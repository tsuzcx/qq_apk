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

public final class c
  extends ShareTinkerInternals
{
  private static String ahSe = null;
  
  private static String h(Context paramContext, Class<? extends Service> paramClass)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = new ComponentName(paramContext, paramClass);
    try
    {
      paramContext = localPackageManager.getServiceInfo(paramContext, 0);
      return paramContext.processName;
    }
    finally {}
    return null;
  }
  
  public static boolean oA(Context paramContext)
  {
    return TinkerPatchService.ov(paramContext);
  }
  
  public static String oB(Context paramContext)
  {
    if (ahSe != null) {
      return ahSe;
    }
    paramContext = h(paramContext, TinkerPatchService.class);
    if (paramContext == null) {
      return null;
    }
    ahSe = paramContext;
    return paramContext;
  }
  
  public static boolean oC(Context paramContext)
  {
    String str = getProcessName(paramContext);
    paramContext = oB(paramContext);
    if ((paramContext == null) || (paramContext.length() == 0)) {
      return false;
    }
    return str.equals(paramContext);
  }
  
  public static void oz(Context paramContext)
  {
    String str = oB(paramContext);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.f.c
 * JD-Core Version:    0.7.0.1
 */