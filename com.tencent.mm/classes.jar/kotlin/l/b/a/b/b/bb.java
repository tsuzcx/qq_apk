package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ak;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.l.b.a.b.j.d;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.v;
import kotlin.m.h;
import kotlin.m.k;
import kotlin.m.q;

public final class bb
{
  public static final List<ba> a(i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(56893);
    s.u(parami, "<this>");
    List localList = parami.kno();
    s.s(localList, "declaredTypeParameters");
    if ((!parami.kne()) && (!(parami.knp() instanceof a)))
    {
      AppMethodBeat.o(56893);
      return localList;
    }
    Object localObject1 = kotlin.l.b.a.b.j.d.a.H((l)parami);
    Object localObject3 = (b)bb.a.aiHx;
    s.u(localObject1, "$this$takeWhile");
    s.u(localObject3, "predicate");
    localObject3 = k.d(k.c(k.a((h)new q((h)localObject1, (b)localObject3), (b)bb.b.aiHy), (b)bb.c.aiHz));
    Object localObject4 = kotlin.l.b.a.b.j.d.a.H((l)parami).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = ((Iterator)localObject4).next();
      if ((localObject1 instanceof e))
      {
        localObject1 = (e)localObject1;
        if (localObject1 != null) {
          break label226;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (List)ab.aivy;
      }
      if ((!((List)localObject3).isEmpty()) || (!((List)localObject2).isEmpty())) {
        break label252;
      }
      parami = parami.kno();
      s.s(parami, "declaredTypeParameters");
      AppMethodBeat.o(56893);
      return parami;
      localObject1 = null;
      break;
      label226:
      localObject4 = ((e)localObject1).kmZ();
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = ((ax)localObject4).klq();
      }
    }
    label252:
    localObject2 = (Iterable)p.b((Collection)localObject3, (Iterable)localObject2);
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ba)((Iterator)localObject2).next();
      s.s(localObject3, "it");
      ((Collection)localObject1).add(new c((ba)localObject3, (l)parami, localList.size()));
    }
    parami = (List)localObject1;
    parami = p.b((Collection)localList, (Iterable)parami);
    AppMethodBeat.o(56893);
    return parami;
  }
  
  public static final an a(ad paramad, i parami, int paramInt)
  {
    AppMethodBeat.i(56894);
    if ((parami == null) || (v.L((l)parami)))
    {
      AppMethodBeat.o(56894);
      return null;
    }
    int j = parami.kno().size() + paramInt;
    if (!parami.kne())
    {
      if ((j == paramad.klR().size()) || (d.m((l)parami))) {}
      for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
      {
        paramad = (Throwable)new AssertionError(paramad.klR().size() - j + " trailing arguments were found in " + paramad + " type");
        AppMethodBeat.o(56894);
        throw paramad;
      }
      paramad = new an(parami, paramad.klR().subList(paramInt, paramad.klR().size()), null);
      AppMethodBeat.o(56894);
      return paramad;
    }
    List localList = paramad.klR().subList(paramInt, j);
    Object localObject = parami.knp();
    if ((localObject instanceof i)) {}
    for (localObject = (i)localObject;; localObject = null)
    {
      paramad = new an(parami, localList, a(paramad, (i)localObject, j));
      AppMethodBeat.o(56894);
      return paramad;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.bb
 * JD-Core Version:    0.7.0.1
 */