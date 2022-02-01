package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class e$a
{
  public static final HashMap<String, Long> JSE;
  
  static
  {
    AppMethodBeat.i(133666);
    HashMap localHashMap = new HashMap();
    JSE = localHashMap;
    localHashMap.put("doc", Long.valueOf(64L));
    JSE.put("docx", Long.valueOf(128L));
    JSE.put("ppt", Long.valueOf(256L));
    JSE.put("pptx", Long.valueOf(512L));
    JSE.put("xls", Long.valueOf(1024L));
    JSE.put("xlsx", Long.valueOf(2048L));
    JSE.put("pdf", Long.valueOf(4096L));
    JSE.put("1", Long.valueOf(1L));
    JSE.put("3", Long.valueOf(2L));
    JSE.put("48", Long.valueOf(4L));
    JSE.put("43", Long.valueOf(8L));
    JSE.put("mp3", Long.valueOf(16L));
    JSE.put("wav", Long.valueOf(16L));
    JSE.put("wma", Long.valueOf(16L));
    JSE.put("avi", Long.valueOf(8L));
    JSE.put("rmvb", Long.valueOf(8L));
    JSE.put("rm", Long.valueOf(8L));
    JSE.put("mpg", Long.valueOf(8L));
    JSE.put("mpeg", Long.valueOf(8L));
    JSE.put("wmv", Long.valueOf(8L));
    JSE.put("mp4", Long.valueOf(8L));
    JSE.put("mkv", Long.valueOf(8L));
    AppMethodBeat.o(133666);
  }
  
  public static Long bcU(String paramString)
  {
    AppMethodBeat.i(133665);
    if (paramString == null)
    {
      AppMethodBeat.o(133665);
      return null;
    }
    paramString = (Long)JSE.get(paramString.toLowerCase());
    AppMethodBeat.o(133665);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.a
 * JD-Core Version:    0.7.0.1
 */