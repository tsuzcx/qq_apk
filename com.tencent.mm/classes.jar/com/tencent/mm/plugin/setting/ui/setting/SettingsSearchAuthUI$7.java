package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class SettingsSearchAuthUI$7
  implements MenuItem.OnMenuItemClickListener
{
  SettingsSearchAuthUI$7(SettingsSearchAuthUI paramSettingsSearchAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 700)
    {
      SettingsSearchAuthUI.a(this.nVN, true);
      SettingsSearchAuthUI.g(this.nVN).notifyDataSetChanged();
      SettingsSearchAuthUI.e(this.nVN);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.7
 * JD-Core Version:    0.7.0.1
 */