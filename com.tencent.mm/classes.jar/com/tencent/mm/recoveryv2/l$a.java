package com.tencent.mm.recoveryv2;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class l$a
{
  private static Application gNz;
  
  private static Application getApplication()
  {
    AppMethodBeat.i(193875);
    try
    {
      Object localObject1 = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = (Application)((Method)localObject1).invoke(null, new Object[0]);
      AppMethodBeat.o(193875);
      return localObject1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
          ((Method)localObject2).setAccessible(true);
          localObject2 = (Application)((Method)localObject2).invoke(null, new Object[0]);
        }
        catch (Exception localException2)
        {
          Object localObject3 = null;
        }
      }
    }
  }
  
  public static Application gva()
  {
    AppMethodBeat.i(193874);
    if (gNz == null) {
      gNz = getApplication();
    }
    Application localApplication = gNz;
    AppMethodBeat.o(193874);
    return localApplication;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.l.a
 * JD-Core Version:    0.7.0.1
 */