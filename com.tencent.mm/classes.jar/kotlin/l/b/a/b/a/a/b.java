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
import kotlin.l.b.a.b.b.e;
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
  private static final kotlin.l.b.a.b.f.a Tfw;
  private static final kotlin.l.b.a.b.f.a Tfx;
  public static final a Tfy;
  private final kotlin.l.b.a.b.l.j TcN;
  private final b Tfs;
  private final d Tft;
  private final kotlin.l.b.a.b.b.ab Tfu;
  final c Tfv;
  final int arity;
  final List<as> parameters;
  
  static
  {
    AppMethodBeat.i(56733);
    Tfy = new a((byte)0);
    Tfw = new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.g.TcD, kotlin.l.b.a.b.f.f.btY("Function"));
    Tfx = new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.j.hzw(), kotlin.l.b.a.b.f.f.btY("KFunction"));
    AppMethodBeat.o(56733);
  }
  
  public b(final kotlin.l.b.a.b.l.j paramj, kotlin.l.b.a.b.b.ab paramab, c paramc, int paramInt)
  {
    super(paramj, paramc.atQ(paramInt));
    AppMethodBeat.i(56732);
    this.TcN = paramj;
    this.Tfu = paramab;
    this.Tfv = paramc;
    this.arity = paramInt;
    this.Tfs = new b();
    this.Tft = new d(this.TcN, this);
    paramj = new ArrayList();
    paramab = new q(paramj)
    {
      public final void a(bh paramAnonymousbh, String paramAnonymousString)
      {
        AppMethodBeat.i(56717);
        p.h(paramAnonymousbh, "variance");
        p.h(paramAnonymousString, "name");
        ArrayList localArrayList = paramj;
        l locall = (l)this.Tfz;
        g.a locala = kotlin.l.b.a.b.b.a.g.TiC;
        localArrayList.add(ai.a(locall, g.a.hBP(), paramAnonymousbh, kotlin.l.b.a.b.f.f.btY(paramAnonymousString), paramj.size(), b.c(this.Tfz)));
        AppMethodBeat.o(56717);
      }
    };
    Object localObject = (Iterable)new kotlin.k.f(1, this.arity);
    paramc = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramInt = ((kotlin.a.ab)localObject).nextInt();
      paramab.a(bh.TOR, "P".concat(String.valueOf(paramInt)));
      paramc.add(x.SXb);
    }
    paramab.a(bh.TOS, "R");
    this.parameters = kotlin.a.j.p((Iterable)paramj);
    AppMethodBeat.o(56732);
  }
  
  public final kotlin.l.b.a.b.b.f hzB()
  {
    return kotlin.l.b.a.b.b.f.Thf;
  }
  
  public final w hzC()
  {
    return w.Thr;
  }
  
  public final ba hzE()
  {
    AppMethodBeat.i(56728);
    ba localba = az.ThU;
    p.g(localba, "Visibilities.PUBLIC");
    AppMethodBeat.o(56728);
    return localba;
  }
  
  public final boolean hzF()
  {
    return false;
  }
  
  public final boolean hzG()
  {
    return false;
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
    AppMethodBeat.i(56729);
    Object localObject = kotlin.l.b.a.b.b.a.g.TiC;
    localObject = g.a.hBP();
    AppMethodBeat.o(56729);
    return localObject;
  }
  
  public final an hzM()
  {
    AppMethodBeat.i(56730);
    an localan = an.ThK;
    p.g(localan, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(56730);
    return localan;
  }
  
  public final List<as> hzO()
  {
    return this.parameters;
  }
  
  public final at hzz()
  {
    return (at)this.Tfs;
  }
  
  public final boolean isExternal()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56731);
    String str = hAH().sG();
    p.g(str, "name.asString()");
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
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(258511);
      List localList = b.b(this.Tfz);
      AppMethodBeat.o(258511);
      return localList;
    }
    
    public final Collection<kotlin.l.b.a.b.m.ab> hzR()
    {
      AppMethodBeat.i(56719);
      Object localObject1 = this.Tfz.Tfv;
      y localy;
      Object localObject2;
      switch (c.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        localObject1 = new kotlin.m();
        AppMethodBeat.o(56719);
        throw ((Throwable)localObject1);
      case 1: 
        localObject1 = kotlin.a.j.listOf(b.hzP());
        localy = b.a(this.Tfz).hBj();
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
        e locale = s.b(localy, (kotlin.l.b.a.b.f.a)localObject3);
        if (locale == null)
        {
          localObject1 = (Throwable)new IllegalStateException(("Built-in class " + localObject3 + " not found").toString());
          AppMethodBeat.o(56719);
          throw ((Throwable)localObject1);
          localObject1 = kotlin.a.j.listOf(new kotlin.l.b.a.b.f.a[] { b.hzQ(), new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.g.TcD, b.c.TfA.atQ(this.Tfz.arity)) });
          break;
          localObject1 = kotlin.a.j.listOf(b.hzP());
          break;
          localObject1 = kotlin.a.j.listOf(new kotlin.l.b.a.b.f.a[] { b.hzQ(), new kotlin.l.b.a.b.f.a(c.THv, b.c.TfB.atQ(this.Tfz.arity)) });
          break;
        }
        localObject3 = b.b(this.Tfz);
        Object localObject4 = locale.hzz();
        p.g(localObject4, "descriptor.typeConstructor");
        localObject4 = (Iterable)kotlin.a.j.N((List)localObject3, ((at)localObject4).getParameters().size());
        localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(new ax((kotlin.l.b.a.b.m.ab)((as)((Iterator)localObject4).next()).hAG()));
        }
        localObject3 = (List)localObject3;
        localObject4 = kotlin.l.b.a.b.b.a.g.TiC;
        ((Collection)localObject1).add(ac.a(g.a.hBP(), locale, (List)localObject3));
      }
      label441:
      localObject1 = (Collection)kotlin.a.j.p((Iterable)localObject1);
      AppMethodBeat.o(56719);
      return localObject1;
    }
    
    public final boolean hzU()
    {
      return true;
    }
    
    public final aq hzV()
    {
      return (aq)aq.a.ThM;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56721);
      String str = this.Tfz.toString();
      AppMethodBeat.o(56721);
      return str;
    }
  }
  
  public static enum c
  {
    public static final a TfH;
    public final kotlin.l.b.a.b.f.b TfF;
    public final String TfG;
    
    static
    {
      AppMethodBeat.i(56723);
      Object localObject1 = kotlin.l.b.a.b.a.g.TcD;
      p.g(localObject1, "BUILT_INS_PACKAGE_FQ_NAME");
      localObject1 = new c("Function", 0, (kotlin.l.b.a.b.f.b)localObject1, "Function");
      TfA = (c)localObject1;
      Object localObject2 = c.THv;
      p.g(localObject2, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
      localObject2 = new c("SuspendFunction", 1, (kotlin.l.b.a.b.f.b)localObject2, "SuspendFunction");
      TfB = (c)localObject2;
      c localc1 = new c("KFunction", 2, kotlin.l.b.a.b.a.j.hzw(), "KFunction");
      TfC = localc1;
      c localc2 = new c("KSuspendFunction", 3, kotlin.l.b.a.b.a.j.hzw(), "KSuspendFunction");
      TfD = localc2;
      TfE = new c[] { localObject1, localObject2, localc1, localc2 };
      TfH = new a((byte)0);
      AppMethodBeat.o(56723);
    }
    
    private c(kotlin.l.b.a.b.f.b paramb, String paramString)
    {
      this.TfF = paramb;
      this.TfG = paramString;
    }
    
    public final kotlin.l.b.a.b.f.f atQ(int paramInt)
    {
      AppMethodBeat.i(56724);
      kotlin.l.b.a.b.f.f localf = kotlin.l.b.a.b.f.f.btY(this.TfG + paramInt);
      p.g(localf, "Name.identifier(\"$classNamePrefix$arity\")");
      AppMethodBeat.o(56724);
      return localf;
    }
    
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */