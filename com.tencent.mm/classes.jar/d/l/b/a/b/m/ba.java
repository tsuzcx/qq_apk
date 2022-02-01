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
  public static final ba NZM;
  public final ay Nvy;
  
  static
  {
    AppMethodBeat.i(60869);
    if (!ba.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      NZM = d(ay.NZK);
      AppMethodBeat.o(60869);
      return;
    }
  }
  
  private ba(ay paramay)
  {
    AppMethodBeat.i(60855);
    this.Nvy = paramay;
    AppMethodBeat.o(60855);
  }
  
  private av a(av paramav, int paramInt)
  {
    AppMethodBeat.i(60861);
    if (paramav == null) {
      ajW(16);
    }
    a(paramInt, paramav, this.Nvy);
    if (paramav.gyE())
    {
      if (paramav == null) {
        ajW(17);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    Object localObject3 = paramav.gnW();
    Object localObject1;
    if ((localObject3 instanceof bd))
    {
      localObject1 = ((bd)localObject3).gyz();
      localObject2 = ((bd)localObject3).gyA();
      localObject1 = a(new ax(paramav.gyF(), (ab)localObject1), paramInt + 1);
      paramav = c((ab)localObject2, paramav.gyF());
      paramav = be.b(((av)localObject1).gnW().gyC(), paramav);
      paramav = new ax(((av)localObject1).gyF(), paramav);
      AppMethodBeat.o(60861);
      return paramav;
    }
    if ((s.ak((ab)localObject3)) || ((((ab)localObject3).gyC() instanceof ai)))
    {
      if (paramav == null) {
        ajW(18);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    av localav = this.Nvy.O((ab)localObject3);
    Object localObject2 = paramav.gyF();
    Object localObject4;
    if ((localav == null) && (y.am((ab)localObject3)) && (!as.au((ab)localObject3)))
    {
      localObject1 = y.an((ab)localObject3);
      localav = a(new ax((bh)localObject2, ((v)localObject1).NZc), paramInt + 1);
      localObject3 = a(new ax((bh)localObject2, ((v)localObject1).NZd), paramInt + 1);
      localObject4 = localav.gyF();
      if ((!$assertionsDisabled) && ((localObject4 != ((av)localObject3).gyF()) || (localObject2 != bh.NZW)) && (localObject2 != localObject4))
      {
        paramav = new AssertionError("Unexpected substituted projection kind: " + localObject4 + "; original: " + localObject2);
        AppMethodBeat.o(60861);
        throw paramav;
      }
      if ((localav.gnW() == ((v)localObject1).NZc) && (((av)localObject3).gnW() == ((v)localObject1).NZd))
      {
        if (paramav == null) {
          ajW(19);
        }
        AppMethodBeat.o(60861);
        return paramav;
      }
      paramav = new ax((bh)localObject4, ac.a(az.az(localav.gnW()), az.az(((av)localObject3).gnW())));
      AppMethodBeat.o(60861);
      return paramav;
    }
    if ((d.l.b.a.b.a.g.x((ab)localObject3)) || (ad.aq((ab)localObject3)))
    {
      if (paramav == null) {
        ajW(20);
      }
      AppMethodBeat.o(60861);
      return paramav;
    }
    if (localav != null)
    {
      localObject4 = b((bh)localObject2, localav.gyF());
      if (!d.ae((ab)localObject3)) {}
      switch (2.NZN[localObject4.ordinal()])
      {
      default: 
        paramav = as.av((ab)localObject3);
        if (localav.gyE())
        {
          if (localav == null) {
            ajW(21);
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
        paramav = new ax(bh.NZY, ((ab)localObject3).gxB().gnF().glG());
        AppMethodBeat.o(60861);
        return paramav;
      }
      if (paramav != null)
      {
        paramav = paramav.R(localav.gnW());
        localObject1 = paramav;
        if (!((ab)localObject3).gmj().isEmpty())
        {
          localObject1 = j(this.Nvy.h(((ab)localObject3).gmj()));
          localObject1 = a.a(paramav, new d.l.b.a.b.b.a.k(new d.l.b.a.b.b.a.g[] { paramav.gmj(), localObject1 }));
        }
        if (localObject4 != b.NZO) {
          break label755;
        }
      }
      label755:
      for (paramav = a((bh)localObject2, localav.gyF());; paramav = (av)localObject2)
      {
        paramav = new ax(paramav, (ab)localObject1);
        AppMethodBeat.o(60861);
        return paramav;
        paramav = bc.b(localav.gnW(), ((ab)localObject3).gqy());
        break;
      }
    }
    paramav = b(paramav, paramInt);
    if (paramav == null) {
      ajW(22);
    }
    AppMethodBeat.o(60861);
    return paramav;
  }
  
  public static bh a(bh parambh, av paramav)
  {
    AppMethodBeat.i(60865);
    if (parambh == null) {
      ajW(25);
    }
    if (paramav == null) {
      ajW(26);
    }
    if (paramav.gyE())
    {
      parambh = bh.NZY;
      if (parambh == null) {
        ajW(27);
      }
      AppMethodBeat.o(60865);
      return parambh;
    }
    parambh = a(parambh, paramav.gyF());
    AppMethodBeat.o(60865);
    return parambh;
  }
  
  private static bh a(bh parambh1, bh parambh2)
  {
    AppMethodBeat.i(60866);
    if (parambh1 == null) {
      ajW(28);
    }
    if (parambh2 == null) {
      ajW(29);
    }
    if (parambh1 == bh.NZW)
    {
      if (parambh2 == null) {
        ajW(30);
      }
      AppMethodBeat.o(60866);
      return parambh2;
    }
    if (parambh2 == bh.NZW)
    {
      if (parambh1 == null) {
        ajW(31);
      }
      AppMethodBeat.o(60866);
      return parambh1;
    }
    if (parambh1 == parambh2)
    {
      if (parambh2 == null) {
        ajW(32);
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
      paramav = new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + fA(paramav) + "; substitution: " + fA(paramay));
      AppMethodBeat.o(60867);
      throw paramav;
    }
    AppMethodBeat.o(60867);
  }
  
  public static ba aA(ab paramab)
  {
    AppMethodBeat.i(60854);
    if (paramab == null) {
      ajW(4);
    }
    paramab = d(au.a(paramab.gxB(), paramab.gxy()));
    AppMethodBeat.o(60854);
    return paramab;
  }
  
  private av b(av paramav, int paramInt)
  {
    AppMethodBeat.i(60863);
    Object localObject1 = paramav.gnW();
    bh localbh = paramav.gyF();
    if ((((ab)localObject1).gxB().gmq() instanceof d.l.b.a.b.b.as))
    {
      AppMethodBeat.o(60863);
      return paramav;
    }
    paramav = null;
    Object localObject2 = am.ar((ab)localObject1);
    if (localObject2 != null) {
      paramav = c((ab)localObject2, bh.NZW);
    }
    localObject2 = az.a((ab)localObject1, b(((ab)localObject1).gxB().getParameters(), ((ab)localObject1).gxy(), paramInt), this.Nvy.h(((ab)localObject1).gmj()));
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
    if ((parambh1 == bh.NZX) && (parambh2 == bh.NZY)) {
      return b.NZQ;
    }
    if ((parambh1 == bh.NZY) && (parambh2 == bh.NZX)) {
      return b.NZP;
    }
    return b.NZO;
  }
  
  public static ba b(ay paramay1, ay paramay2)
  {
    AppMethodBeat.i(60853);
    if (paramay1 == null) {
      ajW(1);
    }
    if (paramay2 == null) {
      ajW(2);
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
      switch (2.NZN[b(localas.gnh(), localObject.gyF()).ordinal()])
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
      if ((localas.gnh() == bh.NZW) || (((av)localObject).gyE())) {
        break label124;
      }
      localObject = new ax(bh.NZW, ((av)localObject).gnW());
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
    if ((!this.Nvy.gyv()) && (!this.Nvy.gxD()))
    {
      AppMethodBeat.o(60859);
      return paramav;
    }
    paramav = d.l.b.a.b.m.e.b.a(paramav, this.Nvy.gxD());
    AppMethodBeat.o(60859);
    return paramav;
  }
  
  public static ba d(ay paramay)
  {
    AppMethodBeat.i(60852);
    if (paramay == null) {
      ajW(0);
    }
    paramay = new ba(paramay);
    AppMethodBeat.o(60852);
    return paramay;
  }
  
  private static String fA(Object paramObject)
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
      if (c.t(paramObject))
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
      ajW(23);
    }
    if (!paramg.h(d.l.b.a.b.a.g.Nng.NnT))
    {
      if (paramg == null) {
        ajW(24);
      }
      AppMethodBeat.o(60862);
      return paramg;
    }
    paramg = new l(paramg, new d.g.a.b() {}, (byte)0);
    AppMethodBeat.o(60862);
    return paramg;
  }
  
  public final ab b(ab paramab, bh parambh)
  {
    AppMethodBeat.i(60857);
    if (paramab == null) {
      ajW(7);
    }
    if (parambh == null) {
      ajW(8);
    }
    if (this.Nvy.isEmpty())
    {
      if (paramab == null) {
        ajW(9);
      }
      AppMethodBeat.o(60857);
      return paramab;
    }
    try
    {
      paramab = a(new ax(parambh, paramab), 0).gnW();
      if (paramab == null) {
        ajW(10);
      }
      AppMethodBeat.o(60857);
      return paramab;
    }
    catch (a paramab)
    {
      paramab = u.bey(paramab.getMessage());
      if (paramab == null) {
        ajW(11);
      }
      AppMethodBeat.o(60857);
    }
    return paramab;
  }
  
  public final ab c(ab paramab, bh parambh)
  {
    AppMethodBeat.i(60858);
    if (paramab == null) {
      ajW(12);
    }
    if (parambh == null) {
      ajW(13);
    }
    paramab = c(new ax(parambh, gyH().a(paramab, parambh)));
    if (paramab == null)
    {
      AppMethodBeat.o(60858);
      return null;
    }
    paramab = paramab.gnW();
    AppMethodBeat.o(60858);
    return paramab;
  }
  
  public final av d(av paramav)
  {
    AppMethodBeat.i(60860);
    if (paramav == null) {
      ajW(15);
    }
    if (this.Nvy.isEmpty())
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
  
  public final ay gyH()
  {
    AppMethodBeat.i(60856);
    ay localay = this.Nvy;
    if (localay == null) {
      ajW(6);
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
      NZO = new b("NO_CONFLICT", 0);
      NZP = new b("IN_IN_OUT_POSITION", 1);
      NZQ = new b("OUT_IN_IN_POSITION", 2);
      NZR = new b[] { NZO, NZP, NZQ };
      AppMethodBeat.o(60851);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.ba
 * JD-Core Version:    0.7.0.1
 */