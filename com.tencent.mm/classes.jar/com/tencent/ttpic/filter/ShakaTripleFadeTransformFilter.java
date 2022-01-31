package com.tencent.ttpic.filter;

import com.tencent.filter.m.a;
import com.tencent.filter.m.i;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaTripleFadeTransformFilter
  extends ShakaFilterBase
{
  private static final String[] PARAM_KEYS = { "scaleUp", "scaleMid", "scaleDown", "alphaUp", "alphaMid", "alphaDown" };
  
  public ShakaTripleFadeTransformFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.SHAKA_TRIPLE_FACE_TRANSFORM);
  }
  
  private void setParams(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    addParam(new m.i("layers", paramInt));
    addParam(new m.a("scales", paramArrayOfFloat1));
    addParam(new m.a("alphaRatios", paramArrayOfFloat2));
  }
  
  protected float getDefaultParamValue()
  {
    return 1.0F;
  }
  
  protected String[] getParamKeys()
  {
    return PARAM_KEYS;
  }
  
  public void initParams()
  {
    addParam(new m.i("layers", 1));
    addParam(new m.a("scales", new float[] { 1.0F, 0.0F, 0.0F, 0.0F }));
    addParam(new m.a("alphaRatios", new float[] { 1.0F, 0.0F, 0.0F, 0.0F }));
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    float f2 = ((Float)paramMap.get("scaleUp")).floatValue();
    float f3 = ((Float)paramMap.get("scaleMid")).floatValue();
    float f4 = ((Float)paramMap.get("scaleDown")).floatValue();
    float[] arrayOfFloat = new float[3];
    arrayOfFloat[0] = ((Float)paramMap.get("alphaUp")).floatValue();
    arrayOfFloat[1] = ((Float)paramMap.get("alphaMid")).floatValue();
    arrayOfFloat[2] = ((Float)paramMap.get("alphaDown")).floatValue();
    float f1 = 0.0F;
    int i = 0;
    while (i < 3)
    {
      f1 += arrayOfFloat[i];
      i += 1;
    }
    i = 0;
    while (i < 3)
    {
      arrayOfFloat[i] /= f1;
      i += 1;
    }
    setParams(3, new float[] { f2, f3, f4 }, arrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaTripleFadeTransformFilter
 * JD-Core Version:    0.7.0.1
 */