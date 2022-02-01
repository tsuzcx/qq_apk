package com.tencent.mm.sdk.platformtools;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class ApplicationGlobal
{
  private static final String TAG = "MicroMsg.sdk.ApplicationGlobal";
  private static Application sActivityThreadApp;
  private static Application sAttachedApp;
  
  public static void attach(Application paramApplication)
  {
    try
    {
      if (sAttachedApp == null) {
        sAttachedApp = paramApplication;
      }
      return;
    }
    finally
    {
      paramApplication = finally;
      throw paramApplication;
    }
  }
  
  public static Application context()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(230278);
        Application localApplication;
        if (sAttachedApp != null)
        {
          localApplication = sAttachedApp;
          AppMethodBeat.o(230278);
          return localApplication;
        }
        if (sActivityThreadApp != null)
        {
          localApplication = sActivityThreadApp;
          AppMethodBeat.o(230278);
          continue;
        }
        localObject2 = getActivityThreadApplication();
      }
      finally {}
      sActivityThreadApp = (Application)localObject2;
      if (localObject2 == null) {
        break;
      }
      localObject2 = sActivityThreadApp;
      AppMethodBeat.o(230278);
    }
    Object localObject2 = new IllegalStateException("Please make sure you do not call Applications#context() before or inside Application#attachBaseContext(Context). If you have to, please call Applications#attach(Application) first.");
    AppMethodBeat.o(230278);
    throw ((Throwable)localObject2);
  }
  
  private static Application getActivityThreadApplication()
  {
    AppMethodBeat.i(230279);
    try
    {
      localObject1 = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = (Application)((Method)localObject1).invoke(null, new Object[0]);
      AppMethodBeat.o(230279);
      return localObject1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          Object localObject1 = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
          ((Method)localObject1).setAccessible(true);
          localObject1 = (Application)((Method)localObject1).invoke(null, new Object[0]);
        }
        catch (Exception localException1)
        {
          Log.w("MicroMsg.sdk.ApplicationGlobal", "get activity thread fail, error = " + localException2.getMessage() + " & " + localException1.getMessage());
          Object localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ApplicationGlobal
 * JD-Core Version:    0.7.0.1
 */