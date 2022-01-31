package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;

final class VideoMaterialUtil$3
  implements FilenameFilter
{
  public final boolean accept(File paramFile, String paramString)
  {
    AppMethodBeat.i(84052);
    boolean bool = paramString.endsWith(".png");
    AppMethodBeat.o(84052);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.3
 * JD-Core Version:    0.7.0.1
 */