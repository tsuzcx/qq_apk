package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsAliasUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SettingsAliasUI$2(SettingsAliasUI paramSettingsAliasUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127185);
    this.qIa.hideVKB();
    this.qIa.finish();
    AppMethodBeat.o(127185);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.2
 * JD-Core Version:    0.7.0.1
 */