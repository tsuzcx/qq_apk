package d.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
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
import d.y;

public final class j
  extends aa
  implements c
{
  private final i JUG;
  public final f JUH;
  private g.a JVD;
  public final a.m Jis;
  public final d.l.b.a.b.e.b.c Jiu;
  public final h Jiv;
  
  public j(l paraml, ah paramah, g paramg, w paramw, ba paramba, boolean paramBoolean1, d.l.b.a.b.f.f paramf, d.l.b.a.b.b.b.a parama, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, a.m paramm, d.l.b.a.b.e.b.c paramc, h paramh, i parami, f paramf1)
  {
    super(paraml, paramah, paramg, paramw, paramba, paramBoolean1, paramf, parama, an.JqJ, paramBoolean2, paramBoolean3, paramBoolean6, false, paramBoolean4, paramBoolean5);
    AppMethodBeat.i(60477);
    this.Jis = paramm;
    this.Jiu = paramc;
    this.Jiv = paramh;
    this.JUG = parami;
    this.JUH = paramf1;
    this.JVD = g.a.JVY;
    AppMethodBeat.o(60477);
  }
  
  public final aa a(l paraml, w paramw, ba paramba, ah paramah, d.l.b.a.b.b.b.a parama, d.l.b.a.b.f.f paramf, an paraman)
  {
    AppMethodBeat.i(60475);
    k.h(paraml, "newOwner");
    k.h(paramw, "newModality");
    k.h(paramba, "newVisibility");
    k.h(parama, "kind");
    k.h(paramf, "newName");
    k.h(paraman, "source");
    paraml = (aa)new j(paraml, paramah, fxF(), paramw, paramba, this.Jvz, paramf, parama, this.JuT, fzA(), fxE(), this.JuV, this.JtN, this.Jis, this.Jiu, this.Jiv, this.JUG, this.JUH);
    AppMethodBeat.o(60475);
    return paraml;
  }
  
  public final void a(ab paramab, aj paramaj, r paramr1, r paramr2, g.a parama)
  {
    AppMethodBeat.i(60474);
    k.h(parama, "isExperimentalCoroutineInReleaseEnvironment");
    super.a(paramab, paramaj, paramr1, paramr2);
    paramab = y.JfV;
    this.JVD = parama;
    AppMethodBeat.o(60474);
  }
  
  public final d.l.b.a.b.e.b.c fJC()
  {
    return this.Jiu;
  }
  
  public final h fJD()
  {
    return this.Jiv;
  }
  
  public final boolean fxE()
  {
    AppMethodBeat.i(60476);
    Boolean localBoolean = b.JKt.afn(this.Jis.JGd);
    k.g(localBoolean, "Flags.IS_EXTERNAL_PROPERTY.get(proto.flags)");
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(60476);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.j
 * JD-Core Version:    0.7.0.1
 */