package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class ShakeReportUI$21
  implements DialogInterface.OnClickListener
{
  ShakeReportUI$21(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.odm.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    ShakeReportUI.N(this.odm);
    this.odm.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.21
 * JD-Core Version:    0.7.0.1
 */