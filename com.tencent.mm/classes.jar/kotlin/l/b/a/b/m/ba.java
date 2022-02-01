package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.a.l;
import kotlin.l.b.a.b.j.a.a.d;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.o.c;

public class ba
{
  public static final ba TOF;
  public final ay Tlg;
  
  static
  {
    AppMethodBeat.i(60869);
    if (!ba.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      TOF = d(ay.TOD);
      AppMethodBeat.o(60869);
      return;
    }
  }
  
  private ba(ay paramay)
  {
    AppMethodBeat.i(60855);
    this.Tlg = paramay;
    AppMethodBeat.o(60855);
  }
  
  private av a(av paramav, int paramInt)
  {
    AppMethodBeat.i(60861);
    if (paramav == null) {
      atM(16);
    }
    a(paramInt, paramav, this.Tlg);
    if (paramav.hLH())
    {
      if (paramav == null) {
        atM(17);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    Object localObject3 = paramav.hBy();
    Object localObject1;
    if ((localObject3 instanceof bd))
    {
      localObject1 = ((bd)localObject3).hLC();
      localObject2 = ((bd)localObject3).hLD();
      localObject1 = a(new ax(paramav.hLI(), (ab)localObject1), paramInt + 1);
      paramav = c((ab)localObject2, paramav.hLI());
      paramav = be.b(((av)localObject1).hBy().hLF(), paramav);
      paramav = new ax(((av)localObject1).hLI(), paramav);
      AppMethodBeat.o(60861);
      return paramav;
    }
    if ((s.aj((ab)localObject3)) || ((((ab)localObject3).hLF() instanceof ai)))
    {
      if (paramav == null) {
        atM(18);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    av localav = this.Tlg.N((ab)localObject3);
    Object localObject2 = paramav.hLI();
    Object localObject4;
    if ((localav == null) && (y.al((ab)localObject3)) && (!as.at((ab)localObject3)))
    {
      localObject1 = y.am((ab)localObject3);
      localav = a(new ax((bh)localObject2, ((v)localObject1).TNV), paramInt + 1);
      localObject3 = a(new ax((bh)localObject2, ((v)localObject1).TNW), paramInt + 1);
      localObject4 = localav.hLI();
      if ((!$assertionsDisabled) && ((localObject4 != ((av)localObject3).hLI()) || (localObject2 != bh.TOQ)) && (localObject2 != localObject4))
      {
        paramav = new AssertionError("Unexpected substituted projection kind: " + localObject4 + "; original: " + localObject2);
        AppMethodBeat.o(60861);
        throw paramav;
      }
      if ((localav.hBy() == ((v)localObject1).TNV) && (((av)localObject3).hBy() == ((v)localObject1).TNW))
      {
        if (paramav == null) {
          atM(19);
        }
        AppMethodBeat.o(60861);
        return paramav;
      }
      paramav = new ax((bh)localObject4, ac.a(az.ay(localav.hBy()), az.ay(((av)localObject3).hBy())));
      AppMethodBeat.o(60861);
      return paramav;
    }
    if ((kotlin.l.b.a.b.a.g.x((ab)localObject3)) || (ad.ap((ab)localObject3)))
    {
      if (paramav == null) {
        atM(20);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    if (localav != null)
    {
      localObject4 = b((bh)localObject2, localav.hLI());
      if (!d.ad((ab)localObject3)) {}
      switch (2.TOG[localObject4.ordinal()])
      {
      default: 
        paramav = as.au((ab)localObject3);
        if (localav.hLH())
        {
          if (localav == null) {
            atM(21);
          }
          AppMethodBeat.o(60861);
          return localav;
        }
        break;
      case 1: 
        paramav = new a("Out-projection in in-position");
        AppMethodBeat.o(60861);
        throw paramav;
      case 2: 
        paramav = new ax(bh.TOS, ((ab)localObject3).hKE().hBh().hzj());
        AppMethodBeat.o(60861);
        return paramav;
      }
      if (paramav != null)
      {
        paramav = paramav.Q(localav.hBy());
        localObject1 = paramav;
        if (!((ab)localObject3).hzL().isEmpty())
        {
          localObject1 = j(this.Tlg.h(((ab)localObject3).hzL()));
          localObject1 = a.a(paramav, new kotlin.l.b.a.b.b.a.k(new kotlin.l.b.a.b.b.a.g[] { paramav.hzL(), localObject1 }));
        }
        if (localObject4 != b.TOH) {
          break label755;
        }
      }
      label755:
      for (paramav = a((bh)localObject2, localav.hLI());; paramav = (av)localObject2)
      {
        paramav = new ax(paramav, (ab)localObject1);
        AppMethodBeat.o(60861);
        return paramav;
        paramav = bc.c(localav.hBy(), ((ab)localObject3).hEa());
        break;
      }
    }
    paramav = b(paramav, paramInt);
    if (paramav == null) {
      atM(22);
    }
    AppMethodBeat.o(60861);
    return paramav;
  }
  
  public static bh a(bh parambh, av paramav)
  {
    AppMethodBeat.i(60865);
    if (parambh == null) {
      atM(25);
    }
    if (paramav == null) {
      atM(26);
    }
    if (paramav.hLH())
    {
      parambh = bh.TOS;
      if (parambh == null) {
        atM(27);
      }
      AppMethodBeat.o(60865);
      return parambh;
    }
    parambh = a(parambh, paramav.hLI());
    AppMethodBeat.o(60865);
    return parambh;
  }
  
  private static bh a(bh parambh1, bh parambh2)
  {
    AppMethodBeat.i(60866);
    if (parambh1 == null) {
      atM(28);
    }
    if (parambh2 == null) {
      atM(29);
    }
    if (parambh1 == bh.TOQ)
    {
      if (parambh2 == null) {
        atM(30);
      }
      AppMethodBeat.o(60866);
      return parambh2;
    }
    if (parambh2 == bh.TOQ)
    {
      if (parambh1 == null) {
        atM(31);
      }
      AppMethodBeat.o(60866);
      return parambh1;
    }
    if (parambh1 == parambh2)
    {
      if (parambh2 == null) {
        atM(32);
      }
      AppMethodBeat.o(60866);
      return parambh2;
    }
    parambh1 = new AssertionError("Variance conflict: type parameter variance '" + parambh1 + "' and projection kind '" + parambh2 + "' cannot be combined");
    AppMethodBeat.o(60866);
    throw parambh1;
  }
  
  private static void a(int paramInt, av paramav, ay paramay)
  {
    AppMethodBeat.i(60867);
    if (paramInt > 100)
    {
      paramav = new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + fE(paramav) + "; substitution: " + fE(paramay));
      AppMethodBeat.o(60867);
      throw paramav;
    }
    AppMethodBeat.o(60867);
  }
  
  public static ba az(ab paramab)
  {
    AppMethodBeat.i(60854);
    if (paramab == null) {
      atM(4);
    }
    paramab = d(au.a(paramab.hKE(), paramab.hKB()));
    AppMethodBeat.o(60854);
    return paramab;
  }
  
  private List<av> b(List<kotlin.l.b.a.b.b.as> paramList, List<av> paramList1, int paramInt)
  {
    AppMethodBeat.i(60864);
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = 0;
    int i = 0;
    kotlin.l.b.a.b.b.as localas;
    Object localObject;
    if (j < paramList.size())
    {
      localas = (kotlin.l.b.a.b.b.as)paramList.get(j);
      av localav = (av)paramList1.get(j);
      localObject = a(localav, paramInt + 1);
      switch (2.TOG[b(localas.hAJ(), localObject.hLI()).ordinal()])
      {
      default: 
        label124:
        if (localObject != localav) {
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
      if ((localas.hAJ() == bh.TOQ) || (((av)localObject).hLH())) {
        break label124;
      }
      localObject = new ax(bh.TOQ, ((av)localObject).hBy());
      break label124;
      localObject = bc.d(localas);
      break label124;
      if (i == 0)
      {
        AppMethodBeat.o(60864);
        return paramList1;
      }
      AppMethodBeat.o(60864);
      return localArrayList;
    }
  }
  
  private av b(av paramav, int paramInt)
  {
    AppMethodBeat.i(60863);
    Object localObject1 = paramav.hBy();
    bh localbh = paramav.hLI();
    if ((((ab)localObject1).hKE().hzS() instanceof kotlin.l.b.a.b.b.as))
    {
      AppMethodBeat.o(60863);
      return paramav;
    }
    paramav = null;
    Object localObject2 = am.aq((ab)localObject1);
    if (localObject2 != null) {
      paramav = c((ab)localObject2, bh.TOQ);
    }
    localObject2 = az.a((ab)localObject1, b(((ab)localObject1).hKE().getParameters(), ((ab)localObject1).hKB(), paramInt), this.Tlg.h(((ab)localObject1).hzL()));
    localObject1 = localObject2;
    if ((localObject2 instanceof aj))
    {
      localObject1 = localObject2;
      if ((paramav instanceof aj)) {
        localObject1 = am.b((aj)localObject2, (aj)paramav);
      }
    }
    paramav = new ax(localbh, (ab)localObject1);
    AppMethodBeat.o(60863);
    return paramav;
  }
  
  private static b b(bh parambh1, bh parambh2)
  {
    if ((parambh1 == bh.TOR) && (parambh2 == bh.TOS)) {
      return b.TOJ;
    }
    if ((parambh1 == bh.TOS) && (parambh2 == bh.TOR)) {
      return b.TOI;
    }
    return b.TOH;
  }
  
  public static ba b(ay paramay1, ay paramay2)
  {
    AppMethodBeat.i(60853);
    if (paramay1 == null) {
      atM(1);
    }
    if (paramay2 == null) {
      atM(2);
    }
    paramay1 = d(q.a(paramay1, paramay2));
    AppMethodBeat.o(60853);
    return paramay1;
  }
  
  private av c(av paramav)
  {
    AppMethodBeat.i(60859);
    paramav = d(paramav);
    if ((!this.Tlg.hLy()) && (!this.Tlg.hKG()))
    {
      AppMethodBeat.o(60859);
      return paramav;
    }
    paramav = kotlin.l.b.a.b.m.e.b.a(paramav, this.Tlg.hKG());
    AppMethodBeat.o(60859);
    return paramav;
  }
  
  public static ba d(ay paramay)
  {
    AppMethodBeat.i(60852);
    if (paramay == null) {
      atM(0);
    }
    paramay = new ba(paramay);
    AppMethodBeat.o(60852);
    return paramay;
  }
  
  private static String fE(Object paramObject)
  {
    AppMethodBeat.i(60868);
    try
    {
      paramObject = paramObject.toString();
      AppMethodBeat.o(60868);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      if (c.u(paramObject))
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
  
  private static kotlin.l.b.a.b.b.a.g j(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60862);
    if (paramg == null) {
      atM(23);
    }
    if (!paramg.h(kotlin.l.b.a.b.a.g.TcO.TdB))
    {
      if (paramg == null) {
        atM(24);
      }
      AppMethodBeat.o(60862);
      return paramg;
    }
    paramg = new l(paramg, new kotlin.g.a.b() {}, (byte)0);
    AppMethodBeat.o(60862);
    return paramg;
  }
  
  public final ab b(ab paramab, bh parambh)
  {
    AppMethodBeat.i(60857);
    if (paramab == null) {
      atM(7);
    }
    if (parambh == null) {
      atM(8);
    }
    if (this.Tlg.isEmpty())
    {
      if (paramab == null) {
        atM(9);
      }
      AppMethodBeat.o(60857);
      return paramab;
    }
    try
    {
      paramab = a(new ax(parambh, paramab), 0).hBy();
      if (paramab == null) {
        atM(10);
      }
      AppMethodBeat.o(60857);
      return paramab;
    }
    catch (a paramab)
    {
      paramab = u.bun(paramab.getMessage());
      if (paramab == null) {
        atM(11);
      }
      AppMethodBeat.o(60857);
    }
    return paramab;
  }
  
  public final ab c(ab paramab, bh parambh)
  {
    AppMethodBeat.i(60858);
    if (paramab == null) {
      atM(12);
    }
    if (parambh == null) {
      atM(13);
    }
    paramab = c(new ax(parambh, hLK().a(paramab, parambh)));
    if (paramab == null)
    {
      AppMethodBeat.o(60858);
      return null;
    }
    paramab = paramab.hBy();
    AppMethodBeat.o(60858);
    return paramab;
  }
  
  public final av d(av paramav)
  {
    AppMethodBeat.i(60860);
    if (paramav == null) {
      atM(15);
    }
    if (this.Tlg.isEmpty())
    {
      AppMethodBeat.o(60860);
      return paramav;
    }
    try
    {
      paramav = a(paramav, 0);
      AppMethodBeat.o(60860);
      return paramav;
    }
    catch (a paramav)
    {
      AppMethodBeat.o(60860);
    }
    return null;
  }
  
  public final ay hLK()
  {
    AppMethodBeat.i(60856);
    ay localay = this.Tlg;
    if (localay == null) {
      atM(6);
    }
    AppMethodBeat.o(60856);
    return localay;
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
      TOH = new b("NO_CONFLICT", 0);
      TOI = new b("IN_IN_OUT_POSITION", 1);
      TOJ = new b("OUT_IN_IN_POSITION", 2);
      TOK = new b[] { TOH, TOI, TOJ };
      AppMethodBeat.o(60851);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ba
 * JD-Core Version:    0.7.0.1
 */