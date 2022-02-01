package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.bzf;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.xk;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class u
  implements b<t>
{
  protected t AXo;
  public final b AXp;
  public final a AXq;
  public final d AXr;
  public final c AXs;
  
  public u()
  {
    this(new t());
    AppMethodBeat.i(68489);
    AppMethodBeat.o(68489);
  }
  
  private u(t paramt)
  {
    AppMethodBeat.i(68490);
    this.AXp = new b();
    this.AXq = new a();
    this.AXr = new d();
    this.AXs = new c();
    this.AXo = paramt;
    AppMethodBeat.o(68490);
  }
  
  public final class a
    implements e<xk, com.tencent.mm.vending.j.c<String, Integer>>
  {
    public a() {}
    
    public final String Ua()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements e<cju, Void>
  {
    public b() {}
    
    public final String Ua()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<cju> aOa()
    {
      AppMethodBeat.i(68484);
      com.tencent.mm.vending.g.c localc = g.fxs().c(this);
      AppMethodBeat.o(68484);
      return localc;
    }
  }
  
  public final class c
    implements e<bzd, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public c() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<bzd> is(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68486);
      com.tencent.mm.vending.g.c localc = g.J(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).c(this);
      AppMethodBeat.o(68486);
      return localc;
    }
  }
  
  public final class d
    implements e<bzf, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public d() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.u
 * JD-Core Version:    0.7.0.1
 */