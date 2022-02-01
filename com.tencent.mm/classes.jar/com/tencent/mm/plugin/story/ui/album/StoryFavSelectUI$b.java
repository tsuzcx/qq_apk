package com.tencent.mm.plugin.story.ui.album;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class StoryFavSelectUI$b
  implements MenuItem.OnMenuItemClickListener
{
  StoryFavSelectUI$b(StoryFavSelectUI paramStoryFavSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(119863);
    StoryFavSelectUI.a(this.ysc);
    this.ysc.finish();
    AppMethodBeat.o(119863);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI.b
 * JD-Core Version:    0.7.0.1
 */