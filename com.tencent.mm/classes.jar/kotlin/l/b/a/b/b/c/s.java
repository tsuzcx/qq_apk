package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.x.a;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.j.g.h;
import kotlin.l.b.a.b.j.g.m;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.c.k;
import kotlin.l.b.a.b.m.j;
import kotlin.l.b.a.b.m.q;

public class s
  extends t
{
  private List<ba> aiHh;
  private ax aiJX;
  private final t aiLh;
  private final be aiLi;
  private be aiLj;
  private List<ba> aiLk;
  
  static
  {
    AppMethodBeat.i(191911);
    if (!s.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(191911);
      return;
    }
  }
  
  public s(t paramt, be parambe)
  {
    this.aiLh = paramt;
    this.aiLi = parambe;
  }
  
  private be kpR()
  {
    AppMethodBeat.i(57133);
    if (this.aiLj == null)
    {
      if (!this.aiLi.aiKL.isEmpty()) {
        break label45;
      }
      this.aiLj = this.aiLi;
    }
    for (;;)
    {
      Object localObject = this.aiLj;
      AppMethodBeat.o(57133);
      return localObject;
      label45:
      localObject = this.aiLh.kmZ().klq();
      this.aiLk = new ArrayList(((List)localObject).size());
      this.aiLj = q.a((List)localObject, this.aiLi.kAR(), this, this.aiLk);
      this.aiHh = p.c(this.aiLk, new b() {});
    }
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57158);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57158);
    return paramn;
  }
  
  public final h a(kotlin.l.b.a.b.m.a.g paramg)
  {
    AppMethodBeat.i(57138);
    if (paramg == null) {
      aKu(13);
    }
    paramg = this.aiLh.a(paramg);
    if (this.aiLi.aiKL.isEmpty())
    {
      if (paramg == null) {
        aKu(14);
      }
      AppMethodBeat.o(57138);
      return paramg;
    }
    paramg = new m(paramg, kpR());
    AppMethodBeat.o(57138);
    return paramg;
  }
  
  public final h a(bc parambc)
  {
    AppMethodBeat.i(57136);
    if (parambc == null) {
      aKu(10);
    }
    parambc = a(parambc, a.e(kotlin.l.b.a.b.j.d.s(this)));
    if (parambc == null) {
      aKu(11);
    }
    AppMethodBeat.o(57136);
    return parambc;
  }
  
  public final h a(bc parambc, kotlin.l.b.a.b.m.a.g paramg)
  {
    AppMethodBeat.i(57135);
    if (parambc == null) {
      aKu(5);
    }
    if (paramg == null) {
      aKu(6);
    }
    parambc = this.aiLh.a(parambc, paramg);
    if (this.aiLi.aiKL.isEmpty())
    {
      if (parambc == null) {
        aKu(7);
      }
      AppMethodBeat.o(57135);
      return parambc;
    }
    parambc = new m(parambc, kpR());
    AppMethodBeat.o(57135);
    return parambc;
  }
  
  public final boolean isValue()
  {
    AppMethodBeat.i(191949);
    boolean bool = this.aiLh.isValue();
    AppMethodBeat.o(191949);
    return bool;
  }
  
  public final Collection<kotlin.l.b.a.b.b.d> klv()
  {
    AppMethodBeat.i(57142);
    Object localObject = this.aiLh.klv();
    ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      kotlin.l.b.a.b.b.d locald = (kotlin.l.b.a.b.b.d)((Iterator)localObject).next();
      localArrayList.add(((kotlin.l.b.a.b.b.d)locald.koO().d(locald.kos()).a(locald.knb()).d(locald.knc()).a(locald.koh()).Pj(false).koU()).a(kpR()));
    }
    AppMethodBeat.o(57142);
    return localArrayList;
  }
  
  public final ax kmZ()
  {
    AppMethodBeat.i(57134);
    Object localObject2 = this.aiLh.kmZ();
    if (this.aiLi.aiKL.isEmpty())
    {
      if (localObject2 == null) {
        aKu(0);
      }
      AppMethodBeat.o(57134);
      return localObject2;
    }
    if (this.aiJX == null)
    {
      localObject1 = kpR();
      Object localObject3 = ((ax)localObject2).kpG();
      localObject2 = new ArrayList(((Collection)localObject3).size());
      localObject3 = ((Collection)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((be)localObject1).c((ad)((Iterator)localObject3).next(), bl.ajqM));
      }
      this.aiJX = new j(this, this.aiLk, (Collection)localObject2, kotlin.l.b.a.b.l.e.ajos);
    }
    Object localObject1 = this.aiJX;
    if (localObject1 == null) {
      aKu(1);
    }
    AppMethodBeat.o(57134);
    return localObject1;
  }
  
  public final kotlin.l.b.a.b.b.f kna()
  {
    AppMethodBeat.i(57148);
    kotlin.l.b.a.b.b.f localf = this.aiLh.kna();
    if (localf == null) {
      aKu(24);
    }
    AppMethodBeat.o(57148);
    return localf;
  }
  
  public final ab knb()
  {
    AppMethodBeat.i(57149);
    ab localab = this.aiLh.knb();
    if (localab == null) {
      aKu(25);
    }
    AppMethodBeat.o(57149);
    return localab;
  }
  
  public final kotlin.l.b.a.b.b.t knc()
  {
    AppMethodBeat.i(191935);
    kotlin.l.b.a.b.b.t localt = this.aiLh.knc();
    if (localt == null) {
      aKu(26);
    }
    AppMethodBeat.o(191935);
    return localt;
  }
  
  public final boolean knd()
  {
    AppMethodBeat.i(57155);
    boolean bool = this.aiLh.knd();
    AppMethodBeat.o(57155);
    return bool;
  }
  
  public final boolean kne()
  {
    AppMethodBeat.i(57151);
    boolean bool = this.aiLh.kne();
    AppMethodBeat.o(57151);
    return bool;
  }
  
  public final boolean knf()
  {
    AppMethodBeat.i(57152);
    boolean bool = this.aiLh.knf();
    AppMethodBeat.o(57152);
    return bool;
  }
  
  public final boolean kng()
  {
    AppMethodBeat.i(57153);
    boolean bool = this.aiLh.kng();
    AppMethodBeat.o(57153);
    return bool;
  }
  
  public final boolean knh()
  {
    AppMethodBeat.i(191946);
    boolean bool = this.aiLh.knh();
    AppMethodBeat.o(191946);
    return bool;
  }
  
  public final boolean kni()
  {
    AppMethodBeat.i(57156);
    boolean bool = this.aiLh.kni();
    AppMethodBeat.o(57156);
    return bool;
  }
  
  public final boolean knj()
  {
    AppMethodBeat.i(57157);
    boolean bool = this.aiLh.knj();
    AppMethodBeat.o(57157);
    return bool;
  }
  
  public final boolean knk()
  {
    AppMethodBeat.i(57154);
    boolean bool = this.aiLh.knk();
    AppMethodBeat.o(57154);
    return bool;
  }
  
  public final kotlin.l.b.a.b.b.a.g knl()
  {
    AppMethodBeat.i(57143);
    kotlin.l.b.a.b.b.a.g localg = this.aiLh.knl();
    if (localg == null) {
      aKu(18);
    }
    AppMethodBeat.o(57143);
    return localg;
  }
  
  public final av knm()
  {
    AppMethodBeat.i(57161);
    av localav = av.aiHu;
    if (localav == null) {
      aKu(28);
    }
    AppMethodBeat.o(57161);
    return localav;
  }
  
  public final y<al> knn()
  {
    AppMethodBeat.i(191977);
    Object localObject = this.aiLh.knn();
    if (localObject == null)
    {
      AppMethodBeat.o(191977);
      return null;
    }
    kotlin.l.b.a.b.f.f localf = ((y)localObject).aiGV;
    al localal = (al)knn().aiGW;
    localObject = localal;
    if (localal != null) {
      if (!this.aiLi.aiKL.isEmpty()) {
        break label81;
      }
    }
    for (localObject = localal;; localObject = (al)localObject)
    {
      localObject = new y(localf, (k)localObject);
      AppMethodBeat.o(191977);
      return localObject;
      label81:
      localObject = kpR().c(localal, bl.ajqM);
      if ((!$assertionsDisabled) && (!(localObject instanceof al)))
      {
        localObject = new AssertionError("Substitution for SimpleType should also be a SimpleType, but it is " + localObject + "\nUnsubstituted: " + localal);
        AppMethodBeat.o(191977);
        throw ((Throwable)localObject);
      }
    }
  }
  
  public final List<ba> kno()
  {
    AppMethodBeat.i(57162);
    kpR();
    List localList = this.aiHh;
    if (localList == null) {
      aKu(29);
    }
    AppMethodBeat.o(57162);
    return localList;
  }
  
  public final l knp()
  {
    AppMethodBeat.i(57146);
    l locall = this.aiLh.knp();
    if (locall == null) {
      aKu(21);
    }
    AppMethodBeat.o(57146);
    return locall;
  }
  
  public final h knq()
  {
    AppMethodBeat.i(57139);
    h localh = this.aiLh.knq();
    if (localh == null) {
      aKu(15);
    }
    AppMethodBeat.o(57139);
    return localh;
  }
  
  public final kotlin.l.b.a.b.b.e knr()
  {
    AppMethodBeat.i(57147);
    kotlin.l.b.a.b.b.e locale = this.aiLh.knr();
    AppMethodBeat.o(57147);
    return locale;
  }
  
  public final kotlin.l.b.a.b.b.d kns()
  {
    AppMethodBeat.i(57160);
    kotlin.l.b.a.b.b.d locald = this.aiLh.kns();
    AppMethodBeat.o(57160);
    return locald;
  }
  
  public final Collection<kotlin.l.b.a.b.b.e> knt()
  {
    AppMethodBeat.i(57163);
    Collection localCollection = this.aiLh.knt();
    if (localCollection == null) {
      aKu(30);
    }
    AppMethodBeat.o(57163);
    return localCollection;
  }
  
  public final al koj()
  {
    AppMethodBeat.i(57140);
    Object localObject = bg.pe(kmZ().klq());
    localObject = ae.a(knl(), kmZ(), (List)localObject, false, kot());
    if (localObject == null) {
      aKu(16);
    }
    AppMethodBeat.o(57140);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.f.f kok()
  {
    AppMethodBeat.i(57144);
    kotlin.l.b.a.b.f.f localf = this.aiLh.kok();
    if (localf == null) {
      aKu(19);
    }
    AppMethodBeat.o(57144);
    return localf;
  }
  
  public final h kot()
  {
    AppMethodBeat.i(57137);
    h localh = a(a.e(kotlin.l.b.a.b.j.d.s(this.aiLh)));
    if (localh == null) {
      aKu(12);
    }
    AppMethodBeat.o(57137);
    return localh;
  }
  
  public final h kou()
  {
    AppMethodBeat.i(57159);
    h localh = this.aiLh.kou();
    if (localh == null) {
      aKu(27);
    }
    AppMethodBeat.o(57159);
    return localh;
  }
  
  public final as kov()
  {
    AppMethodBeat.i(57141);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(57141);
    throw localUnsupportedOperationException;
  }
  
  public final kotlin.l.b.a.b.b.e kow()
  {
    AppMethodBeat.i(57145);
    kotlin.l.b.a.b.b.e locale = this.aiLh.kow();
    if (locale == null) {
      aKu(20);
    }
    AppMethodBeat.o(57145);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.s
 * JD-Core Version:    0.7.0.1
 */