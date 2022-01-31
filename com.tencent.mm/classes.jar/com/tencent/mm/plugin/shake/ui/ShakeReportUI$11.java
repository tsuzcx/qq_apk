package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$11
  implements Runnable
{
  ShakeReportUI$11(ShakeReportUI paramShakeReportUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(24789);
    if (ShakeReportUI.r(this.qRs) != null) {
      ShakeReportUI.r(this.qRs).setVisibility(8);
    }
    AppMethodBeat.o(24789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.11
 * JD-Core Version:    0.7.0.1
 */