package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.base.h;

final class SettingsModifyEmailAddrUI$22
  implements View.OnClickListener
{
  SettingsModifyEmailAddrUI$22(SettingsModifyEmailAddrUI paramSettingsModifyEmailAddrUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new y(y.fgs);
    g.Dk().a(paramView, 0);
    paramView = this.nUU;
    SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI = this.nUU;
    this.nUU.getString(a.i.app_tip);
    SettingsModifyEmailAddrUI.a(paramView, h.b(localSettingsModifyEmailAddrUI, this.nUU.getString(a.i.settings_unbinding), true, new SettingsModifyEmailAddrUI.22.1(this)));
    this.nUU.XM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.22
 * JD-Core Version:    0.7.0.1
 */