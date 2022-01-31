package com.tencent.ttpic;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.filter.SplitFilter;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoSDKMaterialParser;
import com.tencent.ttpic.util.youtu.GestureDetector;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTSticker
{
  public static final String PERF_LOG = "[showPreview]";
  private VideoPreviewFaceOutlineDetector faceDetector;
  private BaseFilter mCopyFilter;
  private h mCopyFrame;
  private h[] mInputFrame;
  private int[] mInputTex;
  private long mLastTimeStamp;
  private boolean mPause;
  private long mPauseTimeDiff;
  private SplitFilter mSplitFilter;
  private VideoFilterList mVideoFilters;
  private float splitScreen;
  
  public PTSticker(VideoMaterial paramVideoMaterial, VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    AppMethodBeat.i(81611);
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mSplitFilter = new SplitFilter();
    this.mInputFrame = new h[2];
    this.mCopyFrame = new h();
    this.mInputTex = new int[1];
    construct(paramVideoMaterial, paramVideoPreviewFaceOutlineDetector);
    AppMethodBeat.o(81611);
  }
  
  public PTSticker(String paramString, VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    AppMethodBeat.i(81610);
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mSplitFilter = new SplitFilter();
    this.mInputFrame = new h[2];
    this.mCopyFrame = new h();
    this.mInputTex = new int[1];
    construct(VideoSDKMaterialParser.parseVideoMaterial(paramString, "params"), paramVideoPreviewFaceOutlineDetector);
    AppMethodBeat.o(81610);
  }
  
  private void construct(VideoMaterial paramVideoMaterial, VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    AppMethodBeat.i(81612);
    if (paramVideoMaterial == null)
    {
      paramVideoMaterial = new RuntimeException("PTSticker init fail!");
      AppMethodBeat.o(81612);
      throw paramVideoMaterial;
    }
    VideoMemoryManager.getInstance().loadAllImages(paramVideoMaterial);
    this.mVideoFilters = VideoFilterUtil.createFilters(paramVideoMaterial);
    paramVideoPreviewFaceOutlineDetector.setRefine(VideoMaterialUtil.needOpenRefine(paramVideoMaterial));
    paramVideoPreviewFaceOutlineDetector.setFaceValueDetectType(paramVideoMaterial.getFaceValueDetectType());
    paramVideoPreviewFaceOutlineDetector.clearActionCounter();
    GestureDetector.getInstance().clearActionCounter();
    GestureDetector.getInstance().setConfig(paramVideoMaterial.getHandBoostEnable());
    this.splitScreen = paramVideoMaterial.getSplitScreen();
    this.faceDetector = paramVideoPreviewFaceOutlineDetector;
    AppMethodBeat.o(81612);
  }
  
  private long getUpdateTimeStamp(long paramLong)
  {
    if (this.mPause) {
      this.mPauseTimeDiff = (paramLong - this.mLastTimeStamp);
    }
    for (paramLong = this.mLastTimeStamp;; paramLong -= this.mPauseTimeDiff)
    {
      this.mLastTimeStamp = paramLong;
      return this.mLastTimeStamp;
    }
  }
  
  public void addTouchPoint(PointF paramPointF)
  {
    AppMethodBeat.i(81637);
    this.mVideoFilters.addTouchPoint(paramPointF);
    AppMethodBeat.o(81637);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(81614);
    destroy(true);
    AppMethodBeat.o(81614);
  }
  
  public void destroy(boolean paramBoolean)
  {
    AppMethodBeat.i(81615);
    this.mCopyFilter.ClearGLSL();
    this.mSplitFilter.ClearGLSL();
    if (this.mVideoFilters != null) {
      this.mVideoFilters.destroy();
    }
    h[] arrayOfh = this.mInputFrame;
    int j = arrayOfh.length;
    int i = 0;
    while (i < j)
    {
      h localh = arrayOfh[i];
      if (localh != null) {
        localh.clear();
      }
      i += 1;
    }
    this.mCopyFrame.clear();
    GLES20.glDeleteTextures(this.mInputTex.length, this.mInputTex, 0);
    this.faceDetector.setRefine(false);
    if (paramBoolean) {
      VideoMemoryManager.getInstance().clear();
    }
    LogicDataManager.getInstance().destroy();
    AppMethodBeat.o(81615);
  }
  
  public boolean hasParticleFilter()
  {
    AppMethodBeat.i(81626);
    if ((this.mVideoFilters != null) && (this.mVideoFilters.hasParticleFilter()))
    {
      AppMethodBeat.o(81626);
      return true;
    }
    AppMethodBeat.o(81626);
    return false;
  }
  
  public boolean hasVoiceTextFilter()
  {
    AppMethodBeat.i(81625);
    if ((this.mVideoFilters != null) && (this.mVideoFilters.hasVoiceTextFilter()))
    {
      AppMethodBeat.o(81625);
      return true;
    }
    AppMethodBeat.o(81625);
    return false;
  }
  
  public void init()
  {
    AppMethodBeat.i(81613);
    this.mCopyFilter.ApplyGLSLFilter();
    this.mVideoFilters.ApplyGLSLFilter();
    this.mSplitFilter.ApplyGLSLFilter();
    int i = 0;
    while (i < this.mInputFrame.length)
    {
      this.mInputFrame[i] = new h();
      i += 1;
    }
    GLES20.glGenTextures(this.mInputTex.length, this.mInputTex, 0);
    AppMethodBeat.o(81613);
  }
  
  public boolean is3DMaterial()
  {
    AppMethodBeat.i(81633);
    boolean bool = VideoMaterialUtil.is3DMaterial(this.mVideoFilters.getMaterial());
    AppMethodBeat.o(81633);
    return bool;
  }
  
  public boolean isParticleMaterial()
  {
    AppMethodBeat.i(81634);
    boolean bool = VideoMaterialUtil.is3DMaterial(this.mVideoFilters.getMaterial());
    AppMethodBeat.o(81634);
    return bool;
  }
  
  public boolean isSegmentRequired()
  {
    AppMethodBeat.i(81623);
    boolean bool = this.mVideoFilters.isSegmentRequired();
    AppMethodBeat.o(81623);
    return bool;
  }
  
  public boolean isSupportPause()
  {
    AppMethodBeat.i(81624);
    boolean bool = this.mVideoFilters.isSupportPause();
    AppMethodBeat.o(81624);
    return bool;
  }
  
  public boolean needDetectBody()
  {
    AppMethodBeat.i(81635);
    boolean bool = VideoMaterialUtil.isBodyDetectMaterial(this.mVideoFilters.getMaterial());
    AppMethodBeat.o(81635);
    return bool;
  }
  
  public boolean needDetectFace(int paramInt)
  {
    AppMethodBeat.i(81627);
    boolean bool = this.mVideoFilters.needFaceInfo(paramInt);
    AppMethodBeat.o(81627);
    return bool;
  }
  
  public boolean needDetectGesture()
  {
    AppMethodBeat.i(81628);
    boolean bool = this.mVideoFilters.needDetectGesture();
    AppMethodBeat.o(81628);
    return bool;
  }
  
  public boolean needRecordTouchPoint()
  {
    AppMethodBeat.i(81636);
    boolean bool = VideoFilterUtil.needRecordTouchPoint(this.mVideoFilters);
    AppMethodBeat.o(81636);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(81620);
    this.mVideoFilters.onPause();
    AppMethodBeat.o(81620);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(81619);
    this.mVideoFilters.onResume();
    AppMethodBeat.o(81619);
  }
  
  public void onStickerPause()
  {
    AppMethodBeat.i(81621);
    if (isSupportPause())
    {
      this.mPause = true;
      this.mVideoFilters.setAudioPause(this.mPause);
    }
    AppMethodBeat.o(81621);
  }
  
  public void onStickerResume()
  {
    AppMethodBeat.i(81622);
    if (isSupportPause())
    {
      this.mPause = false;
      this.mVideoFilters.setAudioPause(this.mPause);
    }
    AppMethodBeat.o(81622);
  }
  
  public h processSplitFilters(h paramh1, h paramh2)
  {
    AppMethodBeat.i(81638);
    if (this.splitScreen <= 0.0F)
    {
      AppMethodBeat.o(81638);
      return paramh2;
    }
    h localh = this.mCopyFrame;
    this.mCopyFilter.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, paramh2.width, paramh2.height, -1, 0.0D, localh);
    this.mSplitFilter.setxPos(this.splitScreen);
    this.mSplitFilter.RenderProcess(paramh2.texture[0], paramh2.width, paramh2.height, -1, 0.0D, localh);
    AppMethodBeat.o(81638);
    return localh;
  }
  
  public h processStickerFilters(h paramh, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    AppMethodBeat.i(81617);
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    long l = this.mLastTimeStamp;
    int i = paramPTFaceAttr.getRotation();
    Object localObject = paramPTSegAttr.getMaskFrame();
    if ((paramPTSegAttr.getMaskFrame() != null) && (paramPTFaceAttr.getFaceCount() > 0)) {}
    for (paramPTSegAttr = this.mVideoFilters.doFabbyStroke(paramh, (h)localObject);; paramPTSegAttr = paramh)
    {
      this.mVideoFilters.renderARFilterIfNeeded(paramPTSegAttr);
      localObject = this.mVideoFilters.updateAndRenderHeadCropItemFilters(paramPTSegAttr, paramPTFaceAttr);
      paramPTSegAttr = (PTSegAttr)localObject;
      if (this.mVideoFilters.isSegmentRequired()) {
        paramPTSegAttr = this.mVideoFilters.updateAndRenderBgFilters((h)localObject, paramPTFaceAttr);
      }
      localObject = paramPTSegAttr;
      if (this.mVideoFilters.render3DFirst())
      {
        BenchUtil.benchStart("[showPreview]updateAndRender3DFilter");
        localObject = this.mVideoFilters.updateAndRender3DFilter(paramPTSegAttr, paramPTFaceAttr, i);
        BenchUtil.benchEnd("[showPreview]updateAndRender3DFilter");
      }
      BenchUtil.benchStart("[showPreview]updateAndRender - DO_NOT_RENDER_FACE_OFF_FILTER");
      paramPTSegAttr = this.mVideoFilters.updateAndRenderDynamicStickers((h)localObject, paramPTFaceAttr);
      BenchUtil.benchEnd("[showPreview]updateAndRender - DO_NOT_RENDER_FACE_OFF_FILTER");
      HashMap localHashMap = new HashMap();
      this.mVideoFilters.updateAndRenderMultiViewerMaterial(localHashMap, paramPTSegAttr, paramPTFaceAttr);
      localObject = this.mVideoFilters.updateAndRenderStaticStickers(paramPTSegAttr, paramPTFaceAttr);
      paramPTSegAttr = (PTSegAttr)localObject;
      if (!this.mVideoFilters.render3DFirst())
      {
        BenchUtil.benchStart("[showPreview]updateAndRender");
        paramPTSegAttr = this.mVideoFilters.updateAndRender3DFilter((h)localObject, paramPTFaceAttr, i);
        BenchUtil.benchEnd("[showPreview]updateAndRender");
      }
      BenchUtil.benchStart("updateAndRenderActMaterial");
      paramPTFaceAttr = this.mVideoFilters.updateAndRenderActMaterial(paramPTSegAttr, localList1, localList2, i, l);
      BenchUtil.benchEnd("updateAndRenderActMaterial");
      if (localHashMap.isEmpty()) {
        localHashMap.put(Integer.valueOf(0), paramPTFaceAttr);
      }
      paramh = this.mVideoFilters.updateAndRenderFabbyMV(paramh, localHashMap, this.faceDetector.getFaceActionCounter(), localSet, l);
      AppMethodBeat.o(81617);
      return paramh;
    }
  }
  
  public h processTransformRelatedFilters(h paramh, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    AppMethodBeat.i(81616);
    paramPTSegAttr = paramPTFaceAttr.getAllFacePoints();
    List localList1 = paramPTFaceAttr.getAllFaceAngles();
    List localList2 = paramPTFaceAttr.getHandPoints();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    long l = getUpdateTimeStamp(paramPTFaceAttr.getTimeStamp());
    this.mVideoFilters.updateFaceParams(paramPTSegAttr, localList1, localList2, paramh.width);
    BenchUtil.benchStart("updateTextureParam2");
    this.mVideoFilters.updateTextureParam(this.faceDetector.getFaceActionCounter(), localSet, l);
    BenchUtil.benchEnd("updateTextureParam2");
    paramh = this.mVideoFilters.processTransformRelatedFilters(paramh, paramPTFaceAttr);
    AppMethodBeat.o(81616);
    return paramh;
  }
  
  public void reset()
  {
    AppMethodBeat.i(81618);
    this.mVideoFilters.reset();
    AppMethodBeat.o(81618);
  }
  
  public void setRatioMode(VideoFilterUtil.RATIO_MODE paramRATIO_MODE)
  {
    AppMethodBeat.i(81631);
    this.mVideoFilters.setRatioMode(paramRATIO_MODE);
    AppMethodBeat.o(81631);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(81632);
    this.mVideoFilters.setRenderMode(paramInt);
    AppMethodBeat.o(81632);
  }
  
  public void updateCosAlpha(int paramInt)
  {
    AppMethodBeat.i(81629);
    this.mVideoFilters.updateCosAlpha(paramInt);
    AppMethodBeat.o(81629);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble, int paramInt3)
  {
    AppMethodBeat.i(81630);
    this.mVideoFilters.updateVideoSize(paramInt1, paramInt2, paramDouble, paramInt3);
    AppMethodBeat.o(81630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.PTSticker
 * JD-Core Version:    0.7.0.1
 */