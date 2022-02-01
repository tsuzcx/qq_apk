package com.tencent.mm.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/DefaultViewActionCallback;", "Lcom/tencent/mm/view/IViewActionCallback;", "()V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "libmmui_release"})
public class c
  implements j
{
  public void onChanged() {}
  
  public void onItemRangeChanged(int paramInt1, int paramInt2) {}
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject) {}
  
  public void onItemRangeInserted(int paramInt1, int paramInt2) {}
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2) {}
  
  public void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(204921);
    p.h(paramc, "reason");
    AppMethodBeat.o(204921);
  }
  
  public void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(204922);
    p.h(paramc, "reason");
    AppMethodBeat.o(204922);
  }
  
  public void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(204920);
    p.h(paramc, "reason");
    AppMethodBeat.o(204920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.c
 * JD-Core Version:    0.7.0.1
 */