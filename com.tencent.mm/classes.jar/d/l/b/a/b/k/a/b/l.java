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
  private final d.l.b.a.b.e.b.i JUG;
  private final f JUH;
  private g.a JVD;
  private Collection<? extends ag> JWo;
  private aj JWp;
  private aj JWq;
  private aj JWr;
  private final a.q JWs;
  private final c Jiu;
  private final d.l.b.a.b.e.b.h Jiv;
  private final d.l.b.a.b.l.i JlL;
  private List<? extends as> JuB;
  
  public l(d.l.b.a.b.l.i parami, d.l.b.a.b.b.l paraml, d.l.b.a.b.b.a.g paramg, d.l.b.a.b.f.f paramf, ba paramba, a.q paramq, c paramc, d.l.b.a.b.e.b.h paramh, d.l.b.a.b.e.b.i parami1, f paramf1)
  {
    super(paraml, paramg, paramf, localan, paramba);
    AppMethodBeat.i(60488);
    this.JlL = parami;
    this.JWs = paramq;
    this.Jiu = paramc;
    this.Jiv = paramh;
    this.JUG = parami1;
    this.JUH = paramf1;
    this.JVD = g.a.JVY;
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
    this.JsX = paramList;
    this.JWp = paramaj1;
    this.JWq = paramaj2;
    this.JuB = d.l.b.a.b.b.at.a(this);
    paramaj1 = (d.l.b.a.b.b.h)this;
    paramList = fzq();
    if (paramList != null)
    {
      paramList = paramList.fyF();
      if (paramList != null) {}
    }
    else
    {
      paramList = (d.l.b.a.b.j.f.h)h.b.JTG;
    }
    for (;;)
    {
      paramList = bc.a(paramaj1, paramList, (b)new d.a(this));
      k.g(paramList, "TypeUtils.makeUnsubstitu…s)?.defaultType\n        }");
      this.JWr = paramList;
      this.JWo = fzL();
      this.JVD = parama;
      AppMethodBeat.o(60483);
      return;
    }
  }
  
  public final c fJC()
  {
    return this.Jiu;
  }
  
  public final d.l.b.a.b.e.b.h fJD()
  {
    return this.Jiv;
  }
  
  public final aj fyA()
  {
    AppMethodBeat.i(60485);
    aj localaj = this.JWr;
    if (localaj == null) {
      k.aPZ("defaultTypeImpl");
    }
    AppMethodBeat.o(60485);
    return localaj;
  }
  
  public final d.l.b.a.b.l.i fzK()
  {
    return this.JlL;
  }
  
  public final List<as> fzO()
  {
    AppMethodBeat.i(60487);
    List localList = this.JuB;
    if (localList == null) {
      k.aPZ("typeConstructorParameters");
    }
    AppMethodBeat.o(60487);
    return localList;
  }
  
  public final aj fzo()
  {
    AppMethodBeat.i(60481);
    aj localaj = this.JWp;
    if (localaj == null) {
      k.aPZ("underlyingType");
    }
    AppMethodBeat.o(60481);
    return localaj;
  }
  
  public final aj fzp()
  {
    AppMethodBeat.i(60482);
    aj localaj = this.JWq;
    if (localaj == null) {
      k.aPZ("expandedType");
    }
    AppMethodBeat.o(60482);
    return localaj;
  }
  
  public final e fzq()
  {
    AppMethodBeat.i(60484);
    if (ad.aq((ab)fzp()))
    {
      AppMethodBeat.o(60484);
      return null;
    }
    d.l.b.a.b.b.h localh = fzp().fIW().fxM();
    Object localObject = localh;
    if (!(localh instanceof e)) {
      localObject = null;
    }
    localObject = (e)localObject;
    AppMethodBeat.o(60484);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.l
 * JD-Core Version:    0.7.0.1
 */