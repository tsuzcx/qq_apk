package com.tencent.mm.plugin.report;

import android.app.Application;
import com.tencent.matrix.d;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a.a;
import com.tencent.mm.app.n;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import junit.framework.Assert;

public class PluginReport
  extends f
  implements n, com.tencent.mm.kernel.api.c, c
{
  private t vIV;
  private a.a vIW;
  
  public PluginReport()
  {
    AppMethodBeat.i(186000);
    this.vIW = new PluginReport.1(this);
    AppMethodBeat.o(186000);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(143776);
    if (aj.cbe())
    {
      ad.i("Matrix.PluginReport", "load matrixmrs so");
      PluginReport.class.getClassLoader();
      j.pq("matrixmrs");
      this.vIV = new t(k.class);
      com.tencent.mm.kernel.g.a(t.class, new com.tencent.mm.kernel.c.e(this.vIV));
    }
    paramg = e.vIY;
    h localh = h.vKh;
    ad.i("MicroMsg.ReportService", "instance set %s", new Object[] { localh });
    paramg.vIZ = localh;
    AppMethodBeat.o(143776);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(143775);
    if (aj.cbe()) {
      dependsOn(q.class);
    }
    AppMethodBeat.o(143775);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(143777);
    com.tencent.matrix.c.a((Application)aj.getContext(), d.ctd);
    if (com.tencent.mm.a.a.cHj == null) {
      com.tencent.mm.a.a.cHj = this.vIW;
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
    paramc = d.ctd;
    com.tencent.mm.kernel.g.afz();
    long l = com.tencent.mm.kernel.a.getUin();
    if (paramc.isInitialized)
    {
      ad.i("MatrixDelegate", "[onAccountReady] uin=".concat(String.valueOf(l)));
      Assert.assertTrue(aj.cbe());
      paramc = paramc.cte;
      MrsLogic.setUin(l);
      paramc.csX = true;
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