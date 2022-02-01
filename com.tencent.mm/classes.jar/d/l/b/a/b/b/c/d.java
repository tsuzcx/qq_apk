package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.n;
import d.l.b.a.b.b.o;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.w;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.am;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class d
  extends k
  implements ar
{
  protected List<? extends as> Lgq;
  private final c Lgr;
  protected final d.l.b.a.b.b.ba Lgs;
  
  public d(d.l.b.a.b.b.l paraml, d.l.b.a.b.b.a.g paramg, f paramf, an paraman, d.l.b.a.b.b.ba paramba)
  {
    super(paraml, paramg, paramf, paraman);
    this.Lgs = paramba;
    this.Lgr = new c(this);
  }
  
  private ar fSq()
  {
    o localo = super.fSr();
    if (localo == null) {
      throw new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
    }
    return (ar)localo;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    d.g.b.k.h(paramn, "visitor");
    return paramn.a((ar)this, paramD);
  }
  
  public final at fPW()
  {
    return (at)this.Lgr;
  }
  
  public final w fPZ()
  {
    return w.LdG;
  }
  
  public final d.l.b.a.b.b.ba fQb()
  {
    return this.Lgs;
  }
  
  public final boolean fQd()
  {
    return bc.b((ab)fRS(), (d.g.a.b)new b(this));
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
  
  public final List<as> fQm()
  {
    List localList = this.Lgq;
    if (localList == null) {
      d.g.b.k.aVY("declaredTypeParametersImpl");
    }
    return localList;
  }
  
  protected abstract d.l.b.a.b.l.i fSo();
  
  public final Collection<ag> fSp()
  {
    Object localObject1 = fRU();
    if (localObject1 == null) {
      return (Collection)d.a.v.KTF;
    }
    localObject1 = ((e)localObject1).fOv();
    d.g.b.k.g(localObject1, "classDescriptor.constructors");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (d.l.b.a.b.b.d)localIterator.next();
      localObject1 = ah.LiE;
      Object localObject2 = fSo();
      ar localar = (ar)this;
      d.g.b.k.g(localObject3, "it");
      d.g.b.k.h(localObject2, "storageManager");
      d.g.b.k.h(localar, "typeAliasDescriptor");
      d.g.b.k.h(localObject3, "constructor");
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
          localObject5 = ((d.l.b.a.b.b.d)localObject3).a((d.l.b.a.b.m.ba)localObject1);
          if (localObject5 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject4 = ((d.l.b.a.b.b.d)localObject3).fQj();
            Object localObject6 = ((d.l.b.a.b.b.d)localObject3).fQY();
            d.g.b.k.g(localObject6, "constructor.kind");
            an localan = localar.fQk();
            d.g.b.k.g(localan, "typeAliasDescriptor.source");
            localObject2 = new ah((d.l.b.a.b.l.i)localObject2, localar, (d.l.b.a.b.b.d)localObject5, null, (d.l.b.a.b.b.a.g)localObject4, (b.a)localObject6, localan, (byte)0);
            localObject4 = (t)localObject2;
            localObject6 = ((d.l.b.a.b.b.d)localObject3).fQU();
            if (localObject6 == null) {
              p.agL(26);
            }
            if (localObject1 == null) {
              p.agL(27);
            }
            localObject4 = p.a((t)localObject4, (List)localObject6, (d.l.b.a.b.m.ba)localObject1, false, false, null);
            if (localObject4 == null)
            {
              localObject1 = null;
            }
            else
            {
              d.g.b.k.g(localObject4, "FunctionDescriptorImpl.g…         ) ?: return null");
              localObject5 = y.ao((ab)((d.l.b.a.b.b.d)localObject5).fQS().gcz());
              localObject6 = localar.fRe();
              d.g.b.k.g(localObject6, "typeAliasDescriptor.defaultType");
              localObject5 = am.b((aj)localObject5, (aj)localObject6);
              localObject6 = ((d.l.b.a.b.b.d)localObject3).fQQ();
              if (localObject6 == null) {
                break label438;
              }
              localObject3 = (d.l.b.a.b.b.a)localObject2;
              d.g.b.k.g(localObject6, "it");
              localObject1 = ((d.l.b.a.b.m.ba)localObject1).b(((ak)localObject6).fRV(), bh.LLV);
              localObject6 = d.l.b.a.b.b.a.g.LeU;
            }
          }
        }
      }
      label438:
      for (localObject1 = d.l.b.a.b.j.b.a((d.l.b.a.b.b.a)localObject3, (ab)localObject1, g.a.fSm());; localObject1 = null)
      {
        ((ah)localObject2).a((ak)localObject1, null, localar.fQm(), (List)localObject4, (ab)localObject5, w.LdG, localar.fQb());
        localObject1 = (ag)localObject2;
        break label131;
        break;
      }
    }
    return (Collection)localCollection;
  }
  
  protected abstract List<as> fSs();
  
  public String toString()
  {
    return "typealias " + fRf().rf();
  }
  
  public static final class a
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.m.a.i, aj>
  {
    public a(d paramd)
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.l
    implements d.g.a.b<bg, Boolean>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  public static final class c
    implements at
  {
    public final boolean fQs()
    {
      return true;
    }
    
    public final d.l.b.a.b.a.g fRE()
    {
      AppMethodBeat.i(57000);
      d.l.b.a.b.a.g localg = d.l.b.a.b.j.d.a.G((d.l.b.a.b.b.l)this.Lgt);
      AppMethodBeat.o(57000);
      return localg;
    }
    
    public final Collection<ab> fSt()
    {
      AppMethodBeat.i(56999);
      Collection localCollection = ((ar)this.Lgt).fRS().gbz().fSt();
      d.g.b.k.g(localCollection, "declarationDescriptor.un…pe.constructor.supertypes");
      AppMethodBeat.o(56999);
      return localCollection;
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(56998);
      List localList = this.Lgt.fSs();
      AppMethodBeat.o(56998);
      return localList;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57001);
      String str = "[typealias " + ((ar)this.Lgt).fRf().rf() + ']';
      AppMethodBeat.o(57001);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.d
 * JD-Core Version:    0.7.0.1
 */