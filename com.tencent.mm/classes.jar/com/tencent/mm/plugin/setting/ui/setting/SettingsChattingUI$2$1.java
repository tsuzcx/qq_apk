package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsChattingUI$2$1
  implements DialogInterface.OnCancelListener
{
  SettingsChattingUI$2$1(SettingsChattingUI.2 param2) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127210);
    SettingsChattingUI.a(this.qIg.qIf, true);
    AppMethodBeat.o(127210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.2.1
 * JD-Core Version:    0.7.0.1
 */