package com.tencent.mm.pluginsdk.h.a.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.a.a.b.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public final class r
{
  private static final HashMap<Integer, g> BTI;
  private static volatile List<g> BTJ;
  
  static
  {
    AppMethodBeat.i(152069);
    HashMap localHashMap = new HashMap(1);
    BTI = localHashMap;
    localHashMap.put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new b.a());
    BTJ = null;
    AppMethodBeat.o(152069);
  }
  
  public static Collection<g> ewM()
  {
    AppMethodBeat.i(152068);
    if (BTJ != null)
    {
      localObject = BTJ;
      AppMethodBeat.o(152068);
      return localObject;
    }
    Object localObject = new LinkedList();
    Iterator localIterator = BTI.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      g localg = (g)BTI.get(Integer.valueOf(i));
      if (localg != null) {
        ((LinkedList)localObject).add(localg);
      }
    }
    BTJ = (List)localObject;
    AppMethodBeat.o(152068);
    return localObject;
  }
  
  public static void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.r
 * JD-Core Version:    0.7.0.1
 */