package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class e$a
{
  public static final HashMap<String, Long> QRJ;
  
  static
  {
    AppMethodBeat.i(133666);
    HashMap localHashMap = new HashMap();
    QRJ = localHashMap;
    localHashMap.put("doc", Long.valueOf(64L));
    QRJ.put("docx", Long.valueOf(128L));
    QRJ.put("ppt", Long.valueOf(256L));
    QRJ.put("pptx", Long.valueOf(512L));
    QRJ.put("xls", Long.valueOf(1024L));
    QRJ.put("xlsx", Long.valueOf(2048L));
    QRJ.put("pdf", Long.valueOf(4096L));
    QRJ.put("1", Long.valueOf(1L));
    QRJ.put("3", Long.valueOf(2L));
    QRJ.put("48", Long.valueOf(4L));
    QRJ.put("43", Long.valueOf(8L));
    QRJ.put("mp3", Long.valueOf(16L));
    QRJ.put("wav", Long.valueOf(16L));
    QRJ.put("wma", Long.valueOf(16L));
    QRJ.put("avi", Long.valueOf(8L));
    QRJ.put("rmvb", Long.valueOf(8L));
    QRJ.put("rm", Long.valueOf(8L));
    QRJ.put("mpg", Long.valueOf(8L));
    QRJ.put("mpeg", Long.valueOf(8L));
    QRJ.put("wmv", Long.valueOf(8L));
    QRJ.put("mp4", Long.valueOf(8L));
    QRJ.put("mkv", Long.valueOf(8L));
    AppMethodBeat.o(133666);
  }
  
  public static Long boU(String paramString)
  {
    AppMethodBeat.i(133665);
    if (paramString == null)
    {
      AppMethodBeat.o(133665);
      return null;
    }
    paramString = (Long)QRJ.get(paramString.toLowerCase());
    AppMethodBeat.o(133665);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.a
 * JD-Core Version:    0.7.0.1
 */