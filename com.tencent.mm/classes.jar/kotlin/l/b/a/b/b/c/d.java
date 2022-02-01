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
  private List<? extends as> aaMU;
  private final c aaMV;
  private final kotlin.l.b.a.b.b.ba aaMW;
  
  public d(l paraml, kotlin.l.b.a.b.b.a.g paramg, f paramf, an paraman, kotlin.l.b.a.b.b.ba paramba)
  {
    super(paraml, paramg, paramf, paraman);
    this.aaMW = paramba;
    this.aaMV = new c(this);
  }
  
  private ar iGh()
  {
    o localo = super.iGi();
    if (localo == null) {
      throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
    }
    return (ar)localo;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    kotlin.g.b.p.k(paramn, "visitor");
    return paramn.a((ar)this, paramD);
  }
  
  public final at iDL()
  {
    return (at)this.aaMV;
  }
  
  public final w iDO()
  {
    return w.aaKi;
  }
  
  public final kotlin.l.b.a.b.b.ba iDQ()
  {
    return this.aaMW;
  }
  
  public final boolean iDS()
  {
    return bc.b((ab)iFK(), (kotlin.g.a.b)new b(this));
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
  
  protected abstract j iEV();
  
  public final List<as> iEb()
  {
    List localList = this.aaMU;
    if (localList == null) {
      kotlin.g.b.p.bGy("declaredTypeParametersImpl");
    }
    return localList;
  }
  
  public final Collection<ag> iGg()
  {
    Object localObject1 = iFM();
    if (localObject1 == null) {
      return (Collection)v.aaAd;
    }
    localObject1 = ((e)localObject1).iCg();
    kotlin.g.b.p.j(localObject1, "classDescriptor.constructors");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (kotlin.l.b.a.b.b.d)localIterator.next();
      localObject1 = ah.aaPi;
      Object localObject2 = iEV();
      ar localar = (ar)this;
      kotlin.g.b.p.j(localObject3, "it");
      kotlin.g.b.p.k(localObject2, "storageManager");
      kotlin.g.b.p.k(localar, "typeAliasDescriptor");
      kotlin.g.b.p.k(localObject3, "constructor");
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
            localObject4 = ((kotlin.l.b.a.b.b.d)localObject3).iDY();
            Object localObject6 = ((kotlin.l.b.a.b.b.d)localObject3).iEN();
            kotlin.g.b.p.j(localObject6, "constructor.kind");
            an localan = localar.iDZ();
            kotlin.g.b.p.j(localan, "typeAliasDescriptor.source");
            localObject2 = new ah((j)localObject2, localar, (kotlin.l.b.a.b.b.d)localObject5, null, (kotlin.l.b.a.b.b.a.g)localObject4, (b.a)localObject6, localan, (byte)0);
            localObject4 = (kotlin.l.b.a.b.b.t)localObject2;
            localObject6 = ((kotlin.l.b.a.b.b.d)localObject3).iEJ();
            if (localObject6 == null) {
              p.aDG(26);
            }
            if (localObject1 == null) {
              p.aDG(27);
            }
            localObject4 = p.a((kotlin.l.b.a.b.b.t)localObject4, (List)localObject6, (kotlin.l.b.a.b.m.ba)localObject1, false, false, null);
            if (localObject4 == null)
            {
              localObject1 = null;
            }
            else
            {
              kotlin.g.b.p.j(localObject4, "FunctionDescriptorImpl.g…         ) ?: return null");
              localObject5 = y.an((ab)((kotlin.l.b.a.b.b.d)localObject5).iEH().iPX());
              localObject6 = localar.iET();
              kotlin.g.b.p.j(localObject6, "typeAliasDescriptor.defaultType");
              localObject5 = am.b((aj)localObject5, (aj)localObject6);
              localObject6 = ((kotlin.l.b.a.b.b.d)localObject3).iEF();
              if (localObject6 == null) {
                break label438;
              }
              localObject3 = (kotlin.l.b.a.b.b.a)localObject2;
              kotlin.g.b.p.j(localObject6, "it");
              localObject1 = ((kotlin.l.b.a.b.m.ba)localObject1).b(((ak)localObject6).iFN(), bh.abrp);
              localObject6 = kotlin.l.b.a.b.b.a.g.aaLw;
            }
          }
        }
      }
      label438:
      for (localObject1 = kotlin.l.b.a.b.j.b.a((kotlin.l.b.a.b.b.a)localObject3, (ab)localObject1, g.a.iGe());; localObject1 = null)
      {
        ((ah)localObject2).a((ak)localObject1, null, localar.iEb(), (List)localObject4, (ab)localObject5, w.aaKi, localar.iDQ());
        localObject1 = (ag)localObject2;
        break label131;
        break;
      }
    }
    return (Collection)localCollection;
  }
  
  protected abstract List<as> iGj();
  
  public final void lx(List<? extends as> paramList)
  {
    kotlin.g.b.p.k(paramList, "declaredTypeParameters");
    this.aaMU = paramList;
  }
  
  public String toString()
  {
    return "typealias " + iEU().qu();
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
    public final List<as> iCb()
    {
      AppMethodBeat.i(56998);
      List localList = this.aaMX.iGj();
      AppMethodBeat.o(56998);
      return localList;
    }
    
    public final boolean iEh()
    {
      return true;
    }
    
    public final kotlin.l.b.a.b.a.g iFv()
    {
      AppMethodBeat.i(57000);
      kotlin.l.b.a.b.a.g localg = kotlin.l.b.a.b.j.d.a.G((l)this.aaMX);
      AppMethodBeat.o(57000);
      return localg;
    }
    
    public final Collection<ab> iGk()
    {
      AppMethodBeat.i(56999);
      Collection localCollection = ((ar)this.aaMX).iFK().iOU().iGk();
      kotlin.g.b.p.j(localCollection, "declarationDescriptor.un…pe.constructor.supertypes");
      AppMethodBeat.o(56999);
      return localCollection;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57001);
      String str = "[typealias " + ((ar)this.aaMX).iEU().qu() + ']';
      AppMethodBeat.o(57001);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.d
 * JD-Core Version:    0.7.0.1
 */