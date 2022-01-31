package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.model.DistortParam;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeautyTransformList
{
  private static final int MAX_TRANSFORMED_FACES = 5;
  private TransformFilter mBasic3 = null;
  private BeautyParam mBeautyParam;
  private TransformFilter mChinThinShorten;
  private BaseFilter mCopyFilter;
  private List<TransformFilter> mFilters;
  private TransformFilter mVFaceEyeNose;
  private h transFrame = new h();
  
  public BeautyTransformList()
  {
    BenchUtil.benchStart("[onSurfaceCreated] create BeautyParam");
    this.mBeautyParam = new BeautyParam(false);
    BenchUtil.benchEnd("[onSurfaceCreated] create BeautyParam");
    this.mVFaceEyeNose = new TransformFilter(null, null);
    this.mChinThinShorten = new TransformFilter(null, null);
    this.mBasic3 = new TransformFilter(null, null);
    this.mFilters = new ArrayList();
    this.mCopyFilter = new BaseFilter(GLSLRender.bcE);
  }
  
  private void rebuildFilterList()
  {
    this.mFilters.clear();
    if ((this.mBeautyParam.vlian.getLevel() != 0) || (this.mBeautyParam.eye.getLevel() != 0) || (this.mBeautyParam.nose.getLevel() != 0)) {
      this.mFilters.add(this.mVFaceEyeNose);
    }
    if ((this.mBeautyParam.zhailian.getLevel() != 0) || (this.mBeautyParam.xiaba.getLevel() != 0) || (this.mBeautyParam.faceShorten.getLevel() != 0)) {
      this.mFilters.add(this.mChinThinShorten);
    }
    if (this.mBeautyParam.basic3.getLevel() != 0) {
      this.mFilters.add(this.mBasic3);
    }
    this.transFrame.clear();
  }
  
  public void clear()
  {
    this.transFrame.clear();
    this.mVFaceEyeNose.clearGLSLSelf();
    this.mChinThinShorten.clearGLSLSelf();
    this.mBasic3.clearGLSLSelf();
    this.mCopyFilter.ClearGLSL();
  }
  
  public BeautyParam getBeautyParam()
  {
    return this.mBeautyParam;
  }
  
  public void initial()
  {
    BenchUtil.benchStart("[onSurfaceCreated] create Beauty Transform Filters");
    this.mVFaceEyeNose.ApplyGLSLFilter();
    this.mChinThinShorten.ApplyGLSLFilter();
    this.mBasic3.ApplyGLSLFilter();
    BenchUtil.benchEnd("[onSurfaceCreated] create Beauty Transform Filters");
    BenchUtil.benchStart("[onSurfaceCreated] create Beauty mCopyFilter");
    this.mCopyFilter.ApplyGLSLFilter();
    BenchUtil.benchEnd("[onSurfaceCreated] create Beauty mCopyFilter");
  }
  
  public boolean needFaceInfo()
  {
    return this.mFilters.size() != 0;
  }
  
  public h process(h paramh, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, double paramDouble)
  {
    updateVideoSize(paramh.width, paramh.height, paramDouble);
    return updateAndRender(paramh, paramList, paramList1, paramMap, paramList2, paramMap1, paramSet);
  }
  
  public void setBeautyParam(int paramInt, DistortParam paramDistortParam)
  {
    if (paramDistortParam == null) {
      return;
    }
    if ((paramInt == BeautyRealConfig.TYPE.FACE_V.value) || (paramInt == BeautyRealConfig.TYPE.EYE.value) || (paramInt == BeautyRealConfig.TYPE.NOSE.value)) {
      if (paramInt == BeautyRealConfig.TYPE.FACE_V.value)
      {
        this.mBeautyParam.vlian = paramDistortParam;
        paramDistortParam = new ArrayList();
        paramDistortParam.addAll(this.mBeautyParam.vlian.getItems());
        paramDistortParam.addAll(this.mBeautyParam.eye.getItems());
        paramDistortParam.addAll(this.mBeautyParam.nose.getItems());
        this.mVFaceEyeNose.setDistortionItems(paramDistortParam);
      }
    }
    for (;;)
    {
      rebuildFilterList();
      return;
      if (paramInt == BeautyRealConfig.TYPE.EYE.value)
      {
        this.mBeautyParam.eye = paramDistortParam;
        break;
      }
      if (paramInt != BeautyRealConfig.TYPE.NOSE.value) {
        break;
      }
      this.mBeautyParam.nose = paramDistortParam;
      break;
      if ((paramInt == BeautyRealConfig.TYPE.FACE_THIN.value) || (paramInt == BeautyRealConfig.TYPE.CHIN.value) || (paramInt == BeautyRealConfig.TYPE.FACE_SHORTEN.value))
      {
        if (paramInt == BeautyRealConfig.TYPE.FACE_THIN.value) {
          this.mBeautyParam.zhailian = paramDistortParam;
        }
        for (;;)
        {
          paramDistortParam = new ArrayList();
          paramDistortParam.addAll(this.mBeautyParam.zhailian.getItems());
          paramDistortParam.addAll(this.mBeautyParam.xiaba.getItems());
          paramDistortParam.addAll(this.mBeautyParam.faceShorten.getItems());
          this.mChinThinShorten.setDistortionItems(paramDistortParam);
          break;
          if (paramInt == BeautyRealConfig.TYPE.CHIN.value) {
            this.mBeautyParam.xiaba = paramDistortParam;
          } else if (paramInt == BeautyRealConfig.TYPE.FACE_SHORTEN.value) {
            this.mBeautyParam.faceShorten = paramDistortParam;
          }
        }
      }
      if (paramInt == BeautyRealConfig.TYPE.BASIC3.value)
      {
        this.mBeautyParam.basic3 = paramDistortParam;
        paramDistortParam = new ArrayList();
        paramDistortParam.addAll(this.mBeautyParam.basic3.getItems());
        this.mBasic3.setDistortionItems(paramDistortParam);
      }
    }
  }
  
  public void setBeautyParam(BeautyParam paramBeautyParam)
  {
    if (paramBeautyParam == null) {
      return;
    }
    setBeautyParam(BeautyRealConfig.TYPE.FACE_V.value, paramBeautyParam.vlian);
    setBeautyParam(BeautyRealConfig.TYPE.EYE.value, paramBeautyParam.eye);
    setBeautyParam(BeautyRealConfig.TYPE.NOSE.value, paramBeautyParam.nose);
    setBeautyParam(BeautyRealConfig.TYPE.FACE_THIN.value, paramBeautyParam.zhailian);
    setBeautyParam(BeautyRealConfig.TYPE.CHIN.value, paramBeautyParam.xiaba);
    setBeautyParam(BeautyRealConfig.TYPE.FACE_SHORTEN.value, paramBeautyParam.faceShorten);
    setBeautyParam(BeautyRealConfig.TYPE.BASIC3.value, paramBeautyParam.basic3);
    rebuildFilterList();
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mVFaceEyeNose.setRenderMode(paramInt);
    this.mChinThinShorten.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public h updateAndRender(h paramh, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet)
  {
    if (paramList != null)
    {
      int i = 0;
      Object localObject1 = paramh;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= Math.min(paramList.size(), 5)) {
          break;
        }
        List localList = (List)paramList.get(i);
        float[] arrayOfFloat = (float[])paramList1.get(i);
        localObject2 = localObject1;
        if (this.mFilters.size() % 2 == 1)
        {
          this.mCopyFilter.RenderProcess(localObject1.texture[0], ((h)localObject1).width, ((h)localObject1).height, -1, 0.0D, this.transFrame);
          localObject2 = this.transFrame;
        }
        Iterator localIterator = this.mFilters.iterator();
        localObject1 = localObject2;
        while (localIterator.hasNext())
        {
          localObject2 = (TransformFilter)localIterator.next();
          ((TransformFilter)localObject2).updatePreview(localList, arrayOfFloat, paramMap, paramList2, paramMap1, paramSet, 0.0F, 0L);
          if (VideoMaterialUtil.needCopyTransform()) {
            localObject1 = FrameUtil.renderProcessByCopy(localObject1.texture[0], ((h)localObject1).width, ((h)localObject1).height, (VideoFilterBase)localObject2, this.mCopyFilter, paramh, this.transFrame);
          } else {
            localObject1 = FrameUtil.renderProcessBySwitchFbo(localObject1.texture[0], ((h)localObject1).width, ((h)localObject1).height, (VideoFilterBase)localObject2, paramh, this.transFrame);
          }
        }
        i += 1;
      }
    }
    Object localObject2 = paramh;
    return localObject2;
  }
  
  public void updateAndRender(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, List<List<PointF>> paramList)
  {
    h localh2 = new h(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramList != null)
    {
      int i = 0;
      h localh1 = localh2;
      while (i < Math.min(paramList.size(), 5))
      {
        Object localObject = this.mFilters.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TransformFilter localTransformFilter = (TransformFilter)((Iterator)localObject).next();
          localTransformFilter.updateParams((List)paramList.get(i), null, 1.0D);
          localh1 = FrameUtil.renderProcessBySwitchFbo(localh1.texture[0], paramInt3, paramInt4, localTransformFilter, localh2, this.transFrame);
        }
        if (localh1.texture[0] != paramInt2)
        {
          localObject = new h(paramInt1, paramInt2, paramInt3, paramInt4);
          this.mCopyFilter.RenderProcess(localh1.texture[0], paramInt3, paramInt4, paramInt2, 0.0D, (h)localObject);
        }
        i += 1;
      }
    }
  }
  
  public void updateFaceFeature(List<List<PointF>> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      List localList = (List)paramList.next();
      FaceOffUtil.getFullCoords(localList, 2.0F);
      Iterator localIterator = this.mFilters.iterator();
      while (localIterator.hasNext()) {
        ((TransformFilter)localIterator.next()).updateFaceFeatures(localList);
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mVFaceEyeNose.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mChinThinShorten.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mBasic3.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyTransformList
 * JD-Core Version:    0.7.0.1
 */