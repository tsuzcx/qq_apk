package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsMoreSafeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsMoreSafeUI$1(SettingsMoreSafeUI paramSettingsMoreSafeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127324);
    this.qJl.hideVKB();
    this.qJl.finish();
    AppMethodBeat.o(127324);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI.1
 * JD-Core Version:    0.7.0.1
 */