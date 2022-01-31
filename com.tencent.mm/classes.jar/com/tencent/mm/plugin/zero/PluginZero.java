package com.tencent.mm.plugin.zero;

import android.os.Build.VERSION;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.cm.i;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.zero.tasks.LoadNormsgJNITask;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.y;
import java.io.File;

public class PluginZero
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.zero.a.d
{
  private static final int[] vIY = { 6, 6, 0, 1, 2, 3, 4, 5 };
  private a vIV;
  private b vIW;
  private final com.tencent.mm.app.e vIX;
  public com.tencent.mm.plugin.zero.a.b vIZ;
  public PluginZero.b vJa;
  public PluginZero.a yLW;
  
  public PluginZero()
  {
    AppMethodBeat.i(58762);
    this.vIV = new a();
    this.vIW = new b();
    this.vIX = new com.tencent.mm.app.e();
    this.vJa = new PluginZero.b();
    this.yLW = new PluginZero.a();
    AppMethodBeat.o(58762);
  }
  
  private void initSDRoot()
  {
    AppMethodBeat.i(58766);
    if (!new File(ac.eQv + "SdcardInfo.cfg").exists())
    {
      com.tencent.mm.compatible.util.e.lo(com.tencent.mm.compatible.util.e.eQx);
      ab.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", new Object[] { com.tencent.mm.compatible.util.e.eQx });
      AppMethodBeat.o(58766);
      return;
    }
    String str2 = com.tencent.mm.compatible.util.e.eQx;
    y localy = new y(ac.eQv + "SdcardInfo.cfg");
    String str3 = (String)localy.get(1, "");
    int i = ((Integer)localy.get(2, Integer.valueOf(0))).intValue();
    int j = Build.VERSION.SDK_INT;
    if (bo.isNullOrNil(str3))
    {
      localy.set(1, str2);
      localy.set(2, Integer.valueOf(j));
    }
    for (String str1 = str2;; str1 = str3)
    {
      ab.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", new Object[] { str3, str1, str2, Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.compatible.util.e.lo(str1);
      if ((i == j) || (com.tencent.mm.compatible.util.f.Mi())) {
        break label342;
      }
      if ((!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted")) || (!new File(com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()).canWrite())) {
        break;
      }
      localy.set(1, str2);
      localy.set(2, Integer.valueOf(j));
      com.tencent.mm.compatible.util.e.lo(str2);
      ab.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", new Object[] { com.tencent.mm.compatible.util.e.eQx, Boolean.valueOf(com.tencent.mm.compatible.util.f.Mi()) });
      AppMethodBeat.o(58766);
      return;
    }
    ab.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", new Object[] { com.tencent.mm.compatible.util.e.eQx, Boolean.valueOf(com.tencent.mm.compatible.util.f.Mi()), str2 });
    label342:
    AppMethodBeat.o(58766);
  }
  
  private void setupStubLog()
  {
    AppMethodBeat.i(58768);
    com.tencent.f.a.b.a(new PluginZero.3(this));
    AppMethodBeat.o(58768);
  }
  
  private void setupVendingLog()
  {
    AppMethodBeat.i(58769);
    com.tencent.mm.vending.f.a.a(new PluginZero.4(this));
    AppMethodBeat.o(58769);
  }
  
  public com.tencent.mm.vending.b.b addICoreServiceLifecycleCallback(com.tencent.mm.plugin.zero.a.a parama)
  {
    AppMethodBeat.i(58771);
    parama = this.yLW.at(parama);
    AppMethodBeat.o(58771);
    return parama;
  }
  
  public com.tencent.mm.vending.b.b addNotifyReceiverCallback(com.tencent.mm.plugin.zero.a.c paramc)
  {
    AppMethodBeat.i(58770);
    ab.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", new Object[] { this, paramc });
    paramc = this.vJa.at(paramc);
    AppMethodBeat.o(58770);
    return paramc;
  }
  
  public void configure(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(58765);
    try
    {
      initSDRoot();
      ah.setProcessName(paramg.mProcessName);
      com.tencent.mm.kernel.a.a.g("configure [%s], setup broken library handler...", new Object[] { this });
      setupStubLog();
      setupVendingLog();
      if (paramg.SD())
      {
        com.tencent.mm.kernel.a.a.g("configure [%s], for process[%s]...", new Object[] { this, paramg.mProcessName });
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.e(this.vIV));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.e(this.vIW));
        com.tencent.mm.kernel.a.a.g("configure [%s], make worker core...", new Object[] { this });
        com.tencent.mm.kernel.g localg = com.tencent.mm.kernel.g.RM();
        if (!localg.eIx)
        {
          localg.eIx = true;
          localg.eIq = new com.tencent.mm.kernel.e(com.tencent.mm.kernel.a.c.RX());
          localg.eIr = new com.tencent.mm.kernel.a(com.tencent.mm.kernel.a.c.RX());
          localg.eIs = new com.tencent.mm.kernel.b(localg.eIu, localg.eHs);
          localg.eIt = new com.tencent.mm.cf.b(ah.getContext());
        }
        NotifyReceiver.Im();
        com.tencent.mm.kernel.g.RM().a(new com.tencent.mm.kernel.api.g()
        {
          public final void BN()
          {
            AppMethodBeat.i(58746);
            com.tencent.mm.kernel.a.a.g("onStartupDone", new Object[0]);
            AppMethodBeat.o(58746);
          }
          
          public final void br(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(58747);
            if (paramAnonymousBoolean)
            {
              l.n(paramg.bX, true);
              l.o(paramg.bX, true);
            }
            ab.dsI();
            AppMethodBeat.o(58747);
          }
        });
        com.tencent.mm.kernel.g.RM();
        i.AZz = new com.tencent.mm.vending.h.h(com.tencent.mm.cm.d.c(com.tencent.mm.kernel.g.RO().caB()), "WeChat.WORKER");
        com.tencent.mm.vending.h.g.a("WeChat.WORKER", i.AZz);
        new com.tencent.mm.plugin.zero.tasks.a().before(this);
      }
      if ((paramg.SD()) || (paramg.mI(":push"))) {
        new LoadNormsgJNITask().before(new LoadProtocolJNITask().before(this));
      }
      if (paramg.mI(":push"))
      {
        AppLogic.setCallBack(new AppCallBack(ah.getContext()));
        k.a(com.tencent.mm.kernel.b.eHr, getClass().getClassLoader());
        SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
      }
      AppMethodBeat.o(58765);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.PluginZero", localException, "what happened?", new Object[0]);
      }
    }
  }
  
  public void dependency()
  {
    AppMethodBeat.i(58764);
    dependsOnRoot();
    AppMethodBeat.o(58764);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(58767);
    if (paramg.SD())
    {
      com.tencent.mm.kernel.g.RM().eIu.at(new PluginZero.2(this, paramg));
      NotifyReceiver.In();
    }
    AppMethodBeat.o(58767);
  }
  
  public void installed()
  {
    AppMethodBeat.i(58763);
    alias(com.tencent.mm.plugin.zero.a.d.class);
    AppMethodBeat.o(58763);
  }
  
  public void setILightPushDelegate(com.tencent.mm.plugin.zero.a.b paramb)
  {
    this.vIZ = paramb;
  }
  
  public String toString()
  {
    return "plugin-zero";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero
 * JD-Core Version:    0.7.0.1
 */