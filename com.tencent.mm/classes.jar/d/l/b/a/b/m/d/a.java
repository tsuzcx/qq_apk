package d.l.b.a.b.m.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.aa;
import d.g.b.k;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.f;
import d.l.b.a.b.b.h;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.ao;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.ax;
import d.l.b.a.b.m.az;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.be;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.v;
import d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static final ab a(ab paramab, d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(61252);
    k.h(paramab, "$this$replaceAnnotations");
    k.h(paramg, "newAnnotations");
    if ((paramab.fQj().isEmpty()) && (paramg.isEmpty()))
    {
      AppMethodBeat.o(61252);
      return paramab;
    }
    paramab = (ab)paramab.gcz().b(paramg);
    AppMethodBeat.o(61252);
    return paramab;
  }
  
  public static final av a(ab paramab, bh parambh, as paramas)
  {
    AppMethodBeat.i(61253);
    k.h(paramab, "type");
    k.h(parambh, "projectionKind");
    if (paramas != null) {}
    for (paramas = paramas.fRg();; paramas = null)
    {
      bh localbh = parambh;
      if (paramas == parambh) {
        localbh = bh.LLV;
      }
      paramab = (av)new ax(localbh, paramab);
      AppMethodBeat.o(61253);
      return paramab;
    }
  }
  
  public static final ab aD(ab paramab)
  {
    AppMethodBeat.i(61248);
    k.h(paramab, "$this$makeNullable");
    paramab = bc.aD(paramab);
    k.g(paramab, "TypeUtils.makeNullable(this)");
    AppMethodBeat.o(61248);
    return paramab;
  }
  
  public static final ab aE(ab paramab)
  {
    AppMethodBeat.i(61249);
    k.h(paramab, "$this$makeNotNullable");
    paramab = bc.aE(paramab);
    k.g(paramab, "TypeUtils.makeNotNullable(this)");
    AppMethodBeat.o(61249);
    return paramab;
  }
  
  public static final boolean aI(ab paramab)
  {
    AppMethodBeat.i(61250);
    k.h(paramab, "$this$isTypeParameter");
    boolean bool = bc.aI(paramab);
    AppMethodBeat.o(61250);
    return bool;
  }
  
  public static final d.l.b.a.b.a.g aN(ab paramab)
  {
    AppMethodBeat.i(61247);
    k.h(paramab, "$this$builtIns");
    paramab = paramab.gbz().fRE();
    k.g(paramab, "constructor.builtIns");
    AppMethodBeat.o(61247);
    return paramab;
  }
  
  public static final av aO(ab paramab)
  {
    AppMethodBeat.i(61254);
    k.h(paramab, "$this$asTypeProjection");
    paramab = (av)new ax(paramab);
    AppMethodBeat.o(61254);
    return paramab;
  }
  
  public static final ab aP(ab paramab)
  {
    AppMethodBeat.i(61255);
    k.h(paramab, "$this$replaceArgumentsWithStarProjections");
    bg localbg = paramab.gcz();
    aj localaj;
    Object localObject1;
    if ((localbg instanceof v))
    {
      localaj = ((v)localbg).LLa;
      paramab = localaj;
      if (!localaj.gbz().getParameters().isEmpty())
      {
        if (localaj.gbz().fQq() == null) {
          paramab = localaj;
        }
      }
      else
      {
        localaj = ((v)localbg).LLb;
        if ((!localaj.gbz().getParameters().isEmpty()) && (localaj.gbz().fQq() != null)) {
          break label218;
        }
      }
      for (;;)
      {
        paramab = ac.a(paramab, localaj);
        paramab = (ab)be.a(paramab, (ab)localbg);
        AppMethodBeat.o(61255);
        return paramab;
        paramab = localaj.gbz().getParameters();
        k.g(paramab, "constructor.parameters");
        localObject1 = (Iterable)paramab;
        paramab = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramab.add(new ao((as)((Iterator)localObject1).next()));
        }
        paramab = az.a(localaj, (List)paramab);
        break;
        label218:
        localObject1 = localaj.gbz().getParameters();
        k.g(localObject1, "constructor.parameters");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(new ao((as)((Iterator)localObject2).next()));
        }
        localaj = az.a(localaj, (List)localObject1);
      }
    }
    if ((localbg instanceof aj))
    {
      localaj = (aj)localbg;
      paramab = localaj;
      if (!localaj.gbz().getParameters().isEmpty()) {
        if (localaj.gbz().fQq() != null) {
          break label369;
        }
      }
      for (paramab = localaj;; paramab = az.a(localaj, (List)paramab))
      {
        paramab = (bg)paramab;
        break;
        label369:
        paramab = localaj.gbz().getParameters();
        k.g(paramab, "constructor.parameters");
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
    k.h(paramab1, "$this$isSubtypeOf");
    k.h(paramab2, "superType");
    boolean bool = d.l.b.a.b.m.a.g.LMg.c(paramab1, paramab2);
    AppMethodBeat.o(61251);
    return bool;
  }
  
  public static final ab e(as paramas)
  {
    AppMethodBeat.i(61256);
    k.h(paramas, "$this$representativeUpperBound");
    Object localObject1 = paramas.fOJ();
    k.g(localObject1, "upperBounds");
    if (!((Collection)localObject1).isEmpty()) {}
    for (int i = 1; (aa.KTq) && (i == 0); i = 0)
    {
      paramas = (Throwable)new AssertionError("Upper bounds should not be empty: ".concat(String.valueOf(paramas)));
      AppMethodBeat.o(61256);
      throw paramas;
    }
    localObject1 = paramas.fOJ();
    k.g(localObject1, "upperBounds");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = localIterator.next();
      h localh = ((ab)localObject2).gbz().fQq();
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
        paramas = paramas.fOJ();
        k.g(paramas, "upperBounds");
        paramas = j.iO(paramas);
        k.g(paramas, "upperBounds.first()");
        localObject1 = (ab)paramas;
      }
      AppMethodBeat.o(61256);
      return localObject1;
      if ((((e)localObject1).fPY() == f.Ldx) || (((e)localObject1).fPY() == f.LdA)) {
        break label158;
      }
      i = 1;
      break label160;
      label241:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.d.a
 * JD-Core Version:    0.7.0.1
 */