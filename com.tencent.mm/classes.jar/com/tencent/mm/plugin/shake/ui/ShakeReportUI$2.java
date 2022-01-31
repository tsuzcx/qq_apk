package com.tencent.mm.plugin.shake.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ShakeReportUI$2
  implements DialogInterface.OnClickListener
{
  ShakeReportUI$2(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ShakeReportUI.r(this.odm) != null) {
      ShakeReportUI.r(this.odm).cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.2
 * JD-Core Version:    0.7.0.1
 */