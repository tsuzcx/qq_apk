package com.tencent.ttpic;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.ApiHelper;
import com.tencent.ttpic.device.DeviceInstance;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.fabby.FabbyUtil;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.thread.SegmentGLThread;
import com.tencent.ttpic.util.FrameUtil;

public class PTSegmentor
{
  private static final ThreadLocal<PTSegmentor> INSTANCE;
  private static String[] NOT_SUPPORT_DEVICE;
  private boolean firstSeg;
  private volatile SegmentDataPipe mDetDataPipe;
  private BaseFilter mRotateFilter;
  private h mRotateFrame;
  private SegmentGLThread mSegGLThread;
  private final Object mSegmentLock;
  
  static
  {
    AppMethodBeat.i(81609);
    INSTANCE = new ThreadLocal()
    {
      protected final PTSegmentor initialValue()
      {
        AppMethodBeat.i(81597);
        PTSegmentor localPTSegmentor = new PTSegmentor();
        AppMethodBeat.o(81597);
        return localPTSegmentor;
      }
    };
    NOT_SUPPORT_DEVICE = new String[] { "QIHOO_1503-A01" };
    AppMethodBeat.o(81609);
  }
  
  public PTSegmentor()
  {
    AppMethodBeat.i(81600);
    this.mRotateFilter = new BaseFilter(GLSLRender.btg);
    this.mRotateFrame = new h();
    this.mSegmentLock = new Object();
    AppMethodBeat.o(81600);
  }
  
  private PTSegAttr genSegAttr(h paramh)
  {
    AppMethodBeat.i(81607);
    PTSegAttr localPTSegAttr = new PTSegAttr();
    localPTSegAttr.setMaskFrame(paramh);
    AppMethodBeat.o(81607);
    return localPTSegAttr;
  }
  
  public static PTSegmentor getInstance()
  {
    AppMethodBeat.i(81601);
    PTSegmentor localPTSegmentor = (PTSegmentor)INSTANCE.get();
    AppMethodBeat.o(81601);
    return localPTSegmentor;
  }
  
  private boolean inBlackList(String paramString)
  {
    AppMethodBeat.i(81603);
    String[] arrayOfString = NOT_SUPPORT_DEVICE;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString))
      {
        AppMethodBeat.o(81603);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(81603);
    return false;
  }
  
  private void setDataPipe(SegmentDataPipe paramSegmentDataPipe)
  {
    AppMethodBeat.i(81604);
    synchronized (this.mSegmentLock)
    {
      this.mDetDataPipe = paramSegmentDataPipe;
      this.mSegmentLock.notifyAll();
      AppMethodBeat.o(81604);
      return;
    }
  }
  
  public void destroy()
  {
    AppMethodBeat.i(81605);
    this.mRotateFilter.ClearGLSL();
    this.mRotateFrame.clear();
    if (this.mSegGLThread != null)
    {
      this.mSegGLThread.destroy();
      this.mSegGLThread = null;
    }
    AppMethodBeat.o(81605);
  }
  
  public PTSegAttr detectFrame(h paramh, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(81606);
    if ((this.mSegGLThread != null) && (this.mSegGLThread.isInitReady()) && (paramBoolean) && (FabbyManager.getInstance().IsInitSuccess()) && (FeatureManager.isSegmentationReady())) {
      if (this.firstSeg) {
        break label194;
      }
    }
    for (;;)
    {
      synchronized (this.mSegmentLock)
      {
        try
        {
          if (this.mDetDataPipe == null)
          {
            this.mSegmentLock.wait();
            continue;
          }
          this.mSegGLThread.postSegJob(paramh, FabbyUtil.isHorizon(paramInt));
        }
        catch (InterruptedException localInterruptedException)
        {
          localObject1 = this.mDetDataPipe;
          this.mDetDataPipe = null;
        }
        this.firstSeg = false;
        if ((localObject1 != null) && (((SegmentDataPipe)localObject1).mTexFrame.width == paramh.width))
        {
          paramh = ((SegmentDataPipe)localObject1).mMaskFrame;
          localObject1 = paramh;
          if (paramh != null) {
            localObject1 = FrameUtil.rotateCorrect(paramh, paramh.width, paramh.height, -paramInt, this.mRotateFilter, this.mRotateFrame);
          }
          paramh = genSegAttr((h)localObject1);
          AppMethodBeat.o(81606);
          return paramh;
        }
      }
      paramh = null;
      continue;
      label194:
      Object localObject1 = null;
    }
  }
  
  @TargetApi(17)
  public void init()
  {
    AppMethodBeat.i(81602);
    if ((ApiHelper.hasJellyBeanMR1()) && (this.mSegGLThread == null) && (!inBlackList(DeviceInstance.getInstance().getDeviceName())))
    {
      this.mSegGLThread = new SegmentGLThread(EGL14.eglGetCurrentContext());
      this.mSegGLThread.setOnDataReadyListener(new PTSegmentor.2(this));
    }
    this.mRotateFilter.ApplyGLSLFilter();
    this.firstSeg = true;
    AppMethodBeat.o(81602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.PTSegmentor
 * JD-Core Version:    0.7.0.1
 */