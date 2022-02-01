package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.y;

public class w
{
  private final x abrX;
  
  static
  {
    AppMethodBeat.i(61174);
    if (!w.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(61174);
      return;
    }
  }
  
  public w(x paramx)
  {
    this.abrX = paramx;
  }
  
  private static ab a(kotlin.l.b.a.b.b.as paramas, av paramav)
  {
    AppMethodBeat.i(61165);
    if (paramas == null) {
      aDG(5);
    }
    if (paramav == null) {
      aDG(6);
    }
    int i;
    if ((paramav.iQa() == bh.abrq) || (paramas.iEW() == bh.abrq))
    {
      i = 1;
      if (i == 0) {
        break label81;
      }
    }
    label81:
    for (paramas = a.G(paramas).iDv();; paramas = paramav.iFN())
    {
      if (paramas == null) {
        aDG(7);
      }
      AppMethodBeat.o(61165);
      return paramas;
      i = 0;
      break;
    }
  }
  
  private static ab a(ab paramab1, ab paramab2, x paramx)
  {
    AppMethodBeat.i(61164);
    if (paramab1 == null) {
      aDG(2);
    }
    if (paramab2 == null) {
      aDG(3);
    }
    if (paramx == null) {
      aDG(4);
    }
    paramab1 = z.a(paramab1, paramab2, paramx);
    AppMethodBeat.o(61164);
    return paramab1;
  }
  
  private boolean a(av paramav1, av paramav2, kotlin.l.b.a.b.b.as paramas)
  {
    AppMethodBeat.i(61173);
    if (paramav1 == null) {
      aDG(19);
    }
    if (paramav2 == null) {
      aDG(20);
    }
    if (paramas == null) {
      aDG(21);
    }
    if (paramas.iEW() != bh.abrp)
    {
      AppMethodBeat.o(61173);
      return false;
    }
    if ((paramav1.iQa() != bh.abrp) && (paramav2.iQa() == bh.abrp))
    {
      boolean bool = this.abrX.a(paramav2.iFN(), paramav1);
      AppMethodBeat.o(61173);
      return bool;
    }
    AppMethodBeat.o(61173);
    return false;
  }
  
  private static ab b(kotlin.l.b.a.b.b.as paramas, av paramav)
  {
    AppMethodBeat.i(61166);
    if (paramas == null) {
      aDG(8);
    }
    if (paramav == null) {
      aDG(9);
    }
    int i;
    if ((paramav.iQa() == bh.abrr) || (paramas.iEW() == bh.abrr))
    {
      i = 1;
      if (i == 0) {
        break label82;
      }
    }
    label82:
    for (paramas = a.G(paramas).iDt();; paramas = paramav.iFN())
    {
      if (paramas == null) {
        aDG(10);
      }
      AppMethodBeat.o(61166);
      return paramas;
      i = 0;
      break;
    }
  }
  
  private static a c(kotlin.l.b.a.b.b.as paramas, av paramav)
  {
    AppMethodBeat.i(61169);
    if (paramas == null) {
      aDG(13);
    }
    if (paramav == null) {
      aDG(14);
    }
    paramas = paramas.iEW();
    paramav = paramav.iQa();
    if (paramav == bh.abrp) {}
    for (;;)
    {
      if ((paramav == bh.abrq) && (paramas == bh.abrr))
      {
        paramas = a.absc;
        AppMethodBeat.o(61169);
        return paramas;
      }
      if ((paramav == bh.abrr) && (paramas == bh.abrq))
      {
        paramas = a.absc;
        AppMethodBeat.o(61169);
        return paramas;
      }
      paramas = a.b(paramas);
      AppMethodBeat.o(61169);
      return paramas;
      kotlin.l.b.a.b.b.as localas = paramas;
      paramas = paramav;
      paramav = localas;
    }
  }
  
