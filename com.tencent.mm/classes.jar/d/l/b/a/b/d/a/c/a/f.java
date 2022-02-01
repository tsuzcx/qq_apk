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
  private static final Set<String> NCv;
  public static final a NCw;
  public final d.l.b.a.b.d.a.c.h NBF;
  public final d.l.b.a.b.d.a.e.g NCb;
  final b NCn;
  private final g NCo;
  private final al<g> NCp;
  private final d.l.b.a.b.j.f.f NCq;
  private final l NCr;
  private final d.l.b.a.b.l.f<List<as>> NCs;
  private final d.l.b.a.b.d.a.c.h NCt;
  private final e NCu;
  private final boolean NrR;
  private final d.l.b.a.b.b.a.g Nsz;
  private final w NuI;
  private final d.l.b.a.b.b.f NuJ;
  private final d.l.b.a.b.b.ba Nvd;
  
  static
  {
    AppMethodBeat.i(57824);
    NCw = new a((byte)0);
    NCv = ak.setOf(new String[] { "equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString" });
    AppMethodBeat.o(57824);
  }
  
  public f(d.l.b.a.b.d.a.c.h paramh, d.l.b.a.b.b.l paraml, d.l.b.a.b.d.a.e.g paramg, e parame)
  {
    super(paramh.NBN.Nnf, paraml, paramg.gnf(), (an)paramh.NBN.NBq.a((d.l.b.a.b.d.a.e.l)paramg));
    AppMethodBeat.i(57823);
    this.NCt = paramh;
    this.NCb = paramg;
    this.NCu = parame;
    this.NBF = d.l.b.a.b.d.a.c.a.a(this.NCt, (d.l.b.a.b.b.g)this, (x)this.NCb, 4);
    this.NBF.NBN.NBn.b(this.NCb);
    boolean bool1 = d.ac.Nhs;
    if (this.NCb.gpm())
    {
      paramh = d.l.b.a.b.b.f.NrA;
      this.NuJ = paramh;
      if ((!this.NCb.gpm()) && (!this.NCb.isEnum())) {
        break label468;
      }
      paramh = w.NrG;
      this.NuI = paramh;
      this.Nvd = this.NCb.gmb();
      if ((this.NCb.gpj() == null) || (this.NCb.fUX())) {
        break label537;
      }
      bool1 = true;
      label220:
      this.NrR = bool1;
      this.NCn = new b();
      paramh = this.NBF;
      paraml = (e)this;
      paramg = this.NCb;
      if (this.NCu == null) {
        break label543;
      }
    }
    label531:
    label537:
    label543:
    for (bool1 = bool3;; bool1 = false)
    {
      this.NCo = new g(paramh, paraml, paramg, bool1);
      paramh = al.Nsa;
      this.NCp = al.a.a((e)this, this.NBF.NBN.Nnf, this.NBF.NBN.NBz.gyJ(), (d.g.a.b)new d(this));
      this.NCq = new d.l.b.a.b.j.f.f((d.l.b.a.b.j.f.h)this.NCo);
      this.NCr = new l(this.NBF, this.NCb, this);
      this.Nsz = d.l.b.a.b.d.a.c.f.a(this.NBF, (d.l.b.a.b.d.a.e.d)this.NCb);
      this.NCs = this.NBF.NBN.Nnf.S((d.g.a.a)new c(this));
      AppMethodBeat.o(57823);
      return;
      if (this.NCb.isInterface())
      {
        paramh = d.l.b.a.b.b.f.Nrx;
        break;
      }
      if (this.NCb.isEnum())
      {
        paramh = d.l.b.a.b.b.f.Nry;
        break;
      }
      paramh = d.l.b.a.b.b.f.Nrw;
      break;
      label468:
      paramh = w.NrL;
      if ((this.NCb.gpo()) || (this.NCb.isInterface()))
      {
        bool1 = true;
        label499:
        if (this.NCb.gpp()) {
          break label531;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        paramh = w.a.bd(bool1, bool2);
        break;
        bool1 = false;
        break label499;
      }
      bool1 = false;
      break label220;
    }
  }
  
  public final d.l.b.a.b.j.f.h glV()
  {
    return (d.l.b.a.b.j.f.h)this.NCr;
  }
  
  public final at glW()
  {
    return (at)this.NCn;
  }
  
  public final e glX()
  {
    return null;
  }
  
  public final d.l.b.a.b.b.f glY()
  {
    return this.NuJ;
  }
  
  public final w glZ()
  {
    return this.NuI;
  }
  
  public final d.l.b.a.b.b.d gma()
  {
    return null;
  }
  
  public final d.l.b.a.b.b.ba gmb()
  {
    AppMethodBeat.i(57815);
    if ((d.g.b.p.i(this.Nvd, az.Nsi)) && (this.NCb.gpj() == null)) {}
    for (d.l.b.a.b.b.ba localba = d.l.b.a.b.d.a.n.Nzw;; localba = this.Nvd)
    {
      d.g.b.p.g(localba, "if (visibility == Visibi…ISIBILITY else visibility");
      AppMethodBeat.o(57815);
      return localba;
    }
  }
  
  public final boolean gmc()
  {
    return false;
  }
  
  public final boolean gmd()
  {
    return this.NrR;
  }
  
  public final boolean gme()
  {
    return false;
  }
  
  public final boolean gmf()
  {
    return false;
  }
  
  public final boolean gmg()
  {
    return false;
  }
  
  public final boolean gmh()
  {
    return false;
  }
  
  public final d.l.b.a.b.b.a.g gmj()
  {
    return this.Nsz;
  }
  
  public final Collection<e> gml()
  {
    return (Collection)d.a.v.NhH;
  }
  
  public final List<as> gmm()
  {
    AppMethodBeat.i(57821);
    List localList = (List)this.NCs.invoke();
    AppMethodBeat.o(57821);
    return localList;
  }
  
  public final d.l.b.a.b.j.f.h gnl()
  {
    return (d.l.b.a.b.j.f.h)this.NCq;
  }
  
  public final g gqm()
  {
    AppMethodBeat.i(57817);
    Object localObject = super.gnk();
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
  
  public final List<d.l.b.a.b.b.d> gqn()
  {
    AppMethodBeat.i(57819);
    List localList = (List)this.NCo.NCA.invoke();
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
    private final d.l.b.a.b.l.f<List<as>> NCx;
    
    public b()
    {
      super();
      AppMethodBeat.i(57812);
      this.NCx = f.a(this$1).NBN.Nnf.S((d.g.a.a)new a(this));
      AppMethodBeat.o(57812);
    }
    
    private final d.l.b.a.b.m.ab gqo()
    {
      AppMethodBeat.i(57809);
      Object localObject1 = this.NCy.gmj();
      Object localObject2 = d.l.b.a.b.d.a.p.NzK;
      d.g.b.p.g(localObject2, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
      localObject1 = ((d.l.b.a.b.b.a.g)localObject1).g((d.l.b.a.b.f.b)localObject2);
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label341;
        }
        if ((((d.l.b.a.b.f.b)localObject1).NNm.NNr.isEmpty()) || (!((d.l.b.a.b.f.b)localObject1).q(d.l.b.a.b.a.g.NmU))) {
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
        localObject2 = d.l.b.a.b.d.a.i.Nzr;
      }
      label284:
      label291:
      label303:
      label316:
      label330:
      label335:
      label341:
      label736:
      for (localObject2 = d.l.b.a.b.d.a.i.m(d.l.b.a.b.j.d.a.o(this.NCy));; localObject2 = localObject1)
      {
        if (localObject2 == null)
        {
          AppMethodBeat.o(57809);
          return null;
          localObject2 = d.a.j.g((Iterable)((d.l.b.a.b.b.a.c)localObject1).gom().values());
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
            localObject1 = d.l.b.a.b.f.i.NND;
            j = ((String)localObject2).length();
            i = 0;
            if (i >= j) {
              break label303;
            }
            char c = ((String)localObject2).charAt(i);
            switch (d.l.b.a.b.f.e.cqt[localObject1.ordinal()])
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
                localObject1 = d.l.b.a.b.f.i.NNE;
                continue;
                if (c != '.') {
                  break label284;
                }
                localObject1 = d.l.b.a.b.f.i.NNF;
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
            if (localObject1 == d.l.b.a.b.f.i.NNF) {
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
        localObject2 = d.l.b.a.b.j.d.a.b(f.a(this.NCy).NBN.NpH, (d.l.b.a.b.f.b)localObject2, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Nym);
        if (localObject2 == null)
        {
          AppMethodBeat.o(57809);
          return null;
        }
        Object localObject3 = ((e)localObject2).glW();
        d.g.b.p.g(localObject3, "classDescriptor.typeConstructor");
        i = ((at)localObject3).getParameters().size();
        localObject3 = ((at)this.NCy.NCn).getParameters();
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
            bh localbh = bh.NZW;
            d.g.b.p.g(localObject4, "parameter");
            ((Collection)localObject1).add(new ax(localbh, (d.l.b.a.b.m.ab)((as)localObject4).gne()));
          }
        }
        for (localObject1 = (List)localObject1;; localObject1 = (List)localObject3)
        {
          localObject3 = d.l.b.a.b.b.a.g.NsU;
          localObject1 = (d.l.b.a.b.m.ab)d.l.b.a.b.m.ac.a(g.a.gon(), (e)localObject2, (List)localObject1);
          AppMethodBeat.o(57809);
          return localObject1;
          if ((j != 1) || (i <= 1) || (localObject1 != null)) {
            break;
          }
          localObject1 = bh.NZW;
          localObject3 = d.a.j.jp((List)localObject3);
          d.g.b.p.g(localObject3, "typeParameters.single()");
          localObject1 = new ax((bh)localObject1, (d.l.b.a.b.m.ab)((as)localObject3).gne());
          localObject4 = (Iterable)new d.k.f(1, i);
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
      List localList = (List)this.NCx.invoke();
      AppMethodBeat.o(57807);
      return localList;
    }
    
    public final Collection<d.l.b.a.b.m.ab> gmp()
    {
      e locale = null;
      AppMethodBeat.i(57808);
      Object localObject1 = this.NCy.NCb.got();
      ArrayList localArrayList = new ArrayList(((Collection)localObject1).size());
      Object localObject2 = new ArrayList(0);
      Object localObject3 = gqo();
      Object localObject4 = ((Collection)localObject1).iterator();
      label181:
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = (d.l.b.a.b.d.a.e.j)((Iterator)localObject4).next();
        localObject5 = f.a(this.NCy).NBM.a((d.l.b.a.b.d.a.e.v)localObject1, d.l.b.a.b.d.a.c.b.d.a(d.l.b.a.b.d.a.a.l.NAM, false, null, 3));
        if ((((d.l.b.a.b.m.ab)localObject5).gxB().gmq() instanceof aa.b)) {
          ((ArrayList)localObject2).add(localObject1);
        }
        at localat = ((d.l.b.a.b.m.ab)localObject5).gxB();
        if (localObject3 != null) {}
        for (localObject1 = ((d.l.b.a.b.m.ab)localObject3).gxB();; localObject1 = null)
        {
          if ((d.g.b.p.i(localat, localObject1)) || (d.l.b.a.b.a.g.z((d.l.b.a.b.m.ab)localObject5))) {
            break label181;
          }
          localArrayList.add(localObject5);
          break;
        }
      }
      localObject4 = (Collection)localArrayList;
      Object localObject5 = f.b(this.NCy);
      localObject1 = locale;
      if (localObject5 != null) {
        localObject1 = d.l.b.a.b.a.b.j.a((e)localObject5, (e)this.NCy).gyG().c((d.l.b.a.b.m.ab)((e)localObject5).gne(), bh.NZW);
      }
      d.l.b.a.b.o.a.c((Collection)localObject4, localObject1);
      d.l.b.a.b.o.a.c((Collection)localArrayList, localObject3);
      if (!((Collection)localObject2).isEmpty())
      {
        i = 1;
        if (i != 0)
        {
          localObject1 = f.a(this.NCy).NBN.NBm;
          locale = (e)this.NCy;
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
          ((Collection)localObject2).add(((d.l.b.a.b.d.a.e.j)localObject4).gpt());
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
      localObject1 = (Collection)d.a.j.listOf(f.a(this.NCy).NBN.NpH.gnF().glF());
      AppMethodBeat.o(57808);
      return localObject1;
    }
    
    public final e gmr()
    {
      return (e)this.NCy;
    }
    
    public final boolean gms()
    {
      return true;
    }
    
    public final aq gmt()
    {
      AppMethodBeat.i(57810);
      aq localaq = f.a(this.NCy).NBN.NuE;
      AppMethodBeat.o(57810);
      return localaq;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57811);
      String str = this.NCy.gnf().sD();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.f
 * JD-Core Version:    0.7.0.1
 */