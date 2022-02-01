package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.aa;
import d.l.b.a.b.b.as;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.au;
import d.l.b.a.b.m.au.a;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.ay;
import d.l.b.a.b.m.ba;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.c.b;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class m
{
  public static final aj a(aj paramaj, b paramb)
  {
    AppMethodBeat.i(61083);
    d.g.b.k.h(paramaj, "type");
    d.g.b.k.h(paramb, "status");
    if (paramaj.gbw().size() != paramaj.gbz().getParameters().size())
    {
      AppMethodBeat.o(61083);
      return null;
    }
    List localList = paramaj.gbw();
    Object localObject1 = (Iterable)localList;
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext()) {
        if (((av)((Iterator)localObject1).next()).gcC() == bh.LLV)
        {
          i = 1;
          label126:
          if (i != 0) {
            break label146;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label153;
      }
      AppMethodBeat.o(61083);
      return null;
      i = 0;
      break label126;
      label146:
      break;
    }
    label153:
    localObject1 = (Iterable)localList;
    Object localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    Object localObject4 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject4).hasNext())
    {
      localObject2 = (av)((Iterator)localObject4).next();
      if (((av)localObject2).gcC() == bh.LLV)
      {
        localObject1 = localObject2;
        ((Collection)localObject3).add(localObject1);
      }
      else
      {
        if ((!((av)localObject2).gcB()) && (((av)localObject2).gcC() == bh.LLW)) {}
        for (localObject1 = ((av)localObject2).fRV().gcz();; localObject1 = null)
        {
          localObject1 = d.l.b.a.b.m.d.a.aO((ab)new k(paramb, (bg)localObject1, (av)localObject2));
          break;
        }
      }
    }
    paramb = (List)localObject3;
    localObject1 = au.LLE;
    localObject1 = au.a.a(paramaj.gbz(), paramb).gcD();
    int k = ((Collection)localList).size();
    i = 0;
    while (i < k)
    {
      localObject2 = (av)localList.get(i);
      localObject3 = (av)paramb.get(i);
      if (((av)localObject2).gcC() != bh.LLV)
      {
        localObject4 = paramaj.gbz().getParameters().get(i);
        d.g.b.k.g(localObject4, "type.constructor.parameters[index]");
        localObject4 = ((as)localObject4).fOJ();
        d.g.b.k.g(localObject4, "type.constructor.parameters[index].upperBounds");
        Object localObject5 = (Iterable)localObject4;
        localObject4 = (Collection)new ArrayList();
        localObject5 = ((Iterable)localObject5).iterator();
        Object localObject6;
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (ab)((Iterator)localObject5).next();
          n.a locala = n.LMu;
          n.a.gcI();
          ((Collection)localObject4).add(o.c(((ba)localObject1).b((ab)localObject6, bh.LLV).gcz()));
        }
        localObject4 = (List)localObject4;
        if ((!((av)localObject2).gcB()) && (((av)localObject2).gcC() == bh.LLX))
        {
          localObject5 = (Collection)localObject4;
          localObject6 = n.LMu;
          n.a.gcI();
          ((Collection)localObject5).add(o.c(((av)localObject2).fRV().gcz()));
        }
        localObject2 = ((av)localObject3).fRV();
        if (localObject2 == null)
        {
          paramaj = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
          AppMethodBeat.o(61083);
          throw paramaj;
        }
        localObject2 = ((k)localObject2).LMm;
        d.g.b.k.h(localObject4, "supertypes");
        if (((l)localObject2).LMp == null) {}
        for (int j = 1; (aa.KTq) && (j == 0); j = 0)
        {
          paramaj = (Throwable)new AssertionError("Already initialized! oldValue = " + ((l)localObject2).LMp + ", newValue = " + localObject4);
          AppMethodBeat.o(61083);
          throw paramaj;
        }
        ((l)localObject2).LMp = ((d.g.a.a)new l.b((List)localObject4));
      }
      i += 1;
    }
    paramaj = ac.c(paramaj.fQj(), paramaj.gbz(), paramb, paramaj.fUx());
    AppMethodBeat.o(61083);
    return paramaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.a.m
 * JD-Core Version:    0.7.0.1
 */