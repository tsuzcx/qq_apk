package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.r;
import com.tencent.xweb.r.a;
import org.xwalk.core.Log;

public class BSpatch
{
  static
  {
    AppMethodBeat.i(156988);
    BSpatch.class.getClassLoader();
    if (r.aieT != null)
    {
      r.aieT.DA("bspatch_utils");
      AppMethodBeat.o(156988);
      return;
    }
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("bspatch_utils");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/xweb/LibraryLoader", "load", "(Ljava/lang/String;Ljava/lang/ClassLoader;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/xweb/LibraryLoader", "load", "(Ljava/lang/String;Ljava/lang/ClassLoader;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(156988);
  }
  
  public static int bQ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156987);
    Log.i("BSpatch", "doPatch oldFile:" + paramString1 + ",patchFile:" + paramString2 + ",newFile:" + paramString3);
    long l = System.currentTimeMillis();
    l.kiu();
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
      l.kiv();
    }
    for (;;)
    {
      AppMethodBeat.o(156987);
      return j;
      Log.i("BSpatch", "doPatch successful");
      if (i != 0)
      {
        if (!g.copyFile(str, paramString1))
        {
          Log.e("BSpatch", "doPatch same path, copy failed");
          AppMethodBeat.o(156987);
          return -1;
        }
        g.deleteFile(str);
      }
      l.By(System.currentTimeMillis() - l);
    }
  }
  
  public native int nativeDoPatch(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.util.BSpatch
 * JD-Core Version:    0.7.0.1
 */