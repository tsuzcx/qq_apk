package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsUploadUI$8
  implements DialogInterface.OnClickListener
{
  SnsUploadUI$8(SnsUploadUI paramSnsUploadUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(145658);
    this.sbR.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    paramDialogInterface.dismiss();
    AppMethodBeat.o(145658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.8
 * JD-Core Version:    0.7.0.1
 */