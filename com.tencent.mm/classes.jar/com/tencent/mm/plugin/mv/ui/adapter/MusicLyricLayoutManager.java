package com.tencent.mm.plugin.mv.ui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "alphaStartOffset", "onLayoutCompleted", "", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollVerticallyBy", "dy", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "smoothScrollToPosition", "recyclerView", "position", "updateChild", "plugin-mv_release"})
public final class MusicLyricLayoutManager
  extends LinearLayoutManager
{
  private final int ArH;
  
  private MusicLyricLayoutManager(Context paramContext)
  {
    super(1, false);
    AppMethodBeat.i(256970);
    this.ArH = a.fromDPToPix(paramContext, 0);
    AppMethodBeat.o(256970);
  }
  
  private final void cKb()
  {
    AppMethodBeat.i(256969);
    int i = 0;
    int j = getChildCount();
    if (i < j)
    {
      View localView = getChildAt(i);
      if (localView == null) {}
      for (;;)
      {
        i += 1;
        break;
        p.g(localView, "getChildAt(i) ?: continue");
        int k = (localView.getTop() + localView.getBottom()) / 2;
        int m = getHeight() / 2;
        int n = localView.getMeasuredHeight();
        if (n - Math.abs(k - m) > this.ArH) {
          localView.setAlpha(Math.min(1.0F - Math.abs(k - m) / (n - this.ArH), 1.0F));
        } else {
          localView.setAlpha(0.0F);
        }
      }
    }
    AppMethodBeat.o(256969);
  }
  
  public final void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(256966);
    super.onLayoutCompleted(params);
    cKb();
    AppMethodBeat.o(256966);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(256967);
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    cKb();
    AppMethodBeat.o(256967);
    return paramInt;
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(256968);
    p.h(paramRecyclerView, "recyclerView");
    paramRecyclerView = new a(paramRecyclerView, paramRecyclerView.getContext());
    paramRecyclerView.ct(paramInt);
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(256968);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/adapter/MusicLyricLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-mv_release"})
  public static final class a
    extends ae
  {
    a(RecyclerView paramRecyclerView, Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(256965);
      p.h(paramDisplayMetrics, "displayMetrics");
      float f = 600.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(256965);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.adapter.MusicLyricLayoutManager
 * JD-Core Version:    0.7.0.1
 */