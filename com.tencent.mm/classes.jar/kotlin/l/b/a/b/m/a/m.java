package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.au;
import kotlin.l.b.a.b.m.au.a;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.ba;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.c.b;
import kotlin.t;
import kotlin.z;

public final class m
{
  public static final aj a(aj paramaj, b paramb)
  {
    AppMethodBeat.i(61083);
    p.k(paramaj, "type");
    p.k(paramb, "status");
    if (paramaj.iOR().size() != paramaj.iOU().iCb().size())
    {
      AppMethodBeat.o(61083);
      return null;
    }
    List localList = paramaj.iOR();
    Object localObject1 = (Iterable)localList;
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext()) {
        if (((av)((Iterator)localObject1).next()).iQa() == bh.abrp)
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
    Object localObject2 = paramaj.iOU().iCb();
    p.j(localObject2, "type.constructor.parameters");
    localObject1 = (Iterable)j.c((Iterable)localObject1, (Iterable)localObject2);
    Object localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    Object localObject4 = ((Iterable)localObject1).iterator();
    Object localObject5;
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (kotlin.o)((Iterator)localObject4).next();
      localObject2 = (av)((kotlin.o)localObject1).Mx;
      localObject5 = (as)((kotlin.o)localObject1).My;
      if (((av)localObject2).iQa() == bh.abrp)
      {
        localObject1 = localObject2;
        ((Collection)localObject3).add(localObject1);
      }
      else
      {
        if ((!((av)localObject2).iPZ()) && (((av)localObject2).iQa() == bh.abrq)) {}
        for (localObject1 = ((av)localObject2).iFN().iPX();; localObject1 = null)
        {
          p.j(localObject5, "parameter");
          localObject1 = kotlin.l.b.a.b.m.d.a.aN((ab)new k(paramb, (bg)localObject1, (av)localObject2, (as)localObject5));
          break;
        }
      }
    }
    paramb = (List)localObject3;
    localObject1 = au.abqZ;
    localObject1 = au.a.a(paramaj.iOU(), paramb).iQb();
    int k = ((Collection)localList).size();
    i = 0;
    while (i < k)
    {
      localObject2 = (av)localList.get(i);
      localObject3 = (av)paramb.get(i);
      if (((av)localObject2).iQa() != bh.abrp)
      {
        localObject4 = paramaj.iOU().iCb().get(i);
        p.j(localObject4, "type.constructor.parameters[index]");
        localObject4 = ((as)localObject4).iCz();
        p.j(localObject4, "type.constructor.parameters[index].upperBounds");
        localObject5 = (Iterable)localObject4;
        localObject4 = (Collection)new ArrayList();
        localObject5 = ((Iterable)localObject5).iterator();
        Object localObject6;
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (ab)((Iterator)localObject5).next();
          n.a locala = n.abrP;
          n.a.iQg();
          ((Collection)localObject4).add(o.c(((ba)localObject1).b((ab)localObject6, bh.abrp).iPX()));
        }
        localObject4 = (List)localObject4;
        if ((!((av)localObject2).iPZ()) && (((av)localObject2).iQa() == bh.abrr))
        {
          localObject5 = (Collection)localObject4;
          localObject6 = n.abrP;
          n.a.iQg();
          ((Collection)localObject5).add(o.c(((av)localObject2).iFN().iPX()));
        }
        localObject2 = ((av)localObject3).iFN();
        if (localObject2 == null)
        {
          paramaj = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
          AppMethodBeat.o(61083);
          throw paramaj;
        }
        localObject2 = ((k)localObject2).abrH;
        p.k(localObject4, "supertypes");
        if (((l)localObject2).abrK == null) {}
        for (int j = 1; (z.aazO) && (j == 0); j = 0)
        {
          paramaj = (Throwable)new AssertionError("Already initialized! oldValue = " + ((l)localObject2).abrK + ", newValue = " + localObject4);
          AppMethodBeat.o(61083);
          throw paramaj;
        }
        ((l)localObject2).abrK = ((kotlin.g.a.a)new l.b((List)localObject4));
      }
      i += 1;
    }
    paramaj = ac.c(paramaj.iDY(), paramaj.iOU(), paramb, paramaj.iIu());
    AppMethodBeat.o(61083);
    return paramaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.m
 * JD-Core Version:    0.7.0.1
 */