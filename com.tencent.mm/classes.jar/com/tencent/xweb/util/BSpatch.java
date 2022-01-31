package com.tencent.xweb.util;

import com.tencent.mm.compatible.util.k;
import org.xwalk.core.Log;

public class BSpatch
{
  static
  {
    k.b("bspatch_utils", BSpatch.class.getClassLoader());
  }
  
  public static int at(String paramString1, String paramString2, String paramString3)
  {
    Log.i("BSpatch", "doPatch oldFile:" + paramString1 + ",patchFile:" + paramString2 + ",newFile:" + paramString3);
    long l = System.currentTimeMillis();
    e.cTg();
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
      e.cTh();
    }
    for (;;)
    {
      return j;
      Log.i("BSpatch", "doPatch successful");
      if (i != 0)
      {
        if (!a.copyFile(str, paramString1))
        {
          Log.e("BSpatch", "doPatch same path, copy failed");
          return -1;
        }
        a.deleteFile(str);
      }
      e.iA(System.currentTimeMillis() - l);
    }
  }
  
  public native int nativeDoPatch(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.util.BSpatch
 * JD-Core Version:    0.7.0.1
 */