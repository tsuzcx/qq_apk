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
  public final kotlin.l.b.a.b.e.b.c aaCB;
  public final h aaCC;
  public final a.m aaCz;
  private final i abnD;
  public final f abnE;
  private g.a abow;
  
  public j(l paraml, ah paramah, g paramg, w paramw, ba paramba, boolean paramBoolean1, kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.b.b.a parama, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, a.m paramm, kotlin.l.b.a.b.e.b.c paramc, h paramh, i parami, f paramf1)
  {
    super(paraml, paramah, paramg, paramw, paramba, paramBoolean1, paramf, parama, an.aaKE, paramBoolean2, paramBoolean3, paramBoolean6, false, paramBoolean4, paramBoolean5);
    AppMethodBeat.i(60477);
    this.aaCz = paramm;
    this.aaCB = paramc;
    this.aaCC = paramh;
    this.abnD = parami;
    this.abnE = paramf1;
    this.abow = g.a.aboR;
    AppMethodBeat.o(60477);
  }
  
  public final aa a(l paraml, w paramw, ba paramba, ah paramah, kotlin.l.b.a.b.b.b.a parama, kotlin.l.b.a.b.f.f paramf, an paraman)
  {
    AppMethodBeat.i(60475);
    p.k(paraml, "newOwner");
    p.k(paramw, "newModality");
    p.k(paramba, "newVisibility");
    p.k(parama, "kind");
    p.k(paramf, "newName");
    p.k(paraman, "source");
    paraml = (aa)new j(paraml, paramah, iDY(), paramw, paramba, iFU(), paramf, parama, iFX(), iFW(), iDX(), iFY(), iDV(), this.aaCz, this.aaCB, this.aaCC, this.abnD, this.abnE);
    AppMethodBeat.o(60475);
    return paraml;
  }
  
  public final void a(ab paramab, aj paramaj, r paramr1, r paramr2, g.a parama)
  {
    AppMethodBeat.i(60474);
    p.k(parama, "isExperimentalCoroutineInReleaseEnvironment");
    super.a(paramab, paramaj, paramr1, paramr2);
    paramab = x.aazN;
    this.abow = parama;
    AppMethodBeat.o(60474);
  }
  
  public final boolean iDX()
  {
    AppMethodBeat.i(60476);
    Boolean localBoolean = b.abeh.aFe(this.aaCz.aaZS);
    p.j(localBoolean, "Flags.IS_EXTERNAL_PROPERTY.get(proto.flags)");
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(60476);
    return bool;
  }
  
  public final kotlin.l.b.a.b.e.b.c iPB()
  {
    return this.aaCB;
  }
  
  public final h iPC()
  {
    return this.aaCC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.j
 * JD-Core Version:    0.7.0.1
 */