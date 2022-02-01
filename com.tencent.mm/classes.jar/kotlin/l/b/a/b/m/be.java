package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.k;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.j.a.a.d;
import kotlin.l.b.a.b.m.a.j;
import kotlin.l.b.a.b.m.d.a;

public class be
{
  public static final be ajqz;
  public final bc aiKL;
  
  static
  {
    AppMethodBeat.i(60869);
    if (!be.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ajqz = d(bc.ajqx);
      AppMethodBeat.o(60869);
      return;
    }
  }
  
  private be(bc parambc)
  {
    AppMethodBeat.i(60855);
    this.aiKL = parambc;
    AppMethodBeat.o(60855);
  }
  
  private static az a(ad paramad, az paramaz1, ba paramba, az paramaz2)
  {
    AppMethodBeat.i(191592);
    if (paramad == null) {
      aKu(26);
    }
    if (paramaz1 == null) {
      aKu(27);
    }
    if (paramaz2 == null) {
      aKu(28);
    }
    if (!paramad.knl().i(k.a.aiDi))
    {
      if (paramaz1 == null) {
        aKu(29);
      }
      AppMethodBeat.o(191592);
      return paramaz1;
    }
    paramad = paramaz1.koG().kzm();
    if (!(paramad instanceof j))
    {
      if (paramaz1 == null) {
        aKu(30);
      }
      AppMethodBeat.o(191592);
      return paramaz1;
    }
    paramad = ((j)paramad).ajjx;
    bl localbl = paramad.kAN();
    if (b(paramaz2.kAN(), localbl) == b.ajqD)
    {
      paramad = new bb(paramad.koG());
      AppMethodBeat.o(191592);
      return paramad;
    }
    if (paramba == null)
    {
      if (paramaz1 == null) {
        aKu(31);
      }
      AppMethodBeat.o(191592);
      return paramaz1;
    }
    if (b(paramba.kom(), localbl) == b.ajqD)
    {
      paramad = new bb(paramad.koG());
      AppMethodBeat.o(191592);
      return paramad;
    }
    if (paramaz1 == null) {
      aKu(32);
    }
    AppMethodBeat.o(191592);
    return paramaz1;
  }
  
  private az a(az paramaz, int paramInt)
  {
    AppMethodBeat.i(60863);
    Object localObject1 = paramaz.koG();
    bl localbl = paramaz.kAN();
    if ((((ad)localObject1).kzm().knA() instanceof ba))
    {
      AppMethodBeat.o(60863);
      return paramaz;
    }
    paramaz = null;
    Object localObject2 = ao.aj((ad)localObject1);
    if (localObject2 != null) {
      paramaz = kAQ().c((ad)localObject2, bl.ajqM);
    }
    localObject2 = bd.a((ad)localObject1, b(((ad)localObject1).kzm().klq(), ((ad)localObject1).klR(), paramInt), this.aiKL.h(((ad)localObject1).knl()));
    localObject1 = localObject2;
    if ((localObject2 instanceof al))
    {
      localObject1 = localObject2;
      if ((paramaz instanceof al)) {
        localObject1 = ao.b((al)localObject2, (al)paramaz);
      }
    }
    paramaz = new bb(localbl, (ad)localObject1);
    AppMethodBeat.o(60863);
    return paramaz;
  }
  
