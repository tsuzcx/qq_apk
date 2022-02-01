package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class SettingsAboutSystemUI$7
  implements DialogInterface.OnClickListener
{
  SettingsAboutSystemUI$7(SettingsAboutSystemUI paramSettingsAboutSystemUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74050);
    ae.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user cancel go set system nfc switch");
    AppMethodBeat.o(74050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.7
 * JD-Core Version:    0.7.0.1
 */