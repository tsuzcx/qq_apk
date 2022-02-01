package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;

public abstract interface CustomLayer
  extends Removable, IOverlay
{
  public abstract void clearDiskCache();
  
  public abstract void reload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.CustomLayer
 * JD-Core Version:    0.7.0.1
 */