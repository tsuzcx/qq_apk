package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Colorable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Widthable;

public abstract interface Arc
  extends Colorable, Levelable, Removable, Strokeable, Visible, Widthable, IOverlay
{
  public abstract LatLng getCenter();
  
  public abstract double getLength();
  
  public abstract double getRadius();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Arc
 * JD-Core Version:    0.7.0.1
 */