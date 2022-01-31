package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class DoubleOutputFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER;
  
  static
  {
    AppMethodBeat.i(82158);
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/OrigFragmentShader.dat");
    AppMethodBeat.o(82158);
  }
  
  public DoubleOutputFilter()
  {
    super(FRAGMENT_SHADER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.filter.DoubleOutputFilter
 * JD-Core Version:    0.7.0.1
 */