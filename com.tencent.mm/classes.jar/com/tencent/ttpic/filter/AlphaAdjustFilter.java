package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;

public class AlphaAdjustFilter
  extends BaseFilter
{
  private static String FRAGMENT = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float filterAdjustParam;\n void main()\n {\n     vec4 c2 = texture2D(inputImageTexture2, textureCoordinate.xy);\n     vec4 c1 = texture2D(inputImageTexture, textureCoordinate.xy);\n     gl_FragColor = mix(c1,c2,filterAdjustParam);\n}\n";
  private float adjust = 0.2F;
  
  public AlphaAdjustFilter()
  {
    super(FRAGMENT);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new m.n("inputImageTexture2", 0, 33986));
    addParam(new m.f("filterAdjustParam", this.adjust));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setAdjustParam(float paramFloat)
  {
    this.adjust = paramFloat;
    addParam(new m.f("filterAdjustParam", this.adjust));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.AlphaAdjustFilter
 * JD-Core Version:    0.7.0.1
 */