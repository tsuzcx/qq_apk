package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ac;
import d.l.b.a.b.f.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class i
  implements ac
{
  private final List<ac> MXI;
  
  public i(List<? extends ac> paramList)
  {
    AppMethodBeat.i(57060);
    this.MXI = paramList;
    AppMethodBeat.o(57060);
  }
  
  public final Collection<d.l.b.a.b.f.b> a(d.l.b.a.b.f.b paramb, d.g.a.b<? super f, Boolean> paramb1)
  {
    AppMethodBeat.i(57059);
    p.h(paramb, "fqName");
    p.h(paramb1, "nameFilter");
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.MXI.iterator();
    while (localIterator.hasNext()) {
      localHashSet.addAll(((ac)localIterator.next()).a(paramb, paramb1));
    }
    paramb = (Collection)localHashSet;
    AppMethodBeat.o(57059);
    return paramb;
  }
  
  public final List<ab> f(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57058);
    p.h(paramb, "fqName");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.MXI.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll((Collection)((ac)localIterator.next()).f(paramb));
    }
    paramb = j.l((Iterable)localArrayList);
    AppMethodBeat.o(57058);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.i
 * JD-Core Version:    0.7.0.1
 */