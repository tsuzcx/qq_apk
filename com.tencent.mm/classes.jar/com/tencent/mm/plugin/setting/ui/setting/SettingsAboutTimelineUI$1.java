package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsAboutTimelineUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsAboutTimelineUI$1(SettingsAboutTimelineUI paramSettingsAboutTimelineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127136);
    this.qHB.hideVKB();
    this.qHB.finish();
    AppMethodBeat.o(127136);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutTimelineUI.1
 * JD-Core Version:    0.7.0.1
 */