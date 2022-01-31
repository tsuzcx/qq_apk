package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class VideoActivity
  extends Activity
{
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    be.a(this).a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.getWindow().setFormat(-3);
    paramBundle = super.getIntent();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getBundleExtra("extraData");; paramBundle = null)
    {
      if (paramBundle != null)
      {
        paramBundle.putInt("callMode", 1);
        be.a(super.getApplicationContext()).a(null, paramBundle, null);
      }
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    be.a(this).a(this, 4);
  }
  
  protected void onPause()
  {
    super.onPause();
    be.a(this).a(this, 3);
  }
  
  protected void onResume()
  {
    super.onResume();
    be.a(this).a(this, 2);
  }
  
  protected void onStop()
  {
    super.onStop();
    be.a(this).a(this, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.VideoActivity
 * JD-Core Version:    0.7.0.1
 */