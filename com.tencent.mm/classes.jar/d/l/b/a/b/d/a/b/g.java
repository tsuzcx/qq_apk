package d.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.a;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.aj;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.c.aa;
import d.l.b.a.b.b.c.ac;
import d.l.b.a.b.b.c.al;
import d.l.b.a.b.b.c.z;
import d.l.b.a.b.b.j;
import d.l.b.a.b.b.w;
import d.l.b.a.b.d.a.f.s;
import d.l.b.a.b.f.f;
import d.o;
import java.util.List;

public class g
  extends aa
  implements b
{
  private final boolean LmY;
  private final o<a.a<?>, ?> LmZ;
  
  protected g(d.l.b.a.b.b.l paraml, d.l.b.a.b.b.a.g paramg, w paramw, ba paramba, boolean paramBoolean1, f paramf, an paraman, ah paramah, b.a parama, boolean paramBoolean2, o<a.a<?>, ?> paramo)
  {
    super(paraml, paramah, paramg, paramw, paramba, paramBoolean1, paramf, parama, paraman, false, false, false, false, false, false);
    AppMethodBeat.i(57723);
    this.LmY = paramBoolean2;
    this.LmZ = paramo;
    AppMethodBeat.o(57723);
  }
  
  public static g a(d.l.b.a.b.b.l paraml, d.l.b.a.b.b.a.g paramg, w paramw, ba paramba, boolean paramBoolean1, f paramf, an paraman, boolean paramBoolean2)
  {
    AppMethodBeat.i(57724);
    if (paraml == null) {
      agL(7);
    }
    if (paramg == null) {
      agL(8);
    }
    if (paramw == null) {
      agL(9);
    }
    if (paramba == null) {
      agL(10);
    }
    if (paramf == null) {
      agL(11);
    }
    if (paraman == null) {
      agL(12);
    }
    paraml = new g(paraml, paramg, paramw, paramba, paramBoolean1, paramf, paraman, null, b.a.Ldo, paramBoolean2, null);
    AppMethodBeat.o(57724);
    return paraml;
  }
  
  public final aa a(d.l.b.a.b.b.l paraml, w paramw, ba paramba, ah paramah, b.a parama, f paramf, an paraman)
  {
    AppMethodBeat.i(57725);
    if (paraml == null) {
      agL(13);
    }
    if (paramw == null) {
      agL(14);
    }
    if (paramba == null) {
      agL(15);
    }
    if (parama == null) {
      agL(16);
    }
    if (paramf == null) {
      agL(17);
    }
    if (paraman == null) {
      agL(18);
    }
    paraml = new g(paraml, fQj(), paramw, paramba, this.LiS, paramf, paraman, paramah, parama, this.LmY, this.LmZ);
    AppMethodBeat.o(57725);
    return paraml;
  }
  
  public final b a(d.l.b.a.b.m.ab paramab1, List<l> paramList, d.l.b.a.b.m.ab paramab2, o<a.a<?>, ?> paramo)
  {
    AppMethodBeat.i(57726);
    if (paramab2 == null) {
      agL(20);
    }
    g localg;
    Object localObject1;
    Object localObject2;
    w localw;
    ba localba;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    b.a locala;
    if (fRN() == this)
    {
      paramList = null;
      localg = new g(fPU(), fQj(), fPZ(), fQb(), this.LiS, fRf(), fQk(), paramList, fQY(), this.LmY, paramo);
      localObject1 = this.Lip;
      if (localObject1 == null) {
        break label455;
      }
      localObject2 = ((d.l.b.a.b.b.c.ab)localObject1).fQj();
      localw = ((d.l.b.a.b.b.c.ab)localObject1).fPZ();
      localba = ((d.l.b.a.b.b.c.ab)localObject1).fQb();
      bool1 = ((z)localObject1).isDefault;
      bool2 = ((z)localObject1).LgF;
      bool3 = ((z)localObject1).Lhe;
      locala = fQY();
      if (paramList != null) {
        break label418;
      }
      paramo = null;
      label138:
      paramo = new d.l.b.a.b.b.c.ab(localg, (d.l.b.a.b.b.a.g)localObject2, localw, localba, bool1, bool2, bool3, locala, paramo, ((d.l.b.a.b.b.c.ab)localObject1).fQk());
      paramo.Lhr = ((z)localObject1).Lhr;
      paramo.K(paramab2);
    }
    for (;;)
    {
      localObject1 = null;
      localObject2 = this.Liq;
      if (localObject2 != null)
      {
        localObject1 = ((aj)localObject2).fQj();
        localw = ((aj)localObject2).fPZ();
        localba = ((aj)localObject2).fQb();
        bool1 = ((aj)localObject2).isDefault();
        bool2 = ((aj)localObject2).fQi();
        bool3 = ((aj)localObject2).fQf();
        locala = fQY();
        if (paramList == null)
        {
          paramList = null;
          label266:
          localObject1 = new ac(localg, (d.l.b.a.b.b.a.g)localObject1, localw, localba, bool1, bool2, bool3, locala, paramList, ((aj)localObject2).fQk());
          ((z)localObject1).Lhr = ((z)localObject1).Lhr;
          ((ac)localObject1).a((av)((aj)localObject2).fQU().get(0));
        }
      }
      else
      {
        localg.a(paramo, (aj)localObject1, this.Lis, this.Lit);
        localg.Lir = this.Lir;
        if (this.LiT != null) {
          localg.a(this.LiT);
        }
        localg.t(fQW());
        if (paramab1 != null) {
          break label439;
        }
      }
      for (paramab1 = null;; paramab1 = d.l.b.a.b.j.b.a(this, paramab1, g.a.fSm()))
      {
        localg.a(paramab2, fQR(), this.Lha, paramab1);
        AppMethodBeat.o(57726);
        return localg;
        paramList = fRN();
        break;
        label418:
        paramo = paramList.fRK();
        break label138;
        paramList = paramList.fRL();
        break label266;
        label439:
        paramList = d.l.b.a.b.b.a.g.LeU;
      }
      label455:
      paramo = null;
    }
  }
  
  public final <V> V a(a.a<V> parama)
  {
    AppMethodBeat.i(57728);
    if ((this.LmZ != null) && (((a.a)this.LmZ.first).equals(parama)))
    {
      parama = this.LmZ.second;
      AppMethodBeat.o(57728);
      return parama;
    }
    AppMethodBeat.o(57728);
    return null;
  }
  
  public final boolean fQV()
  {
    return false;
  }
  
  public final boolean fSe()
  {
    AppMethodBeat.i(57727);
    d.l.b.a.b.m.ab localab = fRV();
    if ((this.LmY) && (j.G(localab)) && ((!s.U(localab)) || (d.l.b.a.b.a.g.D(localab))))
    {
      AppMethodBeat.o(57727);
      return true;
    }
    AppMethodBeat.o(57727);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.b.g
 * JD-Core Version:    0.7.0.1
 */