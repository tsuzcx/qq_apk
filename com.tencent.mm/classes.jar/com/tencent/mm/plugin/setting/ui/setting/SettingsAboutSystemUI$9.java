package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.f;

final class SettingsAboutSystemUI$9
  implements DialogInterface.OnClickListener
{
  SettingsAboutSystemUI$9(SettingsAboutSystemUI paramSettingsAboutSystemUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.nTp.dnD.edit().putBoolean("settings_voicerecorder_mode", true).commit();
    ((CheckBoxPreference)SettingsAboutSystemUI.a(this.nTp).add("settings_voicerecorder_mode")).rHo = true;
    SettingsAboutSystemUI.a(this.nTp).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.9
 * JD-Core Version:    0.7.0.1
 */