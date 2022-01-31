package com.tencent.mm.sandbox.monitor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class ExceptionMonitorService
  extends Service
{
  public static long dXA = 0L;
  public static int ubJ = 0;
  private static ExceptionMonitorService ubN = null;
  private long ubK = 300000L;
  private ah ubL = new ah();
  private Runnable ubM = new ExceptionMonitorService.1(this);
  private long ubO;
  
  private void e(Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      this.ubL.removeCallbacks(this.ubM);
      this.ubL.postDelayed(this.ubM, this.ubK);
      String str3 = paramIntent.getAction();
      y.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand action:" + str3);
      try
      {
        String str2 = paramIntent.getStringExtra("tag");
        String str1 = str2;
        if (str2 == null) {
          str1 = "exception";
        }
        int i = paramIntent.getIntExtra("exceptionPid", 0);
        str1.equals("exception");
        ubJ = i;
        dXA = paramIntent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
        str2 = paramIntent.getStringExtra("exceptionMsg");
        String str4 = paramIntent.getStringExtra("userName");
        boolean bool = paramIntent.getBooleanExtra("exceptionWriteSdcard", true);
        y.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand. action=" + str3 + " pid:" + i + " tag=" + str1 + ", userName=" + str4 + ", message" + str2);
        if (!bk.bl(str2))
        {
          if (a.a(str4, str1, new b.a(str4, str1, bk.UX(), str2, bool)) == 0) {
            fm(this);
          }
          if (System.currentTimeMillis() - this.ubO > 600000L)
          {
            this.ubO = System.currentTimeMillis();
            e.post(new Runnable()
            {
              public final void run() {}
            }, "RecoveryWriteLogThread");
            return;
          }
        }
      }
      catch (Exception paramIntent)
      {
        y.printErrStackTrace("MicroMsg.CrashMonitorService", paramIntent, "", new Object[0]);
      }
    }
  }
  
  public static void fm(Context paramContext)
  {
    Object localObject = new Intent(paramContext, CrashUploadAlarmReceiver.class);
    if (PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject, 536870912) == null)
    {
      localObject = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject, 0);
      paramContext = (AlarmManager)paramContext.getSystemService("alarm");
      long l = bk.UY() + 1800000L;
      paramContext.set(0, l, (PendingIntent)localObject);
      y.d("MicroMsg.CrashMonitorService", "dkcrash startAlarmMgr pendingIntent:%d %d", new Object[] { Integer.valueOf(((PendingIntent)localObject).hashCode()), Long.valueOf(l) });
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    ubN = this;
    c.j(hashCode(), this);
    this.ubL.postDelayed(this.ubM, this.ubK);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ubN = null;
    c.k(hashCode(), this);
    this.ubL.removeCallbacks(this.ubM);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    e(paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    e(paramIntent);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ExceptionMonitorService
 * JD-Core Version:    0.7.0.1
 */