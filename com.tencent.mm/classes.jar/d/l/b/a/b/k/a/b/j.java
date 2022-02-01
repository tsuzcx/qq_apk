package d.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.aj;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.c.aa;
import d.l.b.a.b.b.c.ab;
import d.l.b.a.b.b.c.al;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.r;
import d.l.b.a.b.b.w;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.e.b.b;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.e.b.i;
import d.z;

public final class j
  extends aa
  implements c
{
  private final i NWe;
  public final f NWf;
  private g.a NXb;
  public final a.m NjX;
  public final d.l.b.a.b.e.b.c NjZ;
  public final h Nka;
  
  public j(l paraml, ah paramah, g paramg, w paramw, ba paramba, boolean paramBoolean1, d.l.b.a.b.f.f paramf, d.l.b.a.b.b.b.a parama, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, a.m paramm, d.l.b.a.b.e.b.c paramc, h paramh, i parami, f paramf1)
  {
    super(paraml, paramah, paramg, paramw, paramba, paramBoolean1, paramf, parama, an.Nsc, paramBoolean2, paramBoolean3, paramBoolean6, false, paramBoolean4, paramBoolean5);
    AppMethodBeat.i(60477);
    this.NjX = paramm;
    this.NjZ = paramc;
    this.Nka = paramh;
    this.NWe = parami;
    this.NWf = paramf1;
    this.NXb = g.a.NXw;
    AppMethodBeat.o(60477);
  }
  
  public final aa a(l paraml, w paramw, ba paramba, ah paramah, d.l.b.a.b.b.b.a parama, d.l.b.a.b.f.f paramf, an paraman)
  {
    AppMethodBeat.i(60475);
    p.h(paraml, "newOwner");
    p.h(paramw, "newModality");
    p.h(paramba, "newVisibility");
    p.h(parama, "kind");
    p.h(paramf, "newName");
    p.h(paraman, "source");
    paraml = (aa)new j(paraml, paramah, gmj(), paramw, paramba, this.NwU, paramf, parama, this.Nwo, gof(), gmi(), this.Nwq, this.Nvi, this.NjX, this.NjZ, this.Nka, this.NWe, this.NWf);
    AppMethodBeat.o(60475);
    return paraml;
  }
  
  public final void a(ab paramab, aj paramaj, r paramr1, r paramr2, g.a parama)
  {
    AppMethodBeat.i(60474);
    p.h(parama, "isExperimentalCoroutineInReleaseEnvironment");
    super.a(paramab, paramaj, paramr1, paramr2);
    paramab = z.Nhr;
    this.NXb = parama;
    AppMethodBeat.o(60474);
  }
  
  public final boolean gmi()
  {
    AppMethodBeat.i(60476);
    Boolean localBoolean = b.NLP.alu(this.NjX.NHz);
    p.g(localBoolean, "Flags.IS_EXTERNAL_PROPERTY.get(proto.flags)");
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(60476);
    return bool;
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
 * Qualified Name:     d.l.b.a.b.k.a.b.j
 * JD-Core Version:    0.7.0.1
 */