package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsManageFindMoreUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SettingsManageFindMoreUI$3(SettingsManageFindMoreUI paramSettingsManageFindMoreUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127270);
    this.qIQ.finish();
    AppMethodBeat.o(127270);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI.3
 * JD-Core Version:    0.7.0.1
 */