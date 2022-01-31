package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;

class VideoMaterialDecoder$1
  implements FilenameFilter
{
  VideoMaterialDecoder$1(VideoMaterialDecoder paramVideoMaterialDecoder) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    AppMethodBeat.i(84044);
    boolean bool = paramString.endsWith(".mp4");
    AppMethodBeat.o(84044);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialDecoder.1
 * JD-Core Version:    0.7.0.1
 */