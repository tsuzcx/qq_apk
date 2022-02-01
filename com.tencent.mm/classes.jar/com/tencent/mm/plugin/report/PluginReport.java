package com.tencent.mm.plugin.report;

import android.app.Application;
import com.tencent.matrix.d;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a.a;
import com.tencent.mm.app.n;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import junit.framework.Assert;

public class PluginReport
  extends f
  implements n, com.tencent.mm.kernel.api.c, c
{
  private t ygF;
  private a.a ygG;
  
  public PluginReport()
  {
    AppMethodBeat.i(186000);
    this.ygG = new PluginReport.1(this);
    AppMethodBeat.o(186000);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(143776);
    if (aj.cmR())
    {
      ad.i("Matrix.PluginReport", "load matrixmrs so");
      PluginReport.class.getClassLoader();
      com.tencent.mm.compatible.util.j.vr("matrixmrs");
      this.ygF = new t(com.tencent.mm.plugin.report.service.j.class);
      com.tencent.mm.kernel.g.a(t.class, new com.tencent.mm.kernel.c.e(this.ygF));
    }
    paramg = e.ygI;
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
    ad.i("MicroMsg.ReportService", "instance set %s", new Object[] { localg });
    paramg.ygJ = localg;
    AppMethodBeat.o(143776);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(143775);
    if (aj.cmR()) {
      dependsOn(r.class);
    }
    AppMethodBeat.o(143775);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(143777);
    com.tencent.matrix.c.a((Application)aj.getContext(), d.cBd);
    if (com.tencent.mm.a.a.cPw == null) {
      com.tencent.mm.a.a.cPw = this.ygG;
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
    paramc = d.cBd;
    com.tencent.mm.kernel.g.ajA();
    long l = com.tencent.mm.kernel.a.getUin();
    if (paramc.isInitialized)
    {
      ad.i("MatrixDelegate", "[onAccountReady] uin=".concat(String.valueOf(l)));
      Assert.assertTrue(aj.cmR());
      paramc = paramc.cBe;
      MrsLogic.setUin(l);
      paramc.cAX = true;
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