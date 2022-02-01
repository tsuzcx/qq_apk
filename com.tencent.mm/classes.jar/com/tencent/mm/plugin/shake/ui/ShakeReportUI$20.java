package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$20
  implements DialogInterface.OnClickListener
{
  ShakeReportUI$20(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(28469);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(28469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.20
 * JD-Core Version:    0.7.0.1
 */