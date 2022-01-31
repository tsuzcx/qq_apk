package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SmoothSharpenFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER;
  public static final String FRAGMENT_SHADER2;
  
  static
  {
    AppMethodBeat.i(82938);
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothSharpenFragmentShader.dat");
    FRAGMENT_SHADER2 = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothSharpenFragmentShader2.dat");
    AppMethodBeat.o(82938);
  }
  
  public SmoothSharpenFilter()
  {
    super(FRAGMENT_SHADER);
    AppMethodBeat.i(82933);
    initParams();
    AppMethodBeat.o(82933);
  }
  
  public SmoothSharpenFilter(int paramInt)
  {
    super(FRAGMENT_SHADER2);
    AppMethodBeat.i(82934);
    initParams();
    AppMethodBeat.o(82934);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82935);
    addParam(new m.f("sharpFactor", 0.12F));
    addParam(new m.n("inputImageTexture2", 0, 33986));
    AppMethodBeat.o(82935);
  }
  
  public void updateFactor(float paramFloat)
  {
    AppMethodBeat.i(82937);
    addParam(new m.f("sharpFactor", 0.12F * paramFloat));
    AppMethodBeat.o(82937);
  }
  
  public void updateTexture(int paramInt)
  {
    AppMethodBeat.i(82936);
    addParam(new m.n("inputImageTexture2", paramInt, 33986));
    AppMethodBeat.o(82936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.SmoothSharpenFilter
 * JD-Core Version:    0.7.0.1
 */