package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class e$a
{
  public static final HashMap<String, Long> XNx;
  
  static
  {
    AppMethodBeat.i(133666);
    HashMap localHashMap = new HashMap();
    XNx = localHashMap;
    localHashMap.put("doc", Long.valueOf(64L));
    XNx.put("docx", Long.valueOf(128L));
    XNx.put("ppt", Long.valueOf(256L));
    XNx.put("pptx", Long.valueOf(512L));
    XNx.put("xls", Long.valueOf(1024L));
    XNx.put("xlsx", Long.valueOf(2048L));
    XNx.put("pdf", Long.valueOf(4096L));
    XNx.put("1", Long.valueOf(1L));
    XNx.put("3", Long.valueOf(2L));
    XNx.put("48", Long.valueOf(4L));
    XNx.put("43", Long.valueOf(8L));
    XNx.put("mp3", Long.valueOf(16L));
    XNx.put("wav", Long.valueOf(16L));
    XNx.put("wma", Long.valueOf(16L));
    XNx.put("avi", Long.valueOf(8L));
    XNx.put("rmvb", Long.valueOf(8L));
    XNx.put("rm", Long.valueOf(8L));
    XNx.put("mpg", Long.valueOf(8L));
    XNx.put("mpeg", Long.valueOf(8L));
    XNx.put("wmv", Long.valueOf(8L));
    XNx.put("mp4", Long.valueOf(8L));
    XNx.put("mkv", Long.valueOf(8L));
    AppMethodBeat.o(133666);
  }
  
  public static Long boO(String paramString)
  {
    AppMethodBeat.i(133665);
    if (paramString == null)
    {
      AppMethodBeat.o(133665);
      return null;
    }
    paramString = (Long)XNx.get(paramString.toLowerCase());
    AppMethodBeat.o(133665);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.a
 * JD-Core Version:    0.7.0.1
 */