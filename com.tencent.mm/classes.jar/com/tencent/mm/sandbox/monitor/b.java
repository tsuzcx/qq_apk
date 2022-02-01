package com.tencent.mm.sandbox.monitor;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  private static a HWA = null;
  public static int HWB = 0;
  public static long hfU = 0L;
  private long HWC;
  private ap HWD;
  private Runnable HWE;
  private long HWF;
  
  public b()
  {
    AppMethodBeat.i(32596);
    this.HWC = 300000L;
    this.HWD = new ap();
    this.HWE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32594);
        ad.d("MicroMsg.ExceptionMonitor", "stopSelf");
        if (b.fis() != null) {
          b.fis().stopSelf();
        }
        AppMethodBeat.o(32594);
      }
    };
    AppMethodBeat.o(32596);
  }
  
  public static void it(Context paramContext)
  {
    AppMethodBeat.i(32600);
    Intent localIntent = new Intent(paramContext, CrashUploadAlarmReceiver.class);
    PendingIntent localPendingIntent = com.tencent.mm.a.a.b(paramContext, 108, localIntent);
    if (localPendingIntent == null)
    {
      long l = bt.flT() + 1800000L;
      com.tencent.mm.a.a.set(paramContext, 108, 0, l, localIntent, 0);
      ad.i("MicroMsg.ExceptionMonitor", "dkcrash startAlarmMgr pendingIntent:%d %d", new Object[] { Integer.valueOf(localPendingIntent.hashCode()), Long.valueOf(l) });
    }
    AppMethodBeat.o(32600);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(32597);
    HWA = parama;
    c.n(hashCode(), this);
    this.HWD.postDelayed(this.HWE, this.HWC);
    AppMethodBeat.o(32597);
  }
  
  public final void o(Intent paramIntent)
  {
    AppMethodBeat.i(32599);
    ad.i("MicroMsg.ExceptionMonitor", "handleCommand()");
    if (paramIntent == null)
    {
      AppMethodBeat.o(32599);
      return;
    }
    this.HWD.removeCallbacks(this.HWE);
    this.HWD.postDelayed(this.HWE, this.HWC);
    String str3 = paramIntent.getAction();
    ad.d("MicroMsg.ExceptionMonitor", "dkcrash handleCommand action:".concat(String.valueOf(str3)));
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
        if (bt.lQ(str2, "mm"))
        {
          g.yhR.idkeyStat(1185L, 11L, 1L, true);
          int i = paramIntent.getIntExtra("exceptionPid", 0);
          str1.equals("exception");
          HWB = i;
          hfU = paramIntent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
          str4 = paramIntent.getStringExtra("exceptionMsg");
          str5 = paramIntent.getStringExtra("userName");
          str6 = paramIntent.getStringExtra("exceptionPreventPath");
          bool = paramIntent.getBooleanExtra("exceptionWriteSdcard", true);
          ad.d("MicroMsg.ExceptionMonitor", "dkcrash handleCommand. action=" + str3 + " pid:" + i + " tag=" + str1 + ", userName=" + str5 + ", crashPreventPath=" + bt.bI(str6, "null") + ", message" + str4);
          ad.i("MicroMsg.ExceptionMonitor", "processName:%s crashPreventPath:%s", new Object[] { str2, str6 });
          if (!bt.isNullOrNil(str4)) {
            break;
          }
          AppMethodBeat.o(32599);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        ad.printErrStackTrace("MicroMsg.ExceptionMonitor", paramIntent, "", new Object[0]);
        AppMethodBeat.o(32599);
        return;
      }
      if (bt.lQ(str2, "push")) {
        g.yhR.idkeyStat(1185L, 12L, 1L, true);
      } else if (bt.lQ(str2, "other")) {
        g.yhR.idkeyStat(1185L, 13L, 1L, true);
      }
    }
    if (a.a(str5, str1, new ErrLog.Error(str5, str1, bt.aQJ(), str4, bool), str6, false) == 0) {
      it(aj.getContext());
    }
    if (System.currentTimeMillis() - this.HWF > 600000L)
    {
      this.HWF = System.currentTimeMillis();
      com.tencent.mm.sdk.g.b.c(new b.2(this), "RecoveryWriteLogThread");
    }
    AppMethodBeat.o(32599);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32598);
    c.o(hashCode(), this);
    this.HWD.removeCallbacks(this.HWE);
    HWA = null;
    AppMethodBeat.o(32598);
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