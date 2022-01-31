package com.tencent.ttpic.filter;

import com.tencent.filter.m.b;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaOffsetAlphaBlendFilter
  extends ShakaFilterBase
{
  private static final String[] PARAM_KEYS = { "translateXup", "translateYup", "translateXdown", "translateYdown" };
  
  public ShakaOffsetAlphaBlendFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.SHAKA_OFFSET_ALPHA_BLEND);
  }
  
  private void setParams(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    addParam(new m.b("offset1", paramFloat1, paramFloat2));
    addParam(new m.b("offset2", paramFloat3, paramFloat4));
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
    setParams(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    setParams(((Float)paramMap.get("translateXup")).floatValue(), ((Float)paramMap.get("translateYup")).floatValue(), ((Float)paramMap.get("translateXdown")).floatValue(), ((Float)paramMap.get("translateYdown")).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaOffsetAlphaBlendFilter
 * JD-Core Version:    0.7.0.1
 */