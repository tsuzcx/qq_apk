package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.c.af;
import kotlin.l.b.a.b.b.c.p;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ad;

public final class l
  extends af
  implements c
{
  private final kotlin.l.b.a.b.e.b.c aiyk;
  private final kotlin.l.b.a.b.e.b.g aiyl;
  private final i ajml;
  private final g ajmm;
  private h.a ajng;
  private final a.h ajoi;
  
  private l(kotlin.l.b.a.b.b.l paraml, au paramau, kotlin.l.b.a.b.b.a.g paramg, f paramf, b.a parama, a.h paramh, kotlin.l.b.a.b.e.b.c paramc, kotlin.l.b.a.b.e.b.g paramg1, i parami, g paramg2, av paramav) {}
  
  public final af a(as paramas1, as paramas2, List<? extends ba> paramList, List<? extends bd> paramList1, ad paramad, ab paramab, t paramt, Map<? extends a.a<?>, ?> paramMap, h.a parama)
  {
    AppMethodBeat.i(192388);
    s.u(paramList, "typeParameters");
    s.u(paramList1, "unsubstitutedValueParameters");
    s.u(paramt, "visibility");
    s.u(paramMap, "userDataMap");
    s.u(parama, "isExperimentalCoroutineInReleaseEnvironment");
    paramas1 = super.a(paramas1, paramas2, paramList, paramList1, paramad, paramab, paramt, paramMap);
    s.s(paramas1, "super.initialize(\n      …    userDataMap\n        )");
    this.ajng = parama;
    AppMethodBeat.o(192388);
    return paramas1;
  }
  
  public final p a(kotlin.l.b.a.b.b.l paraml, x paramx, b.a parama, f paramf, kotlin.l.b.a.b.b.a.g paramg, av paramav)
  {
    AppMethodBeat.i(60479);
    s.u(paraml, "newOwner");
    s.u(parama, "kind");
    s.u(paramg, "annotations");
    s.u(paramav, "source");
    au localau = (au)paramx;
    if (paramf == null)
    {
      paramx = kok();
      s.s(paramx, "name");
    }
    for (;;)
    {
      paraml = new l(paraml, localau, paramg, paramx, parama, this.ajoi, this.aiyk, this.aiyl, this.ajml, this.ajmm, paramav);
      paraml.Pl(kpO());
      paraml.ajng = this.ajng;
      paraml = (p)paraml;
      AppMethodBeat.o(60479);
      return paraml;
      paramx = paramf;
    }
  }
  
  public final kotlin.l.b.a.b.e.b.c kAc()
  {
    return this.aiyk;
  }
  
  public final kotlin.l.b.a.b.e.b.g kAd()
  {
    return this.aiyl;
  }
  
  public final i kAe()
  {
    return this.ajml;
  }
  
  public final g kAf()
  {
    return this.ajmm;
  }
  
  public final List<h> kAg()
  {
    AppMethodBeat.i(192405);
    List localList = c.a.a((c)this);
    AppMethodBeat.o(192405);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.l
 * JD-Core Version:    0.7.0.1
 */