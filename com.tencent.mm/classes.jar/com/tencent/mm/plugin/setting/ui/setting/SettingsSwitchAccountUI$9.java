package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;

final class SettingsSwitchAccountUI$9
  implements View.OnClickListener
{
  SettingsSwitchAccountUI$9(SettingsSwitchAccountUI paramSettingsSwitchAccountUI) {}
  
  public final void onClick(View paramView)
  {
    SettingsSwitchAccountUI.b(this.nWi, false);
    SettingsSwitchAccountUI.a(this.nWi, false);
    SettingsSwitchAccountUI.d(this.nWi).setDeleteState(false);
    SettingsSwitchAccountUI.d(this.nWi).bzE();
    SettingsSwitchAccountUI.e(this.nWi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.9
 * JD-Core Version:    0.7.0.1
 */