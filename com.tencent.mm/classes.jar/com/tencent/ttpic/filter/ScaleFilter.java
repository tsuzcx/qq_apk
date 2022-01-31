package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;

public class ScaleFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform float scale;\n \n void main(void) {\n       float x = 0.5 + (textureCoordinate.x - 0.5) / scale; \n       float y = 0.5 + (textureCoordinate.y - 0.5) / scale; \n       if (x < 0.0 || x > 1.0 || y < 0.0 || y > 1.0) { \n           gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0); \n       } else { \n           gl_FragColor = texture2D(inputImageTexture, vec2(x, y)); \n       } \n }";
  
  public ScaleFilter()
  {
    super(" precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform float scale;\n \n void main(void) {\n       float x = 0.5 + (textureCoordinate.x - 0.5) / scale; \n       float y = 0.5 + (textureCoordinate.y - 0.5) / scale; \n       if (x < 0.0 || x > 1.0 || y < 0.0 || y > 1.0) { \n           gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0); \n       } else { \n           gl_FragColor = texture2D(inputImageTexture, vec2(x, y)); \n       } \n }");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new m.f("scale", 0.0F));
  }
  
  public void setScale(float paramFloat)
  {
    addParam(new m.f("scale", paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.ScaleFilter
 * JD-Core Version:    0.7.0.1
 */