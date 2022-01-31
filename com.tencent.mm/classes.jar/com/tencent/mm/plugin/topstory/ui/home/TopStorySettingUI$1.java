package com.tencent.mm.plugin.topstory.ui.home;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStorySettingUI$1
  implements MenuItem.OnMenuItemClickListener
{
  TopStorySettingUI$1(TopStorySettingUI paramTopStorySettingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(1625);
    this.thb.finish();
    AppMethodBeat.o(1625);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI.1
 * JD-Core Version:    0.7.0.1
 */