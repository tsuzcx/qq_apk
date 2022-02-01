package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ak;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.j.g.n;
import kotlin.l.b.a.b.j.g.n.a;

public final class ac
  implements ax, kotlin.l.b.a.b.m.c.h
{
  public ad ajpN;
  public final LinkedHashSet<ad> ajpO;
  private final int cHb;
  
  public ac(Collection<? extends ad> paramCollection)
  {
    AppMethodBeat.i(60760);
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramCollection = (Throwable)new AssertionError("Attempt to create an empty intersection");
      AppMethodBeat.o(60760);
      throw paramCollection;
    }
    this.ajpO = new LinkedHashSet(paramCollection);
    this.cHb = this.ajpO.hashCode();
    AppMethodBeat.o(60760);
  }
  
  private ac(Collection<? extends ad> paramCollection, ad paramad)
  {
    this(paramCollection);
    this.ajpN = paramad;
  }
  
  public final ac ag(ad paramad)
  {
    AppMethodBeat.i(191665);
    paramad = new ac((Collection)this.ajpO, paramad);
    AppMethodBeat.o(191665);
    return paramad;
  }
  
  public final String bf(b<? super ad, ? extends Object> paramb)
  {
    AppMethodBeat.i(191651);
    s.u(paramb, "getProperTypeRelatedToStringify");
    paramb = p.a((Iterable)p.a((Iterable)this.ajpO, (Comparator)new ac.b(paramb)), (CharSequence)" & ", (CharSequence)"{", (CharSequence)"}", 0, null, (b)new ac.d(paramb), 24);
    AppMethodBeat.o(191651);
    return paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60758);
    if (this == paramObject)
    {
      AppMethodBeat.o(60758);
      return true;
    }
    if (!(paramObject instanceof ac))
    {
      AppMethodBeat.o(60758);
      return false;
    }
    boolean bool = s.p(this.ajpO, ((ac)paramObject).ajpO);
    AppMethodBeat.o(60758);
    return bool;
  }
  
  public final int hashCode()
  {
    return this.cHb;
  }
  
  public final kotlin.l.b.a.b.j.g.h kAI()
  {
    AppMethodBeat.i(191635);
    Object localObject = n.ajlt;
    localObject = n.a.c("member scope for intersection type", (Collection)this.ajpO);
    AppMethodBeat.o(191635);
    return localObject;
  }
  
  public final al kAJ()
  {
    AppMethodBeat.i(60759);
    Object localObject = kotlin.l.b.a.b.b.a.g.aiIh;
    localObject = ae.a(g.a.kpB(), (ax)this, (List)ab.aivy, false, kAI(), (b)new a(this));
    AppMethodBeat.o(60759);
    return localObject;
  }
  
  public final List<ba> klq()
  {
    return (List)ab.aivy;
  }
  
  public final kotlin.l.b.a.b.b.h knA()
  {
    return null;
  }
  
  public final boolean knx()
  {
    return false;
  }
  
  public final kotlin.l.b.a.b.a.h koV()
  {
    AppMethodBeat.i(60756);
    kotlin.l.b.a.b.a.h localh = ((ad)this.ajpO.iterator().next()).kzm().koV();
    s.s(localh, "intersectedTypes.iterato…xt().constructor.builtIns");
    AppMethodBeat.o(60756);
    return localh;
  }
  
  public final Collection<ad> kpG()
  {
    return (Collection)this.ajpO;
  }
  
  public final ac m(kotlin.l.b.a.b.m.a.g paramg)
  {
    AppMethodBeat.i(191661);
    s.u(paramg, "kotlinTypeRefiner");
    Object localObject2 = (Iterable)this.ajpO;
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    for (int i = 0; ((Iterator)localObject2).hasNext(); i = 1) {
      ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).f(paramg));
    }
    localObject1 = (List)localObject1;
    if (i == 0)
    {
      paramg = null;
      if (paramg == null)
      {
        AppMethodBeat.o(191661);
        return this;
      }
    }
    else
    {
      localObject2 = this.ajpN;
      if (localObject2 == null) {}
      for (paramg = null;; paramg = ((ad)localObject2).f(paramg))
      {
        paramg = new ac((Collection)localObject1).ag(paramg);
        break;
      }
    }
    AppMethodBeat.o(191661);
    return paramg;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60757);
    String str = bf((b)ac.c.ajpR);
    AppMethodBeat.o(60757);
    return str;
  }
  
  static final class a
    extends u
    implements b<kotlin.l.b.a.b.m.a.g, al>
  {
    a(ac paramac)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ac
 * JD-Core Version:    0.7.0.1
 */