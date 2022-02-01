package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.ac;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
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
    int j = parami.gmm().size() + paramInt;
    if (!parami.gmd())
    {
      if ((j == paramab.gxy().size()) || (d.l.b.a.b.j.c.m((l)parami))) {}
      for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
      {
        paramab = (Throwable)new AssertionError(paramab.gxy().size() - j + " trailing arguments were found in " + paramab + " type");
        AppMethodBeat.o(56894);
        throw paramab;
      }
      paramab = new af(parami, paramab.gxy().subList(paramInt, paramab.gxy().size()), null);
      AppMethodBeat.o(56894);
      return paramab;
    }
    List localList = paramab.gxy().subList(paramInt, j);
    l locall2 = parami.glU();
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
    p.h(parami, "$this$computeConstructorTypeParameters");
    List localList = parami.gmm();
    p.g(localList, "declaredTypeParameters");
    if ((!parami.gmd()) && (!(parami.glU() instanceof a)))
    {
      AppMethodBeat.o(56893);
      return localList;
    }
    Object localObject1 = d.l.b.a.b.j.d.a.H((l)parami);
    Object localObject3 = (b)a.Nsf;
    p.h(localObject1, "$this$takeWhile");
    p.h(localObject3, "predicate");
    localObject3 = d.m.i.c(d.m.i.c(d.m.i.a((h)new o((h)localObject1, (b)localObject3), (b)b.Nsg), (b)c.Nsh));
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
        localObject4 = ((e)localObject4).glW();
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((d.l.b.a.b.m.at)localObject4).getParameters();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (List)v.NhH;
      }
      if ((!((List)localObject3).isEmpty()) || (!((List)localObject2).isEmpty())) {
        break;
      }
      parami = parami.gmm();
      p.g(parami, "declaredTypeParameters");
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
      p.g(localObject3, "it");
      ((Collection)localObject1).add(new c((as)localObject3, (l)parami, localList.size()));
    }
    parami = (List)localObject1;
    parami = j.b((Collection)localList, (Iterable)parami);
    AppMethodBeat.o(56893);
    return parami;
  }
  
  static final class a
    extends q
    implements b<l, Boolean>
  {
    public static final a Nsf;
    
    static
    {
      AppMethodBeat.i(56888);
      Nsf = new a();
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
    public static final b Nsg;
    
    static
    {
      AppMethodBeat.i(56890);
      Nsg = new b();
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
    public static final c Nsh;
    
    static
    {
      AppMethodBeat.i(56892);
      Nsh = new c();
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