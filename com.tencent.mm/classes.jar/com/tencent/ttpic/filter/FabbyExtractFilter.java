package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.n;

public class FabbyExtractFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n     vec4 cameraColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n     \n     gl_FragColor = cameraColor * maskColor.r; \n }";
  
  public FabbyExtractFilter()
  {
    super(" precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n     vec4 cameraColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n     \n     gl_FragColor = cameraColor * maskColor.r; \n }");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new m.n("inputImageTexture2", 0, 33986));
  }
  
  public void setTex(int paramInt)
  {
    addParam(new m.n("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyExtractFilter
 * JD-Core Version:    0.7.0.1
 */