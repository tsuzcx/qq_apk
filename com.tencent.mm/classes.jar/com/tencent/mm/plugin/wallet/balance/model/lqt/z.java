package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class z
  implements b<y>
{
  protected y AXE;
  public final b AXF;
  public final a AXG;
  
  public z()
  {
    this(new y());
    AppMethodBeat.i(68510);
    AppMethodBeat.o(68510);
  }
  
  private z(y paramy)
  {
    AppMethodBeat.i(68511);
    this.AXF = new b();
    this.AXG = new a();
    this.AXE = paramy;
    AppMethodBeat.o(68511);
  }
  
  public final class a
    implements e<btd, d<Integer, Integer, String>>
  {
    public a() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<cfp, Void>
  {
    public b() {}
    
    public final String Ua()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.z
 * JD-Core Version:    0.7.0.1
 */