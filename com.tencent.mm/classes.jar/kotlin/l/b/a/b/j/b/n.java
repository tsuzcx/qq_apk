package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.m;

public final class n
  implements at
{
  public static final a ablg;
  private final y aaIj;
  private final aj aaXH;
  public final Set<ab> able;
  private final f ablf;
  private final long value;
  
  static
  {
    AppMethodBeat.i(60083);
    ablg = new a((byte)0);
    AppMethodBeat.o(60083);
  }
  
  private n(long paramLong, y paramy, Set<? extends ab> paramSet)
  {
    AppMethodBeat.i(60088);
    g.a locala = kotlin.l.b.a.b.b.a.g.aaLw;
    this.aaXH = ac.a(g.a.iGe(), this);
    this.ablf = kotlin.g.ar((a)new b(this));
    this.value = paramLong;
    this.aaIj = paramy;
    this.able = paramSet;
    AppMethodBeat.o(60088);
  }
  
  public final boolean c(at paramat)
  {
    AppMethodBeat.i(60087);
    p.k(paramat, "constructor");
    Object localObject = (Iterable)this.able;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (p.h(((ab)((Iterator)localObject).next()).iOU(), paramat))
        {
          AppMethodBeat.o(60087);
          return true;
        }
      }
    }
    AppMethodBeat.o(60087);
    return false;
  }
  
  public final List<as> iCb()
  {
    return (List)v.aaAd;
  }
  
  public final h iEf()
  {
    return null;
  }
  
  public final boolean iEh()
  {
    return false;
  }
  
  public final kotlin.l.b.a.b.a.g iFv()
  {
    AppMethodBeat.i(60085);
    kotlin.l.b.a.b.a.g localg = this.aaIj.iFv();
    AppMethodBeat.o(60085);
    return localg;
  }
  
  public final Collection<ab> iGk()
  {
    AppMethodBeat.i(60084);
    Collection localCollection = (Collection)this.ablf.getValue();
    AppMethodBeat.o(60084);
    return localCollection;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60086);
    String str = "IntegerLiteralType" + new StringBuilder("[").append(j.a((Iterable)this.able, (CharSequence)",", null, null, 0, null, (b)n.c.abll, 30)).append(']').toString();
    AppMethodBeat.o(60086);
    return str;
  }
  
  public static final class a
  {
    private static aj a(n paramn, aj paramaj)
    {
      AppMethodBeat.i(60079);
      if (paramn.able.contains(paramaj))
      {
        AppMethodBeat.o(60079);
        return paramaj;
      }
      AppMethodBeat.o(60079);
      return null;
    }
    
    public static aj y(Collection<? extends aj> paramCollection)
    {
      AppMethodBeat.i(60078);
      p.k(paramCollection, "types");
      a locala = a.abli;
      if (paramCollection.isEmpty())
      {
        AppMethodBeat.o(60078);
        return null;
      }
      Iterator localIterator = ((Iterable)paramCollection).iterator();
      if (!localIterator.hasNext())
      {
        paramCollection = (Throwable)new UnsupportedOperationException("Empty collection can't be reduced.");
        AppMethodBeat.o(60078);
        throw paramCollection;
      }
      paramCollection = localIterator.next();
      while (localIterator.hasNext())
      {
        Object localObject1 = (aj)localIterator.next();
        paramCollection = (aj)paramCollection;
        Object localObject2 = n.ablg;
        if ((paramCollection == null) || (localObject1 == null))
        {
          paramCollection = null;
        }
        else
        {
          Object localObject3 = paramCollection.iOU();
          localObject2 = ((aj)localObject1).iOU();
          if (((localObject3 instanceof n)) && ((localObject2 instanceof n)))
          {
            localObject1 = (n)localObject3;
            localObject2 = (n)localObject2;
            switch (o.$EnumSwitchMapping$0[locala.ordinal()])
            {
            default: 
              paramCollection = new m();
              AppMethodBeat.o(60078);
              throw paramCollection;
            case 1: 
              paramCollection = (Iterable)((n)localObject1).able;
              localObject2 = (Iterable)((n)localObject2).able;
              p.k(paramCollection, "$this$intersect");
              p.k(localObject2, "other");
              paramCollection = j.u(paramCollection);
              localObject3 = (Collection)paramCollection;
              p.k(localObject3, "$this$retainAll");
              p.k(localObject2, "elements");
              localObject2 = j.a((Iterable)localObject2, (Iterable)localObject3);
              ag.fc(localObject3).retainAll((Collection)localObject2);
            }
            for (;;)
            {
              paramCollection = new n(n.c((n)localObject1), n.d((n)localObject1), paramCollection, (byte)0);
              localObject1 = kotlin.l.b.a.b.b.a.g.aaLw;
              paramCollection = ac.a(g.a.iGe(), paramCollection);
              break;
              paramCollection = j.b((Iterable)((n)localObject1).able, (Iterable)((n)localObject2).able);
            }
          }
          if ((localObject3 instanceof n)) {
            paramCollection = a((n)localObject3, (aj)localObject1);
          } else if ((localObject2 instanceof n)) {
            paramCollection = a((n)localObject2, paramCollection);
          } else {
            paramCollection = null;
          }
        }
      }
      paramCollection = (aj)paramCollection;
      AppMethodBeat.o(60078);
      return paramCollection;
    }
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(60074);
        a locala1 = new a("COMMON_SUPER_TYPE", 0);
        ablh = locala1;
        a locala2 = new a("INTERSECTION_TYPE", 1);
        abli = locala2;
        ablj = new a[] { locala1, locala2 };
        AppMethodBeat.o(60074);
      }
      
      private a() {}
    }
  }
  
  static final class b
    extends q
    implements a<List<aj>>
  {
    b(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.n
 * JD-Core Version:    0.7.0.1
 */