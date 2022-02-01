package com.tencent.mm.plugin.performance;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.tencent.matrix.fd.FDDumpBridge;
import com.tencent.matrix.hook.memory.MemoryHook;
import com.tencent.matrix.hook.pthread.PthreadHook;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.app.r;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.battery.BackgroundActivationsListener;
import com.tencent.mm.plugin.expansions.e.b;
import com.tencent.mm.plugin.expt.PluginExpt;
import com.tencent.mm.plugin.m;
import com.tencent.mm.plugin.performance.b.a.k;
import com.tencent.mm.plugin.performance.elf.AbstractProcessChecker;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.performance.jectl.JeVersion;
import com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog;
import com.tencent.mm.plugin.performance.watchdogs.d.b;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.GCSemiSpaceTrimWrapper;
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
import com.tencent.mm.vfs.af;
import com.tencent.threadpool.d.e;
import com.tencent.threadpool.d.f;
import com.tencent.threadpool.g.b;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import java.util.Set;
import kotlin.g.b.s;

public class PluginPerformance
  extends com.tencent.mm.kernel.b.f
  implements q, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.performance.a.d, ApplicationLifeCycle
{
  private com.tencent.mm.plugin.performance.b.a MIb;
  a MIc;
  
  public PluginPerformance()
  {
    AppMethodBeat.i(184687);
    this.MIb = new com.tencent.mm.plugin.performance.b.a();
    AppMethodBeat.o(184687);
  }
  
  private void dryRunBackgroundActivationForTest(Context paramContext) {}
  
  private static boolean isNotificationListenerEnabled(Context paramContext)
  {
    AppMethodBeat.i(300838);
    try
    {
      boolean bool = androidx.core.app.i.Y(paramContext).contains(paramContext.getPackageName());
      AppMethodBeat.o(300838);
      return bool;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(300838);
    }
    return false;
  }
  
  private void setupBackgroundActivationsListener(Context paramContext)
  {
    AppMethodBeat.i(300828);
    if (!WeChatEnvironment.hasDebugger())
    {
      AppMethodBeat.o(300828);
      return;
    }
    isNotificationListenerEnabled(paramContext);
    AppMethodBeat.o(300828);
  }
  
  private void setupBitmapDecodeCanary(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124904);
    MMBitmapFactory.setDecodeCanary(new PluginPerformance.4(this, paramg));
    AppMethodBeat.o(124904);
  }
  
  private void setupMemoryWatchDog()
  {
    AppMethodBeat.i(300817);
    Object localObject = com.tencent.mm.plugin.performance.watchdogs.d.gzs();
    ((com.tencent.mm.plugin.performance.watchdogs.d)localObject).MNT = ((com.tencent.mm.plugin.performance.watchdogs.d)localObject).zXp.getMemoryClass();
    ((com.tencent.mm.plugin.performance.watchdogs.d)localObject).MNU = ((com.tencent.mm.plugin.performance.watchdogs.d)localObject).zXp.getLargeMemoryClass();
    ((Application)MMApplicationContext.getContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject);
    ((com.tencent.mm.plugin.performance.watchdogs.d)localObject).MOd = System.currentTimeMillis();
    com.tencent.threadpool.i locali = com.tencent.threadpool.h.ahAA;
    long l;
    if (((com.tencent.mm.plugin.performance.watchdogs.d)localObject).eLx)
    {
      l = 300000L;
      locali.a((Runnable)localObject, l, "MicroMsg.MemoryWatchDog");
      localObject = com.tencent.mm.plugin.performance.watchdogs.a.gzo();
      if (!MMApplicationContext.isAppBrandProcess()) {}
    }
    for (;;)
    {
      try
      {
        int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yGa, 2000000);
        com.tencent.mm.plugin.performance.watchdogs.a.MMJ = i;
        if (i != 0) {
          continue;
        }
        com.tencent.mm.plugin.performance.watchdogs.h.install();
      }
      catch (Exception localException)
      {
        double d;
        continue;
        Log.i("MicroMsg.PluginPerformance", "will repot memory info after boot (%s)", new Object[] { Double.valueOf(d) });
        com.tencent.mm.kernel.h.baF().a(new com.tencent.mm.kernel.api.g()
        {
          public final void aDv()
          {
            AppMethodBeat.i(300792);
            com.tencent.threadpool.h.ahAA.p(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(300806);
                d.b localb1 = com.tencent.mm.plugin.performance.watchdogs.d.gzs().af(true, 0);
                Object[] arrayOfObject = c.gxV().toArray();
                StringBuilder localStringBuilder = new StringBuilder();
                int i;
                if ((localb1.MOL != null) && (localb1.MOL.length > 0))
                {
                  localStringBuilder.append("allProcess:");
                  d.b[] arrayOfb = localb1.MOL;
                  j = arrayOfb.length;
                  i = 0;
                  while (i < j)
                  {
                    d.b localb2 = arrayOfb[i];
                    localStringBuilder.append(localb2.pid).append("-").append(localb2.processName).append("-pss:").append(localb2.FrK).append(";");
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
                com.tencent.mm.plugin.performance.watchdogs.c.a(32, localb1.MOA - localb1.MOB, localb1.MOy, localb1.MOt, localb1.FrK, localb1.MOK, localStringBuilder.toString(), j, -2L, -2L, -1L, localb1.MOI.totalMem, "", "", "", "", localb1.MOJ, localb1.hfG);
                AppMethodBeat.o(300806);
              }
            }, 10000L);
            com.tencent.mm.kernel.h.baF().b(this);
            AppMethodBeat.o(300792);
          }
          
          public final void dZ(boolean paramAnonymousBoolean) {}
        });
        AppMethodBeat.o(300817);
      }
      d = Math.random();
      if (d < 1.0D / ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zqK, 100000)) {
        continue;
      }
      Log.i("MicroMsg.PluginPerformance", "NOT report memory info after boot (%s)", new Object[] { Double.valueOf(d) });
      AppMethodBeat.o(300817);
      return;
      l = 1800000L;
      break;
      com.tencent.threadpool.h.ahAA.a((Runnable)localObject, 300000L, "AppbrandMemoryMonitor");
    }
  }
  
  private static void setupPerformanceComponents(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(300820);
    com.tencent.mm.plugin.expansions.e.install(new e.b()
    {
      public final void a(com.tencent.mm.toolkit.frontia.a.c.a paramAnonymousa)
      {
        AppMethodBeat.i(300791);
        PluginPerformance.access$000();
        AppMethodBeat.o(300791);
      }
    });
    AppMethodBeat.o(300820);
  }
  
  private static void setupWxperf()
  {
    AppMethodBeat.i(300825);
    com.tencent.mm.plugin.performance.diagnostic.a.Ao(false);
    com.tencent.mm.plugin.performance.diagnostic.c.a(com.tencent.mm.plugin.performance.diagnostic.a.MIo);
    Object localObject2 = (com.tencent.mm.plugin.performance.diagnostic.b.b)com.tencent.mm.plugin.performance.a.a.MIk.bX(com.tencent.mm.plugin.performance.diagnostic.b.b.class);
    Object localObject1 = (com.tencent.mm.plugin.performance.diagnostic.c.b)com.tencent.mm.plugin.performance.a.a.MIk.bX(com.tencent.mm.plugin.performance.diagnostic.c.b.class);
    localObject2 = (MemoryHook)((com.tencent.mm.plugin.performance.diagnostic.b.b)localObject2).gyj();
    localObject1 = (PthreadHook)((com.tencent.mm.plugin.performance.diagnostic.c.b)localObject1).gyj();
    try
    {
      Log.i("MicroMsg.PluginPerformance", "memoryHook = %s, pthreadHook = %s, eglHook = %s", new Object[] { localObject2, localObject1, "eglHookStub" });
      com.tencent.mm.plugin.performance.diagnostic.c.a(new com.tencent.matrix.hook.a[] { localObject2, localObject1 });
      if (MMApplicationContext.isMainProcess()) {
        JeVersion.gza();
      }
      AppMethodBeat.o(300825);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.PluginPerformance", localThrowable, "Hook error", new Object[0]);
      }
    }
  }
  
  private void startBackgroundActivationsListener(Context paramContext)
  {
    AppMethodBeat.i(300832);
    if (!WeChatEnvironment.hasDebugger())
    {
      AppMethodBeat.o(300832);
      return;
    }
    if (!isNotificationListenerEnabled(paramContext))
    {
      AppMethodBeat.o(300832);
      return;
    }
    try
    {
      paramContext.startService(new Intent(paramContext, BackgroundActivationsListener.class));
      AppMethodBeat.o(300832);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(300832);
    }
  }
  
  private void stopBackgroundActivationsListener(Context paramContext)
  {
    AppMethodBeat.i(300835);
    if (!WeChatEnvironment.hasDebugger())
    {
      AppMethodBeat.o(300835);
      return;
    }
    if (!isNotificationListenerEnabled(paramContext))
    {
      AppMethodBeat.o(300835);
      return;
    }
    try
    {
      paramContext.stopService(new Intent(paramContext, BackgroundActivationsListener.class));
      AppMethodBeat.o(300835);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(300835);
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124902);
    com.tencent.mm.plugin.performance.a.a.MIk.a(com.tencent.mm.plugin.performance.diagnostic.e.MJy);
    com.tencent.mm.plugin.performance.a.a.MIk.a(new com.tencent.mm.plugin.performance.diagnostic.b.b());
    com.tencent.mm.plugin.performance.a.a.MIk.a(new com.tencent.mm.plugin.performance.diagnostic.a.c());
    com.tencent.mm.plugin.performance.a.a.MIk.a(new com.tencent.mm.plugin.performance.diagnostic.c.b());
    com.tencent.mm.plugin.performance.a.a.MIk.a(new com.tencent.mm.plugin.performance.diagnostic.a.e());
    com.tencent.mm.plugin.performance.diagnostic.d.alive();
    com.tencent.mm.plugin.performance.b.a locala = this.MIb;
    boolean bool = paramg.bbA();
    Log.i("ThreadPool.Profiler", s.X("[open] isProcessMain=", Boolean.valueOf(bool)));
    if ((com.tencent.mm.plugin.performance.b.a.eYL) && (bool))
    {
      paramg = new MMHandler("reportStatistics");
      paramg.postDelayed((Runnable)new a.k(locala, paramg), 1800000L);
      AppForegroundDelegate.heY.a((q)locala);
      locala.MMd.startTimer(600000L, 600000L);
    }
    AppForegroundDelegate.heY.a((r)locala);
    com.tencent.threadpool.d.ahAo = (d.e)locala.MLW;
    com.tencent.threadpool.d.ahAp = (d.f)locala.MLU;
    com.tencent.threadpool.a.ahzV = (g.b)locala.MLV;
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.performance.a.e.class, new m());
    if ((WeChatEnvironment.hasDebugger()) || (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvj, false)))
    {
      ThreadStackShinkerWrapper.markEnabled(MMApplicationContext.getContext());
      paramg = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvk, "");
      ThreadStackShinkerWrapper.storeIgnoredCreatorSoPatterns(MMApplicationContext.getContext(), paramg);
      if ((!WeChatEnvironment.hasDebugger()) && (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvl, false))) {
        break label436;
      }
      WVReservedSpaceShinkerWrapper.markEnabled(MMApplicationContext.getContext());
      WVReservedSpaceShinkerWrapper.markStartupFine(MMApplicationContext.getContext());
      label310:
      if ((!WeChatEnvironment.hasDebugger()) && (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvm, false))) {
        break label445;
      }
      PatronsWrapper.installExceptionFuse();
      PatronsWrapper.markEnabled(MMApplicationContext.getContext(), false);
      label346:
      if ((!WeChatEnvironment.hasDebugger()) && (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvo, false))) {
        break label454;
      }
      GCSemiSpaceTrimWrapper.markEnabled(MMApplicationContext.getContext(), false);
      label379:
      if ((!WeChatEnvironment.hasDebugger()) && (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvn, false))) {
        break label463;
      }
      PatronsWrapper.markAggressiveStrategyEnabled(MMApplicationContext.getContext());
    }
    for (;;)
    {
      af.qs("wechat-backtrace", "${data}/files/wechat-backtrace/saving-cache");
      AppMethodBeat.o(124902);
      return;
      ThreadStackShinkerWrapper.markDisabled(MMApplicationContext.getContext());
      break;
      label436:
      WVReservedSpaceShinkerWrapper.markDisabled(MMApplicationContext.getContext());
      break label310;
      label445:
      PatronsWrapper.markDisabled(MMApplicationContext.getContext());
      break label346;
      label454:
      GCSemiSpaceTrimWrapper.markDisabled(MMApplicationContext.getContext());
      break label379;
      label463:
      PatronsWrapper.markAggressiveStrategyDisabled(MMApplicationContext.getContext());
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
      localObject = com.tencent.mm.plugin.performance.elf.b.MLv;
    }
    try
    {
      ((com.tencent.mm.plugin.performance.elf.b)localObject).egk = com.tencent.mm.plugin.performance.elf.b.cP(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yLs, 0) / 10000.0F);
      com.tencent.mm.plugin.performance.elf.b.MLp = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yLv, 1200000L);
      Log.i("MicroMsg.ProcessElf", "[call] isEnable:%b CHECK_TIME:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.performance.elf.b)localObject).egk), Long.valueOf(com.tencent.mm.plugin.performance.elf.b.gyW()) });
      if (((com.tencent.mm.plugin.performance.elf.b)localObject).egk)
      {
        com.tencent.mm.plugin.performance.elf.b.MKQ.removeCallbacks(com.tencent.mm.plugin.performance.elf.b.MLx);
        com.tencent.mm.plugin.performance.elf.b.MKQ.postDelayed(com.tencent.mm.plugin.performance.elf.b.MLx, com.tencent.mm.plugin.performance.elf.b.gyW());
      }
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("ACTION_ELF_CHECK_RESPONSE");
      ((IntentFilter)localObject).addAction("com.tencent.mm.MMUIModeManager");
      MMApplicationContext.getContext().registerReceiver(com.tencent.mm.plugin.performance.elf.b.MLw, (IntentFilter)localObject);
      paramg.bGP.registerActivityLifecycleCallbacks(new com.tencent.mm.ag.a());
      setupMemoryWatchDog();
      paramg.bGP.registerActivityLifecycleCallbacks(new ThreadWatchDog());
      localObject = com.tencent.mm.plugin.performance.watchdogs.b.gzp();
      try
      {
        ((com.tencent.mm.plugin.performance.watchdogs.b)localObject).MMT = FDDumpBridge.getFDLimit();
        MultiProcessMMKV.getDefault().encode("mFdLimit", ((com.tencent.mm.plugin.performance.watchdogs.b)localObject).MMT);
        Log.i("MicroMsg.FDWatchDog", "FdLimit = %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.performance.watchdogs.b)localObject).MMT) });
        i = 230;
        if (((com.tencent.mm.plugin.performance.watchdogs.b)localObject).MMT > 1024) {
          break label630;
        }
        i = 231;
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1031L, i, 1L, false);
      }
      finally
      {
        for (;;)
        {
          int i;
          int j;
          Log.printErrStackTrace("MicroMsg.FDWatchDog", localThrowable, "get resource limit err", new Object[0]);
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1031L, 251L, 1L, false);
        }
        locali = com.tencent.threadpool.h.ahAA;
        if (!((com.tencent.mm.plugin.performance.watchdogs.e)localObject).ffv) {
          break label735;
        }
      }
      com.tencent.threadpool.h.ahAA.p((Runnable)localObject, 1800000L);
      localObject = com.tencent.mm.plugin.performance.watchdogs.e.gzB();
      if (!MMApplicationContext.isMainProcess())
      {
        Log.e("MicroMsg.ProcessWatchDog", "NOT main process");
        setupPerformanceComponents(paramg);
        setupBitmapDecodeCanary(paramg);
        this.MIc = a.aRo(paramg.mProcessName);
        localObject = this.MIc;
        ((a)localObject).mState = ((a)localObject).eMf.decodeInt("state", 0);
        Log.d("MicroMsg.ForegroundKilledDetect", "%s: CHECK LAST STATE = %s", new Object[] { ((a)localObject).mProcessName, Integer.toBinaryString(((a)localObject).mState) });
        if ((((a)localObject).gxQ()) && (((a)localObject).gxR()) && (!((a)localObject).gxS()))
        {
          Log.e("MicroMsg.ForegroundKilledDetect", "%s: LAST STATE ERROR: %s", new Object[] { ((a)localObject).mProcessName, Integer.toBinaryString(((a)localObject).mState) });
          com.tencent.mm.kernel.h.baF().a(new a.1((a)localObject));
        }
        ((a)localObject).afs(1);
        ((a)localObject).afs(2);
        ((a)localObject).afs(4);
        ((a)localObject).gxT();
        this.MIc.onAppForeground("boot");
        paramg.bGP.registerActivityLifecycleCallbacks(this.MIc);
        CrashReportFactory.addCrashReportExtraMessageGetter(this.MIc);
        Log.i("MicroMsg.PluginPerformance", "build.ENABLE_MATRIX_MEMORY_HOOK = %s, build.ENABLE_MATRIX_PTHREAD_HOOK = %s, build.ENABLE_MATRIX_SILENCE_ANALYSE = %s", new Object[] { Boolean.valueOf(BuildInfo.ENABLE_MATRIX_MEMORY_HOOK), Boolean.valueOf(BuildInfo.ENABLE_MATRIX_PTHREAD_HOOK), Boolean.valueOf(BuildInfo.ENABLE_MATRIX_SILENCE_ANALYSE) });
        if (com.tencent.matrix.c.a.ayu() > 0)
        {
          Log.w("MicroMsg.PluginPerformance", "Enable pthread hook for further trace");
          com.tencent.mm.plugin.performance.a.a.MIk.aRq("<cmd><diagnostic><PthreadHook\n enable='1' process='mm' duration='1' hook='.*\\.so$' thread='.*'/></diagnostic></cmd>");
        }
        com.tencent.matrix.c.c.a(new com.tencent.matrix.c.c.a()
        {
          public final void ayF()
          {
            AppMethodBeat.i(300793);
            com.tencent.matrix.c.a.nj(com.tencent.matrix.c.a.ayu() + 1);
            if (((com.tencent.mm.plugin.performance.diagnostic.c.b)com.tencent.mm.plugin.performance.a.a.MIk.bX(com.tencent.mm.plugin.performance.diagnostic.c.b.class)).MKM.gyp())
            {
              Log.w("MicroMsg.PluginPerformance", "Dump pthread report");
              ((com.tencent.mm.plugin.performance.diagnostic.c.b)com.tencent.mm.plugin.performance.a.a.MIk.bX(com.tencent.mm.plugin.performance.diagnostic.c.b.class)).iT(false);
            }
            AppMethodBeat.o(300793);
          }
        });
        AppMethodBeat.o(124903);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ProcessElf", localException, "", new Object[0]);
        com.tencent.mm.plugin.performance.elf.b.MLp = 1200000L;
        ((com.tencent.mm.plugin.performance.elf.b)localObject).egk = com.tencent.mm.plugin.performance.elf.b.DEBUG;
        continue;
        label630:
        if (((com.tencent.mm.plugin.performance.watchdogs.b)localObject).MMT <= 2048)
        {
          i = 232;
        }
        else
        {
          j = ((com.tencent.mm.plugin.performance.watchdogs.b)localObject).MMT;
          if (j <= 4096) {
            i = 233;
          }
        }
      }
    }
    com.tencent.threadpool.i locali;
    label735:
    for (long l = 300000L;; l = 1800000L)
    {
      locali.p((Runnable)localObject, l);
      break;
    }
  }
  
  public com.tencent.mm.plugin.performance.b.a getThreadPoolProfiler()
  {
    return this.MIb;
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
      com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new PluginPerformance.5(this), 2000L);
      if ((!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED) && (!com.tencent.mm.protocal.d.Yxk) && (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zgY, 1) != 1)) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      AppForegroundDelegate.hff = bool;
      AppMethodBeat.o(124905);
      return;
    }
  }
  
  public void onAccountRelease() {}
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(124907);
    com.tencent.mm.plugin.performance.elf.a.bY(MainProcessChecker.class).du(false);
    com.tencent.mm.plugin.performance.watchdogs.d.gzs().du(false);
    com.tencent.mm.plugin.performance.watchdogs.e.gzB().ffv = false;
    if (this.MIc != null) {
      this.MIc.onAppBackground(paramString);
    }
    startBackgroundActivationsListener(MMApplicationContext.getContext());
    AppMethodBeat.o(124907);
  }
  
  public void onAppForeground(String paramString)
  {
    AppMethodBeat.i(124906);
    com.tencent.mm.plugin.performance.elf.a.bY(MainProcessChecker.class).du(true);
    com.tencent.mm.plugin.performance.watchdogs.d.gzs().du(true);
    com.tencent.mm.plugin.performance.watchdogs.e.gzB().ffv = true;
    if (this.MIc != null) {
      this.MIc.onAppForeground(paramString);
    }
    stopBackgroundActivationsListener(MMApplicationContext.getContext());
    AppMethodBeat.o(124906);
  }
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate() {}
  
  public void onLowMemory()
  {
    AppMethodBeat.i(300876);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(300789);
        Log.e("MicroMsg.PluginPerformance", "onLowMemory -> dump memory");
        Log.i("MicroMsg.PluginPerformance", "[onLowMemory] %s", new Object[] { com.tencent.mm.plugin.performance.watchdogs.d.gzs().af(true, 0) });
        AppMethodBeat.o(300789);
      }
    });
    AppMethodBeat.o(300876);
  }
  
  public void onTerminate() {}
  
  public void onTrimMemory(final int paramInt)
  {
    AppMethodBeat.i(300879);
    if (paramInt <= 15) {
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(300788);
          Log.e("MicroMsg.PluginPerformance", "onTrimMemory level:%d -> dump memory", new Object[] { Integer.valueOf(paramInt) });
          Log.i("MicroMsg.PluginPerformance", "[onTrimMemory] %s", new Object[] { com.tencent.mm.plugin.performance.watchdogs.d.gzs().af(true, 0) });
          AppMethodBeat.o(300788);
        }
      });
    }
    AppMethodBeat.o(300879);
  }
  
  public String toString()
  {
    return "plugin-performance";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.PluginPerformance
 * JD-Core Version:    0.7.0.1
 */