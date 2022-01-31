package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsChattingBackgroundUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsChattingBackgroundUI$1(SettingsChattingBackgroundUI paramSettingsChattingBackgroundUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127197);
    this.qIe.hideVKB();
    this.qIe.finish();
    AppMethodBeat.o(127197);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI.1
 * JD-Core Version:    0.7.0.1
 */