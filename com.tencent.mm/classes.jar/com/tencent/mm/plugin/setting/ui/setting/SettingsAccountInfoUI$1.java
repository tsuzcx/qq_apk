package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsAccountInfoUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsAccountInfoUI$1(SettingsAccountInfoUI paramSettingsAccountInfoUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127142);
    this.qHH.hideVKB();
    this.qHH.finish();
    AppMethodBeat.o(127142);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI.1
 * JD-Core Version:    0.7.0.1
 */