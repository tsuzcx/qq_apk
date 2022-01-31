package com.tencent.ttpic.util;

import android.content.Context;
import java.io.File;

final class VideoFileUtil$2
  implements VideoFileUtil.AssetFileComparator
{
  public final boolean equals(Context paramContext, String paramString, File paramFile)
  {
    long l = VideoFileUtil.getAssetLength(paramContext, paramString);
    return (l != -1L) && (l == paramFile.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoFileUtil.2
 * JD-Core Version:    0.7.0.1
 */