package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsAddMeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsAddMeUI$1(SettingsAddMeUI paramSettingsAddMeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127168);
    this.qHQ.hideVKB();
    this.qHQ.finish();
    AppMethodBeat.o(127168);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAddMeUI.1
 * JD-Core Version:    0.7.0.1
 */