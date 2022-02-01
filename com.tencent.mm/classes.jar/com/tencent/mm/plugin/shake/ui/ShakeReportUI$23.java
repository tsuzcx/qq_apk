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
    AppMethodBeat.i(28472);
    ShakeReportUI.P(this.Dlj);
    this.Dlj.finish();
    AppMethodBeat.o(28472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.23
 * JD-Core Version:    0.7.0.1
 */