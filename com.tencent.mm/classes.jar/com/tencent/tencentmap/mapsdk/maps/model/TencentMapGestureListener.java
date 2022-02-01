package com.tencent.tencentmap.mapsdk.maps.model;

public abstract interface TencentMapGestureListener
{
  public abstract boolean onDoubleTap(float paramFloat1, float paramFloat2);
  
  public abstract boolean onDown(float paramFloat1, float paramFloat2);
  
  public abstract boolean onFling(float paramFloat1, float paramFloat2);
  
  public abstract boolean onLongPress(float paramFloat1, float paramFloat2);
  
  public abstract void onMapStable();
  
  public abstract boolean onScroll(float paramFloat1, float paramFloat2);
  
  public abstract boolean onSingleTap(float paramFloat1, float paramFloat2);
  
  public abstract boolean onUp(float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
 * JD-Core Version:    0.7.0.1
 */