package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GuideFilterRefine3
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main() {\n   vec4 r = texture2D(inputImageTexture, textureCoordinate);\n   vec4 s = (texture2D(inputImageTexture2, textureCoordinate) - vec4(0.5, 0.5, 0.5, 0.5)) * 2.0;\n   float src = s.x * r.x + s.y * r.y + s.z * r.z + s.w * 2.0;\n   src = (src - 0.5) * 2.0 + 0.5;\n   if (src < 0.1) src = 0.0;\n   if (src > 0.9) src = 1.0;\n   gl_FragColor = vec4(src, src, src, 1.0);\n}";
  
  public GuideFilterRefine3()
  {
    super("precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main() {\n   vec4 r = texture2D(inputImageTexture, textureCoordinate);\n   vec4 s = (texture2D(inputImageTexture2, textureCoordinate) - vec4(0.5, 0.5, 0.5, 0.5)) * 2.0;\n   float src = s.x * r.x + s.y * r.y + s.z * r.z + s.w * 2.0;\n   src = (src - 0.5) * 2.0 + 0.5;\n   if (src < 0.1) src = 0.0;\n   if (src > 0.9) src = 1.0;\n   gl_FragColor = vec4(src, src, src, 1.0);\n}");
    AppMethodBeat.i(82586);
    initParams();
    AppMethodBeat.o(82586);
  }
  
  private void initParams()
  {
    AppMethodBeat.i(82587);
    addParam(new m.n("inputImageTexture2", 0, 33986));
    AppMethodBeat.o(82587);
  }
  
  public void updateParams(int paramInt)
  {
    AppMethodBeat.i(82588);
    addParam(new m.n("inputImageTexture2", paramInt, 33986));
    AppMethodBeat.o(82588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.GuideFilterRefine3
 * JD-Core Version:    0.7.0.1
 */