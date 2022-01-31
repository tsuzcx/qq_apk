package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.au;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

final class SettingsNotificationUI$4
  implements DialogInterface.OnClickListener
{
  SettingsNotificationUI$4(SettingsNotificationUI paramSettingsNotificationUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127355);
    com.tencent.mm.m.f.bU(true);
    ((CheckBoxPreference)SettingsNotificationUI.a(this.qJo).atx("settings_new_voip_msg_notification")).vxW = true;
    this.qJo.initView();
    au.k(false, true);
    AppMethodBeat.o(127355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI.4
 * JD-Core Version:    0.7.0.1
 */