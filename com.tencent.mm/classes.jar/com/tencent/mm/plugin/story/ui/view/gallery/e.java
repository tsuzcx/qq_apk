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
import com.tencent.mm.ad.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "", "gallery", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "recyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "pageScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;)V", "hintLayout", "Landroid/view/View;", "hintShowing", "", "scrollListener", "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1;", "showHintRunnable", "Ljava/lang/Runnable;", "cancelHint", "", "checkCancel", "destroy", "Companion", "plugin-story_release"})
public final class e
{
  public static final e.a Bdf;
  private static final String TAG = "MicroMsg.GalleryScrollUpCheck";
  boolean BcY;
  private final c BcZ;
  private final Runnable Bda;
  private View Bdb;
  private final StoryGalleryView Bdc;
  private final GalleryRecyclerView Bdd;
  private final i Bde;
  
  static
  {
    AppMethodBeat.i(120374);
    Bdf = new e.a((byte)0);
    TAG = "MicroMsg.GalleryScrollUpCheck";
    AppMethodBeat.o(120374);
  }
  
  public e(StoryGalleryView paramStoryGalleryView, GalleryRecyclerView paramGalleryRecyclerView, i parami)
  {
    AppMethodBeat.i(120373);
    this.Bdc = paramStoryGalleryView;
    this.Bdd = paramGalleryRecyclerView;
    this.Bde = parami;
    this.BcZ = new c(this);
    paramStoryGalleryView = g.ajC();
    p.g(paramStoryGalleryView, "storage()");
    if (paramStoryGalleryView.ajl().getBoolean(al.a.IFp, false))
    {
      this.Bda = ((Runnable)e.1.Bdg);
      this.Bde.j((RecyclerView)this.Bdd);
      AppMethodBeat.o(120373);
      return;
    }
    this.Bda = ((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120368);
        int i = com.tencent.mm.cc.a.fromDPToPix(e.d(this.Bdh).getContext(), 112);
        View localView = LayoutInflater.from(e.d(this.Bdh).getContext()).inflate(2131495718, (ViewGroup)e.d(this.Bdh), false);
        e.a(this.Bdh, localView);
        Object localObject = localView.findViewById(2131305493);
        p.g(localObject, "layout.findViewById(R.id…tory_scroll_up_hint_icon)");
        ((ImageView)localObject).setImageDrawable(ao.k(e.d(this.Bdh).getContext(), 2131689951, -1));
        localObject = new RelativeLayout.LayoutParams(-1, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 1);
        e.d(this.Bdh).addView(localView, (ViewGroup.LayoutParams)localObject);
        p.g(localView, "layout");
        localView.setAlpha(0.0F);
        localView.animate().alpha(1.0F).start();
        e.b(this.Bdh).smoothScrollBy(0, i);
        e.h(this.Bdh);
        AppMethodBeat.o(120368);
      }
    });
    aq.o(this.Bda, 5000L);
    this.Bdd.a((RecyclerView.m)this.BcZ);
    AppMethodBeat.o(120373);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(120372);
    aq.aA(this.Bda);
    this.Bdc.removeView(this.Bdb);
    this.Bdd.b((RecyclerView.m)this.BcZ);
    AppMethodBeat.o(120372);
  }
  
  public final void emf()
  {
    AppMethodBeat.i(120371);
    c.g((d.g.a.a)new b(this));
    AppMethodBeat.o(120371);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-story_release"})
  public static final class c
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120370);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      if ((!e.g(this.Bdh)) && (paramInt2 > 0))
      {
        ad.i(e.access$getTAG$cp(), "onScrolled ".concat(String.valueOf(paramInt2)));
        paramRecyclerView = g.ajC();
        p.g(paramRecyclerView, "storage()");
        paramRecyclerView.ajl().set(al.a.IFp, Boolean.TRUE);
        this.Bdh.emf();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(120370);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(189783);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(189783);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.e
 * JD-Core Version:    0.7.0.1
 */