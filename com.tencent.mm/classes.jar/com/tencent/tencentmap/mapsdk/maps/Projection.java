package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Point;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;

public abstract interface Projection
{
  public abstract LatLng fromScreenLocation(Point paramPoint);
  
  public abstract VisibleRegion getVisibleRegion();
  
  public abstract double metersPerPixel(double paramDouble);
  
  public abstract Point toScreenLocation(LatLng paramLatLng);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.Projection
 * JD-Core Version:    0.7.0.1
 */