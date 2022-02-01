package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ae;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.m.ab;

public final class k
  extends ae
  implements c
{
  private final kotlin.l.b.a.b.e.b.c SZH;
  private final h SZI;
  private g.a TLU;
  private final i TLa;
  private final f TLb;
  private final a.h TME;
  
  private k(l paraml, am paramam, g paramg, kotlin.l.b.a.b.f.f paramf, b.a parama, a.h paramh, kotlin.l.b.a.b.e.b.c paramc, h paramh1, i parami, f paramf1, an paraman) {}
  
  public final ae a(ak paramak1, ak paramak2, List<? extends as> paramList, List<? extends av> paramList1, ab paramab, w paramw, ba paramba, Map<? extends a.a<?>, ?> paramMap, g.a parama)
  {
    AppMethodBeat.i(60478);
    kotlin.g.b.p.h(paramList, "typeParameters");
    kotlin.g.b.p.h(paramList1, "unsubstitutedValueParameters");
    kotlin.g.b.p.h(paramba, "visibility");
    kotlin.g.b.p.h(paramMap, "userDataMap");
    kotlin.g.b.p.h(parama, "isExperimentalCoroutineInReleaseEnvironment");
    paramak1 = super.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, paramMap);
    this.TLU = parama;
    kotlin.g.b.p.g(paramak1, "super.initialize(\n      …easeEnvironment\n        }");
    AppMethodBeat.o(60478);
    return paramak1;
  }
  
  public final kotlin.l.b.a.b.b.c.p a(l paraml, t paramt, b.a parama, kotlin.l.b.a.b.f.f paramf, g paramg, an paraman)
  {
    AppMethodBeat.i(60479);
    kotlin.g.b.p.h(paraml, "newOwner");
    kotlin.g.b.p.h(parama, "kind");
    kotlin.g.b.p.h(paramg, "annotations");
    kotlin.g.b.p.h(paraman, "source");
    am localam = (am)paramt;
    if (paramf == null)
    {
      paramt = hAH();
      kotlin.g.b.p.g(paramt, "name");
    }
    for (;;)
    {
      paraml = new k(paraml, localam, paramg, paramt, parama, this.TME, this.SZH, this.SZI, this.TLa, this.TLb, paraman);
      paraml.TLU = this.TLU;
      paraml = (kotlin.l.b.a.b.b.c.p)paraml;
      AppMethodBeat.o(60479);
      return paraml;
      paramt = paramf;
    }
  }
  
  public final kotlin.l.b.a.b.e.b.c hLj()
  {
    return this.SZH;
  }
  
  public final h hLk()
  {
    return this.SZI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.k
 * JD-Core Version:    0.7.0.1
 */