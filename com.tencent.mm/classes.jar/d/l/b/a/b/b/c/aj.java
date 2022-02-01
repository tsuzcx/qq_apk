package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.ax;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.b;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.ba;
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
  public static final a LiO;
  private final av LiJ;
  private final boolean LiK;
  final boolean LiL;
  final boolean LiM;
  final ab LiN;
  private final int index;
  
  static
  {
    AppMethodBeat.i(57348);
    LiO = new a((byte)0);
    AppMethodBeat.o(57348);
  }
  
  public aj(d.l.b.a.b.b.a parama, av paramav, int paramInt, d.l.b.a.b.b.a.g paramg, d.l.b.a.b.f.f paramf, ab paramab1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ab paramab2, an paraman)
  {
    super((d.l.b.a.b.b.l)parama, paramg, paramf, paramab1, paraman);
    AppMethodBeat.i(57347);
    this.index = paramInt;
    this.LiK = paramBoolean1;
    this.LiL = paramBoolean2;
    this.LiM = paramBoolean3;
    this.LiN = paramab2;
    if (paramav == null) {}
    for (parama = (av)this;; parama = paramav)
    {
      this.LiJ = parama;
      AppMethodBeat.o(57347);
      return;
    }
  }
  
  public static final aj a(d.l.b.a.b.b.a parama, av paramav, int paramInt, d.l.b.a.b.b.a.g paramg, d.l.b.a.b.f.f paramf, ab paramab1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ab paramab2, an paraman, d.g.a.a<? extends List<? extends ax>> parama1)
  {
    AppMethodBeat.i(57349);
    d.g.b.k.h(parama, "containingDeclaration");
    d.g.b.k.h(paramg, "annotations");
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(paramab1, "outType");
    d.g.b.k.h(paraman, "source");
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
    d.g.b.k.h(parama, "newOwner");
    d.g.b.k.h(paramf, "newName");
    d.l.b.a.b.b.a.g localg = fQj();
    d.g.b.k.g(localg, "annotations");
    ab localab1 = fRV();
    d.g.b.k.g(localab1, "type");
    boolean bool1 = fRX();
    boolean bool2 = this.LiL;
    boolean bool3 = this.LiM;
    ab localab2 = this.LiN;
    an localan = an.Lec;
    d.g.b.k.g(localan, "SourceElement.NO_SOURCE");
    parama = (av)new aj(parama, null, paramInt, localg, paramf, localab1, bool1, bool2, bool3, localab2, localan);
    AppMethodBeat.o(57344);
    return parama;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57343);
    d.g.b.k.h(paramn, "visitor");
    paramn = paramn.a((av)this, paramD);
    AppMethodBeat.o(57343);
    return paramn;
  }
  
  public final Collection<av> fQW()
  {
    AppMethodBeat.i(57346);
    Collection localCollection = fRW().fQW();
    d.g.b.k.g(localCollection, "containingDeclaration.overriddenDescriptors");
    Object localObject = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d.l.b.a.b.b.a locala = (d.l.b.a.b.b.a)((Iterator)localObject).next();
      d.g.b.k.g(locala, "it");
      localCollection.add((av)locala.fQU().get(this.index));
    }
    localCollection = (Collection)localCollection;
    AppMethodBeat.o(57346);
    return localCollection;
  }
  
  public final ba fQb()
  {
    AppMethodBeat.i(57345);
    ba localba = az.Len;
    d.g.b.k.g(localba, "Visibilities.LOCAL");
    AppMethodBeat.o(57345);
    return localba;
  }
  
  public final d.l.b.a.b.b.a fRW()
  {
    AppMethodBeat.i(57334);
    Object localObject = super.fPU();
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
  
  public final boolean fRX()
  {
    AppMethodBeat.i(57336);
    if (this.LiK)
    {
      Object localObject = fRW();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        AppMethodBeat.o(57336);
        throw ((Throwable)localObject);
      }
      localObject = ((b)localObject).fQY();
      d.g.b.k.g(localObject, "(containingDeclaration a…bleMemberDescriptor).kind");
      if (((b.a)localObject).fQZ())
      {
        AppMethodBeat.o(57336);
        return true;
      }
    }
    AppMethodBeat.o(57336);
    return false;
  }
  
  public final ab fRY()
  {
    return this.LiN;
  }
  
  public final av fRZ()
  {
    AppMethodBeat.i(57337);
    if (this.LiJ == (aj)this)
    {
      localav = (av)this;
      AppMethodBeat.o(57337);
      return localav;
    }
    av localav = this.LiJ.fRZ();
    AppMethodBeat.o(57337);
    return localav;
  }
  
  public final boolean fSa()
  {
    return this.LiL;
  }
  
  public final boolean fSb()
  {
    return this.LiM;
  }
  
  public final boolean fSc()
  {
    return false;
  }
  
  public final boolean fSf()
  {
    return false;
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public static final class a {}
  
  public static final class b
    extends aj
  {
    private final d.f LiP;
    
    static
    {
      AppMethodBeat.i(57330);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(b.class), "destructuringVariables", "getDestructuringVariables()Ljava/util/List;")) };
      AppMethodBeat.o(57330);
    }
    
    public b(d.l.b.a.b.b.a parama, av paramav, int paramInt, d.l.b.a.b.b.a.g paramg, d.l.b.a.b.f.f paramf, ab paramab1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ab paramab2, an paraman, d.g.a.a<? extends List<? extends ax>> parama1)
    {
      super(paramav, paramInt, paramg, paramf, paramab1, paramBoolean1, paramBoolean2, paramBoolean3, paramab2, paraman);
      AppMethodBeat.i(57333);
      this.LiP = d.g.K(parama1);
      AppMethodBeat.o(57333);
    }
    
    public final av a(d.l.b.a.b.b.a parama, d.l.b.a.b.f.f paramf, int paramInt)
    {
      AppMethodBeat.i(57332);
      d.g.b.k.h(parama, "newOwner");
      d.g.b.k.h(paramf, "newName");
      d.l.b.a.b.b.a.g localg = fQj();
      d.g.b.k.g(localg, "annotations");
      ab localab1 = fRV();
      d.g.b.k.g(localab1, "type");
      boolean bool1 = fRX();
      boolean bool2 = this.LiL;
      boolean bool3 = this.LiM;
      ab localab2 = this.LiN;
      an localan = an.Lec;
      d.g.b.k.g(localan, "SourceElement.NO_SOURCE");
      parama = (av)new b(parama, null, paramInt, localg, paramf, localab1, bool1, bool2, bool3, localab2, localan, (d.g.a.a)new a(this));
      AppMethodBeat.o(57332);
      return parama;
    }
    
    public final List<ax> fSW()
    {
      AppMethodBeat.i(57331);
      List localList = (List)this.LiP.getValue();
      AppMethodBeat.o(57331);
      return localList;
    }
    
    static final class a
      extends d.g.b.l
      implements d.g.a.a<List<? extends ax>>
    {
      a(aj.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.aj
 * JD-Core Version:    0.7.0.1
 */