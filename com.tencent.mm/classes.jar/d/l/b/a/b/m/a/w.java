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
  private final x JZj;
  
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
    this.JZj = paramx;
  }
  
  private static ab a(d.l.b.a.b.b.as paramas, av paramav)
  {
    AppMethodBeat.i(61165);
    if (paramas == null) {
      adP(5);
    }
    if (paramav == null) {
      adP(6);
    }
    int i;
    if ((paramav.fJZ() == bh.JYD) || (paramas.fyC() == bh.JYD))
    {
      i = 1;
      if (i == 0) {
        break label81;
      }
    }
    label81:
    for (paramas = a.G(paramas).fxc();; paramas = paramav.fzr())
    {
      if (paramas == null) {
        adP(7);
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
      adP(2);
    }
    if (paramab2 == null) {
      adP(3);
    }
    if (paramx == null) {
      adP(4);
    }
    paramab1 = z.a(paramab1, paramab2, paramx);
    AppMethodBeat.o(61164);
    return paramab1;
  }
  
  private boolean a(av paramav1, av paramav2, d.l.b.a.b.b.as paramas)
  {
    AppMethodBeat.i(61173);
    if (paramav1 == null) {
      adP(19);
    }
    if (paramav2 == null) {
      adP(20);
    }
    if (paramas == null) {
      adP(21);
    }
    if (paramas.fyC() != bh.JYC)
    {
      AppMethodBeat.o(61173);
      return false;
    }
    if ((paramav1.fJZ() != bh.JYC) && (paramav2.fJZ() == bh.JYC))
    {
      boolean bool = this.JZj.a(paramav2.fzr(), paramav1);
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
      adP(8);
    }
    if (paramav == null) {
      adP(9);
    }
    int i;
    if ((paramav.fJZ() == bh.JYE) || (paramas.fyC() == bh.JYE))
    {
      i = 1;
      if (i == 0) {
        break label82;
      }
    }
    label82:
    for (paramas = a.G(paramas).fxa();; paramas = paramav.fzr())
    {
      if (paramas == null) {
        adP(10);
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
      adP(13);
    }
    if (paramav == null) {
      adP(14);
    }
    paramas = paramas.fyC();
    paramav = paramav.fJZ();
    if (paramav == bh.JYC) {}
    for (;;)
    {
      if ((paramav == bh.JYD) && (paramas == bh.JYE))
      {
        paramas = a.JZo;
        AppMethodBeat.o(61169);
        return paramas;
      }
      if ((paramav == bh.JYE) && (paramas == bh.JYD))
      {
        paramas = a.JZo;
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
      adP(0);
    }
    if (paramab2 == null) {
      adP(1);
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
    if ((c(y.an(paramab2).JXH, paramab1)) && (c(paramab1, y.an(paramab2).JXI)))
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
    if ((!paramab2.fBT()) && (paramab1.fBT()))
    {
      AppMethodBeat.o(61171);
      return false;
    }
    if (g.y(paramab1))
    {
      AppMethodBeat.o(61171);
      return true;
    }
    ab localab = a(paramab1, paramab2, this.JZj);
    if (localab == null)
    {
      bool = this.JZj.e(paramab1, paramab2);
      AppMethodBeat.o(61171);
      return bool;
    }
    if ((!paramab2.fBT()) && (localab.fBT()))
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
      adP(17);
    }
    if (paramab2 == null) {
      adP(18);
    }
    Object localObject1 = paramab1.fIW();
    paramab1 = paramab1.fIT();
    paramab2 = paramab2.fIT();
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
      if ((!localav1.fJY()) && (!a(localav2, localav1, (d.l.b.a.b.b.as)localObject2)))
      {
        if ((ad.aq(localav2.fzr())) || (ad.aq(localav1.fzr()))) {}
        for (int j = 1; (j == 0) && (((d.l.b.a.b.b.as)localObject2).fyC() == bh.JYC) && (localav2.fJZ() == bh.JYC) && (localav1.fJZ() == bh.JYC); j = 0)
        {
          if (this.JZj.a(localav2.fzr(), localav1.fzr(), this)) {
            break label385;
          }
          AppMethodBeat.o(61172);
          return false;
        }
        ab localab1 = a((d.l.b.a.b.b.as)localObject2, localav1);
        ab localab2 = a((d.l.b.a.b.b.as)localObject2, localav2);
        if (!this.JZj.b(localab2, localab1, this))
        {
          AppMethodBeat.o(61172);
          return false;
        }
        localab1 = b((d.l.b.a.b.b.as)localObject2, localav1);
        localObject2 = b((d.l.b.a.b.b.as)localObject2, localav2);
        if (localav1.fJZ() != bh.JYE)
        {
          if (!this.JZj.b(localab1, (ab)localObject2, this))
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
        adP(15);
      }
      if (paramab2 == null) {
        adP(16);
      }
      if (d.l.b.a.b.m.as.b(paramab1, paramab2))
      {
        if ((!paramab1.fBT()) || (paramab2.fBT()))
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
      adP(11);
    }
    if (paramab2 == null) {
      adP(12);
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
    if (paramab1.fBT() != paramab2.fBT())
    {
      AppMethodBeat.o(61167);
      return false;
    }
    if (paramab1.fBT())
    {
      bool = this.JZj.a(bc.aE(paramab1), bc.aE(paramab2), this);
      AppMethodBeat.o(61167);
      return bool;
    }
    at localat1 = paramab1.fIW();
    at localat2 = paramab2.fIW();
    if (!this.JZj.b(localat1, localat2))
    {
      AppMethodBeat.o(61167);
      return false;
    }
    paramab1 = paramab1.fIT();
    paramab2 = paramab2.fIT();
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
      if ((!localav1.fJY()) || (!localav2.fJY()))
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
          if (!this.JZj.a(localav1.fzr(), localav2.fzr(), this))
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
      JZl = new a("IN", 0);
      JZm = new a("OUT", 1);
      JZn = new a("INV", 2);
      JZo = new a("STAR", 3);
      JZp = new a[] { JZl, JZm, JZn, JZo };
      AppMethodBeat.o(61161);
    }
    
    private a() {}
    
    public static a b(bh parambh)
    {
      AppMethodBeat.i(61160);
      if (parambh == null) {
        adP(0);
      }
      switch (w.1.JZk[parambh.ordinal()])
      {
      default: 
        parambh = new IllegalStateException("Unknown variance");
        AppMethodBeat.o(61160);
        throw parambh;
      case 1: 
        parambh = JZn;
        if (parambh == null) {
          adP(1);
        }
        AppMethodBeat.o(61160);
        return parambh;
      case 2: 
        parambh = JZl;
        if (parambh == null) {
          adP(2);
        }
        AppMethodBeat.o(61160);
        return parambh;
      }
      parambh = JZm;
      if (parambh == null) {
        adP(3);
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