package com.tencent.ttpic.filter;

import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GuideFilterRefine
{
  private GuideFilterRefine1 mFilter1;
  private GuideFilterRefine2 mFilter2;
  private GuideFilterRefine3 mFilter3;
  private h mFrame1;
  private h mFrame2;
  
  public GuideFilterRefine()
  {
    AppMethodBeat.i(82576);
    this.mFilter1 = new GuideFilterRefine1();
    this.mFilter2 = new GuideFilterRefine2();
    this.mFilter3 = new GuideFilterRefine3();
    this.mFrame1 = new h();
    this.mFrame2 = new h();
    AppMethodBeat.o(82576);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82577);
    this.mFilter1.ApplyGLSLFilter();
    this.mFilter2.ApplyGLSLFilter();
    this.mFilter3.ApplyGLSLFilter();
    AppMethodBeat.o(82577);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(82579);
    this.mFilter1.clearGLSLSelf();
    this.mFilter2.clearGLSLSelf();
    this.mFilter3.clearGLSLSelf();
    this.mFrame1.clear();
    this.mFrame2.clear();
    AppMethodBeat.o(82579);
  }
  
  public void updateAndRender(h paramh1, h paramh2, h paramh3)
  {
    AppMethodBeat.i(82578);
    int i = paramh1.width;
    int j = paramh1.height;
    this.mFilter1.updateParams(paramh2.texture[0], i, j);
    this.mFilter1.RenderProcess(paramh1.texture[0], i, j, -1, 0.0D, this.mFrame1);
    this.mFilter2.updateParams(i, j);
    this.mFilter2.RenderProcess(this.mFrame1.texture[0], i, j, -1, 0.0D, this.mFrame2);
    this.mFilter3.updateParams(this.mFrame2.texture[0]);
    this.mFilter3.RenderProcess(paramh1.texture[0], i, j, -1, 0.0D, paramh3);
    AppMethodBeat.o(82578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.GuideFilterRefine
 * JD-Core Version:    0.7.0.1
 */