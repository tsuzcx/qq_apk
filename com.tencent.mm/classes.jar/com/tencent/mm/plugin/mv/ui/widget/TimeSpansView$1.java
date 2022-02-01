package com.tencent.mm.plugin.mv.ui.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/widget/TimeSpansView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TimeSpansView$1
  extends RecyclerView.l
{
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(286637);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt);
    a.c("com/tencent/mm/plugin/mv/ui/widget/TimeSpansView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    a.a(this, "com/tencent/mm/plugin/mv/ui/widget/TimeSpansView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
    AppMethodBeat.o(286637);
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(286631);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    a.c("com/tencent/mm/plugin/mv/ui/widget/TimeSpansView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    s.u(paramRecyclerView, "recyclerView");
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    Log.i("MicroMsg.TimeSpansView", "onScrolled: dx=" + paramInt1 + ", dy=" + paramInt2);
    a.a(this, "com/tencent/mm/plugin/mv/ui/widget/TimeSpansView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(286631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.TimeSpansView.1
 * JD-Core Version:    0.7.0.1
 */