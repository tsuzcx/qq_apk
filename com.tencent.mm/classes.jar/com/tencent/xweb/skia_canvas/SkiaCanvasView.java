package com.tencent.xweb.skia_canvas;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasView
  implements VSyncRenderer.PresentCallback
{
  private static final String TAG = "SkiaCanvasView";
  private final SkiaCanvasApp mApp;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private final String mTag;
  private final long mViewID;
  
  public SkiaCanvasView(SkiaCanvasApp paramSkiaCanvasApp, final SurfaceTexture paramSurfaceTexture, String paramString, long paramLong)
  {
    AppMethodBeat.i(218230);
    new StringBuilder("SkiaCanvasView created ").append(this);
    this.mApp = paramSkiaCanvasApp;
    this.mTag = paramString;
    this.mViewID = paramLong;
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(218227);
        SkiaCanvasView.access$002(SkiaCanvasView.this, paramSurfaceTexture);
        SkiaCanvasView.access$102(SkiaCanvasView.this, new Surface(paramSurfaceTexture));
        SkiaCanvasView.access$400(SkiaCanvasView.this, SkiaCanvasView.this.mTag, SkiaCanvasView.this.mViewID, SkiaCanvasView.this.mSurface);
        VSyncRenderer.getInstance().addPresentCallback(SkiaCanvasView.this);
        AppMethodBeat.o(218227);
      }
    });
    AppMethodBeat.o(218230);
  }
  
  private void checkAndPost(Runnable paramRunnable)
  {
    AppMethodBeat.i(218232);
    this.mApp.checkAndPostOnWorkingThread(paramRunnable);
    AppMethodBeat.o(218232);
  }
  
  private native void nativeCreateCanvas(String paramString, long paramLong, Surface paramSurface);
  
  private native void nativeDoPresent(long paramLong);
  
  private native void nativeRemoveCanvas(long paramLong);
  
  private native void nativeSwapSurface(long paramLong, Surface paramSurface);
  
  private void notifyTextureSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4298);
    if (!this.mApp.isRunOnWorkingThread())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("notifyTextureSizeChanged must be called.");
      AppMethodBeat.o(4298);
      throw localIllegalStateException;
    }
    new StringBuilder("notifyTextureSizeChanged called with ").append(paramInt1).append(" / ").append(paramInt2).append(" this: ").append(this);
    this.mSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    AppMethodBeat.o(4298);
  }
  
  public static String version()
  {
    return "c074ade02b6179ccfd3ca3f546f56c32ea0aa828/1.0";
  }
  
  public void doPresent()
  {
    AppMethodBeat.i(218231);
    nativeDoPresent(this.mViewID);
    AppMethodBeat.o(218231);
  }
  
  public long getId()
  {
    return this.mViewID;
  }
  
  public void recycle()
  {
    AppMethodBeat.i(4296);
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(218228);
        new StringBuilder("SkiaCanvasView recycle ").append(SkiaCanvasView.this);
        SkiaCanvasView.access$500(SkiaCanvasView.this, SkiaCanvasView.this.mViewID);
        AppMethodBeat.o(218228);
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
        AppMethodBeat.i(218229);
        new StringBuilder("SkiaCanvasView swapSurface ").append(SkiaCanvasView.this);
        if (paramSurfaceTexture != SkiaCanvasView.this.mSurfaceTexture)
        {
          SkiaCanvasView.access$002(SkiaCanvasView.this, paramSurfaceTexture);
          SkiaCanvasView.access$102(SkiaCanvasView.this, new Surface(paramSurfaceTexture));
          SkiaCanvasView.access$600(SkiaCanvasView.this, SkiaCanvasView.this.mViewID, SkiaCanvasView.this.mSurface);
        }
        AppMethodBeat.o(218229);
      }
    });
    AppMethodBeat.o(4297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasView
 * JD-Core Version:    0.7.0.1
 */