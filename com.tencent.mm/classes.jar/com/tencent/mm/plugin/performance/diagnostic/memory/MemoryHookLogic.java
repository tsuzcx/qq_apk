package com.tencent.mm.plugin.performance.diagnostic.memory;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.c;
import com.tencent.mm.plugin.performance.diagnostic.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
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
  private static final e wHi;
  private static final e wHj;
  
  static
  {
    AppMethodBeat.i(124967);
    TAG = "MicroMsg.MemoryHookLogic";
    String str2 = aj.getProcessName();
    String str1 = "MM_";
    if (str2.contains(":tools"))
    {
      str1 = "tools_";
      TAG += ":tools";
    }
    for (;;)
    {
      str2 = aj.getContext().getFilesDir().getAbsolutePath() + "/memory_hook";
      str1 = str2 + "/" + str1 + Process.myPid() + "_memory_hook.log";
      wHi = new e(str2);
      wHj = new e(str1);
      ad.d(TAG, "init dump file dir = %s", new Object[] { str2 });
      ad.i(TAG, "init dump file path = %s", new Object[] { str1 });
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
  
  public static boolean dyC()
  {
    AppMethodBeat.i(211744);
    boolean bool2 = wGr.decodeBool("MH_KEY_ENABLE_BOOLEAN", false);
    ad.i(TAG, "enableMemoryHook = %s for process [%s]", new Object[] { Boolean.valueOf(bool2), aj.getProcessName() });
    boolean bool1 = bool2;
    long l1;
    long l2;
    if (bool2)
    {
      l1 = wGr.decodeLong("MH_KEY_DURATION_MILLIS_LONG", 0L);
      l2 = wGr.decodeLong("MH_KEY_BEGIN_TIME_LONG", -1L);
      ad.i(TAG, "hook duration = %s, hook begin time = %s", new Object[] { Long.valueOf(l1), c.yt(l2) });
      if (l2 >= 0L) {
        break label145;
      }
      l1 = System.currentTimeMillis();
      wGr.encode("MH_KEY_BEGIN_TIME_LONG", l1);
      ad.i(TAG, "update hookBeginTime = %s", new Object[] { Long.valueOf(l1) });
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(211744);
      return bool1;
      label145:
      bool1 = bool2;
      if (System.currentTimeMillis() - l2 > l1)
      {
        wGr.encode("MH_KEY_ENABLE_BOOLEAN", false);
        ad.i(TAG, "time out, disable hook");
        bool1 = false;
      }
    }
  }
  
  public static boolean dyE()
  {
    AppMethodBeat.i(124964);
    String str = aj.getProcessName();
    boolean bool = wGr.decodeBool("MH_KEY_MULTI_PROCESS_BOOLEAN", false);
    ad.i(TAG, "enable multiProcess = %s", new Object[] { Boolean.valueOf(bool) });
    if ((aj.cmR()) || ((bool) && ((str.endsWith(":tools")) || (str.contains(":appbrand")))))
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
    MemoryHookLogic.MemoryHookReporter.report();
    AppMethodBeat.o(124961);
  }
  
  public final void av(Map<String, String> paramMap)
  {
    AppMethodBeat.i(124960);
    ad.i(TAG, "onReceiveIpxxCmd:[%s]", new Object[] { paramMap });
    boolean bool2 = wGr.decodeBool("MH_KEY_ENABLE_BOOLEAN", false);
    boolean bool1 = wGr.decodeBool("MH_KEY_EXPT_ENABLE_BOOLEAN", true);
    ad.d(TAG, "isExptEnabled = ".concat(String.valueOf(bool1)));
    if (("1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$expt"))) && ((!bool1) || (bool2)))
    {
      localObject = TAG;
      paramMap = paramMap.get(".cmd.diagnostic.MemoryHook" + ".$expt");
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        ad.i((String)localObject, "skip config from expt cause [.$expt = %s && (!isExptEnabled = %s || isEnabledNow = %s)]", new Object[] { paramMap, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(124960);
        return;
      }
    }
    if ((paramMap.get(".cmd.diagnostic.MemoryHook" + ".$enableExpt") == null) || ("1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$enableExpt")))) {}
    String str;
    for (bool1 = true;; bool1 = false)
    {
      wGr.encode("MH_KEY_EXPT_ENABLE_BOOLEAN", bool1);
      ad.d(TAG, "cmd enableExpt = %s, expt = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf("1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$expt"))) });
      bool1 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$enable"));
      wGr.encode("MH_KEY_ENABLE_BOOLEAN", bool1);
      if (!bool1) {
        break label1295;
      }
      str = (String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$hook");
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      ad.e(TAG, "ERROR(MemoryHook): hook regex is blank");
      AppMethodBeat.o(124960);
      return;
    }
    Object localObject = (String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$ignore");
    bool1 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$stack"));
    int i = bt.getInt((String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$min"), 0);
    int j = bt.getInt((String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$max"), 0);
    double d = bt.getDouble((String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$sampling"), 1.0D);
    int k = bt.getInt((String)paramMap.get(".cmd.diagnostic.MemoryHook" + ".$duration"), 0);
    boolean bool3 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$multiprocess"));
    boolean bool4 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$force"));
    boolean bool5 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$extreme"));
    boolean bool6 = "1".equals(paramMap.get(".cmd.diagnostic.MemoryHook" + ".$mmap"));
    wGr.encode("MH_KEY_HOOK_SO_STRING", str);
    wGr.encode("MH_KEY_IGNORE_SO_STRING", (String)localObject);
    wGr.encode("MH_KEY_ENABLE_STACKTRACE_BOOLEAN", bool1);
    wGr.encode("MH_KEY_MIN_TRACE_SIZE_INT", i);
    wGr.encode("MH_KEY_MAX_TRACE_SIZE_INT", j);
    paramMap = wGr;
    if (paramMap.y("MH_KEY_SAMPLING_DOUBLE", Double.valueOf(d))) {
      paramMap.IeH.encode("MH_KEY_SAMPLING_DOUBLE", d);
    }
    wGr.encode("MH_KEY_DURATION_MILLIS_LONG", k * 60 * 60 * 1000L);
    wGr.encode("MH_KEY_MULTI_PROCESS_BOOLEAN", bool3);
    wGr.encode("MH_KEY_BEGIN_TIME_LONG", -1L);
    wGr.encode("MH_KEY_EXTREME_BOOLEAN", bool5);
    wGr.encode("MH_KEY_ENABLE_MMAP_BOOLEAN", bool6);
    paramMap = (Map<String, String>)localObject;
    if (!bool5)
    {
      if (localObject == null) {
        paramMap = ".*libutils\\.so$;.*libcutils\\.so$;.*libskia\\.so$;.*libbinder.*\\.so$;.*libhwbinder\\.so$;.*libicuuc\\.so$;.*libicui18n\\.so$;.*libart.*\\.so$;.*libandroidfw\\.so$;.*libandroid_runtime\\.so$;.*libjavacore\\.so$;.*libopenjdk.*\\.so$;.*libmemfence\\.so$";
      }
    }
    else
    {
      if (((bool2) && (!bool4)) || (!dyE())) {
        break label1295;
      }
      ad.i(TAG, "hook immediately");
      Assert.assertNotNull(str);
      localObject = str.split(";");
      if (paramMap != null) {
        break label1269;
      }
    }
    label1269:
    for (paramMap = new String[0];; paramMap = paramMap.split(";"))
    {
      ad.i(TAG, "hookRegex = %s", new Object[] { Arrays.toString((Object[])localObject) });
      ad.i(TAG, "ignoreRegex = %s", new Object[] { Arrays.toString(paramMap) });
      try
      {
        paramMap = MemoryHook.MoI.ag((String[])localObject).ah(paramMap);
        paramMap.MoO = bool1;
        paramMap.MoL = i;
        paramMap.MoM = j;
        paramMap = paramMap.F(d);
        paramMap.MoP = bool6;
        HookManager.MoC.gai().a(paramMap).gah();
        wGr.encode("MH_KEY_BEGIN_TIME_LONG", System.currentTimeMillis());
        ad.i(TAG, "register Reporter");
        MemoryHookLogic.MemoryHookReporter.install();
        dyD();
        g.yhR.f(18261, new Object[] { aj.getProcessName(), Integer.valueOf(Process.myPid()), Integer.valueOf(1) });
        AppMethodBeat.o(124960);
        return;
      }
      catch (Throwable paramMap)
      {
        ad.printErrStackTrace(TAG, paramMap, "MemoryHook Error", new Object[0]);
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
  
  public final void dyD()
  {
    AppMethodBeat.i(124963);
    final String str = TAG + "-repeat";
    h.LTJ.aZz(str);
    h.LTJ.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124951);
        if (a.wGr.decodeBool("MH_KEY_ENABLE_BOOLEAN", false))
        {
          MemoryHookLogic.report();
          h.LTJ.a(this, 1800000L, str);
        }
        AppMethodBeat.o(124951);
      }
    }, 1800000L, str);
    AppMethodBeat.o(124963);
  }
  
  public final String dyy()
  {
    return ".cmd.diagnostic.MemoryHook";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.memory.MemoryHookLogic
 * JD-Core Version:    0.7.0.1
 */