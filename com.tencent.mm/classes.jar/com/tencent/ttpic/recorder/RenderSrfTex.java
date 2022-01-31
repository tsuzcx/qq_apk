package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.hardware.Camera.Parameters;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.WindowSurface;

@TargetApi(18)
public class RenderSrfTex
{
  private static final String TAG = RenderSrfTex.class.getSimpleName();
  private int[] alterWidths;
  private Handler handler;
  private double mAspectRatio = 0.0D;
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bcE);
  private h mCopyFrame = new h();
  private EglCore mCore;
  private int mFboTexH;
  private int mFboTexW;
  private HandlerThread mGlThread;
  private boolean mIgnoreWatermark;
  private WindowSurface mInputSurface;
  private final MyRecorder mRecorder;
  private long mSampleTimeMs = -1L;
  
  public RenderSrfTex(int paramInt1, int paramInt2, Camera.Parameters paramParameters, String paramString, int paramInt3, boolean paramBoolean)
  {
    this.mRecorder = new MyRecorder(paramParameters, paramString);
    this.mFboTexW = Math.max(paramInt1, 1);
    this.mFboTexH = Math.max(paramInt2, 1);
    if ((paramInt3 == 90) || (paramInt3 == 270))
    {
      paramInt1 = this.mFboTexW;
      this.mFboTexW = this.mFboTexH;
      this.mFboTexH = paramInt1;
    }
    this.alterWidths = new int[0];
    this.mIgnoreWatermark = paramBoolean;
  }
  
  private void initGL()
  {
    GlUtil.checkGlError("initGL_S");
    this.mCopyFilter.ApplyGLSLFilter();
    this.mCopyFilter.nativeSetRotationAndFlip(0, 0, 1);
    GlUtil.checkGlError("initGL_E");
  }
  
  public void draw(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    queue(new RenderSrfTex.1(this, paramInt));
  }
  
  public int getHeight()
  {
    return this.mFboTexH;
  }
  
  public int getWidth()
  {
    return this.mFboTexW;
  }
  
  public boolean ignoreWatermark()
  {
    return this.mIgnoreWatermark;
  }
  
  public void initGlThread(EGLContext paramEGLContext)
  {
    paramEGLContext = new RenderSrfTex.2(this, paramEGLContext);
    if (this.mGlThread == null)
    {
      this.mGlThread = new HandlerThread("VideoGlThread");
      this.mGlThread.start();
      this.handler = new Handler(this.mGlThread.getLooper());
      this.handler.post(paramEGLContext);
    }
  }
  
  public boolean prepare()
  {
    int k = this.mFboTexH;
    int j = this.mFboTexW;
    float f = k / j;
    int i = 0;
    boolean bool;
    for (;;)
    {
      bool = this.mRecorder.prepareEncoder(j, k);
      if ((bool) || (i >= this.alterWidths.length)) {
        break;
      }
      if (j > k)
      {
        k = this.alterWidths[i];
        j = (int)(k / f);
        i += 1;
      }
      else
      {
        j = this.alterWidths[i];
        k = (int)(j * f);
        i += 1;
      }
    }
    this.mFboTexW = Math.max(j, 1);
    this.mFboTexH = Math.max(k, 1);
    return bool;
  }
  
  public void queue(Runnable paramRunnable)
  {
    if (this.handler != null) {
      this.handler.post(paramRunnable);
    }
  }
  
  public void setAlternativeWidth(int[] paramArrayOfInt)
  {
    this.alterWidths = paramArrayOfInt;
  }
  
  public void setPlayRate(float paramFloat)
  {
    if (this.mRecorder != null) {
      this.mRecorder.setPlayRate(paramFloat);
    }
  }
  
  public void setSampleTime(long paramLong)
  {
    this.mSampleTimeMs = paramLong;
  }
  
  public void stop(RecorderListener paramRecorderListener)
  {
    queue(new RenderSrfTex.3(this, paramRecorderListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.recorder.RenderSrfTex
 * JD-Core Version:    0.7.0.1
 */