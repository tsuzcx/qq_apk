package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsAboutSystemUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsAboutSystemUI$1(SettingsAboutSystemUI paramSettingsAboutSystemUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127107);
    this.qHp.hideVKB();
    this.qHp.finish();
    AppMethodBeat.o(127107);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.1
 * JD-Core Version:    0.7.0.1
 */