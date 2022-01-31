package com.tencent.mm.plugin.performance;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.PluginExpt;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.performance.elf.AbstractProcessChecker;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;

public class PluginPerformance
  extends f
  implements j, c, com.tencent.mm.plugin.performance.a.a
{
  com.tencent.mm.plugin.performance.b.a prX;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(111017);
    com.tencent.mm.ci.c.ySK = new b.1();
    paramg = new com.tencent.mm.plugin.performance.b.a();
    this.prX = paramg;
    d.a(paramg);
    AppMethodBeat.o(111017);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(111016);
    dependsOn(PluginReport.class);
    dependsOn(p.class);
    dependsOn(PluginExpt.class);
    AppMethodBeat.o(111016);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(111018);
    Object localObject1;
    if (ah.dsU()) {
      localObject1 = com.tencent.mm.plugin.performance.elf.b.psT;
    }
    try
    {
      ((com.tencent.mm.plugin.performance.elf.b)localObject1).bTy = com.tencent.mm.plugin.performance.elf.b.aR(((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTK, 0) / 10000.0F);
      com.tencent.mm.plugin.performance.elf.b.psO = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTN, 1200000L);
      ab.i("MicroMsg.ProcessElf", "[call] isEnable:%b CHECK_TIME:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.performance.elf.b)localObject1).bTy), Long.valueOf(com.tencent.mm.plugin.performance.elf.b.caE()) });
      if (((com.tencent.mm.plugin.performance.elf.b)localObject1).bTy)
      {
        com.tencent.mm.plugin.performance.elf.b.psk.removeCallbacks(com.tencent.mm.plugin.performance.elf.b.psV);
        com.tencent.mm.plugin.performance.elf.b.psk.postDelayed(com.tencent.mm.plugin.performance.elf.b.psV, com.tencent.mm.plugin.performance.elf.b.caE());
      }
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("ACTION_ELF_CHECK_RESPONSE");
      ((IntentFilter)localObject1).addAction("com.tencent.mm.MMDensityManager");
      ah.getContext().registerReceiver(com.tencent.mm.plugin.performance.elf.b.psU, (IntentFilter)localObject1);
      paramg.bX.registerActivityLifecycleCallbacks(new com.tencent.mm.ac.a());
      if (ah.brt())
      {
        localObject1 = a.psb;
        localObject2 = paramg.bX;
        ((a)localObject1).bVD = true;
        ((a)localObject1).oNc.start();
        ((a)localObject1).handler = new Handler(((a)localObject1).oNc.getLooper());
        ((Application)localObject2).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      }
      localObject1 = com.tencent.mm.performance.a.a.aob();
      Object localObject2 = (ActivityManager)ah.getContext().getSystemService("activity");
      ((com.tencent.mm.performance.a.a)localObject1).gim = ((ActivityManager)localObject2).getMemoryClass();
      ((com.tencent.mm.performance.a.a)localObject1).gin = ((ActivityManager)localObject2).getLargeMemoryClass();
      ((Application)ah.getContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      localObject2 = d.ysm;
      if (((com.tencent.mm.performance.a.a)localObject1).bSe)
      {
        l = 300000L;
        ((e)localObject2).r((Runnable)localObject1, l);
        paramg.bX.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.performance.b.b());
        AppMethodBeat.o(111018);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ProcessElf", localException, "", new Object[0]);
        com.tencent.mm.plugin.performance.elf.b.psO = 1200000L;
        ((com.tencent.mm.plugin.performance.elf.b)localObject1).bTy = com.tencent.mm.plugin.performance.elf.b.DEBUG;
        continue;
        long l = 1800000L;
      }
    }
  }
  
  public void installed()
  {
    AppMethodBeat.i(111015);
    alias(com.tencent.mm.plugin.performance.a.a.class);
    AppMethodBeat.o(111015);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(111019);
    if (ah.brt()) {
      com.tencent.mm.kernel.g.RO().o(new PluginPerformance.1(this), 2000L);
    }
    AppMethodBeat.o(111019);
  }
  
  public void onAccountRelease() {}
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(151781);
    com.tencent.mm.plugin.performance.elf.a.an(MainProcessChecker.class).jY(false);
    a.psb.jY(false);
    com.tencent.mm.performance.a.a.aob().bSe = false;
    AppMethodBeat.o(151781);
  }
  
  public void onAppForeground(String paramString)
  {
    AppMethodBeat.i(151780);
    com.tencent.mm.plugin.performance.elf.a.an(MainProcessChecker.class).jY(true);
    a.psb.jY(true);
    com.tencent.mm.performance.a.a.aob().bSe = true;
    AppMethodBeat.o(151780);
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