package com.tencent.mm.sandbox.monitor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMService;

public class ExceptionMonitorService
  extends MMService
{
  public static long ePF = 0L;
  public static int yjY = 0;
  private static ExceptionMonitorService ykc = null;
  private long yjZ;
  private ak yka;
  private Runnable ykb;
  private long ykd;
  
  public ExceptionMonitorService()
  {
    AppMethodBeat.i(28789);
    this.yjZ = 300000L;
    this.yka = new ak();
    this.ykb = new ExceptionMonitorService.1(this);
    AppMethodBeat.o(28789);
  }
  
  private void drt()
  {
    AppMethodBeat.i(28795);
    if (System.currentTimeMillis() - this.ykd <= 600000L)
    {
      AppMethodBeat.o(28795);
      return;
    }
    this.ykd = System.currentTimeMillis();
    d.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28788);
        com.tencent.mm.modelrecovery.a.aiR();
        AppMethodBeat.o(28788);
      }
    }, "RecoveryWriteLogThread");
    AppMethodBeat.o(28795);
  }
  
  public static void gz(Context paramContext)
  {
    AppMethodBeat.i(28796);
    Object localObject = new Intent(paramContext, CrashUploadAlarmReceiver.class);
    if (PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject, 536870912) == null)
    {
      localObject = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject, 0);
      paramContext = (AlarmManager)paramContext.getSystemService("alarm");
      long l = bo.aoy() + 1800000L;
      paramContext.set(0, l, (PendingIntent)localObject);
      ab.d("MicroMsg.CrashMonitorService", "dkcrash startAlarmMgr pendingIntent:%d %d", new Object[] { Integer.valueOf(((PendingIntent)localObject).hashCode()), Long.valueOf(l) });
    }
    AppMethodBeat.o(28796);
  }
  
  private void o(Intent paramIntent)
  {
    AppMethodBeat.i(28794);
    if (paramIntent == null)
    {
      AppMethodBeat.o(28794);
      return;
    }
    this.yka.removeCallbacks(this.ykb);
    this.yka.postDelayed(this.ykb, this.yjZ);
    String str3 = paramIntent.getAction();
    ab.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand action:".concat(String.valueOf(str3)));
    String str2;
    String str1;
    String str4;
    boolean bool;
    try
    {
      str2 = paramIntent.getStringExtra("tag");
      str1 = str2;
      if (str2 == null) {
        str1 = "exception";
      }
      int i = paramIntent.getIntExtra("exceptionPid", 0);
      str1.equals("exception");
      yjY = i;
      ePF = paramIntent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
      str2 = paramIntent.getStringExtra("exceptionMsg");
      str4 = paramIntent.getStringExtra("userName");
      bool = paramIntent.getBooleanExtra("exceptionWriteSdcard", true);
      ab.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand. action=" + str3 + " pid:" + i + " tag=" + str1 + ", userName=" + str4 + ", message" + str2);
      if (bo.isNullOrNil(str2))
      {
        AppMethodBeat.o(28794);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      ab.printErrStackTrace("MicroMsg.CrashMonitorService", paramIntent, "", new Object[0]);
      AppMethodBeat.o(28794);
      return;
    }
    if (a.a(str4, str1, new b.a(str4, str1, bo.aox(), str2, bool)) == 0) {
      gz(ah.getContext());
    }
    drt();
    AppMethodBeat.o(28794);
  }
  
  public final IBinder It()
  {
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.CrashMonitorService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(28790);
    super.onCreate();
    ykc = this;
    c.m(hashCode(), this);
    this.yka.postDelayed(this.ykb, this.yjZ);
    AppMethodBeat.o(28790);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(28793);
    super.onDestroy();
    ykc = null;
    c.n(hashCode(), this);
    this.yka.removeCallbacks(this.ykb);
    AppMethodBeat.o(28793);
  }
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(28791);
    super.onStart(paramIntent, paramInt);
    o(paramIntent);
    AppMethodBeat.o(28791);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28792);
    o(paramIntent);
    AppMethodBeat.o(28792);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ExceptionMonitorService
 * JD-Core Version:    0.7.0.1
 */