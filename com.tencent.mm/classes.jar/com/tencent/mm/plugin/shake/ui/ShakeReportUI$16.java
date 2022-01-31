package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$16
  implements DialogInterface.OnCancelListener
{
  ShakeReportUI$16(ShakeReportUI paramShakeReportUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(24794);
    paramDialogInterface.dismiss();
    ShakeReportUI.b(this.qRs, true);
    ShakeReportUI.L(this.qRs);
    ShakeReportUI.M(this.qRs).setText("");
    AppMethodBeat.o(24794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.16
 * JD-Core Version:    0.7.0.1
 */