package com.tencent.mm.plugin.voiceprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsVoicePrintUI$6
  implements DialogInterface.OnClickListener
{
  SettingsVoicePrintUI$6(SettingsVoicePrintUI paramSettingsVoicePrintUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(26147);
    paramDialogInterface.dismiss();
    this.tsf.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(26147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI.6
 * JD-Core Version:    0.7.0.1
 */