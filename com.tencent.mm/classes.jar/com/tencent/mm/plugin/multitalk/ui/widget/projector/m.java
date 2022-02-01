package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.ScreenThumbLayoutManager;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.c;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.e;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "TOTAL_PAGES", "", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentPage", "isLastPage", "", "isLoading", "mCurrentHeight", "getMCurrentHeight", "()I", "setMCurrentHeight", "(I)V", "value", "mCurrentIndex", "getMCurrentIndex", "setMCurrentIndex", "mCurrentStr", "", "mCurrentWidth", "getMCurrentWidth", "setMCurrentWidth", "mItemDecoration", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutItemDecoration;", "mMaxCount", "getMMaxCount", "setMMaxCount", "mScreenShadowBg", "Landroid/view/View;", "mScreenThumbAdapter", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;", "getMScreenThumbAdapter", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;", "setMScreenThumbAdapter", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;)V", "mScreenThumbIndexRoot", "Landroid/widget/FrameLayout;", "mScreenThumbIndexUI", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI;", "mScreenThumbRootView", "mThumbnailLayoutManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutManager;", "screenThumbRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "thumbnailList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/graphics/Bitmap;", "thumbnailUiLayout", "getThumbnailUiLayout", "()Landroid/view/View;", "setThumbnailUiLayout", "(Landroid/view/View;)V", "applyClickEvent", "", "applyCurrentThumbnail", "pageIndex", "mCurrentPageWidth", "mCurrentPageHeight", "getLayout", "viewGroup", "hide", "loadNextPage", "onThumbnailLoad", "thumbnail", "show", "showIndexText", "str", "switchToDoodleIndex", "switchToPage", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m.a Lze;
  static int Lzt;
  a Lsq;
  String Lzd;
  public CopyOnWriteArrayList<Bitmap> Lzf;
  View Lzg;
  ScreenThumbLayoutManager Lzh;
  e Lzi;
  b Lzj;
  RecyclerView Lzk;
  FrameLayout Lzl;
  l Lzm;
  FrameLayout Lzn;
  View Lzo;
  int Lzp;
  int Lzq;
  int Lzr;
  int Lzs;
  Context context;
  boolean isLoading;
  boolean pIS;
  int sfk;
  int xYG;
  
  static
  {
    AppMethodBeat.i(285705);
    Lze = new m.a((byte)0);
    Lzt = 10;
    AppMethodBeat.o(285705);
  }
  
  public m(Context paramContext, a parama)
  {
    AppMethodBeat.i(285633);
    this.context = paramContext;
    this.Lsq = parama;
    this.Lzf = new CopyOnWriteArrayList();
    this.xYG = -1;
    this.sfk = -1;
    this.Lzs = 3;
    AppMethodBeat.o(285633);
  }
  
  private void gis()
  {
    AppMethodBeat.i(285642);
    FrameLayout localFrameLayout = this.Lzn;
    if (localFrameLayout != null)
    {
      localFrameLayout.removeAllViews();
      l locall = this.Lzm;
      if (locall != null) {
        locall.f(this.context, localFrameLayout);
      }
    }
    AppMethodBeat.o(285642);
  }
  
  public final void aNJ(String paramString)
  {
    AppMethodBeat.i(285723);
    s.u(paramString, "str");
    Object localObject = this.Lzn;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    this.Lzd = paramString;
    localObject = this.Lzm;
    if (localObject != null) {
      ((l)localObject).aNJ(paramString);
    }
    AppMethodBeat.o(285723);
  }
  
  public final void acb(int paramInt)
  {
    AppMethodBeat.i(285756);
    if ((this.Lzk != null) && (paramInt >= 0) && (this.sfk >= 0))
    {
      Object localObject = this.Lzm;
      if (localObject != null) {
        ((l)localObject).aNJ(paramInt + 1 + '/' + this.sfk);
      }
      localObject = this.Lzj;
      if (localObject != null) {
        ((b)localObject).acb(paramInt);
      }
      localObject = this.Lzh;
      if (localObject != null)
      {
        RecyclerView localRecyclerView = this.Lzk;
        s.checkNotNull(localRecyclerView);
        ((ScreenThumbLayoutManager)localObject).smoothScrollToPosition(localRecyclerView, new RecyclerView.s(), paramInt);
      }
    }
    AppMethodBeat.o(285756);
  }
  
  public final void gir()
  {
    AppMethodBeat.i(285713);
    Bundle localBundle = new Bundle();
    localBundle.putInt("thumb_current_page", this.Lzr);
    this.Lsq.a(a.c.Lxk, localBundle);
    AppMethodBeat.o(285713);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(285734);
    gis();
    Object localObject;
    if ((this.Lsq.ghU() == 90) || (this.Lsq.ghU() == 270))
    {
      localObject = this.Lzk;
      if (localObject != null)
      {
        ((RecyclerView)localObject).setVisibility(4);
        AppMethodBeat.o(285734);
      }
    }
    else
    {
      localObject = this.Lzk;
      if (localObject != null) {
        ((RecyclerView)localObject).setVisibility(4);
      }
      localObject = this.Lzo;
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
    }
    AppMethodBeat.o(285734);
  }
  
  public final void show()
  {
    AppMethodBeat.i(285746);
    gis();
    Object localObject = this.Lzm;
    if (localObject != null) {
      ((l)localObject).exz();
    }
    localObject = this.Lzn;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.Lzl;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.Lzk;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(0);
    }
    localObject = this.Lzo;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    acb(this.xYG);
    AppMethodBeat.o(285746);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI$applyClickEvent$2", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener;", "getTotalPageCount", "", "isLastPage", "", "isLoading", "loadMoreItems", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends c
  {
    b(m paramm, ScreenThumbLayoutManager paramScreenThumbLayoutManager)
    {
      super();
      AppMethodBeat.i(285908);
      AppMethodBeat.o(285908);
    }
    
    public final void giu()
    {
      AppMethodBeat.i(285916);
      m.a(this.Lzu);
      m localm = this.Lzu;
      m.a(localm, m.b(localm) + 1);
      this.Lzu.gir();
      AppMethodBeat.o(285916);
    }
    
    public final boolean giv()
    {
      AppMethodBeat.i(285924);
      boolean bool = m.c(this.Lzu);
      AppMethodBeat.o(285924);
      return bool;
    }
    
    public final boolean isLoading()
    {
      AppMethodBeat.i(285931);
      boolean bool = m.d(this.Lzu);
      AppMethodBeat.o(285931);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "tag", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.m<View, Integer, ah>
  {
    c(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.m
 * JD-Core Version:    0.7.0.1
 */