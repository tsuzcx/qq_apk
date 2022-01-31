package com.tencent.mm.plugin.story.ui.album;

import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class StoryFavSelectUI$c
  implements MenuItem.OnMenuItemClickListener
{
  StoryFavSelectUI$c(StoryFavSelectUI paramStoryFavSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(151132);
    this.sJA.finish();
    AppMethodBeat.o(151132);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI.c
 * JD-Core Version:    0.7.0.1
 */