package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.youtu.GestureDetector;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeautyFaceListReshape
{
  public static final String TAG;
  private BaseFilter mCopyFilter;
  private h mCopyFrame1;
  private h mCopyFrame2;
  private EyeLightenAndPounchFilterReshape mEyeLightenFilter;
  private h mEyeLightenFrame;
  private FaceFeatureFilterReshape mFaceFeatureFilter;
  private h mFaceFeatureFrame;
  private h mRemovePounchFrame;
  
  static
  {
    AppMethodBeat.i(81999);
    TAG = BeautyFaceListReshape.class.getName();
    AppMethodBeat.o(81999);
  }
  
  public BeautyFaceListReshape()
  {
    AppMethodBeat.i(81989);
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mRemovePounchFrame = new h();
    this.mEyeLightenFrame = new h();
    this.mFaceFeatureFrame = new h();
    this.mCopyFrame1 = new h();
    this.mCopyFrame2 = new h();
    this.mEyeLightenFilter = new EyeLightenAndPounchFilterReshape();
    this.mFaceFeatureFilter = new FaceFeatureFilterReshape();
    AppMethodBeat.o(81989);
  }
  
  public void clear()
  {
    AppMethodBeat.i(81997);
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
    AppMethodBeat.o(81997);
  }
  
  public void initial()
  {
    AppMethodBeat.i(81990);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.ApplyGLSLFilter();
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.ApplyGLSLFilter();
    }
    this.mCopyFilter.ApplyGLSLFilter();
    AppMethodBeat.o(81990);
  }
  
  public h render(h paramh, List<List<PointF>> paramList, List<float[]> paramList1, FaceDetector paramFaceDetector, List<PointF> paramList2, Set<Integer> paramSet, double paramDouble, int paramInt, long paramLong)
  {
    AppMethodBeat.i(81996);
    if (paramFaceDetector != null) {}
    for (Map localMap = paramFaceDetector.getFaceActionCounter();; localMap = null)
    {
      BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
      paramFaceDetector = paramh;
      int i;
      float[] arrayOfFloat;
      if (this.mFaceFeatureFilter != null)
      {
        paramFaceDetector = paramh;
        if (this.mFaceFeatureFilter.needRender())
        {
          this.mCopyFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mFaceFeatureFrame);
          i = 0;
          while (i < paramList.size())
          {
            paramFaceDetector = (List)paramList.get(i);
            arrayOfFloat = (float[])paramList1.get(i);
            paramFaceDetector = new PTDetectInfo.Builder().facePoints(paramFaceDetector).faceAngles(arrayOfFloat).faceActionCounter(localMap).handPoints(paramList2).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(paramSet).phoneAngle(paramInt).timestamp(paramLong).build();
            this.mFaceFeatureFilter.updatePreview(paramFaceDetector);
            this.mFaceFeatureFilter.OnDrawFrameGLSL();
            this.mFaceFeatureFilter.renderTexture(paramh.texture[0], paramh.width, paramh.height);
            i += 1;
          }
          paramFaceDetector = this.mFaceFeatureFrame;
        }
      }
      BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
      BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
      paramh = paramFaceDetector;
      if (this.mEyeLightenFilter != null)
      {
        paramh = paramFaceDetector;
        if (this.mEyeLightenFilter.needRender())
        {
          this.mCopyFilter.RenderProcess(paramFaceDetector.texture[0], paramFaceDetector.width, paramFaceDetector.height, -1, 0.0D, this.mEyeLightenFrame);
          i = 0;
          while (i < paramList.size())
          {
            paramh = (List)paramList.get(i);
            arrayOfFloat = (float[])paramList1.get(i);
            paramh = new PTDetectInfo.Builder().facePoints(paramh).faceAngles(arrayOfFloat).faceActionCounter(localMap).handPoints(paramList2).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(paramSet).phoneAngle(paramInt).timestamp(paramLong).build();
            this.mEyeLightenFilter.updatePreview(paramh);
            this.mEyeLightenFilter.OnDrawFrameGLSL();
            this.mEyeLightenFilter.renderTexture(paramFaceDetector.texture[0], paramFaceDetector.width, paramFaceDetector.height);
            i += 1;
          }
          paramh = this.mEyeLightenFrame;
        }
      }
      BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
      AppMethodBeat.o(81996);
      return paramh;
    }
  }
  
  public void setEyeLightenAlpha(float paramFloat)
  {
    AppMethodBeat.i(81992);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setAlphaValue(paramFloat);
    }
    AppMethodBeat.o(81992);
  }
  
  public void setFaceFeatherAlpha(float paramFloat)
  {
    AppMethodBeat.i(81994);
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.setAlphaValue(paramFloat);
    }
    AppMethodBeat.o(81994);
  }
  
  public void setPounchEnhance(float paramFloat)
  {
    AppMethodBeat.i(81993);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setPounchEnhance(paramFloat);
    }
    AppMethodBeat.o(81993);
  }
  
  public void setRemovePounchAlpha(float paramFloat)
  {
    AppMethodBeat.i(81991);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setSmoothOpacity(paramFloat);
    }
    AppMethodBeat.o(81991);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(81998);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setRenderMode(paramInt);
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.setRenderMode(paramInt);
    }
    this.mCopyFilter.setRenderMode(paramInt);
    AppMethodBeat.o(81998);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(81995);
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    AppMethodBeat.o(81995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyFaceListReshape
 * JD-Core Version:    0.7.0.1
 */