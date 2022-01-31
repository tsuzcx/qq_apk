package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsAboutMicroMsgUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsAboutMicroMsgUI$1(SettingsAboutMicroMsgUI paramSettingsAboutMicroMsgUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127087);
    this.qHg.hideVKB();
    this.qHg.finish();
    AppMethodBeat.o(127087);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.1
 * JD-Core Version:    0.7.0.1
 */