package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "orientation", "", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/content/Context;I)V", "TAG", "", "contentWidth", "itemWidth", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "applyWidthSize", "", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "smoothScrollToPosition", "recyclerView", "updateChildWithIndex", "index", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScreenThumbLayoutManager
  extends LinearLayoutManager
{
  private RecyclerView Izb;
  private final String TAG;
  public int contentWidth;
  public int wLI;
  
  public ScreenThumbLayoutManager(RecyclerView paramRecyclerView, Context paramContext)
  {
    super(0, false);
    AppMethodBeat.i(285877);
    this.Izb = paramRecyclerView;
    this.TAG = "MicroMsg.ScreenThumbLayoutManager";
    AppMethodBeat.o(285877);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(285883);
    s.u(paramn, "recycler");
    s.u(params, "state");
    super.onLayoutChildren(paramn, params);
    AppMethodBeat.o(285883);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(285893);
    s.u(paramn, "recycler");
    s.u(params, "state");
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    AppMethodBeat.o(285893);
    return paramInt;
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(285906);
    bo(paramInt, (this.contentWidth - this.wLI) / 2);
    AppMethodBeat.o(285906);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(285900);
    s.u(paramRecyclerView, "recyclerView");
    s.u(params, "state");
    if (paramInt == -1)
    {
      AppMethodBeat.o(285900);
      return;
    }
    paramRecyclerView = paramRecyclerView.getContext();
    s.s(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new a(paramRecyclerView);
    paramRecyclerView.cag = paramInt;
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(285900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.ScreenThumbLayoutManager
 * JD-Core Version:    0.7.0.1
 */