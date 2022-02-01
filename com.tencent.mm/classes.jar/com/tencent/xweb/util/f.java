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
import org.xwalk.core.XWalkEnvironment;

public final class f
{
  public static String htT()
  {
    AppMethodBeat.i(219086);
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject1 = g.oj("android.app.Application", "getProcessName");
      if (localObject1 != null)
      {
        localObject1 = localObject1.toString();
        AppMethodBeat.o(219086);
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
          AppMethodBeat.o(219086);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        localObject2 = XWalkEnvironment.getApplicationContext();
        int i = Process.myPid();
        if (localObject2 != null)
        {
          localObject2 = (ActivityManager)((Context)localObject2).getSystemService("activity");
          if (localObject2 != null)
          {
            localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              if (((Iterator)localObject2).hasNext())
              {
                ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
                if (localRunningAppProcessInfo.pid != i) {
                  continue;
                }
                localObject2 = localRunningAppProcessInfo.processName;
                AppMethodBeat.o(219086);
                return localObject2;
              }
            }
          }
        }
        AppMethodBeat.o(219086);
        return null;
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.util.f
 * JD-Core Version:    0.7.0.1
 */