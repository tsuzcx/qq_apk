package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.p.b;
import kotlin.l.b.a.b.e.a.s;

public final class g
{
  private final List<a.p> TJb;
  
  public g(a.s params)
  {
    AppMethodBeat.i(59084);
    Object localObject = params.ajbo;
    if (params.kwx())
    {
      int j = params.ajbp;
      params = params.ajbo;
      s.s(params, "typeTable.typeList");
      params = (Iterable)params;
      Collection localCollection = (Collection)new ArrayList(p.a(params, 10));
      int i = 0;
      Iterator localIterator = params.iterator();
      while (localIterator.hasNext())
      {
        params = localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        localObject = (a.p)params;
        params = (a.s)localObject;
        if (i >= j) {
          params = ((a.p)localObject).kvU().Pr(true).kwc();
        }
        localCollection.add(params);
        i += 1;
      }
      localObject = (List)localCollection;
    }
    s.s(localObject, "run {\n        val origin… else originalTypes\n    }");
    this.TJb = ((List)localObject);
    AppMethodBeat.o(59084);
  }
  
  public final a.p aLZ(int paramInt)
  {
    AppMethodBeat.i(59083);
    a.p localp = (a.p)this.TJb.get(paramInt);
    AppMethodBeat.o(59083);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.g
 * JD-Core Version:    0.7.0.1
 */