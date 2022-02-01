package com.tencent.tencentmap.mapsdk.maps.model;

public abstract interface MaskLayer
{
  public abstract String getId();
  
  public abstract MaskLayerOptions getOptions();
  
  public abstract int getZIndex();
  
  public abstract boolean isClickable();
  
  public abstract boolean isVisible();
  
  public abstract void remove();
  
  public abstract void remove(long paramLong);
  
  public abstract void setOptions(MaskLayerOptions paramMaskLayerOptions);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setZIndex(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MaskLayer
 * JD-Core Version:    0.7.0.1
 */