package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CircleOptions
{
  private boolean boVisible;
  private double dRadius;
  private float fStrokeWidth;
  private int iFillColor;
  private int iLevel;
  private int iStrokeColor;
  private int iZindex;
  private LatLng latlngCenter;
  private boolean mClickable;
  
  public CircleOptions()
  {
    AppMethodBeat.i(173128);
    this.iLevel = 2;
    this.latlngCenter = new LatLng(39.984253000000002D, 116.307439D);
    this.dRadius = 1.0D;
    this.fStrokeWidth = 1.0F;
    this.iStrokeColor = -16777216;
    this.iFillColor = 0;
    this.iZindex = 0;
    this.boVisible = true;
    AppMethodBeat.o(173128);
  }
  
  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(181059);
    this.iLevel = 2;
    this.latlngCenter = new LatLng(39.984253000000002D, 116.307439D);
    this.dRadius = 1.0D;
    this.fStrokeWidth = 1.0F;
    this.iStrokeColor = -16777216;
    this.iFillColor = 0;
    this.boVisible = true;
    this.latlngCenter = paramLatLng;
    this.dRadius = paramDouble;
    this.fStrokeWidth = paramFloat;
    this.iStrokeColor = paramInt2;
    this.iFillColor = paramInt3;
    this.iZindex = paramInt4;
    this.boVisible = paramBoolean;
    AppMethodBeat.o(181059);
  }
  
  public CircleOptions center(LatLng paramLatLng)
  {
    this.latlngCenter = paramLatLng;
    return this;
  }
  
  public CircleOptions clickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
    return this;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    this.iFillColor = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.latlngCenter;
  }
  
  public int getFillColor()
  {
    return this.iFillColor;
  }
  
  public int getLevel()
  {
    return this.iLevel;
  }
  
  public double getRadius()
  {
    return this.dRadius;
  }
  
  public int getStrokeColor()
  {
    return this.iStrokeColor;
  }
  
  public float getStrokeWidth()
  {
    return this.fStrokeWidth;
  }
  
  public int getZIndex()
  {
    return this.iZindex;
  }
  
  public boolean isClickable()
  {
    return this.mClickable;
  }
  
  public boolean isVisible()
  {
    return this.boVisible;
  }
  
  public CircleOptions level(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2)) {
      return this;
    }
    this.iLevel = paramInt;
    return this;
  }
  
  public CircleOptions radius(double paramDouble)
  {
    this.dRadius = paramDouble;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt)
  {
    this.iStrokeColor = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.fStrokeWidth = 1.0F;
      return this;
    }
    this.fStrokeWidth = paramFloat;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean)
  {
    this.boVisible = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(173129);
    if (paramParcel == null)
    {
      AppMethodBeat.o(173129);
      return;
    }
    paramParcel.writeDouble(this.dRadius);
    AppMethodBeat.o(173129);
  }
  
  public CircleOptions zIndex(int paramInt)
  {
    this.iZindex = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.CircleOptions
 * JD-Core Version:    0.7.0.1
 */