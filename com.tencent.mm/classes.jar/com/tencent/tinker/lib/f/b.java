package com.tencent.tinker.lib.f;

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
import java.util.Iterator;
import java.util.List;

public final class b
  extends ShareTinkerInternals
{
  private static String wWM = null;
  
  private static String b(Context paramContext, Class<? extends Service> paramClass)
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
  
  public static void hO(Context paramContext)
  {
    String str = hQ(paramContext);
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
  
  public static boolean hP(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    paramContext = hQ(paramContext);
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
      new StringBuilder("isTinkerPatchServiceRunning Exception: ").append(paramContext.toString());
      return false;
    }
    catch (Error paramContext)
    {
      new StringBuilder("isTinkerPatchServiceRunning Error: ").append(paramContext.toString());
      return false;
    }
    return false;
  }
  
  private static String hQ(Context paramContext)
  {
    if (wWM != null) {
      return wWM;
    }
    paramContext = b(paramContext, TinkerPatchService.cQH());
    if (paramContext == null) {
      return null;
    }
    wWM = paramContext;
    return paramContext;
  }
  
  public static boolean hR(Context paramContext)
  {
    String str = ak(paramContext);
    paramContext = hQ(paramContext);
    if ((paramContext == null) || (paramContext.length() == 0)) {
      return false;
    }
    return str.equals(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.f.b
 * JD-Core Version:    0.7.0.1
 */