package com.tencent.tencentmap.mapsdk.maps.model;

public abstract interface GroundOverlay
{
  public abstract void remove();
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setAnchor(float paramFloat1, float paramFloat2);
  
  public abstract void setBitmap(BitmapDescriptor paramBitmapDescriptor);
  
  public abstract void setLatLongBounds(LatLngBounds paramLatLngBounds);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setPosition(LatLng paramLatLng);
  
  public abstract void setVisibility(boolean paramBoolean);
  
  public abstract void setZindex(int paramInt);
  
  public abstract void setZoom(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
 * JD-Core Version:    0.7.0.1
 */