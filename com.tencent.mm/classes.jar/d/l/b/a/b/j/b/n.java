package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.f;
import d.g.a.a;
import d.g.a.b;
import d.g.b.aa;
import d.g.b.l;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.h;
import d.l.b.a.b.b.y;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collection<+Ld.l.b.a.b.m.aj;>;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class n
  implements at
{
  public static final a LFC;
  public final Set<ab> LFA;
  private final f LFB;
  private final y LbH;
  private final aj Lre;
  private final long value;
  
  static
  {
    AppMethodBeat.i(60083);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(n.class), "supertypes", "getSupertypes()Ljava/util/List;")) };
    LFC = new a((byte)0);
    AppMethodBeat.o(60083);
  }
  
  private n(long paramLong, y paramy, Set<? extends ab> paramSet)
  {
    AppMethodBeat.i(60088);
    g.a locala = d.l.b.a.b.b.a.g.LeU;
    this.Lre = ac.a(g.a.fSm(), this);
    this.LFB = d.g.K((a)new b(this));
    this.value = paramLong;
    this.LbH = paramy;
    this.LFA = paramSet;
    AppMethodBeat.o(60088);
  }
  
  public final boolean c(at paramat)
  {
    AppMethodBeat.i(60087);
    d.g.b.k.h(paramat, "constructor");
    Object localObject = (Iterable)this.LFA;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (d.g.b.k.g(((ab)((Iterator)localObject).next()).gbz(), paramat))
        {
          AppMethodBeat.o(60087);
          return true;
        }
      }
    }
    AppMethodBeat.o(60087);
    return false;
  }
  
  public final h fQq()
  {
    return null;
  }
  
  public final boolean fQs()
  {
    return false;
  }
  
  public final d.l.b.a.b.a.g fRE()
  {
    AppMethodBeat.i(60085);
    d.l.b.a.b.a.g localg = this.LbH.fRE();
    AppMethodBeat.o(60085);
    return localg;
  }
  
  public final Collection<ab> fSt()
  {
    AppMethodBeat.i(60084);
    Collection localCollection = (Collection)this.LFB.getValue();
    AppMethodBeat.o(60084);
    return localCollection;
  }
  
  public final List<as> getParameters()
  {
    return (List)v.KTF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60086);
    String str = "IntegerLiteralType" + new StringBuilder("[").append(j.a((Iterable)this.LFA, (CharSequence)",", null, null, 0, null, (b)c.LFH, 30)).append(']').toString();
    AppMethodBeat.o(60086);
    return str;
  }
  
  public static final class a
  {
    private static aj a(n paramn, aj paramaj)
    {
      AppMethodBeat.i(60079);
      if (paramn.LFA.contains(paramaj))
      {
        AppMethodBeat.o(60079);
        return paramaj;
      }
      AppMethodBeat.o(60079);
      return null;
    }
    
    public static aj w(Collection<? extends aj> paramCollection)
    {
      AppMethodBeat.i(60078);
      d.g.b.k.h(paramCollection, "types");
      a locala = a.LFE;
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
        Object localObject2 = n.LFC;
        if ((paramCollection == null) || (localObject1 == null))
        {
          paramCollection = null;
        }
        else
        {
          localObject2 = paramCollection.gbz();
          Object localObject3 = ((aj)localObject1).gbz();
          if (((localObject2 instanceof n)) && ((localObject3 instanceof n)))
          {
            localObject2 = (n)localObject2;
            paramCollection = (n)localObject3;
            Object localObject4;
            switch (o.cfA[locala.ordinal()])
            {
            default: 
              paramCollection = new m();
              AppMethodBeat.o(60078);
              throw paramCollection;
            case 1: 
              localObject1 = (Iterable)((n)localObject2).LFA;
              paramCollection = (Iterable)paramCollection.LFA;
              d.g.b.k.h(localObject1, "$this$intersect");
              d.g.b.k.h(paramCollection, "other");
              localObject1 = j.q((Iterable)localObject1);
              localObject3 = (Collection)localObject1;
              d.g.b.k.h(localObject3, "$this$retainAll");
              d.g.b.k.h(paramCollection, "elements");
              localObject4 = (Iterable)localObject3;
              d.g.b.k.h(paramCollection, "$this$convertToSetForSetOperationWith");
              d.g.b.k.h(localObject4, "source");
              if ((paramCollection instanceof Set))
              {
                paramCollection = (Collection)paramCollection;
                label296:
                aa.eO(localObject3).retainAll(paramCollection);
              }
              break;
            }
            for (paramCollection = (Collection<? extends aj>)localObject1;; paramCollection = j.a((Iterable)((n)localObject2).LFA, (Iterable)paramCollection.LFA))
            {
              paramCollection = new n(n.c((n)localObject2), n.d((n)localObject2), paramCollection, (byte)0);
              localObject1 = d.l.b.a.b.b.a.g.LeU;
              paramCollection = ac.a(g.a.fSm(), paramCollection);
              break;
              if ((paramCollection instanceof Collection))
              {
                if (((localObject4 instanceof Collection)) && (((Collection)localObject4).size() < 2))
                {
                  paramCollection = (Collection)paramCollection;
                  break label296;
                }
                localObject4 = (Collection)paramCollection;
                if ((((Collection)localObject4).size() > 2) && ((localObject4 instanceof ArrayList))) {}
                for (int i = 1;; i = 0)
                {
                  if (i != 0) {
                    break label426;
                  }
                  paramCollection = (Collection)paramCollection;
                  break;
                }
              }
              label426:
              paramCollection = (Collection)j.k(paramCollection);
              break label296;
            }
          }
          if ((localObject2 instanceof n)) {
            paramCollection = a((n)localObject2, (aj)localObject1);
          } else if ((localObject3 instanceof n)) {
            paramCollection = a((n)localObject3, paramCollection);
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
        LFD = locala1;
        a locala2 = new a("INTERSECTION_TYPE", 1);
        LFE = locala2;
        LFF = new a[] { locala1, locala2 };
        AppMethodBeat.o(60074);
      }
      
      private a() {}
    }
  }
  
  static final class b
    extends l
    implements a<List<aj>>
  {
    b(n paramn)
    {
      super();
    }
  }
  
  static final class c
    extends l
    implements b<ab, String>
  {
    public static final c LFH;
    
    static
    {
      AppMethodBeat.i(60082);
      LFH = new c();
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