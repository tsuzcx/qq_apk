package com.tencent.mm.plugin.voip_cs.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipCSMainUI$8
  implements DialogInterface.OnClickListener
{
  VoipCSMainUI$8(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(135396);
    paramDialogInterface.dismiss();
    this.tLK.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(135396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.8
 * JD-Core Version:    0.7.0.1
 */