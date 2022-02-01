package d.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l.b.a.b.e.a.p;
import d.l.b.a.b.e.a.p.b;
import d.l.b.a.b.e.a.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private final List<a.p> BrE;
  
  public h(a.s params)
  {
    AppMethodBeat.i(59084);
    Object localObject = params.Nno;
    Collection localCollection;
    if (params.gpJ())
    {
      int j = params.Nnp;
      params = params.Nno;
      p.g(params, "typeTable.typeList");
      params = (Iterable)params;
      localCollection = (Collection)new ArrayList(j.a(params, 10));
      int i = 0;
      Iterator localIterator = params.iterator();
      while (localIterator.hasNext())
      {
        params = localIterator.next();
        if (i < 0) {
          j.gfB();
        }
        localObject = (a.p)params;
        params = (a.s)localObject;
        if (i >= j) {
          params = ((a.p)localObject).gpg().Ad(true).gpo();
        }
        localCollection.add(params);
        i += 1;
      }
    }
    for (params = (List)localCollection;; params = (a.s)localObject)
    {
      this.BrE = params;
      AppMethodBeat.o(59084);
      return;
      p.g(localObject, "originalTypes");
    }
  }
  
  public final a.p akO(int paramInt)
  {
    AppMethodBeat.i(59083);
    a.p localp = (a.p)this.BrE.get(paramInt);
    AppMethodBeat.o(59083);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.b.h
 * JD-Core Version:    0.7.0.1
 */