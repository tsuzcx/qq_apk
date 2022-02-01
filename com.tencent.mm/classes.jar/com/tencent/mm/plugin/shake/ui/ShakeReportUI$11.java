package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$11
  implements Runnable
{
  ShakeReportUI$11(ShakeReportUI paramShakeReportUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(28460);
    if (ShakeReportUI.r(this.yQi) != null) {
      ShakeReportUI.r(this.yQi).setVisibility(8);
    }
    AppMethodBeat.o(28460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.11
 * JD-Core Version:    0.7.0.1
 */