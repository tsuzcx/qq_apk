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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.app.p;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.wxperf.jni.HookManager;
import com.tencent.wxperf.jni.HookManager.a;
import com.tencent.wxperf.jni.memory.MemoryHook;
import com.tencent.wxperf.jni.pthread.PthreadHook;
import java.util.Arrays;
import java.util.Set;

public class PluginPerformance
  extends f
  implements o, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.performance.a.d
{
  private com.tencent.mm.plugin.performance.b.a wVT;
  a wVU;
  
  public PluginPerformance()
  {
    AppMethodBeat.i(184687);
    this.wVT = new com.tencent.mm.plugin.performance.b.a();
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
    AppMethodBeat.i(215406);
    com.tencent.mm.plugin.performance.c.c localc = com.tencent.mm.plugin.performance.c.c.dCq();
    localc.wZK = localc.aJm.getMemoryClass();
    localc.wZL = localc.aJm.getLargeMemoryClass();
    ((Application)ak.getContext()).registerActivityLifecycleCallbacks(localc);
    i locali = h.MqF;
    if (localc.cCq) {}
    double d;
    for (long l = 300000L;; l = 1800000L)
    {
      locali.r(localc, l);
      d = Math.random();
      if (d < 1.0D / ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPI, 100000)) {
        break;
      }
      ae.i("MicroMsg.PluginPerformance", "NOT report memory info after boot (%s)", new Object[] { Double.valueOf(d) });
      AppMethodBeat.o(215406);
      return;
    }
    ae.i("MicroMsg.PluginPerformance", "will repot memory info after boot (%s)", new Object[] { Double.valueOf(d) });
    com.tencent.mm.kernel.g.ajS().a(new com.tencent.mm.kernel.api.g()
    {
      public final void ML()
      {
        AppMethodBeat.i(215402);
        h.MqF.r(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(124897);
            com.tencent.mm.plugin.performance.c.b.a(com.tencent.mm.plugin.performance.c.c.dCq().P(true, 0), c.dBN().toArray());
            AppMethodBeat.o(124897);
          }
        }, 10000L);
        com.tencent.mm.kernel.g.ajS().b(this);
        AppMethodBeat.o(215402);
      }
      
      public final void ch(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(215406);
  }
  
  private void setupWxperf()
  {
    AppMethodBeat.i(215407);
    Object localObject3 = (MemoryHookLogic)com.tencent.mm.plugin.performance.a.a.wWa.aR(MemoryHookLogic.class);
    Object localObject1;
    Object localObject4;
    boolean bool1;
    int i;
    int j;
    double d;
    boolean bool2;
    boolean bool3;
    if (MemoryHookLogic.dBU())
    {
      localObject1 = null;
      if (MemoryHookLogic.dBS())
      {
        localObject4 = MemoryHookLogic.wWe.decodeString("MH_KEY_HOOK_SO_STRING", "");
        localObject1 = MemoryHookLogic.wWe.decodeString("MH_KEY_IGNORE_SO_STRING", "");
        bool1 = MemoryHookLogic.wWe.decodeBool("MH_KEY_ENABLE_STACKTRACE_BOOLEAN", false);
        i = MemoryHookLogic.wWe.decodeInt("MH_KEY_MIN_TRACE_SIZE_INT", 0);
        j = MemoryHookLogic.wWe.decodeInt("MH_KEY_MAX_TRACE_SIZE_INT", 0);
        d = MemoryHookLogic.wWe.aRZ("MH_KEY_SAMPLING_DOUBLE");
        bool2 = MemoryHookLogic.wWe.decodeBool("MH_KEY_EXTREME_BOOLEAN", false);
        bool3 = MemoryHookLogic.wWe.decodeBool("MH_KEY_ENABLE_MMAP_BOOLEAN", false);
        ae.i(MemoryHookLogic.TAG, "hook:%s, ignore:%s, enableStacktrace:%s, min:%d, max:%d, sampling:%f, extreme:%s, mmap:%s", new Object[] { localObject4, localObject1, Boolean.valueOf(bool1), Integer.valueOf(i), Integer.valueOf(j), Double.valueOf(d), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          ae.e(MemoryHookLogic.TAG, "ERROR(MemoryHook): hook regex is blank");
          localObject1 = null;
        }
      }
      else if (localObject1 != null)
      {
        ((MemoryHookLogic)localObject3).dBT();
        MemoryHookLogic.MemoryHookReporter.install();
        ae.i(MemoryHookLogic.TAG, "register Reporter");
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null) {
      for (;;)
      {
        com.tencent.mm.plugin.performance.a.a.wWa.aR(PthreadHookLogic.class);
        ae.i(PthreadHookLogic.TAG, "configurePthreadHook");
        localObject3 = null;
        if (PthreadHookLogic.dBU())
        {
          localObject1 = null;
          if (PthreadHookLogic.dBS())
          {
            localObject4 = PthreadHookLogic.wWe.decodeString("PH_KEY_HOOK_SO_STRING", "");
            localObject1 = PthreadHookLogic.wWe.decodeString("PH_KEY_IGNORE_SO_STRING", "");
            localObject3 = PthreadHookLogic.wWe.decodeString("PH_KEY_HOOK_THREAD_STRING", "");
            localObject4 = ((String)localObject4).split(";");
            if (localObject1 != null) {
              break label693;
            }
            localObject1 = new String[0];
            label333:
            if (localObject3 != null) {
              break label706;
            }
            localObject3 = new String[1];
            localObject3[0] = ".*";
            ae.i(PthreadHookLogic.TAG, "hookRegex = %s", new Object[] { Arrays.toString((Object[])localObject4) });
            ae.i(PthreadHookLogic.TAG, "ignoreRegex = %s", new Object[] { Arrays.toString((Object[])localObject1) });
            ae.i(PthreadHookLogic.TAG, "threadRegex = %s", new Object[] { Arrays.toString((Object[])localObject3) });
            localObject1 = PthreadHook.MLM.ai((String[])localObject4).aj((String[])localObject1).ak((String[])localObject3);
          }
          localObject3 = localObject1;
          if (localObject1 != null)
          {
            PthreadHookLogic.PthreadHookReporter.install();
            localObject3 = localObject1;
          }
        }
        try
        {
          ae.i("MicroMsg.PluginPerformance", "memoryHook = %s, pthreadHook = %s, eglHook = %s", new Object[] { localObject2, localObject3, "eglHook" });
          HookManager.MLy.a((com.tencent.wxperf.jni.a)localObject2).a((com.tencent.wxperf.jni.a)localObject3).geJ();
          com.tencent.mm.sdk.a.b.b((c.a)com.tencent.mm.plugin.performance.a.a.wWa.aR(PthreadHookLogic.class));
          AppMethodBeat.o(215407);
          return;
          localObject2 = localObject1;
          if (!bool2)
          {
            localObject2 = localObject1;
            if (!((String)localObject1).endsWith(";")) {
              localObject2 = (String)localObject1 + ";";
            }
            localObject2 = (String)localObject2 + ".*libutils\\.so$;.*libcutils\\.so$;.*libskia\\.so$;.*libbinder.*\\.so$;.*libhwbinder\\.so$;.*libicuuc\\.so$;.*libicui18n\\.so$;.*libart.*\\.so$;.*libandroidfw\\.so$;.*libandroid_runtime\\.so$;.*libjavacore\\.so$;.*libopenjdk.*\\.so$;.*libmemfence\\.so$";
          }
          localObject1 = ((String)localObject4).split(";");
          localObject2 = ((String)localObject2).split(";");
          localObject1 = MemoryHook.MLE.ag((String[])localObject1).ah((String[])localObject2);
          ((MemoryHook)localObject1).MLK = bool1;
          ((MemoryHook)localObject1).MLH = i;
          ((MemoryHook)localObject1).MLI = j;
          localObject1 = ((MemoryHook)localObject1).F(d);
          ((MemoryHook)localObject1).MLL = bool3;
          com.tencent.mm.plugin.report.service.g.yxI.f(18261, new Object[] { ak.getProcessName(), Integer.valueOf(Process.myPid()), Integer.valueOf(0) });
          break;
          label693:
          localObject1 = ((String)localObject1).split(";");
          break label333;
          label706:
          localObject3 = ((String)localObject3).split(";");
        }
        catch (HookManager.a locala)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.PluginPerformance", locala, "Hook error", new Object[0]);
          }
        }
      }
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g arg1)
  {
    AppMethodBeat.i(124902);
    com.tencent.mm.ci.c.Jme = new b.1();
    com.tencent.mm.plugin.performance.a.a.wWa.a(new MemoryHookLogic());
    com.tencent.mm.plugin.performance.a.a.wWa.a(new com.tencent.mm.plugin.performance.diagnostic.b());
    com.tencent.mm.plugin.performance.a.a.wWa.a(new com.tencent.mm.plugin.performance.diagnostic.a.c());
    com.tencent.mm.plugin.performance.a.a.wWa.a(new PthreadHookLogic());
    com.tencent.mm.plugin.performance.b.a locala = this.wVT;
    boolean bool = ???.akL();
    ae.i("ThreadPool.Profiler", "[open] isProcessMain=".concat(String.valueOf(bool)));
    if ((com.tencent.mm.plugin.performance.b.a.cFS) && (bool))
    {
      ??? = new aq("reportStatistics");
      ???.postDelayed((Runnable)new a.k(locala, ???), 1800000L);
      AppForegroundDelegate.cTA.a((o)locala);
      locala.wYt.ay(600000L, 600000L);
    }
    AppForegroundDelegate localAppForegroundDelegate = AppForegroundDelegate.cTA;
    p localp = (p)locala;
    synchronized (localAppForegroundDelegate.cTE)
    {
      localAppForegroundDelegate.cTE.add(localp);
      com.tencent.e.d.Mqt = (d.e)locala.wYm;
      com.tencent.e.d.Mqu = (d.f)locala.wYk;
      com.tencent.e.a.Mqa = (g.b)locala.wYl;
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
    if (ak.foA()) {
      localObject = com.tencent.mm.plugin.performance.elf.b.wXR;
    }
    i locali;
    try
    {
      ((com.tencent.mm.plugin.performance.elf.b)localObject).cNF = com.tencent.mm.plugin.performance.elf.b.bn(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzn, 0) / 10000.0F);
      com.tencent.mm.plugin.performance.elf.b.wXL = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzq, 1200000L);
      ae.i("MicroMsg.ProcessElf", "[call] isEnable:%b CHECK_TIME:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.performance.elf.b)localObject).cNF), Long.valueOf(com.tencent.mm.plugin.performance.elf.b.dCc()) });
      if (((com.tencent.mm.plugin.performance.elf.b)localObject).cNF)
      {
        com.tencent.mm.plugin.performance.elf.b.wXi.removeCallbacks(com.tencent.mm.plugin.performance.elf.b.wXT);
        com.tencent.mm.plugin.performance.elf.b.wXi.postDelayed(com.tencent.mm.plugin.performance.elf.b.wXT, com.tencent.mm.plugin.performance.elf.b.dCc());
      }
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("ACTION_ELF_CHECK_RESPONSE");
      ((IntentFilter)localObject).addAction("com.tencent.mm.MMUIModeManager");
      ak.getContext().registerReceiver(com.tencent.mm.plugin.performance.elf.b.wXS, (IntentFilter)localObject);
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.ad.a());
      setupMemoryWatchDog();
      paramg.ca.registerActivityLifecycleCallbacks(new e());
      localObject = com.tencent.mm.plugin.performance.c.a.dCo();
      h.MqF.r((Runnable)localObject, 1800000L);
      localObject = com.tencent.mm.plugin.performance.c.d.dCu();
      if (!ak.coh())
      {
        ae.e("MicroMsg.ProcessWatchDog", "NOT main process");
        setupWxperf();
        setupBitmapDecodeCanary(paramg);
        this.wVU = a.avB(paramg.mProcessName);
        localObject = this.wVU;
        ((a)localObject).mState = ((a)localObject).cCf.decodeInt("state", 0);
        ae.d("MicroMsg.ForegroundKilledDetect", "%s: CHECK LAST STATE = %s", new Object[] { ((a)localObject).mProcessName, Integer.toBinaryString(((a)localObject).mState) });
        if ((((a)localObject).dBI()) && (((a)localObject).dBJ()) && (!((a)localObject).dBK()))
        {
          ae.e("MicroMsg.ForegroundKilledDetect", "%s: LAST STATE ERROR: %s", new Object[] { ((a)localObject).mProcessName, Integer.toBinaryString(((a)localObject).mState) });
          com.tencent.mm.kernel.g.ajS().a(new a.1((a)localObject));
        }
        ((a)localObject).Ne(1);
        ((a)localObject).Ne(2);
        ((a)localObject).Ne(4);
        ((a)localObject).dBL();
        this.wVU.onAppForeground("boot");
        paramg.ca.registerActivityLifecycleCallbacks(this.wVU);
        com.tencent.mm.sdk.a.b.b(this.wVU);
        AppMethodBeat.o(124903);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.ProcessElf", localException, "", new Object[0]);
        com.tencent.mm.plugin.performance.elf.b.wXL = 1200000L;
        ((com.tencent.mm.plugin.performance.elf.b)localObject).cNF = com.tencent.mm.plugin.performance.elf.b.DEBUG;
      }
      locali = h.MqF;
      if (!((com.tencent.mm.plugin.performance.c.d)localObject).cCq) {}
    }
    for (long l = 300000L;; l = 1800000L)
    {
      locali.r((Runnable)localObject, l);
      break;
    }
  }
  
  public com.tencent.mm.plugin.performance.b.a getThreadPoolProfiler()
  {
    return this.wVT;
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
    if (ak.coh())
    {
      com.tencent.mm.kernel.g.ajU().n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215405);
          ((MainProcessChecker)com.tencent.mm.plugin.performance.elf.a.aS(MainProcessChecker.class)).start();
          AppMethodBeat.o(215405);
        }
      }, 2000L);
      if ((!j.IS_FLAVOR_PURPLE) && (!j.IS_FLAVOR_RED) && (!com.tencent.mm.protocal.d.FFK) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJk, 0) != 1)) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      AppForegroundDelegate.cTD = bool;
      AppMethodBeat.o(124905);
      return;
    }
  }
  
  public void onAccountRelease() {}
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(124907);
    com.tencent.mm.plugin.performance.elf.a.aS(MainProcessChecker.class).bV(false);
    com.tencent.mm.plugin.performance.c.c.dCq().cCq = false;
    com.tencent.mm.plugin.performance.c.d.dCu().cCq = false;
    if (this.wVU != null) {
      this.wVU.onAppBackground(paramString);
    }
    AppMethodBeat.o(124907);
  }
  
  public void onAppForeground(String paramString)
  {
    AppMethodBeat.i(124906);
    com.tencent.mm.plugin.performance.elf.a.aS(MainProcessChecker.class).bV(true);
    com.tencent.mm.plugin.performance.c.c.dCq().cCq = true;
    com.tencent.mm.plugin.performance.c.d.dCu().cCq = true;
    if (this.wVU != null) {
      this.wVU.onAppForeground(paramString);
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