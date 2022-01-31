package com.tencent.ttpic.filter;

import com.tencent.filter.m.f;
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
    addParam(new m.f("l", paramFloat1));
    addParam(new m.f("r", paramFloat2));
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
    setParams(0.0F, 0.0F);
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    setParams(((Float)paramMap.get("translateL")).floatValue(), ((Float)paramMap.get("translateR")).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaUpDownFilter
 * JD-Core Version:    0.7.0.1
 */