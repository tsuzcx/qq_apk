package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.p.b;
import kotlin.l.b.a.b.e.a.s;

public final class h
{
  private final List<a.p> GjM;
  
  public h(a.s params)
  {
    AppMethodBeat.i(59084);
    Object localObject = params.TzW;
    Collection localCollection;
    if (params.hHI())
    {
      int j = params.TzX;
      params = params.TzW;
      p.g(params, "typeTable.typeList");
      params = (Iterable)params;
      localCollection = (Collection)new ArrayList(j.a(params, 10));
      int i = 0;
      Iterator localIterator = params.iterator();
      while (localIterator.hasNext())
      {
        params = localIterator.next();
        if (i < 0) {
          j.hxH();
        }
        localObject = (a.p)params;
        params = (a.s)localObject;
        if (i >= j) {
          params = ((a.p)localObject).hHf().EH(true).hHn();
        }
        localCollection.add(params);
        i += 1;
      }
    }
    for (params = (List)localCollection;; params = (a.s)localObject)
    {
      this.GjM = params;
      AppMethodBeat.o(59084);
      return;
      p.g(localObject, "originalTypes");
    }
  }
  
  public final a.p avo(int paramInt)
  {
    AppMethodBeat.i(59083);
    a.p localp = (a.p)this.GjM.get(paramInt);
    AppMethodBeat.o(59083);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.h
 * JD-Core Version:    0.7.0.1
 */