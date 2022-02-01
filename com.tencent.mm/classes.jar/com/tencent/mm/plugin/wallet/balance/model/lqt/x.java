package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.h;

public class x
  implements b<w>
{
  public final b AXA;
  public final c AXB;
  protected w AXx;
  public final d AXy;
  public final a AXz;
  
  public x()
  {
    this(new w());
    AppMethodBeat.i(68502);
    AppMethodBeat.o(68502);
  }
  
  private x(w paramw)
  {
    AppMethodBeat.i(68503);
    this.AXy = new d();
    this.AXz = new a();
    this.AXA = new b();
    this.AXB = new c();
    this.AXx = paramw;
    AppMethodBeat.o(68503);
  }
  
  public final class a
    implements e<dd, h<String, String, String, String, Integer, Integer, Integer>>
  {
    public a() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<bwm, h<Integer, String, String, String, Integer, Integer, String>>
  {
    public b() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<cje, d<Integer, Integer, Integer>>
  {
    public c() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<cje> it(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68499);
      com.tencent.mm.vending.g.c localc = g.h(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(6)).c(this);
      AppMethodBeat.o(68499);
      return localc;
    }
  }
  
  public final class d
    implements e<cgn, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public d() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.x
 * JD-Core Version:    0.7.0.1
 */