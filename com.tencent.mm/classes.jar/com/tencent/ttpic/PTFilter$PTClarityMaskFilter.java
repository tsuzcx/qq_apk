package com.tencent.ttpic;

import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.ClarityMaskFilter;
import com.tencent.ttpic.filter.SmoothSharpenFilter;

public class PTFilter$PTClarityMaskFilter
  extends PTFilter
{
  private boolean hasApply;
  private ClarityMaskFilter mClarityMaskFilter;
  private h mClarityMaskFrame;
  private SmoothSharpenFilter mSmoothSharpenFilter;
  private h mSmoothSharpenFrame;
  
  public PTFilter$PTClarityMaskFilter()
  {
    AppMethodBeat.i(80648);
    this.mClarityMaskFilter = new ClarityMaskFilter();
    this.mSmoothSharpenFilter = new SmoothSharpenFilter();
    this.mClarityMaskFrame = new h();
    this.mSmoothSharpenFrame = new h();
    this.hasApply = false;
    AppMethodBeat.o(80648);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(80651);
    this.mClarityMaskFilter.clearGLSLSelf();
    this.mSmoothSharpenFilter.clearGLSLSelf();
    this.mClarityMaskFrame.clear();
    this.mSmoothSharpenFrame.clear();
    this.hasApply = false;
    super.destroy();
    AppMethodBeat.o(80651);
  }
  
  public int init()
  {
    AppMethodBeat.i(80649);
    int i = super.init();
    AppMethodBeat.o(80649);
    return i;
  }
  
  public h process(h paramh, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80650);
    if (!this.hasApply)
    {
      this.mClarityMaskFilter.ApplyGLSLFilter(true, paramInt1, paramInt2);
      this.mSmoothSharpenFilter.ApplyGLSLFilter(true, paramInt1, paramInt2);
      this.hasApply = true;
    }
    paramInt1 = paramh.height * 720 / paramh.width;
    this.mClarityMaskFilter.updateSize(720, paramInt1);
    this.mClarityMaskFilter.RenderProcess(paramh.texture[0], 720, paramInt1, -1, 0.0D, this.mClarityMaskFrame);
    this.mSmoothSharpenFilter.updateTexture(this.mClarityMaskFrame.texture[0]);
    this.mSmoothSharpenFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mSmoothSharpenFrame);
    paramh = this.mSmoothSharpenFrame;
    AppMethodBeat.o(80650);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTClarityMaskFilter
 * JD-Core Version:    0.7.0.1
 */