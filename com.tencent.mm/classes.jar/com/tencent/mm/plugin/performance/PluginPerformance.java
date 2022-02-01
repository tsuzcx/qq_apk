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
import com.tencent.mm.plugin.performance.c.a.k;
import com.tencent.mm.plugin.performance.diagnostic.memory.MemoryHookLogic;
import com.tencent.mm.plugin.performance.diagnostic.memory.MemoryHookLogic.MemoryHookReporter;
import com.tencent.mm.plugin.performance.elf.AbstractProcessChecker;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Set;

public class PluginPerformance
  extends f
  implements n, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.performance.a.d
{
  private com.tencent.mm.plugin.performance.c.a vzW;
  a vzX;
  
  public PluginPerformance()
  {
    AppMethodBeat.i(184687);
    this.vzW = new com.tencent.mm.plugin.performance.c.a();
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
    com.tencent.mm.cj.c.Heg = new b.1();
    com.tencent.mm.plugin.performance.a.a.vAc.a(new MemoryHookLogic());
    com.tencent.mm.plugin.performance.a.a.vAc.a(new com.tencent.mm.plugin.performance.diagnostic.b());
    com.tencent.mm.plugin.performance.a.a.vAc.a(new com.tencent.mm.plugin.performance.diagnostic.a.c());
    com.tencent.mm.plugin.performance.c.a locala = this.vzW;
    boolean bool = ???.ahL();
    ac.i("ThreadPool.Profiler", "[open] isProcessMain=".concat(String.valueOf(bool)));
    if ((com.tencent.mm.plugin.performance.c.a.cuo) && (bool))
    {
      ??? = new ao("reportStatistics");
      ???.postDelayed((Runnable)new a.k(locala, ???), 1800000L);
      AppForegroundDelegate.cHM.a((n)locala);
      locala.vCN.au(600000L, 600000L);
    }
    AppForegroundDelegate localAppForegroundDelegate = AppForegroundDelegate.cHM;
    o localo = (o)locala;
    synchronized (localAppForegroundDelegate.cHP)
    {
      localAppForegroundDelegate.cHP.add(localo);
      com.tencent.e.d.JZB = (d.e)locala.vCG;
      com.tencent.e.d.JZC = (d.f)locala.vCE;
      com.tencent.e.a.JZi = (g.b)locala.vCF;
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
    if (ai.eVb()) {
      localObject1 = com.tencent.mm.plugin.performance.elf.b.vBH;
    }
    try
    {
      ((com.tencent.mm.plugin.performance.elf.b)localObject1).cBX = com.tencent.mm.plugin.performance.elf.b.bk(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOz, 0) / 10000.0F);
      com.tencent.mm.plugin.performance.elf.b.vBB = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOC, 1200000L);
      ac.i("MicroMsg.ProcessElf", "[call] isEnable:%b CHECK_TIME:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.performance.elf.b)localObject1).cBX), Long.valueOf(com.tencent.mm.plugin.performance.elf.b.doo()) });
      if (((com.tencent.mm.plugin.performance.elf.b)localObject1).cBX)
      {
        com.tencent.mm.plugin.performance.elf.b.vAY.removeCallbacks(com.tencent.mm.plugin.performance.elf.b.vBJ);
        com.tencent.mm.plugin.performance.elf.b.vAY.postDelayed(com.tencent.mm.plugin.performance.elf.b.vBJ, com.tencent.mm.plugin.performance.elf.b.doo());
      }
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("ACTION_ELF_CHECK_RESPONSE");
      ((IntentFilter)localObject1).addAction("com.tencent.mm.MMUIModeManager");
      ai.getContext().registerReceiver(com.tencent.mm.plugin.performance.elf.b.vBI, (IntentFilter)localObject1);
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.ad.a());
      localObject1 = com.tencent.mm.performance.a.a.aMA();
      ((com.tencent.mm.performance.a.a)localObject1).iqB = ((com.tencent.mm.performance.a.a)localObject1).aHv.getMemoryClass();
      ((com.tencent.mm.performance.a.a)localObject1).iqC = ((com.tencent.mm.performance.a.a)localObject1).aHv.getLargeMemoryClass();
      ((Application)ai.getContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      i locali = com.tencent.e.h.JZN;
      if (((com.tencent.mm.performance.a.a)localObject1).cqM)
      {
        l1 = 300000L;
        locali.q((Runnable)localObject1, l1);
        ((com.tencent.mm.performance.a.a)localObject1).mProcessName = ai.getProcessName();
        paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.performance.d.a());
        localObject1 = com.tencent.mm.plugin.performance.b.a.dou();
        com.tencent.e.h.JZN.q((Runnable)localObject1, 1800000L);
        localMemoryHookLogic = (MemoryHookLogic)com.tencent.mm.plugin.performance.a.a.vAc.aR(MemoryHookLogic.class);
        if ((localMemoryHookLogic != null) && (localMemoryHookLogic.doh()))
        {
          bool2 = localMemoryHookLogic.vAu.decodeBool("MH_KEY_ENABLE_BOOLEAN", false);
          ac.i(MemoryHookLogic.TAG, "enableMemoryHook = %s for process [%s]", new Object[] { Boolean.valueOf(bool2), ai.getProcessName() });
          bool1 = bool2;
          if (bool2)
          {
            l1 = localMemoryHookLogic.vAu.decodeLong("MH_KEY_DURATION_MILLIS_LONG", 0L);
            l2 = localMemoryHookLogic.vAu.decodeLong("MH_KEY_BEGIN_TIME_LONG", -1L);
            ac.i(MemoryHookLogic.TAG, "hook duration = %s, hook begin time = %s", new Object[] { Long.valueOf(l1), MemoryHookLogic.wi(l2) });
            if (l2 >= 0L) {
              break label1029;
            }
            l1 = System.currentTimeMillis();
            localMemoryHookLogic.vAu.encode("MH_KEY_BEGIN_TIME_LONG", l1);
            ac.i(MemoryHookLogic.TAG, "update hookBeginTime = %s", new Object[] { Long.valueOf(l1) });
            bool1 = bool2;
          }
          if (bool1)
          {
            str = localMemoryHookLogic.vAu.decodeString("MH_KEY_HOOK_SO_STRING", "");
            localObject1 = localMemoryHookLogic.vAu.decodeString("MH_KEY_IGNORE_SO_STRING", "");
            bool1 = localMemoryHookLogic.vAu.decodeBool("MH_KEY_ENABLE_STACKTRACE_BOOLEAN", false);
            i = localMemoryHookLogic.vAu.decodeInt("MH_KEY_MIN_TRACE_SIZE_INT", 0);
            j = localMemoryHookLogic.vAu.decodeInt("MH_KEY_MAX_TRACE_SIZE_INT", 0);
            d = localMemoryHookLogic.vAu.aKW("MH_KEY_SAMPLING_DOUBLE");
            bool2 = localMemoryHookLogic.vAu.decodeBool("MH_KEY_EXTREME_BOOLEAN", false);
            bool3 = localMemoryHookLogic.vAu.decodeBool("MH_KEY_ENABLE_MMAP_BOOLEAN", false);
            ac.i(MemoryHookLogic.TAG, "hook:%s, ignore:%s, enableStacktrace:%s, min:%d, max:%d, sampling:%f, extreme:%s, mmap:%s", new Object[] { str, localObject1, Boolean.valueOf(bool1), Integer.valueOf(i), Integer.valueOf(j), Double.valueOf(d), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
            if (!TextUtils.isEmpty(str)) {
              break label1073;
            }
            ac.e(MemoryHookLogic.TAG, "ERROR(MemoryHook): hook regex is blank");
          }
          localMemoryHookLogic.dog();
          if (localMemoryHookLogic.vAu.decodeBool("MH_KEY_ENABLE_BOOLEAN", false))
          {
            ac.i(MemoryHookLogic.TAG, "register Reporter");
            MemoryHookLogic.MemoryHookReporter.install();
          }
        }
        localObject1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYs, "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          ac.d("MicroMsg.PluginPerformance", "[%s] exptCmd:[%s]", new Object[] { ai.getProcessName(), localObject1 });
          com.tencent.mm.plugin.performance.a.a.vAc.ap(bv.L((String)localObject1, "cmd"));
        }
        setupBitmapDecodeCanary(paramg);
        this.vzX = a.aph(paramg.mProcessName);
        localObject1 = this.vzX;
        ((a)localObject1).mState = ((a)localObject1).cqB.decodeInt("state", 0);
        ac.d("MicroMsg.ForegroundKilledDetect", "%s: CHECK LAST STATE = %s", new Object[] { ((a)localObject1).mProcessName, Integer.toBinaryString(((a)localObject1).mState) });
        if ((((a)localObject1).dnW()) && (((a)localObject1).dnX()) && (!((a)localObject1).dnY()))
        {
          ac.e("MicroMsg.ForegroundKilledDetect", "%s: LAST STATE ERROR: %s", new Object[] { ((a)localObject1).mProcessName, Integer.toBinaryString(((a)localObject1).mState) });
          com.tencent.mm.kernel.g.agS().a(new a.1((a)localObject1));
        }
        ((a)localObject1).KW(1);
        ((a)localObject1).KW(2);
        ((a)localObject1).KW(4);
        ((a)localObject1).dnZ();
        this.vzX.onAppForeground("boot");
        paramg.ca.registerActivityLifecycleCallbacks(this.vzX);
        com.tencent.mm.sdk.a.b.b(this.vzX);
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
        ac.printErrStackTrace("MicroMsg.ProcessElf", localException, "", new Object[0]);
        com.tencent.mm.plugin.performance.elf.b.vBB = 1200000L;
        ((com.tencent.mm.plugin.performance.elf.b)localObject1).cBX = com.tencent.mm.plugin.performance.elf.b.DEBUG;
        continue;
        long l1 = 1800000L;
        continue;
        label1029:
        boolean bool1 = bool2;
        if (System.currentTimeMillis() - l2 > l1)
        {
          bool1 = false;
          localMemoryHookLogic.vAu.encode("MH_KEY_ENABLE_BOOLEAN", false);
          ac.i(MemoryHookLogic.TAG, "time out, disable hook");
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
            MemoryHook.INSTANCE.addHookSo((String[])localObject1).addIgnoreSo((String[])localObject2).enableStacktrace(bool1).minTraceSize(i).maxTraceSize(j).sampling(d).enableMmapHook(bool3).hook();
            com.tencent.mm.plugin.report.service.h.wUl.f(18261, new Object[] { ai.getProcessName(), Integer.valueOf(Process.myPid()), Integer.valueOf(0) });
          }
          catch (Throwable localThrowable)
          {
            ac.printErrStackTrace(MemoryHookLogic.TAG, localThrowable, "MemoryHook Error", new Object[0]);
          }
        }
      }
    }
  }
  
  public com.tencent.mm.plugin.performance.c.a getThreadPoolProfiler()
  {
    return this.vzW;
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
    if (ai.cin()) {
      com.tencent.mm.kernel.g.agU().m(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124899);
          ((MainProcessChecker)com.tencent.mm.plugin.performance.elf.a.aS(MainProcessChecker.class)).start();
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
    com.tencent.mm.plugin.performance.elf.a.aS(MainProcessChecker.class).bT(false);
    com.tencent.mm.performance.a.a.aMA().cqM = false;
    if (this.vzX != null) {
      this.vzX.onAppBackground(paramString);
    }
    AppMethodBeat.o(124907);
  }
  
  public void onAppForeground(String paramString)
  {
    AppMethodBeat.i(124906);
    com.tencent.mm.plugin.performance.elf.a.aS(MainProcessChecker.class).bT(true);
    com.tencent.mm.performance.a.a.aMA().cqM = true;
    if (this.vzX != null) {
      this.vzX.onAppForeground(paramString);
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