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
  private final h TJU;
  private final ba TKd;
  private Map<kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.l> TKe;
  private final kotlin.f TKf;
  
  public l(h paramh, ba paramba)
  {
    AppMethodBeat.i(60235);
    this.TJU = paramh;
    paramh = paramba.hLK();
    p.g(paramh, "givenSubstitutor.substitution");
    this.TKd = kotlin.l.b.a.b.j.a.a.d.c(paramh).hLJ();
    this.TKf = g.ah((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(60235);
  }
  
  private final <D extends kotlin.l.b.a.b.b.l> Collection<D> B(Collection<? extends D> paramCollection)
  {
    AppMethodBeat.i(60228);
    if (this.TKd.Tlg.isEmpty())
    {
      AppMethodBeat.o(60228);
      return paramCollection;
    }
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(60228);
      return paramCollection;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(kotlin.l.b.a.b.o.a.hp(paramCollection.size()));
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localLinkedHashSet.add(J((kotlin.l.b.a.b.b.l)paramCollection.next()));
    }
    paramCollection = (Collection)localLinkedHashSet;
    AppMethodBeat.o(60228);
    return paramCollection;
  }
  
  private final <D extends kotlin.l.b.a.b.b.l> D J(D paramD)
  {
    AppMethodBeat.i(60227);
    if (this.TKd.Tlg.isEmpty())
    {
      AppMethodBeat.o(60227);
      return paramD;
    }
    if (this.TKe == null) {
      this.TKe = ((Map)new HashMap());
    }
    Map localMap = this.TKe;
    if (localMap == null) {
      p.hyc();
    }
    Object localObject2 = localMap.get(paramD);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((paramD instanceof ap))
      {
        localObject1 = ((ap)paramD).f(this.TKd);
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
  
  public final Collection<? extends ah> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60229);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = B(this.TJU.a(paramf, parama));
    AppMethodBeat.o(60229);
    return paramf;
  }
  
  public final Collection<kotlin.l.b.a.b.b.l> a(d paramd, b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(60232);
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    paramd = (Collection)this.TKf.getValue();
    AppMethodBeat.o(60232);
    return paramd;
  }
  
  public final Collection<? extends am> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60231);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = B(this.TJU.b(paramf, parama));
    AppMethodBeat.o(60231);
    return paramf;
  }
  
  public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60230);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = this.TJU.c(paramf, parama);
    if (paramf != null)
    {
      paramf = (kotlin.l.b.a.b.b.h)J((kotlin.l.b.a.b.b.l)paramf);
      AppMethodBeat.o(60230);
      return paramf;
    }
    AppMethodBeat.o(60230);
    return null;
  }
  
  public final Set<kotlin.l.b.a.b.f.f> hCa()
  {
    AppMethodBeat.i(60233);
    Set localSet = this.TJU.hCa();
    AppMethodBeat.o(60233);
    return localSet;
  }
  
  public final Set<kotlin.l.b.a.b.f.f> hCb()
  {
    AppMethodBeat.i(60234);
    Set localSet = this.TJU.hCb();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.l
 * JD-Core Version:    0.7.0.1
 */