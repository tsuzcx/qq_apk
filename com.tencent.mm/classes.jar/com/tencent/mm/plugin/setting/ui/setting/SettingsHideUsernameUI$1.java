package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsHideUsernameUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsHideUsernameUI$1(SettingsHideUsernameUI paramSettingsHideUsernameUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127230);
    this.qIx.finish();
    AppMethodBeat.o(127230);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsHideUsernameUI.1
 * JD-Core Version:    0.7.0.1
 */