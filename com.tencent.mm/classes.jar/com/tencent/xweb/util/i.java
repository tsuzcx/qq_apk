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
  static boolean aaga = false;
  static int aagb = -1;
  
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
        if (!"true".equalsIgnoreCase(a.oO("NOT_USE_JAR_REPLACE_DEX", "tools")))
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
  
  public static boolean aCN(int paramInt)
  {
    AppMethodBeat.i(195820);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(195820);
      return false;
    }
    if (!aaga)
    {
      aaga = true;
      aagb = a.ivJ().aG("APK_LOAD_MIN_VER", null, -1);
      Log.i("XWebClassLoaderWrapper", "support apk load min ver = " + aagb);
    }
    if (aagb <= 0)
    {
      AppMethodBeat.o(195820);
      return false;
    }
    if (paramInt > aagb)
    {
      AppMethodBeat.o(195820);
      return true;
    }
    AppMethodBeat.o(195820);
    return false;
  }
  
  public static ClassLoader aCO(int paramInt)
  {
    AppMethodBeat.i(195829);
    if (paramInt == -1)
    {
      Log.i("XWebClassLoaderWrapper", "getXWalkClassLoader version = -1");
      AppMethodBeat.o(195829);
      return null;
    }
    Object localObject;
    String str1;
    if (aCN(paramInt))
    {
      localObject = XWalkEnvironment.getDownloadApkPath(paramInt);
      str1 = XWalkEnvironment.getExtractedCoreDir(paramInt);
      String str2 = XWalkEnvironment.getOptimizedDexDir(paramInt);
      Log.i("XWebClassLoaderWrapper", "is apk load path  = ".concat(String.valueOf(localObject)));
      localObject = bv((String)localObject, str2, str1);
      AppMethodBeat.o(195829);
      return localObject;
    }
    try
    {
      localObject = XWalkEnvironment.getExtractedCoreDir(paramInt);
      str1 = XWalkEnvironment.getClassDexFilePath(paramInt);
      boolean bool = new File(str1).exists();
      if (!bool)
      {
        AppMethodBeat.o(195829);
        return null;
      }
      localObject = bv(str1, XWalkEnvironment.getOptimizedDexDir(paramInt), (String)localObject);
      AppMethodBeat.o(195829);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("XWebClassLoaderWrapper", "getXWalkClassLoader error:" + localException.getMessage());
      AppMethodBeat.o(195829);
    }
    return null;
  }
  
  public static ClassLoader bv(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(183532);
    paramString1 = a(paramString1, paramString2, paramString3, ClassLoader.getSystemClassLoader());
    AppMethodBeat.o(183532);
    return paramString1;
  }
  
  public static ClassLoader iyv()
  {
    AppMethodBeat.i(195823);
    ClassLoader localClassLoader = aCO(XWalkEnvironment.getAvailableVersion());
    AppMethodBeat.o(195823);
    return localClassLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.i
 * JD-Core Version:    0.7.0.1
 */