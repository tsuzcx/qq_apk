package com.tencent.ttpic.filter;

import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaFlipFilter
  extends ShakaFilterBase
{
  private static final String[] PARAM_KEYS = { "translateX", "translateY" };
  
  public ShakaFlipFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.SHAKA_FLIP);
  }
  
  private void setParams(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(82838);
    addParam(new m.f("x", paramFloat1));
    addParam(new m.f("y", paramFloat2));
    AppMethodBeat.o(82838);
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
    AppMethodBeat.i(82837);
    setParams(0.0F, 0.0F);
    AppMethodBeat.o(82837);
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    AppMethodBeat.i(82839);
    setParams(((Float)paramMap.get("translateX")).floatValue(), ((Float)paramMap.get("translateY")).floatValue());
    AppMethodBeat.o(82839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaFlipFilter
 * JD-Core Version:    0.7.0.1
 */