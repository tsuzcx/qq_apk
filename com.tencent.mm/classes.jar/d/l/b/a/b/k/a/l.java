package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.aa;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ac;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.y;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.k.a.b.f;
import java.util.List;

public final class l
{
  public final d.l.b.a.b.l.j MQa;
  public final aa MSe;
  public final y MTr;
  public final r Neh;
  public final d.l.b.a.b.c.a.b Neo;
  public final d.l.b.a.b.m.a.n Neu;
  public final j NyI;
  public final m NyJ;
  final i NyK;
  public final c<d.l.b.a.b.b.a.c, d.l.b.a.b.j.b.g<?>> NyL;
  final ac NyM;
  private final v NyN;
  final s NyO;
  public final Iterable<d.l.b.a.b.b.b.b> NyP;
  final k NyQ;
  public final d.l.b.a.b.b.b.a NyR;
  public final d.l.b.a.b.b.b.c NyS;
  public final d.l.b.a.b.h.g NyT;
  
  public l(d.l.b.a.b.l.j paramj, y paramy, m paramm, i parami, c<? extends d.l.b.a.b.b.a.c, ? extends d.l.b.a.b.j.b.g<?>> paramc, ac paramac, v paramv, r paramr, d.l.b.a.b.c.a.b paramb, s params, Iterable<? extends d.l.b.a.b.b.b.b> paramIterable, aa paramaa, k paramk, d.l.b.a.b.b.b.a parama, d.l.b.a.b.b.b.c paramc1, d.l.b.a.b.h.g paramg, d.l.b.a.b.m.a.n paramn)
  {
    AppMethodBeat.i(60305);
    this.MQa = paramj;
    this.MTr = paramy;
    this.NyJ = paramm;
    this.NyK = parami;
    this.NyL = paramc;
    this.NyM = paramac;
    this.NyN = paramv;
    this.Neh = paramr;
    this.Neo = paramb;
    this.NyO = params;
    this.NyP = paramIterable;
    this.MSe = paramaa;
    this.NyQ = paramk;
    this.NyR = parama;
    this.NyS = paramc1;
    this.NyT = paramg;
    this.Neu = paramn;
    this.NyI = new j(this);
    AppMethodBeat.o(60305);
  }
  
  public final n a(ab paramab, d.l.b.a.b.e.b.c paramc, h paramh, d.l.b.a.b.e.b.i parami, d.l.b.a.b.e.b.a parama, f paramf)
  {
    AppMethodBeat.i(60304);
    p.h(paramab, "descriptor");
    p.h(paramc, "nameResolver");
    p.h(paramh, "typeTable");
    p.h(parami, "versionRequirementTable");
    p.h(parama, "metadataVersion");
    paramab = new n(this, paramc, (d.l.b.a.b.b.l)paramab, paramh, parami, parama, paramf, null, (List)d.a.v.MKE);
    AppMethodBeat.o(60304);
    return paramab;
  }
  
  public final e g(d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(60303);
    p.h(parama, "classId");
    parama = j.a(this.NyI, parama);
    AppMethodBeat.o(60303);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.l
 * JD-Core Version:    0.7.0.1
 */