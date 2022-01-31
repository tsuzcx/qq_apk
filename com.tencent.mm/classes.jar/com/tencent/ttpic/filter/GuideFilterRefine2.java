package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GuideFilterRefine2
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float width;\nuniform float height;\nvoid main() {\n   float step_x = 1.0 / width;\n   float step_y = 1.0 / height;\n   vec4 srcValue = vec4(0.0, 0.0, 0.0, 0.0);\n   vec2 fIdx = textureCoordinate;\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x - step_x, textureCoordinate.y - step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x, textureCoordinate.y - step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x + step_x, textureCoordinate.y - step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x - step_x, textureCoordinate.y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x + step_x, textureCoordinate.y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x - step_x, textureCoordinate.y + step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x, textureCoordinate.y + step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x + step_x, textureCoordinate.y + step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   gl_FragColor = srcValue / 9.0;\n}";
  
  public GuideFilterRefine2()
  {
    super("precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float width;\nuniform float height;\nvoid main() {\n   float step_x = 1.0 / width;\n   float step_y = 1.0 / height;\n   vec4 srcValue = vec4(0.0, 0.0, 0.0, 0.0);\n   vec2 fIdx = textureCoordinate;\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x - step_x, textureCoordinate.y - step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x, textureCoordinate.y - step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x + step_x, textureCoordinate.y - step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x - step_x, textureCoordinate.y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x + step_x, textureCoordinate.y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x - step_x, textureCoordinate.y + step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x, textureCoordinate.y + step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x + step_x, textureCoordinate.y + step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   gl_FragColor = srcValue / 9.0;\n}");
    AppMethodBeat.i(82583);
    initParams();
    AppMethodBeat.o(82583);
  }
  
  private void initParams()
  {
    AppMethodBeat.i(82584);
    addParam(new m.f("width", 0.0F));
    addParam(new m.f("height", 0.0F));
    AppMethodBeat.o(82584);
  }
  
  public void updateParams(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82585);
    addParam(new m.f("width", paramInt1));
    addParam(new m.f("height", paramInt2));
    AppMethodBeat.o(82585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.GuideFilterRefine2
 * JD-Core Version:    0.7.0.1
 */