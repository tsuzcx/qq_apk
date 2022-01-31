package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SimpleGaussionFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER;
  
  static
  {
    AppMethodBeat.i(82861);
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/GaussionBlurFragmentShader.dat");
    AppMethodBeat.o(82861);
  }
  
  public SimpleGaussionFilter()
  {
    super(FRAGMENT_SHADER);
    AppMethodBeat.i(82858);
    initParams();
    AppMethodBeat.o(82858);
  }
  
  private void initParams()
  {
    AppMethodBeat.i(82859);
    addParam(new m.f("stepX", 0.0F));
    addParam(new m.f("stepY", 0.0F));
    AppMethodBeat.o(82859);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82860);
    addParam(new m.f("stepX", 1.0F / paramInt2));
    addParam(new m.f("stepY", 1.0F / paramInt3));
    boolean bool = super.renderTexture(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(82860);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.SimpleGaussionFilter
 * JD-Core Version:    0.7.0.1
 */