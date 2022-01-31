package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$13
  implements Runnable
{
  ShakeReportUI$13(ShakeReportUI paramShakeReportUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(24791);
    if (ShakeReportUI.F(this.qRs) != null) {
      ShakeReportUI.F(this.qRs).setVisibility(8);
    }
    if (ShakeReportUI.G(this.qRs) != null) {
      ShakeReportUI.G(this.qRs).setVisibility(8);
    }
    if (ShakeReportUI.H(this.qRs) != null) {
      ShakeReportUI.H(this.qRs).setVisibility(0);
    }
    if ((!ShakeReportUI.I(this.qRs)) && (!ShakeReportUI.C(this.qRs))) {
      ShakeReportUI.J(this.qRs);
    }
    AppMethodBeat.o(24791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.13
 * JD-Core Version:    0.7.0.1
 */