package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dh;

final class SettingsModifyAliasCheckUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsModifyAliasCheckUI$1(SettingsModifyAliasCheckUI paramSettingsModifyAliasCheckUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(220997);
    paramMenuItem = new dh();
    paramMenuItem.mw(SettingsAliasUI.yGx);
    paramMenuItem.dPH = 7L;
    paramMenuItem.aLk();
    this.yHz.onBackPressed();
    AppMethodBeat.o(220997);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasCheckUI.1
 * JD-Core Version:    0.7.0.1
 */