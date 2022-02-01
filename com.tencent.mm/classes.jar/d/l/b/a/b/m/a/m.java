package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l.b.a.b.b.as;
import d.l.b.a.b.m.ab;
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
    p.h(paramaj, "type");
    p.h(paramb, "status");
    if (paramaj.gsW().size() != paramaj.gsZ().getParameters().size())
    {
      AppMethodBeat.o(61083);
      return null;
    }
    List localList = paramaj.gsW();
    Object localObject1 = (Iterable)localList;
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext()) {
        if (((av)((Iterator)localObject1).next()).gud() == bh.NCP)
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
    Object localObject2 = paramaj.gsZ().getParameters();
    p.g(localObject2, "type.constructor.parameters");
    localObject1 = (Iterable)j.c((Iterable)localObject1, (Iterable)localObject2);
    Object localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    Object localObject4 = ((Iterable)localObject1).iterator();
    Object localObject5;
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (d.o)((Iterator)localObject4).next();
      localObject2 = (av)((d.o)localObject1).first;
      localObject5 = (as)((d.o)localObject1).second;
      if (((av)localObject2).gud() == bh.NCP)
      {
        localObject1 = localObject2;
        ((Collection)localObject3).add(localObject1);
      }
      else
      {
        if ((!((av)localObject2).guc()) && (((av)localObject2).gud() == bh.NCQ)) {}
        for (localObject1 = ((av)localObject2).gju().gua();; localObject1 = null)
        {
          p.g(localObject5, "parameter");
          localObject1 = d.l.b.a.b.m.d.a.aO((ab)new k(paramb, (bg)localObject1, (av)localObject2, (as)localObject5));
          break;
        }
      }
    }
    paramb = (List)localObject3;
    localObject1 = au.NCz;
    localObject1 = au.a.a(paramaj.gsZ(), paramb).gue();
    int k = ((Collection)localList).size();
    i = 0;
    while (i < k)
    {
      localObject2 = (av)localList.get(i);
      localObject3 = (av)paramb.get(i);
      if (((av)localObject2).gud() != bh.NCP)
      {
        localObject4 = paramaj.gsZ().getParameters().get(i);
        p.g(localObject4, "type.constructor.parameters[index]");
        localObject4 = ((as)localObject4).ggj();
        p.g(localObject4, "type.constructor.parameters[index].upperBounds");
        localObject5 = (Iterable)localObject4;
        localObject4 = (Collection)new ArrayList();
        localObject5 = ((Iterable)localObject5).iterator();
        Object localObject6;
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (ab)((Iterator)localObject5).next();
          n.a locala = n.NDp;
          n.a.guj();
          ((Collection)localObject4).add(o.c(((ba)localObject1).b((ab)localObject6, bh.NCP).gua()));
        }
        localObject4 = (List)localObject4;
        if ((!((av)localObject2).guc()) && (((av)localObject2).gud() == bh.NCR))
        {
          localObject5 = (Collection)localObject4;
          localObject6 = n.NDp;
          n.a.guj();
          ((Collection)localObject5).add(o.c(((av)localObject2).gju().gua()));
        }
        localObject2 = ((av)localObject3).gju();
        if (localObject2 == null)
        {
          paramaj = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
          AppMethodBeat.o(61083);
          throw paramaj;
        }
        localObject2 = ((k)localObject2).NDh;
        p.h(localObject4, "supertypes");
        if (((l)localObject2).NDk == null) {}
        for (int j = 1; (d.ac.MKp) && (j == 0); j = 0)
        {
          paramaj = (Throwable)new AssertionError("Already initialized! oldValue = " + ((l)localObject2).NDk + ", newValue = " + localObject4);
          AppMethodBeat.o(61083);
          throw paramaj;
        }
        ((l)localObject2).NDk = ((d.g.a.a)new l.b((List)localObject4));
      }
      i += 1;
    }
    paramaj = d.l.b.a.b.m.ac.c(paramaj.ghH(), paramaj.gsZ(), paramb, paramaj.glW());
    AppMethodBeat.o(61083);
    return paramaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.a.m
 * JD-Core Version:    0.7.0.1
 */