package com.tencent.mm.plugin.story.ui;

import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class StorySettingsUI$ac
  implements MenuItem.OnMenuItemClickListener
{
  StorySettingsUI$ac(StorySettingsUI paramStorySettingsUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(110078);
    this.sHQ.finish();
    AppMethodBeat.o(110078);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.ac
 * JD-Core Version:    0.7.0.1
 */