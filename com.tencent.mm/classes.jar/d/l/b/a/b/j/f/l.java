package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.ap;
import d.l.b.a.b.m.ay;
import d.l.b.a.b.m.ba;
import d.v;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class l
  implements h
{
  private final h NxR;
  private final ba Nya;
  private Map<d.l.b.a.b.b.l, d.l.b.a.b.b.l> Nyb;
  private final d.f Nyc;
  
  public l(h paramh, ba paramba)
  {
    AppMethodBeat.i(60235);
    this.NxR = paramh;
    paramh = paramba.guf();
    p.g(paramh, "givenSubstitutor.substitution");
    this.Nya = d.l.b.a.b.j.a.a.d.c(paramh).gue();
    this.Nyc = g.O((d.g.a.a)new a(this));
    AppMethodBeat.o(60235);
  }
  
  private final <D extends d.l.b.a.b.b.l> D J(D paramD)
  {
    AppMethodBeat.i(60227);
    if (this.Nya.MYs.isEmpty())
    {
      AppMethodBeat.o(60227);
      return paramD;
    }
    if (this.Nyb == null) {
      this.Nyb = ((Map)new HashMap());
    }
    Map localMap = this.Nyb;
    if (localMap == null) {
      p.gfZ();
    }
    Object localObject2 = localMap.get(paramD);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((paramD instanceof ap))
      {
        localObject1 = ((ap)paramD).f(this.Nya);
        if (localObject1 == null)
        {
          paramD = (Throwable)new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + paramD + " substitution fails");
          AppMethodBeat.o(60227);
          throw paramD;
        }
        localObject1 = (d.l.b.a.b.b.l)localObject1;
        localMap.put(paramD, localObject1);
      }
    }
    else
    {
      paramD = (d.l.b.a.b.b.l)localObject1;
      if (paramD != null) {
        break label210;
      }
      paramD = new v("null cannot be cast to non-null type D");
      AppMethodBeat.o(60227);
      throw paramD;
    }
    paramD = (Throwable)new IllegalStateException("Unknown descriptor in scope: ".concat(String.valueOf(paramD)).toString());
    AppMethodBeat.o(60227);
    throw paramD;
    label210:
    AppMethodBeat.o(60227);
    return paramD;
  }
  
  private final <D extends d.l.b.a.b.b.l> Collection<D> y(Collection<? extends D> paramCollection)
  {
    AppMethodBeat.i(60228);
    if (this.Nya.MYs.isEmpty())
    {
      AppMethodBeat.o(60228);
      return paramCollection;
    }
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(60228);
      return paramCollection;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(d.l.b.a.b.o.a.ge(paramCollection.size()));
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localLinkedHashSet.add(J((d.l.b.a.b.b.l)paramCollection.next()));
    }
    paramCollection = (Collection)localLinkedHashSet;
    AppMethodBeat.o(60228);
    return paramCollection;
  }
  
  public final Collection<? extends ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60229);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = y(this.NxR.a(paramf, parama));
    AppMethodBeat.o(60229);
    return paramf;
  }
  
  public final Collection<d.l.b.a.b.b.l> a(d paramd, b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(60232);
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    paramd = (Collection)this.Nyc.getValue();
    AppMethodBeat.o(60232);
    return paramd;
  }
  
  public final Collection<? extends am> b(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60231);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = y(this.NxR.b(paramf, parama));
    AppMethodBeat.o(60231);
    return paramf;
  }
  
  public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60230);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = this.NxR.c(paramf, parama);
    if (paramf != null)
    {
      paramf = (d.l.b.a.b.b.h)J((d.l.b.a.b.b.l)paramf);
      AppMethodBeat.o(60230);
      return paramf;
    }
    AppMethodBeat.o(60230);
    return null;
  }
  
  public final Set<d.l.b.a.b.f.f> gjW()
  {
    AppMethodBeat.i(60233);
    Set localSet = this.NxR.gjW();
    AppMethodBeat.o(60233);
    return localSet;
  }
  
  public final Set<d.l.b.a.b.f.f> gjX()
  {
    AppMethodBeat.i(60234);
    Set localSet = this.NxR.gjX();
    AppMethodBeat.o(60234);
    return localSet;
  }
  
  static final class a
    extends q
    implements d.g.a.a<Collection<? extends d.l.b.a.b.b.l>>
  {
    a(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.f.l
 * JD-Core Version:    0.7.0.1
 */