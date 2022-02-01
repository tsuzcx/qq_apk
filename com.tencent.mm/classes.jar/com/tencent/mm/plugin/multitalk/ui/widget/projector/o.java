package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.widget.FrameLayout;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "TOTAL_PAGES", "", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentPage", "isLastPage", "", "isLoading", "mCurrentHeight", "getMCurrentHeight", "()I", "setMCurrentHeight", "(I)V", "value", "mCurrentIndex", "getMCurrentIndex", "setMCurrentIndex", "mCurrentStr", "", "mCurrentWidth", "getMCurrentWidth", "setMCurrentWidth", "mItemDecoration", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutItemDecoration;", "mMaxCount", "getMMaxCount", "setMMaxCount", "mScreenShadowBg", "Landroid/view/View;", "mScreenThumbAdapter", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;", "getMScreenThumbAdapter", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;", "setMScreenThumbAdapter", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;)V", "mScreenThumbIndexRoot", "Landroid/widget/FrameLayout;", "mScreenThumbIndexUI", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI;", "mScreenThumbRootView", "mThumbnailLayoutManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutManager;", "screenThumbRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "thumbnailList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/graphics/Bitmap;", "thumbnailUiLayout", "getThumbnailUiLayout", "()Landroid/view/View;", "setThumbnailUiLayout", "(Landroid/view/View;)V", "applyClickEvent", "", "applyCurrentThumbnail", "pageIndex", "mCurrentPageWidth", "mCurrentPageHeight", "getLayout", "viewGroup", "hide", "loadNextPage", "onThumbnailLoad", "thumbnail", "show", "showIndexText", "str", "switchToDoodleIndex", "switchToPage", "Companion", "plugin-multitalk_release"})
public final class o
{
  static int zXR;
  public static final o.a zXS;
  Context context;
  boolean isLoading;
  boolean jUX;
  int mMaxCount;
  int rmJ;
  a zQD;
  String zXB;
  public CopyOnWriteArrayList<Bitmap> zXD;
  View zXE;
  ScreenThumbLayoutManager zXF;
  e zXG;
  b zXH;
  RecyclerView zXI;
  FrameLayout zXJ;
  n zXK;
  FrameLayout zXL;
  View zXM;
  int zXN;
  int zXO;
  int zXP;
  int zXQ;
  
  static
  {
    AppMethodBeat.i(240048);
    zXS = new o.a((byte)0);
    zXR = 10;
    AppMethodBeat.o(240048);
  }
  
  public o(Context paramContext, a parama)
  {
    AppMethodBeat.i(240047);
    this.context = paramContext;
    this.zQD = parama;
    this.zXD = new CopyOnWriteArrayList();
    this.rmJ = -1;
    this.mMaxCount = -1;
    this.zXQ = 3;
    AppMethodBeat.o(240047);
  }
  
  private void epF()
  {
    AppMethodBeat.i(240044);
    FrameLayout localFrameLayout = this.zXL;
    if (localFrameLayout != null)
    {
      localFrameLayout.removeAllViews();
      n localn = this.zXK;
      if (localn != null)
      {
        localn.c(this.context, localFrameLayout);
        AppMethodBeat.o(240044);
        return;
      }
      AppMethodBeat.o(240044);
      return;
    }
    AppMethodBeat.o(240044);
  }
  
  public final void RB(int paramInt)
  {
    AppMethodBeat.i(240046);
    if ((this.zXI != null) && (paramInt >= 0) && (this.mMaxCount >= 0))
    {
      Object localObject = this.zXK;
      if (localObject != null) {
        ((n)localObject).aGE(paramInt + 1 + '/' + this.mMaxCount);
      }
      localObject = this.zXH;
      if (localObject != null) {
        ((b)localObject).RB(paramInt);
      }
      localObject = this.zXF;
      if (localObject != null)
      {
        RecyclerView localRecyclerView = this.zXI;
        if (localRecyclerView == null) {
          p.hyc();
        }
        ((ScreenThumbLayoutManager)localObject).smoothScrollToPosition(localRecyclerView, new RecyclerView.s(), paramInt);
        AppMethodBeat.o(240046);
        return;
      }
    }
    AppMethodBeat.o(240046);
  }
  
  public final void aGE(String paramString)
  {
    AppMethodBeat.i(240042);
    p.h(paramString, "str");
    Object localObject = this.zXL;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    this.zXB = paramString;
    localObject = this.zXK;
    if (localObject != null)
    {
      ((n)localObject).aGE(paramString);
      AppMethodBeat.o(240042);
      return;
    }
    AppMethodBeat.o(240042);
  }
  
  public final void epE()
  {
    AppMethodBeat.i(240041);
    Bundle localBundle = new Bundle();
    localBundle.putInt("thumb_current_page", this.zXP);
    this.zQD.a(a.c.zVy, localBundle);
    AppMethodBeat.o(240041);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(240043);
    epF();
    if ((this.zQD.epf() == 90) || (this.zQD.epf() == 270))
    {
      localObject = this.zXI;
      if (localObject != null)
      {
        ((RecyclerView)localObject).setVisibility(4);
        AppMethodBeat.o(240043);
        return;
      }
      AppMethodBeat.o(240043);
      return;
    }
    Object localObject = this.zXI;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(4);
    }
    localObject = this.zXM;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(4);
      AppMethodBeat.o(240043);
      return;
    }
    AppMethodBeat.o(240043);
  }
  
  public final void show()
  {
    AppMethodBeat.i(240045);
    epF();
    Object localObject = this.zXK;
    if (localObject != null) {
      ((n)localObject).eoD();
    }
    localObject = this.zXL;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.zXJ;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.zXI;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(0);
    }
    localObject = this.zXM;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    RB(this.rmJ);
    AppMethodBeat.o(240045);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI$applyClickEvent$2", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener;", "getTotalPageCount", "", "isLastPage", "", "isLoading", "loadMoreItems", "", "plugin-multitalk_release"})
  public static final class b
    extends c
  {
    b(LinearLayoutManager paramLinearLayoutManager)
    {
      super();
    }
    
    public final void epH()
    {
      AppMethodBeat.i(240037);
      o.b(this.zXT);
      o localo = this.zXT;
      o.a(localo, o.c(localo) + 1);
      this.zXT.epE();
      AppMethodBeat.o(240037);
    }
    
    public final boolean epI()
    {
      AppMethodBeat.i(240038);
      boolean bool = o.d(this.zXT);
      AppMethodBeat.o(240038);
      return bool;
    }
    
    public final boolean isLoading()
    {
      AppMethodBeat.i(240039);
      boolean bool = o.a(this.zXT);
      AppMethodBeat.o(240039);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "tag", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.o
 * JD-Core Version:    0.7.0.1
 */