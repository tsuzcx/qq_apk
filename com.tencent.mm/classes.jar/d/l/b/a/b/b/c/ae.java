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
      ajW(5);
    }
    if (paramg == null) {
      ajW(6);
    }
    if (paramf == null) {
      ajW(7);
    }
    if (parama == null) {
      ajW(8);
    }
    if (paraman == null) {
      ajW(9);
    }
    paraml = new ae(paraml, null, paramg, paramf, parama, paraman);
    AppMethodBeat.o(57278);
    return paraml;
  }
  
  public ae a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, ba paramba, Map<? extends a.a<?>, ?> paramMap)
  {
    AppMethodBeat.i(57280);
    if (paramList == null) {
      ajW(14);
    }
    if (paramList1 == null) {
      ajW(15);
    }
    if (paramba == null) {
      ajW(16);
    }
    super.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.Nvu = new LinkedHashMap(paramMap);
    }
    if (this == null) {
      ajW(17);
    }
    AppMethodBeat.o(57280);
    return this;
  }
  
  protected p a(l paraml, t paramt, b.a parama, f paramf, g paramg, an paraman)
  {
    AppMethodBeat.i(57282);
    if (paraml == null) {
      ajW(19);
    }
    if (parama == null) {
      ajW(20);
    }
    if (paramg == null) {
      ajW(21);
    }
    if (paraman == null) {
      ajW(22);
    }
    paramt = (am)paramt;
    if (paramf != null) {}
    for (;;)
    {
      paraml = new ae(paraml, paramt, paramg, paramf, parama, paraman);
      AppMethodBeat.o(57282);
      return paraml;
      paramf = gnf();
    }
  }
  
  public final ae b(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, ba paramba)
  {
    AppMethodBeat.i(57279);
    if (paramList == null) {
      ajW(10);
    }
    if (paramList1 == null) {
      ajW(11);
    }
    if (paramba == null) {
      ajW(12);
    }
    paramak1 = a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, null);
    if (paramak1 == null) {
      ajW(13);
    }
    AppMethodBeat.o(57279);
    return paramak1;
  }
  
  public am c(l paraml, w paramw, ba paramba, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(57283);
    paraml = (am)super.b(paraml, paramw, paramba, parama, paramBoolean);
    if (paraml == null) {
      ajW(23);
    }
    AppMethodBeat.o(57283);
    return paraml;
  }
  
  public t.a<? extends am> gny()
  {
    AppMethodBeat.i(57284);
    t.a locala = super.gny();
    if (locala == null) {
      ajW(24);
    }
    AppMethodBeat.o(57284);
    return locala;
  }
  
  public final am goS()
  {
    AppMethodBeat.i(57281);
    am localam = (am)super.gnr();
    if (localam == null) {
      ajW(18);
    }
    AppMethodBeat.o(57281);
    return localam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.ae
 * JD-Core Version:    0.7.0.1
 */