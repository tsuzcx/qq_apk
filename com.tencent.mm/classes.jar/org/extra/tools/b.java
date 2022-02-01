package org.extra.tools;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.reflect.Method;
import org.extra.a.c;

public class b
{
  public static final String TAG;
  private static Context appContext;
  
  static
  {
    AppMethodBeat.i(216860);
    TAG = b.class.getSimpleName();
    AppMethodBeat.o(216860);
  }
  
  private static boolean cQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(216858);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(216858);
      return false;
    }
    boolean bool = true;
    try
    {
      paramContext = paramContext.getApplicationInfo().dataDir + "/lib";
      System.load(paramContext + File.separator + "lib" + paramString + ".so");
      AppMethodBeat.o(216858);
      return bool;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        new StringBuilder("load  fail! Error: ").append(paramContext.getMessage());
        bool = false;
      }
    }
  }
  
  private static boolean cR(Context paramContext, String paramString)
  {
    AppMethodBeat.i(216859);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(216859);
      return false;
    }
    try
    {
      c.loadLibrary(paramContext, paramString);
      AppMethodBeat.o(216859);
      return true;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(216859);
    }
    return false;
  }
  
  public static Context getAppContext()
  {
    return appContext;
  }
  
  private static boolean load(String paramString)
  {
    AppMethodBeat.i(216857);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(216857);
      return false;
    }
    boolean bool = true;
    try
    {
      System.loadLibrary(paramString);
      AppMethodBeat.o(216857);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        new StringBuilder("loadLibrary ").append(paramString).append(" fail! Error: ").append(localThrowable.getMessage());
        bool = false;
      }
    }
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(216856);
    try
    {
      appContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
      label33:
      Context localContext = appContext;
      if ((!load(paramString)) && (!cQ(localContext, paramString))) {
        cR(localContext, paramString);
      }
      AppMethodBeat.o(216856);
      return;
    }
    catch (Exception localException)
    {
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.tools.b
 * JD-Core Version:    0.7.0.1
 */