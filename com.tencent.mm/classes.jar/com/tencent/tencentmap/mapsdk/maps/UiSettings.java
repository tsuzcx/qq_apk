package com.tencent.tencentmap.mapsdk.maps;

public abstract interface UiSettings
{
  public abstract boolean isCompassEnabled();
  
  public abstract boolean isIndoorLevelPickerEnabled();
  
  public abstract boolean isMyLocationButtonEnabled();
  
  public abstract boolean isRotateGesturesEnabled();
  
  public abstract boolean isScaleViewEnabled();
  
  public abstract boolean isScrollGesturesEnabled();
  
  public abstract boolean isTiltGesturesEnabled();
  
  public abstract boolean isZoomControlsEnabled();
  
  public abstract boolean isZoomGesturesEnabled();
  
  public abstract void setAllGesturesEnabled(boolean paramBoolean);
  
  public abstract void setCompassEnabled(boolean paramBoolean);
  
  public abstract void setCompassExtraPadding(int paramInt);
  
  public abstract void setCompassExtraPadding(int paramInt1, int paramInt2);
  
  public abstract void setFlingGestureEnabled(boolean paramBoolean);
  
  public abstract void setGestureScaleByMapCenter(boolean paramBoolean);
  
  public abstract void setIndoorLevelPickerEnabled(boolean paramBoolean);
  
  public abstract void setLogoPosition(int paramInt);
  
  public abstract void setLogoPosition(int paramInt, int[] paramArrayOfInt);
  
  public abstract void setLogoPositionWithMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void setLogoScale(float paramFloat);
  
  public abstract void setLogoSize(int paramInt);
  
  public abstract void setMyLocationButtonEnabled(boolean paramBoolean);
  
  public abstract void setRotateGesturesEnabled(boolean paramBoolean);
  
  public abstract void setScaleViewEnabled(boolean paramBoolean);
  
  public abstract void setScaleViewFadeEnable(boolean paramBoolean);
  
  public abstract void setScaleViewPosition(int paramInt);
  
  public abstract void setScaleViewPositionWithMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void setScrollGesturesEnabled(boolean paramBoolean);
  
  public abstract void setTiltGesturesEnabled(boolean paramBoolean);
  
  public abstract void setZoomControlsEnabled(boolean paramBoolean);
  
  public abstract void setZoomGesturesEnabled(boolean paramBoolean);
  
  public abstract void setZoomPosition(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.UiSettings
 * JD-Core Version:    0.7.0.1
 */