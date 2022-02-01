package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MyLocationStyle
{
  public static final int LOCATION_TYPE_FOLLOW_NO_CENTER = 2;
  public static final int LOCATION_TYPE_LOCATION_ROTATE = 0;
  public static final int LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER = 1;
  public static final int LOCATION_TYPE_MAP_ROTATE_NO_CENTER = 3;
  private float anchorU;
  private float anchorV;
  private int fillColor;
  private BitmapDescriptor mIcon;
  private int myLocationType;
  private int strokeColor;
  private float strokeWidth;
  
  public MyLocationStyle()
  {
    AppMethodBeat.i(173272);
    this.anchorU = 0.5F;
    this.anchorV = 0.5F;
    this.fillColor = Color.argb(102, 0, 163, 255);
    this.strokeColor = Color.argb(127, 0, 163, 255);
    this.strokeWidth = 1.0F;
    this.myLocationType = 0;
    AppMethodBeat.o(173272);
  }
  
  public MyLocationStyle anchor(float paramFloat1, float paramFloat2)
  {
    this.anchorU = paramFloat1;
    this.anchorV = paramFloat2;
    return this;
  }
  
  public MyLocationStyle fillColor(int paramInt)
  {
    this.fillColor = paramInt;
    return this;
  }
  
  public float getAnchorU()
  {
    return this.anchorU;
  }
  
  public float getAnchorV()
  {
    return this.anchorV;
  }
  
  public int getFillColor()
  {
    return this.fillColor;
  }
  
  public BitmapDescriptor getMyLocationIcon()
  {
    return this.mIcon;
  }
  
  public int getMyLocationType()
  {
    return this.myLocationType;
  }
  
  public int getStrokeColor()
  {
    return this.strokeColor;
  }
  
  public float getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public MyLocationStyle icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.mIcon = paramBitmapDescriptor;
    return this;
  }
  
  public MyLocationStyle myLocationType(int paramInt)
  {
    this.myLocationType = paramInt;
    return this;
  }
  
  public MyLocationStyle strokeColor(int paramInt)
  {
    this.strokeColor = paramInt;
    return this;
  }
  
  public MyLocationStyle strokeWidth(int paramInt)
  {
    this.strokeWidth = paramInt;
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(237834);
    String str = "{anchorU=" + this.anchorU + ", anchorV=" + this.anchorV + ", fillColor=" + this.fillColor + ", strokeColor=" + this.strokeColor + ", strokeWidth=" + this.strokeWidth + ", myLocationType=" + this.myLocationType + ", mIcon=" + this.mIcon + '}';
    AppMethodBeat.o(237834);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle
 * JD-Core Version:    0.7.0.1
 */