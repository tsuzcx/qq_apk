package com.tencent.ttpic.filter;

import com.tencent.filter.m.f;
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
    addParam(new m.f("adjust", paramFloat));
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
    setParams(1.0F);
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    setParams(((Float)paramMap.get("adjust")).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.HorizontalSkewFilter
 * JD-Core Version:    0.7.0.1
 */