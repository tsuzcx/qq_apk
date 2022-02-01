package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.ejz;
import com.tencent.mm.protocal.protobuf.eoj;
import com.tencent.mm.protocal.protobuf.jl;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.d;

public final class ah
  implements b<ag>
{
  protected ag Vbe;
  public final d Vbf;
  public final a Vbg;
  public final b Vbh;
  public final e Vbi;
  public final c Vbj;
  
  public ah()
  {
    this(new ag());
    AppMethodBeat.i(68545);
    AppMethodBeat.o(68545);
  }
  
  public ah(ag paramag)
  {
    AppMethodBeat.i(68546);
    this.Vbf = new d();
    this.Vbg = new a();
    this.Vbh = new b();
    this.Vbi = new e();
    this.Vbj = new c();
    this.Vbe = paramag;
    AppMethodBeat.o(68546);
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<eoj, com.tencent.mm.vending.j.e<Integer, Integer, Integer, jl>>
  {
    public a() {}
    
    public final com.tencent.mm.vending.g.c<eoj> a(int paramInt1, int paramInt2, int paramInt3, jl paramjl)
    {
      AppMethodBeat.i(316152);
      paramjl = g.b(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramjl).c(this);
      AppMethodBeat.o(316152);
      return paramjl;
    }
    
    public final String aKh()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<ae, Integer>
  {
    public b() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public c() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<Void> mQ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(316136);
      com.tencent.mm.vending.g.c localc = g.S(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).c(this);
      AppMethodBeat.o(316136);
      return localc;
    }
  }
  
  public final class d
    implements com.tencent.mm.vending.h.e<ejz, d<Integer, Integer, Bankcard>>
  {
    public d() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
  }
  
  public final class e
    implements com.tencent.mm.vending.h.e<Void, d<Integer, Integer, Integer>>
  {
    public e() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<Void> mR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68543);
      com.tencent.mm.vending.g.c localc = g.f(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1)).c(this);
      AppMethodBeat.o(68543);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ah
 * JD-Core Version:    0.7.0.1
 */