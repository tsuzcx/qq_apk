package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.j.b.g<*>;
import kotlin.l.b.a.b.j.b.j;

public final class c
{
  public final s aiOo;
  private final kotlin.l.b.a.b.l.g<kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.a.c> aiOp;
  
  public c(kotlin.l.b.a.b.l.m paramm, s params)
  {
    AppMethodBeat.i(192107);
    this.aiOo = params;
    this.aiOp = paramm.be((kotlin.g.a.b)new d());
    AppMethodBeat.o(192107);
  }
  
  private final List<a> a(kotlin.l.b.a.b.j.b.g<?> paramg, kotlin.g.a.m<? super j, ? super a, Boolean> paramm)
  {
    AppMethodBeat.i(192117);
    Object localObject;
    if ((paramg instanceof kotlin.l.b.a.b.j.b.b))
    {
      localObject = (Iterable)((kotlin.l.b.a.b.j.b.b)paramg).getValue();
      paramg = (Collection)new ArrayList();
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        kotlin.a.p.a(paramg, (Iterable)a((kotlin.l.b.a.b.j.b.g)((Iterator)localObject).next(), paramm));
      }
      paramg = (List)paramg;
      AppMethodBeat.o(192117);
      return paramg;
    }
    if ((paramg instanceof j))
    {
      a[] arrayOfa = a.values();
      int j = arrayOfa.length;
      int i = 0;
      if (i < j)
      {
        localObject = arrayOfa[i];
        if (!((Boolean)paramm.invoke(paramg, localObject)).booleanValue()) {}
      }
      for (paramg = (kotlin.l.b.a.b.j.b.g<?>)localObject;; paramg = null)
      {
        paramg = kotlin.a.p.hs(paramg);
        AppMethodBeat.o(192117);
        return paramg;
        i += 1;
        break;
      }
    }
    paramg = (List)kotlin.a.ab.aivy;
    AppMethodBeat.o(192117);
    return paramg;
  }
  
  private final ab p(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(192112);
    parame = parame.knl().h(b.kru());
    if (parame == null)
    {
      parame = null;
      if (!(parame instanceof j)) {
        break label57;
      }
    }
    label57:
    for (parame = (j)parame;; parame = null)
    {
      if (parame != null) {
        break label62;
      }
      AppMethodBeat.o(192112);
      return null;
      parame = kotlin.l.b.a.b.j.d.a.k(parame);
      break;
    }
    label62:
    ab localab = this.aiOo.aiPe.aiPl;
    if (localab != null)
    {
      AppMethodBeat.o(192112);
      return localab;
    }
    parame = parame.ajjI.PF();
    switch (parame.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(192112);
          return null;
        } while (!parame.equals("STRICT"));
        parame = ab.aiQj;
        AppMethodBeat.o(192112);
        return parame;
      } while (!parame.equals("IGNORE"));
      parame = ab.aiQh;
      AppMethodBeat.o(192112);
      return parame;
    } while (!parame.equals("WARN"));
    parame = ab.aiQi;
    AppMethodBeat.o(192112);
    return parame;
  }
  
  public final kotlin.l.b.a.b.b.a.c d(kotlin.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(57535);
    kotlin.g.b.s.u(paramc, "annotationDescriptor");
    if (this.aiOo.aiPe.aiPo)
    {
      AppMethodBeat.o(57535);
      return null;
    }
    kotlin.l.b.a.b.b.e locale = kotlin.l.b.a.b.j.d.a.j(paramc);
    if (locale == null)
    {
      AppMethodBeat.o(57535);
      return null;
    }
    if ((b.krx().contains(kotlin.l.b.a.b.j.d.a.o((l)locale))) || (locale.knl().i(b.krs()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(57535);
      return paramc;
    }
    if (locale.kna() != kotlin.l.b.a.b.b.f.aiGx)
    {
      AppMethodBeat.o(57535);
      return null;
    }
    paramc = (kotlin.l.b.a.b.b.a.c)this.aiOp.invoke(locale);
    AppMethodBeat.o(57535);
    return paramc;
  }
  
  public final a e(kotlin.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(57536);
    kotlin.g.b.s.u(paramc, "annotationDescriptor");
    if (this.aiOo.aiPe.aiPo)
    {
      AppMethodBeat.o(57536);
      return null;
    }
    Object localObject1 = kotlin.l.b.a.b.j.d.a.j(paramc);
    if ((localObject1 != null) && (((kotlin.l.b.a.b.b.e)localObject1).knl().i(b.krt()))) {}
    while (localObject1 == null)
    {
      AppMethodBeat.o(57536);
      return null;
      localObject1 = null;
    }
    paramc = kotlin.l.b.a.b.j.d.a.j(paramc);
    kotlin.g.b.s.checkNotNull(paramc);
    paramc = paramc.knl().h(b.krt());
    kotlin.g.b.s.checkNotNull(paramc);
    paramc = paramc.kpA();
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramc.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      paramc = (kotlin.l.b.a.b.f.f)((Map.Entry)localObject2).getKey();
      localObject2 = (kotlin.l.b.a.b.j.b.g)((Map.Entry)localObject2).getValue();
      if (kotlin.g.b.s.p(paramc, w.aiPv)) {}
      for (paramc = a((kotlin.l.b.a.b.j.b.g)localObject2, (kotlin.g.a.m)b.aiOs);; paramc = (List)kotlin.a.ab.aivy)
      {
        kotlin.a.p.a(localCollection, (Iterable)paramc);
        break;
      }
    }
    paramc = ((Iterable)localCollection).iterator();
    for (int i = 0; paramc.hasNext(); i = 1 << ((a)paramc.next()).ordinal() | i) {}
    localObject1 = ((Iterable)((kotlin.l.b.a.b.b.e)localObject1).knl()).iterator();
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      paramc = ((Iterator)localObject1).next();
      if (d((kotlin.l.b.a.b.b.a.c)paramc) != null)
      {
        j = 1;
        label325:
        if (j == 0) {
          break label349;
        }
      }
    }
    for (;;)
    {
      paramc = (kotlin.l.b.a.b.b.a.c)paramc;
      if (paramc != null) {
        break label356;
      }
      AppMethodBeat.o(57536);
      return null;
      j = 0;
      break label325;
      label349:
      break;
      paramc = null;
    }
    label356:
    paramc = new a(paramc, i);
    AppMethodBeat.o(57536);
    return paramc;
  }
  
  public final a f(kotlin.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(192127);
    kotlin.g.b.s.u(paramc, "annotationDescriptor");
    Object localObject1 = kotlin.l.b.a.b.j.d.a.j(paramc);
    if (localObject1 == null)
    {
      AppMethodBeat.o(192127);
      return null;
    }
    localObject1 = ((kotlin.l.b.a.b.b.e)localObject1).knl();
    Object localObject2 = w.aiPw;
    kotlin.g.b.s.s(localObject2, "TARGET_ANNOTATION");
    localObject1 = ((kotlin.l.b.a.b.b.a.g)localObject1).h((kotlin.l.b.a.b.f.c)localObject2);
    if (localObject1 == null)
    {
      AppMethodBeat.o(192127);
      return null;
    }
    localObject2 = ((kotlin.l.b.a.b.b.a.c)localObject1).kpA();
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      kotlin.a.p.a((Collection)localObject1, (Iterable)a((kotlin.l.b.a.b.j.b.g)((Map.Entry)((Iterator)localObject2).next()).getValue(), (kotlin.g.a.m)new c(this)));
    }
    localObject1 = (Iterable)localObject1;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      i = 1 << ((a)((Iterator)localObject1).next()).ordinal() | i;
    }
    paramc = new a(paramc, i);
    AppMethodBeat.o(192127);
    return paramc;
  }
  
  public final ab g(kotlin.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(192133);
    kotlin.g.b.s.u(paramc, "annotationDescriptor");
    paramc = h(paramc);
    if (paramc != null)
    {
      AppMethodBeat.o(192133);
      return paramc;
    }
    paramc = this.aiOo.aiPe.aiPk;
    AppMethodBeat.o(192133);
    return paramc;
  }
  
  public final ab h(kotlin.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(192135);
    kotlin.g.b.s.u(paramc, "annotationDescriptor");
    ab localab = (ab)this.aiOo.aiPe.aiPm.get(paramc.koY());
    if (localab != null)
    {
      AppMethodBeat.o(192135);
      return localab;
    }
    paramc = kotlin.l.b.a.b.j.d.a.j(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(192135);
      return null;
    }
    paramc = p(paramc);
    AppMethodBeat.o(192135);
    return paramc;
  }
  
  public static final class a
  {
    public final kotlin.l.b.a.b.b.a.c aiOq;
    private final int aiOr;
    
    public a(kotlin.l.b.a.b.b.a.c paramc, int paramInt)
    {
      AppMethodBeat.i(57532);
      this.aiOq = paramc;
      this.aiOr = paramInt;
      AppMethodBeat.o(57532);
    }
    
    private final boolean a(a parama)
    {
      AppMethodBeat.i(191975);
      if ((this.aiOr & 1 << parama.ordinal()) != 0)
      {
        AppMethodBeat.o(191975);
        return true;
      }
      AppMethodBeat.o(191975);
      return false;
    }
    
    public final List<a> component2()
    {
      AppMethodBeat.i(57530);
      Object localObject = a.values();
      Collection localCollection = (Collection)new ArrayList();
      int k = localObject.length;
      int j = 0;
      if (j < k)
      {
        a locala = localObject[j];
        int i;
        if (a(locala)) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0) {
            localCollection.add(locala);
          }
          j += 1;
          break;
          if ((a(a.aiOc)) && (locala != a.aiOd)) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      localObject = (List)localCollection;
      AppMethodBeat.o(57530);
      return localObject;
    }
  }
  
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.m<j, a, Boolean>
  {
    public static final b aiOs;
    
    static
    {
      AppMethodBeat.i(191978);
      aiOs = new b();
      AppMethodBeat.o(191978);
    }
    
    b()
    {
      super();
    }
  }
  
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.m<j, a, Boolean>
  {
    c(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c
 * JD-Core Version:    0.7.0.1
 */