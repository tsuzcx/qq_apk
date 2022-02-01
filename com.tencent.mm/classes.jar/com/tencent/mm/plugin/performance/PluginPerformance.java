package com.tencent.mm.plugin.performance;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.e.d.e;
import com.tencent.e.d.f;
import com.tencent.e.g.b;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n;
import com.tencent.mm.app.o;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.performance.jni.memory.MemoryHook;
import com.tencent.mm.plugin.expt.PluginExpt;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.performance.b.a.k;
import com.tencent.mm.plugin.performance.diagnostic.memory.MemoryHookLogic;
import com.tencent.mm.plugin.performance.diagnostic.memory.MemoryHookLogic.MemoryHookReporter;
import com.tencent.mm.plugin.performance.elf.AbstractProcessChecker;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Set;

public class PluginPerformance
  extends f
  implements n, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.performance.a.d
{
  private com.tencent.mm.plugin.performance.b.a ura;
  a urb;
  
  public PluginPerformance()
  {
    AppMethodBeat.i(184687);
    this.ura = new com.tencent.mm.plugin.performance.b.a();
    AppMethodBeat.o(184687);
  }
  
  private void setupBitmapDecodeCanary(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124904);
    MMBitmapFactory.setDecodeCanary(new PluginPerformance.1(this, paramg));
    AppMethodBeat.o(124904);
  }
  
  public void configure(com.tencent.mm.kernel.b.g arg1)
  {
    AppMethodBeat.i(124902);
    com.tencent.mm.ck.c.FFd = new b.1();
    com.tencent.mm.plugin.performance.a.a.urg.a(new MemoryHookLogic());
    com.tencent.mm.plugin.performance.a.a.urg.a(new com.tencent.mm.plugin.performance.diagnostic.b());
    com.tencent.mm.plugin.performance.a.a.urg.a(new com.tencent.mm.plugin.performance.diagnostic.a.c());
    com.tencent.mm.plugin.performance.b.a locala = this.ura;
    boolean bool = ???.agu();
    ad.i("ThreadPool.Profiler", "[open] isProcessMain=".concat(String.valueOf(bool)));
    if ((com.tencent.mm.plugin.performance.b.a.cxf) && (bool))
    {
      ??? = new ap("reportStatistics");
      ???.postDelayed((Runnable)new a.k(locala, ???), 1800000L);
      AppForegroundDelegate.cKE.a((n)locala);
      locala.utq.av(600000L, 600000L);
    }
    AppForegroundDelegate localAppForegroundDelegate = AppForegroundDelegate.cKE;
    o localo = (o)locala;
    synchronized (localAppForegroundDelegate.cKH)
    {
      localAppForegroundDelegate.cKH.add(localo);
      com.tencent.e.d.IxS = (d.e)locala.utj;
      com.tencent.e.d.IxT = (d.f)locala.uth;
      com.tencent.e.a.Ixz = (g.b)locala.uti;
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
    Object localObject1;
    if (aj.eFH()) {
      localObject1 = com.tencent.mm.plugin.performance.elf.b.usO;
    }
    try
    {
      ((com.tencent.mm.plugin.performance.elf.b)localObject1).cEP = com.tencent.mm.plugin.performance.elf.b.bd(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pli, 0) / 10000.0F);
      com.tencent.mm.plugin.performance.elf.b.usI = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pll, 1200000L);
      ad.i("MicroMsg.ProcessElf", "[call] isEnable:%b CHECK_TIME:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.performance.elf.b)localObject1).cEP), Long.valueOf(com.tencent.mm.plugin.performance.elf.b.daG()) });
      if (((com.tencent.mm.plugin.performance.elf.b)localObject1).cEP)
      {
        com.tencent.mm.plugin.performance.elf.b.use.removeCallbacks(com.tencent.mm.plugin.performance.elf.b.usQ);
        com.tencent.mm.plugin.performance.elf.b.use.postDelayed(com.tencent.mm.plugin.performance.elf.b.usQ, com.tencent.mm.plugin.performance.elf.b.daG());
      }
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("ACTION_ELF_CHECK_RESPONSE");
      ((IntentFilter)localObject1).addAction("com.tencent.mm.MMUIModeManager");
      aj.getContext().registerReceiver(com.tencent.mm.plugin.performance.elf.b.usP, (IntentFilter)localObject1);
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.ae.a());
      localObject1 = com.tencent.mm.performance.a.a.aFM();
      ((com.tencent.mm.performance.a.a)localObject1).hQv = ((com.tencent.mm.performance.a.a)localObject1).aGF.getMemoryClass();
      ((com.tencent.mm.performance.a.a)localObject1).hQw = ((com.tencent.mm.performance.a.a)localObject1).aGF.getLargeMemoryClass();
      ((Application)aj.getContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      i locali = com.tencent.e.h.Iye;
      if (((com.tencent.mm.performance.a.a)localObject1).ctF)
      {
        l1 = 300000L;
        locali.q((Runnable)localObject1, l1);
        ((com.tencent.mm.performance.a.a)localObject1).mProcessName = aj.getProcessName();
        paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.performance.c.b());
        localObject1 = com.tencent.mm.plugin.performance.c.a.daT();
        com.tencent.e.h.Iye.q((Runnable)localObject1, 1800000L);
        localMemoryHookLogic = (MemoryHookLogic)com.tencent.mm.plugin.performance.a.a.urg.aQ(MemoryHookLogic.class);
        if ((localMemoryHookLogic != null) && (localMemoryHookLogic.daz()))
        {
          bool2 = localMemoryHookLogic.urA.decodeBool("MH_KEY_ENABLE_BOOLEAN", false);
          ad.i(MemoryHookLogic.TAG, "enableMemoryHook = %s for process [%s]", new Object[] { Boolean.valueOf(bool2), aj.getProcessName() });
          bool1 = bool2;
          if (bool2)
          {
            l1 = localMemoryHookLogic.urA.decodeLong("MH_KEY_DURATION_MILLIS_LONG", 0L);
            l2 = localMemoryHookLogic.urA.decodeLong("MH_KEY_BEGIN_TIME_LONG", -1L);
            ad.i(MemoryHookLogic.TAG, "hook duration = %s, hook begin time = %s", new Object[] { Long.valueOf(l1), MemoryHookLogic.rF(l2) });
            if (l2 >= 0L) {
              break label1029;
            }
            l1 = System.currentTimeMillis();
            localMemoryHookLogic.urA.encode("MH_KEY_BEGIN_TIME_LONG", l1);
            ad.i(MemoryHookLogic.TAG, "update hookBeginTime = %s", new Object[] { Long.valueOf(l1) });
            bool1 = bool2;
          }
          if (bool1)
          {
            str = localMemoryHookLogic.urA.decodeString("MH_KEY_HOOK_SO_STRING", "");
            localObject1 = localMemoryHookLogic.urA.decodeString("MH_KEY_IGNORE_SO_STRING", "");
            bool1 = localMemoryHookLogic.urA.decodeBool("MH_KEY_ENABLE_STACKTRACE_BOOLEAN", false);
            i = localMemoryHookLogic.urA.decodeInt("MH_KEY_MIN_TRACE_SIZE_INT", 0);
            j = localMemoryHookLogic.urA.decodeInt("MH_KEY_MAX_TRACE_SIZE_INT", 0);
            d = localMemoryHookLogic.urA.aFF("MH_KEY_SAMPLING_DOUBLE");
            bool2 = localMemoryHookLogic.urA.decodeBool("MH_KEY_EXTREME_BOOLEAN", false);
            bool3 = localMemoryHookLogic.urA.decodeBool("MH_KEY_ENABLE_MMAP_BOOLEAN", false);
            ad.i(MemoryHookLogic.TAG, "hook:%s, ignore:%s, enableStacktrace:%s, min:%d, max:%d, sampling:%f, extreme:%s, mmap:%s", new Object[] { str, localObject1, Boolean.valueOf(bool1), Integer.valueOf(i), Integer.valueOf(j), Double.valueOf(d), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
            if (!TextUtils.isEmpty(str)) {
              break label1073;
            }
            ad.e(MemoryHookLogic.TAG, "ERROR(MemoryHook): hook regex is blank");
          }
          localMemoryHookLogic.day();
          if (localMemoryHookLogic.urA.decodeBool("MH_KEY_ENABLE_BOOLEAN", false))
          {
            ad.i(MemoryHookLogic.TAG, "register Reporter");
            MemoryHookLogic.MemoryHookReporter.install();
          }
        }
        localObject1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pue, "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          ad.d("MicroMsg.PluginPerformance", "[%s] exptCmd:[%s]", new Object[] { aj.getProcessName(), localObject1 });
          com.tencent.mm.plugin.performance.a.a.urg.an(bw.K((String)localObject1, "cmd"));
        }
        setupBitmapDecodeCanary(paramg);
        this.urb = a.akj(paramg.mProcessName);
        localObject1 = this.urb;
        ((a)localObject1).mState = ((a)localObject1).ctt.decodeInt("state", 0);
        ad.d("MicroMsg.ForegroundKilledDetect", "%s: CHECK LAST STATE = %s", new Object[] { ((a)localObject1).mProcessName, Integer.toBinaryString(((a)localObject1).mState) });
        if ((((a)localObject1).dao()) && (((a)localObject1).dap()) && (!((a)localObject1).daq()))
        {
          ad.e("MicroMsg.ForegroundKilledDetect", "%s: LAST STATE ERROR: %s", new Object[] { ((a)localObject1).mProcessName, Integer.toBinaryString(((a)localObject1).mState) });
          com.tencent.mm.kernel.g.afC().a(new a.1((a)localObject1));
        }
        ((a)localObject1).IX(1);
        ((a)localObject1).IX(2);
        ((a)localObject1).IX(4);
        ((a)localObject1).dar();
        this.urb.onAppForeground("boot");
        paramg.ca.registerActivityLifecycleCallbacks(this.urb);
        com.tencent.mm.sdk.a.b.b(this.urb);
        AppMethodBeat.o(124903);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        MemoryHookLogic localMemoryHookLogic;
        boolean bool2;
        long l2;
        String str;
        int i;
        int j;
        double d;
        boolean bool3;
        ad.printErrStackTrace("MicroMsg.ProcessElf", localException, "", new Object[0]);
        com.tencent.mm.plugin.performance.elf.b.usI = 1200000L;
        ((com.tencent.mm.plugin.performance.elf.b)localObject1).cEP = com.tencent.mm.plugin.performance.elf.b.DEBUG;
        continue;
        long l1 = 1800000L;
        continue;
        label1029:
        boolean bool1 = bool2;
        if (System.currentTimeMillis() - l2 > l1)
        {
          bool1 = false;
          localMemoryHookLogic.urA.encode("MH_KEY_ENABLE_BOOLEAN", false);
          ad.i(MemoryHookLogic.TAG, "time out, disable hook");
          continue;
          label1073:
          Object localObject2 = localObject1;
          if (!bool2)
          {
            localObject2 = localObject1;
            if (!((String)localObject1).endsWith(";")) {
              localObject2 = (String)localObject1 + ";";
            }
            localObject2 = (String)localObject2 + ".*libutils\\.so$;.*libcutils\\.so$;.*libskia\\.so$;.*libbinder.*\\.so$;.*libhwbinder\\.so$;.*libicuuc\\.so$;.*libicui18n\\.so$;.*libart.*\\.so$;.*libandroidfw\\.so$;.*libandroid_runtime\\.so$;.*libjavacore\\.so$;.*libopenjdk.*\\.so$;";
          }
          localObject1 = str.split(";");
          localObject2 = ((String)localObject2).split(";");
          try
          {
            localObject1 = MemoryHook.hQk.j((String[])localObject1).k((String[])localObject2);
            ((MemoryHook)localObject1).hQq = bool1;
            ((MemoryHook)localObject1).hQn = i;
            ((MemoryHook)localObject1).hQo = j;
            localObject1 = ((MemoryHook)localObject1).n(d);
            ((MemoryHook)localObject1).hQr = bool3;
            ((MemoryHook)localObject1).hook();
            com.tencent.mm.plugin.report.service.h.vKh.f(18261, new Object[] { aj.getProcessName(), Integer.valueOf(Process.myPid()), Integer.valueOf(0) });
          }
          catch (Throwable localThrowable)
          {
            ad.printErrStackTrace(MemoryHookLogic.TAG, localThrowable, "MemoryHook Error", new Object[0]);
          }
        }
      }
    }
  }
  
  public com.tencent.mm.plugin.performance.b.a getThreadPoolProfiler()
  {
    return this.ura;
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
    if (aj.cbe()) {
      com.tencent.mm.kernel.g.afE().m(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124899);
          ((MainProcessChecker)com.tencent.mm.plugin.performance.elf.a.aR(MainProcessChecker.class)).start();
          AppMethodBeat.o(124899);
        }
      }, 2000L);
    }
    AppMethodBeat.o(124905);
  }
  
  public void onAccountRelease() {}
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(124907);
    com.tencent.mm.plugin.performance.elf.a.aR(MainProcessChecker.class).bS(false);
    com.tencent.mm.performance.a.a.aFM().ctF = false;
    if (this.urb != null) {
      this.urb.onAppBackground(paramString);
    }
    AppMethodBeat.o(124907);
  }
  
  public void onAppForeground(String paramString)
  {
    AppMethodBeat.i(124906);
    com.tencent.mm.plugin.performance.elf.a.aR(MainProcessChecker.class).bS(true);
    com.tencent.mm.performance.a.a.aFM().ctF = true;
    if (this.urb != null) {
      this.urb.onAppForeground(paramString);
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