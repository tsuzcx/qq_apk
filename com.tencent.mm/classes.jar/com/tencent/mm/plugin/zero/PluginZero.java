package com.tencent.mm.plugin.zero;

import android.os.Build.VERSION;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.ck.a.a;
import com.tencent.mm.ck.i;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.zero.tasks.LoadNormsgJNITask;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac;
import java.io.File;

public class PluginZero
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.zero.a.d
{
  private static final int[] rSd = { 6, 6, 0, 1, 2, 3, 4, 5 };
  private a rSa = new a();
  private b rSb = new b();
  private final com.tencent.mm.app.e rSc = new com.tencent.mm.app.e();
  public com.tencent.mm.plugin.zero.a.b rSe;
  public PluginZero.b rSf = new PluginZero.b();
  public PluginZero.a rSg = new PluginZero.a();
  
  private void initSDRoot()
  {
    if (!new File(ac.dOP + "SdcardInfo.cfg").exists())
    {
      com.tencent.mm.compatible.util.e.fc(com.tencent.mm.compatible.util.e.bkF);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", new Object[] { com.tencent.mm.compatible.util.e.bkF });
      return;
    }
    String str2 = com.tencent.mm.compatible.util.e.bkF;
    com.tencent.mm.storage.y localy = new com.tencent.mm.storage.y(ac.dOP + "SdcardInfo.cfg");
    String str3 = (String)localy.get(1, "");
    int i = ((Integer)localy.get(2, Integer.valueOf(0))).intValue();
    int j = Build.VERSION.SDK_INT;
    if (bk.bl(str3))
    {
      localy.set(1, str2);
      localy.set(2, Integer.valueOf(j));
    }
    for (String str1 = str2;; str1 = str3)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", new Object[] { str3, str1, str2, Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.compatible.util.e.fc(str1);
      if ((i == j) || (com.tencent.mm.compatible.util.f.zF())) {
        break;
      }
      if ((!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted")) || (!new File(com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()).canWrite())) {
        break label296;
      }
      localy.set(1, str2);
      localy.set(2, Integer.valueOf(j));
      com.tencent.mm.compatible.util.e.fc(str2);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", new Object[] { com.tencent.mm.compatible.util.e.bkF, Boolean.valueOf(com.tencent.mm.compatible.util.f.zF()) });
      return;
    }
    label296:
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", new Object[] { com.tencent.mm.compatible.util.e.bkF, Boolean.valueOf(com.tencent.mm.compatible.util.f.zF()), str2 });
  }
  
  private void setupStubLog()
  {
    com.tencent.e.a.b.a(new PluginZero.3(this));
  }
  
  private void setupVendingLog()
  {
    com.tencent.mm.vending.f.a.a(new PluginZero.4(this));
  }
  
  public com.tencent.mm.vending.b.b addICoreServiceLifecycleCallback(com.tencent.mm.plugin.zero.a.a parama)
  {
    return this.rSg.aj(parama);
  }
  
  public com.tencent.mm.vending.b.b addNotifyReceiverCallback(com.tencent.mm.plugin.zero.a.c paramc)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", new Object[] { this, paramc });
    return this.rSf.aj(paramc);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    try
    {
      initSDRoot();
      ae.bw(paramg.dIA);
      com.tencent.mm.kernel.a.a.j("configure [%s], setup broken library handler...", new Object[] { this });
      k.setupBrokenLibraryHandler();
      setupStubLog();
      setupVendingLog();
      if (paramg.Ex())
      {
        com.tencent.mm.kernel.a.a.j("configure [%s], for process[%s]...", new Object[] { this, paramg.dIA });
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.e(this.rSa));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.e(this.rSb));
        com.tencent.mm.kernel.a.a.j("configure [%s], make worker core...", new Object[] { this });
        com.tencent.mm.kernel.g localg = com.tencent.mm.kernel.g.DQ();
        if (!localg.dKZ)
        {
          localg.dKZ = true;
          localg.dKS = new com.tencent.mm.kernel.e(com.tencent.mm.kernel.a.c.DY());
          localg.dKT = new com.tencent.mm.kernel.a(com.tencent.mm.kernel.a.c.DY());
          localg.dKU = new com.tencent.mm.kernel.b(localg.dKW, localg.dJS);
          localg.dKV = new com.tencent.mm.ce.b(ae.getContext());
        }
        com.tencent.mm.kernel.g.DQ().a(new PluginZero.1(this, paramg));
        com.tencent.mm.kernel.g.DQ();
        i.wDi = new com.tencent.mm.vending.h.h(com.tencent.mm.ck.d.c(com.tencent.mm.kernel.g.DS().crf()), "WeChat.WORKER");
        com.tencent.mm.vending.h.g.a("WeChat.WORKER", i.wDi);
        new com.tencent.mm.plugin.zero.tasks.a().before(this);
      }
      if ((paramg.Ex()) || (paramg.gn(":push"))) {
        new LoadNormsgJNITask().before(new LoadProtocolJNITask().before(this));
      }
      if (paramg.gn(":push"))
      {
        AppLogic.setCallBack(new AppCallBack(ae.getContext()));
        k.b(com.tencent.mm.kernel.b.dJR, getClass().getClassLoader());
        SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.PluginZero", localException, "what happened?", new Object[0]);
      }
    }
  }
  
  public void dependency()
  {
    dependsOnRoot();
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      com.tencent.mm.kernel.g.DQ().dKW.aj(new PluginZero.2(this, paramg));
      NotifyReceiver.vY();
    }
  }
  
  public void installed()
  {
    alias(com.tencent.mm.plugin.zero.a.d.class);
  }
  
  public void setILightPushDelegate(com.tencent.mm.plugin.zero.a.b paramb)
  {
    this.rSe = paramb;
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