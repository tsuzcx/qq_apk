package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryGalleryView$m$a
  implements Runnable
{
  StoryGalleryView$m$a(StoryGalleryView.m paramm, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(110813);
    Object localObject = g.RL();
    j.p(localObject, "MMKernel.storage()");
    boolean bool = ((e)localObject).Ru().getBoolean(ac.a.yLF, true);
    localObject = StoryGalleryView.sTW;
    ab.i(StoryGalleryView.access$getTAG$cp(), "onPostStart " + this.szU + " and ret " + bool);
    if (bool)
    {
      this.sUe.sTX.setFirstPost(true);
      this.sUe.sTX.K(true, false);
    }
    AppMethodBeat.o(110813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.m.a
 * JD-Core Version:    0.7.0.1
 */