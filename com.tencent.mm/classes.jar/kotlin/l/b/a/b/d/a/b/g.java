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
  private final boolean aaTC;
  private final o<a.a<?>, ?> aaTD;
  
  protected g(kotlin.l.b.a.b.b.l paraml, kotlin.l.b.a.b.b.a.g paramg, w paramw, ba paramba, boolean paramBoolean1, f paramf, an paraman, ah paramah, b.a parama, boolean paramBoolean2, o<a.a<?>, ?> paramo)
  {
    super(paraml, paramah, paramg, paramw, paramba, paramBoolean1, paramf, parama, paraman, false, false, false, false, false, false);
    AppMethodBeat.i(57723);
    this.aaTC = paramBoolean2;
    this.aaTD = paramo;
    AppMethodBeat.o(57723);
  }
  
  public static g a(kotlin.l.b.a.b.b.l paraml, kotlin.l.b.a.b.b.a.g paramg, w paramw, ba paramba, boolean paramBoolean1, f paramf, an paraman, boolean paramBoolean2)
  {
    AppMethodBeat.i(57724);
    if (paraml == null) {
      aDG(7);
    }
    if (paramg == null) {
      aDG(8);
    }
    if (paramw == null) {
      aDG(9);
    }
    if (paramba == null) {
      aDG(10);
    }
    if (paramf == null) {
      aDG(11);
    }
    if (paraman == null) {
      aDG(12);
    }
    paraml = new g(paraml, paramg, paramw, paramba, paramBoolean1, paramf, paraman, null, b.a.aaJQ, paramBoolean2, null);
    AppMethodBeat.o(57724);
    return paraml;
  }
  
  public final <V> V a(a.a<V> parama)
  {
    AppMethodBeat.i(57728);
    if ((this.aaTD != null) && (((a.a)this.aaTD.Mx).equals(parama)))
    {
      parama = this.aaTD.My;
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
      aDG(13);
    }
    if (paramw == null) {
      aDG(14);
    }
    if (paramba == null) {
      aDG(15);
    }
    if (parama == null) {
      aDG(16);
    }
    if (paramf == null) {
      aDG(17);
    }
    if (paraman == null) {
      aDG(18);
    }
    paraml = new g(paraml, iDY(), paramw, paramba, iFU(), paramf, paraman, paramah, parama, this.aaTC, this.aaTD);
    AppMethodBeat.o(57725);
    return paraml;
  }
  
  public final b a(kotlin.l.b.a.b.m.ab paramab1, List<l> paramList, kotlin.l.b.a.b.m.ab paramab2, o<a.a<?>, ?> paramo)
  {
    AppMethodBeat.i(57726);
    if (paramab2 == null) {
      aDG(20);
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
    if (iFF() == this)
    {
      paramList = null;
      localg = new g(iDJ(), iDY(), iDO(), iDQ(), iFU(), iEU(), iDZ(), paramList, iEN(), this.aaTC, paramo);
      localObject1 = this.aaOT;
      if (localObject1 == null) {
        break label455;
      }
      localObject2 = ((kotlin.l.b.a.b.b.c.ab)localObject1).iDY();
      localw = ((kotlin.l.b.a.b.b.c.ab)localObject1).iDO();
      localba = ((kotlin.l.b.a.b.b.c.ab)localObject1).iDQ();
      bool1 = ((z)localObject1).lJx;
      bool2 = ((z)localObject1).aaNj;
      bool3 = ((z)localObject1).aaNI;
      locala = iEN();
      if (paramList != null) {
        break label418;
      }
      paramo = null;
      label138:
      paramo = new kotlin.l.b.a.b.b.c.ab(localg, (kotlin.l.b.a.b.b.a.g)localObject2, localw, localba, bool1, bool2, bool3, locala, paramo, ((kotlin.l.b.a.b.b.c.ab)localObject1).iDZ());
      paramo.aaNV = ((z)localObject1).aaNV;
      paramo.J(paramab2);
    }
    for (;;)
    {
      localObject1 = null;
      localObject2 = iFD();
      if (localObject2 != null)
      {
        localObject1 = ((aj)localObject2).iDY();
        localw = ((aj)localObject2).iDO();
        localba = ((aj)localObject2).iDQ();
        bool1 = ((aj)localObject2).iFA();
        bool2 = ((aj)localObject2).iDX();
        bool3 = ((aj)localObject2).iDU();
        locala = iEN();
        if (paramList == null)
        {
          paramList = null;
          label266:
          localObject1 = new ac(localg, (kotlin.l.b.a.b.b.a.g)localObject1, localw, localba, bool1, bool2, bool3, locala, paramList, ((aj)localObject2).iDZ());
          ((z)localObject1).aaNV = ((z)localObject1).aaNV;
          ((ac)localObject1).a((av)((aj)localObject2).iEJ().get(0));
        }
      }
      else
      {
        localg.a(paramo, (aj)localObject1, iFG(), iFH());
        localg.Jl(iGE());
        if (this.aaPx != null) {
          localg.a(this.aaPx);
        }
        localg.v(iEL());
        if (paramab1 != null) {
          break label439;
        }
      }
      for (paramab1 = null;; paramab1 = kotlin.l.b.a.b.j.b.a(this, paramab1, g.a.iGe()))
      {
        localg.a(paramab2, iEG(), iEF(), paramab1);
        AppMethodBeat.o(57726);
        return localg;
        paramList = iFF();
        break;
        label418:
        paramo = paramList.iFC();
        break label138;
        paramList = paramList.iFD();
        break label266;
        label439:
        paramList = kotlin.l.b.a.b.b.a.g.aaLw;
      }
      label455:
      paramo = null;
    }
  }
  
  public final boolean iEK()
  {
    return false;
  }
  
  public final boolean iFW()
  {
    AppMethodBeat.i(57727);
    kotlin.l.b.a.b.m.ab localab = iFN();
    if ((this.aaTC) && (j.F(localab)) && ((!s.T(localab)) || (kotlin.l.b.a.b.a.g.D(localab))))
    {
      AppMethodBeat.o(57727);
      return true;
    }
    AppMethodBeat.o(57727);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.g
 * JD-Core Version:    0.7.0.1
 */