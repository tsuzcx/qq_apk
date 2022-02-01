package d.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.aa;
import d.l.b.a.b.b.as;
import d.l.b.a.b.d.a.c.h;
import d.l.b.a.b.d.a.c.m;
import d.l.b.a.b.d.a.e.v;
import d.l.b.a.b.d.a.e.w;
import d.l.b.a.b.d.a.e.z;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ae;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.ax;
import d.l.b.a.b.m.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private final h NBF;
  private final m NBO;
  
  public c(h paramh, m paramm)
  {
    AppMethodBeat.i(57975);
    this.NBF = paramh;
    this.NBO = paramm;
    AppMethodBeat.o(57975);
  }
  
  private final d.l.b.a.b.b.e a(d.l.b.a.b.d.a.e.j paramj, a parama, d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57970);
    if ((parama.NDw) && (p.i(paramb, d.gqt())))
    {
      paramj = this.NBF.NBN.NBu.glS();
      AppMethodBeat.o(57970);
      return paramj;
    }
    d.l.b.a.b.a.b.c localc = d.l.b.a.b.a.b.c.Nqr;
    paramb = d.l.b.a.b.a.b.c.a(paramb, this.NBF.NBN.NpH.gnF());
    if (paramb == null)
    {
      AppMethodBeat.o(57970);
      return null;
    }
    if ((d.l.b.a.b.a.b.c.i(paramb)) && ((parama.NDv == b.NDA) || (parama.NDu == d.l.b.a.b.d.a.a.l.NAM) || (a(paramj, paramb))))
    {
      paramj = d.l.b.a.b.a.b.c.k(paramb);
      AppMethodBeat.o(57970);
      return paramj;
    }
    AppMethodBeat.o(57970);
    return paramb;
  }
  
  private final ab a(d.l.b.a.b.d.a.e.j paramj, a parama)
  {
    AppMethodBeat.i(57966);
    c localc = new c(paramj);
    if ((!parama.NDw) && (parama.NDu != d.l.b.a.b.d.a.a.l.NAM)) {}
    boolean bool;
    for (int i = 1;; i = 0)
    {
      bool = paramj.gpu();
      if ((bool) || (i != 0)) {
        break label96;
      }
      paramj = a(paramj, parama, null);
      if (paramj == null) {
        break;
      }
      paramj = (ab)paramj;
      AppMethodBeat.o(57966);
      return paramj;
    }
    paramj = (ab)localc.gqs();
    AppMethodBeat.o(57966);
    return paramj;
    label96:
    aj localaj = a(paramj, parama.a(b.NDA), null);
    if (localaj == null)
    {
      paramj = (ab)localc.gqs();
      AppMethodBeat.o(57966);
      return paramj;
    }
    paramj = a(paramj, parama.a(b.NDz), localaj);
    if (paramj == null)
    {
      paramj = (ab)localc.gqs();
      AppMethodBeat.o(57966);
      return paramj;
    }
    if (bool)
    {
      paramj = (ab)new g(localaj, paramj);
      AppMethodBeat.o(57966);
      return paramj;
    }
    paramj = (ab)d.l.b.a.b.m.ac.a(localaj, paramj);
    AppMethodBeat.o(57966);
    return paramj;
  }
  
  private final aj a(d.l.b.a.b.d.a.e.j paramj, a parama, aj paramaj)
  {
    AppMethodBeat.i(57967);
    Object localObject1;
    if (paramaj != null)
    {
      localObject2 = paramaj.gmj();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = (d.l.b.a.b.b.a.g)new d.l.b.a.b.d.a.c.e(this.NBF, (d.l.b.a.b.d.a.e.d)paramj);
    }
    at localat = b(paramj, parama);
    if (localat == null)
    {
      AppMethodBeat.o(57967);
      return null;
    }
    boolean bool = a(parama);
    if (paramaj != null) {}
    for (Object localObject2 = paramaj.gxB(); (p.i(localObject2, localat)) && (!paramj.gpu()) && (bool); localObject2 = null)
    {
      paramj = paramaj.Ap(true);
      AppMethodBeat.o(57967);
      return paramj;
    }
    paramj = d.l.b.a.b.m.ac.c((d.l.b.a.b.b.a.g)localObject1, localat, a(paramj, parama, localat), bool);
    AppMethodBeat.o(57967);
    return paramj;
  }
  
  private final at a(d.l.b.a.b.d.a.e.j paramj)
  {
    AppMethodBeat.i(57969);
    paramj = d.l.b.a.b.f.a.p(new d.l.b.a.b.f.b(paramj.gps()));
    p.g(paramj, "ClassId.topLevel(FqName(…classifierQualifiedName))");
    paramj = this.NBF.NBN.NBk.gqF().Npj.a(paramj, d.a.j.listOf(Integer.valueOf(0))).glW();
    p.g(paramj, "c.components.deserialize…istOf(0)).typeConstructor");
    AppMethodBeat.o(57969);
    return paramj;
  }
  
  private final av a(v paramv, a parama, as paramas)
  {
    AppMethodBeat.i(57973);
    if ((paramv instanceof z))
    {
      v localv = ((z)paramv).gpI();
      if (((z)paramv).gpJ()) {}
      for (paramv = bh.NZY; (localv == null) || (a(paramv, paramas)); paramv = bh.NZX)
      {
        paramv = d.a(paramas, parama);
        AppMethodBeat.o(57973);
        return paramv;
      }
      paramv = d.l.b.a.b.m.d.a.a(a(localv, d.a(d.l.b.a.b.d.a.a.l.NAN, false, null, 3)), paramv, paramas);
      AppMethodBeat.o(57973);
      return paramv;
    }
    paramv = (av)new ax(bh.NZW, a(paramv, parama));
    AppMethodBeat.o(57973);
    return paramv;
  }
  
  private final List<av> a(d.l.b.a.b.d.a.e.j paramj, final a parama, final at paramat)
  {
    AppMethodBeat.i(57972);
    final boolean bool = paramj.gpu();
    Object localObject1;
    int i;
    label73:
    Object localObject2;
    label126:
    Object localObject3;
    ae localae;
    if (!bool)
    {
      if (!paramj.gpv().isEmpty()) {
        break label231;
      }
      localObject1 = paramat.getParameters();
      p.g(localObject1, "constructor.parameters");
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label231;
        }
      }
    }
    else
    {
      i = 1;
      localObject1 = paramat.getParameters();
      p.g(localObject1, "constructor.parameters");
      if (i == 0) {
        break label268;
      }
      paramj = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(d.a.j.a(paramj, 10));
      localObject2 = paramj.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label248;
      }
      localObject3 = (as)((Iterator)localObject2).next();
      localae = new ae(this.NBF.NBN.Nnf, (d.g.a.a)new b((as)localObject3, this, parama, paramat, bool));
      paramj = e.NDO;
      p.g(localObject3, "parameter");
      if (!bool) {
        break label237;
      }
    }
    label231:
    label237:
    for (paramj = parama;; paramj = parama.a(b.NDy))
    {
      ((Collection)localObject1).add(e.a((as)localObject3, paramj, (ab)localae));
      break label126;
      i = 0;
      break;
      i = 0;
      break label73;
    }
    label248:
    paramj = d.a.j.l((Iterable)localObject1);
    AppMethodBeat.o(57972);
    return paramj;
    label268:
    if (((List)localObject1).size() != paramj.gpv().size())
    {
      parama = (Iterable)localObject1;
      paramj = (Collection)new ArrayList(d.a.j.a(parama, 10));
      parama = parama.iterator();
      while (parama.hasNext())
      {
        paramat = (as)parama.next();
        p.g(paramat, "p");
        paramj.add(new ax((ab)d.l.b.a.b.m.u.bey(paramat.gnf().sD())));
      }
      paramj = d.a.j.l((Iterable)paramj);
      AppMethodBeat.o(57972);
      return paramj;
    }
    parama = d.a.j.o((Iterable)paramj.gpv());
    paramj = (Collection)new ArrayList(d.a.j.a(parama, 10));
    parama = parama.iterator();
    while (parama.hasNext())
    {
      paramat = (d.a.y)parama.next();
      int j = paramat.index;
      paramat = (v)paramat.value;
      if (j < ((List)localObject1).size()) {}
      for (i = 1; (d.ac.Nhs) && (i == 0); i = 0)
      {
        paramj = (Throwable)new AssertionError("Argument index should be less then type parameters count, but " + j + " > " + ((List)localObject1).size());
        AppMethodBeat.o(57972);
        throw paramj;
      }
      localObject2 = (as)((List)localObject1).get(j);
      localObject3 = d.a(d.l.b.a.b.d.a.a.l.NAN, false, null, 3);
      p.g(localObject2, "parameter");
      paramj.add(a(paramat, (a)localObject3, (as)localObject2));
    }
    paramj = d.a.j.l((Iterable)paramj);
    AppMethodBeat.o(57972);
    return paramj;
  }
  
  private static boolean a(a parama)
  {
    if (parama.NDv == b.NDA) {}
    while ((parama.NDw) || (parama.NDu == d.l.b.a.b.d.a.a.l.NAM)) {
      return false;
    }
    return true;
  }
  
  private static boolean a(d.l.b.a.b.d.a.e.j paramj, d.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(57971);
    a locala = a.NDC;
    if (!a.a((v)d.a.j.jo(paramj.gpv())))
    {
      AppMethodBeat.o(57971);
      return false;
    }
    paramj = d.l.b.a.b.a.b.c.Nqr;
    paramj = d.l.b.a.b.a.b.c.k(parame).glW();
    p.g(paramj, "JavaToKotlinClassMap.con…         .typeConstructor");
    paramj = paramj.getParameters();
    p.g(paramj, "JavaToKotlinClassMap.con…ypeConstructor.parameters");
    paramj = (as)d.a.j.jo(paramj);
    if (paramj != null)
    {
      paramj = paramj.gnh();
      if (paramj != null) {}
    }
    else
    {
      AppMethodBeat.o(57971);
      return false;
    }
    p.g(paramj, "JavaToKotlinClassMap.con….variance ?: return false");
    if (paramj != bh.NZY)
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
    if (paramas.gnh() == bh.NZW)
    {
      AppMethodBeat.o(57974);
      return false;
    }
    if (parambh != paramas.gnh())
    {
      AppMethodBeat.o(57974);
      return true;
    }
    AppMethodBeat.o(57974);
    return false;
  }
  
  private final at b(d.l.b.a.b.d.a.e.j paramj, a parama)
  {
    AppMethodBeat.i(57968);
    d.l.b.a.b.d.a.e.i locali = paramj.gpr();
    if (locali == null)
    {
      paramj = a(paramj);
      AppMethodBeat.o(57968);
      return paramj;
    }
    if ((locali instanceof d.l.b.a.b.d.a.e.g))
    {
      Object localObject = ((d.l.b.a.b.d.a.e.g)locali).gnI();
      if (localObject == null)
      {
        paramj = (Throwable)new AssertionError("Class type should have a FQ name: ".concat(String.valueOf(locali)));
        AppMethodBeat.o(57968);
        throw paramj;
      }
      localObject = a(paramj, parama, (d.l.b.a.b.f.b)localObject);
      parama = (a)localObject;
      if (localObject == null) {
        parama = this.NBF.NBN.NBr.c((d.l.b.a.b.d.a.e.g)locali);
      }
      if (parama != null)
      {
        parama = parama.glW();
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
        paramj = this.NBO.a((w)locali);
        if (paramj != null)
        {
          paramj = paramj.glW();
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
  
  public final ab a(d.l.b.a.b.d.a.e.f paramf, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(57965);
    p.h(paramf, "arrayType");
    p.h(parama, "attr");
    Object localObject = paramf.gpg();
    if (!(localObject instanceof d.l.b.a.b.d.a.e.u)) {}
    for (paramf = null;; paramf = (d.l.b.a.b.d.a.e.f)localObject)
    {
      paramf = (d.l.b.a.b.d.a.e.u)paramf;
      if (paramf != null) {
        paramf = paramf.gpF();
      }
      while (paramf != null)
      {
        paramf = this.NBF.NBN.NpH.gnF().b(paramf);
        p.g(paramf, "c.module.builtIns.getPri…KotlinType(primitiveType)");
        if (parama.NDw)
        {
          paramf = (ab)paramf;
          AppMethodBeat.o(57965);
          return paramf;
          paramf = null;
        }
        else
        {
          paramf = (ab)d.l.b.a.b.m.ac.a(paramf, paramf.Ap(true));
          AppMethodBeat.o(57965);
          return paramf;
        }
      }
      localObject = a((v)localObject, d.a(d.l.b.a.b.d.a.a.l.NAN, parama.NDw, null, 2));
      if (parama.NDw)
      {
        if (paramBoolean) {}
        for (paramf = bh.NZY;; paramf = bh.NZW)
        {
          paramf = this.NBF.NBN.NpH.gnF().a(paramf, (ab)localObject);
          p.g(paramf, "c.module.builtIns.getArr…ctionKind, componentType)");
          paramf = (ab)paramf;
          AppMethodBeat.o(57965);
          return paramf;
        }
      }
      paramf = this.NBF.NBN.NpH.gnF().a(bh.NZW, (ab)localObject);
      p.g(paramf, "c.module.builtIns.getArr…INVARIANT, componentType)");
      paramf = (ab)d.l.b.a.b.m.ac.a(paramf, this.NBF.NBN.NpH.gnF().a(bh.NZY, (ab)localObject).Ap(true));
      AppMethodBeat.o(57965);
      return paramf;
    }
  }
  
  public final ab a(v paramv, a parama)
  {
    AppMethodBeat.i(57964);
    p.h(parama, "attr");
    if ((paramv instanceof d.l.b.a.b.d.a.e.u))
    {
      paramv = ((d.l.b.a.b.d.a.e.u)paramv).gpF();
      if (paramv != null) {}
      for (paramv = this.NBF.NBN.NpH.gnF().a(paramv);; paramv = this.NBF.NBN.NpH.gnF().glN())
      {
        p.g(paramv, "if (primitiveType != nul….module.builtIns.unitType");
        paramv = (ab)paramv;
        AppMethodBeat.o(57964);
        return paramv;
      }
    }
    if ((paramv instanceof d.l.b.a.b.d.a.e.j))
    {
      paramv = a((d.l.b.a.b.d.a.e.j)paramv, parama);
      AppMethodBeat.o(57964);
      return paramv;
    }
    if ((paramv instanceof d.l.b.a.b.d.a.e.f))
    {
      paramv = a((d.l.b.a.b.d.a.e.f)paramv, parama, false);
      AppMethodBeat.o(57964);
      return paramv;
    }
    if ((paramv instanceof z))
    {
      paramv = ((z)paramv).gpI();
      if (paramv != null)
      {
        paramv = a(paramv, parama);
        if (paramv != null) {}
      }
      else
      {
        paramv = this.NBF.NBN.NpH.gnF().glH();
        p.g(paramv, "c.module.builtIns.defaultBound");
        paramv = (ab)paramv;
        AppMethodBeat.o(57964);
        return paramv;
      }
    }
    else
    {
      if (paramv == null)
      {
        paramv = this.NBF.NBN.NpH.gnF().glH();
        p.g(paramv, "c.module.builtIns.defaultBound");
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
    implements d.g.a.b<v, Boolean>
  {
    public static final a NDC;
    
    static
    {
      AppMethodBeat.i(57959);
      NDC = new a();
      AppMethodBeat.o(57959);
    }
    
    a()
    {
      super();
    }
    
    public static boolean a(v paramv)
    {
      AppMethodBeat.i(57958);
      if (!(paramv instanceof z)) {
        paramv = null;
      }
      for (;;)
      {
        paramv = (z)paramv;
        if (paramv != null)
        {
          if ((paramv.gpI() != null) && (!paramv.gpJ()))
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
    implements d.g.a.a<ab>
  {
    b(as paramas, c paramc, a parama, at paramat, boolean paramBoolean)
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements d.g.a.a<aj>
  {
    c(d.l.b.a.b.d.a.e.j paramj)
    {
      super();
    }
    
    public final aj gqs()
    {
      AppMethodBeat.i(57963);
      aj localaj = d.l.b.a.b.m.u.bey("Unresolved java class " + this.NDJ.gpt());
      p.g(localaj, "ErrorUtils.createErrorTy…vaType.presentableText}\")");
      AppMethodBeat.o(57963);
      return localaj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.b.c
 * JD-Core Version:    0.7.0.1
 */