package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryGalleryView$d
  implements Runnable
{
  StoryGalleryView$d(StoryGalleryView paramStoryGalleryView) {}
  
  public final void run()
  {
    AppMethodBeat.i(110788);
    Object localObject1 = StoryGalleryView.B(this.sTX);
    if ((localObject1 != null) && (((StoryGalleryItemView)localObject1).getVideoItem() != null))
    {
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = j.b.cAB();
      Object localObject2 = StoryGalleryView.B(this.sTX);
      if (localObject2 == null) {
        a.f.b.j.ebi();
      }
      localObject2 = ((StoryGalleryItemView)localObject2).getVideoItem();
      if (localObject2 == null) {
        a.f.b.j.ebi();
      }
      int i = k.b((k)localObject1, ((i)localObject2).cJA);
      localObject1 = StoryGalleryView.sTW;
      localObject1 = StoryGalleryView.access$getTAG$cp();
      localObject2 = new StringBuilder("storyId :");
      Object localObject3 = StoryGalleryView.B(this.sTX);
      if (localObject3 == null) {
        a.f.b.j.ebi();
      }
      localObject3 = ((StoryGalleryItemView)localObject3).getVideoItem();
      if (localObject3 == null) {
        a.f.b.j.ebi();
      }
      ab.i((String)localObject1, ((i)localObject3).cJA + " read times + 1  ,result:" + i);
      AppMethodBeat.o(110788);
      return;
    }
    AppMethodBeat.o(110788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.d
 * JD-Core Version:    0.7.0.1
 */