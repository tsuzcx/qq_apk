package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.b.p;
import d.l.b.a.b.b.aa;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.av;
import d.l.b.a.b.e.a.a;
import d.l.b.a.b.e.a.a.a;
import d.l.b.a.b.e.a.a.a.b;
import d.l.b.a.b.e.b.b.a;
import d.l.b.a.b.j.b.h;
import d.l.b.a.b.j.b.i;
import d.l.b.a.b.j.b.k;
import d.l.b.a.b.j.b.k.a;
import d.l.b.a.b.j.b.m;
import d.l.b.a.b.j.b.r;
import d.l.b.a.b.j.b.v;
import d.l.b.a.b.j.b.w;
import d.l.b.a.b.j.b.z;
import d.l.b.a.b.m.at;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class f
{
  private final d.l.b.a.b.b.y NpH;
  private final aa Npj;
  
  public f(d.l.b.a.b.b.y paramy, aa paramaa)
  {
    AppMethodBeat.i(60287);
    this.NpH = paramy;
    this.Npj = paramaa;
    AppMethodBeat.o(60287);
  }
  
  private final d.l.b.a.b.j.b.g<?> a(d.l.b.a.b.m.ab paramab, a.a.a.b paramb, d.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60283);
    paramc = b(paramab, paramb, paramc);
    if (a(paramc, paramab, paramb)) {}
    for (;;)
    {
      Object localObject = paramc;
      if (paramc == null)
      {
        paramc = k.NTD;
        localObject = (d.l.b.a.b.j.b.g)k.a.bet("Unexpected argument value: actual type " + paramb.NHp + " != expected type " + paramab);
      }
      AppMethodBeat.o(60283);
      return localObject;
      paramc = null;
    }
  }
  
  private final o<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> a(a.a.a parama, Map<d.l.b.a.b.f.f, ? extends av> paramMap, d.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60282);
    Object localObject = (av)paramMap.get(x.b(paramc, parama.NHm));
    if (localObject == null)
    {
      AppMethodBeat.o(60282);
      return null;
    }
    paramMap = x.b(paramc, parama.NHm);
    localObject = ((av)localObject).gnW();
    p.g(localObject, "parameter.type");
    parama = parama.NHn;
    p.g(parama, "proto.value");
    parama = new o(paramMap, a((d.l.b.a.b.m.ab)localObject, parama, paramc));
    AppMethodBeat.o(60282);
    return parama;
  }
  
  private final boolean a(d.l.b.a.b.j.b.g<?> paramg, d.l.b.a.b.m.ab paramab, a.a.a.b paramb)
  {
    AppMethodBeat.i(60285);
    Object localObject = paramb.NHp;
    if (localObject == null) {}
    for (;;)
    {
      boolean bool = p.i(paramg.b(this.NpH), paramab);
      AppMethodBeat.o(60285);
      return bool;
      switch (g.gpL[localObject.ordinal()])
      {
      }
    }
    paramab = paramab.gxB().gmq();
    paramg = paramab;
    if (!(paramab instanceof d.l.b.a.b.b.e)) {
      paramg = null;
    }
    paramg = (d.l.b.a.b.b.e)paramg;
    if ((paramg == null) || (d.l.b.a.b.a.g.g(paramg)))
    {
      AppMethodBeat.o(60285);
      return true;
    }
    AppMethodBeat.o(60285);
    return false;
    if (((paramg instanceof d.l.b.a.b.j.b.b)) && (((List)((d.l.b.a.b.j.b.b)paramg).getValue()).size() == paramb.NHx.size())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramg = (Throwable)new IllegalStateException("Deserialized ArrayValue should have the same number of elements as the original array value: ".concat(String.valueOf(paramg)).toString());
      AppMethodBeat.o(60285);
      throw paramg;
    }
    paramab = gnF().l(paramab);
    p.g(paramab, "builtIns.getArrayElementType(expectedType)");
    localObject = ((Iterable)d.a.j.o((Collection)((d.l.b.a.b.j.b.b)paramg).getValue())).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i = ((d.a.ab)localObject).nextInt();
      d.l.b.a.b.j.b.g localg = (d.l.b.a.b.j.b.g)((List)((d.l.b.a.b.j.b.b)paramg).getValue()).get(i);
      a.a.a.b localb = paramb.akd(i);
      p.g(localb, "value.getArrayElement(i)");
      if (!a(localg, paramab, localb))
      {
        AppMethodBeat.o(60285);
        return false;
      }
    }
    AppMethodBeat.o(60285);
    return true;
  }
  
  private final d.l.b.a.b.b.e f(d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(60286);
    parama = d.l.b.a.b.b.s.a(this.NpH, parama, this.Npj);
    AppMethodBeat.o(60286);
    return parama;
  }
  
  private final d.l.b.a.b.a.g gnF()
  {
    AppMethodBeat.i(60280);
    d.l.b.a.b.a.g localg = this.NpH.gnF();
    AppMethodBeat.o(60280);
    return localg;
  }
  
  public final d.l.b.a.b.b.a.c b(a.a parama, d.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60281);
    p.h(parama, "proto");
    p.h(paramc, "nameResolver");
    d.l.b.a.b.b.e locale = f(x.a(paramc, parama.NHh));
    Object localObject1 = ae.emptyMap();
    if ((parama.getArgumentCount() != 0) && (!d.l.b.a.b.m.u.L((d.l.b.a.b.b.l)locale)) && (d.l.b.a.b.j.c.z((d.l.b.a.b.b.l)locale)))
    {
      Object localObject2 = locale.gkx();
      p.g(localObject2, "annotationClass.constructors");
      localObject2 = (d.l.b.a.b.b.d)d.a.j.g((Iterable)localObject2);
      if (localObject2 != null)
      {
        localObject1 = ((d.l.b.a.b.b.d)localObject2).gmU();
        p.g(localObject1, "constructor.valueParameters");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Map)new LinkedHashMap(d.k.j.lw(ae.ajS(d.a.j.a((Iterable)localObject2, 10)), 16));
        localObject2 = ((Iterable)localObject2).iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          av localav = (av)localObject3;
          p.g(localav, "it");
          ((Map)localObject1).put(localav.gnf(), localObject3);
        }
        parama = parama.NHi;
        p.g(parama, "proto.argumentList");
        localObject2 = (Iterable)parama;
        parama = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (a.a.a)((Iterator)localObject2).next();
          p.g(localObject3, "it");
          localObject3 = a((a.a.a)localObject3, (Map)localObject1, paramc);
          if (localObject3 != null) {
            parama.add(localObject3);
          }
        }
      }
    }
    for (parama = ae.A((Iterable)parama);; parama = (a.a)localObject1)
    {
      parama = (d.l.b.a.b.b.a.c)new d.l.b.a.b.b.a.d((d.l.b.a.b.m.ab)locale.gne(), parama, an.Nsc);
      AppMethodBeat.o(60281);
      return parama;
    }
  }
  
  public final d.l.b.a.b.j.b.g<?> b(d.l.b.a.b.m.ab paramab, a.a.a.b paramb, d.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60284);
    p.h(paramab, "expectedType");
    p.h(paramb, "value");
    p.h(paramc, "nameResolver");
    Object localObject1 = d.l.b.a.b.e.b.b.NMa.alu(paramb.NHz);
    p.g(localObject1, "Flags.IS_UNSIGNED.get(value.flags)");
    boolean bool = ((Boolean)localObject1).booleanValue();
    localObject1 = paramb.NHp;
    if (localObject1 == null) {}
    for (;;)
    {
      paramab = (Throwable)new IllegalStateException(("Unsupported annotation argument type: " + paramb.NHp + " (expected " + paramab + ')').toString());
      AppMethodBeat.o(60284);
      throw paramab;
      switch (g.cqt[localObject1.ordinal()])
      {
      }
    }
    byte b = (byte)(int)paramb.NHq;
    if (bool) {}
    for (paramab = new w(b);; paramab = new d.l.b.a.b.j.b.d(b))
    {
      paramab = (d.l.b.a.b.j.b.g)paramab;
      AppMethodBeat.o(60284);
      return paramab;
    }
    paramab = (d.l.b.a.b.j.b.g)new d.l.b.a.b.j.b.e((char)(int)paramb.NHq);
    AppMethodBeat.o(60284);
    return paramab;
    short s = (short)(int)paramb.NHq;
    if (bool) {}
    for (paramab = new z(s);; paramab = new d.l.b.a.b.j.b.u(s))
    {
      paramab = (d.l.b.a.b.j.b.g)paramab;
      AppMethodBeat.o(60284);
      return paramab;
    }
    int i = (int)paramb.NHq;
    if (bool) {}
    for (paramab = new d.l.b.a.b.j.b.x(i);; paramab = new m(i))
    {
      paramab = (d.l.b.a.b.j.b.g)paramab;
      AppMethodBeat.o(60284);
      return paramab;
    }
    long l = paramb.NHq;
    if (bool) {}
    for (paramab = new d.l.b.a.b.j.b.y(l);; paramab = new d.l.b.a.b.j.b.s(l))
    {
      paramab = (d.l.b.a.b.j.b.g)paramab;
      AppMethodBeat.o(60284);
      return paramab;
    }
    paramab = (d.l.b.a.b.j.b.g)new d.l.b.a.b.j.b.l(paramb.NHr);
    AppMethodBeat.o(60284);
    return paramab;
    paramab = (d.l.b.a.b.j.b.g)new i(paramb.NHs);
    AppMethodBeat.o(60284);
    return paramab;
    if (paramb.NHq != 0L) {}
    for (bool = true;; bool = false)
    {
      paramab = (d.l.b.a.b.j.b.g)new d.l.b.a.b.j.b.c(bool);
      AppMethodBeat.o(60284);
      return paramab;
    }
    paramab = (d.l.b.a.b.j.b.g)new v(paramc.getString(paramb.NHt));
    AppMethodBeat.o(60284);
    return paramab;
    paramab = (d.l.b.a.b.j.b.g)new r(x.a(paramc, paramb.NHu), paramb.NHy);
    AppMethodBeat.o(60284);
    return paramab;
    paramab = (d.l.b.a.b.j.b.g)new d.l.b.a.b.j.b.j(x.a(paramc, paramb.NHu), x.b(paramc, paramb.NHv));
    AppMethodBeat.o(60284);
    return paramab;
    paramab = paramb.NHw;
    p.g(paramab, "value.annotation");
    paramab = (d.l.b.a.b.j.b.g)new d.l.b.a.b.j.b.a(b(paramab, paramc));
    AppMethodBeat.o(60284);
    return paramab;
    localObject1 = h.NTy;
    paramb = paramb.NHx;
    p.g(paramb, "value.arrayElementList");
    localObject1 = (Iterable)paramb;
    paramb = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      a.a.a.b localb = (a.a.a.b)((Iterator)localObject1).next();
      Object localObject2 = gnF().glF();
      p.g(localObject2, "builtIns.anyType");
      localObject2 = (d.l.b.a.b.m.ab)localObject2;
      p.g(localb, "it");
      paramb.add(b((d.l.b.a.b.m.ab)localObject2, localb, paramc));
    }
    paramab = (d.l.b.a.b.j.b.g)h.a((List)paramb, paramab);
    AppMethodBeat.o(60284);
    return paramab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.f
 * JD-Core Version:    0.7.0.1
 */