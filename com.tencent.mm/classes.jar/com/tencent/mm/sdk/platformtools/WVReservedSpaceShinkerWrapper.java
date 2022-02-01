package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.hook.HookManager;
import com.tencent.matrix.hook.HookManager.b;
import com.tencent.matrix.hook.a;
import com.tencent.matrix.hook.a.a;
import com.tencent.matrix.hook.memory.WVPreAllocHook;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.aa;
import com.tencent.mm.app.e;
import com.tencent.mm.compatible.util.k;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

public class WVReservedSpaceShinkerWrapper
{
  private static final String DATA_DIR_NAME = "wv_reserved_space_shinker";
  private static final String ENABLED_MARK_FILE_NAME = "enabled";
  private static final PeriodRecorder REPORT_FREQ_LIMIT;
  private static final String TAG = "MicroMsg.WVReservedSpaceShinkerWrapper";
  
  static
  {
    AppMethodBeat.i(243473);
    REPORT_FREQ_LIMIT = new PeriodRecorder("wv_rss_rpt", TimeUnit.HOURS.toMillis(24L), true, true);
    AppMethodBeat.o(243473);
  }
  
  /* Error */
  private static int getAndIncEnableCounter(Context paramContext)
  {
    // Byte code:
    //   0: ldc 58
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 13
    //   8: invokestatic 62	com/tencent/mm/sdk/platformtools/WVReservedSpaceShinkerWrapper:getMarkerFileName	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_2
    //   12: aload_2
    //   13: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +21 -> 37
    //   19: ldc 18
    //   21: ldc 70
    //   23: iconst_0
    //   24: anewarray 4	java/lang/Object
    //   27: invokestatic 76	com/tencent/mm/app/aa:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: ldc 58
    //   32: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_m1
    //   36: ireturn
    //   37: new 78	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: invokestatic 82	com/tencent/mm/sdk/platformtools/WVReservedSpaceShinkerWrapper:getDataStoreDir	(Landroid/content/Context;)Ljava/io/File;
    //   45: aload_2
    //   46: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 89	java/io/File:exists	()Z
    //   54: ifne +21 -> 75
    //   57: ldc 18
    //   59: ldc 91
    //   61: iconst_0
    //   62: anewarray 4	java/lang/Object
    //   65: invokestatic 76	com/tencent/mm/app/aa:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: ldc 58
    //   70: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iconst_m1
    //   74: ireturn
    //   75: new 93	java/io/DataInputStream
    //   78: dup
    //   79: new 95	java/io/FileInputStream
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: invokespecial 101	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   90: astore_3
    //   91: aload_3
    //   92: invokevirtual 105	java/io/DataInputStream:readInt	()I
    //   95: istore_1
    //   96: aload_3
    //   97: invokevirtual 108	java/io/DataInputStream:close	()V
    //   100: new 110	java/io/DataOutputStream
    //   103: dup
    //   104: new 112	java/io/FileOutputStream
    //   107: dup
    //   108: aload_0
    //   109: invokespecial 113	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   112: invokespecial 116	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   115: astore_2
    //   116: aload_2
    //   117: iload_1
    //   118: iconst_1
    //   119: iadd
    //   120: invokevirtual 119	java/io/DataOutputStream:writeInt	(I)V
    //   123: aload_2
    //   124: invokevirtual 120	java/io/DataOutputStream:close	()V
    //   127: ldc 58
    //   129: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iload_1
    //   133: ireturn
    //   134: astore_2
    //   135: aload_3
    //   136: invokevirtual 108	java/io/DataInputStream:close	()V
    //   139: ldc 58
    //   141: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_2
    //   145: athrow
    //   146: astore_2
    //   147: ldc 18
    //   149: aload_2
    //   150: ldc 122
    //   152: iconst_0
    //   153: anewarray 4	java/lang/Object
    //   156: invokestatic 126	com/tencent/mm/app/aa:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: iconst_0
    //   160: istore_1
    //   161: goto -61 -> 100
    //   164: astore_3
    //   165: aload_2
    //   166: aload_3
    //   167: invokevirtual 132	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   170: goto -31 -> 139
    //   173: astore_0
    //   174: aload_2
    //   175: invokevirtual 120	java/io/DataOutputStream:close	()V
    //   178: ldc 58
    //   180: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_0
    //   184: athrow
    //   185: astore_0
    //   186: ldc 18
    //   188: aload_0
    //   189: ldc 134
    //   191: iconst_0
    //   192: anewarray 4	java/lang/Object
    //   195: invokestatic 126	com/tencent/mm/app/aa:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: ldc 58
    //   200: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: iconst_m1
    //   204: ireturn
    //   205: astore_2
    //   206: aload_0
    //   207: aload_2
    //   208: invokevirtual 132	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   211: goto -33 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramContext	Context
    //   95	66	1	i	int
    //   11	113	2	localObject1	Object
    //   134	11	2	localObject2	Object
    //   146	29	2	localThrowable1	Throwable
    //   205	3	2	localThrowable2	Throwable
    //   90	46	3	localDataInputStream	java.io.DataInputStream
    //   164	3	3	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   91	96	134	finally
    //   75	91	146	finally
    //   96	100	146	finally
    //   139	146	146	finally
    //   165	170	146	finally
    //   135	139	164	finally
    //   116	123	173	finally
    //   100	116	185	finally
    //   123	127	185	finally
    //   178	185	185	finally
    //   206	211	185	finally
    //   174	178	205	finally
  }
  
