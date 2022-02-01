package com.tencent.mm.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class e$e
  implements Runnable
{
  public static final e YKB;
  
  static
  {
    AppMethodBeat.i(195191);
    YKB = new e();
    AppMethodBeat.o(195191);
  }
  
  public final void run()
  {
    AppMethodBeat.i(195185);
    Object localObject2 = (Map)f.igX();
    Object localObject1 = new LinkedHashMap();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (((g)localEntry.getValue()).YKT) {
        ((LinkedHashMap)localObject1).put(localEntry.getKey(), localEntry.getValue());
      }
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      f.igX().remove(((Map.Entry)localObject2).getKey());
    }
    AppMethodBeat.o(195185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.e.e
 * JD-Core Version:    0.7.0.1
 */