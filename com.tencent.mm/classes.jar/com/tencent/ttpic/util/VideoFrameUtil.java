package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.VideoFilterBase;

public class VideoFrameUtil
{
  public static h renderProcessByCopy(int paramInt1, int paramInt2, int paramInt3, VideoFilterBase paramVideoFilterBase, BaseFilter paramBaseFilter, h paramh1, h paramh2)
  {
    AppMethodBeat.i(84039);
    if (paramh1.texture[0] == paramInt1) {}
    for (;;)
    {
      paramBaseFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramh2);
      paramVideoFilterBase.OnDrawFrameGLSL();
      paramVideoFilterBase.renderTexture(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(84039);
      return paramh2;
      paramh2 = paramh1;
    }
  }
  
  public static h renderProcessBySwitchFbo(int paramInt1, int paramInt2, int paramInt3, VideoFilterBase paramVideoFilterBase, h paramh1, h paramh2)
  {
    AppMethodBeat.i(84038);
    if (paramh1.texture[0] == paramInt1) {}
    for (;;)
    {
      paramVideoFilterBase.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramh2);
      AppMethodBeat.o(84038);
      return paramh2;
      paramh2 = paramh1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoFrameUtil
 * JD-Core Version:    0.7.0.1
 */