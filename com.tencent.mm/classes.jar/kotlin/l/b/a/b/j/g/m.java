package kotlin.l.b.a.b.j.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;

public final class m
  implements h
{
  private final h ajlf;
  private final be ajlp;
  private Map<l, l> ajlq;
  private final j ajlr;
  
  public m(h paramh, be parambe)
  {
    AppMethodBeat.i(60235);
    this.ajlf = paramh;
    paramh = parambe.kAR();
    s.s(paramh, "givenSubstitutor.substitution");
    this.ajlp = kotlin.l.b.a.b.j.a.a.d.c(paramh).kAO();
    this.ajlr = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(60235);
  }
  
  private final <D extends l> D J(D paramD)
  {
    AppMethodBeat.i(60227);
    if (this.ajlp.aiKL.isEmpty())
    {
      AppMethodBeat.o(60227);
      return paramD;
    }
    if (this.ajlq == null) {
      this.ajlq = ((Map)new HashMap());
    }
    Map localMap = this.ajlq;
    s.checkNotNull(localMap);
    Object localObject2 = localMap.get(paramD);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((paramD instanceof ax))
      {
        localObject1 = ((ax)paramD).f(this.ajlp);
        if (localObject1 == null)
        {
          paramD = new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + paramD + " substitution fails");
          AppMethodBeat.o(60227);
          throw paramD;
        }
      }
      else
      {
        paramD = (Throwable)new IllegalStateException(s.X("Unknown descriptor in scope: ", paramD).toString());
        AppMethodBeat.o(60227);
        throw paramD;
      }
      localObject1 = (l)localObject1;
      localMap.put(paramD, localObject1);
    }
    paramD = (l)localObject1;
    AppMethodBeat.o(60227);
    return paramD;
  }
  
  private final <D extends l> Collection<D> Q(Collection<? extends D> paramCollection)
  {
    AppMethodBeat.i(60228);
    if (this.ajlp.aiKL.isEmpty())
    {
      AppMethodBeat.o(60228);
      return paramCollection;
    }
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(60228);
      return paramCollection;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(kotlin.l.b.a.b.o.a.lN(paramCollection.size()));
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localLinkedHashSet.add(J((l)paramCollection.next()));
    }
    paramCollection = (Collection)localLinkedHashSet;
    AppMethodBeat.o(60228);
    return paramCollection;
  }
  
  public final Collection<? extends ap> a(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(60229);
    s.u(paramf, "name");
    s.u(paramb, "location");
    paramf = Q(this.ajlf.a(paramf, paramb));
    AppMethodBeat.o(60229);
    return paramf;
  }
  
  public final Collection<l> a(d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(60232);
    s.u(paramd, "kindFilter");
    s.u(paramb, "nameFilter");
    paramd = (Collection)this.ajlr.getValue();
    AppMethodBeat.o(60232);
    return paramd;
  }
  
  public final Collection<? extends au> b(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(60231);
    s.u(paramf, "name");
    s.u(paramb, "location");
    paramf = Q(this.ajlf.b(paramf, paramb));
    AppMethodBeat.o(60231);
    return paramf;
  }
  
  public final kotlin.l.b.a.b.b.h c(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(60230);
    s.u(paramf, "name");
    s.u(paramb, "location");
    paramf = this.ajlf.c(paramf, paramb);
    if (paramf == null)
    {
      AppMethodBeat.o(60230);
      return null;
    }
    paramf = (kotlin.l.b.a.b.b.h)J((l)paramf);
    AppMethodBeat.o(60230);
    return paramf;
  }
  
  public final void d(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(192244);
    h.b.a((h)this, paramf, paramb);
    AppMethodBeat.o(192244);
  }
  
  public final Set<f> kpL()
  {
    AppMethodBeat.i(60233);
    Set localSet = this.ajlf.kpL();
    AppMethodBeat.o(60233);
    return localSet;
  }
  
  public final Set<f> kpM()
  {
    AppMethodBeat.i(192241);
    Set localSet = this.ajlf.kpM();
    AppMethodBeat.o(192241);
    return localSet;
  }
  
  public final Set<f> kpN()
  {
    AppMethodBeat.i(60234);
    Set localSet = this.ajlf.kpN();
    AppMethodBeat.o(60234);
    return localSet;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.a<Collection<? extends l>>
  {
    a(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g.m
 * JD-Core Version:    0.7.0.1
 */