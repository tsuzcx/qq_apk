package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.ar.filter.ARParticleFilter;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.face.Face;
import com.tencent.ttpic.facedetect.FaceDetector.DETECT_TYPE;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.manager.MaterialManager;
import com.tencent.ttpic.manager.RandomGroupManager;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.FabbyFaceActionCounter;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.GenderRange;
import com.tencent.ttpic.model.ParticleParam;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.particle.ParticleFilter;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FaceAverageUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterFactory;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import com.tencent.ttpic.util.VideoFrameUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.util.youtu.GestureDetector;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.view.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class VideoFilterList
{
  public static final String FABBY_LOG = "[FABBY]";
  private static final int HAND_RANDOM_INDEX = 0;
  public static final String PERF_LOG = "[showPreview]";
  private static String TAG;
  private static final Random mRandom;
  private Audio3DFilter audio3DFilter;
  private List<VideoFilterBase> bgDynamicStickerFilters;
  private List<VideoFilterBase> bgStaticStickerFilters;
  private List<NormalVideoFilter> bodyFilters;
  private List<ParticleFilter> bodyParticleFilters;
  private h[] copyFrame;
  private CrazyFaceFilters crazyFaceFilters;
  private FabbyExtractFilter fabbyExtractFilter;
  private h fabbyFeatheredMaskStep1;
  private h fabbyFeatheredMaskStep2;
  private FabbyFilters fabbyMvFilters;
  private h fabbyOriginCopyFrame;
  private FabbyStrokeFilter fabbyStrokeFilter;
  private h fabbyStrokeFrame;
  private List<VideoFilterBase> faceParticleDynamicFilters;
  private List<VideoFilterBase> faceParticleStaticFilters;
  private FastBlurFilter fastBlurFilter;
  private FastStickerFilter fastBodyStickerFilter;
  private FastStickerFilter fastFaceStickerFilter;
  private FastParticleFilter fastParticleFilter;
  private List<VideoFilterBase> fgDynamicFilters;
  private List<VideoFilterBase> fgStaticStickerFilters;
  private List<VideoFilterBase> filters;
  private GameFilter gameFilter;
  private List<NormalVideoFilter> gestureFilters;
  private List<ParticleFilter> gestureParticleFilters;
  private HeadCropFilter headCropFilter;
  private List<NormalVideoFilter> headCropItemFilters;
  private ARParticleFilter mARParticleFilter;
  private Queue<PointF> mARTouchPointQueue;
  private ActFilters mActFilters;
  private Map<Integer, Float> mAgeValueMap;
  private h mBgFrame;
  private Map<Integer, Double> mCharmValueMap;
  private BaseFilter mCopyFilter;
  private Map<Integer, Float> mCpValueMap;
  private int mCurPersonId;
  private VideoFilterBase mEffectFilter;
  private h mEffectFrame;
  private int mEffectOrder;
  private h mEffectTestFrame;
  private double mFaceDetScale;
  private Comparator<Face> mFaceIndexComperator;
  private List<Face> mFaceList;
  private List<VideoFilterBase> mFaceOffFilters;
  private List<FacialFeatureFilter> mFacialFeatureFilterList;
  private Map<Integer, Float> mGenderValueMap;
  private Map<Integer, Double> mHandsValueMap;
  private h mHeadCropFrame;
  private LipsCosFilter mLipsCosFilter;
  private BaseFilter mMaskFilter;
  private PhantomFilter mPhantomFilter;
  private h mPhantomFrame;
  private Map<Integer, Float> mPopularValueMap;
  private float mScaleFace;
  private List<List<PointF>> mTouchPoints;
  private List<VideoFilterBase> mTransformFilters;
  private VideoMaterial material;
  private List<MultiViewerFilter> multiViewerFilters;
  public Map<Integer, h> multiViewerFrameMap;
  private h multiViewerOutFrame;
  private int multiViewerSrcTexture;
  private boolean needDetectGesture;
  private h renderFrame;
  private VoiceTextFilter voiceTextFilter;
  
  static
  {
    AppMethodBeat.i(83159);
    TAG = VideoFilterList.class.getSimpleName();
    mRandom = new Random(System.currentTimeMillis());
    AppMethodBeat.o(83159);
  }
  
  public VideoFilterList()
  {
    AppMethodBeat.i(83079);
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.copyFrame = new h[2];
    this.renderFrame = new h();
    this.mEffectFrame = new h();
    this.mEffectTestFrame = new h();
    this.mHeadCropFrame = new h();
    this.mBgFrame = new h();
    this.fabbyStrokeFrame = new h();
    this.fabbyFeatheredMaskStep1 = new h();
    this.fabbyFeatheredMaskStep2 = new h();
    this.fabbyOriginCopyFrame = new h();
    this.mPhantomFrame = new h();
    this.mCurPersonId = -1;
    this.mTouchPoints = new ArrayList();
    this.mScaleFace = 1.0F;
    this.mCharmValueMap = new HashMap();
    this.mHandsValueMap = new HashMap();
    this.mAgeValueMap = new HashMap();
    this.mGenderValueMap = new HashMap();
    this.mPopularValueMap = new HashMap();
    this.mCpValueMap = new HashMap();
    this.mFaceList = new ArrayList();
    this.mEffectOrder = -1;
    this.mARTouchPointQueue = new LinkedList();
    this.headCropItemFilters = new ArrayList();
    this.needDetectGesture = false;
    this.multiViewerFrameMap = new HashMap();
    this.mFaceDetScale = VideoMaterialUtil.SCALE_FACE_DETECT;
    this.fastParticleFilter = new FastParticleFilter();
    this.mFaceIndexComperator = new VideoFilterList.1(this);
    AppMethodBeat.o(83079);
  }
  
  private h RenderProcessForAudio3DFilter(h paramh1, h paramh2, List<Face> paramList, int paramInt1, PTFaceAttr paramPTFaceAttr, int paramInt2)
  {
    AppMethodBeat.i(83084);
    if (paramh2 == null)
    {
      this.audio3DFilter.setFaceCount(paramInt1);
      this.audio3DFilter.addSrcTexture(this.multiViewerSrcTexture);
      if (paramInt1 > 0) {
        break label109;
      }
      paramh2 = new PTDetectInfo.Builder().faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
      this.audio3DFilter.updatePreview(paramh2);
    }
    for (;;)
    {
      this.audio3DFilter.render(paramh1, paramPTFaceAttr);
      AppMethodBeat.o(83084);
      return paramh1;
      paramh1 = paramh2;
      break;
      label109:
      int i = 0;
      while ((i < paramInt1) && (i < paramList.size()))
      {
        paramh2 = (Face)paramList.get(i);
        paramh2 = new PTDetectInfo.Builder().facePoints(paramh2.facePoints).faceAngles(paramh2.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints(paramPTFaceAttr.getHandPoints()).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
        this.audio3DFilter.updatePreview(paramh2);
        this.audio3DFilter.setRenderParams(paramInt2);
        i += 1;
      }
    }
  }
  
  private h RenderProcessForFastBodyStickerFilter(h paramh1, h paramh2, PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(83085);
    if (paramh2 == null) {}
    for (;;)
    {
      this.fastBodyStickerFilter.setFaceCount(1);
      this.fastBodyStickerFilter.addSrcTexture(this.multiViewerSrcTexture);
      this.fastBodyStickerFilter.updatePreview(paramPTDetectInfo);
      this.fastBodyStickerFilter.setRenderParams(0);
      this.fastBodyStickerFilter.render(paramh1);
      AppMethodBeat.o(83085);
      return paramh1;
      paramh1 = paramh2;
    }
  }
  
  private h RenderProcessForFastFaceStickerFilter(h paramh1, h paramh2, List<Face> paramList, int paramInt1, PTFaceAttr paramPTFaceAttr, int paramInt2)
  {
    AppMethodBeat.i(83083);
    if (paramh2 == null)
    {
      this.fastFaceStickerFilter.setFaceCount(paramInt1);
      this.fastFaceStickerFilter.addSrcTexture(this.multiViewerSrcTexture);
      if (paramInt1 > 0) {
        break label107;
      }
      paramh2 = new PTDetectInfo.Builder().faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
      this.fastFaceStickerFilter.updatePreview(paramh2);
    }
    for (;;)
    {
      this.fastFaceStickerFilter.render(paramh1);
      AppMethodBeat.o(83083);
      return paramh1;
      paramh1 = paramh2;
      break;
      label107:
      int i = 0;
      while ((i < paramInt1) && (i < paramList.size()))
      {
        paramh2 = (Face)paramList.get(i);
        paramh2 = new PTDetectInfo.Builder().facePoints(paramh2.facePoints).faceAngles(paramh2.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints(paramPTFaceAttr.getHandPoints()).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
        this.fastFaceStickerFilter.updatePreview(paramh2);
        this.fastFaceStickerFilter.setRenderParams(paramInt2);
        i += 1;
      }
    }
  }
  
  private h RenderProcessForFastParticleFilter(h paramh, List<ParticleFilter> paramList)
  {
    AppMethodBeat.i(83086);
    if (BaseUtils.isEmpty(paramList))
    {
      AppMethodBeat.o(83086);
      return paramh;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((ParticleFilter)paramList.get(i)).getParticleParam().needRender) {
        localArrayList.add(((ParticleFilter)paramList.get(i)).getParticleParam());
      }
      i += 1;
    }
    this.fastParticleFilter.render(localArrayList, paramh);
    AppMethodBeat.o(83086);
    return paramh;
  }
  
  private h RenderProcessForFilters(h paramh1, h paramh2, List<? extends VideoFilterBase> paramList)
  {
    AppMethodBeat.i(83082);
    if (BaseUtils.isEmpty(paramList))
    {
      AppMethodBeat.o(83082);
      return paramh1;
    }
    h localh2;
    h localh1;
    int i;
    label92:
    Object localObject;
    if (paramh1.texture[0] == this.copyFrame[0].texture[0])
    {
      localh2 = this.copyFrame[1];
      localh1 = paramh2;
      if (paramh2 == null) {
        localh1 = paramh1;
      }
      GLES20.glBindFramebuffer(36160, localh1.bte[0]);
      GLES20.glViewport(0, 0, localh1.width, localh1.height);
      i = 0;
      paramh2 = paramh1;
      if (i >= paramList.size()) {
        break label376;
      }
      localObject = (VideoFilterBase)paramList.get(i);
      if (!needRender((VideoFilterBase)localObject)) {
        break label373;
      }
      if (VideoFilterUtil.canUseBlendMode((VideoFilterBase)localObject)) {
        break label335;
      }
      localh1 = paramh2;
      if (VideoFilterUtil.needCopy((VideoFilterBase)localObject))
      {
        GlUtil.setBlendMode(false);
        localh1 = FrameUtil.renderProcessBySwitchFbo(paramh2.texture[0], paramh2.width, paramh2.height, this.mCopyFilter, paramh1, localh2);
        GlUtil.setBlendMode(true);
      }
      BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + localObject.getClass().getName());
      if ((!VideoFilterUtil.maybeTransformFilter((VideoFilterBase)localObject)) || (!VideoMaterialUtil.needCopyTransform())) {
        break label306;
      }
      paramh2 = VideoFrameUtil.renderProcessByCopy(localh1.texture[0], localh1.width, localh1.height, (VideoFilterBase)localObject, this.mCopyFilter, paramh1, localh2);
      label249:
      BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + localObject.getClass().getName());
      localObject = paramh2;
      localh1 = paramh2;
      paramh2 = (h)localObject;
    }
    label306:
    label335:
    label373:
    for (;;)
    {
      i += 1;
      break label92;
      localh2 = this.copyFrame[0];
      break;
      paramh2 = VideoFrameUtil.renderProcessBySwitchFbo(localh1.texture[0], localh1.width, localh1.height, (VideoFilterBase)localObject, paramh1, localh2);
      break label249;
      BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
      ((VideoFilterBase)localObject).OnDrawFrameGLSL();
      ((VideoFilterBase)localObject).renderTexture(paramh2.texture[0], paramh2.width, paramh2.height);
      BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
    }
    label376:
    AppMethodBeat.o(83082);
    return localh1;
  }
  
  private h RenderProcessForFilters(h paramh, List<? extends VideoFilterBase> paramList)
  {
    AppMethodBeat.i(83081);
    paramh = RenderProcessForFilters(paramh, null, paramList);
    AppMethodBeat.o(83081);
    return paramh;
  }
  
  private void clearAgeRangeItemStatus()
  {
    AppMethodBeat.i(83102);
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        Object localObject = (VideoFilterBase)this.filters.get(i);
        if ((localObject instanceof NormalVideoFilter))
        {
          localObject = ((NormalVideoFilter)localObject).getStickerItem();
          if ((localObject != null) && (((StickerItem)localObject).ageRange != null)) {
            ((StickerItem)localObject).ageRange.clearStatus();
          }
        }
        i += 1;
      }
    }
    this.mAgeValueMap.clear();
    AppMethodBeat.o(83102);
  }
  
  private void clearCharmRangeItemStatus()
  {
    AppMethodBeat.i(83100);
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        Object localObject = (VideoFilterBase)this.filters.get(i);
        if ((localObject instanceof NormalVideoFilter))
        {
          localObject = ((NormalVideoFilter)localObject).getStickerItem();
          if ((localObject != null) && (((StickerItem)localObject).charmRange != null)) {
            ((StickerItem)localObject).charmRange.clearStatus();
          }
        }
        i += 1;
      }
    }
    this.mCharmValueMap.clear();
    AppMethodBeat.o(83100);
  }
  
  private void clearCpRangeItemStatus()
  {
    AppMethodBeat.i(83105);
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        Object localObject = (VideoFilterBase)this.filters.get(i);
        if ((localObject instanceof NormalVideoFilter))
        {
          localObject = ((NormalVideoFilter)localObject).getStickerItem();
          if ((localObject != null) && (((StickerItem)localObject).cpRange != null)) {
            ((StickerItem)localObject).cpRange.clearStatus();
          }
        }
        i += 1;
      }
    }
    this.mCpValueMap.clear();
    AppMethodBeat.o(83105);
  }
  
  private void clearFaceMappingData()
  {
    AppMethodBeat.i(83107);
    this.mFaceList.clear();
    AppMethodBeat.o(83107);
  }
  
  private void clearGenderRangeItemStatus()
  {
    AppMethodBeat.i(83103);
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        Object localObject = (VideoFilterBase)this.filters.get(i);
        if ((localObject instanceof NormalVideoFilter))
        {
          localObject = ((NormalVideoFilter)localObject).getStickerItem();
          if ((localObject != null) && (((StickerItem)localObject).genderRange != null)) {
            ((StickerItem)localObject).genderRange.clearStatus();
          }
        }
        i += 1;
      }
    }
    this.mGenderValueMap.clear();
    AppMethodBeat.o(83103);
  }
  
  private void clearHandsRangeItemStatus()
  {
    AppMethodBeat.i(83101);
    if (this.gestureFilters != null)
    {
      int i = 0;
      while (i < this.gestureFilters.size())
      {
        StickerItem localStickerItem = ((NormalVideoFilter)this.gestureFilters.get(i)).getStickerItem();
        if ((localStickerItem != null) && (localStickerItem.charmRange != null)) {
          localStickerItem.charmRange.clearStatus();
        }
        i += 1;
      }
    }
    this.mHandsValueMap.clear();
    AppMethodBeat.o(83101);
  }
  
  private void clearPopularRangeItemStatus()
  {
    AppMethodBeat.i(83104);
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        Object localObject = (VideoFilterBase)this.filters.get(i);
        if ((localObject instanceof NormalVideoFilter))
        {
          localObject = ((NormalVideoFilter)localObject).getStickerItem();
          if ((localObject != null) && (((StickerItem)localObject).popularRange != null)) {
            ((StickerItem)localObject).popularRange.clearStatus();
          }
        }
        i += 1;
      }
    }
    this.mPopularValueMap.clear();
    AppMethodBeat.o(83104);
  }
  
  private void destroyNormalAudio()
  {
    AppMethodBeat.i(83115);
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).destroyAudio();
      }
    }
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.destroyAudio();
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.destroyAudio();
    }
    if (this.audio3DFilter != null) {
      this.audio3DFilter.destroyAudio();
    }
    AppMethodBeat.o(83115);
  }
  
  private float getAdjustedAge(float paramFloat)
  {
    float f;
    if ((paramFloat >= 0.21D) && (paramFloat <= 0.25D)) {
      f = (float)(paramFloat * 0.8D);
    }
    do
    {
      do
      {
        return f;
        if ((paramFloat >= 0.26D) && (paramFloat <= 0.3D)) {
          return (float)(paramFloat * 0.7D);
        }
        if ((paramFloat >= 0.31D) && (paramFloat <= 0.49D)) {
          return (float)(paramFloat * 0.6D);
        }
        f = paramFloat;
      } while (paramFloat < 0.5D);
      f = paramFloat;
    } while (paramFloat > 0.7D);
    return (float)(paramFloat * 0.5D);
  }
  
  private List<VideoFilterBase> getExcludeFilters(List<? extends VideoFilterBase> paramList, List<VideoFilterBase> paramList1)
  {
    AppMethodBeat.i(83129);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      if (!paramList1.contains(localVideoFilterBase)) {
        localArrayList.add(localVideoFilterBase);
      }
    }
    AppMethodBeat.o(83129);
    return localArrayList;
  }
  
  private List<Integer> getNewFaceIndexList(int paramInt, Set<Integer> paramSet, List<Face> paramList)
  {
    AppMethodBeat.i(83135);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add(Integer.valueOf(((Face)paramList.get(((Integer)paramSet.next()).intValue())).faceIndex));
    }
    int i = 0;
    while (localArrayList.size() < paramInt)
    {
      if (!localHashSet.contains(Integer.valueOf(i))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    AppMethodBeat.o(83135);
    return localArrayList;
  }
  
  private List<VideoFilterBase> getStaticStickerFilters(List<? extends VideoFilterBase> paramList)
  {
    AppMethodBeat.i(83128);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      if (((localVideoFilterBase instanceof StaticStickerFilter)) || ((localVideoFilterBase instanceof StaticNumFilter)) || (((localVideoFilterBase instanceof ParticleFilter)) && (((ParticleFilter)localVideoFilterBase).isStatic()))) {
        localArrayList.add(localVideoFilterBase);
      }
    }
    AppMethodBeat.o(83128);
    return localArrayList;
  }
  
  private List<VideoFilterBase> getStickerFilters(List<? extends VideoFilterBase> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(83118);
    List localList = getStaticStickerFilters(paramList);
    paramList = getExcludeFilters(paramList, localList);
    if (paramBoolean1)
    {
      paramList = getZIndexFilters(localList, paramBoolean2);
      AppMethodBeat.o(83118);
      return paramList;
    }
    paramList = getZIndexFilters(paramList, paramBoolean2);
    AppMethodBeat.o(83118);
    return paramList;
  }
  
  private List<VideoFilterBase> getZIndexFilters(List<VideoFilterBase> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(83119);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      int i = 0;
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        i = ((NormalVideoFilter)localVideoFilterBase).getStickerItem().zIndex;
      }
      if ((localVideoFilterBase instanceof VoiceTextFilter)) {
        i = ((VoiceTextFilter)localVideoFilterBase).getZIndex();
      }
      if (paramBoolean)
      {
        if (i >= 0) {
          localArrayList.add(localVideoFilterBase);
        }
      }
      else if (i < 0) {
        localArrayList.add(localVideoFilterBase);
      }
    }
    AppMethodBeat.o(83119);
    return localArrayList;
  }
  
  private boolean hasHands(List<PointF> paramList)
  {
    AppMethodBeat.i(83091);
    if ((paramList != null) && (paramList.size() > 0) && (this.gestureFilters != null) && (this.gestureFilters.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (PointF)paramList.next();
        float f1 = ((PointF)localObject).x;
        float f2 = ((PointF)localObject).x;
        float f3 = ((PointF)localObject).y;
        if (((PointF)localObject).y * f3 + f1 * f2 >= 0.0001D)
        {
          localObject = (NormalVideoFilter)this.gestureFilters.get(0);
          if ((localObject != null) && (((NormalVideoFilter)localObject).getStickerItem() != null))
          {
            boolean bool = GestureDetector.getInstance().isGestureTriggered(((NormalVideoFilter)localObject).getStickerItem().triggerType);
            AppMethodBeat.o(83091);
            return bool;
          }
        }
      }
    }
    AppMethodBeat.o(83091);
    return false;
  }
  
  private void hitAgeRangeItem(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, int paramInt)
  {
    AppMethodBeat.i(83097);
    if (!paramVideoPreviewFaceOutlineDetector.needDetectFaceValue())
    {
      AppMethodBeat.o(83097);
      return;
    }
    if (this.filters != null)
    {
      if ((!this.mAgeValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mAgeValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
      {
        float f = paramVideoPreviewFaceOutlineDetector.getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value);
        if ((int)(f * 100.0F) == 0)
        {
          AppMethodBeat.o(83097);
          return;
        }
        f = getAdjustedAge(f);
        this.mAgeValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
      }
      int i = 0;
      while (i < this.filters.size())
      {
        paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)this.filters.get(i);
        if ((paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter))
        {
          StickerItem localStickerItem = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
          if (localStickerItem != null)
          {
            if (localStickerItem.ageRange != null) {
              localStickerItem.ageRange.setValue(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue());
            }
            if (((paramVideoPreviewFaceOutlineDetector instanceof DynamicNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value)) {
              ((DynamicNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
            }
            if (((paramVideoPreviewFaceOutlineDetector instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value)) {
              ((StaticNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
            }
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(83097);
  }
  
  private void hitCharmRangeItem(int paramInt)
  {
    AppMethodBeat.i(83088);
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        Object localObject1 = (VideoFilterBase)this.filters.get(i);
        Object localObject2;
        if ((localObject1 instanceof NormalVideoFilter))
        {
          localObject2 = ((NormalVideoFilter)localObject1).getStickerItem();
          if ((localObject2 != null) && (((StickerItem)localObject2).charmRange != null)) {
            ((StickerItem)localObject2).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
          }
        }
        if ((localObject1 instanceof FaceOffFilter))
        {
          localObject2 = ((FaceOffFilter)localObject1).getFaceOffItem();
          if ((localObject2 != null) && (((FaceItem)localObject2).charmRange != null)) {
            ((FaceItem)localObject2).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
          }
        }
        if ((localObject1 instanceof TransformFilter))
        {
          localObject1 = ((TransformFilter)localObject1).getFaceMeshItem();
          if ((localObject1 != null) && (((FaceMeshItem)localObject1).charmRange != null)) {
            ((FaceMeshItem)localObject1).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(83088);
  }
  
  private void hitCpRangeItem(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(83099);
    if ((!paramVideoPreviewFaceOutlineDetector.needDetectFaceValue()) || (paramInt2 < 2))
    {
      AppMethodBeat.o(83099);
      return;
    }
    if (this.filters != null)
    {
      if ((!this.mCpValueMap.containsKey(Integer.valueOf(paramInt1))) || ((this.mCpValueMap.containsKey(Integer.valueOf(paramInt1))) && (((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue() < 0.0F)))
      {
        float f = paramVideoPreviewFaceOutlineDetector.getFaceValues(paramInt1, FaceDetector.DETECT_TYPE.DETECT_TYPE_CP.value);
        if ((int)(f * 100.0F) == 0)
        {
          AppMethodBeat.o(83099);
          return;
        }
        this.mCpValueMap.put(Integer.valueOf(paramInt1), Float.valueOf(f));
      }
      paramInt2 = 0;
      while (paramInt2 < this.filters.size())
      {
        paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)this.filters.get(paramInt2);
        if ((paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter))
        {
          StickerItem localStickerItem = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
          if (localStickerItem != null)
          {
            if (localStickerItem.cpRange != null) {
              localStickerItem.cpRange.setValue(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue());
            }
            if (((paramVideoPreviewFaceOutlineDetector instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_CP.value)) {
              ((StaticNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue() * 100.0F));
            }
          }
        }
        paramInt2 += 1;
      }
    }
    AppMethodBeat.o(83099);
  }
  
  private void hitFaceRandomGroupItem(int paramInt)
  {
    AppMethodBeat.i(83089);
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(i);
        if ((localVideoFilterBase instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localVideoFilterBase).updateRandomGroupValue(RandomGroupManager.getInstance().getFaceValue(paramInt));
        }
        if ((localVideoFilterBase instanceof FaceOffFilter)) {
          ((FaceOffFilter)localVideoFilterBase).updateRandomGroupValue(RandomGroupManager.getInstance().getFaceValue(paramInt));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(83089);
  }
  
  private void hitGenderRangeItem(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, int paramInt)
  {
    AppMethodBeat.i(83098);
    if (!paramVideoPreviewFaceOutlineDetector.needDetectFaceValue())
    {
      AppMethodBeat.o(83098);
      return;
    }
    if (this.filters != null)
    {
      if ((!this.mGenderValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mGenderValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
      {
        float f = paramVideoPreviewFaceOutlineDetector.getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value);
        if ((int)(f * 100.0F) == 0)
        {
          AppMethodBeat.o(83098);
          return;
        }
        this.mGenderValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
      }
      int i = 0;
      while (i < this.filters.size())
      {
        paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)this.filters.get(i);
        if ((paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter))
        {
          StickerItem localStickerItem = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
          if (localStickerItem != null)
          {
            if (localStickerItem.genderRange != null) {
              localStickerItem.genderRange.setValue(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue());
            }
            if (((paramVideoPreviewFaceOutlineDetector instanceof DynamicNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value)) {
              ((DynamicNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
            }
            if (((paramVideoPreviewFaceOutlineDetector instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value)) {
              ((StaticNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
            }
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(83098);
  }
  
  private void hitHandRandomGroupItem()
  {
    AppMethodBeat.i(83090);
    if (this.gestureFilters != null)
    {
      int i = 0;
      while (i < this.gestureFilters.size())
      {
        ((NormalVideoFilter)this.gestureFilters.get(i)).updateRandomGroupValue(RandomGroupManager.getInstance().getHandValue());
        i += 1;
      }
    }
    AppMethodBeat.o(83090);
  }
  
  private void hitHandsRangeItem()
  {
    AppMethodBeat.i(83095);
    if (!this.mHandsValueMap.containsKey(Integer.valueOf(0)))
    {
      AppMethodBeat.o(83095);
      return;
    }
    if (this.gestureFilters != null)
    {
      int i = 0;
      while (i < this.gestureFilters.size())
      {
        StickerItem localStickerItem = ((NormalVideoFilter)this.gestureFilters.get(i)).getStickerItem();
        if ((localStickerItem != null) && (localStickerItem.charmRange != null)) {
          localStickerItem.charmRange.hit(((Double)this.mHandsValueMap.get(Integer.valueOf(0))).doubleValue());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(83095);
  }
  
  private void hitPopularRangeItem(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, int paramInt)
  {
    AppMethodBeat.i(83096);
    if (!paramVideoPreviewFaceOutlineDetector.needDetectFaceValue())
    {
      AppMethodBeat.o(83096);
      return;
    }
    if (this.filters != null)
    {
      if ((!this.mPopularValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mPopularValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
      {
        float f = paramVideoPreviewFaceOutlineDetector.getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value);
        if ((int)(f * 100.0F) == 0)
        {
          AppMethodBeat.o(83096);
          return;
        }
        this.mPopularValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
      }
      int i = 0;
      while (i < this.filters.size())
      {
        paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)this.filters.get(i);
        if ((paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter))
        {
          StickerItem localStickerItem = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
          if (localStickerItem != null)
          {
            if (localStickerItem.popularRange != null) {
              localStickerItem.popularRange.setValue(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue());
            }
            if (((paramVideoPreviewFaceOutlineDetector instanceof DynamicNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value)) {
              ((DynamicNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
            }
            if (((paramVideoPreviewFaceOutlineDetector instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value)) {
              ((StaticNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
            }
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(83096);
  }
  
  private void init()
  {
    AppMethodBeat.i(83108);
    this.mCurPersonId = -1;
    MaterialManager.getInstance().setCurrentMaterial(this.material);
    AppMethodBeat.o(83108);
  }
  
  private boolean isHandPointsValid(List<PointF> paramList)
  {
    AppMethodBeat.i(83092);
    if (paramList == null)
    {
      AppMethodBeat.o(83092);
      return false;
    }
    paramList = paramList.iterator();
    PointF localPointF;
    float f1;
    float f2;
    float f3;
    float f4;
    for (int i = 0; paramList.hasNext(); i = (int)(localPointF.y * f4 + f2 * f3 + f1))
    {
      localPointF = (PointF)paramList.next();
      f1 = i;
      f2 = localPointF.x;
      f3 = localPointF.x;
      f4 = localPointF.y;
    }
    if (i > 0.0001D)
    {
      AppMethodBeat.o(83092);
      return true;
    }
    AppMethodBeat.o(83092);
    return false;
  }
  
  private void mappingFace(List<Face> paramList, List<List<PointF>> paramList1, List<float[]> paramList2, int paramInt)
  {
    AppMethodBeat.i(83134);
    Object localObject3 = new HashSet();
    Object localObject1 = new HashSet();
    int j = 0;
    Object localObject5;
    while (j < paramList1.size())
    {
      localObject2 = (List)paramList1.get(j);
      localObject4 = (float[])paramList2.get(j);
      localObject5 = (PointF)((List)localObject2).get(64);
      int k = -1;
      double d1 = paramInt * 0.1D;
      i = 0;
      while (i < paramList.size())
      {
        double d2 = d1;
        int m = k;
        if (!((Set)localObject3).contains(Integer.valueOf(i)))
        {
          double d3 = AlgoUtils.getDistance((PointF)localObject5, (PointF)((Face)paramList.get(i)).facePoints.get(64));
          d2 = d1;
          m = k;
          if (d3 < d1)
          {
            d2 = d3;
            m = i;
          }
        }
        i += 1;
        d1 = d2;
        k = m;
      }
      if (k != -1)
      {
        ((Set)localObject3).add(Integer.valueOf(k));
        ((Set)localObject1).add(Integer.valueOf(j));
        ((Face)paramList.get(k)).facePoints = ((List)localObject2);
        ((Face)paramList.get(k)).faceAngles = ((float[])localObject4);
      }
      j += 1;
    }
    Object localObject4 = new HashSet();
    Object localObject2 = new ArrayList();
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      ((Set)localObject4).add(Integer.valueOf(((Face)paramList.get(paramInt)).faceIndex));
      if (((Set)localObject3).contains(Integer.valueOf(paramInt))) {
        ((List)localObject2).add(paramList.get(paramInt));
      }
      paramInt += 1;
    }
    localObject3 = getNewFaceIndexList(paramList1.size() - ((Set)localObject1).size(), (Set)localObject3, paramList);
    int i = 0;
    paramInt = 0;
    if (i < paramList1.size())
    {
      if (((Set)localObject1).contains(Integer.valueOf(i))) {
        break label659;
      }
      localObject5 = new Face();
      ((Face)localObject5).facePoints = ((List)paramList1.get(i));
      ((Face)localObject5).faceAngles = ((float[])paramList2.get(i));
      ((Face)localObject5).faceIndex = ((Integer)((List)localObject3).get(paramInt)).intValue();
      this.mCharmValueMap.remove(Integer.valueOf(((Face)localObject5).faceIndex));
      ((List)localObject2).add(localObject5);
      paramInt += 1;
    }
    label659:
    for (;;)
    {
      i += 1;
      break;
      paramList1 = new HashSet();
      paramInt = 0;
      while (paramInt < ((List)localObject2).size())
      {
        paramList1.add(Integer.valueOf(((Face)((List)localObject2).get(paramInt)).faceIndex));
        paramInt += 1;
      }
      paramList2 = ((Set)localObject4).iterator();
      while (paramList2.hasNext())
      {
        localObject1 = (Integer)paramList2.next();
        if (!paramList1.contains(localObject1)) {
          removeValueRangeForFace(((Integer)localObject1).intValue());
        }
      }
      paramList.clear();
      paramList.addAll((Collection)localObject2);
      AppMethodBeat.o(83134);
      return;
    }
  }
  
  private boolean needRender(VideoFilterBase paramVideoFilterBase)
  {
    AppMethodBeat.i(83137);
    Object localObject;
    if ((paramVideoFilterBase instanceof NormalVideoFilter))
    {
      localObject = ((NormalVideoFilter)paramVideoFilterBase).getStickerItem();
      if ((localObject == null) || (!((NormalVideoFilter)paramVideoFilterBase).isRenderReady()))
      {
        AppMethodBeat.o(83137);
        return false;
      }
      if (this.mCurPersonId == -1)
      {
        AppMethodBeat.o(83137);
        return true;
      }
      if ((((StickerItem)localObject).personID != -1) && (((StickerItem)localObject).personID != this.mCurPersonId))
      {
        AppMethodBeat.o(83137);
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof FaceOffFilter))
    {
      localObject = (FaceOffFilter)paramVideoFilterBase;
      FaceItem localFaceItem = ((FaceOffFilter)localObject).getFaceOffItem();
      if ((localFaceItem == null) || (!((FaceOffFilter)localObject).isRenderReady()))
      {
        AppMethodBeat.o(83137);
        return false;
      }
      if (this.mCurPersonId == -1)
      {
        AppMethodBeat.o(83137);
        return true;
      }
      if ((localFaceItem.personID != -1) && (localFaceItem.personID != this.mCurPersonId))
      {
        AppMethodBeat.o(83137);
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof TransformFilter))
    {
      localObject = ((TransformFilter)paramVideoFilterBase).getFaceMeshItem();
      if ((localObject != null) && (((((FaceMeshItem)localObject).personID != -1) && (this.mCurPersonId != -1) && (((FaceMeshItem)localObject).personID != this.mCurPersonId)) || ((this.mCurPersonId != -1) && (((FaceMeshItem)localObject).charmRange != null) && (!((FaceMeshItem)localObject).charmRange.isHit()))))
      {
        AppMethodBeat.o(83137);
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof FaceCropFilter))
    {
      boolean bool = ((FaceCropFilter)paramVideoFilterBase).isNeedRender();
      AppMethodBeat.o(83137);
      return bool;
    }
    AppMethodBeat.o(83137);
    return true;
  }
  
  private void processMappingFace(List<List<PointF>> paramList, List<float[]> paramList1, int paramInt)
  {
    AppMethodBeat.i(83124);
    Face localFace;
    if (!this.mFaceList.isEmpty())
    {
      if (this.gameFilter == null)
      {
        mappingFace(this.mFaceList, paramList, paramList1, paramInt);
        Collections.sort(this.mFaceList, this.mFaceIndexComperator);
        AppMethodBeat.o(83124);
        return;
      }
      this.mFaceList.clear();
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        localFace = new Face();
        localFace.facePoints = ((List)paramList.get(paramInt));
        localFace.faceAngles = ((float[])paramList1.get(paramInt));
        localFace.faceIndex = paramInt;
        this.mFaceList.add(localFace);
        paramInt += 1;
      }
      AppMethodBeat.o(83124);
      return;
    }
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      localFace = new Face();
      localFace.facePoints = ((List)paramList.get(paramInt));
      localFace.faceAngles = ((float[])paramList1.get(paramInt));
      localFace.faceIndex = paramInt;
      this.mFaceList.add(localFace);
      paramInt += 1;
    }
    AppMethodBeat.o(83124);
  }
  
  private void removeValueRangeForFace(int paramInt)
  {
    AppMethodBeat.i(83106);
    this.mCharmValueMap.remove(Integer.valueOf(paramInt));
    this.mAgeValueMap.remove(Integer.valueOf(paramInt));
    this.mGenderValueMap.remove(Integer.valueOf(paramInt));
    this.mPopularValueMap.remove(Integer.valueOf(paramInt));
    this.mCpValueMap.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(83106);
  }
  
  private void syncCharmRangeAndHandsRangeValue(boolean paramBoolean)
  {
    AppMethodBeat.i(83093);
    double d;
    if (((!BaseUtils.isEmpty(this.mFaceList)) && (!this.mCharmValueMap.containsKey(Integer.valueOf(((Face)this.mFaceList.get(0)).faceIndex)))) || ((paramBoolean) && (!this.mHandsValueMap.containsKey(Integer.valueOf(0))))) {
      d = mRandom.nextDouble();
    }
    for (;;)
    {
      if (d < 0.0D) {
        d = mRandom.nextDouble();
      }
      for (;;)
      {
        if (!BaseUtils.isEmpty(this.mFaceList))
        {
          i = ((Face)this.mFaceList.get(0)).faceIndex;
          this.mCharmValueMap.put(Integer.valueOf(i), Double.valueOf(d));
        }
        int i = 1;
        for (;;)
        {
          if (i < this.mFaceList.size())
          {
            int j = ((Face)this.mFaceList.get(i)).faceIndex;
            if (!this.mCharmValueMap.containsKey(Integer.valueOf(j))) {
              this.mCharmValueMap.put(Integer.valueOf(((Face)this.mFaceList.get(i)).faceIndex), Double.valueOf(mRandom.nextDouble()));
            }
            i += 1;
            continue;
            if ((!BaseUtils.isEmpty(this.mFaceList)) && (this.mCharmValueMap.containsKey(Integer.valueOf(((Face)this.mFaceList.get(0)).faceIndex))))
            {
              d = ((Double)this.mCharmValueMap.get(Integer.valueOf(((Face)this.mFaceList.get(0)).faceIndex))).doubleValue();
              break;
            }
            if (!this.mHandsValueMap.containsKey(Integer.valueOf(0))) {
              break label385;
            }
            d = ((Double)this.mHandsValueMap.get(Integer.valueOf(0))).doubleValue();
            break;
          }
        }
        if (paramBoolean) {
          this.mHandsValueMap.put(Integer.valueOf(0), Double.valueOf(d));
        }
        AppMethodBeat.o(83093);
        return;
      }
      label385:
      d = -1.0D;
    }
  }
  
  private void syncRandomGroupValue(boolean paramBoolean)
  {
    AppMethodBeat.i(83094);
    if (this.material.getRandomGroupCount() <= 0)
    {
      AppMethodBeat.o(83094);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mFaceList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Integer.valueOf(((Face)localIterator.next()).faceIndex));
    }
    RandomGroupManager.getInstance().updateValue(localArrayList, paramBoolean, this.material.getRandomGroupCount());
    AppMethodBeat.o(83094);
  }
  
  private h updateAndRender(h paramh, PTFaceAttr paramPTFaceAttr)
  {
    AppMethodBeat.i(83122);
    Object localObject4 = paramPTFaceAttr.getAllFacePoints();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    Object localObject2 = paramPTFaceAttr.getBodyPoints();
    Object localObject3 = paramPTFaceAttr.getAllFaceAngles();
    long l = paramPTFaceAttr.getTimeStamp();
    GlUtil.setBlendMode(true);
    GLES20.glBindFramebuffer(36160, paramh.bte[0]);
    GLES20.glViewport(0, 0, paramh.width, paramh.height);
    Object localObject1 = paramh;
    if (this.mEffectOrder == 1)
    {
      localObject1 = paramh;
      if (this.mEffectFilter != null)
      {
        this.mEffectFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mEffectFrame);
        localObject1 = this.mEffectFrame;
      }
    }
    if (VideoMaterialUtil.isFaceSwitchMaterial(getMaterial()))
    {
      this.mCopyFilter.RenderProcess(localObject1.texture[0], ((h)localObject1).width, ((h)localObject1).height, -1, 0.0D, this.copyFrame[0]);
      GLES20.glBindFramebuffer(36160, localObject1.bte[0]);
      GLES20.glViewport(0, 0, ((h)localObject1).width, ((h)localObject1).height);
      paramh = (h)localObject1;
    }
    int i;
    for (;;)
    {
      GlUtil.setBlendMode(false);
      AppMethodBeat.o(83122);
      return paramh;
      if (getMaterial().getShaderType() == VideoMaterialUtil.SHADER_TYPE.DOODLE.value)
      {
        paramPTFaceAttr = this.filters.iterator();
        for (;;)
        {
          paramh = (h)localObject1;
          if (!paramPTFaceAttr.hasNext()) {
            break;
          }
          paramh = (VideoFilterBase)paramPTFaceAttr.next();
          if ((paramh instanceof DoodleFilter))
          {
            paramh = (DoodleFilter)paramh;
            paramh.setTouchPoints((List)localObject4, this.mTouchPoints, ((h)localObject1).width, ((h)localObject1).height, this.mScaleFace);
            paramh.renderProcess();
          }
        }
      }
      if (getMaterial().getShaderType() != VideoMaterialUtil.SHADER_TYPE.AUDIO3D.value) {
        break;
      }
      paramPTFaceAttr.getRotation();
      paramh = (h)localObject1;
      if (this.audio3DFilter != null)
      {
        BenchUtil.benchStart("[showPreview]RenderProcessForAudio3DFilter");
        i = Math.min(((List)localObject4).size(), getMaterial().getMaxFaceCount());
        paramh = RenderProcessForAudio3DFilter((h)localObject1, this.multiViewerOutFrame, this.mFaceList, i, paramPTFaceAttr, this.mCurPersonId);
        BenchUtil.benchEnd("[showPreview]RenderProcessForAudio3DFilter");
      }
    }
    int j = Math.min(((List)localObject4).size(), getMaterial().getMaxFaceCount());
    if (((List)localObject2).size() == 0)
    {
      localObject2 = new ArrayList();
      if ((this.crazyFaceFilters == null) || (j <= 0)) {
        break label1170;
      }
      paramh = (float[])((List)localObject3).get(0);
      localObject4 = (List)((List)localObject4).get(0);
      if (!FaceAverageUtil.isPositiveFace(paramh, (List)localObject4, ((h)localObject1).width, ((h)localObject1).height, this.mFaceDetScale)) {
        break label863;
      }
    }
    label1170:
    for (paramh = this.crazyFaceFilters.updateAndRender((h)localObject1, ((h)localObject1).width, ((h)localObject1).height, (List)localObject4, paramh);; paramh = (h)localObject1)
    {
      localObject1 = paramh;
      if (j <= 0)
      {
        setCurPersonId(-1);
        localObject1 = new PTDetectInfo.Builder().triggeredExpression(localSet).timestamp(l).build();
        updateFilters((PTDetectInfo)localObject1, this.fgDynamicFilters);
        paramh = RenderProcessForFilters(paramh, this.fgDynamicFilters);
        updateFilters((PTDetectInfo)localObject1, this.faceParticleDynamicFilters);
        localObject1 = RenderProcessForFilters(paramh, this.faceParticleDynamicFilters);
      }
      paramh = (h)localObject1;
      if (this.fastFaceStickerFilter != null)
      {
        BenchUtil.benchStart("[showPreview]RenderProcessForFastFaceStickerFilter");
        paramh = RenderProcessForFastFaceStickerFilter((h)localObject1, this.multiViewerOutFrame, this.mFaceList, j, paramPTFaceAttr, this.mCurPersonId);
        BenchUtil.benchEnd("[showPreview]RenderProcessForFastFaceStickerFilter");
      }
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          localObject1 = (Face)this.mFaceList.get(i);
          setCurPersonId(((Face)localObject1).faceIndex);
          hitCharmRangeItem(((Face)localObject1).faceIndex);
          hitFaceRandomGroupItem(((Face)localObject1).faceIndex);
          hitAgeRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject1).faceIndex);
          hitGenderRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject1).faceIndex);
          hitPopularRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject1).faceIndex);
          hitCpRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject1).faceIndex, j);
          BenchUtil.benchStart("[showPreview]RenderProcess");
          localObject1 = new PTDetectInfo.Builder().facePoints(((Face)localObject1).facePoints).faceAngles(((Face)localObject1).faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
          updateFilters((PTDetectInfo)localObject1, this.fgDynamicFilters);
          paramh = RenderProcessForFilters(paramh, this.multiViewerOutFrame, this.fgDynamicFilters);
          updateFilters((PTDetectInfo)localObject1, this.faceParticleDynamicFilters);
          paramh = RenderProcessForFilters(paramh, this.multiViewerOutFrame, this.faceParticleDynamicFilters);
          BenchUtil.benchEnd("[showPreview]RenderProcess");
          i += 1;
          continue;
          localObject2 = (List)((List)localObject2).get(0);
          break;
          label863:
          AppMethodBeat.o(83122);
          return localObject1;
        }
      }
      if (this.mPhantomFilter != null)
      {
        GlUtil.setBlendMode(false);
        this.mPhantomFilter.updatePreview(paramPTFaceAttr.getTimeStamp());
        this.mPhantomFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mPhantomFrame);
        paramh = this.mPhantomFrame;
        GlUtil.setBlendMode(true);
      }
      for (;;)
      {
        localObject4 = new PTDetectInfo.Builder().handPoints(paramPTFaceAttr.getHandPoints()).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector());
        if (((List)localObject3).size() > 0) {}
        for (localObject1 = (float[])((List)localObject3).get(0);; localObject1 = null)
        {
          localObject3 = ((PTDetectInfo.Builder)localObject4).faceAngles((float[])localObject1).build();
          localObject1 = paramh;
          if (isHandPointsValid(paramPTFaceAttr.getHandPoints()))
          {
            updateFilters((PTDetectInfo)localObject3, this.gestureFilters);
            paramh = RenderProcessForFilters(paramh, this.gestureFilters);
            updateFilters((PTDetectInfo)localObject3, this.gestureParticleFilters);
            localObject1 = RenderProcessForFilters(paramh, this.gestureParticleFilters);
          }
          paramPTFaceAttr = new PTDetectInfo.Builder().triggeredExpression(localSet).bodyPoints((List)localObject2).timestamp(l).build();
          paramh = (h)localObject1;
          if (this.fastBodyStickerFilter != null)
          {
            BenchUtil.benchStart("[showPreview]RenderProcessForFastBodyStickerFilter");
            paramh = RenderProcessForFastBodyStickerFilter((h)localObject1, null, paramPTFaceAttr);
            BenchUtil.benchEnd("[showPreview]RenderProcessForFastBodyStickerFilter");
          }
          updateFilters(paramPTFaceAttr, this.bodyFilters);
          paramh = RenderProcessForFilters(paramh, this.bodyFilters);
          updateFilters(paramPTFaceAttr, this.bodyParticleFilters);
          paramh = RenderProcessForFastParticleFilter(paramh, this.bodyParticleFilters);
          break;
        }
      }
    }
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(83116);
    init();
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.gestureFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.bodyFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.faceParticleDynamicFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.faceParticleStaticFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.gestureParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.bodyParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.headCropItemFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.ApplyGLSLFilter(this.material.getDataPath());
    }
    if (this.headCropFilter != null) {
      this.headCropFilter.ApplyGLSLFilter();
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.ApplyGLSLFilter();
    }
    if (this.mFacialFeatureFilterList != null)
    {
      localIterator = this.mFacialFeatureFilterList.iterator();
      while (localIterator.hasNext()) {
        ((FacialFeatureFilter)localIterator.next()).ApplyGLSLFilter();
      }
    }
    if (this.mLipsCosFilter != null) {
      this.mLipsCosFilter.ApplyGLSLFilter();
    }
    if (this.mPhantomFilter != null) {
      this.mPhantomFilter.ApplyGLSLFilter();
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.ApplyGLSLFilter();
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.ApplyGLSLFilter();
    }
    if (this.voiceTextFilter != null) {
      this.voiceTextFilter.ApplyGLSLFilter();
    }
    if (this.mActFilters != null) {
      this.mActFilters.ApplyGLSLFilter();
    }
    if (this.multiViewerFilters != null)
    {
      localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext()) {
        ((MultiViewerFilter)localIterator.next()).ApplyGLSLFilter();
      }
    }
    if (this.gameFilter != null) {
      this.gameFilter.applyGLSLFilter();
    }
    if (isSegmentRequired())
    {
      this.fabbyExtractFilter = new FabbyExtractFilter();
      this.fabbyStrokeFilter = new FabbyStrokeFilter();
      this.fastBlurFilter = new FastBlurFilter();
      this.mMaskFilter = new BaseFilter(VideoFilterFactory.FRAGMENT_SHADER_MASK);
      this.fabbyExtractFilter.ApplyGLSLFilter();
      this.fabbyStrokeFilter.ApplyGLSLFilter();
      this.fastBlurFilter.ApplyGLSLFilter();
      this.mMaskFilter.ApplyGLSLFilter();
    }
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.ApplyGLSLFilter();
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.ApplyGLSLFilter();
    }
    if (this.audio3DFilter != null) {
      this.audio3DFilter.ApplyGLSLFilter();
    }
    this.mCopyFilter.ApplyGLSLFilter();
    int i = 0;
    while (i < this.copyFrame.length)
    {
      this.copyFrame[i] = new h();
      i += 1;
    }
    this.fastParticleFilter.applyGLSLFilter();
    AppMethodBeat.o(83116);
  }
  
  public h RenderProcess(h paramh)
  {
    AppMethodBeat.i(83087);
    if (BaseUtils.isEmpty(this.filters))
    {
      AppMethodBeat.o(83087);
      return paramh;
    }
    h localh2;
    int i;
    h localh1;
    label81:
    VideoFilterBase localVideoFilterBase;
    h localh3;
    if (paramh.texture[0] == this.copyFrame[0].texture[0])
    {
      localh2 = this.copyFrame[1];
      GLES20.glBindFramebuffer(36160, paramh.bte[0]);
      GLES20.glViewport(0, 0, paramh.width, paramh.height);
      i = 0;
      localh1 = paramh;
      if (i >= this.filters.size()) {
        break label350;
      }
      localVideoFilterBase = (VideoFilterBase)this.filters.get(i);
      if (!needRender(localVideoFilterBase)) {
        break label347;
      }
      if (VideoFilterUtil.canUseBlendMode(localVideoFilterBase)) {
        break label309;
      }
      localh3 = localh1;
      if (VideoFilterUtil.needCopy(localVideoFilterBase)) {
        localh3 = FrameUtil.renderProcessBySwitchFbo(localh1.texture[0], localh1.width, localh1.height, this.mCopyFilter, paramh, localh2);
      }
      BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
      if ((!VideoFilterUtil.maybeTransformFilter(localVideoFilterBase)) || (!VideoMaterialUtil.needCopyTransform())) {
        break label280;
      }
      localh1 = VideoFrameUtil.renderProcessByCopy(localh3.texture[0], localh3.width, localh3.height, localVideoFilterBase, this.mCopyFilter, paramh, localh2);
      label234:
      BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
    }
    label280:
    label309:
    label347:
    for (;;)
    {
      i += 1;
      break label81;
      localh2 = this.copyFrame[0];
      break;
      localh1 = VideoFrameUtil.renderProcessBySwitchFbo(localh3.texture[0], localh3.width, localh3.height, localVideoFilterBase, paramh, localh2);
      break label234;
      BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
      localVideoFilterBase.OnDrawFrameGLSL();
      localVideoFilterBase.renderTexture(localh1.texture[0], localh1.width, localh1.height);
      BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
    }
    label350:
    AppMethodBeat.o(83087);
    return localh1;
  }
  
  public void addTouchPoint(PointF paramPointF)
  {
    AppMethodBeat.i(83139);
    this.mARTouchPointQueue.offer(paramPointF);
    AppMethodBeat.o(83139);
  }
  
  public void addTouchPoint(PointF paramPointF, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(83136);
    if (paramPointF == null)
    {
      AppMethodBeat.o(83136);
      return;
    }
    if ((paramBoolean) || (this.mTouchPoints.size() == 0)) {
      this.mTouchPoints.add(new ArrayList());
    }
    ((List)this.mTouchPoints.get(this.mTouchPoints.size() - 1)).add(paramPointF);
    this.mScaleFace = paramFloat;
    AppMethodBeat.o(83136);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(83113);
    destroyAudio();
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).clearGLSLSelf();
    }
    localIterator = this.gestureFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).clearGLSLSelf();
    }
    localIterator = this.bodyFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).clearGLSLSelf();
    }
    localIterator = this.faceParticleDynamicFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).clearGLSLSelf();
    }
    localIterator = this.faceParticleStaticFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).clearGLSLSelf();
    }
    localIterator = this.gestureParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).clearGLSLSelf();
    }
    localIterator = this.bodyParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).clearGLSLSelf();
    }
    localIterator = this.headCropItemFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).clearGLSLSelf();
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.clear();
    }
    if (this.multiViewerFilters != null)
    {
      localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext()) {
        ((MultiViewerFilter)localIterator.next()).clear();
      }
    }
    if (this.gameFilter != null) {
      this.gameFilter.clear();
    }
    this.renderFrame.clear();
    this.mEffectFrame.clear();
    this.mEffectTestFrame.clear();
    this.mHeadCropFrame.clear();
    this.mBgFrame.clear();
    this.fabbyStrokeFrame.clear();
    this.fabbyFeatheredMaskStep1.clear();
    this.fabbyFeatheredMaskStep2.clear();
    this.mPhantomFrame.clear();
    int i = 0;
    while (i < this.copyFrame.length)
    {
      this.copyFrame[i].clear();
      i += 1;
    }
    localIterator = this.multiViewerFrameMap.values().iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).clear();
    }
    this.multiViewerFrameMap.clear();
    this.mCopyFilter.ClearGLSL();
    if (this.headCropFilter != null) {
      this.headCropFilter.clearGLSLSelf();
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.clear();
    }
    if (this.mFacialFeatureFilterList != null)
    {
      localIterator = this.mFacialFeatureFilterList.iterator();
      while (localIterator.hasNext()) {
        ((FacialFeatureFilter)localIterator.next()).clearGLSLSelf();
      }
    }
    if (this.mLipsCosFilter != null) {
      this.mLipsCosFilter.clear();
    }
    if (this.mPhantomFilter != null) {
      this.mPhantomFilter.clearGLSLSelf();
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.clear();
    }
    if (this.mActFilters != null) {
      this.mActFilters.clear();
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.clearGLSLSelf();
    }
    if (this.fabbyExtractFilter != null) {
      this.fabbyExtractFilter.ClearGLSL();
    }
    if (this.fabbyStrokeFilter != null) {
      this.fabbyStrokeFilter.ClearGLSL();
    }
    if (this.fastBlurFilter != null) {
      this.fastBlurFilter.ClearGLSL();
    }
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.clearGLSLSelf();
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.clearGLSLSelf();
    }
    if (this.audio3DFilter != null) {
      this.audio3DFilter.clearGLSLSelf();
    }
    if (this.fabbyOriginCopyFrame != null) {
      this.fabbyOriginCopyFrame.clear();
    }
    if (this.voiceTextFilter != null) {
      this.voiceTextFilter.clearGLSLSelf();
    }
    this.fastParticleFilter.clearGLSLSelf();
    destroyAudio();
    AppMethodBeat.o(83113);
  }
  
  public void destroyAudio()
  {
    AppMethodBeat.i(83114);
    destroyNormalAudio();
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.destroyAudioPlayer();
    }
    if (this.mActFilters != null) {
      this.mActFilters.destroyAudio();
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.destroyAudio();
    }
    AppMethodBeat.o(83114);
  }
  
  public h doFabbyStroke(h paramh1, h paramh2)
  {
    AppMethodBeat.i(83147);
    BenchUtil.benchStart("[showPreview][FABBY] doFabbyStroke");
    if (this.material.getSegmentStrokeWidth() > 0.0D)
    {
      this.fabbyStrokeFilter.setmMaskTex(paramh2.texture[0]);
      this.fabbyStrokeFilter.setStepX(1.0F / paramh1.width);
      this.fabbyStrokeFilter.setStepY(1.0F / paramh1.height);
      this.fabbyStrokeFilter.setStrokeGapInPixel((float)this.material.getSegmentStrokeGap() * Math.min(paramh1.width, paramh1.height));
      this.fabbyStrokeFilter.setStrokeWidthInPixel((float)this.material.getSegmentStrokeWidth() * Math.min(paramh1.width, paramh1.height));
      this.fabbyStrokeFilter.setStrokeColor(this.material.getSegmentStrokeColor());
      this.fabbyStrokeFilter.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, this.fabbyStrokeFrame);
    }
    for (;;)
    {
      BenchUtil.benchEnd("[showPreview][FABBY] doFabbyStroke");
      paramh1 = this.fabbyStrokeFrame;
      AppMethodBeat.o(83147);
      return paramh1;
      if (this.material.getSegmentFeather() > 0)
      {
        int i = paramh1.width / 2;
        int j = paramh1.height / 2;
        this.fastBlurFilter.updateParams(1.2F / i, 0.0F);
        this.fastBlurFilter.RenderProcess(paramh2.texture[0], i, j, -1, 0.0D, this.fabbyFeatheredMaskStep1);
        this.fastBlurFilter.updateParams(0.0F, 1.2F / j);
        this.fastBlurFilter.RenderProcess(this.fabbyFeatheredMaskStep1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, this.fabbyFeatheredMaskStep2);
        this.fabbyExtractFilter.setTex(this.fabbyFeatheredMaskStep2.texture[0]);
        this.fabbyExtractFilter.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, this.fabbyStrokeFrame);
      }
      else
      {
        this.fabbyExtractFilter.setTex(paramh2.texture[0]);
        this.fabbyExtractFilter.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, this.fabbyStrokeFrame);
      }
    }
  }
  
  public Audio3DFilter getAudio3DFilter()
  {
    return this.audio3DFilter;
  }
  
  public CrazyFaceFilters getCrazyFaceFilters()
  {
    return this.crazyFaceFilters;
  }
  
  public FastStickerFilter getFastBodyStickerFilter()
  {
    return this.fastBodyStickerFilter;
  }
  
  public FastStickerFilter getFastFaceStickerFilter()
  {
    return this.fastFaceStickerFilter;
  }
  
  public List<VideoFilterBase> getFgStaticStickerFilters()
  {
    return this.fgStaticStickerFilters;
  }
  
  public VideoMaterial getMaterial()
  {
    return this.material;
  }
  
  public int getVideoEffectOrder()
  {
    return this.mEffectOrder;
  }
  
  public boolean hasParticleFilter()
  {
    AppMethodBeat.i(83151);
    if (this.filters != null)
    {
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext()) {
        if (((VideoFilterBase)localIterator.next() instanceof ParticleFilter))
        {
          AppMethodBeat.o(83151);
          return true;
        }
      }
    }
    AppMethodBeat.o(83151);
    return false;
  }
  
  public boolean hasVoiceTextFilter()
  {
    AppMethodBeat.i(83150);
    if (this.filters != null)
    {
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext()) {
        if (((VideoFilterBase)localIterator.next() instanceof VoiceTextFilter))
        {
          AppMethodBeat.o(83150);
          return true;
        }
      }
    }
    AppMethodBeat.o(83150);
    return false;
  }
  
  public boolean isSegmentRequired()
  {
    AppMethodBeat.i(83148);
    if (this.material == null)
    {
      AppMethodBeat.o(83148);
      return false;
    }
    boolean bool = this.material.isSegmentRequired();
    AppMethodBeat.o(83148);
    return bool;
  }
  
  public boolean isSupportPause()
  {
    AppMethodBeat.i(83149);
    if (this.material == null)
    {
      AppMethodBeat.o(83149);
      return false;
    }
    boolean bool = this.material.isSupportPause();
    AppMethodBeat.o(83149);
    return bool;
  }
  
  public boolean needDetectGesture()
  {
    return this.needDetectGesture;
  }
  
  public boolean needFaceInfo(int paramInt)
  {
    AppMethodBeat.i(83144);
    paramInt = (paramInt + 360) % 360;
    if (((paramInt == 90) || (paramInt == 270)) && (!this.material.isSupportLandscape()))
    {
      AppMethodBeat.o(83144);
      return false;
    }
    AppMethodBeat.o(83144);
    return true;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(83143);
    destroyAudio();
    AppMethodBeat.o(83143);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(83142);
    if (this.mActFilters != null) {
      this.mActFilters.reset(System.currentTimeMillis());
    }
    AppMethodBeat.o(83142);
  }
  
  public h processTransformRelatedFilters(h paramh, PTFaceAttr paramPTFaceAttr)
  {
    AppMethodBeat.i(83123);
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    long l = paramPTFaceAttr.getTimeStamp();
    int j = Math.min(this.mFaceList.size(), getMaterial().getMaxFaceCount());
    GlUtil.setBlendMode(true);
    Object localObject1;
    if (j <= 0)
    {
      localObject1 = new PTDetectInfo.Builder().triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
      updateFilters((PTDetectInfo)localObject1, this.mFaceOffFilters);
      updateFilters((PTDetectInfo)localObject1, this.mTransformFilters);
    }
    int i = 0;
    while (i < j)
    {
      Object localObject2 = (Face)this.mFaceList.get(i);
      setCurPersonId(((Face)localObject2).faceIndex);
      hitCharmRangeItem(((Face)localObject2).faceIndex);
      hitFaceRandomGroupItem(((Face)localObject2).faceIndex);
      hitAgeRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject2).faceIndex);
      hitGenderRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject2).faceIndex);
      hitPopularRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject2).faceIndex);
      hitCpRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject2).faceIndex, j);
      if ((this.mCurPersonId <= 1) && (this.mLipsCosFilter != null) && ((getMaterial().getLipsLutPath() == null) || (FeatureManager.isLutLipsReady()))) {
        this.mLipsCosFilter.updateAndRender(paramh, paramh.width, paramh.height, ((Face)localObject2).facePoints, ((Face)localObject2).faceAngles, null);
      }
      PTDetectInfo localPTDetectInfo = new PTDetectInfo.Builder().facePoints(((Face)localObject2).facePoints).faceAngles(((Face)localObject2).faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
      localObject1 = paramh;
      if (this.mFaceOffFilters != null)
      {
        updateFilters(localPTDetectInfo, this.mFaceOffFilters);
        localObject1 = RenderProcessForFilters(paramh, this.multiViewerOutFrame, this.mFaceOffFilters);
      }
      if (this.mFacialFeatureFilterList != null)
      {
        GlUtil.setBlendMode(false);
        paramh = this.mFacialFeatureFilterList.iterator();
        while (paramh.hasNext()) {
          ((FacialFeatureFilter)paramh.next()).updateStickerFilterList(((Face)localObject2).facePoints, ((Face)localObject2).faceAngles, (h)localObject1);
        }
        GlUtil.setBlendMode(true);
      }
      paramh = (h)localObject1;
      if (this.mTransformFilters != null)
      {
        updateFilters(localPTDetectInfo, this.mTransformFilters);
        paramh = RenderProcessForFilters((h)localObject1, this.multiViewerOutFrame, this.mTransformFilters);
      }
      localObject1 = paramh;
      if (this.mFacialFeatureFilterList != null)
      {
        localObject2 = this.mFacialFeatureFilterList.iterator();
        for (;;)
        {
          localObject1 = paramh;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (FacialFeatureFilter)((Iterator)localObject2).next();
          updateFilters(localPTDetectInfo, ((FacialFeatureFilter)localObject1).getStickerFilters());
          paramh = RenderProcessForFilters(paramh, ((FacialFeatureFilter)localObject1).getStickerFilters());
        }
      }
      i += 1;
      paramh = (h)localObject1;
    }
    GlUtil.setBlendMode(false);
    AppMethodBeat.o(83123);
    return paramh;
  }
  
  public boolean render3DFirst()
  {
    AppMethodBeat.i(83153);
    if ((this.gameFilter != null) && (this.gameFilter.getOrderMode() == 2))
    {
      AppMethodBeat.o(83153);
      return true;
    }
    AppMethodBeat.o(83153);
    return false;
  }
  
  public void renderARFilterIfNeeded(h paramh)
  {
    AppMethodBeat.i(83140);
    if (this.mARParticleFilter != null)
    {
      GlUtil.setBlendMode(true);
      paramh.a(-1, paramh.width, paramh.height, 0.0D);
      while (!this.mARTouchPointQueue.isEmpty())
      {
        PointF localPointF = (PointF)this.mARTouchPointQueue.poll();
        if (localPointF != null) {
          this.mARParticleFilter.addTouchPoint(localPointF);
        }
      }
      this.mARParticleFilter.updateAndRender(paramh);
      GlUtil.setBlendMode(false);
    }
    AppMethodBeat.o(83140);
  }
  
  public h renderEffectFilter(h paramh)
  {
    AppMethodBeat.i(83156);
    h localh = paramh;
    if (this.mEffectFilter != null)
    {
      this.mEffectFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mEffectTestFrame);
      localh = this.mEffectTestFrame;
    }
    AppMethodBeat.o(83156);
    return localh;
  }
  
  public Bitmap renderForBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(83133);
    if (this.filters == null)
    {
      localObject1 = g.aJ(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(83133);
      return localObject1;
    }
    GlUtil.setBlendMode(true);
    h localh = new h();
    this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, localh);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    paramInt1 = 0;
    Object localObject1 = localh;
    if (paramInt1 < this.filters.size())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(paramInt1);
      if (!VideoFilterUtil.canUseBlendMode(localVideoFilterBase))
      {
        localObject2 = localObject1;
        if (VideoFilterUtil.needCopy(localVideoFilterBase)) {
          localObject2 = FrameUtil.renderProcessBySwitchFbo(localObject1.texture[0], paramInt2, paramInt3, this.mCopyFilter, localh, this.copyFrame[0]);
        }
        localObject1 = VideoFrameUtil.renderProcessBySwitchFbo(localObject2.texture[0], paramInt2, paramInt3, localVideoFilterBase, localh, this.copyFrame[0]);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localVideoFilterBase.OnDrawFrameGLSL();
        localVideoFilterBase.renderTexture(localObject1.texture[0], paramInt2, paramInt3);
      }
    }
    GlUtil.setBlendMode(false);
    Object localObject2 = g.aJ(localObject1.texture[0], paramInt2, paramInt3);
    ((h)localObject1).clear();
    AppMethodBeat.o(83133);
    return localObject2;
  }
  
  public void reset()
  {
    AppMethodBeat.i(83155);
    if (!this.material.isResetWhenStartRecord())
    {
      AppMethodBeat.o(83155);
      return;
    }
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).reset();
      }
      if ((localVideoFilterBase instanceof FaceOffFilter)) {
        ((FaceOffFilter)localVideoFilterBase).reset();
      }
      if ((localVideoFilterBase instanceof TransformFilter)) {
        ((TransformFilter)localVideoFilterBase).reset();
      }
    }
    localIterator = this.gestureFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).reset();
    }
    localIterator = this.bodyFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).reset();
    }
    localIterator = this.headCropItemFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).reset();
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.reset();
    }
    if (this.mFacialFeatureFilterList != null)
    {
      localIterator = this.mFacialFeatureFilterList.iterator();
      while (localIterator.hasNext()) {
        ((FacialFeatureFilter)localIterator.next()).reset();
      }
    }
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.reset();
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.reset();
    }
    if (this.audio3DFilter != null) {
      this.audio3DFilter.reset();
    }
    localIterator = this.multiViewerFilters.iterator();
    while (localIterator.hasNext()) {
      ((MultiViewerFilter)localIterator.next()).reset();
    }
    if (this.mActFilters != null) {
      this.mActFilters.reset();
    }
    AppMethodBeat.o(83155);
  }
  
  public void setARParticleFilter(ARParticleFilter paramARParticleFilter)
  {
    this.mARParticleFilter = paramARParticleFilter;
  }
  
  public void setActFilter(ActFilters paramActFilters)
  {
    this.mActFilters = paramActFilters;
  }
  
  public void setAudio3DFilter(Audio3DFilter paramAudio3DFilter)
  {
    this.audio3DFilter = paramAudio3DFilter;
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    AppMethodBeat.i(83157);
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.setAudioPause(paramBoolean);
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.setAudioPause(paramBoolean);
    }
    if (this.audio3DFilter != null) {
      this.audio3DFilter.setAudioPause(paramBoolean);
    }
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).setAudioPause(paramBoolean);
      }
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.setAudioPause(paramBoolean);
    }
    if (this.mActFilters != null) {
      this.mActFilters.setAudioPause(paramBoolean);
    }
    if (this.multiViewerFilters != null)
    {
      localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext()) {
        ((MultiViewerFilter)localIterator.next()).setAudioPause(paramBoolean);
      }
    }
    AppMethodBeat.o(83157);
  }
  
  public void setBodyFilters(List<NormalVideoFilter> paramList)
  {
    this.bodyFilters = paramList;
  }
  
  public void setBodyParticleFilters(List<ParticleFilter> paramList)
  {
    this.bodyParticleFilters = paramList;
  }
  
  public void setCrazyFaceFilters(CrazyFaceFilters paramCrazyFaceFilters)
  {
    this.crazyFaceFilters = paramCrazyFaceFilters;
  }
  
  public void setCurPersonId(int paramInt)
  {
    this.mCurPersonId = paramInt;
  }
  
  public void setFabbyMvFilters(FabbyFilters paramFabbyFilters)
  {
    this.fabbyMvFilters = paramFabbyFilters;
  }
  
  public void setFaceParticleFilters(List<ParticleFilter> paramList)
  {
    AppMethodBeat.i(83158);
    this.faceParticleDynamicFilters = getStickerFilters(paramList, false, true);
    this.faceParticleStaticFilters = getStickerFilters(paramList, true, true);
    AppMethodBeat.o(83158);
  }
  
  public void setFacialFeatureFilterList(List<FacialFeatureFilter> paramList)
  {
    this.mFacialFeatureFilterList = paramList;
  }
  
  public void setFastBodyStickerFilter(FastStickerFilter paramFastStickerFilter)
  {
    this.fastBodyStickerFilter = paramFastStickerFilter;
  }
  
  public void setFastFaceStickerFilter(FastStickerFilter paramFastStickerFilter)
  {
    this.fastFaceStickerFilter = paramFastStickerFilter;
  }
  
  public void setFilters(List<VideoFilterBase> paramList1, List<VideoFilterBase> paramList2, List<VideoFilterBase> paramList3)
  {
    AppMethodBeat.i(83117);
    this.fgStaticStickerFilters = getStickerFilters(paramList1, true, true);
    this.fgDynamicFilters = getStickerFilters(paramList1, false, true);
    this.bgStaticStickerFilters = getStickerFilters(paramList1, true, false);
    this.bgDynamicStickerFilters = getStickerFilters(paramList1, false, false);
    this.filters = new ArrayList();
    this.filters.addAll(paramList2);
    this.filters.addAll(paramList3);
    this.filters.addAll(paramList1);
    this.mFaceOffFilters = paramList2;
    this.mTransformFilters = paramList3;
    AppMethodBeat.o(83117);
  }
  
  public void setGameFilter(GameFilter paramGameFilter)
  {
    this.gameFilter = paramGameFilter;
  }
  
  public void setGestureFilters(List<NormalVideoFilter> paramList)
  {
    this.gestureFilters = paramList;
  }
  
  public void setGestureParticleFilters(List<ParticleFilter> paramList)
  {
    this.gestureParticleFilters = paramList;
  }
  
  public void setHeadCropFilter(HeadCropFilter paramHeadCropFilter)
  {
    this.headCropFilter = paramHeadCropFilter;
  }
  
  public void setHeadCropItemFilters(List<NormalVideoFilter> paramList)
  {
    this.headCropItemFilters = paramList;
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(83138);
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.setImageData(paramArrayOfByte);
    }
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof FaceOffFilter)) {
        ((FaceOffFilter)localVideoFilterBase).setImageData(paramArrayOfByte);
      }
    }
    AppMethodBeat.o(83138);
  }
  
  public void setIsRenderForBitmap(boolean paramBoolean)
  {
    AppMethodBeat.i(83132);
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).setRenderForBitmap(paramBoolean);
      } else if ((localVideoFilterBase instanceof FaceOffFilter)) {
        ((FaceOffFilter)localVideoFilterBase).setRenderForBitmap(paramBoolean);
      } else if ((localVideoFilterBase instanceof TransformFilter)) {
        ((TransformFilter)localVideoFilterBase).setRenderForBitmap(paramBoolean);
      }
    }
    AppMethodBeat.o(83132);
  }
  
  public void setLipsCosFilter(LipsCosFilter paramLipsCosFilter)
  {
    this.mLipsCosFilter = paramLipsCosFilter;
  }
  
  public void setMaterial(VideoMaterial paramVideoMaterial)
  {
    this.material = paramVideoMaterial;
  }
  
  public void setMultiViewerFilters(List<MultiViewerFilter> paramList)
  {
    this.multiViewerFilters = paramList;
  }
  
  public void setMultiViewerOutFrame(h paramh)
  {
    this.multiViewerOutFrame = paramh;
  }
  
  public void setMultiViewerSrcTexture(int paramInt)
  {
    this.multiViewerSrcTexture = paramInt;
  }
  
  public void setNeedDetectGesture(boolean paramBoolean)
  {
    this.needDetectGesture = paramBoolean;
  }
  
  public void setPhantomFilter(PhantomFilter paramPhantomFilter)
  {
    this.mPhantomFilter = paramPhantomFilter;
  }
  
  public void setRatioMode(VideoFilterUtil.RATIO_MODE paramRATIO_MODE)
  {
    AppMethodBeat.i(83152);
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof StaticStickerFilter)) {
        ((StaticStickerFilter)localVideoFilterBase).setRatioMode(paramRATIO_MODE);
      }
    }
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.setRatioMode(paramRATIO_MODE);
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.setRatioMode(paramRATIO_MODE);
    }
    if (this.audio3DFilter != null) {
      this.audio3DFilter.setRatioMode(paramRATIO_MODE);
    }
    if (this.multiViewerFilters != null)
    {
      localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext()) {
        ((MultiViewerFilter)localIterator.next()).setRatioMode(paramRATIO_MODE);
      }
    }
    AppMethodBeat.o(83152);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(83145);
    VideoFilterUtil.setRenderMode(this.filters, paramInt);
    VideoFilterUtil.setRenderMode(this.headCropItemFilters, paramInt);
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.setRenderMode(paramInt);
    }
    this.mCopyFilter.setRenderMode(paramInt);
    if (this.headCropFilter != null) {
      this.headCropFilter.setRenderMode(paramInt);
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.setRenderMode(paramInt);
    }
    if (this.mFacialFeatureFilterList != null)
    {
      Iterator localIterator = this.mFacialFeatureFilterList.iterator();
      while (localIterator.hasNext()) {
        ((FacialFeatureFilter)localIterator.next()).setRenderMode(paramInt);
      }
    }
    if (this.mLipsCosFilter != null) {
      this.mLipsCosFilter.setRenderMode(paramInt);
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.setRenderMode(paramInt);
    }
    if (this.mActFilters != null) {
      this.mActFilters.setRenderMode(paramInt);
    }
    if (this.fabbyExtractFilter != null) {
      this.fabbyExtractFilter.setRenderMode(paramInt);
    }
    if (this.fabbyStrokeFilter != null) {
      this.fabbyStrokeFilter.setRenderMode(paramInt);
    }
    if (this.fastBlurFilter != null) {
      this.fastBlurFilter.setRenderMode(paramInt);
    }
    AppMethodBeat.o(83145);
  }
  
  public void setTriggerWords(String paramString)
  {
    AppMethodBeat.i(83154);
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).setTriggerWords(paramString);
      } else if ((localVideoFilterBase instanceof FaceOffFilter)) {
        ((FaceOffFilter)localVideoFilterBase).setTriggerWords(paramString);
      } else if ((localVideoFilterBase instanceof TransformFilter)) {
        ((TransformFilter)localVideoFilterBase).setTriggerWords(paramString);
      } else if ((localVideoFilterBase instanceof VoiceTextFilter)) {
        ((VoiceTextFilter)localVideoFilterBase).setTriggerWords(paramString);
      }
    }
    AppMethodBeat.o(83154);
  }
  
  public void setVideoEffectFilter(VideoFilterBase paramVideoFilterBase)
  {
    this.mEffectFilter = paramVideoFilterBase;
  }
  
  public void setVideoEffectOrder(int paramInt)
  {
    this.mEffectOrder = paramInt;
  }
  
  public void setVoiceTextFilter(VoiceTextFilter paramVoiceTextFilter)
  {
    this.voiceTextFilter = paramVoiceTextFilter;
  }
  
  public void updateAllFilters(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(83111);
    updateFilters(paramPTDetectInfo, this.filters);
    AppMethodBeat.o(83111);
  }
  
  public h updateAndRender3DFilter(h paramh, PTFaceAttr paramPTFaceAttr, int paramInt)
  {
    AppMethodBeat.i(83141);
    h localh = paramh;
    if (this.gameFilter != null)
    {
      localh = paramh;
      if (getMaterial().getShaderType() != VideoMaterialUtil.SHADER_TYPE.AUDIO3D.value)
      {
        this.gameFilter.updateVideoSize(paramh.width, paramh.height, paramInt);
        localh = this.gameFilter.updateAndRender(paramh, paramPTFaceAttr);
      }
    }
    AppMethodBeat.o(83141);
    return localh;
  }
  
  public h updateAndRenderActMaterial(h paramh, List<List<PointF>> paramList, List<float[]> paramList1, int paramInt, long paramLong)
  {
    AppMethodBeat.i(83130);
    h localh = paramh;
    if (this.mActFilters != null)
    {
      GlUtil.setBlendMode(true);
      localh = this.mActFilters.updateAndRender(paramh, paramLong, paramList, paramList1, paramInt);
      GlUtil.setBlendMode(false);
    }
    AppMethodBeat.o(83130);
    return localh;
  }
  
  public h updateAndRenderBgFilters(h paramh, PTFaceAttr paramPTFaceAttr)
  {
    AppMethodBeat.i(83127);
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    Map localMap1 = paramPTFaceAttr.getFaceActionCounter();
    List localList3 = paramPTFaceAttr.getHandPoints();
    Map localMap2 = GestureDetector.getInstance().getHandActionCounter();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    long l = paramPTFaceAttr.getTimeStamp();
    this.mBgFrame.a(-1, paramh.width, paramh.height, 0.0D);
    FrameUtil.clearFrame(this.mBgFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramh.width, paramh.height);
    h localh = this.mBgFrame;
    GlUtil.setBlendMode(true);
    int j = Math.min(localList1.size(), getMaterial().getMaxFaceCount());
    int i = 0;
    while (i < j)
    {
      BenchUtil.benchStart("[showPreview]updateAllFilters");
      updateFilters(new PTDetectInfo.Builder().facePoints((List)localList1.get(i)).faceAngles((float[])localList2.get(i)).faceActionCounter(localMap1).handPoints(localList3).handActionCounter(localMap2).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.bgDynamicStickerFilters);
      BenchUtil.benchEnd("[showPreview]updateAllFilters");
      BenchUtil.benchStart("[showPreview]RenderProcess");
      localh = RenderProcessForFilters(localh, this.bgDynamicStickerFilters);
      BenchUtil.benchEnd("[showPreview]RenderProcess");
      i += 1;
    }
    if (localList1.size() <= 0) {
      updateFilters(new PTDetectInfo.Builder().faceActionCounter(localMap1).handPoints(localList3).handActionCounter(localMap2).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.bgStaticStickerFilters);
    }
    for (paramPTFaceAttr = RenderProcessForFilters(localh, this.bgStaticStickerFilters);; paramPTFaceAttr = RenderProcessForFilters(localh, this.bgStaticStickerFilters))
    {
      this.mMaskFilter.OnDrawFrameGLSL();
      this.mMaskFilter.renderTexture(paramh.texture[0], paramh.width, paramh.height);
      GlUtil.setBlendMode(false);
      AppMethodBeat.o(83127);
      return paramPTFaceAttr;
      updateFilters(new PTDetectInfo.Builder().facePoints((List)localList1.get(0)).faceAngles((float[])localList2.get(0)).faceActionCounter(localMap1).handPoints(localList3).handActionCounter(localMap2).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.bgStaticStickerFilters);
    }
  }
  
  public h updateAndRenderDynamicStickers(h paramh, PTFaceAttr paramPTFaceAttr)
  {
    AppMethodBeat.i(83080);
    if ((paramPTFaceAttr.isLandscape()) && (!getMaterial().isSupportLandscape()))
    {
      destroyNormalAudio();
      AppMethodBeat.o(83080);
      return paramh;
    }
    if (paramPTFaceAttr.getFaceCount() > 0) {
      setImageData(paramPTFaceAttr.getData());
    }
    BenchUtil.benchStart("[VideoFilterList] updateAndRender");
    paramh = updateAndRender(paramh, paramPTFaceAttr);
    BenchUtil.benchEnd("[VideoFilterList] updateAndRender");
    AppMethodBeat.o(83080);
    return paramh;
  }
  
  public h updateAndRenderFabbyMV(h paramh, Map<Integer, h> paramMap, Map<Integer, FaceActionCounter> paramMap1, Set<Integer> paramSet, long paramLong)
  {
    AppMethodBeat.i(83146);
    if (this.fabbyMvFilters != null)
    {
      if ((paramMap == null) || (!paramMap.containsKey(Integer.valueOf(0))) || (paramh.texture[0] != ((h)paramMap.get(Integer.valueOf(0))).texture[0])) {
        break label140;
      }
      this.mCopyFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.fabbyOriginCopyFrame);
      paramh = this.fabbyOriginCopyFrame;
    }
    label140:
    for (;;)
    {
      paramh = this.fabbyMvFilters.updateAndRender(paramh, paramMap, paramMap1, paramSet, paramLong);
      AppMethodBeat.o(83146);
      return paramh;
      paramh = (h)paramMap.values().iterator().next();
      AppMethodBeat.o(83146);
      return paramh;
    }
  }
  
  public h updateAndRenderHeadCropItemFilters(h paramh, PTFaceAttr paramPTFaceAttr)
  {
    AppMethodBeat.i(83125);
    int i = (paramPTFaceAttr.getRotation() + 360) % 360;
    if (((i == 90) || (i == 270)) && (!this.material.isSupportLandscape()))
    {
      AppMethodBeat.o(83125);
      return paramh;
    }
    GlUtil.setBlendMode(true);
    if (this.headCropFilter != null)
    {
      this.mCopyFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mHeadCropFrame);
      this.headCropFilter.setInputFrame(this.mHeadCropFrame);
      paramh.a(-1, paramh.width, paramh.height, 0.0D);
    }
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    Map localMap = paramPTFaceAttr.getFaceActionCounter();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    long l = paramPTFaceAttr.getTimeStamp();
    if (localList1.size() <= 0) {
      updateFilters(new PTDetectInfo.Builder().faceActionCounter(localMap).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.headCropItemFilters);
    }
    for (paramh = RenderProcessForFilters(paramh, this.headCropItemFilters);; paramh = RenderProcessForFilters(paramh, this.headCropItemFilters))
    {
      GlUtil.setBlendMode(false);
      AppMethodBeat.o(83125);
      return paramh;
      updateFilters(new PTDetectInfo.Builder().facePoints((List)localList1.get(0)).faceAngles((float[])localList2.get(0)).faceActionCounter(localMap).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.headCropItemFilters);
    }
  }
  
  public void updateAndRenderMultiViewerMaterial(Map<Integer, h> paramMap, h paramh, PTFaceAttr paramPTFaceAttr)
  {
    AppMethodBeat.i(83131);
    Object localObject = paramPTFaceAttr.getFaceActionCounter();
    paramMap.clear();
    if (this.multiViewerFilters != null)
    {
      FabbyFaceActionCounter localFabbyFaceActionCounter = (FabbyFaceActionCounter)((Map)localObject).get(Integer.valueOf(PTFaceAttr.PTExpression.MV_PART_INDEX.value));
      int i = 0;
      if (i < this.multiViewerFilters.size())
      {
        MultiViewerFilter localMultiViewerFilter = (MultiViewerFilter)this.multiViewerFilters.get(i);
        int j;
        if (localMultiViewerFilter.needRenderThisPart(localFabbyFaceActionCounter.count))
        {
          j = localMultiViewerFilter.getRenderId();
          if (localFabbyFaceActionCounter.scaleMap.get(Integer.valueOf(j)) == null) {
            break label343;
          }
        }
        label343:
        for (localObject = (PointF)localFabbyFaceActionCounter.scaleMap.get(Integer.valueOf(j));; localObject = new PointF(1.0F, 1.0F))
        {
          float f = Math.max(((PointF)localObject).x, ((PointF)localObject).y);
          int k = (int)(paramh.width * f);
          int m = (int)(paramh.height * f);
          localMultiViewerFilter.updateVideoSize(k, m, this.mFaceDetScale / f);
          if (!this.multiViewerFrameMap.containsKey(Integer.valueOf(j)))
          {
            localObject = new h();
            this.multiViewerFrameMap.put(Integer.valueOf(j), localObject);
          }
          localObject = (h)this.multiViewerFrameMap.get(Integer.valueOf(j));
          ((h)localObject).a(-1, k, m, 0.0D);
          BenchUtil.benchStart("updateAndRenderMultiViewerMaterial - clearFrame");
          FrameUtil.clearFrame((h)localObject, 0.0F, 0.0F, 0.0F, 0.0F, ((h)localObject).width, ((h)localObject).height);
          BenchUtil.benchEnd("updateAndRenderMultiViewerMaterial - clearFrame");
          BenchUtil.benchStart("updateAndRenderMultiViewerMaterial - multiViewerFilter.render");
          localObject = localMultiViewerFilter.render(paramh, (h)localObject, paramPTFaceAttr);
          BenchUtil.benchEnd("updateAndRenderMultiViewerMaterial - multiViewerFilter.render");
          paramMap.put(Integer.valueOf(j), localObject);
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(83131);
  }
  
  public h updateAndRenderStaticStickers(h paramh, PTFaceAttr paramPTFaceAttr)
  {
    AppMethodBeat.i(83126);
    int i = (paramPTFaceAttr.getRotation() + 360) % 360;
    if (((i == 90) || (i == 270)) && (!this.material.isSupportLandscape()))
    {
      AppMethodBeat.o(83126);
      return paramh;
    }
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    Map localMap = paramPTFaceAttr.getFaceActionCounter();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    long l = paramPTFaceAttr.getTimeStamp();
    GlUtil.setBlendMode(true);
    if (localList1.size() <= 0)
    {
      paramPTFaceAttr = new PTDetectInfo.Builder().faceActionCounter(localMap).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
      updateFilters(paramPTFaceAttr, this.fgStaticStickerFilters);
      paramh = RenderProcessForFilters(paramh, this.fgStaticStickerFilters);
      updateFilters(paramPTFaceAttr, this.faceParticleStaticFilters);
    }
    for (paramh = RenderProcessForFilters(paramh, this.faceParticleStaticFilters);; paramh = RenderProcessForFilters(paramh, this.faceParticleStaticFilters))
    {
      GlUtil.setBlendMode(false);
      paramPTFaceAttr = paramh;
      if (this.mEffectOrder == 2)
      {
        paramPTFaceAttr = paramh;
        if (this.mEffectFilter != null)
        {
          this.mEffectFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mEffectFrame);
          paramPTFaceAttr = this.mEffectFrame;
        }
      }
      AppMethodBeat.o(83126);
      return paramPTFaceAttr;
      paramPTFaceAttr = new PTDetectInfo.Builder().facePoints((List)localList1.get(0)).faceAngles((float[])localList2.get(0)).faceActionCounter(localMap).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).build();
      updateFilters(paramPTFaceAttr, this.fgStaticStickerFilters);
      paramh = RenderProcessForFilters(paramh, this.fgStaticStickerFilters);
      updateFilters(paramPTFaceAttr, this.faceParticleStaticFilters);
    }
  }
  
  public void updateCosAlpha(int paramInt)
  {
    AppMethodBeat.i(83120);
    if (VideoMaterialUtil.isCosMaterial(getMaterial()))
    {
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
        if ((localVideoFilterBase instanceof FaceOffFilter)) {
          ((FaceOffFilter)localVideoFilterBase).setCosAlpha(paramInt / 100.0F);
        }
      }
      if (this.mLipsCosFilter != null) {
        this.mLipsCosFilter.setCosAlpha(paramInt / 100.0F);
      }
    }
    AppMethodBeat.o(83120);
  }
  
  public void updateFaceParams(List<List<PointF>> paramList, List<float[]> paramList1, List<PointF> paramList2, int paramInt)
  {
    AppMethodBeat.i(83121);
    int i = Math.min(paramList.size(), getMaterial().getMaxFaceCount());
    processMappingFace(paramList, paramList1, paramInt);
    if (i <= 0)
    {
      clearCharmRangeItemStatus();
      clearGenderRangeItemStatus();
      clearPopularRangeItemStatus();
      clearAgeRangeItemStatus();
      clearFaceMappingData();
    }
    if (i < 2) {
      clearCpRangeItemStatus();
    }
    if (!hasHands(paramList2)) {
      clearHandsRangeItemStatus();
    }
    syncCharmRangeAndHandsRangeValue(hasHands(paramList2));
    syncRandomGroupValue(hasHands(paramList2));
    hitHandsRangeItem();
    hitHandRandomGroupItem();
    AppMethodBeat.o(83121);
  }
  
  public void updateFilters(PTDetectInfo paramPTDetectInfo, List<? extends VideoFilterBase> paramList)
  {
    AppMethodBeat.i(83112);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((VideoFilterBase)paramList.next()).updatePreview(paramPTDetectInfo);
    }
    AppMethodBeat.o(83112);
  }
  
  public void updateTextureParam(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, long paramLong)
  {
    AppMethodBeat.i(83110);
    Iterator localIterator = this.filters.iterator();
    VideoFilterBase localVideoFilterBase;
    while (localIterator.hasNext())
    {
      localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).updateTextureParam(paramLong);
      }
    }
    if (this.headCropItemFilters != null)
    {
      localIterator = this.headCropItemFilters.iterator();
      while (localIterator.hasNext())
      {
        localVideoFilterBase = (VideoFilterBase)localIterator.next();
        if ((localVideoFilterBase instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localVideoFilterBase).updateTextureParam(paramLong);
        }
      }
    }
    if (this.gestureFilters != null)
    {
      localIterator = this.gestureFilters.iterator();
      while (localIterator.hasNext()) {
        ((NormalVideoFilter)localIterator.next()).updateTextureParam(paramLong);
      }
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.updateTextureParam(paramMap, paramSet, paramLong);
    }
    AppMethodBeat.o(83110);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble, int paramInt3)
  {
    AppMethodBeat.i(83109);
    this.mFaceDetScale = paramDouble;
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.gestureFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.bodyFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.faceParticleDynamicFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.faceParticleStaticFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.gestureParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.bodyParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.headCropItemFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.headCropFilter != null) {
      this.headCropFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mFacialFeatureFilterList != null)
    {
      localIterator = this.mFacialFeatureFilterList.iterator();
      while (localIterator.hasNext()) {
        ((FacialFeatureFilter)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
    }
    if (this.mLipsCosFilter != null) {
      this.mLipsCosFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.voiceTextFilter != null) {
      this.voiceTextFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.audio3DFilter != null) {
      this.audio3DFilter.updateVideoSize(paramInt1, paramInt2, paramDouble, paramInt3);
    }
    AppMethodBeat.o(83109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoFilterList
 * JD-Core Version:    0.7.0.1
 */