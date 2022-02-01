package com.tencent.mm.splash;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DexOptService
  extends Service
{
  private Handler Fbh;
  private volatile boolean Fbi;
  private Handler Fbj;
  private volatile Throwable Fbk;
  private HandlerThread mHandlerThread;
  
  public DexOptService()
  {
    AppMethodBeat.i(40608);
    this.mHandlerThread = new HandlerThread("DexOpt-Thread");
    this.Fbi = false;
    this.Fbj = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(40606);
        h.b("WxSplash.DexOptService", "dexopt process quit.", new Object[0]);
        DexOptService.this.stopSelf();
        AppMethodBeat.o(40606);
      }
    };
    AppMethodBeat.o(40608);
  }
  
  private boolean eIh()
  {
    AppMethodBeat.i(40610);
    h.b("WxSplash.DexOptService", "doDexOpt start", new Object[0]);
    try
    {
      bool = h.Fbq.bs(getApplicationContext());
      h.b("WxSplash.DexOptService", "schedule to quit", new Object[0]);
      this.Fbj.removeCallbacksAndMessages(null);
      this.Fbj.sendEmptyMessageDelayed(0, 120000L);
      h.b("WxSplash.DexOptService", "doDexOpt done, result %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(40610);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.Fbk = localThrowable;
        boolean bool = false;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(40612);
    h.b("WxSplash.DexOptService", "onBind", new Object[0]);
    AppMethodBeat.o(40612);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(40609);
    h.b("WxSplash.DexOptService", "onCreate", new Object[0]);
    super.onCreate();
    this.mHandlerThread.start();
    this.Fbh = new Handler(this.mHandlerThread.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(40607);
        if (DexOptService.a(DexOptService.this))
        {
          h.b("WxSplash.DexOptService", "dex opt progressing.", new Object[0]);
          AppMethodBeat.o(40607);
          return;
        }
        DexOptService.a(DexOptService.this, true);
        if (DexOptService.b(DexOptService.this)) {
          DexOptService.access$200();
        }
        for (;;)
        {
          DexOptService.Kr();
          DexOptService.a(DexOptService.this, false);
          AppMethodBeat.o(40607);
          return;
          DexOptService.access$300();
          DexOptService.c(DexOptService.this);
        }
      }
    };
    AppMethodBeat.o(40609);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(40613);
    h.b("WxSplash.DexOptService", "onDestroy", new Object[0]);
    super.onDestroy();
    AppMethodBeat.o(40613);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40611);
    this.Fbh.sendEmptyMessage(0);
    h.b("WxSplash.DexOptService", "onStartCommand", new Object[0]);
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(40611);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.DexOptService
 * JD-Core Version:    0.7.0.1
 */