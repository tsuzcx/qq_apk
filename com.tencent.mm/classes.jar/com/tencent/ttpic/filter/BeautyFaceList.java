package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class BeautyFaceList
{
  public static final String TAG;
  private float[] faceVertices;
  private int height;
  private ContrastFilter mContrastFilter;
  private h mContrastFrame;
  private BaseFilter mCopyFilter;
  private h mCopyFrame1;
  private h mCopyFrame2;
  private EyeLightenAndPounchFilter mEyeLightenFilter;
  private h[] mEyeLightenFrame;
  private double mFaceDetScale;
  private FaceFeatureFilter mFaceFeatureFilter;
  private h[] mFaceFeatureFrame;
  private LightRemovePouchFilter mLightRemovePouchFilter;
  private h[] mLightRemovePouchFrame;
  private h mRemovePounchFrame;
  private int width;
  
  static
  {
    AppMethodBeat.i(81988);
    TAG = BeautyFaceList.class.getName();
    AppMethodBeat.o(81988);
  }
  
  public BeautyFaceList()
  {
    AppMethodBeat.i(81974);
    this.mContrastFilter = new ContrastFilter();
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mRemovePounchFrame = new h();
    this.mContrastFrame = new h();
    this.mEyeLightenFrame = new h[2];
    this.mFaceFeatureFrame = new h[2];
    this.mLightRemovePouchFrame = new h[2];
    this.mCopyFrame1 = new h();
    this.mCopyFrame2 = new h();
    this.faceVertices = new float[1380];
    this.mEyeLightenFilter = new EyeLightenAndPounchFilter();
    this.mFaceFeatureFilter = new FaceFeatureFilter();
    this.mLightRemovePouchFilter = new LightRemovePouchFilter();
    int i = 0;
    while (i < this.mEyeLightenFrame.length)
    {
      this.mEyeLightenFrame[i] = new h();
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.mFaceFeatureFrame.length) {
        break;
      }
      this.mFaceFeatureFrame[i] = new h();
      i += 1;
    }
    while (j < this.mLightRemovePouchFrame.length)
    {
      this.mLightRemovePouchFrame[j] = new h();
      j += 1;
    }
    AppMethodBeat.o(81974);
  }
  
  public void clear()
  {
    int j = 0;
    AppMethodBeat.i(81982);
    this.mEyeLightenFilter.clearGLSLSelf();
    this.mFaceFeatureFilter.clearGLSLSelf();
    this.mLightRemovePouchFilter.clearGLSLSelf();
    this.mContrastFilter.ClearGLSL();
    this.mRemovePounchFrame.clear();
    h[] arrayOfh = this.mEyeLightenFrame;
    int k = arrayOfh.length;
    int i = 0;
    h localh;
    while (i < k)
    {
      localh = arrayOfh[i];
      if (localh != null) {
        localh.clear();
      }
      i += 1;
    }
    arrayOfh = this.mFaceFeatureFrame;
    k = arrayOfh.length;
    i = 0;
    while (i < k)
    {
      localh = arrayOfh[i];
      if (localh != null) {
        localh.clear();
      }
      i += 1;
    }
    arrayOfh = this.mLightRemovePouchFrame;
    k = arrayOfh.length;
    i = j;
    while (i < k)
    {
      localh = arrayOfh[i];
      if (localh != null) {
        localh.clear();
      }
      i += 1;
    }
    this.mCopyFrame1.clear();
    this.mCopyFrame2.clear();
    this.mContrastFrame.clear();
    AppMethodBeat.o(81982);
  }
  
  public void initial()
  {
    AppMethodBeat.i(81975);
    this.mEyeLightenFilter.ApplyGLSLFilter();
    this.mFaceFeatureFilter.ApplyGLSLFilter();
    this.mLightRemovePouchFilter.ApplyGLSLFilter();
    this.mContrastFilter.ApplyGLSLFilter();
    this.mCopyFilter.ApplyGLSLFilter();
    AppMethodBeat.o(81975);
  }
  
  public h render(h paramh, List<List<PointF>> paramList)
  {
    AppMethodBeat.i(81981);
    int j = 0;
    int i = 0;
    if (j < paramList.size())
    {
      List localList = VideoMaterialUtil.copyList((List)paramList.get(j));
      FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(localList, 2.0F), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices);
      BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
      Object localObject = paramh;
      int n;
      if (this.mFaceFeatureFilter.needRender())
      {
        localObject = this.mCopyFilter;
        k = paramh.texture[0];
        m = paramh.width;
        n = paramh.height;
        arrayOfh = this.mFaceFeatureFrame;
        ((BaseFilter)localObject).RenderProcess(k, m, n, -1, 0.0D, arrayOfh[(j % arrayOfh.length)]);
        this.mFaceFeatureFilter.updateParam(this.faceVertices);
        this.mFaceFeatureFilter.OnDrawFrameGLSL();
        this.mFaceFeatureFilter.renderTexture(paramh.texture[0], paramh.width, paramh.height);
        paramh = this.mFaceFeatureFrame;
        localObject = paramh[(j % paramh.length)];
      }
      BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
      paramh = (h)localObject;
      if (this.mLightRemovePouchFilter.needRender())
      {
        paramh = this.mCopyFilter;
        k = localObject.texture[0];
        m = ((h)localObject).width;
        n = ((h)localObject).height;
        arrayOfh = this.mLightRemovePouchFrame;
        paramh.RenderProcess(k, m, n, -1, 0.0D, arrayOfh[(j % arrayOfh.length)]);
        this.mLightRemovePouchFilter.updateParam(this.faceVertices);
        this.mLightRemovePouchFilter.OnDrawFrameGLSL();
        this.mLightRemovePouchFilter.renderTexture(localObject.texture[0], ((h)localObject).width, ((h)localObject).height);
        paramh = this.mLightRemovePouchFrame;
        paramh = paramh[(j % paramh.length)];
      }
      BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
      if (!this.mEyeLightenFilter.needRender()) {
        break label525;
      }
      localObject = this.mContrastFilter;
      i = paramh.texture[0];
      int k = paramh.width;
      int m = paramh.height;
      h[] arrayOfh = this.mEyeLightenFrame;
      ((ContrastFilter)localObject).RenderProcess(i, k, m, -1, 0.0D, arrayOfh[(j % arrayOfh.length)]);
      this.mEyeLightenFilter.updateParam(localList, this.faceVertices);
      this.mEyeLightenFilter.OnDrawFrameGLSL();
      this.mEyeLightenFilter.renderTexture(paramh.texture[0], paramh.width, paramh.height);
      paramh = this.mEyeLightenFrame;
      paramh = paramh[(j % paramh.length)];
      i = 1;
    }
    label525:
    for (;;)
    {
      BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
      j += 1;
      break;
      paramList = paramh;
      if (i == 0)
      {
        paramList = paramh;
        if (this.mContrastFilter.needRender())
        {
          this.mContrastFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mContrastFrame);
          paramList = this.mContrastFrame;
        }
      }
      AppMethodBeat.o(81981);
      return paramList;
    }
  }
  
  public void setContrastLevel(int paramInt)
  {
    AppMethodBeat.i(81987);
    this.mContrastFilter.setContrastLevel(paramInt);
    this.mEyeLightenFilter.setContrastLevel(paramInt);
    AppMethodBeat.o(81987);
  }
  
  public void setEyeLightenAlpha(float paramFloat)
  {
    AppMethodBeat.i(81978);
    this.mEyeLightenFilter.setAlphaValue(paramFloat);
    AppMethodBeat.o(81978);
  }
  
  public void setFaceFeatureParam(FaceFeatureParam paramFaceFeatureParam)
  {
    AppMethodBeat.i(81979);
    this.mFaceFeatureFilter.setFaceFeatureParam(paramFaceFeatureParam);
    AppMethodBeat.o(81979);
  }
  
  public void setLightRemovePouchAlpha(float paramFloat)
  {
    AppMethodBeat.i(81977);
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat / 0.9F));
    this.mLightRemovePouchFilter.setSmoothOpacity(paramFloat);
    AppMethodBeat.o(81977);
  }
  
  public void setLightRemovePouchSkinTexture(int paramInt)
  {
    AppMethodBeat.i(81986);
    this.mLightRemovePouchFilter.setSkinTexture(paramInt);
    AppMethodBeat.o(81986);
  }
  
  public void setNormalAlphaFactor(float paramFloat)
  {
    AppMethodBeat.i(81985);
    this.mFaceFeatureFilter.setNormalAlphaFactor(paramFloat);
    AppMethodBeat.o(81985);
  }
  
  public void setRemovePounchAlpha(float paramFloat)
  {
    AppMethodBeat.i(81976);
    this.mEyeLightenFilter.setSmoothOpacity(paramFloat);
    AppMethodBeat.o(81976);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(81983);
    this.mEyeLightenFilter.setRenderMode(paramInt);
    this.mFaceFeatureFilter.setRenderMode(paramInt);
    this.mLightRemovePouchFilter.setRenderMode(paramInt);
    this.mContrastFilter.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
    AppMethodBeat.o(81983);
  }
  
  public void setToothWhitenAlpha(float paramFloat)
  {
    AppMethodBeat.i(81984);
    this.mEyeLightenFilter.setToothWhitenAlpha(paramFloat);
    AppMethodBeat.o(81984);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(81980);
    this.mEyeLightenFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mFaceFeatureFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mLightRemovePouchFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.width = paramInt1;
    this.height = paramInt2;
    this.mFaceDetScale = paramDouble;
    AppMethodBeat.o(81980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyFaceList
 * JD-Core Version:    0.7.0.1
 */