package com.tencent.mm.plugin.performance;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.support.v4.app.v;
import com.tencent.f.d.e;
import com.tencent.f.d.f;
import com.tencent.f.g.b;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.app.p;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.battery.BackgroundActivationsListener;
import com.tencent.mm.plugin.expansions.a.b;
import com.tencent.mm.plugin.expt.PluginExpt;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.c.a.k;
import com.tencent.mm.plugin.performance.elf.AbstractProcessChecker;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.performance.jectl.JeVersion;
import com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.wxperf.fd.FDDumpBridge;
import com.tencent.wxperf.jni.HookManager;
import com.tencent.wxperf.jni.memory.MemoryHook;
import com.tencent.wxperf.jni.pthread.PthreadHook;
import java.util.Set;

public class PluginPerformance
  extends f
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
    AppMethodBeat.i(201013);
    try
    {
      boolean bool = v.Q(paramContext).contains(paramContext.getPackageName());
      AppMethodBeat.o(201013);
      return bool;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(201013);
    }
    return false;
  }
  
  private void setupBackgroundActivationsListener(Context paramContext)
  {
    AppMethodBeat.i(201010);
    if (!WeChatEnvironment.hasDebugger())
    {
      AppMethodBeat.o(201010);
      return;
    }
    isNotificationListenerEnabled(paramContext);
    AppMethodBeat.o(201010);
  }
  
  private void setupBitmapDecodeCanary(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124904);
    MMBitmapFactory.setDecodeCanary(new PluginPerformance.3(this, paramg));
    AppMethodBeat.o(124904);
  }
  
  private void setupMemoryWatchDog()
  {
    AppMethodBeat.i(201006);
    com.tencent.mm.plugin.performance.watchdogs.c localc = com.tencent.mm.plugin.performance.watchdogs.c.eCH();
    localc.AXb = localc.aJf.getMemoryClass();
    localc.AXc = localc.aJf.getLargeMemoryClass();
    ((Application)MMApplicationContext.getContext()).registerActivityLifecycleCallbacks(localc);
    localc.AXl = System.currentTimeMillis();
    i locali = h.RTc;
    if (localc.cPB) {}
    double d;
    for (long l = 300000L;; l = 1800000L)
    {
      locali.a(localc, l, "MicroMsg.MemoryWatchDog");
      d = Math.random();
      if (d < 1.0D / ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smT, 100000)) {
        break;
      }
      Log.i("MicroMsg.PluginPerformance", "NOT report memory info after boot (%s)", new Object[] { Double.valueOf(d) });
      AppMethodBeat.o(201006);
      return;
    }
    Log.i("MicroMsg.PluginPerformance", "will repot memory info after boot (%s)", new Object[] { Double.valueOf(d) });
    com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g()
    {
      public final void WY()
      {
        AppMethodBeat.i(200999);
        h.RTc.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(124897);
            com.tencent.mm.plugin.performance.watchdogs.c.a locala1 = com.tencent.mm.plugin.performance.watchdogs.c.eCH().S(true, 0);
            Object[] arrayOfObject = c.eBB().toArray();
            StringBuilder localStringBuilder = new StringBuilder();
            int i;
            if ((locala1.AXH != null) && (locala1.AXH.length > 0))
            {
              localStringBuilder.append("allProcess:");
              com.tencent.mm.plugin.performance.watchdogs.c.a[] arrayOfa = locala1.AXH;
              j = arrayOfa.length;
              i = 0;
              while (i < j)
              {
                com.tencent.mm.plugin.performance.watchdogs.c.a locala2 = arrayOfa[i];
                localStringBuilder.append(locala2.pid).append("-").append(locala2.processName).append("-pss:").append(locala2.AXF).append(";");
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
            com.tencent.mm.plugin.performance.watchdogs.b.a(32, locala1.AXx - locala1.AXy, locala1.AXv, locala1.AXq, locala1.AXF, locala1.AXG, localStringBuilder.toString(), j, -2L, -2L, -1L, locala1.AXE.totalMem);
            AppMethodBeat.o(124897);
          }
        }, 10000L);
        com.tencent.mm.kernel.g.aAi().b(this);
        AppMethodBeat.o(200999);
      }
      
      public final void cQ(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(201006);
  }
  
  private void setupWxperf()
  {
    AppMethodBeat.i(201007);
    com.tencent.mm.plugin.expansions.a.a(new a.b()
    {
      public final void a(com.tencent.mm.toolkit.frontia.a.c.a paramAnonymousa)
      {
        AppMethodBeat.i(201000);
        Object localObject = (com.tencent.mm.plugin.performance.diagnostic.b.b)com.tencent.mm.plugin.performance.a.a.ASb.aT(com.tencent.mm.plugin.performance.diagnostic.b.b.class);
        paramAnonymousa = (com.tencent.mm.plugin.performance.diagnostic.c.b)com.tencent.mm.plugin.performance.a.a.ASb.aT(com.tencent.mm.plugin.performance.diagnostic.c.b.class);
        localObject = (MemoryHook)((com.tencent.mm.plugin.performance.diagnostic.b.b)localObject).eBJ();
        paramAnonymousa = (PthreadHook)paramAnonymousa.eBJ();
        try
        {
          Log.i("MicroMsg.PluginPerformance", "memoryHook = %s, pthreadHook = %s, eglHook = %s", new Object[] { localObject, paramAnonymousa, "eglHookStub" });
          HookManager.Syn.a((com.tencent.wxperf.jni.a)localObject).a(paramAnonymousa).hrZ();
          if (MMApplicationContext.isMainProcess()) {
            JeVersion.eCv();
          }
          AppMethodBeat.o(201000);
          return;
        }
        catch (Throwable paramAnonymousa)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.PluginPerformance", paramAnonymousa, "Hook error", new Object[0]);
          }
        }
      }
    });
    AppMethodBeat.o(201007);
  }
  
  private void startBackgroundActivationsListener(Context paramContext)
  {
    AppMethodBeat.i(201011);
    if (!WeChatEnvironment.hasDebugger())
    {
      AppMethodBeat.o(201011);
      return;
    }
    if (!isNotificationListenerEnabled(paramContext))
    {
      AppMethodBeat.o(201011);
      return;
    }
    try
    {
      paramContext.startService(new Intent(paramContext, BackgroundActivationsListener.class));
      AppMethodBeat.o(201011);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(201011);
    }
  }
  
  private void stopBackgroundActivationsListener(Context paramContext)
  {
    AppMethodBeat.i(201012);
    if (!WeChatEnvironment.hasDebugger())
    {
      AppMethodBeat.o(201012);
      return;
    }
    if (!isNotificationListenerEnabled(paramContext))
    {
      AppMethodBeat.o(201012);
      return;
    }
    try
    {
      paramContext.stopService(new Intent(paramContext, BackgroundActivationsListener.class));
      AppMethodBeat.o(201012);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(201012);
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g arg1)
  {
    AppMethodBeat.i(124902);
    com.tencent.mm.ci.c.OvX = new b.1();
    com.tencent.mm.plugin.performance.a.a.ASb.a(com.tencent.mm.plugin.performance.diagnostic.c.ATi);
    com.tencent.mm.plugin.performance.a.a.ASb.a(new com.tencent.mm.plugin.performance.diagnostic.b.b());
    com.tencent.mm.plugin.performance.a.a.ASb.a(new com.tencent.mm.plugin.performance.diagnostic.a.c());
    com.tencent.mm.plugin.performance.a.a.ASb.a(new com.tencent.mm.plugin.performance.diagnostic.c.b());
    com.tencent.mm.plugin.performance.diagnostic.b.alive();
    com.tencent.mm.plugin.performance.c.a locala = this.threadPoolProfiler;
    boolean bool = ???.aBb();
    Log.i("ThreadPool.Profiler", "[open] isProcessMain=".concat(String.valueOf(bool)));
    if ((com.tencent.mm.plugin.performance.c.a.cWq) && (bool))
    {
      ??? = new MMHandler("reportStatistics");
      ???.postDelayed((Runnable)new a.k(locala, ???), 1800000L);
      AppForegroundDelegate.djR.a((o)locala);
      locala.AVs.startTimer(600000L, 600000L);
    }
    AppForegroundDelegate localAppForegroundDelegate = AppForegroundDelegate.djR;
    p localp = (p)locala;
    synchronized (localAppForegroundDelegate.djX)
    {
      localAppForegroundDelegate.djX.add(localp);
      com.tencent.f.d.RSQ = (d.e)locala.AVl;
      com.tencent.f.d.RSR = (d.f)locala.AVj;
      com.tencent.f.a.RSx = (g.b)locala.AVk;
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
    if (MMApplicationContext.isPushProcess()) {
      localObject = com.tencent.mm.plugin.performance.elf.b.AUL;
    }
    try
    {
      ((com.tencent.mm.plugin.performance.elf.b)localObject).ded = com.tencent.mm.plugin.performance.elf.b.bF(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRv, 0) / 10000.0F);
      com.tencent.mm.plugin.performance.elf.b.AUF = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRy, 1200000L);
      Log.i("MicroMsg.ProcessElf", "[call] isEnable:%b CHECK_TIME:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.performance.elf.b)localObject).ded), Long.valueOf(com.tencent.mm.plugin.performance.elf.b.eCr()) });
      if (((com.tencent.mm.plugin.performance.elf.b)localObject).ded)
      {
        com.tencent.mm.plugin.performance.elf.b.AUg.removeCallbacks(com.tencent.mm.plugin.performance.elf.b.AUN);
        com.tencent.mm.plugin.performance.elf.b.AUg.postDelayed(com.tencent.mm.plugin.performance.elf.b.AUN, com.tencent.mm.plugin.performance.elf.b.eCr());
      }
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("ACTION_ELF_CHECK_RESPONSE");
      ((IntentFilter)localObject).addAction("com.tencent.mm.MMUIModeManager");
      MMApplicationContext.getContext().registerReceiver(com.tencent.mm.plugin.performance.elf.b.AUM, (IntentFilter)localObject);
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.ad.a());
      setupMemoryWatchDog();
      paramg.ca.registerActivityLifecycleCallbacks(new ThreadWatchDog());
      localObject = com.tencent.mm.plugin.performance.watchdogs.a.eCE();
      try
      {
        ((com.tencent.mm.plugin.performance.watchdogs.a)localObject).AWe = FDDumpBridge.getFDLimit();
        Log.i("MicroMsg.FDWatchDog", "FdLimit = %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.performance.watchdogs.a)localObject).AWe) });
        i = 230;
        if (((com.tencent.mm.plugin.performance.watchdogs.a)localObject).AWe > 1024) {
          break label542;
        }
        i = 231;
        e.Cxv.idkeyStat(1031L, i, 1L, false);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          int i;
          int j;
          Log.printErrStackTrace("MicroMsg.FDWatchDog", localThrowable, "get resource limit err", new Object[0]);
          e.Cxv.idkeyStat(1031L, 251L, 1L, false);
        }
        locali = h.RTc;
        if (!((com.tencent.mm.plugin.performance.watchdogs.d)localObject).cQp) {
          break label647;
        }
      }
      h.RTc.o((Runnable)localObject, 1800000L);
      localObject = com.tencent.mm.plugin.performance.watchdogs.d.eCN();
      if (!MMApplicationContext.isMainProcess())
      {
        Log.e("MicroMsg.ProcessWatchDog", "NOT main process");
        setupWxperf();
        setupBitmapDecodeCanary(paramg);
        this.mForegroundKilledDetector = a.aJO(paramg.mProcessName);
        localObject = this.mForegroundKilledDetector;
        ((a)localObject).mState = ((a)localObject).cQe.decodeInt("state", 0);
        Log.d("MicroMsg.ForegroundKilledDetect", "%s: CHECK LAST STATE = %s", new Object[] { ((a)localObject).mProcessName, Integer.toBinaryString(((a)localObject).mState) });
        if ((((a)localObject).eBw()) && (((a)localObject).eBx()) && (!((a)localObject).eBy()))
        {
          Log.e("MicroMsg.ForegroundKilledDetect", "%s: LAST STATE ERROR: %s", new Object[] { ((a)localObject).mProcessName, Integer.toBinaryString(((a)localObject).mState) });
          com.tencent.mm.kernel.g.aAi().a(new a.1((a)localObject));
        }
        ((a)localObject).Uo(1);
        ((a)localObject).Uo(2);
        ((a)localObject).Uo(4);
        ((a)localObject).eBz();
        this.mForegroundKilledDetector.onAppForeground("boot");
        paramg.ca.registerActivityLifecycleCallbacks(this.mForegroundKilledDetector);
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
        com.tencent.mm.plugin.performance.elf.b.AUF = 1200000L;
        ((com.tencent.mm.plugin.performance.elf.b)localObject).ded = com.tencent.mm.plugin.performance.elf.b.DEBUG;
        continue;
        label542:
        if (((com.tencent.mm.plugin.performance.watchdogs.a)localObject).AWe <= 2048)
        {
          i = 232;
        }
        else
        {
          j = ((com.tencent.mm.plugin.performance.watchdogs.a)localObject).AWe;
          if (j <= 4096) {
            i = 233;
          }
        }
      }
    }
    i locali;
    label647:
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
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(124905);
    if (MMApplicationContext.isMainProcess())
    {
      com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(201003);
          ((MainProcessChecker)com.tencent.mm.plugin.performance.elf.a.aU(MainProcessChecker.class)).start();
          AppMethodBeat.o(201003);
        }
      }, 2000L);
      if ((!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED) && (!com.tencent.mm.protocal.d.KyR) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.seL, 0) != 1)) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      AppForegroundDelegate.djW = bool;
      AppMethodBeat.o(124905);
      return;
    }
  }
  
  public void onAccountRelease() {}
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(124907);
    com.tencent.mm.plugin.performance.elf.a.aU(MainProcessChecker.class).cy(false);
    com.tencent.mm.plugin.performance.watchdogs.c.eCH().cy(false);
    com.tencent.mm.plugin.performance.watchdogs.d.eCN().cQp = false;
    if (this.mForegroundKilledDetector != null) {
      this.mForegroundKilledDetector.onAppBackground(paramString);
    }
    startBackgroundActivationsListener(MMApplicationContext.getContext());
    AppMethodBeat.o(124907);
  }
  
  public void onAppForeground(String paramString)
  {
    AppMethodBeat.i(124906);
    com.tencent.mm.plugin.performance.elf.a.aU(MainProcessChecker.class).cy(true);
    com.tencent.mm.plugin.performance.watchdogs.c.eCH().cy(true);
    com.tencent.mm.plugin.performance.watchdogs.d.eCN().cQp = true;
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
    AppMethodBeat.i(201008);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201004);
        Log.e("MicroMsg.PluginPerformance", "onLowMemory -> dump memory");
        Log.i("MicroMsg.PluginPerformance", "[onLowMemory] %s", new Object[] { com.tencent.mm.plugin.performance.watchdogs.c.eCH().S(true, 0) });
        AppMethodBeat.o(201004);
      }
    });
    AppMethodBeat.o(201008);
  }
  
  public void onTerminate() {}
  
  public void onTrimMemory(final int paramInt)
  {
    AppMethodBeat.i(201009);
    if (paramInt <= 15) {
      h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(201005);
          Log.e("MicroMsg.PluginPerformance", "onTrimMemory level:%d -> dump memory", new Object[] { Integer.valueOf(paramInt) });
          Log.i("MicroMsg.PluginPerformance", "[onTrimMemory] %s", new Object[] { com.tencent.mm.plugin.performance.watchdogs.c.eCH().S(true, 0) });
          AppMethodBeat.o(201005);
        }
      });
    }
    AppMethodBeat.o(201009);
  }
  
  public String toString()
  {
    return "plugin-performance";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.PluginPerformance
 * JD-Core Version:    0.7.0.1
 */