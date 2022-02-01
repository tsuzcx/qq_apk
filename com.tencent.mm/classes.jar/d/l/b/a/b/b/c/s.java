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
  private at MXE;
  private final t MYN;
  private final d.l.b.a.b.m.ba MYO;
  private d.l.b.a.b.m.ba MYP;
  private List<as> MYQ;
  private List<as> MYR;
  
  public s(t paramt, d.l.b.a.b.m.ba paramba)
  {
    this.MYN = paramt;
    this.MYO = paramba;
  }
  
  private d.l.b.a.b.m.ba gkb()
  {
    AppMethodBeat.i(57133);
    if (this.MYP == null)
    {
      if (!this.MYO.MYs.isEmpty()) {
        break label45;
      }
      this.MYP = this.MYO;
    }
    for (;;)
    {
      Object localObject = this.MYP;
      AppMethodBeat.o(57133);
      return localObject;
      label45:
      localObject = this.MYN.ghu().getParameters();
      this.MYQ = new ArrayList(((List)localObject).size());
      this.MYP = p.a((List)localObject, this.MYO.guf(), this, this.MYQ);
      this.MYR = d.a.j.c(this.MYQ, new d.g.a.b() {});
    }
  }
  
  public final h a(i parami)
  {
    AppMethodBeat.i(57138);
    if (parami == null) {
      ajm(13);
    }
    parami = this.MYN.a(parami);
    if (this.MYO.MYs.isEmpty())
    {
      if (parami == null) {
        ajm(14);
      }
      AppMethodBeat.o(57138);
      return parami;
    }
    parami = new d.l.b.a.b.j.f.l(parami, gkb());
    AppMethodBeat.o(57138);
    return parami;
  }
  
  public final h a(ay paramay)
  {
    AppMethodBeat.i(57136);
    if (paramay == null) {
      ajm(10);
    }
    paramay = a(paramay, a.d(c.s(this)));
    if (paramay == null) {
      ajm(11);
    }
    AppMethodBeat.o(57136);
    return paramay;
  }
  
  public final h a(ay paramay, i parami)
  {
    AppMethodBeat.i(57135);
    if (paramay == null) {
      ajm(5);
    }
    if (parami == null) {
      ajm(6);
    }
    paramay = this.MYN.a(paramay, parami);
    if (this.MYO.MYs.isEmpty())
    {
      if (paramay == null) {
        ajm(7);
      }
      AppMethodBeat.o(57135);
      return paramay;
    }
    paramay = new d.l.b.a.b.j.f.l(paramay, gkb());
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
  
  public final Collection<d> gfV()
  {
    AppMethodBeat.i(57142);
    Object localObject = this.MYN.gfV();
    ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      localArrayList.add(((d)locald.giW().d(locald.giH()).a(locald.ghx()).a(locald.ghz()).a(locald.giw()).zX(false).gjc()).a(gkb()));
    }
    AppMethodBeat.o(57142);
    return localArrayList;
  }
  
  public final boolean ghA()
  {
    AppMethodBeat.i(57155);
    boolean bool = this.MYN.ghA();
    AppMethodBeat.o(57155);
    return bool;
  }
  
  public final boolean ghB()
  {
    AppMethodBeat.i(57151);
    boolean bool = this.MYN.ghB();
    AppMethodBeat.o(57151);
    return bool;
  }
  
  public final boolean ghC()
  {
    AppMethodBeat.i(57152);
    boolean bool = this.MYN.ghC();
    AppMethodBeat.o(57152);
    return bool;
  }
  
  public final boolean ghD()
  {
    AppMethodBeat.i(57153);
    boolean bool = this.MYN.ghD();
    AppMethodBeat.o(57153);
    return bool;
  }
  
  public final boolean ghE()
  {
    AppMethodBeat.i(57156);
    boolean bool = this.MYN.ghE();
    AppMethodBeat.o(57156);
    return bool;
  }
  
  public final boolean ghF()
  {
    AppMethodBeat.i(57157);
    boolean bool = this.MYN.ghF();
    AppMethodBeat.o(57157);
    return bool;
  }
  
  public final boolean ghG()
  {
    AppMethodBeat.i(57154);
    boolean bool = this.MYN.ghG();
    AppMethodBeat.o(57154);
    return bool;
  }
  
  public final g ghH()
  {
    AppMethodBeat.i(57143);
    g localg = this.MYN.ghH();
    if (localg == null) {
      ajm(18);
    }
    AppMethodBeat.o(57143);
    return localg;
  }
  
  public final an ghI()
  {
    AppMethodBeat.i(57161);
    an localan = an.MUX;
    if (localan == null) {
      ajm(28);
    }
    AppMethodBeat.o(57161);
    return localan;
  }
  
  public final Collection<e> ghJ()
  {
    AppMethodBeat.i(57163);
    Collection localCollection = this.MYN.ghJ();
    if (localCollection == null) {
      ajm(30);
    }
    AppMethodBeat.o(57163);
    return localCollection;
  }
  
  public final List<as> ghK()
  {
    AppMethodBeat.i(57162);
    gkb();
    List localList = this.MYR;
    if (localList == null) {
      ajm(29);
    }
    AppMethodBeat.o(57162);
    return localList;
  }
  
  public final d.l.b.a.b.b.l ghs()
  {
    AppMethodBeat.i(57146);
    d.l.b.a.b.b.l locall = this.MYN.ghs();
    if (locall == null) {
      ajm(21);
    }
    AppMethodBeat.o(57146);
    return locall;
  }
  
  public final h ght()
  {
    AppMethodBeat.i(57139);
    h localh = this.MYN.ght();
    if (localh == null) {
      ajm(15);
    }
    AppMethodBeat.o(57139);
    return localh;
  }
  
  public final at ghu()
  {
    AppMethodBeat.i(57134);
    Object localObject2 = this.MYN.ghu();
    if (this.MYO.MYs.isEmpty())
    {
      if (localObject2 == null) {
        ajm(0);
      }
      AppMethodBeat.o(57134);
      return localObject2;
    }
    if (this.MXE == null)
    {
      localObject1 = gkb();
      Object localObject3 = ((at)localObject2).gjR();
      localObject2 = new ArrayList(((Collection)localObject3).size());
      localObject3 = ((Collection)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((d.l.b.a.b.m.ba)localObject1).c((ab)((Iterator)localObject3).next(), bh.NCP));
      }
      this.MXE = new d.l.b.a.b.m.j(this, this.MYQ, (Collection)localObject2, d.l.b.a.b.l.b.NAN);
    }
    Object localObject1 = this.MXE;
    if (localObject1 == null) {
      ajm(1);
    }
    AppMethodBeat.o(57134);
    return localObject1;
  }
  
  public final e ghv()
  {
    AppMethodBeat.i(57147);
    e locale = this.MYN.ghv();
    AppMethodBeat.o(57147);
    return locale;
  }
  
  public final d.l.b.a.b.b.f ghw()
  {
    AppMethodBeat.i(57148);
    d.l.b.a.b.b.f localf = this.MYN.ghw();
    if (localf == null) {
      ajm(24);
    }
    AppMethodBeat.o(57148);
    return localf;
  }
  
  public final w ghx()
  {
    AppMethodBeat.i(57149);
    w localw = this.MYN.ghx();
    if (localw == null) {
      ajm(25);
    }
    AppMethodBeat.o(57149);
    return localw;
  }
  
  public final d ghy()
  {
    AppMethodBeat.i(57160);
    d locald = this.MYN.ghy();
    AppMethodBeat.o(57160);
    return locald;
  }
  
  public final d.l.b.a.b.b.ba ghz()
  {
    AppMethodBeat.i(57150);
    d.l.b.a.b.b.ba localba = this.MYN.ghz();
    if (localba == null) {
      ajm(26);
    }
    AppMethodBeat.o(57150);
    return localba;
  }
  
  public final aj giC()
  {
    AppMethodBeat.i(57140);
    Object localObject = bc.jt(ghu().getParameters());
    localObject = ac.a(ghH(), ghu(), (List)localObject, giI());
    AppMethodBeat.o(57140);
    return localObject;
  }
  
  public final d.l.b.a.b.f.f giD()
  {
    AppMethodBeat.i(57144);
    d.l.b.a.b.f.f localf = this.MYN.giD();
    if (localf == null) {
      ajm(19);
    }
    AppMethodBeat.o(57144);
    return localf;
  }
  
  public final h giI()
  {
    AppMethodBeat.i(57137);
    h localh = a(a.d(c.s(this.MYN)));
    if (localh == null) {
      ajm(12);
    }
    AppMethodBeat.o(57137);
    return localh;
  }
  
  public final h giJ()
  {
    AppMethodBeat.i(57159);
    h localh = this.MYN.giJ();
    if (localh == null) {
      ajm(27);
    }
    AppMethodBeat.o(57159);
    return localh;
  }
  
  public final ak giK()
  {
    AppMethodBeat.i(57141);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(57141);
    throw localUnsupportedOperationException;
  }
  
  public final e giL()
  {
    AppMethodBeat.i(57145);
    e locale = this.MYN.giL();
    if (locale == null) {
      ajm(20);
    }
    AppMethodBeat.o(57145);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.s
 * JD-Core Version:    0.7.0.1
 */