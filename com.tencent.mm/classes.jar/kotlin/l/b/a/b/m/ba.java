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
  public static final ba abrf;
  public final ay aaOa;
  
  static
  {
    AppMethodBeat.i(60869);
    if (!ba.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      abrf = d(ay.abrd);
      AppMethodBeat.o(60869);
      return;
    }
  }
  
  private ba(ay paramay)
  {
    AppMethodBeat.i(60855);
    this.aaOa = paramay;
    AppMethodBeat.o(60855);
  }
  
  private av a(av paramav, int paramInt)
  {
    AppMethodBeat.i(60861);
    if (paramav == null) {
      aDG(16);
    }
    a(paramInt, paramav, this.aaOa);
    if (paramav.iPZ())
    {
      if (paramav == null) {
        aDG(17);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    Object localObject3 = paramav.iFN();
    Object localObject1;
    if ((localObject3 instanceof bd))
    {
      localObject1 = ((bd)localObject3).iPU();
      localObject2 = ((bd)localObject3).iPV();
      localObject1 = a(new ax(paramav.iQa(), (ab)localObject1), paramInt + 1);
      paramav = c((ab)localObject2, paramav.iQa());
      paramav = be.b(((av)localObject1).iFN().iPX(), paramav);
      paramav = new ax(((av)localObject1).iQa(), paramav);
      AppMethodBeat.o(60861);
      return paramav;
    }
    if ((s.aj((ab)localObject3)) || ((((ab)localObject3).iPX() instanceof ai)))
    {
      if (paramav == null) {
        aDG(18);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    av localav = this.aaOa.N((ab)localObject3);
    Object localObject2 = paramav.iQa();
    Object localObject4;
    if ((localav == null) && (y.al((ab)localObject3)) && (!as.at((ab)localObject3)))
    {
      localObject1 = y.am((ab)localObject3);
      localav = a(new ax((bh)localObject2, ((v)localObject1).abqv), paramInt + 1);
      localObject3 = a(new ax((bh)localObject2, ((v)localObject1).abqw), paramInt + 1);
      localObject4 = localav.iQa();
      if ((!$assertionsDisabled) && ((localObject4 != ((av)localObject3).iQa()) || (localObject2 != bh.abrp)) && (localObject2 != localObject4))
      {
        paramav = new AssertionError("Unexpected substituted projection kind: " + localObject4 + "; original: " + localObject2);
        AppMethodBeat.o(60861);
        throw paramav;
      }
      if ((localav.iFN() == ((v)localObject1).abqv) && (((av)localObject3).iFN() == ((v)localObject1).abqw))
      {
        if (paramav == null) {
          aDG(19);
        }
        AppMethodBeat.o(60861);
        return paramav;
      }
      paramav = new ax((bh)localObject4, ac.a(az.ay(localav.iFN()), az.ay(((av)localObject3).iFN())));
      AppMethodBeat.o(60861);
      return paramav;
    }
    if ((kotlin.l.b.a.b.a.g.x((ab)localObject3)) || (ad.ap((ab)localObject3)))
    {
      if (paramav == null) {
        aDG(20);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    if (localav != null)
    {
      localObject4 = b((bh)localObject2, localav.iQa());
      if (!d.ad((ab)localObject3)) {}
      switch (2.abrg[localObject4.ordinal()])
      {
      default: 
        paramav = as.au((ab)localObject3);
        if (localav.iPZ())
        {
          if (localav == null) {
            aDG(21);
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
        paramav = new ax(bh.abrr, ((ab)localObject3).iOU().iFv().iDv());
        AppMethodBeat.o(60861);
        return paramav;
      }
      if (paramav != null)
      {
        paramav = paramav.Q(localav.iFN());
        localObject1 = paramav;
        if (!((ab)localObject3).iDY().isEmpty())
        {
          localObject1 = j(this.aaOa.h(((ab)localObject3).iDY()));
          localObject1 = a.a(paramav, new kotlin.l.b.a.b.b.a.k(new kotlin.l.b.a.b.b.a.g[] { paramav.iDY(), localObject1 }));
        }
        if (localObject4 != b.abrh) {
          break label755;
        }
      }
      label755:
      for (paramav = a((bh)localObject2, localav.iQa());; paramav = (av)localObject2)
      {
        paramav = new ax(paramav, (ab)localObject1);
        AppMethodBeat.o(60861);
        return paramav;
        paramav = bc.c(localav.iFN(), ((ab)localObject3).iIu());
        break;
      }
    }
    paramav = b(paramav, paramInt);
    if (paramav == null) {
      aDG(22);
    }
    AppMethodBeat.o(60861);
    return paramav;
  }
  
  public static bh a(bh parambh, av paramav)
  {
    AppMethodBeat.i(60865);
    if (parambh == null) {
      aDG(25);
    }
    if (paramav == null) {
      aDG(26);
    }
    if (paramav.iPZ())
    {
      parambh = bh.abrr;
      if (parambh == null) {
        aDG(27);
      }
      AppMethodBeat.o(60865);
      return parambh;
    }
    parambh = a(parambh, paramav.iQa());
    AppMethodBeat.o(60865);
    return parambh;
  }
  
  private static bh a(bh parambh1, bh parambh2)
  {
    AppMethodBeat.i(60866);
    if (parambh1 == null) {
      aDG(28);
    }
    if (parambh2 == null) {
      aDG(29);
    }
    if (parambh1 == bh.abrp)
    {
      if (parambh2 == null) {
        aDG(30);
      }
      AppMethodBeat.o(60866);
      return parambh2;
    }
    if (parambh2 == bh.abrp)
    {
      if (parambh1 == null) {
        aDG(31);
      }
      AppMethodBeat.o(60866);
      return parambh1;
    }
    if (parambh1 == parambh2)
    {
      if (parambh2 == null) {
        aDG(32);
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
      paramav = new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + fK(paramav) + "; substitution: " + fK(paramay));
      AppMethodBeat.o(60867);
      throw paramav;
    }
    AppMethodBeat.o(60867);
  }
  
  public static ba az(ab paramab)
  {
    AppMethodBeat.i(60854);
    if (paramab == null) {
      aDG(4);
    }
    paramab = d(au.a(paramab.iOU(), paramab.iOR()));
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
      switch (2.abrg[b(localas.iEW(), localObject.iQa()).ordinal()])
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
      if ((localas.iEW() == bh.abrp) || (((av)localObject).iPZ())) {
        break label124;
      }
      localObject = new ax(bh.abrp, ((av)localObject).iFN());
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
    Object localObject1 = paramav.iFN();
    bh localbh = paramav.iQa();
    if ((((ab)localObject1).iOU().iEf() instanceof kotlin.l.b.a.b.b.as))
    {
      AppMethodBeat.o(60863);
      return paramav;
    }
    paramav = null;
    Object localObject2 = am.aq((ab)localObject1);
    if (localObject2 != null) {
      paramav = c((ab)localObject2, bh.abrp);
    }
    localObject2 = az.a((ab)localObject1, b(((ab)localObject1).iOU().iCb(), ((ab)localObject1).iOR(), paramInt), this.aaOa.h(((ab)localObject1).iDY()));
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
    if ((parambh1 == bh.abrq) && (parambh2 == bh.abrr)) {
      return b.abrj;
    }
    if ((parambh1 == bh.abrr) && (parambh2 == bh.abrq)) {
      return b.abri;
    }
    return b.abrh;
  }
  
  public static ba b(ay paramay1, ay paramay2)
  {
    AppMethodBeat.i(60853);
    if (paramay1 == null) {
      aDG(1);
    }
    if (paramay2 == null) {
      aDG(2);
    }
    paramay1 = d(q.a(paramay1, paramay2));
    AppMethodBeat.o(60853);
    return paramay1;
  }
  
  private av c(av paramav)
  {
    AppMethodBeat.i(60859);
    paramav = d(paramav);
    if ((!this.aaOa.iPR()) && (!this.aaOa.iOW()))
    {
      AppMethodBeat.o(60859);
      return paramav;
    }
    paramav = kotlin.l.b.a.b.m.e.b.a(paramav, this.aaOa.iOW());
    AppMethodBeat.o(60859);
    return paramav;
  }
  
  public static ba d(ay paramay)
  {
    AppMethodBeat.i(60852);
    if (paramay == null) {
      aDG(0);
    }
    paramay = new ba(paramay);
    AppMethodBeat.o(60852);
    return paramay;
  }
  
  private static String fK(Object paramObject)
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
      aDG(23);
    }
    if (!paramg.h(kotlin.l.b.a.b.a.g.aaFI.aaGv))
    {
      if (paramg == null) {
        aDG(24);
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
      aDG(7);
    }
    if (parambh == null) {
      aDG(8);
    }
    if (this.aaOa.isEmpty())
    {
      if (paramab == null) {
        aDG(9);
      }
      AppMethodBeat.o(60857);
      return paramab;
    }
    try
    {
      paramab = a(new ax(parambh, paramab), 0).iFN();
      if (paramab == null) {
        aDG(10);
      }
      AppMethodBeat.o(60857);
      return paramab;
    }
    catch (a paramab)
    {
      paramab = u.bHp(paramab.getMessage());
      if (paramab == null) {
        aDG(11);
      }
      AppMethodBeat.o(60857);
    }
    return paramab;
  }
  
  public final ab c(ab paramab, bh parambh)
  {
    AppMethodBeat.i(60858);
    if (paramab == null) {
      aDG(12);
    }
    if (parambh == null) {
      aDG(13);
    }
    paramab = c(new ax(parambh, iQc().a(paramab, parambh)));
    if (paramab == null)
    {
      AppMethodBeat.o(60858);
      return null;
    }
    paramab = paramab.iFN();
    AppMethodBeat.o(60858);
    return paramab;
  }
  
  public final av d(av paramav)
  {
    AppMethodBeat.i(60860);
    if (paramav == null) {
      aDG(15);
    }
    if (this.aaOa.isEmpty())
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
  
  public final ay iQc()
  {
    AppMethodBeat.i(60856);
    ay localay = this.aaOa;
    if (localay == null) {
      aDG(6);
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
      abrh = new b("NO_CONFLICT", 0);
      abri = new b("IN_IN_OUT_POSITION", 1);
      abrj = new b("OUT_IN_IN_POSITION", 2);
      abrk = new b[] { abrh, abri, abrj };
      AppMethodBeat.o(60851);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ba
 * JD-Core Version:    0.7.0.1
 */