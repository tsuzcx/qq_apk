package com.tencent.ttpic.util;

import java.io.File;
import java.io.FilenameFilter;

final class VideoMaterialUtil$2
  implements FilenameFilter
{
  public final boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".mp4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.2
 * JD-Core Version:    0.7.0.1
 */