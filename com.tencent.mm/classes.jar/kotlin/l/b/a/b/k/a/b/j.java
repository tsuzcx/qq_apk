package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.aa;
import kotlin.l.b.a.b.b.c.ab;
import kotlin.l.b.a.b.b.c.al;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.r;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.b.b;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.b.i;
import kotlin.x;

public final class j
  extends aa
  implements c
{
  public final a.m SZF;
  public final kotlin.l.b.a.b.e.b.c SZH;
  public final h SZI;
  private g.a TLU;
  private final i TLa;
  public final f TLb;
  
  public j(l paraml, ah paramah, g paramg, w paramw, ba paramba, boolean paramBoolean1, kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.b.b.a parama, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, a.m paramm, kotlin.l.b.a.b.e.b.c paramc, h paramh, i parami, f paramf1)
  {
    super(paraml, paramah, paramg, paramw, paramba, paramBoolean1, paramf, parama, an.ThK, paramBoolean2, paramBoolean3, paramBoolean6, false, paramBoolean4, paramBoolean5);
    AppMethodBeat.i(60477);
    this.SZF = paramm;
    this.SZH = paramc;
    this.SZI = paramh;
    this.TLa = parami;
    this.TLb = paramf1;
    this.TLU = g.a.TMp;
    AppMethodBeat.o(60477);
  }
  
  public final aa a(l paraml, w paramw, ba paramba, ah paramah, kotlin.l.b.a.b.b.b.a parama, kotlin.l.b.a.b.f.f paramf, an paraman)
  {
    AppMethodBeat.i(60475);
    p.h(paraml, "newOwner");
    p.h(paramw, "newModality");
    p.h(paramba, "newVisibility");
    p.h(parama, "kind");
    p.h(paramf, "newName");
    p.h(paraman, "source");
    paraml = (aa)new j(paraml, paramah, hzL(), paramw, paramba, this.TmC, paramf, parama, this.TlW, hBH(), isExternal(), this.TlY, this.TkQ, this.SZF, this.SZH, this.SZI, this.TLa, this.TLb);
    AppMethodBeat.o(60475);
    return paraml;
  }
  
  public final void a(ab paramab, aj paramaj, r paramr1, r paramr2, g.a parama)
  {
    AppMethodBeat.i(60474);
    p.h(parama, "isExperimentalCoroutineInReleaseEnvironment");
    super.a(paramab, paramaj, paramr1, paramr2);
    paramab = x.SXb;
    this.TLU = parama;
    AppMethodBeat.o(60474);
  }
  
  public final kotlin.l.b.a.b.e.b.c hLj()
  {
    return this.SZH;
  }
  
  public final h hLk()
  {
    return this.SZI;
  }
  
  public final boolean isExternal()
  {
    AppMethodBeat.i(60476);
    Boolean localBoolean = b.TBt.avk(this.SZF.Txb);
    p.g(localBoolean, "Flags.IS_EXTERNAL_PROPERTY.get(proto.flags)");
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(60476);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.j
 * JD-Core Version:    0.7.0.1
 */