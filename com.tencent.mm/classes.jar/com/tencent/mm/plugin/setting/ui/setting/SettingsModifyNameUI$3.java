package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.m.b;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;

final class SettingsModifyNameUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SettingsModifyNameUI$3(SettingsModifyNameUI paramSettingsModifyNameUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = SettingsModifyNameUI.c(this.nVa).getText().toString();
    String str = b.Ak();
    if ((!bk.bl(str)) && (paramMenuItem.matches(".*[" + str + "].*")))
    {
      h.b(this.nVa.mController.uMN, this.nVa.getString(a.i.invalid_input_character_toast, new Object[] { str }), this.nVa.getString(a.i.app_tip), true);
      return false;
    }
    c.d(SettingsModifyNameUI.c(this.nVa)).fJ(1, 32).a(this.nVa);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI.3
 * JD-Core Version:    0.7.0.1
 */