package com.tencent.mm.view;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/IMediaBannerIndicator;", "", "getCount", "", "getCurrentIndex", "getOnSelectedPageListener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "getView", "Landroid/view/View;", "isShowOnlyOneIndicator", "", "setCount", "", "count", "setCurrentIndex", "index", "setOnSelectedPageListener", "listener", "setShowOnlyOneIndicator", "isShow", "OnSelectedPageListener", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface i
{
  public abstract int getCount();
  
  public abstract View getView();
  
  public abstract void setCount(int paramInt);
  
  public abstract void setCurrentIndex(int paramInt);
  
  public abstract void setOnSelectedPageListener(i.a parama);
  
  public abstract void setShowOnlyOneIndicator(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.i
 * JD-Core Version:    0.7.0.1
 */