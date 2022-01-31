package com.tencent.ttpic.thread;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.ttpic.filter.ExpFilter;
import com.tencent.ttpic.filter.FabbyExtractFilter;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.filter.SimpleGaussionFilter;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.OffscreenSurface;
import com.tencent.ttpic.gles.OnSegDataReadyListener;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.util.FabbyManager;

@TargetApi(18)
public class SegmentGLThread
{
  private static final int SEGMENT_HEIGHT;
  private static final int SEGMENT_WIDTH = 16;
  private ExpFilter expFilter = new ExpFilter();
  private FabbyExtractFilter fabbyExtractFilter = new FabbyExtractFilter();
  private FabbyStrokeFilter fabbyStrokeFilter = new FabbyStrokeFilter();
  private OnSegDataReadyListener listener;
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bcE);
  private h mCopyFrame;
  private EglCore mCore;
  private Handler mHandler;
  private Bitmap mMaskBitmap;
  private Bitmap mMaskBitmapHorizon;
  private OffscreenSurface mOffscreenSurface;
  private boolean mRunOnCpuForce;
  private Bitmap mSegBitmap;
  private Bitmap mSegBitmapHorizon;
  private h mSegFrame;
  private SimpleGaussionFilter mSimpleBlurFilter = new SimpleGaussionFilter();
  private h mTempFrame;
  private int[] mTempTexId = new int[2];
  private GLSegSharedData sharedData;
  
  static
  {
    if (FabbyManager.USE_SMALL_IMAGE) {}
    for (int i = 16;; i = 32)
    {
      SEGMENT_HEIGHT = i;
      return;
    }
  }
  
  public SegmentGLThread(EGLContext paramEGLContext)
  {
    HandlerThread localHandlerThread = new HandlerThread("OffscreenGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper());
    this.mHandler.post(new SegmentGLThread.1(this, paramEGLContext));
  }
  
  private void setAllRenderMode(int paramInt)
  {
    this.fabbyExtractFilter.setRenderMode(paramInt);
    this.fabbyStrokeFilter.setRenderMode(paramInt);
    this.expFilter.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public void clearSegLig()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new SegmentGLThread.6(this));
    }
  }
  
  public void destroy()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new SegmentGLThread.3(this));
    }
  }
  
  public SegmentDataPipe getCurrentDataPipe()
  {
    if (this.sharedData == null) {
      return null;
    }
    return this.sharedData.getCurrentTexturePile();
  }
  
  public void initSegLig()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new SegmentGLThread.5(this));
    }
  }
  
  public boolean needWait()
  {
    if (this.sharedData == null) {
      return true;
    }
    SegmentDataPipe[] arrayOfSegmentDataPipe = this.sharedData.mTexturePile;
    int j = arrayOfSegmentDataPipe.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label55;
      }
      SegmentDataPipe localSegmentDataPipe = arrayOfSegmentDataPipe[i];
      if ((localSegmentDataPipe.isBusy()) || (localSegmentDataPipe.isReady())) {
        break;
      }
      i += 1;
    }
    label55:
    return false;
  }
  
  public void postSegJob(h paramh, boolean paramBoolean)
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(new SegmentGLThread.2(this, paramBoolean, paramh));
  }
  
  public void reset()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new SegmentGLThread.4(this));
    }
  }
  
  public void setOnDataReadyListener(OnSegDataReadyListener paramOnSegDataReadyListener)
  {
    this.listener = paramOnSegDataReadyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread
 * JD-Core Version:    0.7.0.1
 */