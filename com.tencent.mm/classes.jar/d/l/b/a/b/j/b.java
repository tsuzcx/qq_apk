package d.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.c.ac;
import d.l.b.a.b.b.c.ad;
import d.l.b.a.b.b.c.ae;
import d.l.b.a.b.b.c.aj;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.w;
import d.l.b.a.b.m.bh;
import java.util.Collections;

public final class b
{
  public static ak a(d.l.b.a.b.b.a parama, d.l.b.a.b.m.ab paramab, d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(59894);
    if (parama == null) {
      ajW(29);
    }
    if (paramg == null) {
      ajW(30);
    }
    if (paramab == null)
    {
      AppMethodBeat.o(59894);
      return null;
    }
    parama = new ad(parama, new d.l.b.a.b.j.f.a.b(parama, paramab, null), paramg);
    AppMethodBeat.o(59894);
    return parama;
  }
  
  public static d.l.b.a.b.b.c.ab a(ah paramah, d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(59888);
    if (paramah == null) {
      ajW(13);
    }
    if (paramg == null) {
      ajW(14);
    }
    paramah = b(paramah, paramg);
    AppMethodBeat.o(59888);
    return paramah;
  }
  
  public static d.l.b.a.b.b.c.ab a(ah paramah, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, an paraman)
  {
    AppMethodBeat.i(59890);
    if (paramah == null) {
      ajW(17);
    }
    if (paramg == null) {
      ajW(18);
    }
    if (paraman == null) {
      ajW(19);
    }
    paramah = new d.l.b.a.b.b.c.ab(paramah, paramg, paramah.glZ(), paramah.gmb(), paramBoolean, false, false, d.l.b.a.b.b.b.a.Nro, null, paraman);
    AppMethodBeat.o(59890);
    return paramah;
  }
  
  public static ac a(ah paramah, d.l.b.a.b.b.a.g paramg1, d.l.b.a.b.b.a.g paramg2)
  {
    AppMethodBeat.i(59885);
    if (paramah == null) {
      ajW(0);
    }
    if (paramg1 == null) {
      ajW(1);
    }
    if (paramg2 == null) {
      ajW(2);
    }
    paramah = a(paramah, paramg1, paramg2, paramah.gmk());
    AppMethodBeat.o(59885);
    return paramah;
  }
  
  private static ac a(ah paramah, d.l.b.a.b.b.a.g paramg1, d.l.b.a.b.b.a.g paramg2, an paraman)
  {
    AppMethodBeat.i(59886);
    if (paramah == null) {
      ajW(3);
    }
    if (paramg1 == null) {
      ajW(4);
    }
    if (paramg2 == null) {
      ajW(5);
    }
    if (paraman == null) {
      ajW(6);
    }
    paramah = a(paramah, paramg1, paramg2, true, paramah.gmb(), paraman);
    AppMethodBeat.o(59886);
    return paramah;
  }
  
  public static ac a(ah paramah, d.l.b.a.b.b.a.g paramg1, d.l.b.a.b.b.a.g paramg2, boolean paramBoolean, ba paramba, an paraman)
  {
    AppMethodBeat.i(59887);
    if (paramah == null) {
      ajW(7);
    }
    if (paramg1 == null) {
      ajW(8);
    }
    if (paramg2 == null) {
      ajW(9);
    }
    if (paramba == null) {
      ajW(10);
    }
    if (paraman == null) {
      ajW(11);
    }
    paramg1 = new ac(paramah, paramg1, paramah.glZ(), paramba, paramBoolean, false, false, d.l.b.a.b.b.b.a.Nro, null, paraman);
    paramg1.a(ac.a(paramg1, paramah.gnW(), paramg2));
    AppMethodBeat.o(59887);
    return paramg1;
  }
  
  private static d.l.b.a.b.b.c.ab b(ah paramah, d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(59889);
    if (paramah == null) {
      ajW(15);
    }
    if (paramg == null) {
      ajW(16);
    }
    paramah = a(paramah, paramg, true, paramah.gmk());
    AppMethodBeat.o(59889);
    return paramah;
  }
  
  public static boolean g(t paramt)
  {
    AppMethodBeat.i(59893);
    if (paramt == null) {
      ajW(28);
    }
    if ((paramt.gmY() == d.l.b.a.b.b.b.a.Nrr) && (c.y(paramt.glU())))
    {
      AppMethodBeat.o(59893);
      return true;
    }
    AppMethodBeat.o(59893);
    return false;
  }
  
  public static am w(e parame)
  {
    AppMethodBeat.i(59891);
    if (parame == null) {
      ajW(22);
    }
    g.a locala = d.l.b.a.b.b.a.g.NsU;
    parame = ae.a(parame, g.a.gon(), c.NSx, d.l.b.a.b.b.b.a.Nrr, parame.gmk()).b(null, null, Collections.emptyList(), Collections.emptyList(), d.l.b.a.b.j.d.a.G(parame).a(bh.NZW, parame.gne()), w.NrG, az.Nsm);
    if (parame == null) {
      ajW(23);
    }
    AppMethodBeat.o(59891);
    return parame;
  }
  
  public static am x(e parame)
  {
    AppMethodBeat.i(59892);
    if (parame == null) {
      ajW(24);
    }
    Object localObject1 = d.l.b.a.b.b.a.g.NsU;
    localObject1 = ae.a(parame, g.a.gon(), c.NSy, d.l.b.a.b.b.b.a.Nrr, parame.gmk());
    Object localObject2 = d.l.b.a.b.b.a.g.NsU;
    localObject2 = new aj((d.l.b.a.b.b.a)localObject1, null, 0, g.a.gon(), d.l.b.a.b.f.f.bei("value"), d.l.b.a.b.j.d.a.G(parame).glO(), false, false, false, null, parame.gmk());
    parame = ((ae)localObject1).b(null, null, Collections.emptyList(), Collections.singletonList(localObject2), parame.gne(), w.NrG, az.Nsm);
    if (parame == null) {
      ajW(25);
    }
    AppMethodBeat.o(59892);
    return parame;
  }
  
  public static final class a
    extends d.l.b.a.b.b.c.f
  {
    public a(e parame, an paraman)
    {
      super(null, g.a.gon(), true, d.l.b.a.b.b.b.a.Nro, paraman);
      AppMethodBeat.i(59883);
      a(Collections.emptyList(), c.z(parame));
      AppMethodBeat.o(59883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.b
 * JD-Core Version:    0.7.0.1
 */