package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;

public class DoubleOutputFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/OrigFragmentShader.dat");
  
  public DoubleOutputFilter()
  {
    super(FRAGMENT_SHADER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.DoubleOutputFilter
 * JD-Core Version:    0.7.0.1
 */