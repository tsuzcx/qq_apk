package com.tencent.xweb.skia_canvas;

import android.graphics.Bitmap;

public abstract interface IXWebImageLoader
{
  public abstract Bitmap loadImage(String paramString);
  
  public abstract void loadImageAsync(String paramString, IXWebImageLoader.LoadImageCallback paramLoadImageCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.IXWebImageLoader
 * JD-Core Version:    0.7.0.1
 */