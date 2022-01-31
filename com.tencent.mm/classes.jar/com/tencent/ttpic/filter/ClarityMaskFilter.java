package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class ClarityMaskFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER2;
  public static final String VERTEX_SHADER2;
  
  static
  {
    AppMethodBeat.i(82113);
    VERTEX_SHADER2 = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ClarityMaskVertexShader2.dat");
    FRAGMENT_SHADER2 = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ClarityMaskFragmentShader2.dat");
    AppMethodBeat.o(82113);
  }
  
  public ClarityMaskFilter()
  {
    super(VERTEX_SHADER2, FRAGMENT_SHADER2);
    AppMethodBeat.i(82109);
    initParams();
    AppMethodBeat.o(82109);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82110);
    addParam(new m.f("sharpFactor", 0.12F));
    addParam(new m.f("texelWidthOffset", 0.001388889F));
    addParam(new m.f("texelHeightOffset", 0.00078125F));
    AppMethodBeat.o(82110);
  }
  
  public void updateFactor(float paramFloat)
  {
    AppMethodBeat.i(82112);
    addParam(new m.f("sharpFactor", 0.12F * paramFloat));
    AppMethodBeat.o(82112);
  }
  
  public void updateSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82111);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      addParam(new m.f("texelWidthOffset", 1.0F / paramInt1));
      addParam(new m.f("texelHeightOffset", 1.0F / paramInt2));
    }
    AppMethodBeat.o(82111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.ClarityMaskFilter
 * JD-Core Version:    0.7.0.1
 */