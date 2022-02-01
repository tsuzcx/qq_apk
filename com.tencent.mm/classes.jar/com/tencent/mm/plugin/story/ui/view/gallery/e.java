package com.tencent.mm.plugin.story.ui.view.gallery;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "", "gallery", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "recyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "pageScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;)V", "hintLayout", "Landroid/view/View;", "hintShowing", "", "scrollListener", "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1;", "showHintRunnable", "Ljava/lang/Runnable;", "cancelHint", "", "checkCancel", "destroy", "Companion", "plugin-story_release"})
public final class e
{
  private static final String TAG = "MicroMsg.GalleryScrollUpCheck";
  public static final e.a zLE;
  private View zLA;
  private final StoryGalleryView zLB;
  private final GalleryRecyclerView zLC;
  private final i zLD;
  boolean zLx;
  private final c zLy;
  private final Runnable zLz;
  
  static
  {
    AppMethodBeat.i(120374);
    zLE = new e.a((byte)0);
    TAG = "MicroMsg.GalleryScrollUpCheck";
    AppMethodBeat.o(120374);
  }
  
  public e(StoryGalleryView paramStoryGalleryView, GalleryRecyclerView paramGalleryRecyclerView, i parami)
  {
    AppMethodBeat.i(120373);
    this.zLB = paramStoryGalleryView;
    this.zLC = paramGalleryRecyclerView;
    this.zLD = parami;
    this.zLy = new c(this);
    paramStoryGalleryView = g.agR();
    k.g(paramStoryGalleryView, "storage()");
    if (paramStoryGalleryView.agA().getBoolean(ah.a.GSK, false))
    {
      this.zLz = ((Runnable)e.1.zLF);
      this.zLD.j((RecyclerView)this.zLC);
      AppMethodBeat.o(120373);
      return;
    }
    this.zLz = ((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120368);
        int i = com.tencent.mm.cc.a.fromDPToPix(e.d(this.zLG).getContext(), 112);
        View localView = LayoutInflater.from(e.d(this.zLG).getContext()).inflate(2131495718, (ViewGroup)e.d(this.zLG), false);
        e.a(this.zLG, localView);
        Object localObject = localView.findViewById(2131305493);
        k.g(localObject, "layout.findViewById(R.id…tory_scroll_up_hint_icon)");
        ((ImageView)localObject).setImageDrawable(am.k(e.d(this.zLG).getContext(), 2131689951, -1));
        localObject = new RelativeLayout.LayoutParams(-1, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 1);
        e.d(this.zLG).addView(localView, (ViewGroup.LayoutParams)localObject);
        k.g(localView, "layout");
        localView.setAlpha(0.0F);
        localView.animate().alpha(1.0F).start();
        e.b(this.zLG).smoothScrollBy(0, i);
        e.h(this.zLG);
        AppMethodBeat.o(120368);
      }
    });
    ap.n(this.zLz, 5000L);
    this.zLC.a((RecyclerView.m)this.zLy);
    AppMethodBeat.o(120373);
  }
  
  public final void dZQ()
  {
    AppMethodBeat.i(120371);
    c.g((d.g.a.a)new b(this));
    AppMethodBeat.o(120371);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(120372);
    ap.aB(this.zLz);
    this.zLB.removeView(this.zLA);
    this.zLC.b((RecyclerView.m)this.zLy);
    AppMethodBeat.o(120372);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-story_release"})
  public static final class c
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120370);
      b localb = new b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      k.h(paramRecyclerView, "recyclerView");
      if ((!e.g(this.zLG)) && (paramInt2 > 0))
      {
        ac.i(e.access$getTAG$cp(), "onScrolled ".concat(String.valueOf(paramInt2)));
        paramRecyclerView = g.agR();
        k.g(paramRecyclerView, "storage()");
        paramRecyclerView.agA().set(ah.a.GSK, Boolean.TRUE);
        this.zLG.dZQ();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(120370);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(192930);
      b localb = new b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(192930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.e
 * JD-Core Version:    0.7.0.1
 */