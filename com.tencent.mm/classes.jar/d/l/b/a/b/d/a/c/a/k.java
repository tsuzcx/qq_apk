package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.c.aa;
import d.l.b.a.b.b.c.aj;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.w.a;
import d.l.b.a.b.d.a.c.h;
import d.l.b.a.b.d.a.c.m;
import d.l.b.a.b.d.a.e.n;
import d.l.b.a.b.d.a.e.x;
import d.l.b.a.b.j.f.c.a;
import d.l.b.a.b.m.ab;
import d.o;
import d.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class k
  extends d.l.b.a.b.j.f.i
{
  private final d.l.b.a.b.l.c<d.l.b.a.b.f.f, Collection<am>> MXL;
  private final d.l.b.a.b.l.c<d.l.b.a.b.f.f, List<ah>> MXM;
  final d.l.b.a.b.l.f<Collection<d.l.b.a.b.b.l>> MXN;
  final h NeA;
  final d.l.b.a.b.l.f<b> NfS;
  private final d.l.b.a.b.l.c<d.l.b.a.b.f.f, Collection<am>> NfT;
  private final d.l.b.a.b.l.d<d.l.b.a.b.f.f, ah> NfU;
  private final d.l.b.a.b.l.f NfV;
  private final d.l.b.a.b.l.f NfW;
  private final d.l.b.a.b.l.f NfX;
  final k NfY;
  
  public k(h paramh, k paramk)
  {
    this.NeA = paramh;
    this.NfY = paramk;
    this.MXN = this.NeA.NeI.MQa.a((d.g.a.a)new c(this), (List)d.a.v.MKE);
    this.NfS = this.NeA.NeI.MQa.S((d.g.a.a)new g(this));
    this.NfT = this.NeA.NeI.MQa.I((d.g.a.b)new f(this));
    this.NfU = this.NeA.NeI.MQa.J((d.g.a.b)new e(this));
    this.MXL = this.NeA.NeI.MQa.I((d.g.a.b)new i(this));
    this.NfV = this.NeA.NeI.MQa.S((d.g.a.a)new h(this));
    this.NfW = this.NeA.NeI.MQa.S((d.g.a.a)new k(this));
    this.NfX = this.NeA.NeI.MQa.S((d.g.a.a)new d(this));
    this.MXM = this.NeA.NeI.MQa.I((d.g.a.b)new j(this));
  }
  
  protected static b a(h paramh, t paramt, List<? extends d.l.b.a.b.d.a.e.y> paramList)
  {
    d.g.b.p.h(paramh, "c");
    d.g.b.p.h(paramt, "function");
    d.g.b.p.h(paramList, "jValueParameters");
    Set localSet = (Set)new LinkedHashSet();
    Object localObject1 = d.a.j.o((Iterable)paramList);
    Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    boolean bool = false;
    int j;
    d.l.b.a.b.d.a.e.y localy;
    d.l.b.a.b.b.a.g localg;
    d.l.b.a.b.d.a.c.b.a locala;
    Object localObject2;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject1 = (d.a.y)localIterator.next();
      j = ((d.a.y)localObject1).index;
      localy = (d.l.b.a.b.d.a.e.y)((d.a.y)localObject1).value;
      localg = d.l.b.a.b.d.a.c.f.a(paramh, (d.l.b.a.b.d.a.e.d)localy);
      locala = d.l.b.a.b.d.a.c.b.d.a(d.l.b.a.b.d.a.a.l.NdI, false, null, 3);
      localObject1 = d.l.b.a.b.d.a.p.NcI;
      d.g.b.p.g(localObject1, "JvmAnnotationNames.PARAMETER_NAME_FQ_NAME");
      localObject1 = localg.g((d.l.b.a.b.f.b)localObject1);
      if (localObject1 != null)
      {
        localObject2 = d.l.b.a.b.j.d.a.m((d.l.b.a.b.b.a.c)localObject1);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!(localObject2 instanceof d.l.b.a.b.j.b.v)) {
            localObject1 = null;
          }
          localObject1 = (d.l.b.a.b.j.b.v)localObject1;
          if (localObject1 != null) {
            localObject1 = (String)((d.l.b.a.b.j.b.v)localObject1).getValue();
          }
        }
      }
      while (localy.glf())
      {
        localObject3 = localy.gkX();
        localObject2 = localObject3;
        if (!(localObject3 instanceof d.l.b.a.b.d.a.e.f)) {
          localObject2 = null;
        }
        localObject2 = (d.l.b.a.b.d.a.e.f)localObject2;
        if (localObject2 == null)
        {
          throw ((Throwable)new AssertionError("Vararg parameter should be an array: ".concat(String.valueOf(localy))));
          localObject1 = null;
        }
        else
        {
          localObject2 = paramh.NeH.a((d.l.b.a.b.d.a.e.f)localObject2, locala, true);
          localObject2 = u.S(localObject2, paramh.NeI.MSC.gjd().l((ab)localObject2));
          label323:
          localObject3 = (ab)((o)localObject2).first;
          localObject2 = (ab)((o)localObject2).second;
          if ((!d.g.b.p.i(paramt.giD().sD(), "equals")) || (paramList.size() != 1) || (!d.g.b.p.i(paramh.NeI.MSC.gjd().ghe(), localObject3))) {
            break label491;
          }
          localObject1 = d.l.b.a.b.f.f.bcE("other");
        }
      }
    }
    for (;;)
    {
      d.g.b.p.g(localObject1, "if (function.name.asStri…(\"p$index\")\n            }");
      localCollection.add(new aj((d.l.b.a.b.b.a)paramt, null, j, localg, (d.l.b.a.b.f.f)localObject1, (ab)localObject3, false, false, false, (ab)localObject2, (an)paramh.NeI.Nel.a((d.l.b.a.b.d.a.e.l)localy)));
      break;
      localObject2 = u.S(paramh.NeH.a(localy.gkX(), locala), null);
      break label323;
      label491:
      if (localObject1 != null)
      {
        if (((CharSequence)localObject1).length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (!localSet.add(localObject1))) {
            break label542;
          }
          localObject1 = d.l.b.a.b.f.f.bcE((String)localObject1);
          break;
        }
      }
      label542:
      localObject1 = localy.giD();
      if (localObject1 == null) {
        bool = true;
      }
      if (localObject1 == null)
      {
        localObject1 = d.l.b.a.b.f.f.bcE("p".concat(String.valueOf(j)));
        continue;
        return new b(d.a.j.l((Iterable)localCollection), bool);
      }
    }
  }
  
  protected static ab a(d.l.b.a.b.d.a.e.q paramq, h paramh)
  {
    d.g.b.p.h(paramq, "method");
    d.g.b.p.h(paramh, "c");
    boolean bool = paramq.gkY().gkK();
    d.l.b.a.b.d.a.c.b.a locala = d.l.b.a.b.d.a.c.b.d.a(d.l.b.a.b.d.a.a.l.NdI, bool, null, 2);
    return paramh.NeH.a(paramq.gkZ(), locala);
  }
  
  private static boolean a(n paramn)
  {
    return (paramn.gkN()) && (paramn.fQB());
  }
  
  protected final d.l.b.a.b.d.a.b.f a(d.l.b.a.b.d.a.e.q paramq)
  {
    d.g.b.p.h(paramq, "method");
    Object localObject1 = d.l.b.a.b.d.a.c.f.a(this.NeA, (d.l.b.a.b.d.a.e.d)paramq);
    d.l.b.a.b.d.a.b.f localf = d.l.b.a.b.d.a.b.f.a(glO(), (d.l.b.a.b.b.a.g)localObject1, paramq.giD(), (an)this.NeA.NeI.Nel.a((d.l.b.a.b.d.a.e.l)paramq));
    d.g.b.p.g(localf, "JavaMethodDescriptor.cre….source(method)\n        )");
    h localh = d.l.b.a.b.d.a.c.a.a(this.NeA, (d.l.b.a.b.b.l)localf, (x)paramq, 0);
    Object localObject2 = (Iterable)paramq.gip();
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d.l.b.a.b.d.a.e.w)((Iterator)localObject2).next();
      localObject3 = localh.NeJ.a((d.l.b.a.b.d.a.e.w)localObject3);
      if (localObject3 == null) {
        d.g.b.p.gfZ();
      }
      ((Collection)localObject1).add(localObject3);
    }
    localObject1 = (List)localObject1;
    localObject2 = a(localh, (t)localf, paramq.gis());
    Object localObject3 = a(paramq, (List)localObject1, a(paramq, localh), ((b)localObject2).Nga);
    localObject1 = ((a)localObject3).NdE;
    boolean bool1;
    if (localObject1 != null)
    {
      Object localObject4 = (d.l.b.a.b.b.a)localf;
      Object localObject5 = d.l.b.a.b.b.a.g.MVP;
      localObject1 = d.l.b.a.b.j.b.a((d.l.b.a.b.b.a)localObject4, (ab)localObject1, g.a.gjL());
      localObject4 = gio();
      localObject5 = ((a)localObject3).MUK;
      List localList = ((a)localObject3).NdF;
      ab localab = ((a)localObject3).MZs;
      Object localObject6 = d.l.b.a.b.b.w.MUG;
      boolean bool2 = paramq.gkM();
      if (paramq.gkN()) {
        break label446;
      }
      bool1 = true;
      label314:
      localObject6 = w.a.be(bool2, bool1);
      ba localba = paramq.ghz();
      if (((a)localObject3).NdE == null) {
        break label451;
      }
      paramq = ae.c(u.S(d.l.b.a.b.d.a.b.f.NdM, d.a.j.jc(((b)localObject2).Nga)));
      label356:
      localf.a((ak)localObject1, (ak)localObject4, (List)localObject5, localList, localab, (d.l.b.a.b.b.w)localObject6, localba, paramq);
      localf.bf(((a)localObject3).MYh, ((b)localObject2).Ngb);
      if (((Collection)((a)localObject3).NfZ).isEmpty()) {
        break label458;
      }
    }
    label446:
    label451:
    label458:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localh.NeI.Neg.a((d.l.b.a.b.b.b)localf, ((a)localObject3).NfZ);
      }
      return localf;
      localObject1 = null;
      break;
      bool1 = false;
      break label314;
      paramq = ae.emptyMap();
      break label356;
    }
  }
  
  protected abstract a a(d.l.b.a.b.d.a.e.q paramq, List<? extends as> paramList, ab paramab, List<? extends av> paramList1);
  
  public Collection<ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    d.g.b.p.h(paramf, "name");
    d.g.b.p.h(parama, "location");
    if (!gjX().contains(paramf)) {
      return (Collection)d.a.v.MKE;
    }
    return (Collection)this.MXM.invoke(paramf);
  }
  
  public Collection<d.l.b.a.b.b.l> a(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    d.g.b.p.h(paramd, "kindFilter");
    d.g.b.p.h(paramb, "nameFilter");
    return (Collection)this.MXN.invoke();
  }
  
  protected abstract Set<d.l.b.a.b.f.f> a(d.l.b.a.b.j.f.d paramd);
  
  protected abstract void a(Collection<am> paramCollection, d.l.b.a.b.f.f paramf);
  
  protected boolean a(d.l.b.a.b.d.a.b.f paramf)
  {
    d.g.b.p.h(paramf, "$this$isVisibleAsFunction");
    return true;
  }
  
  public Collection<am> b(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    d.g.b.p.h(paramf, "name");
    d.g.b.p.h(parama, "location");
    if (!gjW().contains(paramf)) {
      return (Collection)d.a.v.MKE;
    }
    return (Collection)this.MXL.invoke(paramf);
  }
  
  protected abstract Set<d.l.b.a.b.f.f> b(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb);
  
  protected abstract void b(d.l.b.a.b.f.f paramf, Collection<ah> paramCollection);
  
  protected abstract Set<d.l.b.a.b.f.f> c(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb);
  
  protected final List<d.l.b.a.b.b.l> d(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    d.g.b.p.h(paramd, "kindFilter");
    d.g.b.p.h(paramb, "nameFilter");
    d.l.b.a.b.c.a.c localc = d.l.b.a.b.c.a.c.Nbb;
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject = d.l.b.a.b.j.f.d.NxN;
    d.l.b.a.b.f.f localf;
    if (paramd.alm(d.l.b.a.b.j.f.d.gtr()))
    {
      localObject = c(paramd, paramb).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localf = (d.l.b.a.b.f.f)((Iterator)localObject).next();
        if (((Boolean)paramb.invoke(localf)).booleanValue()) {
          d.l.b.a.b.o.a.c((Collection)localLinkedHashSet, c(localf, (d.l.b.a.b.c.a.a)localc));
        }
      }
    }
    localObject = d.l.b.a.b.j.f.d.NxN;
    if ((paramd.alm(d.l.b.a.b.j.f.d.gto())) && (!paramd.Nxp.contains(c.a.Nxm)))
    {
      localObject = b(paramd, paramb).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localf = (d.l.b.a.b.f.f)((Iterator)localObject).next();
        if (((Boolean)paramb.invoke(localf)).booleanValue()) {
          localLinkedHashSet.addAll(b(localf, (d.l.b.a.b.c.a.a)localc));
        }
      }
    }
    localObject = d.l.b.a.b.j.f.d.NxN;
    if ((paramd.alm(d.l.b.a.b.j.f.d.gtp())) && (!paramd.Nxp.contains(c.a.Nxm)))
    {
      paramd = a(paramd).iterator();
      while (paramd.hasNext())
      {
        localObject = (d.l.b.a.b.f.f)paramd.next();
        if (((Boolean)paramb.invoke(localObject)).booleanValue()) {
          localLinkedHashSet.addAll(a((d.l.b.a.b.f.f)localObject, (d.l.b.a.b.c.a.a)localc));
        }
      }
    }
    return d.a.j.l((Iterable)localLinkedHashSet);
  }
  
  protected abstract ak gio();
  
  public final Set<d.l.b.a.b.f.f> gjW()
  {
    return (Set)d.l.b.a.b.l.i.a(this.NfV, cwV[0]);
  }
  
  public final Set<d.l.b.a.b.f.f> gjX()
  {
    return (Set)d.l.b.a.b.l.i.a(this.NfW, cwV[1]);
  }
  
  protected abstract b glN();
  
  protected abstract d.l.b.a.b.b.l glO();
  
  public String toString()
  {
    return "Lazy scope for " + glO();
  }
  
  protected static final class a
  {
    final List<as> MUK;
    final boolean MYh;
    final ab MZs;
    final ab NdE;
    final List<av> NdF;
    final List<String> NfZ;
    
    public a(ab paramab1, ab paramab2, List<? extends av> paramList, List<? extends as> paramList1, boolean paramBoolean, List<String> paramList2)
    {
      AppMethodBeat.i(57910);
      this.MZs = paramab1;
      this.NdE = paramab2;
      this.NdF = paramList;
      this.MUK = paramList1;
      this.MYh = paramBoolean;
      this.NfZ = paramList2;
      AppMethodBeat.o(57910);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(57913);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!d.g.b.p.i(this.MZs, paramObject.MZs)) || (!d.g.b.p.i(this.NdE, paramObject.NdE)) || (!d.g.b.p.i(this.NdF, paramObject.NdF)) || (!d.g.b.p.i(this.MUK, paramObject.MUK)) || (this.MYh != paramObject.MYh) || (!d.g.b.p.i(this.NfZ, paramObject.NfZ))) {}
        }
      }
      else
      {
        AppMethodBeat.o(57913);
        return true;
      }
      AppMethodBeat.o(57913);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57911);
      String str = "MethodSignatureData(returnType=" + this.MZs + ", receiverType=" + this.NdE + ", valueParameters=" + this.NdF + ", typeParameters=" + this.MUK + ", hasStableParameterNames=" + this.MYh + ", errors=" + this.NfZ + ")";
      AppMethodBeat.o(57911);
      return str;
    }
  }
  
  protected static final class b
  {
    final List<av> Nga;
    final boolean Ngb;
    
    public b(List<? extends av> paramList, boolean paramBoolean)
    {
      AppMethodBeat.i(57914);
      this.Nga = paramList;
      this.Ngb = paramBoolean;
      AppMethodBeat.o(57914);
    }
  }
  
  static final class c
    extends d.g.b.q
    implements d.g.a.a<List<? extends d.l.b.a.b.b.l>>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.q
    implements d.g.a.a<Set<? extends d.l.b.a.b.f.f>>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  static final class e
    extends d.g.b.q
    implements d.g.a.b<d.l.b.a.b.f.f, ah>
  {
    e(k paramk)
    {
      super();
    }
  }
  
  static final class f
    extends d.g.b.q
    implements d.g.a.b<d.l.b.a.b.f.f, Collection<? extends am>>
  {
    f(k paramk)
    {
      super();
    }
  }
  
  static final class g
    extends d.g.b.q
    implements d.g.a.a<b>
  {
    g(k paramk)
    {
      super();
    }
  }
  
  static final class h
    extends d.g.b.q
    implements d.g.a.a<Set<? extends d.l.b.a.b.f.f>>
  {
    h(k paramk)
    {
      super();
    }
  }
  
  static final class i
    extends d.g.b.q
    implements d.g.a.b<d.l.b.a.b.f.f, List<? extends am>>
  {
    i(k paramk)
    {
      super();
    }
  }
  
  static final class j
    extends d.g.b.q
    implements d.g.a.b<d.l.b.a.b.f.f, List<? extends ah>>
  {
    j(k paramk)
    {
      super();
    }
  }
  
  static final class k
    extends d.g.b.q
    implements d.g.a.a<Set<? extends d.l.b.a.b.f.f>>
  {
    k(k paramk)
    {
      super();
    }
  }
  
  static final class l
    extends d.g.b.q
    implements d.g.a.a<d.l.b.a.b.j.b.g<?>>
  {
    l(k paramk, n paramn, aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.k
 * JD-Core Version:    0.7.0.1
 */