package com.tencent.mm.plugin.story.ui.album;

import a.l;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class StoryAlbumUI$b
  implements MenuItem.OnMenuItemClickListener
{
  StoryAlbumUI$b(StoryAlbumUI paramStoryAlbumUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(110168);
    paramMenuItem = this.sJs.getActivity();
    if (paramMenuItem != null) {
      paramMenuItem.finish();
    }
    AppMethodBeat.o(110168);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryAlbumUI.b
 * JD-Core Version:    0.7.0.1
 */