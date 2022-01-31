package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;

final class VideoMaterialUtil$4
  implements FilenameFilter
{
  public final boolean accept(File paramFile, String paramString)
  {
    AppMethodBeat.i(84053);
    boolean bool = paramString.endsWith(".mp4");
    AppMethodBeat.o(84053);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.4
 * JD-Core Version:    0.7.0.1
 */