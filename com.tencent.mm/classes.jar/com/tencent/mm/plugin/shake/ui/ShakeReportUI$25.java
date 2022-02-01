package com.tencent.mm.plugin.shake.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$25
  implements DialogInterface.OnClickListener
{
  ShakeReportUI$25(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(273549);
    if (ShakeReportUI.i(this.PEm) != null) {
      ShakeReportUI.i(this.PEm).cancel();
    }
    AppMethodBeat.o(273549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.25
 * JD-Core Version:    0.7.0.1
 */