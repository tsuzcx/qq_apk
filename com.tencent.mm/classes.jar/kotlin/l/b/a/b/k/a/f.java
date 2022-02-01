package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.e.a.a;
import kotlin.l.b.a.b.e.a.a.a;
import kotlin.l.b.a.b.e.a.a.a.b;
import kotlin.l.b.a.b.e.b.b.a;
import kotlin.l.b.a.b.j.b.h;
import kotlin.l.b.a.b.j.b.k;
import kotlin.l.b.a.b.j.b.k.a;
import kotlin.l.b.a.b.j.b.m;
import kotlin.l.b.a.b.j.b.r;
import kotlin.l.b.a.b.j.b.v;
import kotlin.l.b.a.b.j.b.w;
import kotlin.l.b.a.b.j.b.z;
import kotlin.l.b.a.b.m.at;
import kotlin.o;

public final class f
{
  private final aa aaHL;
  private final kotlin.l.b.a.b.b.y aaIj;
  
  public f(kotlin.l.b.a.b.b.y paramy, aa paramaa)
  {
    AppMethodBeat.i(60287);
    this.aaIj = paramy;
    this.aaHL = paramaa;
    AppMethodBeat.o(60287);
  }
  
  private final kotlin.l.b.a.b.j.b.g<?> a(kotlin.l.b.a.b.m.ab paramab, a.a.a.b paramb, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60283);
    paramc = b(paramab, paramb, paramc);
    if (a(paramc, paramab, paramb)) {}
    for (;;)
    {
      Object localObject = paramc;
      if (paramc == null)
      {
        paramc = k.abld;
        localObject = (kotlin.l.b.a.b.j.b.g)k.a.bHk("Unexpected argument value: actual type " + paramb.aaZJ + " != expected type " + paramab);
      }
      AppMethodBeat.o(60283);
      return localObject;
      paramc = null;
    }
  }
  
  private final o<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> a(a.a.a parama, Map<kotlin.l.b.a.b.f.f, ? extends av> paramMap, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60282);
    Object localObject = (av)paramMap.get(x.b(paramc, parama.aaZG));
    if (localObject == null)
    {
      AppMethodBeat.o(60282);
      return null;
    }
    paramMap = x.b(paramc, parama.aaZG);
    localObject = ((av)localObject).iFN();
    p.j(localObject, "parameter.type");
    parama = parama.aaZH;
    p.j(parama, "proto.value");
    parama = new o(paramMap, a((kotlin.l.b.a.b.m.ab)localObject, parama, paramc));
    AppMethodBeat.o(60282);
    return parama;
  }
  
  private final boolean a(kotlin.l.b.a.b.j.b.g<?> paramg, kotlin.l.b.a.b.m.ab paramab, a.a.a.b paramb)
  {
    AppMethodBeat.i(60285);
    Object localObject = paramb.aaZJ;
    if (localObject == null) {}
    for (;;)
    {
      boolean bool = p.h(paramg.b(this.aaIj), paramab);
      AppMethodBeat.o(60285);
      return bool;
      switch (g.jLJ[localObject.ordinal()])
      {
      }
    }
    paramab = paramab.iOU().iEf();
    paramg = paramab;
    if (!(paramab instanceof kotlin.l.b.a.b.b.e)) {
      paramg = null;
    }
    paramg = (kotlin.l.b.a.b.b.e)paramg;
    if ((paramg == null) || (kotlin.l.b.a.b.a.g.g(paramg)))
    {
      AppMethodBeat.o(60285);
      return true;
    }
    AppMethodBeat.o(60285);
    return false;
    if (((paramg instanceof kotlin.l.b.a.b.j.b.b)) && (((List)((kotlin.l.b.a.b.j.b.b)paramg).getValue()).size() == paramb.aaZQ.size())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramg = (Throwable)new IllegalStateException("Deserialized ArrayValue should have the same number of elements as the original array value: ".concat(String.valueOf(paramg)).toString());
      AppMethodBeat.o(60285);
      throw paramg;
    }
    paramab = iFv().l(paramab);
    p.j(paramab, "builtIns.getArrayElementType(expectedType)");
    localObject = ((Iterable)kotlin.a.j.p((Collection)((kotlin.l.b.a.b.j.b.b)paramg).getValue())).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i = ((kotlin.a.ab)localObject).zD();
      kotlin.l.b.a.b.j.b.g localg = (kotlin.l.b.a.b.j.b.g)((List)((kotlin.l.b.a.b.j.b.b)paramg).getValue()).get(i);
      a.a.a.b localb = paramb.aDN(i);
      p.j(localb, "value.getArrayElement(i)");
      if (!a(localg, paramab, localb))
      {
        AppMethodBeat.o(60285);
        return false;
      }
    }
    AppMethodBeat.o(60285);
    return true;
  }
  
  private final kotlin.l.b.a.b.b.e f(kotlin.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(60286);
    parama = kotlin.l.b.a.b.b.s.a(this.aaIj, parama, this.aaHL);
    AppMethodBeat.o(60286);
    return parama;
  }
  
  private final kotlin.l.b.a.b.a.g iFv()
  {
    AppMethodBeat.i(60280);
    kotlin.l.b.a.b.a.g localg = this.aaIj.iFv();
    AppMethodBeat.o(60280);
    return localg;
  }
  
  public final kotlin.l.b.a.b.b.a.c b(a.a parama, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60281);
    p.k(parama, "proto");
    p.k(paramc, "nameResolver");
    kotlin.l.b.a.b.b.e locale = f(x.a(paramc, parama.aaZD));
    Object localObject1 = ae.iBR();
    if ((parama.getArgumentCount() != 0) && (!kotlin.l.b.a.b.m.u.L((kotlin.l.b.a.b.b.l)locale)) && (kotlin.l.b.a.b.j.c.z((kotlin.l.b.a.b.b.l)locale)))
    {
      Object localObject2 = locale.iCg();
      p.j(localObject2, "annotationClass.constructors");
      localObject2 = (kotlin.l.b.a.b.b.d)kotlin.a.j.j((Iterable)localObject2);
      if (localObject2 != null)
      {
        localObject1 = ((kotlin.l.b.a.b.b.d)localObject2).iEJ();
        p.j(localObject1, "constructor.valueParameters");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Map)new LinkedHashMap(kotlin.k.i.ov(ae.aDD(kotlin.a.j.a((Iterable)localObject2, 10)), 16));
        localObject2 = ((Iterable)localObject2).iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          av localav = (av)localObject3;
          p.j(localav, "it");
          ((Map)localObject1).put(localav.iEU(), localObject3);
        }
        parama = parama.aaZE;
        p.j(parama, "proto.argumentList");
        localObject2 = (Iterable)parama;
        parama = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (a.a.a)((Iterator)localObject2).next();
          p.j(localObject3, "it");
          localObject3 = a((a.a.a)localObject3, (Map)localObject1, paramc);
          if (localObject3 != null) {
            parama.add(localObject3);
          }
        }
      }
    }
    for (parama = ae.E((Iterable)parama);; parama = (a.a)localObject1)
    {
      parama = (kotlin.l.b.a.b.b.a.c)new kotlin.l.b.a.b.b.a.d((kotlin.l.b.a.b.m.ab)locale.iET(), parama, an.aaKE);
      AppMethodBeat.o(60281);
      return parama;
    }
  }
  
  public final kotlin.l.b.a.b.j.b.g<?> b(kotlin.l.b.a.b.m.ab paramab, a.a.a.b paramb, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60284);
    p.k(paramab, "expectedType");
    p.k(paramb, "value");
    p.k(paramc, "nameResolver");
    Object localObject1 = kotlin.l.b.a.b.e.b.b.abes.aFe(paramb.aaZS);
    p.j(localObject1, "Flags.IS_UNSIGNED.get(value.flags)");
    boolean bool = ((Boolean)localObject1).booleanValue();
    localObject1 = paramb.aaZJ;
    if (localObject1 == null) {}
    for (;;)
    {
      paramab = (Throwable)new IllegalStateException(("Unsupported annotation argument type: " + paramb.aaZJ + " (expected " + paramab + ')').toString());
      AppMethodBeat.o(60284);
      throw paramab;
      switch (g.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      }
    }
    byte b = (byte)(int)paramb.aaZK;
    if (bool) {}
    for (paramab = new w(b);; paramab = new kotlin.l.b.a.b.j.b.d(b))
    {
      paramab = (kotlin.l.b.a.b.j.b.g)paramab;
      AppMethodBeat.o(60284);
      return paramab;
    }
    paramab = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.e((char)(int)paramb.aaZK);
    AppMethodBeat.o(60284);
    return paramab;
    short s = (short)(int)paramb.aaZK;
    if (bool) {}
    for (paramab = new z(s);; paramab = new kotlin.l.b.a.b.j.b.u(s))
    {
      paramab = (kotlin.l.b.a.b.j.b.g)paramab;
      AppMethodBeat.o(60284);
      return paramab;
    }
    int i = (int)paramb.aaZK;
    if (bool) {}
    for (paramab = new kotlin.l.b.a.b.j.b.x(i);; paramab = new m(i))
    {
      paramab = (kotlin.l.b.a.b.j.b.g)paramab;
      AppMethodBeat.o(60284);
      return paramab;
    }
    long l = paramb.aaZK;
    if (bool) {}
    for (paramab = new kotlin.l.b.a.b.j.b.y(l);; paramab = new kotlin.l.b.a.b.j.b.s(l))
    {
      paramab = (kotlin.l.b.a.b.j.b.g)paramab;
      AppMethodBeat.o(60284);
      return paramab;
    }
    paramab = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.l(paramb.aaZL);
    AppMethodBeat.o(60284);
    return paramab;
    paramab = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.i(paramb.bUg);
    AppMethodBeat.o(60284);
    return paramab;
    if (paramb.aaZK != 0L) {}
    for (bool = true;; bool = false)
    {
      paramab = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.c(bool);
      AppMethodBeat.o(60284);
      return paramab;
    }
    paramab = (kotlin.l.b.a.b.j.b.g)new v(paramc.getString(paramb.aaZM));
    AppMethodBeat.o(60284);
    return paramab;
    paramab = (kotlin.l.b.a.b.j.b.g)new r(x.a(paramc, paramb.aaZN), paramb.aaZR);
    AppMethodBeat.o(60284);
    return paramab;
    paramab = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.j(x.a(paramc, paramb.aaZN), x.b(paramc, paramb.aaZO));
    AppMethodBeat.o(60284);
    return paramab;
    paramab = paramb.aaZP;
    p.j(paramab, "value.annotation");
    paramab = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.a(b(paramab, paramc));
    AppMethodBeat.o(60284);
    return paramab;
    localObject1 = h.abkY;
    paramb = paramb.aaZQ;
    p.j(paramb, "value.arrayElementList");
    localObject1 = (Iterable)paramb;
    paramb = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      a.a.a.b localb = (a.a.a.b)((Iterator)localObject1).next();
      Object localObject2 = iFv().iDu();
      p.j(localObject2, "builtIns.anyType");
      localObject2 = (kotlin.l.b.a.b.m.ab)localObject2;
      p.j(localb, "it");
      paramb.add(b((kotlin.l.b.a.b.m.ab)localObject2, localb, paramc));
    }
    paramab = (kotlin.l.b.a.b.j.b.g)h.a((List)paramb, paramab);
    AppMethodBeat.o(60284);
    return paramab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.f
 * JD-Core Version:    0.7.0.1
 */