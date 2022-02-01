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
  private static final d.l.b.a.b.f.a LbO;
  private static final d.l.b.a.b.f.a LbP;
  public static final a LbQ;
  private final i KZf;
  private final b LbK;
  private final d LbL;
  private final d.l.b.a.b.b.ab LbM;
  final c LbN;
  final int arity;
  final List<as> parameters;
  
  static
  {
    AppMethodBeat.i(56733);
    LbQ = new a((byte)0);
    LbO = new d.l.b.a.b.f.a(d.l.b.a.b.a.g.KYV, d.l.b.a.b.f.f.aWB("Function"));
    LbP = new d.l.b.a.b.f.a(d.l.b.a.b.a.j.fPT(), d.l.b.a.b.f.f.aWB("KFunction"));
    AppMethodBeat.o(56733);
  }
  
  public b(final i parami, d.l.b.a.b.b.ab paramab, c paramc, int paramInt)
  {
    super(parami, paramc.agP(paramInt));
    AppMethodBeat.i(56732);
    this.KZf = parami;
    this.LbM = paramab;
    this.LbN = paramc;
    this.arity = paramInt;
    this.LbK = new b();
    this.LbL = new d(this.KZf, this);
    parami = new ArrayList();
    paramab = new d.g.b.l(parami)
    {
      public final void a(bh paramAnonymousbh, String paramAnonymousString)
      {
        AppMethodBeat.i(56717);
        k.h(paramAnonymousbh, "variance");
        k.h(paramAnonymousString, "name");
        ArrayList localArrayList = parami;
        d.l.b.a.b.b.l locall = (d.l.b.a.b.b.l)this.LbR;
        g.a locala = d.l.b.a.b.b.a.g.LeU;
        localArrayList.add(ai.a(locall, g.a.fSm(), paramAnonymousbh, d.l.b.a.b.f.f.aWB(paramAnonymousString), parami.size()));
        AppMethodBeat.o(56717);
      }
    };
    Object localObject = (Iterable)new d.k.d(1, this.arity);
    paramc = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramInt = ((d.a.ab)localObject).nextInt();
      paramab.a(bh.LLW, "P".concat(String.valueOf(paramInt)));
      paramc.add(d.y.KTp);
    }
    paramab.a(bh.LLX, "R");
    this.parameters = d.a.j.l((Iterable)parami);
    AppMethodBeat.o(56732);
  }
  
  public final at fPW()
  {
    return (at)this.LbK;
  }
  
  public final d.l.b.a.b.b.f fPY()
  {
    return d.l.b.a.b.b.f.Ldx;
  }
  
  public final w fPZ()
  {
    return w.LdJ;
  }
  
  public final ba fQb()
  {
    AppMethodBeat.i(56728);
    ba localba = az.Lem;
    k.g(localba, "Visibilities.PUBLIC");
    AppMethodBeat.o(56728);
    return localba;
  }
  
  public final boolean fQc()
  {
    return false;
  }
  
  public final boolean fQd()
  {
    return false;
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
  
  public final boolean fQi()
  {
    return false;
  }
  
  public final d.l.b.a.b.b.a.g fQj()
  {
    AppMethodBeat.i(56729);
    Object localObject = d.l.b.a.b.b.a.g.LeU;
    localObject = g.a.fSm();
    AppMethodBeat.o(56729);
    return localObject;
  }
  
  public final an fQk()
  {
    AppMethodBeat.i(56730);
    an localan = an.Lec;
    k.g(localan, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(56730);
    return localan;
  }
  
  public final List<as> fQm()
  {
    return this.parameters;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56731);
    String str = fRf().rf();
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
    
    public final Collection<d.l.b.a.b.m.ab> fQp()
    {
      AppMethodBeat.i(56719);
      Object localObject1 = this.LbR.LbN;
      d.l.b.a.b.b.y localy;
      Object localObject2;
      switch (c.cfA[localObject1.ordinal()])
      {
      default: 
        localObject1 = new d.m();
        AppMethodBeat.o(56719);
        throw ((Throwable)localObject1);
      case 1: 
        localObject1 = d.a.j.listOf(b.fQn());
        localy = b.a(this.LbR).fRG();
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
          localObject1 = d.a.j.listOf(new d.l.b.a.b.f.a[] { b.fQo(), new d.l.b.a.b.f.a(d.l.b.a.b.a.g.KYV, b.c.LbS.agP(this.LbR.arity)) });
          break;
          localObject1 = d.a.j.listOf(b.fQn());
          break;
          localObject1 = d.a.j.listOf(new d.l.b.a.b.f.a[] { b.fQo(), new d.l.b.a.b.f.a(c.LEu, b.c.LbT.agP(this.LbR.arity)) });
          break;
        }
        localObject3 = b.b(this.LbR);
        Object localObject4 = locale.fPW();
        k.g(localObject4, "descriptor.typeConstructor");
        localObject4 = (Iterable)d.a.j.D((List)localObject3, ((at)localObject4).getParameters().size());
        localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(new ax((d.l.b.a.b.m.ab)((as)((Iterator)localObject4).next()).fRe()));
        }
        localObject3 = (List)localObject3;
        localObject4 = d.l.b.a.b.b.a.g.LeU;
        ((Collection)localObject1).add(ac.a(g.a.fSm(), locale, (List)localObject3));
      }
      label441:
      localObject1 = (Collection)d.a.j.l((Iterable)localObject1);
      AppMethodBeat.o(56719);
      return localObject1;
    }
    
    public final boolean fQs()
    {
      return true;
    }
    
    public final aq fQt()
    {
      return (aq)aq.a.Lee;
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(210232);
      List localList = b.b(this.LbR);
      AppMethodBeat.o(210232);
      return localList;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56721);
      String str = this.LbR.toString();
      AppMethodBeat.o(56721);
      return str;
    }
  }
  
  public static enum c
  {
    public static final a LbZ;
    public final d.l.b.a.b.f.b LbX;
    public final String LbY;
    
    static
    {
      AppMethodBeat.i(56723);
      Object localObject1 = d.l.b.a.b.a.g.KYV;
      k.g(localObject1, "BUILT_INS_PACKAGE_FQ_NAME");
      localObject1 = new c("Function", 0, (d.l.b.a.b.f.b)localObject1, "Function");
      LbS = (c)localObject1;
      Object localObject2 = c.LEu;
      k.g(localObject2, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
      localObject2 = new c("SuspendFunction", 1, (d.l.b.a.b.f.b)localObject2, "SuspendFunction");
      LbT = (c)localObject2;
      c localc1 = new c("KFunction", 2, d.l.b.a.b.a.j.fPT(), "KFunction");
      LbU = localc1;
      c localc2 = new c("KSuspendFunction", 3, d.l.b.a.b.a.j.fPT(), "KSuspendFunction");
      LbV = localc2;
      LbW = new c[] { localObject1, localObject2, localc1, localc2 };
      LbZ = new a((byte)0);
      AppMethodBeat.o(56723);
    }
    
    private c(d.l.b.a.b.f.b paramb, String paramString)
    {
      this.LbX = paramb;
      this.LbY = paramString;
    }
    
    public final d.l.b.a.b.f.f agP(int paramInt)
    {
      AppMethodBeat.i(56724);
      d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.aWB(this.LbY + paramInt);
      k.g(localf, "Name.identifier(\"$classNamePrefix$arity\")");
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