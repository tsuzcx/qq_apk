package com.tencent.mm.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/BaseViewActionCallback;", "Lcom/tencent/mm/view/IViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getHeaderCount", "", "onChanged", "", "onItemRangeChanged", "positionStart", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "updateState", "libmmui_release"})
public class b
  implements j
{
  private final RefreshLoadMoreLayout tLS;
  
  public b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(204919);
    this.tLS = paramRefreshLoadMoreLayout;
    AppMethodBeat.o(204919);
  }
  
  public void dmp() {}
  
  public int getHeaderCount()
  {
    return 0;
  }
  
  public void onChanged()
  {
    AppMethodBeat.i(204914);
    this.tLS.onChanged();
    dmp();
    AppMethodBeat.o(204914);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204915);
    this.tLS.onItemRangeChanged(getHeaderCount() + paramInt1, paramInt2);
    dmp();
    AppMethodBeat.o(204915);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(204916);
    this.tLS.onItemRangeChanged(getHeaderCount() + paramInt1, paramInt2, paramObject);
    dmp();
    AppMethodBeat.o(204916);
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204917);
    this.tLS.onItemRangeInserted(getHeaderCount() + paramInt1, paramInt2);
    dmp();
    AppMethodBeat.o(204917);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204918);
    this.tLS.onItemRangeRemoved(getHeaderCount() + paramInt1, paramInt2);
    dmp();
    AppMethodBeat.o(204918);
  }
  
  public void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(204913);
    p.h(paramc, "reason");
    this.tLS.onPreFinishLoadMore(paramc);
    dmp();
    AppMethodBeat.o(204913);
  }
  
  public void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(204911);
    p.h(paramc, "reason");
    this.tLS.onPreFinishLoadMoreSmooth(paramc);
    dmp();
    AppMethodBeat.o(204911);
  }
  
  public void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(204912);
    p.h(paramc, "reason");
    this.tLS.onPreFinishRefresh(paramc);
    dmp();
    AppMethodBeat.o(204912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.b
 * JD-Core Version:    0.7.0.1
 */