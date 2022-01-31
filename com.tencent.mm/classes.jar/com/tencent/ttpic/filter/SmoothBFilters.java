package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.util.List;

public class SmoothBFilters
{
  private SmoothBLargeBlurFilter mBigBlurFilter;
  private SmoothBBoxFilter mBoxFilter;
  private h mBoxFrame1;
  private h mBoxFrame2;
  private SmoothBClarifyFilter mClarityFilter;
  private BaseFilter mCopyFilter;
  private GPUImageTwoInputHighPassFilter mHighPassFilter;
  private SmoothBProcessFilter mProcessVarianceFilter;
  private SmoothBVarianceFilter mVarianceFilter;
  private h mVarianceFrame1;
  
  public SmoothBFilters()
  {
    AppMethodBeat.i(82878);
    this.mClarityFilter = new SmoothBClarifyFilter();
    this.mBigBlurFilter = new SmoothBLargeBlurFilter();
    this.mVarianceFilter = new SmoothBVarianceFilter();
    this.mBoxFilter = new SmoothBBoxFilter();
    this.mProcessVarianceFilter = new SmoothBProcessFilter();
    this.mHighPassFilter = new GPUImageTwoInputHighPassFilter();
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mBoxFrame1 = new h();
    this.mVarianceFrame1 = new h();
    this.mBoxFrame2 = new h();
    AppMethodBeat.o(82878);
  }
  
  public void clear()
  {
    AppMethodBeat.i(82881);
    this.mClarityFilter.clearGLSLSelf();
    this.mBigBlurFilter.clearGLSLSelf();
    this.mVarianceFilter.clearGLSLSelf();
    this.mBoxFilter.ClearGLSL();
    this.mProcessVarianceFilter.clearGLSLSelf();
    this.mHighPassFilter.clearGLSLSelf();
    this.mCopyFilter.clearGLSLSelf();
    this.mBoxFrame1.clear();
    this.mVarianceFrame1.clear();
    this.mBoxFrame2.clear();
    AppMethodBeat.o(82881);
  }
  
  public h getVarianceFrame()
  {
    return this.mBoxFrame2;
  }
  
  public void initial()
  {
    AppMethodBeat.i(82879);
    this.mClarityFilter.ApplyGLSLFilter();
    this.mBigBlurFilter.ApplyGLSLFilter();
    this.mVarianceFilter.ApplyGLSLFilter();
    this.mBoxFilter.ApplyGLSLFilter(true, 0.0F, 0.0F);
    this.mProcessVarianceFilter.ApplyGLSLFilter();
    this.mHighPassFilter.ApplyGLSLFilter();
    this.mCopyFilter.ApplyGLSLFilter();
    AppMethodBeat.o(82879);
  }
  
  public void setOnlyDetFaceRectSkin(boolean paramBoolean) {}
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82882);
    VideoFilterUtil.setRenderMode(this.mClarityFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mBigBlurFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mVarianceFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mBoxFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mProcessVarianceFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mCopyFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mHighPassFilter, paramInt);
    AppMethodBeat.o(82882);
  }
  
  public void updateAndRender(h paramh1, h paramh2, List<List<PointF>> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82880);
    if ((this.mProcessVarianceFilter.getBlurAlpha() > 0.01F) && (paramList != null) && (paramList.size() > 0))
    {
      int j = paramh1.height * 360 / paramh1.width;
      this.mBoxFilter.updateParam(360.0F, j);
      this.mBoxFilter.RenderProcess(paramh1.texture[0], 360, j, -1, 0.0D, this.mBoxFrame1);
      this.mVarianceFilter.setPositions(GlUtil.ORIGIN_POSITION_COORDS);
      this.mVarianceFilter.setTexCords(GlUtil.ORIGIN_TEX_COORDS);
      this.mVarianceFilter.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
      FrameUtil.clearFrame(this.mVarianceFrame1, 0.0F, 1.0F, 0.0F, 1.0F, 360, j);
      this.mVarianceFilter.setInFaceRect(1);
      this.mVarianceFilter.setRotation(paramInt3);
      int i = 0;
      if (i < paramList.size())
      {
        Object localObject = AlgoUtils.getFaceRectF((List)paramList.get(i));
        float f1;
        float f2;
        if (localObject != null)
        {
          if (paramInt3 != 0) {
            break label348;
          }
          f1 = ((RectF)localObject).width();
          f2 = ((RectF)localObject).height();
          ((RectF)localObject).left -= 0.1F * f1;
          ((RectF)localObject).top -= 0.2F * f2;
          ((RectF)localObject).right = (f1 * 0.1F + ((RectF)localObject).right);
          ((RectF)localObject).bottom += f2 * 0.6F;
        }
        for (;;)
        {
          localObject = AlgoUtils.calPositions(((RectF)localObject).left, ((RectF)localObject).top, ((RectF)localObject).right, ((RectF)localObject).bottom, paramInt1, paramInt2);
          this.mVarianceFilter.setPositions((float[])localObject);
          this.mVarianceFilter.OnDrawFrameGLSL();
          this.mVarianceFilter.renderTexture(paramh1.texture[0], 360, j);
          i += 1;
          break;
          label348:
          if (paramInt3 == 90)
          {
            f1 = ((RectF)localObject).width();
            f2 = ((RectF)localObject).height();
            ((RectF)localObject).left -= 0.6F * f1;
            ((RectF)localObject).top -= 0.1F * f2;
            ((RectF)localObject).right = (f1 * 0.2F + ((RectF)localObject).right);
            ((RectF)localObject).bottom += f2 * 0.1F;
          }
          else if (paramInt3 == 180)
          {
            f1 = ((RectF)localObject).width();
            f2 = ((RectF)localObject).height();
            ((RectF)localObject).left -= 0.1F * f1;
            ((RectF)localObject).top -= 0.6F * f2;
            ((RectF)localObject).right = (f1 * 0.1F + ((RectF)localObject).right);
            ((RectF)localObject).bottom += f2 * 0.2F;
          }
          else
          {
            f1 = ((RectF)localObject).width();
            f2 = ((RectF)localObject).height();
            ((RectF)localObject).left -= 0.2F * f1;
            ((RectF)localObject).top -= 0.1F * f2;
            ((RectF)localObject).right = (f1 * 0.6F + ((RectF)localObject).right);
            ((RectF)localObject).bottom += f2 * 0.1F;
          }
        }
      }
      this.mBoxFilter.updateParam(360.0F, j);
      this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], 360, j, -1, 0.0D, this.mBoxFrame2);
      this.mProcessVarianceFilter.updateTextures(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0]);
      this.mProcessVarianceFilter.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, paramh2);
      AppMethodBeat.o(82880);
      return;
    }
    this.mCopyFilter.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, paramh2);
    AppMethodBeat.o(82880);
  }
  
  public void updateBlurAlpha(float paramFloat)
  {
    AppMethodBeat.i(82883);
    this.mProcessVarianceFilter.updateBlurAlpha(0.7F * paramFloat * 0.8F);
    AppMethodBeat.o(82883);
  }
  
  public void updateClarityAlpha(float paramFloat)
  {
    AppMethodBeat.i(82884);
    this.mClarityFilter.updateAlpha(paramFloat);
    AppMethodBeat.o(82884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.SmoothBFilters
 * JD-Core Version:    0.7.0.1
 */