package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.f;
import d.g.a.a;
import d.g.a.b;
import d.g.b.ae;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.h;
import d.l.b.a.b.b.y;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class n
  implements at
{
  public static final a NTG;
  private final aj NFh;
  public final Set<ab> NTE;
  private final f NTF;
  private final y NpH;
  private final long value;
  
  static
  {
    AppMethodBeat.i(60083);
    NTG = new a((byte)0);
    AppMethodBeat.o(60083);
  }
  
  private n(long paramLong, y paramy, Set<? extends ab> paramSet)
  {
    AppMethodBeat.i(60088);
    g.a locala = d.l.b.a.b.b.a.g.NsU;
    this.NFh = ac.a(g.a.gon(), this);
    this.NTF = d.g.O((a)new b(this));
    this.value = paramLong;
    this.NpH = paramy;
    this.NTE = paramSet;
    AppMethodBeat.o(60088);
  }
  
  public final boolean c(at paramat)
  {
    AppMethodBeat.i(60087);
    p.h(paramat, "constructor");
    Object localObject = (Iterable)this.NTE;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (p.i(((ab)((Iterator)localObject).next()).gxB(), paramat))
        {
          AppMethodBeat.o(60087);
          return true;
        }
      }
    }
    AppMethodBeat.o(60087);
    return false;
  }
  
  public final List<as> getParameters()
  {
    return (List)v.NhH;
  }
  
  public final h gmq()
  {
    return null;
  }
  
  public final boolean gms()
  {
    return false;
  }
  
  public final d.l.b.a.b.a.g gnF()
  {
    AppMethodBeat.i(60085);
    d.l.b.a.b.a.g localg = this.NpH.gnF();
    AppMethodBeat.o(60085);
    return localg;
  }
  
  public final Collection<ab> got()
  {
    AppMethodBeat.i(60084);
    Collection localCollection = (Collection)this.NTF.getValue();
    AppMethodBeat.o(60084);
    return localCollection;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60086);
    String str = "IntegerLiteralType" + new StringBuilder("[").append(j.a((Iterable)this.NTE, (CharSequence)",", null, null, 0, null, (b)c.NTL, 30)).append(']').toString();
    AppMethodBeat.o(60086);
    return str;
  }
  
  public static final class a
  {
    private static aj a(n paramn, aj paramaj)
    {
      AppMethodBeat.i(60079);
      if (paramn.NTE.contains(paramaj))
      {
        AppMethodBeat.o(60079);
        return paramaj;
      }
      AppMethodBeat.o(60079);
      return null;
    }
    
    public static aj x(Collection<? extends aj> paramCollection)
    {
      AppMethodBeat.i(60078);
      p.h(paramCollection, "types");
      a locala = a.NTI;
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
        Object localObject2 = n.NTG;
        if ((paramCollection == null) || (localObject1 == null))
        {
          paramCollection = null;
        }
        else
        {
          Object localObject3 = paramCollection.gxB();
          localObject2 = ((aj)localObject1).gxB();
          if (((localObject3 instanceof n)) && ((localObject2 instanceof n)))
          {
            localObject1 = (n)localObject3;
            localObject2 = (n)localObject2;
            switch (o.cqt[locala.ordinal()])
            {
            default: 
              paramCollection = new m();
              AppMethodBeat.o(60078);
              throw paramCollection;
            case 1: 
              paramCollection = (Iterable)((n)localObject1).NTE;
              localObject2 = (Iterable)((n)localObject2).NTE;
              p.h(paramCollection, "$this$intersect");
              p.h(localObject2, "other");
              paramCollection = j.q(paramCollection);
              localObject3 = (Collection)paramCollection;
              p.h(localObject3, "$this$retainAll");
              p.h(localObject2, "elements");
              localObject2 = j.a((Iterable)localObject2, (Iterable)localObject3);
              ae.eU(localObject3).retainAll((Collection)localObject2);
            }
            for (;;)
            {
              paramCollection = new n(n.c((n)localObject1), n.d((n)localObject1), paramCollection, (byte)0);
              localObject1 = d.l.b.a.b.b.a.g.NsU;
              paramCollection = ac.a(g.a.gon(), paramCollection);
              break;
              paramCollection = j.b((Iterable)((n)localObject1).NTE, (Iterable)((n)localObject2).NTE);
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
        NTH = locala1;
        a locala2 = new a("INTERSECTION_TYPE", 1);
        NTI = locala2;
        NTJ = new a[] { locala1, locala2 };
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
  
  static final class c
    extends q
    implements b<ab, String>
  {
    public static final c NTL;
    
    static
    {
      AppMethodBeat.i(60082);
      NTL = new c();
      AppMethodBeat.o(60082);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.b.n
 * JD-Core Version:    0.7.0.1
 */