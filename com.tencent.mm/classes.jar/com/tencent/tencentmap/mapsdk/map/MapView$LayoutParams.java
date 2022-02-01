package com.tencent.tencentmap.mapsdk.map;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mapsdk.raster.model.LatLng;

public class MapView$LayoutParams
  extends ViewGroup.LayoutParams
{
  public static final int BOTTOM_CENTER = 81;
  public static final int CENTER = 17;
  public int alignment = 17;
  public int height = 0;
  public LatLng point = null;
  public int width = 0;
  
  public MapView$LayoutParams(int paramInt1, int paramInt2, LatLng paramLatLng, int paramInt3)
  {
    super(paramInt1, paramInt2);
    this.width = paramInt1;
    this.height = paramInt2;
    this.point = paramLatLng;
    this.alignment = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams
 * JD-Core Version:    0.7.0.1
 */