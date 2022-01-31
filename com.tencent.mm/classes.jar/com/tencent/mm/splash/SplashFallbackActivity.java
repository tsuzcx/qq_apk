package com.tencent.mm.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

public class SplashFallbackActivity
  extends Activity
{
  private Handler mHandler;
  private Runnable umc = new Runnable()
  {
    private long umd = -1L;
    
    public final void run()
    {
      if (this.umd == -1L) {
        this.umd = System.currentTimeMillis();
      }
      if (!SplashFallbackActivity.ctk())
      {
        if (System.currentTimeMillis() - this.umd >= 80000L)
        {
          i.c("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone timeout", new Object[0]);
          SplashFallbackActivity.this.finish();
          SplashFallbackActivity.this.overridePendingTransition(h.a.splash_no_anim, h.a.splash_faded_out);
          return;
        }
        SplashFallbackActivity.b(SplashFallbackActivity.this).postDelayed(SplashFallbackActivity.a(SplashFallbackActivity.this), 100L);
        return;
      }
      i.c("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone true", new Object[0]);
      SplashFallbackActivity.this.finish();
      SplashFallbackActivity.this.overridePendingTransition(h.a.splash_no_anim, h.a.splash_faded_out);
    }
  };
  
  public void onBackPressed()
  {
    i.c("MicroMsg.FallbackSplash", "block onBackPressed", new Object[0]);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i.c("MicroMsg.FallbackSplash", "onCreate", new Object[0]);
    paramBundle = new HandlerThread("splash-activity");
    paramBundle.start();
    this.mHandler = new Handler(paramBundle.getLooper());
    this.mHandler.postDelayed(this.umc, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.SplashFallbackActivity
 * JD-Core Version:    0.7.0.1
 */