package com.tencent.mm.plugin.voiceprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class VoiceLoginUI$2
  implements DialogInterface.OnClickListener
{
  VoiceLoginUI$2(VoiceLoginUI paramVoiceLoginUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.pMu.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI.2
 * JD-Core Version:    0.7.0.1
 */