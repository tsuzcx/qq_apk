package com.tencent.ttpic.filter;

import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.BenchUtil;

public class ClarityFilters
{
  public static final String PERF_LOG = "[ClarityFilters]";
  private float mClarityAlpha;
  private ClarityMaskFilter mClarityMaskFilter2;
  
  public ClarityFilters()
  {
    AppMethodBeat.i(82103);
    this.mClarityMaskFilter2 = new ClarityMaskFilter();
    this.mClarityAlpha = 0.0F;
    AppMethodBeat.o(82103);
  }
  
  public void clear()
  {
    AppMethodBeat.i(82106);
    this.mClarityMaskFilter2.clearGLSLSelf();
    AppMethodBeat.o(82106);
  }
  
  public void initial(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82104);
    this.mClarityMaskFilter2.ApplyGLSLFilter(false, paramInt1, paramInt2);
    AppMethodBeat.o(82104);
  }
  
  public void setClarityAlpha(float paramFloat)
  {
    AppMethodBeat.i(82108);
    this.mClarityAlpha = paramFloat;
    this.mClarityMaskFilter2.updateFactor(paramFloat);
    this.mClarityMaskFilter2.updateFactor(paramFloat);
    AppMethodBeat.o(82108);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82107);
    this.mClarityMaskFilter2.setRenderMode(paramInt);
    AppMethodBeat.o(82107);
  }
  
  public h updateAndRender(h paramh1, h paramh2)
  {
    AppMethodBeat.i(82105);
    if (this.mClarityAlpha < 0.01F)
    {
      AppMethodBeat.o(82105);
      return paramh1;
    }
    int i = paramh1.height * 720 / paramh1.width;
    int j;
    if (paramh1.width > paramh1.height)
    {
      j = paramh1.width * 720 / paramh1.height;
      i = 720;
    }
    for (;;)
    {
      BenchUtil.benchStart("[ClarityFilters]mClarityMaskFilter");
      this.mClarityMaskFilter2.updateSize(j, i);
      this.mClarityMaskFilter2.RenderProcess(paramh1.texture[0], paramh1.width, paramh1.height, -1, 0.0D, paramh2);
      BenchUtil.benchEnd("[ClarityFilters]mClarityMaskFilter");
      AppMethodBeat.o(82105);
      return paramh2;
      j = 720;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.ClarityFilters
 * JD-Core Version:    0.7.0.1
 */