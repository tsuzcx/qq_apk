package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import com.tencent.matrix.hook.HookManager;
import com.tencent.matrix.hook.HookManager.b;
import com.tencent.matrix.hook.pthread.PthreadHook;
import com.tencent.matrix.hook.pthread.PthreadHook.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.x;
import com.tencent.mm.compatible.util.j;
import java.io.File;

public class ThreadStackShinkerWrapper
{
  private static final String DATA_DIR_NAME = "threadstack_shinker";
  private static final String ENABLED_MARK_FILE_NAME = "enabled";
  private static final String IGNORED_PATTERN_FILE_NAME = "ignored_patterns";
  private static final String TAG = "MicroMsg.ThreadStackShinkerWrapper";
  
  private static File getDataStoreDir(Context paramContext)
  {
    AppMethodBeat.i(262217);
    paramContext = paramContext.getDir("threadstack_shinker", 0);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    AppMethodBeat.o(262217);
    return paramContext;
  }
  
  public static boolean isEnabled(Context paramContext)
  {
    AppMethodBeat.i(262215);
    if (!isPreconditionsSatisfied(paramContext))
    {
      AppMethodBeat.o(262215);
      return false;
    }
    boolean bool = new File(getDataStoreDir(paramContext), "enabled").exists();
    AppMethodBeat.o(262215);
    return bool;
  }
  
  private static boolean isPreconditionsSatisfied(Context paramContext)
  {
    return !BuildInfo.IS_ARM64;
  }
  
  /* Error */
  private static void loadIgnoredCreatorSoPatterns(Context paramContext, PthreadHook.a parama)
  {
    // Byte code:
    //   0: ldc 73
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 41	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokestatic 59	com/tencent/mm/sdk/platformtools/ThreadStackShinkerWrapper:getDataStoreDir	(Landroid/content/Context;)Ljava/io/File;
    //   13: ldc 16
    //   15: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore_0
    //   19: new 75	java/io/BufferedReader
    //   22: dup
    //   23: new 77	java/io/FileReader
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 80	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   31: invokespecial 83	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore_3
    //   35: aconst_null
    //   36: astore_2
    //   37: aload_3
    //   38: invokevirtual 87	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore_0
    //   42: aload_0
    //   43: ifnull +75 -> 118
    //   46: aload_0
    //   47: invokevirtual 92	java/lang/String:trim	()Ljava/lang/String;
    //   50: astore_0
    //   51: aload_1
    //   52: aload_0
    //   53: invokevirtual 98	com/tencent/matrix/hook/pthread/PthreadHook$a:ff	(Ljava/lang/String;)Lcom/tencent/matrix/hook/pthread/PthreadHook$a;
    //   56: pop
    //   57: ldc 19
    //   59: ldc 100
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_0
    //   68: aastore
    //   69: invokestatic 106	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: goto -35 -> 37
    //   75: astore_1
    //   76: ldc 73
    //   78: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_1
    //   82: athrow
    //   83: astore_0
    //   84: aload_1
    //   85: ifnull +52 -> 137
    //   88: aload_3
    //   89: invokevirtual 109	java/io/BufferedReader:close	()V
    //   92: ldc 73
    //   94: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: ldc 19
    //   102: aload_0
    //   103: ldc 111
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 114	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: ldc 73
    //   114: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: return
    //   118: aload_3
    //   119: invokevirtual 109	java/io/BufferedReader:close	()V
    //   122: ldc 73
    //   124: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: return
    //   128: astore_2
    //   129: aload_1
    //   130: aload_2
    //   131: invokevirtual 118	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   134: goto -42 -> 92
    //   137: aload_3
    //   138: invokevirtual 109	java/io/BufferedReader:close	()V
    //   141: goto -49 -> 92
    //   144: astore_0
    //   145: aload_2
    //   146: astore_1
    //   147: goto -63 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramContext	Context
    //   0	150	1	parama	PthreadHook.a
    //   36	1	2	localObject	Object
    //   128	18	2	localThrowable	Throwable
    //   34	104	3	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   37	42	75	java/lang/Throwable
    //   46	72	75	java/lang/Throwable
    //   76	83	83	finally
    //   19	35	99	java/lang/Throwable
    //   92	99	99	java/lang/Throwable
    //   118	127	99	java/lang/Throwable
    //   129	134	99	java/lang/Throwable
    //   137	141	99	java/lang/Throwable
    //   88	92	128	java/lang/Throwable
    //   37	42	144	finally
    //   46	72	144	finally
  }
  
