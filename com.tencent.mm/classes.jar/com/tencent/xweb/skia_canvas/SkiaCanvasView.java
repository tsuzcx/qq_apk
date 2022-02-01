package com.tencent.xweb.skia_canvas;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
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
  private SurfaceTexture mSurfaceTexture;
  private final String mTag;
  private final long mViewID;
  
  public SkiaCanvasView(SkiaCanvasApp paramSkiaCanvasApp, final SurfaceTexture paramSurfaceTexture, String paramString, long paramLong)
  {
    AppMethodBeat.i(196717);
    new StringBuilder("SkiaCanvasView created ").append(this);
    this.mApp = paramSkiaCanvasApp;
    this.mTag = paramString;
    this.mViewID = paramLong;
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(196703);
        SkiaCanvasView.access$002(SkiaCanvasView.this, paramSurfaceTexture);
        SkiaCanvasView.access$102(SkiaCanvasView.this, new Surface(paramSurfaceTexture));
        SkiaCanvasView.access$400(SkiaCanvasView.this, SkiaCanvasView.this.mTag, SkiaCanvasView.this.mViewID, SkiaCanvasView.this.mSurface);
        SkiaCanvasView.access$502(SkiaCanvasView.this, true);
        VSyncRenderer.getInstance().addPresentCallback(SkiaCanvasView.this);
        AppMethodBeat.o(196703);
      }
    });
    AppMethodBeat.o(196717);
  }
  
  private void checkAndPost(Runnable paramRunnable)
  {
    AppMethodBeat.i(196723);
    this.mApp.checkAndPostOnWorkingThread(paramRunnable);
    AppMethodBeat.o(196723);
  }
  
  private native void nativeCreateCanvas(String paramString, long paramLong, Surface paramSurface);
  
  private native void nativeDoPresent(long paramLong, boolean paramBoolean);
  
  private native void nativeRemoveCanvas(long paramLong);
  
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
    this.mSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    AppMethodBeat.o(4298);
  }
  
  public static String version()
  {
    return "d84591d74013a08f28eed8de85a6468d4b1758f1/1.0";
  }
  
  public void doPresent()
  {
    AppMethodBeat.i(196720);
    if (this.mIsForeground)
    {
      nativeDoPresent(this.mViewID, this.mHasSurfaceSwapped);
      this.mHasSurfaceSwapped = false;
      VSyncRenderer.getInstance().triggerNextVSync();
    }
    AppMethodBeat.o(196720);
  }
  
  public long getId()
  {
    return this.mViewID;
  }
  
  public Bitmap getSnapshot(Rect paramRect)
  {
    AppMethodBeat.i(196730);
    if (!this.mApp.isRunOnWorkingThread())
    {
      paramRect = new IllegalStateException("getSnapshot must be called on js thread.");
      AppMethodBeat.o(196730);
      throw paramRect;
    }
    if ((paramRect.width() <= 0) || (paramRect.height() <= 0))
    {
      AppMethodBeat.o(196730);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramRect.width(), paramRect.height(), Bitmap.Config.ARGB_8888);
    if (nativeUpdateBitmap(this.mViewID, localBitmap, paramRect.left, paramRect.top, paramRect.width(), paramRect.height()))
    {
      AppMethodBeat.o(196730);
      return localBitmap;
    }
    AppMethodBeat.o(196730);
    return null;
  }
  
  public void notifyVisibilityChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(196722);
    if (paramBoolean != this.mIsForeground)
    {
      this.mIsForeground = paramBoolean;
      if (paramBoolean) {
        checkAndPost(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(196705);
            VSyncRenderer.getInstance().triggerNextVSync();
            AppMethodBeat.o(196705);
          }
        });
      }
    }
    AppMethodBeat.o(196722);
  }
  
  public void recycle()
  {
    AppMethodBeat.i(4296);
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(196707);
        new StringBuilder("SkiaCanvasView recycle ").append(SkiaCanvasView.this);
        SkiaCanvasView.access$600(SkiaCanvasView.this, SkiaCanvasView.this.mViewID);
        VSyncRenderer.getInstance().removePresentCallback(SkiaCanvasView.this);
        AppMethodBeat.o(196707);
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
        AppMethodBeat.i(196711);
        new StringBuilder("SkiaCanvasView swapSurface ").append(SkiaCanvasView.this).append(" old one is ").append(SkiaCanvasView.this.mSurfaceTexture).append(" new  one is ").append(paramSurfaceTexture);
        if (paramSurfaceTexture != SkiaCanvasView.this.mSurfaceTexture)
        {
          SkiaCanvasView.access$002(SkiaCanvasView.this, paramSurfaceTexture);
          SkiaCanvasView.access$102(SkiaCanvasView.this, new Surface(paramSurfaceTexture));
          SkiaCanvasView.access$700(SkiaCanvasView.this, SkiaCanvasView.this.mViewID, SkiaCanvasView.this.mSurface);
          SkiaCanvasView.access$802(SkiaCanvasView.this, true);
        }
        AppMethodBeat.o(196711);
      }
    });
    AppMethodBeat.o(4297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasView
 * JD-Core Version:    0.7.0.1
 */