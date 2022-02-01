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
  private final c aaCB;
  private final kotlin.l.b.a.b.e.b.h aaCC;
  private final j aaFH;
  private List<? extends as> aaOy;
  private final i abnD;
  private final f abnE;
  private g.a abow;
  private Collection<? extends ag> abph;
  private aj abpi;
  private aj abpj;
  private aj abpk;
  private final a.q abpl;
  
  public l(j paramj, kotlin.l.b.a.b.b.l paraml, kotlin.l.b.a.b.b.a.g paramg, kotlin.l.b.a.b.f.f paramf, ba paramba, a.q paramq, c paramc, kotlin.l.b.a.b.e.b.h paramh, i parami, f paramf1)
  {
    super(paraml, paramg, paramf, localan, paramba);
    AppMethodBeat.i(60488);
    this.aaFH = paramj;
    this.abpl = paramq;
    this.aaCB = paramc;
    this.aaCC = paramh;
    this.abnD = parami;
    this.abnE = paramf1;
    this.abow = g.a.aboR;
    AppMethodBeat.o(60488);
  }
  
  public final void a(List<? extends as> paramList, aj paramaj1, aj paramaj2, g.a parama)
  {
    AppMethodBeat.i(60483);
    p.k(paramList, "declaredTypeParameters");
    p.k(paramaj1, "underlyingType");
    p.k(paramaj2, "expandedType");
    p.k(parama, "isExperimentalCoroutineInReleaseEnvironment");
    lx(paramList);
    this.abpi = paramaj1;
    this.abpj = paramaj2;
    this.aaOy = kotlin.l.b.a.b.b.at.a(this);
    paramaj1 = (kotlin.l.b.a.b.b.h)this;
    paramList = iFM();
    if (paramList != null)
    {
      paramList = paramList.iEZ();
      if (paramList != null) {}
    }
    else
    {
      paramList = (kotlin.l.b.a.b.j.f.h)h.b.abmC;
    }
    for (;;)
    {
      paramList = bc.a(paramaj1, paramList, (b)new d.a(this));
      p.j(paramList, "TypeUtils.makeUnsubstitu…s)?.defaultType\n        }");
      this.abpk = paramList;
      this.abph = iGg();
      this.abow = parama;
      AppMethodBeat.o(60483);
      return;
    }
  }
  
  public final aj iET()
  {
    AppMethodBeat.i(60485);
    aj localaj = this.abpk;
    if (localaj == null) {
      p.bGy("defaultTypeImpl");
    }
    AppMethodBeat.o(60485);
    return localaj;
  }
  
  public final j iEV()
  {
    return this.aaFH;
  }
  
  public final aj iFK()
  {
    AppMethodBeat.i(60481);
    aj localaj = this.abpi;
    if (localaj == null) {
      p.bGy("underlyingType");
    }
    AppMethodBeat.o(60481);
    return localaj;
  }
  
  public final aj iFL()
  {
    AppMethodBeat.i(60482);
    aj localaj = this.abpj;
    if (localaj == null) {
      p.bGy("expandedType");
    }
    AppMethodBeat.o(60482);
    return localaj;
  }
  
  public final e iFM()
  {
    AppMethodBeat.i(60484);
    if (ad.ap((ab)iFL()))
    {
      AppMethodBeat.o(60484);
      return null;
    }
    kotlin.l.b.a.b.b.h localh = iFL().iOU().iEf();
    Object localObject = localh;
    if (!(localh instanceof e)) {
      localObject = null;
    }
    localObject = (e)localObject;
    AppMethodBeat.o(60484);
    return localObject;
  }
  
  public final List<as> iGj()
  {
    AppMethodBeat.i(60487);
    List localList = this.aaOy;
    if (localList == null) {
      p.bGy("typeConstructorParameters");
    }
    AppMethodBeat.o(60487);
    return localList;
  }
  
  public final c iPB()
  {
    return this.aaCB;
  }
  
  public final kotlin.l.b.a.b.e.b.h iPC()
  {
    return this.aaCC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.l
 * JD-Core Version:    0.7.0.1
 */