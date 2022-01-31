package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.as;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

final class SettingsNotificationUI$3
  implements DialogInterface.OnClickListener
{
  SettingsNotificationUI$3(SettingsNotificationUI paramSettingsNotificationUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mm.m.f.bv(true);
    ((CheckBoxPreference)SettingsNotificationUI.a(this.nVj).add("settings_new_voip_msg_notification")).rHo = true;
    this.nVj.initView();
    as.j(false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI.3
 * JD-Core Version:    0.7.0.1
 */