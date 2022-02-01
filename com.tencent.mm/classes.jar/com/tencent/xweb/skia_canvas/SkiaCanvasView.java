package com.tencent.xweb.skia_canvas;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasView
  implements VSyncRenderer.PresentCallback
{
  private static final String TAG = "SkiaCanvasView";
  private final SkiaCanvasApp mApp;
  private boolean mHasSurfaceSwapped;
  private volatile boolean mIsForeground;
  private Surface mSurface;
  private final String mTag;
  private final long mViewID;
  
  public SkiaCanvasView(SkiaCanvasApp paramSkiaCanvasApp, final Surface paramSurface, String paramString, long paramLong)
  {
    AppMethodBeat.i(213743);
    new StringBuilder("SkiaCanvasView created ").append(this);
    this.mApp = paramSkiaCanvasApp;
    this.mTag = paramString;
    this.mViewID = paramLong;
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(213746);
        SkiaCanvasView.access$002(SkiaCanvasView.this, paramSurface);
        SkiaCanvasView.access$300(SkiaCanvasView.this, SkiaCanvasView.this.mTag, SkiaCanvasView.this.mViewID, paramSurface);
        SkiaCanvasView.access$402(SkiaCanvasView.this, true);
        VSyncRenderer.getInstance().addPresentCallback(SkiaCanvasView.this);
        AppMethodBeat.o(213746);
      }
    });
    AppMethodBeat.o(213743);
  }
  
  private void checkAndPost(Runnable paramRunnable)
  {
    AppMethodBeat.i(213755);
    this.mApp.checkAndPostOnWorkingThread(paramRunnable);
    AppMethodBeat.o(213755);
  }
  
  private native void nativeCreateCanvas(String paramString, long paramLong, Surface paramSurface);
  
  private native void nativeDoPresent(long paramLong, boolean paramBoolean);
  
  private native void nativeRemoveCanvas(long paramLong);
  
  private static native void nativeSetSurfaceSize(Surface paramSurface, int paramInt1, int paramInt2);
  
  private native void nativeSwapSurface(long paramLong, Surface paramSurface);
  
  private native boolean nativeUpdateBitmap(long paramLong, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private void notifyTextureSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4298);
    if (!this.mApp.isRunOnWorkingThread())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("notifyTextureSizeChanged must be called on js thread.");
      AppMethodBeat.o(4298);
      throw localIllegalStateException;
    }
    new StringBuilder("notifyTextureSizeChanged called with ").append(paramInt1).append(" / ").append(paramInt2).append(" this: ").append(this);
    setSurfaceSize(this.mSurface, paramInt1, paramInt2);
    AppMethodBeat.o(4298);
  }
  
  public static void setSurfaceSize(Surface paramSurface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213770);
    nativeSetSurfaceSize(paramSurface, paramInt1, paramInt2);
    AppMethodBeat.o(213770);
  }
  
  public static String version()
  {
    return "8760a8553179fae41069f6eb877e4c6ffb2fbc7c/1.0";
  }
  
  public void doPresent()
  {
    AppMethodBeat.i(213905);
    if (this.mIsForeground)
    {
      nativeDoPresent(this.mViewID, this.mHasSurfaceSwapped);
      this.mHasSurfaceSwapped = false;
      VSyncRenderer.getInstance().triggerNextVSync();
    }
    AppMethodBeat.o(213905);
  }
  
  public long getId()
  {
    return this.mViewID;
  }
  
  public Bitmap getSnapshot(Rect paramRect)
  {
    AppMethodBeat.i(213935);
    if (!this.mApp.isRunOnWorkingThread())
    {
      paramRect = new IllegalStateException("getSnapshot must be called on js thread.");
      AppMethodBeat.o(213935);
      throw paramRect;
    }
    if ((paramRect.width() <= 0) || (paramRect.height() <= 0))
    {
      AppMethodBeat.o(213935);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramRect.width(), paramRect.height(), Bitmap.Config.ARGB_8888);
    if (nativeUpdateBitmap(this.mViewID, localBitmap, paramRect.left, paramRect.top, paramRect.width(), paramRect.height()))
    {
      AppMethodBeat.o(213935);
      return localBitmap;
    }
    AppMethodBeat.o(213935);
    return null;
  }
  
  public void notifyVisibilityChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(213911);
    if (paramBoolean != this.mIsForeground)
    {
      this.mIsForeground = paramBoolean;
      if (paramBoolean) {
        checkAndPost(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(213719);
            VSyncRenderer.getInstance().triggerNextVSync();
            AppMethodBeat.o(213719);
          }
        });
      }
    }
    AppMethodBeat.o(213911);
  }
  
  public void recycle()
  {
    AppMethodBeat.i(4296);
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(213716);
        new StringBuilder("SkiaCanvasView recycle ").append(SkiaCanvasView.this);
        SkiaCanvasView.access$500(SkiaCanvasView.this, SkiaCanvasView.this.mViewID);
        VSyncRenderer.getInstance().removePresentCallback(SkiaCanvasView.this);
        AppMethodBeat.o(213716);
      }
    });
    AppMethodBeat.o(4296);
  }
  
  public void swapSurface(final Surface paramSurface)
  {
    AppMethodBeat.i(213924);
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(213713);
        new StringBuilder("SkiaCanvasView swapSurface ").append(SkiaCanvasView.this).append(" old one is ").append(SkiaCanvasView.this.mSurface).append(" new  one is ").append(paramSurface);
        if (paramSurface != SkiaCanvasView.this.mSurface)
        {
          SkiaCanvasView.access$002(SkiaCanvasView.this, paramSurface);
          SkiaCanvasView.access$600(SkiaCanvasView.this, SkiaCanvasView.this.mViewID, SkiaCanvasView.this.mSurface);
          SkiaCanvasView.access$702(SkiaCanvasView.this, true);
        }
        AppMethodBeat.o(213713);
      }
    });
    AppMethodBeat.o(213924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasView
 * JD-Core Version:    0.7.0.1
 */