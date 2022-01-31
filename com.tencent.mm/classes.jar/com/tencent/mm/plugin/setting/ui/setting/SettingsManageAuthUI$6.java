package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsManageAuthUI$6
  implements MenuItem.OnMenuItemClickListener
{
  SettingsManageAuthUI$6(SettingsManageAuthUI paramSettingsManageAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127251);
    if (paramMenuItem.getItemId() == 700)
    {
      SettingsManageAuthUI.a(this.qIF, true);
      SettingsManageAuthUI.d(this.qIF).notifyDataSetChanged();
      SettingsManageAuthUI.e(this.qIF);
    }
    AppMethodBeat.o(127251);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.6
 * JD-Core Version:    0.7.0.1
 */