package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.VideoMaterial;

public class VideoSDKMaterialParser
{
  private static final DecryptListener decryptListener;
  
  static
  {
    AppMethodBeat.i(84223);
    decryptListener = new VideoSDKMaterialParser.1();
    AppMethodBeat.o(84223);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2)
  {
    AppMethodBeat.i(84222);
    paramString1 = VideoTemplateParser.parseVideoMaterial(paramString1, paramString2, true, decryptListener);
    AppMethodBeat.o(84222);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoSDKMaterialParser
 * JD-Core Version:    0.7.0.1
 */