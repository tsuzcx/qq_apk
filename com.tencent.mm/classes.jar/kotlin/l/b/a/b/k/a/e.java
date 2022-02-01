package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ah;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.e.a.a;
import kotlin.l.b.a.b.e.a.a.a;
import kotlin.l.b.a.b.e.a.a.a.b;
import kotlin.l.b.a.b.e.b.b.a;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.b.a;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.j.b.i;
import kotlin.l.b.a.b.j.b.j;
import kotlin.l.b.a.b.j.b.k.a;
import kotlin.l.b.a.b.j.b.q;
import kotlin.l.b.a.b.j.b.t;
import kotlin.l.b.a.b.j.b.u;
import kotlin.l.b.a.b.j.b.x;
import kotlin.l.b.a.b.j.b.y;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;

public final class e
{
  private final ag aiBS;
  private final ae aiEx;
  
  public e(ae paramae, ag paramag)
  {
    AppMethodBeat.i(60287);
    this.aiEx = paramae;
    this.aiBS = paramag;
    AppMethodBeat.o(60287);
  }
  
  private final g<?> a(ad paramad, a.a.a.b paramb, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60283);
    paramc = b(paramad, paramb, paramc);
    if (a(paramc, paramad, paramb)) {}
    while (paramc == null)
    {
      paramc = kotlin.l.b.a.b.j.b.k.ajjJ;
      paramad = (g)k.a.bJo("Unexpected argument value: actual type " + paramb.aiYh + " != expected type " + paramad);
      AppMethodBeat.o(60283);
      return paramad;
      paramc = null;
    }
    AppMethodBeat.o(60283);
    return paramc;
  }
  
  private final kotlin.r<f, g<?>> a(a.a.a parama, Map<f, ? extends bd> paramMap, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60282);
    Object localObject = (bd)paramMap.get(w.b(paramc, parama.aiYe));
    if (localObject == null)
    {
      AppMethodBeat.o(60282);
      return null;
    }
    paramMap = w.b(paramc, parama.aiYe);
    localObject = ((bd)localObject).koG();
    s.s(localObject, "parameter.type");
    parama = parama.aiYf;
    s.s(parama, "proto.value");
    parama = new kotlin.r(paramMap, a((ad)localObject, parama, paramc));
    AppMethodBeat.o(60282);
    return parama;
  }
  
  private final boolean a(g<?> paramg, ad paramad, a.a.a.b paramb)
  {
    AppMethodBeat.i(60285);
    Object localObject = paramb.aiYh;
    if (localObject == null) {}
    for (int i = -1;; i = a.$EnumSwitchMapping$0[localObject.ordinal()]) {
      switch (i)
      {
      case 11: 
      case 12: 
      default: 
        boolean bool = s.p(paramg.c(this.aiEx), paramad);
        AppMethodBeat.o(60285);
        return bool;
      }
    }
    paramg = paramad.kzm().knA();
    if ((paramg instanceof kotlin.l.b.a.b.b.e)) {}
    for (paramg = (kotlin.l.b.a.b.b.e)paramg; (paramg == null) || (h.g(paramg)); paramg = null)
    {
      AppMethodBeat.o(60285);
      return true;
    }
    AppMethodBeat.o(60285);
    return false;
    if (((paramg instanceof kotlin.l.b.a.b.j.b.b)) && (((List)((kotlin.l.b.a.b.j.b.b)paramg).getValue()).size() == paramb.aiYo.size())) {}
    for (i = 1; i == 0; i = 0)
    {
      paramg = (Throwable)new IllegalStateException(s.X("Deserialized ArrayValue should have the same number of elements as the original array value: ", paramg).toString());
      AppMethodBeat.o(60285);
      throw paramg;
    }
    paramad = koV().l(paramad);
    s.s(paramad, "builtIns.getArrayElementType(expectedType)");
    localObject = (Iterable)p.F((Collection)((kotlin.l.b.a.b.j.b.b)paramg).getValue());
    if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty()))
    {
      AppMethodBeat.o(60285);
      return true;
    }
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i = ((ah)localObject).Zo();
      g localg = (g)((List)((kotlin.l.b.a.b.j.b.b)paramg).getValue()).get(i);
      a.a.a.b localb = paramb.aKC(i);
      s.s(localb, "value.getArrayElement(i)");
      if (!a(localg, paramad, localb))
      {
        AppMethodBeat.o(60285);
        return false;
      }
    }
    AppMethodBeat.o(60285);
    return true;
  }
  
  private final kotlin.l.b.a.b.b.e h(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(60286);
    paramb = kotlin.l.b.a.b.b.w.a(this.aiEx, paramb, this.aiBS);
    AppMethodBeat.o(60286);
    return paramb;
  }
  
  private final h koV()
  {
    AppMethodBeat.i(60280);
    h localh = this.aiEx.koV();
    AppMethodBeat.o(60280);
    return localh;
  }
  
  public final kotlin.l.b.a.b.b.a.c b(a.a parama, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60281);
    s.u(parama, "proto");
    s.u(paramc, "nameResolver");
    kotlin.l.b.a.b.b.e locale = h(w.a(paramc, parama.aiYb));
    Object localObject1 = ak.kkZ();
    if ((parama.getArgumentCount() != 0) && (!kotlin.l.b.a.b.m.v.L((kotlin.l.b.a.b.b.l)locale)) && (kotlin.l.b.a.b.j.d.z((kotlin.l.b.a.b.b.l)locale)))
    {
      Object localObject2 = locale.klv();
      s.s(localObject2, "annotationClass.constructors");
      localObject2 = (kotlin.l.b.a.b.b.d)p.j((Iterable)localObject2);
      if (localObject2 != null)
      {
        localObject1 = ((kotlin.l.b.a.b.b.d)localObject2).kod();
        s.s(localObject1, "constructor.valueParameters");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Map)new LinkedHashMap(kotlin.k.k.qu(ak.aKi(p.a((Iterable)localObject2, 10)), 16));
        localObject2 = ((Iterable)localObject2).iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          ((Map)localObject1).put(((bd)localObject3).kok(), localObject3);
        }
        parama = parama.aiYc;
        s.s(parama, "proto.argumentList");
        localObject2 = (Iterable)parama;
        parama = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (a.a.a)((Iterator)localObject2).next();
          s.s(localObject3, "it");
          localObject3 = a((a.a.a)localObject3, (Map)localObject1, paramc);
          if (localObject3 != null) {
            parama.add(localObject3);
          }
        }
      }
    }
    for (parama = ak.F((Iterable)parama);; parama = (a.a)localObject1)
    {
      parama = (kotlin.l.b.a.b.b.a.c)new kotlin.l.b.a.b.b.a.d((ad)locale.koj(), parama, av.aiHu);
      AppMethodBeat.o(60281);
      return parama;
    }
  }
  
  public final g<?> b(ad paramad, a.a.a.b paramb, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60284);
    s.u(paramad, "expectedType");
    s.u(paramb, "value");
    s.u(paramc, "nameResolver");
    Object localObject1 = kotlin.l.b.a.b.e.b.b.ajcX.aLV(paramb.aiYq);
    s.s(localObject1, "IS_UNSIGNED.get(value.flags)");
    boolean bool = ((Boolean)localObject1).booleanValue();
    localObject1 = paramb.aiYh;
    if (localObject1 == null) {}
    for (int i = -1;; i = a.$EnumSwitchMapping$0[localObject1.ordinal()]) {
      switch (i)
      {
      default: 
        paramad = (Throwable)new IllegalStateException(("Unsupported annotation argument type: " + paramb.aiYh + " (expected " + paramad + ')').toString());
        AppMethodBeat.o(60284);
        throw paramad;
      }
    }
    byte b = (byte)(int)paramb.aiYi;
    if (bool) {}
    for (paramad = new kotlin.l.b.a.b.j.b.v(b);; paramad = new kotlin.l.b.a.b.j.b.d(b))
    {
      paramad = (g)paramad;
      AppMethodBeat.o(60284);
      return paramad;
    }
    paramad = (g)new kotlin.l.b.a.b.j.b.e((char)(int)paramb.aiYi);
    AppMethodBeat.o(60284);
    return paramad;
    short s = (short)(int)paramb.aiYi;
    if (bool) {}
    for (paramad = new y(s);; paramad = new t(s))
    {
      paramad = (g)paramad;
      AppMethodBeat.o(60284);
      return paramad;
    }
    i = (int)paramb.aiYi;
    if (bool) {}
    for (paramad = new kotlin.l.b.a.b.j.b.w(i);; paramad = new kotlin.l.b.a.b.j.b.m(i))
    {
      paramad = (g)paramad;
      AppMethodBeat.o(60284);
      return paramad;
    }
    long l = paramb.aiYi;
    if (bool) {}
    for (paramad = new x(l);; paramad = new kotlin.l.b.a.b.j.b.r(l))
    {
      paramad = (g)paramad;
      AppMethodBeat.o(60284);
      return paramad;
    }
    paramad = (g)new kotlin.l.b.a.b.j.b.l(paramb.aiYj);
    AppMethodBeat.o(60284);
    return paramad;
    paramad = (g)new i(paramb.dNT);
    AppMethodBeat.o(60284);
    return paramad;
    if (paramb.aiYi != 0L) {}
    for (bool = true;; bool = false)
    {
      paramad = (g)new kotlin.l.b.a.b.j.b.c(bool);
      AppMethodBeat.o(60284);
      return paramad;
    }
    paramad = (g)new u(paramc.getString(paramb.aiYk));
    AppMethodBeat.o(60284);
    return paramad;
    paramad = (g)new q(w.a(paramc, paramb.aiYl), paramb.aiYp);
    AppMethodBeat.o(60284);
    return paramad;
    paramad = (g)new j(w.a(paramc, paramb.aiYl), w.b(paramc, paramb.aiYm));
    AppMethodBeat.o(60284);
    return paramad;
    paramad = paramb.aiYn;
    s.s(paramad, "value.annotation");
    paramad = (g)new a(b(paramad, paramc));
    AppMethodBeat.o(60284);
    return paramad;
    paramb = paramb.aiYo;
    s.s(paramb, "value.arrayElementList");
    localObject1 = (Iterable)paramb;
    paramb = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      a.a.a.b localb = (a.a.a.b)((Iterator)localObject1).next();
      Object localObject2 = koV().kmO();
      s.s(localObject2, "builtIns.anyType");
      localObject2 = (ad)localObject2;
      s.s(localb, "it");
      paramb.add(b((ad)localObject2, localb, paramc));
    }
    paramad = (g)new m((List)paramb, paramad);
    AppMethodBeat.o(60284);
    return paramad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.e
 * JD-Core Version:    0.7.0.1
 */