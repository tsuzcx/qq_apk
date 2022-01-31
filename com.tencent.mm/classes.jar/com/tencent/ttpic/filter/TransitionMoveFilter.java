package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.ttpic.util.VideoFilterUtil;

public class TransitionMoveFilter
  extends BaseFilter
  implements ITransitionFilter
{
  public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float moveX;\n uniform float moveY;\n \n void main(void) {\n     vec2 location = textureCoordinate + vec2(moveX, moveY); \n     if (location.x < 0.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(1.0, 0.0)); \n     } else if (location.x > 1.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(-1.0, 0.0)); \n     } else if (location.y < 0.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(0.0, 1.0)); \n     } else if (location.y > 1.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(0.0, -1.0)); \n     } else { \n         gl_FragColor = texture2D(inputImageTexture2, location); \n     } \n }";
  private int easeCurve;
  private int moveOrientation = 1;
  private long transitionDuration;
  private long transitionStartTime = -1L;
  
  public TransitionMoveFilter()
  {
    super(" precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float moveX;\n uniform float moveY;\n \n void main(void) {\n     vec2 location = textureCoordinate + vec2(moveX, moveY); \n     if (location.x < 0.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(1.0, 0.0)); \n     } else if (location.x > 1.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(-1.0, 0.0)); \n     } else if (location.y < 0.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(0.0, 1.0)); \n     } else if (location.y > 1.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(0.0, -1.0)); \n     } else { \n         gl_FragColor = texture2D(inputImageTexture2, location); \n     } \n }");
    initParams();
  }
  
  private double getDuration(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    paramDouble3 = (paramDouble3 - paramDouble1) / (paramDouble2 - paramDouble1);
    switch (this.easeCurve)
    {
    default: 
      return paramDouble3 * (paramDouble2 - paramDouble1) + paramDouble1;
    case 1: 
      paramDouble1 = -(paramDouble2 - paramDouble1);
      return Math.cos(paramDouble3 * 1.570796326794897D) * paramDouble1 + paramDouble2;
    case 2: 
      return Math.sin(paramDouble3 * 1.570796326794897D) * (paramDouble2 - paramDouble1) + paramDouble1;
    }
    paramDouble2 = -(paramDouble2 - paramDouble1) / 2.0D;
    return (Math.cos(paramDouble3 * 3.141592653589793D) - 1.0D) * paramDouble2 + paramDouble1;
  }
  
  private void initParams()
  {
    addParam(new m.n("inputImageTexture2", 0, 33986));
    addParam(new m.f("moveX", 0.0F));
    addParam(new m.f("moveY", 0.0F));
  }
  
  private void updateTextureParam(long paramLong)
  {
    float f1 = 1.0F;
    float f2 = (float)(getDuration(this.transitionStartTime, this.transitionStartTime + this.transitionDuration, paramLong) - this.transitionStartTime) / (float)this.transitionDuration;
    if (f2 > 1.0F) {}
    for (;;)
    {
      if (this.moveOrientation == 1)
      {
        float f3 = 0.0F;
        f2 = f1;
        f1 = f3;
      }
      for (;;)
      {
        addParam(new m.f("moveX", f2));
        addParam(new m.f("moveY", f1));
        return;
        if (this.moveOrientation == 2)
        {
          f2 = -f1;
          f1 = 0.0F;
        }
        else if (this.moveOrientation == 3)
        {
          f2 = 0.0F;
        }
        else
        {
          f1 = -f1;
          f2 = 0.0F;
        }
      }
      f1 = f2;
    }
  }
  
  public void reset()
  {
    this.transitionStartTime = -1L;
    setPositions(VideoFilterUtil.ORIGIN_POSITION_COORDS);
  }
  
  public void setDataPath(String paramString) {}
  
  public void setDuration(long paramLong)
  {
    this.transitionDuration = paramLong;
  }
  
  public void setEaseCurve(int paramInt)
  {
    this.easeCurve = paramInt;
  }
  
  public void setLastTex(int paramInt)
  {
    addParam(new m.n("inputImageTexture2", paramInt, 33986));
  }
  
  public void setMoveOrientation(int paramInt)
  {
    this.moveOrientation = paramInt;
  }
  
  public void updatePreview(long paramLong)
  {
    if (this.transitionStartTime < 0L) {
      this.transitionStartTime = paramLong;
    }
    updateTextureParam(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransitionMoveFilter
 * JD-Core Version:    0.7.0.1
 */