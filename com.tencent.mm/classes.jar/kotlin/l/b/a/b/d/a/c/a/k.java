package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.ae;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.aa;
import kotlin.l.b.a.b.b.c.aj;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w.a;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.d.a.c.m;
import kotlin.l.b.a.b.d.a.e.n;
import kotlin.l.b.a.b.d.a.e.x;
import kotlin.l.b.a.b.j.f.c.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.o;
import kotlin.s;

public abstract class k
  extends kotlin.l.b.a.b.j.f.i
{
  private final kotlin.l.b.a.b.l.c<kotlin.l.b.a.b.f.f, Collection<am>> aaNt;
  private final kotlin.l.b.a.b.l.c<kotlin.l.b.a.b.f.f, List<ah>> aaNu;
  private final kotlin.l.b.a.b.l.f<Collection<kotlin.l.b.a.b.b.l>> aaNv;
  final h aaUh;
  private final kotlin.l.b.a.b.l.d<kotlin.l.b.a.b.f.f, ah> aaVA;
  private final kotlin.l.b.a.b.l.f aaVB;
  private final kotlin.l.b.a.b.l.f aaVC;
  private final kotlin.l.b.a.b.l.f aaVD;
  final k aaVE;
  final kotlin.l.b.a.b.l.f<b> aaVy;
  private final kotlin.l.b.a.b.l.c<kotlin.l.b.a.b.f.f, Collection<am>> aaVz;
  
  public k(h paramh, k paramk)
  {
    this.aaUh = paramh;
    this.aaVE = paramk;
    this.aaNv = this.aaUh.aaUp.aaFH.a((kotlin.g.a.a)new c(this), (List)kotlin.a.v.aaAd);
    this.aaVy = this.aaUh.aaUp.aaFH.av((kotlin.g.a.a)new g(this));
    this.aaVz = this.aaUh.aaUp.aaFH.ak((kotlin.g.a.b)new f(this));
    this.aaVA = this.aaUh.aaUp.aaFH.al((kotlin.g.a.b)new e(this));
    this.aaNt = this.aaUh.aaUp.aaFH.ak((kotlin.g.a.b)new i(this));
    this.aaVB = this.aaUh.aaUp.aaFH.av((kotlin.g.a.a)new h(this));
    this.aaVC = this.aaUh.aaUp.aaFH.av((kotlin.g.a.a)new k(this));
    this.aaVD = this.aaUh.aaUp.aaFH.av((kotlin.g.a.a)new d(this));
    this.aaNu = this.aaUh.aaUp.aaFH.ak((kotlin.g.a.b)new j(this));
  }
  
  protected static b a(h paramh, t paramt, List<? extends kotlin.l.b.a.b.d.a.e.y> paramList)
  {
    kotlin.g.b.p.k(paramh, "c");
    kotlin.g.b.p.k(paramt, "function");
    kotlin.g.b.p.k(paramList, "jValueParameters");
    Set localSet = (Set)new LinkedHashSet();
    Object localObject1 = kotlin.a.j.s((Iterable)paramList);
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    boolean bool = false;
    int j;
    kotlin.l.b.a.b.d.a.e.y localy;
    kotlin.l.b.a.b.b.a.g localg;
    kotlin.l.b.a.b.d.a.c.b.a locala;
    Object localObject2;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject1 = (kotlin.a.y)localIterator.next();
      j = ((kotlin.a.y)localObject1).index;
      localy = (kotlin.l.b.a.b.d.a.e.y)((kotlin.a.y)localObject1).value;
      localg = kotlin.l.b.a.b.d.a.c.f.a(paramh, (kotlin.l.b.a.b.d.a.e.d)localy);
      locala = kotlin.l.b.a.b.d.a.c.b.d.a(kotlin.l.b.a.b.d.a.a.l.aaTp, false, null, 3);
      localObject1 = kotlin.l.b.a.b.d.a.p.aaSp;
      kotlin.g.b.p.j(localObject1, "JvmAnnotationNames.PARAMETER_NAME_FQ_NAME");
      localObject1 = localg.g((kotlin.l.b.a.b.f.b)localObject1);
      if (localObject1 != null)
      {
        localObject2 = kotlin.l.b.a.b.j.d.a.m((kotlin.l.b.a.b.b.a.c)localObject1);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!(localObject2 instanceof kotlin.l.b.a.b.j.b.v)) {
            localObject1 = null;
          }
          localObject1 = (kotlin.l.b.a.b.j.b.v)localObject1;
          if (localObject1 != null) {
            localObject1 = (String)((kotlin.l.b.a.b.j.b.v)localObject1).getValue();
          }
        }
      }
      while (localy.iHD())
      {
        localObject3 = localy.iHv();
        localObject2 = localObject3;
        if (!(localObject3 instanceof kotlin.l.b.a.b.d.a.e.f)) {
          localObject2 = null;
        }
        localObject2 = (kotlin.l.b.a.b.d.a.e.f)localObject2;
        if (localObject2 == null)
        {
          throw ((Throwable)new AssertionError("Vararg parameter should be an array: ".concat(String.valueOf(localy))));
          localObject1 = null;
        }
        else
        {
          localObject2 = paramh.aaUo.a((kotlin.l.b.a.b.d.a.e.f)localObject2, locala, true);
          localObject2 = s.M(localObject2, paramh.aaUp.aaIj.iFv().l((ab)localObject2));
          label323:
          localObject3 = (ab)((o)localObject2).Mx;
          localObject2 = (ab)((o)localObject2).My;
          if ((!kotlin.g.b.p.h(paramt.iEU().qu(), "equals")) || (paramList.size() != 1) || (!kotlin.g.b.p.h(paramh.aaUp.aaIj.iFv().iDv(), localObject3))) {
            break label491;
          }
          localObject1 = kotlin.l.b.a.b.f.f.bHb("other");
        }
      }
    }
    for (;;)
    {
      kotlin.g.b.p.j(localObject1, "if (function.name.asStri…(\"p$index\")\n            }");
      localCollection.add(new aj((kotlin.l.b.a.b.b.a)paramt, null, j, localg, (kotlin.l.b.a.b.f.f)localObject1, (ab)localObject3, false, false, false, (ab)localObject2, (an)paramh.aaUp.aaTS.a((kotlin.l.b.a.b.d.a.e.l)localy)));
      break;
      localObject2 = s.M(paramh.aaUo.a(localy.iHv(), locala), null);
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
          localObject1 = kotlin.l.b.a.b.f.f.bHb((String)localObject1);
          break;
        }
      }
      label542:
      localObject1 = localy.iEU();
      if (localObject1 == null) {
        bool = true;
      }
      if (localObject1 == null)
      {
        localObject1 = kotlin.l.b.a.b.f.f.bHb("p".concat(String.valueOf(j)));
        continue;
        return new b(kotlin.a.j.p((Iterable)localCollection), bool);
      }
    }
  }
  
  protected static ab a(kotlin.l.b.a.b.d.a.e.q paramq, h paramh)
  {
    kotlin.g.b.p.k(paramq, "method");
    kotlin.g.b.p.k(paramh, "c");
    boolean bool = paramq.iHw().iHh();
    kotlin.l.b.a.b.d.a.c.b.a locala = kotlin.l.b.a.b.d.a.c.b.d.a(kotlin.l.b.a.b.d.a.a.l.aaTp, bool, null, 2);
    return paramh.aaUo.a(paramq.iHx(), locala);
  }
  
  private static boolean a(n paramn)
  {
    return (paramn.iHl()) && (paramn.ihW());
  }
  
  public Collection<ah> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    kotlin.g.b.p.k(paramf, "name");
    kotlin.g.b.p.k(parama, "location");
    if (!iGq().contains(paramf)) {
      return (Collection)kotlin.a.v.aaAd;
    }
    return (Collection)this.aaNu.invoke(paramf);
  }
  
  public Collection<kotlin.l.b.a.b.b.l> a(kotlin.l.b.a.b.j.f.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    kotlin.g.b.p.k(paramd, "kindFilter");
    kotlin.g.b.p.k(paramb, "nameFilter");
    return (Collection)this.aaNv.invoke();
  }
  
  protected abstract Set<kotlin.l.b.a.b.f.f> a(kotlin.l.b.a.b.j.f.d paramd);
  
  protected final kotlin.l.b.a.b.d.a.b.f a(kotlin.l.b.a.b.d.a.e.q paramq)
  {
    kotlin.g.b.p.k(paramq, "method");
    Object localObject1 = kotlin.l.b.a.b.d.a.c.f.a(this.aaUh, (kotlin.l.b.a.b.d.a.e.d)paramq);
    kotlin.l.b.a.b.d.a.b.f localf = kotlin.l.b.a.b.d.a.b.f.a(iIl(), (kotlin.l.b.a.b.b.a.g)localObject1, paramq.iEU(), (an)this.aaUh.aaUp.aaTS.a((kotlin.l.b.a.b.d.a.e.l)paramq));
    kotlin.g.b.p.j(localf, "JavaMethodDescriptor.cre….source(method)\n        )");
    h localh = kotlin.l.b.a.b.d.a.c.a.a(this.aaUh, (kotlin.l.b.a.b.b.l)localf, (x)paramq, 0);
    Object localObject2 = (Iterable)paramq.iEG();
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (kotlin.l.b.a.b.d.a.e.w)((Iterator)localObject2).next();
      localObject3 = localh.aaUq.a((kotlin.l.b.a.b.d.a.e.w)localObject3);
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
      ((Collection)localObject1).add(localObject3);
    }
    localObject1 = (List)localObject1;
    localObject2 = a(localh, (t)localf, paramq.iEJ());
    Object localObject3 = a(paramq, (List)localObject1, a(paramq, localh), ((b)localObject2).aaVG);
    localObject1 = ((a)localObject3).aaTl;
    boolean bool1;
    if (localObject1 != null)
    {
      Object localObject4 = (kotlin.l.b.a.b.b.a)localf;
      Object localObject5 = kotlin.l.b.a.b.b.a.g.aaLw;
      localObject1 = kotlin.l.b.a.b.j.b.a((kotlin.l.b.a.b.b.a)localObject4, (ab)localObject1, g.a.iGe());
      localObject4 = iEF();
      localObject5 = ((a)localObject3).aaKr;
      List localList = ((a)localObject3).aaTm;
      ab localab = ((a)localObject3).aaPa;
      Object localObject6 = kotlin.l.b.a.b.b.w.aaKn;
      boolean bool2 = paramq.iHk();
      if (paramq.iHl()) {
        break label446;
      }
      bool1 = true;
      label314:
      localObject6 = w.a.bx(bool2, bool1);
      ba localba = paramq.iDQ();
      if (((a)localObject3).aaTl == null) {
        break label451;
      }
      paramq = ae.d(s.M(kotlin.l.b.a.b.d.a.b.f.aaTt, kotlin.a.j.lo(((b)localObject2).aaVG)));
      label356:
      localf.a((ak)localObject1, (ak)localObject4, (List)localObject5, localList, localab, (kotlin.l.b.a.b.b.w)localObject6, localba, paramq);
      localf.by(((a)localObject3).aaNP, ((b)localObject2).aaVH);
      if (((Collection)((a)localObject3).aaVF).isEmpty()) {
        break label458;
      }
    }
    label446:
    label451:
    label458:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localh.aaUp.aaTN.a((kotlin.l.b.a.b.b.b)localf, ((a)localObject3).aaVF);
      }
      return localf;
      localObject1 = null;
      break;
      bool1 = false;
      break label314;
      paramq = ae.iBR();
      break label356;
    }
  }
  
  protected abstract a a(kotlin.l.b.a.b.d.a.e.q paramq, List<? extends as> paramList, ab paramab, List<? extends av> paramList1);
  
  protected abstract void a(Collection<am> paramCollection, kotlin.l.b.a.b.f.f paramf);
  
  protected boolean a(kotlin.l.b.a.b.d.a.b.f paramf)
  {
    kotlin.g.b.p.k(paramf, "$this$isVisibleAsFunction");
    return true;
  }
  
  public Collection<am> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    kotlin.g.b.p.k(paramf, "name");
    kotlin.g.b.p.k(parama, "location");
    if (!iGp().contains(paramf)) {
      return (Collection)kotlin.a.v.aaAd;
    }
    return (Collection)this.aaNt.invoke(paramf);
  }
  
  protected abstract Set<kotlin.l.b.a.b.f.f> b(kotlin.l.b.a.b.j.f.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb);
  
  protected abstract void b(kotlin.l.b.a.b.f.f paramf, Collection<ah> paramCollection);
  
  protected abstract Set<kotlin.l.b.a.b.f.f> c(kotlin.l.b.a.b.j.f.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb);
  
  protected final List<kotlin.l.b.a.b.b.l> d(kotlin.l.b.a.b.j.f.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    kotlin.g.b.p.k(paramd, "kindFilter");
    kotlin.g.b.p.k(paramb, "nameFilter");
    kotlin.l.b.a.b.c.a.c localc = kotlin.l.b.a.b.c.a.c.aaQI;
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject = kotlin.l.b.a.b.j.f.d.abms;
    kotlin.l.b.a.b.f.f localf;
    if (paramd.aFz(kotlin.l.b.a.b.j.f.d.iPm()))
    {
      localObject = c(paramd, paramb).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localf = (kotlin.l.b.a.b.f.f)((Iterator)localObject).next();
        if (((Boolean)paramb.invoke(localf)).booleanValue()) {
          kotlin.l.b.a.b.o.a.c((Collection)localLinkedHashSet, c(localf, (kotlin.l.b.a.b.c.a.a)localc));
        }
      }
    }
    localObject = kotlin.l.b.a.b.j.f.d.abms;
    if ((paramd.aFz(kotlin.l.b.a.b.j.f.d.iPj())) && (!paramd.ablU.contains(c.a.ablR)))
    {
      localObject = b(paramd, paramb).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localf = (kotlin.l.b.a.b.f.f)((Iterator)localObject).next();
        if (((Boolean)paramb.invoke(localf)).booleanValue()) {
          localLinkedHashSet.addAll(b(localf, (kotlin.l.b.a.b.c.a.a)localc));
        }
      }
    }
    localObject = kotlin.l.b.a.b.j.f.d.abms;
    if ((paramd.aFz(kotlin.l.b.a.b.j.f.d.iPk())) && (!paramd.ablU.contains(c.a.ablR)))
    {
      paramd = a(paramd).iterator();
      while (paramd.hasNext())
      {
        localObject = (kotlin.l.b.a.b.f.f)paramd.next();
        if (((Boolean)paramb.invoke(localObject)).booleanValue()) {
          localLinkedHashSet.addAll(a((kotlin.l.b.a.b.f.f)localObject, (kotlin.l.b.a.b.c.a.a)localc));
        }
      }
    }
    return kotlin.a.j.p((Iterable)localLinkedHashSet);
  }
  
  protected abstract ak iEF();
  
  public final Set<kotlin.l.b.a.b.f.f> iGp()
  {
    return (Set)kotlin.l.b.a.b.l.i.a(this.aaVB, cMt[0]);
  }
  
  public final Set<kotlin.l.b.a.b.f.f> iGq()
  {
    return (Set)kotlin.l.b.a.b.l.i.a(this.aaVC, cMt[1]);
  }
  
  protected abstract b iIk();
  
  protected abstract kotlin.l.b.a.b.b.l iIl();
  
  protected final kotlin.l.b.a.b.l.f<Collection<kotlin.l.b.a.b.b.l>> iIn()
  {
    return this.aaNv;
  }
  
  public String toString()
  {
    return "Lazy scope for " + iIl();
  }
  
  protected static final class a
  {
    final List<as> aaKr;
    final boolean aaNP;
    final ab aaPa;
    final ab aaTl;
    final List<av> aaTm;
    final List<String> aaVF;
    
    public a(ab paramab1, ab paramab2, List<? extends av> paramList, List<? extends as> paramList1, boolean paramBoolean, List<String> paramList2)
    {
      AppMethodBeat.i(57910);
      this.aaPa = paramab1;
      this.aaTl = paramab2;
      this.aaTm = paramList;
      this.aaKr = paramList1;
      this.aaNP = paramBoolean;
      this.aaVF = paramList2;
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
          if ((!kotlin.g.b.p.h(this.aaPa, paramObject.aaPa)) || (!kotlin.g.b.p.h(this.aaTl, paramObject.aaTl)) || (!kotlin.g.b.p.h(this.aaTm, paramObject.aaTm)) || (!kotlin.g.b.p.h(this.aaKr, paramObject.aaKr)) || (this.aaNP != paramObject.aaNP) || (!kotlin.g.b.p.h(this.aaVF, paramObject.aaVF))) {}
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
      String str = "MethodSignatureData(returnType=" + this.aaPa + ", receiverType=" + this.aaTl + ", valueParameters=" + this.aaTm + ", typeParameters=" + this.aaKr + ", hasStableParameterNames=" + this.aaNP + ", errors=" + this.aaVF + ")";
      AppMethodBeat.o(57911);
      return str;
    }
  }
  
  protected static final class b
  {
    final List<av> aaVG;
    final boolean aaVH;
    
    public b(List<? extends av> paramList, boolean paramBoolean)
    {
      AppMethodBeat.i(57914);
      this.aaVG = paramList;
      this.aaVH = paramBoolean;
      AppMethodBeat.o(57914);
    }
  }
  
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.l>>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, ah>
  {
    e(k paramk)
    {
      super();
    }
  }
  
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends am>>
  {
    f(k paramk)
    {
      super();
    }
  }
  
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<b>
  {
    g(k paramk)
    {
      super();
    }
  }
  
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
  {
    h(k paramk)
    {
      super();
    }
  }
  
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, List<? extends am>>
  {
    i(k paramk)
    {
      super();
    }
  }
  
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, List<? extends ah>>
  {
    j(k paramk)
    {
      super();
    }
  }
  
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
  {
    k(k paramk)
    {
      super();
    }
  }
  
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.l.b.a.b.j.b.g<?>>
  {
    l(k paramk, n paramn, aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.k
 * JD-Core Version:    0.7.0.1
 */