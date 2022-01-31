package com.tencent.ttpic.filter;

import com.tencent.filter.h;

public class GuideFilterRefine
{
  private GuideFilterRefine1 mFilter1 = new GuideFilterRefine1();
  private GuideFilterRefine2 mFilter2 = new GuideFilterRefine2();
  private GuideFilterRefine3 mFilter3 = new GuideFilterRefine3();
  private h mFrame1 = new h();
  private h mFrame2 = new h();
  
  public void ApplyGLSLFilter()
  {
    this.mFilter1.ApplyGLSLFilter();
    this.mFilter2.ApplyGLSLFilter();
    this.mFilter3.ApplyGLSLFilter();
  }
  
  public void clearGLSLSelf()
  {
    this.mFilter1.clearGLSLSelf();
    this.mFilter2.clearGLSLSelf();
    this.mFilter3.clearGLSLSelf();
    this.mFrame1.clear();
    this.mFrame2.clear();
  }
  
  public void updateAndRender(h paramh1, h paramh2, h paramh3)
  {
    int i = paramh1.width;
    int j = paramh1.height;
    this.mFilter1.updateParams(paramh2.texture[0], i, j);
    this.mFilter1.RenderProcess(paramh1.texture[0], i, j, -1, 0.0D, this.mFrame1);
    this.mFilter2.updateParams(i, j);
    this.mFilter2.RenderProcess(this.mFrame1.texture[0], i, j, -1, 0.0D, this.mFrame2);
    this.mFilter3.updateParams(this.mFrame2.texture[0]);
    this.mFilter3.RenderProcess(paramh1.texture[0], i, j, -1, 0.0D, paramh3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.GuideFilterRefine
 * JD-Core Version:    0.7.0.1
 */