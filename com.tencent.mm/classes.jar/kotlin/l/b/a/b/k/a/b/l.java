package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ag;
import kotlin.l.b.a.b.b.c.d;
import kotlin.l.b.a.b.b.c.d.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.e.a.q;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.j.f.h.b;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.bc;

public final class l
  extends d
  implements g
{
  private final c SZH;
  private final kotlin.l.b.a.b.e.b.h SZI;
  private g.a TLU;
  private final i TLa;
  private final f TLb;
  private Collection<? extends ag> TMF;
  private aj TMG;
  private aj TMH;
  private aj TMI;
  private final a.q TMJ;
  private final j TcN;
  private List<? extends as> TlE;
  
  public l(j paramj, kotlin.l.b.a.b.b.l paraml, kotlin.l.b.a.b.b.a.g paramg, kotlin.l.b.a.b.f.f paramf, ba paramba, a.q paramq, c paramc, kotlin.l.b.a.b.e.b.h paramh, i parami, f paramf1)
  {
    super(paraml, paramg, paramf, localan, paramba);
    AppMethodBeat.i(60488);
    this.TcN = paramj;
    this.TMJ = paramq;
    this.SZH = paramc;
    this.SZI = paramh;
    this.TLa = parami;
    this.TLb = paramf1;
    this.TLU = g.a.TMp;
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
    this.Tka = paramList;
    this.TMG = paramaj1;
    this.TMH = paramaj2;
    this.TlE = kotlin.l.b.a.b.b.at.a(this);
    paramaj1 = (kotlin.l.b.a.b.b.h)this;
    paramList = hBx();
    if (paramList != null)
    {
      paramList = paramList.hAM();
      if (paramList != null) {}
    }
    else
    {
      paramList = (kotlin.l.b.a.b.j.f.h)h.b.TKa;
    }
    for (;;)
    {
      paramList = bc.a(paramaj1, paramList, (b)new d.a(this));
      p.g(paramList, "TypeUtils.makeUnsubstitu…s)?.defaultType\n        }");
      this.TMI = paramList;
      this.TMF = hBR();
      this.TLU = parama;
      AppMethodBeat.o(60483);
      return;
    }
  }
  
  public final aj hAG()
  {
    AppMethodBeat.i(60485);
    aj localaj = this.TMI;
    if (localaj == null) {
      p.btv("defaultTypeImpl");
    }
    AppMethodBeat.o(60485);
    return localaj;
  }
  
  public final j hAI()
  {
    return this.TcN;
  }
  
  public final List<as> hBU()
  {
    AppMethodBeat.i(60487);
    List localList = this.TlE;
    if (localList == null) {
      p.btv("typeConstructorParameters");
    }
    AppMethodBeat.o(60487);
    return localList;
  }
  
  public final aj hBv()
  {
    AppMethodBeat.i(60481);
    aj localaj = this.TMG;
    if (localaj == null) {
      p.btv("underlyingType");
    }
    AppMethodBeat.o(60481);
    return localaj;
  }
  
  public final aj hBw()
  {
    AppMethodBeat.i(60482);
    aj localaj = this.TMH;
    if (localaj == null) {
      p.btv("expandedType");
    }
    AppMethodBeat.o(60482);
    return localaj;
  }
  
  public final e hBx()
  {
    AppMethodBeat.i(60484);
    if (ad.ap((ab)hBw()))
    {
      AppMethodBeat.o(60484);
      return null;
    }
    kotlin.l.b.a.b.b.h localh = hBw().hKE().hzS();
    Object localObject = localh;
    if (!(localh instanceof e)) {
      localObject = null;
    }
    localObject = (e)localObject;
    AppMethodBeat.o(60484);
    return localObject;
  }
  
  public final c hLj()
  {
    return this.SZH;
  }
  
  public final kotlin.l.b.a.b.e.b.h hLk()
  {
    return this.SZI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.l
 * JD-Core Version:    0.7.0.1
 */