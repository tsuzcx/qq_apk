package com.tencent.ttpic.thread;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.filter.ExpFilter;
import com.tencent.ttpic.filter.FabbyExtractFilter;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.filter.SimpleGaussionFilter;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.OffscreenSurface;
import com.tencent.ttpic.gles.SegmentDataPipe;

@TargetApi(18)
public class SegmentGLThread
{
  private static final int SEGMENT_HEIGHT;
  private static final int SEGMENT_WIDTH;
  private ExpFilter expFilter;
  private FabbyExtractFilter fabbyExtractFilter;
  private FabbyStrokeFilter fabbyStrokeFilter;
  private BaseFilter mCopyFilter;
  private h mCopyFrame;
  private EglCore mCore;
  private Handler mHandler;
  private boolean mIsInitReady;
  private SegmentGLThread.OnSegDataReadyListener mListener;
  private Bitmap mMaskBitmap;
  private Bitmap mMaskBitmapHorizon;
  private OffscreenSurface mOffscreenSurface;
  private boolean mRunOnCpuForce;
  private Bitmap mSegBitmap;
  private Bitmap mSegBitmapHorizon;
  private h mSegFrame;
  private SimpleGaussionFilter mSimpleBlurFilter;
  private h mTempFrame;
  private int[] mTempTexId;
  private GLSegSharedData sharedData;
  
  static
  {
    int i = 16;
    boolean bool = FabbyManager.USE_SMALL_IMAGE;
    SEGMENT_WIDTH = 16;
    if (FabbyManager.USE_SMALL_IMAGE) {}
    for (;;)
    {
      SEGMENT_HEIGHT = i;
      return;
      i = 32;
    }
  }
  
  public SegmentGLThread(EGLContext paramEGLContext)
  {
    AppMethodBeat.i(83779);
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.fabbyExtractFilter = new FabbyExtractFilter();
    this.fabbyStrokeFilter = new FabbyStrokeFilter();
    this.mSimpleBlurFilter = new SimpleGaussionFilter();
    this.mTempTexId = new int[2];
    this.expFilter = new ExpFilter();
    HandlerThread localHandlerThread = new HandlerThread("SegmentGLThread");
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper());
    this.mHandler.post(new SegmentGLThread.1(this, paramEGLContext));
    AppMethodBeat.o(83779);
  }
  
  private void setAllRenderMode(int paramInt)
  {
    AppMethodBeat.i(83784);
    this.fabbyExtractFilter.setRenderMode(paramInt);
    this.fabbyStrokeFilter.setRenderMode(paramInt);
    this.expFilter.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
    AppMethodBeat.o(83784);
  }
  
  public void clearSegLig()
  {
    AppMethodBeat.i(83787);
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(83778);
          FabbyManager.getInstance().clearSegmentBuffer();
          AppMethodBeat.o(83778);
        }
      });
    }
    AppMethodBeat.o(83787);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(83782);
    if (this.mHandler != null) {
      this.mHandler.post(new SegmentGLThread.3(this));
    }
    AppMethodBeat.o(83782);
  }
  
  public SegmentDataPipe getCurrentDataPipe()
  {
    AppMethodBeat.i(83781);
    if (this.sharedData == null)
    {
      AppMethodBeat.o(83781);
      return null;
    }
    SegmentDataPipe localSegmentDataPipe = this.sharedData.getCurrentTexturePile();
    AppMethodBeat.o(83781);
    return localSegmentDataPipe;
  }
  
  public void initSegLig()
  {
    AppMethodBeat.i(83786);
    if (this.mHandler != null) {
      this.mHandler.post(new SegmentGLThread.5(this));
    }
    AppMethodBeat.o(83786);
  }
  
  public boolean isInitReady()
  {
    return this.mIsInitReady;
  }
  
  public boolean needWait()
  {
    AppMethodBeat.i(83783);
    if (this.sharedData == null)
    {
      AppMethodBeat.o(83783);
      return true;
    }
    SegmentDataPipe[] arrayOfSegmentDataPipe = this.sharedData.mTexturePile;
    int j = arrayOfSegmentDataPipe.length;
    int i = 0;
    while (i < j)
    {
      SegmentDataPipe localSegmentDataPipe = arrayOfSegmentDataPipe[i];
      if ((localSegmentDataPipe.isBusy()) || (localSegmentDataPipe.isReady()))
      {
        AppMethodBeat.o(83783);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(83783);
    return false;
  }
  
  public void postSegJob(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(83780);
    if (this.mHandler == null)
    {
      AppMethodBeat.o(83780);
      return;
    }
    this.mHandler.post(new SegmentGLThread.2(this, paramBoolean, paramh));
    AppMethodBeat.o(83780);
  }
  
  public void reset()
  {
    AppMethodBeat.i(83785);
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(83776);
          SegmentGLThread.this.sharedData.reset();
          AppMethodBeat.o(83776);
        }
      });
    }
    AppMethodBeat.o(83785);
  }
  
  public void setOnDataReadyListener(SegmentGLThread.OnSegDataReadyListener paramOnSegDataReadyListener)
  {
    this.mListener = paramOnSegDataReadyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread
 * JD-Core Version:    0.7.0.1
 */