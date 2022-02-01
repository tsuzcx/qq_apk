package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.c.aj;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.o;

public final class k
{
  public static final List<av> a(Collection<l> paramCollection, Collection<? extends av> paramCollection1, kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(57732);
    p.h(paramCollection, "newValueParametersTypes");
    p.h(paramCollection1, "oldValueParameters");
    p.h(parama, "newOwner");
    if (paramCollection.size() == paramCollection1.size()) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      paramCollection = (Throwable)new AssertionError("Different value parameters sizes: Enhanced = " + paramCollection.size() + ", Old = " + paramCollection1.size());
      AppMethodBeat.o(57732);
      throw paramCollection;
    }
    paramCollection = (Iterable)j.c((Iterable)paramCollection, (Iterable)paramCollection1);
    paramCollection1 = (Collection)new ArrayList(j.a(paramCollection, 10));
    Iterator localIterator = paramCollection.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = (o)localIterator.next();
      paramCollection = (l)((o)localObject1).first;
      Object localObject2 = (av)((o)localObject1).second;
      i = ((av)localObject2).getIndex();
      localObject1 = ((av)localObject2).hzL();
      f localf = ((av)localObject2).hAH();
      p.g(localf, "oldParameter.name");
      ab localab = paramCollection.Tbs;
      boolean bool1 = paramCollection.TqL;
      boolean bool2 = ((av)localObject2).hBD();
      boolean bool3 = ((av)localObject2).hBE();
      if (((av)localObject2).hBB() != null) {}
      for (paramCollection = kotlin.l.b.a.b.j.d.a.F((kotlin.l.b.a.b.b.l)parama).hBh().l(paramCollection.Tbs);; paramCollection = null)
      {
        localObject2 = ((av)localObject2).hzM();
        p.g(localObject2, "oldParameter.source");
        paramCollection1.add(new aj(parama, null, i, (kotlin.l.b.a.b.b.a.g)localObject1, localf, localab, bool1, bool2, bool3, paramCollection, (an)localObject2));
        break;
      }
    }
    paramCollection = (List)paramCollection1;
    AppMethodBeat.o(57732);
    return paramCollection;
  }
  
  public static final kotlin.l.b.a.b.d.a.c.a.l s(e parame)
  {
    AppMethodBeat.i(57733);
    Object localObject;
    do
    {
      p.h(parame, "$this$getParentJavaStaticClassScope");
      e locale = kotlin.l.b.a.b.j.d.a.B(parame);
      if (locale == null)
      {
        AppMethodBeat.o(57733);
        return null;
      }
      localObject = locale.hzy();
      parame = (e)localObject;
      if (!(localObject instanceof kotlin.l.b.a.b.d.a.c.a.l)) {
        parame = null;
      }
      localObject = (kotlin.l.b.a.b.d.a.c.a.l)parame;
      parame = locale;
    } while (localObject == null);
    AppMethodBeat.o(57733);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.k
 * JD-Core Version:    0.7.0.1
 */