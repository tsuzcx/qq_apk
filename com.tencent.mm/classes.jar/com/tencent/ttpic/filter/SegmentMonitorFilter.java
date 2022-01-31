package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;

public class SegmentMonitorFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform int segSlow;\n \n void main(void) {\n    if(segSlow == 1){\n        gl_FragColor = vec4(1, 0, 0, 0.5); \n    } else{\n        gl_FragColor = vec4(0, 1, 0, 0.5); \n    }\n}";
  
  public SegmentMonitorFilter()
  {
    super(" precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform int segSlow;\n \n void main(void) {\n    if(segSlow == 1){\n        gl_FragColor = vec4(1, 0, 0, 0.5); \n    } else{\n        gl_FragColor = vec4(0, 1, 0, 0.5); \n    }\n}");
    AppMethodBeat.i(82833);
    initParams();
    AppMethodBeat.o(82833);
  }
  
  private void initParams()
  {
    AppMethodBeat.i(82834);
    addParam(new m.i("segSlow", 0));
    AppMethodBeat.o(82834);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82835);
    super.ApplyGLSLFilter();
    setPositions(new float[] { -1.0F, -1.0F, -1.0F, -0.25F, -0.25F, -0.25F, -0.25F, -1.0F });
    AppMethodBeat.o(82835);
  }
  
  public h updateAndRender(int paramInt, h paramh)
  {
    AppMethodBeat.i(82836);
    addParam(new m.i("segSlow", paramInt));
    GlUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(paramh.texture[0], paramh.width, paramh.height);
    GlUtil.setBlendMode(false);
    AppMethodBeat.o(82836);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.SegmentMonitorFilter
 * JD-Core Version:    0.7.0.1
 */