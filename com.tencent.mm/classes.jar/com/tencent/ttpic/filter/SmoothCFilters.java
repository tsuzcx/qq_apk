package com.tencent.ttpic.filter;

import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SmoothCFilters
{
  private SmoothCBiFilter mBilateralFilter;
  private h mBilateralFrame;
  private SmoothCProcessFilter mProcessFilter;
  
  public SmoothCFilters()
  {
    AppMethodBeat.i(82918);
    this.mBilateralFilter = new SmoothCBiFilter();
    this.mProcessFilter = new SmoothCProcessFilter();
    AppMethodBeat.o(82918);
  }
  
  public void clear()
  {
    AppMethodBeat.i(82920);
    this.mBilateralFilter.clearGLSLSelf();
    this.mProcessFilter.clearGLSLSelf();
    this.mBilateralFrame.clear();
    AppMethodBeat.o(82920);
  }
  
  public void initial()
  {
    AppMethodBeat.i(82919);
    this.mBilateralFilter.ApplyGLSLFilter();
    this.mProcessFilter.ApplyGLSLFilter();
    this.mBilateralFrame = new h();
    AppMethodBeat.o(82919);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82923);
    this.mBilateralFilter.setRenderMode(paramInt);
    this.mProcessFilter.setRenderMode(paramInt);
    AppMethodBeat.o(82923);
  }
  
  public void updateAndRender(h paramh1, h paramh2)
  {
    AppMethodBeat.i(82922);
    this.mBilateralFilter.updateSize(paramh1.width, paramh1.height);
    this.mBilateralFilter.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, this.mBilateralFrame);
    this.mProcessFilter.setTexture2(this.mBilateralFrame);
    this.mProcessFilter.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, paramh2);
    AppMethodBeat.o(82922);
  }
  
  public void updateSmoothOpacity(float paramFloat)
  {
    AppMethodBeat.i(82921);
    this.mProcessFilter.updateSmoothOpacity(paramFloat);
    AppMethodBeat.o(82921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.SmoothCFilters
 * JD-Core Version:    0.7.0.1
 */