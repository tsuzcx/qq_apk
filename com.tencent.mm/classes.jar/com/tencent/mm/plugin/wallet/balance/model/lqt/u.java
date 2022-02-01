package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bum;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.ww;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class u
  implements b<t>
{
  protected t zFb;
  public final b zFc;
  public final a zFd;
  public final d zFe;
  public final c zFf;
  
  public u()
  {
    this(new t());
    AppMethodBeat.i(68489);
    AppMethodBeat.o(68489);
  }
  
  private u(t paramt)
  {
    AppMethodBeat.i(68490);
    this.zFc = new b();
    this.zFd = new a();
    this.zFe = new d();
    this.zFf = new c();
    this.zFb = paramt;
    AppMethodBeat.o(68490);
  }
  
  public final class a
    implements e<ww, com.tencent.mm.vending.j.c<String, Integer>>
  {
    public a() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements e<cer, Void>
  {
    public b() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<cer> aHm()
    {
      AppMethodBeat.i(68484);
      com.tencent.mm.vending.g.c localc = g.fhq().c(this);
      AppMethodBeat.o(68484);
      return localc;
    }
  }
  
  public final class c
    implements e<bum, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public c() {}
    
    public final String Tg()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<bum> id(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68486);
      com.tencent.mm.vending.g.c localc = g.J(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).c(this);
      AppMethodBeat.o(68486);
      return localc;
    }
  }
  
  public final class d
    implements e<buo, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public d() {}
    
    public final String Tg()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.u
 * JD-Core Version:    0.7.0.1
 */