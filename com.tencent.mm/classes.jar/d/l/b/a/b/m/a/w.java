package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.a.g;
import d.l.b.a.b.j.d.a;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ad;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.y;
import java.util.List;

public class w
{
  private final x LMC;
  
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
    this.LMC = paramx;
  }
  
  private static ab a(d.l.b.a.b.b.as paramas, av paramav)
  {
    AppMethodBeat.i(61165);
    if (paramas == null) {
      agL(5);
    }
    if (paramav == null) {
      agL(6);
    }
    int i;
    if ((paramav.gcC() == bh.LLW) || (paramas.fRg() == bh.LLW))
    {
      i = 1;
      if (i == 0) {
        break label81;
      }
    }
    label81:
    for (paramas = a.G(paramas).fPG();; paramas = paramav.fRV())
    {
      if (paramas == null) {
        agL(7);
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
      agL(2);
    }
    if (paramab2 == null) {
      agL(3);
    }
    if (paramx == null) {
      agL(4);
    }
    paramab1 = z.a(paramab1, paramab2, paramx);
    AppMethodBeat.o(61164);
    return paramab1;
  }
  
  private boolean a(av paramav1, av paramav2, d.l.b.a.b.b.as paramas)
  {
    AppMethodBeat.i(61173);
    if (paramav1 == null) {
      agL(19);
    }
    if (paramav2 == null) {
      agL(20);
    }
    if (paramas == null) {
      agL(21);
    }
    if (paramas.fRg() != bh.LLV)
    {
      AppMethodBeat.o(61173);
      return false;
    }
    if ((paramav1.gcC() != bh.LLV) && (paramav2.gcC() == bh.LLV))
    {
      boolean bool = this.LMC.a(paramav2.fRV(), paramav1);
      AppMethodBeat.o(61173);
      return bool;
    }
    AppMethodBeat.o(61173);
    return false;
  }
  
  private static ab b(d.l.b.a.b.b.as paramas, av paramav)
  {
    AppMethodBeat.i(61166);
    if (paramas == null) {
      agL(8);
    }
    if (paramav == null) {
      agL(9);
    }
    int i;
    if ((paramav.gcC() == bh.LLX) || (paramas.fRg() == bh.LLX))
    {
      i = 1;
      if (i == 0) {
        break label82;
      }
    }
    label82:
    for (paramas = a.G(paramas).fPE();; paramas = paramav.fRV())
    {
      if (paramas == null) {
        agL(10);
      }
      AppMethodBeat.o(61166);
      return paramas;
      i = 0;
      break;
    }
  }
  
  private static a c(d.l.b.a.b.b.as paramas, av paramav)
  {
    AppMethodBeat.i(61169);
    if (paramas == null) {
      agL(13);
    }
    if (paramav == null) {
      agL(14);
    }
    paramas = paramas.fRg();
    paramav = paramav.gcC();
    if (paramav == bh.LLV) {}
    for (;;)
    {
      if ((paramav == bh.LLW) && (paramas == bh.LLX))
      {
        paramas = a.LMH;
        AppMethodBeat.o(61169);
        return paramas;
      }
      if ((paramav == bh.LLX) && (paramas == bh.LLW))
      {
        paramas = a.LMH;
        AppMethodBeat.o(61169);
        return paramas;
      }
      paramas = a.b(paramas);
      AppMethodBeat.o(61169);
      return paramas;
      d.l.b.a.b.b.as localas = paramas;
      paramas = paramav;
      paramav = localas;
    }
  }
  
  public static ab f(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61163);
    if (paramab1 == null) {
      agL(0);
    }
    if (paramab2 == null) {
      agL(1);
    }
    paramab1 = a(paramab1, paramab2, new v());
    AppMethodBeat.o(61163);
    return paramab1;
  }
  
  private boolean g(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61168);
    if ((!$assertionsDisabled) && (y.am(paramab1)))
    {
      paramab1 = new AssertionError("Only inflexible types are allowed here: ".concat(String.valueOf(paramab1)));
      AppMethodBeat.o(61168);
      throw paramab1;
    }
    if ((c(y.an(paramab2).LLa, paramab1)) && (c(paramab1, y.an(paramab2).LLb)))
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
    if ((ad.aq(paramab1)) || (ad.aq(paramab2)))
    {
      AppMethodBeat.o(61171);
      return true;
    }
    if ((!paramab2.fUx()) && (paramab1.fUx()))
    {
      AppMethodBeat.o(61171);
      return false;
    }
    if (g.y(paramab1))
    {
      AppMethodBeat.o(61171);
      return true;
    }
    ab localab = a(paramab1, paramab2, this.LMC);
    if (localab == null)
    {
      bool = this.LMC.e(paramab1, paramab2);
      AppMethodBeat.o(61171);
      return bool;
    }
    if ((!paramab2.fUx()) && (localab.fUx()))
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
      agL(17);
    }
    if (paramab2 == null) {
      agL(18);
    }
    Object localObject1 = paramab1.gbz();
    paramab1 = paramab1.gbw();
    paramab2 = paramab2.gbw();
    if (paramab1.size() != paramab2.size())
    {
      AppMethodBeat.o(61172);
      return false;
    }
    localObject1 = ((at)localObject1).getParameters();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      Object localObject2 = (d.l.b.a.b.b.as)((List)localObject1).get(i);
      av localav1 = (av)paramab2.get(i);
      av localav2 = (av)paramab1.get(i);
      if ((!localav1.gcB()) && (!a(localav2, localav1, (d.l.b.a.b.b.as)localObject2)))
      {
        if ((ad.aq(localav2.fRV())) || (ad.aq(localav1.fRV()))) {}
        for (int j = 1; (j == 0) && (((d.l.b.a.b.b.as)localObject2).fRg() == bh.LLV) && (localav2.gcC() == bh.LLV) && (localav1.gcC() == bh.LLV); j = 0)
        {
          if (this.LMC.a(localav2.fRV(), localav1.fRV(), this)) {
            break label385;
          }
          AppMethodBeat.o(61172);
          return false;
        }
        ab localab1 = a((d.l.b.a.b.b.as)localObject2, localav1);
        ab localab2 = a((d.l.b.a.b.b.as)localObject2, localav2);
        if (!this.LMC.b(localab2, localab1, this))
        {
          AppMethodBeat.o(61172);
          return false;
        }
        localab1 = b((d.l.b.a.b.b.as)localObject2, localav1);
        localObject2 = b((d.l.b.a.b.b.as)localObject2, localav2);
        if (localav1.gcC() != bh.LLX)
        {
          if (!this.LMC.b(localab1, (ab)localObject2, this))
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
        agL(15);
      }
      if (paramab2 == null) {
        agL(16);
      }
      if (d.l.b.a.b.m.as.b(paramab1, paramab2))
      {
        if ((!paramab1.fUx()) || (paramab2.fUx()))
        {
          AppMethodBeat.o(61170);
          return true;
        }
        AppMethodBeat.o(61170);
        return false;
      }
      ab localab1 = d.l.b.a.b.m.as.aw(paramab1);
      ab localab2 = d.l.b.a.b.m.as.ax(paramab2);
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
      agL(11);
    }
    if (paramab2 == null) {
      agL(12);
    }
    if (paramab1 == paramab2)
    {
      AppMethodBeat.o(61167);
      return true;
    }
    boolean bool;
    if (y.am(paramab1))
    {
      if (y.am(paramab2))
      {
        if ((!ad.aq(paramab1)) && (!ad.aq(paramab2)) && (c(paramab1, paramab2)) && (c(paramab2, paramab1)))
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
    if (y.am(paramab2))
    {
      bool = g(paramab1, paramab2);
      AppMethodBeat.o(61167);
      return bool;
    }
    if (paramab1.fUx() != paramab2.fUx())
    {
      AppMethodBeat.o(61167);
      return false;
    }
    if (paramab1.fUx())
    {
      bool = this.LMC.a(bc.aE(paramab1), bc.aE(paramab2), this);
      AppMethodBeat.o(61167);
      return bool;
    }
    at localat1 = paramab1.gbz();
    at localat2 = paramab2.gbz();
    if (!this.LMC.b(localat1, localat2))
    {
      AppMethodBeat.o(61167);
      return false;
    }
    paramab1 = paramab1.gbw();
    paramab2 = paramab2.gbw();
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
      if ((!localav1.gcB()) || (!localav2.gcB()))
      {
        d.l.b.a.b.b.as localas1 = (d.l.b.a.b.b.as)localat1.getParameters().get(i);
        d.l.b.a.b.b.as localas2 = (d.l.b.a.b.b.as)localat2.getParameters().get(i);
        if (!a(localav1, localav2, localas1))
        {
          if (c(localas1, localav1) != c(localas2, localav2))
          {
            AppMethodBeat.o(61167);
            return false;
          }
          if (!this.LMC.a(localav1.fRV(), localav2.fRV(), this))
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
      LME = new a("IN", 0);
      LMF = new a("OUT", 1);
      LMG = new a("INV", 2);
      LMH = new a("STAR", 3);
      LMI = new a[] { LME, LMF, LMG, LMH };
      AppMethodBeat.o(61161);
    }
    
    private a() {}
    
    public static a b(bh parambh)
    {
      AppMethodBeat.i(61160);
      if (parambh == null) {
        agL(0);
      }
      switch (w.1.LMD[parambh.ordinal()])
      {
      default: 
        parambh = new IllegalStateException("Unknown variance");
        AppMethodBeat.o(61160);
        throw parambh;
      case 1: 
        parambh = LMG;
        if (parambh == null) {
          agL(1);
        }
        AppMethodBeat.o(61160);
        return parambh;
      case 2: 
        parambh = LME;
        if (parambh == null) {
          agL(2);
        }
        AppMethodBeat.o(61160);
        return parambh;
      }
      parambh = LMF;
      if (parambh == null) {
        agL(3);
      }
      AppMethodBeat.o(61160);
      return parambh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.a.w
 * JD-Core Version:    0.7.0.1
 */