package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FabbyFeatherFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "   precision mediump float; \n   precision mediump int; \n   varying mediump vec2 textureCoordinate; \n    uniform sampler2D inputImageTexture; \n   uniform sampler2D inputImageTexture2; \n   uniform float stepX; \n   uniform float stepY; \n   uniform float featherWidthInPixel; \n   float alphaForStep(float step_x, float step_y, float weight) { \n       float step_x45 = step_x * 0.7071; \n       float step_y45 = step_y * 0.7071; \n       vec4 v3_10 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y+step_y)); \n       vec4 v3_11 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y+step_y45)); \n       vec4 v3_12 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x, textureCoordinate.y)); \n       vec4 v3_13 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y-step_y45)); \n       vec4 v3_14 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y-step_y)); \n       vec4 v3_15 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y-step_y45)); \n       vec4 v3_16 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x, textureCoordinate.y)); \n       vec4 v3_17 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y+step_y45)); \n       float temp = step(0.1, v3_10.r); \n       temp = step(0.1, v3_12.r + temp); \n       temp = step(0.1, v3_13.r + temp); \n       temp = step(0.1, v3_14.r + temp); \n       temp = step(0.1, v3_15.r + temp); \n       temp = step(0.1, v3_16.r + temp); \n       float alpha = step(0.1, v3_17.r + temp); \n       return alpha * weight; \n   } \n   void main() \n   { \n       vec4 v1 = texture2D(inputImageTexture, textureCoordinate); \n       vec4 v2 = texture2D(inputImageTexture2, textureCoordinate); \n       vec4 bg = vec4(0.0, 0.0, 0.0, 0.0); \n       float mask = v2.r; \n       if (mask < 0.1) { \n           float x = stepX * featherWidthInPixel; \n           float y = stepY * featherWidthInPixel; \n           float outterAlpha = alphaForStep(x, y, 1.0); \n           if (outterAlpha > 0.9) { \n               float minA = 0.0; \n               float maxA = 1.0; \n               float alpha = 1.0; \n               float maxD = featherWidthInPixel; \n               float minD = 0.0; \n               for (int i = 0; i < 100; i++) { \n                   float mid = (minD + maxD) * 0.5; \n                   float midA = (minA + maxA) * 0.5; \n                   float xMid = stepX * mid; \n                   float yMid = stepY * mid; \n                   float aMid = alphaForStep(xMid, yMid, 1.0); \n                   if (aMid > 0.9) { \n                        maxD = mid; \n                       minA = midA; \n                   } else { \n                       minD = mid; \n                       maxA = midA; \n                   } \n                   if (maxD - minD <= 1.0) { \n                       alpha = midA; \n                       break; \n                   } \n               } \n               gl_FragColor = vec4(v1.rgb, alpha); \n           } else { \n               gl_FragColor = bg; \n           } \n       } else { \n           gl_FragColor = vec4(v1.rgb, 1.0); \n       } \n   }";
  private float featherWidthInPixel;
  private int mMaskTex;
  private float stepX;
  private float stepY;
  
  public FabbyFeatherFilter()
  {
    super("   precision mediump float; \n   precision mediump int; \n   varying mediump vec2 textureCoordinate; \n    uniform sampler2D inputImageTexture; \n   uniform sampler2D inputImageTexture2; \n   uniform float stepX; \n   uniform float stepY; \n   uniform float featherWidthInPixel; \n   float alphaForStep(float step_x, float step_y, float weight) { \n       float step_x45 = step_x * 0.7071; \n       float step_y45 = step_y * 0.7071; \n       vec4 v3_10 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y+step_y)); \n       vec4 v3_11 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y+step_y45)); \n       vec4 v3_12 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x, textureCoordinate.y)); \n       vec4 v3_13 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y-step_y45)); \n       vec4 v3_14 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y-step_y)); \n       vec4 v3_15 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y-step_y45)); \n       vec4 v3_16 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x, textureCoordinate.y)); \n       vec4 v3_17 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y+step_y45)); \n       float temp = step(0.1, v3_10.r); \n       temp = step(0.1, v3_12.r + temp); \n       temp = step(0.1, v3_13.r + temp); \n       temp = step(0.1, v3_14.r + temp); \n       temp = step(0.1, v3_15.r + temp); \n       temp = step(0.1, v3_16.r + temp); \n       float alpha = step(0.1, v3_17.r + temp); \n       return alpha * weight; \n   } \n   void main() \n   { \n       vec4 v1 = texture2D(inputImageTexture, textureCoordinate); \n       vec4 v2 = texture2D(inputImageTexture2, textureCoordinate); \n       vec4 bg = vec4(0.0, 0.0, 0.0, 0.0); \n       float mask = v2.r; \n       if (mask < 0.1) { \n           float x = stepX * featherWidthInPixel; \n           float y = stepY * featherWidthInPixel; \n           float outterAlpha = alphaForStep(x, y, 1.0); \n           if (outterAlpha > 0.9) { \n               float minA = 0.0; \n               float maxA = 1.0; \n               float alpha = 1.0; \n               float maxD = featherWidthInPixel; \n               float minD = 0.0; \n               for (int i = 0; i < 100; i++) { \n                   float mid = (minD + maxD) * 0.5; \n                   float midA = (minA + maxA) * 0.5; \n                   float xMid = stepX * mid; \n                   float yMid = stepY * mid; \n                   float aMid = alphaForStep(xMid, yMid, 1.0); \n                   if (aMid > 0.9) { \n                        maxD = mid; \n                       minA = midA; \n                   } else { \n                       minD = mid; \n                       maxA = midA; \n                   } \n                   if (maxD - minD <= 1.0) { \n                       alpha = midA; \n                       break; \n                   } \n               } \n               gl_FragColor = vec4(v1.rgb, alpha); \n           } else { \n               gl_FragColor = bg; \n           } \n       } else { \n           gl_FragColor = vec4(v1.rgb, 1.0); \n       } \n   }");
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(82249);
    addParam(new m.n("inputImageTexture2", this.mMaskTex, 33986));
    addParam(new m.f("stepX", this.stepX));
    addParam(new m.f("stepY", this.stepY));
    addParam(new m.f("featherWidthInPixel", this.featherWidthInPixel));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(82249);
  }
  
  public void setFeatherWidthInPixel(float paramFloat)
  {
    this.featherWidthInPixel = paramFloat;
  }
  
  public void setStepX(float paramFloat)
  {
    this.stepX = paramFloat;
  }
  
  public void setStepY(float paramFloat)
  {
    this.stepY = paramFloat;
  }
  
  public void setmMaskTex(int paramInt)
  {
    this.mMaskTex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyFeatherFilter
 * JD-Core Version:    0.7.0.1
 */