package com.tencent.mm.plugin.performance.diagnostic.memory;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.c;
import com.tencent.mm.plugin.performance.diagnostic.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import com.tencent.mmkv.MMKV;
import com.tencent.wxperf.jni.HookManager;
import com.tencent.wxperf.jni.memory.MemoryHook;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import junit.framework.Assert;

public class MemoryHookLogic
  extends a
{
  public static String TAG;
  private static final k wWV;
  private static final k wWW;
  
  static
  {
    AppMethodBeat.i(124967);
    TAG = "MicroMsg.MemoryHookLogic";
    String str2 = ak.getProcessName();
    String str1 = "MM_";
    if (str2.contains(":tools"))
    {
      str1 = "tools_";
      TAG += ":tools";
    }
    for (;;)
    {
      str2 = ak.getContext().getFilesDir().getAbsolutePath() + "/memory_hook";
      str1 = str2 + "/" + str1 + Process.myPid() + "_memory_hook.log";
      wWV = new k(str2);
      wWW = new k(str1);
      ae.d(TAG, "init dump file dir = %s", new Object[] { str2 });
      ae.i(TAG, "init dump file path = %s", new Object[] { str1 });
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
    AppMethodBeat.o(124959);
  }
  
  public static boolean dBS()
  {
    AppMethodBeat.i(215415);
    boolean bool2 = wWe.decodeBool("MH_KEY_ENABLE_BOOLEAN", false);
    ae.i(TAG, "enableMemoryHook = %s for process [%s]", new Object[] { Boolean.valueOf(bool2), ak.getProcessName() });
    boolean bool1 = bool2;
    long l1;
    long l2;
    if (bool2)
    {
      l1 = wWe.decodeLong("MH_KEY_DURATION_MILLIS_LONG", 0L);
      l2 = wWe.decodeLong("MH_KEY_BEGIN_TIME_LONG", -1L);
      ae.i(TAG, "hook duration = %s, hook begin time = %s", new Object[] { Long.valueOf(l1), c.yN(l2) });
      if (l2 >= 0L) {
        break label145;
      }
      l1 = System.currentTimeMillis();
      wWe.encode("MH_KEY_BEGIN_TIME_LONG", l1);
      ae.i(TAG, "update hookBeginTime = %s", new Object[] { Long.valueOf(l1) });
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(215415);
      return bool1;
      label145:
      bool1 = bool2;
      if (System.currentTimeMillis() - l2 > l1)
      {
        wWe.encode("MH_KEY_ENABLE_BOOLEAN", false);
        ae.i(TAG, "time out, disable hook");
        bool1 = false;
      }
    }
  }
  
  public static boolean dBU()
  {
    AppMethodBeat.i(124964);
    String str = ak.getProcessName();
    boolean bool = wWe.decodeBool("MH_KEY_MULTI_PROCESS_BOOLEAN", false);
    ae.i(TAG, "enable multiProcess = %s", new Object[] { Boolean.valueOf(bool) });
    if ((ak.coh()) || ((bool) && ((str.endsWith(":tools")) || (str.contains(":appbrand")))))
    {
      AppMethodBeat.o(124964);
      return true;
    }
    AppMethodBeat.o(124964);
    return false;
  }
  
  public static void report()
  {
    AppMethodBeat.i(124961);
    MemoryHookReporter.report();
    AppMethodBeat.o(124961);
  }
  
  public final void aB(Map<String, String> paramMap)
  {
    AppMethodBeat.i(124960);
    ae.i(TAG, "onReceiveIpxxCmd:[%s]", new Object[] { paramMap });
    boolean bool2 = wWe.decodeBool("MH_KEY_ENABLE_BOOLEAN", false);
    boolean bool1 = wWe.decodeBool("MH_KEY_EXPT_ENABLE_BOOLEAN", true);
    ae.d(TAG, "isExptEnabled = ".concat(String.valueOf(bool1)));
    if (("1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$expt"))) && ((!bool1) || (bool2)))
    {
      localObject = TAG;
      paramMap = paramMap.get(".cmd.diagnostic.MemoryHook" + ".$expt");
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        ae.i((String)localObject, "skip config from expt cause [.$expt = %s && (!isExptEnabled = %s || isEnabledNow = %s)]", new Object[] { paramMap, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(124960);
        return;
      }
    }
    if ((paramMap.get(".cmd.diagnostic.MemoryHook" + ".$enableExpt") == null) || ("1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$enableExpt")))) {}
    String str;
    for (bool1 = true;; bool1 = false)
    {
      wWe.encode("MH_KEY_EXPT_ENABLE_BOOLEAN", bool1);
      ae.d(TAG, "cmd enableExpt = %s, expt = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf("1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$expt"))) });
      bool1 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$enable"));
      wWe.encode("MH_KEY_ENABLE_BOOLEAN", bool1);
      if (!bool1) {
        break label1295;
      }
      str = (String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$hook");
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      ae.e(TAG, "ERROR(MemoryHook): hook regex is blank");
      AppMethodBeat.o(124960);
      return;
    }
    Object localObject = (String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$ignore");
    bool1 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$stack"));
    int i = bu.getInt((String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$min"), 0);
    int j = bu.getInt((String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$max"), 0);
    double d = bu.getDouble((String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$sampling"), 1.0D);
    int k = bu.getInt((String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$duration"), 0);
    boolean bool3 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$multiprocess"));
    boolean bool4 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$force"));
    boolean bool5 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$extreme"));
    boolean bool6 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$mmap"));
    wWe.encode("MH_KEY_HOOK_SO_STRING", str);
    wWe.encode("MH_KEY_IGNORE_SO_STRING", (String)localObject);
    wWe.encode("MH_KEY_ENABLE_STACKTRACE_BOOLEAN", bool1);
    wWe.encode("MH_KEY_MIN_TRACE_SIZE_INT", i);
    wWe.encode("MH_KEY_MAX_TRACE_SIZE_INT", j);
    paramMap = wWe;
    if (paramMap.y("MH_KEY_SAMPLING_DOUBLE", Double.valueOf(d))) {
      paramMap.IyS.encode("MH_KEY_SAMPLING_DOUBLE", d);
    }
    wWe.encode("MH_KEY_DURATION_MILLIS_LONG", k * 60 * 60 * 1000L);
    wWe.encode("MH_KEY_MULTI_PROCESS_BOOLEAN", bool3);
    wWe.encode("MH_KEY_BEGIN_TIME_LONG", -1L);
    wWe.encode("MH_KEY_EXTREME_BOOLEAN", bool5);
    wWe.encode("MH_KEY_ENABLE_MMAP_BOOLEAN", bool6);
    paramMap = (Map<String, String>)localObject;
    if (!bool5)
    {
      if (localObject == null) {
        paramMap = ".*libutils\\.so$;.*libcutils\\.so$;.*libskia\\.so$;.*libbinder.*\\.so$;.*libhwbinder\\.so$;.*libicuuc\\.so$;.*libicui18n\\.so$;.*libart.*\\.so$;.*libandroidfw\\.so$;.*libandroid_runtime\\.so$;.*libjavacore\\.so$;.*libopenjdk.*\\.so$;.*libmemfence\\.so$";
      }
    }
    else
    {
      if (((bool2) && (!bool4)) || (!dBU())) {
        break label1295;
      }
      ae.i(TAG, "hook immediately");
      Assert.assertNotNull(str);
      localObject = str.split(";");
      if (paramMap != null) {
        break label1269;
      }
    }
    label1269:
    for (paramMap = new String[0];; paramMap = paramMap.split(";"))
    {
      ae.i(TAG, "hookRegex = %s", new Object[] { Arrays.toString((Object[])localObject) });
      ae.i(TAG, "ignoreRegex = %s", new Object[] { Arrays.toString(paramMap) });
      try
      {
        paramMap = MemoryHook.MLE.ag((String[])localObject).ah(paramMap);
        paramMap.MLK = bool1;
        paramMap.MLH = i;
        paramMap.MLI = j;
        paramMap = paramMap.F(d);
        paramMap.MLL = bool6;
        HookManager.MLy.geK().a(paramMap).geJ();
        wWe.encode("MH_KEY_BEGIN_TIME_LONG", System.currentTimeMillis());
        ae.i(TAG, "register Reporter");
        MemoryHookReporter.install();
        dBT();
        g.yxI.f(18261, new Object[] { ak.getProcessName(), Integer.valueOf(Process.myPid()), Integer.valueOf(1) });
        AppMethodBeat.o(124960);
        return;
      }
      catch (Throwable paramMap)
      {
        ae.printErrStackTrace(TAG, paramMap, "MemoryHook Error", new Object[0]);
      }
      paramMap = (Map<String, String>)localObject;
      if (!((String)localObject).endsWith(";")) {
        paramMap = (String)localObject + ";";
      }
      paramMap = paramMap + ".*libutils\\.so$;.*libcutils\\.so$;.*libskia\\.so$;.*libbinder.*\\.so$;.*libhwbinder\\.so$;.*libicuuc\\.so$;.*libicui18n\\.so$;.*libart.*\\.so$;.*libandroidfw\\.so$;.*libandroid_runtime\\.so$;.*libjavacore\\.so$;.*libopenjdk.*\\.so$;.*libmemfence\\.so$";
      break;
    }
    label1295:
    AppMethodBeat.o(124960);
  }
  
  public final String dBO()
  {
    return ".cmd.diagnostic.MemoryHook";
  }
  
  public final void dBT()
  {
    AppMethodBeat.i(124963);
    final String str = TAG + "-repeat";
    h.MqF.bbc(str);
    h.MqF.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124951);
        if (a.wWe.decodeBool("MH_KEY_ENABLE_BOOLEAN", false))
        {
          MemoryHookLogic.report();
          h.MqF.a(this, 1800000L, str);
        }
        AppMethodBeat.o(124951);
      }
    }, 1800000L, str);
    AppMethodBeat.o(124963);
  }
  
  public static final class MemoryHookReporter
    extends BroadcastReceiver
  {
    private static final String wWZ;
    private static MemoryHookReporter wXa;
    
    static
    {
      AppMethodBeat.i(124958);
      wWZ = MemoryHookLogic.TAG + "-reporter";
      wXa = null;
      AppMethodBeat.o(124958);
    }
    
    static void dBW()
    {
      AppMethodBeat.i(124956);
      Intent localIntent = new Intent("com.tencent.mm.memoryhook.dump");
      localIntent.putExtra("op", 1);
      localIntent.putExtra("log_file", w.B(MemoryHookLogic.dBV().fTh()));
      ak.getContext().sendBroadcast(localIntent);
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
      //   8: getstatic 44	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:wXa	Lcom/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter;
      //   11: ifnull +12 -> 23
      //   14: ldc 99
      //   16: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: ldc 2
      //   21: monitorexit
      //   22: return
      //   23: new 2	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter
      //   26: dup
      //   27: invokespecial 100	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:<init>	()V
      //   30: putstatic 44	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:wXa	Lcom/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter;
      //   33: new 102	android/content/IntentFilter
      //   36: dup
      //   37: ldc 55
      //   39: invokespecial 103	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
      //   42: astore_0
      //   43: invokestatic 91	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
      //   46: getstatic 44	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:wXa	Lcom/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter;
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
      ak.getContext().sendBroadcast(localIntent);
      AppMethodBeat.o(124955);
    }
    
    public final void onReceive(final Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(124957);
      final int i = paramIntent.getIntExtra("op", 0);
      paramContext = paramIntent.getStringExtra("log_file");
      h.MqF.f(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 36
          //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 26	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter$1:wXb	I
          //   9: tableswitch	default:+23 -> 32, 0:+29->38, 1:+59->68
          //   33: fload_2
          //   34: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   37: return
          //   38: invokestatic 49	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic:access$000	()Ljava/lang/String;
          //   41: ldc 51
          //   43: iconst_1
          //   44: anewarray 4	java/lang/Object
          //   47: dup
          //   48: iconst_0
          //   49: invokestatic 56	com/tencent/mm/sdk/platformtools/ak:getProcessName	()Ljava/lang/String;
          //   52: aastore
          //   53: invokestatic 61	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   56: invokestatic 64	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic:access$200	()V
          //   59: invokestatic 67	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:dBW	()V
          //   62: ldc 36
          //   64: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   67: return
          //   68: invokestatic 71	com/tencent/mm/sdk/platformtools/ak:coh	()Z
          //   71: ifne +9 -> 80
          //   74: ldc 36
          //   76: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   79: return
          //   80: invokestatic 49	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic:access$000	()Ljava/lang/String;
          //   83: astore 7
          //   85: new 73	com/tencent/mm/vfs/k
          //   88: dup
          //   89: aload_0
          //   90: getfield 28	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter$1:wXc	Ljava/lang/String;
          //   93: invokespecial 76	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
          //   96: astore 6
          //   98: aload 7
          //   100: ldc 78
          //   102: iconst_2
          //   103: anewarray 4	java/lang/Object
          //   106: dup
          //   107: iconst_0
          //   108: aload 6
          //   110: invokevirtual 81	com/tencent/mm/vfs/k:getName	()Ljava/lang/String;
          //   113: aastore
          //   114: dup
          //   115: iconst_1
          //   116: aload 6
          //   118: invokevirtual 85	com/tencent/mm/vfs/k:lastModified	()J
          //   121: invokestatic 91	com/tencent/mm/plugin/performance/c:yN	(J)Ljava/lang/String;
          //   124: aastore
          //   125: invokestatic 61	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   128: aload 6
          //   130: invokevirtual 94	com/tencent/mm/vfs/k:exists	()Z
          //   133: ifeq +184 -> 317
          //   136: new 96	java/io/BufferedReader
          //   139: dup
          //   140: new 98	java/io/InputStreamReader
          //   143: dup
          //   144: aload 6
          //   146: invokestatic 104	com/tencent/mm/vfs/o:ai	(Lcom/tencent/mm/vfs/k;)Ljava/io/InputStream;
          //   149: invokespecial 107	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
          //   152: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
          //   155: astore 4
          //   157: aload 4
          //   159: astore_3
          //   160: new 112	java/lang/StringBuilder
          //   163: dup
          //   164: invokespecial 113	java/lang/StringBuilder:<init>	()V
          //   167: astore 5
          //   169: iconst_0
          //   170: istore_1
          //   171: aload 4
          //   173: astore_3
          //   174: aload 4
          //   176: invokevirtual 116	java/io/BufferedReader:readLine	()Ljava/lang/String;
          //   179: astore 8
          //   181: aload 8
          //   183: ifnull +66 -> 249
          //   186: aload 4
          //   188: astore_3
          //   189: aload 5
          //   191: aload 8
          //   193: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   196: pop
          //   197: aload 4
          //   199: astore_3
          //   200: aload 5
          //   202: bipush 10
          //   204: invokevirtual 123	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
          //   207: pop
          //   208: iload_1
          //   209: iconst_1
          //   210: iadd
          //   211: istore_2
          //   212: iload_1
          //   213: bipush 20
          //   215: irem
          //   216: ifne +201 -> 417
          //   219: aload 4
          //   221: astore_3
          //   222: aload 7
          //   224: aload 5
          //   226: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   229: invokestatic 129	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   232: aload 4
          //   234: astore_3
          //   235: new 112	java/lang/StringBuilder
          //   238: dup
          //   239: invokespecial 113	java/lang/StringBuilder:<init>	()V
          //   242: astore 5
          //   244: iload_2
          //   245: istore_1
          //   246: goto -75 -> 171
          //   249: aload 4
          //   251: astore_3
          //   252: aload 7
          //   254: aload 5
          //   256: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   259: invokestatic 129	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   262: aload 4
          //   264: astore_3
          //   265: invokestatic 134	com/tencent/mm/sdk/platformtools/bv:fnD	()Z
          //   268: ifne +30 -> 298
          //   271: aload 4
          //   273: astore_3
          //   274: invokestatic 137	com/tencent/mm/sdk/platformtools/bv:fpT	()Z
          //   277: ifne +21 -> 298
          //   280: aload 4
          //   282: astore_3
          //   283: getstatic 143	com/tencent/mm/sdk/platformtools/j:IS_FLAVOR_RED	Z
          //   286: ifne +12 -> 298
          //   289: aload 4
          //   291: astore_3
          //   292: getstatic 146	com/tencent/mm/sdk/platformtools/j:DEBUG	Z
          //   295: ifeq +11 -> 306
          //   298: aload 4
          //   300: astore_3
          //   301: aload 6
          //   303: invokestatic 150	com/tencent/mm/plugin/performance/c:N	(Lcom/tencent/mm/vfs/k;)V
          //   306: aload 4
          //   308: invokestatic 156	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
          //   311: aload 6
          //   313: invokevirtual 159	com/tencent/mm/vfs/k:delete	()Z
          //   316: pop
          //   317: aload 7
          //   319: ldc 161
          //   321: iconst_2
          //   322: anewarray 4	java/lang/Object
          //   325: dup
          //   326: iconst_0
          //   327: aload 6
          //   329: invokevirtual 81	com/tencent/mm/vfs/k:getName	()Ljava/lang/String;
          //   332: aastore
          //   333: dup
          //   334: iconst_1
          //   335: aload 6
          //   337: invokevirtual 85	com/tencent/mm/vfs/k:lastModified	()J
          //   340: invokestatic 91	com/tencent/mm/plugin/performance/c:yN	(J)Ljava/lang/String;
          //   343: aastore
          //   344: invokestatic 61	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   347: goto -315 -> 32
          //   350: astore 5
          //   352: aconst_null
          //   353: astore 4
          //   355: aload 4
          //   357: astore_3
          //   358: aload 7
          //   360: aload 5
          //   362: ldc 163
          //   364: iconst_0
          //   365: anewarray 4	java/lang/Object
          //   368: invokestatic 167	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   371: aload 4
          //   373: invokestatic 156	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
          //   376: aload 6
          //   378: invokevirtual 159	com/tencent/mm/vfs/k:delete	()Z
          //   381: pop
          //   382: goto -65 -> 317
          //   385: astore 4
          //   387: aconst_null
          //   388: astore_3
          //   389: aload_3
          //   390: invokestatic 156	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
          //   393: aload 6
          //   395: invokevirtual 159	com/tencent/mm/vfs/k:delete	()Z
          //   398: pop
          //   399: ldc 36
          //   401: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   404: aload 4
          //   406: athrow
          //   407: astore 4
          //   409: goto -20 -> 389
          //   412: astore 5
          //   414: goto -59 -> 355
          //   417: iload_2
          //   418: istore_1
          //   419: goto -248 -> 171
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	422	0	this	1
          //   170	249	1	i	int
          //   211	207	2	j	int
          //   159	231	3	localBufferedReader1	java.io.BufferedReader
          //   155	217	4	localBufferedReader2	java.io.BufferedReader
          //   385	20	4	localObject1	Object
          //   407	1	4	localObject2	Object
          //   167	88	5	localStringBuilder	java.lang.StringBuilder
          //   350	11	5	localIOException1	java.io.IOException
          //   412	1	5	localIOException2	java.io.IOException
          //   96	298	6	localk	k
          //   83	276	7	str1	String
          //   179	13	8	str2	String
          // Exception table:
          //   from	to	target	type
          //   136	157	350	java/io/IOException
          //   136	157	385	finally
          //   160	169	407	finally
          //   174	181	407	finally
          //   189	197	407	finally
          //   200	208	407	finally
          //   222	232	407	finally
          //   235	244	407	finally
          //   252	262	407	finally
          //   265	271	407	finally
          //   274	280	407	finally
          //   283	289	407	finally
          //   292	298	407	finally
          //   301	306	407	finally
          //   358	371	407	finally
          //   160	169	412	java/io/IOException
          //   174	181	412	java/io/IOException
          //   189	197	412	java/io/IOException
          //   200	208	412	java/io/IOException
          //   222	232	412	java/io/IOException
          //   235	244	412	java/io/IOException
          //   252	262	412	java/io/IOException
          //   265	271	412	java/io/IOException
          //   274	280	412	java/io/IOException
          //   283	289	412	java/io/IOException
          //   292	298	412	java/io/IOException
          //   301	306	412	java/io/IOException
        }
      }, wWZ);
      AppMethodBeat.o(124957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.memory.MemoryHookLogic
 * JD-Core Version:    0.7.0.1
 */