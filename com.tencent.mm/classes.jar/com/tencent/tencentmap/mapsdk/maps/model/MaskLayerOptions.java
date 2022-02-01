package com.tencent.tencentmap.mapsdk.maps.model;

public class MaskLayerOptions
{
  private long mAnimationDuration = 0L;
  private int mColor = 0;
  private int mZIndex = 0;
  
  public MaskLayerOptions animationDuration(long paramLong)
  {
    this.mAnimationDuration = paramLong;
    return this;
  }
  
  public MaskLayerOptions color(int paramInt)
  {
    this.mColor = paramInt;
    return this;
  }
  
  public long getAnimationDuration()
  {
    return this.mAnimationDuration;
  }
  
  public int getColor()
  {
    return this.mColor;
  }
  
  public int getZIndex()
  {
    return this.mZIndex;
  }
  
  public MaskLayerOptions zIndex(int paramInt)
  {
    this.mZIndex = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MaskLayerOptions
 * JD-Core Version:    0.7.0.1
 */