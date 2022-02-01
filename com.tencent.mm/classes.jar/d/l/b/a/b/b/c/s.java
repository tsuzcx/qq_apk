package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.d;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.n;
import d.l.b.a.b.b.t.a;
import d.l.b.a.b.b.w;
import d.l.b.a.b.j.c;
import d.l.b.a.b.j.d.a;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.a.i;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.ay;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class s
  extends t
{
  private at NuK;
  private final t NvT;
  private final d.l.b.a.b.m.ba NvU;
  private d.l.b.a.b.m.ba NvV;
  private List<as> NvW;
  private List<as> NvX;
  
  public s(t paramt, d.l.b.a.b.m.ba paramba)
  {
    this.NvT = paramt;
    this.NvU = paramba;
  }
  
  private d.l.b.a.b.m.ba goD()
  {
    AppMethodBeat.i(57133);
    if (this.NvV == null)
    {
      if (!this.NvU.Nvy.isEmpty()) {
        break label45;
      }
      this.NvV = this.NvU;
    }
    for (;;)
    {
      Object localObject = this.NvV;
      AppMethodBeat.o(57133);
      return localObject;
      label45:
      localObject = this.NvT.glW().getParameters();
      this.NvW = new ArrayList(((List)localObject).size());
      this.NvV = p.a((List)localObject, this.NvU.gyH(), this, this.NvW);
      this.NvX = d.a.j.c(this.NvW, new d.g.a.b() {});
    }
  }
  
  public final h a(i parami)
  {
    AppMethodBeat.i(57138);
    if (parami == null) {
      ajW(13);
    }
    parami = this.NvT.a(parami);
    if (this.NvU.Nvy.isEmpty())
    {
      if (parami == null) {
        ajW(14);
      }
      AppMethodBeat.o(57138);
      return parami;
    }
    parami = new d.l.b.a.b.j.f.l(parami, goD());
    AppMethodBeat.o(57138);
    return parami;
  }
  
  public final h a(ay paramay)
  {
    AppMethodBeat.i(57136);
    if (paramay == null) {
      ajW(10);
    }
    paramay = a(paramay, a.d(c.s(this)));
    if (paramay == null) {
      ajW(11);
    }
    AppMethodBeat.o(57136);
    return paramay;
  }
  
  public final h a(ay paramay, i parami)
  {
    AppMethodBeat.i(57135);
    if (paramay == null) {
      ajW(5);
    }
    if (parami == null) {
      ajW(6);
    }
    paramay = this.NvT.a(paramay, parami);
    if (this.NvU.Nvy.isEmpty())
    {
      if (paramay == null) {
        ajW(7);
      }
      AppMethodBeat.o(57135);
      return paramay;
    }
    paramay = new d.l.b.a.b.j.f.l(paramay, goD());
    AppMethodBeat.o(57135);
    return paramay;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57158);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57158);
    return paramn;
  }
  
  public final Collection<d> gkx()
  {
    AppMethodBeat.i(57142);
    Object localObject = this.NvT.gkx();
    ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      localArrayList.add(((d)locald.gny().d(locald.gnj()).a(locald.glZ()).a(locald.gmb()).a(locald.gmY()).Ak(false).gnE()).a(goD()));
    }
    AppMethodBeat.o(57142);
    return localArrayList;
  }
  
  public final d.l.b.a.b.b.l glU()
  {
    AppMethodBeat.i(57146);
    d.l.b.a.b.b.l locall = this.NvT.glU();
    if (locall == null) {
      ajW(21);
    }
    AppMethodBeat.o(57146);
    return locall;
  }
  
  public final h glV()
  {
    AppMethodBeat.i(57139);
    h localh = this.NvT.glV();
    if (localh == null) {
      ajW(15);
    }
    AppMethodBeat.o(57139);
    return localh;
  }
  
  public final at glW()
  {
    AppMethodBeat.i(57134);
    Object localObject2 = this.NvT.glW();
    if (this.NvU.Nvy.isEmpty())
    {
      if (localObject2 == null) {
        ajW(0);
      }
      AppMethodBeat.o(57134);
      return localObject2;
    }
    if (this.NuK == null)
    {
      localObject1 = goD();
      Object localObject3 = ((at)localObject2).got();
      localObject2 = new ArrayList(((Collection)localObject3).size());
      localObject3 = ((Collection)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((d.l.b.a.b.m.ba)localObject1).c((ab)((Iterator)localObject3).next(), bh.NZW));
      }
      this.NuK = new d.l.b.a.b.m.j(this, this.NvW, (Collection)localObject2, d.l.b.a.b.l.b.NXU);
    }
    Object localObject1 = this.NuK;
    if (localObject1 == null) {
      ajW(1);
    }
    AppMethodBeat.o(57134);
    return localObject1;
  }
  
  public final e glX()
  {
    AppMethodBeat.i(57147);
    e locale = this.NvT.glX();
    AppMethodBeat.o(57147);
    return locale;
  }
  
  public final d.l.b.a.b.b.f glY()
  {
    AppMethodBeat.i(57148);
    d.l.b.a.b.b.f localf = this.NvT.glY();
    if (localf == null) {
      ajW(24);
    }
    AppMethodBeat.o(57148);
    return localf;
  }
  
  public final w glZ()
  {
    AppMethodBeat.i(57149);
    w localw = this.NvT.glZ();
    if (localw == null) {
      ajW(25);
    }
    AppMethodBeat.o(57149);
    return localw;
  }
  
  public final d gma()
  {
    AppMethodBeat.i(57160);
    d locald = this.NvT.gma();
    AppMethodBeat.o(57160);
    return locald;
  }
  
  public final d.l.b.a.b.b.ba gmb()
  {
    AppMethodBeat.i(57150);
    d.l.b.a.b.b.ba localba = this.NvT.gmb();
    if (localba == null) {
      ajW(26);
    }
    AppMethodBeat.o(57150);
    return localba;
  }
  
  public final boolean gmc()
  {
    AppMethodBeat.i(57155);
    boolean bool = this.NvT.gmc();
    AppMethodBeat.o(57155);
    return bool;
  }
  
  public final boolean gmd()
  {
    AppMethodBeat.i(57151);
    boolean bool = this.NvT.gmd();
    AppMethodBeat.o(57151);
    return bool;
  }
  
  public final boolean gme()
  {
    AppMethodBeat.i(57152);
    boolean bool = this.NvT.gme();
    AppMethodBeat.o(57152);
    return bool;
  }
  
  public final boolean gmf()
  {
    AppMethodBeat.i(57153);
    boolean bool = this.NvT.gmf();
    AppMethodBeat.o(57153);
    return bool;
  }
  
  public final boolean gmg()
  {
    AppMethodBeat.i(57156);
    boolean bool = this.NvT.gmg();
    AppMethodBeat.o(57156);
    return bool;
  }
  
  public final boolean gmh()
  {
    AppMethodBeat.i(57157);
    boolean bool = this.NvT.gmh();
    AppMethodBeat.o(57157);
    return bool;
  }
  
  public final boolean gmi()
  {
    AppMethodBeat.i(57154);
    boolean bool = this.NvT.gmi();
    AppMethodBeat.o(57154);
    return bool;
  }
  
  public final g gmj()
  {
    AppMethodBeat.i(57143);
    g localg = this.NvT.gmj();
    if (localg == null) {
      ajW(18);
    }
    AppMethodBeat.o(57143);
    return localg;
  }
  
  public final an gmk()
  {
    AppMethodBeat.i(57161);
    an localan = an.Nsc;
    if (localan == null) {
      ajW(28);
    }
    AppMethodBeat.o(57161);
    return localan;
  }
  
  public final Collection<e> gml()
  {
    AppMethodBeat.i(57163);
    Collection localCollection = this.NvT.gml();
    if (localCollection == null) {
      ajW(30);
    }
    AppMethodBeat.o(57163);
    return localCollection;
  }
  
  public final List<as> gmm()
  {
    AppMethodBeat.i(57162);
    goD();
    List localList = this.NvX;
    if (localList == null) {
      ajW(29);
    }
    AppMethodBeat.o(57162);
    return localList;
  }
  
  public final aj gne()
  {
    AppMethodBeat.i(57140);
    Object localObject = bc.jC(glW().getParameters());
    localObject = ac.a(gmj(), glW(), (List)localObject, gnk());
    AppMethodBeat.o(57140);
    return localObject;
  }
  
  public final d.l.b.a.b.f.f gnf()
  {
    AppMethodBeat.i(57144);
    d.l.b.a.b.f.f localf = this.NvT.gnf();
    if (localf == null) {
      ajW(19);
    }
    AppMethodBeat.o(57144);
    return localf;
  }
  
  public final h gnk()
  {
    AppMethodBeat.i(57137);
    h localh = a(a.d(c.s(this.NvT)));
    if (localh == null) {
      ajW(12);
    }
    AppMethodBeat.o(57137);
    return localh;
  }
  
  public final h gnl()
  {
    AppMethodBeat.i(57159);
    h localh = this.NvT.gnl();
    if (localh == null) {
      ajW(27);
    }
    AppMethodBeat.o(57159);
    return localh;
  }
  
  public final ak gnm()
  {
    AppMethodBeat.i(57141);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(57141);
    throw localUnsupportedOperationException;
  }
  
  public final e gnn()
  {
    AppMethodBeat.i(57145);
    e locale = this.NvT.gnn();
    if (locale == null) {
      ajW(20);
    }
    AppMethodBeat.o(57145);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.s
 * JD-Core Version:    0.7.0.1
 */