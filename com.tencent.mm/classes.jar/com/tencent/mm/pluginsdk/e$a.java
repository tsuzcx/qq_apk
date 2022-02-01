package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class e$a
{
  public static final HashMap<String, Long> FbK;
  
  static
  {
    AppMethodBeat.i(133666);
    HashMap localHashMap = new HashMap();
    FbK = localHashMap;
    localHashMap.put("doc", Long.valueOf(64L));
    FbK.put("docx", Long.valueOf(128L));
    FbK.put("ppt", Long.valueOf(256L));
    FbK.put("pptx", Long.valueOf(512L));
    FbK.put("xls", Long.valueOf(1024L));
    FbK.put("xlsx", Long.valueOf(2048L));
    FbK.put("pdf", Long.valueOf(4096L));
    FbK.put("1", Long.valueOf(1L));
    FbK.put("3", Long.valueOf(2L));
    FbK.put("48", Long.valueOf(4L));
    FbK.put("43", Long.valueOf(8L));
    FbK.put("mp3", Long.valueOf(16L));
    FbK.put("wav", Long.valueOf(16L));
    FbK.put("wma", Long.valueOf(16L));
    FbK.put("avi", Long.valueOf(8L));
    FbK.put("rmvb", Long.valueOf(8L));
    FbK.put("rm", Long.valueOf(8L));
    FbK.put("mpg", Long.valueOf(8L));
    FbK.put("mpeg", Long.valueOf(8L));
    FbK.put("wmv", Long.valueOf(8L));
    FbK.put("mp4", Long.valueOf(8L));
    FbK.put("mkv", Long.valueOf(8L));
    AppMethodBeat.o(133666);
  }
  
  public static Long aMB(String paramString)
  {
    AppMethodBeat.i(133665);
    if (paramString == null)
    {
      AppMethodBeat.o(133665);
      return null;
    }
    paramString = (Long)FbK.get(paramString.toLowerCase());
    AppMethodBeat.o(133665);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.a
 * JD-Core Version:    0.7.0.1
 */