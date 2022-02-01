package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "orientation", "", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/content/Context;I)V", "TAG", "", "contentWidth", "itemWidth", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "applyWidthSize", "", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "smoothScrollToPosition", "recyclerView", "updateChildWithIndex", "index", "plugin-multitalk_release"})
public final class ScreenThumbLayoutManager
  extends LinearLayoutManager
{
  private RecyclerView CEY;
  private final String TAG;
  public int contentWidth;
  public int tHY;
  
  public ScreenThumbLayoutManager(RecyclerView paramRecyclerView, Context paramContext)
  {
    super(0, false);
    AppMethodBeat.i(205090);
    this.CEY = paramRecyclerView;
    this.TAG = "MicroMsg.ScreenThumbLayoutManager";
    AppMethodBeat.o(205090);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(205084);
    p.k(paramn, "recycler");
    p.k(params, "state");
    super.onLayoutChildren(paramn, params);
    AppMethodBeat.o(205084);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(205085);
    p.k(paramn, "recycler");
    p.k(params, "state");
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    AppMethodBeat.o(205085);
    return paramInt;
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(205087);
    au(paramInt, (this.contentWidth - this.tHY) / 2);
    AppMethodBeat.o(205087);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(205086);
    p.k(paramRecyclerView, "recyclerView");
    p.k(params, "state");
    if (paramInt == -1)
    {
      AppMethodBeat.o(205086);
      return;
    }
    paramRecyclerView = paramRecyclerView.getContext();
    p.j(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new a(paramRecyclerView);
    paramRecyclerView.cV(paramInt);
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(205086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.ScreenThumbLayoutManager
 * JD-Core Version:    0.7.0.1
 */