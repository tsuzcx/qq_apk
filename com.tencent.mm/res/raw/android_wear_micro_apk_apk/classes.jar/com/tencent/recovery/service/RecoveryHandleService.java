package com.tencent.recovery.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.recovery.model.RecoveryData;
import java.util.ArrayList;

public class RecoveryHandleService
  extends IntentService
{
  private static volatile boolean anj;
  
  public RecoveryHandleService()
  {
    super(RecoveryHandleService.class.getName());
  }
  
  public void onCreate()
  {
    com.tencent.recovery.a.d.c("Recovery.RecoveryHandleService", "onCreate", new Object[0]);
    super.onCreate();
  }
  
  public void onDestroy()
  {
    com.tencent.recovery.a.d.c("Recovery.RecoveryHandleService", "onDestroy", new Object[0]);
    com.tencent.recovery.a.d.oy();
    super.onDestroy();
  }
  
  protected final void onHandleIntent(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("KeyIsRetry", false);
    int i = com.tencent.recovery.e.a.D(this);
    String str = paramIntent.getStringExtra("KeyReportUploadClassName");
    Object localObject2 = paramIntent.getStringExtra("KeyReportHandleClassName");
    RecoveryData localRecoveryData = (RecoveryData)paramIntent.getParcelableExtra("KeyRecoveryData");
    if ((localRecoveryData == null) || (localRecoveryData.processName == null))
    {
      com.tencent.recovery.a.d.c("Recovery.RecoveryHandleService", "recoveryData is null %b %d %s %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), str, localObject2 });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramIntent = new Intent();
    paramIntent.setClassName(this, (String)localObject2);
    paramIntent = PendingIntent.getService(this, 1000002, paramIntent, 536870912);
    if (paramIntent != null) {
      paramIntent.cancel();
    }
    if (anj) {
      com.tencent.recovery.a.d.c("Recovery.RecoveryHandleService", "handle already running", new Object[0]);
    }
    for (;;)
    {
      com.tencent.recovery.a.a(this, localArrayList, str);
      anj = false;
      stopSelf();
      return;
      anj = true;
      com.tencent.recovery.a.d.c("Recovery.RecoveryHandleService", "try to increase recovery process priority", new Object[0]);
      try
      {
        paramIntent = new Notification();
        if (Build.VERSION.SDK_INT < 18) {
          startForeground(-1119860829, paramIntent);
        }
        for (;;)
        {
          com.tencent.recovery.a.d.c("Recovery.RecoveryHandleService", "start to handle %s's exception uuid: %s threadId: %d", new Object[] { localRecoveryData.processName, localRecoveryData.amT, Long.valueOf(Thread.currentThread().getId()) });
          paramIntent = new com.tencent.recovery.model.a();
          try
          {
            localObject1 = new com.tencent.recovery.model.a();
            paramIntent = (Intent)localObject1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Object localObject1;
              long l;
              com.tencent.recovery.a.d.a("Recovery.RecoveryHandleService", localException, "handle", new Object[0]);
            }
          }
          if ((paramIntent.ana) && (!bool))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setClassName(this, (String)localObject2);
            ((Intent)localObject1).putExtra("KeyReportUploadClassName", str);
            ((Intent)localObject1).putExtra("KeyReportHandleClassName", (String)localObject2);
            ((Intent)localObject1).putExtra("KeyRecoveryData", localRecoveryData);
            ((Intent)localObject1).putExtra("KeyIsRetry", true);
            localObject2 = PendingIntent.getService(this, 1000002, (Intent)localObject1, 536870912);
            if (localObject2 != null) {
              ((PendingIntent)localObject2).cancel();
            }
            localObject2 = com.tencent.recovery.b.d.B(this);
            localObject1 = PendingIntent.getService(this, 1000002, (Intent)localObject1, 0);
            l = System.currentTimeMillis() + ((com.tencent.recovery.b.a)localObject2).oD() - 2000L;
            ((AlarmManager)getSystemService("alarm")).set(0, l, (PendingIntent)localObject1);
            com.tencent.recovery.a.d.c("Recovery.RecoveryHandleService", "startAlarm pendingIntent success: %d will retry %s", new Object[] { Integer.valueOf(((PendingIntent)localObject1).hashCode()), com.tencent.recovery.e.a.n(l) });
          }
          com.tencent.recovery.a.d.c("Recovery.RecoveryHandleService", "handle recoveryHandleResult %s", new Object[] { paramIntent });
          break;
          startForeground(-1119860829, paramIntent);
          startService(new Intent(this, RecoveryHandleService.InnerService.class));
        }
      }
      catch (Throwable paramIntent)
      {
        for (;;)
        {
          com.tencent.recovery.a.d.c("Recovery.RecoveryHandleService", "try to increase recovery process priority error:".concat(String.valueOf(paramIntent)), new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.service.RecoveryHandleService
 * JD-Core Version:    0.7.0.1
 */