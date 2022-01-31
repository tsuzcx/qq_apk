package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsChattingUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsChattingUI$1(SettingsChattingUI paramSettingsChattingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127209);
    this.qIf.hideVKB();
    this.qIf.finish();
    AppMethodBeat.o(127209);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.1
 * JD-Core Version:    0.7.0.1
 */