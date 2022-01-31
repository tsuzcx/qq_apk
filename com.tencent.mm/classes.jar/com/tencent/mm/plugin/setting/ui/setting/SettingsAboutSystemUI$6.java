package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class SettingsAboutSystemUI$6
  implements DialogInterface.OnClickListener
{
  SettingsAboutSystemUI$6(SettingsAboutSystemUI paramSettingsAboutSystemUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user go set system nfc switch");
    SettingsAboutSystemUI.d(this.nTp);
    this.nTp.startActivity(new Intent("android.settings.NFC_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.6
 * JD-Core Version:    0.7.0.1
 */