package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;

public class TransitionAlphaFilter
  extends BaseFilter
  implements ITransitionFilter
{
  public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float alpha;\n \n void main(void) {\n     vec4 current = texture2D(inputImageTexture, textureCoordinate);\n     vec4 last = texture2D(inputImageTexture2, textureCoordinate);\n     gl_FragColor = mix(last, current, alpha); \n }";
  private int easeCurve;
  private long transitionDuration;
  private long transitionStartTime;
  
  public TransitionAlphaFilter()
  {
    super(" precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float alpha;\n \n void main(void) {\n     vec4 current = texture2D(inputImageTexture, textureCoordinate);\n     vec4 last = texture2D(inputImageTexture2, textureCoordinate);\n     gl_FragColor = mix(last, current, alpha); \n }");
    AppMethodBeat.i(83038);
    this.transitionStartTime = -1L;
    initParams();
    AppMethodBeat.o(83038);
  }
  
  private double getDuration(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(83044);
    paramDouble3 = (paramDouble3 - paramDouble1) / (paramDouble2 - paramDouble1);
    switch (this.easeCurve)
    {
    default: 
      paramDouble1 = paramDouble3 * (paramDouble2 - paramDouble1) + paramDouble1;
    }
    for (;;)
    {
      AppMethodBeat.o(83044);
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
    AppMethodBeat.i(83039);
    addParam(new m.n("inputImageTexture2", 0, 33986));
    addParam(new m.f("alpha", 0.0F));
    AppMethodBeat.o(83039);
  }
  
  private void updateTextureParam(long paramLong)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(83042);
    float f2 = (float)(getDuration(this.transitionStartTime, this.transitionStartTime + this.transitionDuration, paramLong) - this.transitionStartTime) / (float)this.transitionDuration;
    if (f2 > 1.0F) {}
    for (;;)
    {
      addParam(new m.f("alpha", f1));
      AppMethodBeat.o(83042);
      return;
      f1 = f2;
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(83043);
    this.transitionStartTime = -1L;
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    AppMethodBeat.o(83043);
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
    AppMethodBeat.i(83040);
    addParam(new m.n("inputImageTexture2", paramInt, 33986));
    AppMethodBeat.o(83040);
  }
  
  public void updatePreview(long paramLong)
  {
    AppMethodBeat.i(83041);
    if (this.transitionStartTime < 0L) {
      this.transitionStartTime = paramLong;
    }
    updateTextureParam(paramLong);
    AppMethodBeat.o(83041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransitionAlphaFilter
 * JD-Core Version:    0.7.0.1
 */