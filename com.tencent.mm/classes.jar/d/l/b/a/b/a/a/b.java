package d.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.aq;
import d.l.b.a.b.b.aq.a;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.c.ai;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.s;
import d.l.b.a.b.b.w;
import d.l.b.a.b.b.y;
import d.l.b.a.b.j.c;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.ax;
import d.l.b.a.b.m.bh;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class b
  extends d.l.b.a.b.b.c.a
{
  private static final d.l.b.a.b.f.a NpO;
  private static final d.l.b.a.b.f.a NpP;
  public static final a NpQ;
  private final d.l.b.a.b.l.j Nnf;
  private final b NpK;
  private final d NpL;
  private final d.l.b.a.b.b.ab NpM;
  final c NpN;
  final int arity;
  final List<as> parameters;
  
  static
  {
    AppMethodBeat.i(56733);
    NpQ = new a((byte)0);
    NpO = new d.l.b.a.b.f.a(d.l.b.a.b.a.g.NmV, d.l.b.a.b.f.f.bei("Function"));
    NpP = new d.l.b.a.b.f.a(d.l.b.a.b.a.j.glT(), d.l.b.a.b.f.f.bei("KFunction"));
    AppMethodBeat.o(56733);
  }
  
  public b(final d.l.b.a.b.l.j paramj, d.l.b.a.b.b.ab paramab, c paramc, int paramInt)
  {
    super(paramj, paramc.aka(paramInt));
    AppMethodBeat.i(56732);
    this.Nnf = paramj;
    this.NpM = paramab;
    this.NpN = paramc;
    this.arity = paramInt;
    this.NpK = new b();
    this.NpL = new d(this.Nnf, this);
    paramj = new ArrayList();
    paramab = new q(paramj)
    {
      public final void a(bh paramAnonymousbh, String paramAnonymousString)
      {
        AppMethodBeat.i(56717);
        p.h(paramAnonymousbh, "variance");
        p.h(paramAnonymousString, "name");
        ArrayList localArrayList = paramj;
        l locall = (l)this.NpR;
        g.a locala = d.l.b.a.b.b.a.g.NsU;
        localArrayList.add(ai.a(locall, g.a.gon(), paramAnonymousbh, d.l.b.a.b.f.f.bei(paramAnonymousString), paramj.size(), b.c(this.NpR)));
        AppMethodBeat.o(56717);
      }
    };
    Object localObject = (Iterable)new d.k.f(1, this.arity);
    paramc = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramInt = ((d.a.ab)localObject).nextInt();
      paramab.a(bh.NZX, "P".concat(String.valueOf(paramInt)));
      paramc.add(z.Nhr);
    }
    paramab.a(bh.NZY, "R");
    this.parameters = d.a.j.l((Iterable)paramj);
    AppMethodBeat.o(56732);
  }
  
  public final at glW()
  {
    return (at)this.NpK;
  }
  
  public final d.l.b.a.b.b.f glY()
  {
    return d.l.b.a.b.b.f.Nrx;
  }
  
  public final w glZ()
  {
    return w.NrJ;
  }
  
  public final ba gmb()
  {
    AppMethodBeat.i(56728);
    ba localba = az.Nsm;
    p.g(localba, "Visibilities.PUBLIC");
    AppMethodBeat.o(56728);
    return localba;
  }
  
  public final boolean gmc()
  {
    return false;
  }
  
  public final boolean gmd()
  {
    return false;
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
  
  public final boolean gmi()
  {
    return false;
  }
  
  public final d.l.b.a.b.b.a.g gmj()
  {
    AppMethodBeat.i(56729);
    Object localObject = d.l.b.a.b.b.a.g.NsU;
    localObject = g.a.gon();
    AppMethodBeat.o(56729);
    return localObject;
  }
  
  public final an gmk()
  {
    AppMethodBeat.i(56730);
    an localan = an.Nsc;
    p.g(localan, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(56730);
    return localan;
  }
  
  public final List<as> gmm()
  {
    return this.parameters;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56731);
    String str = gnf().sD();
    p.g(str, "name.asString()");
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
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(224202);
      List localList = b.b(this.NpR);
      AppMethodBeat.o(224202);
      return localList;
    }
    
    public final Collection<d.l.b.a.b.m.ab> gmp()
    {
      AppMethodBeat.i(56719);
      Object localObject1 = this.NpR.NpN;
      y localy;
      Object localObject2;
      switch (c.cqt[localObject1.ordinal()])
      {
      default: 
        localObject1 = new d.m();
        AppMethodBeat.o(56719);
        throw ((Throwable)localObject1);
      case 1: 
        localObject1 = d.a.j.listOf(b.gmn());
        localy = b.a(this.NpR).gnH();
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
          localObject1 = d.a.j.listOf(new d.l.b.a.b.f.a[] { b.gmo(), new d.l.b.a.b.f.a(d.l.b.a.b.a.g.NmV, b.c.NpS.aka(this.NpR.arity)) });
          break;
          localObject1 = d.a.j.listOf(b.gmn());
          break;
          localObject1 = d.a.j.listOf(new d.l.b.a.b.f.a[] { b.gmo(), new d.l.b.a.b.f.a(c.NSz, b.c.NpT.aka(this.NpR.arity)) });
          break;
        }
        localObject3 = b.b(this.NpR);
        Object localObject4 = locale.glW();
        p.g(localObject4, "descriptor.typeConstructor");
        localObject4 = (Iterable)d.a.j.G((List)localObject3, ((at)localObject4).getParameters().size());
        localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(new ax((d.l.b.a.b.m.ab)((as)((Iterator)localObject4).next()).gne()));
        }
        localObject3 = (List)localObject3;
        localObject4 = d.l.b.a.b.b.a.g.NsU;
        ((Collection)localObject1).add(ac.a(g.a.gon(), locale, (List)localObject3));
      }
      label441:
      localObject1 = (Collection)d.a.j.l((Iterable)localObject1);
      AppMethodBeat.o(56719);
      return localObject1;
    }
    
    public final boolean gms()
    {
      return true;
    }
    
    public final aq gmt()
    {
      return (aq)aq.a.Nse;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56721);
      String str = this.NpR.toString();
      AppMethodBeat.o(56721);
      return str;
    }
  }
  
  public static enum c
  {
    public static final a NpZ;
    public final d.l.b.a.b.f.b NpX;
    public final String NpY;
    
    static
    {
      AppMethodBeat.i(56723);
      Object localObject1 = d.l.b.a.b.a.g.NmV;
      p.g(localObject1, "BUILT_INS_PACKAGE_FQ_NAME");
      localObject1 = new c("Function", 0, (d.l.b.a.b.f.b)localObject1, "Function");
      NpS = (c)localObject1;
      Object localObject2 = c.NSz;
      p.g(localObject2, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
      localObject2 = new c("SuspendFunction", 1, (d.l.b.a.b.f.b)localObject2, "SuspendFunction");
      NpT = (c)localObject2;
      c localc1 = new c("KFunction", 2, d.l.b.a.b.a.j.glT(), "KFunction");
      NpU = localc1;
      c localc2 = new c("KSuspendFunction", 3, d.l.b.a.b.a.j.glT(), "KSuspendFunction");
      NpV = localc2;
      NpW = new c[] { localObject1, localObject2, localc1, localc2 };
      NpZ = new a((byte)0);
      AppMethodBeat.o(56723);
    }
    
    private c(d.l.b.a.b.f.b paramb, String paramString)
    {
      this.NpX = paramb;
      this.NpY = paramString;
    }
    
    public final d.l.b.a.b.f.f aka(int paramInt)
    {
      AppMethodBeat.i(56724);
      d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.bei(this.NpY + paramInt);
      p.g(localf, "Name.identifier(\"$classNamePrefix$arity\")");
      AppMethodBeat.o(56724);
      return localf;
    }
    
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */