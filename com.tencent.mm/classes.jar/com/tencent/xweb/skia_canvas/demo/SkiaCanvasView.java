package com.tencent.xweb.skia_canvas.demo;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.util.DisplayMetrics;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.skia_canvas.XWebLibraryLoader;

public class SkiaCanvasView
{
  private static final String TAG = "SkiaCanvasView";
  private long mNativeHandler;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private long mViewID;
  
  static
  {
    AppMethodBeat.i(154253);
    XWebLibraryLoader.load("c++_shared");
    XWebLibraryLoader.load("canvas");
    XWebLibraryLoader.load("skia-canvas");
    AppMethodBeat.o(154253);
  }
  
  public SkiaCanvasView(Context paramContext, SurfaceTexture paramSurfaceTexture, long paramLong)
  {
    AppMethodBeat.i(154249);
    new StringBuilder("SkiaCanvasView created ").append(this);
    this.mNativeHandler = nativeSavePlatformContext(paramContext.getAssets(), paramContext.getResources().getDisplayMetrics().density);
    this.mViewID = paramLong;
    this.mSurfaceTexture = paramSurfaceTexture;
    this.mSurface = new Surface(paramSurfaceTexture);
    nativeSurfaceCreated(this.mNativeHandler, paramLong, this.mSurface);
    AppMethodBeat.o(154249);
  }
  
  private native long nativeSavePlatformContext(AssetManager paramAssetManager, float paramFloat);
  
  private native void nativeSurfaceCreated(long paramLong1, long paramLong2, Surface paramSurface);
  
  private native void nativeSurfaceDestroyed(long paramLong1, long paramLong2);
  
  public static String version()
  {
    return "0c91469d6075c5367e3ff051f01bd01e2bd4d2e0/1.0";
  }
  
  public void notifyTextureSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154252);
    new StringBuilder("notifyTextureSizeChanged called with ").append(paramInt1).append(" / ").append(paramInt2).append(" this: ").append(this);
    this.mSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    AppMethodBeat.o(154252);
  }
  
  public void recycle()
  {
    AppMethodBeat.i(154250);
    new StringBuilder("SkiaCanvasView recycle ").append(this);
    nativeSurfaceDestroyed(this.mNativeHandler, this.mViewID);
    AppMethodBeat.o(154250);
  }
  
  public void swapSurface(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(154251);
    new StringBuilder("SkiaCanvasView swapSurface ").append(this);
    this.mSurfaceTexture = paramSurfaceTexture;
    this.mSurface = new Surface(paramSurfaceTexture);
    nativeSurfaceCreated(this.mNativeHandler, this.mViewID, this.mSurface);
    AppMethodBeat.o(154251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.demo.SkiaCanvasView
 * JD-Core Version:    0.7.0.1
 */