package d.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.e.a.p;
import d.l.b.a.b.e.a.p.b;
import d.l.b.a.b.e.a.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private final List<a.p> zZS;
  
  public h(a.s params)
  {
    AppMethodBeat.i(59084);
    Object localObject = params.Lwr;
    Collection localCollection;
    if (params.fYk())
    {
      int j = params.Lws;
      params = params.Lwr;
      k.g(params, "typeTable.typeList");
      params = (Iterable)params;
      localCollection = (Collection)new ArrayList(j.a(params, 10));
      int i = 0;
      Iterator localIterator = params.iterator();
      while (localIterator.hasNext())
      {
        params = localIterator.next();
        if (i < 0) {
          j.fOc();
        }
        localObject = (a.p)params;
        params = (a.s)localObject;
        if (i >= j) {
          params = ((a.p)localObject).fXH().zp(true).fXP();
        }
        localCollection.add(params);
        i += 1;
      }
    }
    for (params = (List)localCollection;; params = (a.s)localObject)
    {
      this.zZS = params;
      AppMethodBeat.o(59084);
      return;
      k.g(localObject, "originalTypes");
    }
  }
  
  public final a.p ain(int paramInt)
  {
    AppMethodBeat.i(59083);
    a.p localp = (a.p)this.zZS.get(paramInt);
    AppMethodBeat.o(59083);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.b.h
 * JD-Core Version:    0.7.0.1
 */