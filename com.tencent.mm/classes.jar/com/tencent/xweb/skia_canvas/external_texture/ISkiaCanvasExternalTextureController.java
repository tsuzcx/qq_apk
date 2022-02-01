package com.tencent.xweb.skia_canvas.external_texture;

public abstract interface ISkiaCanvasExternalTextureController
{
  public abstract boolean load(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2);
  
  public abstract void onDestroy(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2);
  
  public abstract float[] updateImage(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt1, String paramString1, int paramInt2, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureController
 * JD-Core Version:    0.7.0.1
 */