package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SmoothBProcessFilter_573
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER;
  public static final String VERTEX_SHADER;
  private float blurAlpha;
  
  static
  {
    AppMethodBeat.i(82904);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothBProcessVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SmoothBProcessFragmentShader2_573.dat");
    AppMethodBeat.o(82904);
  }
  
  public SmoothBProcessFilter_573()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82900);
    this.blurAlpha = 0.5F;
    initParams();
    AppMethodBeat.o(82900);
  }
  
  public float getBlurAlpha()
  {
    return this.blurAlpha;
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82901);
    addParam(new m.f("blurAlpha", this.blurAlpha));
    addParam(new m.n("inputImageTexture2", 0, 33986));
    addParam(new m.n("inputImageTexture3", 0, 33987));
    AppMethodBeat.o(82901);
  }
  
  public void updateBlurAlpha(float paramFloat)
  {
    AppMethodBeat.i(82903);
    this.blurAlpha = paramFloat;
    addParam(new m.f("blurAlpha", paramFloat));
    AppMethodBeat.o(82903);
  }
  
  public void updateTextures(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82902);
    addParam(new m.n("inputImageTexture2", paramInt1, 33986));
    addParam(new m.n("inputImageTexture3", paramInt2, 33987));
    AppMethodBeat.o(82902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.SmoothBProcessFilter_573
 * JD-Core Version:    0.7.0.1
 */