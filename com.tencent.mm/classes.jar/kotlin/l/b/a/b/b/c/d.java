package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.aa;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ao;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.bl;

public abstract class d
  extends k
  implements az
{
  private final t aiJF;
  private List<? extends ba> aiJG;
  private final c aiJH;
  
  public d(l paraml, kotlin.l.b.a.b.b.a.g paramg, f paramf, av paramav, t paramt)
  {
    super(paraml, paramg, paramf, paramav);
    this.aiJF = paramt;
    this.aiJH = new c(this);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    s.u(paramn, "visitor");
    return paramn.a((az)this, paramD);
  }
  
  public final ax kmZ()
  {
    return (ax)this.aiJH;
  }
  
  public final kotlin.l.b.a.b.b.ab knb()
  {
    return kotlin.l.b.a.b.b.ab.aiGY;
  }
  
  public final t knc()
  {
    return this.aiJF;
  }
  
  public final boolean kne()
  {
    return bg.a((ad)kpl(), (b)new b(this));
  }
  
  public final boolean kni()
  {
    return false;
  }
  
  public final boolean knj()
  {
    return false;
  }
  
  public final boolean knk()
  {
    return false;
  }
  
  public final List<ba> kno()
  {
    List localList2 = this.aiJG;
    List localList1 = localList2;
    if (localList2 == null)
    {
      s.bIx("declaredTypeParametersImpl");
      localList1 = null;
    }
    return localList1;
  }
  
  protected abstract m kol();
  
  public final Collection<ah> kpD()
  {
    Object localObject1 = kpn();
    if (localObject1 == null) {
      return (Collection)kotlin.a.ab.aivy;
    }
    localObject1 = ((e)localObject1).klv();
    s.s(localObject1, "classDescriptor.constructors");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (kotlin.l.b.a.b.b.d)localIterator.next();
      localObject1 = ai.aiLX;
      Object localObject2 = kol();
      az localaz = (az)this;
      s.s(localObject3, "it");
      s.u(localObject2, "storageManager");
      s.u(localaz, "typeAliasDescriptor");
      s.u(localObject3, "constructor");
      localObject1 = ai.a.a(localaz);
      if (localObject1 == null) {
        localObject1 = null;
      }
      label131:
      Object localObject5;
      Object localObject4;
      Object localObject6;
      for (;;)
      {
        if (localObject1 != null)
        {
          localCollection.add(localObject1);
          break;
          localObject5 = ((kotlin.l.b.a.b.b.d)localObject3).a((be)localObject1);
          if (localObject5 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject4 = ((kotlin.l.b.a.b.b.d)localObject3).knl();
            localObject6 = ((kotlin.l.b.a.b.b.d)localObject3).koh();
            s.s(localObject6, "constructor.kind");
            av localav = localaz.knm();
            s.s(localav, "typeAliasDescriptor.source");
            localObject2 = new ai((m)localObject2, localaz, (kotlin.l.b.a.b.b.d)localObject5, null, (kotlin.l.b.a.b.b.a.g)localObject4, (b.a)localObject6, localav, (byte)0);
            localObject4 = (x)localObject2;
            localObject6 = ((kotlin.l.b.a.b.b.d)localObject3).kod();
            if (localObject6 == null) {
              p.aKu(26);
            }
            if (localObject1 == null) {
              p.aKu(27);
            }
            localObject4 = p.a((x)localObject4, (List)localObject6, (be)localObject1, false, false, null);
            if (localObject4 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject5 = aa.ae((ad)((kotlin.l.b.a.b.b.d)localObject5).kob().kAK());
              localObject6 = localaz.koj();
              s.s(localObject6, "typeAliasDescriptor.defaultType");
              localObject5 = ao.b((al)localObject5, (al)localObject6);
              localObject6 = ((kotlin.l.b.a.b.b.d)localObject3).knZ();
              if (localObject6 != null) {
                break label388;
              }
            }
          }
        }
      }
      for (localObject1 = null;; localObject1 = c.a((kotlin.l.b.a.b.b.a)localObject3, (ad)localObject1, g.a.kpB()))
      {
        ((ai)localObject2).a((as)localObject1, null, localaz.kno(), (List)localObject4, (ad)localObject5, kotlin.l.b.a.b.b.ab.aiGY, localaz.knc());
        localObject1 = (ah)localObject2;
        break label131;
        break;
        label388:
        localObject3 = (kotlin.l.b.a.b.b.a)localObject2;
        localObject1 = ((be)localObject1).b(((as)localObject6).koG(), bl.ajqM);
        localObject6 = kotlin.l.b.a.b.b.a.g.aiIh;
      }
    }
    return (Collection)localCollection;
  }
  
  protected abstract List<ba> kpE();
  
  public final void oT(List<? extends ba> paramList)
  {
    s.u(paramList, "declaredTypeParameters");
    this.aiJG = paramList;
  }
  
  public String toString()
  {
    return s.X("typealias ", kok().PF());
  }
  
  public static final class a
    extends u
    implements b<kotlin.l.b.a.b.m.a.g, al>
  {
    public a(d paramd)
    {
      super();
    }
  }
  
  static final class b
    extends u
    implements b<bk, Boolean>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  public static final class c
    implements ax
  {
    c(d paramd) {}
    
    public final ax c(kotlin.l.b.a.b.m.a.g paramg)
    {
      AppMethodBeat.i(191923);
      s.u(paramg, "kotlinTypeRefiner");
      paramg = (ax)this;
      AppMethodBeat.o(191923);
      return paramg;
    }
    
    public final List<ba> klq()
    {
      AppMethodBeat.i(56998);
      List localList = this.aiJI.kpE();
      AppMethodBeat.o(56998);
      return localList;
    }
    
    public final boolean knx()
    {
      return true;
    }
    
    public final h koV()
    {
      AppMethodBeat.i(57000);
      h localh = kotlin.l.b.a.b.j.d.a.G((l)this.aiJI);
      AppMethodBeat.o(57000);
      return localh;
    }
    
    public final Collection<ad> kpG()
    {
      AppMethodBeat.i(56999);
      Collection localCollection = ((az)this.aiJI).kpl().kzm().kpG();
      s.s(localCollection, "declarationDescriptor.un…pe.constructor.supertypes");
      AppMethodBeat.o(56999);
      return localCollection;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57001);
      String str = "[typealias " + ((az)this.aiJI).kok().PF() + ']';
      AppMethodBeat.o(57001);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.d
 * JD-Core Version:    0.7.0.1
 */