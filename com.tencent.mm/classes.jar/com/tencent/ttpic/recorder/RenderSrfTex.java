package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.WindowSurface;

@TargetApi(18)
public class RenderSrfTex
{
  private static final String TAG;
  private int[] alterWidths;
  private Handler handler;
  private double mAspectRatio;
  private BaseFilter mCopyFilter;
  private h mCopyFrame;
  private EglCore mCore;
  private int mFboTexH;
  private int mFboTexW;
  private HandlerThread mGlThread;
  private boolean mIgnoreWatermark;
  private WindowSurface mInputSurface;
  private final MyRecorder mRecorder;
  private long mSampleTimeMs;
  
  static
  {
    AppMethodBeat.i(83719);
    TAG = RenderSrfTex.class.getSimpleName();
    AppMethodBeat.o(83719);
  }
  
  public RenderSrfTex(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(83710);
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mCopyFrame = new h();
    this.mAspectRatio = 0.0D;
    this.mSampleTimeMs = -1L;
    this.mRecorder = new MyRecorder(paramString);
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
    AppMethodBeat.o(83710);
  }
  
  private void initGL()
  {
    AppMethodBeat.i(83713);
    GlUtil.checkGlError("initGL_S");
    this.mCopyFilter.ApplyGLSLFilter();
    this.mCopyFilter.nativeSetRotationAndFlip(0, 0, 1);
    GlUtil.checkGlError("initGL_E");
    AppMethodBeat.o(83713);
  }
  
  public void draw(int paramInt)
  {
    AppMethodBeat.i(83712);
    if (paramInt < 0)
    {
      AppMethodBeat.o(83712);
      return;
    }
    queue(new RenderSrfTex.1(this, paramInt));
    AppMethodBeat.o(83712);
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
    AppMethodBeat.i(83714);
    paramEGLContext = new RenderSrfTex.2(this, paramEGLContext);
    if (this.mGlThread == null)
    {
      this.mGlThread = new HandlerThread("VideoGlThread");
      this.mGlThread.start();
      this.handler = new Handler(this.mGlThread.getLooper());
      this.handler.post(paramEGLContext);
    }
    AppMethodBeat.o(83714);
  }
  
  public boolean prepare()
  {
    AppMethodBeat.i(83711);
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
    AppMethodBeat.o(83711);
    return bool;
  }
  
  public void queue(Runnable paramRunnable)
  {
    AppMethodBeat.i(83715);
    if (this.handler != null) {
      this.handler.post(paramRunnable);
    }
    AppMethodBeat.o(83715);
  }
  
  public void setAlternativeWidth(int[] paramArrayOfInt)
  {
    this.alterWidths = paramArrayOfInt;
  }
  
  public void setPlayRate(float paramFloat)
  {
    AppMethodBeat.i(83717);
    if (this.mRecorder != null) {
      this.mRecorder.setPlayRate(paramFloat);
    }
    AppMethodBeat.o(83717);
  }
  
  public void setSampleTime(long paramLong)
  {
    this.mSampleTimeMs = paramLong;
  }
  
  public void stop(VideoRecorderListener paramVideoRecorderListener)
  {
    AppMethodBeat.i(83716);
    queue(new RenderSrfTex.3(this, paramVideoRecorderListener));
    AppMethodBeat.o(83716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.recorder.RenderSrfTex
 * JD-Core Version:    0.7.0.1
 */