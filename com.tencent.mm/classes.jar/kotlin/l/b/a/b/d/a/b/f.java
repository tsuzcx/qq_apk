package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.c.aa;
import kotlin.l.b.a.b.b.c.ac;
import kotlin.l.b.a.b.b.j;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.d.a.f.s;
import kotlin.l.b.a.b.j.c;
import kotlin.r;

public class f
  extends kotlin.l.b.a.b.b.c.ab
  implements a
{
  private final boolean aiRD;
  private final r<a.a<?>, ?> aiRE;
  
  protected f(l paraml, g paramg, kotlin.l.b.a.b.b.ab paramab, t paramt, boolean paramBoolean1, kotlin.l.b.a.b.f.f paramf, av paramav, ap paramap, b.a parama, boolean paramBoolean2, r<a.a<?>, ?> paramr)
  {
    super(paraml, paramap, paramg, paramab, paramt, paramBoolean1, paramf, parama, paramav, false, false, false, false, false, false);
    AppMethodBeat.i(191993);
    this.aiRD = paramBoolean2;
    this.aiRE = paramr;
    AppMethodBeat.o(191993);
  }
  
  public static f a(l paraml, g paramg, kotlin.l.b.a.b.b.ab paramab, t paramt, boolean paramBoolean1, kotlin.l.b.a.b.f.f paramf, av paramav, boolean paramBoolean2)
  {
    AppMethodBeat.i(191997);
    if (paraml == null) {
      aKu(7);
    }
    if (paramg == null) {
      aKu(8);
    }
    if (paramab == null) {
      aKu(9);
    }
    if (paramt == null) {
      aKu(10);
    }
    if (paramf == null) {
      aKu(11);
    }
    if (paramav == null) {
      aKu(12);
    }
    paraml = new f(paraml, paramg, paramab, paramt, paramBoolean1, paramf, paramav, null, b.a.aiGl, paramBoolean2, null);
    AppMethodBeat.o(191997);
    return paraml;
  }
  
  public final <V> V a(a.a<V> parama)
  {
    AppMethodBeat.i(57728);
    if ((this.aiRE != null) && (((a.a)this.aiRE.bsC).equals(parama)))
    {
      parama = this.aiRE.bsD;
      AppMethodBeat.o(57728);
      return parama;
    }
    AppMethodBeat.o(57728);
    return null;
  }
  
  public final kotlin.l.b.a.b.b.c.ab a(l paraml, kotlin.l.b.a.b.b.ab paramab, t paramt, ap paramap, b.a parama, kotlin.l.b.a.b.f.f paramf, av paramav)
  {
    AppMethodBeat.i(192011);
    if (paraml == null) {
      aKu(13);
    }
    if (paramab == null) {
      aKu(14);
    }
    if (paramt == null) {
      aKu(15);
    }
    if (parama == null) {
      aKu(16);
    }
    if (paramf == null) {
      aKu(17);
    }
    if (paramav == null) {
      aKu(18);
    }
    paraml = new f(paraml, knl(), paramab, paramt, kpu(), paramf, paramav, paramap, parama, this.aiRD, this.aiRE);
    AppMethodBeat.o(192011);
    return paraml;
  }
  
  public final a a(kotlin.l.b.a.b.m.ad paramad1, List<i> paramList, kotlin.l.b.a.b.m.ad paramad2, r<a.a<?>, ?> paramr)
  {
    AppMethodBeat.i(57726);
    if (paramad2 == null) {
      aKu(20);
    }
    f localf;
    Object localObject1;
    Object localObject2;
    kotlin.l.b.a.b.b.ab localab;
    t localt;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    b.a locala;
    if (kpf() == this)
    {
      paramList = null;
      localf = new f(knp(), knl(), knb(), knc(), kpu(), kok(), knm(), paramList, koh(), this.aiRD, paramr);
      localObject1 = this.aiLL;
      if (localObject1 == null) {
        break label455;
      }
      localObject2 = ((ac)localObject1).knl();
      localab = ((ac)localObject1).knb();
      localt = ((ac)localObject1).knc();
      bool1 = ((aa)localObject1).oBZ;
      bool2 = ((aa)localObject1).aiJU;
      bool3 = ((aa)localObject1).aiKt;
      locala = koh();
      if (paramList != null) {
        break label418;
      }
      paramr = null;
      label138:
      paramr = new ac(localf, (g)localObject2, localab, localt, bool1, bool2, bool3, locala, paramr, ((ac)localObject1).knm());
      paramr.aiKG = ((aa)localObject1).aiKG;
      paramr.C(paramad2);
    }
    for (;;)
    {
      localObject1 = null;
      localObject2 = kpd();
      if (localObject2 != null)
      {
        localObject1 = ((ar)localObject2).knl();
        localab = ((ar)localObject2).knb();
        localt = ((ar)localObject2).knc();
        bool1 = ((ar)localObject2).kpa();
        bool2 = ((ar)localObject2).knk();
        bool3 = ((ar)localObject2).kng();
        locala = koh();
        if (paramList == null)
        {
          paramList = null;
          label266:
          localObject1 = new kotlin.l.b.a.b.b.c.ad(localf, (g)localObject1, localab, localt, bool1, bool2, bool3, locala, paramList, ((ar)localObject2).knm());
          ((aa)localObject1).aiKG = ((aa)localObject1).aiKG;
          ((kotlin.l.b.a.b.b.c.ad)localObject1).a((bd)((ar)localObject2).kod().get(0));
        }
      }
      else
      {
        localf.a(paramr, (ar)localObject1, kpg(), kph());
        localf.Po(kqc());
        if (this.aiMp != null) {
          localf.a(this.aiMp);
        }
        localf.M(kof());
        if (paramad1 != null) {
          break label439;
        }
      }
      for (paramad1 = null;; paramad1 = c.a(this, paramad1, g.a.kpB()))
      {
        localf.a(paramad2, koa(), knZ(), paramad1);
        AppMethodBeat.o(57726);
        return localf;
        paramList = kpf();
        break;
        label418:
        paramr = paramList.kpc();
        break label138;
        paramList = paramList.kpd();
        break label266;
        label439:
        paramList = g.aiIh;
      }
      label455:
      paramr = null;
    }
  }
  
  public final boolean koe()
  {
    return false;
  }
  
  public final boolean kpw()
  {
    AppMethodBeat.i(57727);
    kotlin.l.b.a.b.m.ad localad = koG();
    if ((this.aiRD) && (j.y(localad)) && ((!s.K(localad)) || (h.w(localad))))
    {
      AppMethodBeat.o(57727);
      return true;
    }
    AppMethodBeat.o(57727);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.f
 * JD-Core Version:    0.7.0.1
 */