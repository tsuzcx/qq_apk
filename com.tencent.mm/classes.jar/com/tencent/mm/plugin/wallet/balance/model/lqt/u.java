package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.protocal.protobuf.zm;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class u
  implements b<t>
{
  protected t CPc;
  public final b CPd;
  public final a CPe;
  public final d CPf;
  public final c CPg;
  
  public u()
  {
    this(new t());
    AppMethodBeat.i(68489);
    AppMethodBeat.o(68489);
  }
  
  private u(t paramt)
  {
    AppMethodBeat.i(68490);
    this.CPd = new b();
    this.CPe = new a();
    this.CPf = new d();
    this.CPg = new c();
    this.CPc = paramt;
    AppMethodBeat.o(68490);
  }
  
  public final class a
    implements e<zm, com.tencent.mm.vending.j.c<String, Integer>>
  {
    public a() {}
    
    public final String Wz()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements e<cpo, Void>
  {
    public b() {}
    
    public final String Wz()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<cpo> aRL()
    {
      AppMethodBeat.i(68484);
      com.tencent.mm.vending.g.c localc = g.fSA().c(this);
      AppMethodBeat.o(68484);
      return localc;
    }
  }
  
  public final class c
    implements e<ceo, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public c() {}
    
    public final String Wz()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<ceo> iJ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68486);
      com.tencent.mm.vending.g.c localc = g.L(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).c(this);
      AppMethodBeat.o(68486);
      return localc;
    }
  }
  
  public final class d
    implements e<ceq, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public d() {}
    
    public final String Wz()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.u
 * JD-Core Version:    0.7.0.1
 */