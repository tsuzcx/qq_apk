package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;

public class TransitionMoveFilter
  extends BaseFilter
  implements ITransitionFilter
{
  public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float moveX;\n uniform float moveY;\n \n void main(void) {\n     vec2 location = textureCoordinate + vec2(moveX, moveY); \n     if (location.x < 0.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(1.0, 0.0)); \n     } else if (location.x > 1.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(-1.0, 0.0)); \n     } else if (location.y < 0.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(0.0, 1.0)); \n     } else if (location.y > 1.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(0.0, -1.0)); \n     } else { \n         gl_FragColor = texture2D(inputImageTexture2, location); \n     } \n }";
  private int easeCurve;
  private int moveOrientation;
  private long transitionDuration;
  private long transitionStartTime;
  
  public TransitionMoveFilter()
  {
    super(" precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float moveX;\n uniform float moveY;\n \n void main(void) {\n     vec2 location = textureCoordinate + vec2(moveX, moveY); \n     if (location.x < 0.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(1.0, 0.0)); \n     } else if (location.x > 1.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(-1.0, 0.0)); \n     } else if (location.y < 0.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(0.0, 1.0)); \n     } else if (location.y > 1.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(0.0, -1.0)); \n     } else { \n         gl_FragColor = texture2D(inputImageTexture2, location); \n     } \n }");
    AppMethodBeat.i(83065);
    this.transitionStartTime = -1L;
    this.moveOrientation = 1;
    initParams();
    AppMethodBeat.o(83065);
  }
  
  private double getDuration(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(83071);
    paramDouble3 = (paramDouble3 - paramDouble1) / (paramDouble2 - paramDouble1);
    switch (this.easeCurve)
    {
    default: 
      paramDouble1 = paramDouble3 * (paramDouble2 - paramDouble1) + paramDouble1;
    }
    for (;;)
    {
      AppMethodBeat.o(83071);
      return paramDouble1;
      paramDouble1 = -(paramDouble2 - paramDouble1);
      paramDouble1 = Math.cos(paramDouble3 * 1.570796326794897D) * paramDouble1 + paramDouble2;
      continue;
      paramDouble1 = Math.sin(paramDouble3 * 1.570796326794897D) * (paramDouble2 - paramDouble1) + paramDouble1;
      continue;
      paramDouble2 = -(paramDouble2 - paramDouble1) / 2.0D;
      paramDouble1 = (Math.cos(paramDouble3 * 3.141592653589793D) - 1.0D) * paramDouble2 + paramDouble1;
    }
  }
  
  private void initParams()
  {
    AppMethodBeat.i(83066);
    addParam(new m.n("inputImageTexture2", 0, 33986));
    addParam(new m.f("moveX", 0.0F));
    addParam(new m.f("moveY", 0.0F));
    AppMethodBeat.o(83066);
  }
  
  private void updateTextureParam(long paramLong)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(83069);
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
        AppMethodBeat.o(83069);
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
    AppMethodBeat.i(83070);
    this.transitionStartTime = -1L;
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    AppMethodBeat.o(83070);
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
    AppMethodBeat.i(83067);
    addParam(new m.n("inputImageTexture2", paramInt, 33986));
    AppMethodBeat.o(83067);
  }
  
  public void setMoveOrientation(int paramInt)
  {
    this.moveOrientation = paramInt;
  }
  
  public void updatePreview(long paramLong)
  {
    AppMethodBeat.i(83068);
    if (this.transitionStartTime < 0L) {
      this.transitionStartTime = paramLong;
    }
    updateTextureParam(paramLong);
    AppMethodBeat.o(83068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransitionMoveFilter
 * JD-Core Version:    0.7.0.1
 */