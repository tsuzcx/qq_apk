package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.ttpic.config.SimpleBeautyRealConfig.TYPE;
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

public class SimpleBeautyTransformList
{
  private static final int MAX_TRANSFORMED_FACES = 5;
  private BaseFilter mCopyFilter;
  private SimpleBeautyParam mSimpleBeautyParam;
  private TransformFilter mSimplyBeauty;
  private h transFrame = new h();
  
  public SimpleBeautyTransformList()
  {
    BenchUtil.benchStart("[onSurfaceCreated] create SimpleBeautyParam");
    this.mSimpleBeautyParam = new SimpleBeautyParam(false);
    BenchUtil.benchEnd("[onSurfaceCreated] create SimpleBeautyParam");
    this.mSimplyBeauty = new TransformFilter(null, null);
    this.mCopyFilter = new BaseFilter(GLSLRender.bcE);
  }
  
  public void clear()
  {
    this.transFrame.clear();
    this.mSimplyBeauty.clearGLSLSelf();
    this.mCopyFilter.ClearGLSL();
  }
  
  public SimpleBeautyParam getBeautyParam()
  {
    return this.mSimpleBeautyParam;
  }
  
  public void initial()
  {
    BenchUtil.benchStart("[onSurfaceCreated] create Beauty Transform Filters");
    this.mSimplyBeauty.ApplyGLSLFilter();
    this.mCopyFilter.ApplyGLSLFilter();
    BenchUtil.benchEnd("[onSurfaceCreated] create Beauty Transform Filters");
  }
  
  public h process(h paramh, int paramInt, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, double paramDouble)
  {
    updateVideoSize(paramh.width, paramh.height, paramDouble);
    return updateAndRender(paramh, paramInt, paramList, paramList1, paramMap, paramList2, paramMap1, paramSet);
  }
  
  public void setBeautyParam(int paramInt, DistortParam paramDistortParam)
  {
    if (paramDistortParam == null) {
      return;
    }
    if (paramInt == SimpleBeautyRealConfig.TYPE.EYE.value) {
      this.mSimpleBeautyParam.eye = paramDistortParam;
    }
    for (;;)
    {
      paramDistortParam = new ArrayList();
      paramDistortParam.addAll(this.mSimpleBeautyParam.vlian.getItems());
      paramDistortParam.addAll(this.mSimpleBeautyParam.eye.getItems());
      paramDistortParam.addAll(this.mSimpleBeautyParam.nose.getItems());
      paramDistortParam.addAll(this.mSimpleBeautyParam.zhailian.getItems());
      paramDistortParam.addAll(this.mSimpleBeautyParam.xiaba.getItems());
      paramDistortParam.addAll(this.mSimpleBeautyParam.faceShorten.getItems());
      this.mSimplyBeauty.setDistortionItems(paramDistortParam);
      this.transFrame.clear();
      return;
      if (paramInt == SimpleBeautyRealConfig.TYPE.FACE_THIN.value) {
        this.mSimpleBeautyParam.zhailian = paramDistortParam;
      } else if (paramInt == SimpleBeautyRealConfig.TYPE.CHIN.value) {
        this.mSimpleBeautyParam.xiaba = paramDistortParam;
      }
    }
  }
  
  public void setBeautyParam(SimpleBeautyParam paramSimpleBeautyParam)
  {
    if (paramSimpleBeautyParam == null) {
      return;
    }
    setBeautyParam(SimpleBeautyRealConfig.TYPE.EYE.value, paramSimpleBeautyParam.eye);
    setBeautyParam(SimpleBeautyRealConfig.TYPE.FACE_THIN.value, paramSimpleBeautyParam.zhailian);
    setBeautyParam(SimpleBeautyRealConfig.TYPE.CHIN.value, paramSimpleBeautyParam.xiaba);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mSimplyBeauty.setRenderMode(paramInt);
  }
  
  public h updateAndRender(h paramh, int paramInt, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet)
  {
    this.transFrame.a(paramInt, paramh.width, paramh.height, 0.0D);
    if (paramList != null)
    {
      int i = 0;
      h localh = paramh;
      paramInt = 0;
      if (i < Math.min(paramList.size(), 5))
      {
        List localList = (List)paramList.get(i);
        float[] arrayOfFloat = (float[])paramList1.get(i);
        this.mSimplyBeauty.updatePreview(localList, arrayOfFloat, paramMap, paramList2, paramMap1, paramSet, 0.0F, 0L);
        if (VideoMaterialUtil.needCopyTransform()) {}
        for (localh = FrameUtil.renderProcessByCopy(localh.texture[0], localh.width, localh.height, this.mSimplyBeauty, this.mCopyFilter, paramh, this.transFrame);; localh = FrameUtil.renderProcessBySwitchFbo(localh.texture[0], localh.width, localh.height, this.mSimplyBeauty, paramh, this.transFrame))
        {
          paramInt = 1;
          i += 1;
          break;
        }
      }
    }
    else
    {
      paramInt = 0;
    }
    if (paramInt == 0) {
      this.mCopyFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.transFrame);
    }
    return this.transFrame;
  }
  
  public void updateAndRender(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, List<List<PointF>> paramList)
  {
    h localh2 = new h(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramList != null)
    {
      paramInt1 = 0;
      h localh1 = localh2;
      while (paramInt1 < Math.min(paramList.size(), 5))
      {
        this.mSimplyBeauty.updateParams((List)paramList.get(paramInt1), null, 1.0D);
        localh1 = FrameUtil.renderProcessBySwitchFbo(localh1.texture[0], paramInt3, paramInt4, this.mSimplyBeauty, localh2, this.transFrame);
        paramInt1 += 1;
      }
    }
  }
  
  public void updateFaceFeature(List<List<PointF>> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = (List)paramList.next();
        FaceOffUtil.getFullCoords(localList, 2.0F);
        this.mSimplyBeauty.updateFaceFeatures(localList);
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mSimplyBeauty.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.SimpleBeautyTransformList
 * JD-Core Version:    0.7.0.1
 */