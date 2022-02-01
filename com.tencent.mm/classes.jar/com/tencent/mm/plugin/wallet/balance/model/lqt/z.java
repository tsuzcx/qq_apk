package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class z
  implements b<y>
{
  protected y CPs;
  public final b CPt;
  public final a CPu;
  
  public z()
  {
    this(new y());
    AppMethodBeat.i(68510);
    AppMethodBeat.o(68510);
  }
  
  private z(y paramy)
  {
    AppMethodBeat.i(68511);
    this.CPt = new b();
    this.CPu = new a();
    this.CPs = paramy;
    AppMethodBeat.o(68511);
  }
  
  public final class a
    implements e<byl, d<Integer, Integer, String>>
  {
    public a() {}
    
    public final String Wz()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<cli, Void>
  {
    public b() {}
    
    public final String Wz()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.z
 * JD-Core Version:    0.7.0.1
 */