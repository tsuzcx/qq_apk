package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.aa;
import d.g.b.k;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.aa.b;
import d.l.b.a.b.b.al;
import d.l.b.a.b.b.al.a;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.aq;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.w;
import d.l.b.a.b.b.w.a;
import d.l.b.a.b.b.y;
import d.l.b.a.b.d.a.e.x;
import d.l.b.a.b.d.a.p;
import d.l.b.a.b.k.a.r;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.au;
import d.l.b.a.b.m.ax;
import d.l.b.a.b.m.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
  extends d.l.b.a.b.b.c.g
  implements d.l.b.a.b.d.a.b.d
{
  private static final Set<String> Lot;
  public static final a Lou;
  private final boolean LdR;
  private final d.l.b.a.b.b.a.g Lez;
  private final w LgG;
  private final d.l.b.a.b.b.f LgH;
  private final d.l.b.a.b.b.ba Lhb;
  public final d.l.b.a.b.d.a.c.h LnD;
  public final d.l.b.a.b.d.a.e.g LnZ;
  final b Lol;
  private final g Lom;
  private final al<g> Lon;
  private final d.l.b.a.b.j.f.f Loo;
  private final l Lop;
  private final d.l.b.a.b.l.f<List<as>> Loq;
  private final d.l.b.a.b.d.a.c.h Lor;
  private final e Los;
  
  static
  {
    AppMethodBeat.i(57824);
    Lou = new a((byte)0);
    Lot = ak.setOf(new String[] { "equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString" });
    AppMethodBeat.o(57824);
  }
  
  public f(d.l.b.a.b.d.a.c.h paramh, d.l.b.a.b.b.l paraml, d.l.b.a.b.d.a.e.g paramg, e parame)
  {
    super(paramh.LnL.KZf, paraml, paramg.fRf(), (an)paramh.LnL.Lno.a((d.l.b.a.b.d.a.e.l)paramg));
    AppMethodBeat.i(57823);
    this.Lor = paramh;
    this.LnZ = paramg;
    this.Los = parame;
    this.LnD = d.l.b.a.b.d.a.c.a.a(this.Lor, (d.l.b.a.b.b.g)this, (x)this.LnZ, 4);
    this.LnD.LnL.Lnl.b(this.LnZ);
    boolean bool1 = aa.KTq;
    if (this.LnZ.fTl())
    {
      paramh = d.l.b.a.b.b.f.LdA;
      this.LgH = paramh;
      if ((!this.LnZ.fTl()) && (!this.LnZ.isEnum())) {
        break label468;
      }
      paramh = w.LdG;
      this.LgG = paramh;
      this.Lhb = this.LnZ.fQb();
      if ((this.LnZ.fTi() == null) || (this.LnZ.fzr())) {
        break label537;
      }
      bool1 = true;
      label220:
      this.LdR = bool1;
      this.Lol = new b();
      paramh = this.LnD;
      paraml = (e)this;
      paramg = this.LnZ;
      if (this.Los == null) {
        break label543;
      }
    }
    label531:
    label537:
    label543:
    for (bool1 = bool3;; bool1 = false)
    {
      this.Lom = new g(paramh, paraml, paramg, bool1);
      paramh = al.Lea;
      this.Lon = al.a.a((e)this, this.LnD.LnL.KZf, this.LnD.LnL.Lnx.gcG(), (d.g.a.b)new d(this));
      this.Loo = new d.l.b.a.b.j.f.f((d.l.b.a.b.j.f.h)this.Lom);
      this.Lop = new l(this.LnD, this.LnZ, this);
      this.Lez = d.l.b.a.b.d.a.c.f.a(this.LnD, (d.l.b.a.b.d.a.e.d)this.LnZ);
      this.Loq = this.LnD.LnL.KZf.O((d.g.a.a)new c(this));
      AppMethodBeat.o(57823);
      return;
      if (this.LnZ.isInterface())
      {
        paramh = d.l.b.a.b.b.f.Ldx;
        break;
      }
      if (this.LnZ.isEnum())
      {
        paramh = d.l.b.a.b.b.f.Ldy;
        break;
      }
      paramh = d.l.b.a.b.b.f.Ldw;
      break;
      label468:
      paramh = w.LdL;
      if ((this.LnZ.fTn()) || (this.LnZ.isInterface()))
      {
        bool1 = true;
        label499:
        if (this.LnZ.fTo()) {
          break label531;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        paramh = w.a.aW(bool1, bool2);
        break;
        bool1 = false;
        break label499;
      }
      bool1 = false;
      break label220;
    }
  }
  
  public final d.l.b.a.b.j.f.h fPV()
  {
    return (d.l.b.a.b.j.f.h)this.Lop;
  }
  
  public final at fPW()
  {
    return (at)this.Lol;
  }
  
  public final e fPX()
  {
    return null;
  }
  
  public final d.l.b.a.b.b.f fPY()
  {
    return this.LgH;
  }
  
  public final w fPZ()
  {
    return this.LgG;
  }
  
  public final d.l.b.a.b.b.d fQa()
  {
    return null;
  }
  
  public final d.l.b.a.b.b.ba fQb()
  {
    AppMethodBeat.i(57815);
    if ((k.g(this.Lhb, az.Lei)) && (this.LnZ.fTi() == null)) {}
    for (d.l.b.a.b.b.ba localba = d.l.b.a.b.d.a.n.Llu;; localba = this.Lhb)
    {
      k.g(localba, "if (visibility == Visibi…ISIBILITY else visibility");
      AppMethodBeat.o(57815);
      return localba;
    }
  }
  
  public final boolean fQc()
  {
    return false;
  }
  
  public final boolean fQd()
  {
    return this.LdR;
  }
  
  public final boolean fQe()
  {
    return false;
  }
  
  public final boolean fQf()
  {
    return false;
  }
  
  public final boolean fQg()
  {
    return false;
  }
  
  public final boolean fQh()
  {
    return false;
  }
  
  public final d.l.b.a.b.b.a.g fQj()
  {
    return this.Lez;
  }
  
  public final Collection<e> fQl()
  {
    return (Collection)d.a.v.KTF;
  }
  
  public final List<as> fQm()
  {
    AppMethodBeat.i(57821);
    List localList = (List)this.Loq.invoke();
    AppMethodBeat.o(57821);
    return localList;
  }
  
  public final d.l.b.a.b.j.f.h fRk()
  {
    return (d.l.b.a.b.j.f.h)this.Loo;
  }
  
  public final g fUl()
  {
    AppMethodBeat.i(57817);
    Object localObject = super.fRj();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
      AppMethodBeat.o(57817);
      throw ((Throwable)localObject);
    }
    localObject = (g)localObject;
    AppMethodBeat.o(57817);
    return localObject;
  }
  
  public final List<d.l.b.a.b.b.d> fUm()
  {
    AppMethodBeat.i(57819);
    List localList = (List)this.Lom.Loy.invoke();
    AppMethodBeat.o(57819);
    return localList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57822);
    String str = "Lazy Java class " + d.l.b.a.b.j.d.a.q((d.l.b.a.b.b.l)this);
    AppMethodBeat.o(57822);
    return str;
  }
  
  public static final class a {}
  
  final class b
    extends d.l.b.a.b.m.b
  {
    private final d.l.b.a.b.l.f<List<as>> Lov;
    
    public b()
    {
      super();
      AppMethodBeat.i(57812);
      this.Lov = f.a(this$1).LnL.KZf.O((d.g.a.a)new a(this));
      AppMethodBeat.o(57812);
    }
    
    private final d.l.b.a.b.m.ab fUn()
    {
      AppMethodBeat.i(57809);
      Object localObject1 = this.Low.fQj();
      Object localObject2 = p.LlI;
      k.g(localObject2, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
      localObject1 = ((d.l.b.a.b.b.a.g)localObject1).g((d.l.b.a.b.f.b)localObject2);
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label341;
        }
        if ((((d.l.b.a.b.f.b)localObject1).Lzj.Lzo.isEmpty()) || (!((d.l.b.a.b.f.b)localObject1).q(d.l.b.a.b.a.g.KYU))) {
          break label330;
        }
        i = 1;
        label77:
        if (i == 0) {
          break label335;
        }
        label81:
        if (localObject1 != null) {
          break label736;
        }
        localObject2 = d.l.b.a.b.d.a.i.Llp;
      }
      label284:
      label291:
      label303:
      label316:
      label330:
      label335:
      label341:
      label736:
      for (localObject2 = d.l.b.a.b.d.a.i.m(d.l.b.a.b.j.d.a.o(this.Low));; localObject2 = localObject1)
      {
        if (localObject2 == null)
        {
          AppMethodBeat.o(57809);
          return null;
          localObject2 = d.a.j.g((Iterable)((d.l.b.a.b.b.a.c)localObject1).fSl().values());
          localObject1 = localObject2;
          if (!(localObject2 instanceof d.l.b.a.b.j.b.v)) {
            localObject1 = null;
          }
          localObject1 = (d.l.b.a.b.j.b.v)localObject1;
          if (localObject1 != null)
          {
            localObject2 = (String)((d.l.b.a.b.j.b.v)localObject1).getValue();
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = null;
            break;
          }
          if (localObject2 != null)
          {
            localObject1 = d.l.b.a.b.f.i.LzA;
            j = ((String)localObject2).length();
            i = 0;
            if (i >= j) {
              break label303;
            }
            char c = ((String)localObject2).charAt(i);
            switch (d.l.b.a.b.f.e.cfA[localObject1.ordinal()])
            {
            }
            do
            {
              for (;;)
              {
                i += 1;
                break;
                if (!Character.isJavaIdentifierPart(c)) {
                  break label291;
                }
                localObject1 = d.l.b.a.b.f.i.LzB;
                continue;
                if (c != '.') {
                  break label284;
                }
                localObject1 = d.l.b.a.b.f.i.LzC;
              }
            } while (Character.isJavaIdentifierPart(c));
          }
          for (i = 0;; i = 1)
          {
            if (i != 0) {
              break label316;
            }
            localObject1 = null;
            break;
            if (localObject1 == d.l.b.a.b.f.i.LzC) {
              break label291;
            }
          }
          localObject1 = new d.l.b.a.b.f.b((String)localObject2);
          break;
          i = 0;
          break label77;
          localObject1 = null;
          break label81;
          localObject1 = null;
          break label81;
        }
        localObject2 = d.l.b.a.b.j.d.a.b(f.a(this.Low).LnL.LbH, (d.l.b.a.b.f.b)localObject2, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Lkk);
        if (localObject2 == null)
        {
          AppMethodBeat.o(57809);
          return null;
        }
        Object localObject3 = ((e)localObject2).fPW();
        k.g(localObject3, "classDescriptor.typeConstructor");
        i = ((at)localObject3).getParameters().size();
        localObject3 = ((at)this.Low.Lol).getParameters();
        k.g(localObject3, "getTypeConstructor().parameters");
        int j = ((List)localObject3).size();
        Object localObject4;
        if (j == i)
        {
          localObject3 = (Iterable)localObject3;
          localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (as)((Iterator)localObject3).next();
            bh localbh = bh.LLV;
            k.g(localObject4, "parameter");
            ((Collection)localObject1).add(new ax(localbh, (d.l.b.a.b.m.ab)((as)localObject4).fRe()));
          }
        }
        for (localObject1 = (List)localObject1;; localObject1 = (List)localObject3)
        {
          localObject3 = d.l.b.a.b.b.a.g.LeU;
          localObject1 = (d.l.b.a.b.m.ab)ac.a(g.a.fSm(), (e)localObject2, (List)localObject1);
          AppMethodBeat.o(57809);
          return localObject1;
          if ((j != 1) || (i <= 1) || (localObject1 != null)) {
            break;
          }
          localObject1 = bh.LLV;
          localObject3 = d.a.j.iS((List)localObject3);
          k.g(localObject3, "typeParameters.single()");
          localObject1 = new ax((bh)localObject1, (d.l.b.a.b.m.ab)((as)localObject3).fRe());
          localObject4 = (Iterable)new d.k.d(1, i);
          localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            ((d.a.ab)localObject4).nextInt();
            ((Collection)localObject3).add(localObject1);
          }
        }
        AppMethodBeat.o(57809);
        return null;
      }
    }
    
    public final Collection<d.l.b.a.b.m.ab> fQp()
    {
      e locale = null;
      AppMethodBeat.i(57808);
      Object localObject1 = this.Low.LnZ.fSt();
      ArrayList localArrayList = new ArrayList(((Collection)localObject1).size());
      Object localObject2 = new ArrayList(0);
      Object localObject3 = fUn();
      Object localObject4 = ((Collection)localObject1).iterator();
      label181:
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = (d.l.b.a.b.d.a.e.j)((Iterator)localObject4).next();
        localObject5 = f.a(this.Low).LnK.a((d.l.b.a.b.d.a.e.v)localObject1, d.l.b.a.b.d.a.c.b.d.a(d.l.b.a.b.d.a.a.l.LmK, false, null, 3));
        if ((((d.l.b.a.b.m.ab)localObject5).gbz().fQq() instanceof aa.b)) {
          ((ArrayList)localObject2).add(localObject1);
        }
        at localat = ((d.l.b.a.b.m.ab)localObject5).gbz();
        if (localObject3 != null) {}
        for (localObject1 = ((d.l.b.a.b.m.ab)localObject3).gbz();; localObject1 = null)
        {
          if ((k.g(localat, localObject1)) || (d.l.b.a.b.a.g.z((d.l.b.a.b.m.ab)localObject5))) {
            break label181;
          }
          localArrayList.add(localObject5);
          break;
        }
      }
      localObject4 = (Collection)localArrayList;
      Object localObject5 = f.b(this.Low);
      localObject1 = locale;
      if (localObject5 != null) {
        localObject1 = d.l.b.a.b.a.b.j.a((e)localObject5, (e)this.Low).gcD().c((d.l.b.a.b.m.ab)((e)localObject5).fRe(), bh.LLV);
      }
      d.l.b.a.b.o.a.c((Collection)localObject4, localObject1);
      d.l.b.a.b.o.a.c((Collection)localArrayList, localObject3);
      if (!((Collection)localObject2).isEmpty())
      {
        i = 1;
        if (i != 0)
        {
          localObject1 = f.a(this.Low).LnL.Lnk;
          locale = (e)this.Low;
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label402;
          }
          localObject4 = (d.l.b.a.b.d.a.e.v)((Iterator)localObject3).next();
          if (localObject4 == null)
          {
            localObject1 = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
            AppMethodBeat.o(57808);
            throw ((Throwable)localObject1);
            i = 0;
            break;
          }
          ((Collection)localObject2).add(((d.l.b.a.b.d.a.e.j)localObject4).fTs());
        }
        label402:
        ((r)localObject1).a(locale, (List)localObject2);
      }
      if (!((Collection)localArrayList).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = (Collection)d.a.j.l((Iterable)localArrayList);
        AppMethodBeat.o(57808);
        return localObject1;
      }
      localObject1 = (Collection)d.a.j.listOf(f.a(this.Low).LnL.LbH.fRE().fPF());
      AppMethodBeat.o(57808);
      return localObject1;
    }
    
    public final e fQr()
    {
      return (e)this.Low;
    }
    
    public final boolean fQs()
    {
      return true;
    }
    
    public final aq fQt()
    {
      AppMethodBeat.i(57810);
      aq localaq = f.a(this.Low).LnL.LgC;
      AppMethodBeat.o(57810);
      return localaq;
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(57807);
      List localList = (List)this.Lov.invoke();
      AppMethodBeat.o(57807);
      return localList;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57811);
      String str = this.Low.fRf().rf();
      k.g(str, "name.asString()");
      AppMethodBeat.o(57811);
      return str;
    }
    
    static final class a
      extends d.g.b.l
      implements d.g.a.a<List<? extends as>>
    {
      a(f.b paramb)
      {
        super();
      }
    }
  }
  
  static final class c
    extends d.g.b.l
    implements d.g.a.a<List<? extends as>>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.m.a.i, g>
  {
    d(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.f
 * JD-Core Version:    0.7.0.1
 */