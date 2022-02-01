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
  protected List<? extends as> MXm;
  private final c MXn;
  protected final d.l.b.a.b.b.ba MXo;
  
  public d(l paraml, d.l.b.a.b.b.a.g paramg, f paramf, an paraman, d.l.b.a.b.b.ba paramba)
  {
    super(paraml, paramg, paramf, paraman);
    this.MXo = paramba;
    this.MXn = new c(this);
  }
  
  private ar gjO()
  {
    o localo = super.gjP();
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
  
  public final boolean ghB()
  {
    return bc.b((ab)gjr(), (d.g.a.b)new b(this));
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
  
  public final List<as> ghK()
  {
    List localList = this.MXm;
    if (localList == null) {
      d.g.b.p.bcb("declaredTypeParametersImpl");
    }
    return localList;
  }
  
  public final at ghu()
  {
    return (at)this.MXn;
  }
  
  public final w ghx()
  {
    return w.MUB;
  }
  
  public final d.l.b.a.b.b.ba ghz()
  {
    return this.MXo;
  }
  
  protected abstract j giE();
  
  public final Collection<ag> gjN()
  {
    Object localObject1 = gjt();
    if (localObject1 == null) {
      return (Collection)d.a.v.MKE;
    }
    localObject1 = ((e)localObject1).gfV();
    d.g.b.p.g(localObject1, "classDescriptor.constructors");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (d.l.b.a.b.b.d)localIterator.next();
      localObject1 = ah.MZA;
      Object localObject2 = giE();
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
            localObject4 = ((d.l.b.a.b.b.d)localObject3).ghH();
            Object localObject6 = ((d.l.b.a.b.b.d)localObject3).giw();
            d.g.b.p.g(localObject6, "constructor.kind");
            an localan = localar.ghI();
            d.g.b.p.g(localan, "typeAliasDescriptor.source");
            localObject2 = new ah((j)localObject2, localar, (d.l.b.a.b.b.d)localObject5, null, (d.l.b.a.b.b.a.g)localObject4, (b.a)localObject6, localan, (byte)0);
            localObject4 = (t)localObject2;
            localObject6 = ((d.l.b.a.b.b.d)localObject3).gis();
            if (localObject6 == null) {
              p.ajm(26);
            }
            if (localObject1 == null) {
              p.ajm(27);
            }
            localObject4 = p.a((t)localObject4, (List)localObject6, (d.l.b.a.b.m.ba)localObject1, false, false, null);
            if (localObject4 == null)
            {
              localObject1 = null;
            }
            else
            {
              d.g.b.p.g(localObject4, "FunctionDescriptorImpl.g…         ) ?: return null");
              localObject5 = y.ao((ab)((d.l.b.a.b.b.d)localObject5).giq().gua());
              localObject6 = localar.giC();
              d.g.b.p.g(localObject6, "typeAliasDescriptor.defaultType");
              localObject5 = am.b((aj)localObject5, (aj)localObject6);
              localObject6 = ((d.l.b.a.b.b.d)localObject3).gio();
              if (localObject6 == null) {
                break label438;
              }
              localObject3 = (d.l.b.a.b.b.a)localObject2;
              d.g.b.p.g(localObject6, "it");
              localObject1 = ((d.l.b.a.b.m.ba)localObject1).b(((ak)localObject6).gju(), bh.NCP);
              localObject6 = d.l.b.a.b.b.a.g.MVP;
            }
          }
        }
      }
      label438:
      for (localObject1 = d.l.b.a.b.j.b.a((d.l.b.a.b.b.a)localObject3, (ab)localObject1, g.a.gjL());; localObject1 = null)
      {
        ((ah)localObject2).a((ak)localObject1, null, localar.ghK(), (List)localObject4, (ab)localObject5, w.MUB, localar.ghz());
        localObject1 = (ag)localObject2;
        break label131;
        break;
      }
    }
    return (Collection)localCollection;
  }
  
  protected abstract List<as> gjQ();
  
  public String toString()
  {
    return "typealias " + giD().sD();
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
      List localList = this.MXp.gjQ();
      AppMethodBeat.o(56998);
      return localList;
    }
    
    public final boolean ghQ()
    {
      return true;
    }
    
    public final Collection<ab> gjR()
    {
      AppMethodBeat.i(56999);
      Collection localCollection = ((ar)this.MXp).gjr().gsZ().gjR();
      d.g.b.p.g(localCollection, "declarationDescriptor.un…pe.constructor.supertypes");
      AppMethodBeat.o(56999);
      return localCollection;
    }
    
    public final d.l.b.a.b.a.g gjd()
    {
      AppMethodBeat.i(57000);
      d.l.b.a.b.a.g localg = d.l.b.a.b.j.d.a.G((l)this.MXp);
      AppMethodBeat.o(57000);
      return localg;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57001);
      String str = "[typealias " + ((ar)this.MXp).giD().sD() + ']';
      AppMethodBeat.o(57001);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.d
 * JD-Core Version:    0.7.0.1
 */