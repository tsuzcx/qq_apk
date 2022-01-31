package com.tencent.mm.plugin.voiceprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class SettingsVoicePrintUI$6
  implements DialogInterface.OnClickListener
{
  SettingsVoicePrintUI$6(SettingsVoicePrintUI paramSettingsVoicePrintUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.pMj.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI.6
 * JD-Core Version:    0.7.0.1
 */