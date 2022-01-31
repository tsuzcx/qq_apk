package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryGalleryView$n
  implements Runnable
{
  StoryGalleryView$n(StoryGalleryView paramStoryGalleryView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(110817);
    if ((StoryGalleryView.h(this.sTX) != -1) && (StoryGalleryView.h(this.sTX) < StoryGalleryView.g(this.sTX).size()) && (this.euX < ((ArrayList)StoryGalleryView.g(this.sTX).get(StoryGalleryView.h(this.sTX))).size()))
    {
      Object localObject = StoryGalleryView.sTW;
      ab.d(StoryGalleryView.access$getTAG$cp(), "setCurrentHItem=" + StoryGalleryView.h(this.sTX) + " galleryGroups.size=" + StoryGalleryView.g(this.sTX).size() + " galleryGroups[selectedRow].size=" + ((ArrayList)StoryGalleryView.g(this.sTX).get(StoryGalleryView.h(this.sTX))).size() + " hRecyclerView=" + StoryGalleryView.i(this.sTX));
      localObject = StoryGalleryView.i(this.sTX);
      if (localObject != null)
      {
        ((RecyclerView)localObject).bJ(this.euX);
        AppMethodBeat.o(110817);
        return;
      }
    }
    AppMethodBeat.o(110817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.n
 * JD-Core Version:    0.7.0.1
 */