package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsLanguageUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsLanguageUI$1(SettingsLanguageUI paramSettingsLanguageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127237);
    this.qIB.hideVKB();
    this.qIB.finish();
    AppMethodBeat.o(127237);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI.1
 * JD-Core Version:    0.7.0.1
 */