package com.tencent.mm.plugin.story.ui.b;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "forceUpdateOnNextLayout", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "onItemSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function2;)V", "scrollCallback", "", "offset", "getScrollCallback", "setScrollCallback", "scrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "canScrollHorizontally", "canScrollVertically", "findSelectedChildIndex", "onItemsAdded", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "positionStart", "itemCount", "onItemsChanged", "onItemsRemoved", "onItemsUpdated", "onLayoutCompleted", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "scrollToPosition", "scrollVerticallyBy", "dy", "updateScroll", "updateSelectedChild", "force", "Companion", "plugin-story_release"})
public final class b
  extends LinearLayoutManager
{
  private static final String TAG = "MicroMsg.GalleryLayoutManager";
  public static final b.a sKf;
  private int lCk;
  private boolean lCl;
  public m<? super Integer, ? super View, y> lCm;
  public int lxQ;
  public m<? super Integer, ? super Float, y> sKd;
  public boolean sKe;
  
  static
  {
    AppMethodBeat.i(110229);
    sKf = new b.a((byte)0);
    TAG = "MicroMsg.GalleryLayoutManager";
    AppMethodBeat.o(110229);
  }
  
  public b(Context paramContext)
  {
    this(paramContext, 1, (byte)0);
    AppMethodBeat.i(110228);
    AppMethodBeat.o(110228);
  }
  
  private b(Context paramContext, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(110226);
    this.lxQ = -1;
    this.sKe = true;
    AppMethodBeat.o(110226);
  }
  
  public b(Context paramContext, int paramInt, byte paramByte)
  {
    this(paramContext, paramInt);
    AppMethodBeat.i(110227);
    AppMethodBeat.o(110227);
  }
  
  private final int bpp()
  {
    int j = 0;
    int i = 0;
    int k = 0;
    AppMethodBeat.i(110220);
    if (getChildCount() == 1) {
      i = k;
    }
    for (;;)
    {
      AppMethodBeat.o(110220);
      return i;
      View localView;
      int n;
      if (ij())
      {
        k = getWidth() / 2;
        m = getChildCount();
        for (;;)
        {
          if (j >= m) {
            break label191;
          }
          localView = getChildAt(j);
          j.p(localView, "getChildAt(i)");
          n = localView.getLeft();
          localView = getChildAt(j);
          j.p(localView, "getChildAt(i)");
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
          break label191;
        }
        localView = getChildAt(j);
        j.p(localView, "getChildAt(i)");
        n = localView.getTop();
        localView = getChildAt(j);
        j.p(localView, "getChildAt(i)");
        i = j;
        if ((n + localView.getBottom()) / 2 == k) {
          break;
        }
        j += 1;
      }
      label191:
      i = -1;
    }
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(110217);
    j.q(paramo, "recycler");
    j.q(params, "state");
    int i = super.a(paramInt, paramo, params);
    if (paramInt + 1 > i) {}
    while ((-1 < i) || (this.lCk != 1))
    {
      AppMethodBeat.o(110217);
      return i;
    }
    paramo = getChildAt(0);
    if (paramo != null) {}
    for (paramo = paramo.getParent();; paramo = null)
    {
      params = paramo;
      if (!(paramo instanceof RecyclerView)) {
        params = null;
      }
      paramo = (RecyclerView)params;
      ab.i(TAG, "horizontal Drag to end, " + paramInt + ' ' + i + ", " + paramo);
      if (paramo == null) {
        break;
      }
      paramo.iQ();
      break;
    }
  }
  
  public final void a(RecyclerView.s params)
  {
    AppMethodBeat.i(110215);
    ab.i(TAG, "LogStory: onLayoutCompleted");
    super.a(params);
    hb(this.lCl);
    this.lCl = false;
    AppMethodBeat.o(110215);
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(110221);
    j.q(paramRecyclerView, "recyclerView");
    ab.i(TAG, "LogStory: onItemsChanged");
    this.lCl = true;
    AppMethodBeat.o(110221);
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(110218);
    j.q(paramo, "recycler");
    j.q(params, "state");
    int i = super.b(paramInt, paramo, params);
    ab.i(TAG, "LogStory: vertical " + paramInt + ' ' + i);
    float f;
    if (paramInt + 1 > i) {
      if (getChildCount() != 0)
      {
        if (getChildCount() != 1) {
          break label229;
        }
        paramInt = bv(getChildAt(0));
        f = 0.0F;
      }
    }
    for (;;)
    {
      paramo = this.sKd;
      if (paramo != null) {
        paramo.h(Integer.valueOf(paramInt), Float.valueOf(f));
      }
      AppMethodBeat.o(110218);
      return i;
      if ((-1 < i) || (this.lCk != 1)) {
        break;
      }
      paramo = getChildAt(0);
      if (paramo != null) {}
      for (paramo = paramo.getParent();; paramo = null)
      {
        params = paramo;
        if (!(paramo instanceof RecyclerView)) {
          params = null;
        }
        paramo = (RecyclerView)params;
        ab.i(TAG, "vertical Drag to end, " + paramInt + ' ' + i + ", " + paramo);
        if (paramo == null) {
          break;
        }
        paramo.iQ();
        break;
      }
      label229:
      paramo = getChildAt(0);
      paramInt = bv(paramo);
      int j;
      int k;
      if (ik())
      {
        j = bA(paramo);
        k = by(paramo);
        f = -j / k;
      }
      else
      {
        j = bz(paramo);
        k = bx(paramo);
        f = -j / k;
      }
    }
  }
  
  public final void bJ(int paramInt)
  {
    AppMethodBeat.i(110225);
    ab.i(TAG, "LogStory: scrollToPosition " + paramInt + ' ' + bo.dtY());
    super.bJ(paramInt);
    m localm = this.sKd;
    if (localm != null)
    {
      localm.h(Integer.valueOf(paramInt), Float.valueOf(0.0F));
      AppMethodBeat.o(110225);
      return;
    }
    AppMethodBeat.o(110225);
  }
  
  public final void bX(int paramInt)
  {
    AppMethodBeat.i(110216);
    ab.i(TAG, "LogStory: onScrollStateChanged ".concat(String.valueOf(paramInt)));
    super.bX(paramInt);
    this.lCk = paramInt;
    if (this.lCk == 0) {
      hb(false);
    }
    AppMethodBeat.o(110216);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110222);
    super.c(paramRecyclerView, paramInt1, paramInt2);
    if ((this.lxQ >= paramInt1) && (this.lxQ < paramInt1 + paramInt2)) {
      this.lCl = true;
    }
    AppMethodBeat.o(110222);
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110223);
    j.q(paramRecyclerView, "recyclerView");
    ab.i(TAG, "LogStory: onItemsRemoved " + paramInt1 + ", " + paramInt2);
    super.d(paramRecyclerView, paramInt1, paramInt2);
    if ((this.lxQ >= paramInt1) && (this.lxQ < paramInt1 + paramInt2)) {
      this.lCl = true;
    }
    AppMethodBeat.o(110223);
  }
  
  public final void g(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110224);
    j.q(paramRecyclerView, "recyclerView");
    ab.i(TAG, "LogStory: onItemsUpdated " + paramInt1 + ", " + paramInt2);
    super.g(paramRecyclerView, paramInt1, paramInt2);
    if ((this.lxQ >= paramInt1) && (this.lxQ < paramInt1 + paramInt2)) {
      this.lCl = true;
    }
    AppMethodBeat.o(110224);
  }
  
  public final void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(110219);
    int i = bpp();
    if (i >= 0)
    {
      View localView = getChildAt(i);
      i = bv(localView);
      if ((i != this.lxQ) || (paramBoolean))
      {
        this.lxQ = i;
        m localm = this.lCm;
        if (localm != null)
        {
          i = this.lxQ;
          j.p(localView, "child");
          localm.h(Integer.valueOf(i), localView);
          AppMethodBeat.o(110219);
          return;
        }
      }
    }
    AppMethodBeat.o(110219);
  }
  
  public final boolean ij()
  {
    AppMethodBeat.i(110213);
    if ((this.sKe) && (super.ij()))
    {
      AppMethodBeat.o(110213);
      return true;
    }
    AppMethodBeat.o(110213);
    return false;
  }
  
  public final boolean ik()
  {
    AppMethodBeat.i(110214);
    if ((this.sKe) && (getItemCount() > 1) && (super.ik()))
    {
      AppMethodBeat.o(110214);
      return true;
    }
    AppMethodBeat.o(110214);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.b.b
 * JD-Core Version:    0.7.0.1
 */