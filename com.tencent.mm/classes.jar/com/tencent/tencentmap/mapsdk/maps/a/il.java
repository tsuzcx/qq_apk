package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class il
{
  private static String[] a = new String[0];
  
  public static boolean a()
  {
    AppMethodBeat.i(148547);
    String str = Build.MODEL;
    int j = a.length;
    int i = 0;
    while (i < j)
    {
      if (str.equalsIgnoreCase(a[i]))
      {
        AppMethodBeat.o(148547);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(148547);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.il
 * JD-Core Version:    0.7.0.1
 */