package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.a.ae;
import com.tencent.filter.m.f;
import java.util.Map;

public class GPUImageUnsharpMaskFilter
  extends BaseFilter
{
  private static String SHARP_FRAGMENT = " precision highp float;\n varying vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; \n \n uniform float intensity;\n \n void main()\n {\n     vec4 sharpImageColor = texture2D(inputImageTexture2, textureCoordinate);\n     vec3 blurredImageColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n     \n     gl_FragColor = vec4(sharpImageColor.rgb * intensity + blurredImageColor * (1.0 - intensity), sharpImageColor.a);\n }";
  private float blurRadius = 2.0F;
  private BaseFilter horizontal = null;
  private float intensity = 1.365F;
  private BaseFilter unsharpMask = null;
  private BaseFilter vertical = null;
  
  public GPUImageUnsharpMaskFilter()
  {
    super(GLSLRender.bcE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    int i = 0;
    float f = Math.round(this.blurRadius);
    if (f >= 1.0F)
    {
      i = (int)Math.floor(Math.sqrt(-2.0D * Math.pow(f, 2.0D) * Math.log(0.00390625D * Math.sqrt(6.283185307179586D * Math.pow(f, 2.0D)))));
      i += i % 2;
    }
    this.horizontal = new BaseFilter(ae.b(i, f, true));
    this.vertical = new BaseFilter(ae.b(i, f, false));
    setNextFilter(this.horizontal, null);
    this.horizontal.setNextFilter(this.vertical, null);
    this.unsharpMask = new BaseFilter(SHARP_FRAGMENT);
    this.unsharpMask.addParam(new m.f("intensity", this.intensity));
    this.vertical.setNextFilter(this.unsharpMask, new int[] { 0 });
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("blurRadius")) {
      this.blurRadius = ((Float)paramMap.get("blurRadius")).floatValue();
    }
    if (paramMap.containsKey("intensity"))
    {
      this.intensity = ((Float)paramMap.get("intensity")).floatValue();
      if (this.unsharpMask != null) {
        this.unsharpMask.addParam(new m.f("intensity", this.intensity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.GPUImageUnsharpMaskFilter
 * JD-Core Version:    0.7.0.1
 */