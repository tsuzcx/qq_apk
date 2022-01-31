package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$21
  implements DialogInterface.OnClickListener
{
  ShakeReportUI$21(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(24799);
    this.qRs.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    ShakeReportUI.P(this.qRs);
    this.qRs.finish();
    AppMethodBeat.o(24799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.21
 * JD-Core Version:    0.7.0.1
 */