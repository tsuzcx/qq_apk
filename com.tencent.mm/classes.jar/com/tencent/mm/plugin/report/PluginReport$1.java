package com.tencent.mm.plugin.report;

import android.annotation.SuppressLint;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a.a;
import com.tencent.mm.f.b.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

final class PluginReport$1
  implements a.a
{
  PluginReport$1(PluginReport paramPluginReport) {}
  
  public final void cz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193829);
    try
    {
      j localj = new j();
      localj.gee = localj.z("ProcessName", MMApplicationContext.getProcessName(), true);
      localj.ged = paramInt1;
      localj.gef = paramInt2;
      localj.geg = localj.z("Stack", getStack(), true);
      localj.bpa();
      AppMethodBeat.o(193829);
      return;
    }
    catch (Exception localException)
    {
      Log.e("Matrix.PluginReport", "AlarmHelper.IReportCrash Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(193829);
    }
  }
  
  @SuppressLint({"RestrictedApi"})
  public final String getStack()
  {
    AppMethodBeat.i(193830);
    try
    {
      String str1 = b.getThrowableStack(new Throwable());
      AppMethodBeat.o(193830);
      return str1;
    }
    catch (Exception localException)
    {
      Log.e("Matrix.PluginReport", "getStack() %s", new Object[] { localException.getMessage() });
      String str2 = Util.getStack().toString();
      AppMethodBeat.o(193830);
      return str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.PluginReport.1
 * JD-Core Version:    0.7.0.1
 */