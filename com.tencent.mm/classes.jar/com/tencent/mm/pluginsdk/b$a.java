package com.tencent.mm.pluginsdk;

import java.util.HashMap;

public final class b$a
{
  public static final HashMap<String, Long> rSu;
  
  static
  {
    HashMap localHashMap = new HashMap();
    rSu = localHashMap;
    localHashMap.put("doc", Long.valueOf(64L));
    rSu.put("docx", Long.valueOf(128L));
    rSu.put("ppt", Long.valueOf(256L));
    rSu.put("pptx", Long.valueOf(512L));
    rSu.put("xls", Long.valueOf(1024L));
    rSu.put("xlsx", Long.valueOf(2048L));
    rSu.put("pdf", Long.valueOf(4096L));
    rSu.put("1", Long.valueOf(1L));
    rSu.put("3", Long.valueOf(2L));
    rSu.put("48", Long.valueOf(4L));
    rSu.put("43", Long.valueOf(8L));
    rSu.put("mp3", Long.valueOf(16L));
    rSu.put("wav", Long.valueOf(16L));
    rSu.put("wma", Long.valueOf(16L));
    rSu.put("avi", Long.valueOf(8L));
    rSu.put("rmvb", Long.valueOf(8L));
    rSu.put("rm", Long.valueOf(8L));
    rSu.put("mpg", Long.valueOf(8L));
    rSu.put("mpeg", Long.valueOf(8L));
    rSu.put("wmv", Long.valueOf(8L));
    rSu.put("mp4", Long.valueOf(8L));
    rSu.put("mkv", Long.valueOf(8L));
  }
  
  public static Long Vx(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (Long)rSu.get(paramString.toLowerCase());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.b.a
 * JD-Core Version:    0.7.0.1
 */