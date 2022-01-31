package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class SettingsManageAuthUI$6
  implements MenuItem.OnMenuItemClickListener
{
  SettingsManageAuthUI$6(SettingsManageAuthUI paramSettingsManageAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 700)
    {
      SettingsManageAuthUI.a(this.nUA, true);
      SettingsManageAuthUI.d(this.nUA).notifyDataSetChanged();
      SettingsManageAuthUI.e(this.nUA);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.6
 * JD-Core Version:    0.7.0.1
 */