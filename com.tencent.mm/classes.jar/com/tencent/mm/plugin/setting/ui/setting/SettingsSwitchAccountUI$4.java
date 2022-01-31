package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.c;
import com.tencent.mm.ui.base.h;
import java.util.Map;

final class SettingsSwitchAccountUI$4
  implements SwitchAccountGridView.c
{
  SettingsSwitchAccountUI$4(SettingsSwitchAccountUI paramSettingsSwitchAccountUI) {}
  
  public final void Ms(String paramString)
  {
    h.a(this.nWi, this.nWi.getString(a.i.settings_switch_account_delete_alert, new Object[] { ((SwitchAccountModel)SettingsSwitchAccountUI.c(this.nWi).get(paramString)).username }), this.nWi.getString(a.i.app_tip), this.nWi.getString(a.i.app_yes), this.nWi.getString(a.i.app_no), new SettingsSwitchAccountUI.4.1(this, paramString), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.4
 * JD-Core Version:    0.7.0.1
 */