  private az a(az paramaz, ba paramba, int paramInt)
  {
    AppMethodBeat.i(191589);
    if (paramaz == null) {
      aKu(18);
    }
    a(paramInt, paramaz, this.aiKL);
    if (paramaz.kAM())
    {
      if (paramaz == null) {
        aKu(19);
      }
      AppMethodBeat.o(191589);
      return paramaz;
    }
    Object localObject3 = paramaz.koG();
    Object localObject2;
    if ((localObject3 instanceof bh))
    {
      localObject1 = ((bh)localObject3).kAH();
      localObject2 = ((bh)localObject3).kAG();
      localObject1 = a(new bb(paramaz.kAN(), (ad)localObject1), paramba, paramInt + 1);
      if (((az)localObject1).kAM())
      {
        if (localObject1 == null) {
          aKu(20);
        }
        AppMethodBeat.o(191589);
        return localObject1;
      }
      paramba = c((ad)localObject2, paramaz.kAN());
      localObject2 = ((az)localObject1).koG().kAK();
      paramaz = paramba;
      if ((paramba instanceof bh)) {
        paramaz = ((bh)paramba).kAG();
      }
      paramaz = bi.b((bk)localObject2, paramaz);
      paramaz = new bb(((az)localObject1).kAN(), paramaz);
      AppMethodBeat.o(191589);
      return paramaz;
    }
    if ((t.aa((ad)localObject3)) || ((((ad)localObject3).kAK() instanceof ak)))
    {
      if (paramaz == null) {
        aKu(21);
      }
      AppMethodBeat.o(191589);
      return paramaz;
    }
    Object localObject1 = this.aiKL.G((ad)localObject3);
    if (localObject1 != null) {}
    Object localObject4;
    for (localObject1 = a((ad)localObject3, (az)localObject1, paramba, paramaz);; localObject1 = null)
    {
      localObject2 = paramaz.kAN();
      if ((localObject1 != null) || (!aa.ac((ad)localObject3)) || (aw.am((ad)localObject3))) {
        break label533;
      }
      localObject1 = aa.ad((ad)localObject3);
      localObject3 = a(new bb((bl)localObject2, ((x)localObject1).ajpE), paramba, paramInt + 1);
      paramba = a(new bb((bl)localObject2, ((x)localObject1).ajpF), paramba, paramInt + 1);
      localObject4 = ((az)localObject3).kAN();
      if (($assertionsDisabled) || ((localObject4 == paramba.kAN()) && (localObject2 == bl.ajqM)) || (localObject2 == localObject4)) {
        break;
      }
      paramaz = new AssertionError("Unexpected substituted projection kind: " + localObject4 + "; original: " + localObject2);
      AppMethodBeat.o(191589);
      throw paramaz;
    }
    if ((((az)localObject3).koG() == ((x)localObject1).ajpE) && (paramba.koG() == ((x)localObject1).ajpF))
    {
      if (paramaz == null) {
        aKu(22);
      }
      AppMethodBeat.o(191589);
      return paramaz;
    }
    paramaz = new bb((bl)localObject4, ae.a(bd.ap(((az)localObject3).koG()), bd.ap(paramba.koG())));
    AppMethodBeat.o(191589);
    return paramaz;
    label533:
    if ((h.r((ad)localObject3)) || (af.ai((ad)localObject3)))
    {
      if (paramaz == null) {
        aKu(23);
      }
      AppMethodBeat.o(191589);
      return paramaz;
    }
    if (localObject1 != null)
    {
      localObject4 = b((bl)localObject2, ((az)localObject1).kAN());
      if (!d.T((ad)localObject3)) {}
      switch (2.ajqA[localObject4.ordinal()])
      {
      default: 
        paramaz = aw.an((ad)localObject3);
        if (((az)localObject1).kAM())
        {
          if (localObject1 == null) {
            aKu(24);
          }
          AppMethodBeat.o(191589);
          return localObject1;
        }
        break;
      case 1: 
        paramaz = new a("Out-projection in in-position");
        AppMethodBeat.o(191589);
        throw paramaz;
      case 2: 
        paramaz = new bb(bl.ajqO, ((ad)localObject3).kzm().koV().kmP());
        AppMethodBeat.o(191589);
        return paramaz;
      }
      if (paramaz != null)
      {
        paramaz = paramaz.H(((az)localObject1).koG());
        paramba = paramaz;
        if (!((ad)localObject3).knl().isEmpty())
        {
          paramba = k(this.aiKL.h(((ad)localObject3).knl()));
          paramba = a.b(paramaz, new k(new g[] { paramaz.knl(), paramba }));
        }
        if (localObject4 != b.ajqB) {
          break label840;
        }
      }
      label840:
      for (paramaz = a((bl)localObject2, ((az)localObject1).kAN());; paramaz = (az)localObject2)
      {
        paramaz = new bb(paramaz, paramba);
        AppMethodBeat.o(191589);
        return paramaz;
        paramaz = bg.c(((az)localObject1).koG(), ((ad)localObject3).ksB());
        break;
      }
    }
    paramaz = a(paramaz, paramInt);
    if (paramaz == null) {
      aKu(25);
    }
    AppMethodBeat.o(191589);
    return paramaz;
  }
  
