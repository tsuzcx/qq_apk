package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.filter.m.c;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SmoothCProcessFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER;
  private static final String VERTEX_SHADER;
  
  static
  {
    AppMethodBeat.i(82928);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothCProcessVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothCProcessFragmentShader.dat");
    AppMethodBeat.o(82928);
  }
  
  public SmoothCProcessFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82924);
    initParams();
    AppMethodBeat.o(82924);
  }
  
  private void initParams()
  {
    AppMethodBeat.i(82925);
    addParam(new m.f("blurOpacity", 0.46F));
    addParam(new m.c("inputTextureSize", new float[] { 0.0F, 0.0F }));
    addParam(new m.n("inputImageTexture2", 0, 33986));
    addParam(new m.f("factor1", 2.782F));
    addParam(new m.f("factor2", 1.131F));
    addParam(new m.f("factor3", 1.158F));
    addParam(new m.f("factor4", 2.901F));
    addParam(new m.f("factor5", 0.979F));
    addParam(new m.f("factor6", 0.639F));
    addParam(new m.f("factor7", 0.963F));
    addParam(new m.f("filterOpacity", 0.6F));
    AppMethodBeat.o(82925);
  }
  
  public void setTexture2(h paramh)
  {
    AppMethodBeat.i(82926);
    addParam(new m.n("inputImageTexture2", paramh.texture[0], 33986));
    addParam(new m.c("inputTextureSize", new float[] { paramh.width, paramh.height }));
    AppMethodBeat.o(82926);
  }
  
  public void updateSmoothOpacity(float paramFloat)
  {
    AppMethodBeat.i(82927);
    addParam(new m.f("blurOpacity", paramFloat));
    AppMethodBeat.o(82927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.SmoothCProcessFilter
 * JD-Core Version:    0.7.0.1
 */