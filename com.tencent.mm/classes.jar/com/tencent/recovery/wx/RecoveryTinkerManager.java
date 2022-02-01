package com.tencent.recovery.wx;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.tencent.recovery.log.RecoveryLog;
import java.util.Iterator;
import java.util.List;

public class RecoveryTinkerManager
{
  private static final int MIN_SDKVER_TO_USE_JOBSCHEDULER = 26;
  public static final int OTHER_ERROR = -1;
  public static final int PATCH_SERVICE_RUNNING = -2;
  private static final String TAG = "Recovery.RecoveryTinkerManager";
  public static final String TINKER_PATCH_INTENT_SERVICE = "com.tencent.tinker.lib.service.IntentServiceRunner";
  public static final String TINKER_PATCH_JOB_SERVICE = "com.tencent.tinker.lib.service.JobServiceRunner";
  
  private static String getExpectedServiceRunnerClassName()
  {
    if (Build.VERSION.SDK_INT < 26) {
      return "com.tencent.tinker.lib.service.IntentServiceRunner";
    }
    return "com.tencent.tinker.lib.service.JobServiceRunner";
  }
  
  private static String getServiceProcessName(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = new ComponentName(paramContext, getExpectedServiceRunnerClassName());
    try
    {
      paramContext = localPackageManager.getServiceInfo(paramContext, 0);
      return paramContext.processName;
    }
    finally {}
    return null;
  }
  
  private static boolean isProcessRunning(Context paramContext, String paramString)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.processName != null)
        {
          boolean bool = localRunningAppProcessInfo.processName.equals(paramString);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private static int startPatchByIntentService(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(paramContext, "com.tencent.tinker.lib.service.IntentServiceRunner");
      localIntent.putExtra("patch_path_extra", paramString);
      localIntent.putExtra("patch_result_class", "com.tencent.mm.modelrecovery.RecoveryTinkerResultService");
      paramContext.startService(localIntent);
      return 0;
    }
    finally
    {
      RecoveryLog.e("Recovery.RecoveryTinkerManager", "start patch service fail, exception:".concat(String.valueOf(paramContext)), new Object[0]);
    }
    return -1;
  }
  
  private static int startPatchByJobScheduler(Context paramContext, String paramString)
  {
    try
    {
      JobInfo.Builder localBuilder = new JobInfo.Builder(-252579085, new ComponentName(paramContext, "com.tencent.tinker.lib.service.JobServiceRunner"));
      PersistableBundle localPersistableBundle = new PersistableBundle();
      localPersistableBundle.putString("patch_path_extra", paramString);
      localPersistableBundle.putString("patch_result_class", "com.tencent.mm.modelrecovery.RecoveryTinkerResultService");
      localBuilder.setExtras(localPersistableBundle);
      localBuilder.setOverrideDeadline(5L);
      paramContext = (JobScheduler)paramContext.getSystemService("jobscheduler");
      if (paramContext != null)
      {
        if (paramContext.schedule(localBuilder.build()) == 1) {
          return 0;
        }
        RecoveryLog.e("Recovery.RecoveryTinkerManager", "fail to schedule job.", new Object[0]);
        return -1;
      }
      RecoveryLog.e("Recovery.RecoveryTinkerManager", "fail to get job scheduler service.", new Object[0]);
      return -1;
    }
    finally
    {
      RecoveryLog.e("Recovery.RecoveryTinkerManager", "start patch service fail, exception:".concat(String.valueOf(paramContext)), new Object[0]);
    }
    return -1;
  }
  
  public static int startToPatch(Context paramContext, String paramString)
  {
    if (isProcessRunning(paramContext, getServiceProcessName(paramContext))) {
      return -2;
    }
    if (Build.VERSION.SDK_INT < 26) {
      return startPatchByIntentService(paramContext, paramString);
    }
    return startPatchByJobScheduler(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.recovery.wx.RecoveryTinkerManager
 * JD-Core Version:    0.7.0.1
 */