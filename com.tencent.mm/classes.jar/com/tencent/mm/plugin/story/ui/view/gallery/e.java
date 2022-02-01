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
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "", "gallery", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "recyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "pageScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;)V", "hintLayout", "Landroid/view/View;", "hintShowing", "", "scrollListener", "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1;", "showHintRunnable", "Ljava/lang/Runnable;", "cancelHint", "", "checkCancel", "destroy", "Companion", "plugin-story_release"})
public final class e
{
  private static final String TAG = "MicroMsg.GalleryScrollUpCheck";
  public static final a yyp;
  boolean yyi;
  private final c yyj;
  private final Runnable yyk;
  private View yyl;
  private final StoryGalleryView yym;
  private final GalleryRecyclerView yyn;
  private final i yyo;
  
  static
  {
    AppMethodBeat.i(120374);
    yyp = new a((byte)0);
    TAG = "MicroMsg.GalleryScrollUpCheck";
    AppMethodBeat.o(120374);
  }
  
  public e(StoryGalleryView paramStoryGalleryView, GalleryRecyclerView paramGalleryRecyclerView, i parami)
  {
    AppMethodBeat.i(120373);
    this.yym = paramStoryGalleryView;
    this.yyn = paramGalleryRecyclerView;
    this.yyo = parami;
    this.yyj = new c(this);
    paramStoryGalleryView = g.afB();
    k.g(paramStoryGalleryView, "storage()");
    if (paramStoryGalleryView.afk().getBoolean(ae.a.FuQ, false))
    {
      this.yyk = ((Runnable)e.1.yyq);
      this.yyo.j((RecyclerView)this.yyn);
      AppMethodBeat.o(120373);
      return;
    }
    this.yyk = ((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120368);
        int i = com.tencent.mm.cd.a.fromDPToPix(e.d(this.yyr).getContext(), 112);
        View localView = LayoutInflater.from(e.d(this.yyr).getContext()).inflate(2131495718, (ViewGroup)e.d(this.yyr), false);
        e.a(this.yyr, localView);
        Object localObject = localView.findViewById(2131305493);
        k.g(localObject, "layout.findViewById(R.id…tory_scroll_up_hint_icon)");
        ((ImageView)localObject).setImageDrawable(am.i(e.d(this.yyr).getContext(), 2131689951, -1));
        localObject = new RelativeLayout.LayoutParams(-1, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 1);
        e.d(this.yyr).addView(localView, (ViewGroup.LayoutParams)localObject);
        k.g(localView, "layout");
        localView.setAlpha(0.0F);
        localView.animate().alpha(1.0F).start();
        e.b(this.yyr).smoothScrollBy(0, i);
        e.h(this.yyr);
        AppMethodBeat.o(120368);
      }
    });
    aq.n(this.yyk, 5000L);
    this.yyn.a((RecyclerView.m)this.yyj);
    AppMethodBeat.o(120373);
  }
  
  public final void dLq()
  {
    AppMethodBeat.i(120371);
    c.g((d.g.a.a)new b(this));
    AppMethodBeat.o(120371);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(120372);
    aq.az(this.yyk);
    this.yym.removeView(this.yyl);
    this.yyn.b((RecyclerView.m)this.yyj);
    AppMethodBeat.o(120372);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-story_release"})
  public static final class c
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120370);
      b localb = new b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      k.h(paramRecyclerView, "recyclerView");
      if ((!e.g(this.yyr)) && (paramInt2 > 0))
      {
        ad.i(e.access$getTAG$cp(), "onScrolled ".concat(String.valueOf(paramInt2)));
        paramRecyclerView = g.afB();
        k.g(paramRecyclerView, "storage()");
        paramRecyclerView.afk().set(ae.a.FuQ, Boolean.TRUE);
        this.yyr.dLq();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(120370);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(204835);
      b localb = new b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(204835);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.e
 * JD-Core Version:    0.7.0.1
 */