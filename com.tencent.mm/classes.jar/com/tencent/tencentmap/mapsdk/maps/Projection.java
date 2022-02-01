package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;

public abstract interface Projection
{
  public abstract LatLng fromScreenLocation(Point paramPoint);
  
  public abstract VisibleRegion getVisibleRegion();
  
  public abstract float[] glModelMatrix(PointF paramPointF, float paramFloat);
  
  public abstract float glPixelRatio();
  
  public abstract float[] glProjectionMatrix();
  
  public abstract PointF glVertexForCoordinate(LatLng paramLatLng);
  
  public abstract float[] glViewMatrix();
  
  public abstract double metersPerPixel(double paramDouble);
  
  public abstract Point toScreenLocation(LatLng paramLatLng);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.Projection
 * JD-Core Version:    0.7.0.1
 */