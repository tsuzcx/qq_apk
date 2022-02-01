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
  private final x NDx;
  
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
    this.NDx = paramx;
  }
  
  private static ab a(d.l.b.a.b.b.as paramas, av paramav)
  {
    AppMethodBeat.i(61165);
    if (paramas == null) {
      ajm(5);
    }
    if (paramav == null) {
      ajm(6);
    }
    int i;
    if ((paramav.gud() == bh.NCQ) || (paramas.giF() == bh.NCQ))
    {
      i = 1;
      if (i == 0) {
        break label81;
      }
    }
    label81:
    for (paramas = a.G(paramas).ghe();; paramas = paramav.gju())
    {
      if (paramas == null) {
        ajm(7);
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
      ajm(2);
    }
    if (paramab2 == null) {
      ajm(3);
    }
    if (paramx == null) {
      ajm(4);
    }
    paramab1 = z.a(paramab1, paramab2, paramx);
    AppMethodBeat.o(61164);
    return paramab1;
  }
  
  private boolean a(av paramav1, av paramav2, d.l.b.a.b.b.as paramas)
  {
    AppMethodBeat.i(61173);
    if (paramav1 == null) {
      ajm(19);
    }
    if (paramav2 == null) {
      ajm(20);
    }
    if (paramas == null) {
      ajm(21);
    }
    if (paramas.giF() != bh.NCP)
    {
      AppMethodBeat.o(61173);
      return false;
    }
    if ((paramav1.gud() != bh.NCP) && (paramav2.gud() == bh.NCP))
    {
      boolean bool = this.NDx.a(paramav2.gju(), paramav1);
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
      ajm(8);
    }
    if (paramav == null) {
      ajm(9);
    }
    int i;
    if ((paramav.gud() == bh.NCR) || (paramas.giF() == bh.NCR))
    {
      i = 1;
      if (i == 0) {
        break label82;
      }
    }
    label82:
    for (paramas = a.G(paramas).ghc();; paramas = paramav.gju())
    {
      if (paramas == null) {
        ajm(10);
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
      ajm(13);
    }
    if (paramav == null) {
      ajm(14);
    }
    paramas = paramas.giF();
    paramav = paramav.gud();
    if (paramav == bh.NCP) {}
    for (;;)
    {
      if ((paramav == bh.NCQ) && (paramas == bh.NCR))
      {
        paramas = a.NDC;
        AppMethodBeat.o(61169);
        return paramas;
      }
      if ((paramav == bh.NCR) && (paramas == bh.NCQ))
      {
        paramas = a.NDC;
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
      ajm(0);
    }
    if (paramab2 == null) {
      ajm(1);
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
    if ((c(y.an(paramab2).NBV, paramab1)) && (c(paramab1, y.an(paramab2).NBW)))
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
    if ((!paramab2.glW()) && (paramab1.glW()))
    {
      AppMethodBeat.o(61171);
      return false;
    }
    if (g.y(paramab1))
    {
      AppMethodBeat.o(61171);
      return true;
    }
    ab localab = a(paramab1, paramab2, this.NDx);
    if (localab == null)
    {
      bool = this.NDx.e(paramab1, paramab2);
      AppMethodBeat.o(61171);
      return bool;
    }
    if ((!paramab2.glW()) && (localab.glW()))
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
      ajm(17);
    }
    if (paramab2 == null) {
      ajm(18);
    }
    Object localObject1 = paramab1.gsZ();
    paramab1 = paramab1.gsW();
    paramab2 = paramab2.gsW();
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
      if ((!localav1.guc()) && (!a(localav2, localav1, (d.l.b.a.b.b.as)localObject2)))
      {
        if ((ad.aq(localav2.gju())) || (ad.aq(localav1.gju()))) {}
        for (int j = 1; (j == 0) && (((d.l.b.a.b.b.as)localObject2).giF() == bh.NCP) && (localav2.gud() == bh.NCP) && (localav1.gud() == bh.NCP); j = 0)
        {
          if (this.NDx.a(localav2.gju(), localav1.gju(), this)) {
            break label385;
          }
          AppMethodBeat.o(61172);
          return false;
        }
        ab localab1 = a((d.l.b.a.b.b.as)localObject2, localav1);
        ab localab2 = a((d.l.b.a.b.b.as)localObject2, localav2);
        if (!this.NDx.b(localab2, localab1, this))
        {
          AppMethodBeat.o(61172);
          return false;
        }
        localab1 = b((d.l.b.a.b.b.as)localObject2, localav1);
        localObject2 = b((d.l.b.a.b.b.as)localObject2, localav2);
        if (localav1.gud() != bh.NCR)
        {
          if (!this.NDx.b(localab1, (ab)localObject2, this))
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
        ajm(15);
      }
      if (paramab2 == null) {
        ajm(16);
      }
      if (d.l.b.a.b.m.as.b(paramab1, paramab2))
      {
        if ((!paramab1.glW()) || (paramab2.glW()))
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
      ajm(11);
    }
    if (paramab2 == null) {
      ajm(12);
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
    if (paramab1.glW() != paramab2.glW())
    {
      AppMethodBeat.o(61167);
      return false;
    }
    if (paramab1.glW())
    {
      bool = this.NDx.a(bc.aE(paramab1), bc.aE(paramab2), this);
      AppMethodBeat.o(61167);
      return bool;
    }
    at localat1 = paramab1.gsZ();
    at localat2 = paramab2.gsZ();
    if (!this.NDx.b(localat1, localat2))
    {
      AppMethodBeat.o(61167);
      return false;
    }
    paramab1 = paramab1.gsW();
    paramab2 = paramab2.gsW();
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
      if ((!localav1.guc()) || (!localav2.guc()))
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
          if (!this.NDx.a(localav1.gju(), localav2.gju(), this))
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
      NDz = new a("IN", 0);
      NDA = new a("OUT", 1);
      NDB = new a("INV", 2);
      NDC = new a("STAR", 3);
      NDD = new a[] { NDz, NDA, NDB, NDC };
      AppMethodBeat.o(61161);
    }
    
    private a() {}
    
    public static a b(bh parambh)
    {
      AppMethodBeat.i(61160);
      if (parambh == null) {
        ajm(0);
      }
      switch (w.1.NDy[parambh.ordinal()])
      {
      default: 
        parambh = new IllegalStateException("Unknown variance");
        AppMethodBeat.o(61160);
        throw parambh;
      case 1: 
        parambh = NDB;
        if (parambh == null) {
          ajm(1);
        }
        AppMethodBeat.o(61160);
        return parambh;
      case 2: 
        parambh = NDz;
        if (parambh == null) {
          ajm(2);
        }
        AppMethodBeat.o(61160);
        return parambh;
      }
      parambh = NDA;
      if (parambh == null) {
        ajm(3);
      }
      AppMethodBeat.o(61160);
      return parambh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.a.w
 * JD-Core Version:    0.7.0.1
 */