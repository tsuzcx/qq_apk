package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExternalTextureHandler
  implements ISkiaCanvasExternalTextureHandler
{
  private volatile boolean mIsDestroyed;
  private volatile long mNativePeer;
  
  private ExternalTextureHandler(long paramLong)
  {
    this.mNativePeer = paramLong;
  }
  
  public static ExternalTextureHandler create(long paramLong)
  {
    AppMethodBeat.i(4313);
    ExternalTextureHandler localExternalTextureHandler = new ExternalTextureHandler(paramLong);
    AppMethodBeat.o(4313);
    return localExternalTextureHandler;
  }
  
  private boolean isValid()
  {
    return !this.mIsDestroyed;
  }
  
  private boolean load(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(174305);
    boolean bool = SkiaCanvasExternalTextureManager.getInstance().load(this, paramString1, paramInt, paramString2);
    AppMethodBeat.o(174305);
    return bool;
  }
  
  private native void nativeOnFrameAvailable(long paramLong);
  
  private native void nativeOnLoad(long paramLong, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2);
  
  private void notifyDestroyed(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      AppMethodBeat.i(174308);
      onDestroy(paramString1, paramInt, paramString2);
      this.mIsDestroyed = true;
      AppMethodBeat.o(174308);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private void onDestroy(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(174307);
    SkiaCanvasExternalTextureManager.getInstance().onDestroy(this, paramString1, paramInt, paramString2);
    AppMethodBeat.o(174307);
  }
  
  private float[] updateImage(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(174306);
    paramString1 = SkiaCanvasExternalTextureManager.getInstance().updateImage(this, paramInt1, paramString1, paramInt2, paramString2);
    AppMethodBeat.o(174306);
    return paramString1;
  }
  
  public void onFrameAvailable()
  {
    try
    {
      AppMethodBeat.i(4314);
      if (isValid()) {
        nativeOnFrameAvailable(this.mNativePeer);
      }
      AppMethodBeat.o(4314);
      return;
    }
    finally {}
  }
  
  public void onLoad(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4315);
    if (isValid()) {
      nativeOnLoad(this.mNativePeer, paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(4315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.ExternalTextureHandler
 * JD-Core Version:    0.7.0.1
 */