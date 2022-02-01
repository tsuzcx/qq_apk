package com.tencent.mm.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/BaseViewActionCallback;", "Lcom/tencent/mm/view/IViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getHeaderCount", "", "onChanged", "", "onItemRangeChanged", "positionStart", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "updateState", "libmmui_release"})
public class b
  implements j
{
  private final RefreshLoadMoreLayout xvJ;
  
  public b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(194328);
    this.xvJ = paramRefreshLoadMoreLayout;
    AppMethodBeat.o(194328);
  }
  
  public void dFf() {}
  
  public int getHeaderCount()
  {
    return 0;
  }
  
  public void onChanged()
  {
    AppMethodBeat.i(194316);
    this.xvJ.onChanged();
    dFf();
    AppMethodBeat.o(194316);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194319);
    this.xvJ.onItemRangeChanged(getHeaderCount() + paramInt1, paramInt2);
    dFf();
    AppMethodBeat.o(194319);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(194320);
    this.xvJ.onItemRangeChanged(getHeaderCount() + paramInt1, paramInt2, paramObject);
    dFf();
    AppMethodBeat.o(194320);
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194323);
    this.xvJ.onItemRangeInserted(getHeaderCount() + paramInt1, paramInt2);
    dFf();
    AppMethodBeat.o(194323);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194325);
    this.xvJ.onItemRangeRemoved(getHeaderCount() + paramInt1, paramInt2);
    dFf();
    AppMethodBeat.o(194325);
  }
  
  public void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(194315);
    p.k(paramc, "reason");
    this.xvJ.onPreFinishLoadMore(paramc);
    dFf();
    AppMethodBeat.o(194315);
  }
  
  public void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(194313);
    p.k(paramc, "reason");
    this.xvJ.onPreFinishLoadMoreSmooth(paramc);
    dFf();
    AppMethodBeat.o(194313);
  }
  
  public void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(194314);
    p.k(paramc, "reason");
    this.xvJ.onPreFinishRefresh(paramc);
    dFf();
    AppMethodBeat.o(194314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.b
 * JD-Core Version:    0.7.0.1
 */