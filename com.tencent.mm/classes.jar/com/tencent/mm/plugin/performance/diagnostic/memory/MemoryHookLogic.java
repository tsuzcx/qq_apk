package com.tencent.mm.plugin.performance.diagnostic.memory;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.performance.jni.memory.MemoryHook;
import com.tencent.mm.plugin.performance.diagnostic.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import com.tencent.mmkv.MMKV;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import junit.framework.Assert;

public class MemoryHookLogic
  extends a
{
  public static String TAG;
  private static final e vAP;
  private static final e vAQ;
  public aw vAu;
  
  static
  {
    AppMethodBeat.i(124967);
    TAG = "MicroMsg.MemoryHookLogic";
    String str2 = ai.getProcessName();
    String str1 = "MM_";
    if (str2.contains(":tools"))
    {
      str1 = "tools_";
      TAG += ":tools";
    }
    for (;;)
    {
      str2 = ai.getContext().getFilesDir().getAbsolutePath() + "/memory_hook";
      str1 = str2 + "/" + str1 + Process.myPid() + "_memory_hook.log";
      vAP = new e(str2);
      vAQ = new e(str1);
      ac.d(TAG, "init dump file dir = %s", new Object[] { str2 });
      ac.i(TAG, "init dump file path = %s", new Object[] { str1 });
      AppMethodBeat.o(124967);
      return;
      if (str2.contains(":appbrand0"))
      {
        str1 = "appbrand0_";
        TAG += ":appbrand0";
      }
      else if (str2.contains(":appbrand1"))
      {
        str1 = "appbrand1_";
        TAG += ":appbrand1";
      }
      else if (str2.contains(":appbrand2"))
      {
        str1 = "appbrand2_";
        TAG += ":appbrand2";
      }
      else if (str2.contains(":appbrand3"))
      {
        str1 = "appbrand3_";
        TAG += ":appbrand3";
      }
      else if (str2.contains(":appbrand4"))
      {
        str1 = "appbrand4_";
        TAG += ":appbrand4";
      }
    }
  }
  
  public MemoryHookLogic()
  {
    AppMethodBeat.i(124959);
    this.vAu = aw.aKT("diagnostic_memory_hook_stg");
    AppMethodBeat.o(124959);
  }
  
  public static void report()
  {
    AppMethodBeat.i(124961);
    MemoryHookReporter.report();
    AppMethodBeat.o(124961);
  }
  
  public static String wi(long paramLong)
  {
    AppMethodBeat.i(124962);
    String str = new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date(paramLong));
    AppMethodBeat.o(124962);
    return str;
  }
  
  public final void aq(Map<String, String> paramMap)
  {
    AppMethodBeat.i(124960);
    ac.i(TAG, "onReceiveIpxxCmd:[%s]", new Object[] { paramMap });
    boolean bool2 = this.vAu.decodeBool("MH_KEY_ENABLE_BOOLEAN", false);
    boolean bool1 = this.vAu.decodeBool("MH_KEY_EXPT_ENABLE_BOOLEAN", true);
    ac.d(TAG, "isExptEnabled = ".concat(String.valueOf(bool1)));
    if (("1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$expt"))) && ((!bool1) || (bool2)))
    {
      localObject = TAG;
      paramMap = paramMap.get(".cmd.diagnostic.MemoryHook" + ".$expt");
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        ac.i((String)localObject, "skip config from expt cause [.$expt = %s && (!isExptEnabled = %s || isEnabledNow = %s)]", new Object[] { paramMap, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(124960);
        return;
      }
    }
    if ((paramMap.get(".cmd.diagnostic.MemoryHook" + ".$enableExpt") == null) || ("1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$enableExpt")))) {}
    String str;
    for (bool1 = true;; bool1 = false)
    {
      this.vAu.encode("MH_KEY_EXPT_ENABLE_BOOLEAN", bool1);
      ac.d(TAG, "cmd enableExpt = %s, expt = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf("1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$expt"))) });
      bool1 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$enable"));
      this.vAu.encode("MH_KEY_ENABLE_BOOLEAN", bool1);
      if (!bool1) {
        break label1300;
      }
      str = (String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$hook");
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      ac.e(TAG, "ERROR(MemoryHook): hook regex is blank");
      AppMethodBeat.o(124960);
      return;
    }
    Object localObject = (String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$ignore");
    bool1 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$stack"));
    int i = bs.getInt((String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$min"), 0);
    int j = bs.getInt((String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$max"), 0);
    double d = bs.getDouble((String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$sampling"), 1.0D);
    int k = bs.getInt((String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$duration"), 0);
    boolean bool3 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$multiprocess"));
    boolean bool4 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$force"));
    boolean bool5 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$extreme"));
    boolean bool6 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$mmap"));
    this.vAu.encode("MH_KEY_HOOK_SO_STRING", str);
    this.vAu.encode("MH_KEY_IGNORE_SO_STRING", (String)localObject);
    this.vAu.encode("MH_KEY_ENABLE_STACKTRACE_BOOLEAN", bool1);
    this.vAu.encode("MH_KEY_MIN_TRACE_SIZE_INT", i);
    this.vAu.encode("MH_KEY_MAX_TRACE_SIZE_INT", j);
    paramMap = this.vAu;
    if (paramMap.A("MH_KEY_SAMPLING_DOUBLE", Double.valueOf(d))) {
      paramMap.GsS.encode("MH_KEY_SAMPLING_DOUBLE", d);
    }
    this.vAu.encode("MH_KEY_DURATION_MILLIS_LONG", k * 60 * 60 * 1000L);
    this.vAu.encode("MH_KEY_MULTI_PROCESS_BOOLEAN", bool3);
    this.vAu.encode("MH_KEY_BEGIN_TIME_LONG", -1L);
    this.vAu.encode("MH_KEY_EXTREME_BOOLEAN", bool5);
    this.vAu.encode("MH_KEY_ENABLE_MMAP_BOOLEAN", bool6);
    paramMap = (Map<String, String>)localObject;
    if (!bool5)
    {
      if (localObject == null) {
        paramMap = ".*libutils\\.so$;.*libcutils\\.so$;.*libskia\\.so$;.*libbinder.*\\.so$;.*libhwbinder\\.so$;.*libicuuc\\.so$;.*libicui18n\\.so$;.*libart.*\\.so$;.*libandroidfw\\.so$;.*libandroid_runtime\\.so$;.*libjavacore\\.so$;.*libopenjdk.*\\.so$;";
      }
    }
    else
    {
      if (((bool2) && (!bool4)) || (!doh())) {
        break label1300;
      }
      ac.i(TAG, "hook immediately");
      Assert.assertNotNull(str);
      localObject = str.split(";");
      if (paramMap != null) {
        break label1274;
      }
    }
    label1274:
    for (paramMap = new String[0];; paramMap = paramMap.split(";"))
    {
      ac.i(TAG, "hookRegex = %s", new Object[] { Arrays.toString((Object[])localObject) });
      ac.i(TAG, "ignoreRegex = %s", new Object[] { Arrays.toString(paramMap) });
      try
      {
        MemoryHook.INSTANCE.addHookSo((String[])localObject).addIgnoreSo(paramMap).enableStacktrace(bool1).minTraceSize(i).maxTraceSize(j).sampling(d).enableMmapHook(bool6).hook();
        this.vAu.encode("MH_KEY_BEGIN_TIME_LONG", System.currentTimeMillis());
        ac.i(TAG, "register Reporter");
        MemoryHookReporter.install();
        dog();
        com.tencent.mm.plugin.report.service.h.wUl.f(18261, new Object[] { ai.getProcessName(), Integer.valueOf(Process.myPid()), Integer.valueOf(1) });
        AppMethodBeat.o(124960);
        return;
      }
      catch (Throwable paramMap)
      {
        ac.printErrStackTrace(TAG, paramMap, "MemoryHook Error", new Object[0]);
      }
      paramMap = (Map<String, String>)localObject;
      if (!((String)localObject).endsWith(";")) {
        paramMap = (String)localObject + ";";
      }
      paramMap = paramMap + ".*libutils\\.so$;.*libcutils\\.so$;.*libskia\\.so$;.*libbinder.*\\.so$;.*libhwbinder\\.so$;.*libicuuc\\.so$;.*libicui18n\\.so$;.*libart.*\\.so$;.*libandroidfw\\.so$;.*libandroid_runtime\\.so$;.*libjavacore\\.so$;.*libopenjdk.*\\.so$;";
      break;
    }
    label1300:
    AppMethodBeat.o(124960);
  }
  
  public final String dob()
  {
    return ".cmd.diagnostic.MemoryHook";
  }
  
  public final void dog()
  {
    AppMethodBeat.i(124963);
    final String str = TAG + "-repeat";
    com.tencent.e.h.JZN.aTz(str);
    com.tencent.e.h.JZN.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124951);
        if (MemoryHookLogic.a(MemoryHookLogic.this).decodeBool("MH_KEY_ENABLE_BOOLEAN", false))
        {
          MemoryHookLogic.report();
          com.tencent.e.h.JZN.a(this, 1800000L, str);
        }
        AppMethodBeat.o(124951);
      }
    }, 1800000L, str);
    AppMethodBeat.o(124963);
  }
  
  public final boolean doh()
  {
    AppMethodBeat.i(124964);
    String str = ai.getProcessName();
    boolean bool = this.vAu.decodeBool("MH_KEY_MULTI_PROCESS_BOOLEAN", false);
    ac.i(TAG, "enable multiProcess = %s", new Object[] { Boolean.valueOf(bool) });
    if ((ai.cin()) || ((bool) && ((str.endsWith(":tools")) || (str.contains(":appbrand")))))
    {
      AppMethodBeat.o(124964);
      return true;
    }
    AppMethodBeat.o(124964);
    return false;
  }
  
  public static final class MemoryHookReporter
    extends BroadcastReceiver
  {
    private static final String vAT;
    private static MemoryHookReporter vAU;
    
    static
    {
      AppMethodBeat.i(124958);
      vAT = MemoryHookLogic.TAG + "-reporter";
      vAU = null;
      AppMethodBeat.o(124958);
    }
    
    static void doj()
    {
      AppMethodBeat.i(124956);
      Intent localIntent = new Intent("com.tencent.mm.memoryhook.dump");
      localIntent.putExtra("op", 1);
      localIntent.putExtra("log_file", q.B(MemoryHookLogic.doi().fxV()));
      ai.getContext().sendBroadcast(localIntent);
      AppMethodBeat.o(124956);
    }
    
    /* Error */
    public static void install()
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 99
      //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: getstatic 44	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:vAU	Lcom/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter;
      //   11: ifnull +12 -> 23
      //   14: ldc 99
      //   16: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: ldc 2
      //   21: monitorexit
      //   22: return
      //   23: new 2	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter
      //   26: dup
      //   27: invokespecial 100	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:<init>	()V
      //   30: putstatic 44	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:vAU	Lcom/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter;
      //   33: new 102	android/content/IntentFilter
      //   36: dup
      //   37: ldc 55
      //   39: invokespecial 103	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
      //   42: astore_0
      //   43: invokestatic 91	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
      //   46: getstatic 44	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:vAU	Lcom/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter;
      //   49: aload_0
      //   50: ldc 105
      //   52: aconst_null
      //   53: invokevirtual 109	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
      //   56: pop
      //   57: ldc 99
      //   59: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   62: goto -43 -> 19
      //   65: astore_0
      //   66: ldc 2
      //   68: monitorexit
      //   69: aload_0
      //   70: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   42	8	0	localIntentFilter	android.content.IntentFilter
      //   65	5	0	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   3	19	65	finally
      //   23	62	65	finally
    }
    
    static void report()
    {
      AppMethodBeat.i(124955);
      Intent localIntent = new Intent("com.tencent.mm.memoryhook.dump");
      localIntent.putExtra("op", 0);
      ai.getContext().sendBroadcast(localIntent);
      AppMethodBeat.o(124955);
    }
    
    public final void onReceive(final Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(124957);
      final int i = paramIntent.getIntExtra("op", 0);
      paramContext = paramIntent.getStringExtra("log_file");
      com.tencent.e.h.JZN.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124953);
          switch (i)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(124953);
            return;
            ac.i(MemoryHookLogic.TAG, "current process...[%s]", new Object[] { ai.getProcessName() });
            MemoryHookLogic.access$300();
            MemoryHookLogic.MemoryHookReporter.doj();
            AppMethodBeat.o(124953);
            return;
            if (!ai.cin())
            {
              AppMethodBeat.o(124953);
              return;
            }
            MemoryHookLogic.Q(new e(paramContext));
          }
        }
      }, vAT);
      AppMethodBeat.o(124957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.memory.MemoryHookLogic
 * JD-Core Version:    0.7.0.1
 */