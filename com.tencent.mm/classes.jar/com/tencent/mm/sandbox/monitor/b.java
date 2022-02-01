package com.tencent.mm.sandbox.monitor;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
{
  private static a GkO = null;
  public static int GkP = 0;
  public static long gLX = 0L;
  private long GkQ;
  private ao GkR;
  private Runnable GkS;
  private long GkT;
  
  public b()
  {
    AppMethodBeat.i(32596);
    this.GkQ = 300000L;
    this.GkR = new ao();
    this.GkS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32594);
        ac.d("MicroMsg.ExceptionMonitor", "stopSelf");
        if (b.eSQ() != null) {
          b.eSQ().stopSelf();
        }
        AppMethodBeat.o(32594);
      }
    };
    AppMethodBeat.o(32596);
  }
  
  public static void ij(Context paramContext)
  {
    AppMethodBeat.i(32600);
    Intent localIntent = new Intent(paramContext, CrashUploadAlarmReceiver.class);
    PendingIntent localPendingIntent = com.tencent.mm.a.a.b(paramContext, 108, localIntent);
    if (localPendingIntent == null)
    {
      long l = bs.eWj() + 1800000L;
      com.tencent.mm.a.a.set(paramContext, 108, 0, l, localIntent, 0);
      ac.i("MicroMsg.ExceptionMonitor", "dkcrash startAlarmMgr pendingIntent:%d %d", new Object[] { Integer.valueOf(localPendingIntent.hashCode()), Long.valueOf(l) });
    }
    AppMethodBeat.o(32600);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(32597);
    GkO = parama;
    c.o(hashCode(), this);
    this.GkR.postDelayed(this.GkS, this.GkQ);
    AppMethodBeat.o(32597);
  }
  
  public final void o(Intent paramIntent)
  {
    AppMethodBeat.i(32599);
    ac.i("MicroMsg.ExceptionMonitor", "handleCommand()");
    if (paramIntent == null)
    {
      AppMethodBeat.o(32599);
      return;
    }
    this.GkR.removeCallbacks(this.GkS);
    this.GkR.postDelayed(this.GkS, this.GkQ);
    String str3 = paramIntent.getAction();
    ac.d("MicroMsg.ExceptionMonitor", "dkcrash handleCommand action:".concat(String.valueOf(str3)));
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
        if (bs.lr(str2, "mm"))
        {
          h.wUl.idkeyStat(1185L, 11L, 1L, true);
          int i = paramIntent.getIntExtra("exceptionPid", 0);
          str1.equals("exception");
          GkP = i;
          gLX = paramIntent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
          str4 = paramIntent.getStringExtra("exceptionMsg");
          str5 = paramIntent.getStringExtra("userName");
          str6 = paramIntent.getStringExtra("exceptionPreventPath");
          bool = paramIntent.getBooleanExtra("exceptionWriteSdcard", true);
          ac.d("MicroMsg.ExceptionMonitor", "dkcrash handleCommand. action=" + str3 + " pid:" + i + " tag=" + str1 + ", userName=" + str5 + ", crashPreventPath=" + bs.bG(str6, "null") + ", message" + str4);
          ac.i("MicroMsg.ExceptionMonitor", "processName:%s crashPreventPath:%s", new Object[] { str2, str6 });
          if (!bs.isNullOrNil(str4)) {
            break;
          }
          AppMethodBeat.o(32599);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        ac.printErrStackTrace("MicroMsg.ExceptionMonitor", paramIntent, "", new Object[0]);
        AppMethodBeat.o(32599);
        return;
      }
      if (bs.lr(str2, "push")) {
        h.wUl.idkeyStat(1185L, 12L, 1L, true);
      } else if (bs.lr(str2, "other")) {
        h.wUl.idkeyStat(1185L, 13L, 1L, true);
      }
    }
    if (a.a(str5, str1, new ErrLog.Error(str5, str1, bs.aNx(), str4, bool), str6, false) == 0) {
      ij(ai.getContext());
    }
    if (System.currentTimeMillis() - this.GkT > 600000L)
    {
      this.GkT = System.currentTimeMillis();
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(32595);
          com.tencent.mm.modelrecovery.b.aGQ();
          AppMethodBeat.o(32595);
        }
      }, "RecoveryWriteLogThread");
    }
    AppMethodBeat.o(32599);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32598);
    c.p(hashCode(), this);
    this.GkR.removeCallbacks(this.GkS);
    GkO = null;
    AppMethodBeat.o(32598);
  }
  
  public static abstract interface a
  {
    public abstract void stopSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.b
 * JD-Core Version:    0.7.0.1
 */