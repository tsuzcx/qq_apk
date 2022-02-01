package com.tencent.mm.view.recyclerview;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$1$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$1"})
final class WxRecyclerAdapter$f
  implements Runnable
{
  WxRecyclerAdapter$f(f paramf, a parama, ViewGroup.LayoutParams paramLayoutParams, WxRecyclerAdapter paramWxRecyclerAdapter, e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(204005);
    f localf = this.LEo;
    View localView = this.qqq.arI;
    k.g(localView, "holder.itemView");
    localf.width = localView.getMeasuredWidth();
    localf = this.LEo;
    localView = this.qqq.arI;
    k.g(localView, "holder.itemView");
    localf.height = localView.getMeasuredHeight();
    AppMethodBeat.o(204005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter.f
 * JD-Core Version:    0.7.0.1
 */