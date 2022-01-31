package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.ETC1Util.ETC1Texture;

public abstract interface LoadItemManager
{
  public abstract void clear();
  
  public abstract ETC1Util.ETC1Texture loadETCAlphaTexture(int paramInt);
  
  public abstract ETC1Util.ETC1Texture loadETCRGBTexture(int paramInt);
  
  public abstract Bitmap loadImage(int paramInt);
  
  public abstract Bitmap loadImage(String paramString);
  
  public abstract void prepareImages();
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadItemManager
 * JD-Core Version:    0.7.0.1
 */