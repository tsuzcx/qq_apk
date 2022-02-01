package d.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.c.ag;
import d.l.b.a.b.b.c.d;
import d.l.b.a.b.b.c.d.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.e.a.q;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.j.f.h.b;
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
  private final c KVO;
  private final d.l.b.a.b.e.b.h KVP;
  private final d.l.b.a.b.l.i KZf;
  private final d.l.b.a.b.e.b.i LHZ;
  private g.a LIW;
  private final f LIa;
  private Collection<? extends ag> LJH;
  private aj LJI;
  private aj LJJ;
  private aj LJK;
  private final a.q LJL;
  private List<? extends as> LhU;
  
  public l(d.l.b.a.b.l.i parami, d.l.b.a.b.b.l paraml, d.l.b.a.b.b.a.g paramg, d.l.b.a.b.f.f paramf, ba paramba, a.q paramq, c paramc, d.l.b.a.b.e.b.h paramh, d.l.b.a.b.e.b.i parami1, f paramf1)
  {
    super(paraml, paramg, paramf, localan, paramba);
    AppMethodBeat.i(60488);
    this.KZf = parami;
    this.LJL = paramq;
    this.KVO = paramc;
    this.KVP = paramh;
    this.LHZ = parami1;
    this.LIa = paramf1;
    this.LIW = g.a.LJr;
    AppMethodBeat.o(60488);
  }
  
  public final void a(List<? extends as> paramList, aj paramaj1, aj paramaj2, g.a parama)
  {
    AppMethodBeat.i(60483);
    k.h(paramList, "declaredTypeParameters");
    k.h(paramaj1, "underlyingType");
    k.h(paramaj2, "expandedType");
    k.h(parama, "isExperimentalCoroutineInReleaseEnvironment");
    k.h(paramList, "declaredTypeParameters");
    this.Lgq = paramList;
    this.LJI = paramaj1;
    this.LJJ = paramaj2;
    this.LhU = d.l.b.a.b.b.at.a(this);
    paramaj1 = (d.l.b.a.b.b.h)this;
    paramList = fRU();
    if (paramList != null)
    {
      paramList = paramList.fRj();
      if (paramList != null) {}
    }
    else
    {
      paramList = (d.l.b.a.b.j.f.h)h.b.LGZ;
    }
    for (;;)
    {
      paramList = bc.a(paramaj1, paramList, (b)new d.a(this));
      k.g(paramList, "TypeUtils.makeUnsubstitu…s)?.defaultType\n        }");
      this.LJK = paramList;
      this.LJH = fSp();
      this.LIW = parama;
      AppMethodBeat.o(60483);
      return;
    }
  }
  
  public final aj fRS()
  {
    AppMethodBeat.i(60481);
    aj localaj = this.LJI;
    if (localaj == null) {
      k.aVY("underlyingType");
    }
    AppMethodBeat.o(60481);
    return localaj;
  }
  
  public final aj fRT()
  {
    AppMethodBeat.i(60482);
    aj localaj = this.LJJ;
    if (localaj == null) {
      k.aVY("expandedType");
    }
    AppMethodBeat.o(60482);
    return localaj;
  }
  
  public final e fRU()
  {
    AppMethodBeat.i(60484);
    if (ad.aq((ab)fRT()))
    {
      AppMethodBeat.o(60484);
      return null;
    }
    d.l.b.a.b.b.h localh = fRT().gbz().fQq();
    Object localObject = localh;
    if (!(localh instanceof e)) {
      localObject = null;
    }
    localObject = (e)localObject;
    AppMethodBeat.o(60484);
    return localObject;
  }
  
  public final aj fRe()
  {
    AppMethodBeat.i(60485);
    aj localaj = this.LJK;
    if (localaj == null) {
      k.aVY("defaultTypeImpl");
    }
    AppMethodBeat.o(60485);
    return localaj;
  }
  
  public final d.l.b.a.b.l.i fSo()
  {
    return this.KZf;
  }
  
  public final List<as> fSs()
  {
    AppMethodBeat.i(60487);
    List localList = this.LhU;
    if (localList == null) {
      k.aVY("typeConstructorParameters");
    }
    AppMethodBeat.o(60487);
    return localList;
  }
  
  public final c gcf()
  {
    return this.KVO;
  }
  
  public final d.l.b.a.b.e.b.h gcg()
  {
    return this.KVP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.l
 * JD-Core Version:    0.7.0.1
 */