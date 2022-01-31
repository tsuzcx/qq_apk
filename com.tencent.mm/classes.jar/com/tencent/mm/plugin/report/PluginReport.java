package com.tencent.mm.plugin.report;

import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class PluginReport
  extends f
  implements com.tencent.mm.app.j, com.tencent.mm.kernel.api.c, c
{
  private q qrH;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(72660);
    if (ah.brt())
    {
      ab.i("Matrix.PluginReport", "load matrixmrs so");
      k.a("matrixmrs", PluginReport.class.getClassLoader());
    }
    this.qrH = new q(com.tencent.mm.plugin.report.service.j.class);
    com.tencent.mm.kernel.g.a(q.class, new com.tencent.mm.kernel.c.e(this.qrH));
    e locale = e.qrI;
    h localh = h.qsU;
    ab.i("MicroMsg.ReportService", "instance set %s", new Object[] { localh });
    locale.qrJ = localh;
    MatrixReport.setMrsCallback(new com.tencent.mrs.a.a());
    com.tencent.mrs.a.k(paramg.bX);
    AppMethodBeat.o(72660);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(72659);
    dependsOn(p.class);
    AppMethodBeat.o(72659);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(72658);
    alias(c.class);
    AppMethodBeat.o(72658);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(72662);
    com.tencent.mrs.a.dTm();
    AppMethodBeat.o(72662);
  }
  
  public void onAccountRelease() {}
  
  public void onAppBackground(String paramString) {}
  
  public void onAppForeground(String paramString) {}
  
  public String toString()
  {
    return "plugin-report";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.PluginReport
 * JD-Core Version:    0.7.0.1
 */