package com.tencent.recovery;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.service.RecoveryHandleService;
import com.tencent.recovery.service.RecoveryReportService;
import com.tencent.recovery.service.RecoveryUploadService;
import com.tencent.recovery.util.Util;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecoveryLogic
{
  private static final String TAG = "Recovery.RecoveryLogic";
  private static String handleServiceProcessName;
  public static int processStartFlag = 17;
  public static Field rProcessStateField = null;
  
  public static int getProcessStartFlag(Context paramContext, String paramString)
  {
    if (processStartFlag != 17) {
      return processStartFlag;
    }
    processStartFlag = 16;
    if (rProcessStateField == null) {}
    try
    {
      rProcessStateField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
      if (rProcessStateField != null) {
        paramContext = (ActivityManager)paramContext.getSystemService("activity");
      }
      for (;;)
      {
        Iterator localIterator2;
        try
        {
          paramContext = paramContext.getRunningAppProcesses();
          if ((paramContext == null) || (paramContext.isEmpty()))
          {
            RecoveryLog.i("Recovery.RecoveryLogic", "can not get running app process", new Object[0]);
            return processStartFlag;
          }
        }
        catch (Exception paramContext)
        {
          paramContext = null;
          continue;
          localIterator2 = paramContext.iterator();
        }
        do
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator2.next();
          } while ((localRunningAppProcessInfo == null) || (localRunningAppProcessInfo.importance != 100) || (localRunningAppProcessInfo.importanceReasonCode != 0));
          try
          {
            int i = rProcessStateField.getInt(localRunningAppProcessInfo);
            localObject1 = Integer.valueOf(i);
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Object localObject1;
              localIterator1 = null;
            }
            paramString = new StringBuffer();
            Iterator localIterator1 = paramContext.iterator();
            while (localIterator1.hasNext())
            {
              localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator1.next();
              if (localRunningAppProcessInfo != null) {
                paramString.append(localRunningAppProcessInfo.processName + ":" + localRunningAppProcessInfo.importance + " ");
              }
            }
            RecoveryLog.i("Recovery.RecoveryLogic", "foregroundInfo is null %s %s", new Object[] { Integer.valueOf(paramContext.size()), paramString.toString() });
          }
        } while ((localObject1 == null) || (((Integer)localObject1).intValue() != 2));
        localObject1 = localRunningAppProcessInfo;
        if (localObject1 != null)
        {
          RecoveryLog.i("Recovery.RecoveryLogic", "%s %s", new Object[] { paramString, ((ActivityManager.RunningAppProcessInfo)localObject1).processName });
          if (!paramString.equals(((ActivityManager.RunningAppProcessInfo)localObject1).processName)) {
            continue;
          }
          processStartFlag = 1;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        Object localObject2 = null;
      }
    }
  }
  
  private static String getRecoveryHandleServiceName(Context paramContext, String paramString)
  {
    if (handleServiceProcessName != null) {
      return handleServiceProcessName;
    }
    paramContext = getServiceProcessName(paramContext, paramString);
    if (paramContext == null) {
      return null;
    }
    handleServiceProcessName = paramContext;
    return paramContext;
  }
  
  private static String getServiceProcessName(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = new ComponentName(paramContext, paramString);
    try
    {
      paramContext = localPackageManager.getServiceInfo(paramContext, 0);
      return paramContext.processName;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static boolean isRecoveryProcess()
  {
    return isRecoveryProcess(Recovery.getContext());
  }
  
  public static boolean isRecoveryProcess(Context paramContext)
  {
    String str = Util.getMyProcessName(paramContext);
    boolean bool = false;
    if (str.equals(paramContext.getPackageName() + ":recovery")) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean startHandleService(Context paramContext, CommonOptions paramCommonOptions, RecoveryContext paramRecoveryContext)
  {
    if (paramCommonOptions.getRecoveryHandleService() == null)
    {
      RecoveryLog.i("Recovery.RecoveryLogic", "startRecoveryProcess not set handle service", new Object[0]);
      return false;
    }
    RecoveryLog.i("Recovery.RecoveryLogic", "startHandleService %s", new Object[] { Util.getMyProcessName(paramContext) });
    String str1;
    if (Util.isNullOrNil(paramCommonOptions.getRecoveryUploadService()))
    {
      str1 = RecoveryUploadService.class.getName();
      if (!Util.isNullOrNil(paramCommonOptions.getRecoveryHandleService())) {
        break label187;
      }
    }
    label187:
    for (String str2 = RecoveryHandleService.class.getName();; str2 = paramCommonOptions.getRecoveryHandleService())
    {
      RecoveryData localRecoveryData = new RecoveryData();
      localRecoveryData.processName = Util.getMyProcessName(paramContext);
      localRecoveryData.uuid = paramCommonOptions.getUUID();
      localRecoveryData.configUrl = paramCommonOptions.getConfigUrl();
      localRecoveryData.exceptionItemList = paramRecoveryContext.exceptionItemList;
      localRecoveryData.clientVersion = paramCommonOptions.getClientVersion();
      paramRecoveryContext = new Intent();
      paramRecoveryContext.setClassName(paramContext, paramCommonOptions.getRecoveryHandleService());
      paramRecoveryContext.putExtra("KeyReportUploadClassName", str1);
      paramRecoveryContext.putExtra("KeyReportHandleClassName", str2);
      paramRecoveryContext.putExtra("KeyRecoveryData", localRecoveryData);
      paramContext.startService(paramRecoveryContext);
      return true;
      str1 = paramCommonOptions.getRecoveryUploadService();
      break;
    }
  }
  
  public static void startReportService(Context paramContext, RecoveryStatusItem paramRecoveryStatusItem, String paramString)
  {
    RecoveryLog.i("Recovery.RecoveryLogic", "startReportService %s", new Object[] { "ProcessStatus" });
    Intent localIntent = new Intent(paramContext, RecoveryReportService.class);
    localIntent.putExtra("KeyReportType", "ProcessStatus");
    localIntent.putExtra("KeyReportItem", paramRecoveryStatusItem);
    localIntent.putExtra("KeyReportUploadClassName", paramString);
    paramContext.startService(localIntent);
  }
  
  public static void startReportService(Context paramContext, ArrayList<RecoveryHandleItem> paramArrayList, String paramString)
  {
    RecoveryLog.i("Recovery.RecoveryLogic", "startReportService %s", new Object[] { "HandleStatus" });
    Intent localIntent = new Intent(paramContext, RecoveryReportService.class);
    localIntent.putExtra("KeyReportType", "HandleStatus");
    localIntent.putExtra("KeyReportUploadClassName", paramString);
    localIntent.putParcelableArrayListExtra("KeyReportItem", paramArrayList);
    paramContext.startService(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.RecoveryLogic
 * JD-Core Version:    0.7.0.1
 */