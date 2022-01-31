package com.tencent.ttpic.filter;

import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PTSmoothBFilters
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
  private GPUImageTwoInputHighPassFilter mHighPassFilter;
  private h mHighPassFrame;
  private h mOutFrame;
  private SmoothBProcessFilter mProcessVarianceFilter;
  private h mProcessVarianceFrame1;
  private SmoothBVarianceFilter mVarianceFilter;
  private h mVarianceFrame1;
  private h mVarianceFrame1_1;
  
  public PTSmoothBFilters()
  {
    AppMethodBeat.i(82711);
    this.mClarityFilter = new SmoothBClarifyFilter();
    this.mBigBlurFilter = new SmoothBLargeBlurFilter();
    this.mVarianceFilter = new SmoothBVarianceFilter();
    this.mBoxFilter = new SmoothBBoxFilter();
    this.mProcessVarianceFilter = new SmoothBProcessFilter();
    this.mHighPassFilter = new GPUImageTwoInputHighPassFilter();
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
    this.mOutFrame = new h();
    AppMethodBeat.o(82711);
  }
  
  private h updateAndRenderHighQuality(h paramh)
  {
    AppMethodBeat.i(82714);
    if (this.mProcessVarianceFilter.getBlurAlpha() <= 0.01F)
    {
      AppMethodBeat.o(82714);
      return paramh;
    }
    int i = paramh.height * 360 / paramh.width;
    int j = paramh.height * 720 / paramh.width;
    this.mBoxFilter.updateParam(360.0F, i);
    this.mBoxFilter.RenderProcess(paramh.texture[0], 360, i, -1, 0.0D, this.mBoxFrame1);
    this.mVarianceFilter.setTexture2(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
    this.mVarianceFilter.RenderProcess(paramh.texture[0], 360, i, -1, 0.0D, this.mVarianceFrame1);
    this.mBoxFilter.updateParam(360.0F, i);
    this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], 360, i, -1, 0.0D, this.mBoxFrame2);
    this.mBoxFilter.updateParam(720.0F, j);
    this.mBoxFilter.RenderProcess(paramh.texture[0], 720, j, -1, 0.0D, this.mBoxFrame1_1);
    this.mVarianceFilter.setTexture2(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame1_1).texture[0]);
    this.mVarianceFilter.RenderProcess(paramh.texture[0], 720, j, -1, 0.0D, this.mVarianceFrame1_1);
    this.mBoxFilter.updateParam(720.0F, j);
    this.mBoxFilter.RenderProcess(this.mVarianceFrame1_1.texture[0], 720, j, -1, 0.0D, this.mBoxFrame2_1);
    this.mHighPassFilter.updateTexture(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame2_1).texture[0]);
    this.mHighPassFilter.RenderProcess(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0], 720, j, -1, 0.0D, this.mHighPassFrame);
    this.mProcessVarianceFilter.updateTextures(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mHighPassFrame).texture[0]);
    this.mProcessVarianceFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mProcessVarianceFrame1);
    this.mBoxFilter.updateParam(360.0F, i);
    this.mBoxFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], 360, i, -1, 0.0D, this.mBoxFrame3);
    this.mBigBlurFilter.updateParam(360.0F, i);
    this.mBigBlurFilter.RenderProcess(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame3).texture[0], 360, i, -1, 0.0D, this.mBigBlurFrame1);
    this.mClarityFilter.updateTexture(this.mBigBlurFrame1.texture[0]);
    this.mClarityFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mOutFrame);
    paramh = this.mOutFrame;
    AppMethodBeat.o(82714);
    return paramh;
  }
  
  public void clear()
  {
    AppMethodBeat.i(82716);
    this.mClarityFilter.clearGLSLSelf();
    this.mBigBlurFilter.clearGLSLSelf();
    this.mVarianceFilter.clearGLSLSelf();
    this.mBoxFilter.ClearGLSL();
    this.mProcessVarianceFilter.clearGLSLSelf();
    this.mHighPassFilter.clearGLSLSelf();
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
    this.mOutFrame.clear();
    AppMethodBeat.o(82716);
  }
  
  public void initial()
  {
    AppMethodBeat.i(82712);
    this.mClarityFilter.ApplyGLSLFilter();
    this.mBigBlurFilter.ApplyGLSLFilter();
    this.mVarianceFilter.ApplyGLSLFilter();
    this.mBoxFilter.ApplyGLSLFilter(true, 0.0F, 0.0F);
    this.mProcessVarianceFilter.ApplyGLSLFilter();
    this.mHighPassFilter.ApplyGLSLFilter();
    AppMethodBeat.o(82712);
  }
  
  public h process(h paramh)
  {
    AppMethodBeat.i(82715);
    paramh = updateAndRenderHighQuality(paramh);
    AppMethodBeat.o(82715);
    return paramh;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82717);
    this.mClarityFilter.setRenderMode(paramInt);
    this.mBigBlurFilter.setRenderMode(paramInt);
    this.mVarianceFilter.setRenderMode(paramInt);
    this.mBoxFilter.setRenderMode(paramInt);
    this.mProcessVarianceFilter.setRenderMode(paramInt);
    this.mHighPassFilter.setRenderMode(paramInt);
    AppMethodBeat.o(82717);
  }
  
  public h updateAndRender(h paramh)
  {
    AppMethodBeat.i(82713);
    if (this.mProcessVarianceFilter.getBlurAlpha() <= 0.01F)
    {
      AppMethodBeat.o(82713);
      return paramh;
    }
    int i = paramh.height * 360 / paramh.width;
    this.mBoxFilter.updateParam(360.0F, i);
    this.mBoxFilter.RenderProcess(paramh.texture[0], 360, i, -1, 0.0D, this.mBoxFrame1);
    this.mVarianceFilter.setTexture2(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
    this.mVarianceFilter.RenderProcess(paramh.texture[0], 360, i, -1, 0.0D, this.mVarianceFrame1);
    this.mBoxFilter.updateParam(360.0F, i);
    this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], 360, i, -1, 0.0D, this.mBoxFrame2);
    this.mProcessVarianceFilter.updateTextures(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0]);
    this.mProcessVarianceFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mProcessVarianceFrame1);
    this.mBoxFilter.updateParam(360.0F, i);
    this.mBoxFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], 360, i, -1, 0.0D, this.mBoxFrame3);
    this.mBigBlurFilter.updateParam(360.0F, i);
    this.mBigBlurFilter.RenderProcess(com.tencent.ttpic.util.FrameUtil.getLastRenderFrame(this.mBoxFrame3).texture[0], 360, i, -1, 0.0D, this.mBigBlurFrame1);
    this.mClarityFilter.updateTexture(this.mBigBlurFrame1.texture[0]);
    this.mClarityFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mOutFrame);
    paramh = this.mOutFrame;
    AppMethodBeat.o(82713);
    return paramh;
  }
  
  public void updateBlurAlpha(float paramFloat)
  {
    AppMethodBeat.i(82718);
    this.mProcessVarianceFilter.updateBlurAlpha(paramFloat);
    AppMethodBeat.o(82718);
  }
  
  public void updateClarityAlpha(float paramFloat)
  {
    AppMethodBeat.i(82719);
    this.mClarityFilter.updateAlpha(paramFloat);
    AppMethodBeat.o(82719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.PTSmoothBFilters
 * JD-Core Version:    0.7.0.1
 */