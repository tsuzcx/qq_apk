package com.tencent.recovery.wx;

import android.annotation.TargetApi;
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
  private static boolean bH(Context paramContext, String paramString)
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
  
  public static int bX(Context paramContext, String paramString)
  {
    if (bH(paramContext, iV(paramContext))) {
      return -2;
    }
    if (Build.VERSION.SDK_INT < 26) {
      return bY(paramContext, paramString);
    }
    return bZ(paramContext, paramString);
  }
  
  private static int bY(Context paramContext, String paramString)
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
    catch (Throwable paramContext)
    {
      RecoveryLog.e("Recovery.RecoveryTinkerManager", "start patch service fail, exception:".concat(String.valueOf(paramContext)), new Object[0]);
    }
    return -1;
  }
  
  @TargetApi(21)
  private static int bZ(Context paramContext, String paramString)
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
    catch (Throwable paramContext)
    {
      RecoveryLog.e("Recovery.RecoveryTinkerManager", "start patch service fail, exception:".concat(String.valueOf(paramContext)), new Object[0]);
    }
    return -1;
  }
  
  private static String iV(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (Build.VERSION.SDK_INT < 26) {}
    for (String str = "com.tencent.tinker.lib.service.IntentServiceRunner";; str = "com.tencent.tinker.lib.service.JobServiceRunner")
    {
      paramContext = new ComponentName(paramContext, str);
      try
      {
        paramContext = localPackageManager.getServiceInfo(paramContext, 0);
        return paramContext.processName;
      }
      catch (Throwable paramContext) {}
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.RecoveryTinkerManager
 * JD-Core Version:    0.7.0.1
 */