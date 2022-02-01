package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.t.a;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.p;

public final class s
  extends t
{
  private at aaNm;
  private final t aaOv;
  private final kotlin.l.b.a.b.m.ba aaOw;
  private kotlin.l.b.a.b.m.ba aaOx;
  private List<as> aaOy;
  private List<as> aaOz;
  
  public s(t paramt, kotlin.l.b.a.b.m.ba paramba)
  {
    this.aaOv = paramt;
    this.aaOw = paramba;
  }
  
  private kotlin.l.b.a.b.m.ba iGu()
  {
    AppMethodBeat.i(57133);
    if (this.aaOx == null)
    {
      if (!this.aaOw.aaOa.isEmpty()) {
        break label45;
      }
      this.aaOx = this.aaOw;
    }
    for (;;)
    {
      Object localObject = this.aaOx;
      AppMethodBeat.o(57133);
      return localObject;
      label45:
      localObject = this.aaOv.iDL().iCb();
      this.aaOy = new ArrayList(((List)localObject).size());
      this.aaOx = p.a((List)localObject, this.aaOw.iQc(), this, this.aaOy);
      this.aaOz = kotlin.a.j.c(this.aaOy, new kotlin.g.a.b() {});
    }
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57158);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57158);
    return paramn;
  }
  
  public final h a(i parami)
  {
    AppMethodBeat.i(57138);
    if (parami == null) {
      aDG(13);
    }
    parami = this.aaOv.a(parami);
    if (this.aaOw.aaOa.isEmpty())
    {
      if (parami == null) {
        aDG(14);
      }
      AppMethodBeat.o(57138);
      return parami;
    }
    parami = new kotlin.l.b.a.b.j.f.l(parami, iGu());
    AppMethodBeat.o(57138);
    return parami;
  }
  
  public final h a(ay paramay)
  {
    AppMethodBeat.i(57136);
    if (paramay == null) {
      aDG(10);
    }
    paramay = a(paramay, a.d(c.s(this)));
    if (paramay == null) {
      aDG(11);
    }
    AppMethodBeat.o(57136);
    return paramay;
  }
  
  public final h a(ay paramay, i parami)
  {
    AppMethodBeat.i(57135);
    if (paramay == null) {
      aDG(5);
    }
    if (parami == null) {
      aDG(6);
    }
    paramay = this.aaOv.a(paramay, parami);
    if (this.aaOw.aaOa.isEmpty())
    {
      if (paramay == null) {
        aDG(7);
      }
      AppMethodBeat.o(57135);
      return paramay;
    }
    paramay = new kotlin.l.b.a.b.j.f.l(paramay, iGu());
    AppMethodBeat.o(57135);
    return paramay;
  }
  
  public final Collection<d> iCg()
  {
    AppMethodBeat.i(57142);
    Object localObject = this.aaOv.iCg();
    ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      localArrayList.add(((d)locald.iFo().d(locald.iEY()).a(locald.iDO()).a(locald.iDQ()).a(locald.iEN()).Jg(false).iFu()).a(iGu()));
    }
    AppMethodBeat.o(57142);
    return localArrayList;
  }
  
  public final kotlin.l.b.a.b.b.l iDJ()
  {
    AppMethodBeat.i(57146);
    kotlin.l.b.a.b.b.l locall = this.aaOv.iDJ();
    if (locall == null) {
      aDG(21);
    }
    AppMethodBeat.o(57146);
    return locall;
  }
  
  public final h iDK()
  {
    AppMethodBeat.i(57139);
    h localh = this.aaOv.iDK();
    if (localh == null) {
      aDG(15);
    }
    AppMethodBeat.o(57139);
    return localh;
  }
  
  public final at iDL()
  {
    AppMethodBeat.i(57134);
    Object localObject2 = this.aaOv.iDL();
    if (this.aaOw.aaOa.isEmpty())
    {
      if (localObject2 == null) {
        aDG(0);
      }
      AppMethodBeat.o(57134);
      return localObject2;
    }
    if (this.aaNm == null)
    {
      localObject1 = iGu();
      Object localObject3 = ((at)localObject2).iGk();
      localObject2 = new ArrayList(((Collection)localObject3).size());
      localObject3 = ((Collection)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((kotlin.l.b.a.b.m.ba)localObject1).c((ab)((Iterator)localObject3).next(), bh.abrp));
      }
      this.aaNm = new kotlin.l.b.a.b.m.j(this, this.aaOy, (Collection)localObject2, kotlin.l.b.a.b.l.b.abpp);
    }
    Object localObject1 = this.aaNm;
    if (localObject1 == null) {
      aDG(1);
    }
    AppMethodBeat.o(57134);
    return localObject1;
  }
  
  public final e iDM()
  {
    AppMethodBeat.i(57147);
    e locale = this.aaOv.iDM();
    AppMethodBeat.o(57147);
    return locale;
  }
  
  public final kotlin.l.b.a.b.b.f iDN()
  {
    AppMethodBeat.i(57148);
    kotlin.l.b.a.b.b.f localf = this.aaOv.iDN();
    if (localf == null) {
      aDG(24);
    }
    AppMethodBeat.o(57148);
    return localf;
  }
  
  public final w iDO()
  {
    AppMethodBeat.i(57149);
    w localw = this.aaOv.iDO();
    if (localw == null) {
      aDG(25);
    }
    AppMethodBeat.o(57149);
    return localw;
  }
  
  public final d iDP()
  {
    AppMethodBeat.i(57160);
    d locald = this.aaOv.iDP();
    AppMethodBeat.o(57160);
    return locald;
  }
  
  public final kotlin.l.b.a.b.b.ba iDQ()
  {
    AppMethodBeat.i(57150);
    kotlin.l.b.a.b.b.ba localba = this.aaOv.iDQ();
    if (localba == null) {
      aDG(26);
    }
    AppMethodBeat.o(57150);
    return localba;
  }
  
  public final boolean iDR()
  {
    AppMethodBeat.i(57155);
    boolean bool = this.aaOv.iDR();
    AppMethodBeat.o(57155);
    return bool;
  }
  
  public final boolean iDS()
  {
    AppMethodBeat.i(57151);
    boolean bool = this.aaOv.iDS();
    AppMethodBeat.o(57151);
    return bool;
  }
  
  public final boolean iDT()
  {
    AppMethodBeat.i(57152);
    boolean bool = this.aaOv.iDT();
    AppMethodBeat.o(57152);
    return bool;
  }
  
  public final boolean iDU()
  {
    AppMethodBeat.i(57153);
    boolean bool = this.aaOv.iDU();
    AppMethodBeat.o(57153);
    return bool;
  }
  
  public final boolean iDV()
  {
    AppMethodBeat.i(57156);
    boolean bool = this.aaOv.iDV();
    AppMethodBeat.o(57156);
    return bool;
  }
  
  public final boolean iDW()
  {
    AppMethodBeat.i(57157);
    boolean bool = this.aaOv.iDW();
    AppMethodBeat.o(57157);
    return bool;
  }
  
  public final boolean iDX()
  {
    AppMethodBeat.i(57154);
    boolean bool = this.aaOv.iDX();
    AppMethodBeat.o(57154);
    return bool;
  }
  
  public final g iDY()
  {
    AppMethodBeat.i(57143);
    g localg = this.aaOv.iDY();
    if (localg == null) {
      aDG(18);
    }
    AppMethodBeat.o(57143);
    return localg;
  }
  
  public final an iDZ()
  {
    AppMethodBeat.i(57161);
    an localan = an.aaKE;
    if (localan == null) {
      aDG(28);
    }
    AppMethodBeat.o(57161);
    return localan;
  }
  
  public final aj iET()
  {
    AppMethodBeat.i(57140);
    Object localObject = bc.lF(iDL().iCb());
    localObject = ac.a(iDY(), iDL(), (List)localObject, false, iEZ());
    AppMethodBeat.o(57140);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.f.f iEU()
  {
    AppMethodBeat.i(57144);
    kotlin.l.b.a.b.f.f localf = this.aaOv.iEU();
    if (localf == null) {
      aDG(19);
    }
    AppMethodBeat.o(57144);
    return localf;
  }
  
  public final h iEZ()
  {
    AppMethodBeat.i(57137);
    h localh = a(a.d(c.s(this.aaOv)));
    if (localh == null) {
      aDG(12);
    }
    AppMethodBeat.o(57137);
    return localh;
  }
  
  public final Collection<e> iEa()
  {
    AppMethodBeat.i(57163);
    Collection localCollection = this.aaOv.iEa();
    if (localCollection == null) {
      aDG(30);
    }
    AppMethodBeat.o(57163);
    return localCollection;
  }
  
  public final List<as> iEb()
  {
    AppMethodBeat.i(57162);
    iGu();
    List localList = this.aaOz;
    if (localList == null) {
      aDG(29);
    }
    AppMethodBeat.o(57162);
    return localList;
  }
  
  public final h iFa()
  {
    AppMethodBeat.i(57159);
    h localh = this.aaOv.iFa();
    if (localh == null) {
      aDG(27);
    }
    AppMethodBeat.o(57159);
    return localh;
  }
  
  public final ak iFb()
  {
    AppMethodBeat.i(57141);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(57141);
    throw localUnsupportedOperationException;
  }
  
  public final e iFc()
  {
    AppMethodBeat.i(57145);
    e locale = this.aaOv.iFc();
    if (locale == null) {
      aDG(20);
    }
    AppMethodBeat.o(57145);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.s
 * JD-Core Version:    0.7.0.1
 */