  public static bl a(bl parambl, az paramaz)
  {
    AppMethodBeat.i(60865);
    if (parambl == null) {
      aKu(35);
    }
    if (paramaz == null) {
      aKu(36);
    }
    if (paramaz.kAM())
    {
      parambl = bl.ajqO;
      if (parambl == null) {
        aKu(37);
      }
      AppMethodBeat.o(60865);
      return parambl;
    }
    parambl = a(parambl, paramaz.kAN());
    AppMethodBeat.o(60865);
    return parambl;
  }
  
  private static bl a(bl parambl1, bl parambl2)
  {
    AppMethodBeat.i(60866);
    if (parambl1 == null) {
      aKu(38);
    }
    if (parambl2 == null) {
      aKu(39);
    }
    if (parambl1 == bl.ajqM)
    {
      if (parambl2 == null) {
        aKu(40);
      }
      AppMethodBeat.o(60866);
      return parambl2;
    }
    if (parambl2 == bl.ajqM)
    {
      if (parambl1 == null) {
        aKu(41);
      }
      AppMethodBeat.o(60866);
      return parambl1;
    }
    if (parambl1 == parambl2)
    {
      if (parambl2 == null) {
        aKu(42);
      }
      AppMethodBeat.o(60866);
      return parambl2;
    }
    parambl1 = new AssertionError("Variance conflict: type parameter variance '" + parambl1 + "' and projection kind '" + parambl2 + "' cannot be combined");
    AppMethodBeat.o(60866);
    throw parambl1;
  }
  
