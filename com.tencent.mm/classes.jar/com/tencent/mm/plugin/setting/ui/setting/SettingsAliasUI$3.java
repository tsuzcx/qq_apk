package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class SettingsAliasUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SettingsAliasUI$3(SettingsAliasUI paramSettingsAliasUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    SettingsAliasUI.a(this.nUa, SettingsAliasUI.c(this.nUa).getText().toString().trim());
    if (q.Gj().equalsIgnoreCase(SettingsAliasUI.d(this.nUa)))
    {
      this.nUa.XM();
      this.nUa.finish();
      return true;
    }
    h.a(this.nUa.mController.uMN, this.nUa.getString(a.i.modify_username_confirm, new Object[] { SettingsAliasUI.d(this.nUa) }), this.nUa.getString(a.i.confirm_username), new SettingsAliasUI.3.1(this), null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.3
 * JD-Core Version:    0.7.0.1
 */