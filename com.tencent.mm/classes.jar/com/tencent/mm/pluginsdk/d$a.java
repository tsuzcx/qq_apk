package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class d$a
{
  public static final HashMap<String, Long> Dfq;
  
  static
  {
    AppMethodBeat.i(133666);
    HashMap localHashMap = new HashMap();
    Dfq = localHashMap;
    localHashMap.put("doc", Long.valueOf(64L));
    Dfq.put("docx", Long.valueOf(128L));
    Dfq.put("ppt", Long.valueOf(256L));
    Dfq.put("pptx", Long.valueOf(512L));
    Dfq.put("xls", Long.valueOf(1024L));
    Dfq.put("xlsx", Long.valueOf(2048L));
    Dfq.put("pdf", Long.valueOf(4096L));
    Dfq.put("1", Long.valueOf(1L));
    Dfq.put("3", Long.valueOf(2L));
    Dfq.put("48", Long.valueOf(4L));
    Dfq.put("43", Long.valueOf(8L));
    Dfq.put("mp3", Long.valueOf(16L));
    Dfq.put("wav", Long.valueOf(16L));
    Dfq.put("wma", Long.valueOf(16L));
    Dfq.put("avi", Long.valueOf(8L));
    Dfq.put("rmvb", Long.valueOf(8L));
    Dfq.put("rm", Long.valueOf(8L));
    Dfq.put("mpg", Long.valueOf(8L));
    Dfq.put("mpeg", Long.valueOf(8L));
    Dfq.put("wmv", Long.valueOf(8L));
    Dfq.put("mp4", Long.valueOf(8L));
    Dfq.put("mkv", Long.valueOf(8L));
    AppMethodBeat.o(133666);
  }
  
  public static Long aFF(String paramString)
  {
    AppMethodBeat.i(133665);
    if (paramString == null)
    {
      AppMethodBeat.o(133665);
      return null;
    }
    paramString = (Long)Dfq.get(paramString.toLowerCase());
    AppMethodBeat.o(133665);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a
 * JD-Core Version:    0.7.0.1
 */