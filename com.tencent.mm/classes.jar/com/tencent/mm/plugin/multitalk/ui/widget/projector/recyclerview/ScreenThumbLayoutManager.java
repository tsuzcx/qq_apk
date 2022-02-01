package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "mRecycleView", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/support/v7/widget/RecyclerView;Landroid/content/Context;I)V", "TAG", "", "contentWidth", "itemWidth", "getMRecycleView", "()Landroid/support/v7/widget/RecyclerView;", "setMRecycleView", "(Landroid/support/v7/widget/RecyclerView;)V", "applyWidthSize", "", "onLayoutChildren", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "smoothScrollToPosition", "recyclerView", "updateChildWithIndex", "index", "plugin-multitalk_release"})
public final class ScreenThumbLayoutManager
  extends LinearLayoutManager
{
  private final String TAG;
  public int qmd;
  private RecyclerView xAX;
  public int zYO;
  
  public ScreenThumbLayoutManager(RecyclerView paramRecyclerView, Context paramContext)
  {
    super(0, false);
    AppMethodBeat.i(240087);
    this.xAX = paramRecyclerView;
    this.TAG = "MicroMsg.ScreenThumbLayoutManager";
    AppMethodBeat.o(240087);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(240083);
    p.h(paramn, "recycler");
    p.h(params, "state");
    super.onLayoutChildren(paramn, params);
    AppMethodBeat.o(240083);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(240084);
    p.h(paramn, "recycler");
    p.h(params, "state");
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    AppMethodBeat.o(240084);
    return paramInt;
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(240086);
    ah(paramInt, (this.zYO - this.qmd) / 2);
    AppMethodBeat.o(240086);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(240085);
    p.h(paramRecyclerView, "recyclerView");
    p.h(params, "state");
    if (paramInt == -1)
    {
      AppMethodBeat.o(240085);
      return;
    }
    paramRecyclerView = paramRecyclerView.getContext();
    p.g(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new a(paramRecyclerView);
    paramRecyclerView.ct(paramInt);
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(240085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.ScreenThumbLayoutManager
 * JD-Core Version:    0.7.0.1
 */