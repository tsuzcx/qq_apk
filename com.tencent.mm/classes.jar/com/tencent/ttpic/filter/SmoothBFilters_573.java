package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SmoothBFilters_573
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
  private SmoothBProcessFilter_573 mProcessVarianceFilter;
  private h mProcessVarianceFrame1;
  private SmoothBVarianceFilter_573 mVarianceFilter;
  private h mVarianceFrame1;
  private h mVarianceFrame1_1;
  
  public SmoothBFilters_573()
  {
    AppMethodBeat.i(82885);
    this.mClarityFilter = new SmoothBClarifyFilter();
    this.mBigBlurFilter = new SmoothBLargeBlurFilter();
    this.mVarianceFilter = new SmoothBVarianceFilter_573();
    this.mProcessVarianceFilter = new SmoothBProcessFilter_573();
    this.mBoxFilter = new SmoothBBoxFilter();
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
    AppMethodBeat.o(82885);
  }
  
  public void clear()
  {
    AppMethodBeat.i(82889);
    this.mClarityFilter.clearGLSLSelf();
    this.mBigBlurFilter.clearGLSLSelf();
    this.mVarianceFilter.clearGLSLSelf();
    this.mBoxFilter.ClearGLSL();
    this.mProcessVarianceFilter.clearGLSLSelf();
    this.mHighPassFilter.clearGLSLSelf();
    this.mCopyFilter.clearGLSLSelf();
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
    AppMethodBeat.o(82889);
  }
  
  public void initial()
  {
    AppMethodBeat.i(82886);
    this.mClarityFilter.ApplyGLSLFilter();
    this.mBigBlurFilter.ApplyGLSLFilter();
    this.mVarianceFilter.ApplyGLSLFilter();
    this.mBoxFilter.ApplyGLSLFilter(true, 0.0F, 0.0F);
    this.mProcessVarianceFilter.ApplyGLSLFilter();
    this.mHighPassFilter.ApplyGLSLFilter();
    this.mCopyFilter.ApplyGLSLFilter();
    AppMethodBeat.o(82886);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82890);
    this.mClarityFilter.setRenderMode(paramInt);
    this.mBigBlurFilter.setRenderMode(paramInt);
    this.mVarianceFilter.setRenderMode(paramInt);
    this.mBoxFilter.setRenderMode(paramInt);
    this.mProcessVarianceFilter.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
    this.mHighPassFilter.setRenderMode(paramInt);
    AppMethodBeat.o(82890);
  }
  
  public void updateAndRender(h paramh1, h paramh2)
  {
    AppMethodBeat.i(82887);
    if (this.mProcessVarianceFilter.getBlurAlpha() > 0.01F)
    {
      int i = paramh1.height * 360 / paramh1.width;
      this.mBoxFilter.updateParam(360.0F, i);
      this.mBoxFilter.RenderProcess(paramh1.texture[0], 360, i, -1, 0.0D, this.mBoxFrame1);
      this.mVarianceFilter.setTexture2(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
      this.mVarianceFilter.RenderProcess(paramh1.texture[0], 360, i, -1, 0.0D, this.mVarianceFrame1);
      this.mBoxFilter.updateParam(360.0F, i);
      this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], 360, i, -1, 0.0D, this.mBoxFrame2);
      this.mProcessVarianceFilter.updateTextures(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0]);
      this.mProcessVarianceFilter.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, paramh2);
      AppMethodBeat.o(82887);
      return;
    }
    this.mCopyFilter.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, paramh2);
    AppMethodBeat.o(82887);
  }
  
  public void updateAndRenderHighQuality(h paramh1, h paramh2)
  {
    AppMethodBeat.i(82888);
    if (this.mProcessVarianceFilter.getBlurAlpha() > 0.01F)
    {
      int i = paramh1.height * 360 / paramh1.width;
      int j = paramh1.height * 720 / paramh1.width;
      this.mBoxFilter.updateParam(360.0F, i);
      this.mBoxFilter.RenderProcess(paramh1.texture[0], 360, i, -1, 0.0D, this.mBoxFrame1);
      this.mVarianceFilter.setTexture2(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
      this.mVarianceFilter.RenderProcess(paramh1.texture[0], 360, i, -1, 0.0D, this.mVarianceFrame1);
      this.mBoxFilter.updateParam(360.0F, i);
      this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], 360, i, -1, 0.0D, this.mBoxFrame2);
      this.mBoxFilter.updateParam(720.0F, j);
      this.mBoxFilter.RenderProcess(paramh1.texture[0], 720, j, -1, 0.0D, this.mBoxFrame1_1);
      this.mVarianceFilter.setTexture2(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame1_1).texture[0]);
      this.mVarianceFilter.RenderProcess(paramh1.texture[0], 720, j, -1, 0.0D, this.mVarianceFrame1_1);
      this.mBoxFilter.updateParam(720.0F, j);
      this.mBoxFilter.RenderProcess(this.mVarianceFrame1_1.texture[0], 720, j, -1, 0.0D, this.mBoxFrame2_1);
      this.mHighPassFilter.updateTexture(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame2_1).texture[0]);
      this.mHighPassFilter.RenderProcess(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0], 720, j, -1, 0.0D, this.mHighPassFrame);
      this.mProcessVarianceFilter.updateTextures(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mHighPassFrame).texture[0]);
      this.mProcessVarianceFilter.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, this.mProcessVarianceFrame1);
      this.mBoxFilter.updateParam(360.0F, i);
      this.mBoxFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], 360, i, -1, 0.0D, this.mBoxFrame3);
      this.mBigBlurFilter.updateParam(360.0F, i);
      this.mBigBlurFilter.RenderProcess(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame3).texture[0], 360, i, -1, 0.0D, this.mBigBlurFrame1);
      this.mClarityFilter.updateTexture(this.mBigBlurFrame1.texture[0]);
      this.mClarityFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, paramh2);
      AppMethodBeat.o(82888);
      return;
    }
    this.mCopyFilter.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, paramh2);
    AppMethodBeat.o(82888);
  }
  
  public void updateBlurAlpha(float paramFloat)
  {
    AppMethodBeat.i(82891);
    this.mProcessVarianceFilter.updateBlurAlpha(0.8F * paramFloat);
    AppMethodBeat.o(82891);
  }
  
  public void updateClarityAlpha(float paramFloat)
  {
    AppMethodBeat.i(82892);
    this.mClarityFilter.updateAlpha(paramFloat);
    AppMethodBeat.o(82892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.SmoothBFilters_573
 * JD-Core Version:    0.7.0.1
 */