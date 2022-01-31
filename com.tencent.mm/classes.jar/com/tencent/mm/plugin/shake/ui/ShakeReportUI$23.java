package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$23
  implements DialogInterface.OnClickListener
{
  ShakeReportUI$23(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(24801);
    ShakeReportUI.P(this.qRs);
    this.qRs.finish();
    AppMethodBeat.o(24801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.23
 * JD-Core Version:    0.7.0.1
 */