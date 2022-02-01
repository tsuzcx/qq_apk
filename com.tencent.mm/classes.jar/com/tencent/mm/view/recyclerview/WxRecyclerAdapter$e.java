package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
final class WxRecyclerAdapter$e
  implements Runnable
{
  WxRecyclerAdapter$e(WxRecyclerAdapter paramWxRecyclerAdapter) {}
  
  public final void run()
  {
    AppMethodBeat.i(204004);
    RecyclerView.m localm = WxRecyclerAdapter.b(this.LEi);
    if (localm != null)
    {
      localm.b(this.LEi.getRecyclerView(), 7);
      AppMethodBeat.o(204004);
      return;
    }
    AppMethodBeat.o(204004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter.e
 * JD-Core Version:    0.7.0.1
 */