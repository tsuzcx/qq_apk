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
  public final r NBm;
  public final d.l.b.a.b.c.a.b NBt;
  public final d.l.b.a.b.m.a.n NBz;
  public final j NVP;
  public final m NVQ;
  final i NVR;
  public final c<d.l.b.a.b.b.a.c, d.l.b.a.b.j.b.g<?>> NVS;
  final ac NVT;
  private final v NVU;
  final s NVV;
  public final Iterable<d.l.b.a.b.b.b.b> NVW;
  final k NVX;
  public final d.l.b.a.b.b.b.a NVY;
  public final d.l.b.a.b.b.b.c NVZ;
  public final d.l.b.a.b.h.g NWa;
  public final d.l.b.a.b.l.j Nnf;
  public final aa Npj;
  public final y Nqw;
  
  public l(d.l.b.a.b.l.j paramj, y paramy, m paramm, i parami, c<? extends d.l.b.a.b.b.a.c, ? extends d.l.b.a.b.j.b.g<?>> paramc, ac paramac, v paramv, r paramr, d.l.b.a.b.c.a.b paramb, s params, Iterable<? extends d.l.b.a.b.b.b.b> paramIterable, aa paramaa, k paramk, d.l.b.a.b.b.b.a parama, d.l.b.a.b.b.b.c paramc1, d.l.b.a.b.h.g paramg, d.l.b.a.b.m.a.n paramn)
  {
    AppMethodBeat.i(60305);
    this.Nnf = paramj;
    this.Nqw = paramy;
    this.NVQ = paramm;
    this.NVR = parami;
    this.NVS = paramc;
    this.NVT = paramac;
    this.NVU = paramv;
    this.NBm = paramr;
    this.NBt = paramb;
    this.NVV = params;
    this.NVW = paramIterable;
    this.Npj = paramaa;
    this.NVX = paramk;
    this.NVY = parama;
    this.NVZ = paramc1;
    this.NWa = paramg;
    this.NBz = paramn;
    this.NVP = new j(this);
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
    paramab = new n(this, paramc, (d.l.b.a.b.b.l)paramab, paramh, parami, parama, paramf, null, (List)d.a.v.NhH);
    AppMethodBeat.o(60304);
    return paramab;
  }
  
  public final e g(d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(60303);
    p.h(parama, "classId");
    parama = j.a(this.NVP, parama);
    AppMethodBeat.o(60303);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.l
 * JD-Core Version:    0.7.0.1
 */