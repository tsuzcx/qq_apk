package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.BenchUtil;
import java.util.List;

public class BeautyFaceList_573
{
  public static final String TAG;
  private BaseFilter mCopyFilter;
  private h mCopyFrame1;
  private h mCopyFrame2;
  private EyeLightenAndPounchFilter_573 mEyeLightenFilter;
  private h mEyeLightenFrame;
  private FaceFeatureFilter_573 mFaceFeatureFilter;
  private h mFaceFeatureFrame;
  private LightRemovePouchFilter_573 mLightRemovePouchFilter;
  private h mLightRemovePouchFrame;
  private h mRemovePounchFrame;
  private float superSmooth;
  
  static
  {
    AppMethodBeat.i(82012);
    TAG = BeautyFaceList.class.getName();
    AppMethodBeat.o(82012);
  }
  
  public BeautyFaceList_573()
  {
    AppMethodBeat.i(82000);
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mRemovePounchFrame = new h();
    this.mEyeLightenFrame = new h();
    this.mFaceFeatureFrame = new h();
    this.mLightRemovePouchFrame = new h();
    this.mCopyFrame1 = new h();
    this.mCopyFrame2 = new h();
    this.superSmooth = 0.25F;
    this.mEyeLightenFilter = new EyeLightenAndPounchFilter_573();
    this.mFaceFeatureFilter = new FaceFeatureFilter_573();
    this.mLightRemovePouchFilter = new LightRemovePouchFilter_573();
    AppMethodBeat.o(82000);
  }
  
  public void clear()
  {
    AppMethodBeat.i(82008);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.clearGLSLSelf();
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.clearGLSLSelf();
    }
    if (this.mLightRemovePouchFilter != null) {
      this.mLightRemovePouchFilter.clearGLSLSelf();
    }
    this.mCopyFilter.ClearGLSL();
    this.mRemovePounchFrame.clear();
    this.mEyeLightenFrame.clear();
    this.mFaceFeatureFrame.clear();
    this.mLightRemovePouchFrame.clear();
    this.mCopyFrame1.clear();
    this.mCopyFrame2.clear();
    AppMethodBeat.o(82008);
  }
  
  public void initial()
  {
    AppMethodBeat.i(82001);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.ApplyGLSLFilter();
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.ApplyGLSLFilter();
    }
    if (this.mLightRemovePouchFilter != null) {
      this.mLightRemovePouchFilter.ApplyGLSLFilter();
    }
    this.mCopyFilter.ApplyGLSLFilter();
    AppMethodBeat.o(82001);
  }
  
  public h render(h paramh, List<List<PointF>> paramList)
  {
    AppMethodBeat.i(82007);
    BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
    Object localObject = paramh;
    int i;
    if (this.mFaceFeatureFilter != null)
    {
      localObject = paramh;
      if (this.mFaceFeatureFilter.needRender())
      {
        this.mCopyFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mFaceFeatureFrame);
        i = 0;
        while (i < paramList.size())
        {
          localObject = (List)paramList.get(i);
          this.mFaceFeatureFilter.updateParam((List)localObject);
          this.mFaceFeatureFilter.OnDrawFrameGLSL();
          this.mFaceFeatureFilter.renderTexture(paramh.texture[0], paramh.width, paramh.height);
          i += 1;
        }
        localObject = this.mFaceFeatureFrame;
      }
    }
    BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
    paramh = (h)localObject;
    if (this.mLightRemovePouchFilter != null)
    {
      paramh = (h)localObject;
      if (this.mLightRemovePouchFilter.needRender())
      {
        this.mCopyFilter.RenderProcess(localObject.texture[0], ((h)localObject).width, ((h)localObject).height, -1, 0.0D, this.mLightRemovePouchFrame);
        i = 0;
        while (i < paramList.size())
        {
          paramh = (List)paramList.get(i);
          this.mLightRemovePouchFilter.updateParam(paramh);
          this.mLightRemovePouchFilter.OnDrawFrameGLSL();
          this.mLightRemovePouchFilter.renderTexture(localObject.texture[0], ((h)localObject).width, ((h)localObject).height);
          i += 1;
        }
        paramh = this.mLightRemovePouchFrame;
      }
    }
    BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
    localObject = paramh;
    if (this.mEyeLightenFilter != null)
    {
      localObject = paramh;
      if (this.mEyeLightenFilter.needRender())
      {
        this.mCopyFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mEyeLightenFrame);
        i = 0;
        while (i < paramList.size())
        {
          localObject = (List)paramList.get(i);
          this.mEyeLightenFilter.updateParam((List)localObject);
          this.mEyeLightenFilter.OnDrawFrameGLSL();
          this.mEyeLightenFilter.renderTexture(paramh.texture[0], paramh.width, paramh.height);
          i += 1;
        }
        localObject = this.mEyeLightenFrame;
      }
    }
    BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
    AppMethodBeat.o(82007);
    return localObject;
  }
  
  public void setContrastOpacity(float paramFloat)
  {
    AppMethodBeat.i(82005);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setContrastOpacity(paramFloat);
    }
    AppMethodBeat.o(82005);
  }
  
  public void setEyeLightenAlpha(float paramFloat)
  {
    AppMethodBeat.i(82003);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setAlphaValue(paramFloat);
    }
    AppMethodBeat.o(82003);
  }
  
  public void setFaceFeatureParam(FaceFeatureParam paramFaceFeatureParam)
  {
    AppMethodBeat.i(82004);
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.setFaceFeatureParam(paramFaceFeatureParam);
    }
    AppMethodBeat.o(82004);
  }
  
  public void setNormalAlphaFactor(float paramFloat)
  {
    AppMethodBeat.i(82011);
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.setNormalAlphaFactor(paramFloat);
    }
    AppMethodBeat.o(82011);
  }
  
  public void setRemovePounchAlpha(float paramFloat)
  {
    AppMethodBeat.i(82002);
    if (this.mLightRemovePouchFilter != null) {
      this.mLightRemovePouchFilter.setSmoothOpacity(paramFloat);
    }
    if (this.mEyeLightenFilter != null) {
      if (paramFloat >= this.superSmooth) {
        break label60;
      }
    }
    label60:
    for (paramFloat = 0.0F;; paramFloat = 1.0F / (1.0F - this.superSmooth) * (paramFloat - this.superSmooth))
    {
      this.mEyeLightenFilter.setSmoothOpacity(Math.max(0.0F, Math.min(1.0F, paramFloat)));
      AppMethodBeat.o(82002);
      return;
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82009);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setRenderMode(paramInt);
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.setRenderMode(paramInt);
    }
    if (this.mLightRemovePouchFilter != null) {
      this.mLightRemovePouchFilter.setRenderMode(paramInt);
    }
    this.mCopyFilter.setRenderMode(paramInt);
    AppMethodBeat.o(82009);
  }
  
  public void setToothWhitenAlpha(float paramFloat)
  {
    AppMethodBeat.i(82010);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setToothWhitenAlpha(paramFloat);
    }
    AppMethodBeat.o(82010);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(82006);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mLightRemovePouchFilter != null) {
      this.mLightRemovePouchFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    AppMethodBeat.o(82006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyFaceList_573
 * JD-Core Version:    0.7.0.1
 */