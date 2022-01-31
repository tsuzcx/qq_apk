package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-story_release"})
public final class g$c
  extends RecyclerView.m
{
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110741);
    j.q(paramRecyclerView, "recyclerView");
    if ((!g.g(this.sSA)) && (paramInt2 > 0))
    {
      ab.i(g.access$getTAG$cp(), "onScrolled ".concat(String.valueOf(paramInt2)));
      paramRecyclerView = com.tencent.mm.kernel.g.RL();
      j.p(paramRecyclerView, "storage()");
      paramRecyclerView.Ru().set(ac.a.yLv, Boolean.TRUE);
      this.sSA.cFZ();
    }
    AppMethodBeat.o(110741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.g.c
 * JD-Core Version:    0.7.0.1
 */