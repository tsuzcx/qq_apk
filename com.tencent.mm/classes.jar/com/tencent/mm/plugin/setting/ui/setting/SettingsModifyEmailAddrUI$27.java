package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class SettingsModifyEmailAddrUI$27
  implements MenuItem.OnMenuItemClickListener
{
  SettingsModifyEmailAddrUI$27(SettingsModifyEmailAddrUI paramSettingsModifyEmailAddrUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    SettingsModifyEmailAddrUI.a(this.nUU, SettingsModifyEmailAddrUI.c(this.nUU).getText().toString().trim());
    if (!bk.ZC(SettingsModifyEmailAddrUI.d(this.nUU)))
    {
      h.h(this.nUU.mController.uMN, a.i.verify_email_err_tip, a.i.app_tip);
      return true;
    }
    paramMenuItem = (Integer)g.DP().Dz().get(7, null);
    if ((paramMenuItem != null) && ((paramMenuItem.intValue() & 0x2) != 0)) {}
    for (boolean bool = true; (!SettingsModifyEmailAddrUI.d(this.nUU).equals(SettingsModifyEmailAddrUI.e(this.nUU))) || (!Boolean.valueOf(bool).booleanValue()); bool = false)
    {
      paramMenuItem = new d(d.fju, SettingsModifyEmailAddrUI.d(this.nUU));
      g.Dk().a(paramMenuItem, 0);
      SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI1 = this.nUU;
      SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI2 = this.nUU;
      this.nUU.getString(a.i.app_tip);
      SettingsModifyEmailAddrUI.a(localSettingsModifyEmailAddrUI1, h.b(localSettingsModifyEmailAddrUI2, this.nUU.getString(a.i.settings_binding), true, new SettingsModifyEmailAddrUI.27.1(this, paramMenuItem)));
      this.nUU.XM();
      return true;
    }
    this.nUU.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.27
 * JD-Core Version:    0.7.0.1
 */