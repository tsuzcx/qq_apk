package com.tencent.ttpic.filter;

import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class HorizontalSkewFilter
  extends ShakaFilterBase
{
  private static final String[] PARAM_KEYS = { "adjust" };
  
  public HorizontalSkewFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.SHAKA_HORIZONTAL_SKEW);
  }
  
  private void setParams(float paramFloat)
  {
    AppMethodBeat.i(82606);
    addParam(new m.f("adjust", paramFloat));
    AppMethodBeat.o(82606);
  }
  
  protected float getDefaultParamValue()
  {
    return 0.0F;
  }
  
  protected String[] getParamKeys()
  {
    return PARAM_KEYS;
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82605);
    setParams(1.0F);
    AppMethodBeat.o(82605);
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    AppMethodBeat.i(82607);
    setParams(((Float)paramMap.get("adjust")).floatValue());
    AppMethodBeat.o(82607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.filter.HorizontalSkewFilter
 * JD-Core Version:    0.7.0.1
 */