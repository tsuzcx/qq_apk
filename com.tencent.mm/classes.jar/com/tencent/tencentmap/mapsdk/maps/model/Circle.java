package com.tencent.tencentmap.mapsdk.maps.model;

public abstract interface Circle
  extends IOverlay
{
  public abstract boolean contains(LatLng paramLatLng);
  
  public abstract LatLng getCenter();
  
  public abstract int getFillColor();
  
  public abstract String getId();
  
  public abstract int getLevel();
  
  public abstract double getRadius();
  
  public abstract int getStrokeColor();
  
  public abstract float getStrokeWidth();
  
  public abstract Object getTag();
  
  public abstract float getZIndex();
  
  public abstract boolean isClickable();
  
  public abstract boolean isVisible();
  
  public abstract void remove();
  
  public abstract void setCenter(LatLng paramLatLng);
  
  public abstract void setClickable(boolean paramBoolean);
  
  public abstract void setFillColor(int paramInt);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setOptions(CircleOptions paramCircleOptions);
  
  public abstract void setRadius(double paramDouble);
  
  public abstract void setStrokeColor(int paramInt);
  
  public abstract void setStrokeWidth(float paramFloat);
  
  public abstract void setTag(Object paramObject);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setZIndex(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Circle
 * JD-Core Version:    0.7.0.1
 */