package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Rect;

public abstract interface IntersectionOverlay
{
  public abstract void remove();
  
  public abstract void setBounds(Rect paramRect);
  
  public abstract void setDarkMode(boolean paramBoolean);
  
  public abstract void setData(byte[] paramArrayOfByte);
  
  public abstract void setDistance(int paramInt);
  
  public abstract void setVisibility(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay
 * JD-Core Version:    0.7.0.1
 */