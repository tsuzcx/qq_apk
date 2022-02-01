package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.o;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.am;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.y;

public abstract class d
  extends k
  implements ar
{
  protected List<? extends as> Tka;
  private final c Tkb;
  protected final kotlin.l.b.a.b.b.ba Tkc;
  
  public d(l paraml, kotlin.l.b.a.b.b.a.g paramg, f paramf, an paraman, kotlin.l.b.a.b.b.ba paramba)
  {
    super(paraml, paramg, paramf, paraman);
    this.Tkc = paramba;
    this.Tkb = new c(this);
  }
  
  private ar hBS()
  {
    o localo = super.hBT();
    if (localo == null) {
      throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
    }
    return (ar)localo;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    kotlin.g.b.p.h(paramn, "visitor");
    return paramn.a((ar)this, paramD);
  }
  
  protected abstract j hAI();
  
  public final Collection<ag> hBR()
  {
    Object localObject1 = hBx();
    if (localObject1 == null) {
      return (Collection)v.SXr;
    }
    localObject1 = ((e)localObject1).hxW();
    kotlin.g.b.p.g(localObject1, "classDescriptor.constructors");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (kotlin.l.b.a.b.b.d)localIterator.next();
      localObject1 = ah.Tmo;
      Object localObject2 = hAI();
      ar localar = (ar)this;
      kotlin.g.b.p.g(localObject3, "it");
      kotlin.g.b.p.h(localObject2, "storageManager");
      kotlin.g.b.p.h(localar, "typeAliasDescriptor");
      kotlin.g.b.p.h(localObject3, "constructor");
      localObject1 = ah.a.a(localar);
      if (localObject1 == null) {
        localObject1 = null;
      }
      label131:
      Object localObject5;
      Object localObject4;
      for (;;)
      {
        if (localObject1 != null)
        {
          localCollection.add(localObject1);
          break;
          localObject5 = ((kotlin.l.b.a.b.b.d)localObject3).a((kotlin.l.b.a.b.m.ba)localObject1);
          if (localObject5 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject4 = ((kotlin.l.b.a.b.b.d)localObject3).hzL();
            Object localObject6 = ((kotlin.l.b.a.b.b.d)localObject3).hAA();
            kotlin.g.b.p.g(localObject6, "constructor.kind");
            an localan = localar.hzM();
            kotlin.g.b.p.g(localan, "typeAliasDescriptor.source");
            localObject2 = new ah((j)localObject2, localar, (kotlin.l.b.a.b.b.d)localObject5, null, (kotlin.l.b.a.b.b.a.g)localObject4, (b.a)localObject6, localan, (byte)0);
            localObject4 = (kotlin.l.b.a.b.b.t)localObject2;
            localObject6 = ((kotlin.l.b.a.b.b.d)localObject3).hAw();
            if (localObject6 == null) {
              p.atM(26);
            }
            if (localObject1 == null) {
              p.atM(27);
            }
            localObject4 = p.a((kotlin.l.b.a.b.b.t)localObject4, (List)localObject6, (kotlin.l.b.a.b.m.ba)localObject1, false, false, null);
            if (localObject4 == null)
            {
              localObject1 = null;
            }
            else
            {
              kotlin.g.b.p.g(localObject4, "FunctionDescriptorImpl.g…         ) ?: return null");
              localObject5 = y.an((ab)((kotlin.l.b.a.b.b.d)localObject5).hAu().hLF());
              localObject6 = localar.hAG();
              kotlin.g.b.p.g(localObject6, "typeAliasDescriptor.defaultType");
              localObject5 = am.b((aj)localObject5, (aj)localObject6);
              localObject6 = ((kotlin.l.b.a.b.b.d)localObject3).hAs();
              if (localObject6 == null) {
                break label437;
              }
              localObject3 = (kotlin.l.b.a.b.b.a)localObject2;
              kotlin.g.b.p.g(localObject6, "it");
              localObject1 = ((kotlin.l.b.a.b.m.ba)localObject1).b(((ak)localObject6).hBy(), bh.TOQ);
              localObject6 = kotlin.l.b.a.b.b.a.g.TiC;
            }
          }
        }
      }
      label437:
      for (localObject1 = kotlin.l.b.a.b.j.b.a((kotlin.l.b.a.b.b.a)localObject3, (ab)localObject1, g.a.hBP());; localObject1 = null)
      {
        ((ah)localObject2).a((ak)localObject1, null, localar.hzO(), (List)localObject4, (ab)localObject5, w.Tho, localar.hzE());
        localObject1 = (ag)localObject2;
        break label131;
        break;
      }
    }
    return (Collection)localCollection;
  }
  
  protected abstract List<as> hBU();
  
  public final w hzC()
  {
    return w.Tho;
  }
  
  public final kotlin.l.b.a.b.b.ba hzE()
  {
    return this.Tkc;
  }
  
  public final boolean hzG()
  {
    return bc.b((ab)hBv(), (kotlin.g.a.b)new b(this));
  }
  
  public final boolean hzJ()
  {
    return false;
  }
  
  public final boolean hzK()
  {
    return false;
  }
  
  public final List<as> hzO()
  {
    List localList = this.Tka;
    if (localList == null) {
      kotlin.g.b.p.btv("declaredTypeParametersImpl");
    }
    return localList;
  }
  
  public final at hzz()
  {
    return (at)this.Tkb;
  }
  
  public final boolean isExternal()
  {
    return false;
  }
  
  public String toString()
  {
    return "typealias " + hAH().sG();
  }
  
  public static final class a
    extends q
    implements kotlin.g.a.b<i, aj>
  {
    public a(d paramd)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements kotlin.g.a.b<bg, Boolean>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  public static final class c
    implements at
  {
    public final List<as> getParameters()
    {
      AppMethodBeat.i(56998);
      List localList = this.Tkd.hBU();
      AppMethodBeat.o(56998);
      return localList;
    }
    
    public final Collection<ab> hBV()
    {
      AppMethodBeat.i(56999);
      Collection localCollection = ((ar)this.Tkd).hBv().hKE().hBV();
      kotlin.g.b.p.g(localCollection, "declarationDescriptor.un…pe.constructor.supertypes");
      AppMethodBeat.o(56999);
      return localCollection;
    }
    
    public final kotlin.l.b.a.b.a.g hBh()
    {
      AppMethodBeat.i(57000);
      kotlin.l.b.a.b.a.g localg = kotlin.l.b.a.b.j.d.a.G((l)this.Tkd);
      AppMethodBeat.o(57000);
      return localg;
    }
    
    public final boolean hzU()
    {
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57001);
      String str = "[typealias " + ((ar)this.Tkd).hAH().sG() + ']';
      AppMethodBeat.o(57001);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.d
 * JD-Core Version:    0.7.0.1
 */