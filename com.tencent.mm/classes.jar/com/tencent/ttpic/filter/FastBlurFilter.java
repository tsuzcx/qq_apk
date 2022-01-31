package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FastBlurFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "   uniform sampler2D inputImageTexture; \n   uniform highp float texelWidthOffset; \n   uniform highp float texelHeightOffset; \n   varying highp vec2 blurCoordinates[9]; \n   void main() \n   { \n       lowp vec4 sum = vec4(0.0); \n       sum += texture2D(inputImageTexture, blurCoordinates[0]) * 0.133571; \n       sum += texture2D(inputImageTexture, blurCoordinates[1]) * 0.233308; \n       sum += texture2D(inputImageTexture, blurCoordinates[2]) * 0.233308; \n       sum += texture2D(inputImageTexture, blurCoordinates[3]) * 0.135928; \n       sum += texture2D(inputImageTexture, blurCoordinates[4]) * 0.135928; \n       sum += texture2D(inputImageTexture, blurCoordinates[5]) * 0.051383; \n       sum += texture2D(inputImageTexture, blurCoordinates[6]) * 0.051383; \n       sum += texture2D(inputImageTexture, blurCoordinates[7]) * 0.012595; \n       sum += texture2D(inputImageTexture, blurCoordinates[8]) * 0.012595; \n       gl_FragColor = sum; \n   }";
  public static final String VERTEX_SHADER = "   attribute vec4 position; \n   attribute vec4 inputTextureCoordinate; \n   uniform float texelWidthOffset; \n   uniform float texelHeightOffset; \n   varying vec2 blurCoordinates[9]; \n   void main() \n   { \n       gl_Position = position; \n       vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset); \n       blurCoordinates[0] = inputTextureCoordinate.xy; \n       blurCoordinates[1] = inputTextureCoordinate.xy + singleStepOffset * 1.458430; \n       blurCoordinates[2] = inputTextureCoordinate.xy - singleStepOffset * 1.458430; \n       blurCoordinates[3] = inputTextureCoordinate.xy + singleStepOffset * 3.403985; \n       blurCoordinates[4] = inputTextureCoordinate.xy - singleStepOffset * 3.403985; \n       blurCoordinates[5] = inputTextureCoordinate.xy + singleStepOffset * 5.351806; \n       blurCoordinates[6] = inputTextureCoordinate.xy - singleStepOffset * 5.351806; \n       blurCoordinates[7] = inputTextureCoordinate.xy + singleStepOffset * 7.302940; \n       blurCoordinates[8] = inputTextureCoordinate.xy - singleStepOffset * 7.302940; \n   }";
  
  public FastBlurFilter()
  {
    super("   attribute vec4 position; \n   attribute vec4 inputTextureCoordinate; \n   uniform float texelWidthOffset; \n   uniform float texelHeightOffset; \n   varying vec2 blurCoordinates[9]; \n   void main() \n   { \n       gl_Position = position; \n       vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset); \n       blurCoordinates[0] = inputTextureCoordinate.xy; \n       blurCoordinates[1] = inputTextureCoordinate.xy + singleStepOffset * 1.458430; \n       blurCoordinates[2] = inputTextureCoordinate.xy - singleStepOffset * 1.458430; \n       blurCoordinates[3] = inputTextureCoordinate.xy + singleStepOffset * 3.403985; \n       blurCoordinates[4] = inputTextureCoordinate.xy - singleStepOffset * 3.403985; \n       blurCoordinates[5] = inputTextureCoordinate.xy + singleStepOffset * 5.351806; \n       blurCoordinates[6] = inputTextureCoordinate.xy - singleStepOffset * 5.351806; \n       blurCoordinates[7] = inputTextureCoordinate.xy + singleStepOffset * 7.302940; \n       blurCoordinates[8] = inputTextureCoordinate.xy - singleStepOffset * 7.302940; \n   }", "   uniform sampler2D inputImageTexture; \n   uniform highp float texelWidthOffset; \n   uniform highp float texelHeightOffset; \n   varying highp vec2 blurCoordinates[9]; \n   void main() \n   { \n       lowp vec4 sum = vec4(0.0); \n       sum += texture2D(inputImageTexture, blurCoordinates[0]) * 0.133571; \n       sum += texture2D(inputImageTexture, blurCoordinates[1]) * 0.233308; \n       sum += texture2D(inputImageTexture, blurCoordinates[2]) * 0.233308; \n       sum += texture2D(inputImageTexture, blurCoordinates[3]) * 0.135928; \n       sum += texture2D(inputImageTexture, blurCoordinates[4]) * 0.135928; \n       sum += texture2D(inputImageTexture, blurCoordinates[5]) * 0.051383; \n       sum += texture2D(inputImageTexture, blurCoordinates[6]) * 0.051383; \n       sum += texture2D(inputImageTexture, blurCoordinates[7]) * 0.012595; \n       sum += texture2D(inputImageTexture, blurCoordinates[8]) * 0.012595; \n       gl_FragColor = sum; \n   }");
    AppMethodBeat.i(82461);
    initParams();
    AppMethodBeat.o(82461);
  }
  
  private void initParams()
  {
    AppMethodBeat.i(82462);
    addParam(new m.f("texelWidthOffset", 0.0F));
    addParam(new m.f("texelHeightOffset", 0.0F));
    AppMethodBeat.o(82462);
  }
  
  public void updateParams(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(82463);
    addParam(new m.f("texelWidthOffset", paramFloat1));
    addParam(new m.f("texelHeightOffset", paramFloat2));
    AppMethodBeat.o(82463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FastBlurFilter
 * JD-Core Version:    0.7.0.1
 */