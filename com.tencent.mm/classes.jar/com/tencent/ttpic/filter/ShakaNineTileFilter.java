package com.tencent.ttpic.filter;

import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaNineTileFilter
  extends ShakaFilterBase
{
  private static final String[] PARAM_KEYS = { "xMin", "xMax", "yMin", "yMax" };
  
  public ShakaNineTileFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.SHAKA_NINE_TILE);
  }
  
  private void setParams(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(82844);
    addParam(new m.f("x_min", paramFloat1));
    addParam(new m.f("x_max", paramFloat2));
    addParam(new m.f("y_min", paramFloat3));
    addParam(new m.f("y_max", paramFloat4));
    AppMethodBeat.o(82844);
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
    AppMethodBeat.i(82843);
    setParams(0.0F, 0.0F, 0.0F, 0.0F);
    AppMethodBeat.o(82843);
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    AppMethodBeat.i(82845);
    setParams(((Float)paramMap.get("xMin")).floatValue(), ((Float)paramMap.get("xMax")).floatValue(), ((Float)paramMap.get("yMin")).floatValue(), ((Float)paramMap.get("yMax")).floatValue());
    AppMethodBeat.o(82845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaNineTileFilter
 * JD-Core Version:    0.7.0.1
 */