  private static void a(int paramInt, az paramaz, bc parambc)
  {
    AppMethodBeat.i(60867);
    if (paramInt > 100)
    {
      paramaz = new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + im(paramaz) + "; substitution: " + im(parambc));
      AppMethodBeat.o(60867);
      throw paramaz;
    }
    AppMethodBeat.o(60867);
  }
  
  public static be aq(ad paramad)
  {
    AppMethodBeat.i(60854);
    if (paramad == null) {
      aKu(6);
    }
    paramad = d(ay.a(paramad.kzm(), paramad.klR()));
    AppMethodBeat.o(60854);
    return paramad;
  }
  
  private List<az> b(List<ba> paramList, List<az> paramList1, int paramInt)
  {
    AppMethodBeat.i(60864);
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = 0;
    int i = 0;
    ba localba;
    Object localObject;
    if (j < paramList.size())
    {
      localba = (ba)paramList.get(j);
      az localaz = (az)paramList1.get(j);
      localObject = a(localaz, localba, paramInt + 1);
      switch (2.ajqA[b(localba.kom(), localObject.kAN()).ordinal()])
      {
      default: 
        label128:
        if (localObject != localaz) {
          i = 1;
        }
        break;
      }
    }
    for (;;)
    {
      localArrayList.add(localObject);
      j += 1;
      break;
      if ((localba.kom() == bl.ajqM) || (((az)localObject).kAM())) {
        break label128;
      }
      localObject = new bb(bl.ajqM, ((az)localObject).koG());
      break label128;
      localObject = bg.c(localba);
      break label128;
      if (i == 0)
      {
        AppMethodBeat.o(60864);
        return paramList1;
      }
      AppMethodBeat.o(60864);
      return localArrayList;
    }
  }
  
  private static b b(bl parambl1, bl parambl2)
  {
    if ((parambl1 == bl.ajqN) && (parambl2 == bl.ajqO)) {
      return b.ajqD;
    }
    if ((parambl1 == bl.ajqO) && (parambl2 == bl.ajqN)) {
      return b.ajqC;
    }
    return b.ajqB;
  }
  
  public static be b(bc parambc1, bc parambc2)
  {
    AppMethodBeat.i(60853);
    if (parambc1 == null) {
      aKu(3);
    }
    if (parambc2 == null) {
      aKu(4);
    }
    parambc1 = d(r.a(parambc1, parambc2));
    AppMethodBeat.o(60853);
    return parambc1;
  }
  
  private az c(az paramaz)
  {
    AppMethodBeat.i(60859);
    paramaz = d(paramaz);
    if ((!this.aiKL.kAD()) && (!this.aiKL.kzo()))
    {
      AppMethodBeat.o(60859);
      return paramaz;
    }
    paramaz = kotlin.l.b.a.b.m.e.b.a(paramaz, this.aiKL.kzo());
    AppMethodBeat.o(60859);
    return paramaz;
  }
  
  public static be d(bc parambc)
  {
    AppMethodBeat.i(60852);
    if (parambc == null) {
      aKu(0);
    }
    parambc = new be(parambc);
    AppMethodBeat.o(60852);
    return parambc;
  }
  
  private static String im(Object paramObject)
  {
    AppMethodBeat.i(60868);
    try
    {
      paramObject = paramObject.toString();
      AppMethodBeat.o(60868);
      return paramObject;
    }
    finally
    {
      if (kotlin.l.b.a.b.o.c.K(paramObject))
      {
        paramObject = (RuntimeException)paramObject;
        AppMethodBeat.o(60868);
        throw paramObject;
      }
      paramObject = "[Exception while computing toString(): " + paramObject + "]";
      AppMethodBeat.o(60868);
    }
    return paramObject;
  }
  
  private static g k(g paramg)
  {
    AppMethodBeat.i(60862);
    if (paramg == null) {
      aKu(33);
    }
    if (!paramg.i(k.a.aiDi))
    {
      if (paramg == null) {
        aKu(34);
      }
      AppMethodBeat.o(60862);
      return paramg;
    }
    paramg = new kotlin.l.b.a.b.b.a.l(paramg, new kotlin.g.a.b() {}, (byte)0);
    AppMethodBeat.o(60862);
    return paramg;
  }
  
  private be kAQ()
  {
    AppMethodBeat.i(191579);
    if ((!(this.aiKL instanceof ab)) || (!this.aiKL.kzo()))
    {
      AppMethodBeat.o(191579);
      return this;
    }
    be localbe = new be(new ab(((ab)this.aiKL).ajpK, ((ab)this.aiKL).ajpL, false));
    AppMethodBeat.o(191579);
    return localbe;
  }
  
  public final ad b(ad paramad, bl parambl)
  {
    AppMethodBeat.i(60857);
    if (paramad == null) {
      aKu(9);
    }
    if (parambl == null) {
      aKu(10);
    }
    if (this.aiKL.isEmpty())
    {
      if (paramad == null) {
        aKu(11);
      }
      AppMethodBeat.o(60857);
      return paramad;
    }
    try
    {
      paramad = a(new bb(parambl, paramad), null, 0).koG();
      if (paramad == null) {
        aKu(12);
      }
      AppMethodBeat.o(60857);
      return paramad;
    }
    catch (a paramad)
    {
      paramad = v.bJt(paramad.getMessage());
      if (paramad == null) {
        aKu(13);
      }
      AppMethodBeat.o(60857);
    }
    return paramad;
  }
  
  public final ad c(ad paramad, bl parambl)
  {
    AppMethodBeat.i(60858);
    if (paramad == null) {
      aKu(14);
    }
    if (parambl == null) {
      aKu(15);
    }
    paramad = c(new bb(parambl, kAR().a(paramad, parambl)));
    if (paramad == null)
    {
      AppMethodBeat.o(60858);
      return null;
    }
    paramad = paramad.koG();
    AppMethodBeat.o(60858);
    return paramad;
  }
  
  public final az d(az paramaz)
  {
    AppMethodBeat.i(60860);
    if (paramaz == null) {
      aKu(17);
    }
    if (this.aiKL.isEmpty())
    {
      AppMethodBeat.o(60860);
      return paramaz;
    }
    try
    {
      paramaz = a(paramaz, null, 0);
      AppMethodBeat.o(60860);
      return paramaz;
    }
    catch (a paramaz)
    {
      AppMethodBeat.o(60860);
    }
    return null;
  }
  
  public final bc kAR()
  {
    AppMethodBeat.i(60856);
    bc localbc = this.aiKL;
    if (localbc == null) {
      aKu(8);
    }
    AppMethodBeat.o(60856);
    return localbc;
  }
  
  static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(60851);
      ajqB = new b("NO_CONFLICT", 0);
      ajqC = new b("IN_IN_OUT_POSITION", 1);
      ajqD = new b("OUT_IN_IN_POSITION", 2);
      ajqE = new b[] { ajqB, ajqC, ajqD };
      AppMethodBeat.o(60851);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.be
 * JD-Core Version:    0.7.0.1
 */