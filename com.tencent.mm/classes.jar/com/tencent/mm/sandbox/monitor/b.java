package com.tencent.mm.sandbox.monitor;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class b
{
  private static a URC;
  public static int URD;
  private static MMHandler URF;
  private static Runnable URG;
  private static boolean URH;
  public static long kje;
  private long URE;
  private long URI;
  
  static
  {
    AppMethodBeat.i(270214);
    URC = null;
    URD = 0;
    kje = 0L;
    URF = new MMHandler();
    URG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32594);
        Log.d("MicroMsg.ExceptionMonitor", "stopSelf");
        if (b.hrW() != null) {
          b.hrW().stopSelf();
        }
        AppMethodBeat.o(32594);
      }
    };
    URH = false;
    AppMethodBeat.o(270214);
  }
  
  public b()
  {
    AppMethodBeat.i(32596);
    this.URE = 300000L;
    AppMethodBeat.o(32596);
  }
  
  public static boolean hrV()
  {
    AppMethodBeat.i(270213);
    Log.i("MicroMsg.ExceptionMonitor", "isCrashWorking process:" + MMApplicationContext.getProcessName());
    if (MMApplicationContext.isSandBoxProcess())
    {
      Log.i("MicroMsg.ExceptionMonitor", "isCrashWorking :" + URH);
      boolean bool = URH;
      AppMethodBeat.o(270213);
      return bool;
    }
    AppMethodBeat.o(270213);
    return false;
  }
  
  public static void kw(Context paramContext)
  {
    AppMethodBeat.i(32600);
    Intent localIntent = new Intent(paramContext, CrashUploadAlarmReceiver.class);
    PendingIntent localPendingIntent = com.tencent.mm.a.a.b(paramContext, 108, localIntent);
    if (localPendingIntent == null)
    {
      long l = Util.nowMilliSecond() + 1800000L;
      com.tencent.mm.a.a.set(paramContext, 108, 0, l, localIntent, 0);
      Log.i("MicroMsg.ExceptionMonitor", "dkcrash startAlarmMgr pendingIntent:%d %d", new Object[] { Integer.valueOf(localPendingIntent.hashCode()), Long.valueOf(l) });
    }
    AppMethodBeat.o(32600);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(32597);
    URC = parama;
    c.u(hashCode(), this);
    URF.removeCallbacks(URG);
    URF.postDelayed(URG, this.URE);
    URH = true;
    Log.i("MicroMsg.ExceptionMonitor", "onCreate");
    AppMethodBeat.o(32597);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32598);
    c.v(hashCode(), this);
    URF.removeCallbacks(URG);
    URH = false;
    URC = null;
    Log.i("MicroMsg.ExceptionMonitor", "onDestroy");
    AppMethodBeat.o(32598);
  }
  
  public final void q(Intent paramIntent)
  {
    AppMethodBeat.i(32599);
    Log.i("MicroMsg.ExceptionMonitor", "handleCommand()");
    if (paramIntent == null)
    {
      AppMethodBeat.o(32599);
      return;
    }
    URF.removeCallbacks(URG);
    URF.postDelayed(URG, this.URE);
    URH = true;
    Log.i("MicroMsg.ExceptionMonitor", "handleCommand");
    String str3 = paramIntent.getAction();
    Log.d("MicroMsg.ExceptionMonitor", "dkcrash handleCommand action:".concat(String.valueOf(str3)));
    String str1;
    String str4;
    String str5;
    String str6;
    boolean bool;
    for (;;)
    {
      String str2;
      try
      {
        str2 = paramIntent.getStringExtra("tag");
        str1 = str2;
        if (str2 == null) {
          str1 = "exception";
        }
        str2 = paramIntent.getStringExtra("exceptionProcess");
        if (Util.isEqual(str2, "mm"))
        {
          h.IzE.idkeyStat(1185L, 11L, 1L, true);
          int i = paramIntent.getIntExtra("exceptionPid", 0);
          str1.equals("exception");
          URD = i;
          kje = paramIntent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
          str4 = paramIntent.getStringExtra("exceptionMsg");
          str5 = paramIntent.getStringExtra("userName");
          str6 = paramIntent.getStringExtra("exceptionPreventPath");
          bool = paramIntent.getBooleanExtra("exceptionWriteSdcard", true);
          Log.d("MicroMsg.ExceptionMonitor", "dkcrash handleCommand. action=" + str3 + " pid:" + i + " tag=" + str1 + ", userName=" + str5 + ", crashPreventPath=" + Util.nullAs(str6, "null") + ", message" + str4);
          Log.i("MicroMsg.ExceptionMonitor", "processName:%s crashPreventPath:%s", new Object[] { str2, str6 });
          if (!Util.isNullOrNil(str4)) {
            break;
          }
          AppMethodBeat.o(32599);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        Log.printErrStackTrace("MicroMsg.ExceptionMonitor", paramIntent, "", new Object[0]);
        AppMethodBeat.o(32599);
        return;
      }
      if (Util.isEqual(str2, "push")) {
        h.IzE.idkeyStat(1185L, 12L, 1L, true);
      } else if (Util.isEqual(str2, "other")) {
        h.IzE.idkeyStat(1185L, 13L, 1L, true);
      }
    }
    if (a.a(str5, str1, new ErrLog.Error(str5, str1, Util.nowSecond(), str4, bool), str6, false) == 0) {
      kw(MMApplicationContext.getContext());
    }
    if (System.currentTimeMillis() - this.URI > 600000L)
    {
      this.URI = System.currentTimeMillis();
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(32595);
          com.tencent.mm.modelrecovery.b.bnW();
          AppMethodBeat.o(32595);
        }
      }, "RecoveryWriteLogThread");
    }
    AppMethodBeat.o(32599);
  }
  
  public static abstract interface a
  {
    public abstract void stopSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.b
 * JD-Core Version:    0.7.0.1
 */