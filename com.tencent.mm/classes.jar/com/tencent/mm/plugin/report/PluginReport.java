package com.tencent.mm.plugin.report;

import android.app.Application;
import com.tencent.matrix.d;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a.a;
import com.tencent.mm.app.o;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import junit.framework.Assert;

public class PluginReport
  extends f
  implements o, com.tencent.mm.kernel.api.c, c
{
  private u yww;
  private a.a ywx;
  
  public PluginReport()
  {
    AppMethodBeat.i(186000);
    this.ywx = new a.a()
    {
      public final void ce(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(221075);
        try
        {
          com.tencent.mm.g.b.a.a locala = new com.tencent.mm.g.b.a.a();
          locala.dQA = locala.t("ProcessName", ak.getProcessName(), true);
          locala.dQz = paramAnonymousInt1;
          locala.dQB = paramAnonymousInt2;
          locala.dQC = locala.t("Stack", getStack(), true);
          locala.aLH();
          AppMethodBeat.o(221075);
          return;
        }
        catch (Exception localException)
        {
          ae.e("Matrix.PluginReport", "AlarmHelper.IReportCrash Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          AppMethodBeat.o(221075);
        }
      }
      
      public final String getStack()
      {
        AppMethodBeat.i(221076);
        try
        {
          String str1 = com.tencent.matrix.a.d.a.getThrowableStack(new Throwable());
          AppMethodBeat.o(221076);
          return str1;
        }
        catch (Exception localException)
        {
          ae.e("Matrix.PluginReport", "getStack() %s", new Object[] { localException.getMessage() });
          String str2 = bu.fpN().toString();
          AppMethodBeat.o(221076);
          return str2;
        }
      }
    };
    AppMethodBeat.o(186000);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(143776);
    if (ak.coh())
    {
      ae.i("Matrix.PluginReport", "load matrixmrs so");
      PluginReport.class.getClassLoader();
      com.tencent.mm.compatible.util.j.vN("matrixmrs");
      this.yww = new u(com.tencent.mm.plugin.report.service.j.class);
      com.tencent.mm.kernel.g.a(u.class, new com.tencent.mm.kernel.c.e(this.yww));
    }
    paramg = e.ywz;
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
    ae.i("MicroMsg.ReportService", "instance set %s", new Object[] { localg });
    paramg.ywA = localg;
    AppMethodBeat.o(143776);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(143775);
    if (ak.coh()) {
      dependsOn(s.class);
    }
    AppMethodBeat.o(143775);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(143777);
    com.tencent.matrix.c.a((Application)ak.getContext(), d.cBK);
    if (com.tencent.mm.a.a.cQg == null) {
      com.tencent.mm.a.a.cQg = this.ywx;
    }
    AppMethodBeat.o(143777);
  }
  
  public void installed()
  {
    AppMethodBeat.i(143774);
    alias(c.class);
    AppMethodBeat.o(143774);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(143778);
    paramc = d.cBK;
    com.tencent.mm.kernel.g.ajP();
    long l = com.tencent.mm.kernel.a.getUin();
    if (paramc.isInitialized)
    {
      ae.i("MatrixDelegate", "[onAccountReady] uin=".concat(String.valueOf(l)));
      Assert.assertTrue(ak.coh());
      paramc = paramc.cBL;
      MrsLogic.setUin(l);
      paramc.cBE = true;
    }
    AppMethodBeat.o(143778);
  }
  
  public void onAccountRelease() {}
  
  public void onAppBackground(String paramString) {}
  
  public void onAppForeground(String paramString) {}
  
  public String toString()
  {
    return "plugin-report";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.PluginReport
 * JD-Core Version:    0.7.0.1
 */