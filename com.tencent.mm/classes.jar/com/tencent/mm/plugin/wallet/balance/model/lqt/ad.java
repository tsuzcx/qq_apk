package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.d;

public final class ad
  implements b<ac>
{
  protected ac AYf;
  public final c AYg;
  public final a AYh;
  public final b AYi;
  public final d AYj;
  
  public ad()
  {
    this(new ac());
    AppMethodBeat.i(68545);
    AppMethodBeat.o(68545);
  }
  
  public ad(ac paramac)
  {
    AppMethodBeat.i(68546);
    this.AYg = new c();
    this.AYh = new a();
    this.AYi = new b();
    this.AYj = new d();
    this.AYf = paramac;
    AppMethodBeat.o(68546);
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<cni, com.tencent.mm.vending.j.e<Integer, Integer, Integer, ig>>
  {
    public a() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
    
    public final c<cni> a(int paramInt1, int paramInt2, int paramInt3, ig paramig)
    {
      AppMethodBeat.i(207193);
      paramig = g.b(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramig).c(this);
      AppMethodBeat.o(207193);
      return paramig;
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<com.tencent.mm.plugin.wallet_core.c.ad, Integer>
  {
    public b() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements com.tencent.mm.vending.h.e<cjq, d<Integer, Integer, Bankcard>>
  {
    public c() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
  }
  
  public final class d
    implements com.tencent.mm.vending.h.e<Void, d<Integer, Integer, Integer>>
  {
    public d() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
    
    public final c<Void> it(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68543);
      c localc = g.h(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1)).c(this);
      AppMethodBeat.o(68543);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ad
 * JD-Core Version:    0.7.0.1
 */