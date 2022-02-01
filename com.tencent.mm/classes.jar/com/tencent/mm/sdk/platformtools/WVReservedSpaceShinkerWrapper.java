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
import com.tencent.mm.app.d;
import com.tencent.mm.app.x;
import com.tencent.mm.compatible.util.j;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class WVReservedSpaceShinkerWrapper
{
  private static final String DATA_DIR_NAME = "wv_reserved_space_shinker";
  private static final String ENABLED_MARK_FILE_NAME = "enabled";
  private static final String TAG = "MicroMsg.WVReservedSpaceShinkerWrapper";
  
  /* Error */
  private static int getAndIncEnableCounter(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 26
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 13
    //   10: invokestatic 36	com/tencent/mm/sdk/platformtools/WVReservedSpaceShinkerWrapper:getMarkerFileName	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_2
    //   14: aload_2
    //   15: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +21 -> 39
    //   21: ldc 16
    //   23: ldc 44
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 50	com/tencent/mm/app/x:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: ldc 26
    //   34: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: iconst_m1
    //   38: ireturn
    //   39: new 55	java/io/File
    //   42: dup
    //   43: aload_0
    //   44: invokestatic 59	com/tencent/mm/sdk/platformtools/WVReservedSpaceShinkerWrapper:getDataStoreDir	(Landroid/content/Context;)Ljava/io/File;
    //   47: aload_2
    //   48: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore 4
    //   53: aload 4
    //   55: invokevirtual 66	java/io/File:exists	()Z
    //   58: ifne +21 -> 79
    //   61: ldc 16
    //   63: ldc 68
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 50	com/tencent/mm/app/x:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: ldc 26
    //   74: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_m1
    //   78: ireturn
    //   79: new 70	java/io/DataInputStream
    //   82: dup
    //   83: new 72	java/io/FileInputStream
    //   86: dup
    //   87: aload 4
    //   89: invokespecial 75	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   92: invokespecial 78	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   95: astore 5
    //   97: aload 5
    //   99: invokevirtual 82	java/io/DataInputStream:readInt	()I
    //   102: istore_1
    //   103: aload 5
    //   105: invokevirtual 85	java/io/DataInputStream:close	()V
    //   108: new 87	java/io/DataOutputStream
    //   111: dup
    //   112: new 89	java/io/FileOutputStream
    //   115: dup
    //   116: aload 4
    //   118: invokespecial 90	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: invokespecial 93	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   124: astore 4
    //   126: aload_3
    //   127: astore_0
    //   128: aload 4
    //   130: iload_1
    //   131: iconst_1
    //   132: iadd
    //   133: invokevirtual 96	java/io/DataOutputStream:writeInt	(I)V
    //   136: aload 4
    //   138: invokevirtual 97	java/io/DataOutputStream:close	()V
    //   141: ldc 26
    //   143: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iload_1
    //   147: ireturn
    //   148: astore_2
    //   149: ldc 26
    //   151: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_2
    //   155: athrow
    //   156: astore_0
    //   157: aload_2
    //   158: ifnull +44 -> 202
    //   161: aload 5
    //   163: invokevirtual 85	java/io/DataInputStream:close	()V
    //   166: ldc 26
    //   168: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_0
    //   172: athrow
    //   173: astore_0
    //   174: ldc 16
    //   176: aload_0
    //   177: ldc 99
    //   179: iconst_0
    //   180: anewarray 4	java/lang/Object
    //   183: invokestatic 103	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: iconst_0
    //   187: istore_1
    //   188: goto -80 -> 108
    //   191: astore 5
    //   193: aload_2
    //   194: aload 5
    //   196: invokevirtual 107	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   199: goto -33 -> 166
    //   202: aload 5
    //   204: invokevirtual 85	java/io/DataInputStream:close	()V
    //   207: goto -41 -> 166
    //   210: astore_2
    //   211: aload_2
    //   212: astore_0
    //   213: ldc 26
    //   215: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload_2
    //   219: astore_0
    //   220: aload_2
    //   221: athrow
    //   222: astore_2
    //   223: aload_0
    //   224: ifnull +44 -> 268
    //   227: aload 4
    //   229: invokevirtual 97	java/io/DataOutputStream:close	()V
    //   232: ldc 26
    //   234: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_2
    //   238: athrow
    //   239: astore_0
    //   240: ldc 16
    //   242: aload_0
    //   243: ldc 109
    //   245: iconst_0
    //   246: anewarray 4	java/lang/Object
    //   249: invokestatic 103	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: ldc 26
    //   254: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iconst_m1
    //   258: ireturn
    //   259: astore_3
    //   260: aload_0
    //   261: aload_3
    //   262: invokevirtual 107	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   265: goto -33 -> 232
    //   268: aload 4
    //   270: invokevirtual 97	java/io/DataOutputStream:close	()V
    //   273: goto -41 -> 232
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_2
    //   279: goto -122 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramContext	Context
    //   102	86	1	i	int
    //   13	35	2	str	String
    //   148	46	2	localThrowable1	Throwable
    //   210	11	2	localThrowable2	Throwable
    //   222	16	2	localObject1	Object
    //   278	1	2	localObject2	Object
    //   1	126	3	localObject3	Object
    //   259	3	3	localThrowable3	Throwable
    //   51	218	4	localObject4	Object
    //   95	67	5	localDataInputStream	java.io.DataInputStream
    //   191	12	5	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   97	103	148	java/lang/Throwable
    //   149	156	156	finally
    //   79	97	173	java/lang/Throwable
    //   103	108	173	java/lang/Throwable
    //   166	173	173	java/lang/Throwable
    //   193	199	173	java/lang/Throwable
    //   202	207	173	java/lang/Throwable
    //   161	166	191	java/lang/Throwable
    //   128	136	210	java/lang/Throwable
    //   128	136	222	finally
    //   213	218	222	finally
    //   220	222	222	finally
    //   108	126	239	java/lang/Throwable
    //   136	141	239	java/lang/Throwable
    //   232	239	239	java/lang/Throwable
    //   260	265	239	java/lang/Throwable
    //   268	273	239	java/lang/Throwable
    //   227	232	259	java/lang/Throwable
    //   97	103	276	finally
  }
  
  private static File getDataStoreDir(Context paramContext)
  {
    AppMethodBeat.i(263263);
    paramContext = paramContext.getDir("wv_reserved_space_shinker", 0);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    AppMethodBeat.o(263263);
    return paramContext;
  }
  
  private static String getMarkerFileName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(263264);
    String str2 = d.cQP;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = Util.getProcessNameByPid(paramContext, Process.myPid());
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(263264);
      return null;
    }
    paramContext = str1.replace('.', '_').replace(":", "__") + "_" + paramString;
    AppMethodBeat.o(263264);
    return paramContext;
  }
  
  public static boolean isEnabled(Context paramContext)
  {
    AppMethodBeat.i(263260);
    if (!isPreconditionsSatisfied(paramContext))
    {
      AppMethodBeat.o(263260);
      return false;
    }
    String str = getMarkerFileName(paramContext, "enabled");
    if (!TextUtils.isEmpty(str))
    {
      boolean bool = new File(getDataStoreDir(paramContext), str).exists();
      AppMethodBeat.o(263260);
      return bool;
    }
    x.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Fail to get marker file name, treat as disabled.", new Object[0]);
    AppMethodBeat.o(263260);
    return false;
  }
  
  private static boolean isPreconditionsSatisfied(Context paramContext)
  {
    return !BuildInfo.IS_ARM64;
  }
  
  public static void markDisabled(Context paramContext)
  {
    AppMethodBeat.i(263258);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(263258);
        return;
      }
      String str = getMarkerFileName(paramContext, "enabled");
      if (TextUtils.isEmpty(str))
      {
        x.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Fail to get marker file name, skip marking disabled.", new Object[0]);
        AppMethodBeat.o(263258);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), str);
      if ((!paramContext.exists()) || (paramContext.delete()))
      {
        x.a("MicroMsg.WVReservedSpaceShinkerWrapper", "[+] Mark disabled successfully.", new Object[0]);
        AppMethodBeat.o(263258);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      x.a("MicroMsg.WVReservedSpaceShinkerWrapper", paramContext, "[-] Fail to mark disabled.", new Object[0]);
      AppMethodBeat.o(263258);
      return;
    }
    x.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Fail to mark disabled.", new Object[0]);
    AppMethodBeat.o(263258);
  }
  
  public static void markEnabled(Context paramContext)
  {
    AppMethodBeat.i(263257);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(263257);
        return;
      }
      x.a("MicroMsg.WVReservedSpaceShinkerWrapper", "[+] markEnabled called.", new Object[0]);
      String str = getMarkerFileName(paramContext, "enabled");
      if (TextUtils.isEmpty(str))
      {
        x.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Fail to get marker file name, skip marking enabled.", new Object[0]);
        AppMethodBeat.o(263257);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), str);
      if ((paramContext.exists()) || (paramContext.createNewFile()))
      {
        x.a("MicroMsg.WVReservedSpaceShinkerWrapper", "[+] Mark enabled successfully.", new Object[0]);
        AppMethodBeat.o(263257);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      x.a("MicroMsg.WVReservedSpaceShinkerWrapper", paramContext, "[-] Fail to mark enabled.", new Object[0]);
      AppMethodBeat.o(263257);
      return;
    }
    x.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Fail to mark enabled.", new Object[0]);
    AppMethodBeat.o(263257);
  }
  
  public static void markStartupFine(Context paramContext)
  {
    AppMethodBeat.i(263259);
    resetEnableCounter(paramContext);
    AppMethodBeat.o(263259);
  }
  
  private static void resetEnableCounter(Context paramContext)
  {
    AppMethodBeat.i(263262);
    String str = getMarkerFileName(paramContext, "enabled");
    if (TextUtils.isEmpty(str))
    {
      x.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Fail to get marker file name, skip reset enable counter.", new Object[0]);
      AppMethodBeat.o(263262);
      return;
    }
    paramContext = new File(getDataStoreDir(paramContext), str);
    if (!paramContext.exists())
    {
      x.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Not enabled, skip reset enable counter.", new Object[0]);
      AppMethodBeat.o(263262);
      return;
    }
    try
    {
      DataOutputStream localDataOutputStream = new DataOutputStream(new FileOutputStream(paramContext));
      paramContext = null;
      try
      {
        localDataOutputStream.close();
        AppMethodBeat.o(263262);
        throw localObject;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          paramContext.addSuppressed(localThrowable2);
        }
      }
    }
    catch (Throwable paramContext)
    {
      try
      {
        localDataOutputStream.writeInt(0);
        localDataOutputStream.close();
        AppMethodBeat.o(263262);
        return;
      }
      catch (Throwable localThrowable1)
      {
        paramContext = localThrowable1;
        AppMethodBeat.o(263262);
        paramContext = localThrowable1;
        throw localThrowable1;
      }
      finally
      {
        if (paramContext == null) {
          break label162;
        }
      }
      paramContext = paramContext;
      x.a("MicroMsg.WVReservedSpaceShinkerWrapper", paramContext, "[-] Fail to update marker file.", new Object[0]);
      AppMethodBeat.o(263262);
      return;
    }
    for (;;)
    {
      label162:
      localThrowable2.close();
    }
  }
  
  public static void tryToInstall(Context paramContext)
  {
    AppMethodBeat.i(263255);
    if (!isPreconditionsSatisfied(paramContext))
    {
      x.a("MicroMsg.WVReservedSpaceShinkerWrapper", "[+] Env condition is not satisfied, skip installation.", new Object[0]);
      AppMethodBeat.o(263255);
      return;
    }
    if (!isEnabled(paramContext))
    {
      x.a("MicroMsg.WVReservedSpaceShinkerWrapper", "[+] Not enabled, skip installation.", new Object[0]);
      AppMethodBeat.o(263255);
      return;
    }
    if (getAndIncEnableCounter(paramContext) >= 3)
    {
      x.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] Startup failure count was out of limit, mark disable and skip installation.", new Object[0]);
      markDisabled(paramContext);
      AppMethodBeat.o(263255);
      return;
    }
    StartupILogsReport.reportNumericValue(paramContext, -536739839, Integer.valueOf(1));
    HookManager.cYg.cYk = new HookManager.b()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(261882);
        j.load(paramAnonymousString);
        AppMethodBeat.o(261882);
      }
    };
    try
    {
      HookManager.cYg.a(WVPreAllocHook.cYu).WL();
      if (WVPreAllocHook.cYu.cXZ == a.a.cYb)
      {
        x.a("MicroMsg.WVReservedSpaceShinkerWrapper", "[+] install successfully.", new Object[0]);
        StartupILogsReport.reportNumericValue(paramContext, -536739839, Integer.valueOf(2));
        AppMethodBeat.o(263255);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      x.a("MicroMsg.WVReservedSpaceShinkerWrapper", localThrowable, "[-] install failed.", new Object[0]);
      StartupILogsReport.reportNumericValue(paramContext, -536739839, Integer.valueOf(3));
      AppMethodBeat.o(263255);
      return;
    }
    x.c("MicroMsg.WVReservedSpaceShinkerWrapper", "[-] install failed.", new Object[0]);
    StartupILogsReport.reportNumericValue(paramContext, -536739839, Integer.valueOf(3));
    AppMethodBeat.o(263255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WVReservedSpaceShinkerWrapper
 * JD-Core Version:    0.7.0.1
 */