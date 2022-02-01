package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;

public abstract interface ISkiaCanvasExternalTextureHandler
{
  public abstract void onFrameAvailable();
  
  public abstract void onLoad(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureHandler
 * JD-Core Version:    0.7.0.1
 */