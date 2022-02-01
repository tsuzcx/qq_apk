package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.aa;
import d.g.a.b;
import d.g.b.k;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.u;
import d.m.h;
import d.m.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class at
{
  public static final af a(ab paramab, i parami, int paramInt)
  {
    AppMethodBeat.i(56894);
    if ((parami == null) || (u.L((l)parami)))
    {
      AppMethodBeat.o(56894);
      return null;
    }
    int j = parami.fQm().size() + paramInt;
    if (!parami.fQd())
    {
      if ((j == paramab.gbw().size()) || (d.l.b.a.b.j.c.m((l)parami))) {}
      for (int i = 1; (aa.KTq) && (i == 0); i = 0)
      {
        paramab = (Throwable)new AssertionError(paramab.gbw().size() - j + " trailing arguments were found in " + paramab + " type");
        AppMethodBeat.o(56894);
        throw paramab;
      }
      paramab = new af(parami, paramab.gbw().subList(paramInt, paramab.gbw().size()), null);
      AppMethodBeat.o(56894);
      return paramab;
    }
    List localList = paramab.gbw().subList(paramInt, j);
    l locall2 = parami.fPU();
    l locall1 = locall2;
    if (!(locall2 instanceof i)) {
      locall1 = null;
    }
    paramab = new af(parami, localList, a(paramab, (i)locall1, j));
    AppMethodBeat.o(56894);
    return paramab;
  }
  
  public static final List<as> a(i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(56893);
    k.h(parami, "$this$computeConstructorTypeParameters");
    List localList = parami.fQm();
    k.g(localList, "declaredTypeParameters");
    if ((!parami.fQd()) && (!(parami.fPU() instanceof a)))
    {
      AppMethodBeat.o(56893);
      return localList;
    }
    Object localObject1 = d.l.b.a.b.j.d.a.H((l)parami);
    Object localObject3 = (b)a.Lef;
    k.h(localObject1, "$this$takeWhile");
    k.h(localObject3, "predicate");
    localObject3 = d.m.i.c(d.m.i.c(d.m.i.a((h)new o((h)localObject1, (b)localObject3), (b)b.Leg), (b)c.Leh));
    Object localObject4 = d.l.b.a.b.j.d.a.H((l)parami).iterator();
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
        localObject4 = ((e)localObject4).fPW();
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((d.l.b.a.b.m.at)localObject4).getParameters();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (List)v.KTF;
      }
      if ((!((List)localObject3).isEmpty()) || (!((List)localObject2).isEmpty())) {
        break;
      }
      parami = parami.fQm();
      k.g(parami, "declaredTypeParameters");
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
      k.g(localObject3, "it");
      ((Collection)localObject1).add(new c((as)localObject3, (l)parami, localList.size()));
    }
    parami = (List)localObject1;
    parami = j.b((Collection)localList, (Iterable)parami);
    AppMethodBeat.o(56893);
    return parami;
  }
  
  static final class a
    extends d.g.b.l
    implements b<l, Boolean>
  {
    public static final a Lef;
    
    static
    {
      AppMethodBeat.i(56888);
      Lef = new a();
      AppMethodBeat.o(56888);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.l
    implements b<l, Boolean>
  {
    public static final b Leg;
    
    static
    {
      AppMethodBeat.i(56890);
      Leg = new b();
      AppMethodBeat.o(56890);
    }
    
    b()
    {
      super();
    }
  }
  
  static final class c
    extends d.g.b.l
    implements b<l, h<? extends as>>
  {
    public static final c Leh;
    
    static
    {
      AppMethodBeat.i(56892);
      Leh = new c();
      AppMethodBeat.o(56892);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.at
 * JD-Core Version:    0.7.0.1
 */