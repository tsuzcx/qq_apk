package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.a.ae;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.c.af;
import kotlin.l.b.a.b.b.c.p.a;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.n.j;

public final class e
  extends af
{
  public static final a aiES;
  
  static
  {
    AppMethodBeat.i(56743);
    aiES = new a((byte)0);
    AppMethodBeat.o(56743);
  }
  
  private e(l paraml, e parame, b.a parama, boolean paramBoolean)
  {
    super(paraml, parame, g.a.kpB(), j.ajsu, parama, av.aiHu);
    AppMethodBeat.i(56742);
    this.aiKr = true;
    this.aiKz = paramBoolean;
    Pl(false);
    AppMethodBeat.o(56742);
  }
  
  private final x oQ(List<f> paramList)
  {
    boolean bool = true;
    AppMethodBeat.i(56741);
    int j = kod().size() - paramList.size();
    if ((j == 0) || (j == 1)) {}
    for (int i = 1; (kotlin.ak.aiuY) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(56741);
      throw paramList;
    }
    Object localObject1 = kod();
    kotlin.g.b.s.s(localObject1, "valueParameters");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      bd localbd = (bd)localIterator.next();
      localObject2 = localbd.kok();
      kotlin.g.b.s.s(localObject2, "it.name");
      i = localbd.getIndex();
      int k = i - j;
      localObject1 = localObject2;
      if (k >= 0)
      {
        f localf = (f)paramList.get(k);
        localObject1 = localObject2;
        if (localf != null) {
          localObject1 = localf;
        }
      }
      localCollection.add(localbd.a((a)this, (f)localObject1, i));
    }
    localObject1 = (List)localCollection;
    Object localObject2 = h(be.ajqz);
    paramList = (Iterable)paramList;
    if (!((Collection)paramList).isEmpty())
    {
      paramList = paramList.iterator();
      if (paramList.hasNext()) {
        if ((f)paramList.next() == null)
        {
          i = 1;
          label293:
          if (i == 0) {
            break label357;
          }
        }
      }
    }
    for (;;)
    {
      ((p.a)localObject2).aiKY = Boolean.valueOf(bool);
      paramList = ((p.a)localObject2).oW((List)localObject1).f((kotlin.l.b.a.b.b.b)kqi());
      kotlin.g.b.s.s(paramList, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
      paramList = super.a(paramList);
      kotlin.g.b.s.checkNotNull(paramList);
      kotlin.g.b.s.s(paramList, "super.doSubstitute(copyConfiguration)!!");
      AppMethodBeat.o(56741);
      return paramList;
      i = 0;
      break label293;
      label357:
      break;
      bool = false;
    }
  }
  
  public final kotlin.l.b.a.b.b.c.p a(l paraml, x paramx, b.a parama, f paramf, kotlin.l.b.a.b.b.a.g paramg, av paramav)
  {
    AppMethodBeat.i(56740);
    kotlin.g.b.s.u(paraml, "newOwner");
    kotlin.g.b.s.u(parama, "kind");
    kotlin.g.b.s.u(paramg, "annotations");
    kotlin.g.b.s.u(paramav, "source");
    paraml = (kotlin.l.b.a.b.b.c.p)new e(paraml, (e)paramx, parama, koN());
    AppMethodBeat.o(56740);
    return paraml;
  }
  
  public final x a(p.a parama)
  {
    AppMethodBeat.i(56739);
    kotlin.g.b.s.u(parama, "configuration");
    parama = (e)super.a(parama);
    if (parama == null)
    {
      AppMethodBeat.o(56739);
      return null;
    }
    Object localObject1 = parama.kod();
    kotlin.g.b.s.s(localObject1, "substituted.valueParameters");
    localObject1 = (Iterable)localObject1;
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((bd)((Iterator)localObject1).next()).koG();
        kotlin.g.b.s.s(localObject2, "it.type");
        if (kotlin.l.b.a.b.a.g.k((ad)localObject2) != null)
        {
          i = 1;
          label115:
          if (i == 0) {
            break label140;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label147;
      }
      parama = (x)parama;
      AppMethodBeat.o(56739);
      return parama;
      i = 0;
      break label115;
      label140:
      break;
    }
    label147:
    localObject1 = parama.kod();
    kotlin.g.b.s.s(localObject1, "substituted.valueParameters");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ad localad = ((bd)((Iterator)localObject2).next()).koG();
      kotlin.g.b.s.s(localad, "it.type");
      ((Collection)localObject1).add(kotlin.l.b.a.b.a.g.k(localad));
    }
    parama = parama.oQ((List)localObject1);
    AppMethodBeat.o(56739);
    return parama;
  }
  
  public final boolean knC()
  {
    return false;
  }
  
  public final boolean kng()
  {
    return false;
  }
  
  public final boolean knk()
  {
    return false;
  }
  
  public static final class a
  {
    public static e a(b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(56737);
      kotlin.g.b.s.u(paramb, "functionClass");
      List localList1 = paramb.aiED;
      e locale = new e((l)paramb, b.a.aiGl, paramBoolean);
      paramb = paramb.kov();
      List localList2 = (List)kotlin.a.ab.aivy;
      Object localObject2 = (Iterable)localList1;
      Object localObject1 = new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((ba)localObject3).kom() == bl.ajqN) {}
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
      localObject2 = kotlin.a.p.s((Iterable)localObject1);
      localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ae)((Iterator)localObject2).next();
        a locala = e.aiES;
        ((Collection)localObject1).add(a(locale, ((ae)localObject3).index, (ba)((ae)localObject3).value));
      }
      locale.b(null, paramb, localList2, (List)localObject1, (ad)((ba)kotlin.a.p.oM(localList1)).koj(), kotlin.l.b.a.b.b.ab.aiHb, kotlin.l.b.a.b.b.s.aiGG);
      locale.Pm(true);
      AppMethodBeat.o(56737);
      return locale;
    }
    
    private static bd a(e parame, int paramInt, ba paramba)
    {
      AppMethodBeat.i(56738);
      Object localObject1 = paramba.kok().PF();
      kotlin.g.b.s.s(localObject1, "typeParameter.name.asString()");
      if (kotlin.g.b.s.p(localObject1, "T")) {
        localObject1 = "instance";
      }
      for (;;)
      {
        parame = (a)parame;
        Object localObject2 = kotlin.l.b.a.b.b.a.g.aiIh;
        localObject2 = g.a.kpB();
        localObject1 = f.bJe((String)localObject1);
        kotlin.g.b.s.s(localObject1, "identifier(name)");
        paramba = paramba.koj();
        kotlin.g.b.s.s(paramba, "typeParameter.defaultType");
        paramba = (ad)paramba;
        av localav = av.aiHu;
        kotlin.g.b.s.s(localav, "NO_SOURCE");
        parame = (bd)new kotlin.l.b.a.b.b.c.ak(parame, null, paramInt, (kotlin.l.b.a.b.b.a.g)localObject2, (f)localObject1, paramba, false, false, false, null, localav);
        AppMethodBeat.o(56738);
        return parame;
        if (kotlin.g.b.s.p(localObject1, "E"))
        {
          localObject1 = "receiver";
        }
        else
        {
          localObject1 = ((String)localObject1).toLowerCase(Locale.ROOT);
          kotlin.g.b.s.s(localObject1, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */