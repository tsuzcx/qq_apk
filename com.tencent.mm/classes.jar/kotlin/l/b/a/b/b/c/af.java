package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.b.x.a;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ad;

public class af
  extends p
  implements au
{
  protected af(l paraml, au paramau, g paramg, f paramf, b.a parama, av paramav)
  {
    super(paraml, paramau, paramg, paramf, parama, paramav);
    AppMethodBeat.i(57277);
    AppMethodBeat.o(57277);
  }
  
  public static af a(l paraml, g paramg, f paramf, b.a parama, av paramav)
  {
    AppMethodBeat.i(57278);
    if (paraml == null) {
      aKu(5);
    }
    if (paramg == null) {
      aKu(6);
    }
    if (paramf == null) {
      aKu(7);
    }
    if (parama == null) {
      aKu(8);
    }
    if (paramav == null) {
      aKu(9);
    }
    paraml = new af(paraml, null, paramg, paramf, parama, paramav);
    AppMethodBeat.o(57278);
    return paraml;
  }
  
  public af a(as paramas1, as paramas2, List<? extends ba> paramList, List<bd> paramList1, ad paramad, ab paramab, t paramt, Map<? extends a.a<?>, ?> paramMap)
  {
    AppMethodBeat.i(191892);
    if (paramList == null) {
      aKu(14);
    }
    if (paramList1 == null) {
      aKu(15);
    }
    if (paramt == null) {
      aKu(16);
    }
    super.a(paramas1, paramas2, paramList, paramList1, paramad, paramab, paramt);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.aiKH = new LinkedHashMap(paramMap);
    }
    if (this == null) {
      aKu(17);
    }
    AppMethodBeat.o(191892);
    return this;
  }
  
  protected p a(l paraml, x paramx, b.a parama, f paramf, g paramg, av paramav)
  {
    AppMethodBeat.i(57282);
    if (paraml == null) {
      aKu(19);
    }
    if (parama == null) {
      aKu(20);
    }
    if (paramg == null) {
      aKu(21);
    }
    if (paramav == null) {
      aKu(22);
    }
    paramx = (au)paramx;
    if (paramf != null) {}
    for (;;)
    {
      paraml = new af(paraml, paramx, paramg, paramf, parama, paramav);
      AppMethodBeat.o(57282);
      return paraml;
      paramf = kok();
    }
  }
  
  public final af b(as paramas1, as paramas2, List<? extends ba> paramList, List<bd> paramList1, ad paramad, ab paramab, t paramt)
  {
    AppMethodBeat.i(191891);
    if (paramList == null) {
      aKu(10);
    }
    if (paramList1 == null) {
      aKu(11);
    }
    if (paramt == null) {
      aKu(12);
    }
    paramas1 = a(paramas1, paramas2, paramList, paramList1, paramad, paramab, paramt, null);
    if (paramas1 == null) {
      aKu(13);
    }
    AppMethodBeat.o(191891);
    return paramas1;
  }
  
  public au c(l paraml, ab paramab, t paramt, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(191895);
    paraml = (au)super.b(paraml, paramab, paramt, parama, paramBoolean);
    if (paraml == null) {
      aKu(23);
    }
    AppMethodBeat.o(191895);
    return paraml;
  }
  
  public x.a<? extends au> koO()
  {
    AppMethodBeat.i(57284);
    x.a locala = super.koO();
    if (locala == null) {
      aKu(24);
    }
    AppMethodBeat.o(57284);
    return locala;
  }
  
  public final au kqi()
  {
    AppMethodBeat.i(57281);
    au localau = (au)super.koH();
    if (localau == null) {
      aKu(18);
    }
    AppMethodBeat.o(57281);
    return localau;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.af
 * JD-Core Version:    0.7.0.1
 */