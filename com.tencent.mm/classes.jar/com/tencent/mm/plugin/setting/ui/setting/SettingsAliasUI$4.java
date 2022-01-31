package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;

final class SettingsAliasUI$4
  implements DialogInterface.OnCancelListener
{
  SettingsAliasUI$4(SettingsAliasUI paramSettingsAliasUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (SettingsAliasUI.f(this.nUa) != null) {
      g.Dk().c(SettingsAliasUI.f(this.nUa));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.4
 * JD-Core Version:    0.7.0.1
 */