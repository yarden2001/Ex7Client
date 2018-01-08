package com.example.madaim.ex7client;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.test.suitebuilder.annotation.Suppress;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private final int MY_CALL_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View v) {
        switch (v.getId()){
            case R.id.butCall:
                if(checkSelfPermission(Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED) {
                    EditText call = (EditText) findViewById(R.id.edCall);
                    String num = call.getText().toString();
                    phoneNum(num);
                }
                else{
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},MY_CALL_REQUEST);
                }

                break;
            case R.id.butSurf:


                break;
            case R.id.butEmail:


                break;
            case R.id.butReg:


                break;
        }

        Toast.makeText(this, "hello", Toast.LENGTH_LONG).show();
    }

    @SuppressWarnings({"MissingPermission"})
    private void phoneNum(String phoneNum){
        String number = phoneNum;
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" +number));
        startActivity(intent);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case MY_CALL_REQUEST:
                if(grantResults.length>0&&
                        permissions[0].equals(Manifest.permission.CALL_PHONE)&&
                            grantResults[0]==getPackageManager().PERMISSION_GRANTED)


                break;

        }
    }
}