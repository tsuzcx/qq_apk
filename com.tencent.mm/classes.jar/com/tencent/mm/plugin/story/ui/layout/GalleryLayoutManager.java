package com.tencent.mm.plugin.story.ui.layout;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "forceUpdateOnNextLayout", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "onItemSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function2;)V", "scrollCallback", "", "offset", "getScrollCallback", "setScrollCallback", "scrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "()I", "canScrollHorizontally", "canScrollVertically", "findSelectedChildIndex", "onItemsAdded", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "positionStart", "itemCount", "onItemsChanged", "onItemsRemoved", "onItemsUpdated", "onLayoutCompleted", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "scrollToPosition", "scrollVerticallyBy", "dy", "updateScroll", "updateSelectedChild", "force", "Companion", "plugin-story_release"})
public final class GalleryLayoutManager
  extends LinearLayoutManager
{
  public static final a FzN;
  private static final String TAG = "MicroMsg.GalleryLayoutManager";
  public m<? super Integer, ? super Float, x> FzM;
  public boolean hbX;
  private boolean uyI;
  public m<? super Integer, ? super View, x> uyJ;
  public int va;
  private int vp;
  
  static
  {
    AppMethodBeat.i(119935);
    FzN = new a((byte)0);
    TAG = "MicroMsg.GalleryLayoutManager";
    AppMethodBeat.o(119935);
  }
  
  public GalleryLayoutManager(Context paramContext)
  {
    this(paramContext, 1, (byte)0);
    AppMethodBeat.i(119934);
    AppMethodBeat.o(119934);
  }
  
  private GalleryLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt, false);
    AppMethodBeat.i(119932);
    this.va = -1;
    this.hbX = true;
    AppMethodBeat.o(119932);
  }
  
  public GalleryLayoutManager(Context paramContext, int paramInt, byte paramByte)
  {
    this(paramContext, paramInt);
    AppMethodBeat.i(119933);
    AppMethodBeat.o(119933);
  }
  
  private final int div()
  {
    int j = 0;
    int i = 0;
    int k = 0;
    AppMethodBeat.i(119926);
    if (getChildCount() == 1) {
      i = k;
    }
    for (;;)
    {
      AppMethodBeat.o(119926);
      return i;
      View localView;
      int n;
      if (super.canScrollHorizontally())
      {
        k = getWidth() / 2;
        m = getChildCount();
        for (;;)
        {
          if (j >= m) {
            break label223;
          }
          localView = getChildAt(j);
          if (localView == null) {
            p.hyc();
          }
          p.g(localView, "getChildAt(i)!!");
          n = localView.getLeft();
          localView = getChildAt(j);
          if (localView == null) {
            p.hyc();
          }
          p.g(localView, "getChildAt(i)!!");
          i = j;
          if ((n + localView.getRight()) / 2 == k) {
            break;
          }
          j += 1;
        }
      }
      k = getHeight() / 2;
      int m = getChildCount();
      j = i;
      for (;;)
      {
        if (j >= m) {
          break label223;
        }
        localView = getChildAt(j);
        if (localView == null) {
          p.hyc();
        }
        p.g(localView, "getChildAt(i)!!");
        n = localView.getTop();
        localView = getChildAt(j);
        if (localView == null) {
          p.hyc();
        }
        p.g(localView, "getChildAt(i)!!");
        i = j;
        if ((n + localView.getBottom()) / 2 == k) {
          break;
        }
        j += 1;
      }
      label223:
      i = -1;
    }
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(119919);
    if ((this.hbX) && (super.canScrollHorizontally()))
    {
      AppMethodBeat.o(119919);
      return true;
    }
    AppMethodBeat.o(119919);
    return false;
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(119920);
    if ((this.hbX) && (getItemCount() > 1) && (super.canScrollVertically()))
    {
      AppMethodBeat.o(119920);
      return true;
    }
    AppMethodBeat.o(119920);
    return false;
  }
  
  public final void nz(boolean paramBoolean)
  {
    AppMethodBeat.i(119925);
    int i = div();
    if (i >= 0)
    {
      View localView = getChildAt(i);
      if (localView == null) {
        p.hyc();
      }
      p.g(localView, "getChildAt(selectedChildIndex)!!");
      i = getPosition(localView);
      if ((i != this.va) || (paramBoolean))
      {
        this.va = i;
        m localm = this.uyJ;
        if (localm != null)
        {
          localm.invoke(Integer.valueOf(this.va), localView);
          AppMethodBeat.o(119925);
          return;
        }
      }
    }
    AppMethodBeat.o(119925);
  }
  
  public final void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119928);
    p.h(paramRecyclerView, "recyclerView");
    super.onItemsAdded(paramRecyclerView, paramInt1, paramInt2);
    if ((this.va >= paramInt1) && (this.va < paramInt1 + paramInt2)) {
      this.uyI = true;
    }
    AppMethodBeat.o(119928);
  }
  
  public final void onItemsChanged(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(119927);
    p.h(paramRecyclerView, "recyclerView");
    Log.i(TAG, "LogStory: onItemsChanged");
    this.uyI = true;
    AppMethodBeat.o(119927);
  }
  
  public final void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119929);
    p.h(paramRecyclerView, "recyclerView");
    Log.i(TAG, "LogStory: onItemsRemoved " + paramInt1 + ", " + paramInt2);
    super.onItemsRemoved(paramRecyclerView, paramInt1, paramInt2);
    if ((this.va >= paramInt1) && (this.va < paramInt1 + paramInt2)) {
      this.uyI = true;
    }
    AppMethodBeat.o(119929);
  }
  
  public final void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119930);
    p.h(paramRecyclerView, "recyclerView");
    Log.i(TAG, "LogStory: onItemsUpdated " + paramInt1 + ", " + paramInt2);
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    if ((this.va >= paramInt1) && (this.va < paramInt1 + paramInt2)) {
      this.uyI = true;
    }
    AppMethodBeat.o(119930);
  }
  
  public final void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(119921);
    Log.i(TAG, "LogStory: onLayoutCompleted");
    super.onLayoutCompleted(params);
    nz(this.uyI);
    this.uyI = false;
    AppMethodBeat.o(119921);
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(119922);
    Log.i(TAG, "LogStory: onScrollStateChanged ".concat(String.valueOf(paramInt)));
    super.onScrollStateChanged(paramInt);
    this.vp = paramInt;
    if (this.vp == 0) {
      nz(false);
    }
    AppMethodBeat.o(119922);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(119923);
    p.h(paramn, "recycler");
    p.h(params, "state");
    int i = super.scrollHorizontallyBy(paramInt, paramn, params);
    if (paramInt + 1 > i) {}
    while ((-1 < i) || (this.vp != 1))
    {
      AppMethodBeat.o(119923);
      return i;
    }
    paramn = getChildAt(0);
    if (paramn != null) {}
    for (paramn = paramn.getParent();; paramn = null)
    {
      params = paramn;
      if (!(paramn instanceof RecyclerView)) {
        params = null;
      }
      paramn = (RecyclerView)params;
      Log.i(TAG, "horizontal Drag to end, " + paramInt + ' ' + i + ", " + paramn);
      if (paramn == null) {
        break;
      }
      paramn.kQ();
      break;
    }
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(119931);
    Log.i(TAG, "LogStory: scrollToPosition " + paramInt + ' ' + Util.getStack());
    super.scrollToPosition(paramInt);
    m localm = this.FzM;
    if (localm != null)
    {
      localm.invoke(Integer.valueOf(paramInt), Float.valueOf(0.0F));
      AppMethodBeat.o(119931);
      return;
    }
    AppMethodBeat.o(119931);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(119924);
    p.h(paramn, "recycler");
    p.h(params, "state");
    int i = super.scrollVerticallyBy(paramInt, paramn, params);
    Log.i(TAG, "LogStory: vertical " + paramInt + ' ' + i);
    float f;
    if (paramInt + 1 > i) {
      if (getChildCount() != 0)
      {
        if (getChildCount() != 1) {
          break label244;
        }
        paramn = getChildAt(0);
        if (paramn == null) {
          p.hyc();
        }
        paramInt = getPosition(paramn);
        f = 0.0F;
      }
    }
    for (;;)
    {
      paramn = this.FzM;
      if (paramn != null) {
        paramn.invoke(Integer.valueOf(paramInt), Float.valueOf(f));
      }
      AppMethodBeat.o(119924);
      return i;
      if ((-1 < i) || (this.vp != 1)) {
        break;
      }
      paramn = getChildAt(0);
      if (paramn != null) {}
      for (paramn = paramn.getParent();; paramn = null)
      {
        params = paramn;
        if (!(paramn instanceof RecyclerView)) {
          params = null;
        }
        paramn = (RecyclerView)params;
        Log.i(TAG, "vertical Drag to end, " + paramInt + ' ' + i + ", " + paramn);
        if (paramn == null) {
          break;
        }
        paramn.kQ();
        break;
      }
      label244:
      paramn = getChildAt(0);
      if (paramn == null) {
        p.hyc();
      }
      p.g(paramn, "getChildAt(0)!!");
      paramInt = getPosition(paramn);
      int j;
      int k;
      if (canScrollVertically())
      {
        j = getDecoratedTop(paramn);
        k = getDecoratedMeasuredHeight(paramn);
        f = -j / k;
      }
      else
      {
        j = getDecoratedLeft(paramn);
        k = getDecoratedMeasuredWidth(paramn);
        f = -j / k;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.layout.GalleryLayoutManager
 * JD-Core Version:    0.7.0.1
 */