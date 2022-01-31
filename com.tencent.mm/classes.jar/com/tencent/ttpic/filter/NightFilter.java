package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NightFilter
  extends BaseFilter
{
  private static final String TAG;
  private NightRGBStretchImpFilter adjustFilter = null;
  float strenth = 0.5F;
  
  static
  {
    AppMethodBeat.i(82677);
    TAG = NightFilter.class.getSimpleName();
    AppMethodBeat.o(82677);
  }
  
  public NightFilter()
  {
    super(GLSLRender.btg);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(82675);
    this.glsl_programID = GLSLRender.btg;
    this.adjustFilter = new NightRGBStretchImpFilter();
    this.adjustFilter.addParam(new m.f("param", this.strenth));
    if (this.strenth >= 0.5F) {
      this.adjustFilter.addParam(new m.f("scale", 2.0F));
    }
    for (;;)
    {
      setNextFilter(this.adjustFilter, new int[] { this.srcTextureIndex + 1 });
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(82675);
      return;
      this.adjustFilter.addParam(new m.f("scale", 1.0F));
    }
  }
  
  public void ClearGLSL()
  {
    AppMethodBeat.i(82676);
    this.adjustFilter = null;
    super.ClearGLSL();
    AppMethodBeat.o(82676);
  }
  
  public boolean isAdjustFilter()
  {
    return true;
  }
  
  public void setAdjustParam(float paramFloat)
  {
    AppMethodBeat.i(82674);
    this.strenth = paramFloat;
    if (this.adjustFilter != null) {
      this.adjustFilter.addParam(new m.f("param", this.strenth));
    }
    AppMethodBeat.o(82674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.NightFilter
 * JD-Core Version:    0.7.0.1
 */