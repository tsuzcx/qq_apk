package com.tencent.tencentmap.mapsdk.maps.model;

public abstract interface VectorOverlayProvider
{
  public abstract VectorOverlayProvider displayLevel(int paramInt);
  
  public abstract int getDisplayLevel();
  
  public abstract int getMaxZoom();
  
  public abstract int getMinZoom();
  
  public abstract float getOpacity();
  
  public abstract int getZIndex();
  
  public abstract boolean isVisibility();
  
  public abstract VectorOverlayProvider maxZoom(int paramInt);
  
  public abstract VectorOverlayProvider minZoom(int paramInt);
  
  public abstract VectorOverlayProvider opacity(float paramFloat);
  
  public abstract VectorOverlayProvider visibility(boolean paramBoolean);
  
  public abstract VectorOverlayProvider zIndex(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
 * JD-Core Version:    0.7.0.1
 */