  public static void markDisabled(Context paramContext)
  {
    AppMethodBeat.i(262214);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(262214);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), "enabled");
      if ((!paramContext.exists()) || (paramContext.delete()))
      {
        x.a("MicroMsg.ThreadStackShinkerWrapper", "[+] Mark disabled successfully.", new Object[0]);
        AppMethodBeat.o(262214);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      Log.printErrStackTrace("MicroMsg.ThreadStackShinkerWrapper", paramContext, "[-] Fail to mark disabled.", new Object[0]);
      AppMethodBeat.o(262214);
      return;
    }
    x.c("MicroMsg.ThreadStackShinkerWrapper", "[-] Fail to mark disabled.", new Object[0]);
    AppMethodBeat.o(262214);
  }
  
  public static void markEnabled(Context paramContext)
  {
    AppMethodBeat.i(262211);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(262211);
        return;
      }
      x.a("MicroMsg.ThreadStackShinkerWrapper", "[+] markEnabled called.", new Object[0]);
      paramContext = new File(getDataStoreDir(paramContext), "enabled");
      if ((paramContext.exists()) || (paramContext.createNewFile()))
      {
        x.a("MicroMsg.ThreadStackShinkerWrapper", "[+] Mark enabled successfully.", new Object[0]);
        AppMethodBeat.o(262211);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      x.a("MicroMsg.ThreadStackShinkerWrapper", paramContext, "[-] Fail to mark enabled.", new Object[0]);
      AppMethodBeat.o(262211);
      return;
    }
    x.c("MicroMsg.ThreadStackShinkerWrapper", "[-] Fail to mark enabled.", new Object[0]);
    AppMethodBeat.o(262211);
  }
  
  /* Error */
  public static void storeIgnoredCreatorSoPatterns(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 150
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +16 -> 25
    //   12: ldc 19
    //   14: ldc 158
    //   16: invokestatic 162	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 150
    //   21: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: aload_1
    //   26: ldc 164
    //   28: invokevirtual 168	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   31: astore 5
    //   33: aload 5
    //   35: invokestatic 174	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([Ljava/lang/String;)Z
    //   38: ifeq +16 -> 54
    //   41: ldc 19
    //   43: ldc 158
    //   45: invokestatic 162	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: ldc 150
    //   50: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: return
    //   54: new 41	java/io/File
    //   57: dup
    //   58: aload_0
    //   59: invokestatic 59	com/tencent/mm/sdk/platformtools/ThreadStackShinkerWrapper:getDataStoreDir	(Landroid/content/Context;)Ljava/io/File;
    //   62: ldc 16
    //   64: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   67: astore_0
    //   68: new 176	java/io/PrintWriter
    //   71: dup
    //   72: new 178	java/io/FileWriter
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 179	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   80: invokespecial 182	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   83: astore 4
    //   85: aconst_null
    //   86: astore_1
    //   87: aload 5
    //   89: arraylength
    //   90: istore_3
    //   91: iconst_0
    //   92: istore_2
    //   93: iload_2
    //   94: iload_3
    //   95: if_icmpge +36 -> 131
    //   98: aload 5
    //   100: iload_2
    //   101: aaload
    //   102: astore_0
    //   103: ldc 19
    //   105: ldc 184
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: aastore
    //   115: invokestatic 106	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload 4
    //   120: aload_0
    //   121: invokevirtual 188	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   124: iload_2
    //   125: iconst_1
    //   126: iadd
    //   127: istore_2
    //   128: goto -35 -> 93
    //   131: aload 4
    //   133: invokevirtual 189	java/io/PrintWriter:close	()V
    //   136: ldc 150
    //   138: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: return
    //   142: astore_0
    //   143: ldc 19
    //   145: aload_0
    //   146: ldc 191
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 114	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: ldc 150
    //   157: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: return
    //   161: astore_1
    //   162: ldc 150
    //   164: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_1
    //   168: athrow
    //   169: astore_0
    //   170: aload_1
    //   171: ifnull +26 -> 197
    //   174: aload 4
    //   176: invokevirtual 189	java/io/PrintWriter:close	()V
    //   179: ldc 150
    //   181: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_0
    //   185: athrow
    //   186: astore 4
    //   188: aload_1
    //   189: aload 4
    //   191: invokevirtual 118	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   194: goto -15 -> 179
    //   197: aload 4
    //   199: invokevirtual 189	java/io/PrintWriter:close	()V
    //   202: goto -23 -> 179
    //   205: astore_0
    //   206: goto -36 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramContext	Context
    //   0	209	1	paramString	String
    //   92	36	2	i	int
    //   90	6	3	j	int
    //   83	92	4	localPrintWriter	java.io.PrintWriter
    //   186	12	4	localThrowable	Throwable
    //   31	68	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   68	85	142	java/lang/Throwable
    //   131	141	142	java/lang/Throwable
    //   179	186	142	java/lang/Throwable
    //   188	194	142	java/lang/Throwable
    //   197	202	142	java/lang/Throwable
    //   87	91	161	java/lang/Throwable
    //   103	124	161	java/lang/Throwable
    //   162	169	169	finally
    //   174	179	186	java/lang/Throwable
    //   87	91	205	finally
    //   103	124	205	finally
  }
  
  public static void tryToInstall(Context paramContext)
  {
    AppMethodBeat.i(262210);
    if (!isPreconditionsSatisfied(paramContext))
    {
      AppMethodBeat.o(262210);
      return;
    }
    if (!isEnabled(paramContext))
    {
      x.a("MicroMsg.ThreadStackShinkerWrapper", "[+] Not enabled, skip installation.", new Object[0]);
      AppMethodBeat.o(262210);
      return;
    }
    HookManager.cYg.cYk = new HookManager.b()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(261247);
        j.load(paramAnonymousString);
        AppMethodBeat.o(261247);
      }
    };
    try
    {
      PthreadHook.a locala = new PthreadHook.a();
      locala.enabled = true;
      locala = locala.ff(".*/app_tbs/.*").ff(".*/libmttwebview\\.so$").ff(".*/libmtticu\\.so$").ff(".*/libtbs_v8\\.so$").ff(".*/libmagicbrush.so\\.so$");
      loadIgnoredCreatorSoPatterns(paramContext, locala);
      paramContext = HookManager.cYg;
      PthreadHook localPthreadHook = PthreadHook.cYv;
      localPthreadHook.cYz = locala;
      paramContext.a(localPthreadHook).WL();
      x.a("MicroMsg.ThreadStackShinkerWrapper", "[+] install successfully.", new Object[0]);
      AppMethodBeat.o(262210);
      return;
    }
    catch (Throwable paramContext)
    {
      x.a("MicroMsg.ThreadStackShinkerWrapper", paramContext, "[-] install failed.", new Object[0]);
      AppMethodBeat.o(262210);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ThreadStackShinkerWrapper
 * JD-Core Version:    0.7.0.1
 */