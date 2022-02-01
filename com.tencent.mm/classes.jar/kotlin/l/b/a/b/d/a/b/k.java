package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.c.aj;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.o;
import kotlin.z;

public final class k
{
  public static final List<av> a(Collection<l> paramCollection, Collection<? extends av> paramCollection1, kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(57732);
    p.k(paramCollection, "newValueParametersTypes");
    p.k(paramCollection1, "oldValueParameters");
    p.k(parama, "newOwner");
    if (paramCollection.size() == paramCollection1.size()) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
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
      paramCollection = (l)((o)localObject1).Mx;
      Object localObject2 = (av)((o)localObject1).My;
      i = ((av)localObject2).getIndex();
      localObject1 = ((av)localObject2).iDY();
      f localf = ((av)localObject2).iEU();
      p.j(localf, "oldParameter.name");
      ab localab = paramCollection.aaEm;
      boolean bool1 = paramCollection.aaTF;
      boolean bool2 = ((av)localObject2).iFS();
      boolean bool3 = ((av)localObject2).iFT();
      if (((av)localObject2).iFQ() != null) {}
      for (paramCollection = kotlin.l.b.a.b.j.d.a.F((kotlin.l.b.a.b.b.l)parama).iFv().l(paramCollection.aaEm);; paramCollection = null)
      {
        localObject2 = ((av)localObject2).iDZ();
        p.j(localObject2, "oldParameter.source");
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
      p.k(parame, "$this$getParentJavaStaticClassScope");
      e locale = kotlin.l.b.a.b.j.d.a.B(parame);
      if (locale == null)
      {
        AppMethodBeat.o(57733);
        return null;
      }
      localObject = locale.iDK();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.k
 * JD-Core Version:    0.7.0.1
 */