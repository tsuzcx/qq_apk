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
  private final x TPy;
  
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
    this.TPy = paramx;
  }
  
  private static ab a(kotlin.l.b.a.b.b.as paramas, av paramav)
  {
    AppMethodBeat.i(61165);
    if (paramas == null) {
      atM(5);
    }
    if (paramav == null) {
      atM(6);
    }
    int i;
    if ((paramav.hLI() == bh.TOR) || (paramas.hAJ() == bh.TOR))
    {
      i = 1;
      if (i == 0) {
        break label81;
      }
    }
    label81:
    for (paramas = a.G(paramas).hzj();; paramas = paramav.hBy())
    {
      if (paramas == null) {
        atM(7);
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
      atM(2);
    }
    if (paramab2 == null) {
      atM(3);
    }
    if (paramx == null) {
      atM(4);
    }
    paramab1 = z.a(paramab1, paramab2, paramx);
    AppMethodBeat.o(61164);
    return paramab1;
  }
  
  private boolean a(av paramav1, av paramav2, kotlin.l.b.a.b.b.as paramas)
  {
    AppMethodBeat.i(61173);
    if (paramav1 == null) {
      atM(19);
    }
    if (paramav2 == null) {
      atM(20);
    }
    if (paramas == null) {
      atM(21);
    }
    if (paramas.hAJ() != bh.TOQ)
    {
      AppMethodBeat.o(61173);
      return false;
    }
    if ((paramav1.hLI() != bh.TOQ) && (paramav2.hLI() == bh.TOQ))
    {
      boolean bool = this.TPy.a(paramav2.hBy(), paramav1);
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
      atM(8);
    }
    if (paramav == null) {
      atM(9);
    }
    int i;
    if ((paramav.hLI() == bh.TOS) || (paramas.hAJ() == bh.TOS))
    {
      i = 1;
      if (i == 0) {
        break label82;
      }
    }
    label82:
    for (paramas = a.G(paramas).hzh();; paramas = paramav.hBy())
    {
      if (paramas == null) {
        atM(10);
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
      atM(13);
    }
    if (paramav == null) {
      atM(14);
    }
    paramas = paramas.hAJ();
    paramav = paramav.hLI();
    if (paramav == bh.TOQ) {}
    for (;;)
    {
      if ((paramav == bh.TOR) && (paramas == bh.TOS))
      {
        paramas = a.TPD;
        AppMethodBeat.o(61169);
        return paramas;
      }
      if ((paramav == bh.TOS) && (paramas == bh.TOR))
      {
        paramas = a.TPD;
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
      atM(0);
    }
    if (paramab2 == null) {
      atM(1);
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
    if ((c(y.am(paramab2).TNV, paramab1)) && (c(paramab1, y.am(paramab2).TNW)))
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
    if ((!paramab2.hEa()) && (paramab1.hEa()))
    {
      AppMethodBeat.o(61171);
      return false;
    }
    if (g.y(paramab1))
    {
      AppMethodBeat.o(61171);
      return true;
    }
    ab localab = a(paramab1, paramab2, this.TPy);
    if (localab == null)
    {
      bool = this.TPy.e(paramab1, paramab2);
      AppMethodBeat.o(61171);
      return bool;
    }
    if ((!paramab2.hEa()) && (localab.hEa()))
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
      atM(17);
    }
    if (paramab2 == null) {
      atM(18);
    }
    Object localObject1 = paramab1.hKE();
    paramab1 = paramab1.hKB();
    paramab2 = paramab2.hKB();
    if (paramab1.size() != paramab2.size())
    {
      AppMethodBeat.o(61172);
      return false;
    }
    localObject1 = ((at)localObject1).getParameters();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      Object localObject2 = (kotlin.l.b.a.b.b.as)((List)localObject1).get(i);
      av localav1 = (av)paramab2.get(i);
      av localav2 = (av)paramab1.get(i);
      if ((!localav1.hLH()) && (!a(localav2, localav1, (kotlin.l.b.a.b.b.as)localObject2)))
      {
        if ((ad.ap(localav2.hBy())) || (ad.ap(localav1.hBy()))) {}
        for (int j = 1; (j == 0) && (((kotlin.l.b.a.b.b.as)localObject2).hAJ() == bh.TOQ) && (localav2.hLI() == bh.TOQ) && (localav1.hLI() == bh.TOQ); j = 0)
        {
          if (this.TPy.a(localav2.hBy(), localav1.hBy(), this)) {
            break label385;
          }
          AppMethodBeat.o(61172);
          return false;
        }
        ab localab1 = a((kotlin.l.b.a.b.b.as)localObject2, localav1);
        ab localab2 = a((kotlin.l.b.a.b.b.as)localObject2, localav2);
        if (!this.TPy.b(localab2, localab1, this))
        {
          AppMethodBeat.o(61172);
          return false;
        }
        localab1 = b((kotlin.l.b.a.b.b.as)localObject2, localav1);
        localObject2 = b((kotlin.l.b.a.b.b.as)localObject2, localav2);
        if (localav1.hLI() != bh.TOS)
        {
          if (!this.TPy.b(localab1, (ab)localObject2, this))
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
        atM(15);
      }
      if (paramab2 == null) {
        atM(16);
      }
      if (kotlin.l.b.a.b.m.as.b(paramab1, paramab2))
      {
        if ((!paramab1.hEa()) || (paramab2.hEa()))
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
      atM(11);
    }
    if (paramab2 == null) {
      atM(12);
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
    if (paramab1.hEa() != paramab2.hEa())
    {
      AppMethodBeat.o(61167);
      return false;
    }
    if (paramab1.hEa())
    {
      bool = this.TPy.a(bc.aD(paramab1), bc.aD(paramab2), this);
      AppMethodBeat.o(61167);
      return bool;
    }
    at localat1 = paramab1.hKE();
    at localat2 = paramab2.hKE();
    if (!this.TPy.b(localat1, localat2))
    {
      AppMethodBeat.o(61167);
      return false;
    }
    paramab1 = paramab1.hKB();
    paramab2 = paramab2.hKB();
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
      if ((!localav1.hLH()) || (!localav2.hLH()))
      {
        kotlin.l.b.a.b.b.as localas1 = (kotlin.l.b.a.b.b.as)localat1.getParameters().get(i);
        kotlin.l.b.a.b.b.as localas2 = (kotlin.l.b.a.b.b.as)localat2.getParameters().get(i);
        if (!a(localav1, localav2, localas1))
        {
          if (c(localas1, localav1) != c(localas2, localav2))
          {
            AppMethodBeat.o(61167);
            return false;
          }
          if (!this.TPy.a(localav1.hBy(), localav2.hBy(), this))
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
      TPA = new a("IN", 0);
      TPB = new a("OUT", 1);
      TPC = new a("INV", 2);
      TPD = new a("STAR", 3);
      TPE = new a[] { TPA, TPB, TPC, TPD };
      AppMethodBeat.o(61161);
    }
    
    private a() {}
    
    public static a b(bh parambh)
    {
      AppMethodBeat.i(61160);
      if (parambh == null) {
        atM(0);
      }
      switch (w.1.TPz[parambh.ordinal()])
      {
      default: 
        parambh = new IllegalStateException("Unknown variance");
        AppMethodBeat.o(61160);
        throw parambh;
      case 1: 
        parambh = TPC;
        if (parambh == null) {
          atM(1);
        }
        AppMethodBeat.o(61160);
        return parambh;
      case 2: 
        parambh = TPA;
        if (parambh == null) {
          atM(2);
        }
        AppMethodBeat.o(61160);
        return parambh;
      }
      parambh = TPB;
      if (parambh == null) {
        atM(3);
      }
      AppMethodBeat.o(61160);
      return parambh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.w
 * JD-Core Version:    0.7.0.1
 */