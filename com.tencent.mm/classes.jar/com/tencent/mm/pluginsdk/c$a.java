package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class c$a
{
  public static final HashMap<String, Long> vJp;
  
  static
  {
    AppMethodBeat.i(114653);
    HashMap localHashMap = new HashMap();
    vJp = localHashMap;
    localHashMap.put("doc", Long.valueOf(64L));
    vJp.put("docx", Long.valueOf(128L));
    vJp.put("ppt", Long.valueOf(256L));
    vJp.put("pptx", Long.valueOf(512L));
    vJp.put("xls", Long.valueOf(1024L));
    vJp.put("xlsx", Long.valueOf(2048L));
    vJp.put("pdf", Long.valueOf(4096L));
    vJp.put("1", Long.valueOf(1L));
    vJp.put("3", Long.valueOf(2L));
    vJp.put("48", Long.valueOf(4L));
    vJp.put("43", Long.valueOf(8L));
    vJp.put("mp3", Long.valueOf(16L));
    vJp.put("wav", Long.valueOf(16L));
    vJp.put("wma", Long.valueOf(16L));
    vJp.put("avi", Long.valueOf(8L));
    vJp.put("rmvb", Long.valueOf(8L));
    vJp.put("rm", Long.valueOf(8L));
    vJp.put("mpg", Long.valueOf(8L));
    vJp.put("mpeg", Long.valueOf(8L));
    vJp.put("wmv", Long.valueOf(8L));
    vJp.put("mp4", Long.valueOf(8L));
    vJp.put("mkv", Long.valueOf(8L));
    AppMethodBeat.o(114653);
  }
  
  public static Long akT(String paramString)
  {
    AppMethodBeat.i(114652);
    if (paramString == null)
    {
      AppMethodBeat.o(114652);
      return null;
    }
    paramString = (Long)vJp.get(paramString.toLowerCase());
    AppMethodBeat.o(114652);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.a
 * JD-Core Version:    0.7.0.1
 */