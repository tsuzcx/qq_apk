package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.ttpic.ar.filter.ARParticleFilter;
import com.tencent.ttpic.face.Face;
import com.tencent.ttpic.facedetect.FaceDetector.DETECT_TYPE;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
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
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FaceAverageUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterFactory;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.view.b;
import com.tencent.view.f;
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
  private static String TAG = VideoFilterList.class.getSimpleName();
  private static final Random mRandom = new Random(System.currentTimeMillis());
  private List<VideoFilterBase> bgDynamicStickerFilters;
  private List<VideoFilterBase> bgStaticStickerFilters;
  private h[] copyFrame = new h[2];
  private CrazyFaceFilters crazyFaceFilters;
  private FabbyExtractFilter fabbyExtractFilter;
  private h fabbyFeatheredMaskStep1 = new h();
  private h fabbyFeatheredMaskStep2 = new h();
  private FabbyFilters fabbyMvFilters;
  private h fabbyOriginCopyFrame = new h();
  private FabbyStrokeFilter fabbyStrokeFilter;
  private h fabbyStrokeFrame = new h();
  private FastBlurFilter fastBlurFilter;
  private FastStickerFilter fastStickerFilter;
  private List<VideoFilterBase> fgOtherFilters;
  private List<VideoFilterBase> fgStaticStickerFilters;
  private List<VideoFilterBase> filters;
  private GameFilter gameFilter;
  private List<VideoFilterBase> gestureFilters;
  private HeadCropFilter headCropFilter;
  private List<VideoFilterBase> headCropItemFilters = new ArrayList();
  private ARParticleFilter mARParticleFilter;
  private Queue<PointF> mARTouchPointQueue = new LinkedList();
  private ActFilters mActFilters;
  private Map<Integer, Float> mAgeValueMap = new HashMap();
  private h mBgFrame = new h();
  private Map<Integer, Double> mCharmValueMap = new HashMap();
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bcE);
  private Map<Integer, Float> mCpValueMap = new HashMap();
  private int mCurPersonId = -1;
  private VideoFilterBase mEffectFilter;
  private h mEffectFrame = new h();
  private int mEffectOrder = -1;
  private Comparator<Face> mFaceIndexComperator = new VideoFilterList.1(this);
  private List<Face> mFaceList = new ArrayList();
  private Map<Integer, Float> mGenderValueMap = new HashMap();
  private Map<Integer, Double> mHandsValueMap = new HashMap();
  private h mHeadCropFrame = new h();
  private LipsCosFilter mLipsCosFilter;
  private BaseFilter mMaskFilter;
  private Map<Integer, Float> mPopularValueMap = new HashMap();
  private float mScaleFace = 1.0F;
  private List<List<PointF>> mTouchPoints = new ArrayList();
  private VideoMaterial material;
  private List<MultiViewerFilter> multiViewerFilters;
  public Map<Integer, h> multiViewerFrameMap = new HashMap();
  private h multiViewerOutFrame;
  private int multiViewerSrcTexture;
  private boolean needDetectGesture = false;
  private float outScale = 1.0F;
  private VideoFilterUtil.RATIO_MODE ratioMode;
  private h renderFrame = new h();
  
  private h RenderProcessForFastStickerFilter(h paramh1, h paramh2, List<Face> paramList, int paramInt1, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList1, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong, int paramInt2)
  {
    if (paramh2 == null)
    {
      this.fastStickerFilter.setFaceCount(paramInt1);
      this.fastStickerFilter.addSrcTexture(this.multiViewerSrcTexture);
      if (paramInt1 > 0) {
        break label62;
      }
      this.fastStickerFilter.updatePreview(null, null, paramMap, null, null, paramSet, 0.0F, paramLong);
    }
    for (;;)
    {
      this.fastStickerFilter.render(paramh1);
      return paramh1;
      paramh1 = paramh2;
      break;
      label62:
      int i = 0;
      while ((i < paramInt1) && (i < paramList.size()))
      {
        paramh2 = (Face)paramList.get(i);
        this.fastStickerFilter.updatePreview(paramh2.facePoints, paramh2.faceAngles, paramMap, paramList1, paramMap1, paramSet, paramFloat, paramLong);
        this.fastStickerFilter.setRenderParams(paramInt2);
        i += 1;
      }
    }
  }
  
  private h RenderProcessForFilters(h paramh1, h paramh2, List<VideoFilterBase> paramList)
  {
    if (VideoUtil.isEmpty(paramList)) {
      return paramh1;
    }
    h localh2;
    h localh1;
    int i;
    label80:
    Object localObject;
    if (paramh1.texture[0] == this.copyFrame[0].texture[0])
    {
      localh2 = this.copyFrame[1];
      localh1 = paramh2;
      if (paramh2 == null) {
        localh1 = paramh1;
      }
      GLES20.glBindFramebuffer(36160, localh1.bcC[0]);
      GLES20.glViewport(0, 0, localh1.width, localh1.height);
      i = 0;
      paramh2 = paramh1;
      if (i >= paramList.size()) {
        break label380;
      }
      localObject = (VideoFilterBase)paramList.get(i);
      if (!needRender((VideoFilterBase)localObject)) {
        break label377;
      }
      if (VideoFilterUtil.canUseBlendMode((VideoFilterBase)localObject)) {
        break label339;
      }
      localh1 = paramh2;
      if (VideoFileUtil.needCopy((VideoFilterBase)localObject))
      {
        GlUtil.debugCheckGlError(this);
        VideoFilterUtil.setBlendMode(false);
        GlUtil.debugCheckGlError(this);
        localh1 = FrameUtil.renderProcessBySwitchFbo(paramh2.texture[0], paramh2.width, paramh2.height, this.mCopyFilter, paramh1, localh2);
        GlUtil.debugCheckGlError(this);
        VideoFilterUtil.setBlendMode(true);
        GlUtil.debugCheckGlError(this);
      }
      BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + localObject.getClass().getName());
      if ((!VideoFilterUtil.maybeTransformFilter((VideoFilterBase)localObject)) || (!VideoMaterialUtil.needCopyTransform())) {
        break label310;
      }
      paramh2 = FrameUtil.renderProcessByCopy(localh1.texture[0], localh1.width, localh1.height, (VideoFilterBase)localObject, this.mCopyFilter, paramh1, localh2);
      label253:
      BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + localObject.getClass().getName());
      localObject = paramh2;
      localh1 = paramh2;
      paramh2 = (h)localObject;
    }
    label310:
    label339:
    label377:
    for (;;)
    {
      i += 1;
      break label80;
      localh2 = this.copyFrame[0];
      break;
      paramh2 = FrameUtil.renderProcessBySwitchFbo(localh1.texture[0], localh1.width, localh1.height, (VideoFilterBase)localObject, paramh1, localh2);
      break label253;
      BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
      ((VideoFilterBase)localObject).OnDrawFrameGLSL();
      ((VideoFilterBase)localObject).renderTexture(paramh2.texture[0], paramh2.width, paramh2.height);
      BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
    }
    label380:
    return localh1;
  }
  
  private h RenderProcessForFilters(h paramh, List<VideoFilterBase> paramList)
  {
    return RenderProcessForFilters(paramh, null, paramList);
  }
  
  private void clearAgeRangeItemStatus()
  {
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
  }
  
  private void clearCharmRangeItemStatus()
  {
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
  }
  
  private void clearCpRangeItemStatus()
  {
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
  }
  
  private void clearFaceMappingData()
  {
    this.mFaceList.clear();
  }
  
  private void clearGenderRangeItemStatus()
  {
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
  }
  
  private void clearHandsRangeItemStatus()
  {
    if (this.gestureFilters != null)
    {
      int i = 0;
      while (i < this.gestureFilters.size())
      {
        Object localObject = (VideoFilterBase)this.gestureFilters.get(i);
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
    this.mHandsValueMap.clear();
  }
  
  private void clearPopularRangeItemStatus()
  {
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
  }
  
  private void destroyNormalAudio()
  {
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).destroyAudio();
      }
    }
    if (this.fastStickerFilter != null) {
      this.fastStickerFilter.destroyAudio();
    }
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
  
  private List<VideoFilterBase> getExcludeFilters(List<VideoFilterBase> paramList1, List<VideoFilterBase> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList1.next();
      if (!paramList2.contains(localVideoFilterBase)) {
        localArrayList.add(localVideoFilterBase);
      }
    }
    return localArrayList;
  }
  
  private List<Integer> getNewFaceIndexList(int paramInt, Set<Integer> paramSet, List<Face> paramList)
  {
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
    return localArrayList;
  }
  
  private List<VideoFilterBase> getStaticStickerFilters(List<VideoFilterBase> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      if (((localVideoFilterBase instanceof StaticStickerFilter)) || ((localVideoFilterBase instanceof StaticNumFilter))) {
        localArrayList.add(localVideoFilterBase);
      }
    }
    return localArrayList;
  }
  
  private List<VideoFilterBase> getStickerFilters(List<VideoFilterBase> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = getStaticStickerFilters(paramList);
    paramList = getExcludeFilters(paramList, localList);
    if (paramBoolean1) {
      return getZIndexFilters(localList, paramBoolean2);
    }
    return getZIndexFilters(paramList, paramBoolean2);
  }
  
  private List<VideoFilterBase> getZIndexFilters(List<VideoFilterBase> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      int i = 0;
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        i = ((NormalVideoFilter)localVideoFilterBase).getStickerItem().zIndex;
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
    return localArrayList;
  }
  
  private boolean hasHands(List<PointF> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.gestureFilters != null) && (this.gestureFilters.size() > 0))
    {
      paramList = paramList.iterator();
      Object localObject;
      do
      {
        float f1;
        float f2;
        float f3;
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (PointF)paramList.next();
          f1 = ((PointF)localObject).x;
          f2 = ((PointF)localObject).x;
          f3 = ((PointF)localObject).y;
        } while ((((PointF)localObject).y * f3 + f1 * f2 < 0.0001D) || (!(this.gestureFilters.get(0) instanceof NormalVideoFilter)));
        localObject = (NormalVideoFilter)this.gestureFilters.get(0);
      } while ((localObject == null) || (((NormalVideoFilter)localObject).getStickerItem() == null));
    }
    return false;
  }
  
  private void hitAgeRangeItem(int paramInt)
  {
    if (!VideoPreviewFaceOutlineDetector.getInstance().needDetectFaceValue()) {
      break label9;
    }
    for (;;)
    {
      label9:
      return;
      if (this.filters != null)
      {
        if ((!this.mAgeValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mAgeValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
        {
          float f = VideoPreviewFaceOutlineDetector.getInstance().getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value);
          if ((int)(f * 100.0F) == 0) {
            break;
          }
          f = getAdjustedAge(f);
          this.mAgeValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
        }
        int i = 0;
        while (i < this.filters.size())
        {
          VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(i);
          if ((localVideoFilterBase instanceof NormalVideoFilter))
          {
            StickerItem localStickerItem = ((NormalVideoFilter)localVideoFilterBase).getStickerItem();
            if (localStickerItem != null)
            {
              if (localStickerItem.ageRange != null) {
                localStickerItem.ageRange.setValue(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue());
              }
              if (((localVideoFilterBase instanceof DynamicNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value)) {
                ((DynamicNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
              if (((localVideoFilterBase instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value)) {
                ((StaticNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void hitCharmRangeItem(int paramInt)
  {
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
        if ((localObject1 instanceof TransformFilterNew))
        {
          localObject1 = ((TransformFilterNew)localObject1).getFaceMeshItem();
          if ((localObject1 != null) && (((FaceMeshItem)localObject1).charmRange != null)) {
            ((FaceMeshItem)localObject1).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
          }
        }
        i += 1;
      }
    }
  }
  
  private void hitCpRangeItem(int paramInt1, int paramInt2)
  {
    if ((!VideoPreviewFaceOutlineDetector.getInstance().needDetectFaceValue()) || (paramInt2 < 2)) {
      break label14;
    }
    for (;;)
    {
      label14:
      return;
      if (this.filters != null)
      {
        if ((!this.mCpValueMap.containsKey(Integer.valueOf(paramInt1))) || ((this.mCpValueMap.containsKey(Integer.valueOf(paramInt1))) && (((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue() < 0.0F)))
        {
          float f = VideoPreviewFaceOutlineDetector.getInstance().getFaceValues(paramInt1, FaceDetector.DETECT_TYPE.DETECT_TYPE_CP.value);
          if ((int)(f * 100.0F) == 0) {
            break;
          }
          this.mCpValueMap.put(Integer.valueOf(paramInt1), Float.valueOf(f));
        }
        paramInt2 = 0;
        while (paramInt2 < this.filters.size())
        {
          VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(paramInt2);
          if ((localVideoFilterBase instanceof NormalVideoFilter))
          {
            StickerItem localStickerItem = ((NormalVideoFilter)localVideoFilterBase).getStickerItem();
            if (localStickerItem != null)
            {
              if (localStickerItem.cpRange != null) {
                localStickerItem.cpRange.setValue(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue());
              }
              if (((localVideoFilterBase instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_CP.value)) {
                ((StaticNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue() * 100.0F));
              }
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
  
  private void hitFaceRandomGroupItem(int paramInt)
  {
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
  }
  
  private void hitGenderRangeItem(int paramInt)
  {
    if (!VideoPreviewFaceOutlineDetector.getInstance().needDetectFaceValue()) {
      break label9;
    }
    for (;;)
    {
      label9:
      return;
      if (this.filters != null)
      {
        if ((!this.mGenderValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mGenderValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
        {
          float f = VideoPreviewFaceOutlineDetector.getInstance().getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value);
          if ((int)(f * 100.0F) == 0) {
            break;
          }
          this.mGenderValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
        }
        int i = 0;
        while (i < this.filters.size())
        {
          VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(i);
          if ((localVideoFilterBase instanceof NormalVideoFilter))
          {
            StickerItem localStickerItem = ((NormalVideoFilter)localVideoFilterBase).getStickerItem();
            if (localStickerItem != null)
            {
              if (localStickerItem.genderRange != null) {
                localStickerItem.genderRange.setValue(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue());
              }
              if (((localVideoFilterBase instanceof DynamicNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value)) {
                ((DynamicNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
              if (((localVideoFilterBase instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value)) {
                ((StaticNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void hitHandRandomGroupItem()
  {
    if (this.gestureFilters != null)
    {
      int i = 0;
      while (i < this.gestureFilters.size())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.gestureFilters.get(i);
        if ((localVideoFilterBase instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localVideoFilterBase).updateRandomGroupValue(RandomGroupManager.getInstance().getHandValue());
        }
        i += 1;
      }
    }
  }
  
  private void hitHandsRangeItem()
  {
    if (!this.mHandsValueMap.containsKey(Integer.valueOf(0))) {}
    for (;;)
    {
      return;
      if (this.gestureFilters != null)
      {
        int i = 0;
        while (i < this.gestureFilters.size())
        {
          Object localObject1 = (VideoFilterBase)this.gestureFilters.get(i);
          Object localObject2;
          if ((localObject1 instanceof NormalVideoFilter))
          {
            localObject2 = ((NormalVideoFilter)localObject1).getStickerItem();
            if ((localObject2 != null) && (((StickerItem)localObject2).charmRange != null)) {
              ((StickerItem)localObject2).charmRange.hit(((Double)this.mHandsValueMap.get(Integer.valueOf(0))).doubleValue());
            }
          }
          if ((localObject1 instanceof FaceOffFilter))
          {
            localObject2 = ((FaceOffFilter)localObject1).getFaceOffItem();
            if ((localObject2 != null) && (((FaceItem)localObject2).charmRange != null)) {
              ((FaceItem)localObject2).charmRange.hit(((Double)this.mHandsValueMap.get(Integer.valueOf(0))).doubleValue());
            }
          }
          if ((localObject1 instanceof TransformFilterNew))
          {
            localObject1 = ((TransformFilterNew)localObject1).getFaceMeshItem();
            if ((localObject1 != null) && (((FaceMeshItem)localObject1).charmRange != null)) {
              ((FaceMeshItem)localObject1).charmRange.hit(((Double)this.mHandsValueMap.get(Integer.valueOf(0))).doubleValue());
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void hitPopularRangeItem(int paramInt)
  {
    if (!VideoPreviewFaceOutlineDetector.getInstance().needDetectFaceValue()) {
      break label9;
    }
    for (;;)
    {
      label9:
      return;
      if (this.filters != null)
      {
        if ((!this.mPopularValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mPopularValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
        {
          float f = VideoPreviewFaceOutlineDetector.getInstance().getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value);
          if ((int)(f * 100.0F) == 0) {
            break;
          }
          this.mPopularValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
        }
        int i = 0;
        while (i < this.filters.size())
        {
          VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(i);
          if ((localVideoFilterBase instanceof NormalVideoFilter))
          {
            StickerItem localStickerItem = ((NormalVideoFilter)localVideoFilterBase).getStickerItem();
            if (localStickerItem != null)
            {
              if (localStickerItem.popularRange != null) {
                localStickerItem.popularRange.setValue(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue());
              }
              if (((localVideoFilterBase instanceof DynamicNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value)) {
                ((DynamicNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
              if (((localVideoFilterBase instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value)) {
                ((StaticNumFilter)localVideoFilterBase).setNum((int)(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void init()
  {
    this.mCurPersonId = -1;
    MaterialManager.getInstance().setCurrentMaterial(this.material);
    if (b.xdf) {
      setRenderMode(1);
    }
  }
  
  private void mappingFace(List<Face> paramList, List<List<PointF>> paramList1, List<float[]> paramList2, int paramInt)
  {
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
        break label647;
      }
      localObject5 = new Face();
      ((Face)localObject5).facePoints = ((List)paramList1.get(i));
      ((Face)localObject5).faceAngles = ((float[])paramList2.get(i));
      ((Face)localObject5).faceIndex = ((Integer)((List)localObject3).get(paramInt)).intValue();
      this.mCharmValueMap.remove(Integer.valueOf(((Face)localObject5).faceIndex));
      ((List)localObject2).add(localObject5);
      paramInt += 1;
    }
    label647:
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
      return;
    }
  }
  
  public static boolean needMultiViewerMaterial()
  {
    return false;
  }
  
  private boolean needRender(VideoFilterBase paramVideoFilterBase)
  {
    Object localObject;
    if ((paramVideoFilterBase instanceof NormalVideoFilter))
    {
      localObject = ((NormalVideoFilter)paramVideoFilterBase).getStickerItem();
      if ((localObject == null) || (!((NormalVideoFilter)paramVideoFilterBase).isRenderReady())) {
        return false;
      }
      if (this.mCurPersonId == -1) {
        return true;
      }
      if ((((StickerItem)localObject).personID != -1) && (((StickerItem)localObject).personID != this.mCurPersonId)) {
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof FaceOffFilter))
    {
      localObject = (FaceOffFilter)paramVideoFilterBase;
      FaceItem localFaceItem = ((FaceOffFilter)localObject).getFaceOffItem();
      if ((localFaceItem == null) || (!((FaceOffFilter)localObject).isRenderReady())) {
        return false;
      }
      if (this.mCurPersonId == -1) {
        return true;
      }
      if ((localFaceItem.personID != -1) && (localFaceItem.personID != this.mCurPersonId)) {
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof TransformFilterNew))
    {
      localObject = ((TransformFilterNew)paramVideoFilterBase).getFaceMeshItem();
      if ((localObject != null) && (((((FaceMeshItem)localObject).personID != -1) && (this.mCurPersonId != -1) && (((FaceMeshItem)localObject).personID != this.mCurPersonId)) || ((this.mCurPersonId != -1) && (((FaceMeshItem)localObject).charmRange != null) && (!((FaceMeshItem)localObject).charmRange.isHit())))) {
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof FaceCropFilter)) {
      return ((FaceCropFilter)paramVideoFilterBase).isNeedRender();
    }
    return true;
  }
  
  private void processMappingFace(List<List<PointF>> paramList, List<float[]> paramList1, int paramInt)
  {
    if (!this.mFaceList.isEmpty()) {
      if (this.gameFilter == null)
      {
        mappingFace(this.mFaceList, paramList, paramList1, paramInt);
        Collections.sort(this.mFaceList, this.mFaceIndexComperator);
      }
    }
    for (;;)
    {
      return;
      this.mFaceList.clear();
      paramInt = 0;
      Face localFace;
      while (paramInt < paramList.size())
      {
        localFace = new Face();
        localFace.facePoints = ((List)paramList.get(paramInt));
        localFace.faceAngles = ((float[])paramList1.get(paramInt));
        localFace.faceIndex = paramInt;
        this.mFaceList.add(localFace);
        paramInt += 1;
      }
      continue;
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
    }
  }
  
  private void removeValueRangeForFace(int paramInt)
  {
    this.mCharmValueMap.remove(Integer.valueOf(paramInt));
    this.mAgeValueMap.remove(Integer.valueOf(paramInt));
    this.mGenderValueMap.remove(Integer.valueOf(paramInt));
    this.mPopularValueMap.remove(Integer.valueOf(paramInt));
    this.mCpValueMap.remove(Integer.valueOf(paramInt));
  }
  
  private void syncCharmRangeAndHandsRangeValue(boolean paramBoolean)
  {
    double d;
    if (((!VideoUtil.isEmpty(this.mFaceList)) && (!this.mCharmValueMap.containsKey(Integer.valueOf(((Face)this.mFaceList.get(0)).faceIndex)))) || ((paramBoolean) && (!this.mHandsValueMap.containsKey(Integer.valueOf(0))))) {
      d = mRandom.nextDouble();
    }
    for (;;)
    {
      if (d < 0.0D) {
        d = mRandom.nextDouble();
      }
      for (;;)
      {
        if (!VideoUtil.isEmpty(this.mFaceList))
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
            if ((!VideoUtil.isEmpty(this.mFaceList)) && (this.mCharmValueMap.containsKey(Integer.valueOf(((Face)this.mFaceList.get(0)).faceIndex))))
            {
              d = ((Double)this.mCharmValueMap.get(Integer.valueOf(((Face)this.mFaceList.get(0)).faceIndex))).doubleValue();
              break;
            }
            if (!this.mHandsValueMap.containsKey(Integer.valueOf(0))) {
              break label373;
            }
            d = ((Double)this.mHandsValueMap.get(Integer.valueOf(0))).doubleValue();
            break;
          }
        }
        if (paramBoolean) {
          this.mHandsValueMap.put(Integer.valueOf(0), Double.valueOf(d));
        }
        return;
      }
      label373:
      d = -1.0D;
    }
  }
  
  private void syncRandomGroupValue(boolean paramBoolean)
  {
    if (this.material.getRandomGroupCount() <= 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mFaceList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Integer.valueOf(((Face)localIterator.next()).faceIndex));
    }
    RandomGroupManager.getInstance().updateValue(localArrayList, paramBoolean, this.material.getRandomGroupCount());
  }
  
  public void ApplyGLSLFilter()
  {
    init();
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.gestureFilters.iterator();
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
    if (this.mLipsCosFilter != null) {
      this.mLipsCosFilter.ApplyGLSLFilter();
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.ApplyGLSLFilter();
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.ApplyGLSLFilter();
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
    if (this.fastStickerFilter != null) {
      this.fastStickerFilter.ApplyGLSLFilter();
    }
    this.mCopyFilter.ApplyGLSLFilter();
    int i = 0;
    while (i < this.copyFrame.length)
    {
      this.copyFrame[i] = new h();
      i += 1;
    }
    VideoPreviewFaceOutlineDetector.getInstance().setFaceValueDetectType(this.material.getFaceValueDetectType());
  }
  
  public h RenderProcess(h paramh)
  {
    if (VideoUtil.isEmpty(this.filters)) {
      return paramh;
    }
    h localh2;
    int i;
    h localh1;
    label69:
    VideoFilterBase localVideoFilterBase;
    h localh3;
    if (paramh.texture[0] == this.copyFrame[0].texture[0])
    {
      localh2 = this.copyFrame[1];
      GLES20.glBindFramebuffer(36160, paramh.bcC[0]);
      GLES20.glViewport(0, 0, paramh.width, paramh.height);
      i = 0;
      localh1 = paramh;
      if (i >= this.filters.size()) {
        return localh1;
      }
      localVideoFilterBase = (VideoFilterBase)this.filters.get(i);
      if (!needRender(localVideoFilterBase)) {
        break label335;
      }
      if (VideoFilterUtil.canUseBlendMode(localVideoFilterBase)) {
        break label297;
      }
      localh3 = localh1;
      if (VideoFileUtil.needCopy(localVideoFilterBase)) {
        localh3 = FrameUtil.renderProcessBySwitchFbo(localh1.texture[0], localh1.width, localh1.height, this.mCopyFilter, paramh, localh2);
      }
      BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
      if ((!VideoFilterUtil.maybeTransformFilter(localVideoFilterBase)) || (!VideoMaterialUtil.needCopyTransform())) {
        break label268;
      }
      localh1 = FrameUtil.renderProcessByCopy(localh3.texture[0], localh3.width, localh3.height, localVideoFilterBase, this.mCopyFilter, paramh, localh2);
      label222:
      BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
    }
    label268:
    label297:
    label335:
    for (;;)
    {
      i += 1;
      break label69;
      localh2 = this.copyFrame[0];
      break;
      localh1 = FrameUtil.renderProcessBySwitchFbo(localh3.texture[0], localh3.width, localh3.height, localVideoFilterBase, paramh, localh2);
      break label222;
      BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
      localVideoFilterBase.OnDrawFrameGLSL();
      localVideoFilterBase.renderTexture(localh1.texture[0], localh1.width, localh1.height);
      BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
    }
    return localh1;
  }
  
  public void addTouchPoint(PointF paramPointF)
  {
    this.mARTouchPointQueue.offer(paramPointF);
  }
  
  public void addTouchPoint(PointF paramPointF, float paramFloat, boolean paramBoolean)
  {
    if (paramPointF == null) {
      return;
    }
    if ((paramBoolean) || (this.mTouchPoints.size() == 0)) {
      this.mTouchPoints.add(new ArrayList());
    }
    ((List)this.mTouchPoints.get(this.mTouchPoints.size() - 1)).add(paramPointF);
    this.mScaleFace = paramFloat;
  }
  
  public void destroy()
  {
    destroyAudio();
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).clearGLSLSelf();
    }
    localIterator = this.gestureFilters.iterator();
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
    this.renderFrame.clear();
    this.mEffectFrame.clear();
    this.mHeadCropFrame.clear();
    this.mBgFrame.clear();
    this.fabbyStrokeFrame.clear();
    this.fabbyFeatheredMaskStep1.clear();
    this.fabbyFeatheredMaskStep2.clear();
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
    if (this.mLipsCosFilter != null) {
      this.mLipsCosFilter.clear();
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
    if (this.fastStickerFilter != null) {
      this.fastStickerFilter.clearGLSLSelf();
    }
    if (this.fabbyOriginCopyFrame != null) {
      this.fabbyOriginCopyFrame.clear();
    }
    destroyAudio();
    if (LogicDataManager.getInstance().needDecibel()) {
      LogicDataManager.getInstance().destroy();
    }
  }
  
  public void destroyAudio()
  {
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
  }
  
  public h doFabbyStroke(h paramh1, h paramh2)
  {
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
      return this.fabbyStrokeFrame;
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
  
  public CrazyFaceFilters getCrazyFaceFilters()
  {
    return this.crazyFaceFilters;
  }
  
  public FastStickerFilter getFastStickerFilter()
  {
    return this.fastStickerFilter;
  }
  
  public List<VideoFilterBase> getFgStaticStickerFilters()
  {
    return this.fgStaticStickerFilters;
  }
  
  public List<VideoFilterBase> getFilters()
  {
    return this.filters;
  }
  
  public GameFilter getGameFilter()
  {
    return this.gameFilter;
  }
  
  public VideoMaterial getMaterial()
  {
    return this.material;
  }
  
  public boolean isSegmentRequired()
  {
    if (this.material == null) {
      return false;
    }
    return this.material.isSegmentRequired();
  }
  
  public boolean needDetectGesture()
  {
    return this.needDetectGesture;
  }
  
  public boolean needFaceInfo(int paramInt)
  {
    paramInt = (paramInt + 360) % 360;
    return ((paramInt != 90) && (paramInt != 270)) || (this.material.isSupportLandscape());
  }
  
  public void onPause()
  {
    destroyAudio();
  }
  
  public void onResume()
  {
    if (this.mActFilters != null) {
      this.mActFilters.reset(System.currentTimeMillis());
    }
  }
  
  public h process(h paramh, List<FaceStatus> paramList, List<List<PointF>> paramList1, List<float[]> paramList2, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList3, float[] paramArrayOfFloat, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, double paramDouble, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    if ((paramBoolean) && (!getMaterial().isSupportLandscape()))
    {
      destroyNormalAudio();
      return paramh;
    }
    if (VideoPreviewFaceOutlineDetector.getInstance().getFaceCount() > 0) {
      setImageData(paramArrayOfByte);
    }
    updateVideoSize(paramh.width, paramh.height, paramDouble);
    BenchUtil.benchStart("[VideoFilterList] updateAndRender");
    paramh = updateAndRender(paramh, paramList, paramList1, paramList2, paramMap, paramList3, paramArrayOfFloat, paramMap1, paramSet, paramDouble, paramLong);
    BenchUtil.benchEnd("[VideoFilterList] updateAndRender");
    return paramh;
  }
  
  public boolean render3DFirst()
  {
    return false;
  }
  
  public void renderARFilterIfNeeded(h paramh)
  {
    if (this.mARParticleFilter != null)
    {
      VideoFilterUtil.setBlendMode(true);
      paramh.a(-1, paramh.width, paramh.height, 0.0D);
      while (!this.mARTouchPointQueue.isEmpty())
      {
        PointF localPointF = (PointF)this.mARTouchPointQueue.poll();
        if (localPointF != null) {
          this.mARParticleFilter.addTouchPoint(localPointF);
        }
      }
      this.mARParticleFilter.updateAndRender(paramh);
      VideoFilterUtil.setBlendMode(false);
    }
  }
  
  public Bitmap renderForBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.filters == null) {
      return f.ax(paramInt1, paramInt2, paramInt3);
    }
    VideoFilterUtil.setBlendMode(true);
    h localh2 = new h();
    this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, localh2);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    paramInt1 = 0;
    h localh1 = localh2;
    if (paramInt1 < this.filters.size())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(paramInt1);
      if (!VideoFilterUtil.canUseBlendMode(localVideoFilterBase))
      {
        localObject = localh1;
        if (VideoFileUtil.needCopy(localVideoFilterBase)) {
          localObject = FrameUtil.renderProcessBySwitchFbo(localh1.texture[0], paramInt2, paramInt3, this.mCopyFilter, localh2, this.copyFrame[0]);
        }
        localh1 = FrameUtil.renderProcessBySwitchFbo(localObject.texture[0], paramInt2, paramInt3, localVideoFilterBase, localh2, this.copyFrame[0]);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localVideoFilterBase.OnDrawFrameGLSL();
        localVideoFilterBase.renderTexture(localh1.texture[0], paramInt2, paramInt3);
      }
    }
    VideoFilterUtil.setBlendMode(false);
    Object localObject = f.ax(localh1.texture[0], paramInt2, paramInt3);
    localh1.clear();
    return localObject;
  }
  
  public void setARParticleFilter(ARParticleFilter paramARParticleFilter)
  {
    this.mARParticleFilter = paramARParticleFilter;
  }
  
  public void setActFilter(ActFilters paramActFilters)
  {
    this.mActFilters = paramActFilters;
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
  
  public void setFastStickerFilter(FastStickerFilter paramFastStickerFilter)
  {
    this.fastStickerFilter = paramFastStickerFilter;
  }
  
  public void setFilters(List<VideoFilterBase> paramList)
  {
    this.filters = paramList;
    this.fgStaticStickerFilters = getStickerFilters(paramList, true, true);
    this.fgOtherFilters = getStickerFilters(paramList, false, true);
    this.bgStaticStickerFilters = getStickerFilters(paramList, true, false);
    this.bgDynamicStickerFilters = getStickerFilters(paramList, false, false);
  }
  
  public void setGameFilter(GameFilter paramGameFilter) {}
  
  public void setGestureFilters(List<VideoFilterBase> paramList)
  {
    this.gestureFilters = paramList;
  }
  
  public void setHeadCropFilter(HeadCropFilter paramHeadCropFilter)
  {
    this.headCropFilter = paramHeadCropFilter;
  }
  
  public void setHeadCropItemFilters(List<VideoFilterBase> paramList)
  {
    this.headCropItemFilters = paramList;
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
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
  }
  
  public void setIsRenderForBitmap(boolean paramBoolean)
  {
    if (this.filters != null)
    {
      int i = 0;
      while (i < this.filters.size())
      {
        ((VideoFilterBase)this.filters.get(i)).setIsRenderForBitmap(paramBoolean);
        i += 1;
      }
    }
  }
  
  public void setLipsCosFilter(LipsCosFilter paramLipsCosFilter)
  {
    this.mLipsCosFilter = paramLipsCosFilter;
  }
  
  public void setMaterial(VideoMaterial paramVideoMaterial)
  {
    this.material = paramVideoMaterial;
  }
  
  public void setMaterialMute()
  {
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.destroyAudioPlayer();
    }
    if (this.mActFilters != null) {
      this.mActFilters.destroyAudio();
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.destroyAudio();
    }
    if (this.fastStickerFilter != null) {
      this.fastStickerFilter.destroyAudio();
    }
    Iterator localIterator = this.fgStaticStickerFilters.iterator();
    VideoFilterBase localVideoFilterBase;
    while (localIterator.hasNext())
    {
      localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if (localVideoFilterBase != null) {
        if ((localVideoFilterBase instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localVideoFilterBase).destroyAudio();
        } else if ((localVideoFilterBase instanceof StaticNumFilter)) {
          ((StaticNumFilter)localVideoFilterBase).destroyAudio();
        }
      }
    }
    localIterator = this.bgStaticStickerFilters.iterator();
    while (localIterator.hasNext())
    {
      localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if (localVideoFilterBase != null) {
        if ((localVideoFilterBase instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localVideoFilterBase).destroyAudio();
        } else if ((localVideoFilterBase instanceof StaticNumFilter)) {
          ((StaticNumFilter)localVideoFilterBase).destroyAudio();
        }
      }
    }
    localIterator = this.fgOtherFilters.iterator();
    while (localIterator.hasNext())
    {
      localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase != null) && ((localVideoFilterBase instanceof NormalVideoFilter))) {
        ((NormalVideoFilter)localVideoFilterBase).destroyAudio();
      }
    }
    localIterator = this.bgDynamicStickerFilters.iterator();
    while (localIterator.hasNext())
    {
      localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase != null) && ((localVideoFilterBase instanceof NormalVideoFilter))) {
        ((NormalVideoFilter)localVideoFilterBase).destroyAudio();
      }
    }
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
  
  public void setOrigFrame(h paramh)
  {
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof FaceOffFilter)) {
        ((FaceOffFilter)localVideoFilterBase).setOrigFrame(paramh);
      }
    }
  }
  
  public void setOutScale(float paramFloat)
  {
    this.outScale = paramFloat;
  }
  
  public void setRatioMode(VideoFilterUtil.RATIO_MODE paramRATIO_MODE)
  {
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof StaticStickerFilter)) {
        ((StaticStickerFilter)localVideoFilterBase).setRatioMode(paramRATIO_MODE);
      }
    }
    if (this.fastStickerFilter != null) {
      this.fastStickerFilter.setRatioMode(paramRATIO_MODE);
    }
    if (this.multiViewerFilters != null)
    {
      localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext()) {
        ((MultiViewerFilter)localIterator.next()).setRatioMode(paramRATIO_MODE);
      }
    }
  }
  
  public void setRenderMode(int paramInt)
  {
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
    if (this.mLipsCosFilter != null) {
      this.mLipsCosFilter.setRenderMode(paramInt);
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.setRenderMode(paramInt);
    }
    if (this.mActFilters != null) {
      this.mActFilters.setRenderMode(paramInt);
    }
    if (this.fastStickerFilter != null) {
      this.fastStickerFilter.setRenderMode(paramInt);
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
  }
  
  public void setVideoEffectFilter(VideoFilterBase paramVideoFilterBase)
  {
    this.mEffectFilter = paramVideoFilterBase;
  }
  
  public void setVideoEffectOrder(int paramInt)
  {
    this.mEffectOrder = paramInt;
  }
  
  public void updateAllFilters(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat)
  {
    long l = System.currentTimeMillis();
    updateFilters(paramList1, paramArrayOfFloat, paramMap, paramList2, paramMap1, paramSet, paramFloat, this.filters, l);
  }
  
  public h updateAndRender(h paramh, List<FaceStatus> paramList, List<List<PointF>> paramList1, List<float[]> paramList2, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList3, float[] paramArrayOfFloat, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, double paramDouble, long paramLong)
  {
    VideoFilterUtil.setBlendMode(true);
    GLES20.glBindFramebuffer(36160, paramh.bcC[0]);
    GLES20.glViewport(0, 0, paramh.width, paramh.height);
    paramList = paramh;
    if (this.mEffectOrder == 1)
    {
      paramList = paramh;
      if (this.mEffectFilter != null)
      {
        this.mEffectFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mEffectFrame);
        paramList = this.mEffectFrame;
      }
    }
    if (VideoMaterialUtil.isFaceCopyMaterial(getMaterial()))
    {
      paramList2 = this.filters.iterator();
      for (;;)
      {
        paramh = paramList;
        if (!paramList2.hasNext()) {
          break;
        }
        paramh = (VideoFilterBase)paramList2.next();
        if ((paramh instanceof FaceCopyFilter))
        {
          paramh = (FaceCopyFilter)paramh;
          paramh.setFaceParams(paramList1, paramList.texture[0]);
          paramh.renderProcess(paramSet);
        }
      }
    }
    if (VideoMaterialUtil.isFaceSwitchMaterial(getMaterial()))
    {
      this.mCopyFilter.RenderProcess(paramList.texture[0], paramList.width, paramList.height, -1, 0.0D, this.copyFrame[0]);
      GLES20.glBindFramebuffer(36160, paramList.bcC[0]);
      GLES20.glViewport(0, 0, paramList.width, paramList.height);
      paramList2 = this.filters.iterator();
      for (;;)
      {
        paramh = paramList;
        if (!paramList2.hasNext()) {
          break;
        }
        paramh = (VideoFilterBase)paramList2.next();
        if ((paramh instanceof SwitchFaceFilter))
        {
          paramh = (SwitchFaceFilter)paramh;
          paramh.setFaceParams(paramList1, this.copyFrame[0].texture[0]);
          paramh.renderProcess(paramSet);
        }
      }
    }
    if (getMaterial().getShaderType() == VideoMaterialUtil.SHADER_TYPE.DOODLE.value)
    {
      paramList2 = this.filters.iterator();
      for (;;)
      {
        paramh = paramList;
        if (!paramList2.hasNext()) {
          break;
        }
        paramh = (VideoFilterBase)paramList2.next();
        if ((paramh instanceof DoodleFilter))
        {
          paramh = (DoodleFilter)paramh;
          paramh.setTouchPoints(paramList1, this.mTouchPoints, paramList.width, paramList.height, this.mScaleFace);
          paramh.renderProcess();
        }
      }
    }
    int j = Math.min(paramList1.size(), getMaterial().getMaxFaceCount());
    paramh = paramList;
    if (this.crazyFaceFilters != null)
    {
      paramh = paramList;
      if (j > 0)
      {
        float[] arrayOfFloat = (float[])paramList2.get(0);
        List localList = (List)paramList1.get(0);
        paramh = paramList;
        if (!FaceAverageUtil.isPositiveFace(arrayOfFloat, localList, paramList.width, paramList.height, paramDouble)) {
          break label913;
        }
        paramh = this.crazyFaceFilters.updateAndRender(paramList, paramList.width, paramList.height, localList, arrayOfFloat);
      }
    }
    processMappingFace(paramList1, paramList2, paramh.width);
    if (j <= 0)
    {
      setCurPersonId(-1);
      updateFilters(null, null, paramMap, null, paramMap1, paramSet, 0.0F, this.fgOtherFilters, paramLong);
      paramh = RenderProcessForFilters(paramh, this.fgOtherFilters);
      clearCharmRangeItemStatus();
      clearGenderRangeItemStatus();
      clearPopularRangeItemStatus();
      clearAgeRangeItemStatus();
      clearFaceMappingData();
    }
    for (;;)
    {
      if (j < 2) {
        clearCpRangeItemStatus();
      }
      if (!hasHands(paramList3)) {
        clearHandsRangeItemStatus();
      }
      syncCharmRangeAndHandsRangeValue(hasHands(paramList3));
      syncRandomGroupValue(hasHands(paramList3));
      int i = 0;
      while (i < j)
      {
        paramList = (Face)this.mFaceList.get(i);
        setCurPersonId(paramList.faceIndex);
        hitCharmRangeItem(paramList.faceIndex);
        hitFaceRandomGroupItem(paramList.faceIndex);
        hitAgeRangeItem(paramList.faceIndex);
        hitGenderRangeItem(paramList.faceIndex);
        hitPopularRangeItem(paramList.faceIndex);
        hitCpRangeItem(paramList.faceIndex, j);
        if ((this.mCurPersonId <= 1) && (this.mLipsCosFilter != null)) {
          this.mLipsCosFilter.updateAndRender(paramh, paramh.width, paramh.height, paramList.facePoints, paramList.faceAngles, null);
        }
        BenchUtil.benchStart("[showPreview]updateAllFilters");
        updateFilters(paramList.facePoints, paramList.faceAngles, paramMap, paramList3, paramMap1, paramSet, 0.0F, this.fgOtherFilters, paramLong);
        BenchUtil.benchEnd("[showPreview]updateAllFilters");
        BenchUtil.benchStart("[showPreview]RenderProcess");
        paramh = RenderProcessForFilters(paramh, this.multiViewerOutFrame, this.fgOtherFilters);
        BenchUtil.benchEnd("[showPreview]RenderProcess");
        i += 1;
      }
      paramList = paramh;
      if (this.fastStickerFilter != null)
      {
        BenchUtil.benchStart("[showPreview]RenderProcessForFastStickerFilter");
        paramList = RenderProcessForFastStickerFilter(paramh, this.multiViewerOutFrame, this.mFaceList, j, paramMap, paramList3, paramMap1, paramSet, 0.0F, paramLong, this.mCurPersonId);
        BenchUtil.benchEnd("[showPreview]RenderProcessForFastStickerFilter");
      }
      if ((this.gestureFilters != null) && (!this.gestureFilters.isEmpty()))
      {
        hitHandsRangeItem();
        hitHandRandomGroupItem();
        updateFilters(null, paramArrayOfFloat, paramMap, paramList3, paramMap1, paramSet, 0.0F, this.gestureFilters, paramLong);
      }
      for (paramh = RenderProcessForFilters(paramList, this.gestureFilters);; paramh = paramList)
      {
        VideoFilterUtil.setBlendMode(false);
        label913:
        return paramh;
      }
    }
  }
  
  public h updateAndRender3DFilter(h paramh, List<FaceStatus> paramList, Map<Integer, FaceActionCounter> paramMap, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, int paramInt)
  {
    return paramh;
  }
  
  public h updateAndRenderActMaterial(h paramh, List<List<PointF>> paramList, List<float[]> paramList1, double paramDouble, int paramInt)
  {
    h localh = paramh;
    if (this.mActFilters != null)
    {
      long l = System.currentTimeMillis();
      VideoFilterUtil.setBlendMode(true);
      localh = this.mActFilters.updateAndRender(paramh, l, paramList, paramList1, paramDouble, paramInt);
      VideoFilterUtil.setBlendMode(false);
    }
    return localh;
  }
  
  public h updateAndRenderBgFilters(h paramh, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, double paramDouble, long paramLong)
  {
    updateVideoSize(paramh.width, paramh.height, paramDouble);
    this.mBgFrame.a(-1, paramh.width, paramh.height, 0.0D);
    FrameUtil.clearFrame(this.mBgFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramh.width, paramh.height);
    h localh = this.mBgFrame;
    VideoFilterUtil.setBlendMode(true);
    int j = Math.min(paramList.size(), getMaterial().getMaxFaceCount());
    int i = 0;
    while (i < j)
    {
      BenchUtil.benchStart("[showPreview]updateAllFilters");
      updateFilters((List)paramList.get(i), (float[])paramList1.get(i), paramMap, paramList2, paramMap1, paramSet, 0.0F, this.bgDynamicStickerFilters, paramLong);
      BenchUtil.benchEnd("[showPreview]updateAllFilters");
      BenchUtil.benchStart("[showPreview]RenderProcess");
      localh = RenderProcessForFilters(localh, this.bgDynamicStickerFilters);
      BenchUtil.benchEnd("[showPreview]RenderProcess");
      i += 1;
    }
    if (paramList.size() <= 0) {
      updateFilters(null, null, paramMap, paramList2, paramMap1, paramSet, 0.0F, this.bgStaticStickerFilters, paramLong);
    }
    for (paramList = RenderProcessForFilters(localh, this.bgStaticStickerFilters);; paramList = RenderProcessForFilters(localh, this.bgStaticStickerFilters))
    {
      this.mMaskFilter.OnDrawFrameGLSL();
      this.mMaskFilter.renderTexture(paramh.texture[0], paramh.width, paramh.height);
      VideoFilterUtil.setBlendMode(false);
      return paramList;
      updateFilters((List)paramList.get(0), (float[])paramList1.get(0), paramMap, paramList2, paramMap1, paramSet, 0.0F, this.bgStaticStickerFilters, paramLong);
    }
  }
  
  public h updateAndRenderFabbyMV(h paramh, Map<Integer, h> paramMap, Map<Integer, FaceActionCounter> paramMap1, Set<Integer> paramSet, long paramLong)
  {
    if (this.fabbyMvFilters != null)
    {
      if ((paramMap == null) || (!paramMap.containsKey(Integer.valueOf(0))) || (paramh.texture[0] != ((h)paramMap.get(Integer.valueOf(0))).texture[0])) {
        break label118;
      }
      this.mCopyFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.fabbyOriginCopyFrame);
      paramh = this.fabbyOriginCopyFrame;
    }
    label118:
    for (;;)
    {
      return this.fabbyMvFilters.updateAndRender(paramh, paramMap, paramMap1, paramSet, paramLong);
      return (h)paramMap.values().iterator().next();
    }
  }
  
  public h updateAndRenderHeadCropItemFilters(h paramh, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, double paramDouble, int paramInt, long paramLong)
  {
    paramInt = (paramInt + 360) % 360;
    if (((paramInt == 90) || (paramInt == 270)) && (!this.material.isSupportLandscape())) {
      return paramh;
    }
    updateVideoSize(paramh.width, paramh.height, paramDouble);
    VideoFilterUtil.setBlendMode(true);
    if (this.headCropFilter != null)
    {
      this.mCopyFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mHeadCropFrame);
      this.headCropFilter.setInputFrame(this.mHeadCropFrame);
      paramh.a(-1, paramh.width, paramh.height, 0.0D);
    }
    h localh = paramh;
    if (paramList != null)
    {
      if (paramList.size() > 0) {
        break label171;
      }
      updateFilters(null, null, paramMap, paramList2, paramMap1, paramSet, 0.0F, this.headCropItemFilters, paramLong);
    }
    for (localh = RenderProcessForFilters(paramh, this.headCropItemFilters);; localh = RenderProcessForFilters(paramh, this.headCropItemFilters))
    {
      VideoFilterUtil.setBlendMode(false);
      return localh;
      label171:
      updateFilters((List)paramList.get(0), (float[])paramList1.get(0), paramMap, paramList2, paramMap1, paramSet, 0.0F, this.headCropItemFilters, paramLong);
    }
  }
  
  public void updateAndRenderMultiViewerMaterial(Map<Integer, h> paramMap, h paramh, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap1, List<PointF> paramList2, float[] paramArrayOfFloat, Map<Integer, HandActionCounter> paramMap2, Set<Integer> paramSet, double paramDouble, byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramMap.clear();
    if (this.multiViewerFilters != null)
    {
      FabbyFaceActionCounter localFabbyFaceActionCounter = (FabbyFaceActionCounter)paramMap1.get(Integer.valueOf(VideoMaterialUtil.TRIGGER_TYPE.MV_PART_INDEX.value));
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
        for (Object localObject = (PointF)localFabbyFaceActionCounter.scaleMap.get(Integer.valueOf(j));; localObject = new PointF(1.0F, 1.0F))
        {
          float f = Math.max(((PointF)localObject).x, ((PointF)localObject).y);
          localMultiViewerFilter.setOutScale(f);
          int k = (int)(paramh.width * f);
          int m = (int)(f * paramh.height);
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
          localObject = localMultiViewerFilter.render(paramh, (h)localObject, paramList, paramList1, paramMap1, paramList2, paramArrayOfFloat, paramMap2, paramSet, paramDouble, paramArrayOfByte, paramInt, paramLong, paramBoolean);
          BenchUtil.benchEnd("updateAndRenderMultiViewerMaterial - multiViewerFilter.render");
          paramMap.put(Integer.valueOf(j), localObject);
          i += 1;
          break;
        }
      }
    }
  }
  
  public h updateAndRenderStaticStickers(h paramh, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, double paramDouble, int paramInt, long paramLong)
  {
    paramInt = (paramInt + 360) % 360;
    if (((paramInt == 90) || (paramInt == 270)) && (!this.material.isSupportLandscape())) {
      return paramh;
    }
    updateVideoSize(paramh.width, paramh.height, paramDouble);
    VideoFilterUtil.setBlendMode(true);
    if (paramList.size() <= 0) {
      updateFilters(null, null, paramMap, paramList2, paramMap1, paramSet, 0.0F, this.fgStaticStickerFilters, paramLong);
    }
    for (paramh = RenderProcessForFilters(paramh, this.fgStaticStickerFilters);; paramh = RenderProcessForFilters(paramh, this.fgStaticStickerFilters))
    {
      paramList = paramh;
      if (this.mEffectOrder == 2)
      {
        paramList = paramh;
        if (this.mEffectFilter != null)
        {
          this.mEffectFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mEffectFrame);
          paramList = this.mEffectFrame;
        }
      }
      VideoFilterUtil.setBlendMode(false);
      return paramList;
      updateFilters((List)paramList.get(0), (float[])paramList1.get(0), paramMap, paramList2, paramMap1, paramSet, 0.0F, this.fgStaticStickerFilters, paramLong);
    }
  }
  
  public void updateCosAlpha(int paramInt)
  {
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
  }
  
  public void updateFilters(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, List<VideoFilterBase> paramList, long paramLong)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((VideoFilterBase)paramList.next()).updatePreview(paramList1, paramArrayOfFloat, paramMap, paramList2, paramMap1, paramSet, paramFloat, paramLong);
    }
  }
  
  public void updateTextureParam(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, long paramLong)
  {
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
      while (localIterator.hasNext())
      {
        localVideoFilterBase = (VideoFilterBase)localIterator.next();
        if ((localVideoFilterBase instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localVideoFilterBase).updateTextureParam(paramLong);
        }
      }
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.updateTextureParam(paramMap, paramSet, paramLong);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    paramDouble /= this.outScale;
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.gestureFilters.iterator();
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
    if (this.mLipsCosFilter != null) {
      this.mLipsCosFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.fastStickerFilter != null) {
      this.fastStickerFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoFilterList
 * JD-Core Version:    0.7.0.1
 */