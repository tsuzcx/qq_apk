package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import org.xwalk.core.Log;

public class BSpatch
{
  static
  {
    AppMethodBeat.i(4000);
    k.a("bspatch_utils", BSpatch.class.getClassLoader());
    AppMethodBeat.o(4000);
  }
  
  public static int aK(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(3999);
    Log.i("BSpatch", "doPatch oldFile:" + paramString1 + ",patchFile:" + paramString2 + ",newFile:" + paramString3);
    long l = System.currentTimeMillis();
    f.dZw();
    int i = 0;
    String str = paramString3;
    if (paramString1.equals(paramString3))
    {
      str = paramString1 + ".temp";
      i = 1;
    }
    int j = new BSpatch().nativeDoPatch(paramString1, paramString2, str);
    if (j < 0)
    {
      Log.i("BSpatch", "doPatch failed");
      f.dZx();
    }
    for (;;)
    {
      AppMethodBeat.o(3999);
      return j;
      Log.i("BSpatch", "doPatch successful");
      if (i != 0)
      {
        if (!b.copyFile(str, paramString1))
        {
          Log.e("BSpatch", "doPatch same path, copy failed");
          AppMethodBeat.o(3999);
          return -1;
        }
        b.deleteFile(str);
      }
      f.pm(System.currentTimeMillis() - l);
    }
  }
  
  public native int nativeDoPatch(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.util.BSpatch
 * JD-Core Version:    0.7.0.1
 */