package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.d;

public final class af
  implements b<ae>
{
  protected ae HuL;
  public final d HuM;
  public final a HuN;
  public final b HuO;
  public final e HuP;
  public final c HuQ;
  
  public af()
  {
    this(new ae());
    AppMethodBeat.i(68545);
    AppMethodBeat.o(68545);
  }
  
  public af(ae paramae)
  {
    AppMethodBeat.i(68546);
    this.HuM = new d();
    this.HuN = new a();
    this.HuO = new b();
    this.HuP = new e();
    this.HuQ = new c();
    this.HuL = paramae;
    AppMethodBeat.o(68546);
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<dlv, com.tencent.mm.vending.j.e<Integer, Integer, Integer, ja>>
  {
    public a() {}
    
    public final com.tencent.mm.vending.g.c<dlv> a(int paramInt1, int paramInt2, int paramInt3, ja paramja)
    {
      AppMethodBeat.i(213866);
      paramja = g.a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramja).c(this);
      AppMethodBeat.o(213866);
      return paramja;
    }
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<ad, Integer>
  {
    public b() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public c() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<Void> jP(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(213867);
      com.tencent.mm.vending.g.c localc = g.O(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).c(this);
      AppMethodBeat.o(213867);
      return localc;
    }
  }
  
  public final class d
    implements com.tencent.mm.vending.h.e<dhj, d<Integer, Integer, Bankcard>>
  {
    public d() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
  
  public final class e
    implements com.tencent.mm.vending.h.e<Void, d<Integer, Integer, Integer>>
  {
    public e() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<Void> jQ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68543);
      com.tencent.mm.vending.g.c localc = g.h(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1)).c(this);
      AppMethodBeat.o(68543);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.af
 * JD-Core Version:    0.7.0.1
 */