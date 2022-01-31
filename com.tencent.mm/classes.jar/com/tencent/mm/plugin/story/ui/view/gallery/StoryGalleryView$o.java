package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryGalleryView$o
  implements Runnable
{
  StoryGalleryView$o(StoryGalleryView paramStoryGalleryView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(110818);
    StoryGalleryView.a locala = StoryGalleryView.sTW;
    ab.d(StoryGalleryView.access$getTAG$cp(), "setCurrentVItem " + this.euX + ", all:" + StoryGalleryView.g(this.sTX).size());
    if (this.euX < StoryGalleryView.g(this.sTX).size()) {
      StoryGalleryView.d(this.sTX).bJ(this.euX);
    }
    AppMethodBeat.o(110818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.o
 * JD-Core Version:    0.7.0.1
 */