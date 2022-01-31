package com.tencent.mm.plugin.shake.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$5
  implements View.OnClickListener
{
  ShakeReportUI$5(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24780);
    ShakeReportUI.s(this.qRs).cancel();
    AppMethodBeat.o(24780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.5
 * JD-Core Version:    0.7.0.1
 */