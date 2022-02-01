package com.tencent.mm.plugin.performance;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.e.d.e;
import com.tencent.e.d.f;
import com.tencent.e.g.b;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n;
import com.tencent.mm.app.o;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.PluginExpt;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.b.a.k;
import com.tencent.mm.plugin.performance.c.e;
import com.tencent.mm.plugin.performance.diagnostic.memory.MemoryHookLogic;
import com.tencent.mm.plugin.performance.diagnostic.memory.MemoryHookLogic.MemoryHookReporter;
import com.tencent.mm.plugin.performance.diagnostic.pthread.PthreadHookLogic;
import com.tencent.mm.plugin.performance.diagnostic.pthread.PthreadHookLogic.PthreadHookReporter;
import com.tencent.mm.plugin.performance.elf.AbstractProcessChecker;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.wxperf.jni.HookManager;
import com.tencent.wxperf.jni.HookManager.a;
import com.tencent.wxperf.jni.memory.MemoryHook;
import com.tencent.wxperf.jni.pthread.PthreadHook;
import java.util.Arrays;
import java.util.Set;

public class PluginPerformance
  extends f
  implements n, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.performance.a.d
{
  private com.tencent.mm.plugin.performance.b.a wGg;
  a wGh;
  
  public PluginPerformance()
  {
    AppMethodBeat.i(184687);
    this.wGg = new com.tencent.mm.plugin.performance.b.a();
    AppMethodBeat.o(184687);
  }
  
  private void setupBitmapDecodeCanary(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124904);
    MMBitmapFactory.setDecodeCanary(new PluginPerformance.2(this, paramg));
    AppMethodBeat.o(124904);
  }
  
  private void setupMemoryWatchDog()
  {
    AppMethodBeat.i(211735);
    com.tencent.mm.plugin.performance.c.c localc = com.tencent.mm.plugin.performance.c.c.dyZ();
    localc.wJZ = localc.aJm.getMemoryClass();
    localc.wKa = localc.aJm.getLargeMemoryClass();
    ((Application)aj.getContext()).registerActivityLifecycleCallbacks(localc);
    com.tencent.e.i locali = h.LTJ;
    if (localc.cBJ) {}
    double d;
    for (long l = 300000L;; l = 1800000L)
    {
      locali.r(localc, l);
      d = Math.random();
      if (d < 1.0D / ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIc, 100000)) {
        break;
      }
      ad.i("MicroMsg.PluginPerformance", "NOT report memory info after boot (%s)", new Object[] { Double.valueOf(d) });
      AppMethodBeat.o(211735);
      return;
    }
    ad.i("MicroMsg.PluginPerformance", "will repot memory info after boot (%s)", new Object[] { Double.valueOf(d) });
    com.tencent.mm.kernel.g.ajD().a(new PluginPerformance.1(this));
    AppMethodBeat.o(211735);
  }
  
  private void setupWxperf()
  {
    AppMethodBeat.i(211736);
    Object localObject4 = (MemoryHookLogic)com.tencent.mm.plugin.performance.a.a.wGn.aR(MemoryHookLogic.class);
    Object localObject3 = null;
    Object localObject1;
    boolean bool1;
    int i;
    int j;
    double d;
    boolean bool2;
    boolean bool3;
    if (MemoryHookLogic.dyE())
    {
      localObject1 = null;
      if (MemoryHookLogic.dyC())
      {
        localObject5 = MemoryHookLogic.wGr.decodeString("MH_KEY_HOOK_SO_STRING", "");
        localObject1 = MemoryHookLogic.wGr.decodeString("MH_KEY_IGNORE_SO_STRING", "");
        bool1 = MemoryHookLogic.wGr.decodeBool("MH_KEY_ENABLE_STACKTRACE_BOOLEAN", false);
        i = MemoryHookLogic.wGr.decodeInt("MH_KEY_MIN_TRACE_SIZE_INT", 0);
        j = MemoryHookLogic.wGr.decodeInt("MH_KEY_MAX_TRACE_SIZE_INT", 0);
        d = MemoryHookLogic.wGr.aQC("MH_KEY_SAMPLING_DOUBLE");
        bool2 = MemoryHookLogic.wGr.decodeBool("MH_KEY_EXTREME_BOOLEAN", false);
        bool3 = MemoryHookLogic.wGr.decodeBool("MH_KEY_ENABLE_MMAP_BOOLEAN", false);
        ad.i(MemoryHookLogic.TAG, "hook:%s, ignore:%s, enableStacktrace:%s, min:%d, max:%d, sampling:%f, extreme:%s, mmap:%s", new Object[] { localObject5, localObject1, Boolean.valueOf(bool1), Integer.valueOf(i), Integer.valueOf(j), Double.valueOf(d), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
          break label520;
        }
        ad.e(MemoryHookLogic.TAG, "ERROR(MemoryHook): hook regex is blank");
        localObject1 = null;
      }
      localObject3 = localObject1;
      if (localObject1 != null)
      {
        ((MemoryHookLogic)localObject4).dyD();
        MemoryHookLogic.MemoryHookReporter.install();
        ad.i(MemoryHookLogic.TAG, "register Reporter");
        localObject3 = localObject1;
      }
    }
    Object localObject5 = (PthreadHookLogic)com.tencent.mm.plugin.performance.a.a.wGn.aR(PthreadHookLogic.class);
    ad.i(PthreadHookLogic.TAG, "configurePthreadHook");
    if (PthreadHookLogic.dyE())
    {
      localObject1 = null;
      if (PthreadHookLogic.dyC())
      {
        Object localObject6 = PthreadHookLogic.wGr.decodeString("PH_KEY_HOOK_SO_STRING", "");
        localObject1 = PthreadHookLogic.wGr.decodeString("PH_KEY_IGNORE_SO_STRING", "");
        localObject4 = PthreadHookLogic.wGr.decodeString("PH_KEY_HOOK_THREAD_STRING", "");
        localObject6 = ((String)localObject6).split(";");
        if (localObject1 == null)
        {
          localObject1 = new String[0];
          label341:
          if (localObject4 != null) {
            break label711;
          }
          localObject4 = new String[1];
          localObject4[0] = ".*";
          ad.i(PthreadHookLogic.TAG, "hookRegex = %s", new Object[] { Arrays.toString((Object[])localObject6) });
          ad.i(PthreadHookLogic.TAG, "ignoreRegex = %s", new Object[] { Arrays.toString((Object[])localObject1) });
          ad.i(PthreadHookLogic.TAG, "threadRegex = %s", new Object[] { Arrays.toString((Object[])localObject4) });
          localObject1 = PthreadHook.MoQ.ai((String[])localObject6).aj((String[])localObject1).ak((String[])localObject4);
        }
      }
      else if (localObject1 != null)
      {
        PthreadHookLogic.PthreadHookReporter.install();
        ((PthreadHookLogic)localObject5).dyD();
      }
    }
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.PluginPerformance", "memoryHook = %s, pthreadHook = %s, eglHook = %s", new Object[] { localObject3, localObject1, "eglHook" });
        HookManager.MoC.a((com.tencent.wxperf.jni.a)localObject3).a((com.tencent.wxperf.jni.a)localObject1).gah();
        com.tencent.mm.sdk.a.b.b((c.a)com.tencent.mm.plugin.performance.a.a.wGn.aR(PthreadHookLogic.class));
        AppMethodBeat.o(211736);
        return;
        label520:
        localObject3 = localObject1;
        if (!bool2)
        {
          localObject3 = localObject1;
          if (!((String)localObject1).endsWith(";")) {
            localObject3 = (String)localObject1 + ";";
          }
          localObject3 = (String)localObject3 + ".*libutils\\.so$;.*libcutils\\.so$;.*libskia\\.so$;.*libbinder.*\\.so$;.*libhwbinder\\.so$;.*libicuuc\\.so$;.*libicui18n\\.so$;.*libart.*\\.so$;.*libandroidfw\\.so$;.*libandroid_runtime\\.so$;.*libjavacore\\.so$;.*libopenjdk.*\\.so$;.*libmemfence\\.so$";
        }
        localObject1 = ((String)localObject5).split(";");
        localObject3 = ((String)localObject3).split(";");
        localObject1 = MemoryHook.MoI.ag((String[])localObject1).ah((String[])localObject3);
        ((MemoryHook)localObject1).MoO = bool1;
        ((MemoryHook)localObject1).MoL = i;
        ((MemoryHook)localObject1).MoM = j;
        localObject1 = ((MemoryHook)localObject1).F(d);
        ((MemoryHook)localObject1).MoP = bool3;
        com.tencent.mm.plugin.report.service.g.yhR.f(18261, new Object[] { aj.getProcessName(), Integer.valueOf(Process.myPid()), Integer.valueOf(0) });
        break;
        localObject1 = ((String)localObject1).split(";");
        break label341;
        label711:
        localObject4 = ((String)localObject4).split(";");
      }
      catch (HookManager.a locala)
      {
        ad.printErrStackTrace("MicroMsg.PluginPerformance", locala, "Hook error", new Object[0]);
        continue;
      }
      Object localObject2 = null;
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g arg1)
  {
    AppMethodBeat.i(124902);
    com.tencent.mm.cj.c.IRw = new b.1();
    com.tencent.mm.plugin.performance.a.a.wGn.a(new MemoryHookLogic());
    com.tencent.mm.plugin.performance.a.a.wGn.a(new com.tencent.mm.plugin.performance.diagnostic.b());
    com.tencent.mm.plugin.performance.a.a.wGn.a(new com.tencent.mm.plugin.performance.diagnostic.a.c());
    com.tencent.mm.plugin.performance.a.a.wGn.a(new PthreadHookLogic());
    com.tencent.mm.plugin.performance.b.a locala = this.wGg;
    boolean bool = ???.akw();
    ad.i("ThreadPool.Profiler", "[open] isProcessMain=".concat(String.valueOf(bool)));
    if ((com.tencent.mm.plugin.performance.b.a.cFj) && (bool))
    {
      ??? = new ap("reportStatistics");
      ???.postDelayed((Runnable)new a.k(locala, ???), 1800000L);
      AppForegroundDelegate.cSQ.a((n)locala);
      locala.wII.az(600000L, 600000L);
    }
    AppForegroundDelegate localAppForegroundDelegate = AppForegroundDelegate.cSQ;
    o localo = (o)locala;
    synchronized (localAppForegroundDelegate.cSU)
    {
      localAppForegroundDelegate.cSU.add(localo);
      com.tencent.e.d.LTw = (d.e)locala.wIB;
      com.tencent.e.d.LTx = (d.f)locala.wIz;
      com.tencent.e.a.LTd = (g.b)locala.wIA;
      AppMethodBeat.o(124902);
      return;
    }
  }
  
  public void dependency()
  {
    AppMethodBeat.i(124901);
    dependsOn(PluginReport.class);
    dependsOn(PluginExpt.class);
    dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    AppMethodBeat.o(124901);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124903);
    Object localObject;
    if (aj.fkG()) {
      localObject = com.tencent.mm.plugin.performance.elf.b.wIg;
    }
    com.tencent.e.i locali;
    try
    {
      ((com.tencent.mm.plugin.performance.elf.b)localObject).cMW = com.tencent.mm.plugin.performance.elf.b.bn(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsy, 0) / 10000.0F);
      com.tencent.mm.plugin.performance.elf.b.wIa = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsB, 1200000L);
      ad.i("MicroMsg.ProcessElf", "[call] isEnable:%b CHECK_TIME:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.performance.elf.b)localObject).cMW), Long.valueOf(com.tencent.mm.plugin.performance.elf.b.dyL()) });
      if (((com.tencent.mm.plugin.performance.elf.b)localObject).cMW)
      {
        com.tencent.mm.plugin.performance.elf.b.wHx.removeCallbacks(com.tencent.mm.plugin.performance.elf.b.wIi);
        com.tencent.mm.plugin.performance.elf.b.wHx.postDelayed(com.tencent.mm.plugin.performance.elf.b.wIi, com.tencent.mm.plugin.performance.elf.b.dyL());
      }
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("ACTION_ELF_CHECK_RESPONSE");
      ((IntentFilter)localObject).addAction("com.tencent.mm.MMUIModeManager");
      aj.getContext().registerReceiver(com.tencent.mm.plugin.performance.elf.b.wIh, (IntentFilter)localObject);
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.ae.a());
      setupMemoryWatchDog();
      paramg.ca.registerActivityLifecycleCallbacks(new e());
      localObject = com.tencent.mm.plugin.performance.c.a.dyX();
      h.LTJ.r((Runnable)localObject, 1800000L);
      localObject = com.tencent.mm.plugin.performance.c.d.dzd();
      if (!aj.cmR())
      {
        ad.e("MicroMsg.ProcessWatchDog", "NOT main process");
        setupWxperf();
        setupBitmapDecodeCanary(paramg);
        this.wGh = a.aum(paramg.mProcessName);
        localObject = this.wGh;
        ((a)localObject).mState = ((a)localObject).cBy.decodeInt("state", 0);
        ad.d("MicroMsg.ForegroundKilledDetect", "%s: CHECK LAST STATE = %s", new Object[] { ((a)localObject).mProcessName, Integer.toBinaryString(((a)localObject).mState) });
        if ((((a)localObject).dys()) && (((a)localObject).dyt()) && (!((a)localObject).dyu()))
        {
          ad.e("MicroMsg.ForegroundKilledDetect", "%s: LAST STATE ERROR: %s", new Object[] { ((a)localObject).mProcessName, Integer.toBinaryString(((a)localObject).mState) });
          com.tencent.mm.kernel.g.ajD().a(new a.1((a)localObject));
        }
        ((a)localObject).My(1);
        ((a)localObject).My(2);
        ((a)localObject).My(4);
        ((a)localObject).dyv();
        this.wGh.onAppForeground("boot");
        paramg.ca.registerActivityLifecycleCallbacks(this.wGh);
        com.tencent.mm.sdk.a.b.b(this.wGh);
        AppMethodBeat.o(124903);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ProcessElf", localException, "", new Object[0]);
        com.tencent.mm.plugin.performance.elf.b.wIa = 1200000L;
        ((com.tencent.mm.plugin.performance.elf.b)localObject).cMW = com.tencent.mm.plugin.performance.elf.b.DEBUG;
      }
      locali = h.LTJ;
      if (!((com.tencent.mm.plugin.performance.c.d)localObject).cBJ) {}
    }
    for (long l = 300000L;; l = 1800000L)
    {
      locali.r((Runnable)localObject, l);
      break;
    }
  }
  
  public com.tencent.mm.plugin.performance.b.a getThreadPoolProfiler()
  {
    return this.wGg;
  }
  
  public void installed()
  {
    AppMethodBeat.i(124900);
    alias(com.tencent.mm.plugin.performance.a.d.class);
    AppMethodBeat.o(124900);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(124905);
    if (aj.cmR())
    {
      com.tencent.mm.kernel.g.ajF().n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211734);
          ((MainProcessChecker)com.tencent.mm.plugin.performance.elf.a.aS(MainProcessChecker.class)).start();
          AppMethodBeat.o(211734);
        }
      }, 2000L);
      if ((!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) && (!com.tencent.mm.protocal.d.Fnm) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBP, 0) != 1)) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      AppForegroundDelegate.cST = bool;
      AppMethodBeat.o(124905);
      return;
    }
  }
  
  public void onAccountRelease() {}
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(124907);
    com.tencent.mm.plugin.performance.elf.a.aS(MainProcessChecker.class).bV(false);
    com.tencent.mm.plugin.performance.c.c.dyZ().cBJ = false;
    com.tencent.mm.plugin.performance.c.d.dzd().cBJ = false;
    if (this.wGh != null) {
      this.wGh.onAppBackground(paramString);
    }
    AppMethodBeat.o(124907);
  }
  
  public void onAppForeground(String paramString)
  {
    AppMethodBeat.i(124906);
    com.tencent.mm.plugin.performance.elf.a.aS(MainProcessChecker.class).bV(true);
    com.tencent.mm.plugin.performance.c.c.dyZ().cBJ = true;
    com.tencent.mm.plugin.performance.c.d.dzd().cBJ = true;
    if (this.wGh != null) {
      this.wGh.onAppForeground(paramString);
    }
    AppMethodBeat.o(124906);
  }
  
  public String toString()
  {
    return "plugin-performance";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.PluginPerformance
 * JD-Core Version:    0.7.0.1
 */