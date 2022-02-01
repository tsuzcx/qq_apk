package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.o.i.b;
import kotlin.x;

public final class j
{
  public static final <H> Collection<H> b(Collection<? extends H> paramCollection, b<? super H, ? extends a> paramb)
  {
    AppMethodBeat.i(60009);
    p.k(paramCollection, "$this$selectMostSpecificInEachOverridableGroup");
    p.k(paramb, "descriptorByHandle");
    if (paramCollection.size() <= 1)
    {
      AppMethodBeat.o(60009);
      return paramCollection;
    }
    paramCollection = new LinkedList(paramCollection);
    Object localObject1 = kotlin.l.b.a.b.o.i.abuE;
    localObject1 = i.b.iQq();
    int i;
    if (!((Collection)paramCollection).isEmpty()) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        Object localObject3 = kotlin.a.j.lo((List)paramCollection);
        Object localObject2 = kotlin.l.b.a.b.o.i.abuE;
        localObject2 = i.b.iQq();
        Object localObject4 = i.a(localObject3, (Collection)paramCollection, paramb, (b)new b((kotlin.l.b.a.b.o.i)localObject2));
        p.j(localObject4, "OverridingUtil.extractMe…nflictedHandles.add(it) }");
        if ((((Collection)localObject4).size() == 1) && (((kotlin.l.b.a.b.o.i)localObject2).isEmpty()))
        {
          localObject2 = kotlin.a.j.i((Iterable)localObject4);
          p.j(localObject2, "overridableGroup.single()");
          ((kotlin.l.b.a.b.o.i)localObject1).add(localObject2);
          break;
          i = 0;
          continue;
        }
        localObject3 = i.a((Collection)localObject4, paramb);
        p.j(localObject3, "OverridingUtil.selectMos…roup, descriptorByHandle)");
        a locala = (a)paramb.invoke(localObject3);
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          p.j(localObject5, "it");
          if (!i.e(locala, (a)paramb.invoke(localObject5))) {
            ((Collection)localObject2).add(localObject5);
          }
        }
        if (!((Collection)localObject2).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            ((kotlin.l.b.a.b.o.i)localObject1).addAll((Collection)localObject2);
          }
          ((kotlin.l.b.a.b.o.i)localObject1).add(localObject3);
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
    public static final a abkM;
    
    static
    {
      AppMethodBeat.i(60007);
      abkM = new a();
      AppMethodBeat.o(60007);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements b<H, x>
  {
    b(kotlin.l.b.a.b.o.i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.b.a.b.j.j
 * JD-Core Version:    0.7.0.1
 */