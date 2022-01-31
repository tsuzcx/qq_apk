package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class SettingsChattingUI$2$3
  implements DialogInterface.OnClickListener
{
  SettingsChattingUI$2$3(SettingsChattingUI.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127212);
    h.qsU.e(14553, new Object[] { Integer.valueOf(5), Integer.valueOf(3), "" });
    SettingsChattingUI.a(this.qIg.qIf).show();
    SettingsChattingUI.a(this.qIg.qIf, false);
    SettingsChattingUI.b(this.qIg.qIf);
    AppMethodBeat.o(127212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.2.3
 * JD-Core Version:    0.7.0.1
 */