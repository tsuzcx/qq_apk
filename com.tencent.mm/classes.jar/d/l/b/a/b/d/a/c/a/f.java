package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.g.b.q;
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
import d.l.b.a.b.k.a.r;
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
  private static final Set<String> Nfq;
  public static final a Nfr;
  private final boolean MUM;
  private final d.l.b.a.b.b.a.g MVu;
  private final w MXC;
  private final d.l.b.a.b.b.f MXD;
  private final d.l.b.a.b.b.ba MXX;
  public final d.l.b.a.b.d.a.c.h NeA;
  public final d.l.b.a.b.d.a.e.g NeW;
  final b Nfi;
  private final g Nfj;
  private final al<g> Nfk;
  private final d.l.b.a.b.j.f.f Nfl;
  private final l Nfm;
  private final d.l.b.a.b.l.f<List<as>> Nfn;
  private final d.l.b.a.b.d.a.c.h Nfo;
  private final e Nfp;
  
  static
  {
    AppMethodBeat.i(57824);
    Nfr = new a((byte)0);
    Nfq = ak.setOf(new String[] { "equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString" });
    AppMethodBeat.o(57824);
  }
  
  public f(d.l.b.a.b.d.a.c.h paramh, d.l.b.a.b.b.l paraml, d.l.b.a.b.d.a.e.g paramg, e parame)
  {
    super(paramh.NeI.MQa, paraml, paramg.giD(), (an)paramh.NeI.Nel.a((d.l.b.a.b.d.a.e.l)paramg));
    AppMethodBeat.i(57823);
    this.Nfo = paramh;
    this.NeW = paramg;
    this.Nfp = parame;
    this.NeA = d.l.b.a.b.d.a.c.a.a(this.Nfo, (d.l.b.a.b.b.g)this, (x)this.NeW, 4);
    this.NeA.NeI.Nei.b(this.NeW);
    boolean bool1 = d.ac.MKp;
    if (this.NeW.gkK())
    {
      paramh = d.l.b.a.b.b.f.MUv;
      this.MXD = paramh;
      if ((!this.NeW.gkK()) && (!this.NeW.isEnum())) {
        break label468;
      }
      paramh = w.MUB;
      this.MXC = paramh;
      this.MXX = this.NeW.ghz();
      if ((this.NeW.gkH() == null) || (this.NeW.fQB())) {
        break label537;
      }
      bool1 = true;
      label220:
      this.MUM = bool1;
      this.Nfi = new b();
      paramh = this.NeA;
      paraml = (e)this;
      paramg = this.NeW;
      if (this.Nfp == null) {
        break label543;
      }
    }
    label531:
    label537:
    label543:
    for (bool1 = bool3;; bool1 = false)
    {
      this.Nfj = new g(paramh, paraml, paramg, bool1);
      paramh = al.MUV;
      this.Nfk = al.a.a((e)this, this.NeA.NeI.MQa, this.NeA.NeI.Neu.guh(), (d.g.a.b)new d(this));
      this.Nfl = new d.l.b.a.b.j.f.f((d.l.b.a.b.j.f.h)this.Nfj);
      this.Nfm = new l(this.NeA, this.NeW, this);
      this.MVu = d.l.b.a.b.d.a.c.f.a(this.NeA, (d.l.b.a.b.d.a.e.d)this.NeW);
      this.Nfn = this.NeA.NeI.MQa.S((d.g.a.a)new c(this));
      AppMethodBeat.o(57823);
      return;
      if (this.NeW.isInterface())
      {
        paramh = d.l.b.a.b.b.f.MUs;
        break;
      }
      if (this.NeW.isEnum())
      {
        paramh = d.l.b.a.b.b.f.MUt;
        break;
      }
      paramh = d.l.b.a.b.b.f.MUr;
      break;
      label468:
      paramh = w.MUG;
      if ((this.NeW.gkM()) || (this.NeW.isInterface()))
      {
        bool1 = true;
        label499:
        if (this.NeW.gkN()) {
          break label531;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        paramh = w.a.be(bool1, bool2);
        break;
        bool1 = false;
        break label499;
      }
      bool1 = false;
      break label220;
    }
  }
  
  public final boolean ghA()
  {
    return false;
  }
  
  public final boolean ghB()
  {
    return this.MUM;
  }
  
  public final boolean ghC()
  {
    return false;
  }
  
  public final boolean ghD()
  {
    return false;
  }
  
  public final boolean ghE()
  {
    return false;
  }
  
  public final boolean ghF()
  {
    return false;
  }
  
  public final d.l.b.a.b.b.a.g ghH()
  {
    return this.MVu;
  }
  
  public final Collection<e> ghJ()
  {
    return (Collection)d.a.v.MKE;
  }
  
  public final List<as> ghK()
  {
    AppMethodBeat.i(57821);
    List localList = (List)this.Nfn.invoke();
    AppMethodBeat.o(57821);
    return localList;
  }
  
  public final d.l.b.a.b.j.f.h ght()
  {
    return (d.l.b.a.b.j.f.h)this.Nfm;
  }
  
  public final at ghu()
  {
    return (at)this.Nfi;
  }
  
  public final e ghv()
  {
    return null;
  }
  
  public final d.l.b.a.b.b.f ghw()
  {
    return this.MXD;
  }
  
  public final w ghx()
  {
    return this.MXC;
  }
  
  public final d.l.b.a.b.b.d ghy()
  {
    return null;
  }
  
  public final d.l.b.a.b.b.ba ghz()
  {
    AppMethodBeat.i(57815);
    if ((d.g.b.p.i(this.MXX, az.MVd)) && (this.NeW.gkH() == null)) {}
    for (d.l.b.a.b.b.ba localba = d.l.b.a.b.d.a.n.Ncr;; localba = this.MXX)
    {
      d.g.b.p.g(localba, "if (visibility == Visibi…ISIBILITY else visibility");
      AppMethodBeat.o(57815);
      return localba;
    }
  }
  
  public final d.l.b.a.b.j.f.h giJ()
  {
    return (d.l.b.a.b.j.f.h)this.Nfl;
  }
  
  public final g glK()
  {
    AppMethodBeat.i(57817);
    Object localObject = super.giI();
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
  
  public final List<d.l.b.a.b.b.d> glL()
  {
    AppMethodBeat.i(57819);
    List localList = (List)this.Nfj.Nfv.invoke();
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
    private final d.l.b.a.b.l.f<List<as>> Nfs;
    
    public b()
    {
      super();
      AppMethodBeat.i(57812);
      this.Nfs = f.a(this$1).NeI.MQa.S((d.g.a.a)new a(this));
      AppMethodBeat.o(57812);
    }
    
    private final d.l.b.a.b.m.ab glM()
    {
      AppMethodBeat.i(57809);
      Object localObject1 = this.Nft.ghH();
      Object localObject2 = d.l.b.a.b.d.a.p.NcF;
      d.g.b.p.g(localObject2, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
      localObject1 = ((d.l.b.a.b.b.a.g)localObject1).g((d.l.b.a.b.f.b)localObject2);
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label341;
        }
        if ((((d.l.b.a.b.f.b)localObject1).Nqg.Nql.isEmpty()) || (!((d.l.b.a.b.f.b)localObject1).q(d.l.b.a.b.a.g.MPP))) {
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
        localObject2 = d.l.b.a.b.d.a.i.Ncm;
      }
      label284:
      label291:
      label303:
      label316:
      label330:
      label335:
      label341:
      label736:
      for (localObject2 = d.l.b.a.b.d.a.i.m(d.l.b.a.b.j.d.a.o(this.Nft));; localObject2 = localObject1)
      {
        if (localObject2 == null)
        {
          AppMethodBeat.o(57809);
          return null;
          localObject2 = d.a.j.g((Iterable)((d.l.b.a.b.b.a.c)localObject1).gjK().values());
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
            localObject1 = d.l.b.a.b.f.i.Nqx;
            j = ((String)localObject2).length();
            i = 0;
            if (i >= j) {
              break label303;
            }
            char c = ((String)localObject2).charAt(i);
            switch (d.l.b.a.b.f.e.cpQ[localObject1.ordinal()])
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
                localObject1 = d.l.b.a.b.f.i.Nqy;
                continue;
                if (c != '.') {
                  break label284;
                }
                localObject1 = d.l.b.a.b.f.i.Nqz;
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
            if (localObject1 == d.l.b.a.b.f.i.Nqz) {
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
        localObject2 = d.l.b.a.b.j.d.a.b(f.a(this.Nft).NeI.MSC, (d.l.b.a.b.f.b)localObject2, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Nbh);
        if (localObject2 == null)
        {
          AppMethodBeat.o(57809);
          return null;
        }
        Object localObject3 = ((e)localObject2).ghu();
        d.g.b.p.g(localObject3, "classDescriptor.typeConstructor");
        i = ((at)localObject3).getParameters().size();
        localObject3 = ((at)this.Nft.Nfi).getParameters();
        d.g.b.p.g(localObject3, "getTypeConstructor().parameters");
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
            bh localbh = bh.NCP;
            d.g.b.p.g(localObject4, "parameter");
            ((Collection)localObject1).add(new ax(localbh, (d.l.b.a.b.m.ab)((as)localObject4).giC()));
          }
        }
        for (localObject1 = (List)localObject1;; localObject1 = (List)localObject3)
        {
          localObject3 = d.l.b.a.b.b.a.g.MVP;
          localObject1 = (d.l.b.a.b.m.ab)d.l.b.a.b.m.ac.a(g.a.gjL(), (e)localObject2, (List)localObject1);
          AppMethodBeat.o(57809);
          return localObject1;
          if ((j != 1) || (i <= 1) || (localObject1 != null)) {
            break;
          }
          localObject1 = bh.NCP;
          localObject3 = d.a.j.jg((List)localObject3);
          d.g.b.p.g(localObject3, "typeParameters.single()");
          localObject1 = new ax((bh)localObject1, (d.l.b.a.b.m.ab)((as)localObject3).giC());
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
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(57807);
      List localList = (List)this.Nfs.invoke();
      AppMethodBeat.o(57807);
      return localList;
    }
    
    public final Collection<d.l.b.a.b.m.ab> ghN()
    {
      e locale = null;
      AppMethodBeat.i(57808);
      Object localObject1 = this.Nft.NeW.gjR();
      ArrayList localArrayList = new ArrayList(((Collection)localObject1).size());
      Object localObject2 = new ArrayList(0);
      Object localObject3 = glM();
      Object localObject4 = ((Collection)localObject1).iterator();
      label181:
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = (d.l.b.a.b.d.a.e.j)((Iterator)localObject4).next();
        localObject5 = f.a(this.Nft).NeH.a((d.l.b.a.b.d.a.e.v)localObject1, d.l.b.a.b.d.a.c.b.d.a(d.l.b.a.b.d.a.a.l.NdH, false, null, 3));
        if ((((d.l.b.a.b.m.ab)localObject5).gsZ().ghO() instanceof aa.b)) {
          ((ArrayList)localObject2).add(localObject1);
        }
        at localat = ((d.l.b.a.b.m.ab)localObject5).gsZ();
        if (localObject3 != null) {}
        for (localObject1 = ((d.l.b.a.b.m.ab)localObject3).gsZ();; localObject1 = null)
        {
          if ((d.g.b.p.i(localat, localObject1)) || (d.l.b.a.b.a.g.z((d.l.b.a.b.m.ab)localObject5))) {
            break label181;
          }
          localArrayList.add(localObject5);
          break;
        }
      }
      localObject4 = (Collection)localArrayList;
      Object localObject5 = f.b(this.Nft);
      localObject1 = locale;
      if (localObject5 != null) {
        localObject1 = d.l.b.a.b.a.b.j.a((e)localObject5, (e)this.Nft).gue().c((d.l.b.a.b.m.ab)((e)localObject5).giC(), bh.NCP);
      }
      d.l.b.a.b.o.a.c((Collection)localObject4, localObject1);
      d.l.b.a.b.o.a.c((Collection)localArrayList, localObject3);
      if (!((Collection)localObject2).isEmpty())
      {
        i = 1;
        if (i != 0)
        {
          localObject1 = f.a(this.Nft).NeI.Neh;
          locale = (e)this.Nft;
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
          ((Collection)localObject2).add(((d.l.b.a.b.d.a.e.j)localObject4).gkR());
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
      localObject1 = (Collection)d.a.j.listOf(f.a(this.Nft).NeI.MSC.gjd().ghd());
      AppMethodBeat.o(57808);
      return localObject1;
    }
    
    public final e ghP()
    {
      return (e)this.Nft;
    }
    
    public final boolean ghQ()
    {
      return true;
    }
    
    public final aq ghR()
    {
      AppMethodBeat.i(57810);
      aq localaq = f.a(this.Nft).NeI.MXy;
      AppMethodBeat.o(57810);
      return localaq;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57811);
      String str = this.Nft.giD().sD();
      d.g.b.p.g(str, "name.asString()");
      AppMethodBeat.o(57811);
      return str;
    }
    
    static final class a
      extends q
      implements d.g.a.a<List<? extends as>>
    {
      a(f.b paramb)
      {
        super();
      }
    }
  }
  
  static final class c
    extends q
    implements d.g.a.a<List<? extends as>>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements d.g.a.b<d.l.b.a.b.m.a.i, g>
  {
    d(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.f
 * JD-Core Version:    0.7.0.1
 */