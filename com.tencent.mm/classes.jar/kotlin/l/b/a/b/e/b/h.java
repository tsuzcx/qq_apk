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
  private final List<a.p> MWx;
  
  public h(a.s params)
  {
    AppMethodBeat.i(59084);
    Object localObject = params.abcN;
    Collection localCollection;
    if (params.iMc())
    {
      int j = params.abcO;
      params = params.abcN;
      p.j(params, "typeTable.typeList");
      params = (Iterable)params;
      localCollection = (Collection)new ArrayList(j.a(params, 10));
      int i = 0;
      Iterator localIterator = params.iterator();
      while (localIterator.hasNext())
      {
        params = localIterator.next();
        if (i < 0) {
          j.iBO();
        }
        localObject = (a.p)params;
        params = (a.s)localObject;
        if (i >= j) {
          params = ((a.p)localObject).iLz().Jo(true).iLH();
        }
        localCollection.add(params);
        i += 1;
      }
    }
    for (params = (List)localCollection;; params = (a.s)localObject)
    {
      this.MWx = params;
      AppMethodBeat.o(59084);
      return;
      p.j(localObject, "originalTypes");
    }
  }
  
  public final a.p aFi(int paramInt)
  {
    AppMethodBeat.i(59083);
    a.p localp = (a.p)this.MWx.get(paramInt);
    AppMethodBeat.o(59083);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.h
 * JD-Core Version:    0.7.0.1
 */