package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class d
{
  private static HashMap<String, Integer> vJr = null;
  
  public static int akU(String paramString)
  {
    AppMethodBeat.i(114655);
    if (vJr == null)
    {
      HashMap localHashMap = new HashMap();
      vJr = localHashMap;
      localHashMap.put("avi", Integer.valueOf(2131230826));
      vJr.put("m4v", Integer.valueOf(2131230826));
      vJr.put("vob", Integer.valueOf(2131230826));
      vJr.put("mpeg", Integer.valueOf(2131230826));
      vJr.put("mpe", Integer.valueOf(2131230826));
      vJr.put("asx", Integer.valueOf(2131230826));
      vJr.put("asf", Integer.valueOf(2131230826));
      vJr.put("f4v", Integer.valueOf(2131230826));
      vJr.put("flv", Integer.valueOf(2131230826));
      vJr.put("mkv", Integer.valueOf(2131230826));
      vJr.put("wmv", Integer.valueOf(2131230826));
      vJr.put("wm", Integer.valueOf(2131230826));
      vJr.put("3gp", Integer.valueOf(2131230826));
      vJr.put("mp4", Integer.valueOf(2131230826));
      vJr.put("rmvb", Integer.valueOf(2131230826));
      vJr.put("rm", Integer.valueOf(2131230826));
      vJr.put("ra", Integer.valueOf(2131230826));
      vJr.put("ram", Integer.valueOf(2131230826));
      vJr.put("mp3pro", Integer.valueOf(2131230809));
      vJr.put("vqf", Integer.valueOf(2131230809));
      vJr.put("cd", Integer.valueOf(2131230809));
      vJr.put("md", Integer.valueOf(2131230809));
      vJr.put("mod", Integer.valueOf(2131230809));
      vJr.put("vorbis", Integer.valueOf(2131230809));
      vJr.put("au", Integer.valueOf(2131230809));
      vJr.put("amr", Integer.valueOf(2131230809));
      vJr.put("silk", Integer.valueOf(2131230809));
      vJr.put("wma", Integer.valueOf(2131230809));
      vJr.put("mmf", Integer.valueOf(2131230809));
      vJr.put("mid", Integer.valueOf(2131230809));
      vJr.put("midi", Integer.valueOf(2131230809));
      vJr.put("mp3", Integer.valueOf(2131230809));
      vJr.put("aac", Integer.valueOf(2131230809));
      vJr.put("ape", Integer.valueOf(2131230809));
      vJr.put("aiff", Integer.valueOf(2131230809));
      vJr.put("aif", Integer.valueOf(2131230809));
      vJr.put("jfif", Integer.valueOf(2130837708));
      vJr.put("tiff", Integer.valueOf(2130837708));
      vJr.put("tif", Integer.valueOf(2130837708));
      vJr.put("jpe", Integer.valueOf(2130837708));
      vJr.put("dib", Integer.valueOf(2130837708));
      vJr.put("jpeg", Integer.valueOf(2130837708));
      vJr.put("jpg", Integer.valueOf(2130837708));
      vJr.put("png", Integer.valueOf(2130837708));
      vJr.put("bmp", Integer.valueOf(2130837708));
      vJr.put("gif", Integer.valueOf(2130837708));
      vJr.put("rar", Integer.valueOf(2131230818));
      vJr.put("zip", Integer.valueOf(2131230818));
      vJr.put("7z", Integer.valueOf(2131230818));
      vJr.put("iso", Integer.valueOf(2131230818));
      vJr.put("cab", Integer.valueOf(2131230818));
      vJr.put("doc", Integer.valueOf(2131230830));
      vJr.put("docx", Integer.valueOf(2131230830));
      vJr.put("ppt", Integer.valueOf(2131230816));
      vJr.put("pptx", Integer.valueOf(2131230816));
      vJr.put("xls", Integer.valueOf(2131230802));
      vJr.put("xlsx", Integer.valueOf(2131230802));
      vJr.put("txt", Integer.valueOf(2131230821));
      vJr.put("rtf", Integer.valueOf(2131230821));
      vJr.put("pdf", Integer.valueOf(2131230813));
    }
    paramString = (Integer)vJr.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(114655);
      return 2131230822;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(114655);
    return i;
  }
  
  public static int dkP()
  {
    return 2131230822;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d
 * JD-Core Version:    0.7.0.1
 */