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
    AppMethodBeat.i(187358);
    TAG = b.class.getSimpleName();
    AppMethodBeat.o(187358);
  }
  
  private static boolean dB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(187343);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(187343);
      return false;
    }
    boolean bool = true;
    try
    {
      paramContext = paramContext.getApplicationInfo().dataDir + "/lib";
      System.load(paramContext + File.separator + "lib" + paramString + ".so");
      AppMethodBeat.o(187343);
      return bool;
    }
    finally
    {
      for (;;)
      {
        new StringBuilder("load  fail! Error: ").append(paramContext.getMessage());
        bool = false;
      }
    }
  }
  
  private static boolean dC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(187350);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(187350);
      return false;
    }
    try
    {
      c.loadLibrary(paramContext, paramString);
      return true;
    }
    finally
    {
      AppMethodBeat.o(187350);
    }
    return false;
  }
  
  public static Context getAppContext()
  {
    return appContext;
  }
  
  private static boolean load(String paramString)
  {
    AppMethodBeat.i(187326);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(187326);
      return false;
    }
    try
    {
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, locala.aYi(), "org/extra/tools/LibraryLoadUtils", "load", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "org/extra/tools/LibraryLoadUtils", "load", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      bool = true;
    }
    finally
    {
      for (;;)
      {
        new StringBuilder("loadLibrary ").append(paramString).append(" fail! Error: ").append(localObject1.getMessage());
        boolean bool = false;
      }
    }
    AppMethodBeat.o(187326);
    return bool;
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(187309);
    try
    {
      appContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
      label33:
      Context localContext = appContext;
      if ((!load(paramString)) && (!dB(localContext, paramString))) {
        dC(localContext, paramString);
      }
      AppMethodBeat.o(187309);
      return;
    }
    catch (Exception localException)
    {
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.extra.tools.b
 * JD-Core Version:    0.7.0.1
 */