package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.a;
import com.tencent.mm.plugin.j.a.b;
import java.util.HashMap;

public final class f
{
  private static HashMap<String, Integer> QRP = null;
  
  public static int boX(String paramString)
  {
    AppMethodBeat.i(133670);
    if (QRP == null)
    {
      HashMap localHashMap = new HashMap();
      QRP = localHashMap;
      localHashMap.put("avi", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("m4v", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("vob", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("mpeg", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("mpe", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("asx", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("asf", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("f4v", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("flv", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("mkv", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("wmv", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("wm", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("3gp", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("mp4", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("rmvb", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("rm", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("ra", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("ram", Integer.valueOf(a.b.app_attach_file_icon_video));
      QRP.put("mp3pro", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("vqf", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("cd", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("md", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("mod", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("vorbis", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("au", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("amr", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("silk", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("wma", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("mmf", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("mid", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("midi", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("mp3", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("aac", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("ape", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("aiff", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("aif", Integer.valueOf(a.b.app_attach_file_icon_music));
      QRP.put("jfif", Integer.valueOf(a.a.app_attach_file_icon_pic));
      QRP.put("tiff", Integer.valueOf(a.a.app_attach_file_icon_pic));
      QRP.put("tif", Integer.valueOf(a.a.app_attach_file_icon_pic));
      QRP.put("jpe", Integer.valueOf(a.a.app_attach_file_icon_pic));
      QRP.put("dib", Integer.valueOf(a.a.app_attach_file_icon_pic));
      QRP.put("jpeg", Integer.valueOf(a.a.app_attach_file_icon_pic));
      QRP.put("jpg", Integer.valueOf(a.a.app_attach_file_icon_pic));
      QRP.put("png", Integer.valueOf(a.a.app_attach_file_icon_pic));
      QRP.put("bmp", Integer.valueOf(a.a.app_attach_file_icon_pic));
      QRP.put("gif", Integer.valueOf(a.a.app_attach_file_icon_pic));
      QRP.put("rar", Integer.valueOf(a.b.app_attach_file_icon_rar));
      QRP.put("zip", Integer.valueOf(a.b.app_attach_file_icon_rar));
      QRP.put("7z", Integer.valueOf(a.b.app_attach_file_icon_rar));
      QRP.put("iso", Integer.valueOf(a.b.app_attach_file_icon_rar));
      QRP.put("cab", Integer.valueOf(a.b.app_attach_file_icon_rar));
      QRP.put("doc", Integer.valueOf(a.b.app_attach_file_icon_word));
      QRP.put("docx", Integer.valueOf(a.b.app_attach_file_icon_word));
      QRP.put("ppt", Integer.valueOf(a.b.app_attach_file_icon_ppt));
      QRP.put("pptx", Integer.valueOf(a.b.app_attach_file_icon_ppt));
      QRP.put("xls", Integer.valueOf(a.b.app_attach_file_icon_excel));
      QRP.put("xlsx", Integer.valueOf(a.b.app_attach_file_icon_excel));
      QRP.put("txt", Integer.valueOf(a.b.app_attach_file_icon_txt));
      QRP.put("rtf", Integer.valueOf(a.b.app_attach_file_icon_txt));
      QRP.put("pdf", Integer.valueOf(a.b.app_attach_file_icon_pdf));
    }
    paramString = (Integer)QRP.get(paramString);
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
  
  public static int hfL()
  {
    return a.b.app_attach_file_icon_unknow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f
 * JD-Core Version:    0.7.0.1
 */