package com.tencent.mm.plugin.shake.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.d;

final class ShakeReportUI$22
  implements Runnable
{
  ShakeReportUI$22(ShakeReportUI paramShakeReportUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(24800);
    if (ShakeReportUI.f(this.qRs) != null) {
      ShakeReportUI.f(this.qRs).dmK();
    }
    AppMethodBeat.o(24800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.22
 * JD-Core Version:    0.7.0.1
 */