package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.aq.a;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ai;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bh;
import kotlin.x;

public final class b
  extends kotlin.l.b.a.b.b.c.a
{
  private static final kotlin.l.b.a.b.f.a aaIq;
  private static final kotlin.l.b.a.b.f.a aaIr;
  public static final a aaIs;
  private final kotlin.l.b.a.b.l.j aaFH;
  private final b aaIm;
  private final d aaIn;
  private final kotlin.l.b.a.b.b.ab aaIo;
  final c aaIp;
  final int arity;
  final List<as> parameters;
  
  static
  {
    AppMethodBeat.i(56733);
    aaIs = new a((byte)0);
    aaIq = new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.g.aaFx, kotlin.l.b.a.b.f.f.bHb("Function"));
    aaIr = new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.j.iDI(), kotlin.l.b.a.b.f.f.bHb("KFunction"));
    AppMethodBeat.o(56733);
  }
  
  public b(final kotlin.l.b.a.b.l.j paramj, kotlin.l.b.a.b.b.ab paramab, c paramc, int paramInt)
  {
    super(paramj, paramc.aDK(paramInt));
    AppMethodBeat.i(56732);
    this.aaFH = paramj;
    this.aaIo = paramab;
    this.aaIp = paramc;
    this.arity = paramInt;
    this.aaIm = new b();
    this.aaIn = new d(this.aaFH, this);
    paramj = new ArrayList();
    paramab = new q(paramj)
    {
      public final void a(bh paramAnonymousbh, String paramAnonymousString)
      {
        AppMethodBeat.i(56717);
        p.k(paramAnonymousbh, "variance");
        p.k(paramAnonymousString, "name");
        ArrayList localArrayList = paramj;
        l locall = (l)this.aaIt;
        g.a locala = kotlin.l.b.a.b.b.a.g.aaLw;
        localArrayList.add(ai.a(locall, g.a.iGe(), paramAnonymousbh, kotlin.l.b.a.b.f.f.bHb(paramAnonymousString), paramj.size(), b.c(this.aaIt)));
        AppMethodBeat.o(56717);
      }
    };
    Object localObject = (Iterable)new kotlin.k.e(1, this.arity);
    paramc = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramInt = ((kotlin.a.ab)localObject).zD();
      paramab.a(bh.abrq, "P".concat(String.valueOf(paramInt)));
      paramc.add(x.aazN);
    }
    paramab.a(bh.abrr, "R");
    this.parameters = kotlin.a.j.p((Iterable)paramj);
    AppMethodBeat.o(56732);
  }
  
  public final at iDL()
  {
    return (at)this.aaIm;
  }
  
  public final kotlin.l.b.a.b.b.f iDN()
  {
    return kotlin.l.b.a.b.b.f.aaJZ;
  }
  
  public final w iDO()
  {
    return w.aaKl;
  }
  
  public final ba iDQ()
  {
    AppMethodBeat.i(56728);
    ba localba = az.aaKO;
    p.j(localba, "Visibilities.PUBLIC");
    AppMethodBeat.o(56728);
    return localba;
  }
  
  public final boolean iDR()
  {
    return false;
  }
  
  public final boolean iDS()
  {
    return false;
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
  
  public final boolean iDX()
  {
    return false;
  }
  
  public final kotlin.l.b.a.b.b.a.g iDY()
  {
    AppMethodBeat.i(56729);
    Object localObject = kotlin.l.b.a.b.b.a.g.aaLw;
    localObject = g.a.iGe();
    AppMethodBeat.o(56729);
    return localObject;
  }
  
  public final an iDZ()
  {
    AppMethodBeat.i(56730);
    an localan = an.aaKE;
    p.j(localan, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(56730);
    return localan;
  }
  
  public final List<as> iEb()
  {
    return this.parameters;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56731);
    String str = iEU().qu();
    p.j(str, "name.asString()");
    AppMethodBeat.o(56731);
    return str;
  }
  
  public static final class a {}
  
  final class b
    extends kotlin.l.b.a.b.m.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(56722);
      AppMethodBeat.o(56722);
    }
    
    public final List<as> iCb()
    {
      AppMethodBeat.i(292925);
      List localList = b.b(this.aaIt);
      AppMethodBeat.o(292925);
      return localList;
    }
    
    public final Collection<kotlin.l.b.a.b.m.ab> iEe()
    {
      AppMethodBeat.i(56719);
      Object localObject1 = this.aaIt.aaIp;
      y localy;
      Object localObject2;
      switch (c.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        localObject1 = new kotlin.m();
        AppMethodBeat.o(56719);
        throw ((Throwable)localObject1);
      case 1: 
        localObject1 = kotlin.a.j.listOf(b.iEc());
        localy = b.a(this.aaIt).iFx();
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label441;
        }
        Object localObject3 = (kotlin.l.b.a.b.f.a)((Iterator)localObject2).next();
        kotlin.l.b.a.b.b.e locale = s.b(localy, (kotlin.l.b.a.b.f.a)localObject3);
        if (locale == null)
        {
          localObject1 = (Throwable)new IllegalStateException(("Built-in class " + localObject3 + " not found").toString());
          AppMethodBeat.o(56719);
          throw ((Throwable)localObject1);
          localObject1 = kotlin.a.j.listOf(new kotlin.l.b.a.b.f.a[] { b.iEd(), new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.g.aaFx, b.c.aaIu.aDK(this.aaIt.arity)) });
          break;
          localObject1 = kotlin.a.j.listOf(b.iEc());
          break;
          localObject1 = kotlin.a.j.listOf(new kotlin.l.b.a.b.f.a[] { b.iEd(), new kotlin.l.b.a.b.f.a(c.abjZ, b.c.aaIv.aDK(this.aaIt.arity)) });
          break;
        }
        localObject3 = b.b(this.aaIt);
        Object localObject4 = locale.iDL();
        p.j(localObject4, "descriptor.typeConstructor");
        localObject4 = (Iterable)kotlin.a.j.O((List)localObject3, ((at)localObject4).iCb().size());
        localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(new ax((kotlin.l.b.a.b.m.ab)((as)((Iterator)localObject4).next()).iET()));
        }
        localObject3 = (List)localObject3;
        localObject4 = kotlin.l.b.a.b.b.a.g.aaLw;
        ((Collection)localObject1).add(ac.a(g.a.iGe(), locale, (List)localObject3));
      }
      label441:
      localObject1 = (Collection)kotlin.a.j.p((Iterable)localObject1);
      AppMethodBeat.o(56719);
      return localObject1;
    }
    
    public final boolean iEh()
    {
      return true;
    }
    
    public final aq iEi()
    {
      return (aq)aq.a.aaKG;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56721);
      String str = this.aaIt.toString();
      AppMethodBeat.o(56721);
      return str;
    }
  }
  
  public static enum c
  {
    public static final a aaIB;
    public final String aaIA;
    public final kotlin.l.b.a.b.f.b aaIz;
    
    static
    {
      AppMethodBeat.i(56723);
      Object localObject1 = kotlin.l.b.a.b.a.g.aaFx;
      p.j(localObject1, "BUILT_INS_PACKAGE_FQ_NAME");
      localObject1 = new c("Function", 0, (kotlin.l.b.a.b.f.b)localObject1, "Function");
      aaIu = (c)localObject1;
      Object localObject2 = c.abjZ;
      p.j(localObject2, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
      localObject2 = new c("SuspendFunction", 1, (kotlin.l.b.a.b.f.b)localObject2, "SuspendFunction");
      aaIv = (c)localObject2;
      c localc1 = new c("KFunction", 2, kotlin.l.b.a.b.a.j.iDI(), "KFunction");
      aaIw = localc1;
      c localc2 = new c("KSuspendFunction", 3, kotlin.l.b.a.b.a.j.iDI(), "KSuspendFunction");
      aaIx = localc2;
      aaIy = new c[] { localObject1, localObject2, localc1, localc2 };
      aaIB = new a((byte)0);
      AppMethodBeat.o(56723);
    }
    
    private c(kotlin.l.b.a.b.f.b paramb, String paramString)
    {
      this.aaIz = paramb;
      this.aaIA = paramString;
    }
    
    public final kotlin.l.b.a.b.f.f aDK(int paramInt)
    {
      AppMethodBeat.i(56724);
      kotlin.l.b.a.b.f.f localf = kotlin.l.b.a.b.f.f.bHb(this.aaIA + paramInt);
      p.j(localf, "Name.identifier(\"$classNamePrefix$arity\")");
      AppMethodBeat.o(56724);
      return localf;
    }
    
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */