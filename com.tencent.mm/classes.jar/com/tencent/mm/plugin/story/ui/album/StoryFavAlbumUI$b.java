package com.tencent.mm.plugin.story.ui.album;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class StoryFavAlbumUI$b
  implements MenuItem.OnMenuItemClickListener
{
  StoryFavAlbumUI$b(StoryFavAlbumUI paramStoryFavAlbumUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(119847);
    this.Fzj.finish();
    AppMethodBeat.o(119847);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI.b
 * JD-Core Version:    0.7.0.1
 */