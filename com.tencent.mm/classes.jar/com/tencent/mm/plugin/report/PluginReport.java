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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;

public class PluginReport
  extends f
  implements n, com.tencent.mm.kernel.api.c, c
{
  private t wSZ;
  private a.a wTa;
  
  public PluginReport()
  {
    AppMethodBeat.i(186000);
    this.wTa = new a.a()
    {
      public final void cb(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(206463);
        try
        {
          com.tencent.mm.g.b.a.a locala = new com.tencent.mm.g.b.a.a();
          locala.dCP = locala.t("ProcessName", ai.getProcessName(), true);
          locala.dCO = paramAnonymousInt1;
          locala.dCQ = paramAnonymousInt2;
          locala.dCR = locala.t("Stack", getStack(), true);
          locala.aHZ();
          AppMethodBeat.o(206463);
          return;
        }
        catch (Exception localException)
        {
          ac.e("Matrix.PluginReport", "AlarmHelper.IReportCrash Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          AppMethodBeat.o(206463);
        }
      }
      
      public final String getStack()
      {
        AppMethodBeat.i(206464);
        try
        {
          String str1 = com.tencent.matrix.a.d.a.getThrowableStack(new Throwable());
          AppMethodBeat.o(206464);
          return str1;
        }
        catch (Exception localException)
        {
          ac.e("Matrix.PluginReport", "getStack() %s", new Object[] { localException.getMessage() });
          String str2 = bs.eWi().toString();
          AppMethodBeat.o(206464);
          return str2;
        }
      }
    };
    AppMethodBeat.o(186000);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(143776);
    if (ai.cin())
    {
      ac.i("Matrix.PluginReport", "load matrixmrs so");
      PluginReport.class.getClassLoader();
      j.sC("matrixmrs");
      this.wSZ = new t(k.class);
      com.tencent.mm.kernel.g.a(t.class, new com.tencent.mm.kernel.c.e(this.wSZ));
    }
    paramg = e.wTc;
    h localh = h.wUl;
    ac.i("MicroMsg.ReportService", "instance set %s", new Object[] { localh });
    paramg.wTd = localh;
    AppMethodBeat.o(143776);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(143775);
    if (ai.cin()) {
      dependsOn(q.class);
    }
    AppMethodBeat.o(143775);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(143777);
    com.tencent.matrix.c.a((Application)ai.getContext(), d.cql);
    if (com.tencent.mm.a.a.cEr == null) {
      com.tencent.mm.a.a.cEr = this.wTa;
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
    paramc = d.cql;
    com.tencent.mm.kernel.g.agP();
    long l = com.tencent.mm.kernel.a.getUin();
    if (paramc.isInitialized)
    {
      ac.i("MatrixDelegate", "[onAccountReady] uin=".concat(String.valueOf(l)));
      Assert.assertTrue(ai.cin());
      paramc = paramc.cqm;
      MrsLogic.setUin(l);
      paramc.cqf = true;
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