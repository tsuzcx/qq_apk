package com.tencent.mm.plugin.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;

final class PluginReport$1
  implements a.a
{
  PluginReport$1(PluginReport paramPluginReport) {}
  
  public final void ce(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193470);
    try
    {
      com.tencent.mm.g.b.a.a locala = new com.tencent.mm.g.b.a.a();
      locala.dFc = locala.t("ProcessName", aj.getProcessName(), true);
      locala.dFb = paramInt1;
      locala.dFd = paramInt2;
      locala.dFe = locala.t("Stack", getStack(), true);
      locala.aBj();
      AppMethodBeat.o(193470);
      return;
    }
    catch (Exception localException)
    {
      ad.e("Matrix.PluginReport", "AlarmHelper.IReportCrash Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(193470);
    }
  }
  
  public final String getStack()
  {
    AppMethodBeat.i(193471);
    try
    {
      String str1 = com.tencent.matrix.a.d.a.getThrowableStack(new Throwable());
      AppMethodBeat.o(193471);
      return str1;
    }
    catch (Exception localException)
    {
      ad.e("Matrix.PluginReport", "getStack() %s", new Object[] { localException.getMessage() });
      String str2 = bt.eGN().toString();
      AppMethodBeat.o(193471);
      return str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.PluginReport.1
 * JD-Core Version:    0.7.0.1
 */