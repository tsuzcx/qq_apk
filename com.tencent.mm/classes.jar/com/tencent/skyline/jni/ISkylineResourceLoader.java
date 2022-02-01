package com.tencent.skyline.jni;

import android.graphics.Bitmap;

public abstract interface ISkylineResourceLoader
{
  public abstract Bitmap loadBitmap(String paramString);
  
  public abstract void loadBitmapAsync(String paramString, BitmapLoadCallback paramBitmapLoadCallback);
  
  public abstract byte[] loadResource(String paramString);
  
  public abstract void loadResourceAsync(String paramString, ResourceLoadCallback paramResourceLoadCallback);
  
  public static abstract interface BitmapLoadCallback
  {
    public abstract void onBitmapLoaded(Bitmap paramBitmap);
  }
  
  public static abstract interface ResourceLoadCallback
  {
    public abstract void onResourceLoaded(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.skyline.jni.ISkylineResourceLoader
 * JD-Core Version:    0.7.0.1
 */