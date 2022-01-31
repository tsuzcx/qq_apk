package com.tencent.ttpic.filter;

import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaUpDownFilter
  extends ShakaFilterBase
{
  private static final String[] PARAM_KEYS = { "translateL", "translateR" };
  
  public ShakaUpDownFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.SHAKA_UP_DOWN);
  }
  
  private void setParams(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(82853);
    addParam(new m.f("l", paramFloat1));
    addParam(new m.f("r", paramFloat2));
    AppMethodBeat.o(82853);
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
    AppMethodBeat.i(82852);
    setParams(0.0F, 0.0F);
    AppMethodBeat.o(82852);
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    AppMethodBeat.i(82854);
    setParams(((Float)paramMap.get("translateL")).floatValue(), ((Float)paramMap.get("translateR")).floatValue());
    AppMethodBeat.o(82854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaUpDownFilter
 * JD-Core Version:    0.7.0.1
 */