package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SmoothCBiFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER;
  private static final String VERTEX_SHADER;
  
  static
  {
    AppMethodBeat.i(82917);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothCBiVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothCBiFragmentShader.dat");
    AppMethodBeat.o(82917);
  }
  
  public SmoothCBiFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82914);
    initParams();
    AppMethodBeat.o(82914);
  }
  
  private void initParams()
  {
    AppMethodBeat.i(82915);
    addParam(new m.f("texelWidthOffset", 0.0F));
    addParam(new m.f("texelHeightOffset", 0.0F));
    addParam(new m.f("distanceNormalizationFactor", 4.0F));
    AppMethodBeat.o(82915);
  }
  
  public void updateSize(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(82916);
    addParam(new m.f("texelWidthOffset", 4.0F / paramFloat1));
    addParam(new m.f("texelHeightOffset", 4.0F / paramFloat2));
    AppMethodBeat.o(82916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.SmoothCBiFilter
 * JD-Core Version:    0.7.0.1
 */