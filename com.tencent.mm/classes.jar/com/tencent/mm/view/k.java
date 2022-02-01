package com.tencent.mm.view;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/IViewActionCallback;", "Lcom/tencent/mm/view/IPreViewDataCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface k
  extends j
{
  public abstract void onChanged();
  
  public abstract void onItemRangeChanged(int paramInt1, int paramInt2);
  
  public abstract void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject);
  
  public abstract void onItemRangeInserted(int paramInt1, int paramInt2);
  
  public abstract void onItemRangeRemoved(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.k
 * JD-Core Version:    0.7.0.1
 */