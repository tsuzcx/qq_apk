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
  private static final d.l.b.a.b.f.a MSJ;
  private static final d.l.b.a.b.f.a MSK;
  public static final a MSL;
  private final d.l.b.a.b.l.j MQa;
  private final b MSF;
  private final d MSG;
  private final d.l.b.a.b.b.ab MSH;
  final c MSI;
  final int arity;
  final List<as> parameters;
  
  static
  {
    AppMethodBeat.i(56733);
    MSL = new a((byte)0);
    MSJ = new d.l.b.a.b.f.a(d.l.b.a.b.a.g.MPQ, d.l.b.a.b.f.f.bcE("Function"));
    MSK = new d.l.b.a.b.f.a(d.l.b.a.b.a.j.ghr(), d.l.b.a.b.f.f.bcE("KFunction"));
    AppMethodBeat.o(56733);
  }
  
  public b(final d.l.b.a.b.l.j paramj, d.l.b.a.b.b.ab paramab, c paramc, int paramInt)
  {
    super(paramj, paramc.ajq(paramInt));
    AppMethodBeat.i(56732);
    this.MQa = paramj;
    this.MSH = paramab;
    this.MSI = paramc;
    this.arity = paramInt;
    this.MSF = new b();
    this.MSG = new d(this.MQa, this);
    paramj = new ArrayList();
    paramab = new q(paramj)
    {
      public final void a(bh paramAnonymousbh, String paramAnonymousString)
      {
        AppMethodBeat.i(56717);
        p.h(paramAnonymousbh, "variance");
        p.h(paramAnonymousString, "name");
        ArrayList localArrayList = paramj;
        l locall = (l)this.MSM;
        g.a locala = d.l.b.a.b.b.a.g.MVP;
        localArrayList.add(ai.a(locall, g.a.gjL(), paramAnonymousbh, d.l.b.a.b.f.f.bcE(paramAnonymousString), paramj.size(), b.c(this.MSM)));
        AppMethodBeat.o(56717);
      }
    };
    Object localObject = (Iterable)new d.k.d(1, this.arity);
    paramc = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramInt = ((d.a.ab)localObject).nextInt();
      paramab.a(bh.NCQ, "P".concat(String.valueOf(paramInt)));
      paramc.add(z.MKo);
    }
    paramab.a(bh.NCR, "R");
    this.parameters = d.a.j.l((Iterable)paramj);
    AppMethodBeat.o(56732);
  }
  
  public final boolean ghA()
  {
    return false;
  }
  
  public final boolean ghB()
  {
    return false;
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
  
  public final boolean ghG()
  {
    return false;
  }
  
  public final d.l.b.a.b.b.a.g ghH()
  {
    AppMethodBeat.i(56729);
    Object localObject = d.l.b.a.b.b.a.g.MVP;
    localObject = g.a.gjL();
    AppMethodBeat.o(56729);
    return localObject;
  }
  
  public final an ghI()
  {
    AppMethodBeat.i(56730);
    an localan = an.MUX;
    p.g(localan, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(56730);
    return localan;
  }
  
  public final List<as> ghK()
  {
    return this.parameters;
  }
  
  public final at ghu()
  {
    return (at)this.MSF;
  }
  
  public final d.l.b.a.b.b.f ghw()
  {
    return d.l.b.a.b.b.f.MUs;
  }
  
  public final w ghx()
  {
    return w.MUE;
  }
  
  public final ba ghz()
  {
    AppMethodBeat.i(56728);
    ba localba = az.MVh;
    p.g(localba, "Visibilities.PUBLIC");
    AppMethodBeat.o(56728);
    return localba;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56731);
    String str = giD().sD();
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
      AppMethodBeat.i(221689);
      List localList = b.b(this.MSM);
      AppMethodBeat.o(221689);
      return localList;
    }
    
    public final Collection<d.l.b.a.b.m.ab> ghN()
    {
      AppMethodBeat.i(56719);
      Object localObject1 = this.MSM.MSI;
      y localy;
      Object localObject2;
      switch (c.cpQ[localObject1.ordinal()])
      {
      default: 
        localObject1 = new d.m();
        AppMethodBeat.o(56719);
        throw ((Throwable)localObject1);
      case 1: 
        localObject1 = d.a.j.listOf(b.ghL());
        localy = b.a(this.MSM).gjf();
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
          localObject1 = d.a.j.listOf(new d.l.b.a.b.f.a[] { b.ghM(), new d.l.b.a.b.f.a(d.l.b.a.b.a.g.MPQ, b.c.MSN.ajq(this.MSM.arity)) });
          break;
          localObject1 = d.a.j.listOf(b.ghL());
          break;
          localObject1 = d.a.j.listOf(new d.l.b.a.b.f.a[] { b.ghM(), new d.l.b.a.b.f.a(c.Nvt, b.c.MSO.ajq(this.MSM.arity)) });
          break;
        }
        localObject3 = b.b(this.MSM);
        Object localObject4 = locale.ghu();
        p.g(localObject4, "descriptor.typeConstructor");
        localObject4 = (Iterable)d.a.j.F((List)localObject3, ((at)localObject4).getParameters().size());
        localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(new ax((d.l.b.a.b.m.ab)((as)((Iterator)localObject4).next()).giC()));
        }
        localObject3 = (List)localObject3;
        localObject4 = d.l.b.a.b.b.a.g.MVP;
        ((Collection)localObject1).add(ac.a(g.a.gjL(), locale, (List)localObject3));
      }
      label441:
      localObject1 = (Collection)d.a.j.l((Iterable)localObject1);
      AppMethodBeat.o(56719);
      return localObject1;
    }
    
    public final boolean ghQ()
    {
      return true;
    }
    
    public final aq ghR()
    {
      return (aq)aq.a.MUZ;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56721);
      String str = this.MSM.toString();
      AppMethodBeat.o(56721);
      return str;
    }
  }
  
  public static enum c
  {
    public static final a MSU;
    public final d.l.b.a.b.f.b MSS;
    public final String MST;
    
    static
    {
      AppMethodBeat.i(56723);
      Object localObject1 = d.l.b.a.b.a.g.MPQ;
      p.g(localObject1, "BUILT_INS_PACKAGE_FQ_NAME");
      localObject1 = new c("Function", 0, (d.l.b.a.b.f.b)localObject1, "Function");
      MSN = (c)localObject1;
      Object localObject2 = c.Nvt;
      p.g(localObject2, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
      localObject2 = new c("SuspendFunction", 1, (d.l.b.a.b.f.b)localObject2, "SuspendFunction");
      MSO = (c)localObject2;
      c localc1 = new c("KFunction", 2, d.l.b.a.b.a.j.ghr(), "KFunction");
      MSP = localc1;
      c localc2 = new c("KSuspendFunction", 3, d.l.b.a.b.a.j.ghr(), "KSuspendFunction");
      MSQ = localc2;
      MSR = new c[] { localObject1, localObject2, localc1, localc2 };
      MSU = new a((byte)0);
      AppMethodBeat.o(56723);
    }
    
    private c(d.l.b.a.b.f.b paramb, String paramString)
    {
      this.MSS = paramb;
      this.MST = paramString;
    }
    
    public final d.l.b.a.b.f.f ajq(int paramInt)
    {
      AppMethodBeat.i(56724);
      d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.bcE(this.MST + paramInt);
      p.g(localf, "Name.identifier(\"$classNamePrefix$arity\")");
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