package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsModifyNameUI$4
  implements MenuItem.OnMenuItemClickListener
{
  SettingsModifyNameUI$4(SettingsModifyNameUI paramSettingsModifyNameUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127309);
    this.qJf.hideVKB();
    this.qJf.finish();
    AppMethodBeat.o(127309);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI.4
 * JD-Core Version:    0.7.0.1
 */