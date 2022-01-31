package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsNetStatUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsNetStatUI$1(SettingsNetStatUI paramSettingsNetStatUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127341);
    this.qJn.hideVKB();
    this.qJn.finish();
    AppMethodBeat.o(127341);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI.1
 * JD-Core Version:    0.7.0.1
 */