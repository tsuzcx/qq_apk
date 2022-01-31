package com.tencent.ttpic.filter;

import com.tencent.filter.m.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(82846);
    addParam(new m.b("offset1", paramFloat1, paramFloat2));
    addParam(new m.b("offset2", paramFloat3, paramFloat4));
    AppMethodBeat.o(82846);
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
    AppMethodBeat.i(82847);
    setParams(0.0F, 0.0F, 0.0F, 0.0F);
    AppMethodBeat.o(82847);
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    AppMethodBeat.i(82848);
    setParams(((Float)paramMap.get("translateXup")).floatValue(), ((Float)paramMap.get("translateYup")).floatValue(), ((Float)paramMap.get("translateXdown")).floatValue(), ((Float)paramMap.get("translateYdown")).floatValue());
    AppMethodBeat.o(82848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaOffsetAlphaBlendFilter
 * JD-Core Version:    0.7.0.1
 */