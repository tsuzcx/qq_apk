package com.tencent.mm.plugin.report;

import android.app.Application;
import com.tencent.matrix.d;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.a.a.a;
import com.tencent.mm.app.o;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.report.service.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import junit.framework.Assert;

public class PluginReport
  extends com.tencent.mm.kernel.b.f
  implements o, com.tencent.mm.kernel.api.c, c
{
  private y Iyu;
  private a.a Iyv;
  
  public PluginReport()
  {
    AppMethodBeat.i(186000);
    this.Iyv = new PluginReport.1(this);
    AppMethodBeat.o(186000);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(143776);
    if (MMApplicationContext.isMainProcess())
    {
      Log.i("Matrix.PluginReport", "load matrixmrs so");
      PluginReport.class.getClassLoader();
      j.KW("matrixmrs");
      this.Iyu = new y(k.class);
      com.tencent.mm.kernel.h.a(y.class, new e(this.Iyu));
    }
    paramg = f.Iyx;
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    Log.i("MicroMsg.ReportService", "instance set %s", new Object[] { localh });
    paramg.Iyy = localh;
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
    com.tencent.matrix.c.a((Application)MMApplicationContext.getContext(), d.cQA);
    if (a.eYi == null) {
      a.eYi = this.Iyv;
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
    paramc = d.cQA;
    com.tencent.mm.kernel.h.aHE();
    long l = b.getUin();
    if (paramc.isInitialized)
    {
      Log.i("MatrixDelegate", "[onAccountReady] uin=".concat(String.valueOf(l)));
      Assert.assertTrue(MMApplicationContext.isMainProcess());
      paramc = paramc.cQB;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.PluginReport
 * JD-Core Version:    0.7.0.1
 */