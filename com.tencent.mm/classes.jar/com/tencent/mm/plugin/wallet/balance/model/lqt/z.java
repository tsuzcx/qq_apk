package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.h;

public class z
  implements b<y>
{
  protected y Huc;
  public final d Hud;
  public final a Hue;
  public final b Huf;
  public final c Hug;
  
  public z()
  {
    this(new y());
    AppMethodBeat.i(68502);
    AppMethodBeat.o(68502);
  }
  
  private z(y paramy)
  {
    AppMethodBeat.i(68503);
    this.Hud = new d();
    this.Hue = new a();
    this.Huf = new b();
    this.Hug = new c();
    this.Huc = paramy;
    AppMethodBeat.o(68503);
  }
  
  public final class a
    implements e<dn, h<String, String, String, String, Integer, Integer, Integer>>
  {
    public a() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<cqy, h<Integer, String, String, String, Integer, Integer, String>>
  {
    public b() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<dgx, d<Integer, Integer, Integer>>
  {
    public c() {}
    
    public final com.tencent.mm.vending.g.c<dgx> aH(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(213854);
      com.tencent.mm.vending.g.c localc = g.h(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(6)).c(this);
      AppMethodBeat.o(213854);
      return localc;
    }
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
  
  public final class d
    implements e<ddt, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public d() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.z
 * JD-Core Version:    0.7.0.1
 */