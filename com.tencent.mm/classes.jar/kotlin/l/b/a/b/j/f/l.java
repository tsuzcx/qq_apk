package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.g;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.ba;
import kotlin.t;

public final class l
  implements h
{
  private final ba abmF;
  private Map<kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.l> abmG;
  private final kotlin.f abmH;
  private final h abmw;
  
  public l(h paramh, ba paramba)
  {
    AppMethodBeat.i(60235);
    this.abmw = paramh;
    paramh = paramba.iQc();
    p.j(paramh, "givenSubstitutor.substitution");
    this.abmF = kotlin.l.b.a.b.j.a.a.d.c(paramh).iQb();
    this.abmH = g.ar((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(60235);
  }
  
  private final <D extends kotlin.l.b.a.b.b.l> D J(D paramD)
  {
    AppMethodBeat.i(60227);
    if (this.abmF.aaOa.isEmpty())
    {
      AppMethodBeat.o(60227);
      return paramD;
    }
    if (this.abmG == null) {
      this.abmG = ((Map)new HashMap());
    }
    Map localMap = this.abmG;
    if (localMap == null) {
      p.iCn();
    }
    Object localObject2 = localMap.get(paramD);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((paramD instanceof ap))
      {
        localObject1 = ((ap)paramD).f(this.abmF);
        if (localObject1 == null)
        {
          paramD = (Throwable)new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + paramD + " substitution fails");
          AppMethodBeat.o(60227);
          throw paramD;
        }
        localObject1 = (kotlin.l.b.a.b.b.l)localObject1;
        localMap.put(paramD, localObject1);
      }
    }
    else
    {
      paramD = (kotlin.l.b.a.b.b.l)localObject1;
      if (paramD != null) {
        break label210;
      }
      paramD = new t("null cannot be cast to non-null type D");
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
  
  private final <D extends kotlin.l.b.a.b.b.l> Collection<D> z(Collection<? extends D> paramCollection)
  {
    AppMethodBeat.i(60228);
    if (this.abmF.aaOa.isEmpty())
    {
      AppMethodBeat.o(60228);
      return paramCollection;
    }
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(60228);
      return paramCollection;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(kotlin.l.b.a.b.o.a.ii(paramCollection.size()));
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localLinkedHashSet.add(J((kotlin.l.b.a.b.b.l)paramCollection.next()));
    }
    paramCollection = (Collection)localLinkedHashSet;
    AppMethodBeat.o(60228);
    return paramCollection;
  }
  
  public final Collection<? extends ah> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60229);
    p.k(paramf, "name");
    p.k(parama, "location");
    paramf = z(this.abmw.a(paramf, parama));
    AppMethodBeat.o(60229);
    return paramf;
  }
  
  public final Collection<kotlin.l.b.a.b.b.l> a(d paramd, b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(60232);
    p.k(paramd, "kindFilter");
    p.k(paramb, "nameFilter");
    paramd = (Collection)this.abmH.getValue();
    AppMethodBeat.o(60232);
    return paramd;
  }
  
  public final Collection<? extends am> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60231);
    p.k(paramf, "name");
    p.k(parama, "location");
    paramf = z(this.abmw.b(paramf, parama));
    AppMethodBeat.o(60231);
    return paramf;
  }
  
  public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60230);
    p.k(paramf, "name");
    p.k(parama, "location");
    paramf = this.abmw.c(paramf, parama);
    if (paramf != null)
    {
      paramf = (kotlin.l.b.a.b.b.h)J((kotlin.l.b.a.b.b.l)paramf);
      AppMethodBeat.o(60230);
      return paramf;
    }
    AppMethodBeat.o(60230);
    return null;
  }
  
  public final Set<kotlin.l.b.a.b.f.f> iGp()
  {
    AppMethodBeat.i(60233);
    Set localSet = this.abmw.iGp();
    AppMethodBeat.o(60233);
    return localSet;
  }
  
  public final Set<kotlin.l.b.a.b.f.f> iGq()
  {
    AppMethodBeat.i(60234);
    Set localSet = this.abmw.iGq();
    AppMethodBeat.o(60234);
    return localSet;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.a<Collection<? extends kotlin.l.b.a.b.b.l>>
  {
    a(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.l
 * JD-Core Version:    0.7.0.1
 */