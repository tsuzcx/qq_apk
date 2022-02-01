package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.a.y;
import kotlin.aa;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.c.ae;
import kotlin.l.b.a.b.b.c.aj;
import kotlin.l.b.a.b.b.c.p.a;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ba;
import kotlin.l.b.a.b.m.bh;

public final class f
  extends ae
{
  public static final a TfI;
  
  static
  {
    AppMethodBeat.i(56743);
    TfI = new a((byte)0);
    AppMethodBeat.o(56743);
  }
  
  private f(l paraml, f paramf, b.a parama, boolean paramBoolean)
  {
    super(paraml, paramf, g.a.hBP(), kotlin.l.b.a.b.n.j.TQF, parama, an.ThK);
    AppMethodBeat.i(56742);
    this.TkM = true;
    this.TkU = paramBoolean;
    EC(false);
    AppMethodBeat.o(56742);
  }
  
  private final kotlin.l.b.a.b.b.t ky(List<kotlin.l.b.a.b.f.f> paramList)
  {
    boolean bool = true;
    AppMethodBeat.i(56741);
    int j = hAw().size() - paramList.size();
    if ((j == 0) || (j == 1)) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(56741);
      throw paramList;
    }
    Object localObject1 = hAw();
    kotlin.g.b.p.g(localObject1, "valueParameters");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      av localav = (av)localIterator.next();
      kotlin.g.b.p.g(localav, "it");
      localObject2 = localav.hAH();
      kotlin.g.b.p.g(localObject2, "it.name");
      i = localav.getIndex();
      int k = i - j;
      localObject1 = localObject2;
      if (k >= 0)
      {
        kotlin.l.b.a.b.f.f localf = (kotlin.l.b.a.b.f.f)paramList.get(k);
        localObject1 = localObject2;
        if (localf != null) {
          localObject1 = localf;
        }
      }
      localCollection.add(localav.a((a)this, (kotlin.l.b.a.b.f.f)localObject1, i));
    }
    localObject1 = (List)localCollection;
    Object localObject2 = h(ba.TOF);
    paramList = (Iterable)paramList;
    if (!((Collection)paramList).isEmpty())
    {
      paramList = paramList.iterator();
      if (paramList.hasNext()) {
        if ((kotlin.l.b.a.b.f.f)paramList.next() == null)
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
      ((p.a)localObject2).Tlt = Boolean.valueOf(bool);
      paramList = ((p.a)localObject2).kB((List)localObject1).f((kotlin.l.b.a.b.b.b)hCu());
      kotlin.g.b.p.g(paramList, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
      paramList = super.a(paramList);
      if (paramList == null) {
        kotlin.g.b.p.hyc();
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
  
  public final kotlin.l.b.a.b.b.c.p a(l paraml, kotlin.l.b.a.b.b.t paramt, b.a parama, kotlin.l.b.a.b.f.f paramf, g paramg, an paraman)
  {
    AppMethodBeat.i(56740);
    kotlin.g.b.p.h(paraml, "newOwner");
    kotlin.g.b.p.h(parama, "kind");
    kotlin.g.b.p.h(paramg, "annotations");
    kotlin.g.b.p.h(paraman, "source");
    paraml = (kotlin.l.b.a.b.b.c.p)new f(paraml, (f)paramt, parama, hAZ());
    AppMethodBeat.o(56740);
    return paraml;
  }
  
  public final kotlin.l.b.a.b.b.t a(p.a parama)
  {
    AppMethodBeat.i(56739);
    kotlin.g.b.p.h(parama, "configuration");
    parama = (f)super.a(parama);
    if (parama == null)
    {
      AppMethodBeat.o(56739);
      return null;
    }
    Object localObject1 = parama.hAw();
    kotlin.g.b.p.g(localObject1, "substituted.valueParameters");
    localObject1 = (Iterable)localObject1;
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (av)((Iterator)localObject1).next();
        kotlin.g.b.p.g(localObject2, "it");
        localObject2 = ((av)localObject2).hBy();
        kotlin.g.b.p.g(localObject2, "it.type");
        if (kotlin.l.b.a.b.a.f.k((ab)localObject2) != null)
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
      parama = (kotlin.l.b.a.b.b.t)parama;
      AppMethodBeat.o(56739);
      return parama;
      i = 0;
      break label126;
      label151:
      break;
    }
    label158:
    localObject1 = parama.hAw();
    kotlin.g.b.p.g(localObject1, "substituted.valueParameters");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (av)((Iterator)localObject2).next();
      kotlin.g.b.p.g(localObject3, "it");
      localObject3 = ((av)localObject3).hBy();
      kotlin.g.b.p.g(localObject3, "it.type");
      ((Collection)localObject1).add(kotlin.l.b.a.b.a.f.k((ab)localObject3));
    }
    parama = parama.ky((List)localObject1);
    AppMethodBeat.o(56739);
    return parama;
  }
  
  public final boolean hzI()
  {
    return false;
  }
  
  public final boolean hzX()
  {
    return false;
  }
  
  public final boolean isExternal()
  {
    return false;
  }
  
  public static final class a
  {
    public static f a(b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(56737);
      kotlin.g.b.p.h(paramb, "functionClass");
      List localList1 = paramb.parameters;
      f localf = new f((l)paramb, b.a.TgW, paramBoolean);
      paramb = paramb.hAO();
      List localList2 = (List)v.SXr;
      Object localObject2 = (Iterable)localList1;
      Object localObject1 = new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((as)localObject3).hAJ() == bh.TOR) {}
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
      localObject2 = kotlin.a.j.s((Iterable)localObject1);
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (y)((Iterator)localObject2).next();
        a locala = f.TfI;
        ((Collection)localObject1).add(a(localf, ((y)localObject3).index, (as)((y)localObject3).value));
      }
      localf.b(null, paramb, localList2, (List)localObject1, (ab)((as)kotlin.a.j.ku(localList1)).hAG(), w.Thr, az.ThU);
      localf.ED(true);
      AppMethodBeat.o(56737);
      return localf;
    }
    
    private static av a(f paramf, int paramInt, as paramas)
    {
      AppMethodBeat.i(56738);
      Object localObject1 = paramas.hAH().sG();
      kotlin.g.b.p.g(localObject1, "typeParameter.name.asString()");
      switch (((String)localObject1).hashCode())
      {
      default: 
      case 84: 
        while (localObject1 == null)
        {
          paramf = new kotlin.t("null cannot be cast to non-null type java.lang.String");
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
        Object localObject2 = g.TiC;
        localObject2 = g.a.hBP();
        localObject1 = kotlin.l.b.a.b.f.f.btY((String)localObject1);
        kotlin.g.b.p.g(localObject1, "Name.identifier(name)");
        paramas = paramas.hAG();
        kotlin.g.b.p.g(paramas, "typeParameter.defaultType");
        paramas = (ab)paramas;
        an localan = an.ThK;
        kotlin.g.b.p.g(localan, "SourceElement.NO_SOURCE");
        paramf = (av)new aj(paramf, null, paramInt, (g)localObject2, (kotlin.l.b.a.b.f.f)localObject1, paramas, false, false, false, null, localan);
        AppMethodBeat.o(56738);
        return paramf;
        if (!((String)localObject1).equals("E")) {
          break;
        }
        localObject1 = "receiver";
        continue;
        localObject1 = ((String)localObject1).toLowerCase();
        kotlin.g.b.p.g(localObject1, "(this as java.lang.String).toLowerCase()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.a.f
 * JD-Core Version:    0.7.0.1
 */