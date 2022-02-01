package com.tencent.mm.plugin.performance.diagnostic.pthread;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.c;
import com.tencent.mm.plugin.performance.diagnostic.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import com.tencent.wxperf.jni.HookManager;
import com.tencent.wxperf.jni.pthread.PthreadHook;
import d.n.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public class PthreadHookLogic
  extends a
  implements c.a
{
  public static String TAG;
  private static final e wHi;
  private static final e wHj;
  private static final long wHr;
  private static final Set<String> wHs;
  private StringBuilder sb = null;
  
  static
  {
    AppMethodBeat.i(211763);
    TAG = "MicroMsg.PthreadHookLogic";
    long l;
    String str2;
    String str1;
    if (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)
    {
      l = 300000L;
      wHr = l;
      wHs = new HashSet();
      str2 = aj.getProcessName();
      str1 = "OTHER_";
      if (!aj.cmR()) {
        break label180;
      }
      str1 = "MM_";
    }
    for (;;)
    {
      str2 = aj.getContext().getFilesDir().getAbsolutePath() + "/pthread_hook";
      str1 = str2 + "/" + str1 + Process.myPid() + "_pthread_hook.json";
      wHi = new e(str2);
      wHj = new e(str1);
      ad.d(TAG, "init dump file dir = %s", new Object[] { str2 });
      ad.i(TAG, "init dump file path = %s", new Object[] { str1 });
      AppMethodBeat.o(211763);
      return;
      l = 1800000L;
      break;
      label180:
      if (aj.fkI())
      {
        str1 = "tools_";
        TAG += ":tools";
      }
      else if (aj.fkJ())
      {
        str1 = "toolsmp_";
        TAG += ":toolsmp";
      }
      else if (str2.contains(":appbrand0"))
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
  
  private static void R(e parame)
  {
    AppMethodBeat.i(211759);
    ad.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> dump file = %s, modified = %s", new Object[] { parame.getName(), c.yt(parame.lastModified()) });
    Object localObject1 = c.a(q.B(parame.fOK()), d.UTF_8);
    for (;;)
    {
      int i;
      int j;
      try
      {
        localObject1 = new JSONObject((String)localObject1).getJSONArray("PthreadHook");
        long l1 = System.currentTimeMillis();
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          long l2 = bt.getLong(((JSONObject)localObject3).getString("hash"), 0L);
          String str1 = ((JSONObject)localObject3).getString("native");
          String str2 = ((JSONObject)localObject3).getString("java");
          int k = bt.getInt(((JSONObject)localObject3).getString("count"), 0);
          localObject3 = ((JSONObject)localObject3).getJSONArray("threads");
          ad.i(TAG, "------------------------------- hash= %d -------------------------------", new Object[] { Long.valueOf(l2) });
          ad.i(TAG, "native\n\t%s", new Object[] { str1.replace(";", "\n\t") });
          ad.i(TAG, "java\n%s", new Object[] { str2.replace("\\n", "\n") });
          ad.i(TAG, "ThreadCount = %d", new Object[] { Integer.valueOf(k) });
          ArrayList localArrayList = new ArrayList();
          HashSet localHashSet = new HashSet();
          j = 0;
          if (j < ((JSONArray)localObject3).length())
          {
            Object localObject4 = new StringBuilder();
            JSONObject localJSONObject = ((JSONArray)localObject3).getJSONObject(j);
            ((StringBuilder)localObject4).append("{").append(localJSONObject.getString("tid")).append("-").append(localJSONObject.getString("name")).append("}");
            localObject4 = ((StringBuilder)localObject4).toString();
            localArrayList.add(localObject4);
            if (wHs.contains(localObject4)) {
              break label625;
            }
            localHashSet.add(localObject4);
            break label625;
          }
          ad.i(TAG, "==> leaked threads : %s", new Object[] { localArrayList.toString().replace(",", "") });
          if (localHashSet.isEmpty()) {
            break label632;
          }
          g.yhR.f(19816, new Object[] { Integer.valueOf(0), Long.valueOf(l1), Long.valueOf(l2), str1, str2, Integer.valueOf(k), localArrayList.toString().replace(",", "") });
          wHs.addAll(localHashSet);
          ad.i(TAG, "reported %s", new Object[] { localHashSet });
          break label632;
        }
        if ((bu.fjL()) || (bu.flY()) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.DEBUG)) {
          c.N(parame);
        }
        parame.delete();
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace(TAG, localException, "report kv error", new Object[0]);
        parame.delete();
        continue;
      }
      finally
      {
        parame.delete();
        AppMethodBeat.o(211759);
      }
      ad.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< dump file = %s, modified = %s", new Object[] { parame.getName(), c.yt(parame.lastModified()) });
      AppMethodBeat.o(211759);
      return;
      label625:
      j += 1;
      continue;
      label632:
      i += 1;
    }
  }
  
  public static boolean dyC()
  {
    AppMethodBeat.i(211755);
    boolean bool2 = wGr.decodeBool("PH_KEY_ENABLE_BOOLEAN_v2", false);
    ad.i(TAG, "enablePthreadHook = %s for process [%s]", new Object[] { Boolean.valueOf(bool2), aj.getProcessName() });
    boolean bool1 = bool2;
    long l1;
    long l2;
    if (bool2)
    {
      l1 = wGr.decodeLong("PH_KEY_DURATION_MILLIS_LONG", 0L);
      l2 = wGr.decodeLong("PH_KEY_BEGIN_TIME_LONG", -1L);
      ad.i(TAG, "hook duration = %s, hook begin time = %s", new Object[] { Long.valueOf(l1), c.yt(l2) });
      if (l2 >= 0L) {
        break label154;
      }
      l1 = System.currentTimeMillis();
      wGr.encode("PH_KEY_BEGIN_TIME_LONG", l1);
      ad.i(TAG, "update hookBeginTime = %s", new Object[] { Long.valueOf(l1) });
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(211755);
      return bool1;
      label154:
      bool1 = bool2;
      if (System.currentTimeMillis() - l2 > l1)
      {
        wGr.encode("PH_KEY_ENABLE_BOOLEAN_v2", false);
        ad.i(TAG, "time out, disable hook");
        bool1 = false;
      }
    }
  }
  
  public static boolean dyE()
  {
    AppMethodBeat.i(211754);
    boolean bool = wGr.decodeBool("PH_KEY_MULTI_PROCESS_BOOLEAN", false);
    ad.i(TAG, "enable multiProcess = %s", new Object[] { Boolean.valueOf(bool) });
    if ((aj.cmR()) || ((bool) && ((aj.fkI()) || (aj.fkJ()) || (aj.isAppBrandProcess()))))
    {
      AppMethodBeat.o(211754);
      return true;
    }
    AppMethodBeat.o(211754);
    return false;
  }
  
  private static void dyH()
  {
    AppMethodBeat.i(211758);
    ad.i(TAG, "memory dump begin");
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = wHi;
      if (!((e)localObject).exists()) {
        ((e)localObject).mkdirs();
      }
      localObject = PthreadHook.MoQ;
      String str = q.B(wHj.fOK());
      if (HookManager.MoC.MoD) {
        ((PthreadHook)localObject).dumpNative(str);
      }
      ad.i(TAG, "dump path = %s", new Object[] { q.B(wHj.fOK()) });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace(TAG, localException, "something wrong when dumping", new Object[0]);
      }
    }
    ad.i(TAG, "memory dump end, cost = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(211758);
  }
  
  public static void report()
  {
    AppMethodBeat.i(211757);
    PthreadHookReporter.report();
    AppMethodBeat.o(211757);
  }
  
  public final void av(Map<String, String> paramMap)
  {
    AppMethodBeat.i(211753);
    ad.i(TAG, "onReceiveIpxxCmd: [%s]", new Object[] { paramMap });
    boolean bool2 = wGr.decodeBool("PH_KEY_ENABLE_BOOLEAN_v2", false);
    int i = wGr.decodeInt("PH_KEY_CRASH_TIMES_INT", 0);
    if ("1".equals(paramMap.get(".cmd.diagnostic.PthreadHook.$force")))
    {
      i = 0;
      wGr.encode("PH_KEY_CRASH_TIMES_INT", 0);
      ad.i(TAG, "force enable");
    }
    if ((i < 3) && ("1".equals(paramMap.get(".cmd.diagnostic.PthreadHook.$enable")))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      wGr.encode("PH_KEY_ENABLE_BOOLEAN_v2", bool1);
      if (!bool1) {
        break label588;
      }
      localObject2 = (String)paramMap.get(".cmd.diagnostic.PthreadHook.$hook");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      ad.e(TAG, "ERROR(PthreadHook): hook regex is blank");
      AppMethodBeat.o(211753);
      return;
    }
    String str = (String)paramMap.get(".cmd.diagnostic.PthreadHook.$ignore");
    Object localObject1 = (String)paramMap.get(".cmd.diagnostic.PthreadHook.$thread");
    i = bt.getInt((String)paramMap.get(".cmd.diagnostic.PthreadHook.$duration"), 0);
    int j = bt.getInt((String)paramMap.get(".cmd.diagnostic.PthreadHook.$dumpcycle"), 30);
    bool1 = "1".equals(paramMap.get(".cmd.diagnostic.PthreadHook.$multiprocess"));
    wGr.encode("PH_KEY_HOOK_SO_STRING", (String)localObject2);
    wGr.encode("PH_KEY_IGNORE_SO_STRING", str);
    wGr.encode("PH_KEY_HOOK_THREAD_STRING", (String)localObject1);
    wGr.encode("PH_KEY_DURATION_MILLIS_LONG", i * 60 * 60 * 1000L);
    wGr.encode("PH_KEY_MULTI_PROCESS_BOOLEAN", bool1);
    wGr.encode("PH_KEY_DUMP_CYCLE_MILLIS_LONG", j * 60 * 1000L);
    wGr.encode("PH_KEY_BEGIN_TIME_LONG", -1L);
    if (bool2)
    {
      ad.i(TAG, "already enabled now, pls restart process");
      AppMethodBeat.o(211753);
      return;
    }
    Assert.assertNotNull(localObject2);
    ad.i(TAG, "hook immediately");
    Object localObject2 = ((String)localObject2).split(";");
    if (str == null)
    {
      paramMap = new String[0];
      if (localObject1 != null) {
        break label560;
      }
      localObject1 = new String[1];
      localObject1[0] = ".*";
    }
    for (;;)
    {
      ad.i(TAG, "hookRegex = %s", new Object[] { Arrays.toString((Object[])localObject2) });
      ad.i(TAG, "ignoreRegex = %s", new Object[] { Arrays.toString(paramMap) });
      ad.i(TAG, "threadRegex = %s", new Object[] { Arrays.toString((Object[])localObject1) });
      try
      {
        paramMap = PthreadHook.MoQ.ai((String[])localObject2).aj(paramMap).ak((String[])localObject1);
        HookManager.MoC.gai().a(paramMap).gah();
        wGr.encode("PH_KEY_BEGIN_TIME_LONG", System.currentTimeMillis());
        PthreadHookReporter.install();
        dyD();
        AppMethodBeat.o(211753);
        return;
      }
      catch (Throwable paramMap)
      {
        label560:
        ad.printErrStackTrace(TAG, paramMap, "PthreadHook Error", new Object[0]);
      }
      paramMap = str.split(";");
      break;
      localObject1 = ((String)localObject1).split(";");
    }
    label588:
    AppMethodBeat.o(211753);
  }
  
  public final String bev()
  {
    AppMethodBeat.i(211760);
    if (this.sb != null)
    {
      localObject = this.sb.toString();
      AppMethodBeat.o(211760);
      return localObject;
    }
    ad.d(TAG, "onCrash");
    boolean bool = wGr.decodeBool("PH_KEY_ENABLE_BOOLEAN_v2", false);
    int j = wGr.decodeInt("PH_KEY_CRASH_TIMES_INT", 0);
    this.sb = new StringBuilder("PtheadHookConfig:\n");
    this.sb.append("enable=").append(bool).append(",");
    int i = j;
    if (bool)
    {
      localObject = this.sb.append("hook=").append(wGr.decodeString("PH_KEY_HOOK_SO_STRING", "")).append(",thread=").append(wGr.decodeString("PH_KEY_HOOK_THREAD_STRING", "")).append(",duration=").append(wGr.decodeLong("PH_KEY_DURATION_MILLIS_LONG", 0L)).append(",begin=").append(c.yt(wGr.decodeLong("PH_KEY_BEGIN_TIME_LONG", 0L))).append(",crashTimes=");
      i = j + 1;
      ((StringBuilder)localObject).append(i);
      wGr.encode("PH_KEY_CRASH_TIMES_INT", i);
      dyH();
      R(new e(q.B(wHj.fOK())));
    }
    if ((bool) && (i > 3))
    {
      wGr.encode("PH_KEY_ENABLE_BOOLEAN_v2", false);
      ad.e(TAG, "crash happens 3 times, disable hook");
      g.yhR.n(1376L, 1L, 1L);
    }
    Object localObject = this.sb.toString();
    AppMethodBeat.o(211760);
    return localObject;
  }
  
  public final void dyD()
  {
    AppMethodBeat.i(211756);
    String str = TAG + "-repeat";
    h.LTJ.aZz(str);
    final long l = wGr.decodeLong("PH_KEY_DUMP_CYCLE_MILLIS_LONG", wHr);
    h.LTJ.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211746);
        if (a.wGr.decodeBool("PH_KEY_ENABLE_BOOLEAN_v2", false))
        {
          PthreadHookLogic.report();
          h.LTJ.a(this, l, this.wHk);
        }
        AppMethodBeat.o(211746);
      }
    }, l, str);
    AppMethodBeat.o(211756);
  }
  
  public final String dyy()
  {
    return ".cmd.diagnostic.PthreadHook";
  }
  
  public static final class PthreadHookReporter
    extends BroadcastReceiver
  {
    private static final String wHm;
    private static PthreadHookReporter wHv;
    
    static
    {
      AppMethodBeat.i(211752);
      wHm = PthreadHookLogic.TAG + "-reporter";
      wHv = null;
      AppMethodBeat.o(211752);
    }
    
    static void dyG()
    {
      AppMethodBeat.i(211750);
      Intent localIntent = new Intent("com.tencent.mm.pthreadhook.dump");
      localIntent.putExtra("op", 1);
      localIntent.putExtra("log_file", q.B(PthreadHookLogic.dyF().fOK()));
      aj.getContext().sendBroadcast(localIntent);
      AppMethodBeat.o(211750);
    }
    
    /* Error */
    public static void install()
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 99
      //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: getstatic 44	com/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter:wHv	Lcom/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter;
      //   11: ifnull +12 -> 23
      //   14: ldc 99
      //   16: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: ldc 2
      //   21: monitorexit
      //   22: return
      //   23: new 2	com/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter
      //   26: dup
      //   27: invokespecial 100	com/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter:<init>	()V
      //   30: putstatic 44	com/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter:wHv	Lcom/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter;
      //   33: new 102	android/content/IntentFilter
      //   36: dup
      //   37: ldc 55
      //   39: invokespecial 103	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
      //   42: astore_0
      //   43: invokestatic 91	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   46: getstatic 44	com/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter:wHv	Lcom/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter;
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
      AppMethodBeat.i(211749);
      Intent localIntent = new Intent("com.tencent.mm.pthreadhook.dump");
      localIntent.putExtra("op", 0);
      aj.getContext().sendBroadcast(localIntent);
      AppMethodBeat.o(211749);
    }
    
    public final void onReceive(final Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(211751);
      final int i = paramIntent.getIntExtra("op", 0);
      paramContext = paramIntent.getStringExtra("log_file");
      h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211747);
          switch (i)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(211747);
            return;
            ad.i(PthreadHookLogic.TAG, "current process...[%s]", new Object[] { aj.getProcessName() });
            PthreadHookLogic.access$200();
            PthreadHookLogic.PthreadHookReporter.dyG();
            AppMethodBeat.o(211747);
            return;
            if (!aj.cmR())
            {
              AppMethodBeat.o(211747);
              return;
            }
            PthreadHookLogic.S(new e(paramContext));
          }
        }
      }, wHm);
      AppMethodBeat.o(211751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.pthread.PthreadHookLogic
 * JD-Core Version:    0.7.0.1
 */