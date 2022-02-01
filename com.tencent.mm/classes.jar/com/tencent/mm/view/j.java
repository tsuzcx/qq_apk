package com.tencent.mm.view;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/IViewActionCallback;", "Lcom/tencent/mm/view/IPreViewDataCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
public abstract interface j
  extends i
{
  public abstract void onChanged();
  
  public abstract void onItemRangeChanged(int paramInt1, int paramInt2);
  
  public abstract void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject);
  
  public abstract void onItemRangeInserted(int paramInt1, int paramInt2);
  
  public abstract void onItemRangeRemoved(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.j
 * JD-Core Version:    0.7.0.1
 */