package com.tencent.mm.plugin.report;

import com.tencent.matrix.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a.a;
import com.tencent.mm.autogen.mmdata.rpt.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

final class PluginReport$1
  implements a.a
{
  PluginReport$1(PluginReport paramPluginReport) {}
  
  public final void dn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261669);
    try
    {
      l locall = new l();
      locall.ikD = locall.F("ProcessName", MMApplicationContext.getProcessName(), true);
      locall.ikC = paramInt1;
      locall.ikE = paramInt2;
      locall.ikF = locall.F("Stack", getStack(), true);
      locall.bMH();
      AppMethodBeat.o(261669);
      return;
    }
    catch (Exception localException)
    {
      Log.e("Matrix.PluginReport", "AlarmHelper.IReportCrash Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(261669);
    }
  }
  
  public final String getStack()
  {
    AppMethodBeat.i(261671);
    try
    {
      String str1 = b.getThrowableStack(new Throwable());
      AppMethodBeat.o(261671);
      return str1;
    }
    catch (Exception localException)
    {
      Log.e("Matrix.PluginReport", "getStack() %s", new Object[] { localException.getMessage() });
      String str2 = Util.getStack().toString();
      AppMethodBeat.o(261671);
      return str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.report.PluginReport.1
 * JD-Core Version:    0.7.0.1
 */