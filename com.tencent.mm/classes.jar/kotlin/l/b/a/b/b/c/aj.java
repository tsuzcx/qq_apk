package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.m.ab;
import kotlin.t;

public class aj
  extends ak
  implements av
{
  public static final a Tmy;
  private final av Tmt;
  private final boolean Tmu;
  final boolean Tmv;
  final boolean Tmw;
  final ab Tmx;
  private final int index;
  
  static
  {
    AppMethodBeat.i(57348);
    Tmy = new a((byte)0);
    AppMethodBeat.o(57348);
  }
  
  public aj(kotlin.l.b.a.b.b.a parama, av paramav, int paramInt, kotlin.l.b.a.b.b.a.g paramg, kotlin.l.b.a.b.f.f paramf, ab paramab1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ab paramab2, an paraman)
  {
    super((l)parama, paramg, paramf, paramab1, paraman);
    AppMethodBeat.i(57347);
    this.index = paramInt;
    this.Tmu = paramBoolean1;
    this.Tmv = paramBoolean2;
    this.Tmw = paramBoolean3;
    this.Tmx = paramab2;
    if (paramav == null) {}
    for (parama = (av)this;; parama = paramav)
    {
      this.Tmt = parama;
      AppMethodBeat.o(57347);
      return;
    }
  }
  
  public static final aj a(kotlin.l.b.a.b.b.a parama, av paramav, int paramInt, kotlin.l.b.a.b.b.a.g paramg, kotlin.l.b.a.b.f.f paramf, ab paramab1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ab paramab2, an paraman, kotlin.g.a.a<? extends List<? extends ax>> parama1)
  {
    AppMethodBeat.i(57349);
    p.h(parama, "containingDeclaration");
    p.h(paramg, "annotations");
    p.h(paramf, "name");
    p.h(paramab1, "outType");
    p.h(paraman, "source");
    if (parama1 == null)
    {
      parama = new aj(parama, paramav, paramInt, paramg, paramf, paramab1, paramBoolean1, paramBoolean2, paramBoolean3, paramab2, paraman);
      AppMethodBeat.o(57349);
      return parama;
    }
    parama = (aj)new b(parama, paramav, paramInt, paramg, paramf, paramab1, paramBoolean1, paramBoolean2, paramBoolean3, paramab2, paraman, parama1);
    AppMethodBeat.o(57349);
    return parama;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57343);
    p.h(paramn, "visitor");
    paramn = paramn.a((av)this, paramD);
    AppMethodBeat.o(57343);
    return paramn;
  }
  
  public av a(kotlin.l.b.a.b.b.a parama, kotlin.l.b.a.b.f.f paramf, int paramInt)
  {
    AppMethodBeat.i(57344);
    p.h(parama, "newOwner");
    p.h(paramf, "newName");
    kotlin.l.b.a.b.b.a.g localg = hzL();
    p.g(localg, "annotations");
    ab localab1 = hBy();
    p.g(localab1, "type");
    boolean bool1 = hBA();
    boolean bool2 = this.Tmv;
    boolean bool3 = this.Tmw;
    ab localab2 = this.Tmx;
    an localan = an.ThK;
    p.g(localan, "SourceElement.NO_SOURCE");
    parama = (av)new aj(parama, null, paramInt, localg, paramf, localab1, bool1, bool2, bool3, localab2, localan);
    AppMethodBeat.o(57344);
    return parama;
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final Collection<av> hAy()
  {
    AppMethodBeat.i(57346);
    Collection localCollection = hBz().hAy();
    p.g(localCollection, "containingDeclaration.overriddenDescriptors");
    Object localObject = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)((Iterator)localObject).next();
      p.g(locala, "it");
      localCollection.add((av)locala.hAw().get(this.index));
    }
    localCollection = (Collection)localCollection;
    AppMethodBeat.o(57346);
    return localCollection;
  }
  
  public final boolean hBA()
  {
    AppMethodBeat.i(57336);
    if (this.Tmu)
    {
      Object localObject = hBz();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        AppMethodBeat.o(57336);
        throw ((Throwable)localObject);
      }
      localObject = ((b)localObject).hAA();
      p.g(localObject, "(containingDeclaration a…bleMemberDescriptor).kind");
      if (((b.a)localObject).hAB())
      {
        AppMethodBeat.o(57336);
        return true;
      }
    }
    AppMethodBeat.o(57336);
    return false;
  }
  
  public final ab hBB()
  {
    return this.Tmx;
  }
  
  public final av hBC()
  {
    AppMethodBeat.i(57337);
    if (this.Tmt == (aj)this)
    {
      localav = (av)this;
      AppMethodBeat.o(57337);
      return localav;
    }
    av localav = this.Tmt.hBC();
    AppMethodBeat.o(57337);
    return localav;
  }
  
  public final boolean hBD()
  {
    return this.Tmv;
  }
  
  public final boolean hBE()
  {
    return this.Tmw;
  }
  
  public final boolean hBF()
  {
    return false;
  }
  
  public final boolean hBI()
  {
    return false;
  }
  
  public final kotlin.l.b.a.b.b.a hBz()
  {
    AppMethodBeat.i(57334);
    Object localObject = super.hzx();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
      AppMethodBeat.o(57334);
      throw ((Throwable)localObject);
    }
    localObject = (kotlin.l.b.a.b.b.a)localObject;
    AppMethodBeat.o(57334);
    return localObject;
  }
  
  public final ba hzE()
  {
    AppMethodBeat.i(57345);
    ba localba = az.ThV;
    p.g(localba, "Visibilities.LOCAL");
    AppMethodBeat.o(57345);
    return localba;
  }
  
  public static final class a {}
  
  public static final class b
    extends aj
  {
    private final kotlin.f Tmz;
    
    public b(kotlin.l.b.a.b.b.a parama, av paramav, int paramInt, kotlin.l.b.a.b.b.a.g paramg, kotlin.l.b.a.b.f.f paramf, ab paramab1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ab paramab2, an paraman, kotlin.g.a.a<? extends List<? extends ax>> parama1)
    {
      super(paramav, paramInt, paramg, paramf, paramab1, paramBoolean1, paramBoolean2, paramBoolean3, paramab2, paraman);
      AppMethodBeat.i(57333);
      this.Tmz = kotlin.g.ah(parama1);
      AppMethodBeat.o(57333);
    }
    
    public final av a(kotlin.l.b.a.b.b.a parama, kotlin.l.b.a.b.f.f paramf, int paramInt)
    {
      AppMethodBeat.i(57332);
      p.h(parama, "newOwner");
      p.h(paramf, "newName");
      kotlin.l.b.a.b.b.a.g localg = hzL();
      p.g(localg, "annotations");
      ab localab1 = hBy();
      p.g(localab1, "type");
      boolean bool1 = hBA();
      boolean bool2 = this.Tmv;
      boolean bool3 = this.Tmw;
      ab localab2 = this.Tmx;
      an localan = an.ThK;
      p.g(localan, "SourceElement.NO_SOURCE");
      parama = (av)new b(parama, null, paramInt, localg, paramf, localab1, bool1, bool2, bool3, localab2, localan, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(57332);
      return parama;
    }
    
    public final List<ax> hCz()
    {
      AppMethodBeat.i(57331);
      List localList = (List)this.Tmz.getValue();
      AppMethodBeat.o(57331);
      return localList;
    }
    
    static final class a
      extends q
      implements kotlin.g.a.a<List<? extends ax>>
    {
      a(aj.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.aj
 * JD-Core Version:    0.7.0.1
 */