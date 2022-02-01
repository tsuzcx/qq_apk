package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;

public final class a
  implements f
{
  private final List<f> ajkb;
  
  public a(List<? extends f> paramList)
  {
    AppMethodBeat.i(192189);
    this.ajkb = paramList;
    AppMethodBeat.o(192189);
  }
  
  public final List<kotlin.l.b.a.b.f.f> D(e parame)
  {
    AppMethodBeat.i(192193);
    s.u(parame, "thisDescriptor");
    Object localObject = (Iterable)this.ajkb;
    Collection localCollection = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      p.a(localCollection, (Iterable)((f)((Iterator)localObject).next()).D(parame));
    }
    parame = (List)localCollection;
    AppMethodBeat.o(192193);
    return parame;
  }
  
  public final List<kotlin.l.b.a.b.f.f> E(e parame)
  {
    AppMethodBeat.i(192201);
    s.u(parame, "thisDescriptor");
    Object localObject = (Iterable)this.ajkb;
    Collection localCollection = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      p.a(localCollection, (Iterable)((f)((Iterator)localObject).next()).E(parame));
    }
    parame = (List)localCollection;
    AppMethodBeat.o(192201);
    return parame;
  }
  
  public final void a(e parame, kotlin.l.b.a.b.f.f paramf, Collection<au> paramCollection)
  {
    AppMethodBeat.i(192197);
    s.u(parame, "thisDescriptor");
    s.u(paramf, "name");
    s.u(paramCollection, "result");
    Iterator localIterator = ((Iterable)this.ajkb).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a(parame, paramf, paramCollection);
    }
    AppMethodBeat.o(192197);
  }
  
  public final void b(e parame, List<d> paramList)
  {
    AppMethodBeat.i(192206);
    s.u(parame, "thisDescriptor");
    s.u(paramList, "result");
    Iterator localIterator = ((Iterable)this.ajkb).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).b(parame, paramList);
    }
    AppMethodBeat.o(192206);
  }
  
  public final void b(e parame, kotlin.l.b.a.b.f.f paramf, Collection<au> paramCollection)
  {
    AppMethodBeat.i(192204);
    s.u(parame, "thisDescriptor");
    s.u(paramf, "name");
    s.u(paramCollection, "result");
    Iterator localIterator = ((Iterable)this.ajkb).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).b(parame, paramf, paramCollection);
    }
    AppMethodBeat.o(192204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e.a
 * JD-Core Version:    0.7.0.1
 */