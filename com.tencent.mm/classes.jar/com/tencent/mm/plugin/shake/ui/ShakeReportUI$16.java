package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;

final class ShakeReportUI$16
  implements DialogInterface.OnCancelListener
{
  ShakeReportUI$16(ShakeReportUI paramShakeReportUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface.dismiss();
    ShakeReportUI.b(this.odm, true);
    ShakeReportUI.J(this.odm);
    ShakeReportUI.K(this.odm).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.16
 * JD-Core Version:    0.7.0.1
 */