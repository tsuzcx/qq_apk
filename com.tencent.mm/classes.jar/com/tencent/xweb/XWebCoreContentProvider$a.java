package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;

public final class XWebCoreContentProvider$a
{
  private static List<XWebCoreContentProvider.b> BEv;
  private static final Object BEw;
  
  static
  {
    AppMethodBeat.i(3946);
    BEv = new ArrayList();
    BEw = new Object();
    AppMethodBeat.o(3946);
  }
  
  public static void a(XWebCoreContentProvider.b paramb)
  {
    AppMethodBeat.i(3944);
    synchronized (BEw)
    {
      BEv.add(paramb);
      AppMethodBeat.o(3944);
      return;
    }
  }
  
  public static void dYD()
  {
    AppMethodBeat.i(3945);
    Log.i("XWebCoreContentProvider", "CachedInfoMgr process cached info");
    synchronized (BEw)
    {
      Iterator localIterator = BEv.iterator();
      if (localIterator.hasNext())
      {
        XWebCoreContentProvider.b localb = (XWebCoreContentProvider.b)localIterator.next();
        f.bW(localb.key, localb.value);
      }
    }
    BEv.clear();
    AppMethodBeat.o(3945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.XWebCoreContentProvider.a
 * JD-Core Version:    0.7.0.1
 */