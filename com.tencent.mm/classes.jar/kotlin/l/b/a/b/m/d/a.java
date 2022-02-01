package kotlin.l.b.a.b.m.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.ao;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.v;
import kotlin.m;
import kotlin.z;

public final class a
{
  public static final ab a(ab paramab, kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(61252);
    p.k(paramab, "$this$replaceAnnotations");
    p.k(paramg, "newAnnotations");
    if ((paramab.iDY().isEmpty()) && (paramg.isEmpty()))
    {
      AppMethodBeat.o(61252);
      return paramab;
    }
    paramab = (ab)paramab.iPX().b(paramg);
    AppMethodBeat.o(61252);
    return paramab;
  }
  
  public static final av a(ab paramab, bh parambh, as paramas)
  {
    AppMethodBeat.i(61253);
    p.k(paramab, "type");
    p.k(parambh, "projectionKind");
    if (paramas != null) {}
    for (paramas = paramas.iEW();; paramas = null)
    {
      bh localbh = parambh;
      if (paramas == parambh) {
        localbh = bh.abrp;
      }
      paramab = (av)new ax(localbh, paramab);
      AppMethodBeat.o(61253);
      return paramab;
    }
  }
  
  public static final ab aC(ab paramab)
  {
    AppMethodBeat.i(61248);
    p.k(paramab, "$this$makeNullable");
    paramab = bc.aC(paramab);
    p.j(paramab, "TypeUtils.makeNullable(this)");
    AppMethodBeat.o(61248);
    return paramab;
  }
  
  public static final ab aD(ab paramab)
  {
    AppMethodBeat.i(61249);
    p.k(paramab, "$this$makeNotNullable");
    paramab = bc.aD(paramab);
    p.j(paramab, "TypeUtils.makeNotNullable(this)");
    AppMethodBeat.o(61249);
    return paramab;
  }
  
  public static final boolean aH(ab paramab)
  {
    AppMethodBeat.i(61250);
    p.k(paramab, "$this$isTypeParameter");
    boolean bool = bc.aH(paramab);
    AppMethodBeat.o(61250);
    return bool;
  }
  
  public static final kotlin.l.b.a.b.a.g aM(ab paramab)
  {
    AppMethodBeat.i(61247);
    p.k(paramab, "$this$builtIns");
    paramab = paramab.iOU().iFv();
    p.j(paramab, "constructor.builtIns");
    AppMethodBeat.o(61247);
    return paramab;
  }
  
  public static final av aN(ab paramab)
  {
    AppMethodBeat.i(61254);
    p.k(paramab, "$this$asTypeProjection");
    paramab = (av)new ax(paramab);
    AppMethodBeat.o(61254);
    return paramab;
  }
  
  public static final ab aO(ab paramab)
  {
    AppMethodBeat.i(61255);
    p.k(paramab, "$this$replaceArgumentsWithStarProjections");
    bg localbg = paramab.iPX();
    aj localaj;
    Object localObject1;
    if ((localbg instanceof v))
    {
      localaj = ((v)localbg).abqv;
      paramab = localaj;
      if (!localaj.iOU().iCb().isEmpty())
      {
        if (localaj.iOU().iEf() == null) {
          paramab = localaj;
        }
      }
      else
      {
        localaj = ((v)localbg).abqw;
        if ((!localaj.iOU().iCb().isEmpty()) && (localaj.iOU().iEf() != null)) {
          break label220;
        }
      }
      for (;;)
      {
        paramab = ac.a(paramab, localaj);
        paramab = (ab)be.a(paramab, (ab)localbg);
        AppMethodBeat.o(61255);
        return paramab;
        paramab = localaj.iOU().iCb();
        p.j(paramab, "constructor.parameters");
        localObject1 = (Iterable)paramab;
        paramab = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramab.add(new ao((as)((Iterator)localObject1).next()));
        }
        paramab = az.a(localaj, (List)paramab, null, 2);
        break;
        label220:
        localObject1 = localaj.iOU().iCb();
        p.j(localObject1, "constructor.parameters");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(new ao((as)((Iterator)localObject2).next()));
        }
        localaj = az.a(localaj, (List)localObject1, null, 2);
      }
    }
    if ((localbg instanceof aj))
    {
      localaj = (aj)localbg;
      paramab = localaj;
      if (!localaj.iOU().iCb().isEmpty()) {
        if (localaj.iOU().iEf() != null) {
          break label373;
        }
      }
      for (paramab = localaj;; paramab = az.a(localaj, (List)paramab, null, 2))
      {
        paramab = (bg)paramab;
        break;
        label373:
        paramab = localaj.iOU().iCb();
        p.j(paramab, "constructor.parameters");
        localObject1 = (Iterable)paramab;
        paramab = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramab.add(new ao((as)((Iterator)localObject1).next()));
        }
      }
    }
    paramab = new m();
    AppMethodBeat.o(61255);
    throw paramab;
  }
  
  public static final boolean c(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61251);
    p.k(paramab1, "$this$isSubtypeOf");
    p.k(paramab2, "superType");
    boolean bool = kotlin.l.b.a.b.m.a.g.abrB.c(paramab1, paramab2);
    AppMethodBeat.o(61251);
    return bool;
  }
  
  public static final ab e(as paramas)
  {
    AppMethodBeat.i(61256);
    p.k(paramas, "$this$representativeUpperBound");
    Object localObject1 = paramas.iCz();
    p.j(localObject1, "upperBounds");
    if (!((Collection)localObject1).isEmpty()) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      paramas = (Throwable)new AssertionError("Upper bounds should not be empty: ".concat(String.valueOf(paramas)));
      AppMethodBeat.o(61256);
      throw paramas;
    }
    localObject1 = paramas.iCz();
    p.j(localObject1, "upperBounds");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = localIterator.next();
      h localh = ((ab)localObject2).iOU().iEf();
      localObject1 = localh;
      if (!(localh instanceof e)) {
        localObject1 = null;
      }
      localObject1 = (e)localObject1;
      if (localObject1 == null)
      {
        label158:
        i = 0;
        label160:
        if (i == 0) {
          break label241;
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = (ab)localObject1;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramas = paramas.iCz();
        p.j(paramas, "upperBounds");
        paramas = j.lo(paramas);
        p.j(paramas, "upperBounds.first()");
        localObject1 = (ab)paramas;
      }
      AppMethodBeat.o(61256);
      return localObject1;
      if ((((e)localObject1).iDN() == f.aaJZ) || (((e)localObject1).iDN() == f.aaKc)) {
        break label158;
      }
      i = 1;
      break label160;
      label241:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.d.a
 * JD-Core Version:    0.7.0.1
 */