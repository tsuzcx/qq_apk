package com.tencent.mm.plugin.report;

import android.app.Application;
import com.tencent.matrix.d;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.a.a.a;
import com.tencent.mm.app.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import junit.framework.Assert;

public class PluginReport
  extends com.tencent.mm.kernel.b.f
  implements q, com.tencent.mm.kernel.api.c, c
{
  private y OyZ;
  private a.a Oza;
  
  public PluginReport()
  {
    AppMethodBeat.i(186000);
    this.Oza = new PluginReport.1(this);
    AppMethodBeat.o(186000);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(143776);
    if (MMApplicationContext.isMainProcess())
    {
      Log.i("Matrix.PluginReport", "load matrixmrs so");
      PluginReport.class.getClassLoader();
      com.tencent.mm.compatible.util.k.DA("matrixmrs");
      this.OyZ = new y(com.tencent.mm.plugin.report.service.k.class);
      com.tencent.mm.kernel.h.a(y.class, new com.tencent.mm.kernel.c.e(this.OyZ));
    }
    paramg = f.Ozc;
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    Log.i("MicroMsg.ReportService", "instance set %s", new Object[] { localh });
    paramg.Ozd = localh;
    AppMethodBeat.o(143776);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(143775);
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(v.class);
    }
    AppMethodBeat.o(143775);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(143777);
    d.a((Application)MMApplicationContext.getContext(), com.tencent.matrix.e.eLE);
    if (a.hbJ == null) {
      a.hbJ = this.Oza;
    }
    AppMethodBeat.o(143777);
  }
  
  public void installed()
  {
    AppMethodBeat.i(143774);
    alias(c.class);
    AppMethodBeat.o(143774);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(143778);
    paramc = com.tencent.matrix.e.eLE;
    com.tencent.mm.kernel.h.baC();
    long l = b.getUin();
    if (paramc.baY)
    {
      Log.i("MatrixDelegate", "[onAccountReady] uin=".concat(String.valueOf(l)));
      Assert.assertTrue(MMApplicationContext.isMainProcess());
      paramc = paramc.eLF;
      MrsLogic.setUin(l);
      paramc.isInit = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.PluginReport
 * JD-Core Version:    0.7.0.1
 */