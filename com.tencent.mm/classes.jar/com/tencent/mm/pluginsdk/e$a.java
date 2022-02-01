package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class e$a
{
  public static final HashMap<String, Long> EJm;
  
  static
  {
    AppMethodBeat.i(133666);
    HashMap localHashMap = new HashMap();
    EJm = localHashMap;
    localHashMap.put("doc", Long.valueOf(64L));
    EJm.put("docx", Long.valueOf(128L));
    EJm.put("ppt", Long.valueOf(256L));
    EJm.put("pptx", Long.valueOf(512L));
    EJm.put("xls", Long.valueOf(1024L));
    EJm.put("xlsx", Long.valueOf(2048L));
    EJm.put("pdf", Long.valueOf(4096L));
    EJm.put("1", Long.valueOf(1L));
    EJm.put("3", Long.valueOf(2L));
    EJm.put("48", Long.valueOf(4L));
    EJm.put("43", Long.valueOf(8L));
    EJm.put("mp3", Long.valueOf(16L));
    EJm.put("wav", Long.valueOf(16L));
    EJm.put("wma", Long.valueOf(16L));
    EJm.put("avi", Long.valueOf(8L));
    EJm.put("rmvb", Long.valueOf(8L));
    EJm.put("rm", Long.valueOf(8L));
    EJm.put("mpg", Long.valueOf(8L));
    EJm.put("mpeg", Long.valueOf(8L));
    EJm.put("wmv", Long.valueOf(8L));
    EJm.put("mp4", Long.valueOf(8L));
    EJm.put("mkv", Long.valueOf(8L));
    AppMethodBeat.o(133666);
  }
  
  public static Long aLf(String paramString)
  {
    AppMethodBeat.i(133665);
    if (paramString == null)
    {
      AppMethodBeat.o(133665);
      return null;
    }
    paramString = (Long)EJm.get(paramString.toLowerCase());
    AppMethodBeat.o(133665);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.a
 * JD-Core Version:    0.7.0.1
 */