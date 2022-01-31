package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TextureMergeFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n \n void main(void) {\n     vec4 fgColor = texture2D(inputImageTexture3, textureCoordinate);\n     if (fgColor.a >= 1.0) {\n         gl_FragColor = fgColor; \n     } else { \n          vec4 middleColor = texture2D(inputImageTexture, textureCoordinate);\n         if (middleColor.a >= 1.0) { \n             gl_FragColor = mix(middleColor, fgColor, fgColor.a); \n         } else {\n             vec4 bgColor = texture2D(inputImageTexture2, textureCoordinate);\n             vec4 bg_middle = mix(bgColor, middleColor, middleColor.a); \n             gl_FragColor = mix(bg_middle, fgColor, fgColor.a); \n         } \n     } \n }";
  private int mBgTex;
  private int mFgTex;
  
  public TextureMergeFilter()
  {
    super(" precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n \n void main(void) {\n     vec4 fgColor = texture2D(inputImageTexture3, textureCoordinate);\n     if (fgColor.a >= 1.0) {\n         gl_FragColor = fgColor; \n     } else { \n          vec4 middleColor = texture2D(inputImageTexture, textureCoordinate);\n         if (middleColor.a >= 1.0) { \n             gl_FragColor = mix(middleColor, fgColor, fgColor.a); \n         } else {\n             vec4 bgColor = texture2D(inputImageTexture2, textureCoordinate);\n             vec4 bg_middle = mix(bgColor, middleColor, middleColor.a); \n             gl_FragColor = mix(bg_middle, fgColor, fgColor.a); \n         } \n     } \n }");
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(82973);
    addParam(new m.n("inputImageTexture2", this.mBgTex, 33986));
    addParam(new m.n("inputImageTexture3", this.mFgTex, 33987));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(82973);
  }
  
  public void setTex(int paramInt1, int paramInt2)
  {
    this.mBgTex = paramInt1;
    this.mFgTex = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.TextureMergeFilter
 * JD-Core Version:    0.7.0.1
 */