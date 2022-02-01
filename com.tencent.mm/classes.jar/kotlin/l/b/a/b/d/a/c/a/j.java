package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ab.a;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.d.a.a.k;
import kotlin.l.b.a.b.d.a.b.e;
import kotlin.l.b.a.b.d.a.e.aa;
import kotlin.l.b.a.b.d.a.e.n;
import kotlin.l.b.a.b.d.a.e.q;
import kotlin.l.b.a.b.d.a.e.y;
import kotlin.l.b.a.b.j.g.c.a;
import kotlin.l.b.a.b.j.g.i;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.ad;
import kotlin.r;
import kotlin.v;

public abstract class j
  extends i
{
  private final kotlin.l.b.a.b.l.f<kotlin.l.b.a.b.f.f, Collection<au>> aiKd;
  private final kotlin.l.b.a.b.l.f<kotlin.l.b.a.b.f.f, List<ap>> aiKe;
  private final kotlin.l.b.a.b.l.h<Collection<kotlin.l.b.a.b.b.l>> aiKf;
  final kotlin.l.b.a.b.d.a.c.h aiSh;
  final j aiTA;
  final kotlin.l.b.a.b.l.h<b> aiTB;
  private final kotlin.l.b.a.b.l.f<kotlin.l.b.a.b.f.f, Collection<au>> aiTC;
  private final kotlin.l.b.a.b.l.g<kotlin.l.b.a.b.f.f, ap> aiTD;
  private final kotlin.l.b.a.b.l.h aiTE;
  private final kotlin.l.b.a.b.l.h aiTF;
  private final kotlin.l.b.a.b.l.h aiTG;
  
  public j(kotlin.l.b.a.b.d.a.c.h paramh, j paramj)
  {
    this.aiSh = paramh;
    this.aiTA = paramj;
    this.aiKf = this.aiSh.aiSp.aiBu.a((kotlin.g.a.a)new c(this), (List)kotlin.a.ab.aivy);
    this.aiTB = this.aiSh.aiSp.aiBu.cq((kotlin.g.a.a)new g(this));
    this.aiTC = this.aiSh.aiSp.aiBu.bd((kotlin.g.a.b)new f(this));
    this.aiTD = this.aiSh.aiSp.aiBu.be((kotlin.g.a.b)new e(this));
    this.aiKd = this.aiSh.aiSp.aiBu.bd((kotlin.g.a.b)new i(this));
    this.aiTE = this.aiSh.aiSp.aiBu.cq((kotlin.g.a.a)new h(this));
    this.aiTF = this.aiSh.aiSp.aiBu.cq((kotlin.g.a.a)new k(this));
    this.aiTG = this.aiSh.aiSp.aiBu.cq((kotlin.g.a.a)new d(this));
    this.aiKe = this.aiSh.aiSp.aiBu.bd((kotlin.g.a.b)new j(this));
  }
  
  protected static b a(kotlin.l.b.a.b.d.a.c.h paramh, kotlin.l.b.a.b.b.x paramx, List<? extends aa> paramList)
  {
    s.u(paramh, "c");
    s.u(paramx, "function");
    s.u(paramList, "jValueParameters");
    boolean bool = false;
    Object localObject1 = p.s((Iterable)paramList);
    Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject1 = (kotlin.a.ae)localIterator.next();
      i = ((kotlin.a.ae)localObject1).index;
      aa localaa = (aa)((kotlin.a.ae)localObject1).value;
      kotlin.l.b.a.b.b.a.g localg = kotlin.l.b.a.b.d.a.c.f.a(paramh, (kotlin.l.b.a.b.d.a.e.d)localaa);
      localObject2 = kotlin.l.b.a.b.d.a.c.b.d.a(k.aiRp, false, null, 3);
      if (localaa.klP())
      {
        localObject1 = localaa.krd();
        if ((localObject1 instanceof kotlin.l.b.a.b.d.a.e.f)) {}
        for (localObject1 = (kotlin.l.b.a.b.d.a.e.f)localObject1; localObject1 == null; localObject1 = null) {
          throw new AssertionError(s.X("Vararg parameter should be an array: ", localaa));
        }
        localObject1 = paramh.aiSt.a((kotlin.l.b.a.b.d.a.e.f)localObject1, (kotlin.l.b.a.b.d.a.c.b.a)localObject2, true);
      }
      for (localObject1 = v.Y(localObject1, paramh.aiSp.aiEx.koV().l((ad)localObject1));; localObject1 = v.Y(paramh.aiSt.a(localaa.krd(), (kotlin.l.b.a.b.d.a.c.b.a)localObject2), null))
      {
        ad localad1 = (ad)((r)localObject1).bsC;
        ad localad2 = (ad)((r)localObject1).bsD;
        if ((!s.p(paramx.kok().PF(), "equals")) || (paramList.size() != 1) || (!s.p(paramh.aiSp.aiEx.koV().kmP(), localad1))) {
          break label386;
        }
        localObject1 = kotlin.l.b.a.b.f.f.bJe("other");
        s.s(localObject1, "if (function.name.asStri…(\"p$index\")\n            }");
        localCollection.add(new kotlin.l.b.a.b.b.c.ak((kotlin.l.b.a.b.b.a)paramx, null, i, localg, (kotlin.l.b.a.b.f.f)localObject1, localad1, false, false, false, localad2, (av)paramh.aiSp.aiRS.a((kotlin.l.b.a.b.d.a.e.l)localaa)));
        break;
      }
      label386:
      localObject2 = localaa.kok();
      if (localObject2 != null) {
        break label459;
      }
      bool = true;
    }
    label459:
    for (;;)
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = kotlin.l.b.a.b.f.f.bJe(s.X("p", Integer.valueOf(i)));
        s.s(localObject1, "identifier(\"p$index\")");
      }
      break;
      return new b(p.p((Iterable)localCollection), bool);
    }
  }
  
  protected static ad a(q paramq, kotlin.l.b.a.b.d.a.c.h paramh)
  {
    s.u(paramq, "method");
    s.u(paramh, "c");
    boolean bool = paramq.kre().kqH();
    kotlin.l.b.a.b.d.a.c.b.a locala = kotlin.l.b.a.b.d.a.c.b.d.a(k.aiRp, bool, null, 2);
    return paramh.aiSt.a(paramq.krh(), locala);
  }
  
  private static boolean a(n paramn)
  {
    return (paramn.kqN()) && (paramn.jNm());
  }
  
  public Collection<ap> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    if (!kpN().contains(paramf)) {
      return (Collection)kotlin.a.ab.aivy;
    }
    return (Collection)this.aiKe.invoke(paramf);
  }
  
  public Collection<kotlin.l.b.a.b.b.l> a(kotlin.l.b.a.b.j.g.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    s.u(paramd, "kindFilter");
    s.u(paramb, "nameFilter");
    return (Collection)this.aiKf.invoke();
  }
  
  protected abstract Set<kotlin.l.b.a.b.f.f> a(kotlin.l.b.a.b.j.g.d paramd);
  
  protected final e a(q paramq)
  {
    s.u(paramq, "method");
    Object localObject1 = kotlin.l.b.a.b.d.a.c.f.a(this.aiSh, (kotlin.l.b.a.b.d.a.e.d)paramq);
    Object localObject2 = kss();
    Object localObject3 = paramq.kok();
    Object localObject4 = (av)this.aiSh.aiSp.aiRS.a((kotlin.l.b.a.b.d.a.e.l)paramq);
    if ((((b)this.aiTB.invoke()).l(paramq.kok()) != null) && (paramq.kod().isEmpty())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = e.a((kotlin.l.b.a.b.b.l)localObject2, (kotlin.l.b.a.b.b.a.g)localObject1, (kotlin.l.b.a.b.f.f)localObject3, (av)localObject4, bool1);
      s.s(localObject2, "createJavaMethod(\n      …eters.isEmpty()\n        )");
      localObject3 = kotlin.l.b.a.b.d.a.c.a.a(this.aiSh, (kotlin.l.b.a.b.b.l)localObject2, (y)paramq, 0);
      localObject4 = (Iterable)paramq.koa();
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (kotlin.l.b.a.b.d.a.e.x)((Iterator)localObject4).next();
        localObject5 = ((kotlin.l.b.a.b.d.a.c.h)localObject3).aiSq.a((kotlin.l.b.a.b.d.a.e.x)localObject5);
        s.checkNotNull(localObject5);
        ((Collection)localObject1).add(localObject5);
      }
    }
    localObject1 = (List)localObject1;
    localObject4 = a((kotlin.l.b.a.b.d.a.c.h)localObject3, (kotlin.l.b.a.b.b.x)localObject2, paramq.kod());
    Object localObject5 = a(paramq, (List)localObject1, a(paramq, (kotlin.l.b.a.b.d.a.c.h)localObject3), ((b)localObject4).aiTI);
    localObject1 = ((a)localObject5).aiRl;
    Object localObject6;
    Object localObject7;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject6 = knZ();
      localObject7 = ((a)localObject5).aiKl;
      List localList = ((a)localObject5).aiRm;
      ad localad = ((a)localObject5).aiLR;
      Object localObject8 = kotlin.l.b.a.b.b.ab.aiGX;
      boolean bool2 = paramq.kqM();
      if (paramq.kqN()) {
        break label506;
      }
      bool1 = true;
      label350:
      localObject8 = ab.a.bY(bool2, bool1);
      t localt = kotlin.l.b.a.b.d.a.ae.a(paramq.kqO());
      if (((a)localObject5).aiRl == null) {
        break label511;
      }
      paramq = kotlin.a.ak.l(v.Y(e.aiRt, p.oK(((b)localObject4).aiTI)));
      label395:
      ((e)localObject2).a((as)localObject1, (as)localObject6, (List)localObject7, localList, localad, (kotlin.l.b.a.b.b.ab)localObject8, localt, paramq);
      ((e)localObject2).bZ(((a)localObject5).aiKA, ((b)localObject4).aiTJ);
      if (((Collection)((a)localObject5).aiTH).isEmpty()) {
        break label518;
      }
    }
    label518:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((kotlin.l.b.a.b.d.a.c.h)localObject3).aiSp.aiRN.a((kotlin.l.b.a.b.b.b)localObject2, ((a)localObject5).aiTH);
      }
      return localObject2;
      localObject6 = (kotlin.l.b.a.b.b.a)localObject2;
      localObject7 = kotlin.l.b.a.b.b.a.g.aiIh;
      localObject1 = kotlin.l.b.a.b.j.c.a((kotlin.l.b.a.b.b.a)localObject6, (ad)localObject1, g.a.kpB());
      break;
      label506:
      bool1 = false;
      break label350;
      label511:
      paramq = kotlin.a.ak.kkZ();
      break label395;
    }
  }
  
  protected abstract a a(q paramq, List<? extends ba> paramList, ad paramad, List<? extends bd> paramList1);
  
  protected abstract void a(Collection<au> paramCollection, kotlin.l.b.a.b.f.f paramf);
  
  protected boolean a(e parame)
  {
    s.u(parame, "<this>");
    return true;
  }
  
  public Collection<au> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    if (!kpL().contains(paramf)) {
      return (Collection)kotlin.a.ab.aivy;
    }
    return (Collection)this.aiKd.invoke(paramf);
  }
  
  protected abstract Set<kotlin.l.b.a.b.f.f> b(kotlin.l.b.a.b.j.g.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb);
  
  protected void b(Collection<au> paramCollection, kotlin.l.b.a.b.f.f paramf)
  {
    s.u(paramCollection, "result");
    s.u(paramf, "name");
  }
  
  protected abstract void b(kotlin.l.b.a.b.f.f paramf, Collection<ap> paramCollection);
  
  protected abstract Set<kotlin.l.b.a.b.f.f> c(kotlin.l.b.a.b.j.g.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb);
  
  protected final List<kotlin.l.b.a.b.b.l> d(kotlin.l.b.a.b.j.g.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    s.u(paramd, "kindFilter");
    s.u(paramb, "nameFilter");
    kotlin.l.b.a.b.c.a.d locald = kotlin.l.b.a.b.c.a.d.aiNH;
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject = kotlin.l.b.a.b.j.g.d.ajkC;
    kotlin.l.b.a.b.f.f localf;
    if (paramd.aMn(kotlin.l.b.a.b.j.g.d.kzH()))
    {
      localObject = b(paramd, paramb).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localf = (kotlin.l.b.a.b.f.f)((Iterator)localObject).next();
        if (((Boolean)paramb.invoke(localf)).booleanValue()) {
          kotlin.l.b.a.b.o.a.c((Collection)localLinkedHashSet, c(localf, (kotlin.l.b.a.b.c.a.b)locald));
        }
      }
    }
    localObject = kotlin.l.b.a.b.j.g.d.ajkC;
    if ((paramd.aMn(kotlin.l.b.a.b.j.g.d.kzE())) && (!paramd.ajkD.contains(c.a.ajkz)))
    {
      localObject = c(paramd, paramb).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localf = (kotlin.l.b.a.b.f.f)((Iterator)localObject).next();
        if (((Boolean)paramb.invoke(localf)).booleanValue()) {
          localLinkedHashSet.addAll(b(localf, (kotlin.l.b.a.b.c.a.b)locald));
        }
      }
    }
    localObject = kotlin.l.b.a.b.j.g.d.ajkC;
    if ((paramd.aMn(kotlin.l.b.a.b.j.g.d.kzF())) && (!paramd.ajkD.contains(c.a.ajkz)))
    {
      paramd = a(paramd).iterator();
      while (paramd.hasNext())
      {
        localObject = (kotlin.l.b.a.b.f.f)paramd.next();
        if (((Boolean)paramb.invoke(localObject)).booleanValue()) {
          localLinkedHashSet.addAll(a((kotlin.l.b.a.b.f.f)localObject, (kotlin.l.b.a.b.c.a.b)locald));
        }
      }
    }
    return p.p((Iterable)localLinkedHashSet);
  }
  
  protected abstract as knZ();
  
  public final Set<kotlin.l.b.a.b.f.f> kpL()
  {
    return (Set)kotlin.l.b.a.b.l.l.a(this.aiTE, aYe[0]);
  }
  
  public final Set<kotlin.l.b.a.b.f.f> kpM()
  {
    return (Set)kotlin.l.b.a.b.l.l.a(this.aiTG, aYe[2]);
  }
  
  public final Set<kotlin.l.b.a.b.f.f> kpN()
  {
    return (Set)kotlin.l.b.a.b.l.l.a(this.aiTF, aYe[1]);
  }
  
  protected abstract kotlin.l.b.a.b.b.l kss();
  
  protected abstract b kst();
  
  protected final kotlin.l.b.a.b.l.h<Collection<kotlin.l.b.a.b.b.l>> ksv()
  {
    return this.aiKf;
  }
  
  public String toString()
  {
    return s.X("Lazy scope for ", kss());
  }
  
  protected static final class a
  {
    final boolean aiKA;
    final List<ba> aiKl;
    final ad aiLR;
    final ad aiRl;
    final List<bd> aiRm;
    final List<String> aiTH;
    
    public a(ad paramad1, ad paramad2, List<? extends bd> paramList, List<? extends ba> paramList1, boolean paramBoolean, List<String> paramList2)
    {
      AppMethodBeat.i(57910);
      this.aiLR = paramad1;
      this.aiRl = paramad2;
      this.aiRm = paramList;
      this.aiKl = paramList1;
      this.aiKA = paramBoolean;
      this.aiTH = paramList2;
      AppMethodBeat.o(57910);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(57913);
      if (this == paramObject)
      {
        AppMethodBeat.o(57913);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(57913);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.aiLR, paramObject.aiLR))
      {
        AppMethodBeat.o(57913);
        return false;
      }
      if (!s.p(this.aiRl, paramObject.aiRl))
      {
        AppMethodBeat.o(57913);
        return false;
      }
      if (!s.p(this.aiRm, paramObject.aiRm))
      {
        AppMethodBeat.o(57913);
        return false;
      }
      if (!s.p(this.aiKl, paramObject.aiKl))
      {
        AppMethodBeat.o(57913);
        return false;
      }
      if (this.aiKA != paramObject.aiKA)
      {
        AppMethodBeat.o(57913);
        return false;
      }
      if (!s.p(this.aiTH, paramObject.aiTH))
      {
        AppMethodBeat.o(57913);
        return false;
      }
      AppMethodBeat.o(57913);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57911);
      String str = "MethodSignatureData(returnType=" + this.aiLR + ", receiverType=" + this.aiRl + ", valueParameters=" + this.aiRm + ", typeParameters=" + this.aiKl + ", hasStableParameterNames=" + this.aiKA + ", errors=" + this.aiTH + ')';
      AppMethodBeat.o(57911);
      return str;
    }
  }
  
  protected static final class b
  {
    final List<bd> aiTI;
    final boolean aiTJ;
    
    public b(List<? extends bd> paramList, boolean paramBoolean)
    {
      AppMethodBeat.i(57914);
      this.aiTI = paramList;
      this.aiTJ = paramBoolean;
      AppMethodBeat.o(57914);
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.a<Collection<? extends kotlin.l.b.a.b.b.l>>
  {
    c(j paramj)
    {
      super();
    }
  }
  
  static final class d
    extends u
    implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
  {
    d(j paramj)
    {
      super();
    }
  }
  
  static final class e
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, ap>
  {
    e(j paramj)
    {
      super();
    }
  }
  
  static final class f
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends au>>
  {
    f(j paramj)
    {
      super();
    }
  }
  
  static final class g
    extends u
    implements kotlin.g.a.a<b>
  {
    g(j paramj)
    {
      super();
    }
  }
  
  static final class h
    extends u
    implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
  {
    h(j paramj)
    {
      super();
    }
  }
  
  static final class i
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends au>>
  {
    i(j paramj)
    {
      super();
    }
  }
  
  static final class j
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, List<? extends ap>>
  {
    j(j paramj)
    {
      super();
    }
  }
  
  static final class k
    extends u
    implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
  {
    k(j paramj)
    {
      super();
    }
  }
  
  static final class l
    extends u
    implements kotlin.g.a.a<kotlin.l.b.a.b.j.b.g<?>>
  {
    l(j paramj, n paramn, kotlin.l.b.a.b.b.c.ab paramab)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.j
 * JD-Core Version:    0.7.0.1
 */