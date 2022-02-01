package com.tencent.xweb.skia_canvas.resource_loader;

public abstract interface IResourceLoader
{
  public abstract byte[] loadResource(String paramString1, String paramString2);
  
  public abstract void loadResourceAsync(String paramString1, String paramString2, ResourceLoadCallback paramResourceLoadCallback);
  
  public static abstract interface ResourceLoadCallback
  {
    public abstract void onResourceLoaded(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader
 * JD-Core Version:    0.7.0.1
 */