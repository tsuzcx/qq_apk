package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Fillable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;

public abstract interface Circle
  extends Clickable, Fillable, Levelable, Removable, Strokeable, Tagable, Visible, IOverlay
{
  public abstract boolean contains(LatLng paramLatLng);
  
  public abstract LatLng getCenter();
  
  public abstract double getRadius();
  
  public abstract void setCenter(LatLng paramLatLng);
  
  public abstract void setOptions(CircleOptions paramCircleOptions);
  
  public abstract void setRadius(double paramDouble);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Circle
 * JD-Core Version:    0.7.0.1
 */