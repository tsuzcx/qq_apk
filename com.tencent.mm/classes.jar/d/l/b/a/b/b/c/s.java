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
  private at Jtp;
  private d.l.b.a.b.m.ba JuA;
  private List<as> JuB;
  private List<as> JuC;
  private final t Juy;
  private final d.l.b.a.b.m.ba Juz;
  
  public s(t paramt, d.l.b.a.b.m.ba paramba)
  {
    this.Juy = paramt;
    this.Juz = paramba;
  }
  
  private d.l.b.a.b.m.ba fzY()
  {
    AppMethodBeat.i(57133);
    if (this.JuA == null)
    {
      if (!this.Juz.Jud.isEmpty()) {
        break label45;
      }
      this.JuA = this.Juz;
    }
    for (;;)
    {
      Object localObject = this.JuA;
      AppMethodBeat.o(57133);
      return localObject;
      label45:
      localObject = this.Juy.fxs().getParameters();
      this.JuB = new ArrayList(((List)localObject).size());
      this.JuA = p.a((List)localObject, this.Juz.fKb(), this, this.JuB);
      this.JuC = d.a.j.c(this.JuB, new d.g.a.b() {});
    }
  }
  
  public final h a(i parami)
  {
    AppMethodBeat.i(57138);
    if (parami == null) {
      adP(13);
    }
    parami = this.Juy.a(parami);
    if (this.Juz.Jud.isEmpty())
    {
      if (parami == null) {
        adP(14);
      }
      AppMethodBeat.o(57138);
      return parami;
    }
    parami = new d.l.b.a.b.j.f.l(parami, fzY());
    AppMethodBeat.o(57138);
    return parami;
  }
  
  public final h a(ay paramay)
  {
    AppMethodBeat.i(57136);
    if (paramay == null) {
      adP(10);
    }
    paramay = a(paramay, a.d(c.s(this)));
    if (paramay == null) {
      adP(11);
    }
    AppMethodBeat.o(57136);
    return paramay;
  }
  
  public final h a(ay paramay, i parami)
  {
    AppMethodBeat.i(57135);
    if (paramay == null) {
      adP(5);
    }
    if (parami == null) {
      adP(6);
    }
    paramay = this.Juy.a(paramay, parami);
    if (this.Juz.Jud.isEmpty())
    {
      if (paramay == null) {
        adP(7);
      }
      AppMethodBeat.o(57135);
      return paramay;
    }
    paramay = new d.l.b.a.b.j.f.l(paramay, fzY());
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
  
  public final Collection<d> fvR()
  {
    AppMethodBeat.i(57142);
    Object localObject = this.Juy.fvR();
    ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      localArrayList.add(((d)locald.fyT().d(locald.fyE()).a(locald.fxv()).a(locald.fxx()).a(locald.fyu()).xR(false).fyZ()).a(fzY()));
    }
    AppMethodBeat.o(57142);
    return localArrayList;
  }
  
  public final boolean fxA()
  {
    AppMethodBeat.i(57152);
    boolean bool = this.Juy.fxA();
    AppMethodBeat.o(57152);
    return bool;
  }
  
  public final boolean fxB()
  {
    AppMethodBeat.i(57153);
    boolean bool = this.Juy.fxB();
    AppMethodBeat.o(57153);
    return bool;
  }
  
  public final boolean fxC()
  {
    AppMethodBeat.i(57156);
    boolean bool = this.Juy.fxC();
    AppMethodBeat.o(57156);
    return bool;
  }
  
  public final boolean fxD()
  {
    AppMethodBeat.i(57157);
    boolean bool = this.Juy.fxD();
    AppMethodBeat.o(57157);
    return bool;
  }
  
  public final boolean fxE()
  {
    AppMethodBeat.i(57154);
    boolean bool = this.Juy.fxE();
    AppMethodBeat.o(57154);
    return bool;
  }
  
  public final g fxF()
  {
    AppMethodBeat.i(57143);
    g localg = this.Juy.fxF();
    if (localg == null) {
      adP(18);
    }
    AppMethodBeat.o(57143);
    return localg;
  }
  
  public final an fxG()
  {
    AppMethodBeat.i(57161);
    an localan = an.JqJ;
    if (localan == null) {
      adP(28);
    }
    AppMethodBeat.o(57161);
    return localan;
  }
  
  public final Collection<e> fxH()
  {
    AppMethodBeat.i(57163);
    Collection localCollection = this.Juy.fxH();
    if (localCollection == null) {
      adP(30);
    }
    AppMethodBeat.o(57163);
    return localCollection;
  }
  
  public final List<as> fxI()
  {
    AppMethodBeat.i(57162);
    fzY();
    List localList = this.JuC;
    if (localList == null) {
      adP(29);
    }
    AppMethodBeat.o(57162);
    return localList;
  }
  
  public final d.l.b.a.b.b.l fxq()
  {
    AppMethodBeat.i(57146);
    d.l.b.a.b.b.l locall = this.Juy.fxq();
    if (locall == null) {
      adP(21);
    }
    AppMethodBeat.o(57146);
    return locall;
  }
  
  public final h fxr()
  {
    AppMethodBeat.i(57139);
    h localh = this.Juy.fxr();
    if (localh == null) {
      adP(15);
    }
    AppMethodBeat.o(57139);
    return localh;
  }
  
  public final at fxs()
  {
    AppMethodBeat.i(57134);
    Object localObject2 = this.Juy.fxs();
    if (this.Juz.Jud.isEmpty())
    {
      if (localObject2 == null) {
        adP(0);
      }
      AppMethodBeat.o(57134);
      return localObject2;
    }
    if (this.Jtp == null)
    {
      localObject1 = fzY();
      Object localObject3 = ((at)localObject2).fzP();
      localObject2 = new ArrayList(((Collection)localObject3).size());
      localObject3 = ((Collection)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((d.l.b.a.b.m.ba)localObject1).c((ab)((Iterator)localObject3).next(), bh.JYC));
      }
      this.Jtp = new d.l.b.a.b.m.j(this, this.JuB, (Collection)localObject2, d.l.b.a.b.l.b.JWw);
    }
    Object localObject1 = this.Jtp;
    if (localObject1 == null) {
      adP(1);
    }
    AppMethodBeat.o(57134);
    return localObject1;
  }
  
  public final e fxt()
  {
    AppMethodBeat.i(57147);
    e locale = this.Juy.fxt();
    AppMethodBeat.o(57147);
    return locale;
  }
  
  public final d.l.b.a.b.b.f fxu()
  {
    AppMethodBeat.i(57148);
    d.l.b.a.b.b.f localf = this.Juy.fxu();
    if (localf == null) {
      adP(24);
    }
    AppMethodBeat.o(57148);
    return localf;
  }
  
  public final w fxv()
  {
    AppMethodBeat.i(57149);
    w localw = this.Juy.fxv();
    if (localw == null) {
      adP(25);
    }
    AppMethodBeat.o(57149);
    return localw;
  }
  
  public final d fxw()
  {
    AppMethodBeat.i(57160);
    d locald = this.Juy.fxw();
    AppMethodBeat.o(57160);
    return locald;
  }
  
  public final d.l.b.a.b.b.ba fxx()
  {
    AppMethodBeat.i(57150);
    d.l.b.a.b.b.ba localba = this.Juy.fxx();
    if (localba == null) {
      adP(26);
    }
    AppMethodBeat.o(57150);
    return localba;
  }
  
  public final boolean fxy()
  {
    AppMethodBeat.i(57155);
    boolean bool = this.Juy.fxy();
    AppMethodBeat.o(57155);
    return bool;
  }
  
  public final boolean fxz()
  {
    AppMethodBeat.i(57151);
    boolean bool = this.Juy.fxz();
    AppMethodBeat.o(57151);
    return bool;
  }
  
  public final aj fyA()
  {
    AppMethodBeat.i(57140);
    Object localObject = bc.iP(fxs().getParameters());
    localObject = ac.a(fxF(), this, (List)localObject);
    if (localObject == null) {
      adP(16);
    }
    AppMethodBeat.o(57140);
    return localObject;
  }
  
  public final d.l.b.a.b.f.f fyB()
  {
    AppMethodBeat.i(57144);
    d.l.b.a.b.f.f localf = this.Juy.fyB();
    if (localf == null) {
      adP(19);
    }
    AppMethodBeat.o(57144);
    return localf;
  }
  
  public final h fyF()
  {
    AppMethodBeat.i(57137);
    h localh = a(a.d(c.s(this.Juy)));
    if (localh == null) {
      adP(12);
    }
    AppMethodBeat.o(57137);
    return localh;
  }
  
  public final h fyG()
  {
    AppMethodBeat.i(57159);
    h localh = this.Juy.fyG();
    if (localh == null) {
      adP(27);
    }
    AppMethodBeat.o(57159);
    return localh;
  }
  
  public final ak fyH()
  {
    AppMethodBeat.i(57141);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(57141);
    throw localUnsupportedOperationException;
  }
  
  public final e fyI()
  {
    AppMethodBeat.i(57145);
    e locale = this.Juy.fyI();
    if (locale == null) {
      adP(20);
    }
    AppMethodBeat.o(57145);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.s
 * JD-Core Version:    0.7.0.1
 */