package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.ax;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.b;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.n;
import d.l.b.a.b.m.ab;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aj
  extends ak
  implements av
{
  public static final a MZK;
  private final av MZF;
  private final boolean MZG;
  final boolean MZH;
  final boolean MZI;
  final ab MZJ;
  private final int index;
  
  static
  {
    AppMethodBeat.i(57348);
    MZK = new a((byte)0);
    AppMethodBeat.o(57348);
  }
  
  public aj(d.l.b.a.b.b.a parama, av paramav, int paramInt, d.l.b.a.b.b.a.g paramg, d.l.b.a.b.f.f paramf, ab paramab1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ab paramab2, an paraman)
  {
    super((l)parama, paramg, paramf, paramab1, paraman);
    AppMethodBeat.i(57347);
    this.index = paramInt;
    this.MZG = paramBoolean1;
    this.MZH = paramBoolean2;
    this.MZI = paramBoolean3;
    this.MZJ = paramab2;
    if (paramav == null) {}
    for (parama = (av)this;; parama = paramav)
    {
      this.MZF = parama;
      AppMethodBeat.o(57347);
      return;
    }
  }
  
  public static final aj a(d.l.b.a.b.b.a parama, av paramav, int paramInt, d.l.b.a.b.b.a.g paramg, d.l.b.a.b.f.f paramf, ab paramab1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ab paramab2, an paraman, d.g.a.a<? extends List<? extends ax>> parama1)
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
  
  public av a(d.l.b.a.b.b.a parama, d.l.b.a.b.f.f paramf, int paramInt)
  {
    AppMethodBeat.i(57344);
    p.h(parama, "newOwner");
    p.h(paramf, "newName");
    d.l.b.a.b.b.a.g localg = ghH();
    p.g(localg, "annotations");
    ab localab1 = gju();
    p.g(localab1, "type");
    boolean bool1 = gjw();
    boolean bool2 = this.MZH;
    boolean bool3 = this.MZI;
    ab localab2 = this.MZJ;
    an localan = an.MUX;
    p.g(localan, "SourceElement.NO_SOURCE");
    parama = (av)new aj(parama, null, paramInt, localg, paramf, localab1, bool1, bool2, bool3, localab2, localan);
    AppMethodBeat.o(57344);
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
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final ba ghz()
  {
    AppMethodBeat.i(57345);
    ba localba = az.MVi;
    p.g(localba, "Visibilities.LOCAL");
    AppMethodBeat.o(57345);
    return localba;
  }
  
  public final Collection<av> giu()
  {
    AppMethodBeat.i(57346);
    Collection localCollection = gjv().giu();
    p.g(localCollection, "containingDeclaration.overriddenDescriptors");
    Object localObject = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d.l.b.a.b.b.a locala = (d.l.b.a.b.b.a)((Iterator)localObject).next();
      p.g(locala, "it");
      localCollection.add((av)locala.gis().get(this.index));
    }
    localCollection = (Collection)localCollection;
    AppMethodBeat.o(57346);
    return localCollection;
  }
  
  public final boolean gjA()
  {
    return this.MZI;
  }
  
  public final boolean gjB()
  {
    return false;
  }
  
  public final boolean gjE()
  {
    return false;
  }
  
  public final d.l.b.a.b.b.a gjv()
  {
    AppMethodBeat.i(57334);
    Object localObject = super.ghs();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
      AppMethodBeat.o(57334);
      throw ((Throwable)localObject);
    }
    localObject = (d.l.b.a.b.b.a)localObject;
    AppMethodBeat.o(57334);
    return localObject;
  }
  
  public final boolean gjw()
  {
    AppMethodBeat.i(57336);
    if (this.MZG)
    {
      Object localObject = gjv();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        AppMethodBeat.o(57336);
        throw ((Throwable)localObject);
      }
      localObject = ((b)localObject).giw();
      p.g(localObject, "(containingDeclaration a…bleMemberDescriptor).kind");
      if (((b.a)localObject).gix())
      {
        AppMethodBeat.o(57336);
        return true;
      }
    }
    AppMethodBeat.o(57336);
    return false;
  }
  
  public final ab gjx()
  {
    return this.MZJ;
  }
  
  public final av gjy()
  {
    AppMethodBeat.i(57337);
    if (this.MZF == (aj)this)
    {
      localav = (av)this;
      AppMethodBeat.o(57337);
      return localav;
    }
    av localav = this.MZF.gjy();
    AppMethodBeat.o(57337);
    return localav;
  }
  
  public final boolean gjz()
  {
    return this.MZH;
  }
  
  public static final class a {}
  
  public static final class b
    extends aj
  {
    private final d.f MZL;
    
    public b(d.l.b.a.b.b.a parama, av paramav, int paramInt, d.l.b.a.b.b.a.g paramg, d.l.b.a.b.f.f paramf, ab paramab1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ab paramab2, an paraman, d.g.a.a<? extends List<? extends ax>> parama1)
    {
      super(paramav, paramInt, paramg, paramf, paramab1, paramBoolean1, paramBoolean2, paramBoolean3, paramab2, paraman);
      AppMethodBeat.i(57333);
      this.MZL = d.g.O(parama1);
      AppMethodBeat.o(57333);
    }
    
    public final av a(d.l.b.a.b.b.a parama, d.l.b.a.b.f.f paramf, int paramInt)
    {
      AppMethodBeat.i(57332);
      p.h(parama, "newOwner");
      p.h(paramf, "newName");
      d.l.b.a.b.b.a.g localg = ghH();
      p.g(localg, "annotations");
      ab localab1 = gju();
      p.g(localab1, "type");
      boolean bool1 = gjw();
      boolean bool2 = this.MZH;
      boolean bool3 = this.MZI;
      ab localab2 = this.MZJ;
      an localan = an.MUX;
      p.g(localan, "SourceElement.NO_SOURCE");
      parama = (av)new b(parama, null, paramInt, localg, paramf, localab1, bool1, bool2, bool3, localab2, localan, (d.g.a.a)new a(this));
      AppMethodBeat.o(57332);
      return parama;
    }
    
    public final List<ax> gkv()
    {
      AppMethodBeat.i(57331);
      List localList = (List)this.MZL.getValue();
      AppMethodBeat.o(57331);
      return localList;
    }
    
    static final class a
      extends q
      implements d.g.a.a<List<? extends ax>>
    {
      a(aj.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.aj
 * JD-Core Version:    0.7.0.1
 */