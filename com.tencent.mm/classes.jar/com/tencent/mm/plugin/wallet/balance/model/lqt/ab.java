package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dqw;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.efy;
import com.tencent.mm.protocal.protobuf.ejn;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.h;

public class ab
  implements b<aa>
{
  protected aa Vau;
  public final d Vav;
  public final a Vaw;
  public final b Vax;
  public final c Vay;
  
  public ab()
  {
    this(new aa());
    AppMethodBeat.i(68502);
    AppMethodBeat.o(68502);
  }
  
  private ab(aa paramaa)
  {
    AppMethodBeat.i(68503);
    this.Vav = new d();
    this.Vaw = new a();
    this.Vax = new b();
    this.Vay = new c();
    this.Vau = paramaa;
    AppMethodBeat.o(68503);
  }
  
  public final class a
    implements e<dy, h<String, String, String, String, Integer, Integer, Integer>>
  {
    public a() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<dqw, h<Integer, String, String, String, Integer, Integer, String>>
  {
    public b() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<ejn, d<Integer, Integer, Integer>>
  {
    public c() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<ejn> bn(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(316140);
      com.tencent.mm.vending.g.c localc = g.f(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(6)).c(this);
      AppMethodBeat.o(316140);
      return localc;
    }
  }
  
  public final class d
    implements e<efy, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public d() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ab
 * JD-Core Version:    0.7.0.1
 */