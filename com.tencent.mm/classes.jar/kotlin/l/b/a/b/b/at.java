package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.u;
import kotlin.m.h;
import kotlin.m.o;
import kotlin.z;

public final class at
{
  public static final List<as> a(i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(56893);
    p.k(parami, "$this$computeConstructorTypeParameters");
    List localList = parami.iEb();
    p.j(localList, "declaredTypeParameters");
    if ((!parami.iDS()) && (!(parami.iDJ() instanceof a)))
    {
      AppMethodBeat.o(56893);
      return localList;
    }
    Object localObject1 = kotlin.l.b.a.b.j.d.a.H((l)parami);
    Object localObject3 = (b)a.aaKH;
    p.k(localObject1, "$this$takeWhile");
    p.k(localObject3, "predicate");
    localObject3 = kotlin.m.i.c(kotlin.m.i.c(kotlin.m.i.a((h)new o((h)localObject1, (b)localObject3), (b)b.aaKI), (b)c.aaKJ));
    Object localObject4 = kotlin.l.b.a.b.j.d.a.H((l)parami).iterator();
    do
    {
      if (!((Iterator)localObject4).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject4).next();
    } while (!(localObject1 instanceof e));
    for (;;)
    {
      localObject4 = (e)localObject1;
      localObject1 = localObject2;
      if (localObject4 != null)
      {
        localObject4 = ((e)localObject4).iDL();
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((kotlin.l.b.a.b.m.at)localObject4).iCb();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (List)v.aaAd;
      }
      if ((!((List)localObject3).isEmpty()) || (!((List)localObject2).isEmpty())) {
        break;
      }
      parami = parami.iEb();
      p.j(parami, "declaredTypeParameters");
      AppMethodBeat.o(56893);
      return parami;
      localObject1 = null;
    }
    localObject2 = (Iterable)j.b((Collection)localObject3, (Iterable)localObject2);
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (as)((Iterator)localObject2).next();
      p.j(localObject3, "it");
      ((Collection)localObject1).add(new c((as)localObject3, (l)parami, localList.size()));
    }
    parami = (List)localObject1;
    parami = j.b((Collection)localList, (Iterable)parami);
    AppMethodBeat.o(56893);
    return parami;
  }
  
  public static final af a(ab paramab, i parami, int paramInt)
  {
    AppMethodBeat.i(56894);
    if ((parami == null) || (u.L((l)parami)))
    {
      AppMethodBeat.o(56894);
      return null;
    }
    int j = parami.iEb().size() + paramInt;
    if (!parami.iDS())
    {
      if ((j == paramab.iOR().size()) || (kotlin.l.b.a.b.j.c.m((l)parami))) {}
      for (int i = 1; (z.aazO) && (i == 0); i = 0)
      {
        paramab = (Throwable)new AssertionError(paramab.iOR().size() - j + " trailing arguments were found in " + paramab + " type");
        AppMethodBeat.o(56894);
        throw paramab;
      }
      paramab = new af(parami, paramab.iOR().subList(paramInt, paramab.iOR().size()), null);
      AppMethodBeat.o(56894);
      return paramab;
    }
    List localList = paramab.iOR().subList(paramInt, j);
    l locall2 = parami.iDJ();
    l locall1 = locall2;
    if (!(locall2 instanceof i)) {
      locall1 = null;
    }
    paramab = new af(parami, localList, a(paramab, (i)locall1, j));
    AppMethodBeat.o(56894);
    return paramab;
  }
  
  static final class a
    extends q
    implements b<l, Boolean>
  {
    public static final a aaKH;
    
    static
    {
      AppMethodBeat.i(56888);
      aaKH = new a();
      AppMethodBeat.o(56888);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements b<l, Boolean>
  {
    public static final b aaKI;
    
    static
    {
      AppMethodBeat.i(56890);
      aaKI = new b();
      AppMethodBeat.o(56890);
    }
    
    b()
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements b<l, h<? extends as>>
  {
    public static final c aaKJ;
    
    static
    {
      AppMethodBeat.i(56892);
      aaKJ = new c();
      AppMethodBeat.o(56892);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.at
 * JD-Core Version:    0.7.0.1
 */