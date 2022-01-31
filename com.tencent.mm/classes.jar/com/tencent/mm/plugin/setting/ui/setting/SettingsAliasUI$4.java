package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class SettingsAliasUI$4
  implements DialogInterface.OnCancelListener
{
  SettingsAliasUI$4(SettingsAliasUI paramSettingsAliasUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127188);
    if (SettingsAliasUI.f(this.qIa) != null) {
      g.Rc().a(SettingsAliasUI.f(this.qIa));
    }
    AppMethodBeat.o(127188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.4
 * JD-Core Version:    0.7.0.1
 */