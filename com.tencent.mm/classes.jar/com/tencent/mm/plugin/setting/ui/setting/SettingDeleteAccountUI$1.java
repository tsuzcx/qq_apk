package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingDeleteAccountUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingDeleteAccountUI$1(SettingDeleteAccountUI paramSettingDeleteAccountUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127070);
    this.qGN.hideVKB();
    this.qGN.finish();
    AppMethodBeat.o(127070);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountUI.1
 * JD-Core Version:    0.7.0.1
 */