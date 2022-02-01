package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ak;
import kotlin.aa;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.aa.b;
import kotlin.l.b.a.b.b.al;
import kotlin.l.b.a.b.b.al.a;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.w.a;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.d.a.e.x;
import kotlin.l.b.a.b.k.a.r;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.au;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bh;
import kotlin.t;

public final class f
  extends kotlin.l.b.a.b.b.c.g
  implements kotlin.l.b.a.b.d.a.b.d
{
  private static final Set<String> Tsc;
  public static final a Tsd;
  private final boolean Thz;
  private final kotlin.l.b.a.b.b.a.g Tih;
  private final kotlin.l.b.a.b.b.ba TkL;
  private final w Tkq;
  private final kotlin.l.b.a.b.b.f Tkr;
  public final kotlin.l.b.a.b.d.a.e.g TrI;
  final b TrU;
  private final g TrV;
  private final al<g> TrW;
  private final kotlin.l.b.a.b.j.f.f TrX;
  private final l TrY;
  private final kotlin.l.b.a.b.l.f<List<as>> TrZ;
  public final kotlin.l.b.a.b.d.a.c.h Trn;
  private final kotlin.l.b.a.b.d.a.c.h Tsa;
  private final e Tsb;
  
  static
  {
    AppMethodBeat.i(57824);
    Tsd = new a((byte)0);
    Tsc = ak.setOf(new String[] { "equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString" });
    AppMethodBeat.o(57824);
  }
  
  public f(kotlin.l.b.a.b.d.a.c.h paramh, kotlin.l.b.a.b.b.l paraml, kotlin.l.b.a.b.d.a.e.g paramg, e parame)
  {
    super(paramh.Trv.TcN, paraml, paramg.hAH(), (an)paramh.Trv.TqY.a((kotlin.l.b.a.b.d.a.e.l)paramg));
    AppMethodBeat.i(57823);
    this.Tsa = paramh;
    this.TrI = paramg;
    this.Tsb = parame;
    this.Trn = kotlin.l.b.a.b.d.a.c.a.a(this.Tsa, (kotlin.l.b.a.b.b.g)this, (x)this.TrI, 4);
    this.Trn.Trv.TqV.b(this.TrI);
    boolean bool1 = aa.SXc;
    if (this.TrI.hCO())
    {
      paramh = kotlin.l.b.a.b.b.f.Thi;
      this.Tkr = paramh;
      if ((!this.TrI.hCO()) && (!this.TrI.isEnum())) {
        break label468;
      }
      paramh = w.Tho;
      this.Tkq = paramh;
      this.TkL = this.TrI.hzE();
      if ((this.TrI.hCL() == null) || (this.TrI.hgu())) {
        break label537;
      }
      bool1 = true;
      label220:
      this.Thz = bool1;
      this.TrU = new b();
      paramh = this.Trn;
      paraml = (e)this;
      paramg = this.TrI;
      if (this.Tsb == null) {
        break label543;
      }
    }
    label531:
    label537:
    label543:
    for (bool1 = bool3;; bool1 = false)
    {
      this.TrV = new g(paramh, paraml, paramg, bool1);
      paramh = al.ThI;
      this.TrW = al.a.a((e)this, this.Trn.Trv.TcN, this.Trn.Trv.Trh.hLM(), (kotlin.g.a.b)new d(this));
      this.TrX = new kotlin.l.b.a.b.j.f.f((kotlin.l.b.a.b.j.f.h)this.TrV);
      this.TrY = new l(this.Trn, this.TrI, this);
      this.Tih = kotlin.l.b.a.b.d.a.c.f.a(this.Trn, (kotlin.l.b.a.b.d.a.e.d)this.TrI);
      this.TrZ = this.Trn.Trv.TcN.al((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(57823);
      return;
      if (this.TrI.isInterface())
      {
        paramh = kotlin.l.b.a.b.b.f.Thf;
        break;
      }
      if (this.TrI.isEnum())
      {
        paramh = kotlin.l.b.a.b.b.f.Thg;
        break;
      }
      paramh = kotlin.l.b.a.b.b.f.The;
      break;
      label468:
      paramh = w.Tht;
      if ((this.TrI.hCQ()) || (this.TrI.isInterface()))
      {
        bool1 = true;
        label499:
        if (this.TrI.hCR()) {
          break label531;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        paramh = w.a.bn(bool1, bool2);
        break;
        bool1 = false;
        break label499;
      }
      bool1 = false;
      break label220;
    }
  }
  
  public final kotlin.l.b.a.b.j.f.h hAN()
  {
    return (kotlin.l.b.a.b.j.f.h)this.TrX;
  }
  
  public final g hDO()
  {
    AppMethodBeat.i(57817);
    Object localObject = super.hAM();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
      AppMethodBeat.o(57817);
      throw ((Throwable)localObject);
    }
    localObject = (g)localObject;
    AppMethodBeat.o(57817);
    return localObject;
  }
  
  public final List<kotlin.l.b.a.b.b.d> hDP()
  {
    AppMethodBeat.i(57819);
    List localList = (List)this.TrV.Tsh.invoke();
    AppMethodBeat.o(57819);
    return localList;
  }
  
  public final e hzA()
  {
    return null;
  }
  
  public final kotlin.l.b.a.b.b.f hzB()
  {
    return this.Tkr;
  }
  
  public final w hzC()
  {
    return this.Tkq;
  }
  
  public final kotlin.l.b.a.b.b.d hzD()
  {
    return null;
  }
  
  public final kotlin.l.b.a.b.b.ba hzE()
  {
    AppMethodBeat.i(57815);
    if ((kotlin.g.b.p.j(this.TkL, az.ThQ)) && (this.TrI.hCL() == null)) {}
    for (kotlin.l.b.a.b.b.ba localba = kotlin.l.b.a.b.d.a.n.Tpe;; localba = this.TkL)
    {
      kotlin.g.b.p.g(localba, "if (visibility == Visibi…ISIBILITY else visibility");
      AppMethodBeat.o(57815);
      return localba;
    }
  }
  
  public final boolean hzF()
  {
    return false;
  }
  
  public final boolean hzG()
  {
    return this.Thz;
  }
  
  public final boolean hzH()
  {
    return false;
  }
  
  public final boolean hzI()
  {
    return false;
  }
  
  public final boolean hzJ()
  {
    return false;
  }
  
  public final boolean hzK()
  {
    return false;
  }
  
  public final kotlin.l.b.a.b.b.a.g hzL()
  {
    return this.Tih;
  }
  
  public final Collection<e> hzN()
  {
    return (Collection)kotlin.a.v.SXr;
  }
  
  public final List<as> hzO()
  {
    AppMethodBeat.i(57821);
    List localList = (List)this.TrZ.invoke();
    AppMethodBeat.o(57821);
    return localList;
  }
  
  public final kotlin.l.b.a.b.j.f.h hzy()
  {
    return (kotlin.l.b.a.b.j.f.h)this.TrY;
  }
  
  public final at hzz()
  {
    return (at)this.TrU;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57822);
    String str = "Lazy Java class " + kotlin.l.b.a.b.j.d.a.q((kotlin.l.b.a.b.b.l)this);
    AppMethodBeat.o(57822);
    return str;
  }
  
  public static final class a {}
  
  final class b
    extends kotlin.l.b.a.b.m.b
  {
    private final kotlin.l.b.a.b.l.f<List<as>> Tse;
    
    public b()
    {
      super();
      AppMethodBeat.i(57812);
      this.Tse = f.a(this$1).Trv.TcN.al((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(57812);
    }
    
    private final kotlin.l.b.a.b.m.ab hDQ()
    {
      AppMethodBeat.i(57809);
      Object localObject1 = this.Tsf.hzL();
      Object localObject2 = kotlin.l.b.a.b.d.a.p.Tps;
      kotlin.g.b.p.g(localObject2, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
      localObject1 = ((kotlin.l.b.a.b.b.a.g)localObject1).g((kotlin.l.b.a.b.f.b)localObject2);
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label341;
        }
        if ((((kotlin.l.b.a.b.f.b)localObject1).TCR.TCW.isEmpty()) || (!((kotlin.l.b.a.b.f.b)localObject1).q(kotlin.l.b.a.b.a.g.TcC))) {
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
        localObject2 = kotlin.l.b.a.b.d.a.i.ToZ;
      }
      label284:
      label291:
      label303:
      label316:
      label330:
      label335:
      label341:
      label736:
      for (localObject2 = kotlin.l.b.a.b.d.a.i.m(kotlin.l.b.a.b.j.d.a.o(this.Tsf));; localObject2 = localObject1)
      {
        if (localObject2 == null)
        {
          AppMethodBeat.o(57809);
          return null;
          localObject2 = kotlin.a.j.j((Iterable)((kotlin.l.b.a.b.b.a.c)localObject1).hBO().values());
          localObject1 = localObject2;
          if (!(localObject2 instanceof kotlin.l.b.a.b.j.b.v)) {
            localObject1 = null;
          }
          localObject1 = (kotlin.l.b.a.b.j.b.v)localObject1;
          if (localObject1 != null)
          {
            localObject2 = (String)((kotlin.l.b.a.b.j.b.v)localObject1).getValue();
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = null;
            break;
          }
          if (localObject2 != null)
          {
            localObject1 = kotlin.l.b.a.b.f.i.TDi;
            j = ((String)localObject2).length();
            i = 0;
            if (i >= j) {
              break label303;
            }
            char c = ((String)localObject2).charAt(i);
            switch (kotlin.l.b.a.b.f.e.$EnumSwitchMapping$0[localObject1.ordinal()])
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
                localObject1 = kotlin.l.b.a.b.f.i.TDj;
                continue;
                if (c != '.') {
                  break label284;
                }
                localObject1 = kotlin.l.b.a.b.f.i.TDk;
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
            if (localObject1 == kotlin.l.b.a.b.f.i.TDk) {
              break label291;
            }
          }
          localObject1 = new kotlin.l.b.a.b.f.b((String)localObject2);
          break;
          i = 0;
          break label77;
          localObject1 = null;
          break label81;
          localObject1 = null;
          break label81;
        }
        localObject2 = kotlin.l.b.a.b.j.d.a.b(f.a(this.Tsf).Trv.Tfp, (kotlin.l.b.a.b.f.b)localObject2, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.TnU);
        if (localObject2 == null)
        {
          AppMethodBeat.o(57809);
          return null;
        }
        Object localObject3 = ((e)localObject2).hzz();
        kotlin.g.b.p.g(localObject3, "classDescriptor.typeConstructor");
        i = ((at)localObject3).getParameters().size();
        localObject3 = ((at)this.Tsf.TrU).getParameters();
        kotlin.g.b.p.g(localObject3, "getTypeConstructor().parameters");
        int j = ((List)localObject3).size();
        Object localObject4;
        if (j == i)
        {
          localObject3 = (Iterable)localObject3;
          localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (as)((Iterator)localObject3).next();
            bh localbh = bh.TOQ;
            kotlin.g.b.p.g(localObject4, "parameter");
            ((Collection)localObject1).add(new ax(localbh, (kotlin.l.b.a.b.m.ab)((as)localObject4).hAG()));
          }
        }
        for (localObject1 = (List)localObject1;; localObject1 = (List)localObject3)
        {
          localObject3 = kotlin.l.b.a.b.b.a.g.TiC;
          localObject1 = (kotlin.l.b.a.b.m.ab)ac.a(g.a.hBP(), (e)localObject2, (List)localObject1);
          AppMethodBeat.o(57809);
          return localObject1;
          if ((j != 1) || (i <= 1) || (localObject1 != null)) {
            break;
          }
          localObject1 = bh.TOQ;
          localObject3 = kotlin.a.j.kw((List)localObject3);
          kotlin.g.b.p.g(localObject3, "typeParameters.single()");
          localObject1 = new ax((bh)localObject1, (kotlin.l.b.a.b.m.ab)((as)localObject3).hAG());
          localObject4 = (Iterable)new kotlin.k.f(1, i);
          localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            ((kotlin.a.ab)localObject4).nextInt();
            ((Collection)localObject3).add(localObject1);
          }
        }
        AppMethodBeat.o(57809);
        return null;
      }
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(57807);
      List localList = (List)this.Tse.invoke();
      AppMethodBeat.o(57807);
      return localList;
    }
    
    public final Collection<kotlin.l.b.a.b.m.ab> hzR()
    {
      e locale = null;
      AppMethodBeat.i(57808);
      Object localObject1 = this.Tsf.TrI.hBV();
      ArrayList localArrayList = new ArrayList(((Collection)localObject1).size());
      Object localObject2 = new ArrayList(0);
      Object localObject3 = hDQ();
      Object localObject4 = ((Collection)localObject1).iterator();
      label181:
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = (kotlin.l.b.a.b.d.a.e.j)((Iterator)localObject4).next();
        localObject5 = f.a(this.Tsf).Tru.a((kotlin.l.b.a.b.d.a.e.v)localObject1, kotlin.l.b.a.b.d.a.c.b.d.a(kotlin.l.b.a.b.d.a.a.l.Tqu, false, null, 3));
        if ((((kotlin.l.b.a.b.m.ab)localObject5).hKE().hzS() instanceof aa.b)) {
          ((ArrayList)localObject2).add(localObject1);
        }
        at localat = ((kotlin.l.b.a.b.m.ab)localObject5).hKE();
        if (localObject3 != null) {}
        for (localObject1 = ((kotlin.l.b.a.b.m.ab)localObject3).hKE();; localObject1 = null)
        {
          if ((kotlin.g.b.p.j(localat, localObject1)) || (kotlin.l.b.a.b.a.g.z((kotlin.l.b.a.b.m.ab)localObject5))) {
            break label181;
          }
          localArrayList.add(localObject5);
          break;
        }
      }
      localObject4 = (Collection)localArrayList;
      Object localObject5 = f.b(this.Tsf);
      localObject1 = locale;
      if (localObject5 != null) {
        localObject1 = kotlin.l.b.a.b.a.b.j.a((e)localObject5, (e)this.Tsf).hLJ().c((kotlin.l.b.a.b.m.ab)((e)localObject5).hAG(), bh.TOQ);
      }
      kotlin.l.b.a.b.o.a.c((Collection)localObject4, localObject1);
      kotlin.l.b.a.b.o.a.c((Collection)localArrayList, localObject3);
      if (!((Collection)localObject2).isEmpty())
      {
        i = 1;
        if (i != 0)
        {
          localObject1 = f.a(this.Tsf).Trv.TqU;
          locale = (e)this.Tsf;
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
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
          localObject4 = (kotlin.l.b.a.b.d.a.e.v)((Iterator)localObject3).next();
          if (localObject4 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
            AppMethodBeat.o(57808);
            throw ((Throwable)localObject1);
            i = 0;
            break;
          }
          ((Collection)localObject2).add(((kotlin.l.b.a.b.d.a.e.j)localObject4).hCV());
        }
        label402:
        ((r)localObject1).a(locale, (List)localObject2);
      }
      if (!((Collection)localArrayList).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = (Collection)kotlin.a.j.p((Iterable)localArrayList);
        AppMethodBeat.o(57808);
        return localObject1;
      }
      localObject1 = (Collection)kotlin.a.j.listOf(f.a(this.Tsf).Trv.Tfp.hBh().hzi());
      AppMethodBeat.o(57808);
      return localObject1;
    }
    
    public final e hzT()
    {
      return (e)this.Tsf;
    }
    
    public final boolean hzU()
    {
      return true;
    }
    
    public final aq hzV()
    {
      AppMethodBeat.i(57810);
      aq localaq = f.a(this.Tsf).Trv.Tkm;
      AppMethodBeat.o(57810);
      return localaq;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57811);
      String str = this.Tsf.hAH().sG();
      kotlin.g.b.p.g(str, "name.asString()");
      AppMethodBeat.o(57811);
      return str;
    }
    
    static final class a
      extends q
      implements kotlin.g.a.a<List<? extends as>>
    {
      a(f.b paramb)
      {
        super();
      }
    }
  }
  
  static final class c
    extends q
    implements kotlin.g.a.a<List<? extends as>>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.m.a.i, g>
  {
    d(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.f
 * JD-Core Version:    0.7.0.1
 */