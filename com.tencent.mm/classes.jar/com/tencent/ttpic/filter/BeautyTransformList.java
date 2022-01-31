package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.model.DistortParam;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoFrameUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BeautyTransformList
{
  private static int FACE_CACHE_LEN = 10;
  private static final int MAX_TRANSFORMED_FACES = 5;
  private final int MAX_COUNT;
  private int frameIndex;
  private TransformFilter mBasic3;
  private BeautyParam mBeautyParam;
  private TransformFilter mChinThinShorten;
  private BaseFilter mCopyFilter;
  private List<TransformFilter> mFilters;
  private TransformFilter mVFaceEyeNose;
  private List<BeautyTransformList.FaceInfoOfPeople> peopleList;
  private h[] transFrame;
  
  public BeautyTransformList()
  {
    AppMethodBeat.i(82025);
    this.mBasic3 = null;
    this.transFrame = new h[2];
    this.peopleList = new LinkedList();
    this.MAX_COUNT = 6;
    BenchUtil.benchStart("[onSurfaceCreated] create BeautyParam");
    this.mBeautyParam = new BeautyParam(false);
    BenchUtil.benchEnd("[onSurfaceCreated] create BeautyParam");
    this.mVFaceEyeNose = new TransformFilter(new ArrayList(), null);
    this.mChinThinShorten = new TransformFilter(new ArrayList(), null);
    this.mBasic3 = new TransformFilter(new ArrayList(), null);
    this.mFilters = new ArrayList();
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    while (i < this.transFrame.length)
    {
      this.transFrame[i] = new h();
      i += 1;
    }
    AppMethodBeat.o(82025);
  }
  
  private int chooseBestDataIndex(List<List<PointF>> paramList, List<float[]> paramList1)
  {
    AppMethodBeat.i(82034);
    paramList.size();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      if (sameShape((List)paramList.get(0), (List)paramList.get(i), (float[])paramList1.get(0), (float[])paramList1.get(i)))
      {
        AppMethodBeat.o(82034);
        return i;
      }
      i -= 1;
    }
    AppMethodBeat.o(82034);
    return 0;
  }
  
  private void clearTransFrame()
  {
    AppMethodBeat.i(82030);
    int i = 0;
    while (i < this.transFrame.length)
    {
      this.transFrame[i].clear();
      i += 1;
    }
    AppMethodBeat.o(82030);
  }
  
  private BeautyTransformList.FaceInfoOfFrame getFaceInfo()
  {
    AppMethodBeat.i(82035);
    Object localObject = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.peopleList.iterator();
    while (localIterator.hasNext())
    {
      BeautyTransformList.FaceInfoOfPeople localFaceInfoOfPeople = (BeautyTransformList.FaceInfoOfPeople)localIterator.next();
      ((List)localObject).add(localFaceInfoOfPeople.faces.getLast());
      localArrayList1.add(localFaceInfoOfPeople.facesAngles.getLast());
      localArrayList2.add(Integer.valueOf(localFaceInfoOfPeople.count));
    }
    localObject = new BeautyTransformList.FaceInfoOfFrame(this, (List)localObject, localArrayList1, localArrayList2);
    AppMethodBeat.o(82035);
    return localObject;
  }
  
  private float my_smoothstep(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    paramFloat1 = (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
    if (paramFloat1 < 0.0F) {
      paramFloat1 = f2;
    }
    for (;;)
    {
      if (paramFloat1 > 1.0F) {
        paramFloat1 = f1;
      }
      for (;;)
      {
        return (3.0F - paramFloat1 * 2.0F) * (paramFloat1 * paramFloat1);
      }
    }
  }
  
  private void rebuildFilterList()
  {
    AppMethodBeat.i(82029);
    this.mFilters.clear();
    if ((this.mBeautyParam.vlian.getLevel() != 0) || (this.mBeautyParam.eye.getLevel() != 0) || (this.mBeautyParam.nose.getLevel() != 0)) {
      this.mFilters.add(this.mVFaceEyeNose);
    }
    if ((this.mBeautyParam.zhailian.getLevel() != 0) || (this.mBeautyParam.xiaba.getLevel() != 0) || (this.mBeautyParam.faceShorten.getLevel() != 0)) {
      this.mFilters.add(this.mChinThinShorten);
    }
    if (BeautyParam.MESH_SET == 0) {
      if (this.mBeautyParam.basic573.getLevel() != 0) {
        this.mFilters.add(this.mBasic3);
      }
    }
    for (;;)
    {
      clearTransFrame();
      AppMethodBeat.o(82029);
      return;
      if (this.mBeautyParam.basic4.getLevel() != 0) {
        this.mFilters.add(this.mBasic3);
      }
    }
  }
  
  private boolean samePeople(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(82032);
    float f1 = ((PointF)paramList1.get(0)).x;
    f1 = (((PointF)paramList1.get(18)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList1.get(0)).y;
    PointF localPointF1 = new PointF(f1, (((PointF)paramList1.get(18)).y + f2) / 2.0F);
    f1 = ((PointF)paramList2.get(0)).x;
    f1 = (((PointF)paramList2.get(18)).x + f1) / 2.0F;
    f2 = ((PointF)paramList2.get(0)).y;
    PointF localPointF2 = new PointF(f1, (((PointF)paramList2.get(18)).y + f2) / 2.0F);
    f1 = Math.min(AlgoUtils.getDistance((PointF)paramList1.get(0), (PointF)paramList1.get(18)), AlgoUtils.getDistance((PointF)paramList2.get(0), (PointF)paramList2.get(18)));
    if (AlgoUtils.getDistance(localPointF1, localPointF2) < f1 * 0.5F)
    {
      AppMethodBeat.o(82032);
      return true;
    }
    AppMethodBeat.o(82032);
    return false;
  }
  
  private boolean sameShape(List<PointF> paramList1, List<PointF> paramList2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(82036);
    float f2 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat1[1] * 1.2D));
    float f3 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat1[0] * 1.1D));
    float f1 = (float)(AlgoUtils.getDistance((PointF)paramList1.get(0), (PointF)paramList1.get(18)) / Math.cos(f2));
    f2 = (float)(AlgoUtils.getDistance((PointF)paramList1.get(44), (PointF)paramList1.get(54)) / Math.cos(f2));
    float f4 = ((PointF)paramList1.get(44)).x;
    f4 = (((PointF)paramList1.get(54)).x + f4) / 2.0F;
    float f5 = ((PointF)paramList1.get(44)).y;
    f3 = (float)(AlgoUtils.getDistance(new PointF(f4, (((PointF)paramList1.get(54)).y + f5) / 2.0F), (PointF)paramList1.get(9)) / Math.cos(f3));
    float f6 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat2[1] * 1.2D));
    f5 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat2[0] * 1.1D));
    f4 = (float)(AlgoUtils.getDistance((PointF)paramList2.get(0), (PointF)paramList2.get(18)) / Math.cos(f6));
    f6 = (float)(AlgoUtils.getDistance((PointF)paramList2.get(44), (PointF)paramList2.get(54)) / Math.cos(f6));
    float f7 = ((PointF)paramList2.get(44)).x;
    f7 = (((PointF)paramList2.get(54)).x + f7) / 2.0F;
    float f8 = ((PointF)paramList2.get(44)).y;
    f5 = (float)(AlgoUtils.getDistance(new PointF(f7, (((PointF)paramList2.get(54)).y + f8) / 2.0F), (PointF)paramList2.get(9)) / Math.cos(f5));
    f2 = Math.abs(f2 / f1 - f6 / f4);
    if (Math.abs(f3 / f1 - f5 / f4) + f2 < 0.1D)
    {
      AppMethodBeat.o(82036);
      return true;
    }
    AppMethodBeat.o(82036);
    return false;
  }
  
  private void updatePeopleList(List<List<PointF>> paramList, List<float[]> paramList1)
  {
    AppMethodBeat.i(82033);
    if (BaseUtils.isEmpty(paramList))
    {
      AppMethodBeat.o(82033);
      return;
    }
    int i = 0;
    List localList;
    Object localObject;
    if (i < paramList.size())
    {
      localList = (List)paramList.get(i);
      localObject = this.peopleList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        BeautyTransformList.FaceInfoOfPeople localFaceInfoOfPeople = (BeautyTransformList.FaceInfoOfPeople)((Iterator)localObject).next();
        if (samePeople(localList, (List)localFaceInfoOfPeople.faces.getLast()))
        {
          if (localFaceInfoOfPeople.count > 0)
          {
            localFaceInfoOfPeople.faces.clear();
            localFaceInfoOfPeople.facesAngles.clear();
          }
          localFaceInfoOfPeople.faces.add(localList);
          if (localFaceInfoOfPeople.faces.size() > FACE_CACHE_LEN) {
            localFaceInfoOfPeople.faces.removeFirst();
          }
          localFaceInfoOfPeople.facesAngles.add(paramList1.get(i));
          if (localFaceInfoOfPeople.facesAngles.size() > FACE_CACHE_LEN) {
            localFaceInfoOfPeople.facesAngles.removeFirst();
          }
          localFaceInfoOfPeople.count = -1;
        }
      }
    }
    for (int j = 0;; j = 1)
    {
      if (j != 0)
      {
        localObject = new BeautyTransformList.FaceInfoOfPeople(this);
        ((BeautyTransformList.FaceInfoOfPeople)localObject).faces.add(localList);
        ((BeautyTransformList.FaceInfoOfPeople)localObject).facesAngles.add(paramList1.get(i));
        this.peopleList.add(localObject);
      }
      i += 1;
      break;
      paramList = this.peopleList.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (BeautyTransformList.FaceInfoOfPeople)paramList.next();
        paramList1.count += 1;
        if (paramList1.count > 0) {
          if (paramList1.count >= 6)
          {
            paramList.remove();
          }
          else
          {
            i = chooseBestDataIndex(paramList1.faces, paramList1.facesAngles);
            localList = (List)paramList1.faces.get(i);
            localObject = (float[])paramList1.facesAngles.get(i);
            paramList1.faces.clear();
            paramList1.facesAngles.clear();
            paramList1.faces.add(localList);
            paramList1.facesAngles.add(localObject);
          }
        }
      }
      AppMethodBeat.o(82033);
      return;
    }
  }
  
  public void clear()
  {
    AppMethodBeat.i(82039);
    clearTransFrame();
    this.mVFaceEyeNose.clearGLSLSelf();
    this.mChinThinShorten.clearGLSLSelf();
    this.mBasic3.clearGLSLSelf();
    this.mCopyFilter.ClearGLSL();
    AppMethodBeat.o(82039);
  }
  
  public BeautyParam getBeautyParam()
  {
    return this.mBeautyParam;
  }
  
  public void initial()
  {
    AppMethodBeat.i(82026);
    BenchUtil.benchStart("[onSurfaceCreated] create Beauty Transform Filters");
    this.mVFaceEyeNose.ApplyGLSLFilter();
    this.mChinThinShorten.ApplyGLSLFilter();
    this.mBasic3.ApplyGLSLFilter();
    BenchUtil.benchEnd("[onSurfaceCreated] create Beauty Transform Filters");
    BenchUtil.benchStart("[onSurfaceCreated] create Beauty mCopyFilter");
    this.mCopyFilter.ApplyGLSLFilter();
    BenchUtil.benchEnd("[onSurfaceCreated] create Beauty mCopyFilter");
    AppMethodBeat.o(82026);
  }
  
  public boolean needFaceInfo()
  {
    AppMethodBeat.i(82041);
    if (this.mFilters.size() != 0)
    {
      AppMethodBeat.o(82041);
      return true;
    }
    AppMethodBeat.o(82041);
    return false;
  }
  
  public h process(h paramh, List<List<PointF>> paramList, double paramDouble, List<float[]> paramList1, float paramFloat)
  {
    AppMethodBeat.i(82031);
    updateVideoSize(paramh.width, paramh.height, paramDouble);
    paramh = updateAndRender(paramh, paramList, paramList1, paramFloat);
    AppMethodBeat.o(82031);
    return paramh;
  }
  
  public void setBeautyParam(int paramInt, DistortParam paramDistortParam)
  {
    AppMethodBeat.i(82028);
    if (paramDistortParam == null)
    {
      AppMethodBeat.o(82028);
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
      AppMethodBeat.o(82028);
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
      if (paramInt == BeautyRealConfig.TYPE.BASIC3.value) {
        if (BeautyParam.MESH_SET == 0)
        {
          this.mBeautyParam.basic573 = paramDistortParam;
          paramDistortParam = new ArrayList();
          paramDistortParam.addAll(this.mBeautyParam.basic573.getItems());
          this.mBasic3.setDistortionItems(paramDistortParam);
        }
        else
        {
          this.mBeautyParam.basic4 = paramDistortParam;
          paramDistortParam = new ArrayList();
          paramDistortParam.addAll(this.mBeautyParam.basic4.getItems());
          this.mBasic3.setDistortionItems(paramDistortParam);
        }
      }
    }
  }
  
  public void setBeautyParam(BeautyParam paramBeautyParam)
  {
    AppMethodBeat.i(82027);
    if (paramBeautyParam == null)
    {
      AppMethodBeat.o(82027);
      return;
    }
    setBeautyParam(BeautyRealConfig.TYPE.FACE_V.value, paramBeautyParam.vlian);
    setBeautyParam(BeautyRealConfig.TYPE.EYE.value, paramBeautyParam.eye);
    setBeautyParam(BeautyRealConfig.TYPE.NOSE.value, paramBeautyParam.nose);
    setBeautyParam(BeautyRealConfig.TYPE.FACE_THIN.value, paramBeautyParam.zhailian);
    setBeautyParam(BeautyRealConfig.TYPE.CHIN.value, paramBeautyParam.xiaba);
    setBeautyParam(BeautyRealConfig.TYPE.FACE_SHORTEN.value, paramBeautyParam.faceShorten);
    if (BeautyParam.MESH_SET == 0) {
      setBeautyParam(BeautyRealConfig.TYPE.BASIC3.value, paramBeautyParam.basic573);
    }
    for (;;)
    {
      rebuildFilterList();
      AppMethodBeat.o(82027);
      return;
      setBeautyParam(BeautyRealConfig.TYPE.BASIC3.value, paramBeautyParam.basic4);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82042);
    this.mVFaceEyeNose.setRenderMode(paramInt);
    this.mChinThinShorten.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
    AppMethodBeat.o(82042);
  }
  
  public h updateAndRender(h paramh, List<List<PointF>> paramList, List<float[]> paramList1, float paramFloat)
  {
    AppMethodBeat.i(82037);
    updatePeopleList(paramList, paramList1);
    paramList = getFaceInfo();
    List localList1 = paramList.faces;
    List localList2 = paramList.facesAngles;
    List localList3 = paramList.countList;
    this.frameIndex = ((this.frameIndex + 1) % 2);
    if (!BaseUtils.isEmpty(localList1))
    {
      int i = 0;
      paramList = paramh;
      for (;;)
      {
        paramList1 = paramList;
        if (i >= Math.min(localList1.size(), 5)) {
          break;
        }
        paramList1 = (List)localList1.get(i);
        float[] arrayOfFloat = (float[])localList2.get(i);
        Iterator localIterator = this.mFilters.iterator();
        if (localIterator.hasNext())
        {
          TransformFilter localTransformFilter = (TransformFilter)localIterator.next();
          BenchUtil.benchStart("[BeautyTransformList] updatePreview");
          localTransformFilter.updateStrength(1.0F - my_smoothstep(0.4F, 1.0F, ((Integer)localList3.get(i)).intValue() / 6.0F));
          localTransformFilter.updatePreview(new PTDetectInfo.Builder().facePoints(paramList1).faceAngles(arrayOfFloat).phoneAngle(paramFloat).build());
          BenchUtil.benchEnd("[BeautyTransformList] updatePreview");
          BenchUtil.benchStart("[BeautyTransformList] renderProcessBySwitchFbo");
          if (VideoMaterialUtil.needCopyTransform()) {}
          for (paramList = VideoFrameUtil.renderProcessByCopy(paramList.texture[0], paramList.width, paramList.height, localTransformFilter, this.mCopyFilter, paramh, this.transFrame[this.frameIndex]);; paramList = VideoFrameUtil.renderProcessBySwitchFbo(paramList.texture[0], paramList.width, paramList.height, localTransformFilter, paramh, this.transFrame[this.frameIndex]))
          {
            BenchUtil.benchEnd("[BeautyTransformList] renderProcessBySwitchFbo");
            break;
          }
        }
        i += 1;
      }
    }
    paramList1 = paramh;
    AppMethodBeat.o(82037);
    return paramList1;
  }
  
  public void updateAndRender(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, List<List<PointF>> paramList)
  {
    AppMethodBeat.i(82038);
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
          localTransformFilter.updateParams((List)paramList.get(i), null, 1.0D, new float[] { 0.0F, 0.0F, 0.0F });
          localh1 = VideoFrameUtil.renderProcessBySwitchFbo(localh1.texture[0], paramInt3, paramInt4, localTransformFilter, localh2, this.transFrame[0]);
        }
        if (localh1.texture[0] != paramInt2)
        {
          localObject = new h(paramInt1, paramInt2, paramInt3, paramInt4);
          this.mCopyFilter.RenderProcess(localh1.texture[0], paramInt3, paramInt4, paramInt2, 0.0D, (h)localObject);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(82038);
  }
  
  public void updateFaceFeature(List<List<PointF>> paramList)
  {
    AppMethodBeat.i(82043);
    if (paramList == null)
    {
      AppMethodBeat.o(82043);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      List localList = (List)paramList.next();
      BenchUtil.benchStart("[BeautyTransformList] getFullCoords");
      FaceOffUtil.getFullCoords(localList, 2.0F);
      BenchUtil.benchEnd("[BeautyTransformList] getFullCoords");
      BenchUtil.benchStart("[BeautyTransformList] updateFaceFeature");
      Iterator localIterator = this.mFilters.iterator();
      while (localIterator.hasNext()) {
        ((TransformFilter)localIterator.next()).updateFaceFeatures(localList);
      }
      BenchUtil.benchEnd("[BeautyTransformList] updateFaceFeature");
    }
    AppMethodBeat.o(82043);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(82040);
    this.mVFaceEyeNose.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mChinThinShorten.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mBasic3.updateVideoSize(paramInt1, paramInt2, paramDouble);
    AppMethodBeat.o(82040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyTransformList
 * JD-Core Version:    0.7.0.1
 */