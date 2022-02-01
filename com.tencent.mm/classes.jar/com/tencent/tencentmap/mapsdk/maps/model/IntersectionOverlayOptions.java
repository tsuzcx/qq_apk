package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Rect;

public final class IntersectionOverlayOptions
{
  private Rect mBounds;
  private boolean mDarkMode = false;
  private byte[] mData;
  private int mDistance;
  private boolean mVisibility = true;
  
  public final IntersectionOverlayOptions bounds(Rect paramRect)
  {
    this.mBounds = paramRect;
    return this;
  }
  
  public final IntersectionOverlayOptions darkMode(boolean paramBoolean)
  {
    this.mDarkMode = paramBoolean;
    return this;
  }
  
  public final IntersectionOverlayOptions data(byte[] paramArrayOfByte)
  {
    this.mData = paramArrayOfByte;
    return this;
  }
  
  public final IntersectionOverlayOptions distance(int paramInt)
  {
    this.mDistance = paramInt;
    return this;
  }
  
  public final Rect getBounds()
  {
    return this.mBounds;
  }
  
  public final byte[] getData()
  {
    return this.mData;
  }
  
  public final int getDistance()
  {
    return this.mDistance;
  }
  
  public final boolean isDarkMode()
  {
    return this.mDarkMode;
  }
  
  public final boolean isVisibility()
  {
    return this.mVisibility;
  }
  
  public final IntersectionOverlayOptions visibility(boolean paramBoolean)
  {
    this.mVisibility = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions
 * JD-Core Version:    0.7.0.1
 */