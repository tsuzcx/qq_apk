package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;

public abstract interface TencentMapContext
  extends TencentMapComponent, TencentMapResource
{
  public abstract Context getContext();
  
  public abstract TencentMapComponent getMapComponent();
  
  public abstract TencentMapResource getMapResource();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMapContext
 * JD-Core Version:    0.7.0.1
 */