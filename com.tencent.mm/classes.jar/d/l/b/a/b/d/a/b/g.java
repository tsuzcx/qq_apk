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
  private final boolean NdV;
  private final o<a.a<?>, ?> NdW;
  
  protected g(d.l.b.a.b.b.l paraml, d.l.b.a.b.b.a.g paramg, w paramw, ba paramba, boolean paramBoolean1, f paramf, an paraman, ah paramah, b.a parama, boolean paramBoolean2, o<a.a<?>, ?> paramo)
  {
    super(paraml, paramah, paramg, paramw, paramba, paramBoolean1, paramf, parama, paraman, false, false, false, false, false, false);
    AppMethodBeat.i(57723);
    this.NdV = paramBoolean2;
    this.NdW = paramo;
    AppMethodBeat.o(57723);
  }
  
  public static g a(d.l.b.a.b.b.l paraml, d.l.b.a.b.b.a.g paramg, w paramw, ba paramba, boolean paramBoolean1, f paramf, an paraman, boolean paramBoolean2)
  {
    AppMethodBeat.i(57724);
    if (paraml == null) {
      ajm(7);
    }
    if (paramg == null) {
      ajm(8);
    }
    if (paramw == null) {
      ajm(9);
    }
    if (paramba == null) {
      ajm(10);
    }
    if (paramf == null) {
      ajm(11);
    }
    if (paraman == null) {
      ajm(12);
    }
    paraml = new g(paraml, paramg, paramw, paramba, paramBoolean1, paramf, paraman, null, b.a.MUj, paramBoolean2, null);
    AppMethodBeat.o(57724);
    return paraml;
  }
  
  public final aa a(d.l.b.a.b.b.l paraml, w paramw, ba paramba, ah paramah, b.a parama, f paramf, an paraman)
  {
    AppMethodBeat.i(57725);
    if (paraml == null) {
      ajm(13);
    }
    if (paramw == null) {
      ajm(14);
    }
    if (paramba == null) {
      ajm(15);
    }
    if (parama == null) {
      ajm(16);
    }
    if (paramf == null) {
      ajm(17);
    }
    if (paraman == null) {
      ajm(18);
    }
    paraml = new g(paraml, ghH(), paramw, paramba, this.MZO, paramf, paraman, paramah, parama, this.NdV, this.NdW);
    AppMethodBeat.o(57725);
    return paraml;
  }
  
  public final b a(d.l.b.a.b.m.ab paramab1, List<l> paramList, d.l.b.a.b.m.ab paramab2, o<a.a<?>, ?> paramo)
  {
    AppMethodBeat.i(57726);
    if (paramab2 == null) {
      ajm(20);
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
    if (gjm() == this)
    {
      paramList = null;
      localg = new g(ghs(), ghH(), ghx(), ghz(), this.MZO, giD(), ghI(), paramList, giw(), this.NdV, paramo);
      localObject1 = this.MZl;
      if (localObject1 == null) {
        break label455;
      }
      localObject2 = ((d.l.b.a.b.b.c.ab)localObject1).ghH();
      localw = ((d.l.b.a.b.b.c.ab)localObject1).ghx();
      localba = ((d.l.b.a.b.b.c.ab)localObject1).ghz();
      bool1 = ((z)localObject1).isDefault;
      bool2 = ((z)localObject1).MXB;
      bool3 = ((z)localObject1).MYa;
      locala = giw();
      if (paramList != null) {
        break label418;
      }
      paramo = null;
      label138:
      paramo = new d.l.b.a.b.b.c.ab(localg, (d.l.b.a.b.b.a.g)localObject2, localw, localba, bool1, bool2, bool3, locala, paramo, ((d.l.b.a.b.b.c.ab)localObject1).ghI());
      paramo.MYn = ((z)localObject1).MYn;
      paramo.K(paramab2);
    }
    for (;;)
    {
      localObject1 = null;
      localObject2 = this.MZm;
      if (localObject2 != null)
      {
        localObject1 = ((aj)localObject2).ghH();
        localw = ((aj)localObject2).ghx();
        localba = ((aj)localObject2).ghz();
        bool1 = ((aj)localObject2).isDefault();
        bool2 = ((aj)localObject2).ghG();
        bool3 = ((aj)localObject2).ghD();
        locala = giw();
        if (paramList == null)
        {
          paramList = null;
          label266:
          localObject1 = new ac(localg, (d.l.b.a.b.b.a.g)localObject1, localw, localba, bool1, bool2, bool3, locala, paramList, ((aj)localObject2).ghI());
          ((z)localObject1).MYn = ((z)localObject1).MYn;
          ((ac)localObject1).a((av)((aj)localObject2).gis().get(0));
        }
      }
      else
      {
        localg.a(paramo, (aj)localObject1, this.MZo, this.MZp);
        localg.MZn = this.MZn;
        if (this.MZP != null) {
          localg.a(this.MZP);
        }
        localg.u(giu());
        if (paramab1 != null) {
          break label439;
        }
      }
      for (paramab1 = null;; paramab1 = d.l.b.a.b.j.b.a(this, paramab1, g.a.gjL()))
      {
        localg.a(paramab2, gip(), this.MXW, paramab1);
        AppMethodBeat.o(57726);
        return localg;
        paramList = gjm();
        break;
        label418:
        paramo = paramList.gjj();
        break label138;
        paramList = paramList.gjk();
        break label266;
        label439:
        paramList = d.l.b.a.b.b.a.g.MVP;
      }
      label455:
      paramo = null;
    }
  }
  
  public final <V> V a(a.a<V> parama)
  {
    AppMethodBeat.i(57728);
    if ((this.NdW != null) && (((a.a)this.NdW.first).equals(parama)))
    {
      parama = this.NdW.second;
      AppMethodBeat.o(57728);
      return parama;
    }
    AppMethodBeat.o(57728);
    return null;
  }
  
  public final boolean git()
  {
    return false;
  }
  
  public final boolean gjD()
  {
    AppMethodBeat.i(57727);
    d.l.b.a.b.m.ab localab = gju();
    if ((this.NdV) && (j.G(localab)) && ((!s.U(localab)) || (d.l.b.a.b.a.g.D(localab))))
    {
      AppMethodBeat.o(57727);
      return true;
    }
    AppMethodBeat.o(57727);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.b.g
 * JD-Core Version:    0.7.0.1
 */