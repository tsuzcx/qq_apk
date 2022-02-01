package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.a.c.a.k;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ad;
import kotlin.r;

public final class h
{
  public static final List<bd> a(Collection<i> paramCollection, Collection<? extends bd> paramCollection1, kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(57732);
    s.u(paramCollection, "newValueParametersTypes");
    s.u(paramCollection1, "oldValueParameters");
    s.u(parama, "newOwner");
    if (paramCollection.size() == paramCollection1.size()) {}
    for (int i = 1; (kotlin.ak.aiuY) && (i == 0); i = 0)
    {
      paramCollection = (Throwable)new AssertionError("Different value parameters sizes: Enhanced = " + paramCollection.size() + ", Old = " + paramCollection1.size());
      AppMethodBeat.o(57732);
      throw paramCollection;
    }
    paramCollection = (Iterable)p.d((Iterable)paramCollection, (Iterable)paramCollection1);
    paramCollection1 = (Collection)new ArrayList(p.a(paramCollection, 10));
    Iterator localIterator = paramCollection.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = (r)localIterator.next();
      paramCollection = (i)((r)localObject1).bsC;
      Object localObject2 = (bd)((r)localObject1).bsD;
      i = ((bd)localObject2).getIndex();
      localObject1 = ((bd)localObject2).knl();
      f localf = ((bd)localObject2).kok();
      s.s(localf, "oldParameter.name");
      ad localad = paramCollection.aiAd;
      boolean bool1 = paramCollection.aiRF;
      boolean bool2 = ((bd)localObject2).kps();
      boolean bool3 = ((bd)localObject2).kpt();
      if (((bd)localObject2).kpq() != null) {}
      for (paramCollection = kotlin.l.b.a.b.j.d.a.F((l)parama).koV().l(paramCollection.aiAd);; paramCollection = null)
      {
        localObject2 = ((bd)localObject2).knm();
        s.s(localObject2, "oldParameter.source");
        paramCollection1.add(new kotlin.l.b.a.b.b.c.ak(parama, null, i, (g)localObject1, localf, localad, bool1, bool2, bool3, paramCollection, (av)localObject2));
        break;
      }
    }
    paramCollection = (List)paramCollection1;
    AppMethodBeat.o(57732);
    return paramCollection;
  }
  
  public static final k q(e parame)
  {
    AppMethodBeat.i(57733);
    e locale = parame;
    for (;;)
    {
      s.u(locale, "<this>");
      locale = kotlin.l.b.a.b.j.d.a.C(locale);
      if (locale == null)
      {
        AppMethodBeat.o(57733);
        return null;
      }
      parame = locale.knq();
      if ((parame instanceof k)) {}
      for (parame = (k)parame; parame != null; parame = null)
      {
        AppMethodBeat.o(57733);
        return parame;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.h
 * JD-Core Version:    0.7.0.1
 */