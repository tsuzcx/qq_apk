package com.tencent.ttpic;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.thread.SegmentGLThread;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FabbyUtil;
import com.tencent.ttpic.util.OnSegmentReadyListener;
import com.tencent.ttpic.util.PTFaceUtil;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoTemplateParser;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTSticker
{
  private static final boolean HAS_COS = true;
  private static final boolean HAS_STICK = true;
  private static final VideoPreviewFaceOutlineDetector mFaceDetector = ;
  private boolean firstSeg;
  private int frameIndex;
  List<FaceStatus> fs3DList = new ArrayList();
  float[] handAngle = { 0.0F, 0.0F, 0.0F };
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bcE);
  private h mCopyFrame = new h();
  private volatile SegmentDataPipe mDataPipe;
  private PTFaceAttr[] mFaceAttr = new PTFaceAttr[2];
  private h[] mInputFrame = new h[2];
  private int[] mInputTex = new int[1];
  private boolean mIsPause;
  VideoMaterial mMaterial;
  private boolean mNeedFaceTip = true;
  private h[] mOrigFrame = new h[2];
  private h mSegFrame = new h();
  private OnSegmentReadyListener mSegListener;
  private final Object mSegmentLock = new Object();
  private VideoFilterList mVideoFilters;
  
  public PTSticker(String paramString)
  {
    this.mMaterial = VideoTemplateParser.parseVideoMaterial(paramString);
    if ((this.mMaterial.getGameParams() != null) && (paramString.startsWith("assets:")))
    {
      this.mMaterial = null;
      return;
    }
    VideoMaterialUtil.needOpenRefine(this.mMaterial);
    VideoMemoryManager.getInstance().loadAllImages(this.mMaterial);
    if (this.mMaterial == null) {}
    for (paramString = localObject;; paramString = VideoFilterUtil.createFilters(this.mMaterial))
    {
      this.mVideoFilters = paramString;
      mFaceDetector.setRefine(VideoMaterialUtil.needOpenRefine(this.mMaterial));
      this.mNeedFaceTip = VideoMaterialUtil.needFaceTips(this.mMaterial);
      return;
    }
  }
  
  private int checkBufferTexValid(byte[] paramArrayOfByte, int paramInt1, int paramInt2, PTFaceAttr paramPTFaceAttr, int paramInt3)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != paramInt1 * paramInt2 * 4)) {
      paramInt1 = -1202;
    }
    do
    {
      return paramInt1;
      if (paramInt3 <= 0) {
        return -1204;
      }
      if (this.mVideoFilters == null) {
        return -1200;
      }
      if (paramPTFaceAttr == null) {
        return -1203;
      }
      paramInt1 = i;
    } while (this.mInputTex[0] > 0);
    return -1206;
  }
  
  private int checkBufferValid(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, PTFaceAttr paramPTFaceAttr, byte[] paramArrayOfByte2)
  {
    int i = 0;
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length != paramInt1 * paramInt2 * 4)) {
      paramInt1 = -1201;
    }
    do
    {
      return paramInt1;
      if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length != paramInt1 * paramInt2 * 4)) {
        return -1202;
      }
      if (this.mVideoFilters == null) {
        return -1200;
      }
      if (paramPTFaceAttr == null) {
        return -1203;
      }
      paramInt1 = i;
    } while (this.mInputTex[0] > 0);
    return -1206;
  }
  
  private int checkTexBufferValid(int paramInt1, int paramInt2, int paramInt3, PTFaceAttr paramPTFaceAttr, byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramInt1 <= 0) {
      paramInt1 = -1204;
    }
    do
    {
      return paramInt1;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length != paramInt2 * paramInt3 * 4)) {
        return -1202;
      }
      if (this.mVideoFilters == null) {
        return -1200;
      }
      if (paramPTFaceAttr == null) {
        return -1203;
      }
      paramInt1 = i;
    } while (this.mInputTex[0] > 0);
    return -1206;
  }
  
  private int checkTexValid(int paramInt1, PTFaceAttr paramPTFaceAttr, int paramInt2)
  {
    int i = 0;
    if (paramInt1 <= 0) {
      paramInt1 = -1204;
    }
    do
    {
      return paramInt1;
      if (paramInt2 <= 0) {
        return -1205;
      }
      if (this.mVideoFilters == null) {
        return -1200;
      }
      if (paramPTFaceAttr == null) {
        return -1203;
      }
      paramInt1 = i;
    } while (this.mInputTex[0] > 0);
    return -1206;
  }
  
  private SegFaceInfo getSegFaceInfo(int paramInt1, PTFaceAttr paramPTFaceAttr, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = this.frameIndex % 2;
    int j = (this.frameIndex + 1) % 2;
    this.frameIndex += 1;
    int k = VideoFilterUtil.get4DirectionAngle(mFaceDetector.getPhotoAngle());
    this.mCopyFilter.nativeSetRotationAndFlip(k, 0, 0);
    h localh2;
    h localh1;
    if (FabbyUtil.isHorizon(k))
    {
      this.mCopyFilter.RenderProcess(paramInt1, paramInt3, paramInt2, -1, 0.0D, this.mInputFrame[i]);
      this.mCopyFilter.nativeSetRotationAndFlip(0, 0, 0);
      this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mOrigFrame[i]);
      localh2 = this.mInputFrame[i];
      localh1 = this.mOrigFrame[i];
      this.mFaceAttr[i] = paramPTFaceAttr;
      if ((!this.mVideoFilters.isSegmentRequired()) || (this.mSegListener == null)) {
        break label558;
      }
      GLES20.glFinish();
      Object localObject1 = null;
      if (!paramBoolean) {
        break label419;
      }
      BenchUtil.benchStart("[showPreview][FABBY] wait");
      this.mSegListener.needWait();
      if (this.firstSeg) {}
    }
    for (;;)
    {
      synchronized (this.mSegmentLock)
      {
        try
        {
          if (this.mDataPipe == null)
          {
            this.mSegmentLock.wait();
            continue;
          }
          BenchUtil.benchEnd("[showPreview][FABBY] wait");
        }
        catch (InterruptedException localInterruptedException1)
        {
          ??? = this.mDataPipe;
          this.mDataPipe = null;
        }
        this.mSegListener.onTextureReady(localh2, FabbyUtil.isHorizon(k));
        this.firstSeg = false;
        if ((??? == null) || (((SegmentDataPipe)???).mTexFrame.width != localh2.width)) {
          break label569;
        }
        localh2 = this.mOrigFrame[j];
        paramPTFaceAttr = this.mFaceAttr[j];
        localh1 = this.mVideoFilters.doFabbyStroke(((SegmentDataPipe)???).mTexFrame, ((SegmentDataPipe)???).mMaskFrame);
        ??? = localh2;
        if (k == 0) {
          break label555;
        }
        this.mCopyFilter.nativeSetRotationAndFlip(-k, 0, 0);
        this.mCopyFilter.RenderProcess(localh1.texture[0], paramInt2, paramInt3, -1, 0.0D, this.mSegFrame);
        this.mCopyFilter.nativeSetRotationAndFlip(0, 0, 0);
        localh1 = this.mSegFrame;
        return new SegFaceInfo((h)???, localh1, paramPTFaceAttr, k);
        this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mInputFrame[i]);
      }
      label419:
      this.mSegListener.onTextureReady(localh2, FabbyUtil.isHorizon(k));
      BenchUtil.benchStart("[showPreview][FABBY] wait");
      this.mSegListener.needWait();
      synchronized (this.mSegmentLock)
      {
        SegmentDataPipe localSegmentDataPipe;
        try
        {
          while (this.mDataPipe == null) {
            this.mSegmentLock.wait();
          }
          if (localSegmentDataPipe.mTexFrame.width != localh2.width) {
            break label558;
          }
        }
        catch (InterruptedException localInterruptedException2)
        {
          localSegmentDataPipe = this.mDataPipe;
          this.mDataPipe = null;
          BenchUtil.benchEnd("[showPreview][FABBY] wait");
          if (localSegmentDataPipe == null) {
            break label558;
          }
        }
        localh2 = this.mVideoFilters.doFabbyStroke(localSegmentDataPipe.mTexFrame, localSegmentDataPipe.mMaskFrame);
        ??? = localh1;
        localh1 = localh2;
      }
      label555:
      continue;
      label558:
      ??? = localh1;
      localh1 = localh2;
      continue;
      label569:
      ??? = localh1;
      localh1 = localh2;
    }
  }
  
  private h process(h paramh1, h paramh2, PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mIsPause) {
      return paramh1;
    }
    long l = System.currentTimeMillis();
    float f = paramPTFaceAttr.getFaceScale();
    this.mVideoFilters.updateVideoSize(paramInt1, paramInt2, f);
    Set localSet = PTFaceUtil.getTriggeredExpression(paramPTFaceAttr.getFaceExpression());
    List localList1 = PTFaceUtil.getAllFaces(paramPTFaceAttr.getFaceInfos());
    List localList2 = PTFaceUtil.getAllFaceAngles(paramPTFaceAttr.getFaceInfos());
    List localList3 = paramPTFaceAttr.getHandPoints();
    Object localObject = paramPTFaceAttr.getHandAngles();
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.handAngle = ((float[])((List)localObject).get(0));
    }
    this.mVideoFilters.updateTextureParam(mFaceDetector.getFaceActionCounter(), localSet, l);
    this.mVideoFilters.renderARFilterIfNeeded(paramh2);
    localObject = this.mVideoFilters.updateAndRenderHeadCropItemFilters(paramh2, localList1, localList2, mFaceDetector.getFaceActionCounter(), localList3, null, localSet, f, paramInt3, l);
    paramh2 = (h)localObject;
    if (this.mVideoFilters.isSegmentRequired()) {
      paramh2 = this.mVideoFilters.updateAndRenderBgFilters((h)localObject, localList1, localList2, mFaceDetector.getFaceActionCounter(), localList3, null, localSet, f, l);
    }
    if ((this.mVideoFilters != null) && (this.mVideoFilters.render3DFirst()) && ((paramInt3 == 0) || (paramInt3 == 180)))
    {
      BenchUtil.benchStart("[showPreview]updateAndRender3DFilter");
      this.fs3DList = mFaceDetector.getFaceStatus3Ds();
      BenchUtil.benchEnd("[showPreview]updateAndRender3DFilter");
    }
    if ((paramInt3 == 90) || (paramInt3 == 270)) {}
    for (boolean bool = true;; bool = false)
    {
      paramh2 = this.mVideoFilters.process(paramh2, this.fs3DList, localList1, localList2, mFaceDetector.getFaceActionCounter(), localList3, this.handAngle, null, localSet, f, paramPTFaceAttr.getData(), l, bool);
      paramh2 = this.mVideoFilters.updateAndRenderActMaterial(paramh2, localList1, localList2, f, paramInt3);
      localObject = new HashMap();
      if ((this.mVideoFilters != null) && (!VideoFilterList.needMultiViewerMaterial())) {
        this.mVideoFilters.updateAndRenderMultiViewerMaterial((Map)localObject, paramh2, localList1, localList2, mFaceDetector.getFaceActionCounter(), localList3, this.handAngle, null, localSet, f, paramPTFaceAttr.getData(), paramInt3, l, false);
      }
      paramPTFaceAttr = this.mVideoFilters.updateAndRenderStaticStickers(paramh2, localList1, localList2, mFaceDetector.getFaceActionCounter(), localList3, null, localSet, f, paramInt3, l);
      paramh2 = paramPTFaceAttr;
      if (this.mVideoFilters != null)
      {
        if (((Map)localObject).isEmpty()) {
          ((Map)localObject).put(Integer.valueOf(0), paramPTFaceAttr);
        }
        paramh2 = this.mVideoFilters.updateAndRenderFabbyMV(paramh1, (Map)localObject, mFaceDetector.getFaceActionCounter(), localSet, l);
      }
      return paramh2;
    }
  }
  
  public void addTouchPoint(PointF paramPointF)
  {
    this.mVideoFilters.addTouchPoint(paramPointF);
  }
  
  public void destroy()
  {
    this.mCopyFilter.ClearGLSL();
    if (this.mVideoFilters != null) {
      this.mVideoFilters.destroy();
    }
    h[] arrayOfh = this.mInputFrame;
    int j = arrayOfh.length;
    int i = 0;
    h localh;
    while (i < j)
    {
      localh = arrayOfh[i];
      if (localh != null) {
        localh.clear();
      }
      i += 1;
    }
    arrayOfh = this.mOrigFrame;
    j = arrayOfh.length;
    i = 0;
    while (i < j)
    {
      localh = arrayOfh[i];
      if (localh != null) {
        localh.clear();
      }
      i += 1;
    }
    this.mCopyFrame.clear();
    this.mSegFrame.clear();
    GLES20.glDeleteTextures(this.mInputTex.length, this.mInputTex, 0);
    if (this.mSegListener != null) {
      this.mSegListener.reset();
    }
    mFaceDetector.clearActionCounter();
    VideoMemoryManager.getInstance().clear();
    mFaceDetector.setRefine(false);
  }
  
  public String getTips()
  {
    Object localObject;
    if (this.mMaterial == null) {
      localObject = "";
    }
    String str;
    do
    {
      do
      {
        return localObject;
        str = this.mMaterial.getTipsText();
        localObject = str;
      } while (!TextUtils.isEmpty(str));
      str = VideoMaterialUtil.getActionTipString(this.mMaterial.getTriggerType());
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return "";
  }
  
  public String getTipsIcon()
  {
    if (this.mMaterial == null) {
      return null;
    }
    return this.mMaterial.getTipsIcon();
  }
  
  public VideoFilterList getVideoFilters()
  {
    return this.mVideoFilters;
  }
  
  public int init()
  {
    this.mCopyFilter.ApplyGLSLFilter();
    if (this.mVideoFilters == null) {
      return -1200;
    }
    this.firstSeg = true;
    this.mVideoFilters.ApplyGLSLFilter();
    SegmentGLThread localSegmentGLThread = PTModule.getInstance().getSegGLThread();
    if (localSegmentGLThread != null)
    {
      localSegmentGLThread.setOnDataReadyListener(new PTSticker.1(this));
      setOnSegmentReadyListener(new PTSticker.2(this, localSegmentGLThread));
    }
    int i = 0;
    while (i < this.mInputFrame.length)
    {
      this.mInputFrame[i] = new h();
      i += 1;
    }
    i = 0;
    while (i < this.mOrigFrame.length)
    {
      this.mOrigFrame[i] = new h();
      i += 1;
    }
    GLES20.glGenTextures(this.mInputTex.length, this.mInputTex, 0);
    GlUtil.debugCheckGlError(this);
    return 0;
  }
  
  public boolean isStickerOrderBack()
  {
    if (this.mMaterial == null) {}
    while (this.mMaterial.getOrderMode() != 2) {
      return false;
    }
    return true;
  }
  
  public boolean isUseMesh()
  {
    if (this.mMaterial == null) {
      return false;
    }
    return this.mMaterial.isUseMesh();
  }
  
  public boolean needDetectGesture()
  {
    return (this.mVideoFilters != null) && (this.mVideoFilters.needDetectGesture());
  }
  
  public boolean needFaceTip()
  {
    return this.mNeedFaceTip;
  }
  
  public boolean needRecordTouchPoint()
  {
    return VideoFilterUtil.needRecordTouchPoint(this.mVideoFilters);
  }
  
  public void onPause()
  {
    this.mIsPause = true;
    if (this.mVideoFilters != null) {
      this.mVideoFilters.onPause();
    }
  }
  
  public void onResume()
  {
    this.mIsPause = false;
    if (this.mVideoFilters != null) {
      this.mVideoFilters.onResume();
    }
  }
  
  public int processBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2, PTFaceAttr paramPTFaceAttr, int paramInt3, boolean paramBoolean)
  {
    int i = checkBufferTexValid(paramArrayOfByte, paramInt1, paramInt2, paramPTFaceAttr, paramInt3);
    if (i != 0) {
      return i;
    }
    GlUtil.loadTexture(this.mInputTex[0], ByteBuffer.wrap(paramArrayOfByte), paramInt1, paramInt2, 6408);
    paramArrayOfByte = getSegFaceInfo(this.mInputTex[0], paramPTFaceAttr, paramInt1, paramInt2, paramBoolean);
    paramArrayOfByte = process(paramArrayOfByte.origFrame, paramArrayOfByte.maskFrame, paramPTFaceAttr, paramInt1, paramInt2, paramArrayOfByte.rotation);
    this.mCopyFilter.RenderProcess(paramArrayOfByte.texture[0], paramArrayOfByte.width, paramArrayOfByte.height, paramInt3, 0.0D, this.mCopyFrame);
    return 0;
  }
  
  public int processBuffer(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, PTFaceAttr paramPTFaceAttr, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    int i = checkBufferValid(paramArrayOfByte1, paramInt1, paramInt2, paramPTFaceAttr, paramArrayOfByte2);
    if (i != 0) {
      return i;
    }
    GlUtil.loadTexture(this.mInputTex[0], ByteBuffer.wrap(paramArrayOfByte1), paramInt1, paramInt2, 6408);
    paramArrayOfByte1 = getSegFaceInfo(this.mInputTex[0], paramPTFaceAttr, paramInt1, paramInt2, paramBoolean);
    paramArrayOfByte1 = process(paramArrayOfByte1.origFrame, paramArrayOfByte1.maskFrame, paramPTFaceAttr, paramInt1, paramInt2, paramArrayOfByte1.rotation);
    System.arraycopy(RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramArrayOfByte1.texture[0], paramInt1, paramInt2), 0, paramArrayOfByte2, 0, paramInt1 * paramInt2 << 2);
    return 0;
  }
  
  public int processTexture(int paramInt1, int paramInt2, int paramInt3, PTFaceAttr paramPTFaceAttr, int paramInt4, boolean paramBoolean)
  {
    int i;
    if (this.mMaterial == null)
    {
      this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, 0.0D, this.mCopyFrame);
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = checkTexValid(paramInt1, paramPTFaceAttr, paramInt4);
      i = j;
    } while (j != 0);
    SegFaceInfo localSegFaceInfo = getSegFaceInfo(paramInt1, paramPTFaceAttr, paramInt2, paramInt3, paramBoolean);
    paramPTFaceAttr = process(localSegFaceInfo.origFrame, localSegFaceInfo.maskFrame, paramPTFaceAttr, paramInt2, paramInt3, localSegFaceInfo.rotation);
    this.mCopyFilter.RenderProcess(paramPTFaceAttr.texture[0], paramPTFaceAttr.width, paramPTFaceAttr.height, paramInt4, 0.0D, this.mCopyFrame);
    GlUtil.debugCheckGlError(this);
    return 0;
  }
  
  public int processTexture(int paramInt1, int paramInt2, int paramInt3, PTFaceAttr paramPTFaceAttr, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = checkTexBufferValid(paramInt1, paramInt2, paramInt3, paramPTFaceAttr, paramArrayOfByte);
    if (i != 0) {
      return i;
    }
    SegFaceInfo localSegFaceInfo = getSegFaceInfo(paramInt1, paramPTFaceAttr, paramInt2, paramInt3, paramBoolean);
    paramPTFaceAttr = process(localSegFaceInfo.origFrame, localSegFaceInfo.maskFrame, paramPTFaceAttr, paramInt2, paramInt3, localSegFaceInfo.rotation);
    System.arraycopy(RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramPTFaceAttr.texture[0], paramInt2, paramInt3), 0, paramArrayOfByte, 0, paramInt2 * paramInt3 << 2);
    return 0;
  }
  
  public void segmentDataPipe(SegmentDataPipe paramSegmentDataPipe)
  {
    synchronized (this.mSegmentLock)
    {
      this.mDataPipe = paramSegmentDataPipe;
      this.mSegmentLock.notifyAll();
      return;
    }
  }
  
  public void setMaterialMute()
  {
    if (this.mVideoFilters != null) {
      this.mVideoFilters.setMaterialMute();
    }
  }
  
  public void setOnSegmentReadyListener(OnSegmentReadyListener paramOnSegmentReadyListener)
  {
    this.mSegListener = paramOnSegmentReadyListener;
  }
  
  private static class SegFaceInfo
  {
    public PTFaceAttr faceAttr;
    public h maskFrame;
    public h origFrame;
    public int rotation;
    
    public SegFaceInfo(h paramh1, h paramh2, PTFaceAttr paramPTFaceAttr, int paramInt)
    {
      this.origFrame = paramh1;
      this.maskFrame = paramh2;
      this.faceAttr = paramPTFaceAttr;
      this.rotation = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.PTSticker
 * JD-Core Version:    0.7.0.1
 */