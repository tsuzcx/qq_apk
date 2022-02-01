package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPNativeLibraryLoader
{
  private static final String DEFAULT_LIB_PLAYER_CORE_VERSION = "2.10.0.1072.wechat";
  private static final String MAIN_PLAYER_CORE_VERSION = "2.10.0";
  private static boolean mIsLibLoaded = false;
  private static Object mIsLibLoadedLock;
  private static ITPNativeLibraryExternalLoader mLibLoader;
  private static final boolean mLibNameHasArchSuffix = false;
  private static final String mLibPlayerCorePrefix = "TPCore-master";
  private byte _hellAccFlag_;
  
  static
  {
    AppMethodBeat.i(227706);
    mIsLibLoadedLock = new Object();
    mIsLibLoaded = false;
    mLibLoader = null;
    AppMethodBeat.o(227706);
  }
  
  private static native String _getPlayerCoreVersion();
  
  public static String getLibVersion()
  {
    AppMethodBeat.i(227643);
    String str = getPlayerCoreVersion();
    AppMethodBeat.o(227643);
    return str;
  }
  
  public static String getPlayerCoreVersion()
  {
    AppMethodBeat.i(227670);
    try
    {
      String str = _getPlayerCoreVersion();
      AppMethodBeat.o(227670);
      return str;
    }
    finally
    {
      TPNativeLog.printLog(2, "getPlayerCoreVersion: *.so is not loaded yet, return the hard-coded version number:2.10.0.1072.wechat");
      AppMethodBeat.o(227670);
    }
    return "2.10.0.1072.wechat";
  }
  
  /* Error */
  public static boolean isLibLoaded()
  {
    // Byte code:
    //   0: ldc 67
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: invokestatic 71	com/tencent/thumbplayer/core/common/TPNativeLibraryLoader:loadLibIfNeeded	(Landroid/content/Context;)V
    //   9: getstatic 38	com/tencent/thumbplayer/core/common/TPNativeLibraryLoader:mIsLibLoadedLock	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: getstatic 40	com/tencent/thumbplayer/core/common/TPNativeLibraryLoader:mIsLibLoaded	Z
    //   18: istore_0
    //   19: aload_1
    //   20: monitorexit
    //   21: ldc 67
    //   23: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: iload_0
    //   27: ireturn
    //   28: astore_1
    //   29: iconst_4
    //   30: new 73	java/lang/StringBuilder
    //   33: dup
    //   34: ldc 75
    //   36: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_1
    //   40: invokevirtual 83	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   43: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 64	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   52: goto -43 -> 9
    //   55: astore_2
    //   56: aload_1
    //   57: monitorexit
    //   58: ldc 67
    //   60: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	9	0	bool	boolean
    //   28	29	1	localObject2	Object
    //   55	9	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	9	28	finally
    //   15	21	55	finally
  }
  
  private static boolean isMatchJavaAndPlayerCore(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(227700);
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
      AppMethodBeat.o(227700);
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
    AppMethodBeat.i(227679);
    TPNativeLog.printLog(2, "loadLib cpu arch:" + TPSystemInfo.getCpuArchitecture());
    if ((TPSystemInfo.getCpuArchitecture() == 3) || (TPSystemInfo.getCpuArchitecture() == 4) || (TPSystemInfo.getCpuArchitecture() == 0))
    {
      AppMethodBeat.o(227679);
      return false;
    }
    String str = "TPCore-master".concat(String.valueOf(""));
    boolean bool1;
    boolean bool2;
    if (mLibLoader != null)
    {
      bool1 = mLibLoader.loadLib(str, "2.10.0.1072.wechat");
      bool2 = bool1;
      if (bool1)
      {
        paramContext = getPlayerCoreVersion();
        bool1 = isMatchJavaAndPlayerCore("2.10.0", paramContext);
        bool2 = bool1;
        if (!bool1)
        {
          TPNativeLog.printLog(4, "nativePlayerCoreVer(" + paramContext + ") doesn't match javaPlayerCoreVer:(2.10.0)");
          bool2 = bool1;
        }
      }
      if (!bool2) {
        break label159;
      }
      TPNativeLog.printLog(2, "Native libs loaded successfully");
    }
    for (;;)
    {
      AppMethodBeat.o(227679);
      return bool2;
      bool1 = loadLibDefault(str, paramContext);
      break;
      label159:
      TPNativeLog.printLog(4, "Failed to load native libs");
    }
  }
  
  /* Error */
  private static boolean loadLibDefault(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: ldc 158
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_2
    //   6: ldc 160
    //   8: aload_0
    //   9: invokestatic 135	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   12: invokevirtual 139	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   15: invokestatic 64	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   18: new 162	com/tencent/mm/hellhoundlib/b/a
    //   21: dup
    //   22: invokespecial 163	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   25: aload_0
    //   26: invokevirtual 167	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   29: astore 4
    //   31: new 4	java/lang/Object
    //   34: dup
    //   35: invokespecial 36	java/lang/Object:<init>	()V
    //   38: astore 5
    //   40: aload 5
    //   42: aload 4
    //   44: invokevirtual 171	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   47: ldc 172
    //   49: ldc 173
    //   51: ldc 174
    //   53: ldc 176
    //   55: ldc 178
    //   57: ldc 179
    //   59: invokestatic 185	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload 4
    //   64: iconst_0
    //   65: invokevirtual 189	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   68: checkcast 107	java/lang/String
    //   71: invokestatic 193	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   74: aload 5
    //   76: ldc 172
    //   78: ldc 173
    //   80: ldc 174
    //   82: ldc 176
    //   84: ldc 178
    //   86: ldc 179
    //   88: invokestatic 197	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   91: iconst_1
    //   92: istore_2
    //   93: iconst_2
    //   94: new 73	java/lang/StringBuilder
    //   97: dup
    //   98: ldc 199
    //   100: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload_0
    //   104: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 201
    //   109: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 64	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   118: iconst_1
    //   119: istore_2
    //   120: iload_2
    //   121: istore_3
    //   122: iload_2
    //   123: ifne +92 -> 215
    //   126: iload_2
    //   127: istore_3
    //   128: aload_1
    //   129: ifnull +86 -> 215
    //   132: iload_2
    //   133: istore_3
    //   134: invokestatic 126	com/tencent/thumbplayer/core/common/TPSystemInfo:getCpuArchitecture	()I
    //   137: bipush 6
    //   139: if_icmplt +76 -> 215
    //   142: iload_2
    //   143: istore_3
    //   144: iconst_2
    //   145: new 73	java/lang/StringBuilder
    //   148: dup
    //   149: ldc 203
    //   151: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload_0
    //   155: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 205
    //   160: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 64	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   169: iload_2
    //   170: istore_3
    //   171: aload_0
    //   172: ldc 2
    //   174: invokevirtual 211	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   177: aload_1
    //   178: invokestatic 217	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:load	(Ljava/lang/String;Ljava/lang/ClassLoader;Landroid/content/Context;)Z
    //   181: istore_2
    //   182: iload_2
    //   183: ifeq +79 -> 262
    //   186: iload_2
    //   187: istore_3
    //   188: iconst_2
    //   189: new 73	java/lang/StringBuilder
    //   192: dup
    //   193: ldc 219
    //   195: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload_0
    //   199: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 221
    //   204: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 64	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   213: iload_2
    //   214: istore_3
    //   215: ldc 158
    //   217: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: iload_3
    //   221: ireturn
    //   222: astore 4
    //   224: iconst_0
    //   225: istore_2
    //   226: iconst_4
    //   227: new 73	java/lang/StringBuilder
    //   230: dup
    //   231: ldc 223
    //   233: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: aload_0
    //   237: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 225
    //   242: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 4
    //   247: invokevirtual 83	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   250: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 64	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   259: goto -139 -> 120
    //   262: iload_2
    //   263: istore_3
    //   264: iconst_4
    //   265: new 73	java/lang/StringBuilder
    //   268: dup
    //   269: ldc 219
    //   271: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   274: aload_0
    //   275: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 227
    //   280: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 64	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   289: iload_2
    //   290: istore_3
    //   291: goto -76 -> 215
    //   294: astore_1
    //   295: iconst_4
    //   296: new 73	java/lang/StringBuilder
    //   299: dup
    //   300: ldc 219
    //   302: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   305: aload_0
    //   306: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc 229
    //   311: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_1
    //   315: invokevirtual 83	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   318: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 64	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   327: goto -112 -> 215
    //   330: astore 4
    //   332: goto -106 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	paramString	String
    //   0	335	1	paramContext	Context
    //   92	198	2	bool1	boolean
    //   121	170	3	bool2	boolean
    //   29	34	4	locala	com.tencent.mm.hellhoundlib.b.a
    //   222	24	4	localObject1	Object
    //   330	1	4	localObject2	Object
    //   38	37	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	91	222	finally
    //   144	169	294	finally
    //   171	182	294	finally
    //   188	213	294	finally
    //   264	289	294	finally
    //   93	118	330	finally
  }
  
  public static void loadLibIfNeeded(Context paramContext)
  {
    AppMethodBeat.i(227653);
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
          AppMethodBeat.o(227653);
          throw paramContext;
        }
      }
      TPNativeLog.printLog(2, "TPNativeLibraryLoader load lib failed");
    }
    AppMethodBeat.o(227653);
  }
  
  public static void setLibLoader(ITPNativeLibraryExternalLoader paramITPNativeLibraryExternalLoader)
  {
    mLibLoader = paramITPNativeLibraryExternalLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPNativeLibraryLoader
 * JD-Core Version:    0.7.0.1
 */