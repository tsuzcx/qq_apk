package com.tencent.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.GPUImageTwoInputHighPassFilter;
import com.tencent.ttpic.filter.SmoothBBoxFilter;
import com.tencent.ttpic.filter.SmoothBClarifyFilter;
import com.tencent.ttpic.filter.SmoothBLargeBlurFilter;
import com.tencent.ttpic.filter.SmoothBProcessFilter;
import com.tencent.ttpic.filter.SmoothBVarianceFilter;

public class PTFilter$PTSmoothBFilters
  extends PTFilter
{
  private SmoothBLargeBlurFilter mBigBlurFilter;
  private h mBigBlurFrame1;
  private SmoothBBoxFilter mBoxFilter;
  private h mBoxFrame1;
  private h mBoxFrame1_1;
  private h mBoxFrame2;
  private h mBoxFrame2_1;
  private h mBoxFrame3;
  private SmoothBClarifyFilter mClarityFilter;
  private h mClarityFrame1;
  private BaseFilter mCopyFilter;
  private GPUImageTwoInputHighPassFilter mHighPassFilter;
  private h mHighPassFrame;
  private SmoothBProcessFilter mProcessVarianceFilter;
  private SmoothBProcessFilter mProcessVarianceFilter2;
  private h mProcessVarianceFrame1;
  private SmoothBVarianceFilter mVarianceFilter;
  private SmoothBVarianceFilter mVarianceFilter2;
  private h mVarianceFrame1;
  private h mVarianceFrame1_1;
  private h outputFrame;
  
  public PTFilter$PTSmoothBFilters()
  {
    AppMethodBeat.i(80671);
    this.mClarityFilter = new SmoothBClarifyFilter();
    this.mBigBlurFilter = new SmoothBLargeBlurFilter();
    this.mVarianceFilter = new SmoothBVarianceFilter();
    this.mVarianceFilter2 = new SmoothBVarianceFilter();
    this.mBoxFilter = new SmoothBBoxFilter();
    this.mProcessVarianceFilter = new SmoothBProcessFilter();
    this.mProcessVarianceFilter2 = new SmoothBProcessFilter();
    this.mHighPassFilter = new GPUImageTwoInputHighPassFilter();
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mBoxFrame1 = new h();
    this.mBoxFrame1_1 = new h();
    this.mVarianceFrame1 = new h();
    this.mVarianceFrame1_1 = new h();
    this.mProcessVarianceFrame1 = new h();
    this.mBoxFrame2 = new h();
    this.mBoxFrame2_1 = new h();
    this.mBoxFrame3 = new h();
    this.mBigBlurFrame1 = new h();
    this.mClarityFrame1 = new h();
    this.mHighPassFrame = new h();
    this.outputFrame = new h();
    AppMethodBeat.o(80671);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(80675);
    this.mClarityFilter.ClearGLSL();
    this.mBigBlurFilter.ClearGLSL();
    this.mVarianceFilter.ClearGLSL();
    this.mVarianceFilter2.ClearGLSL();
    this.mBoxFilter.ClearGLSL();
    this.mProcessVarianceFilter.ClearGLSL();
    this.mProcessVarianceFilter2.ClearGLSL();
    this.mHighPassFilter.ClearGLSL();
    this.mCopyFilter.ClearGLSL();
    this.mBoxFrame1.clear();
    this.mBoxFrame1_1.clear();
    this.mVarianceFrame1.clear();
    this.mVarianceFrame1_1.clear();
    this.mProcessVarianceFrame1.clear();
    this.mBoxFrame2.clear();
    this.mBoxFrame2_1.clear();
    this.mBoxFrame3.clear();
    this.mBigBlurFrame1.clear();
    this.mClarityFrame1.clear();
    this.mHighPassFrame.clear();
    this.outputFrame.clear();
    super.destroy();
    AppMethodBeat.o(80675);
  }
  
  public int init()
  {
    AppMethodBeat.i(80672);
    int i = super.init();
    this.mClarityFilter.ApplyGLSLFilter();
    this.mBigBlurFilter.ApplyGLSLFilter();
    this.mVarianceFilter.ApplyGLSLFilter();
    this.mVarianceFilter2.ApplyGLSLFilter();
    this.mBoxFilter.ApplyGLSLFilter(true, 0.0F, 0.0F);
    this.mProcessVarianceFilter.ApplyGLSLFilter();
    this.mProcessVarianceFilter2.ApplyGLSLFilter();
    this.mHighPassFilter.ApplyGLSLFilter();
    this.mCopyFilter.ApplyGLSLFilter();
    AppMethodBeat.o(80672);
    return i;
  }
  
  public h process(h paramh, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80673);
    if (this.mProcessVarianceFilter.getBlurAlpha() > 0.01F)
    {
      paramInt1 = paramh.height * 360 / paramh.width;
      this.mBoxFilter.updateParam(360.0F, paramInt1);
      this.mBoxFilter.RenderProcess(paramh.texture[0], 360, paramInt1, -1, 0.0D, this.mBoxFrame1);
      this.mVarianceFilter2.setTexture2(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
      this.mVarianceFilter2.RenderProcess(paramh.texture[0], 360, paramInt1, -1, 0.0D, this.mVarianceFrame1);
      this.mBoxFilter.updateParam(360.0F, paramInt1);
      this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], 360, paramInt1, -1, 0.0D, this.mBoxFrame2);
      this.mProcessVarianceFilter2.updateTextures(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0]);
      this.mProcessVarianceFilter2.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.outputFrame);
    }
    for (;;)
    {
      paramh = this.outputFrame;
      AppMethodBeat.o(80673);
      return paramh;
      this.mCopyFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.outputFrame);
    }
  }
  
  public void updateBlurAlpha(float paramFloat)
  {
    AppMethodBeat.i(80674);
    this.mProcessVarianceFilter.updateBlurAlpha(0.8F * paramFloat);
    this.mProcessVarianceFilter2.updateBlurAlpha(0.8F * paramFloat);
    AppMethodBeat.o(80674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTSmoothBFilters
 * JD-Core Version:    0.7.0.1
 */