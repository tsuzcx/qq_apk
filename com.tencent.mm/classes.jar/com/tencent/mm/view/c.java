package com.tencent.mm.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/DefaultViewActionCallback;", "Lcom/tencent/mm/view/IViewActionCallback;", "()V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  implements k
{
  public void onChanged() {}
  
  public void onItemRangeChanged(int paramInt1, int paramInt2) {}
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject) {}
  
  public void onItemRangeInserted(int paramInt1, int paramInt2) {}
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2) {}
  
  public void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(234637);
    s.u(paramd, "reason");
    AppMethodBeat.o(234637);
  }
  
  public void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(234642);
    s.u(paramd, "reason");
    AppMethodBeat.o(234642);
  }
  
  public void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(234634);
    s.u(paramd, "reason");
    AppMethodBeat.o(234634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.c
 * JD-Core Version:    0.7.0.1
 */