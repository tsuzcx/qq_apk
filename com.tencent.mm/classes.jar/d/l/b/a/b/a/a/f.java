package d.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.y;
import d.aa;
import d.g.b.k;
import d.l.b.a.b.b.a;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.c.ae;
import d.l.b.a.b.b.c.aj;
import d.l.b.a.b.b.c.p;
import d.l.b.a.b.b.c.p.a;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.w;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ba;
import d.l.b.a.b.m.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class f
  extends ae
{
  public static final a JoH;
  
  static
  {
    AppMethodBeat.i(56743);
    JoH = new a((byte)0);
    AppMethodBeat.o(56743);
  }
  
  private f(l paraml, f paramf, b.a parama, boolean paramBoolean)
  {
    super(paraml, paramf, g.a.fzI(), d.l.b.a.b.n.j.Kaq, parama, an.JqJ);
    AppMethodBeat.i(56742);
    this.JtJ = true;
    this.JtR = paramBoolean;
    xS(false);
    AppMethodBeat.o(56742);
  }
  
  private final t iF(List<d.l.b.a.b.f.f> paramList)
  {
    boolean bool = true;
    AppMethodBeat.i(56741);
    int j = fyq().size() - paramList.size();
    if ((j == 0) || (j == 1)) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(56741);
      throw paramList;
    }
    Object localObject1 = fyq();
    k.g(localObject1, "valueParameters");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      av localav = (av)localIterator.next();
      k.g(localav, "it");
      localObject2 = localav.fyB();
      k.g(localObject2, "it.name");
      i = localav.getIndex();
      int k = i - j;
      localObject1 = localObject2;
      if (k >= 0)
      {
        d.l.b.a.b.f.f localf = (d.l.b.a.b.f.f)paramList.get(k);
        localObject1 = localObject2;
        if (localf != null) {
          localObject1 = localf;
        }
      }
      localCollection.add(localav.a((a)this, (d.l.b.a.b.f.f)localObject1, i));
    }
    localObject1 = (List)localCollection;
    Object localObject2 = h(ba.JYr);
    paramList = (Iterable)paramList;
    if (!((Collection)paramList).isEmpty())
    {
      paramList = paramList.iterator();
      if (paramList.hasNext()) {
        if ((d.l.b.a.b.f.f)paramList.next() == null)
        {
          i = 1;
          label300:
          if (i == 0) {
            break label361;
          }
        }
      }
    }
    for (;;)
    {
      ((p.a)localObject2).Juq = Boolean.valueOf(bool);
      paramList = ((p.a)localObject2).iI((List)localObject1).f((d.l.b.a.b.b.b)fAn());
      k.g(paramList, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
      paramList = super.a(paramList);
      if (paramList == null) {
        k.fvU();
      }
      AppMethodBeat.o(56741);
      return paramList;
      i = 0;
      break label300;
      label361:
      break;
      bool = false;
    }
  }
  
  public final p a(l paraml, t paramt, b.a parama, d.l.b.a.b.f.f paramf, g paramg, an paraman)
  {
    AppMethodBeat.i(56740);
    k.h(paraml, "newOwner");
    k.h(parama, "kind");
    k.h(paramg, "annotations");
    k.h(paraman, "source");
    paraml = (p)new f(paraml, (f)paramt, parama, fyS());
    AppMethodBeat.o(56740);
    return paraml;
  }
  
  public final t a(p.a parama)
  {
    AppMethodBeat.i(56739);
    k.h(parama, "configuration");
    parama = (f)super.a(parama);
    if (parama == null)
    {
      AppMethodBeat.o(56739);
      return null;
    }
    Object localObject1 = parama.fyq();
    k.g(localObject1, "substituted.valueParameters");
    localObject1 = (Iterable)localObject1;
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (av)((Iterator)localObject1).next();
        k.g(localObject2, "it");
        localObject2 = ((av)localObject2).fzr();
        k.g(localObject2, "it.type");
        if (d.l.b.a.b.a.f.k((ab)localObject2) != null)
        {
          i = 1;
          label126:
          if (i == 0) {
            break label151;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label158;
      }
      parama = (t)parama;
      AppMethodBeat.o(56739);
      return parama;
      i = 0;
      break label126;
      label151:
      break;
    }
    label158:
    localObject1 = parama.fyq();
    k.g(localObject1, "substituted.valueParameters");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (av)((Iterator)localObject2).next();
      k.g(localObject3, "it");
      localObject3 = ((av)localObject3).fzr();
      k.g(localObject3, "it.type");
      ((Collection)localObject1).add(d.l.b.a.b.a.f.k((ab)localObject3));
    }
    parama = parama.iF((List)localObject1);
    AppMethodBeat.o(56739);
    return parama;
  }
  
  public final boolean fxB()
  {
    return false;
  }
  
  public final boolean fxE()
  {
    return false;
  }
  
  public final boolean fxR()
  {
    return false;
  }
  
  public static final class a
  {
    public static f a(b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(56737);
      k.h(paramb, "functionClass");
      List localList1 = paramb.parameters;
      f localf = new f((l)paramb, b.a.JpV, paramBoolean);
      paramb = paramb.fyH();
      List localList2 = (List)d.a.v.Jgl;
      Object localObject2 = (Iterable)localList1;
      Object localObject1 = new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((as)localObject3).fyC() == bh.JYD) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label127;
          }
          ((ArrayList)localObject1).add(localObject3);
          break;
        }
      }
      label127:
      localObject2 = d.a.j.p((Iterable)localObject1);
      localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (y)((Iterator)localObject2).next();
        a locala = f.JoH;
        ((Collection)localObject1).add(a(localf, ((y)localObject3).index, (as)((y)localObject3).value));
      }
      localf.b(null, paramb, localList2, (List)localObject1, (ab)((as)d.a.j.iA(localList1)).fyA(), w.Jqq, az.JqT);
      localf.xT(true);
      AppMethodBeat.o(56737);
      return localf;
    }
    
    private static av a(f paramf, int paramInt, as paramas)
    {
      AppMethodBeat.i(56738);
      Object localObject1 = paramas.fyB().qV();
      k.g(localObject1, "typeParameter.name.asString()");
      switch (((String)localObject1).hashCode())
      {
      default: 
      case 84: 
        while (localObject1 == null)
        {
          paramf = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(56738);
          throw paramf;
          if (((String)localObject1).equals("T")) {
            localObject1 = "instance";
          }
        }
      }
      for (;;)
      {
        paramf = (a)paramf;
        Object localObject2 = g.JrB;
        localObject2 = g.a.fzI();
        localObject1 = d.l.b.a.b.f.f.aQC((String)localObject1);
        k.g(localObject1, "Name.identifier(name)");
        paramas = paramas.fyA();
        k.g(paramas, "typeParameter.defaultType");
        paramas = (ab)paramas;
        an localan = an.JqJ;
        k.g(localan, "SourceElement.NO_SOURCE");
        paramf = (av)new aj(paramf, null, paramInt, (g)localObject2, (d.l.b.a.b.f.f)localObject1, paramas, false, false, false, null, localan);
        AppMethodBeat.o(56738);
        return paramf;
        if (!((String)localObject1).equals("E")) {
          break;
        }
        localObject1 = "receiver";
        continue;
        localObject1 = ((String)localObject1).toLowerCase();
        k.g(localObject1, "(this as java.lang.String).toLowerCase()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.a.f
 * JD-Core Version:    0.7.0.1
 */