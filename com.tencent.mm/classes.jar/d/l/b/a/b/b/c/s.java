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
  private at LgI;
  private final t LhR;
  private final d.l.b.a.b.m.ba LhS;
  private d.l.b.a.b.m.ba LhT;
  private List<as> LhU;
  private List<as> LhV;
  
  public s(t paramt, d.l.b.a.b.m.ba paramba)
  {
    this.LhR = paramt;
    this.LhS = paramba;
  }
  
  private d.l.b.a.b.m.ba fSC()
  {
    AppMethodBeat.i(57133);
    if (this.LhT == null)
    {
      if (!this.LhS.Lhw.isEmpty()) {
        break label45;
      }
      this.LhT = this.LhS;
    }
    for (;;)
    {
      Object localObject = this.LhT;
      AppMethodBeat.o(57133);
      return localObject;
      label45:
      localObject = this.LhR.fPW().getParameters();
      this.LhU = new ArrayList(((List)localObject).size());
      this.LhT = p.a((List)localObject, this.LhS.gcE(), this, this.LhU);
      this.LhV = d.a.j.c(this.LhU, new d.g.a.b() {});
    }
  }
  
  public final h a(i parami)
  {
    AppMethodBeat.i(57138);
    if (parami == null) {
      agL(13);
    }
    parami = this.LhR.a(parami);
    if (this.LhS.Lhw.isEmpty())
    {
      if (parami == null) {
        agL(14);
      }
      AppMethodBeat.o(57138);
      return parami;
    }
    parami = new d.l.b.a.b.j.f.l(parami, fSC());
    AppMethodBeat.o(57138);
    return parami;
  }
  
  public final h a(ay paramay)
  {
    AppMethodBeat.i(57136);
    if (paramay == null) {
      agL(10);
    }
    paramay = a(paramay, a.d(c.s(this)));
    if (paramay == null) {
      agL(11);
    }
    AppMethodBeat.o(57136);
    return paramay;
  }
  
  public final h a(ay paramay, i parami)
  {
    AppMethodBeat.i(57135);
    if (paramay == null) {
      agL(5);
    }
    if (parami == null) {
      agL(6);
    }
    paramay = this.LhR.a(paramay, parami);
    if (this.LhS.Lhw.isEmpty())
    {
      if (paramay == null) {
        agL(7);
      }
      AppMethodBeat.o(57135);
      return paramay;
    }
    paramay = new d.l.b.a.b.j.f.l(paramay, fSC());
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
  
  public final Collection<d> fOv()
  {
    AppMethodBeat.i(57142);
    Object localObject = this.LhR.fOv();
    ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      localArrayList.add(((d)locald.fRx().d(locald.fRi()).a(locald.fPZ()).a(locald.fQb()).a(locald.fQY()).zj(false).fRD()).a(fSC()));
    }
    AppMethodBeat.o(57142);
    return localArrayList;
  }
  
  public final d.l.b.a.b.b.l fPU()
  {
    AppMethodBeat.i(57146);
    d.l.b.a.b.b.l locall = this.LhR.fPU();
    if (locall == null) {
      agL(21);
    }
    AppMethodBeat.o(57146);
    return locall;
  }
  
  public final h fPV()
  {
    AppMethodBeat.i(57139);
    h localh = this.LhR.fPV();
    if (localh == null) {
      agL(15);
    }
    AppMethodBeat.o(57139);
    return localh;
  }
  
  public final at fPW()
  {
    AppMethodBeat.i(57134);
    Object localObject2 = this.LhR.fPW();
    if (this.LhS.Lhw.isEmpty())
    {
      if (localObject2 == null) {
        agL(0);
      }
      AppMethodBeat.o(57134);
      return localObject2;
    }
    if (this.LgI == null)
    {
      localObject1 = fSC();
      Object localObject3 = ((at)localObject2).fSt();
      localObject2 = new ArrayList(((Collection)localObject3).size());
      localObject3 = ((Collection)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((d.l.b.a.b.m.ba)localObject1).c((ab)((Iterator)localObject3).next(), bh.LLV));
      }
      this.LgI = new d.l.b.a.b.m.j(this, this.LhU, (Collection)localObject2, d.l.b.a.b.l.b.LJP);
    }
    Object localObject1 = this.LgI;
    if (localObject1 == null) {
      agL(1);
    }
    AppMethodBeat.o(57134);
    return localObject1;
  }
  
  public final e fPX()
  {
    AppMethodBeat.i(57147);
    e locale = this.LhR.fPX();
    AppMethodBeat.o(57147);
    return locale;
  }
  
  public final d.l.b.a.b.b.f fPY()
  {
    AppMethodBeat.i(57148);
    d.l.b.a.b.b.f localf = this.LhR.fPY();
    if (localf == null) {
      agL(24);
    }
    AppMethodBeat.o(57148);
    return localf;
  }
  
  public final w fPZ()
  {
    AppMethodBeat.i(57149);
    w localw = this.LhR.fPZ();
    if (localw == null) {
      agL(25);
    }
    AppMethodBeat.o(57149);
    return localw;
  }
  
  public final d fQa()
  {
    AppMethodBeat.i(57160);
    d locald = this.LhR.fQa();
    AppMethodBeat.o(57160);
    return locald;
  }
  
  public final d.l.b.a.b.b.ba fQb()
  {
    AppMethodBeat.i(57150);
    d.l.b.a.b.b.ba localba = this.LhR.fQb();
    if (localba == null) {
      agL(26);
    }
    AppMethodBeat.o(57150);
    return localba;
  }
  
  public final boolean fQc()
  {
    AppMethodBeat.i(57155);
    boolean bool = this.LhR.fQc();
    AppMethodBeat.o(57155);
    return bool;
  }
  
  public final boolean fQd()
  {
    AppMethodBeat.i(57151);
    boolean bool = this.LhR.fQd();
    AppMethodBeat.o(57151);
    return bool;
  }
  
  public final boolean fQe()
  {
    AppMethodBeat.i(57152);
    boolean bool = this.LhR.fQe();
    AppMethodBeat.o(57152);
    return bool;
  }
  
  public final boolean fQf()
  {
    AppMethodBeat.i(57153);
    boolean bool = this.LhR.fQf();
    AppMethodBeat.o(57153);
    return bool;
  }
  
  public final boolean fQg()
  {
    AppMethodBeat.i(57156);
    boolean bool = this.LhR.fQg();
    AppMethodBeat.o(57156);
    return bool;
  }
  
  public final boolean fQh()
  {
    AppMethodBeat.i(57157);
    boolean bool = this.LhR.fQh();
    AppMethodBeat.o(57157);
    return bool;
  }
  
  public final boolean fQi()
  {
    AppMethodBeat.i(57154);
    boolean bool = this.LhR.fQi();
    AppMethodBeat.o(57154);
    return bool;
  }
  
  public final g fQj()
  {
    AppMethodBeat.i(57143);
    g localg = this.LhR.fQj();
    if (localg == null) {
      agL(18);
    }
    AppMethodBeat.o(57143);
    return localg;
  }
  
  public final an fQk()
  {
    AppMethodBeat.i(57161);
    an localan = an.Lec;
    if (localan == null) {
      agL(28);
    }
    AppMethodBeat.o(57161);
    return localan;
  }
  
  public final Collection<e> fQl()
  {
    AppMethodBeat.i(57163);
    Collection localCollection = this.LhR.fQl();
    if (localCollection == null) {
      agL(30);
    }
    AppMethodBeat.o(57163);
    return localCollection;
  }
  
  public final List<as> fQm()
  {
    AppMethodBeat.i(57162);
    fSC();
    List localList = this.LhV;
    if (localList == null) {
      agL(29);
    }
    AppMethodBeat.o(57162);
    return localList;
  }
  
  public final aj fRe()
  {
    AppMethodBeat.i(57140);
    Object localObject = bc.jf(fPW().getParameters());
    localObject = ac.a(fQj(), this, (List)localObject);
    if (localObject == null) {
      agL(16);
    }
    AppMethodBeat.o(57140);
    return localObject;
  }
  
  public final d.l.b.a.b.f.f fRf()
  {
    AppMethodBeat.i(57144);
    d.l.b.a.b.f.f localf = this.LhR.fRf();
    if (localf == null) {
      agL(19);
    }
    AppMethodBeat.o(57144);
    return localf;
  }
  
  public final h fRj()
  {
    AppMethodBeat.i(57137);
    h localh = a(a.d(c.s(this.LhR)));
    if (localh == null) {
      agL(12);
    }
    AppMethodBeat.o(57137);
    return localh;
  }
  
  public final h fRk()
  {
    AppMethodBeat.i(57159);
    h localh = this.LhR.fRk();
    if (localh == null) {
      agL(27);
    }
    AppMethodBeat.o(57159);
    return localh;
  }
  
  public final ak fRl()
  {
    AppMethodBeat.i(57141);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(57141);
    throw localUnsupportedOperationException;
  }
  
  public final e fRm()
  {
    AppMethodBeat.i(57145);
    e locale = this.LhR.fRm();
    if (locale == null) {
      agL(20);
    }
    AppMethodBeat.o(57145);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.s
 * JD-Core Version:    0.7.0.1
 */