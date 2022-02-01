package com.tencent.xweb.skia_canvas;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasView
{
  private static final String TAG = "SkiaCanvasView";
  private final String mAppTag;
  private int mHeight;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private final long mViewID;
  private int mWidth;
  private final IXWebWorkingHandler mWorkingHandler;
  
  static
  {
    AppMethodBeat.i(189673);
    nativeInit();
    AppMethodBeat.o(189673);
  }
  
  public SkiaCanvasView(IXWebWorkingHandler paramIXWebWorkingHandler, final SurfaceTexture paramSurfaceTexture, String paramString, long paramLong)
  {
    AppMethodBeat.i(189667);
    this.mWidth = 300;
    this.mHeight = 150;
    new StringBuilder("SkiaCanvasView created ").append(this);
    this.mWorkingHandler = paramIXWebWorkingHandler;
    this.mAppTag = paramString;
    this.mViewID = paramLong;
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(189663);
        SkiaCanvasView.access$002(SkiaCanvasView.this, paramSurfaceTexture);
        SkiaCanvasView.access$102(SkiaCanvasView.this, new Surface(paramSurfaceTexture));
        SkiaCanvasView.access$400(SkiaCanvasView.this, SkiaCanvasView.this.mAppTag, SkiaCanvasView.this.mViewID, SkiaCanvasView.this.mSurface);
        AppMethodBeat.o(189663);
      }
    });
    AppMethodBeat.o(189667);
  }
  
  private void checkAndPost(Runnable paramRunnable)
  {
    AppMethodBeat.i(189668);
    if (isRunOnWorkingThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(189668);
      return;
    }
    this.mWorkingHandler.post(paramRunnable);
    AppMethodBeat.o(189668);
  }
  
  private boolean isRunOnWorkingThread()
  {
    AppMethodBeat.i(189669);
    boolean bool = this.mWorkingHandler.isRunOnWorkingThread();
    AppMethodBeat.o(189669);
    return bool;
  }
  
  private native void nativeCreateCanvas(String paramString, long paramLong, Surface paramSurface);
  
  private static native void nativeInit();
  
  private native void nativeRemoveCanvas(long paramLong);
  
  private native void nativeSwapSurface(long paramLong, Surface paramSurface);
  
  public static String version()
  {
    return "0349885a96bdb6e210b2acb6eb7dd7ca0a35db22/1.0";
  }
  
  public long getId()
  {
    return this.mViewID;
  }
  
  public void notifyTextureSizeChanged(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(4298);
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(189666);
        new StringBuilder("notifyTextureSizeChanged called with ").append(paramInt1).append(" / ").append(paramInt2).append(" this: ").append(this);
        SkiaCanvasView.access$602(SkiaCanvasView.this, paramInt1);
        SkiaCanvasView.access$702(SkiaCanvasView.this, paramInt2);
        SkiaCanvasView.this.mSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
        AppMethodBeat.o(189666);
      }
    });
    AppMethodBeat.o(4298);
  }
  
  public void recycle()
  {
    AppMethodBeat.i(4296);
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(189664);
        new StringBuilder("SkiaCanvasView recycle ").append(this);
        SkiaCanvasView.access$500(SkiaCanvasView.this, SkiaCanvasView.this.mViewID);
        AppMethodBeat.o(189664);
      }
    });
    AppMethodBeat.o(4296);
  }
  
  public void swapSurface(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(4297);
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(189665);
        new StringBuilder("SkiaCanvasView swapSurface ").append(this);
        SkiaCanvasView.access$002(SkiaCanvasView.this, paramSurfaceTexture);
        SkiaCanvasView.this.mSurfaceTexture.setDefaultBufferSize(SkiaCanvasView.this.mWidth, SkiaCanvasView.this.mHeight);
        SkiaCanvasView.access$102(SkiaCanvasView.this, new Surface(paramSurfaceTexture));
        SkiaCanvasView.access$800(SkiaCanvasView.this, SkiaCanvasView.this.mViewID, SkiaCanvasView.this.mSurface);
        AppMethodBeat.o(189665);
      }
    });
    AppMethodBeat.o(4297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasView
 * JD-Core Version:    0.7.0.1
 */