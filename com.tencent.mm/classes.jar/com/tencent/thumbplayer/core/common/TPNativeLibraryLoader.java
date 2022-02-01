package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPNativeLibraryLoader
{
  private static final String DEFAULT_LIB_PLAYER_CORE_VERSION = "2.3.1.1063.wechat";
  private static final String MAIN_PLAYER_CORE_VERSION = "2.3.1";
  private static boolean mIsLibLoaded = false;
  private static Object mIsLibLoadedLock;
  private static ITPNativeLibraryExternalLoader mLibLoader;
  private static final boolean mLibNameHasArchSuffix = false;
  private static final String mLibPlayerCorePrefix = "TPCore-master";
  
  static
  {
    AppMethodBeat.i(193675);
    mIsLibLoadedLock = new Object();
    mIsLibLoaded = false;
    mLibLoader = null;
    AppMethodBeat.o(193675);
  }
  
  private static native String _getPlayerCoreVersion();
  
  public static String getLibVersion()
  {
    AppMethodBeat.i(193668);
    String str = getPlayerCoreVersion();
    AppMethodBeat.o(193668);
    return str;
  }
  
  public static String getPlayerCoreVersion()
  {
    AppMethodBeat.i(193671);
    try
    {
      String str = _getPlayerCoreVersion();
      AppMethodBeat.o(193671);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(2, "getPlayerCoreVersion: *.so is not loaded yet, return the hard-coded version number:2.3.1.1063.wechat");
      AppMethodBeat.o(193671);
    }
    return "2.3.1.1063.wechat";
  }
  
  /* Error */
  public static boolean isLibLoaded()
  {
    // Byte code:
    //   0: ldc 67
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: invokestatic 71	com/tencent/thumbplayer/core/common/TPNativeLibraryLoader:loadLibIfNeeded	(Landroid/content/Context;)V
    //   9: getstatic 36	com/tencent/thumbplayer/core/common/TPNativeLibraryLoader:mIsLibLoadedLock	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: getstatic 38	com/tencent/thumbplayer/core/common/TPNativeLibraryLoader:mIsLibLoaded	Z
    //   18: istore_0
    //   19: aload_1
    //   20: monitorexit
    //   21: ldc 67
    //   23: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: iload_0
    //   27: ireturn
    //   28: astore_1
    //   29: iconst_4
    //   30: new 73	java/lang/StringBuilder
    //   33: dup
    //   34: ldc 75
    //   36: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_1
    //   40: invokevirtual 81	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   43: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 64	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   52: goto -43 -> 9
    //   55: astore_2
    //   56: aload_1
    //   57: monitorexit
    //   58: ldc 67
    //   60: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	9	0	bool	boolean
    //   28	29	1	localThrowable	Throwable
    //   55	9	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	9	28	java/lang/Throwable
    //   15	21	55	finally
    //   56	58	55	finally
  }
  
  private static boolean isMatchJavaAndPlayerCore(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(193674);
    TPNativeLog.printLog(2, "javaVersion:" + paramString1 + ", coreVersion:" + paramString2);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        break label64;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(193674);
      return bool1;
      label64:
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
      bool1 = bool2;
      if (paramString1.length >= 3)
      {
        bool1 = bool2;
        if (paramString2.length >= 3)
        {
          int i = 0;
          for (;;)
          {
            if (i >= 3) {
              break label125;
            }
            bool1 = bool2;
            if (!paramString1[i].matches(paramString2[i])) {
              break;
            }
            i += 1;
          }
          label125:
          bool1 = true;
        }
      }
    }
  }
  
  private static boolean loadLib(Context paramContext)
  {
    AppMethodBeat.i(193672);
    if ((TPSystemInfo.getCpuArchitecture() == 3) || (TPSystemInfo.getCpuArchitecture() == 4) || (TPSystemInfo.getCpuArchitecture() == 0))
    {
      AppMethodBeat.o(193672);
      return false;
    }
    String str = "TPCore-master".concat(String.valueOf(""));
    boolean bool1;
    boolean bool2;
    if (mLibLoader != null)
    {
      bool1 = mLibLoader.loadLib(str, "2.3.1.1063.wechat");
      bool2 = bool1;
      if (bool1)
      {
        paramContext = getPlayerCoreVersion();
        bool1 = isMatchJavaAndPlayerCore("2.3.1", paramContext);
        bool2 = bool1;
        if (!bool1)
        {
          TPNativeLog.printLog(4, "nativePlayerCoreVer(" + paramContext + ") doesn't match javaPlayerCoreVer:(2.3.1)");
          bool2 = bool1;
        }
      }
      if (!bool2) {
        break label137;
      }
      TPNativeLog.printLog(2, "Native libs loaded successfully");
    }
    for (;;)
    {
      AppMethodBeat.o(193672);
      return bool2;
      bool1 = loadLibDefault(str, paramContext);
      break;
      label137:
      TPNativeLog.printLog(4, "Failed to load native libs");
    }
  }
  
  private static boolean loadLibDefault(String paramString, Context paramContext)
  {
    AppMethodBeat.i(193673);
    bool2 = false;
    bool1 = bool2;
    try
    {
      TPNativeLog.printLog(2, "loadLibDefault loading ".concat(String.valueOf(paramString)));
      bool1 = bool2;
      System.loadLibrary(paramString);
      bool1 = true;
      TPNativeLog.printLog(2, "loadLibDefault " + paramString + " loaded successfully");
      bool1 = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TPNativeLog.printLog(4, "loadLibDefault failed to load " + paramString + "," + localThrowable.getMessage());
        continue;
        bool2 = bool1;
        TPNativeLog.printLog(4, "loadLibDefault loaded " + paramString + " from APK failed");
        bool2 = bool1;
      }
    }
    bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (paramContext != null)
      {
        bool2 = bool1;
        if (TPSystemInfo.getCpuArchitecture() >= 6) {
          bool2 = bool1;
        }
      }
    }
    try
    {
      TPNativeLog.printLog(2, "loadLibDefault try to load " + paramString + " from APK");
      bool2 = bool1;
      bool1 = TPLoadLibFromApk.load(paramString, TPNativeLibraryLoader.class.getClassLoader(), paramContext);
      if (!bool1) {
        break label197;
      }
      bool2 = bool1;
      TPNativeLog.printLog(2, "loadLibDefault loaded " + paramString + " from APK successfully");
      bool2 = bool1;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TPNativeLog.printLog(4, "loadLibDefault loaded " + paramString + " from APK failed," + paramContext.getMessage());
      }
    }
    AppMethodBeat.o(193673);
    return bool2;
  }
  
  public static void loadLibIfNeeded(Context paramContext)
  {
    AppMethodBeat.i(193669);
    for (;;)
    {
      synchronized (mIsLibLoadedLock)
      {
        if (!mIsLibLoaded)
        {
          boolean bool = loadLib(paramContext);
          mIsLibLoaded = bool;
          if (bool) {
            TPNativeLog.printLog(2, "TPNativeLibraryLoader load lib successfully");
          }
        }
        else
        {
          if (mIsLibLoaded) {
            break;
          }
          paramContext = new UnsupportedOperationException("Failed to load native library");
          AppMethodBeat.o(193669);
          throw paramContext;
        }
      }
      TPNativeLog.printLog(2, "TPNativeLibraryLoader load lib failed");
    }
    AppMethodBeat.o(193669);
  }
  
  public static void setLibLoader(ITPNativeLibraryExternalLoader paramITPNativeLibraryExternalLoader)
  {
    mLibLoader = paramITPNativeLibraryExternalLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPNativeLibraryLoader
 * JD-Core Version:    0.7.0.1
 */