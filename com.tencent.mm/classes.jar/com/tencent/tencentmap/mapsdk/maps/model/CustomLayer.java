package com.tencent.tencentmap.mapsdk.maps.model;

public abstract interface CustomLayer
  extends IOverlay
{
  public abstract void clearDiskCache();
  
  public abstract String getId();
  
  public abstract void reload();
  
  public abstract void remove();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.CustomLayer
 * JD-Core Version:    0.7.0.1
 */