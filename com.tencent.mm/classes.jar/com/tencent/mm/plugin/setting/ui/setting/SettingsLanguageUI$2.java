package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsLanguageUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SettingsLanguageUI$2(SettingsLanguageUI paramSettingsLanguageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127238);
    SettingsLanguageUI.a(this.qIB, SettingsLanguageUI.a(this.qIB), SettingsLanguageUI.b(this.qIB));
    this.qIB.finish();
    AppMethodBeat.o(127238);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI.2
 * JD-Core Version:    0.7.0.1
 */