package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.o;
import com.tencent.xweb.o.a;
import org.xwalk.core.Log;

public class BSpatch
{
  static
  {
    AppMethodBeat.i(156988);
    BSpatch.class.getClassLoader();
    if (o.IMN != null)
    {
      o.IMN.pq("bspatch_utils");
      AppMethodBeat.o(156988);
      return;
    }
    System.loadLibrary("bspatch_utils");
    AppMethodBeat.o(156988);
  }
  
  public static int aY(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156987);
    Log.i("BSpatch", "doPatch oldFile:" + paramString1 + ",patchFile:" + paramString2 + ",newFile:" + paramString3);
    long l = System.currentTimeMillis();
    g.fsz();
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
      g.fsA();
    }
    for (;;)
    {
      AppMethodBeat.o(156987);
      return j;
      Log.i("BSpatch", "doPatch successful");
      if (i != 0)
      {
        if (!c.kP(str, paramString1))
        {
          Log.e("BSpatch", "doPatch same path, copy failed");
          AppMethodBeat.o(156987);
          return -1;
        }
        c.deleteFile(str);
      }
      g.xz(System.currentTimeMillis() - l);
    }
  }
  
  public native int nativeDoPatch(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.util.BSpatch
 * JD-Core Version:    0.7.0.1
 */