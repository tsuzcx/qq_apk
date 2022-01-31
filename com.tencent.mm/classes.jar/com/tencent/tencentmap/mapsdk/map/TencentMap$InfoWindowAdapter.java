package com.tencent.tencentmap.mapsdk.map;

import android.view.View;
import com.tencent.mapsdk.raster.model.Marker;

public abstract interface TencentMap$InfoWindowAdapter
{
  public abstract View getInfoWindow(Marker paramMarker);
  
  public abstract void onInfoWindowDettached(Marker paramMarker, View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
 * JD-Core Version:    0.7.0.1
 */