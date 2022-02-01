package d.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.aq;
import d.l.b.a.b.b.aq.a;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.c.ai;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.s;
import d.l.b.a.b.b.w;
import d.l.b.a.b.j.c;
import d.l.b.a.b.l.i;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.ax;
import d.l.b.a.b.m.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class b
  extends d.l.b.a.b.b.c.a
{
  private static final d.l.b.a.b.f.a Jou;
  private static final d.l.b.a.b.f.a Jov;
  public static final a Jow;
  private final i JlL;
  private final b Joq;
  private final d Jor;
  private final d.l.b.a.b.b.ab Jos;
  final c Jot;
  final int arity;
  final List<as> parameters;
  
  static
  {
    AppMethodBeat.i(56733);
    Jow = new a((byte)0);
    Jou = new d.l.b.a.b.f.a(d.l.b.a.b.a.g.JlB, d.l.b.a.b.f.f.aQC("Function"));
    Jov = new d.l.b.a.b.f.a(d.l.b.a.b.a.j.fxp(), d.l.b.a.b.f.f.aQC("KFunction"));
    AppMethodBeat.o(56733);
  }
  
  public b(final i parami, d.l.b.a.b.b.ab paramab, c paramc, int paramInt)
  {
    super(parami, paramc.adT(paramInt));
    AppMethodBeat.i(56732);
    this.JlL = parami;
    this.Jos = paramab;
    this.Jot = paramc;
    this.arity = paramInt;
    this.Joq = new b();
    this.Jor = new d(this.JlL, this);
    parami = new ArrayList();
    paramab = new d.g.b.l(parami)
    {
      public final void a(bh paramAnonymousbh, String paramAnonymousString)
      {
        AppMethodBeat.i(56717);
        k.h(paramAnonymousbh, "variance");
        k.h(paramAnonymousString, "name");
        ArrayList localArrayList = parami;
        d.l.b.a.b.b.l locall = (d.l.b.a.b.b.l)this.Jox;
        g.a locala = d.l.b.a.b.b.a.g.JrB;
        localArrayList.add(ai.a(locall, g.a.fzI(), paramAnonymousbh, d.l.b.a.b.f.f.aQC(paramAnonymousString), parami.size()));
        AppMethodBeat.o(56717);
      }
    };
    Object localObject = (Iterable)new d.k.d(1, this.arity);
    paramc = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramInt = ((d.a.ab)localObject).nextInt();
      paramab.a(bh.JYD, "P".concat(String.valueOf(paramInt)));
      paramc.add(d.y.JfV);
    }
    paramab.a(bh.JYE, "R");
    this.parameters = d.a.j.m((Iterable)parami);
    AppMethodBeat.o(56732);
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
  
  public final boolean fxE()
  {
    return false;
  }
  
  public final d.l.b.a.b.b.a.g fxF()
  {
    AppMethodBeat.i(56729);
    Object localObject = d.l.b.a.b.b.a.g.JrB;
    localObject = g.a.fzI();
    AppMethodBeat.o(56729);
    return localObject;
  }
  
  public final an fxG()
  {
    AppMethodBeat.i(56730);
    an localan = an.JqJ;
    k.g(localan, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(56730);
    return localan;
  }
  
  public final List<as> fxI()
  {
    return this.parameters;
  }
  
  public final at fxs()
  {
    return (at)this.Joq;
  }
  
  public final d.l.b.a.b.b.f fxu()
  {
    return d.l.b.a.b.b.f.Jqe;
  }
  
  public final w fxv()
  {
    return w.Jqq;
  }
  
  public final ba fxx()
  {
    AppMethodBeat.i(56728);
    ba localba = az.JqT;
    k.g(localba, "Visibilities.PUBLIC");
    AppMethodBeat.o(56728);
    return localba;
  }
  
  public final boolean fxy()
  {
    return false;
  }
  
  public final boolean fxz()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56731);
    String str = fyB().qV();
    k.g(str, "name.asString()");
    AppMethodBeat.o(56731);
    return str;
  }
  
  public static final class a {}
  
  final class b
    extends d.l.b.a.b.m.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(56722);
      AppMethodBeat.o(56722);
    }
    
    public final Collection<d.l.b.a.b.m.ab> fxL()
    {
      AppMethodBeat.i(56719);
      Object localObject1 = this.Jox.Jot;
      d.l.b.a.b.b.y localy;
      Object localObject2;
      switch (c.ciE[localObject1.ordinal()])
      {
      default: 
        localObject1 = new d.m();
        AppMethodBeat.o(56719);
        throw ((Throwable)localObject1);
      case 1: 
        localObject1 = d.a.j.listOf(b.fxJ());
        localy = b.a(this.Jox).fzc();
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label441;
        }
        Object localObject3 = (d.l.b.a.b.f.a)((Iterator)localObject2).next();
        e locale = s.b(localy, (d.l.b.a.b.f.a)localObject3);
        if (locale == null)
        {
          localObject1 = (Throwable)new IllegalStateException(("Built-in class " + localObject3 + " not found").toString());
          AppMethodBeat.o(56719);
          throw ((Throwable)localObject1);
          localObject1 = d.a.j.listOf(new d.l.b.a.b.f.a[] { b.fxK(), new d.l.b.a.b.f.a(d.l.b.a.b.a.g.JlB, b.c.Joz.adT(this.Jox.arity)) });
          break;
          localObject1 = d.a.j.listOf(b.fxJ());
          break;
          localObject1 = d.a.j.listOf(new d.l.b.a.b.f.a[] { b.fxK(), new d.l.b.a.b.f.a(c.JRb, b.c.JoA.adT(this.Jox.arity)) });
          break;
        }
        localObject3 = b.b(this.Jox);
        Object localObject4 = locale.fxs();
        k.g(localObject4, "descriptor.typeConstructor");
        localObject4 = (Iterable)d.a.j.D((List)localObject3, ((at)localObject4).getParameters().size());
        localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(new ax((d.l.b.a.b.m.ab)((as)((Iterator)localObject4).next()).fyA()));
        }
        localObject3 = (List)localObject3;
        localObject4 = d.l.b.a.b.b.a.g.JrB;
        ((Collection)localObject1).add(ac.a(g.a.fzI(), locale, (List)localObject3));
      }
      label441:
      localObject1 = (Collection)d.a.j.m((Iterable)localObject1);
      AppMethodBeat.o(56719);
      return localObject1;
    }
    
    public final boolean fxO()
    {
      return true;
    }
    
    public final aq fxP()
    {
      return (aq)aq.a.JqL;
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(202316);
      List localList = b.b(this.Jox);
      AppMethodBeat.o(202316);
      return localList;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56721);
      String str = this.Jox.toString();
      AppMethodBeat.o(56721);
      return str;
    }
  }
  
  public static enum c
  {
    public static final a JoG;
    public final d.l.b.a.b.f.b JoE;
    public final String JoF;
    
    static
    {
      AppMethodBeat.i(56723);
      Object localObject1 = d.l.b.a.b.a.g.JlB;
      k.g(localObject1, "BUILT_INS_PACKAGE_FQ_NAME");
      localObject1 = new c("Function", 0, (d.l.b.a.b.f.b)localObject1, "Function");
      Joz = (c)localObject1;
      Object localObject2 = c.JRb;
      k.g(localObject2, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
      localObject2 = new c("SuspendFunction", 1, (d.l.b.a.b.f.b)localObject2, "SuspendFunction");
      JoA = (c)localObject2;
      c localc1 = new c("KFunction", 2, d.l.b.a.b.a.j.fxp(), "KFunction");
      JoB = localc1;
      c localc2 = new c("KSuspendFunction", 3, d.l.b.a.b.a.j.fxp(), "KSuspendFunction");
      JoC = localc2;
      JoD = new c[] { localObject1, localObject2, localc1, localc2 };
      JoG = new a((byte)0);
      AppMethodBeat.o(56723);
    }
    
    private c(d.l.b.a.b.f.b paramb, String paramString)
    {
      this.JoE = paramb;
      this.JoF = paramString;
    }
    
    public final d.l.b.a.b.f.f adT(int paramInt)
    {
      AppMethodBeat.i(56724);
      d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.aQC(this.JoF + paramInt);
      k.g(localf, "Name.identifier(\"$classNamePrefix$arity\")");
      AppMethodBeat.o(56724);
      return localf;
    }
    
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */