package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsPersonalMoreUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsPersonalMoreUI$1(SettingsPersonalMoreUI paramSettingsPersonalMoreUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74319);
    this.JiX.hideVKB();
    this.JiX.finish();
    AppMethodBeat.o(74319);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI.1
 * JD-Core Version:    0.7.0.1
 */