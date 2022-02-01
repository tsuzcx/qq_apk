package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class d$a
{
  public static final HashMap<String, Long> BNg;
  
  static
  {
    AppMethodBeat.i(133666);
    HashMap localHashMap = new HashMap();
    BNg = localHashMap;
    localHashMap.put("doc", Long.valueOf(64L));
    BNg.put("docx", Long.valueOf(128L));
    BNg.put("ppt", Long.valueOf(256L));
    BNg.put("pptx", Long.valueOf(512L));
    BNg.put("xls", Long.valueOf(1024L));
    BNg.put("xlsx", Long.valueOf(2048L));
    BNg.put("pdf", Long.valueOf(4096L));
    BNg.put("1", Long.valueOf(1L));
    BNg.put("3", Long.valueOf(2L));
    BNg.put("48", Long.valueOf(4L));
    BNg.put("43", Long.valueOf(8L));
    BNg.put("mp3", Long.valueOf(16L));
    BNg.put("wav", Long.valueOf(16L));
    BNg.put("wma", Long.valueOf(16L));
    BNg.put("avi", Long.valueOf(8L));
    BNg.put("rmvb", Long.valueOf(8L));
    BNg.put("rm", Long.valueOf(8L));
    BNg.put("mpg", Long.valueOf(8L));
    BNg.put("mpeg", Long.valueOf(8L));
    BNg.put("wmv", Long.valueOf(8L));
    BNg.put("mp4", Long.valueOf(8L));
    BNg.put("mkv", Long.valueOf(8L));
    AppMethodBeat.o(133666);
  }
  
  public static Long aAn(String paramString)
  {
    AppMethodBeat.i(133665);
    if (paramString == null)
    {
      AppMethodBeat.o(133665);
      return null;
    }
    paramString = (Long)BNg.get(paramString.toLowerCase());
    AppMethodBeat.o(133665);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a
 * JD-Core Version:    0.7.0.1
 */