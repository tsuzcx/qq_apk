package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingDeleteAccountInputPassUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingDeleteAccountInputPassUI$1(SettingDeleteAccountInputPassUI paramSettingDeleteAccountInputPassUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127066);
    this.qGM.hideVKB();
    this.qGM.finish();
    AppMethodBeat.o(127066);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountInputPassUI.1
 * JD-Core Version:    0.7.0.1
 */