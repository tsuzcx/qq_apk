package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.dre;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.protocal.protobuf.ip;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.d;

public final class ag
  implements b<af>
{
  public final a OmA;
  public final b OmB;
  public final e OmC;
  public final c OmD;
  protected af Omy;
  public final d Omz;
  
  public ag()
  {
    this(new af());
    AppMethodBeat.i(68545);
    AppMethodBeat.o(68545);
  }
  
  public ag(af paramaf)
  {
    AppMethodBeat.i(68546);
    this.Omz = new d();
    this.OmA = new a();
    this.OmB = new b();
    this.OmC = new e();
    this.OmD = new c();
    this.Omy = paramaf;
    AppMethodBeat.o(68546);
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<dvn, com.tencent.mm.vending.j.e<Integer, Integer, Integer, ip>>
  {
    public a() {}
    
    public final com.tencent.mm.vending.g.c<dvn> a(int paramInt1, int paramInt2, int paramInt3, ip paramip)
    {
      AppMethodBeat.i(272160);
      paramip = g.b(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramip).c(this);
      AppMethodBeat.o(272160);
      return paramip;
    }
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<ae, Integer>
  {
    public b() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public c() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<Void> lf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(266385);
      com.tencent.mm.vending.g.c localc = g.H(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).c(this);
      AppMethodBeat.o(266385);
      return localc;
    }
  }
  
  public final class d
    implements com.tencent.mm.vending.h.e<dre, d<Integer, Integer, Bankcard>>
  {
    public d() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
  
  public final class e
    implements com.tencent.mm.vending.h.e<Void, d<Integer, Integer, Integer>>
  {
    public e() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<Void> lg(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68543);
      com.tencent.mm.vending.g.c localc = g.g(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1)).c(this);
      AppMethodBeat.o(68543);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ag
 * JD-Core Version:    0.7.0.1
 */