package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.e;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;

public class FabbyStrokeFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision mediump float; \nvarying mediump vec2 textureCoordinate; \nuniform sampler2D inputImageTexture; \nuniform sampler2D inputImageTexture2; \nuniform float stepX; \nuniform float stepY; \nuniform float strokeGapInPixel; \nuniform float strokeWidthInPixel; \nuniform vec4 strokeColor; \nfloat alphaForStep(float step_x, float step_y, float weight) { \n   float step_x45 = step_x * 0.7071; \n   float step_y45 = step_y * 0.7071; \n   vec4 v3_10 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y+step_y)); \n   vec4 v3_11 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y+step_y45)); \n   vec4 v3_12 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x, textureCoordinate.y)); \n   vec4 v3_13 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y-step_y45)); \n   vec4 v3_14 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y-step_y)); \n   vec4 v3_15 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y-step_y45)); \n   vec4 v3_16 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x, textureCoordinate.y)); \n   vec4 v3_17 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y+step_y45)); \n   float alpha = step(0.1, v3_10.r+v3_11.r+v3_12.r+v3_13.r+v3_14.r+v3_15.r+v3_16.r+v3_17.r); \n   return alpha * weight; \n} \nvoid main() \n{ \n   vec4 v1 = texture2D(inputImageTexture, textureCoordinate); \n   vec4 v2 = texture2D(inputImageTexture2, textureCoordinate); \n   vec4 bg = vec4(0.0, 0.0, 0.0, 0.0); \n   float mask = v2.r; \n   if (mask < 0.1) { \n       float x = stepX * strokeGapInPixel; \n       float y = stepY * strokeGapInPixel; \n       float innerAlpha = alphaForStep(x, y, 1.0); \n       if (innerAlpha > 1.0) { \n           gl_FragColor = mix(bg, v1, mask); \n       } else { \n           x += stepX * strokeWidthInPixel; \n           y += stepY * strokeWidthInPixel; \n           float outterAlpha = alphaForStep(x, y, 1.0); \n           if (outterAlpha > 0.9) { \n               gl_FragColor = strokeColor; \n           } else { \n               gl_FragColor = bg; \n           } \n       } \n   } else { \n       gl_FragColor = v1; \n   } \n }";
  
  public FabbyStrokeFilter()
  {
    super("precision mediump float; \nvarying mediump vec2 textureCoordinate; \nuniform sampler2D inputImageTexture; \nuniform sampler2D inputImageTexture2; \nuniform float stepX; \nuniform float stepY; \nuniform float strokeGapInPixel; \nuniform float strokeWidthInPixel; \nuniform vec4 strokeColor; \nfloat alphaForStep(float step_x, float step_y, float weight) { \n   float step_x45 = step_x * 0.7071; \n   float step_y45 = step_y * 0.7071; \n   vec4 v3_10 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y+step_y)); \n   vec4 v3_11 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y+step_y45)); \n   vec4 v3_12 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x, textureCoordinate.y)); \n   vec4 v3_13 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y-step_y45)); \n   vec4 v3_14 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y-step_y)); \n   vec4 v3_15 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y-step_y45)); \n   vec4 v3_16 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x, textureCoordinate.y)); \n   vec4 v3_17 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y+step_y45)); \n   float alpha = step(0.1, v3_10.r+v3_11.r+v3_12.r+v3_13.r+v3_14.r+v3_15.r+v3_16.r+v3_17.r); \n   return alpha * weight; \n} \nvoid main() \n{ \n   vec4 v1 = texture2D(inputImageTexture, textureCoordinate); \n   vec4 v2 = texture2D(inputImageTexture2, textureCoordinate); \n   vec4 bg = vec4(0.0, 0.0, 0.0, 0.0); \n   float mask = v2.r; \n   if (mask < 0.1) { \n       float x = stepX * strokeGapInPixel; \n       float y = stepY * strokeGapInPixel; \n       float innerAlpha = alphaForStep(x, y, 1.0); \n       if (innerAlpha > 1.0) { \n           gl_FragColor = mix(bg, v1, mask); \n       } else { \n           x += stepX * strokeWidthInPixel; \n           y += stepY * strokeWidthInPixel; \n           float outterAlpha = alphaForStep(x, y, 1.0); \n           if (outterAlpha > 0.9) { \n               gl_FragColor = strokeColor; \n           } else { \n               gl_FragColor = bg; \n           } \n       } \n   } else { \n       gl_FragColor = v1; \n   } \n }");
    initParam();
  }
  
  private void initParam()
  {
    addParam(new m.n("inputImageTexture2", 0, 33986));
    addParam(new m.f("stepX", 0.0F));
    addParam(new m.f("stepY", 0.0F));
    addParam(new m.f("strokeGapInPixel", 0.0F));
    addParam(new m.f("strokeWidthInPixel", 0.0F));
    addParam(new m.e("strokeColor", 0.0F, 0.0F, 0.0F, 0.0F));
  }
  
  public void setStepX(float paramFloat)
  {
    addParam(new m.f("stepX", paramFloat));
  }
  
  public void setStepY(float paramFloat)
  {
    addParam(new m.f("stepY", paramFloat));
  }
  
  public void setStrokeColor(float[] paramArrayOfFloat)
  {
    addParam(new m.e("strokeColor", paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]));
  }
  
  public void setStrokeGapInPixel(float paramFloat)
  {
    addParam(new m.f("strokeGapInPixel", paramFloat));
  }
  
  public void setStrokeWidthInPixel(float paramFloat)
  {
    addParam(new m.f("strokeWidthInPixel", paramFloat));
  }
  
  public void setmMaskTex(int paramInt)
  {
    addParam(new m.n("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyStrokeFilter
 * JD-Core Version:    0.7.0.1
 */