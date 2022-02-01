package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.zj;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class u
  implements b<t>
{
  public final d CxA;
  public final c CxB;
  protected t Cxx;
  public final b Cxy;
  public final a Cxz;
  
  public u()
  {
    this(new t());
    AppMethodBeat.i(68489);
    AppMethodBeat.o(68489);
  }
  
  private u(t paramt)
  {
    AppMethodBeat.i(68490);
    this.Cxy = new b();
    this.Cxz = new a();
    this.CxA = new d();
    this.CxB = new c();
    this.Cxx = paramt;
    AppMethodBeat.o(68490);
  }
  
  public final class a
    implements e<zj, com.tencent.mm.vending.j.c<String, Integer>>
  {
    public a() {}
    
    public final String Wr()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements e<cou, Void>
  {
    public b() {}
    
    public final String Wr()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<cou> aRm()
    {
      AppMethodBeat.i(68484);
      com.tencent.mm.vending.g.c localc = g.fOf().c(this);
      AppMethodBeat.o(68484);
      return localc;
    }
  }
  
  public final class c
    implements e<cdu, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public c() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<cdu> iF(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68486);
      com.tencent.mm.vending.g.c localc = g.L(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).c(this);
      AppMethodBeat.o(68486);
      return localc;
    }
  }
  
  public final class d
    implements e<cdw, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public d() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.u
 * JD-Core Version:    0.7.0.1
 */