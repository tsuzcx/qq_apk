package com.tencent.mm.sdk.platformtools;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class d
{
  private static Application OeF;
  private static Application OeG;
  
  public static Application fjS()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(194945);
        Application localApplication;
        if (OeF != null)
        {
          localApplication = OeF;
          AppMethodBeat.o(194945);
          return localApplication;
        }
        if (OeG != null)
        {
          localApplication = OeG;
          AppMethodBeat.o(194945);
          continue;
        }
        localObject2 = fty();
      }
      finally {}
      OeG = (Application)localObject2;
      if (localObject2 == null) {
        break;
      }
      localObject2 = OeG;
      AppMethodBeat.o(194945);
    }
    Object localObject2 = new IllegalStateException("Please make sure you do not call Applications#context() before or inside Application#attachBaseContext(Context). If you have to, please call Applications#attach(Application) first.");
    AppMethodBeat.o(194945);
    throw ((Throwable)localObject2);
  }
  
  private static Application fty()
  {
    AppMethodBeat.i(221720);
    try
    {
      localObject1 = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = (Application)((Method)localObject1).invoke(null, new Object[0]);
      AppMethodBeat.o(221720);
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
          ad.w("MicroMsg.sdk.ApplicationGlobal", "get activity thread fail, error = " + localException2.getMessage() + " & " + localException1.getMessage());
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static void p(Application paramApplication)
  {
    try
    {
      if (OeF == null) {
        OeF = paramApplication;
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
 * Qualified Name:     com.tencent.mm.sdk.platformtools.d
 * JD-Core Version:    0.7.0.1
 */