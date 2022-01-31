package com.tencent.tencentmap.mapsdk.a;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class dv
{
  public static boolean a;
  public static final String b;
  
  static
  {
    AppMethodBeat.i(101127);
    a = false;
    b = a() + "/js/nicolas/xkun/dynamic_map";
    AppMethodBeat.o(101127);
  }
  
  public static String a()
  {
    AppMethodBeat.i(150157);
    File localFile = Environment.getExternalStorageDirectory();
    String str = "/sdcard";
    if (localFile != null) {
      str = localFile.getPath();
    }
    AppMethodBeat.o(150157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dv
 * JD-Core Version:    0.7.0.1
 */