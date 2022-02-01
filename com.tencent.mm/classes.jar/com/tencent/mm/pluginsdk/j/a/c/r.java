package com.tencent.mm.pluginsdk.j.a.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.a.b.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public final class r
{
  private static final HashMap<Integer, g> Fjv;
  private static volatile List<g> Fjw;
  
  static
  {
    AppMethodBeat.i(152069);
    HashMap localHashMap = new HashMap(1);
    Fjv = localHashMap;
    localHashMap.put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new b.a());
    Fjw = null;
    AppMethodBeat.o(152069);
  }
  
  public static Collection<g> feR()
  {
    AppMethodBeat.i(152068);
    if (Fjw != null)
    {
      localObject = Fjw;
      AppMethodBeat.o(152068);
      return localObject;
    }
    Object localObject = new LinkedList();
    Iterator localIterator = Fjv.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      g localg = (g)Fjv.get(Integer.valueOf(i));
      if (localg != null) {
        ((LinkedList)localObject).add(localg);
      }
    }
    Fjw = (List)localObject;
    AppMethodBeat.o(152068);
    return localObject;
  }
  
  public static void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.r
 * JD-Core Version:    0.7.0.1
 */