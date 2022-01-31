package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2
  implements Runnable
{
  e$2(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(72674);
    SmcLogic.OnReportResp(3, -1, null, this.qsa.cCy);
    AppMethodBeat.o(72674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.e.2
 * JD-Core Version:    0.7.0.1
 */