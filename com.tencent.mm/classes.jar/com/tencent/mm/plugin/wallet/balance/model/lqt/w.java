package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.abc;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class w
  implements b<v>
{
  protected v HtT;
  public final b HtU;
  public final a HtV;
  public final d HtW;
  public final c HtX;
  
  public w()
  {
    this(new v());
    AppMethodBeat.i(68489);
    AppMethodBeat.o(68489);
  }
  
  private w(v paramv)
  {
    AppMethodBeat.i(68490);
    this.HtU = new b();
    this.HtV = new a();
    this.HtW = new d();
    this.HtX = new c();
    this.HtT = paramv;
    AppMethodBeat.o(68490);
  }
  
  public final class a
    implements e<abc, com.tencent.mm.vending.j.c<String, Integer>>
  {
    public a() {}
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements e<dhn, Void>
  {
    public b() {}
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<dhn> bmq()
    {
      AppMethodBeat.i(68484);
      com.tencent.mm.vending.g.c localc = g.hdG().c(this);
      AppMethodBeat.o(68484);
      return localc;
    }
  }
  
  public final class c
    implements e<cuv, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public c() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<cuv> jP(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68486);
      com.tencent.mm.vending.g.c localc = g.O(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).c(this);
      AppMethodBeat.o(68486);
      return localc;
    }
  }
  
  public final class d
    implements e<cux, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public d() {}
    
    public final com.tencent.mm.vending.g.c<cux> aen(int paramInt)
    {
      AppMethodBeat.i(213853);
      com.tencent.mm.vending.g.c localc = g.O(Integer.valueOf(paramInt), Integer.valueOf(1)).c(this);
      AppMethodBeat.o(213853);
      return localc;
    }
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.w
 * JD-Core Version:    0.7.0.1
 */