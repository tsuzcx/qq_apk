package com.tencent.xweb.util;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import dalvik.system.DexClassLoader;
import java.io.File;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class i
{
  static boolean SEQ = false;
  static int SER = -1;
  
  private static ClassLoader a(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(183533);
    String str = paramString1;
    if (Build.VERSION.SDK_INT >= 29)
    {
      str = paramString1;
      if (paramString1.endsWith("classes.dex"))
      {
        str = paramString1;
        if (!"true".equalsIgnoreCase(a.nS("NOT_USE_JAR_REPLACE_DEX", "tools")))
        {
          str = paramString1.replace("classes.dex", "classes.dex.jar");
          if (!new File(str).exists()) {
            break label98;
          }
          Log.i("XWebClassLoaderWrapper", "do use .jar instead of .dex");
        }
      }
    }
    for (;;)
    {
      paramString1 = new DexClassLoader(str, paramString2, paramString3, paramClassLoader);
      AppMethodBeat.o(183533);
      return paramString1;
      label98:
      Log.i("XWebClassLoaderWrapper", "try use .jar instead of .dex , but .jar not exist");
      str = paramString1;
    }
  }
  
  public static ClassLoader asW(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(219097);
    if (paramInt == -1)
    {
      Log.i("XWebClassLoaderWrapper", "getXWalkClassLoader version = -1");
      AppMethodBeat.o(219097);
      return null;
    }
    if (paramInt > 0)
    {
      if (!SEQ)
      {
        SEQ = true;
        SER = a.hsb().av("APK_LOAD_MIN_VER", null, -1);
        Log.i("XWebClassLoaderWrapper", "support apk load min ver = " + SER);
      }
      if ((SER <= 0) || (paramInt <= SER)) {}
    }
    Object localObject;
    String str1;
    while (i != 0)
    {
      localObject = XWalkEnvironment.getDownloadApkPath(paramInt);
      str1 = XWalkEnvironment.getExtractedCoreDir(paramInt);
      String str2 = XWalkEnvironment.getOptimizedDexDir(paramInt);
      Log.i("XWebClassLoaderWrapper", "is apk load path  = ".concat(String.valueOf(localObject)));
      localObject = bx((String)localObject, str2, str1);
      AppMethodBeat.o(219097);
      return localObject;
      i = 0;
    }
    try
    {
      localObject = XWalkEnvironment.getExtractedCoreDir(paramInt);
      str1 = XWalkEnvironment.getClassDexFilePath(paramInt);
      boolean bool = new File(str1).exists();
      if (!bool)
      {
        AppMethodBeat.o(219097);
        return null;
      }
      localObject = bx(str1, XWalkEnvironment.getOptimizedDexDir(paramInt), (String)localObject);
      AppMethodBeat.o(219097);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("XWebClassLoaderWrapper", "getXWalkClassLoader error:" + localException.getMessage());
      AppMethodBeat.o(219097);
    }
    return null;
  }
  
  public static ClassLoader bx(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(183532);
    paramString1 = a(paramString1, paramString2, paramString3, ClassLoader.getSystemClassLoader());
    AppMethodBeat.o(183532);
    return paramString1;
  }
  
  public static ClassLoader huI()
  {
    AppMethodBeat.i(219096);
    ClassLoader localClassLoader = asW(XWalkEnvironment.getAvailableVersion());
    AppMethodBeat.o(219096);
    return localClassLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.util.i
 * JD-Core Version:    0.7.0.1
 */