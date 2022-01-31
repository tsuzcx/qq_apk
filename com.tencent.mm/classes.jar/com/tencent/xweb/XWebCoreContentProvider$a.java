package com.tencent.xweb;

import com.tencent.xweb.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;

public final class XWebCoreContentProvider$a
{
  private static List<XWebCoreContentProvider.b> xhs = new ArrayList();
  private static final Object xht = new Object();
  
  public static void a(XWebCoreContentProvider.b paramb)
  {
    synchronized (xht)
    {
      xhs.add(paramb);
      return;
    }
  }
  
  public static void cSx()
  {
    if (xhs.size() == 0) {
      return;
    }
    Log.i("XWebCoreContentProvider", "CachedInfoMgr process cached info");
    synchronized (xht)
    {
      Iterator localIterator = xhs.iterator();
      if (localIterator.hasNext())
      {
        XWebCoreContentProvider.b localb = (XWebCoreContentProvider.b)localIterator.next();
        e.bp(localb.key, localb.value);
      }
    }
    xhs.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.XWebCoreContentProvider.a
 * JD-Core Version:    0.7.0.1
 */