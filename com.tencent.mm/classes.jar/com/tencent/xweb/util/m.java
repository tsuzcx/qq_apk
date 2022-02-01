package com.tencent.xweb.util;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import dalvik.system.DexClassLoader;
import java.io.File;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkFileUtil;

public final class m
{
  private static boolean aimO = false;
  private static int aimP = -1;
  
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
        if (!"true".equalsIgnoreCase(a.keX().qM("NOT_USE_JAR_REPLACE_DEX", "tools")))
        {
          str = paramString1.replace("classes.dex", "classes.dex.jar");
          if (!new File(str).exists()) {
            break label143;
          }
          org.xwalk.core.Log.i("XWebClassLoaderWrapper", "do use .jar instead of .dex");
        }
      }
    }
    for (;;)
    {
      org.xwalk.core.Log.i("XWebClassLoaderWrapper", String.format("getClassLoader, dexPath:%s, optimizedDirectory:%s, librarySearchPath:%s, stack:%s", new Object[] { str, paramString2, paramString3, android.util.Log.getStackTraceString(new Exception("please ignore this exception")) }));
      paramString1 = new DexClassLoader(str, paramString2, paramString3, paramClassLoader);
      AppMethodBeat.o(183533);
      return paramString1;
      label143:
      org.xwalk.core.Log.i("XWebClassLoaderWrapper", "try use .jar instead of .dex, but .jar not exist");
      str = paramString1;
    }
  }
  
  private static boolean aJG(int paramInt)
  {
    AppMethodBeat.i(212603);
    org.xwalk.core.Log.i("XWebClassLoaderWrapper", "isApkLoadMode, current version:".concat(String.valueOf(paramInt)));
    if (paramInt >= 3000)
    {
      AppMethodBeat.o(212603);
      return true;
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(212603);
      return false;
    }
    if (!aimO)
    {
      aimO = true;
      aimP = a.keX().aU("APK_LOAD_MIN_VER", null, -1);
      org.xwalk.core.Log.i("XWebClassLoaderWrapper", "isApkLoadMode, support apk load min version:" + aimP);
    }
    if (paramInt > aimP)
    {
      AppMethodBeat.o(212603);
      return true;
    }
    AppMethodBeat.o(212603);
    return false;
  }
  
  public static boolean aJH(int paramInt)
  {
    AppMethodBeat.i(212646);
    try
    {
      df(paramInt, false);
      AppMethodBeat.o(212646);
      return true;
    }
    finally
    {
      XWalkEnvironment.addXWalkInitializeLog("XWebClassLoaderWrapper", "generateOptDex error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(212646);
    }
    return false;
  }
  
  public static ClassLoader bS(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(183532);
    paramString1 = a(paramString1, paramString2, paramString3, ClassLoader.getSystemClassLoader());
    AppMethodBeat.o(183532);
    return paramString1;
  }
  
  public static ClassLoader df(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(212621);
    org.xwalk.core.Log.i("XWebClassLoaderWrapper", "getXWebClassLoader, apkVersion:" + paramInt + ", forceApkLoad:" + paramBoolean);
    long l = System.currentTimeMillis();
    if (paramInt == -1)
    {
      org.xwalk.core.Log.i("XWebClassLoaderWrapper", "getXWebClassLoader, version invalid");
      AppMethodBeat.o(212621);
      return null;
    }
    Object localObject1;
    String str;
    if ((aJG(paramInt)) || (paramBoolean))
    {
      localObject1 = XWalkFileUtil.getDownloadApkPath(paramInt);
      if (!new File((String)localObject1).exists())
      {
        org.xwalk.core.Log.w("XWebClassLoaderWrapper", "getXWebClassLoader, apk file not exist");
        AppMethodBeat.o(212621);
        return null;
      }
      str = XWalkFileUtil.getExtractedCoreDir(paramInt);
      localObject1 = bS((String)localObject1, XWalkFileUtil.getOptimizedDexDir(paramInt), str);
    }
    for (;;)
    {
      org.xwalk.core.Log.w("XWebClassLoaderWrapper", "###### getXWebClassLoader, costTime:" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(212621);
      return localObject1;
      try
      {
        localObject1 = XWalkFileUtil.getClassDexFilePath(paramInt);
        if (!new File((String)localObject1).exists())
        {
          org.xwalk.core.Log.w("XWebClassLoaderWrapper", "getXWebClassLoader, dex file not exist");
          AppMethodBeat.o(212621);
          return null;
        }
        str = XWalkFileUtil.getExtractedCoreDir(paramInt);
        localObject1 = bS((String)localObject1, XWalkFileUtil.getOptimizedDexDir(paramInt), str);
      }
      finally
      {
        org.xwalk.core.Log.e("XWebClassLoaderWrapper", "getXWebClassLoader, error:".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(212621);
      }
    }
    return null;
  }
  
  private static void eQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212644);
    paramString = new File(paramString);
    if (!paramString.isDirectory())
    {
      AppMethodBeat.o(212644);
      return;
    }
    paramString = paramString.listFiles();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      File localFile1 = paramString[i];
      if (localFile1 != null)
      {
        if (!localFile1.isDirectory()) {
          break label76;
        }
        eQ(localFile1.getAbsolutePath(), paramBoolean);
      }
      for (;;)
      {
        i += 1;
        break;
        label76:
        if (localFile1.getName().endsWith(".dex"))
        {
          String str1 = localFile1.getName();
          try
          {
            String str2 = localFile1.getAbsolutePath() + ".jar";
            File localFile2 = new File(str2);
            if (localFile2.exists())
            {
              org.xwalk.core.Log.i("XWebClassLoaderWrapper", "generate jar from " + str1 + ", but jar file exists, need remove:" + paramBoolean);
              if (paramBoolean) {
                localFile2.delete();
              }
            }
            else
            {
              boolean bool = n.k(localFile1, str2);
              org.xwalk.core.Log.i("XWebClassLoaderWrapper", "generate jar from " + str1 + ", result:" + bool);
            }
          }
          finally
          {
            org.xwalk.core.Log.e("XWebClassLoaderWrapper", "generate jar from " + str1 + " failed, error:" + localObject);
          }
        }
      }
    }
    AppMethodBeat.o(212644);
  }
  
  public static ClassLoader kiJ()
  {
    AppMethodBeat.i(212608);
    ClassLoader localClassLoader = df(XWalkEnvironment.getAvailableVersion(), false);
    AppMethodBeat.o(212608);
    return localClassLoader;
  }
  
  public static void q(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212639);
    if (aJG(paramInt))
    {
      org.xwalk.core.Log.i("XWebClassLoaderWrapper", "tryGenerateJarForDexInDir, apk load mode no need generate jar");
      AppMethodBeat.o(212639);
      return;
    }
    if ((Build.VERSION.SDK_INT < 29) || ("true".equalsIgnoreCase(a.keX().qM("NOT_USE_JAR_REPLACE_DEX", "tools"))))
    {
      org.xwalk.core.Log.i("XWebClassLoaderWrapper", "tryGenerateJarForDexInDir, no need generate jar, android build version:" + Build.VERSION.SDK_INT);
      AppMethodBeat.o(212639);
      return;
    }
    eQ(paramString, paramBoolean);
    AppMethodBeat.o(212639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.util.m
 * JD-Core Version:    0.7.0.1
 */