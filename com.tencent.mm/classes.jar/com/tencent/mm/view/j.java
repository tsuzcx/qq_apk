package com.tencent.mm.view;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/IPreViewDataCallback;", "", "onPreFinishLoadMore", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface j
{
  public abstract void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd);
  
  public abstract void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd);
  
  public abstract void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.j
 * JD-Core Version:    0.7.0.1
 */