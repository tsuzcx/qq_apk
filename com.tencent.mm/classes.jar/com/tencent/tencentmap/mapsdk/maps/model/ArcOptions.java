package com.tencent.tencentmap.mapsdk.maps.model;

public final class ArcOptions
{
  float mAngle = 0.0F;
  int mColor = -16777216;
  LatLng mEndLatLng;
  LatLng mPassLatLng;
  boolean mShowArrow;
  LatLng mStartLatLng;
  int mStrokeColor;
  float mStrokeWidth = 0.0F;
  float mWidth = 5.0F;
  
  public final ArcOptions angle(float paramFloat)
  {
    this.mAngle = paramFloat;
    return this;
  }
  
  public final ArcOptions color(int paramInt)
  {
    this.mColor = paramInt;
    return this;
  }
  
  public final float getAngle()
  {
    return this.mAngle;
  }
  
  public final int getColor()
  {
    return this.mColor;
  }
  
  public final LatLng getEndLatLng()
  {
    return this.mEndLatLng;
  }
  
  public final LatLng getPassLatLng()
  {
    return this.mPassLatLng;
  }
  
  public final LatLng getStartLatLng()
  {
    return this.mStartLatLng;
  }
  
  public final int getStrokeColor()
  {
    return this.mStrokeColor;
  }
  
  public final float getStrokeWidth()
  {
    return this.mStrokeWidth;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final boolean isShowArrow()
  {
    return this.mShowArrow;
  }
  
  public final ArcOptions pass(LatLng paramLatLng)
  {
    this.mPassLatLng = paramLatLng;
    return this;
  }
  
  public final ArcOptions points(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this.mStartLatLng = paramLatLng1;
    this.mEndLatLng = paramLatLng2;
    return this;
  }
  
  public final ArcOptions showArrow(boolean paramBoolean)
  {
    this.mShowArrow = paramBoolean;
    return this;
  }
  
  public final ArcOptions strokeColor(int paramInt)
  {
    this.mStrokeColor = paramInt;
    return this;
  }
  
  public final ArcOptions strokeWidth(float paramFloat)
  {
    this.mStrokeWidth = paramFloat;
    return this;
  }
  
  public final ArcOptions width(float paramFloat)
  {
    this.mWidth = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.ArcOptions
 * JD-Core Version:    0.7.0.1
 */