package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.filter.m.i;
import com.tencent.ttpic.util.VideoFilterUtil;

public class SegmentMonitorFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform int segSlow;\n \n void main(void) {\n    if(segSlow == 1){\n        gl_FragColor = vec4(1, 0, 0, 0.5); \n    } else{\n        gl_FragColor = vec4(0, 1, 0, 0.5); \n    }\n}";
  
  public SegmentMonitorFilter()
  {
    super(" precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform int segSlow;\n \n void main(void) {\n    if(segSlow == 1){\n        gl_FragColor = vec4(1, 0, 0, 0.5); \n    } else{\n        gl_FragColor = vec4(0, 1, 0, 0.5); \n    }\n}");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new m.i("segSlow", 0));
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setPositions(new float[] { -1.0F, -1.0F, -1.0F, -0.25F, -0.25F, -0.25F, -0.25F, -1.0F });
  }
  
  public h updateAndRender(int paramInt, h paramh)
  {
    addParam(new m.i("segSlow", paramInt));
    VideoFilterUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(paramh.texture[0], paramh.width, paramh.height);
    VideoFilterUtil.setBlendMode(false);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.SegmentMonitorFilter
 * JD-Core Version:    0.7.0.1
 */