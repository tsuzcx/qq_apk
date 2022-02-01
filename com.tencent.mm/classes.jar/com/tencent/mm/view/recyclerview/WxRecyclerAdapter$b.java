package com.tencent.mm.view.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$2", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "notifyChangeEvent", "", "onChanged", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxRecyclerAdapter$b
  extends RecyclerView.c
{
  WxRecyclerAdapter$b(RecyclerView paramRecyclerView, WxRecyclerAdapter<D> paramWxRecyclerAdapter) {}
  
  private static final void a(WxRecyclerAdapter paramWxRecyclerAdapter, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(234870);
    s.u(paramWxRecyclerAdapter, "this$0");
    s.u(paramRecyclerView, "$recyclerView");
    paramWxRecyclerAdapter = WxRecyclerAdapter.e(paramWxRecyclerAdapter);
    if (paramWxRecyclerAdapter != null) {
      paramWxRecyclerAdapter.onScrollStateChanged(paramRecyclerView, 8);
    }
    AppMethodBeat.o(234870);
  }
  
  private void jNp()
  {
    AppMethodBeat.i(234863);
    this.AJl.post(new WxRecyclerAdapter.b..ExternalSyntheticLambda0(this.agOW, this.AJl));
    AppMethodBeat.o(234863);
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(234879);
    super.onChanged();
    jNp();
    AppMethodBeat.o(234879);
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(234884);
    super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
    jNp();
    AppMethodBeat.o(234884);
  }
  
  public final void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234888);
    super.onItemRangeInserted(paramInt1, paramInt2);
    jNp();
    AppMethodBeat.o(234888);
  }
  
  public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(234891);
    super.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
    jNp();
    AppMethodBeat.o(234891);
  }
  
  public final void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234894);
    super.onItemRangeRemoved(paramInt1, paramInt2);
    jNp();
    AppMethodBeat.o(234894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter.b
 * JD-Core Version:    0.7.0.1
 */