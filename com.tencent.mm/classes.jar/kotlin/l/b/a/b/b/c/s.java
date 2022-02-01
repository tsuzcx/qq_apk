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
  private at Tks;
  private final t TlB;
  private final kotlin.l.b.a.b.m.ba TlC;
  private kotlin.l.b.a.b.m.ba TlD;
  private List<as> TlE;
  private List<as> TlF;
  
  public s(t paramt, kotlin.l.b.a.b.m.ba paramba)
  {
    this.TlB = paramt;
    this.TlC = paramba;
  }
  
  private kotlin.l.b.a.b.m.ba hCf()
  {
    AppMethodBeat.i(57133);
    if (this.TlD == null)
    {
      if (!this.TlC.Tlg.isEmpty()) {
        break label45;
      }
      this.TlD = this.TlC;
    }
    for (;;)
    {
      Object localObject = this.TlD;
      AppMethodBeat.o(57133);
      return localObject;
      label45:
      localObject = this.TlB.hzz().getParameters();
      this.TlE = new ArrayList(((List)localObject).size());
      this.TlD = p.a((List)localObject, this.TlC.hLK(), this, this.TlE);
      this.TlF = kotlin.a.j.c(this.TlE, new kotlin.g.a.b() {});
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
      atM(13);
    }
    parami = this.TlB.a(parami);
    if (this.TlC.Tlg.isEmpty())
    {
      if (parami == null) {
        atM(14);
      }
      AppMethodBeat.o(57138);
      return parami;
    }
    parami = new kotlin.l.b.a.b.j.f.l(parami, hCf());
    AppMethodBeat.o(57138);
    return parami;
  }
  
  public final h a(ay paramay)
  {
    AppMethodBeat.i(57136);
    if (paramay == null) {
      atM(10);
    }
    paramay = a(paramay, a.d(c.s(this)));
    if (paramay == null) {
      atM(11);
    }
    AppMethodBeat.o(57136);
    return paramay;
  }
  
  public final h a(ay paramay, i parami)
  {
    AppMethodBeat.i(57135);
    if (paramay == null) {
      atM(5);
    }
    if (parami == null) {
      atM(6);
    }
    paramay = this.TlB.a(paramay, parami);
    if (this.TlC.Tlg.isEmpty())
    {
      if (paramay == null) {
        atM(7);
      }
      AppMethodBeat.o(57135);
      return paramay;
    }
    paramay = new kotlin.l.b.a.b.j.f.l(paramay, hCf());
    AppMethodBeat.o(57135);
    return paramay;
  }
  
  public final aj hAG()
  {
    AppMethodBeat.i(57140);
    Object localObject = bc.kI(hzz().getParameters());
    localObject = ac.a(hzL(), hzz(), (List)localObject, false, hAM());
    AppMethodBeat.o(57140);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.f.f hAH()
  {
    AppMethodBeat.i(57144);
    kotlin.l.b.a.b.f.f localf = this.TlB.hAH();
    if (localf == null) {
      atM(19);
    }
    AppMethodBeat.o(57144);
    return localf;
  }
  
  public final h hAM()
  {
    AppMethodBeat.i(57137);
    h localh = a(a.d(c.s(this.TlB)));
    if (localh == null) {
      atM(12);
    }
    AppMethodBeat.o(57137);
    return localh;
  }
  
  public final h hAN()
  {
    AppMethodBeat.i(57159);
    h localh = this.TlB.hAN();
    if (localh == null) {
      atM(27);
    }
    AppMethodBeat.o(57159);
    return localh;
  }
  
  public final ak hAO()
  {
    AppMethodBeat.i(57141);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(57141);
    throw localUnsupportedOperationException;
  }
  
  public final e hAP()
  {
    AppMethodBeat.i(57145);
    e locale = this.TlB.hAP();
    if (locale == null) {
      atM(20);
    }
    AppMethodBeat.o(57145);
    return locale;
  }
  
  public final Collection<d> hxW()
  {
    AppMethodBeat.i(57142);
    Object localObject = this.TlB.hxW();
    ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      localArrayList.add(((d)locald.hBa().d(locald.hAL()).a(locald.hzC()).a(locald.hzE()).a(locald.hAA()).EB(false).hBg()).a(hCf()));
    }
    AppMethodBeat.o(57142);
    return localArrayList;
  }
  
  public final e hzA()
  {
    AppMethodBeat.i(57147);
    e locale = this.TlB.hzA();
    AppMethodBeat.o(57147);
    return locale;
  }
  
  public final kotlin.l.b.a.b.b.f hzB()
  {
    AppMethodBeat.i(57148);
    kotlin.l.b.a.b.b.f localf = this.TlB.hzB();
    if (localf == null) {
      atM(24);
    }
    AppMethodBeat.o(57148);
    return localf;
  }
  
  public final w hzC()
  {
    AppMethodBeat.i(57149);
    w localw = this.TlB.hzC();
    if (localw == null) {
      atM(25);
    }
    AppMethodBeat.o(57149);
    return localw;
  }
  
  public final d hzD()
  {
    AppMethodBeat.i(57160);
    d locald = this.TlB.hzD();
    AppMethodBeat.o(57160);
    return locald;
  }
  
  public final kotlin.l.b.a.b.b.ba hzE()
  {
    AppMethodBeat.i(57150);
    kotlin.l.b.a.b.b.ba localba = this.TlB.hzE();
    if (localba == null) {
      atM(26);
    }
    AppMethodBeat.o(57150);
    return localba;
  }
  
  public final boolean hzF()
  {
    AppMethodBeat.i(57155);
    boolean bool = this.TlB.hzF();
    AppMethodBeat.o(57155);
    return bool;
  }
  
  public final boolean hzG()
  {
    AppMethodBeat.i(57151);
    boolean bool = this.TlB.hzG();
    AppMethodBeat.o(57151);
    return bool;
  }
  
  public final boolean hzH()
  {
    AppMethodBeat.i(57152);
    boolean bool = this.TlB.hzH();
    AppMethodBeat.o(57152);
    return bool;
  }
  
  public final boolean hzI()
  {
    AppMethodBeat.i(57153);
    boolean bool = this.TlB.hzI();
    AppMethodBeat.o(57153);
    return bool;
  }
  
  public final boolean hzJ()
  {
    AppMethodBeat.i(57156);
    boolean bool = this.TlB.hzJ();
    AppMethodBeat.o(57156);
    return bool;
  }
  
  public final boolean hzK()
  {
    AppMethodBeat.i(57157);
    boolean bool = this.TlB.hzK();
    AppMethodBeat.o(57157);
    return bool;
  }
  
  public final g hzL()
  {
    AppMethodBeat.i(57143);
    g localg = this.TlB.hzL();
    if (localg == null) {
      atM(18);
    }
    AppMethodBeat.o(57143);
    return localg;
  }
  
  public final an hzM()
  {
    AppMethodBeat.i(57161);
    an localan = an.ThK;
    if (localan == null) {
      atM(28);
    }
    AppMethodBeat.o(57161);
    return localan;
  }
  
  public final Collection<e> hzN()
  {
    AppMethodBeat.i(57163);
    Collection localCollection = this.TlB.hzN();
    if (localCollection == null) {
      atM(30);
    }
    AppMethodBeat.o(57163);
    return localCollection;
  }
  
  public final List<as> hzO()
  {
    AppMethodBeat.i(57162);
    hCf();
    List localList = this.TlF;
    if (localList == null) {
      atM(29);
    }
    AppMethodBeat.o(57162);
    return localList;
  }
  
  public final kotlin.l.b.a.b.b.l hzx()
  {
    AppMethodBeat.i(57146);
    kotlin.l.b.a.b.b.l locall = this.TlB.hzx();
    if (locall == null) {
      atM(21);
    }
    AppMethodBeat.o(57146);
    return locall;
  }
  
  public final h hzy()
  {
    AppMethodBeat.i(57139);
    h localh = this.TlB.hzy();
    if (localh == null) {
      atM(15);
    }
    AppMethodBeat.o(57139);
    return localh;
  }
  
  public final at hzz()
  {
    AppMethodBeat.i(57134);
    Object localObject2 = this.TlB.hzz();
    if (this.TlC.Tlg.isEmpty())
    {
      if (localObject2 == null) {
        atM(0);
      }
      AppMethodBeat.o(57134);
      return localObject2;
    }
    if (this.Tks == null)
    {
      localObject1 = hCf();
      Object localObject3 = ((at)localObject2).hBV();
      localObject2 = new ArrayList(((Collection)localObject3).size());
      localObject3 = ((Collection)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((kotlin.l.b.a.b.m.ba)localObject1).c((ab)((Iterator)localObject3).next(), bh.TOQ));
      }
      this.Tks = new kotlin.l.b.a.b.m.j(this, this.TlE, (Collection)localObject2, kotlin.l.b.a.b.l.b.TMN);
    }
    Object localObject1 = this.Tks;
    if (localObject1 == null) {
      atM(1);
    }
    AppMethodBeat.o(57134);
    return localObject1;
  }
  
  public final boolean isExternal()
  {
    AppMethodBeat.i(57154);
    boolean bool = this.TlB.isExternal();
    AppMethodBeat.o(57154);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.s
 * JD-Core Version:    0.7.0.1
 */