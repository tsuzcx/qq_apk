package d.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.a;
import d.l.b.a.b.o.i.b;
import d.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
{
  public static final <H> Collection<H> b(Collection<? extends H> paramCollection, b<? super H, ? extends a> paramb)
  {
    AppMethodBeat.i(60009);
    p.h(paramCollection, "$this$selectMostSpecificInEachOverridableGroup");
    p.h(paramb, "descriptorByHandle");
    if (paramCollection.size() <= 1)
    {
      AppMethodBeat.o(60009);
      return paramCollection;
    }
    paramCollection = new LinkedList(paramCollection);
    Object localObject1 = d.l.b.a.b.o.i.Odl;
    localObject1 = i.b.gyW();
    int i;
    if (!((Collection)paramCollection).isEmpty()) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        Object localObject3 = d.a.j.jl((List)paramCollection);
        Object localObject2 = d.l.b.a.b.o.i.Odl;
        localObject2 = i.b.gyW();
        Object localObject4 = i.a(localObject3, (Collection)paramCollection, paramb, (b)new b((d.l.b.a.b.o.i)localObject2));
        p.g(localObject4, "OverridingUtil.extractMe…nflictedHandles.add(it) }");
        if ((((Collection)localObject4).size() == 1) && (((d.l.b.a.b.o.i)localObject2).isEmpty()))
        {
          localObject2 = d.a.j.f((Iterable)localObject4);
          p.g(localObject2, "overridableGroup.single()");
          ((d.l.b.a.b.o.i)localObject1).add(localObject2);
          break;
          i = 0;
          continue;
        }
        localObject3 = i.a((Collection)localObject4, paramb);
        p.g(localObject3, "OverridingUtil.selectMos…roup, descriptorByHandle)");
        a locala = (a)paramb.invoke(localObject3);
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          p.g(localObject5, "it");
          if (!i.e(locala, (a)paramb.invoke(localObject5))) {
            ((Collection)localObject2).add(localObject5);
          }
        }
        if (!((Collection)localObject2).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            ((d.l.b.a.b.o.i)localObject1).addAll((Collection)localObject2);
          }
          ((d.l.b.a.b.o.i)localObject1).add(localObject3);
          break;
        }
      }
    }
    paramCollection = (Collection)localObject1;
    AppMethodBeat.o(60009);
    return paramCollection;
  }
  
  public static final class a
    extends q
    implements b<D, D>
  {
    public static final a NTm;
    
    static
    {
      AppMethodBeat.i(60007);
      NTm = new a();
      AppMethodBeat.o(60007);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements b<H, z>
  {
    b(d.l.b.a.b.o.i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.j
 * JD-Core Version:    0.7.0.1
 */