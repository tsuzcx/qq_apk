package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.q;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.n;
import d.l.b.a.b.b.o;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.w;
import d.l.b.a.b.f.f;
import d.l.b.a.b.l.j;
import d.l.b.a.b.m.a.i;
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
  protected List<? extends as> Nus;
  private final c Nut;
  protected final d.l.b.a.b.b.ba Nuu;
  
  public d(l paraml, d.l.b.a.b.b.a.g paramg, f paramf, an paraman, d.l.b.a.b.b.ba paramba)
  {
    super(paraml, paramg, paramf, paraman);
    this.Nuu = paramba;
    this.Nut = new c(this);
  }
  
  private ar goq()
  {
    o localo = super.gor();
    if (localo == null) {
      throw new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
    }
    return (ar)localo;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    d.g.b.p.h(paramn, "visitor");
    return paramn.a((ar)this, paramD);
  }
  
  public final at glW()
  {
    return (at)this.Nut;
  }
  
  public final w glZ()
  {
    return w.NrG;
  }
  
  public final d.l.b.a.b.b.ba gmb()
  {
    return this.Nuu;
  }
  
  public final boolean gmd()
  {
    return bc.b((ab)gnT(), (d.g.a.b)new b(this));
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
  
  public final List<as> gmm()
  {
    List localList = this.Nus;
    if (localList == null) {
      d.g.b.p.bdF("declaredTypeParametersImpl");
    }
    return localList;
  }
  
  protected abstract j gng();
  
  public final Collection<ag> gop()
  {
    Object localObject1 = gnV();
    if (localObject1 == null) {
      return (Collection)d.a.v.NhH;
    }
    localObject1 = ((e)localObject1).gkx();
    d.g.b.p.g(localObject1, "classDescriptor.constructors");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (d.l.b.a.b.b.d)localIterator.next();
      localObject1 = ah.NwG;
      Object localObject2 = gng();
      ar localar = (ar)this;
      d.g.b.p.g(localObject3, "it");
      d.g.b.p.h(localObject2, "storageManager");
      d.g.b.p.h(localar, "typeAliasDescriptor");
      d.g.b.p.h(localObject3, "constructor");
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
            localObject4 = ((d.l.b.a.b.b.d)localObject3).gmj();
            Object localObject6 = ((d.l.b.a.b.b.d)localObject3).gmY();
            d.g.b.p.g(localObject6, "constructor.kind");
            an localan = localar.gmk();
            d.g.b.p.g(localan, "typeAliasDescriptor.source");
            localObject2 = new ah((j)localObject2, localar, (d.l.b.a.b.b.d)localObject5, null, (d.l.b.a.b.b.a.g)localObject4, (b.a)localObject6, localan, (byte)0);
            localObject4 = (t)localObject2;
            localObject6 = ((d.l.b.a.b.b.d)localObject3).gmU();
            if (localObject6 == null) {
              p.ajW(26);
            }
            if (localObject1 == null) {
              p.ajW(27);
            }
            localObject4 = p.a((t)localObject4, (List)localObject6, (d.l.b.a.b.m.ba)localObject1, false, false, null);
            if (localObject4 == null)
            {
              localObject1 = null;
            }
            else
            {
              d.g.b.p.g(localObject4, "FunctionDescriptorImpl.g…         ) ?: return null");
              localObject5 = y.ao((ab)((d.l.b.a.b.b.d)localObject5).gmS().gyC());
              localObject6 = localar.gne();
              d.g.b.p.g(localObject6, "typeAliasDescriptor.defaultType");
              localObject5 = am.b((aj)localObject5, (aj)localObject6);
              localObject6 = ((d.l.b.a.b.b.d)localObject3).gmQ();
              if (localObject6 == null) {
                break label438;
              }
              localObject3 = (d.l.b.a.b.b.a)localObject2;
              d.g.b.p.g(localObject6, "it");
              localObject1 = ((d.l.b.a.b.m.ba)localObject1).b(((ak)localObject6).gnW(), bh.NZW);
              localObject6 = d.l.b.a.b.b.a.g.NsU;
            }
          }
        }
      }
      label438:
      for (localObject1 = d.l.b.a.b.j.b.a((d.l.b.a.b.b.a)localObject3, (ab)localObject1, g.a.gon());; localObject1 = null)
      {
        ((ah)localObject2).a((ak)localObject1, null, localar.gmm(), (List)localObject4, (ab)localObject5, w.NrG, localar.gmb());
        localObject1 = (ag)localObject2;
        break label131;
        break;
      }
    }
    return (Collection)localCollection;
  }
  
  protected abstract List<as> gos();
  
  public String toString()
  {
    return "typealias " + gnf().sD();
  }
  
  public static final class a
    extends q
    implements d.g.a.b<i, aj>
  {
    public a(d paramd)
    {
      super();
    }
  }
  
  static final class b
    extends q
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
    public final List<as> getParameters()
    {
      AppMethodBeat.i(56998);
      List localList = this.Nuv.gos();
      AppMethodBeat.o(56998);
      return localList;
    }
    
    public final boolean gms()
    {
      return true;
    }
    
    public final d.l.b.a.b.a.g gnF()
    {
      AppMethodBeat.i(57000);
      d.l.b.a.b.a.g localg = d.l.b.a.b.j.d.a.G((l)this.Nuv);
      AppMethodBeat.o(57000);
      return localg;
    }
    
    public final Collection<ab> got()
    {
      AppMethodBeat.i(56999);
      Collection localCollection = ((ar)this.Nuv).gnT().gxB().got();
      d.g.b.p.g(localCollection, "declarationDescriptor.un…pe.constructor.supertypes");
      AppMethodBeat.o(56999);
      return localCollection;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57001);
      String str = "[typealias " + ((ar)this.Nuv).gnf().sD() + ']';
      AppMethodBeat.o(57001);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.d
 * JD-Core Version:    0.7.0.1
 */