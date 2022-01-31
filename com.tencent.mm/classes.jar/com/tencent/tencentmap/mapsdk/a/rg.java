package com.tencent.tencentmap.mapsdk.a;

import android.os.Environment;
import java.io.File;

public class rg
{
  public static boolean a = false;
  public static final String b = a() + "/js/nicolas/xkun/dynamic_map";
  
  public static String a()
  {
    File localFile = Environment.getExternalStorageDirectory();
    String str = "/sdcard";
    if (localFile != null) {
      str = localFile.getPath();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rg
 * JD-Core Version:    0.7.0.1
 */