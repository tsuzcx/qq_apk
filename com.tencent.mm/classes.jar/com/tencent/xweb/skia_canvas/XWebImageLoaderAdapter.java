package com.tencent.xweb.skia_canvas;

public abstract class XWebImageLoaderAdapter
  implements IXWebImageLoader
{
  protected void loadImageAsync(String paramString, IXWebImageLoader.LoadImageCallback paramLoadImageCallback) {}
  
  public void loadImageAsync(String paramString1, String paramString2, IXWebImageLoader.LoadImageCallback paramLoadImageCallback)
  {
    loadImageAsync(paramString1, paramLoadImageCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.XWebImageLoaderAdapter
 * JD-Core Version:    0.7.0.1
 */