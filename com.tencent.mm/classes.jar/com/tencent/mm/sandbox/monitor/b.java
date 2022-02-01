package com.tencent.mm.sandbox.monitor;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
{
  private static a IqI = null;
  public static int IqJ = 0;
  public static long hiI = 0L;
  private long IqK;
  private aq IqL;
  private Runnable IqM;
  private long IqN;
  
  public b()
  {
    AppMethodBeat.i(32596);
    this.IqK = 300000L;
    this.IqL = new aq();
    this.IqM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32594);
        ae.d("MicroMsg.ExceptionMonitor", "stopSelf");
        if (b.fmk() != null) {
          b.fmk().stopSelf();
        }
        AppMethodBeat.o(32594);
      }
    };
    AppMethodBeat.o(32596);
  }
  
  public static void iy(Context paramContext)
  {
    AppMethodBeat.i(32600);
    Intent localIntent = new Intent(paramContext, CrashUploadAlarmReceiver.class);
    PendingIntent localPendingIntent = com.tencent.mm.a.a.b(paramContext, 108, localIntent);
    if (localPendingIntent == null)
    {
      long l = bu.fpO() + 1800000L;
      com.tencent.mm.a.a.set(paramContext, 108, 0, l, localIntent, 0);
      ae.i("MicroMsg.ExceptionMonitor", "dkcrash startAlarmMgr pendingIntent:%d %d", new Object[] { Integer.valueOf(localPendingIntent.hashCode()), Long.valueOf(l) });
    }
    AppMethodBeat.o(32600);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(32597);
    IqI = parama;
    c.n(hashCode(), this);
    this.IqL.postDelayed(this.IqM, this.IqK);
    AppMethodBeat.o(32597);
  }
  
  public final void o(Intent paramIntent)
  {
    AppMethodBeat.i(32599);
    ae.i("MicroMsg.ExceptionMonitor", "handleCommand()");
    if (paramIntent == null)
    {
      AppMethodBeat.o(32599);
      return;
    }
    this.IqL.removeCallbacks(this.IqM);
    this.IqL.postDelayed(this.IqM, this.IqK);
    String str3 = paramIntent.getAction();
    ae.d("MicroMsg.ExceptionMonitor", "dkcrash handleCommand action:".concat(String.valueOf(str3)));
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
        if (bu.lX(str2, "mm"))
        {
          g.yxI.idkeyStat(1185L, 11L, 1L, true);
          int i = paramIntent.getIntExtra("exceptionPid", 0);
          str1.equals("exception");
          IqJ = i;
          hiI = paramIntent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
          str4 = paramIntent.getStringExtra("exceptionMsg");
          str5 = paramIntent.getStringExtra("userName");
          str6 = paramIntent.getStringExtra("exceptionPreventPath");
          bool = paramIntent.getBooleanExtra("exceptionWriteSdcard", true);
          ae.d("MicroMsg.ExceptionMonitor", "dkcrash handleCommand. action=" + str3 + " pid:" + i + " tag=" + str1 + ", userName=" + str5 + ", crashPreventPath=" + bu.bI(str6, "null") + ", message" + str4);
          ae.i("MicroMsg.ExceptionMonitor", "processName:%s crashPreventPath:%s", new Object[] { str2, str6 });
          if (!bu.isNullOrNil(str4)) {
            break;
          }
          AppMethodBeat.o(32599);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        ae.printErrStackTrace("MicroMsg.ExceptionMonitor", paramIntent, "", new Object[0]);
        AppMethodBeat.o(32599);
        return;
      }
      if (bu.lX(str2, "push")) {
        g.yxI.idkeyStat(1185L, 12L, 1L, true);
      } else if (bu.lX(str2, "other")) {
        g.yxI.idkeyStat(1185L, 13L, 1L, true);
      }
    }
    if (a.a(str5, str1, new ErrLog.Error(str5, str1, bu.aRi(), str4, bool), str6, false) == 0) {
      iy(ak.getContext());
    }
    if (System.currentTimeMillis() - this.IqN > 600000L)
    {
      this.IqN = System.currentTimeMillis();
      com.tencent.mm.sdk.g.b.c(new b.2(this), "RecoveryWriteLogThread");
    }
    AppMethodBeat.o(32599);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32598);
    c.o(hashCode(), this);
    this.IqL.removeCallbacks(this.IqM);
    IqI = null;
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