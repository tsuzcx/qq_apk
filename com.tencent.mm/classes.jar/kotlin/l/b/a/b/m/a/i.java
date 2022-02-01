package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.j.g.h;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.c.b;
import kotlin.l.b.a.b.m.c.d;
import kotlin.l.b.a.b.m.v;

public final class i
  extends al
  implements d
{
  private final kotlin.l.b.a.b.b.a.g aiHM;
  private final boolean ajjw;
  public final b ajrc;
  public final j ajrd;
  public final bk ajre;
  final boolean ajrf;
  
  public i(b paramb, j paramj, bk parambk, kotlin.l.b.a.b.b.a.g paramg, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(191683);
    this.ajrc = paramb;
    this.ajrd = paramj;
    this.ajre = parambk;
    this.aiHM = paramg;
    this.ajjw = paramBoolean1;
    this.ajrf = paramBoolean2;
    AppMethodBeat.o(191683);
  }
  
  public i(b paramb, bk parambk, az paramaz, ba paramba)
  {
    this(paramb, new j(paramaz, null, null, paramba, 6), parambk, null, false, 56);
    AppMethodBeat.i(191694);
    AppMethodBeat.o(191694);
  }
  
  private i PG(boolean paramBoolean)
  {
    AppMethodBeat.i(61063);
    i locali = new i(this.ajrc, this.ajrd, this.ajre, this.aiHM, paramBoolean, 32);
    AppMethodBeat.o(61063);
    return locali;
  }
  
  private i l(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(61060);
    s.u(paramg, "newAnnotations");
    paramg = new i(this.ajrc, this.ajrd, this.ajre, paramg, this.ajjw, 32);
    AppMethodBeat.o(61060);
    return paramg;
  }
  
  private i q(g paramg)
  {
    AppMethodBeat.i(61066);
    s.u(paramg, "kotlinTypeRefiner");
    b localb = this.ajrc;
    j localj = this.ajrd.r(paramg);
    bk localbk = this.ajre;
    if (localbk == null) {}
    for (paramg = null;; paramg = paramg.aD((ad)localbk).kAK())
    {
      paramg = new i(localb, localj, paramg, this.aiHM, this.ajjw, 32);
      AppMethodBeat.o(61066);
      return paramg;
    }
  }
  
  public final List<az> klR()
  {
    return (List)ab.aivy;
  }
  
  public final h knP()
  {
    AppMethodBeat.i(61059);
    h localh = v.eW("No member resolution should be done on captured type!", true);
    s.s(localh, "createErrorScope(\"No mem…on captured type!\", true)");
    AppMethodBeat.o(61059);
    return localh;
  }
  
  public final kotlin.l.b.a.b.b.a.g knl()
  {
    return this.aiHM;
  }
  
  public final boolean ksB()
  {
    return this.ajjw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.i
 * JD-Core Version:    0.7.0.1
 */