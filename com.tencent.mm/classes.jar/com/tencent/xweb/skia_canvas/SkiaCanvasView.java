package com.tencent.xweb.skia_canvas;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasView
  implements VSyncRenderer.PresentCallback
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
    AppMethodBeat.i(217438);
    nativeInit();
    AppMethodBeat.o(217438);
  }
  
  public SkiaCanvasView(IXWebWorkingHandler paramIXWebWorkingHandler, final SurfaceTexture paramSurfaceTexture, String paramString, long paramLong)
  {
    AppMethodBeat.i(217431);
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
        AppMethodBeat.i(217427);
        VSyncRenderer.initRenderer(SkiaCanvasView.this.mWorkingHandler);
        SkiaCanvasView.access$102(SkiaCanvasView.this, paramSurfaceTexture);
        SkiaCanvasView.access$202(SkiaCanvasView.this, new Surface(paramSurfaceTexture));
        SkiaCanvasView.access$500(SkiaCanvasView.this, SkiaCanvasView.this.mAppTag, SkiaCanvasView.this.mViewID, SkiaCanvasView.this.mSurface);
        VSyncRenderer.getInstance().addPresentCallback(SkiaCanvasView.this);
        AppMethodBeat.o(217427);
      }
    });
    AppMethodBeat.o(217431);
  }
  
  private void checkAndPost(Runnable paramRunnable)
  {
    AppMethodBeat.i(217433);
    if (isRunOnWorkingThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(217433);
      return;
    }
    this.mWorkingHandler.post(paramRunnable);
    AppMethodBeat.o(217433);
  }
  
  private boolean isRunOnWorkingThread()
  {
    AppMethodBeat.i(217434);
    boolean bool = this.mWorkingHandler.isRunOnWorkingThread();
    AppMethodBeat.o(217434);
    return bool;
  }
  
  private native void nativeCreateCanvas(String paramString, long paramLong, Surface paramSurface);
  
  private native void nativeDoPresent(long paramLong);
  
  private static native void nativeInit();
  
  private native void nativeRemoveCanvas(long paramLong);
  
  private native void nativeSwapSurface(long paramLong, Surface paramSurface);
  
  public static String version()
  {
    return "c39e57a2b772d2be33833196ca1f8705cb421b87/1.0";
  }
  
  public void doPresent()
  {
    AppMethodBeat.i(217432);
    nativeDoPresent(this.mViewID);
    AppMethodBeat.o(217432);
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
        AppMethodBeat.i(217430);
        new StringBuilder("notifyTextureSizeChanged called with ").append(paramInt1).append(" / ").append(paramInt2).append(" this: ").append(SkiaCanvasView.this);
        SkiaCanvasView.access$702(SkiaCanvasView.this, paramInt1);
        SkiaCanvasView.access$802(SkiaCanvasView.this, paramInt2);
        SkiaCanvasView.this.mSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
        AppMethodBeat.o(217430);
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
        AppMethodBeat.i(217428);
        new StringBuilder("SkiaCanvasView recycle ").append(SkiaCanvasView.this);
        SkiaCanvasView.access$600(SkiaCanvasView.this, SkiaCanvasView.this.mViewID);
        AppMethodBeat.o(217428);
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
        AppMethodBeat.i(217429);
        new StringBuilder("SkiaCanvasView swapSurface ").append(SkiaCanvasView.this);
        SkiaCanvasView.access$102(SkiaCanvasView.this, paramSurfaceTexture);
        SkiaCanvasView.this.mSurfaceTexture.setDefaultBufferSize(SkiaCanvasView.this.mWidth, SkiaCanvasView.this.mHeight);
        SkiaCanvasView.access$202(SkiaCanvasView.this, new Surface(paramSurfaceTexture));
        SkiaCanvasView.access$900(SkiaCanvasView.this, SkiaCanvasView.this.mViewID, SkiaCanvasView.this.mSurface);
        AppMethodBeat.o(217429);
      }
    });
    AppMethodBeat.o(4297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasView
 * JD-Core Version:    0.7.0.1
 */