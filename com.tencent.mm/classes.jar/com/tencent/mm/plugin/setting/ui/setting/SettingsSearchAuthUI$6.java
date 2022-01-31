package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsSearchAuthUI$6
  implements MenuItem.OnMenuItemClickListener
{
  SettingsSearchAuthUI$6(SettingsSearchAuthUI paramSettingsSearchAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127446);
    if (paramMenuItem.getItemId() == 700)
    {
      SettingsSearchAuthUI.a(this.qJW, false);
      SettingsSearchAuthUI.g(this.qJW).notifyDataSetChanged();
      SettingsSearchAuthUI.e(this.qJW);
    }
    AppMethodBeat.o(127446);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.6
 * JD-Core Version:    0.7.0.1
 */