  public static ab f(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61163);
    if (paramab1 == null) {
      aDG(0);
    }
    if (paramab2 == null) {
      aDG(1);
    }
    paramab1 = a(paramab1, paramab2, new v());
    AppMethodBeat.o(61163);
    return paramab1;
  }
  
  private boolean g(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61168);
    if ((!$assertionsDisabled) && (y.al(paramab1)))
    {
      paramab1 = new AssertionError("Only inflexible types are allowed here: ".concat(String.valueOf(paramab1)));
      AppMethodBeat.o(61168);
      throw paramab1;
    }
    if ((c(y.am(paramab2).abqv, paramab1)) && (c(paramab1, y.am(paramab2).abqw)))
    {
      AppMethodBeat.o(61168);
      return true;
    }
    AppMethodBeat.o(61168);
    return false;
  }
  
  private boolean h(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61171);
    if ((ad.ap(paramab1)) || (ad.ap(paramab2)))
    {
      AppMethodBeat.o(61171);
      return true;
    }
    if ((!paramab2.iIu()) && (paramab1.iIu()))
    {
      AppMethodBeat.o(61171);
      return false;
    }
    if (g.y(paramab1))
    {
      AppMethodBeat.o(61171);
      return true;
    }
    ab localab = a(paramab1, paramab2, this.abrX);
    if (localab == null)
    {
      bool = this.abrX.e(paramab1, paramab2);
      AppMethodBeat.o(61171);
      return bool;
    }
    if ((!paramab2.iIu()) && (localab.iIu()))
    {
      AppMethodBeat.o(61171);
      return false;
    }
    boolean bool = i(localab, paramab2);
    AppMethodBeat.o(61171);
    return bool;
  }
  
  private boolean i(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61172);
    if (paramab1 == null) {
      aDG(17);
    }
    if (paramab2 == null) {
      aDG(18);
    }
    Object localObject1 = paramab1.iOU();
    paramab1 = paramab1.iOR();
    paramab2 = paramab2.iOR();
    if (paramab1.size() != paramab2.size())
    {
      AppMethodBeat.o(61172);
      return false;
    }
    localObject1 = ((at)localObject1).iCb();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      Object localObject2 = (kotlin.l.b.a.b.b.as)((List)localObject1).get(i);
      av localav1 = (av)paramab2.get(i);
      av localav2 = (av)paramab1.get(i);
      if ((!localav1.iPZ()) && (!a(localav2, localav1, (kotlin.l.b.a.b.b.as)localObject2)))
      {
        if ((ad.ap(localav2.iFN())) || (ad.ap(localav1.iFN()))) {}
        for (int j = 1; (j == 0) && (((kotlin.l.b.a.b.b.as)localObject2).iEW() == bh.abrp) && (localav2.iQa() == bh.abrp) && (localav1.iQa() == bh.abrp); j = 0)
        {
          if (this.abrX.a(localav2.iFN(), localav1.iFN(), this)) {
            break label385;
          }
          AppMethodBeat.o(61172);
          return false;
        }
        ab localab1 = a((kotlin.l.b.a.b.b.as)localObject2, localav1);
        ab localab2 = a((kotlin.l.b.a.b.b.as)localObject2, localav2);
        if (!this.abrX.b(localab2, localab1, this))
        {
          AppMethodBeat.o(61172);
          return false;
        }
        localab1 = b((kotlin.l.b.a.b.b.as)localObject2, localav1);
        localObject2 = b((kotlin.l.b.a.b.b.as)localObject2, localav2);
        if (localav1.iQa() != bh.abrr)
        {
          if (!this.abrX.b(localab1, (ab)localObject2, this))
          {
            AppMethodBeat.o(61172);
            return false;
          }
        }
        else if ((!$assertionsDisabled) && (!g.x(localab1)))
        {
          paramab1 = new AssertionError("In component must be Nothing for out-projection");
          AppMethodBeat.o(61172);
          throw paramab1;
        }
      }
      label385:
      i += 1;
    }
    AppMethodBeat.o(61172);
    return true;
  }
  
  public final boolean c(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61170);
    for (;;)
    {
      if (paramab1 == null) {
        aDG(15);
      }
      if (paramab2 == null) {
        aDG(16);
      }
      if (kotlin.l.b.a.b.m.as.b(paramab1, paramab2))
      {
        if ((!paramab1.iIu()) || (paramab2.iIu()))
        {
          AppMethodBeat.o(61170);
          return true;
        }
        AppMethodBeat.o(61170);
        return false;
      }
      ab localab1 = kotlin.l.b.a.b.m.as.av(paramab1);
      ab localab2 = kotlin.l.b.a.b.m.as.aw(paramab2);
      if ((localab1 == paramab1) && (localab2 == paramab2)) {
        break;
      }
      paramab2 = localab2;
      paramab1 = localab1;
    }
    boolean bool = h(paramab1, paramab2);
    AppMethodBeat.o(61170);
    return bool;
  }
  
  public final boolean d(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61167);
    if (paramab1 == null) {
      aDG(11);
    }
    if (paramab2 == null) {
      aDG(12);
    }
    if (paramab1 == paramab2)
    {
      AppMethodBeat.o(61167);
      return true;
    }
    boolean bool;
    if (y.al(paramab1))
    {
      if (y.al(paramab2))
      {
        if ((!ad.ap(paramab1)) && (!ad.ap(paramab2)) && (c(paramab1, paramab2)) && (c(paramab2, paramab1)))
        {
          AppMethodBeat.o(61167);
          return true;
        }
        AppMethodBeat.o(61167);
        return false;
      }
      bool = g(paramab2, paramab1);
      AppMethodBeat.o(61167);
      return bool;
    }
    if (y.al(paramab2))
    {
      bool = g(paramab1, paramab2);
      AppMethodBeat.o(61167);
      return bool;
    }
    if (paramab1.iIu() != paramab2.iIu())
    {
      AppMethodBeat.o(61167);
      return false;
    }
    if (paramab1.iIu())
    {
      bool = this.abrX.a(bc.aD(paramab1), bc.aD(paramab2), this);
      AppMethodBeat.o(61167);
      return bool;
    }
    at localat1 = paramab1.iOU();
    at localat2 = paramab2.iOU();
    if (!this.abrX.b(localat1, localat2))
    {
      AppMethodBeat.o(61167);
      return false;
    }
    paramab1 = paramab1.iOR();
    paramab2 = paramab2.iOR();
    if (paramab1.size() != paramab2.size())
    {
      AppMethodBeat.o(61167);
      return false;
    }
    int i = 0;
    while (i < paramab1.size())
    {
      av localav1 = (av)paramab1.get(i);
      av localav2 = (av)paramab2.get(i);
      if ((!localav1.iPZ()) || (!localav2.iPZ()))
      {
        kotlin.l.b.a.b.b.as localas1 = (kotlin.l.b.a.b.b.as)localat1.iCb().get(i);
        kotlin.l.b.a.b.b.as localas2 = (kotlin.l.b.a.b.b.as)localat2.iCb().get(i);
        if (!a(localav1, localav2, localas1))
        {
          if (c(localas1, localav1) != c(localas2, localav2))
          {
            AppMethodBeat.o(61167);
            return false;
          }
          if (!this.abrX.a(localav1.iFN(), localav2.iFN(), this))
          {
            AppMethodBeat.o(61167);
            return false;
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(61167);
    return true;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(61161);
      abrZ = new a("IN", 0);
      absa = new a("OUT", 1);
      absb = new a("INV", 2);
      absc = new a("STAR", 3);
      absd = new a[] { abrZ, absa, absb, absc };
      AppMethodBeat.o(61161);
    }
    
    private a() {}
    
    public static a b(bh parambh)
    {
      AppMethodBeat.i(61160);
      if (parambh == null) {
        aDG(0);
      }
      switch (w.1.abrY[parambh.ordinal()])
      {
      default: 
        parambh = new IllegalStateException("Unknown variance");
        AppMethodBeat.o(61160);
        throw parambh;
      case 1: 
        parambh = absb;
        if (parambh == null) {
          aDG(1);
        }
        AppMethodBeat.o(61160);
        return parambh;
      case 2: 
        parambh = abrZ;
        if (parambh == null) {
          aDG(2);
        }
        AppMethodBeat.o(61160);
        return parambh;
      }
      parambh = absa;
      if (parambh == null) {
        aDG(3);
      }
      AppMethodBeat.o(61160);
      return parambh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.w
 * JD-Core Version:    0.7.0.1
 */