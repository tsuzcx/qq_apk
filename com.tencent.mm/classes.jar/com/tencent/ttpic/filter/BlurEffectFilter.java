package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.a.s;
import com.tencent.filter.a.t;
import com.tencent.filter.h;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BlurEffectFilter
  extends BaseFilter
{
  private s mBlendFilter;
  private h mBlendFrame;
  private t mBlurFilter;
  private h mBlurFrame1;
  private h mBlurFrame2;
  private double mStrength;
  
  public BlurEffectFilter()
  {
    super(GLSLRender.btg);
    AppMethodBeat.i(82044);
    this.mBlurFilter = new t();
    this.mBlendFilter = new s();
    this.mBlurFrame1 = new h();
    this.mBlurFrame2 = new h();
    this.mBlendFrame = new h();
    AppMethodBeat.o(82044);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(82045);
    this.mBlurFilter.ApplyGLSLFilter();
    this.mBlendFilter.ApplyGLSLFilter();
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(82045);
  }
  
  public void ClearGLSL()
  {
    AppMethodBeat.i(82046);
    this.mBlurFilter.clearGLSLSelf();
    this.mBlendFilter.clearGLSLSelf();
    this.mBlurFrame1.clear();
    this.mBlurFrame2.clear();
    this.mBlendFrame.clear();
    super.ClearGLSL();
    AppMethodBeat.o(82046);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82048);
    super.beforeRender(paramInt1, paramInt2, paramInt3);
    if ((paramInt2 <= 0) || (paramInt3 <= 0))
    {
      AppMethodBeat.o(82048);
      return;
    }
    int i = paramInt3 * 400 / paramInt2;
    this.mBlurFilter.y(0.0025F, 0.0F);
    this.mBlurFilter.RenderProcess(paramInt1, 400, i, -1, 0.0D, this.mBlurFrame1);
    this.mBlurFilter.y(0.0F, 1.0F / i);
    this.mBlurFilter.RenderProcess(this.mBlurFrame1.texture[0], 400, i, -1, 0.0D, this.mBlurFrame2);
    this.mBlendFilter.addParam(new m.n("inputImageTexture2", paramInt1, 33986));
    this.mBlendFilter.RenderProcess(this.mBlurFrame2.texture[0], paramInt2, paramInt3, -1, 0.0D, this.mBlendFrame);
    AppMethodBeat.o(82048);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(82047);
    this.mBlurFilter.clearGLSLSelf();
    this.mBlendFilter.clearGLSLSelf();
    this.mBlurFrame1.clear();
    this.mBlurFrame2.clear();
    this.mBlendFrame.clear();
    super.clearGLSLSelf();
    AppMethodBeat.o(82047);
  }
  
  public double getStrength()
  {
    return this.mStrength;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82049);
    if (this.mBlendFrame.texture[0] > 0)
    {
      bool = super.renderTexture(this.mBlendFrame.texture[0], paramInt2, paramInt3);
      AppMethodBeat.o(82049);
      return bool;
    }
    boolean bool = super.renderTexture(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(82049);
    return bool;
  }
  
  public void updateFilterBlurStrength(double paramDouble)
  {
    AppMethodBeat.i(82050);
    this.mStrength = paramDouble;
    this.mBlendFilter.addParam(new m.f("alpha", (float)paramDouble));
    AppMethodBeat.o(82050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.BlurEffectFilter
 * JD-Core Version:    0.7.0.1
 */