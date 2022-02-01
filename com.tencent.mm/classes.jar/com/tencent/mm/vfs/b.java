package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.a;
import com.tencent.mm.vfs.a.a.a;
import com.tencent.mm.vfs.a.c;
import com.tencent.mm.vfs.a.c.a;
import com.tencent.mm.vfs.a.e;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class b
{
  private static final String[] YBs;
  private static final String[] YBt;
  private static final Set<String> YBu;
  
  static
  {
    AppMethodBeat.i(194207);
    YBs = new String[] { "avatar", "emoji", "xlog", "xlogPrivate" };
    YBt = new String[] { "cache/org.chromium.xwalk", "cache/org.chromium.android_webview", "cache/com.tencent.mm.xweb" };
    YBu = new HashSet();
    AppMethodBeat.o(194207);
  }
  
  static void bBE(String paramString)
  {
    AppMethodBeat.i(194201);
    if (Arrays.binarySearch(YBs, paramString) >= 0)
    {
      AppMethodBeat.o(194201);
      return;
    }
    synchronized (YBu)
    {
      YBu.add(paramString);
      AppMethodBeat.o(194201);
      return;
    }
  }
  
  public static Iterable<f> ieZ()
  {
    AppMethodBeat.i(194205);
    for (;;)
    {
      synchronized (YBu)
      {
        Object localObject2 = new HashSet(YBu);
        localObject2 = new a((Iterable)localObject2, new a.a() {});
        ??? = h.iWH().iWL().bBL("data-root");
        FileSystem.b localb = new NativeFileSystem("${sdToCache}").cp(h.iWH().iWM());
        a locala = new a(Arrays.asList(YBt), new a.a() {});
        if (??? == null)
        {
          ??? = null;
          ??? = new c(new e(new Iterable[] { localObject2, locala, ???, localb.dJ("", false) }), new c.a()
          {
            final long tick;
          });
          AppMethodBeat.o(194205);
          return ???;
        }
      }
      ??? = ((FileSystem.b)???).dJ("cache", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.b
 * JD-Core Version:    0.7.0.1
 */