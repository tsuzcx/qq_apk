package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.a.l;
import d.l.b.a.b.j.a.a.d;
import d.l.b.a.b.m.d.a;
import d.l.b.a.b.o.c;
import java.util.ArrayList;
import java.util.List;

public class ba
{
  public static final ba LLK;
  public final ay Lhw;
  
  static
  {
    AppMethodBeat.i(60869);
    if (!ba.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LLK = d(ay.LLI);
      AppMethodBeat.o(60869);
      return;
    }
  }
  
  private ba(ay paramay)
  {
    AppMethodBeat.i(60855);
    this.Lhw = paramay;
    AppMethodBeat.o(60855);
  }
  
  private av a(av paramav, int paramInt)
  {
    AppMethodBeat.i(60861);
    if (paramav == null) {
      agL(16);
    }
    a(paramInt, paramav, this.Lhw);
    if (paramav.gcB())
    {
      if (paramav == null) {
        agL(17);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    Object localObject3 = paramav.fRV();
    Object localObject1;
    if ((localObject3 instanceof bd))
    {
      localObject1 = ((bd)localObject3).gcw();
      localObject2 = ((bd)localObject3).gcx();
      localObject1 = a(new ax(paramav.gcC(), (ab)localObject1), paramInt + 1);
      paramav = c((ab)localObject2, paramav.gcC());
      paramav = be.b(((av)localObject1).fRV().gcz(), paramav);
      paramav = new ax(((av)localObject1).gcC(), paramav);
      AppMethodBeat.o(60861);
      return paramav;
    }
    if ((s.ak((ab)localObject3)) || ((((ab)localObject3).gcz() instanceof ai)))
    {
      if (paramav == null) {
        agL(18);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    av localav = this.Lhw.O((ab)localObject3);
    Object localObject2 = paramav.gcC();
    Object localObject4;
    if ((localav == null) && (y.am((ab)localObject3)) && (!as.au((ab)localObject3)))
    {
      localObject1 = y.an((ab)localObject3);
      localav = a(new ax((bh)localObject2, ((v)localObject1).LLa), paramInt + 1);
      localObject3 = a(new ax((bh)localObject2, ((v)localObject1).LLb), paramInt + 1);
      localObject4 = localav.gcC();
      if ((!$assertionsDisabled) && ((localObject4 != ((av)localObject3).gcC()) || (localObject2 != bh.LLV)) && (localObject2 != localObject4))
      {
        paramav = new AssertionError("Unexpected substituted projection kind: " + localObject4 + "; original: " + localObject2);
        AppMethodBeat.o(60861);
        throw paramav;
      }
      if ((localav.fRV() == ((v)localObject1).LLa) && (((av)localObject3).fRV() == ((v)localObject1).LLb))
      {
        if (paramav == null) {
          agL(19);
        }
        AppMethodBeat.o(60861);
        return paramav;
      }
      paramav = new ax((bh)localObject4, ac.a(az.az(localav.fRV()), az.az(((av)localObject3).fRV())));
      AppMethodBeat.o(60861);
      return paramav;
    }
    if ((d.l.b.a.b.a.g.x((ab)localObject3)) || (ad.aq((ab)localObject3)))
    {
      if (paramav == null) {
        agL(20);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    if (localav != null)
    {
      localObject4 = b((bh)localObject2, localav.gcC());
      if (!d.ae((ab)localObject3)) {}
      switch (2.LLL[localObject4.ordinal()])
      {
      default: 
        paramav = as.av((ab)localObject3);
        if (localav.gcB())
        {
          if (localav == null) {
            agL(21);
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
        paramav = new ax(bh.LLX, ((ab)localObject3).gbz().fRE().fPG());
        AppMethodBeat.o(60861);
        return paramav;
      }
      if (paramav != null)
      {
        paramav = paramav.R(localav.fRV());
        localObject1 = paramav;
        if (!((ab)localObject3).fQj().isEmpty())
        {
          localObject1 = j(this.Lhw.h(((ab)localObject3).fQj()));
          localObject1 = a.a(paramav, new d.l.b.a.b.b.a.k(new d.l.b.a.b.b.a.g[] { paramav.fQj(), localObject1 }));
        }
        if (localObject4 != b.LLM) {
          break label755;
        }
      }
      label755:
      for (paramav = a((bh)localObject2, localav.gcC());; paramav = (av)localObject2)
      {
        paramav = new ax(paramav, (ab)localObject1);
        AppMethodBeat.o(60861);
        return paramav;
        paramav = bc.b(localav.fRV(), ((ab)localObject3).fUx());
        break;
      }
    }
    paramav = b(paramav, paramInt);
    if (paramav == null) {
      agL(22);
    }
    AppMethodBeat.o(60861);
    return paramav;
  }
  
  public static bh a(bh parambh, av paramav)
  {
    AppMethodBeat.i(60865);
    if (parambh == null) {
      agL(25);
    }
    if (paramav == null) {
      agL(26);
    }
    if (paramav.gcB())
    {
      parambh = bh.LLX;
      if (parambh == null) {
        agL(27);
      }
      AppMethodBeat.o(60865);
      return parambh;
    }
    parambh = a(parambh, paramav.gcC());
    AppMethodBeat.o(60865);
    return parambh;
  }
  
  private static bh a(bh parambh1, bh parambh2)
  {
    AppMethodBeat.i(60866);
    if (parambh1 == null) {
      agL(28);
    }
    if (parambh2 == null) {
      agL(29);
    }
    if (parambh1 == bh.LLV)
    {
      if (parambh2 == null) {
        agL(30);
      }
      AppMethodBeat.o(60866);
      return parambh2;
    }
    if (parambh2 == bh.LLV)
    {
      if (parambh1 == null) {
        agL(31);
      }
      AppMethodBeat.o(60866);
      return parambh1;
    }
    if (parambh1 == parambh2)
    {
      if (parambh2 == null) {
        agL(32);
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
      paramav = new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + fu(paramav) + "; substitution: " + fu(paramay));
      AppMethodBeat.o(60867);
      throw paramav;
    }
    AppMethodBeat.o(60867);
  }
  
  public static ba aA(ab paramab)
  {
    AppMethodBeat.i(60854);
    if (paramab == null) {
      agL(4);
    }
    paramab = d(au.a(paramab.gbz(), paramab.gbw()));
    AppMethodBeat.o(60854);
    return paramab;
  }
  
  private av b(av paramav, int paramInt)
  {
    AppMethodBeat.i(60863);
    Object localObject1 = paramav.fRV();
    bh localbh = paramav.gcC();
    if ((((ab)localObject1).gbz().fQq() instanceof d.l.b.a.b.b.as))
    {
      AppMethodBeat.o(60863);
      return paramav;
    }
    paramav = null;
    Object localObject2 = am.ar((ab)localObject1);
    if (localObject2 != null) {
      paramav = c((ab)localObject2, bh.LLV);
    }
    localObject2 = az.a((ab)localObject1, b(((ab)localObject1).gbz().getParameters(), ((ab)localObject1).gbw(), paramInt), this.Lhw.h(((ab)localObject1).fQj()));
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
    if ((parambh1 == bh.LLW) && (parambh2 == bh.LLX)) {
      return b.LLO;
    }
    if ((parambh1 == bh.LLX) && (parambh2 == bh.LLW)) {
      return b.LLN;
    }
    return b.LLM;
  }
  
  public static ba b(ay paramay1, ay paramay2)
  {
    AppMethodBeat.i(60853);
    if (paramay1 == null) {
      agL(1);
    }
    if (paramay2 == null) {
      agL(2);
    }
    paramay1 = d(q.a(paramay1, paramay2));
    AppMethodBeat.o(60853);
    return paramay1;
  }
  
  private List<av> b(List<d.l.b.a.b.b.as> paramList, List<av> paramList1, int paramInt)
  {
    AppMethodBeat.i(60864);
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = 0;
    int i = 0;
    d.l.b.a.b.b.as localas;
    Object localObject;
    if (j < paramList.size())
    {
      localas = (d.l.b.a.b.b.as)paramList.get(j);
      av localav = (av)paramList1.get(j);
      localObject = a(localav, paramInt + 1);
      switch (2.LLL[b(localas.fRg(), localObject.gcC()).ordinal()])
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
      if ((localas.fRg() == bh.LLV) || (((av)localObject).gcB())) {
        break label124;
      }
      localObject = new ax(bh.LLV, ((av)localObject).fRV());
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
  
  private av c(av paramav)
  {
    AppMethodBeat.i(60859);
    paramav = d(paramav);
    if ((!this.Lhw.gct()) && (!this.Lhw.gbB()))
    {
      AppMethodBeat.o(60859);
      return paramav;
    }
    paramav = d.l.b.a.b.m.e.b.a(paramav, this.Lhw.gbB());
    AppMethodBeat.o(60859);
    return paramav;
  }
  
  public static ba d(ay paramay)
  {
    AppMethodBeat.i(60852);
    if (paramay == null) {
      agL(0);
    }
    paramay = new ba(paramay);
    AppMethodBeat.o(60852);
    return paramay;
  }
  
  private static String fu(Object paramObject)
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
      if (c.r(paramObject))
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
  
  private static d.l.b.a.b.b.a.g j(d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60862);
    if (paramg == null) {
      agL(23);
    }
    if (!paramg.h(d.l.b.a.b.a.g.KZg.KZT))
    {
      if (paramg == null) {
        agL(24);
      }
      AppMethodBeat.o(60862);
      return paramg;
    }
    paramg = new l(paramg, new d.g.a.b() {});
    AppMethodBeat.o(60862);
    return paramg;
  }
  
  public final ab b(ab paramab, bh parambh)
  {
    AppMethodBeat.i(60857);
    if (paramab == null) {
      agL(7);
    }
    if (parambh == null) {
      agL(8);
    }
    if (this.Lhw.isEmpty())
    {
      if (paramab == null) {
        agL(9);
      }
      AppMethodBeat.o(60857);
      return paramab;
    }
    try
    {
      paramab = a(new ax(parambh, paramab), 0).fRV();
      if (paramab == null) {
        agL(10);
      }
      AppMethodBeat.o(60857);
      return paramab;
    }
    catch (a paramab)
    {
      paramab = u.aWR(paramab.getMessage());
      if (paramab == null) {
        agL(11);
      }
      AppMethodBeat.o(60857);
    }
    return paramab;
  }
  
  public final ab c(ab paramab, bh parambh)
  {
    AppMethodBeat.i(60858);
    if (paramab == null) {
      agL(12);
    }
    if (parambh == null) {
      agL(13);
    }
    paramab = c(new ax(parambh, gcE().a(paramab, parambh)));
    if (paramab == null)
    {
      AppMethodBeat.o(60858);
      return null;
    }
    paramab = paramab.fRV();
    AppMethodBeat.o(60858);
    return paramab;
  }
  
  public final av d(av paramav)
  {
    AppMethodBeat.i(60860);
    if (paramav == null) {
      agL(15);
    }
    if (this.Lhw.isEmpty())
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
  
  public final ay gcE()
  {
    AppMethodBeat.i(60856);
    ay localay = this.Lhw;
    if (localay == null) {
      agL(6);
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
      LLM = new b("NO_CONFLICT", 0);
      LLN = new b("IN_IN_OUT_POSITION", 1);
      LLO = new b("OUT_IN_IN_POSITION", 2);
      LLP = new b[] { LLM, LLN, LLO };
      AppMethodBeat.o(60851);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.ba
 * JD-Core Version:    0.7.0.1
 */