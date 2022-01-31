package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

final class SettingsAboutSystemUI$9
  implements DialogInterface.OnClickListener
{
  SettingsAboutSystemUI$9(SettingsAboutSystemUI paramSettingsAboutSystemUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127119);
    this.qHp.getDefaultSharedPreferences().edit().putBoolean("settings_voicerecorder_mode", true).commit();
    ((CheckBoxPreference)SettingsAboutSystemUI.a(this.qHp).atx("settings_voicerecorder_mode")).vxW = true;
    SettingsAboutSystemUI.a(this.qHp).notifyDataSetChanged();
    AppMethodBeat.o(127119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.9
 * JD-Core Version:    0.7.0.1
 */