package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.n;

public class GameOverlayFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n\n void main(void) {\n     vec4 canvasColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n     gl_FragColor = mix(canvasColor, maskColor, maskColor.a);\n }";
  private static final String VERTEX_SHADER = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";
  
  public GameOverlayFilter()
  {
    super("precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}", " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n\n void main(void) {\n     vec4 canvasColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n     gl_FragColor = mix(canvasColor, maskColor, maskColor.a);\n }");
    initParams();
  }
  
  private void initParams()
  {
    setMaskTexture(0);
  }
  
  public void setMaskTexture(int paramInt)
  {
    addParam(new m.n("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.filter.GameOverlayFilter
 * JD-Core Version:    0.7.0.1
 */