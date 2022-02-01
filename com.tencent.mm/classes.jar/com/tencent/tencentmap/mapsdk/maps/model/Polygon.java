package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Fillable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;
import java.util.List;

public abstract interface Polygon
  extends Clickable, Fillable, Levelable, Removable, Strokeable, Tagable<Object>, Visible, IOverlay
{
  public abstract boolean contains(LatLng paramLatLng);
  
  public abstract List<LatLng> getPoints();
  
  public abstract void setOptions(PolygonOptions paramPolygonOptions);
  
  public abstract void setPoints(List<LatLng> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Polygon
 * JD-Core Version:    0.7.0.1
 */