package com.tencent.mm.plugin.story.ui.album;

import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class StoryAlbumUI$b
  implements MenuItem.OnMenuItemClickListener
{
  StoryAlbumUI$b(StoryAlbumUI paramStoryAlbumUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(119830);
    paramMenuItem = this.Fze.getActivity();
    if (paramMenuItem != null) {
      paramMenuItem.finish();
    }
    AppMethodBeat.o(119830);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryAlbumUI.b
 * JD-Core Version:    0.7.0.1
 */