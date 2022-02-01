package com.tencent.mm.plugin.mv.ui.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "alphaStartOffset", "onLayoutCompleted", "", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollVerticallyBy", "dy", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "smoothScrollToPosition", "recyclerView", "position", "updateChild", "plugin-mv_release"})
public final class MusicLyricLayoutManager
  extends LinearLayoutManager
{
  private final int Gfo;
  
  private MusicLyricLayoutManager(Context paramContext)
  {
    super(1, false);
    AppMethodBeat.i(231364);
    this.Gfo = a.fromDPToPix(paramContext, 0);
    AppMethodBeat.o(231364);
  }
  
  private final void cWY()
  {
    AppMethodBeat.i(231362);
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
        kotlin.g.b.p.j(localView, "getChildAt(i) ?: continue");
        int k = (localView.getTop() + localView.getBottom()) / 2;
        int m = getHeight() / 2;
        int n = localView.getMeasuredHeight();
        if (n - Math.abs(k - m) > this.Gfo) {
          localView.setAlpha(Math.min(1.0F - Math.abs(k - m) / (n - this.Gfo), 1.0F));
        } else {
          localView.setAlpha(0.0F);
        }
      }
    }
    AppMethodBeat.o(231362);
  }
  
  public final void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(231357);
    super.onLayoutCompleted(params);
    cWY();
    AppMethodBeat.o(231357);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(231358);
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    cWY();
    AppMethodBeat.o(231358);
    return paramInt;
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(231360);
    kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
    paramRecyclerView = new a(paramRecyclerView, paramRecyclerView.getContext());
    paramRecyclerView.cV(paramInt);
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(231360);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/adapter/MusicLyricLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-mv_release"})
  public static final class a
    extends androidx.recyclerview.widget.p
  {
    a(RecyclerView paramRecyclerView, Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(228593);
      kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
      float f = 600.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(228593);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.adapter.MusicLyricLayoutManager
 * JD-Core Version:    0.7.0.1
 */