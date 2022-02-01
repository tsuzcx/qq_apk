package com.tencent.mm.pluginsdk.res.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class q
{
  private static final HashMap<Integer, g> XWX;
  private static volatile List<g> XWY;
  
  static
  {
    AppMethodBeat.i(152069);
    HashMap localHashMap = new HashMap(1);
    XWX = localHashMap;
    localHashMap.put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new b.a());
    XWY = null;
    AppMethodBeat.o(152069);
  }
  
  public static Collection<g> iJL()
  {
    AppMethodBeat.i(152068);
    if (XWY != null)
    {
      localObject = XWY;
      AppMethodBeat.o(152068);
      return localObject;
    }
    Object localObject = new LinkedList();
    Iterator localIterator = XWX.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      g localg = (g)XWX.get(Integer.valueOf(i));
      if (localg != null) {
        ((LinkedList)localObject).add(localg);
      }
    }
    XWY = (List)localObject;
    AppMethodBeat.o(152068);
    return localObject;
  }
  
  public static void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.model.q
 * JD-Core Version:    0.7.0.1
 */