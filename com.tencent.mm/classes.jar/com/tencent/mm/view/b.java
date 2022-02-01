package com.tencent.mm.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/BaseViewActionCallback;", "Lcom/tencent/mm/view/IViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getHeaderCount", "", "onChanged", "", "onItemRangeChanged", "positionStart", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "updateState", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  implements k
{
  private final RefreshLoadMoreLayout ATx;
  
  public b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(234620);
    this.ATx = paramRefreshLoadMoreLayout;
    AppMethodBeat.o(234620);
  }
  
  public void evt() {}
  
  public void onChanged()
  {
    AppMethodBeat.i(234636);
    this.ATx.onChanged();
    evt();
    AppMethodBeat.o(234636);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234640);
    this.ATx.onItemRangeChanged(paramInt1 + 0, paramInt2);
    evt();
    AppMethodBeat.o(234640);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(234644);
    this.ATx.onItemRangeChanged(paramInt1 + 0, paramInt2, paramObject);
    evt();
    AppMethodBeat.o(234644);
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234647);
    this.ATx.onItemRangeInserted(paramInt1 + 0, paramInt2);
    evt();
    AppMethodBeat.o(234647);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234650);
    this.ATx.onItemRangeRemoved(paramInt1 + 0, paramInt2);
    evt();
    AppMethodBeat.o(234650);
  }
  
  public void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(234632);
    s.u(paramd, "reason");
    this.ATx.onPreFinishLoadMore(paramd);
    evt();
    AppMethodBeat.o(234632);
  }
  
  public void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(234624);
    s.u(paramd, "reason");
    this.ATx.onPreFinishLoadMoreSmooth(paramd);
    evt();
    AppMethodBeat.o(234624);
  }
  
  public void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(234627);
    s.u(paramd, "reason");
    this.ATx.onPreFinishRefresh(paramd);
    evt();
    AppMethodBeat.o(234627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.b
 * JD-Core Version:    0.7.0.1
 */