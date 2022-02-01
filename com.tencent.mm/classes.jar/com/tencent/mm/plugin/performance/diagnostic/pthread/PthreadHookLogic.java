package com.tencent.mm.plugin.performance.diagnostic.pthread;

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
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
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
  private static final k wWV;
  private static final k wWW;
  private static final long wXe;
  private static final Set<String> wXf;
  private StringBuilder sb = null;
  
  static
  {
    AppMethodBeat.i(215433);
    TAG = "MicroMsg.PthreadHookLogic";
    long l;
    String str2;
    String str1;
    if (j.IS_FLAVOR_RED)
    {
      l = 300000L;
      wXe = l;
      wXf = new HashSet();
      str2 = ak.getProcessName();
      str1 = "OTHER_";
      if (!ak.coh()) {
        break label180;
      }
      str1 = "MM_";
    }
    for (;;)
    {
      str2 = ak.getContext().getFilesDir().getAbsolutePath() + "/pthread_hook";
      str1 = str2 + "/" + str1 + Process.myPid() + "_pthread_hook.json";
      wWV = new k(str2);
      wWW = new k(str1);
      ae.d(TAG, "init dump file dir = %s", new Object[] { str2 });
      ae.i(TAG, "init dump file path = %s", new Object[] { str1 });
      AppMethodBeat.o(215433);
      return;
      l = 1800000L;
      break;
      label180:
      if (ak.foC())
      {
        str1 = "tools_";
        TAG += ":tools";
      }
      else if (ak.foD())
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
  
  private static void R(k paramk)
  {
    AppMethodBeat.i(215429);
    ae.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> dump file = %s, modified = %s", new Object[] { paramk.getName(), c.yN(paramk.lastModified()) });
    Object localObject1 = c.a(w.B(paramk.fTh()), d.UTF_8);
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
          long l2 = bu.getLong(((JSONObject)localObject3).getString("hash"), 0L);
          String str1 = ((JSONObject)localObject3).getString("native");
          String str2 = ((JSONObject)localObject3).getString("java");
          int k = bu.getInt(((JSONObject)localObject3).getString("count"), 0);
          localObject3 = ((JSONObject)localObject3).getJSONArray("threads");
          ae.i(TAG, "------------------------------- hash= %d -------------------------------", new Object[] { Long.valueOf(l2) });
          ae.i(TAG, "native\n\t%s", new Object[] { str1.replace(";", "\n\t") });
          ae.i(TAG, "java\n%s", new Object[] { str2.replace("\\n", "\n") });
          ae.i(TAG, "ThreadCount = %d", new Object[] { Integer.valueOf(k) });
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
            if (wXf.contains(localObject4)) {
              break label632;
            }
            localHashSet.add(localObject4);
            break label632;
          }
          ae.i(TAG, "==> leaked threads : %s", new Object[] { localArrayList.toString().replace(",", "") });
          if (localHashSet.isEmpty()) {
            break label639;
          }
          g.yxI.f(19816, new Object[] { Integer.valueOf(0), Long.valueOf(l1), Long.valueOf(l2), str1, str2, Integer.valueOf(k), localArrayList.toString().replace(",", ""), ak.getProcessName() });
          wXf.addAll(localHashSet);
          ae.i(TAG, "reported %s", new Object[] { localHashSet });
          break label639;
        }
        if ((bv.fnD()) || (bv.fpT()) || (j.IS_FLAVOR_RED) || (j.DEBUG)) {
          c.N(paramk);
        }
        paramk.delete();
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace(TAG, localException, "report kv error", new Object[0]);
        paramk.delete();
        continue;
      }
      finally
      {
        paramk.delete();
        AppMethodBeat.o(215429);
      }
      ae.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< dump file = %s, modified = %s", new Object[] { paramk.getName(), c.yN(paramk.lastModified()) });
      AppMethodBeat.o(215429);
      return;
      label632:
      j += 1;
      continue;
      label639:
      i += 1;
    }
  }
  
  public static boolean dBS()
  {
    AppMethodBeat.i(215425);
    boolean bool2 = wWe.decodeBool("PH_KEY_ENABLE_BOOLEAN_v2", false);
    ae.i(TAG, "enablePthreadHook = %s for process [%s]", new Object[] { Boolean.valueOf(bool2), ak.getProcessName() });
    boolean bool1 = bool2;
    long l1;
    long l2;
    if (bool2)
    {
      l1 = wWe.decodeLong("PH_KEY_DURATION_MILLIS_LONG", 0L);
      l2 = wWe.decodeLong("PH_KEY_BEGIN_TIME_LONG", -1L);
      ae.i(TAG, "hook duration = %s, hook begin time = %s", new Object[] { Long.valueOf(l1), c.yN(l2) });
      if (l2 >= 0L) {
        break label154;
      }
      l1 = System.currentTimeMillis();
      wWe.encode("PH_KEY_BEGIN_TIME_LONG", l1);
      ae.i(TAG, "update hookBeginTime = %s", new Object[] { Long.valueOf(l1) });
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(215425);
      return bool1;
      label154:
      bool1 = bool2;
      if (System.currentTimeMillis() - l2 > l1)
      {
        wWe.encode("PH_KEY_ENABLE_BOOLEAN_v2", false);
        ae.i(TAG, "time out, disable hook");
        bool1 = false;
      }
    }
  }
  
  public static boolean dBU()
  {
    AppMethodBeat.i(215424);
    boolean bool = wWe.decodeBool("PH_KEY_MULTI_PROCESS_BOOLEAN", false);
    ae.i(TAG, "enable multiProcess = %s", new Object[] { Boolean.valueOf(bool) });
    if ((ak.coh()) || ((bool) && ((ak.foC()) || (ak.foD()) || (ak.isAppBrandProcess()))))
    {
      AppMethodBeat.o(215424);
      return true;
    }
    AppMethodBeat.o(215424);
    return false;
  }
  
  public static void dBX()
  {
    AppMethodBeat.i(215427);
    dBY();
    R(new k(w.B(wWW.fTh())));
    AppMethodBeat.o(215427);
  }
  
  private static void dBY()
  {
    AppMethodBeat.i(215428);
    ae.i(TAG, "memory dump begin");
    long l = System.currentTimeMillis();
    try
    {
      k localk = wWV;
      if (!localk.exists()) {
        localk.mkdirs();
      }
      PthreadHook.MLM.dump(w.B(wWW.fTh()));
      ae.i(TAG, "dump path = %s", new Object[] { w.B(wWW.fTh()) });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace(TAG, localException, "something wrong when dumping", new Object[0]);
      }
    }
    ae.i(TAG, "memory dump end, cost = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(215428);
  }
  
  public static void report()
  {
    AppMethodBeat.i(215426);
    PthreadHookReporter.report();
    AppMethodBeat.o(215426);
  }
  
  public final void aB(Map<String, String> paramMap)
  {
    AppMethodBeat.i(215423);
    ae.i(TAG, "onReceiveIpxxCmd: [%s]", new Object[] { paramMap });
    boolean bool2 = wWe.decodeBool("PH_KEY_ENABLE_BOOLEAN_v2", false);
    int i = wWe.decodeInt("PH_KEY_CRASH_TIMES_INT", 0);
    if ("1".equals(paramMap.get(".cmd.diagnostic.PthreadHook.$force")))
    {
      i = 0;
      wWe.encode("PH_KEY_CRASH_TIMES_INT", 0);
      ae.i(TAG, "force enable");
    }
    if ((i < 3) && ("1".equals(paramMap.get(".cmd.diagnostic.PthreadHook.$enable")))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      wWe.encode("PH_KEY_ENABLE_BOOLEAN_v2", bool1);
      if (!bool1) {
        break label584;
      }
      localObject2 = (String)paramMap.get(".cmd.diagnostic.PthreadHook.$hook");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      ae.e(TAG, "ERROR(PthreadHook): hook regex is blank");
      AppMethodBeat.o(215423);
      return;
    }
    String str = (String)paramMap.get(".cmd.diagnostic.PthreadHook.$ignore");
    Object localObject1 = (String)paramMap.get(".cmd.diagnostic.PthreadHook.$thread");
    i = bu.getInt((String)paramMap.get(".cmd.diagnostic.PthreadHook.$duration"), 0);
    int j = bu.getInt((String)paramMap.get(".cmd.diagnostic.PthreadHook.$dumpcycle"), 30);
    bool1 = "1".equals(paramMap.get(".cmd.diagnostic.PthreadHook.$multiprocess"));
    wWe.encode("PH_KEY_HOOK_SO_STRING", (String)localObject2);
    wWe.encode("PH_KEY_IGNORE_SO_STRING", str);
    wWe.encode("PH_KEY_HOOK_THREAD_STRING", (String)localObject1);
    wWe.encode("PH_KEY_DURATION_MILLIS_LONG", i * 60 * 60 * 1000L);
    wWe.encode("PH_KEY_MULTI_PROCESS_BOOLEAN", bool1);
    wWe.encode("PH_KEY_DUMP_CYCLE_MILLIS_LONG", j * 60 * 1000L);
    wWe.encode("PH_KEY_BEGIN_TIME_LONG", -1L);
    if (bool2)
    {
      ae.i(TAG, "already enabled now, pls restart process");
      AppMethodBeat.o(215423);
      return;
    }
    Assert.assertNotNull(localObject2);
    ae.i(TAG, "hook immediately");
    Object localObject2 = ((String)localObject2).split(";");
    if (str == null)
    {
      paramMap = new String[0];
      if (localObject1 != null) {
        break label556;
      }
      localObject1 = new String[1];
      localObject1[0] = ".*";
    }
    for (;;)
    {
      ae.i(TAG, "hookRegex = %s", new Object[] { Arrays.toString((Object[])localObject2) });
      ae.i(TAG, "ignoreRegex = %s", new Object[] { Arrays.toString(paramMap) });
      ae.i(TAG, "threadRegex = %s", new Object[] { Arrays.toString((Object[])localObject1) });
      try
      {
        paramMap = PthreadHook.MLM.ai((String[])localObject2).aj(paramMap).ak((String[])localObject1);
        HookManager.MLy.geK().a(paramMap).geJ();
        wWe.encode("PH_KEY_BEGIN_TIME_LONG", System.currentTimeMillis());
        PthreadHookReporter.install();
        AppMethodBeat.o(215423);
        return;
      }
      catch (Throwable paramMap)
      {
        label556:
        ae.printErrStackTrace(TAG, paramMap, "PthreadHook Error", new Object[0]);
      }
      paramMap = str.split(";");
      break;
      localObject1 = ((String)localObject1).split(";");
    }
    label584:
    AppMethodBeat.o(215423);
  }
  
  public final String bfd()
  {
    AppMethodBeat.i(215430);
    if (this.sb != null)
    {
      localObject = this.sb.toString();
      AppMethodBeat.o(215430);
      return localObject;
    }
    ae.d(TAG, "onCrash");
    boolean bool = wWe.decodeBool("PH_KEY_ENABLE_BOOLEAN_v2", false);
    int j = wWe.decodeInt("PH_KEY_CRASH_TIMES_INT", 0);
    this.sb = new StringBuilder("PtheadHookConfig:\n");
    this.sb.append("enable=").append(bool).append(",");
    int i = j;
    if (bool)
    {
      localObject = this.sb.append("hook=").append(wWe.decodeString("PH_KEY_HOOK_SO_STRING", "")).append(",thread=").append(wWe.decodeString("PH_KEY_HOOK_THREAD_STRING", "")).append(",duration=").append(wWe.decodeLong("PH_KEY_DURATION_MILLIS_LONG", 0L)).append(",begin=").append(c.yN(wWe.decodeLong("PH_KEY_BEGIN_TIME_LONG", 0L))).append(",crashTimes=");
      i = j + 1;
      ((StringBuilder)localObject).append(i);
      wWe.encode("PH_KEY_CRASH_TIMES_INT", i);
      dBY();
      R(new k(w.B(wWW.fTh())));
    }
    if ((bool) && (i > 3))
    {
      wWe.encode("PH_KEY_ENABLE_BOOLEAN_v2", false);
      ae.e(TAG, "crash happens 3 times, disable hook");
      g.yxI.n(1376L, 1L, 1L);
    }
    Object localObject = this.sb.toString();
    AppMethodBeat.o(215430);
    return localObject;
  }
  
  public final String dBO()
  {
    return ".cmd.diagnostic.PthreadHook";
  }
  
  public static final class PthreadHookReporter
    extends BroadcastReceiver
  {
    private static final String wWZ;
    private static PthreadHookReporter wXg;
    
    static
    {
      AppMethodBeat.i(215422);
      wWZ = PthreadHookLogic.TAG + "-reporter";
      wXg = null;
      AppMethodBeat.o(215422);
    }
    
    static void dBW()
    {
      AppMethodBeat.i(215420);
      Intent localIntent = new Intent("com.tencent.mm.pthreadhook.dump");
      localIntent.putExtra("op", 1);
      localIntent.putExtra("log_file", w.B(PthreadHookLogic.dBV().fTh()));
      ak.getContext().sendBroadcast(localIntent);
      AppMethodBeat.o(215420);
    }
    
    /* Error */
    public static void install()
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 99
      //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: getstatic 44	com/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter:wXg	Lcom/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter;
      //   11: ifnull +12 -> 23
      //   14: ldc 99
      //   16: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: ldc 2
      //   21: monitorexit
      //   22: return
      //   23: new 2	com/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter
      //   26: dup
      //   27: invokespecial 100	com/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter:<init>	()V
      //   30: putstatic 44	com/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter:wXg	Lcom/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter;
      //   33: new 102	android/content/IntentFilter
      //   36: dup
      //   37: ldc 55
      //   39: invokespecial 103	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
      //   42: astore_0
      //   43: invokestatic 91	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
      //   46: getstatic 44	com/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter:wXg	Lcom/tencent/mm/plugin/performance/diagnostic/pthread/PthreadHookLogic$PthreadHookReporter;
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
      AppMethodBeat.i(215419);
      Intent localIntent = new Intent("com.tencent.mm.pthreadhook.dump");
      localIntent.putExtra("op", 0);
      ak.getContext().sendBroadcast(localIntent);
      AppMethodBeat.o(215419);
    }
    
    public final void onReceive(final Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(215421);
      final int i = paramIntent.getIntExtra("op", 0);
      paramContext = paramIntent.getStringExtra("log_file");
      h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215417);
          switch (i)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(215417);
            return;
            ae.i(PthreadHookLogic.TAG, "current process...[%s]", new Object[] { ak.getProcessName() });
            PthreadHookLogic.access$200();
            PthreadHookLogic.PthreadHookReporter.dBW();
            AppMethodBeat.o(215417);
            return;
            if (!ak.coh())
            {
              AppMethodBeat.o(215417);
              return;
            }
            PthreadHookLogic.S(new k(paramContext));
          }
        }
      }, wWZ);
      AppMethodBeat.o(215421);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.pthread.PthreadHookLogic
 * JD-Core Version:    0.7.0.1
 */