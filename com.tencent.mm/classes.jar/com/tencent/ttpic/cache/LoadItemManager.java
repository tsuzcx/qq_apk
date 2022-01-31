package com.tencent.ttpic.cache;

import android.graphics.Bitmap;

public abstract interface LoadItemManager
{
  public abstract void clear();
  
  public abstract Bitmap loadImage(int paramInt);
  
  public abstract Bitmap loadImage(String paramString);
  
  public abstract void prepareImages();
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadItemManager
 * JD-Core Version:    0.7.0.1
 */