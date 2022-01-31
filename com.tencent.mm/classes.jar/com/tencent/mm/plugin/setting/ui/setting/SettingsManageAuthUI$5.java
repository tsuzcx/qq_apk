package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsManageAuthUI$5
  implements MenuItem.OnMenuItemClickListener
{
  SettingsManageAuthUI$5(SettingsManageAuthUI paramSettingsManageAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127250);
    if (paramMenuItem.getItemId() == 700)
    {
      SettingsManageAuthUI.a(this.qIF, false);
      SettingsManageAuthUI.d(this.qIF).notifyDataSetChanged();
      SettingsManageAuthUI.e(this.qIF);
    }
    AppMethodBeat.o(127250);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.5
 * JD-Core Version:    0.7.0.1
 */