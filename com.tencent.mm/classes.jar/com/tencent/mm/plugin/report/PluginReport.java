package com.tencent.mm.plugin.report;

import android.annotation.SuppressLint;
import android.app.Application;
import com.tencent.matrix.d;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a.a;
import com.tencent.mm.app.o;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public class PluginReport
  extends f
  implements o, com.tencent.mm.kernel.api.c, c
{
  private y Cxs;
  private a.a Cxt;
  
  public PluginReport()
  {
    AppMethodBeat.i(186000);
    this.Cxt = new a.a()
    {
      public final void cg(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(224150);
        try
        {
          com.tencent.mm.g.b.a.g localg = new com.tencent.mm.g.b.a.g();
          localg.ejz = localg.x("ProcessName", MMApplicationContext.getProcessName(), true);
          localg.ejy = paramAnonymousInt1;
          localg.ejA = paramAnonymousInt2;
          localg.ejB = localg.x("Stack", getStack(), true);
          localg.bfK();
          AppMethodBeat.o(224150);
          return;
        }
        catch (Exception localException)
        {
          Log.e("Matrix.PluginReport", "AlarmHelper.IReportCrash Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          AppMethodBeat.o(224150);
        }
      }
      
      @SuppressLint({"RestrictedApi"})
      public final String getStack()
      {
        AppMethodBeat.i(224151);
        try
        {
          String str1 = com.tencent.matrix.a.c.c.getThrowableStack(new Throwable());
          AppMethodBeat.o(224151);
          return str1;
        }
        catch (Exception localException)
        {
          Log.e("Matrix.PluginReport", "getStack() %s", new Object[] { localException.getMessage() });
          String str2 = Util.getStack().toString();
          AppMethodBeat.o(224151);
          return str2;
        }
      }
    };
    AppMethodBeat.o(186000);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(143776);
    if (MMApplicationContext.isMainProcess())
    {
      Log.i("Matrix.PluginReport", "load matrixmrs so");
      PluginReport.class.getClassLoader();
      j.Ed("matrixmrs");
      this.Cxs = new y(k.class);
      com.tencent.mm.kernel.g.a(y.class, new com.tencent.mm.kernel.c.e(this.Cxs));
    }
    paramg = e.Cxv;
    h localh = h.CyF;
    Log.i("MicroMsg.ReportService", "instance set %s", new Object[] { localh });
    paramg.Cxw = localh;
    AppMethodBeat.o(143776);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(143775);
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(s.class);
    }
    AppMethodBeat.o(143775);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(143777);
    com.tencent.matrix.c.a((Application)MMApplicationContext.getContext(), d.cPI);
    if (com.tencent.mm.a.a.dgB == null) {
      com.tencent.mm.a.a.dgB = this.Cxt;
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
    paramc = d.cPI;
    com.tencent.mm.kernel.g.aAf();
    long l = com.tencent.mm.kernel.a.getUin();
    if (paramc.isInitialized)
    {
      Log.i("MatrixDelegate", "[onAccountReady] uin=".concat(String.valueOf(l)));
      Assert.assertTrue(MMApplicationContext.isMainProcess());
      paramc = paramc.cPJ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.PluginReport
 * JD-Core Version:    0.7.0.1
 */