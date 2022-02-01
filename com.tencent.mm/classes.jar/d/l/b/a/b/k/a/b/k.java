package d.l.b.a.b.k.a.b;

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
import d.l.b.a.b.b.c.ae;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.w;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.e.b.i;
import d.l.b.a.b.m.ab;
import java.util.List;
import java.util.Map;

public final class k
  extends ae
  implements c
{
  private final i NWe;
  private final f NWf;
  private final a.h NXL;
  private g.a NXb;
  private final d.l.b.a.b.e.b.c NjZ;
  private final h Nka;
  
  private k(l paraml, am paramam, g paramg, d.l.b.a.b.f.f paramf, b.a parama, a.h paramh, d.l.b.a.b.e.b.c paramc, h paramh1, i parami, f paramf1, an paraman) {}
  
  public final ae a(ak paramak1, ak paramak2, List<? extends as> paramList, List<? extends av> paramList1, ab paramab, w paramw, ba paramba, Map<? extends a.a<?>, ?> paramMap, g.a parama)
  {
    AppMethodBeat.i(60478);
    d.g.b.p.h(paramList, "typeParameters");
    d.g.b.p.h(paramList1, "unsubstitutedValueParameters");
    d.g.b.p.h(paramba, "visibility");
    d.g.b.p.h(paramMap, "userDataMap");
    d.g.b.p.h(parama, "isExperimentalCoroutineInReleaseEnvironment");
    paramak1 = super.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, paramMap);
    this.NXb = parama;
    d.g.b.p.g(paramak1, "super.initialize(\n      …easeEnvironment\n        }");
    AppMethodBeat.o(60478);
    return paramak1;
  }
  
  public final d.l.b.a.b.b.c.p a(l paraml, t paramt, b.a parama, d.l.b.a.b.f.f paramf, g paramg, an paraman)
  {
    AppMethodBeat.i(60479);
    d.g.b.p.h(paraml, "newOwner");
    d.g.b.p.h(parama, "kind");
    d.g.b.p.h(paramg, "annotations");
    d.g.b.p.h(paraman, "source");
    am localam = (am)paramt;
    if (paramf == null)
    {
      paramt = gnf();
      d.g.b.p.g(paramt, "name");
    }
    for (;;)
    {
      paraml = new k(paraml, localam, paramg, paramt, parama, this.NXL, this.NjZ, this.Nka, this.NWe, this.NWf, paraman);
      paraml.NXb = this.NXb;
      paraml = (d.l.b.a.b.b.c.p)paraml;
      AppMethodBeat.o(60479);
      return paraml;
      paramt = paramf;
    }
  }
  
  public final d.l.b.a.b.e.b.c gyg()
  {
    return this.NjZ;
  }
  
  public final h gyh()
  {
    return this.Nka;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.k
 * JD-Core Version:    0.7.0.1
 */