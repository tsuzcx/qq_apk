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
  public static final a JSj;
  private final aj JDL;
  public final Set<ab> JSh;
  private final f JSi;
  private final y Jon;
  private final long value;
  
  static
  {
    AppMethodBeat.i(60083);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(n.class), "supertypes", "getSupertypes()Ljava/util/List;")) };
    JSj = new a((byte)0);
    AppMethodBeat.o(60083);
  }
  
  private n(long paramLong, y paramy, Set<? extends ab> paramSet)
  {
    AppMethodBeat.i(60088);
    g.a locala = d.l.b.a.b.b.a.g.JrB;
    this.JDL = ac.a(g.a.fzI(), this);
    this.JSi = d.g.E((a)new b(this));
    this.value = paramLong;
    this.Jon = paramy;
    this.JSh = paramSet;
    AppMethodBeat.o(60088);
  }
  
  public final boolean c(at paramat)
  {
    AppMethodBeat.i(60087);
    d.g.b.k.h(paramat, "constructor");
    Object localObject = (Iterable)this.JSh;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (d.g.b.k.g(((ab)((Iterator)localObject).next()).fIW(), paramat))
        {
          AppMethodBeat.o(60087);
          return true;
        }
      }
    }
    AppMethodBeat.o(60087);
    return false;
  }
  
  public final h fxM()
  {
    return null;
  }
  
  public final boolean fxO()
  {
    return false;
  }
  
  public final Collection<ab> fzP()
  {
    AppMethodBeat.i(60084);
    Collection localCollection = (Collection)this.JSi.getValue();
    AppMethodBeat.o(60084);
    return localCollection;
  }
  
  public final d.l.b.a.b.a.g fza()
  {
    AppMethodBeat.i(60085);
    d.l.b.a.b.a.g localg = this.Jon.fza();
    AppMethodBeat.o(60085);
    return localg;
  }
  
  public final List<as> getParameters()
  {
    return (List)v.Jgl;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60086);
    String str = "IntegerLiteralType" + new StringBuilder("[").append(j.a((Iterable)this.JSh, (CharSequence)",", null, null, 0, null, (b)n.c.JSo, 30)).append(']').toString();
    AppMethodBeat.o(60086);
    return str;
  }
  
  public static final class a
  {
    private static aj a(n paramn, aj paramaj)
    {
      AppMethodBeat.i(60079);
      if (paramn.JSh.contains(paramaj))
      {
        AppMethodBeat.o(60079);
        return paramaj;
      }
      AppMethodBeat.o(60079);
      return null;
    }
    
    public static aj v(Collection<? extends aj> paramCollection)
    {
      AppMethodBeat.i(60078);
      d.g.b.k.h(paramCollection, "types");
      n.a.a locala = n.a.a.JSl;
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
        Object localObject2 = n.JSj;
        if ((paramCollection == null) || (localObject1 == null))
        {
          paramCollection = null;
        }
        else
        {
          localObject2 = paramCollection.fIW();
          Object localObject3 = ((aj)localObject1).fIW();
          if (((localObject2 instanceof n)) && ((localObject3 instanceof n)))
          {
            localObject2 = (n)localObject2;
            paramCollection = (n)localObject3;
            Object localObject4;
            switch (o.ciE[locala.ordinal()])
            {
            default: 
              paramCollection = new m();
              AppMethodBeat.o(60078);
              throw paramCollection;
            case 1: 
              localObject1 = (Iterable)((n)localObject2).JSh;
              paramCollection = (Iterable)paramCollection.JSh;
              d.g.b.k.h(localObject1, "$this$intersect");
              d.g.b.k.h(paramCollection, "other");
              localObject1 = j.r((Iterable)localObject1);
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
                aa.eL(localObject3).retainAll(paramCollection);
              }
              break;
            }
            for (paramCollection = (Collection<? extends aj>)localObject1;; paramCollection = j.a((Iterable)((n)localObject2).JSh, (Iterable)paramCollection.JSh))
            {
              paramCollection = new n(n.c((n)localObject2), n.d((n)localObject2), paramCollection, (byte)0);
              localObject1 = d.l.b.a.b.b.a.g.JrB;
              paramCollection = ac.a(g.a.fzI(), paramCollection);
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
              paramCollection = (Collection)j.l(paramCollection);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.b.n
 * JD-Core Version:    0.7.0.1
 */