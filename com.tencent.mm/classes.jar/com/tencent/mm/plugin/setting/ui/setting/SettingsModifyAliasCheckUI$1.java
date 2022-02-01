package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gc;

final class SettingsModifyAliasCheckUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsModifyAliasCheckUI$1(SettingsModifyAliasCheckUI paramSettingsModifyAliasCheckUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(256548);
    paramMenuItem = new gc();
    paramMenuItem.tm(SettingsAliasUI.Dbv);
    paramMenuItem.ejW = 7L;
    paramMenuItem.bfK();
    this.DcB.onBackPressed();
    AppMethodBeat.o(256548);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasCheckUI.1
 * JD-Core Version:    0.7.0.1
 */