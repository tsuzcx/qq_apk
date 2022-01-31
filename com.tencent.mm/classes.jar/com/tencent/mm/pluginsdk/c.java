package com.tencent.mm.pluginsdk;

import com.tencent.mm.plugin.j.a.a;
import com.tencent.mm.plugin.j.a.b;
import java.util.HashMap;

public final class c
{
  private static HashMap<String, Integer> rSw = null;
  
  public static int Vy(String paramString)
  {
    if (rSw == null)
    {
      HashMap localHashMap = new HashMap();
      rSw = localHashMap;
      localHashMap.put("avi", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("m4v", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("vob", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("mpeg", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("mpe", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("asx", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("asf", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("f4v", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("flv", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("mkv", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("wmv", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("wm", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("3gp", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("mp4", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("rmvb", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("rm", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("ra", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("ram", Integer.valueOf(a.b.app_attach_file_icon_video));
      rSw.put("mp3pro", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("vqf", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("cd", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("md", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("mod", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("vorbis", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("au", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("amr", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("silk", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("wma", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("mmf", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("mid", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("midi", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("mp3", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("aac", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("ape", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("aiff", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("aif", Integer.valueOf(a.b.app_attach_file_icon_music));
      rSw.put("jfif", Integer.valueOf(a.a.app_attach_file_icon_pic));
      rSw.put("tiff", Integer.valueOf(a.a.app_attach_file_icon_pic));
      rSw.put("tif", Integer.valueOf(a.a.app_attach_file_icon_pic));
      rSw.put("jpe", Integer.valueOf(a.a.app_attach_file_icon_pic));
      rSw.put("dib", Integer.valueOf(a.a.app_attach_file_icon_pic));
      rSw.put("jpeg", Integer.valueOf(a.a.app_attach_file_icon_pic));
      rSw.put("jpg", Integer.valueOf(a.a.app_attach_file_icon_pic));
      rSw.put("png", Integer.valueOf(a.a.app_attach_file_icon_pic));
      rSw.put("bmp", Integer.valueOf(a.a.app_attach_file_icon_pic));
      rSw.put("gif", Integer.valueOf(a.a.app_attach_file_icon_pic));
      rSw.put("rar", Integer.valueOf(a.b.app_attach_file_icon_rar));
      rSw.put("zip", Integer.valueOf(a.b.app_attach_file_icon_rar));
      rSw.put("7z", Integer.valueOf(a.b.app_attach_file_icon_rar));
      rSw.put("iso", Integer.valueOf(a.b.app_attach_file_icon_rar));
      rSw.put("cab", Integer.valueOf(a.b.app_attach_file_icon_rar));
      rSw.put("doc", Integer.valueOf(a.b.app_attach_file_icon_word));
      rSw.put("docx", Integer.valueOf(a.b.app_attach_file_icon_word));
      rSw.put("ppt", Integer.valueOf(a.b.app_attach_file_icon_ppt));
      rSw.put("pptx", Integer.valueOf(a.b.app_attach_file_icon_ppt));
      rSw.put("xls", Integer.valueOf(a.b.app_attach_file_icon_excel));
      rSw.put("xlsx", Integer.valueOf(a.b.app_attach_file_icon_excel));
      rSw.put("txt", Integer.valueOf(a.b.app_attach_file_icon_txt));
      rSw.put("rtf", Integer.valueOf(a.b.app_attach_file_icon_txt));
      rSw.put("pdf", Integer.valueOf(a.b.app_attach_file_icon_pdf));
    }
    paramString = (Integer)rSw.get(paramString);
    if (paramString == null) {
      return a.b.app_attach_file_icon_unknow;
    }
    return paramString.intValue();
  }
  
  public static int ckk()
  {
    return a.b.app_attach_file_icon_unknow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c
 * JD-Core Version:    0.7.0.1
 */