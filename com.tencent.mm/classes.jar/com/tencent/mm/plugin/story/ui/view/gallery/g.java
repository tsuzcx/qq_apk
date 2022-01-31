package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.a.a;
import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "", "gallery", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "recyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "pageScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;)V", "hintLayout", "Landroid/view/View;", "hintShowing", "", "scrollListener", "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1;", "showHintRunnable", "Ljava/lang/Runnable;", "cancelHint", "", "checkCancel", "destroy", "Companion", "plugin-story_release"})
public final class g
{
  private static final String TAG = "MicroMsg.GalleryScrollUpCheck";
  public static final g.a sSy;
  boolean sSr;
  private final g.c sSs;
  private final Runnable sSt;
  private View sSu;
  private final StoryGalleryView sSv;
  private final GalleryRecyclerView sSw;
  private final k sSx;
  
  static
  {
    AppMethodBeat.i(110745);
    sSy = new g.a((byte)0);
    TAG = "MicroMsg.GalleryScrollUpCheck";
    AppMethodBeat.o(110745);
  }
  
  public g(StoryGalleryView paramStoryGalleryView, GalleryRecyclerView paramGalleryRecyclerView, k paramk)
  {
    AppMethodBeat.i(110744);
    this.sSv = paramStoryGalleryView;
    this.sSw = paramGalleryRecyclerView;
    this.sSx = paramk;
    this.sSs = new g.c(this);
    paramStoryGalleryView = com.tencent.mm.kernel.g.RL();
    j.p(paramStoryGalleryView, "storage()");
    if (paramStoryGalleryView.Ru().getBoolean(ac.a.yLv, false))
    {
      this.sSt = ((Runnable)g.1.sSz);
      this.sSx.i((RecyclerView)this.sSw);
      AppMethodBeat.o(110744);
      return;
    }
    this.sSt = ((Runnable)new g.2(this));
    al.p(this.sSt, 5000L);
    this.sSw.a((RecyclerView.m)this.sSs);
    AppMethodBeat.o(110744);
  }
  
  public final void cFZ()
  {
    AppMethodBeat.i(110742);
    b.b((a)new g.b(this));
    AppMethodBeat.o(110742);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(110743);
    al.ae(this.sSt);
    this.sSv.removeView(this.sSu);
    this.sSw.b((RecyclerView.m)this.sSs);
    AppMethodBeat.o(110743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.g
 * JD-Core Version:    0.7.0.1
 */