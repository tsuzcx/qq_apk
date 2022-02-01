package com.tencent.xweb.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class j
{
  public static String khD()
  {
    AppMethodBeat.i(212606);
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject1 = k.rc("android.app.Application", "getProcessName");
      if (localObject1 != null)
      {
        Log.i("ProcessUtil", "safeGetProcessName, processName:" + localObject1.toString());
        localObject1 = localObject1.toString();
        AppMethodBeat.o(212606);
        return localObject1;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
        ((Method)localObject1).setAccessible(true);
        localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
        if ((localObject1 instanceof String))
        {
          localObject1 = (String)localObject1;
          Log.i("ProcessUtil", "getCurrentProcessNameByActivityThread, processName:".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(212606);
          return localObject1;
        }
      }
      finally
      {
        str = khE();
        AppMethodBeat.o(212606);
        return str;
      }
      String str = null;
    }
  }
  
  private static String khE()
  {
    AppMethodBeat.i(212617);
    Object localObject = XWalkEnvironment.getApplicationContext();
    int i = Process.myPid();
    if (localObject == null)
    {
      AppMethodBeat.o(212617);
      return null;
    }
    localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
    if (localObject != null)
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (localRunningAppProcessInfo.pid == i)
          {
            Log.i("ProcessUtil", "getProcessNameByPid, processName:" + localRunningAppProcessInfo.processName);
            localObject = localRunningAppProcessInfo.processName;
            AppMethodBeat.o(212617);
            return localObject;
          }
        }
      }
    }
    AppMethodBeat.o(212617);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.util.j
 * JD-Core Version:    0.7.0.1
 */