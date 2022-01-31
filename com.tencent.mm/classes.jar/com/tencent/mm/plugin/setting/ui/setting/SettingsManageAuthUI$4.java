package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.b;

final class SettingsManageAuthUI$4
  implements MenuItem.OnMenuItemClickListener
{
  SettingsManageAuthUI$4(SettingsManageAuthUI paramSettingsManageAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127249);
    paramMenuItem = new Intent(this.qIF, SettingsSearchAuthUI.class);
    this.qIF.startActivity(paramMenuItem);
    b.ie(this.qIF);
    AppMethodBeat.o(127249);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.4
 * JD-Core Version:    0.7.0.1
 */