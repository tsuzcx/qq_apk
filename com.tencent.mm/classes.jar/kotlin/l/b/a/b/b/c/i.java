package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ac;
import kotlin.l.b.a.b.f.f;

public final class i
  implements ac
{
  private final List<ac> Tkw;
  
  public i(List<? extends ac> paramList)
  {
    AppMethodBeat.i(57060);
    this.Tkw = paramList;
    AppMethodBeat.o(57060);
  }
  
  public final Collection<kotlin.l.b.a.b.f.b> a(kotlin.l.b.a.b.f.b paramb, kotlin.g.a.b<? super f, Boolean> paramb1)
  {
    AppMethodBeat.i(57059);
    p.h(paramb, "fqName");
    p.h(paramb1, "nameFilter");
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.Tkw.iterator();
    while (localIterator.hasNext()) {
      localHashSet.addAll(((ac)localIterator.next()).a(paramb, paramb1));
    }
    paramb = (Collection)localHashSet;
    AppMethodBeat.o(57059);
    return paramb;
  }
  
  public final List<ab> f(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57058);
    p.h(paramb, "fqName");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Tkw.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll((Collection)((ac)localIterator.next()).f(paramb));
    }
    paramb = j.p((Iterable)localArrayList);
    AppMethodBeat.o(57058);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.i
 * JD-Core Version:    0.7.0.1
 */