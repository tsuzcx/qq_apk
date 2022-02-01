package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.aa;
import kotlin.l.b.a.b.b.c.ac;
import kotlin.l.b.a.b.b.c.al;
import kotlin.l.b.a.b.b.c.z;
import kotlin.l.b.a.b.b.j;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.d.a.f.s;
import kotlin.l.b.a.b.f.f;
import kotlin.o;

public class g
  extends aa
  implements b
{
  private final boolean TqI;
  private final o<a.a<?>, ?> TqJ;
  
  protected g(kotlin.l.b.a.b.b.l paraml, kotlin.l.b.a.b.b.a.g paramg, w paramw, ba paramba, boolean paramBoolean1, f paramf, an paraman, ah paramah, b.a parama, boolean paramBoolean2, o<a.a<?>, ?> paramo)
  {
    super(paraml, paramah, paramg, paramw, paramba, paramBoolean1, paramf, parama, paraman, false, false, false, false, false, false);
    AppMethodBeat.i(57723);
    this.TqI = paramBoolean2;
    this.TqJ = paramo;
    AppMethodBeat.o(57723);
  }
  
  public static g a(kotlin.l.b.a.b.b.l paraml, kotlin.l.b.a.b.b.a.g paramg, w paramw, ba paramba, boolean paramBoolean1, f paramf, an paraman, boolean paramBoolean2)
  {
    AppMethodBeat.i(57724);
    if (paraml == null) {
      atM(7);
    }
    if (paramg == null) {
      atM(8);
    }
    if (paramw == null) {
      atM(9);
    }
    if (paramba == null) {
      atM(10);
    }
    if (paramf == null) {
      atM(11);
    }
    if (paraman == null) {
      atM(12);
    }
    paraml = new g(paraml, paramg, paramw, paramba, paramBoolean1, paramf, paraman, null, b.a.TgW, paramBoolean2, null);
    AppMethodBeat.o(57724);
    return paraml;
  }
  
  public final <V> V a(a.a<V> parama)
  {
    AppMethodBeat.i(57728);
    if ((this.TqJ != null) && (((a.a)this.TqJ.first).equals(parama)))
    {
      parama = this.TqJ.second;
      AppMethodBeat.o(57728);
      return parama;
    }
    AppMethodBeat.o(57728);
    return null;
  }
  
  public final aa a(kotlin.l.b.a.b.b.l paraml, w paramw, ba paramba, ah paramah, b.a parama, f paramf, an paraman)
  {
    AppMethodBeat.i(57725);
    if (paraml == null) {
      atM(13);
    }
    if (paramw == null) {
      atM(14);
    }
    if (paramba == null) {
      atM(15);
    }
    if (parama == null) {
      atM(16);
    }
    if (paramf == null) {
      atM(17);
    }
    if (paraman == null) {
      atM(18);
    }
    paraml = new g(paraml, hzL(), paramw, paramba, this.TmC, paramf, paraman, paramah, parama, this.TqI, this.TqJ);
    AppMethodBeat.o(57725);
    return paraml;
  }
  
  public final b a(kotlin.l.b.a.b.m.ab paramab1, List<l> paramList, kotlin.l.b.a.b.m.ab paramab2, o<a.a<?>, ?> paramo)
  {
    AppMethodBeat.i(57726);
    if (paramab2 == null) {
      atM(20);
    }
    g localg;
    Object localObject1;
    Object localObject2;
    w localw;
    ba localba;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    b.a locala;
    if (hBq() == this)
    {
      paramList = null;
      localg = new g(hzx(), hzL(), hzC(), hzE(), this.TmC, hAH(), hzM(), paramList, hAA(), this.TqI, paramo);
      localObject1 = this.TlZ;
      if (localObject1 == null) {
        break label455;
      }
      localObject2 = ((kotlin.l.b.a.b.b.c.ab)localObject1).hzL();
      localw = ((kotlin.l.b.a.b.b.c.ab)localObject1).hzC();
      localba = ((kotlin.l.b.a.b.b.c.ab)localObject1).hzE();
      bool1 = ((z)localObject1).isDefault;
      bool2 = ((z)localObject1).Tkp;
      bool3 = ((z)localObject1).TkO;
      locala = hAA();
      if (paramList != null) {
        break label418;
      }
      paramo = null;
      label138:
      paramo = new kotlin.l.b.a.b.b.c.ab(localg, (kotlin.l.b.a.b.b.a.g)localObject2, localw, localba, bool1, bool2, bool3, locala, paramo, ((kotlin.l.b.a.b.b.c.ab)localObject1).hzM());
      paramo.Tlb = ((z)localObject1).Tlb;
      paramo.J(paramab2);
    }
    for (;;)
    {
      localObject1 = null;
      localObject2 = this.Tma;
      if (localObject2 != null)
      {
        localObject1 = ((aj)localObject2).hzL();
        localw = ((aj)localObject2).hzC();
        localba = ((aj)localObject2).hzE();
        bool1 = ((aj)localObject2).isDefault();
        bool2 = ((aj)localObject2).isExternal();
        bool3 = ((aj)localObject2).hzI();
        locala = hAA();
        if (paramList == null)
        {
          paramList = null;
          label266:
          localObject1 = new ac(localg, (kotlin.l.b.a.b.b.a.g)localObject1, localw, localba, bool1, bool2, bool3, locala, paramList, ((aj)localObject2).hzM());
          ((z)localObject1).Tlb = ((z)localObject1).Tlb;
          ((ac)localObject1).a((av)((aj)localObject2).hAw().get(0));
        }
      }
      else
      {
        localg.a(paramo, (aj)localObject1, this.Tmc, this.Tmd);
        localg.Tmb = this.Tmb;
        if (this.TmD != null) {
          localg.a(this.TmD);
        }
        localg.x(hAy());
        if (paramab1 != null) {
          break label439;
        }
      }
      for (paramab1 = null;; paramab1 = kotlin.l.b.a.b.j.b.a(this, paramab1, g.a.hBP()))
      {
        localg.a(paramab2, hAt(), this.TkK, paramab1);
        AppMethodBeat.o(57726);
        return localg;
        paramList = hBq();
        break;
        label418:
        paramo = paramList.hBn();
        break label138;
        paramList = paramList.hBo();
        break label266;
        label439:
        paramList = kotlin.l.b.a.b.b.a.g.TiC;
      }
      label455:
      paramo = null;
    }
  }
  
  public final boolean hAx()
  {
    return false;
  }
  
  public final boolean hBH()
  {
    AppMethodBeat.i(57727);
    kotlin.l.b.a.b.m.ab localab = hBy();
    if ((this.TqI) && (j.F(localab)) && ((!s.T(localab)) || (kotlin.l.b.a.b.a.g.D(localab))))
    {
      AppMethodBeat.o(57727);
      return true;
    }
    AppMethodBeat.o(57727);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.g
 * JD-Core Version:    0.7.0.1
 */