  private static File getDataStoreDir(Context paramContext)
  {
    AppMethodBeat.i(243463);
    paramContext = paramContext.getDir("wv_reserved_space_shinker", 0);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    AppMethodBeat.o(243463);
    return paramContext;
  }
  
  private static String getMarkerFileName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243466);
    String str2 = e.eMg;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = Util.getProcessNameByPid(paramContext, Process.myPid());
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(243466);
      return null;
    }
    paramContext = str1.replace('.', '_').replace(":", "__") + "_" + paramString;
    AppMethodBeat.o(243466);
    return paramContext;
  }
  
  public static boolean isEnabled(Context paramContext)
  {
    AppMethodBeat.i(243436);
    if (!isPreconditionsSatisfied(paramContext))
    {
      AppMethodBeat.o(243436);
      return false;
    }
    String str = getMarkerFileName(paramContext, "enabled");
    if (!TextUtils.isEmpty(str))
    {
      boolean bool = new File(getDataStoreDir(paramContext), str).exists();
      AppMethodBeat.o(243436);
      return bool;
    }
    aa.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Fail to get marker file name, treat as disabled.", new Object[0]);
    AppMethodBeat.o(243436);
    return false;
  }
  
  private static boolean isPreconditionsSatisfied(Context paramContext)
  {
    return !BuildInfo.IS_ARM64;
  }
  
  public static void markDisabled(Context paramContext)
  {
    AppMethodBeat.i(243427);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(243427);
        return;
      }
      String str = getMarkerFileName(paramContext, "enabled");
      if (TextUtils.isEmpty(str))
      {
        aa.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Fail to get marker file name, skip marking disabled.", new Object[0]);
        AppMethodBeat.o(243427);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), str);
      if ((!paramContext.exists()) || (paramContext.delete()))
      {
        aa.a("MicroMsg.WVReservedSpaceShinkerWrapper", "[+] Mark disabled successfully.", new Object[0]);
        AppMethodBeat.o(243427);
        return;
      }
    }
    finally
    {
      aa.a("MicroMsg.WVReservedSpaceShinkerWrapper", paramContext, "[-] Fail to mark disabled.", new Object[0]);
      AppMethodBeat.o(243427);
      return;
    }
    aa.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Fail to mark disabled.", new Object[0]);
    AppMethodBeat.o(243427);
  }
  
  public static void markEnabled(Context paramContext)
  {
    AppMethodBeat.i(243423);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(243423);
        return;
      }
      aa.a("MicroMsg.WVReservedSpaceShinkerWrapper", "[+] markEnabled called.", new Object[0]);
      String str = getMarkerFileName(paramContext, "enabled");
      if (TextUtils.isEmpty(str))
      {
        aa.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Fail to get marker file name, skip marking enabled.", new Object[0]);
        AppMethodBeat.o(243423);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), str);
      if ((paramContext.exists()) || (paramContext.createNewFile()))
      {
        aa.a("MicroMsg.WVReservedSpaceShinkerWrapper", "[+] Mark enabled successfully.", new Object[0]);
        AppMethodBeat.o(243423);
        return;
      }
    }
    finally
    {
      aa.a("MicroMsg.WVReservedSpaceShinkerWrapper", paramContext, "[-] Fail to mark enabled.", new Object[0]);
      AppMethodBeat.o(243423);
      return;
    }
    aa.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Fail to mark enabled.", new Object[0]);
    AppMethodBeat.o(243423);
  }
  
  public static void markStartupFine(Context paramContext)
  {
    AppMethodBeat.i(243431);
    resetEnableCounter(paramContext);
    AppMethodBeat.o(243431);
  }
  
  private static void resetEnableCounter(Context paramContext)
  {
    AppMethodBeat.i(243456);
    localObject = getMarkerFileName(paramContext, "enabled");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      aa.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Fail to get marker file name, skip reset enable counter.", new Object[0]);
      AppMethodBeat.o(243456);
      return;
    }
    paramContext = new File(getDataStoreDir(paramContext), (String)localObject);
    if (!paramContext.exists())
    {
      aa.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Not enabled, skip reset enable counter.", new Object[0]);
      AppMethodBeat.o(243456);
      return;
    }
    try
    {
      localObject = new DataOutputStream(new FileOutputStream(paramContext));
      try
      {
        ((DataOutputStream)localObject).close();
        AppMethodBeat.o(243456);
        throw paramContext;
      }
      finally
      {
        paramContext.addSuppressed(localThrowable);
      }
    }
    finally
    {
      try
      {
        ((DataOutputStream)localObject).writeInt(0);
        ((DataOutputStream)localObject).close();
        AppMethodBeat.o(243456);
        return;
      }
      finally {}
      paramContext = finally;
      aa.a("MicroMsg.WVReservedSpaceShinkerWrapper", paramContext, "[-] Fail to update marker file.", new Object[0]);
      AppMethodBeat.o(243456);
      return;
    }
  }
  
  public static void tryToInstall(Context paramContext)
  {
    AppMethodBeat.i(243417);
    if (!isPreconditionsSatisfied(paramContext))
    {
      aa.a("MicroMsg.WVReservedSpaceShinkerWrapper", "[+] Env condition is not satisfied, skip installation.", new Object[0]);
      AppMethodBeat.o(243417);
      return;
    }
    if (!isEnabled(paramContext))
    {
      aa.a("MicroMsg.WVReservedSpaceShinkerWrapper", "[+] Not enabled, skip installation.", new Object[0]);
      AppMethodBeat.o(243417);
      return;
    }
    if (getAndIncEnableCounter(paramContext) >= 3)
    {
      aa.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Startup failure count was out of limit, mark disable and skip installation.", new Object[0]);
      markDisabled(paramContext);
      AppMethodBeat.o(243417);
      return;
    }
    HookManager.eUL.eUQ = new HookManager.b()
    {
      public void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(243743);
        k.load(paramAnonymousString);
        AppMethodBeat.o(243743);
      }
    };
    try
    {
      HookManager.eUL.a(WVPreAllocHook.eVk).axJ();
      if (WVPreAllocHook.eVk.eUE == a.a.eUG)
      {
        aa.a("MicroMsg.WVReservedSpaceShinkerWrapper", "[+] install successfully.", new Object[0]);
        if (!REPORT_FREQ_LIMIT.isExpired("do_rpt")) {
          break label271;
        }
        StartupILogsReport.reportNumericValue(paramContext, -536739839, Integer.valueOf(1));
        StartupILogsReport.reportNumericValue(paramContext, -536739839, Integer.valueOf(2));
        AppMethodBeat.o(243417);
        return;
      }
    }
    finally
    {
      aa.a("MicroMsg.WVReservedSpaceShinkerWrapper", localThrowable, "[-] install failed.", new Object[0]);
      if (REPORT_FREQ_LIMIT.isExpired("do_rpt"))
      {
        StartupILogsReport.reportNumericValue(paramContext, -536739839, Integer.valueOf(1));
        StartupILogsReport.reportNumericValue(paramContext, -536739839, Integer.valueOf(3));
      }
      AppMethodBeat.o(243417);
      return;
    }
    aa.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] install failed.", new Object[0]);
    if (REPORT_FREQ_LIMIT.isExpired("do_rpt"))
    {
      StartupILogsReport.reportNumericValue(paramContext, -536739839, Integer.valueOf(1));
      StartupILogsReport.reportNumericValue(paramContext, -536739839, Integer.valueOf(3));
    }
    label271:
    AppMethodBeat.o(243417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WVReservedSpaceShinkerWrapper
 * JD-Core Version:    0.7.0.1
 */