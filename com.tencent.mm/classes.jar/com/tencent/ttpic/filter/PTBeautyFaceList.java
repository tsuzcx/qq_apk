package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.youtu.GestureDetector;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTBeautyFaceList
{
  public static final String TAG;
  private BaseFilter mCopyFilter;
  private h mCopyFrame1;
  private h mCopyFrame2;
  private EyeLightenAndPounchFilter mEyeLightenFilter;
  private h mEyeLightenFrame;
  private FaceFeatureFilter mFaceFeatureFilter;
  private h mFaceFeatureFrame;
  private h mRemovePounchFrame;
  
  static
  {
    AppMethodBeat.i(82695);
    TAG = BeautyFaceList.class.getName();
    AppMethodBeat.o(82695);
  }
  
  public PTBeautyFaceList()
  {
    AppMethodBeat.i(82687);
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mRemovePounchFrame = new h();
    this.mEyeLightenFrame = new h();
    this.mFaceFeatureFrame = new h();
    this.mCopyFrame1 = new h();
    this.mCopyFrame2 = new h();
    this.mEyeLightenFilter = new EyeLightenAndPounchFilter();
    this.mFaceFeatureFilter = new FaceFeatureFilter();
    AppMethodBeat.o(82687);
  }
  
  public void clear()
  {
    AppMethodBeat.i(82693);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.clearGLSLSelf();
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.clearGLSLSelf();
    }
    this.mCopyFilter.ClearGLSL();
    this.mRemovePounchFrame.clear();
    this.mEyeLightenFrame.clear();
    this.mFaceFeatureFrame.clear();
    this.mCopyFrame1.clear();
    this.mCopyFrame2.clear();
    AppMethodBeat.o(82693);
  }
  
  public void initial()
  {
    AppMethodBeat.i(82688);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.ApplyGLSLFilter();
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.ApplyGLSLFilter();
    }
    this.mCopyFilter.ApplyGLSLFilter();
    AppMethodBeat.o(82688);
  }
  
  public h process(h paramh, PTFaceAttr paramPTFaceAttr)
  {
    AppMethodBeat.i(82692);
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    Map localMap = paramPTFaceAttr.getFaceActionCounter();
    List localList3 = paramPTFaceAttr.getHandPoints();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    int j = paramPTFaceAttr.getRotation();
    long l = paramPTFaceAttr.getTimeStamp();
    BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
    paramPTFaceAttr = paramh;
    int i;
    float[] arrayOfFloat;
    if (this.mFaceFeatureFilter != null)
    {
      this.mCopyFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mFaceFeatureFrame);
      i = 0;
      while (i < localList1.size())
      {
        paramPTFaceAttr = (List)localList1.get(i);
        arrayOfFloat = (float[])localList2.get(i);
        paramPTFaceAttr = new PTDetectInfo.Builder().facePoints(paramPTFaceAttr).faceAngles(arrayOfFloat).faceActionCounter(localMap).handPoints(localList3).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(localSet).phoneAngle(j).timestamp(l).build();
        this.mFaceFeatureFilter.updatePreview(paramPTFaceAttr);
        this.mFaceFeatureFilter.OnDrawFrameGLSL();
        this.mFaceFeatureFilter.renderTexture(paramh.texture[0], paramh.width, paramh.height);
        i += 1;
      }
      paramPTFaceAttr = this.mFaceFeatureFrame;
    }
    BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
    BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
    paramh = paramPTFaceAttr;
    if (this.mEyeLightenFilter != null)
    {
      paramh = paramPTFaceAttr;
      if (this.mEyeLightenFilter.needRender())
      {
        this.mCopyFilter.RenderProcess(paramPTFaceAttr.texture[0], paramPTFaceAttr.width, paramPTFaceAttr.height, -1, 0.0D, this.mEyeLightenFrame);
        i = 0;
        while (i < localList1.size())
        {
          paramh = (List)localList1.get(i);
          arrayOfFloat = (float[])localList2.get(i);
          paramh = new PTDetectInfo.Builder().facePoints(paramh).faceAngles(arrayOfFloat).faceActionCounter(localMap).handPoints(localList3).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(localSet).phoneAngle(j).timestamp(l).build();
          this.mEyeLightenFilter.updatePreview(paramh);
          this.mEyeLightenFilter.OnDrawFrameGLSL();
          this.mEyeLightenFilter.renderTexture(paramPTFaceAttr.texture[0], paramPTFaceAttr.width, paramPTFaceAttr.height);
          i += 1;
        }
        paramh = this.mEyeLightenFrame;
      }
    }
    BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
    AppMethodBeat.o(82692);
    return paramh;
  }
  
  public void setEyeLightenAlpha(float paramFloat)
  {
    AppMethodBeat.i(82690);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setAlphaValue(paramFloat);
    }
    AppMethodBeat.o(82690);
  }
  
  public void setFaceFeatherAlpha(float paramFloat) {}
  
  public void setPounchEnhance(float paramFloat) {}
  
  public void setRemovePounchAlpha(float paramFloat)
  {
    AppMethodBeat.i(82689);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setSmoothOpacity(paramFloat);
    }
    AppMethodBeat.o(82689);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82694);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setRenderMode(paramInt);
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.setRenderMode(paramInt);
    }
    this.mCopyFilter.setRenderMode(paramInt);
    AppMethodBeat.o(82694);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(82691);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    AppMethodBeat.o(82691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.PTBeautyFaceList
 * JD-Core Version:    0.7.0.1
 */