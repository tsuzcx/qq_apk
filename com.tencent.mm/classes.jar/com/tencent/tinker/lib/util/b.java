package com.tencent.tinker.lib.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Process;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.util.Iterator;
import java.util.List;

public final class b
  extends ShareTinkerInternals
{
  private static String Krv = null;
  
  private static String f(Context paramContext, Class<? extends Service> paramClass)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = new ComponentName(paramContext, paramClass);
    try
    {
      paramContext = localPackageManager.getServiceInfo(paramContext, 0);
      return paramContext.processName;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static void kY(Context paramContext)
  {
    String str = la(paramContext);
    if (str == null) {}
    for (;;)
    {
      return;
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (localRunningAppProcessInfo.processName.equals(str)) {
            Process.killProcess(localRunningAppProcessInfo.pid);
          }
        }
      }
    }
  }
  
  public static boolean kZ(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    paramContext = la(paramContext);
    if (paramContext == null) {
      return false;
    }
    try
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        boolean bool = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals(paramContext);
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      ShareTinkerLog.e("Tinker.ServiceInternals", "isTinkerPatchServiceRunning Exception: " + paramContext.toString(), new Object[0]);
      return false;
    }
    catch (Error paramContext)
    {
      ShareTinkerLog.e("Tinker.ServiceInternals", "isTinkerPatchServiceRunning Error: " + paramContext.toString(), new Object[0]);
      return false;
    }
    return false;
  }
  
  private static String la(Context paramContext)
  {
    if (Krv != null) {
      return Krv;
    }
    paramContext = f(paramContext, TinkerPatchService.class);
    if (paramContext == null) {
      return null;
    }
    Krv = paramContext;
    return paramContext;
  }
  
  public static boolean lb(Context paramContext)
  {
    String str = getProcessName(paramContext);
    paramContext = la(paramContext);
    if ((paramContext == null) || (paramContext.length() == 0)) {
      return false;
    }
    return str.equals(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.util.b
 * JD-Core Version:    0.7.0.1
 */