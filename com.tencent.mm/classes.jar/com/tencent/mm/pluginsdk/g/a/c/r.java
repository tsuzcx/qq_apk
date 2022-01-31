package com.tencent.mm.pluginsdk.g.a.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.a.b.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public final class r
{
  private static final HashMap<Integer, g> vOI;
  private static volatile List<g> vOJ;
  
  static
  {
    AppMethodBeat.i(79626);
    HashMap localHashMap = new HashMap(1);
    vOI = localHashMap;
    localHashMap.put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new b.a());
    vOJ = null;
    AppMethodBeat.o(79626);
  }
  
  public static Collection<g> dmA()
  {
    AppMethodBeat.i(79625);
    if (vOJ != null)
    {
      localObject = vOJ;
      AppMethodBeat.o(79625);
      return localObject;
    }
    Object localObject = new LinkedList();
    Iterator localIterator = vOI.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      g localg = (g)vOI.get(Integer.valueOf(i));
      if (localg != null) {
        ((LinkedList)localObject).add(localg);
      }
    }
    vOJ = (List)localObject;
    AppMethodBeat.o(79625);
    return localObject;
  }
  
  public static void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.r
 * JD-Core Version:    0.7.0.1
 */