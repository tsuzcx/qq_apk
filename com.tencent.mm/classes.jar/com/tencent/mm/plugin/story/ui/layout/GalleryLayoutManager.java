package com.tencent.mm.plugin.story.ui.layout;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "forceUpdateOnNextLayout", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "onItemSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function2;)V", "scrollCallback", "", "offset", "getScrollCallback", "setScrollCallback", "scrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "()I", "canScrollHorizontally", "canScrollVertically", "findSelectedChildIndex", "onItemsAdded", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "positionStart", "itemCount", "onItemsChanged", "onItemsRemoved", "onItemsUpdated", "onLayoutCompleted", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "scrollToPosition", "scrollVerticallyBy", "dy", "updateScroll", "updateSelectedChild", "force", "Companion", "plugin-story_release"})
public final class GalleryLayoutManager
  extends LinearLayoutManager
{
  private static final String TAG = "MicroMsg.GalleryLayoutManager";
  public static final a zGc;
  public boolean fUR;
  public int ta;
  private int tp;
  private boolean zFZ;
  public m<? super Integer, ? super View, y> zGa;
  public m<? super Integer, ? super Float, y> zGb;
  
  static
  {
    AppMethodBeat.i(119935);
    zGc = new a((byte)0);
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
    super(paramInt);
    AppMethodBeat.i(119932);
    this.ta = -1;
    this.fUR = true;
    AppMethodBeat.o(119932);
  }
  
  public GalleryLayoutManager(Context paramContext, int paramInt, byte paramByte)
  {
    this(paramContext, paramInt);
    AppMethodBeat.i(119933);
    AppMethodBeat.o(119933);
  }
  
  private final int dZz()
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
      if (super.jM())
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
            k.fOy();
          }
          k.g(localView, "getChildAt(i)!!");
          n = localView.getLeft();
          localView = getChildAt(j);
          if (localView == null) {
            k.fOy();
          }
          k.g(localView, "getChildAt(i)!!");
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
          k.fOy();
        }
        k.g(localView, "getChildAt(i)!!");
        n = localView.getTop();
        localView = getChildAt(j);
        if (localView == null) {
          k.fOy();
        }
        k.g(localView, "getChildAt(i)!!");
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
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(119923);
    k.h(paramo, "recycler");
    k.h(paramt, "state");
    int i = super.a(paramInt, paramo, paramt);
    if (paramInt + 1 > i) {}
    while ((-1 < i) || (this.tp != 1))
    {
      AppMethodBeat.o(119923);
      return i;
    }
    paramo = getChildAt(0);
    if (paramo != null) {}
    for (paramo = paramo.getParent();; paramo = null)
    {
      paramt = paramo;
      if (!(paramo instanceof RecyclerView)) {
        paramt = null;
      }
      paramo = (RecyclerView)paramt;
      ac.i(TAG, "horizontal Drag to end, " + paramInt + ' ' + i + ", " + paramo);
      if (paramo == null) {
        break;
      }
      paramo.kt();
      break;
    }
  }
  
  public final void a(RecyclerView.t paramt)
  {
    AppMethodBeat.i(119921);
    ac.i(TAG, "LogStory: onLayoutCompleted");
    super.a(paramt);
    rQ(this.zFZ);
    this.zFZ = false;
    AppMethodBeat.o(119921);
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(119927);
    k.h(paramRecyclerView, "recyclerView");
    ac.i(TAG, "LogStory: onItemsChanged");
    this.zFZ = true;
    AppMethodBeat.o(119927);
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(119924);
    k.h(paramo, "recycler");
    k.h(paramt, "state");
    int i = super.b(paramInt, paramo, paramt);
    ac.i(TAG, "LogStory: vertical " + paramInt + ' ' + i);
    float f;
    if (paramInt + 1 > i) {
      if (getChildCount() != 0)
      {
        if (getChildCount() != 1) {
          break label238;
        }
        paramo = getChildAt(0);
        if (paramo == null) {
          k.fOy();
        }
        paramInt = bB(paramo);
        f = 0.0F;
      }
    }
    for (;;)
    {
      paramo = this.zGb;
      if (paramo != null) {
        paramo.n(Integer.valueOf(paramInt), Float.valueOf(f));
      }
      AppMethodBeat.o(119924);
      return i;
      if ((-1 < i) || (this.tp != 1)) {
        break;
      }
      paramo = getChildAt(0);
      if (paramo != null) {}
      for (paramo = paramo.getParent();; paramo = null)
      {
        paramt = paramo;
        if (!(paramo instanceof RecyclerView)) {
          paramt = null;
        }
        paramo = (RecyclerView)paramt;
        ac.i(TAG, "vertical Drag to end, " + paramInt + ' ' + i + ", " + paramo);
        if (paramo == null) {
          break;
        }
        paramo.kt();
        break;
      }
      label238:
      paramo = getChildAt(0);
      if (paramo == null) {
        k.fOy();
      }
      k.g(paramo, "getChildAt(0)!!");
      paramInt = bB(paramo);
      int j;
      int k;
      if (jN())
      {
        j = bH(paramo);
        k = bF(paramo);
        f = -j / k;
      }
      else
      {
        j = bG(paramo);
        k = bE(paramo);
        f = -j / k;
      }
    }
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119928);
    k.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView, paramInt1, paramInt2);
    if ((this.ta >= paramInt1) && (this.ta < paramInt1 + paramInt2)) {
      this.zFZ = true;
    }
    AppMethodBeat.o(119928);
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(119931);
    ac.i(TAG, "LogStory: scrollToPosition " + paramInt + ' ' + bs.eWi());
    super.ca(paramInt);
    m localm = this.zGb;
    if (localm != null)
    {
      localm.n(Integer.valueOf(paramInt), Float.valueOf(0.0F));
      AppMethodBeat.o(119931);
      return;
    }
    AppMethodBeat.o(119931);
  }
  
  public final void cp(int paramInt)
  {
    AppMethodBeat.i(119922);
    ac.i(TAG, "LogStory: onScrollStateChanged ".concat(String.valueOf(paramInt)));
    super.cp(paramInt);
    this.tp = paramInt;
    if (this.tp == 0) {
      rQ(false);
    }
    AppMethodBeat.o(119922);
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119929);
    k.h(paramRecyclerView, "recyclerView");
    ac.i(TAG, "LogStory: onItemsRemoved " + paramInt1 + ", " + paramInt2);
    super.d(paramRecyclerView, paramInt1, paramInt2);
    if ((this.ta >= paramInt1) && (this.ta < paramInt1 + paramInt2)) {
      this.zFZ = true;
    }
    AppMethodBeat.o(119929);
  }
  
  public final void g(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119930);
    k.h(paramRecyclerView, "recyclerView");
    ac.i(TAG, "LogStory: onItemsUpdated " + paramInt1 + ", " + paramInt2);
    super.g(paramRecyclerView, paramInt1, paramInt2);
    if ((this.ta >= paramInt1) && (this.ta < paramInt1 + paramInt2)) {
      this.zFZ = true;
    }
    AppMethodBeat.o(119930);
  }
  
  public final boolean jM()
  {
    AppMethodBeat.i(119919);
    if ((this.fUR) && (super.jM()))
    {
      AppMethodBeat.o(119919);
      return true;
    }
    AppMethodBeat.o(119919);
    return false;
  }
  
  public final boolean jN()
  {
    AppMethodBeat.i(119920);
    if ((this.fUR) && (getItemCount() > 1) && (super.jN()))
    {
      AppMethodBeat.o(119920);
      return true;
    }
    AppMethodBeat.o(119920);
    return false;
  }
  
  public final void rQ(boolean paramBoolean)
  {
    AppMethodBeat.i(119925);
    int i = dZz();
    if (i >= 0)
    {
      View localView = getChildAt(i);
      if (localView == null) {
        k.fOy();
      }
      k.g(localView, "getChildAt(selectedChildIndex)!!");
      i = bB(localView);
      if ((i != this.ta) || (paramBoolean))
      {
        this.ta = i;
        m localm = this.zGa;
        if (localm != null)
        {
          localm.n(Integer.valueOf(this.ta), localView);
          AppMethodBeat.o(119925);
          return;
        }
      }
    }
    AppMethodBeat.o(119925);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.layout.GalleryLayoutManager
 * JD-Core Version:    0.7.0.1
 */