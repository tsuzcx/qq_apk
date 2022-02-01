package com.tencent.mm.plugin.teenmode.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsTeenModeMainBizAcct$5
  implements MenuItem.OnMenuItemClickListener
{
  SettingsTeenModeMainBizAcct$5(SettingsTeenModeMainBizAcct paramSettingsTeenModeMainBizAcct) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(259339);
    this.Mud.onBackPressed();
    AppMethodBeat.o(259339);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainBizAcct.5
 * JD-Core Version:    0.7.0.1
 */