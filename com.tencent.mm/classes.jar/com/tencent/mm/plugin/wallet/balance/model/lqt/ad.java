package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.d;

public final class ad
  implements b<ac>
{
  protected ac Cyo;
  public final c Cyp;
  public final a Cyq;
  public final b Cyr;
  public final d Cys;
  
  public ad()
  {
    this(new ac());
    AppMethodBeat.i(68545);
    AppMethodBeat.o(68545);
  }
  
  public ad(ac paramac)
  {
    AppMethodBeat.i(68546);
    this.Cyp = new c();
    this.Cyq = new a();
    this.Cyr = new b();
    this.Cys = new d();
    this.Cyo = paramac;
    AppMethodBeat.o(68546);
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<csl, com.tencent.mm.vending.j.e<Integer, Integer, Integer, in>>
  {
    public a() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
    
    public final c<csl> a(int paramInt1, int paramInt2, int paramInt3, in paramin)
    {
      AppMethodBeat.i(199190);
      paramin = g.b(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramin).c(this);
      AppMethodBeat.o(199190);
      return paramin;
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<com.tencent.mm.plugin.wallet_core.c.ad, Integer>
  {
    public b() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements com.tencent.mm.vending.h.e<coq, d<Integer, Integer, Bankcard>>
  {
    public c() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
  }
  
  public final class d
    implements com.tencent.mm.vending.h.e<Void, d<Integer, Integer, Integer>>
  {
    public d() {}
    
    public final String Wr()
    {
      return "Vending.UI";
    }
    
    public final c<Void> iG(int paramInt1, int paramInt2)
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