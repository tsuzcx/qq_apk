package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.mm.compatible.util.e;

public final class b
{
  public static final String OBJECT_ROOT_DIR_PATH;
  public static boolean rQh = false;
  
  static
  {
    String str2 = e.bkH;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    OBJECT_ROOT_DIR_PATH = str1 + "wepkg/pkgfiles/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.b
 * JD-Core Version:    0.7.0.1
 */