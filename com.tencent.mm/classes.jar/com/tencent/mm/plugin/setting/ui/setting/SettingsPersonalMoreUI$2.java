package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsPersonalMoreUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SettingsPersonalMoreUI$2(SettingsPersonalMoreUI paramSettingsPersonalMoreUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127382);
    this.qJs.hideVKB();
    this.qJs.finish();
    AppMethodBeat.o(127382);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI.2
 * JD-Core Version:    0.7.0.1
 */