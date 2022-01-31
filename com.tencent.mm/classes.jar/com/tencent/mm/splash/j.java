package com.tencent.mm.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

final class j
  extends Activity
{
  public String umf;
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 100)
    {
      if (paramInt2 != -100) {
        onBackPressed();
      }
      return;
    }
    finish();
    i.c("WxSplash.SplashHackActivity", "unknown request code.", new Object[0]);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i.c("WxSplash.SplashHackActivity", "onCreate", new Object[0]);
    setVisible(false);
    paramBundle = new Intent(this, i.ctd());
    paramBundle.putExtra("hashcode", hashCode());
    startActivityForResult(paramBundle, 100);
  }
  
  protected final void onDestroy()
  {
    i.c("WxSplash.SplashHackActivity", "onDestroy", new Object[0]);
    i.ulE.remove(this);
    setVisible(true);
    i.ulE.remove(this);
    super.onDestroy();
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    i.c("WxSplash.SplashHackActivity", "onNewIntent.", new Object[0]);
    if ((i.ulI != null) && (i.ulI.d(paramIntent))) {
      finish();
    }
  }
  
  protected final void onPause()
  {
    i.c("WxSplash.SplashHackActivity", "onPause", new Object[0]);
    super.onPause();
  }
  
  protected final void onResume()
  {
    super.onResume();
    i.c("WxSplash.SplashHackActivity", "onResume", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.j
 * JD-Core Version:    0.7.0.1
 */