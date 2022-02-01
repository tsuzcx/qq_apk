package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.a;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.t.a;
import d.l.b.a.b.b.w;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.ab;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ae
  extends p
  implements am
{
  protected ae(l paraml, am paramam, g paramg, f paramf, b.a parama, an paraman)
  {
    super(paraml, paramam, paramg, paramf, parama, paraman);
    AppMethodBeat.i(57277);
    AppMethodBeat.o(57277);
  }
  
  public static ae a(l paraml, g paramg, f paramf, b.a parama, an paraman)
  {
    AppMethodBeat.i(57278);
    if (paraml == null) {
      agL(5);
    }
    if (paramg == null) {
      agL(6);
    }
    if (paramf == null) {
      agL(7);
    }
    if (parama == null) {
      agL(8);
    }
    if (paraman == null) {
      agL(9);
    }
    paraml = new ae(paraml, null, paramg, paramf, parama, paraman);
    AppMethodBeat.o(57278);
    return paraml;
  }
  
  public ae a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, ba paramba, Map<? extends a.a<?>, ?> paramMap)
  {
    AppMethodBeat.i(57280);
    if (paramList == null) {
      agL(14);
    }
    if (paramList1 == null) {
      agL(15);
    }
    if (paramba == null) {
      agL(16);
    }
    super.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.Lhs = new LinkedHashMap(paramMap);
    }
    if (this == null) {
      agL(17);
    }
    AppMethodBeat.o(57280);
    return this;
  }
  
  protected p a(l paraml, t paramt, b.a parama, f paramf, g paramg, an paraman)
  {
    AppMethodBeat.i(57282);
    if (paraml == null) {
      agL(19);
    }
    if (parama == null) {
      agL(20);
    }
    if (paramg == null) {
      agL(21);
    }
    if (paraman == null) {
      agL(22);
    }
    paramt = (am)paramt;
    if (paramf != null) {}
    for (;;)
    {
      paraml = new ae(paraml, paramt, paramg, paramf, parama, paraman);
      AppMethodBeat.o(57282);
      return paraml;
      paramf = fRf();
    }
  }
  
  public final ae b(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, ba paramba)
  {
    AppMethodBeat.i(57279);
    if (paramList == null) {
      agL(10);
    }
    if (paramList1 == null) {
      agL(11);
    }
    if (paramba == null) {
      agL(12);
    }
    paramak1 = a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, null);
    if (paramak1 == null) {
      agL(13);
    }
    AppMethodBeat.o(57279);
    return paramak1;
  }
  
  public am c(l paraml, w paramw, ba paramba, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(57283);
    paraml = (am)super.b(paraml, paramw, paramba, parama, paramBoolean);
    if (paraml == null) {
      agL(23);
    }
    AppMethodBeat.o(57283);
    return paraml;
  }
  
  public t.a<? extends am> fRx()
  {
    AppMethodBeat.i(57284);
    t.a locala = super.fRx();
    if (locala == null) {
      agL(24);
    }
    AppMethodBeat.o(57284);
    return locala;
  }
  
  public final am fSR()
  {
    AppMethodBeat.i(57281);
    am localam = (am)super.fRq();
    if (localam == null) {
      agL(18);
    }
    AppMethodBeat.o(57281);
    return localam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.ae
 * JD-Core Version:    0.7.0.1
 */