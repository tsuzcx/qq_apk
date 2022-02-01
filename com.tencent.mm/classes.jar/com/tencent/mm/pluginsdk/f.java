package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.a;
import com.tencent.mm.plugin.j.a.b;
import java.util.HashMap;

public final class f
{
  private static HashMap<String, Integer> XND = null;
  
  public static int boR(String paramString)
  {
    AppMethodBeat.i(133670);
    if (XND == null)
    {
      HashMap localHashMap = new HashMap();
      XND = localHashMap;
      localHashMap.put("avi", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("m4v", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("vob", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("mpeg", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("mpe", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("asx", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("asf", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("f4v", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("flv", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("mkv", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("wmv", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("wm", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("3gp", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("mp4", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("rmvb", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("rm", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("ra", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("ram", Integer.valueOf(a.b.app_attach_file_icon_video));
      XND.put("mp3pro", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("vqf", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("cd", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("md", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("mod", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("vorbis", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("au", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("amr", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("silk", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("wma", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("mmf", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("mid", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("midi", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("mp3", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("aac", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("ape", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("aiff", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("aif", Integer.valueOf(a.b.app_attach_file_icon_music));
      XND.put("jfif", Integer.valueOf(a.a.app_attach_file_icon_pic));
      XND.put("tiff", Integer.valueOf(a.a.app_attach_file_icon_pic));
      XND.put("tif", Integer.valueOf(a.a.app_attach_file_icon_pic));
      XND.put("jpe", Integer.valueOf(a.a.app_attach_file_icon_pic));
      XND.put("dib", Integer.valueOf(a.a.app_attach_file_icon_pic));
      XND.put("jpeg", Integer.valueOf(a.a.app_attach_file_icon_pic));
      XND.put("jpg", Integer.valueOf(a.a.app_attach_file_icon_pic));
      XND.put("png", Integer.valueOf(a.a.app_attach_file_icon_pic));
      XND.put("bmp", Integer.valueOf(a.a.app_attach_file_icon_pic));
      XND.put("gif", Integer.valueOf(a.a.app_attach_file_icon_pic));
      XND.put("rar", Integer.valueOf(a.b.app_attach_file_icon_rar));
      XND.put("zip", Integer.valueOf(a.b.app_attach_file_icon_rar));
      XND.put("7z", Integer.valueOf(a.b.app_attach_file_icon_rar));
      XND.put("iso", Integer.valueOf(a.b.app_attach_file_icon_rar));
      XND.put("cab", Integer.valueOf(a.b.app_attach_file_icon_rar));
      XND.put("doc", Integer.valueOf(a.b.app_attach_file_icon_word));
      XND.put("docx", Integer.valueOf(a.b.app_attach_file_icon_word));
      XND.put("ppt", Integer.valueOf(a.b.app_attach_file_icon_ppt));
      XND.put("pptx", Integer.valueOf(a.b.app_attach_file_icon_ppt));
      XND.put("xls", Integer.valueOf(a.b.app_attach_file_icon_excel));
      XND.put("xlsx", Integer.valueOf(a.b.app_attach_file_icon_excel));
      XND.put("txt", Integer.valueOf(a.b.app_attach_file_icon_txt));
      XND.put("rtf", Integer.valueOf(a.b.app_attach_file_icon_txt));
      XND.put("pdf", Integer.valueOf(a.b.app_attach_file_icon_pdf));
      XND.put("ofd", Integer.valueOf(a.b.app_attach_file_icon_ofd));
    }
    paramString = (Integer)XND.get(paramString);
    if (paramString == null)
    {
      i = a.b.app_attach_file_icon_unknow;
      AppMethodBeat.o(133670);
      return i;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(133670);
    return i;
  }
  
  public static int iGF()
  {
    return a.b.app_attach_file_icon_unknow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f
 * JD-Core Version:    0.7.0.1
 */