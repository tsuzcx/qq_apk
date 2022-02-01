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
  private final c MMU;
  private final d.l.b.a.b.e.b.h MMV;
  private final j MQa;
  private List<? extends as> MYQ;
  private Collection<? extends ag> NAF;
  private aj NAG;
  private aj NAH;
  private aj NAI;
  private final a.q NAJ;
  private final i NyX;
  private final f NyY;
  private g.a NzU;
  
  public l(j paramj, d.l.b.a.b.b.l paraml, d.l.b.a.b.b.a.g paramg, d.l.b.a.b.f.f paramf, ba paramba, a.q paramq, c paramc, d.l.b.a.b.e.b.h paramh, i parami, f paramf1)
  {
    super(paraml, paramg, paramf, localan, paramba);
    AppMethodBeat.i(60488);
    this.MQa = paramj;
    this.NAJ = paramq;
    this.MMU = paramc;
    this.MMV = paramh;
    this.NyX = parami;
    this.NyY = paramf1;
    this.NzU = g.a.NAp;
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
    this.MXm = paramList;
    this.NAG = paramaj1;
    this.NAH = paramaj2;
    this.MYQ = d.l.b.a.b.b.at.a(this);
    paramaj1 = (d.l.b.a.b.b.h)this;
    paramList = gjt();
    if (paramList != null)
    {
      paramList = paramList.giI();
      if (paramList != null) {}
    }
    else
    {
      paramList = (d.l.b.a.b.j.f.h)h.b.NxX;
    }
    for (;;)
    {
      paramList = bc.a(paramaj1, paramList, (b)new d.a(this));
      p.g(paramList, "TypeUtils.makeUnsubstitu…s)?.defaultType\n        }");
      this.NAI = paramList;
      this.NAF = gjN();
      this.NzU = parama;
      AppMethodBeat.o(60483);
      return;
    }
  }
  
  public final aj giC()
  {
    AppMethodBeat.i(60485);
    aj localaj = this.NAI;
    if (localaj == null) {
      p.bcb("defaultTypeImpl");
    }
    AppMethodBeat.o(60485);
    return localaj;
  }
  
  public final j giE()
  {
    return this.MQa;
  }
  
  public final List<as> gjQ()
  {
    AppMethodBeat.i(60487);
    List localList = this.MYQ;
    if (localList == null) {
      p.bcb("typeConstructorParameters");
    }
    AppMethodBeat.o(60487);
    return localList;
  }
  
  public final aj gjr()
  {
    AppMethodBeat.i(60481);
    aj localaj = this.NAG;
    if (localaj == null) {
      p.bcb("underlyingType");
    }
    AppMethodBeat.o(60481);
    return localaj;
  }
  
  public final aj gjs()
  {
    AppMethodBeat.i(60482);
    aj localaj = this.NAH;
    if (localaj == null) {
      p.bcb("expandedType");
    }
    AppMethodBeat.o(60482);
    return localaj;
  }
  
  public final e gjt()
  {
    AppMethodBeat.i(60484);
    if (ad.aq((ab)gjs()))
    {
      AppMethodBeat.o(60484);
      return null;
    }
    d.l.b.a.b.b.h localh = gjs().gsZ().ghO();
    Object localObject = localh;
    if (!(localh instanceof e)) {
      localObject = null;
    }
    localObject = (e)localObject;
    AppMethodBeat.o(60484);
    return localObject;
  }
  
  public final c gtE()
  {
    return this.MMU;
  }
  
  public final d.l.b.a.b.e.b.h gtF()
  {
    return this.MMV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.l
 * JD-Core Version:    0.7.0.1
 */