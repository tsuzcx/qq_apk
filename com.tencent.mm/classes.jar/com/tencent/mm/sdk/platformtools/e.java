package com.tencent.mm.sdk.platformtools;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class e
{
  private static Application Iwq;
  private static Application Iwr;
  
  public static Application fnL()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(200291);
        Application localApplication;
        if (Iwq != null)
        {
          localApplication = Iwq;
          AppMethodBeat.o(200291);
          return localApplication;
        }
        if (Iwr != null)
        {
          localApplication = Iwr;
          AppMethodBeat.o(200291);
          continue;
        }
        localObject2 = fnM();
      }
      finally {}
      Iwr = (Application)localObject2;
      if (localObject2 == null) {
        break;
      }
      localObject2 = Iwr;
      AppMethodBeat.o(200291);
    }
    Object localObject2 = new IllegalStateException("Please make sure you do not call Applications#context() before or inside Application#attachBaseContext(Context). If you have to, please call Applications#attach(Application) first.");
    AppMethodBeat.o(200291);
    throw ((Throwable)localObject2);
  }
  
  private static Application fnM()
  {
    AppMethodBeat.i(200292);
    try
    {
      localObject1 = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = (Application)((Method)localObject1).invoke(null, new Object[0]);
      AppMethodBeat.o(200292);
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
          ae.w("MicroMsg.sdk.ApplicationGlobal", "get activity thread fail, error = " + localException2.getMessage() + " & " + localException1.getMessage());
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static void o(Application paramApplication)
  {
    try
    {
      if (Iwq == null) {
        Iwq = paramApplication;
      }
      return;
    }
    finally
    {
      paramApplication = finally;
      throw paramApplication;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.e
 * JD-Core Version:    0.7.0.1
 */