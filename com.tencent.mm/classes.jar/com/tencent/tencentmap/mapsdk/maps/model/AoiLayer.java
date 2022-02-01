package com.tencent.tencentmap.mapsdk.maps.model;

public abstract interface AoiLayer
  extends IOverlay
{
  public abstract String getId();
  
  public abstract LatLng location();
  
  public abstract String name();
  
  public abstract boolean remove();
  
  public static abstract interface OnAoiLayerLoadListener
  {
    public abstract void onAoiLayerLoaded(boolean paramBoolean, AoiLayer paramAoiLayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.AoiLayer
 * JD-Core Version:    0.7.0.1
 */