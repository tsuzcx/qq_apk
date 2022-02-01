package com.tencent.mm.plugin.performance;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.tencent.e.d.e;
import com.tencent.e.d.f;
import com.tencent.e.g.b;
import com.tencent.e.i;
import com.tencent.matrix.fd.FDDumpBridge;
import com.tencent.matrix.hook.memory.MemoryHook;
import com.tencent.matrix.hook.pthread.PthreadHook;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.app.p;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.battery.BackgroundActivationsListener;
import com.tencent.mm.plugin.expansions.a.b;
import com.tencent.mm.plugin.expt.PluginExpt;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.c.a.l;
import com.tencent.mm.plugin.performance.elf.AbstractProcessChecker;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.performance.jectl.JeVersion;
import com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog;
import com.tencent.mm.plugin.performance.watchdogs.c.b;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.PatronsWrapper;
import com.tencent.mm.sdk.platformtools.ThreadStackShinkerWrapper;
import com.tencent.mm.sdk.platformtools.WVReservedSpaceShinkerWrapper;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.toolkit.frontia.a.c.a;
import com.tencent.mm.vfs.ab;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import java.util.Set;

public class PluginPerformance
  extends com.tencent.mm.kernel.b.f
  implements o, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.performance.a.d, ApplicationLifeCycle
{
  private static final String TAG = "MicroMsg.PluginPerformance";
  a mForegroundKilledDetector;
  private com.tencent.mm.plugin.performance.c.a threadPoolProfiler;
  
  public PluginPerformance()
  {
    AppMethodBeat.i(184687);
    this.threadPoolProfiler = new com.tencent.mm.plugin.performance.c.a();
    AppMethodBeat.o(184687);
  }
  
  private void dryRunBackgroundActivationForTest(Context paramContext) {}
  
  private static boolean isNotificationListenerEnabled(Context paramContext)
  {
    AppMethodBeat.i(202053);
    try
    {
      boolean bool = androidx.core.app.h.N(paramContext).contains(paramContext.getPackageName());
      AppMethodBeat.o(202053);
      return bool;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(202053);
    }
    return false;
  }
  
  private void setupBackgroundActivationsListener(Context paramContext)
  {
    AppMethodBeat.i(202046);
    if (!WeChatEnvironment.hasDebugger())
    {
      AppMethodBeat.o(202046);
      return;
    }
    isNotificationListenerEnabled(paramContext);
    AppMethodBeat.o(202046);
  }
  
  private void setupBitmapDecodeCanary(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124904);
    MMBitmapFactory.setDecodeCanary(new PluginPerformance.3(this, paramg));
    AppMethodBeat.o(124904);
  }
  
  private void setupMemoryWatchDog()
  {
    AppMethodBeat.i(202007);
    com.tencent.mm.plugin.performance.watchdogs.c localc = com.tencent.mm.plugin.performance.watchdogs.c.fou();
    localc.GQB = localc.wBe.getMemoryClass();
    localc.GQC = localc.wBe.getLargeMemoryClass();
    ((Application)MMApplicationContext.getContext()).registerActivityLifecycleCallbacks(localc);
    localc.GQL = System.currentTimeMillis();
    i locali = com.tencent.e.h.ZvG;
    if (localc.cQt) {}
    double d;
    for (long l = 300000L;; l = 1800000L)
    {
      locali.a(localc, l, "MicroMsg.MemoryWatchDog");
      d = Math.random();
      if (d < 1.0D / ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXV, 100000)) {
        break;
      }
      Log.i("MicroMsg.PluginPerformance", "NOT report memory info after boot (%s)", new Object[] { Double.valueOf(d) });
      AppMethodBeat.o(202007);
      return;
    }
    Log.i("MicroMsg.PluginPerformance", "will repot memory info after boot (%s)", new Object[] { Double.valueOf(d) });
    com.tencent.mm.kernel.h.aHH().a(new com.tencent.mm.kernel.api.g()
    {
      public final void abB()
      {
        AppMethodBeat.i(200763);
        com.tencent.e.h.ZvG.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(124897);
            c.b localb1 = com.tencent.mm.plugin.performance.watchdogs.c.fou().ad(true, 0);
            Object[] arrayOfObject = c.fni().toArray();
            StringBuilder localStringBuilder = new StringBuilder();
            int i;
            if ((localb1.GRn != null) && (localb1.GRn.length > 0))
            {
              localStringBuilder.append("allProcess:");
              c.b[] arrayOfb = localb1.GRn;
              j = arrayOfb.length;
              i = 0;
              while (i < j)
              {
                c.b localb2 = arrayOfb[i];
                localStringBuilder.append(localb2.pid).append("-").append(localb2.processName).append("-pss:").append(localb2.GRk).append(";");
                i += 1;
              }
            }
            int j = -1;
            if (arrayOfObject != null)
            {
              int k = arrayOfObject.length;
              j = k;
              if (k > 0)
              {
                localStringBuilder.append("loaded so:");
                int m = arrayOfObject.length;
                i = 0;
                for (;;)
                {
                  j = k;
                  if (i >= m) {
                    break;
                  }
                  localStringBuilder.append(arrayOfObject[i]).append(";");
                  i += 1;
                }
              }
            }
            com.tencent.mm.plugin.performance.watchdogs.b.a(32, localb1.GRc - localb1.GRd, localb1.GRa, localb1.GQV, localb1.GRk, localb1.GRm, localStringBuilder.toString(), j, -2L, -2L, -1L, localb1.GRj.totalMem, "", "", "", "", localb1.GRl);
            AppMethodBeat.o(124897);
          }
        }, 10000L);
        com.tencent.mm.kernel.h.aHH().b(this);
        AppMethodBeat.o(200763);
      }
      
      public final void dn(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(202007);
  }
  
  private static void setupPerformanceComponents(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(202009);
    com.tencent.mm.plugin.expansions.a.a(new a.b()
    {
      public final void a(c.a paramAnonymousa)
      {
        AppMethodBeat.i(201458);
        PluginPerformance.access$000();
        AppMethodBeat.o(201458);
      }
    });
    AppMethodBeat.o(202009);
  }
  
  private static void setupWxperf()
  {
    AppMethodBeat.i(202016);
    com.tencent.mm.plugin.performance.diagnostic.a.vS(false);
    com.tencent.mm.plugin.performance.diagnostic.c.a(com.tencent.mm.plugin.performance.diagnostic.a.GLt);
    Object localObject2 = (com.tencent.mm.plugin.performance.diagnostic.b.b)com.tencent.mm.plugin.performance.a.a.GLp.bn(com.tencent.mm.plugin.performance.diagnostic.b.b.class);
    Object localObject1 = (com.tencent.mm.plugin.performance.diagnostic.c.b)com.tencent.mm.plugin.performance.a.a.GLp.bn(com.tencent.mm.plugin.performance.diagnostic.c.b.class);
    localObject2 = (MemoryHook)((com.tencent.mm.plugin.performance.diagnostic.b.b)localObject2).fnw();
    localObject1 = (PthreadHook)((com.tencent.mm.plugin.performance.diagnostic.c.b)localObject1).fnw();
    try
    {
      Log.i("MicroMsg.PluginPerformance", "memoryHook = %s, pthreadHook = %s, eglHook = %s", new Object[] { localObject2, localObject1, "eglHookStub" });
      com.tencent.mm.plugin.performance.diagnostic.c.a(new com.tencent.matrix.hook.a[] { localObject2, localObject1 });
      if (MMApplicationContext.isMainProcess()) {
        JeVersion.fof();
      }
      AppMethodBeat.o(202016);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.PluginPerformance", localThrowable, "Hook error", new Object[0]);
      }
    }
  }
  
  private void startBackgroundActivationsListener(Context paramContext)
  {
    AppMethodBeat.i(202048);
    if (!WeChatEnvironment.hasDebugger())
    {
      AppMethodBeat.o(202048);
      return;
    }
    if (!isNotificationListenerEnabled(paramContext))
    {
      AppMethodBeat.o(202048);
      return;
    }
    try
    {
      paramContext.startService(new Intent(paramContext, BackgroundActivationsListener.class));
      AppMethodBeat.o(202048);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(202048);
    }
  }
  
  private void stopBackgroundActivationsListener(Context paramContext)
  {
    AppMethodBeat.i(202052);
    if (!WeChatEnvironment.hasDebugger())
    {
      AppMethodBeat.o(202052);
      return;
    }
    if (!isNotificationListenerEnabled(paramContext))
    {
      AppMethodBeat.o(202052);
      return;
    }
    try
    {
      paramContext.stopService(new Intent(paramContext, BackgroundActivationsListener.class));
      AppMethodBeat.o(202052);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(202052);
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g arg1)
  {
    AppMethodBeat.i(124902);
    com.tencent.mm.plugin.performance.a.a.GLp.a(com.tencent.mm.plugin.performance.diagnostic.e.GMC);
    com.tencent.mm.plugin.performance.a.a.GLp.a(new com.tencent.mm.plugin.performance.diagnostic.b.b());
    com.tencent.mm.plugin.performance.a.a.GLp.a(new com.tencent.mm.plugin.performance.diagnostic.a.c());
    com.tencent.mm.plugin.performance.a.a.GLp.a(new com.tencent.mm.plugin.performance.diagnostic.c.b());
    com.tencent.mm.plugin.performance.diagnostic.d.alive();
    com.tencent.mm.plugin.performance.c.a locala = this.threadPoolProfiler;
    boolean bool = ???.aIE();
    Log.i("ThreadPool.Profiler", "[open] isProcessMain=".concat(String.valueOf(bool)));
    if ((com.tencent.mm.plugin.performance.c.a.dal) && (bool))
    {
      ??? = new MMHandler("reportStatistics");
      ???.postDelayed((Runnable)new a.l(locala, ???), 1800000L);
      AppForegroundDelegate.fby.a((o)locala);
      locala.GON.startTimer(600000L, 600000L);
    }
    AppForegroundDelegate localAppForegroundDelegate = AppForegroundDelegate.fby;
    p localp = (p)locala;
    for (;;)
    {
      synchronized (localAppForegroundDelegate.fbF)
      {
        localAppForegroundDelegate.fbF.add(localp);
        com.tencent.e.d.Zvu = (d.e)locala.GOG;
        com.tencent.e.d.Zvv = (d.f)locala.GOE;
        com.tencent.e.a.Zvb = (g.b)locala.GOF;
        com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.performance.a.e.class, new com.tencent.mm.plugin.f());
        if ((WeChatEnvironment.hasDebugger()) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbN, false)))
        {
          ThreadStackShinkerWrapper.markEnabled(MMApplicationContext.getContext());
          ??? = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbO, "");
          ThreadStackShinkerWrapper.storeIgnoredCreatorSoPatterns(MMApplicationContext.getContext(), ???);
          if ((!WeChatEnvironment.hasDebugger()) && (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbP, false))) {
            break label390;
          }
          WVReservedSpaceShinkerWrapper.markEnabled(MMApplicationContext.getContext());
          WVReservedSpaceShinkerWrapper.markStartupFine(MMApplicationContext.getContext());
          if ((!WeChatEnvironment.hasDebugger()) && (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.KHT, false))) {
            break label399;
          }
          PatronsWrapper.markEnabled(MMApplicationContext.getContext(), false);
          ab.ou("wechat-backtrace", "${data}/files/wechat-backtrace/saving-cache");
          AppMethodBeat.o(124902);
          return;
        }
      }
      ThreadStackShinkerWrapper.markDisabled(MMApplicationContext.getContext());
      continue;
      label390:
      WVReservedSpaceShinkerWrapper.markDisabled(MMApplicationContext.getContext());
      continue;
      label399:
      PatronsWrapper.markDisabled(MMApplicationContext.getContext());
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
    if (MMApplicationContext.isPushProcess()) {
      localObject = com.tencent.mm.plugin.performance.elf.b.GOg;
    }
    try
    {
      ((com.tencent.mm.plugin.performance.elf.b)localObject).dih = com.tencent.mm.plugin.performance.elf.b.bL(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxR, 0) / 10000.0F);
      com.tencent.mm.plugin.performance.elf.b.GOa = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxU, 1200000L);
      Log.i("MicroMsg.ProcessElf", "[call] isEnable:%b CHECK_TIME:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.performance.elf.b)localObject).dih), Long.valueOf(com.tencent.mm.plugin.performance.elf.b.fob()) });
      if (((com.tencent.mm.plugin.performance.elf.b)localObject).dih)
      {
        com.tencent.mm.plugin.performance.elf.b.GNB.removeCallbacks(com.tencent.mm.plugin.performance.elf.b.GOi);
        com.tencent.mm.plugin.performance.elf.b.GNB.postDelayed(com.tencent.mm.plugin.performance.elf.b.GOi, com.tencent.mm.plugin.performance.elf.b.fob());
      }
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("ACTION_ELF_CHECK_RESPONSE");
      ((IntentFilter)localObject).addAction("com.tencent.mm.MMUIModeManager");
      MMApplicationContext.getContext().registerReceiver(com.tencent.mm.plugin.performance.elf.b.GOh, (IntentFilter)localObject);
      paramg.Zw.registerActivityLifecycleCallbacks(new com.tencent.mm.ag.a());
      setupMemoryWatchDog();
      paramg.Zw.registerActivityLifecycleCallbacks(new ThreadWatchDog());
      localObject = com.tencent.mm.plugin.performance.watchdogs.a.jdMethod_for();
      try
      {
        ((com.tencent.mm.plugin.performance.watchdogs.a)localObject).GPC = FDDumpBridge.getFDLimit();
        MultiProcessMMKV.getDefault().encode("mFdLimit", ((com.tencent.mm.plugin.performance.watchdogs.a)localObject).GPC);
        Log.i("MicroMsg.FDWatchDog", "FdLimit = %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.performance.watchdogs.a)localObject).GPC) });
        i = 230;
        if (((com.tencent.mm.plugin.performance.watchdogs.a)localObject).GPC > 1024) {
          break label557;
        }
        i = 231;
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1031L, i, 1L, false);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          int i;
          int j;
          Log.printErrStackTrace("MicroMsg.FDWatchDog", localThrowable, "get resource limit err", new Object[0]);
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1031L, 251L, 1L, false);
        }
        locali = com.tencent.e.h.ZvG;
        if (!((com.tencent.mm.plugin.performance.watchdogs.d)localObject).dgo) {
          break label662;
        }
      }
      com.tencent.e.h.ZvG.o((Runnable)localObject, 1800000L);
      localObject = com.tencent.mm.plugin.performance.watchdogs.d.foB();
      if (!MMApplicationContext.isMainProcess())
      {
        Log.e("MicroMsg.ProcessWatchDog", "NOT main process");
        setupPerformanceComponents(paramg);
        setupBitmapDecodeCanary(paramg);
        this.mForegroundKilledDetector = a.aUk(paramg.mProcessName);
        localObject = this.mForegroundKilledDetector;
        ((a)localObject).mState = ((a)localObject).cQO.decodeInt("state", 0);
        Log.d("MicroMsg.ForegroundKilledDetect", "%s: CHECK LAST STATE = %s", new Object[] { ((a)localObject).mProcessName, Integer.toBinaryString(((a)localObject).mState) });
        if ((((a)localObject).fnd()) && (((a)localObject).fne()) && (!((a)localObject).fnf()))
        {
          Log.e("MicroMsg.ForegroundKilledDetect", "%s: LAST STATE ERROR: %s", new Object[] { ((a)localObject).mProcessName, Integer.toBinaryString(((a)localObject).mState) });
          com.tencent.mm.kernel.h.aHH().a(new a.1((a)localObject));
        }
        ((a)localObject).aaZ(1);
        ((a)localObject).aaZ(2);
        ((a)localObject).aaZ(4);
        ((a)localObject).fng();
        this.mForegroundKilledDetector.onAppForeground("boot");
        paramg.Zw.registerActivityLifecycleCallbacks(this.mForegroundKilledDetector);
        CrashReportFactory.addCrashReportExtraMessageGetter(this.mForegroundKilledDetector);
        AppMethodBeat.o(124903);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ProcessElf", localException, "", new Object[0]);
        com.tencent.mm.plugin.performance.elf.b.GOa = 1200000L;
        ((com.tencent.mm.plugin.performance.elf.b)localObject).dih = com.tencent.mm.plugin.performance.elf.b.DEBUG;
        continue;
        label557:
        if (((com.tencent.mm.plugin.performance.watchdogs.a)localObject).GPC <= 2048)
        {
          i = 232;
        }
        else
        {
          j = ((com.tencent.mm.plugin.performance.watchdogs.a)localObject).GPC;
          if (j <= 4096) {
            i = 233;
          }
        }
      }
    }
    i locali;
    label662:
    for (long l = 300000L;; l = 1800000L)
    {
      locali.o((Runnable)localObject, l);
      break;
    }
  }
  
  public com.tencent.mm.plugin.performance.c.a getThreadPoolProfiler()
  {
    return this.threadPoolProfiler;
  }
  
  public void installed()
  {
    AppMethodBeat.i(124900);
    alias(com.tencent.mm.plugin.performance.a.d.class);
    AppMethodBeat.o(124900);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(124905);
    if (MMApplicationContext.isMainProcess())
    {
      com.tencent.mm.kernel.h.aHJ().postToWorkerDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(201831);
          ((MainProcessChecker)com.tencent.mm.plugin.performance.elf.a.bo(MainProcessChecker.class)).start();
          AppMethodBeat.o(201831);
        }
      }, 2000L);
      if ((!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED) && (!com.tencent.mm.protocal.d.RAG) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vOw, 0) != 1)) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      AppForegroundDelegate.fbE = bool;
      AppMethodBeat.o(124905);
      return;
    }
  }
  
  public void onAccountRelease() {}
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(124907);
    com.tencent.mm.plugin.performance.elf.a.bo(MainProcessChecker.class).cN(false);
    com.tencent.mm.plugin.performance.watchdogs.c.fou().cN(false);
    com.tencent.mm.plugin.performance.watchdogs.d.foB().dgo = false;
    if (this.mForegroundKilledDetector != null) {
      this.mForegroundKilledDetector.onAppBackground(paramString);
    }
    startBackgroundActivationsListener(MMApplicationContext.getContext());
    AppMethodBeat.o(124907);
  }
  
  public void onAppForeground(String paramString)
  {
    AppMethodBeat.i(124906);
    com.tencent.mm.plugin.performance.elf.a.bo(MainProcessChecker.class).cN(true);
    com.tencent.mm.plugin.performance.watchdogs.c.fou().cN(true);
    com.tencent.mm.plugin.performance.watchdogs.d.foB().dgo = true;
    if (this.mForegroundKilledDetector != null) {
      this.mForegroundKilledDetector.onAppForeground(paramString);
    }
    stopBackgroundActivationsListener(MMApplicationContext.getContext());
    AppMethodBeat.o(124906);
  }
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate() {}
  
  public void onLowMemory()
  {
    AppMethodBeat.i(202035);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201394);
        Log.e("MicroMsg.PluginPerformance", "onLowMemory -> dump memory");
        Log.i("MicroMsg.PluginPerformance", "[onLowMemory] %s", new Object[] { com.tencent.mm.plugin.performance.watchdogs.c.fou().ad(true, 0) });
        AppMethodBeat.o(201394);
      }
    });
    AppMethodBeat.o(202035);
  }
  
  public void onTerminate() {}
  
  public void onTrimMemory(final int paramInt)
  {
    AppMethodBeat.i(202037);
    if (paramInt <= 15) {
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(201278);
          Log.e("MicroMsg.PluginPerformance", "onTrimMemory level:%d -> dump memory", new Object[] { Integer.valueOf(paramInt) });
          Log.i("MicroMsg.PluginPerformance", "[onTrimMemory] %s", new Object[] { com.tencent.mm.plugin.performance.watchdogs.c.fou().ad(true, 0) });
          AppMethodBeat.o(201278);
        }
      });
    }
    AppMethodBeat.o(202037);
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