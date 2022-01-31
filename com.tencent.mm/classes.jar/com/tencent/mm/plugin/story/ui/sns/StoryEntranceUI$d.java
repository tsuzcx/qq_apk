package com.tencent.mm.plugin.story.ui.sns;

import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class StoryEntranceUI$d
  implements MenuItem.OnMenuItemClickListener
{
  StoryEntranceUI$d(StoryEntranceUI paramStoryEntranceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(110258);
    this.sKz.finish();
    AppMethodBeat.o(110258);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI.d
 * JD-Core Version:    0.7.0.1
 */