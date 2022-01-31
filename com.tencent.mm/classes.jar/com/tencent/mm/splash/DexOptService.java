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
  private HandlerThread mHandlerThread;
  private Handler yve;
  private volatile boolean yvf;
  private Handler yvg;
  private volatile Throwable yvh;
  
  public DexOptService()
  {
    AppMethodBeat.i(114815);
    this.mHandlerThread = new HandlerThread("DexOpt-Thread");
    this.yvf = false;
    this.yvg = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(114813);
        h.c("WxSplash.DexOptService", "dexopt process quit.", new Object[0]);
        DexOptService.this.stopSelf();
        AppMethodBeat.o(114813);
      }
    };
    AppMethodBeat.o(114815);
  }
  
  private boolean dvr()
  {
    AppMethodBeat.i(114817);
    h.c("WxSplash.DexOptService", "doDexOpt start", new Object[0]);
    try
    {
      bool = h.yvo.be(getApplicationContext());
      h.c("WxSplash.DexOptService", "schedule to quit", new Object[0]);
      this.yvg.removeCallbacksAndMessages(null);
      this.yvg.sendEmptyMessageDelayed(0, 120000L);
      h.c("WxSplash.DexOptService", "doDexOpt done, result %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114817);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.yvh = localThrowable;
        boolean bool = false;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(114819);
    h.c("WxSplash.DexOptService", "onBind", new Object[0]);
    AppMethodBeat.o(114819);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(114816);
    h.c("WxSplash.DexOptService", "onCreate", new Object[0]);
    super.onCreate();
    this.mHandlerThread.start();
    this.yve = new Handler(this.mHandlerThread.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(114814);
        if (DexOptService.a(DexOptService.this))
        {
          h.c("WxSplash.DexOptService", "dex opt progressing.", new Object[0]);
          AppMethodBeat.o(114814);
          return;
        }
        DexOptService.a(DexOptService.this, true);
        if (DexOptService.b(DexOptService.this)) {
          DexOptService.access$200();
        }
        for (;;)
        {
          DexOptService.aLP();
          DexOptService.a(DexOptService.this, false);
          AppMethodBeat.o(114814);
          return;
          DexOptService.access$300();
          DexOptService.c(DexOptService.this);
        }
      }
    };
    AppMethodBeat.o(114816);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114820);
    h.c("WxSplash.DexOptService", "onDestroy", new Object[0]);
    super.onDestroy();
    AppMethodBeat.o(114820);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114818);
    this.yve.sendEmptyMessage(0);
    h.c("WxSplash.DexOptService", "onStartCommand", new Object[0]);
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(114818);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.DexOptService
 * JD-Core Version:    0.7.0.1
 */