package com.tencent.mm.view.recyclerview;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
final class WxRecyclerAdapter$d
  implements Runnable
{
  WxRecyclerAdapter$d(WxRecyclerAdapter paramWxRecyclerAdapter) {}
  
  public final void run()
  {
    AppMethodBeat.i(204003);
    ad.i("RecyclerViewAdapterEx", "onPause visibleExposeMap.size:" + this.LEi.LEd.size() + " sessionExposeMap.size:" + this.LEi.LEc.size());
    this.LEi.LEd.clear();
    this.LEi.LEc.clear();
    AppMethodBeat.o(204003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter.d
 * JD-Core Version:    0.7.0.1
 */