package com.tencent.tencentmap.mapsdk.maps.model;

public abstract interface TileOverlay
  extends IOverlay
{
  public abstract void clearTileCache();
  
  public abstract String getId();
  
  public abstract void reload();
  
  public abstract void remove();
  
  public abstract void setDiskCacheDir(String paramString);
  
  public abstract void setZindex(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
 * JD-Core Version:    0.7.0.1
 */