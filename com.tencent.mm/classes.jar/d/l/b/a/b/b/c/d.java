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
  protected List<? extends as> JsX;
  private final c JsY;
  protected final d.l.b.a.b.b.ba JsZ;
  
  public d(d.l.b.a.b.b.l paraml, d.l.b.a.b.b.a.g paramg, f paramf, an paraman, d.l.b.a.b.b.ba paramba)
  {
    super(paraml, paramg, paramf, paraman);
    this.JsZ = paramba;
    this.JsY = new c(this);
  }
  
  private ar fzM()
  {
    o localo = super.fzN();
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
  
  public final List<as> fxI()
  {
    List localList = this.JsX;
    if (localList == null) {
      d.g.b.k.aPZ("declaredTypeParametersImpl");
    }
    return localList;
  }
  
  public final at fxs()
  {
    return (at)this.JsY;
  }
  
  public final w fxv()
  {
    return w.Jqn;
  }
  
  public final d.l.b.a.b.b.ba fxx()
  {
    return this.JsZ;
  }
  
  public final boolean fxz()
  {
    return bc.b((ab)fzo(), (d.g.a.b)new b(this));
  }
  
  protected abstract d.l.b.a.b.l.i fzK();
  
  public final Collection<ag> fzL()
  {
    Object localObject1 = fzq();
    if (localObject1 == null) {
      return (Collection)d.a.v.Jgl;
    }
    localObject1 = ((e)localObject1).fvR();
    d.g.b.k.g(localObject1, "classDescriptor.constructors");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (d.l.b.a.b.b.d)localIterator.next();
      localObject1 = ah.Jvl;
      Object localObject2 = fzK();
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
            localObject4 = ((d.l.b.a.b.b.d)localObject3).fxF();
            Object localObject6 = ((d.l.b.a.b.b.d)localObject3).fyu();
            d.g.b.k.g(localObject6, "constructor.kind");
            an localan = localar.fxG();
            d.g.b.k.g(localan, "typeAliasDescriptor.source");
            localObject2 = new ah((d.l.b.a.b.l.i)localObject2, localar, (d.l.b.a.b.b.d)localObject5, null, (d.l.b.a.b.b.a.g)localObject4, (b.a)localObject6, localan, (byte)0);
            localObject4 = (t)localObject2;
            localObject6 = ((d.l.b.a.b.b.d)localObject3).fyq();
            if (localObject6 == null) {
              p.adP(26);
            }
            if (localObject1 == null) {
              p.adP(27);
            }
            localObject4 = p.a((t)localObject4, (List)localObject6, (d.l.b.a.b.m.ba)localObject1, false, false, null);
            if (localObject4 == null)
            {
              localObject1 = null;
            }
            else
            {
              d.g.b.k.g(localObject4, "FunctionDescriptorImpl.g…         ) ?: return null");
              localObject5 = y.ao((ab)((d.l.b.a.b.b.d)localObject5).fyo().fJW());
              localObject6 = localar.fyA();
              d.g.b.k.g(localObject6, "typeAliasDescriptor.defaultType");
              localObject5 = am.b((aj)localObject5, (aj)localObject6);
              localObject6 = ((d.l.b.a.b.b.d)localObject3).fym();
              if (localObject6 == null) {
                break label438;
              }
              localObject3 = (d.l.b.a.b.b.a)localObject2;
              d.g.b.k.g(localObject6, "it");
              localObject1 = ((d.l.b.a.b.m.ba)localObject1).b(((ak)localObject6).fzr(), bh.JYC);
              localObject6 = d.l.b.a.b.b.a.g.JrB;
            }
          }
        }
      }
      label438:
      for (localObject1 = d.l.b.a.b.j.b.a((d.l.b.a.b.b.a)localObject3, (ab)localObject1, g.a.fzI());; localObject1 = null)
      {
        ((ah)localObject2).a((ak)localObject1, null, localar.fxI(), (List)localObject4, (ab)localObject5, w.Jqn, localar.fxx());
        localObject1 = (ag)localObject2;
        break label131;
        break;
      }
    }
    return (Collection)localCollection;
  }
  
  protected abstract List<as> fzO();
  
  public String toString()
  {
    return "typealias " + fyB().qV();
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
    public final boolean fxO()
    {
      return true;
    }
    
    public final Collection<ab> fzP()
    {
      AppMethodBeat.i(56999);
      Collection localCollection = ((ar)this.Jta).fzo().fIW().fzP();
      d.g.b.k.g(localCollection, "declarationDescriptor.un…pe.constructor.supertypes");
      AppMethodBeat.o(56999);
      return localCollection;
    }
    
    public final d.l.b.a.b.a.g fza()
    {
      AppMethodBeat.i(57000);
      d.l.b.a.b.a.g localg = d.l.b.a.b.j.d.a.G((d.l.b.a.b.b.l)this.Jta);
      AppMethodBeat.o(57000);
      return localg;
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(56998);
      List localList = this.Jta.fzO();
      AppMethodBeat.o(56998);
      return localList;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57001);
      String str = "[typealias " + ((ar)this.Jta).fyB().qV() + ']';
      AppMethodBeat.o(57001);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.d
 * JD-Core Version:    0.7.0.1
 */