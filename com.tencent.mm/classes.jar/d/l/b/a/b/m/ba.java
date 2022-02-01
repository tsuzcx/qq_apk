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
  public static final ba JYr;
  public final ay Jud;
  
  static
  {
    AppMethodBeat.i(60869);
    if (!ba.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      JYr = d(ay.JYp);
      AppMethodBeat.o(60869);
      return;
    }
  }
  
  private ba(ay paramay)
  {
    AppMethodBeat.i(60855);
    this.Jud = paramay;
    AppMethodBeat.o(60855);
  }
  
  private av a(av paramav, int paramInt)
  {
    AppMethodBeat.i(60861);
    if (paramav == null) {
      adP(16);
    }
    a(paramInt, paramav, this.Jud);
    if (paramav.fJY())
    {
      if (paramav == null) {
        adP(17);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    Object localObject3 = paramav.fzr();
    Object localObject1;
    if ((localObject3 instanceof bd))
    {
      localObject1 = ((bd)localObject3).fJT();
      localObject2 = ((bd)localObject3).fJU();
      localObject1 = a(new ax(paramav.fJZ(), (ab)localObject1), paramInt + 1);
      paramav = c((ab)localObject2, paramav.fJZ());
      paramav = be.b(((av)localObject1).fzr().fJW(), paramav);
      paramav = new ax(((av)localObject1).fJZ(), paramav);
      AppMethodBeat.o(60861);
      return paramav;
    }
    if ((s.ak((ab)localObject3)) || ((((ab)localObject3).fJW() instanceof ai)))
    {
      if (paramav == null) {
        adP(18);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    av localav = this.Jud.O((ab)localObject3);
    Object localObject2 = paramav.fJZ();
    Object localObject4;
    if ((localav == null) && (y.am((ab)localObject3)) && (!as.au((ab)localObject3)))
    {
      localObject1 = y.an((ab)localObject3);
      localav = a(new ax((bh)localObject2, ((v)localObject1).JXH), paramInt + 1);
      localObject3 = a(new ax((bh)localObject2, ((v)localObject1).JXI), paramInt + 1);
      localObject4 = localav.fJZ();
      if ((!$assertionsDisabled) && ((localObject4 != ((av)localObject3).fJZ()) || (localObject2 != bh.JYC)) && (localObject2 != localObject4))
      {
        paramav = new AssertionError("Unexpected substituted projection kind: " + localObject4 + "; original: " + localObject2);
        AppMethodBeat.o(60861);
        throw paramav;
      }
      if ((localav.fzr() == ((v)localObject1).JXH) && (((av)localObject3).fzr() == ((v)localObject1).JXI))
      {
        if (paramav == null) {
          adP(19);
        }
        AppMethodBeat.o(60861);
        return paramav;
      }
      paramav = new ax((bh)localObject4, ac.a(az.az(localav.fzr()), az.az(((av)localObject3).fzr())));
      AppMethodBeat.o(60861);
      return paramav;
    }
    if ((d.l.b.a.b.a.g.x((ab)localObject3)) || (ad.aq((ab)localObject3)))
    {
      if (paramav == null) {
        adP(20);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    if (localav != null)
    {
      localObject4 = b((bh)localObject2, localav.fJZ());
      if (!d.ae((ab)localObject3)) {}
      switch (2.JYs[localObject4.ordinal()])
      {
      default: 
        paramav = as.av((ab)localObject3);
        if (localav.fJY())
        {
          if (localav == null) {
            adP(21);
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
        paramav = new ax(bh.JYE, ((ab)localObject3).fIW().fza().fxc());
        AppMethodBeat.o(60861);
        return paramav;
      }
      if (paramav != null)
      {
        paramav = paramav.R(localav.fzr());
        localObject1 = paramav;
        if (!((ab)localObject3).fxF().isEmpty())
        {
          localObject1 = j(this.Jud.h(((ab)localObject3).fxF()));
          localObject1 = a.a(paramav, new d.l.b.a.b.b.a.k(new d.l.b.a.b.b.a.g[] { paramav.fxF(), localObject1 }));
        }
        if (localObject4 != b.JYt) {
          break label755;
        }
      }
      label755:
      for (paramav = a((bh)localObject2, localav.fJZ());; paramav = (av)localObject2)
      {
        paramav = new ax(paramav, (ab)localObject1);
        AppMethodBeat.o(60861);
        return paramav;
        paramav = bc.b(localav.fzr(), ((ab)localObject3).fBT());
        break;
      }
    }
    paramav = b(paramav, paramInt);
    if (paramav == null) {
      adP(22);
    }
    AppMethodBeat.o(60861);
    return paramav;
  }
  
  public static bh a(bh parambh, av paramav)
  {
    AppMethodBeat.i(60865);
    if (parambh == null) {
      adP(25);
    }
    if (paramav == null) {
      adP(26);
    }
    if (paramav.fJY())
    {
      parambh = bh.JYE;
      if (parambh == null) {
        adP(27);
      }
      AppMethodBeat.o(60865);
      return parambh;
    }
    parambh = a(parambh, paramav.fJZ());
    AppMethodBeat.o(60865);
    return parambh;
  }
  
  private static bh a(bh parambh1, bh parambh2)
  {
    AppMethodBeat.i(60866);
    if (parambh1 == null) {
      adP(28);
    }
    if (parambh2 == null) {
      adP(29);
    }
    if (parambh1 == bh.JYC)
    {
      if (parambh2 == null) {
        adP(30);
      }
      AppMethodBeat.o(60866);
      return parambh2;
    }
    if (parambh2 == bh.JYC)
    {
      if (parambh1 == null) {
        adP(31);
      }
      AppMethodBeat.o(60866);
      return parambh1;
    }
    if (parambh1 == parambh2)
    {
      if (parambh2 == null) {
        adP(32);
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
      paramav = new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + fr(paramav) + "; substitution: " + fr(paramay));
      AppMethodBeat.o(60867);
      throw paramav;
    }
    AppMethodBeat.o(60867);
  }
  
  public static ba aA(ab paramab)
  {
    AppMethodBeat.i(60854);
    if (paramab == null) {
      adP(4);
    }
    paramab = d(au.a(paramab.fIW(), paramab.fIT()));
    AppMethodBeat.o(60854);
    return paramab;
  }
  
  private av b(av paramav, int paramInt)
  {
    AppMethodBeat.i(60863);
    Object localObject1 = paramav.fzr();
    bh localbh = paramav.fJZ();
    if ((((ab)localObject1).fIW().fxM() instanceof d.l.b.a.b.b.as))
    {
      AppMethodBeat.o(60863);
      return paramav;
    }
    paramav = null;
    Object localObject2 = am.ar((ab)localObject1);
    if (localObject2 != null) {
      paramav = c((ab)localObject2, bh.JYC);
    }
    localObject2 = az.a((ab)localObject1, b(((ab)localObject1).fIW().getParameters(), ((ab)localObject1).fIT(), paramInt), this.Jud.h(((ab)localObject1).fxF()));
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
    if ((parambh1 == bh.JYD) && (parambh2 == bh.JYE)) {
      return b.JYv;
    }
    if ((parambh1 == bh.JYE) && (parambh2 == bh.JYD)) {
      return b.JYu;
    }
    return b.JYt;
  }
  
  public static ba b(ay paramay1, ay paramay2)
  {
    AppMethodBeat.i(60853);
    if (paramay1 == null) {
      adP(1);
    }
    if (paramay2 == null) {
      adP(2);
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
      switch (2.JYs[b(localas.fyC(), localObject.fJZ()).ordinal()])
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
      if ((localas.fyC() == bh.JYC) || (((av)localObject).fJY())) {
        break label124;
      }
      localObject = new ax(bh.JYC, ((av)localObject).fzr());
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
    if ((!this.Jud.fJQ()) && (!this.Jud.fIY()))
    {
      AppMethodBeat.o(60859);
      return paramav;
    }
    paramav = d.l.b.a.b.m.e.b.a(paramav, this.Jud.fIY());
    AppMethodBeat.o(60859);
    return paramav;
  }
  
  public static ba d(ay paramay)
  {
    AppMethodBeat.i(60852);
    if (paramay == null) {
      adP(0);
    }
    paramay = new ba(paramay);
    AppMethodBeat.o(60852);
    return paramay;
  }
  
  private static String fr(Object paramObject)
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
      adP(23);
    }
    if (!paramg.h(d.l.b.a.b.a.g.JlM.Jmz))
    {
      if (paramg == null) {
        adP(24);
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
      adP(7);
    }
    if (parambh == null) {
      adP(8);
    }
    if (this.Jud.isEmpty())
    {
      if (paramab == null) {
        adP(9);
      }
      AppMethodBeat.o(60857);
      return paramab;
    }
    try
    {
      paramab = a(new ax(parambh, paramab), 0).fzr();
      if (paramab == null) {
        adP(10);
      }
      AppMethodBeat.o(60857);
      return paramab;
    }
    catch (a paramab)
    {
      paramab = u.aQS(paramab.getMessage());
      if (paramab == null) {
        adP(11);
      }
      AppMethodBeat.o(60857);
    }
    return paramab;
  }
  
  public final ab c(ab paramab, bh parambh)
  {
    AppMethodBeat.i(60858);
    if (paramab == null) {
      adP(12);
    }
    if (parambh == null) {
      adP(13);
    }
    paramab = c(new ax(parambh, fKb().a(paramab, parambh)));
    if (paramab == null)
    {
      AppMethodBeat.o(60858);
      return null;
    }
    paramab = paramab.fzr();
    AppMethodBeat.o(60858);
    return paramab;
  }
  
  public final av d(av paramav)
  {
    AppMethodBeat.i(60860);
    if (paramav == null) {
      adP(15);
    }
    if (this.Jud.isEmpty())
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
  
  public final ay fKb()
  {
    AppMethodBeat.i(60856);
    ay localay = this.Jud;
    if (localay == null) {
      adP(6);
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
      JYt = new b("NO_CONFLICT", 0);
      JYu = new b("IN_IN_OUT_POSITION", 1);
      JYv = new b("OUT_IN_IN_POSITION", 2);
      JYw = new b[] { JYt, JYu, JYv };
      AppMethodBeat.o(60851);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.ba
 * JD-Core Version:    0.7.0.1
 */