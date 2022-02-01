package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.coy;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.h;

public class x
  implements b<w>
{
  protected w CPl;
  public final d CPm;
  public final a CPn;
  public final b CPo;
  public final c CPp;
  
  public x()
  {
    this(new w());
    AppMethodBeat.i(68502);
    AppMethodBeat.o(68502);
  }
  
  private x(w paramw)
  {
    AppMethodBeat.i(68503);
    this.CPm = new d();
    this.CPn = new a();
    this.CPo = new b();
    this.CPp = new c();
    this.CPl = paramw;
    AppMethodBeat.o(68503);
  }
  
  public final class a
    implements e<de, h<String, String, String, String, Integer, Integer, Integer>>
  {
    public a() {}
    
    public final String Wz()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<cbw, h<Integer, String, String, String, Integer, Integer, String>>
  {
    public b() {}
    
    public final String Wz()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<coy, d<Integer, Integer, Integer>>
  {
    public c() {}
    
    public final String Wz()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<coy> iK(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68499);
      com.tencent.mm.vending.g.c localc = g.h(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(6)).c(this);
      AppMethodBeat.o(68499);
      return localc;
    }
  }
  
  public final class d
    implements e<cmg, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public d() {}
    
    public final String Wz()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.x
 * JD-Core Version:    0.7.0.1
 */