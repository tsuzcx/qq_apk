package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.aa.b;
import kotlin.l.b.a.b.b.al;
import kotlin.l.b.a.b.b.al.a;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.az;
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
import kotlin.z;

public final class f
  extends kotlin.l.b.a.b.b.c.g
  implements kotlin.l.b.a.b.d.a.b.d
{
  private static final Set<String> aaUW;
  public static final a aaUX;
  private final boolean aaKt;
  private final kotlin.l.b.a.b.b.a.g aaLb;
  private final kotlin.l.b.a.b.b.ba aaNF;
  private final w aaNk;
  private final kotlin.l.b.a.b.b.f aaNl;
  public final kotlin.l.b.a.b.d.a.e.g aaUC;
  final b aaUO;
  private final g aaUP;
  private final al<g> aaUQ;
  private final kotlin.l.b.a.b.j.f.f aaUR;
  private final l aaUS;
  private final kotlin.l.b.a.b.l.f<List<as>> aaUT;
  private final kotlin.l.b.a.b.d.a.c.h aaUU;
  private final kotlin.l.b.a.b.b.e aaUV;
  public final kotlin.l.b.a.b.d.a.c.h aaUh;
  
  static
  {
    AppMethodBeat.i(57824);
    aaUX = new a((byte)0);
    aaUW = ak.setOf(new String[] { "equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString" });
    AppMethodBeat.o(57824);
  }
  
  public f(kotlin.l.b.a.b.d.a.c.h paramh, kotlin.l.b.a.b.b.l paraml, kotlin.l.b.a.b.d.a.e.g paramg, kotlin.l.b.a.b.b.e parame)
  {
    super(paramh.aaUp.aaFH, paraml, paramg.iEU(), (an)paramh.aaUp.aaTS.a((kotlin.l.b.a.b.d.a.e.l)paramg));
    AppMethodBeat.i(57823);
    this.aaUU = paramh;
    this.aaUC = paramg;
    this.aaUV = parame;
    this.aaUh = kotlin.l.b.a.b.d.a.c.a.a(this.aaUU, (kotlin.l.b.a.b.b.g)this, (x)this.aaUC, 4);
    this.aaUh.aaUp.aaTP.b(this.aaUC);
    boolean bool1 = z.aazO;
    if (this.aaUC.iHh())
    {
      paramh = kotlin.l.b.a.b.b.f.aaKc;
      this.aaNl = paramh;
      if ((!this.aaUC.iHh()) && (!this.aaUC.iHi())) {
        break label468;
      }
      paramh = w.aaKi;
      this.aaNk = paramh;
      this.aaNF = this.aaUC.iDQ();
      if ((this.aaUC.iHd() == null) || (this.aaUC.ihW())) {
        break label537;
      }
      bool1 = true;
      label220:
      this.aaKt = bool1;
      this.aaUO = new b();
      paramh = this.aaUh;
      paraml = (kotlin.l.b.a.b.b.e)this;
      paramg = this.aaUC;
      if (this.aaUV == null) {
        break label543;
      }
    }
    label531:
    label537:
    label543:
    for (bool1 = bool3;; bool1 = false)
    {
      this.aaUP = new g(paramh, paraml, paramg, bool1);
      paramh = al.aaKC;
      this.aaUQ = al.a.a((kotlin.l.b.a.b.b.e)this, this.aaUh.aaUp.aaFH, this.aaUh.aaUp.aaUb.iQe(), (kotlin.g.a.b)new d(this));
      this.aaUR = new kotlin.l.b.a.b.j.f.f((kotlin.l.b.a.b.j.f.h)this.aaUP);
      this.aaUS = new l(this.aaUh, this.aaUC, this);
      this.aaLb = kotlin.l.b.a.b.d.a.c.f.a(this.aaUh, (kotlin.l.b.a.b.d.a.e.d)this.aaUC);
      this.aaUT = this.aaUh.aaUp.aaFH.av((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(57823);
      return;
      if (this.aaUC.iHg())
      {
        paramh = kotlin.l.b.a.b.b.f.aaJZ;
        break;
      }
      if (this.aaUC.iHi())
      {
        paramh = kotlin.l.b.a.b.b.f.aaKa;
        break;
      }
      paramh = kotlin.l.b.a.b.b.f.aaJY;
      break;
      label468:
      paramh = w.aaKn;
      if ((this.aaUC.iHk()) || (this.aaUC.iHg()))
      {
        bool1 = true;
        label499:
        if (this.aaUC.iHl()) {
          break label531;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        paramh = w.a.bx(bool1, bool2);
        break;
        bool1 = false;
        break label499;
      }
      bool1 = false;
      break label220;
    }
  }
  
  public final kotlin.l.b.a.b.j.f.h iDK()
  {
    return (kotlin.l.b.a.b.j.f.h)this.aaUS;
  }
  
  public final at iDL()
  {
    return (at)this.aaUO;
  }
  
  public final kotlin.l.b.a.b.b.e iDM()
  {
    return null;
  }
  
  public final kotlin.l.b.a.b.b.f iDN()
  {
    return this.aaNl;
  }
  
  public final w iDO()
  {
    return this.aaNk;
  }
  
  public final kotlin.l.b.a.b.b.d iDP()
  {
    return null;
  }
  
  public final kotlin.l.b.a.b.b.ba iDQ()
  {
    AppMethodBeat.i(57815);
    if ((kotlin.g.b.p.h(this.aaNF, az.aaKK)) && (this.aaUC.iHd() == null)) {}
    for (kotlin.l.b.a.b.b.ba localba = kotlin.l.b.a.b.d.a.n.aaRY;; localba = this.aaNF)
    {
      kotlin.g.b.p.j(localba, "if (visibility == Visibi…ISIBILITY else visibility");
      AppMethodBeat.o(57815);
      return localba;
    }
  }
  
  public final boolean iDR()
  {
    return false;
  }
  
  public final boolean iDS()
  {
    return this.aaKt;
  }
  
  public final boolean iDT()
  {
    return false;
  }
  
  public final boolean iDU()
  {
    return false;
  }
  
  public final boolean iDV()
  {
    return false;
  }
  
  public final boolean iDW()
  {
    return false;
  }
  
  public final kotlin.l.b.a.b.b.a.g iDY()
  {
    return this.aaLb;
  }
  
  public final Collection<kotlin.l.b.a.b.b.e> iEa()
  {
    return (Collection)kotlin.a.v.aaAd;
  }
  
  public final List<as> iEb()
  {
    AppMethodBeat.i(57821);
    List localList = (List)this.aaUT.invoke();
    AppMethodBeat.o(57821);
    return localList;
  }
  
  public final kotlin.l.b.a.b.j.f.h iFa()
  {
    return (kotlin.l.b.a.b.j.f.h)this.aaUR;
  }
  
  public final g iIh()
  {
    AppMethodBeat.i(57817);
    Object localObject = super.iEZ();
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
  
  public final List<kotlin.l.b.a.b.b.d> iIi()
  {
    AppMethodBeat.i(57819);
    List localList = (List)this.aaUP.aaVb.invoke();
    AppMethodBeat.o(57819);
    return localList;
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
    private final kotlin.l.b.a.b.l.f<List<as>> aaUY;
    
    public b()
    {
      super();
      AppMethodBeat.i(57812);
      this.aaUY = f.a(this$1).aaUp.aaFH.av((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(57812);
    }
    
    private final kotlin.l.b.a.b.m.ab iIj()
    {
      AppMethodBeat.i(57809);
      Object localObject1 = this.aaUZ.iDY();
      Object localObject2 = kotlin.l.b.a.b.d.a.p.aaSm;
      kotlin.g.b.p.j(localObject2, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
      localObject1 = ((kotlin.l.b.a.b.b.a.g)localObject1).g((kotlin.l.b.a.b.f.b)localObject2);
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label341;
        }
        if ((((kotlin.l.b.a.b.f.b)localObject1).abfE.abfJ.isEmpty()) || (!((kotlin.l.b.a.b.f.b)localObject1).q(kotlin.l.b.a.b.a.g.aaFw))) {
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
        localObject2 = kotlin.l.b.a.b.d.a.i.aaRT;
      }
      label284:
      label291:
      label303:
      label316:
      label330:
      label335:
      label341:
      label736:
      for (localObject2 = kotlin.l.b.a.b.d.a.i.m(kotlin.l.b.a.b.j.d.a.o(this.aaUZ));; localObject2 = localObject1)
      {
        if (localObject2 == null)
        {
          AppMethodBeat.o(57809);
          return null;
          localObject2 = kotlin.a.j.j((Iterable)((kotlin.l.b.a.b.b.a.c)localObject1).iGd().values());
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
            localObject1 = kotlin.l.b.a.b.f.i.abfV;
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
                localObject1 = kotlin.l.b.a.b.f.i.abfW;
                continue;
                if (c != '.') {
                  break label284;
                }
                localObject1 = kotlin.l.b.a.b.f.i.abfX;
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
            if (localObject1 == kotlin.l.b.a.b.f.i.abfX) {
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
        localObject2 = kotlin.l.b.a.b.j.d.a.b(f.a(this.aaUZ).aaUp.aaIj, (kotlin.l.b.a.b.f.b)localObject2, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.aaQO);
        if (localObject2 == null)
        {
          AppMethodBeat.o(57809);
          return null;
        }
        Object localObject3 = ((kotlin.l.b.a.b.b.e)localObject2).iDL();
        kotlin.g.b.p.j(localObject3, "classDescriptor.typeConstructor");
        i = ((at)localObject3).iCb().size();
        localObject3 = ((at)this.aaUZ.aaUO).iCb();
        kotlin.g.b.p.j(localObject3, "getTypeConstructor().parameters");
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
            bh localbh = bh.abrp;
            kotlin.g.b.p.j(localObject4, "parameter");
            ((Collection)localObject1).add(new ax(localbh, (kotlin.l.b.a.b.m.ab)((as)localObject4).iET()));
          }
        }
        for (localObject1 = (List)localObject1;; localObject1 = (List)localObject3)
        {
          localObject3 = kotlin.l.b.a.b.b.a.g.aaLw;
          localObject1 = (kotlin.l.b.a.b.m.ab)ac.a(g.a.iGe(), (kotlin.l.b.a.b.b.e)localObject2, (List)localObject1);
          AppMethodBeat.o(57809);
          return localObject1;
          if ((j != 1) || (i <= 1) || (localObject1 != null)) {
            break;
          }
          localObject1 = bh.abrp;
          localObject3 = kotlin.a.j.ls((List)localObject3);
          kotlin.g.b.p.j(localObject3, "typeParameters.single()");
          localObject1 = new ax((bh)localObject1, (kotlin.l.b.a.b.m.ab)((as)localObject3).iET());
          localObject4 = (Iterable)new kotlin.k.e(1, i);
          localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            ((kotlin.a.ab)localObject4).zD();
            ((Collection)localObject3).add(localObject1);
          }
        }
        AppMethodBeat.o(57809);
        return null;
      }
    }
    
    public final List<as> iCb()
    {
      AppMethodBeat.i(57807);
      List localList = (List)this.aaUY.invoke();
      AppMethodBeat.o(57807);
      return localList;
    }
    
    public final Collection<kotlin.l.b.a.b.m.ab> iEe()
    {
      kotlin.l.b.a.b.b.e locale = null;
      AppMethodBeat.i(57808);
      Object localObject1 = this.aaUZ.aaUC.iGk();
      ArrayList localArrayList = new ArrayList(((Collection)localObject1).size());
      Object localObject2 = new ArrayList(0);
      Object localObject3 = iIj();
      Object localObject4 = ((Collection)localObject1).iterator();
      label181:
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = (kotlin.l.b.a.b.d.a.e.j)((Iterator)localObject4).next();
        localObject5 = f.a(this.aaUZ).aaUo.a((kotlin.l.b.a.b.d.a.e.v)localObject1, kotlin.l.b.a.b.d.a.c.b.d.a(kotlin.l.b.a.b.d.a.a.l.aaTo, false, null, 3));
        if ((((kotlin.l.b.a.b.m.ab)localObject5).iOU().iEf() instanceof aa.b)) {
          ((ArrayList)localObject2).add(localObject1);
        }
        at localat = ((kotlin.l.b.a.b.m.ab)localObject5).iOU();
        if (localObject3 != null) {}
        for (localObject1 = ((kotlin.l.b.a.b.m.ab)localObject3).iOU();; localObject1 = null)
        {
          if ((kotlin.g.b.p.h(localat, localObject1)) || (kotlin.l.b.a.b.a.g.z((kotlin.l.b.a.b.m.ab)localObject5))) {
            break label181;
          }
          localArrayList.add(localObject5);
          break;
        }
      }
      localObject4 = (Collection)localArrayList;
      Object localObject5 = f.b(this.aaUZ);
      localObject1 = locale;
      if (localObject5 != null) {
        localObject1 = kotlin.l.b.a.b.a.b.j.a((kotlin.l.b.a.b.b.e)localObject5, (kotlin.l.b.a.b.b.e)this.aaUZ).iQb().c((kotlin.l.b.a.b.m.ab)((kotlin.l.b.a.b.b.e)localObject5).iET(), bh.abrp);
      }
      kotlin.l.b.a.b.o.a.c((Collection)localObject4, localObject1);
      kotlin.l.b.a.b.o.a.c((Collection)localArrayList, localObject3);
      if (!((Collection)localObject2).isEmpty())
      {
        i = 1;
        if (i != 0)
        {
          localObject1 = f.a(this.aaUZ).aaUp.aaTO;
          locale = (kotlin.l.b.a.b.b.e)this.aaUZ;
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
          ((Collection)localObject2).add(((kotlin.l.b.a.b.d.a.e.j)localObject4).iHp());
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
      localObject1 = (Collection)kotlin.a.j.listOf(f.a(this.aaUZ).aaUp.aaIj.iFv().iDu());
      AppMethodBeat.o(57808);
      return localObject1;
    }
    
    public final kotlin.l.b.a.b.b.e iEg()
    {
      return (kotlin.l.b.a.b.b.e)this.aaUZ;
    }
    
    public final boolean iEh()
    {
      return true;
    }
    
    public final aq iEi()
    {
      AppMethodBeat.i(57810);
      aq localaq = f.a(this.aaUZ).aaUp.aaNg;
      AppMethodBeat.o(57810);
      return localaq;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57811);
      String str = this.aaUZ.iEU().qu();
      kotlin.g.b.p.j(str, "name.asString()");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.f
 * JD-Core Version:    0.7.0.1
 */