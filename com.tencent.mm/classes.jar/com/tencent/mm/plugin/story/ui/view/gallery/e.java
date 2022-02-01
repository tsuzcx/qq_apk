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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "", "gallery", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "recyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "pageScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;)V", "hintLayout", "Landroid/view/View;", "hintShowing", "", "scrollListener", "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1;", "showHintRunnable", "Ljava/lang/Runnable;", "cancelHint", "", "checkCancel", "destroy", "Companion", "plugin-story_release"})
public final class e
{
  public static final e.a BuD;
  private static final String TAG = "MicroMsg.GalleryScrollUpCheck";
  private final StoryGalleryView BuA;
  private final GalleryRecyclerView BuB;
  private final i BuC;
  boolean Buw;
  private final c Bux;
  private final Runnable Buy;
  private View Buz;
  
  static
  {
    AppMethodBeat.i(120374);
    BuD = new e.a((byte)0);
    TAG = "MicroMsg.GalleryScrollUpCheck";
    AppMethodBeat.o(120374);
  }
  
  public e(StoryGalleryView paramStoryGalleryView, GalleryRecyclerView paramGalleryRecyclerView, i parami)
  {
    AppMethodBeat.i(120373);
    this.BuA = paramStoryGalleryView;
    this.BuB = paramGalleryRecyclerView;
    this.BuC = parami;
    this.Bux = new c(this);
    paramStoryGalleryView = g.ajR();
    p.g(paramStoryGalleryView, "storage()");
    if (paramStoryGalleryView.ajA().getBoolean(am.a.IZP, false))
    {
      this.Buy = ((Runnable)e.1.BuE);
      this.BuC.j((RecyclerView)this.BuB);
      AppMethodBeat.o(120373);
      return;
    }
    this.Buy = ((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120368);
        int i = com.tencent.mm.cb.a.fromDPToPix(e.d(this.BuF).getContext(), 112);
        View localView = LayoutInflater.from(e.d(this.BuF).getContext()).inflate(2131495718, (ViewGroup)e.d(this.BuF), false);
        e.a(this.BuF, localView);
        Object localObject = localView.findViewById(2131305493);
        p.g(localObject, "layout.findViewById(R.id…tory_scroll_up_hint_icon)");
        ((ImageView)localObject).setImageDrawable(ao.k(e.d(this.BuF).getContext(), 2131689951, -1));
        localObject = new RelativeLayout.LayoutParams(-1, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 1);
        e.d(this.BuF).addView(localView, (ViewGroup.LayoutParams)localObject);
        p.g(localView, "layout");
        localView.setAlpha(0.0F);
        localView.animate().alpha(1.0F).start();
        e.b(this.BuF).smoothScrollBy(0, i);
        e.h(this.BuF);
        AppMethodBeat.o(120368);
      }
    });
    ar.o(this.Buy, 5000L);
    this.BuB.a((RecyclerView.m)this.Bux);
    AppMethodBeat.o(120373);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(120372);
    ar.ay(this.Buy);
    this.BuA.removeView(this.Buz);
    this.BuB.b((RecyclerView.m)this.Bux);
    AppMethodBeat.o(120372);
  }
  
  public final void epO()
  {
    AppMethodBeat.i(120371);
    c.h((d.g.a.a)new b(this));
    AppMethodBeat.o(120371);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-story_release"})
  public static final class c
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120370);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      if ((!e.g(this.BuF)) && (paramInt2 > 0))
      {
        ae.i(e.access$getTAG$cp(), "onScrolled ".concat(String.valueOf(paramInt2)));
        paramRecyclerView = g.ajR();
        p.g(paramRecyclerView, "storage()");
        paramRecyclerView.ajA().set(am.a.IZP, Boolean.TRUE);
        this.BuF.epO();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(120370);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(221753);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(221753);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.e
 * JD-Core Version:    0.7.0.1
 */