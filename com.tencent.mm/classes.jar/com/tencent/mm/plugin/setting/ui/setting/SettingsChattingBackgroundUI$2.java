package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsChattingBackgroundUI$2
  implements DialogInterface.OnClickListener
{
  SettingsChattingBackgroundUI$2(SettingsChattingBackgroundUI paramSettingsChattingBackgroundUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127198);
    this.qIe.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(127198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI.2
 * JD-Core Version:    0.7.0.1
 */