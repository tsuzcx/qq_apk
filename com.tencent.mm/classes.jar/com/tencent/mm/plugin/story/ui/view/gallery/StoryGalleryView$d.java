package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class StoryGalleryView$d
  implements Runnable
{
  StoryGalleryView$d(StoryGalleryView paramStoryGalleryView) {}
  
  public final void run()
  {
    AppMethodBeat.i(120438);
    Object localObject1 = StoryGalleryView.w(this.FGW);
    if ((localObject1 != null) && (((StoryGalleryItemView)localObject1).getVideoItem() != null))
    {
      localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject1 = j.b.foc();
      Object localObject2 = StoryGalleryView.w(this.FGW);
      if (localObject2 == null) {
        p.hyc();
      }
      localObject2 = ((StoryGalleryItemView)localObject2).getVideoItem();
      if (localObject2 == null) {
        p.hyc();
      }
      int i = k.b((k)localObject1, ((com.tencent.mm.plugin.story.f.d.j)localObject2).edx);
      localObject1 = StoryGalleryView.FGV;
      localObject1 = StoryGalleryView.access$getTAG$cp();
      localObject2 = new StringBuilder("storyId :");
      Object localObject3 = StoryGalleryView.w(this.FGW);
      if (localObject3 == null) {
        p.hyc();
      }
      localObject3 = ((StoryGalleryItemView)localObject3).getVideoItem();
      if (localObject3 == null) {
        p.hyc();
      }
      Log.i((String)localObject1, ((com.tencent.mm.plugin.story.f.d.j)localObject3).edx + " read times + 1  ,result:" + i);
      AppMethodBeat.o(120438);
      return;
    }
    AppMethodBeat.o(120438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.d
 * JD-Core Version:    0.7.0.1
 */