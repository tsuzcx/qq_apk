package d.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.c.ag;
import d.l.b.a.b.b.c.d;
import d.l.b.a.b.b.c.d.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.e.a.q;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.b.i;
import d.l.b.a.b.j.f.h.b;
import d.l.b.a.b.l.j;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ad;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.bc;
import java.util.Collection;
import java.util.List;

public final class l
  extends d
  implements g
{
  private final i NWe;
  private final f NWf;
  private Collection<? extends ag> NXM;
  private aj NXN;
  private aj NXO;
  private aj NXP;
  private final a.q NXQ;
  private g.a NXb;
  private final c NjZ;
  private final d.l.b.a.b.e.b.h Nka;
  private final j Nnf;
  private List<? extends as> NvW;
  
  public l(j paramj, d.l.b.a.b.b.l paraml, d.l.b.a.b.b.a.g paramg, d.l.b.a.b.f.f paramf, ba paramba, a.q paramq, c paramc, d.l.b.a.b.e.b.h paramh, i parami, f paramf1)
  {
    super(paraml, paramg, paramf, localan, paramba);
    AppMethodBeat.i(60488);
    this.Nnf = paramj;
    this.NXQ = paramq;
    this.NjZ = paramc;
    this.Nka = paramh;
    this.NWe = parami;
    this.NWf = paramf1;
    this.NXb = g.a.NXw;
    AppMethodBeat.o(60488);
  }
  
  public final void a(List<? extends as> paramList, aj paramaj1, aj paramaj2, g.a parama)
  {
    AppMethodBeat.i(60483);
    p.h(paramList, "declaredTypeParameters");
    p.h(paramaj1, "underlyingType");
    p.h(paramaj2, "expandedType");
    p.h(parama, "isExperimentalCoroutineInReleaseEnvironment");
    p.h(paramList, "declaredTypeParameters");
    this.Nus = paramList;
    this.NXN = paramaj1;
    this.NXO = paramaj2;
    this.NvW = d.l.b.a.b.b.at.a(this);
    paramaj1 = (d.l.b.a.b.b.h)this;
    paramList = gnV();
    if (paramList != null)
    {
      paramList = paramList.gnk();
      if (paramList != null) {}
    }
    else
    {
      paramList = (d.l.b.a.b.j.f.h)h.b.NVe;
    }
    for (;;)
    {
      paramList = bc.a(paramaj1, paramList, (b)new d.a(this));
      p.g(paramList, "TypeUtils.makeUnsubstitu…s)?.defaultType\n        }");
      this.NXP = paramList;
      this.NXM = gop();
      this.NXb = parama;
      AppMethodBeat.o(60483);
      return;
    }
  }
  
  public final aj gnT()
  {
    AppMethodBeat.i(60481);
    aj localaj = this.NXN;
    if (localaj == null) {
      p.bdF("underlyingType");
    }
    AppMethodBeat.o(60481);
    return localaj;
  }
  
  public final aj gnU()
  {
    AppMethodBeat.i(60482);
    aj localaj = this.NXO;
    if (localaj == null) {
      p.bdF("expandedType");
    }
    AppMethodBeat.o(60482);
    return localaj;
  }
  
  public final e gnV()
  {
    AppMethodBeat.i(60484);
    if (ad.aq((ab)gnU()))
    {
      AppMethodBeat.o(60484);
      return null;
    }
    d.l.b.a.b.b.h localh = gnU().gxB().gmq();
    Object localObject = localh;
    if (!(localh instanceof e)) {
      localObject = null;
    }
    localObject = (e)localObject;
    AppMethodBeat.o(60484);
    return localObject;
  }
  
  public final aj gne()
  {
    AppMethodBeat.i(60485);
    aj localaj = this.NXP;
    if (localaj == null) {
      p.bdF("defaultTypeImpl");
    }
    AppMethodBeat.o(60485);
    return localaj;
  }
  
  public final j gng()
  {
    return this.Nnf;
  }
  
  public final List<as> gos()
  {
    AppMethodBeat.i(60487);
    List localList = this.NvW;
    if (localList == null) {
      p.bdF("typeConstructorParameters");
    }
    AppMethodBeat.o(60487);
    return localList;
  }
  
  public final c gyg()
  {
    return this.NjZ;
  }
  
  public final d.l.b.a.b.e.b.h gyh()
  {
    return this.Nka;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.l
 * JD-Core Version:    0.7.0.1
 */