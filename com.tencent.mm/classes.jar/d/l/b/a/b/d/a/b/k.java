package d.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.aa;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.c.aj;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.ab;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class k
{
  public static final List<av> a(Collection<l> paramCollection, Collection<? extends av> paramCollection1, d.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(57732);
    d.g.b.k.h(paramCollection, "newValueParametersTypes");
    d.g.b.k.h(paramCollection1, "oldValueParameters");
    d.g.b.k.h(parama, "newOwner");
    if (paramCollection.size() == paramCollection1.size()) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0)
    {
      paramCollection = (Throwable)new AssertionError("Different value parameters sizes: Enhanced = " + paramCollection.size() + ", Old = " + paramCollection1.size());
      AppMethodBeat.o(57732);
      throw paramCollection;
    }
    paramCollection = (Iterable)j.b((Iterable)paramCollection, (Iterable)paramCollection1);
    paramCollection1 = (Collection)new ArrayList(j.a(paramCollection, 10));
    Iterator localIterator = paramCollection.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = (o)localIterator.next();
      paramCollection = (l)((o)localObject1).first;
      Object localObject2 = (av)((o)localObject1).second;
      i = ((av)localObject2).getIndex();
      localObject1 = ((av)localObject2).fxF();
      f localf = ((av)localObject2).fyB();
      d.g.b.k.g(localf, "oldParameter.name");
      ab localab = paramCollection.Jko;
      boolean bool1 = paramCollection.JzI;
      boolean bool2 = ((av)localObject2).fzw();
      boolean bool3 = ((av)localObject2).fzx();
      if (((av)localObject2).fzu() != null) {}
      for (paramCollection = d.l.b.a.b.j.d.a.F((d.l.b.a.b.b.l)parama).fza().l(paramCollection.Jko);; paramCollection = null)
      {
        localObject2 = ((av)localObject2).fxG();
        d.g.b.k.g(localObject2, "oldParameter.source");
        paramCollection1.add(new aj(parama, null, i, (d.l.b.a.b.b.a.g)localObject1, localf, localab, bool1, bool2, bool3, paramCollection, (an)localObject2));
        break;
      }
    }
    paramCollection = (List)paramCollection1;
    AppMethodBeat.o(57732);
    return paramCollection;
  }
  
  public static final d.l.b.a.b.d.a.c.a.l s(e parame)
  {
    AppMethodBeat.i(57733);
    Object localObject;
    do
    {
      d.g.b.k.h(parame, "$this$getParentJavaStaticClassScope");
      e locale = d.l.b.a.b.j.d.a.B(parame);
      if (locale == null)
      {
        AppMethodBeat.o(57733);
        return null;
      }
      localObject = locale.fxr();
      parame = (e)localObject;
      if (!(localObject instanceof d.l.b.a.b.d.a.c.a.l)) {
        parame = null;
      }
      localObject = (d.l.b.a.b.d.a.c.a.l)parame;
      parame = locale;
    } while (localObject == null);
    AppMethodBeat.o(57733);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.b.k
 * JD-Core Version:    0.7.0.1
 */