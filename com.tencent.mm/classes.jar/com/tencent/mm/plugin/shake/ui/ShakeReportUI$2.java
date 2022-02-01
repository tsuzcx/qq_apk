package com.tencent.mm.plugin.shake.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$2
  implements DialogInterface.OnClickListener
{
  ShakeReportUI$2(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(28447);
    if (ShakeReportUI.s(this.Dlj) != null) {
      ShakeReportUI.s(this.Dlj).cancel();
    }
    AppMethodBeat.o(28447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.2
 * JD-Core Version:    0.7.0.1
 */