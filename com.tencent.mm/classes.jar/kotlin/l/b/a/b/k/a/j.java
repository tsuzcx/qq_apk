package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.l.m;

public final class j
{
  public final ag aiBS;
  public final m aiBu;
  public final ae aiFr;
  public final q aiRO;
  private final kotlin.l.b.a.b.j.f.a aiRR;
  public final kotlin.l.b.a.b.c.a.c aiRV;
  public final kotlin.l.b.a.b.m.a.l aiSb;
  public final k ajlX;
  final g ajlY;
  public final c<kotlin.l.b.a.b.b.a.c, kotlin.l.b.a.b.j.b.g<?>> ajlZ;
  final ai ajma;
  final u ajmb;
  final r ajmc;
  public final Iterable<kotlin.l.b.a.b.b.b.b> ajmd;
  final i ajme;
  public final kotlin.l.b.a.b.b.b.a ajmf;
  public final kotlin.l.b.a.b.b.b.c ajmg;
  public final kotlin.l.b.a.b.h.g ajmh;
  final kotlin.l.b.a.b.b.b.e ajmi;
  public final h ajmj;
  
  private j(m paramm, ae paramae, k paramk, g paramg, c<? extends kotlin.l.b.a.b.b.a.c, ? extends kotlin.l.b.a.b.j.b.g<?>> paramc, ai paramai, u paramu, q paramq, kotlin.l.b.a.b.c.a.c paramc1, r paramr, Iterable<? extends kotlin.l.b.a.b.b.b.b> paramIterable, ag paramag, i parami, kotlin.l.b.a.b.b.b.a parama, kotlin.l.b.a.b.b.b.c paramc2, kotlin.l.b.a.b.h.g paramg1, kotlin.l.b.a.b.m.a.l paraml, kotlin.l.b.a.b.j.f.a parama1, kotlin.l.b.a.b.b.b.e parame)
  {
    AppMethodBeat.i(192293);
    this.aiBu = paramm;
    this.aiFr = paramae;
    this.ajlX = paramk;
    this.ajlY = paramg;
    this.ajlZ = paramc;
    this.ajma = paramai;
    this.ajmb = paramu;
    this.aiRO = paramq;
    this.aiRV = paramc1;
    this.ajmc = paramr;
    this.ajmd = paramIterable;
    this.aiBS = paramag;
    this.ajme = parami;
    this.ajmf = parama;
    this.ajmg = paramc2;
    this.ajmh = paramg1;
    this.aiSb = paraml;
    this.aiRR = parama1;
    this.ajmi = parame;
    this.ajmj = new h(this);
    AppMethodBeat.o(192293);
  }
  
  public final l a(ah paramah, kotlin.l.b.a.b.e.b.c paramc, kotlin.l.b.a.b.e.b.g paramg, kotlin.l.b.a.b.e.b.i parami, kotlin.l.b.a.b.e.b.a parama, kotlin.l.b.a.b.k.a.b.g paramg1)
  {
    AppMethodBeat.i(60304);
    s.u(paramah, "descriptor");
    s.u(paramc, "nameResolver");
    s.u(paramg, "typeTable");
    s.u(parami, "versionRequirementTable");
    s.u(parama, "metadataVersion");
    paramah = new l(this, paramc, (kotlin.l.b.a.b.b.l)paramah, paramg, parami, parama, paramg1, null, (List)ab.aivy);
    AppMethodBeat.o(60304);
    return paramah;
  }
  
  public final kotlin.l.b.a.b.b.e i(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(60303);
    s.u(paramb, "classId");
    paramb = h.a(this.ajmj, paramb);
    AppMethodBeat.o(60303);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.j
 * JD-Core Version:    0.7.0.1
 */