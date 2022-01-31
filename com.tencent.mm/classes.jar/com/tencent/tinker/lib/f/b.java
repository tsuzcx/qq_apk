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
  private static String Btp = null;
  
  private static String c(Context paramContext, Class<? extends Service> paramClass)
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
  
  public static void jp(Context paramContext)
  {
    String str = jr(paramContext);
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
  
  public static boolean jq(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    paramContext = jr(paramContext);
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
  
  private static String jr(Context paramContext)
  {
    if (Btp != null) {
      return Btp;
    }
    paramContext = c(paramContext, TinkerPatchService.class);
    if (paramContext == null) {
      return null;
    }
    Btp = paramContext;
    return paramContext;
  }
  
  public static boolean js(Context paramContext)
  {
    String str = aI(paramContext);
    paramContext = jr(paramContext);
    if ((paramContext == null) || (paramContext.length() == 0)) {
      return false;
    }
    return str.equals(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tinker.lib.f.b
 * JD-Core Version:    0.7.0.1
 */