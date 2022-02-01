package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.bf;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ad;

public class ak
  extends al
  implements bd
{
  public static final ak.a aiMf;
  private final boolean aiMg;
  private final boolean aiMh;
  private final boolean aiMi;
  private final ad aiMj;
  private final bd aiMk;
  private final int index;
  
  static
  {
    AppMethodBeat.i(57348);
    aiMf = new ak.a((byte)0);
    AppMethodBeat.o(57348);
  }
  
  public ak(kotlin.l.b.a.b.b.a parama, bd parambd, int paramInt, g paramg, f paramf, ad paramad1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ad paramad2, av paramav)
  {
    super((l)parama, paramg, paramf, paramad1, paramav);
    AppMethodBeat.i(57347);
    this.index = paramInt;
    this.aiMg = paramBoolean1;
    this.aiMh = paramBoolean2;
    this.aiMi = paramBoolean3;
    this.aiMj = paramad2;
    if (parambd == null) {}
    for (parama = (bd)this;; parama = parambd)
    {
      this.aiMk = parama;
      AppMethodBeat.o(57347);
      return;
    }
  }
  
  public static final ak a(kotlin.l.b.a.b.b.a parama, bd parambd, int paramInt, g paramg, f paramf, ad paramad1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ad paramad2, av paramav, kotlin.g.a.a<? extends List<? extends bf>> parama1)
  {
    AppMethodBeat.i(57349);
    kotlin.g.b.s.u(parama, "containingDeclaration");
    kotlin.g.b.s.u(paramg, "annotations");
    kotlin.g.b.s.u(paramf, "name");
    kotlin.g.b.s.u(paramad1, "outType");
    kotlin.g.b.s.u(paramav, "source");
    if (parama1 == null)
    {
      parama = new ak(parama, parambd, paramInt, paramg, paramf, paramad1, paramBoolean1, paramBoolean2, paramBoolean3, paramad2, paramav);
      AppMethodBeat.o(57349);
      return parama;
    }
    parama = (ak)new b(parama, parambd, paramInt, paramg, paramf, paramad1, paramBoolean1, paramBoolean2, paramBoolean3, paramad2, paramav, parama1);
    AppMethodBeat.o(57349);
    return parama;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57343);
    kotlin.g.b.s.u(paramn, "visitor");
    paramn = paramn.a((bd)this, paramD);
    AppMethodBeat.o(57343);
    return paramn;
  }
  
  public bd a(kotlin.l.b.a.b.b.a parama, f paramf, int paramInt)
  {
    AppMethodBeat.i(57344);
    kotlin.g.b.s.u(parama, "newOwner");
    kotlin.g.b.s.u(paramf, "newName");
    g localg = knl();
    kotlin.g.b.s.s(localg, "annotations");
    ad localad1 = koG();
    kotlin.g.b.s.s(localad1, "type");
    boolean bool1 = kpp();
    boolean bool2 = this.aiMh;
    boolean bool3 = this.aiMi;
    ad localad2 = this.aiMj;
    av localav = av.aiHu;
    kotlin.g.b.s.s(localav, "NO_SOURCE");
    parama = (bd)new ak(parama, null, paramInt, localg, paramf, localad1, bool1, bool2, bool3, localad2, localav);
    AppMethodBeat.o(57344);
    return parama;
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final t knc()
  {
    AppMethodBeat.i(191909);
    t localt = kotlin.l.b.a.b.b.s.aiGH;
    kotlin.g.b.s.s(localt, "LOCAL");
    AppMethodBeat.o(191909);
    return localt;
  }
  
  public final Collection<bd> kof()
  {
    AppMethodBeat.i(57346);
    Collection localCollection = ((kotlin.l.b.a.b.b.a)super.knp()).kof();
    kotlin.g.b.s.s(localCollection, "containingDeclaration.overriddenDescriptors");
    Object localObject = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add((bd)((kotlin.l.b.a.b.b.a)((Iterator)localObject).next()).kod().get(this.index));
    }
    localCollection = (Collection)localCollection;
    AppMethodBeat.o(57346);
    return localCollection;
  }
  
  public final kotlin.l.b.a.b.b.a kpo()
  {
    AppMethodBeat.i(57334);
    kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)super.knp();
    AppMethodBeat.o(57334);
    return locala;
  }
  
  public final boolean kpp()
  {
    AppMethodBeat.i(57336);
    if ((this.aiMg) && (((b)super.knp()).koh().koi()))
    {
      AppMethodBeat.o(57336);
      return true;
    }
    AppMethodBeat.o(57336);
    return false;
  }
  
  public final ad kpq()
  {
    return this.aiMj;
  }
  
  public final bd kpr()
  {
    AppMethodBeat.i(57337);
    if (this.aiMk == this)
    {
      localbd = (bd)this;
      AppMethodBeat.o(57337);
      return localbd;
    }
    bd localbd = this.aiMk.kpr();
    AppMethodBeat.o(57337);
    return localbd;
  }
  
  public final boolean kps()
  {
    return this.aiMh;
  }
  
  public final boolean kpt()
  {
    return this.aiMi;
  }
  
  public final boolean kpu()
  {
    return false;
  }
  
  public final boolean kpx()
  {
    AppMethodBeat.i(191912);
    kotlin.g.b.s.u((bd)this, "this");
    AppMethodBeat.o(191912);
    return false;
  }
  
  public static final class b
    extends ak
  {
    private final j aiMl;
    
    public b(kotlin.l.b.a.b.b.a parama, bd parambd, int paramInt, g paramg, f paramf, ad paramad1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ad paramad2, av paramav, kotlin.g.a.a<? extends List<? extends bf>> parama1)
    {
      super(parambd, paramInt, paramg, paramf, paramad1, paramBoolean1, paramBoolean2, paramBoolean3, paramad2, paramav);
      AppMethodBeat.i(57333);
      this.aiMl = k.cm(parama1);
      AppMethodBeat.o(57333);
    }
    
    public final bd a(kotlin.l.b.a.b.b.a parama, f paramf, int paramInt)
    {
      AppMethodBeat.i(57332);
      kotlin.g.b.s.u(parama, "newOwner");
      kotlin.g.b.s.u(paramf, "newName");
      g localg = knl();
      kotlin.g.b.s.s(localg, "annotations");
      ad localad1 = koG();
      kotlin.g.b.s.s(localad1, "type");
      boolean bool1 = kpp();
      boolean bool2 = kps();
      boolean bool3 = kpt();
      ad localad2 = kpq();
      av localav = av.aiHu;
      kotlin.g.b.s.s(localav, "NO_SOURCE");
      parama = (bd)new b(parama, null, paramInt, localg, paramf, localad1, bool1, bool2, bool3, localad2, localav, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(57332);
      return parama;
    }
    
    public final List<bf> kqn()
    {
      AppMethodBeat.i(57331);
      List localList = (List)this.aiMl.getValue();
      AppMethodBeat.o(57331);
      return localList;
    }
    
    static final class a
      extends u
      implements kotlin.g.a.a<List<? extends bf>>
    {
      a(ak.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.ak
 * JD-Core Version:    0.7.0.1
 */