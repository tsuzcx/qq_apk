package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.d.a.c.m;
import kotlin.l.b.a.b.d.a.e.v;
import kotlin.l.b.a.b.d.a.e.w;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bh;

public final class c
{
  private final h aaUh;
  private final m aaUq;
  
  public c(h paramh, m paramm)
  {
    AppMethodBeat.i(57975);
    this.aaUh = paramh;
    this.aaUq = paramm;
    AppMethodBeat.o(57975);
  }
  
  private final List<av> a(kotlin.l.b.a.b.d.a.e.j paramj, final a parama, final at paramat)
  {
    AppMethodBeat.i(57972);
    final boolean bool = paramj.iHq();
    Object localObject1;
    int i;
    label71:
    Object localObject2;
    label123:
    Object localObject3;
    ae localae;
    if (!bool)
    {
      if (!paramj.iHr().isEmpty()) {
        break label227;
      }
      localObject1 = paramat.iCb();
      p.j(localObject1, "constructor.parameters");
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label227;
        }
      }
    }
    else
    {
      i = 1;
      localObject1 = paramat.iCb();
      p.j(localObject1, "constructor.parameters");
      if (i == 0) {
        break label263;
      }
      paramj = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a(paramj, 10));
      localObject2 = paramj.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label244;
      }
      localObject3 = (as)((Iterator)localObject2).next();
      localae = new ae(this.aaUh.aaUp.aaFH, (kotlin.g.a.a)new b((as)localObject3, this, parama, paramat, bool));
      paramj = e.aaWp;
      p.j(localObject3, "parameter");
      if (!bool) {
        break label233;
      }
    }
    label227:
    label233:
    for (paramj = parama;; paramj = parama.a(b.aaVZ))
    {
      ((Collection)localObject1).add(e.a((as)localObject3, paramj, (ab)localae));
      break label123;
      i = 0;
      break;
      i = 0;
      break label71;
    }
    label244:
    paramj = kotlin.a.j.p((Iterable)localObject1);
    AppMethodBeat.o(57972);
    return paramj;
    label263:
    if (((List)localObject1).size() != paramj.iHr().size())
    {
      parama = (Iterable)localObject1;
      paramj = (Collection)new ArrayList(kotlin.a.j.a(parama, 10));
      parama = parama.iterator();
      while (parama.hasNext())
      {
        paramat = (as)parama.next();
        p.j(paramat, "p");
        paramj.add(new ax((ab)kotlin.l.b.a.b.m.u.bHp(paramat.iEU().qu())));
      }
      paramj = kotlin.a.j.p((Iterable)paramj);
      AppMethodBeat.o(57972);
      return paramj;
    }
    parama = kotlin.a.j.s((Iterable)paramj.iHr());
    paramj = (Collection)new ArrayList(kotlin.a.j.a(parama, 10));
    parama = parama.iterator();
    while (parama.hasNext())
    {
      paramat = (kotlin.a.y)parama.next();
      int j = paramat.index;
      paramat = (v)paramat.value;
      if (j < ((List)localObject1).size()) {}
      for (i = 1; (kotlin.z.aazO) && (i == 0); i = 0)
      {
        paramj = (Throwable)new AssertionError("Argument index should be less then type parameters count, but " + j + " > " + ((List)localObject1).size());
        AppMethodBeat.o(57972);
        throw paramj;
      }
      localObject2 = (as)((List)localObject1).get(j);
      localObject3 = d.a(kotlin.l.b.a.b.d.a.a.l.aaTp, false, null, 3);
      p.j(localObject2, "parameter");
      paramj.add(a(paramat, (a)localObject3, (as)localObject2));
    }
    paramj = kotlin.a.j.p((Iterable)paramj);
    AppMethodBeat.o(57972);
    return paramj;
  }
  
  private final kotlin.l.b.a.b.b.e a(kotlin.l.b.a.b.d.a.e.j paramj, a parama, kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57970);
    if ((parama.aaVX) && (p.h(paramb, d.iIp())))
    {
      paramj = this.aaUh.aaUp.aaTW.iDH();
      AppMethodBeat.o(57970);
      return paramj;
    }
    kotlin.l.b.a.b.a.b.c localc = kotlin.l.b.a.b.a.b.c.aaIT;
    paramb = kotlin.l.b.a.b.a.b.c.a(paramb, this.aaUh.aaUp.aaIj.iFv());
    if (paramb == null)
    {
      AppMethodBeat.o(57970);
      return null;
    }
    if ((kotlin.l.b.a.b.a.b.c.i(paramb)) && ((parama.aaVW == b.aaWb) || (parama.aaVV == kotlin.l.b.a.b.d.a.a.l.aaTo) || (a(paramj, paramb))))
    {
      paramj = kotlin.l.b.a.b.a.b.c.k(paramb);
      AppMethodBeat.o(57970);
      return paramj;
    }
    AppMethodBeat.o(57970);
    return paramb;
  }
  
  private final ab a(kotlin.l.b.a.b.d.a.e.j paramj, a parama)
  {
    AppMethodBeat.i(57966);
    c localc = new c(paramj);
    if ((!parama.aaVX) && (parama.aaVV != kotlin.l.b.a.b.d.a.a.l.aaTo)) {}
    boolean bool;
    for (int i = 1;; i = 0)
    {
      bool = paramj.iHq();
      if ((bool) || (i != 0)) {
        break label99;
      }
      paramj = a(paramj, parama, null);
      if (paramj == null) {
        break;
      }
      paramj = (ab)paramj;
      AppMethodBeat.o(57966);
      return paramj;
    }
    paramj = (ab)localc.iIo();
    AppMethodBeat.o(57966);
    return paramj;
    label99:
    aj localaj = a(paramj, parama.a(b.aaWb), null);
    if (localaj == null)
    {
      paramj = (ab)localc.iIo();
      AppMethodBeat.o(57966);
      return paramj;
    }
    paramj = a(paramj, parama.a(b.aaWa), localaj);
    if (paramj == null)
    {
      paramj = (ab)localc.iIo();
      AppMethodBeat.o(57966);
      return paramj;
    }
    if (bool)
    {
      paramj = (ab)new g(localaj, paramj);
      AppMethodBeat.o(57966);
      return paramj;
    }
    paramj = (ab)ac.a(localaj, paramj);
    AppMethodBeat.o(57966);
    return paramj;
  }
  
  private final aj a(kotlin.l.b.a.b.d.a.e.j paramj, a parama, aj paramaj)
  {
    AppMethodBeat.i(57967);
    Object localObject1;
    if (paramaj != null)
    {
      localObject2 = paramaj.iDY();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.d.a.c.e(this.aaUh, (kotlin.l.b.a.b.d.a.e.d)paramj);
    }
    at localat = b(paramj, parama);
    if (localat == null)
    {
      AppMethodBeat.o(57967);
      return null;
    }
    boolean bool = a(parama);
    if (paramaj != null) {}
    for (Object localObject2 = paramaj.iOU(); (p.h(localObject2, localat)) && (!paramj.iHq()) && (bool); localObject2 = null)
    {
      paramj = paramaj.Jn(true);
      AppMethodBeat.o(57967);
      return paramj;
    }
    paramj = ac.c((kotlin.l.b.a.b.b.a.g)localObject1, localat, a(paramj, parama, localat), bool);
    AppMethodBeat.o(57967);
    return paramj;
  }
  
  private final at a(kotlin.l.b.a.b.d.a.e.j paramj)
  {
    AppMethodBeat.i(57969);
    paramj = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b(paramj.iHo()));
    p.j(paramj, "ClassId.topLevel(FqName(…classifierQualifiedName))");
    paramj = this.aaUh.aaUp.aaTM.iIC().aaHL.a(paramj, kotlin.a.j.listOf(Integer.valueOf(0))).iDL();
    p.j(paramj, "c.components.deserialize…istOf(0)).typeConstructor");
    AppMethodBeat.o(57969);
    return paramj;
  }
  
  private final av a(v paramv, a parama, as paramas)
  {
    AppMethodBeat.i(57973);
    if ((paramv instanceof kotlin.l.b.a.b.d.a.e.z))
    {
      v localv = ((kotlin.l.b.a.b.d.a.e.z)paramv).iHE();
      if (((kotlin.l.b.a.b.d.a.e.z)paramv).iHF()) {}
      for (paramv = bh.abrr; (localv == null) || (a(paramv, paramas)); paramv = bh.abrq)
      {
        paramv = d.a(paramas, parama);
        AppMethodBeat.o(57973);
        return paramv;
      }
      paramv = kotlin.l.b.a.b.m.d.a.a(a(localv, d.a(kotlin.l.b.a.b.d.a.a.l.aaTp, false, null, 3)), paramv, paramas);
      AppMethodBeat.o(57973);
      return paramv;
    }
    paramv = (av)new ax(bh.abrp, a(paramv, parama));
    AppMethodBeat.o(57973);
    return paramv;
  }
  
  private static boolean a(a parama)
  {
    if (parama.aaVW == b.aaWb) {}
    while ((parama.aaVX) || (parama.aaVV == kotlin.l.b.a.b.d.a.a.l.aaTo)) {
      return false;
    }
    return true;
  }
  
  private static boolean a(kotlin.l.b.a.b.d.a.e.j paramj, kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(57971);
    a locala = a.aaWd;
    if (!a.a((v)kotlin.a.j.lr(paramj.iHr())))
    {
      AppMethodBeat.o(57971);
      return false;
    }
    paramj = kotlin.l.b.a.b.a.b.c.aaIT;
    paramj = kotlin.l.b.a.b.a.b.c.k(parame).iDL();
    p.j(paramj, "JavaToKotlinClassMap.con…         .typeConstructor");
    paramj = paramj.iCb();
    p.j(paramj, "JavaToKotlinClassMap.con…ypeConstructor.parameters");
    paramj = (as)kotlin.a.j.lr(paramj);
    if (paramj != null)
    {
      paramj = paramj.iEW();
      if (paramj != null) {}
    }
    else
    {
      AppMethodBeat.o(57971);
      return false;
    }
    p.j(paramj, "JavaToKotlinClassMap.con….variance ?: return false");
    if (paramj != bh.abrr)
    {
      AppMethodBeat.o(57971);
      return true;
    }
    AppMethodBeat.o(57971);
    return false;
  }
  
  private static boolean a(bh parambh, as paramas)
  {
    AppMethodBeat.i(57974);
    if (paramas.iEW() == bh.abrp)
    {
      AppMethodBeat.o(57974);
      return false;
    }
    if (parambh != paramas.iEW())
    {
      AppMethodBeat.o(57974);
      return true;
    }
    AppMethodBeat.o(57974);
    return false;
  }
  
  private final at b(kotlin.l.b.a.b.d.a.e.j paramj, a parama)
  {
    AppMethodBeat.i(57968);
    kotlin.l.b.a.b.d.a.e.i locali = paramj.iHn();
    if (locali == null)
    {
      paramj = a(paramj);
      AppMethodBeat.o(57968);
      return paramj;
    }
    if ((locali instanceof kotlin.l.b.a.b.d.a.e.g))
    {
      Object localObject = ((kotlin.l.b.a.b.d.a.e.g)locali).iFy();
      if (localObject == null)
      {
        paramj = (Throwable)new AssertionError("Class type should have a FQ name: ".concat(String.valueOf(locali)));
        AppMethodBeat.o(57968);
        throw paramj;
      }
      localObject = a(paramj, parama, (kotlin.l.b.a.b.f.b)localObject);
      parama = (a)localObject;
      if (localObject == null) {
        parama = this.aaUh.aaUp.aaTT.c((kotlin.l.b.a.b.d.a.e.g)locali);
      }
      if (parama != null)
      {
        parama = parama.iDL();
        if (parama != null) {}
      }
      else
      {
        paramj = a(paramj);
        AppMethodBeat.o(57968);
        return paramj;
      }
    }
    else
    {
      if ((locali instanceof w))
      {
        paramj = this.aaUq.a((w)locali);
        if (paramj != null)
        {
          paramj = paramj.iDL();
          AppMethodBeat.o(57968);
          return paramj;
        }
        AppMethodBeat.o(57968);
        return null;
      }
      paramj = (Throwable)new IllegalStateException("Unknown classifier kind: ".concat(String.valueOf(locali)));
      AppMethodBeat.o(57968);
      throw paramj;
    }
    AppMethodBeat.o(57968);
    return parama;
  }
  
  public final ab a(kotlin.l.b.a.b.d.a.e.f paramf, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(57965);
    p.k(paramf, "arrayType");
    p.k(parama, "attr");
    Object localObject = paramf.iGZ();
    if (!(localObject instanceof kotlin.l.b.a.b.d.a.e.u)) {}
    for (paramf = null;; paramf = (kotlin.l.b.a.b.d.a.e.f)localObject)
    {
      paramf = (kotlin.l.b.a.b.d.a.e.u)paramf;
      if (paramf != null) {
        paramf = paramf.iHB();
      }
      while (paramf != null)
      {
        paramf = this.aaUh.aaUp.aaIj.iFv().b(paramf);
        p.j(paramf, "c.module.builtIns.getPri…KotlinType(primitiveType)");
        if (parama.aaVX)
        {
          paramf = (ab)paramf;
          AppMethodBeat.o(57965);
          return paramf;
          paramf = null;
        }
        else
        {
          paramf = (ab)ac.a(paramf, paramf.Jn(true));
          AppMethodBeat.o(57965);
          return paramf;
        }
      }
      localObject = a((v)localObject, d.a(kotlin.l.b.a.b.d.a.a.l.aaTp, parama.aaVX, null, 2));
      if (parama.aaVX)
      {
        if (paramBoolean) {}
        for (paramf = bh.abrr;; paramf = bh.abrp)
        {
          paramf = this.aaUh.aaUp.aaIj.iFv().a(paramf, (ab)localObject);
          p.j(paramf, "c.module.builtIns.getArr…ctionKind, componentType)");
          paramf = (ab)paramf;
          AppMethodBeat.o(57965);
          return paramf;
        }
      }
      paramf = this.aaUh.aaUp.aaIj.iFv().a(bh.abrp, (ab)localObject);
      p.j(paramf, "c.module.builtIns.getArr…INVARIANT, componentType)");
      paramf = (ab)ac.a(paramf, this.aaUh.aaUp.aaIj.iFv().a(bh.abrr, (ab)localObject).Jn(true));
      AppMethodBeat.o(57965);
      return paramf;
    }
  }
  
  public final ab a(v paramv, a parama)
  {
    AppMethodBeat.i(57964);
    p.k(parama, "attr");
    if ((paramv instanceof kotlin.l.b.a.b.d.a.e.u))
    {
      paramv = ((kotlin.l.b.a.b.d.a.e.u)paramv).iHB();
      if (paramv != null) {}
      for (paramv = this.aaUh.aaUp.aaIj.iFv().a(paramv);; paramv = this.aaUh.aaUp.aaIj.iFv().iDC())
      {
        p.j(paramv, "if (primitiveType != nul….module.builtIns.unitType");
        paramv = (ab)paramv;
        AppMethodBeat.o(57964);
        return paramv;
      }
    }
    if ((paramv instanceof kotlin.l.b.a.b.d.a.e.j))
    {
      paramv = a((kotlin.l.b.a.b.d.a.e.j)paramv, parama);
      AppMethodBeat.o(57964);
      return paramv;
    }
    if ((paramv instanceof kotlin.l.b.a.b.d.a.e.f))
    {
      paramv = a((kotlin.l.b.a.b.d.a.e.f)paramv, parama, false);
      AppMethodBeat.o(57964);
      return paramv;
    }
    if ((paramv instanceof kotlin.l.b.a.b.d.a.e.z))
    {
      paramv = ((kotlin.l.b.a.b.d.a.e.z)paramv).iHE();
      if (paramv != null)
      {
        paramv = a(paramv, parama);
        if (paramv != null) {}
      }
      else
      {
        paramv = this.aaUh.aaUp.aaIj.iFv().iDw();
        p.j(paramv, "c.module.builtIns.defaultBound");
        paramv = (ab)paramv;
        AppMethodBeat.o(57964);
        return paramv;
      }
    }
    else
    {
      if (paramv == null)
      {
        paramv = this.aaUh.aaUp.aaIj.iFv().iDw();
        p.j(paramv, "c.module.builtIns.defaultBound");
        paramv = (ab)paramv;
        AppMethodBeat.o(57964);
        return paramv;
      }
      paramv = (Throwable)new UnsupportedOperationException("Unsupported type: ".concat(String.valueOf(paramv)));
      AppMethodBeat.o(57964);
      throw paramv;
    }
    AppMethodBeat.o(57964);
    return paramv;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<v, Boolean>
  {
    public static final a aaWd;
    
    static
    {
      AppMethodBeat.i(57959);
      aaWd = new a();
      AppMethodBeat.o(57959);
    }
    
    a()
    {
      super();
    }
    
    public static boolean a(v paramv)
    {
      AppMethodBeat.i(57958);
      if (!(paramv instanceof kotlin.l.b.a.b.d.a.e.z)) {
        paramv = null;
      }
      for (;;)
      {
        paramv = (kotlin.l.b.a.b.d.a.e.z)paramv;
        if (paramv != null)
        {
          if ((paramv.iHE() != null) && (!paramv.iHF()))
          {
            AppMethodBeat.o(57958);
            return true;
          }
          AppMethodBeat.o(57958);
          return false;
        }
        AppMethodBeat.o(57958);
        return false;
      }
    }
  }
  
  static final class b
    extends q
    implements kotlin.g.a.a<ab>
  {
    b(as paramas, c paramc, a parama, at paramat, boolean paramBoolean)
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements kotlin.g.a.a<aj>
  {
    c(kotlin.l.b.a.b.d.a.e.j paramj)
    {
      super();
    }
    
    public final aj iIo()
    {
      AppMethodBeat.i(57963);
      aj localaj = kotlin.l.b.a.b.m.u.bHp("Unresolved java class " + this.aaWk.iHp());
      p.j(localaj, "ErrorUtils.createErrorTy…vaType.presentableText}\")");
      AppMethodBeat.o(57963);
      return localaj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.b.c
 * JD-Core Version:    0.7.0.1
 */