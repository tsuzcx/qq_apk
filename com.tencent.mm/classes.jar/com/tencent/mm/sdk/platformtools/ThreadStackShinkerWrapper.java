package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.hook.HookManager;
import com.tencent.matrix.hook.HookManager.b;
import com.tencent.matrix.hook.pthread.PthreadHook;
import com.tencent.matrix.hook.pthread.PthreadHook.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.aa;
import com.tencent.mm.compatible.util.k;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ThreadStackShinkerWrapper
{
  private static final String DATA_DIR_NAME = "threadstack_shinker";
  private static final String ENABLED_MARK_FILE_NAME = "enabled";
  private static final String IGNORED_PATTERN_FILE_NAME = "ignored_patterns";
  private static final String TAG = "MicroMsg.ThreadStackShinkerWrapper";
  
  private static File getDataStoreDir(Context paramContext)
  {
    AppMethodBeat.i(243892);
    paramContext = paramContext.getDir("threadstack_shinker", 0);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    AppMethodBeat.o(243892);
    return paramContext;
  }
  
  public static boolean isEnabled(Context paramContext)
  {
    AppMethodBeat.i(243890);
    if (!isPreconditionsSatisfied(paramContext))
    {
      AppMethodBeat.o(243890);
      return false;
    }
    boolean bool = new File(getDataStoreDir(paramContext), "enabled").exists();
    AppMethodBeat.o(243890);
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
    //   0: ldc 71
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 41	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokestatic 59	com/tencent/mm/sdk/platformtools/ThreadStackShinkerWrapper:getDataStoreDir	(Landroid/content/Context;)Ljava/io/File;
    //   13: ldc 16
    //   15: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore_0
    //   19: new 73	java/io/BufferedReader
    //   22: dup
    //   23: new 75	java/io/FileReader
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 78	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   31: invokespecial 81	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore_0
    //   35: aload_0
    //   36: invokevirtual 85	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull +63 -> 104
    //   44: aload_2
    //   45: invokevirtual 90	java/lang/String:trim	()Ljava/lang/String;
    //   48: astore_2
    //   49: aload_1
    //   50: aload_2
    //   51: invokevirtual 96	com/tencent/matrix/hook/pthread/PthreadHook$a:gD	(Ljava/lang/String;)Lcom/tencent/matrix/hook/pthread/PthreadHook$a;
    //   54: pop
    //   55: ldc 19
    //   57: ldc 98
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_2
    //   66: aastore
    //   67: invokestatic 104	com/tencent/mm/app/aa:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: goto -35 -> 35
    //   73: astore_1
    //   74: aload_0
    //   75: invokevirtual 107	java/io/BufferedReader:close	()V
    //   78: ldc 71
    //   80: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_1
    //   84: athrow
    //   85: astore_0
    //   86: ldc 19
    //   88: aload_0
    //   89: ldc 109
    //   91: iconst_0
    //   92: anewarray 4	java/lang/Object
    //   95: invokestatic 112	com/tencent/mm/app/aa:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: ldc 71
    //   100: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: return
    //   104: aload_0
    //   105: invokevirtual 107	java/io/BufferedReader:close	()V
    //   108: ldc 71
    //   110: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: astore_0
    //   115: aload_1
    //   116: aload_0
    //   117: invokevirtual 118	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   120: goto -42 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramContext	Context
    //   0	123	1	parama	PthreadHook.a
    //   39	27	2	str	String
    // Exception table:
    //   from	to	target	type
    //   35	40	73	finally
    //   44	70	73	finally
    //   19	35	85	finally
    //   78	85	85	finally
    //   104	113	85	finally
    //   115	120	85	finally
    //   74	78	114	finally
  }
  
  public static void markDisabled(Context paramContext)
  {
    AppMethodBeat.i(243883);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(243883);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), "enabled");
      if ((!paramContext.exists()) || (paramContext.delete()))
      {
        aa.a("MicroMsg.ThreadStackShinkerWrapper", "[+] Mark disabled successfully.", new Object[0]);
        AppMethodBeat.o(243883);
        return;
      }
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.ThreadStackShinkerWrapper", paramContext, "[-] Fail to mark disabled.", new Object[0]);
      AppMethodBeat.o(243883);
      return;
    }
    aa.c("MicroMsg.ThreadStackShinkerWrapper", "[-] Fail to mark disabled.", new Object[0]);
    AppMethodBeat.o(243883);
  }
  
  public static void markEnabled(Context paramContext)
  {
    AppMethodBeat.i(243870);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(243870);
        return;
      }
      aa.a("MicroMsg.ThreadStackShinkerWrapper", "[+] markEnabled called.", new Object[0]);
      paramContext = new File(getDataStoreDir(paramContext), "enabled");
      if ((paramContext.exists()) || (paramContext.createNewFile()))
      {
        aa.a("MicroMsg.ThreadStackShinkerWrapper", "[+] Mark enabled successfully.", new Object[0]);
        AppMethodBeat.o(243870);
        return;
      }
    }
    finally
    {
      aa.a("MicroMsg.ThreadStackShinkerWrapper", paramContext, "[-] Fail to mark enabled.", new Object[0]);
      AppMethodBeat.o(243870);
      return;
    }
    aa.c("MicroMsg.ThreadStackShinkerWrapper", "[-] Fail to mark enabled.", new Object[0]);
    AppMethodBeat.o(243870);
  }
  
  public static void storeIgnoredCreatorSoPatterns(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243880);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.ThreadStackShinkerWrapper", "patterns is empty or null, skip processing.");
      AppMethodBeat.o(243880);
      return;
    }
    paramString = paramString.split("\\s*(?<!\\\\),\\s*");
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ThreadStackShinkerWrapper", "patterns is empty or null, skip processing.");
      AppMethodBeat.o(243880);
      return;
    }
    paramContext = new File(getDataStoreDir(paramContext), "ignored_patterns");
    try
    {
      paramContext = new PrintWriter(new FileWriter(paramContext));
      try
      {
        int j;
        int i;
        String str;
        paramContext.close();
        AppMethodBeat.o(243880);
        throw paramString;
      }
      finally
      {
        paramString.addSuppressed(paramContext);
      }
    }
    finally
    {
      try
      {
        j = paramString.length;
        i = 0;
        while (i < j)
        {
          str = paramString[i];
          aa.a("MicroMsg.ThreadStackShinkerWrapper", "Pattern: %s was stored.", new Object[] { str });
          paramContext.println(str);
          i += 1;
        }
        paramContext.close();
        AppMethodBeat.o(243880);
        return;
      }
      finally {}
      paramContext = finally;
      aa.a("MicroMsg.ThreadStackShinkerWrapper", paramContext, "Fail to store ignored creator so patterns.", new Object[0]);
      AppMethodBeat.o(243880);
      return;
    }
  }
  
  public static void tryToInstall(Context paramContext)
  {
    AppMethodBeat.i(243864);
    if (!isPreconditionsSatisfied(paramContext))
    {
      AppMethodBeat.o(243864);
      return;
    }
    if (!isEnabled(paramContext))
    {
      aa.a("MicroMsg.ThreadStackShinkerWrapper", "[+] Not enabled, skip installation.", new Object[0]);
      AppMethodBeat.o(243864);
      return;
    }
    HookManager.eUL.eUQ = new HookManager.b()
    {
      public void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(243521);
        k.load(paramAnonymousString);
        AppMethodBeat.o(243521);
      }
    };
    try
    {
      PthreadHook.a locala = new PthreadHook.a();
      locala.enabled = true;
      locala = locala.gD(".*/app_tbs/.*").gD(".*/libmttwebview\\.so$").gD(".*/libmtticu\\.so$").gD(".*/libtbs_v8\\.so$").gD(".*/libmagicbrush\\.so$").gD(".*/lib.*webview.*\\.so$").gD(".*/libc\\.so$");
      loadIgnoredCreatorSoPatterns(paramContext, locala);
      paramContext = HookManager.eUL;
      PthreadHook localPthreadHook = PthreadHook.eVl;
      localPthreadHook.eVp = locala;
      paramContext.a(localPthreadHook).axJ();
      aa.a("MicroMsg.ThreadStackShinkerWrapper", "[+] install successfully.", new Object[0]);
      AppMethodBeat.o(243864);
      return;
    }
    finally
    {
      aa.a("MicroMsg.ThreadStackShinkerWrapper", paramContext, "[-] install failed.", new Object[0]);
      AppMethodBeat.o(243864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ThreadStackShinkerWrapper
 * JD-Core Version:    0.7.0.1
 */