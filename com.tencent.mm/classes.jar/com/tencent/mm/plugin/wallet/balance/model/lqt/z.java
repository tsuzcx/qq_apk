package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class z
  implements b<y>
{
  protected y zFr;
  public final b zFs;
  public final a zFt;
  
  public z()
  {
    this(new y());
    AppMethodBeat.i(68510);
    AppMethodBeat.o(68510);
  }
  
  private z(y paramy)
  {
    AppMethodBeat.i(68511);
    this.zFs = new b();
    this.zFt = new a();
    this.zFr = paramy;
    AppMethodBeat.o(68511);
  }
  
  public final class a
    implements e<bon, d<Integer, Integer, String>>
  {
    public a() {}
    
    public final String Tg()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<caq, Void>
  {
    public b() {}
    
    public final String Tg()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.z
 * JD-Core Version:    0.7.0.1
 */