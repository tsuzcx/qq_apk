package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bb;
import kotlin.l.b.a.b.b.c.ah;
import kotlin.l.b.a.b.b.c.d;
import kotlin.l.b.a.b.b.c.d.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.e.a.q;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.g.h.c;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.af;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bg;

public final class m
  extends d
  implements h
{
  private final kotlin.l.b.a.b.l.m aiBu;
  private List<? extends ba> aiLk;
  private final c aiyk;
  private final kotlin.l.b.a.b.e.b.g aiyl;
  private final kotlin.l.b.a.b.e.b.i ajml;
  private final g ajmm;
  private h.a ajng;
  private final a.q ajoj;
  private Collection<? extends ah> ajok;
  private al ajol;
  private al ajom;
  private al ajon;
  
  public m(kotlin.l.b.a.b.l.m paramm, l paraml, kotlin.l.b.a.b.b.a.g paramg, f paramf, t paramt, a.q paramq, c paramc, kotlin.l.b.a.b.e.b.g paramg1, kotlin.l.b.a.b.e.b.i parami, g paramg2)
  {
    super(paraml, paramg, paramf, localav, paramt);
    AppMethodBeat.i(192337);
    this.aiBu = paramm;
    this.ajoj = paramq;
    this.aiyk = paramc;
    this.aiyl = paramg1;
    this.ajml = parami;
    this.ajmm = paramg2;
    this.ajng = h.a.ajnC;
    AppMethodBeat.o(192337);
  }
  
  public final void a(List<? extends ba> paramList, al paramal1, al paramal2, h.a parama)
  {
    AppMethodBeat.i(60483);
    s.u(paramList, "declaredTypeParameters");
    s.u(paramal1, "underlyingType");
    s.u(paramal2, "expandedType");
    s.u(parama, "isExperimentalCoroutineInReleaseEnvironment");
    oT(paramList);
    this.ajol = paramal1;
    this.ajom = paramal2;
    this.aiLk = bb.a((kotlin.l.b.a.b.b.i)this);
    paramal1 = (kotlin.l.b.a.b.b.h)this;
    paramList = kpn();
    if (paramList == null)
    {
      paramList = null;
      if (paramList != null) {
        break label141;
      }
      paramList = (kotlin.l.b.a.b.j.g.h)h.c.ajlm;
    }
    label141:
    for (;;)
    {
      paramList = bg.a(paramal1, paramList, (b)new d.a(this));
      s.s(paramList, "@OptIn(TypeRefinement::c…s)?.defaultType\n        }");
      this.ajon = paramList;
      this.ajok = kpD();
      this.ajng = parama;
      AppMethodBeat.o(60483);
      return;
      paramList = paramList.kot();
      break;
    }
  }
  
  public final c kAc()
  {
    return this.aiyk;
  }
  
  public final kotlin.l.b.a.b.e.b.g kAd()
  {
    return this.aiyl;
  }
  
  public final kotlin.l.b.a.b.e.b.i kAe()
  {
    return this.ajml;
  }
  
  public final g kAf()
  {
    return this.ajmm;
  }
  
  public final List<kotlin.l.b.a.b.e.b.h> kAg()
  {
    AppMethodBeat.i(192404);
    List localList = h.b.b(this);
    AppMethodBeat.o(192404);
    return localList;
  }
  
  public final al koj()
  {
    AppMethodBeat.i(60485);
    al localal = this.ajon;
    if (localal == null)
    {
      s.bIx("defaultTypeImpl");
      AppMethodBeat.o(60485);
      return null;
    }
    AppMethodBeat.o(60485);
    return localal;
  }
  
  public final kotlin.l.b.a.b.l.m kol()
  {
    return this.aiBu;
  }
  
  public final List<ba> kpE()
  {
    AppMethodBeat.i(60487);
    List localList = this.aiLk;
    if (localList == null)
    {
      s.bIx("typeConstructorParameters");
      AppMethodBeat.o(60487);
      return null;
    }
    AppMethodBeat.o(60487);
    return localList;
  }
  
  public final al kpl()
  {
    AppMethodBeat.i(60481);
    al localal = this.ajol;
    if (localal != null)
    {
      AppMethodBeat.o(60481);
      return localal;
    }
    s.bIx("underlyingType");
    AppMethodBeat.o(60481);
    return null;
  }
  
  public final al kpm()
  {
    AppMethodBeat.i(60482);
    al localal = this.ajom;
    if (localal != null)
    {
      AppMethodBeat.o(60482);
      return localal;
    }
    s.bIx("expandedType");
    AppMethodBeat.o(60482);
    return null;
  }
  
  public final e kpn()
  {
    AppMethodBeat.i(60484);
    if (!af.ai((ad)kpm()))
    {
      Object localObject = kpm().kzm().knA();
      if ((localObject instanceof e))
      {
        localObject = (e)localObject;
        AppMethodBeat.o(60484);
        return localObject;
      }
    }
    AppMethodBeat.o(60484);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.m
 * JD-Core Version:    0.7.0.1
 */