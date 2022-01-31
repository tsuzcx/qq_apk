package com.tencent.mm.plugin.story.ui.album;

import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class StoryFavSelectUI$b
  implements MenuItem.OnMenuItemClickListener
{
  StoryFavSelectUI$b(StoryFavSelectUI paramStoryFavSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(110187);
    StoryFavSelectUI.a(this.sJA);
    this.sJA.finish();
    AppMethodBeat.o(110187);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI.b
 * JD-Core Version:    0.7.0.1
 */