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
  public final a.m KVM;
  public final d.l.b.a.b.e.b.c KVO;
  public final h KVP;
  private final i LHZ;
  private g.a LIW;
  public final f LIa;
  
  public j(l paraml, ah paramah, g paramg, w paramw, ba paramba, boolean paramBoolean1, d.l.b.a.b.f.f paramf, d.l.b.a.b.b.b.a parama, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, a.m paramm, d.l.b.a.b.e.b.c paramc, h paramh, i parami, f paramf1)
  {
    super(paraml, paramah, paramg, paramw, paramba, paramBoolean1, paramf, parama, an.Lec, paramBoolean2, paramBoolean3, paramBoolean6, false, paramBoolean4, paramBoolean5);
    AppMethodBeat.i(60477);
    this.KVM = paramm;
    this.KVO = paramc;
    this.KVP = paramh;
    this.LHZ = parami;
    this.LIa = paramf1;
    this.LIW = g.a.LJr;
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
    paraml = (aa)new j(paraml, paramah, fQj(), paramw, paramba, this.LiS, paramf, parama, this.Lim, fSe(), fQi(), this.Lio, this.Lhg, this.KVM, this.KVO, this.KVP, this.LHZ, this.LIa);
    AppMethodBeat.o(60475);
    return paraml;
  }
  
  public final void a(ab paramab, aj paramaj, r paramr1, r paramr2, g.a parama)
  {
    AppMethodBeat.i(60474);
    k.h(parama, "isExperimentalCoroutineInReleaseEnvironment");
    super.a(paramab, paramaj, paramr1, paramr2);
    paramab = y.KTp;
    this.LIW = parama;
    AppMethodBeat.o(60474);
  }
  
  public final boolean fQi()
  {
    AppMethodBeat.i(60476);
    Boolean localBoolean = b.LxM.aij(this.KVM.Ltw);
    k.g(localBoolean, "Flags.IS_EXTERNAL_PROPERTY.get(proto.flags)");
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(60476);
    return bool;
  }
  
  public final d.l.b.a.b.e.b.c gcf()
  {
    return this.KVO;
  }
  
  public final h gcg()
  {
    return this.KVP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.j
 * JD-Core Version:    0.7.0.1
 */