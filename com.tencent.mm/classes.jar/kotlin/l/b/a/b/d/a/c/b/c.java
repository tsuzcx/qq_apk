package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.d.a.a.k;
import kotlin.l.b.a.b.d.a.c.l;
import kotlin.l.b.a.b.d.a.e.ab;
import kotlin.l.b.a.b.d.a.e.w;
import kotlin.l.b.a.b.d.a.e.x;
import kotlin.l.b.a.b.d.a.e.z;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.v;

public final class c
{
  private final kotlin.l.b.a.b.d.a.c.h aiSh;
  private final l aiSq;
  final g aiUg;
  private final e aiUh;
  
  public c(kotlin.l.b.a.b.d.a.c.h paramh, l paraml)
  {
    AppMethodBeat.i(57975);
    this.aiSh = paramh;
    this.aiSq = paraml;
    this.aiUg = new g();
    this.aiUh = new e(this.aiUg);
    AppMethodBeat.o(57975);
  }
  
  private final List<az> a(final kotlin.l.b.a.b.d.a.e.j paramj, List<? extends ba> paramList, final ax paramax, final a parama)
  {
    AppMethodBeat.i(192160);
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(p.a(paramList, 10));
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      final ba localba = (ba)localIterator.next();
      if (kotlin.l.b.a.b.m.d.a.a(localba, null, parama.aiUa))
      {
        paramList = d.a(localba, parama);
        localCollection.add(paramList);
      }
      else
      {
        kotlin.l.b.a.b.m.ag localag = new kotlin.l.b.a.b.m.ag(this.aiSh.aiSp.aiBu, (kotlin.g.a.a)new a(this, localba, paramj, parama, paramax));
        if (paramj.kqX()) {}
        for (paramList = parama;; paramList = parama.a(b.aiUc))
        {
          paramList = e.a(localba, paramList, (ad)localag);
          break;
        }
      }
    }
    paramj = (List)localCollection;
    AppMethodBeat.o(192160);
    return paramj;
  }
  
  private final List<az> a(kotlin.l.b.a.b.d.a.e.j paramj, a parama, ax paramax)
  {
    AppMethodBeat.i(57972);
    List localList;
    if (!paramj.kqX())
    {
      if (!paramj.kqY().isEmpty()) {
        break label110;
      }
      localList = paramax.klq();
      s.s(localList, "constructor.parameters");
      if (((Collection)localList).isEmpty()) {
        break label104;
      }
      i = 1;
      if (i == 0) {
        break label110;
      }
    }
    label104:
    label110:
    for (int i = 1;; i = 0)
    {
      localList = paramax.klq();
      s.s(localList, "constructor.parameters");
      if (i == 0) {
        break label116;
      }
      paramj = a(paramj, localList, paramax, parama);
      AppMethodBeat.o(57972);
      return paramj;
      i = 0;
      break;
    }
    label116:
    if (localList.size() != paramj.kqY().size())
    {
      parama = (Iterable)localList;
      paramj = (Collection)new ArrayList(p.a(parama, 10));
      parama = parama.iterator();
      while (parama.hasNext()) {
        paramj.add(new bb((ad)v.bJt(((ba)parama.next()).kok().PF())));
      }
      paramj = p.p((Iterable)paramj);
      AppMethodBeat.o(57972);
      return paramj;
    }
    parama = p.s((Iterable)paramj.kqY());
    paramj = (Collection)new ArrayList(p.a(parama, 10));
    parama = parama.iterator();
    while (parama.hasNext())
    {
      paramax = (kotlin.a.ae)parama.next();
      int j = paramax.index;
      paramax = (w)paramax.value;
      if (j < localList.size()) {}
      for (i = 1; (ak.aiuY) && (i == 0); i = 0)
      {
        paramj = (Throwable)new AssertionError("Argument index should be less then type parameters count, but " + j + " > " + localList.size());
        AppMethodBeat.o(57972);
        throw paramj;
      }
      ba localba = (ba)localList.get(j);
      a locala = d.a(k.aiRp, false, null, 3);
      s.s(localba, "parameter");
      paramj.add(a(paramax, locala, localba));
    }
    paramj = p.p((Iterable)paramj);
    AppMethodBeat.o(57972);
    return paramj;
  }
  
  private final kotlin.l.b.a.b.b.e a(kotlin.l.b.a.b.d.a.e.j paramj, a parama, kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(57970);
    if ((parama.aiTZ) && (s.p(paramc, d.ksw())))
    {
      paramj = this.aiSh.aiSp.aiRW.kmY();
      AppMethodBeat.o(57970);
      return paramj;
    }
    kotlin.l.b.a.b.a.b.d locald = kotlin.l.b.a.b.a.b.d.aiFp;
    paramc = kotlin.l.b.a.b.a.b.d.a(paramc, this.aiSh.aiSp.aiEx.koV());
    if (paramc == null)
    {
      AppMethodBeat.o(57970);
      return null;
    }
    if ((kotlin.l.b.a.b.a.b.d.i(paramc)) && ((parama.aiTY == b.aiUe) || (parama.aiTX == k.aiRo) || (a(paramj, paramc))))
    {
      paramj = kotlin.l.b.a.b.a.b.d.j(paramc);
      AppMethodBeat.o(57970);
      return paramj;
    }
    AppMethodBeat.o(57970);
    return paramc;
  }
  
  private final ad a(kotlin.l.b.a.b.d.a.e.j paramj, a parama)
  {
    AppMethodBeat.i(57966);
    if ((!parama.aiTZ) && (parama.aiTX != k.aiRo)) {}
    boolean bool;
    for (int i = 1;; i = 0)
    {
      bool = paramj.kqX();
      if ((bool) || (i != 0)) {
        break label88;
      }
      parama = a(paramj, parama, null);
      if (parama != null) {
        break;
      }
      paramj = (ad)b(paramj);
      AppMethodBeat.o(57966);
      return paramj;
    }
    paramj = (ad)parama;
    AppMethodBeat.o(57966);
    return paramj;
    label88:
    al localal = a(paramj, parama.a(b.aiUe), null);
    if (localal == null)
    {
      paramj = (ad)b(paramj);
      AppMethodBeat.o(57966);
      return paramj;
    }
    parama = a(paramj, parama.a(b.aiUd), localal);
    if (parama == null)
    {
      paramj = (ad)b(paramj);
      AppMethodBeat.o(57966);
      return paramj;
    }
    if (bool)
    {
      paramj = (ad)new f(localal, parama);
      AppMethodBeat.o(57966);
      return paramj;
    }
    paramj = (ad)kotlin.l.b.a.b.m.ae.a(localal, parama);
    AppMethodBeat.o(57966);
    return paramj;
  }
  
  private final al a(kotlin.l.b.a.b.d.a.e.j paramj, a parama, al paramal)
  {
    AppMethodBeat.i(57967);
    if (paramal == null) {}
    Object localObject2;
    ax localax;
    for (Object localObject1 = null;; localObject1 = paramal.knl())
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.d.a.c.e(this.aiSh, (kotlin.l.b.a.b.d.a.e.d)paramj);
      }
      localax = b(paramj, parama);
      if (localax != null) {
        break;
      }
      AppMethodBeat.o(57967);
      return null;
    }
    boolean bool = a(parama);
    if (paramal == null) {}
    for (localObject1 = null; (s.p(localObject1, localax)) && (!paramj.kqX()) && (bool); localObject1 = paramal.kzm())
    {
      paramj = paramal.Pq(true);
      AppMethodBeat.o(57967);
      return paramj;
    }
    paramj = kotlin.l.b.a.b.m.ae.c((kotlin.l.b.a.b.b.a.g)localObject2, localax, a(paramj, parama, localax), bool);
    AppMethodBeat.o(57967);
    return paramj;
  }
  
  private final ax a(kotlin.l.b.a.b.d.a.e.j paramj)
  {
    AppMethodBeat.i(57969);
    paramj = kotlin.l.b.a.b.f.b.s(new kotlin.l.b.a.b.f.c(paramj.kqV()));
    s.s(paramj, "topLevel(FqName(javaType.classifierQualifiedName))");
    paramj = this.aiSh.aiSp.aiRM.ksJ().aiBS.a(paramj, p.listOf(Integer.valueOf(0))).kmZ();
    s.s(paramj, "c.components.deserialize…istOf(0)).typeConstructor");
    AppMethodBeat.o(57969);
    return paramj;
  }
  
  private final az a(w paramw, a parama, ba paramba)
  {
    AppMethodBeat.i(57973);
    if ((paramw instanceof ab))
    {
      w localw = ((ab)paramw).krm();
      if (((ab)paramw).krl()) {}
      for (paramw = bl.ajqO; (localw == null) || (a(paramw, paramba)); paramw = bl.ajqN)
      {
        paramw = d.a(paramba, parama);
        AppMethodBeat.o(57973);
        return paramw;
      }
      paramw = kotlin.l.b.a.b.m.d.a.a(a(localw, d.a(k.aiRp, false, null, 3)), paramw, paramba);
      AppMethodBeat.o(57973);
      return paramw;
    }
    paramw = (az)new bb(bl.ajqM, a(paramw, parama));
    AppMethodBeat.o(57973);
    return paramw;
  }
  
  private static boolean a(a parama)
  {
    if (parama.aiTY == b.aiUe) {}
    while ((parama.aiTZ) || (parama.aiTX == k.aiRo)) {
      return false;
    }
    return true;
  }
  
  private static boolean a(kotlin.l.b.a.b.d.a.e.j paramj, kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(57971);
    if (!z.a((w)p.oN(paramj.kqY())))
    {
      AppMethodBeat.o(57971);
      return false;
    }
    paramj = kotlin.l.b.a.b.a.b.d.aiFp;
    paramj = kotlin.l.b.a.b.a.b.d.j(parame).kmZ().klq();
    s.s(paramj, "JavaToKotlinClassMapper.…ypeConstructor.parameters");
    paramj = (ba)p.oN(paramj);
    if (paramj == null) {}
    for (paramj = null; paramj == null; paramj = paramj.kom())
    {
      AppMethodBeat.o(57971);
      return false;
    }
    if (paramj != bl.ajqO)
    {
      AppMethodBeat.o(57971);
      return true;
    }
    AppMethodBeat.o(57971);
    return false;
  }
  
  private static boolean a(bl parambl, ba paramba)
  {
    AppMethodBeat.i(57974);
    if (paramba.kom() == bl.ajqM)
    {
      AppMethodBeat.o(57974);
      return false;
    }
    if (parambl != paramba.kom())
    {
      AppMethodBeat.o(57974);
      return true;
    }
    AppMethodBeat.o(57974);
    return false;
  }
  
  private static final al b(kotlin.l.b.a.b.d.a.e.j paramj)
  {
    AppMethodBeat.i(192165);
    paramj = v.bJt(s.X("Unresolved java class ", paramj.kqW()));
    s.s(paramj, "createErrorType(\"Unresol…vaType.presentableText}\")");
    AppMethodBeat.o(192165);
    return paramj;
  }
  
  private final ax b(kotlin.l.b.a.b.d.a.e.j paramj, a parama)
  {
    AppMethodBeat.i(57968);
    kotlin.l.b.a.b.d.a.e.i locali = paramj.kqU();
    if (locali == null)
    {
      paramj = a(paramj);
      AppMethodBeat.o(57968);
      return paramj;
    }
    if ((locali instanceof kotlin.l.b.a.b.d.a.e.g))
    {
      Object localObject = ((kotlin.l.b.a.b.d.a.e.g)locali).koY();
      if (localObject == null)
      {
        paramj = new AssertionError(s.X("Class type should have a FQ name: ", locali));
        AppMethodBeat.o(57968);
        throw paramj;
      }
      localObject = a(paramj, parama, (kotlin.l.b.a.b.f.c)localObject);
      parama = (a)localObject;
      if (localObject == null) {
        parama = this.aiSh.aiSp.aiRT.c((kotlin.l.b.a.b.d.a.e.g)locali);
      }
      if (parama == null) {}
      for (parama = null; parama == null; parama = parama.kmZ())
      {
        paramj = a(paramj);
        AppMethodBeat.o(57968);
        return paramj;
      }
      AppMethodBeat.o(57968);
      return parama;
    }
    if ((locali instanceof x))
    {
      paramj = this.aiSq.a((x)locali);
      if (paramj == null)
      {
        AppMethodBeat.o(57968);
        return null;
      }
      paramj = paramj.kmZ();
      AppMethodBeat.o(57968);
      return paramj;
    }
    paramj = new IllegalStateException(s.X("Unknown classifier kind: ", locali));
    AppMethodBeat.o(57968);
    throw paramj;
  }
  
  public final ad a(kotlin.l.b.a.b.d.a.e.f paramf, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(57965);
    s.u(paramf, "arrayType");
    s.u(parama, "attr");
    w localw = paramf.kqB();
    if ((localw instanceof kotlin.l.b.a.b.d.a.e.u))
    {
      localObject = (kotlin.l.b.a.b.d.a.e.u)localw;
      if (localObject != null) {
        break label156;
      }
    }
    kotlin.l.b.a.b.d.a.c.e locale;
    label156:
    for (Object localObject = null;; localObject = ((kotlin.l.b.a.b.d.a.e.u)localObject).krj())
    {
      locale = new kotlin.l.b.a.b.d.a.c.e(this.aiSh, (kotlin.l.b.a.b.d.a.e.d)paramf, true);
      if (localObject == null) {
        break label189;
      }
      paramf = this.aiSh.aiSp.aiEx.koV().b((kotlin.l.b.a.b.a.i)localObject);
      s.s(paramf, "c.module.builtIns.getPri…KotlinType(primitiveType)");
      localObject = kotlin.l.b.a.b.b.a.g.aiIh;
      paramf.d(g.a.oS(p.c((Iterable)locale, (Iterable)paramf.knl())));
      if (!parama.aiTZ) {
        break label168;
      }
      paramf = (ad)paramf;
      AppMethodBeat.o(57965);
      return paramf;
      localObject = null;
      break;
    }
    label168:
    paramf = (ad)kotlin.l.b.a.b.m.ae.a(paramf, paramf.Pq(true));
    AppMethodBeat.o(57965);
    return paramf;
    label189:
    localObject = a(localw, d.a(k.aiRp, parama.aiTZ, null, 2));
    if (parama.aiTZ)
    {
      if (paramBoolean) {}
      for (paramf = bl.ajqO;; paramf = bl.ajqM)
      {
        paramf = this.aiSh.aiSp.aiEx.koV().a(paramf, (ad)localObject, (kotlin.l.b.a.b.b.a.g)locale);
        s.s(paramf, "c.module.builtIns.getArr…mponentType, annotations)");
        paramf = (ad)paramf;
        AppMethodBeat.o(57965);
        return paramf;
      }
    }
    paramf = this.aiSh.aiSp.aiEx.koV().a(bl.ajqM, (ad)localObject, (kotlin.l.b.a.b.b.a.g)locale);
    s.s(paramf, "c.module.builtIns.getArr…mponentType, annotations)");
    paramf = (ad)kotlin.l.b.a.b.m.ae.a(paramf, this.aiSh.aiSp.aiEx.koV().a(bl.ajqO, (ad)localObject, (kotlin.l.b.a.b.b.a.g)locale).Pq(true));
    AppMethodBeat.o(57965);
    return paramf;
  }
  
  public final ad a(w paramw, a parama)
  {
    AppMethodBeat.i(57964);
    s.u(parama, "attr");
    if ((paramw instanceof kotlin.l.b.a.b.d.a.e.u))
    {
      paramw = ((kotlin.l.b.a.b.d.a.e.u)paramw).krj();
      if (paramw != null) {}
      for (paramw = this.aiSh.aiSp.aiEx.koV().a(paramw);; paramw = this.aiSh.aiSp.aiEx.koV().kmW())
      {
        s.s(paramw, "{\n                val pr…ns.unitType\n            }");
        paramw = (ad)paramw;
        AppMethodBeat.o(57964);
        return paramw;
      }
    }
    if ((paramw instanceof kotlin.l.b.a.b.d.a.e.j))
    {
      paramw = a((kotlin.l.b.a.b.d.a.e.j)paramw, parama);
      AppMethodBeat.o(57964);
      return paramw;
    }
    if ((paramw instanceof kotlin.l.b.a.b.d.a.e.f))
    {
      paramw = a((kotlin.l.b.a.b.d.a.e.f)paramw, parama, false);
      AppMethodBeat.o(57964);
      return paramw;
    }
    if ((paramw instanceof ab))
    {
      paramw = ((ab)paramw).krm();
      if (paramw == null) {}
      for (paramw = null; paramw == null; paramw = a(paramw, parama))
      {
        paramw = this.aiSh.aiSp.aiEx.koV().kmQ();
        s.s(paramw, "c.module.builtIns.defaultBound");
        paramw = (ad)paramw;
        AppMethodBeat.o(57964);
        return paramw;
      }
      AppMethodBeat.o(57964);
      return paramw;
    }
    if (paramw == null)
    {
      paramw = this.aiSh.aiSp.aiEx.koV().kmQ();
      s.s(paramw, "c.module.builtIns.defaultBound");
      paramw = (ad)paramw;
      AppMethodBeat.o(57964);
      return paramw;
    }
    paramw = new UnsupportedOperationException(s.X("Unsupported type: ", paramw));
    AppMethodBeat.o(57964);
    throw paramw;
  }
  
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ad>
  {
    a(c paramc, ba paramba, kotlin.l.b.a.b.d.a.e.j paramj, a parama, ax paramax)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.b.c
 * JD-Core Version:    0.7.0.1
 */