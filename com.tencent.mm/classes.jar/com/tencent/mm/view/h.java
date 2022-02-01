package com.tencent.mm.view;

import android.view.View;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/IMediaBannerIndicator;", "", "getCount", "", "getCurrentIndex", "getOnSelectedPageListener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "getView", "Landroid/view/View;", "isShowOnlyOneIndicator", "", "setCount", "", "count", "setCurrentIndex", "index", "setOnSelectedPageListener", "listener", "setShowOnlyOneIndicator", "isShow", "OnSelectedPageListener", "libmmui_release"})
public abstract interface h
{
  public abstract int getCount();
  
  public abstract View getView();
  
  public abstract void setCount(int paramInt);
  
  public abstract void setCurrentIndex(int paramInt);
  
  public abstract void setOnSelectedPageListener(a parama);
  
  public abstract void setShowOnlyOneIndicator(boolean paramBoolean);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "", "onSelected", "", "index", "", "libmmui_release"})
  public static abstract interface a
  {
    public abstract void Ir(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.h
 * JD-Core Version:    0.7.0.1
 */