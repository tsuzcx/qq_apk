package com.tencent.mm.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;

public class SplashActivity
  extends Activity
{
  private boolean uma = false;
  
  private void cth()
  {
    if (i.ulI.b(this, new Runnable()
    {
      public final void run()
      {
        SplashActivity.c(SplashActivity.this);
      }
    })) {
      ctj();
    }
  }
  
  private void ctj()
  {
    if (this.uma) {
      return;
    }
    this.uma = true;
    j localj;
    boolean bool;
    if (!isFinishing())
    {
      setResult(-100);
      int i = getIntent().getIntExtra("hashcode", 0);
      Object localObject = i.ulE.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localj = (j)((Iterator)localObject).next();
        if (i == localj.hashCode())
        {
          localObject = localj.umf;
          if (i.bwZ == null) {
            break label168;
          }
          bool = i.bwZ.cn((String)localObject);
          if (bool) {
            break label173;
          }
          localj.recreate();
          i.c("WxSplash.SplashActivity", "do recreate for %s", new Object[] { localj.umf });
        }
      }
      label123:
      new Handler().postDelayed(new Runnable()
      {
        public final void run()
        {
          SplashActivity.this.finish();
          SplashActivity.d(SplashActivity.this);
        }
      }, 50L);
    }
    for (;;)
    {
      new Handler().postDelayed(new Runnable()
      {
        public final void run()
        {
          i.ulI = null;
        }
      }, 30000L);
      return;
      label168:
      bool = false;
      break;
      label173:
      localj.finish();
      i.c("WxSplash.SplashActivity", "eat activity, %s", new Object[] { localj.umf });
      break label123;
      onBackPressed();
    }
  }
  
  public final void cti()
  {
    if (i.ulI != null)
    {
      if (!i.ulI.a(this, new Runnable()
      {
        public final void run()
        {
          SplashActivity.c(SplashActivity.this);
        }
      })) {
        cth();
      }
      return;
    }
    i.c("WxSplash.SplashActivity", "permissions delegate is null, call splash finish directly.", new Object[0]);
    ctj();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i.a(this);
    i.c("WxSplash.SplashActivity", "onCreate", new Object[0]);
    if (!i.csW())
    {
      i.c("WxSplash.SplashActivity", "no need splash, finish", new Object[0]);
      cti();
    }
    if (i.ulR != null) {
      i.ulR.l(this);
    }
  }
  
  protected void onDestroy()
  {
    i.b(this);
    i.c("WxSplash.SplashActivity", "onDestroy", new Object[0]);
    super.onDestroy();
  }
  
  public void onPause()
  {
    i.c("WxSplash.SplashActivity", "onPause", new Object[0]);
    super.onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (i.ulI != null) {
      i.ulI.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    i.c("WxSplash.SplashActivity", "onResume", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.SplashActivity
 * JD-Core Version:    0.7.0.1
 */