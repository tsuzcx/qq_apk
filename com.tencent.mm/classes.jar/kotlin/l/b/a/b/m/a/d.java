package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.m.aa;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.af;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.t;
import kotlin.l.b.a.b.m.v;
import kotlin.l.b.a.b.m.x;

public final class d
{
  public static final bk pf(List<? extends bk> paramList)
  {
    AppMethodBeat.i(61045);
    s.u(paramList, "types");
    int j;
    int i;
    switch (paramList.size())
    {
    default: 
      localObject1 = (Iterable)paramList;
      localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      j = 0;
      i = 0;
      if (!localIterator.hasNext()) {
        break label231;
      }
      localObject1 = (bk)localIterator.next();
      if ((i != 0) || (af.ai((ad)localObject1)))
      {
        i = 1;
        label112:
        if (!(localObject1 instanceof al)) {
          break label179;
        }
        localObject1 = (al)localObject1;
      }
      break;
    }
    for (;;)
    {
      ((Collection)localObject2).add(localObject1);
      break;
      paramList = (Throwable)new IllegalStateException("Expected some types".toString());
      AppMethodBeat.o(61045);
      throw paramList;
      paramList = (bk)kotlin.a.p.oO(paramList);
      AppMethodBeat.o(61045);
      return paramList;
      i = 0;
      break label112;
      label179:
      if (!(localObject1 instanceof x)) {
        break label216;
      }
      if (t.aa((ad)localObject1))
      {
        AppMethodBeat.o(61045);
        return localObject1;
      }
      localObject1 = ((x)localObject1).ajpE;
      j = 1;
    }
    label216:
    paramList = new kotlin.p();
    AppMethodBeat.o(61045);
    throw paramList;
    label231:
    Object localObject1 = (List)localObject2;
    if (i != 0)
    {
      paramList = v.bJt(s.X("Intersection of error types: ", paramList));
      s.s(paramList, "createErrorType(\"Interse… of error types: $types\")");
      paramList = (bk)paramList;
      AppMethodBeat.o(61045);
      return paramList;
    }
    if (j == 0)
    {
      paramList = (bk)w.ajrt.ph((List)localObject1);
      AppMethodBeat.o(61045);
      return paramList;
    }
    Object localObject2 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramList.add(aa.af((ad)((Iterator)localObject2).next()));
    }
    paramList = (List)paramList;
    paramList = ae.a(w.ajrt.ph((List)localObject1), w.ajrt.ph(paramList));
    AppMethodBeat.o(61045);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.d
 * JD-Core Version:    0.7.0.1
 */