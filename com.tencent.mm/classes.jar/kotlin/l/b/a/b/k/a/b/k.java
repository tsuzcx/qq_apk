package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.c.ac;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.v;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.b.b;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.f.f;

public final class k
  extends kotlin.l.b.a.b.b.c.ab
  implements c
{
  public final a.m aiyi;
  public final kotlin.l.b.a.b.e.b.c aiyk;
  public final kotlin.l.b.a.b.e.b.g aiyl;
  private final i ajml;
  public final g ajmm;
  private h.a ajng;
  
  public k(l paraml, ap paramap, kotlin.l.b.a.b.b.a.g paramg, kotlin.l.b.a.b.b.ab paramab, t paramt, boolean paramBoolean1, f paramf, kotlin.l.b.a.b.b.b.a parama, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, a.m paramm, kotlin.l.b.a.b.e.b.c paramc, kotlin.l.b.a.b.e.b.g paramg1, i parami, g paramg2)
  {
    super(paraml, paramap, paramg, paramab, paramt, paramBoolean1, paramf, parama, av.aiHu, paramBoolean2, paramBoolean3, paramBoolean6, false, paramBoolean4, paramBoolean5);
    AppMethodBeat.i(192363);
    this.aiyi = paramm;
    this.aiyk = paramc;
    this.aiyl = paramg1;
    this.ajml = parami;
    this.ajmm = paramg2;
    this.ajng = h.a.ajnC;
    AppMethodBeat.o(192363);
  }
  
  public final kotlin.l.b.a.b.b.c.ab a(l paraml, kotlin.l.b.a.b.b.ab paramab, t paramt, ap paramap, kotlin.l.b.a.b.b.b.a parama, f paramf, av paramav)
  {
    AppMethodBeat.i(192396);
    s.u(paraml, "newOwner");
    s.u(paramab, "newModality");
    s.u(paramt, "newVisibility");
    s.u(parama, "kind");
    s.u(paramf, "newName");
    s.u(paramav, "source");
    paraml = (kotlin.l.b.a.b.b.c.ab)new k(paraml, paramap, knl(), paramab, paramt, kpu(), paramf, parama, kpx(), kpw(), knk(), kpy(), kni(), this.aiyi, this.aiyk, this.aiyl, this.ajml, this.ajmm);
    AppMethodBeat.o(192396);
    return paraml;
  }
  
  public final void a(ac paramac, ar paramar, v paramv1, v paramv2, h.a parama)
  {
    AppMethodBeat.i(60474);
    s.u(parama, "isExperimentalCoroutineInReleaseEnvironment");
    super.a(paramac, paramar, paramv1, paramv2);
    paramac = ah.aiuX;
    this.ajng = parama;
    AppMethodBeat.o(60474);
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
    AppMethodBeat.i(192410);
    List localList = c.a.a((c)this);
    AppMethodBeat.o(192410);
    return localList;
  }
  
  public final boolean knk()
  {
    AppMethodBeat.i(60476);
    Boolean localBoolean = b.ajcM.aLV(this.aiyi.aiYq);
    s.s(localBoolean, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(60476);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.k
 * JD-Core Version:    0.7.0.1
 */