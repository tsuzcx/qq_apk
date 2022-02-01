package com.tencent.mm.view;

import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/IPreViewDataCallback;", "", "onPreFinishLoadMore", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "libmmui_release"})
public abstract interface i
{
  public abstract void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc);
  
  public abstract void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc);
  
  public abstract void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.i
 * JD-Core Version:    0.7.0.1
 */