package com.tencent.mm.splash;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;

public class DexOptService
  extends Service
{
  private HandlerThread mHandlerThread = new HandlerThread("DexOpt-Thread");
  private volatile boolean ulA = false;
  private Handler ulB = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      i.c("WxSplash.DexOptService", "dexopt process quit.", new Object[0]);
      DexOptService.this.stopSelf();
    }
  };
  private volatile Throwable ulC;
  private Handler ulz;
  
  private boolean csT()
  {
    i.c("WxSplash.DexOptService", "doDexOpt start", new Object[0]);
    try
    {
      bool = i.ulJ.aG(getApplicationContext());
      i.c("WxSplash.DexOptService", "schedule to quit", new Object[0]);
      this.ulB.removeCallbacksAndMessages(null);
      this.ulB.sendEmptyMessageDelayed(0, 120000L);
      i.c("WxSplash.DexOptService", "doDexOpt done, result %s", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.ulC = localThrowable;
        boolean bool = false;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    i.c("WxSplash.DexOptService", "onBind", new Object[0]);
    return null;
  }
  
  public void onCreate()
  {
    i.c("WxSplash.DexOptService", "onCreate", new Object[0]);
    super.onCreate();
    this.mHandlerThread.start();
    this.ulz = new Handler(this.mHandlerThread.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        if (DexOptService.a(DexOptService.this))
        {
          i.c("WxSplash.DexOptService", "dex opt progressing.", new Object[0]);
          return;
        }
        DexOptService.a(DexOptService.this, true);
        if (DexOptService.b(DexOptService.this)) {
          DexOptService.tf();
        }
        for (;;)
        {
          DexOptService.aoH();
          DexOptService.a(DexOptService.this, false);
          return;
          DexOptService.IV();
          DexOptService.c(DexOptService.this);
        }
      }
    };
  }
  
  public void onDestroy()
  {
    i.c("WxSplash.DexOptService", "onDestroy", new Object[0]);
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.ulz.sendEmptyMessage(0);
    i.c("WxSplash.DexOptService", "onStartCommand", new Object[0]);
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.DexOptService
 * JD-Core Version:    0.7.0.1
 */