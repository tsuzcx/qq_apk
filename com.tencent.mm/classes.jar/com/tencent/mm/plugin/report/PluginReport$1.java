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
  
  public final void cd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197137);
    try
    {
      com.tencent.mm.g.b.a.a locala = new com.tencent.mm.g.b.a.a();
      locala.dPk = locala.t("ProcessName", aj.getProcessName(), true);
      locala.dPj = paramInt1;
      locala.dPl = paramInt2;
      locala.dPm = locala.t("Stack", getStack(), true);
      locala.aLk();
      AppMethodBeat.o(197137);
      return;
    }
    catch (Exception localException)
    {
      ad.e("Matrix.PluginReport", "AlarmHelper.IReportCrash Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(197137);
    }
  }
  
  public final String getStack()
  {
    AppMethodBeat.i(197138);
    try
    {
      String str1 = com.tencent.matrix.a.d.a.getThrowableStack(new Throwable());
      AppMethodBeat.o(197138);
      return str1;
    }
    catch (Exception localException)
    {
      ad.e("Matrix.PluginReport", "getStack() %s", new Object[] { localException.getMessage() });
      String str2 = bt.flS().toString();
      AppMethodBeat.o(197138);
      return str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.PluginReport.1
 * JD-Core Version:    0.7.0.1
 */