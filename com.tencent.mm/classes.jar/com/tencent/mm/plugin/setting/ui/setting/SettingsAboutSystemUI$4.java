package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

final class SettingsAboutSystemUI$4
  implements DialogInterface.OnClickListener
{
  SettingsAboutSystemUI$4(SettingsAboutSystemUI paramSettingsAboutSystemUI, CheckBoxPreference paramCheckBoxPreference, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74044);
    this.Jgp.setChecked(this.Jgq);
    SettingsAboutSystemUI.a(this.Jgj).notifyDataSetChanged();
    AppMethodBeat.o(74044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.4
 * JD-Core Version:    0.7.0.1
 */