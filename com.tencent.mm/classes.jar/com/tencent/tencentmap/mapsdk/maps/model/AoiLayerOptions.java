package com.tencent.tencentmap.mapsdk.maps.model;

public class AoiLayerOptions
{
  private int mMaxLevel = -1;
  private int mMinLevel = -1;
  
  public int getMaxLevel()
  {
    return this.mMaxLevel;
  }
  
  public int getMinLevel()
  {
    return this.mMinLevel;
  }
  
  public AoiLayerOptions setDisplayLevel(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > paramInt2)) {
      return this;
    }
    int i = paramInt1;
    if (paramInt1 < 3) {
      i = 3;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > 20) {
      paramInt1 = 20;
    }
    this.mMinLevel = i;
    this.mMaxLevel = paramInt1;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions
 * JD-Core Version:    0.7.0.1
 */