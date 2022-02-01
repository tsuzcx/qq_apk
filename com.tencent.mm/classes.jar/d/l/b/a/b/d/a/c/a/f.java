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
  private static final Set<String> JBa;
  public static final a JBb;
  public final d.l.b.a.b.d.a.e.g JAG;
  final b JAS;
  private final g JAT;
  private final al<g> JAU;
  private final d.l.b.a.b.j.f.f JAV;
  private final l JAW;
  private final d.l.b.a.b.l.f<List<as>> JAX;
  private final d.l.b.a.b.d.a.c.h JAY;
  private final e JAZ;
  public final d.l.b.a.b.d.a.c.h JAk;
  private final boolean Jqy;
  private final d.l.b.a.b.b.a.g Jrg;
  private final d.l.b.a.b.b.ba JtI;
  private final w Jtn;
  private final d.l.b.a.b.b.f Jto;
  
  static
  {
    AppMethodBeat.i(57824);
    JBb = new a((byte)0);
    JBa = ak.setOf(new String[] { "equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString" });
    AppMethodBeat.o(57824);
  }
  
  public f(d.l.b.a.b.d.a.c.h paramh, d.l.b.a.b.b.l paraml, d.l.b.a.b.d.a.e.g paramg, e parame)
  {
    super(paramh.JAs.JlL, paraml, paramg.fyB(), (an)paramh.JAs.JzV.a((d.l.b.a.b.d.a.e.l)paramg));
    AppMethodBeat.i(57823);
    this.JAY = paramh;
    this.JAG = paramg;
    this.JAZ = parame;
    this.JAk = d.l.b.a.b.d.a.c.a.a(this.JAY, (d.l.b.a.b.b.g)this, (x)this.JAG, 4);
    this.JAk.JAs.JzS.b(this.JAG);
    boolean bool1 = aa.JfW;
    if (this.JAG.fAH())
    {
      paramh = d.l.b.a.b.b.f.Jqh;
      this.Jto = paramh;
      if ((!this.JAG.fAH()) && (!this.JAG.isEnum())) {
        break label468;
      }
      paramh = w.Jqn;
      this.Jtn = paramh;
      this.JtI = this.JAG.fxx();
      if ((this.JAG.fAE() == null) || (this.JAG.fje())) {
        break label537;
      }
      bool1 = true;
      label220:
      this.Jqy = bool1;
      this.JAS = new b();
      paramh = this.JAk;
      paraml = (e)this;
      paramg = this.JAG;
      if (this.JAZ == null) {
        break label543;
      }
    }
    label531:
    label537:
    label543:
    for (bool1 = bool3;; bool1 = false)
    {
      this.JAT = new g(paramh, paraml, paramg, bool1);
      paramh = al.JqH;
      this.JAU = al.a.a((e)this, this.JAk.JAs.JlL, this.JAk.JAs.JAe.fKd(), (d.g.a.b)new d(this));
      this.JAV = new d.l.b.a.b.j.f.f((d.l.b.a.b.j.f.h)this.JAT);
      this.JAW = new l(this.JAk, this.JAG, this);
      this.Jrg = d.l.b.a.b.d.a.c.f.a(this.JAk, (d.l.b.a.b.d.a.e.d)this.JAG);
      this.JAX = this.JAk.JAs.JlL.H((d.g.a.a)new c(this));
      AppMethodBeat.o(57823);
      return;
      if (this.JAG.isInterface())
      {
        paramh = d.l.b.a.b.b.f.Jqe;
        break;
      }
      if (this.JAG.isEnum())
      {
        paramh = d.l.b.a.b.b.f.Jqf;
        break;
      }
      paramh = d.l.b.a.b.b.f.Jqd;
      break;
      label468:
      paramh = w.Jqs;
      if ((this.JAG.fAJ()) || (this.JAG.isInterface()))
      {
        bool1 = true;
        label499:
        if (this.JAG.fAK()) {
          break label531;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        paramh = w.a.aS(bool1, bool2);
        break;
        bool1 = false;
        break label499;
      }
      bool1 = false;
      break label220;
    }
  }
  
  public final g fBH()
  {
    AppMethodBeat.i(57817);
    Object localObject = super.fyF();
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
  
  public final List<d.l.b.a.b.b.d> fBI()
  {
    AppMethodBeat.i(57819);
    List localList = (List)this.JAT.JBf.invoke();
    AppMethodBeat.o(57819);
    return localList;
  }
  
  public final boolean fxA()
  {
    return false;
  }
  
  public final boolean fxB()
  {
    return false;
  }
  
  public final boolean fxC()
  {
    return false;
  }
  
  public final boolean fxD()
  {
    return false;
  }
  
  public final d.l.b.a.b.b.a.g fxF()
  {
    return this.Jrg;
  }
  
  public final Collection<e> fxH()
  {
    return (Collection)d.a.v.Jgl;
  }
  
  public final List<as> fxI()
  {
    AppMethodBeat.i(57821);
    List localList = (List)this.JAX.invoke();
    AppMethodBeat.o(57821);
    return localList;
  }
  
  public final d.l.b.a.b.j.f.h fxr()
  {
    return (d.l.b.a.b.j.f.h)this.JAW;
  }
  
  public final at fxs()
  {
    return (at)this.JAS;
  }
  
  public final e fxt()
  {
    return null;
  }
  
  public final d.l.b.a.b.b.f fxu()
  {
    return this.Jto;
  }
  
  public final w fxv()
  {
    return this.Jtn;
  }
  
  public final d.l.b.a.b.b.d fxw()
  {
    return null;
  }
  
  public final d.l.b.a.b.b.ba fxx()
  {
    AppMethodBeat.i(57815);
    if ((k.g(this.JtI, az.JqP)) && (this.JAG.fAE() == null)) {}
    for (d.l.b.a.b.b.ba localba = d.l.b.a.b.d.a.n.Jyb;; localba = this.JtI)
    {
      k.g(localba, "if (visibility == Visibi…ISIBILITY else visibility");
      AppMethodBeat.o(57815);
      return localba;
    }
  }
  
  public final boolean fxy()
  {
    return false;
  }
  
  public final boolean fxz()
  {
    return this.Jqy;
  }
  
  public final d.l.b.a.b.j.f.h fyG()
  {
    return (d.l.b.a.b.j.f.h)this.JAV;
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
    private final d.l.b.a.b.l.f<List<as>> JBc;
    
    public b()
    {
      super();
      AppMethodBeat.i(57812);
      this.JBc = f.a(this$1).JAs.JlL.H((d.g.a.a)new a(this));
      AppMethodBeat.o(57812);
    }
    
    private final d.l.b.a.b.m.ab fBJ()
    {
      AppMethodBeat.i(57809);
      Object localObject1 = this.JBd.fxF();
      Object localObject2 = p.Jyp;
      k.g(localObject2, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
      localObject1 = ((d.l.b.a.b.b.a.g)localObject1).g((d.l.b.a.b.f.b)localObject2);
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label341;
        }
        if ((((d.l.b.a.b.f.b)localObject1).JLQ.JLV.isEmpty()) || (!((d.l.b.a.b.f.b)localObject1).q(d.l.b.a.b.a.g.JlA))) {
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
        localObject2 = d.l.b.a.b.d.a.i.JxW;
      }
      label284:
      label291:
      label303:
      label316:
      label330:
      label335:
      label341:
      label736:
      for (localObject2 = d.l.b.a.b.d.a.i.m(d.l.b.a.b.j.d.a.o(this.JBd));; localObject2 = localObject1)
      {
        if (localObject2 == null)
        {
          AppMethodBeat.o(57809);
          return null;
          localObject2 = d.a.j.g((Iterable)((d.l.b.a.b.b.a.c)localObject1).fzH().values());
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
            localObject1 = d.l.b.a.b.f.i.JMh;
            j = ((String)localObject2).length();
            i = 0;
            if (i >= j) {
              break label303;
            }
            char c = ((String)localObject2).charAt(i);
            switch (d.l.b.a.b.f.e.ciE[localObject1.ordinal()])
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
                localObject1 = d.l.b.a.b.f.i.JMi;
                continue;
                if (c != '.') {
                  break label284;
                }
                localObject1 = d.l.b.a.b.f.i.JMj;
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
            if (localObject1 == d.l.b.a.b.f.i.JMj) {
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
        localObject2 = d.l.b.a.b.j.d.a.b(f.a(this.JBd).JAs.Jon, (d.l.b.a.b.f.b)localObject2, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.JwR);
        if (localObject2 == null)
        {
          AppMethodBeat.o(57809);
          return null;
        }
        Object localObject3 = ((e)localObject2).fxs();
        k.g(localObject3, "classDescriptor.typeConstructor");
        i = ((at)localObject3).getParameters().size();
        localObject3 = ((at)this.JBd.JAS).getParameters();
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
            bh localbh = bh.JYC;
            k.g(localObject4, "parameter");
            ((Collection)localObject1).add(new ax(localbh, (d.l.b.a.b.m.ab)((as)localObject4).fyA()));
          }
        }
        for (localObject1 = (List)localObject1;; localObject1 = (List)localObject3)
        {
          localObject3 = d.l.b.a.b.b.a.g.JrB;
          localObject1 = (d.l.b.a.b.m.ab)ac.a(g.a.fzI(), (e)localObject2, (List)localObject1);
          AppMethodBeat.o(57809);
          return localObject1;
          if ((j != 1) || (i <= 1) || (localObject1 != null)) {
            break;
          }
          localObject1 = bh.JYC;
          localObject3 = d.a.j.iC((List)localObject3);
          k.g(localObject3, "typeParameters.single()");
          localObject1 = new ax((bh)localObject1, (d.l.b.a.b.m.ab)((as)localObject3).fyA());
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
    
    public final Collection<d.l.b.a.b.m.ab> fxL()
    {
      e locale = null;
      AppMethodBeat.i(57808);
      Object localObject1 = this.JBd.JAG.fzP();
      ArrayList localArrayList = new ArrayList(((Collection)localObject1).size());
      Object localObject2 = new ArrayList(0);
      Object localObject3 = fBJ();
      Object localObject4 = ((Collection)localObject1).iterator();
      label181:
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = (d.l.b.a.b.d.a.e.j)((Iterator)localObject4).next();
        localObject5 = f.a(this.JBd).JAr.a((d.l.b.a.b.d.a.e.v)localObject1, d.l.b.a.b.d.a.c.b.d.a(d.l.b.a.b.d.a.a.l.Jzr, false, null, 3));
        if ((((d.l.b.a.b.m.ab)localObject5).fIW().fxM() instanceof aa.b)) {
          ((ArrayList)localObject2).add(localObject1);
        }
        at localat = ((d.l.b.a.b.m.ab)localObject5).fIW();
        if (localObject3 != null) {}
        for (localObject1 = ((d.l.b.a.b.m.ab)localObject3).fIW();; localObject1 = null)
        {
          if ((k.g(localat, localObject1)) || (d.l.b.a.b.a.g.z((d.l.b.a.b.m.ab)localObject5))) {
            break label181;
          }
          localArrayList.add(localObject5);
          break;
        }
      }
      localObject4 = (Collection)localArrayList;
      Object localObject5 = f.b(this.JBd);
      localObject1 = locale;
      if (localObject5 != null) {
        localObject1 = d.l.b.a.b.a.b.j.a((e)localObject5, (e)this.JBd).fKa().c((d.l.b.a.b.m.ab)((e)localObject5).fyA(), bh.JYC);
      }
      d.l.b.a.b.o.a.c((Collection)localObject4, localObject1);
      d.l.b.a.b.o.a.c((Collection)localArrayList, localObject3);
      if (!((Collection)localObject2).isEmpty())
      {
        i = 1;
        if (i != 0)
        {
          localObject1 = f.a(this.JBd).JAs.JzR;
          locale = (e)this.JBd;
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
          ((Collection)localObject2).add(((d.l.b.a.b.d.a.e.j)localObject4).fAO());
        }
        label402:
        ((r)localObject1).a(locale, (List)localObject2);
      }
      if (!((Collection)localArrayList).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = (Collection)d.a.j.m((Iterable)localArrayList);
        AppMethodBeat.o(57808);
        return localObject1;
      }
      localObject1 = (Collection)d.a.j.listOf(f.a(this.JBd).JAs.Jon.fza().fxb());
      AppMethodBeat.o(57808);
      return localObject1;
    }
    
    public final e fxN()
    {
      return (e)this.JBd;
    }
    
    public final boolean fxO()
    {
      return true;
    }
    
    public final aq fxP()
    {
      AppMethodBeat.i(57810);
      aq localaq = f.a(this.JBd).JAs.Jtj;
      AppMethodBeat.o(57810);
      return localaq;
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(57807);
      List localList = (List)this.JBc.invoke();
      AppMethodBeat.o(57807);
      return localList;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57811);
      String str = this.JBd.fyB().qV();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.f
 * JD-Core Version:    0.7.0.1
 */