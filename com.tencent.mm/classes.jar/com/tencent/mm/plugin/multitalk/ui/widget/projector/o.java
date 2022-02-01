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
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "TOTAL_PAGES", "", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentPage", "isLastPage", "", "isLoading", "mCurrentHeight", "getMCurrentHeight", "()I", "setMCurrentHeight", "(I)V", "value", "mCurrentIndex", "getMCurrentIndex", "setMCurrentIndex", "mCurrentStr", "", "mCurrentWidth", "getMCurrentWidth", "setMCurrentWidth", "mItemDecoration", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutItemDecoration;", "mMaxCount", "getMMaxCount", "setMMaxCount", "mScreenShadowBg", "Landroid/view/View;", "mScreenThumbAdapter", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;", "getMScreenThumbAdapter", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;", "setMScreenThumbAdapter", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;)V", "mScreenThumbIndexRoot", "Landroid/widget/FrameLayout;", "mScreenThumbIndexUI", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI;", "mScreenThumbRootView", "mThumbnailLayoutManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutManager;", "screenThumbRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "thumbnailList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/graphics/Bitmap;", "thumbnailUiLayout", "getThumbnailUiLayout", "()Landroid/view/View;", "setThumbnailUiLayout", "(Landroid/view/View;)V", "applyClickEvent", "", "applyCurrentThumbnail", "pageIndex", "mCurrentPageWidth", "mCurrentPageHeight", "getLayout", "viewGroup", "hide", "loadNextPage", "onThumbnailLoad", "thumbnail", "show", "showIndexText", "str", "switchToDoodleIndex", "switchToPage", "Companion", "plugin-multitalk_release"})
public final class o
{
  static int FDD;
  public static final o.a FDE;
  int FDA;
  int FDB;
  int FDC;
  String FDn;
  public CopyOnWriteArrayList<Bitmap> FDp;
  View FDq;
  ScreenThumbLayoutManager FDr;
  e FDs;
  b FDt;
  RecyclerView FDu;
  FrameLayout FDv;
  n FDw;
  FrameLayout FDx;
  View FDy;
  int FDz;
  a Fwg;
  Context context;
  boolean isLoading;
  int mMaxCount;
  boolean mMk;
  int uPV;
  
  static
  {
    AppMethodBeat.i(196498);
    FDE = new o.a((byte)0);
    FDD = 10;
    AppMethodBeat.o(196498);
  }
  
  public o(Context paramContext, a parama)
  {
    AppMethodBeat.i(196496);
    this.context = paramContext;
    this.Fwg = parama;
    this.FDp = new CopyOnWriteArrayList();
    this.uPV = -1;
    this.mMaxCount = -1;
    this.FDC = 3;
    AppMethodBeat.o(196496);
  }
  
  private void eZt()
  {
    AppMethodBeat.i(196491);
    FrameLayout localFrameLayout = this.FDx;
    if (localFrameLayout != null)
    {
      localFrameLayout.removeAllViews();
      n localn = this.FDw;
      if (localn != null)
      {
        localn.c(this.context, localFrameLayout);
        AppMethodBeat.o(196491);
        return;
      }
      AppMethodBeat.o(196491);
      return;
    }
    AppMethodBeat.o(196491);
  }
  
  public final void XR(int paramInt)
  {
    AppMethodBeat.i(196494);
    if ((this.FDu != null) && (paramInt >= 0) && (this.mMaxCount >= 0))
    {
      Object localObject = this.FDw;
      if (localObject != null) {
        ((n)localObject).aQS(paramInt + 1 + '/' + this.mMaxCount);
      }
      localObject = this.FDt;
      if (localObject != null) {
        ((b)localObject).XR(paramInt);
      }
      localObject = this.FDr;
      if (localObject != null)
      {
        RecyclerView localRecyclerView = this.FDu;
        if (localRecyclerView == null) {
          p.iCn();
        }
        ((ScreenThumbLayoutManager)localObject).smoothScrollToPosition(localRecyclerView, new RecyclerView.s(), paramInt);
        AppMethodBeat.o(196494);
        return;
      }
    }
    AppMethodBeat.o(196494);
  }
  
  public final void aQS(String paramString)
  {
    AppMethodBeat.i(196488);
    p.k(paramString, "str");
    Object localObject = this.FDx;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    this.FDn = paramString;
    localObject = this.FDw;
    if (localObject != null)
    {
      ((n)localObject).aQS(paramString);
      AppMethodBeat.o(196488);
      return;
    }
    AppMethodBeat.o(196488);
  }
  
  public final void eZs()
  {
    AppMethodBeat.i(196487);
    Bundle localBundle = new Bundle();
    localBundle.putInt("thumb_current_page", this.FDB);
    this.Fwg.a(a.c.FBi, localBundle);
    AppMethodBeat.o(196487);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(196490);
    eZt();
    if ((this.Fwg.eYV() == 90) || (this.Fwg.eYV() == 270))
    {
      localObject = this.FDu;
      if (localObject != null)
      {
        ((RecyclerView)localObject).setVisibility(4);
        AppMethodBeat.o(196490);
        return;
      }
      AppMethodBeat.o(196490);
      return;
    }
    Object localObject = this.FDu;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(4);
    }
    localObject = this.FDy;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(4);
      AppMethodBeat.o(196490);
      return;
    }
    AppMethodBeat.o(196490);
  }
  
  public final void show()
  {
    AppMethodBeat.i(196492);
    eZt();
    Object localObject = this.FDw;
    if (localObject != null) {
      ((n)localObject).dGn();
    }
    localObject = this.FDx;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.FDv;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.FDu;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(0);
    }
    localObject = this.FDy;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    XR(this.uPV);
    AppMethodBeat.o(196492);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI$applyClickEvent$2", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener;", "getTotalPageCount", "", "isLastPage", "", "isLoading", "loadMoreItems", "", "plugin-multitalk_release"})
  public static final class b
    extends c
  {
    b(LinearLayoutManager paramLinearLayoutManager)
    {
      super();
    }
    
    public final void eZv()
    {
      AppMethodBeat.i(199729);
      o.b(this.FDF);
      o localo = this.FDF;
      o.a(localo, o.c(localo) + 1);
      this.FDF.eZs();
      AppMethodBeat.o(199729);
    }
    
    public final boolean eZw()
    {
      AppMethodBeat.i(199731);
      boolean bool = o.d(this.FDF);
      AppMethodBeat.o(199731);
      return bool;
    }
    
    public final boolean isLoading()
    {
      AppMethodBeat.i(199734);
      boolean bool = o.a(this.FDF);
      AppMethodBeat.o(199734);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "tag", "", "invoke"})
  static final class c
    extends q
    implements m<View, Integer, x>
  {
    c(o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.o
 * JD-Core Version:    0.7.0.1
 */