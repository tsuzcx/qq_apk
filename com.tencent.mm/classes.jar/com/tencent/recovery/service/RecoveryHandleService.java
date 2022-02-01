package com.tencent.recovery.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.model.RecoveryHandleResult;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.util.Util;
import java.util.ArrayList;

public class RecoveryHandleService
  extends IntentService
{
  private static final String TAG = "Recovery.RecoveryHandleService";
  private static final int notificationId = -1119860829;
  private static volatile boolean running;
  
  public RecoveryHandleService()
  {
    super(RecoveryHandleService.class.getName());
  }
  
  private void cancelAlarm(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(this, paramString);
    paramString = PendingIntent.getService(this, 1000002, localIntent, 536870912);
    if (paramString != null) {
      paramString.cancel();
    }
  }
  
  private void increasingPriority()
  {
    RecoveryLog.i("Recovery.RecoveryHandleService", "try to increase recovery process priority", new Object[0]);
    try
    {
      Notification localNotification = new Notification();
      if (Build.VERSION.SDK_INT < 18)
      {
        startForeground(-1119860829, localNotification);
        return;
      }
      startForeground(-1119860829, localNotification);
      startService(new Intent(this, InnerService.class));
      return;
    }
    catch (Throwable localThrowable)
    {
      RecoveryLog.i("Recovery.RecoveryHandleService", "try to increase recovery process priority error:".concat(String.valueOf(localThrowable)), new Object[0]);
    }
  }
  
  private boolean isRetry(Intent paramIntent)
  {
    return paramIntent.getBooleanExtra("KeyIsRetry", false);
  }
  
  private void retry(String paramString1, String paramString2, RecoveryData paramRecoveryData)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(this, paramString2);
    localIntent.putExtra("KeyReportUploadClassName", paramString1);
    localIntent.putExtra("KeyReportHandleClassName", paramString2);
    localIntent.putExtra("KeyRecoveryData", paramRecoveryData);
    localIntent.putExtra("KeyIsRetry", true);
    paramString1 = PendingIntent.getService(this, 1000002, localIntent, 536870912);
    if (paramString1 != null) {
      paramString1.cancel();
    }
    paramString1 = OptionFactory.getCommonOptions(this);
    paramString2 = PendingIntent.getService(this, 1000002, localIntent, 0);
    long l = System.currentTimeMillis();
    l = paramString1.getHandleRetryInterval() + l - 2000L;
    ((AlarmManager)getSystemService("alarm")).set(0, l, paramString2);
    RecoveryLog.i("Recovery.RecoveryHandleService", "startAlarm pendingIntent success: %d will retry %s", new Object[] { Integer.valueOf(paramString2.hashCode()), Util.getTimeFormat(l) });
  }
  
  protected void alreadyRunning(Context paramContext, RecoveryData paramRecoveryData, ArrayList<RecoveryHandleItem> paramArrayList, int paramInt, boolean paramBoolean) {}
  
  protected RecoveryHandleResult handleException(Context paramContext, RecoveryData paramRecoveryData, ArrayList<RecoveryHandleItem> paramArrayList, int paramInt, boolean paramBoolean)
  {
    return new RecoveryHandleResult();
  }
  
  public void onCreate()
  {
    RecoveryLog.i("Recovery.RecoveryHandleService", "onCreate", new Object[0]);
    super.onCreate();
  }
  
  public void onDestroy()
  {
    RecoveryLog.i("Recovery.RecoveryHandleService", "onDestroy", new Object[0]);
    RecoveryLog.appendLog();
    super.onDestroy();
  }
  
  protected final void onHandleIntent(Intent paramIntent)
  {
    boolean bool = isRetry(paramIntent);
    int i = Util.getUUID(this);
    String str1 = paramIntent.getStringExtra("KeyReportUploadClassName");
    String str2 = paramIntent.getStringExtra("KeyReportHandleClassName");
    RecoveryData localRecoveryData = (RecoveryData)paramIntent.getParcelableExtra("KeyRecoveryData");
    if ((localRecoveryData == null) || (localRecoveryData.processName == null))
    {
      RecoveryLog.i("Recovery.RecoveryHandleService", "recoveryData is null %b %d %s %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), str1, str2 });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    cancelAlarm(str2);
    if (running) {
      RecoveryLog.i("Recovery.RecoveryHandleService", "handle already running", new Object[0]);
    }
    for (;;)
    {
      try
      {
        alreadyRunning(this, localRecoveryData, localArrayList, i, bool);
        RecoveryLogic.startReportService(this, localArrayList, str1);
        running = false;
        stopSelf();
        return;
      }
      catch (Exception paramIntent)
      {
        RecoveryLog.printErrStackTrace("Recovery.RecoveryHandleService", paramIntent, "alreadyRunning", new Object[0]);
        continue;
      }
      running = true;
      increasingPriority();
      RecoveryLog.i("Recovery.RecoveryHandleService", "start to handle %s's exception uuid: %s threadId: %d", new Object[] { localRecoveryData.processName, localRecoveryData.uuid, Long.valueOf(Thread.currentThread().getId()) });
      paramIntent = new RecoveryHandleResult();
      try
      {
        RecoveryHandleResult localRecoveryHandleResult = handleException(this, localRecoveryData, localArrayList, i, bool);
        paramIntent = localRecoveryHandleResult;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          RecoveryLog.printErrStackTrace("Recovery.RecoveryHandleService", localException, "handle", new Object[0]);
        }
      }
      if ((paramIntent.retry) && (!bool)) {
        retry(str1, str2, localRecoveryData);
      }
      RecoveryLog.i("Recovery.RecoveryHandleService", "handle recoveryHandleResult %s", new Object[] { paramIntent });
    }
  }
  
  public static class InnerService
    extends Service
  {
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      super.onCreate();
      try
      {
        startForeground(-1119860829, new Notification());
        stopSelf();
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          RecoveryLog.e("Recovery.RecoveryHandleService", "InnerService set service for push exception:%s.", new Object[] { localThrowable });
        }
      }
    }
    
    public void onDestroy()
    {
      stopForeground(true);
      super.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.recovery.service.RecoveryHandleService
 * JD-Core Version:    0.7.0.1
 */