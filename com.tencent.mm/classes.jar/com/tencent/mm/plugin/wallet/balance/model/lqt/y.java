package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class y
  implements b<x>
{
  protected x Vak;
  public final b Val;
  public final a Vam;
  public final e Van;
  public final c Vao;
  public final d Vap;
  
  public y()
  {
    this(new x());
    AppMethodBeat.i(68489);
    AppMethodBeat.o(68489);
  }
  
  private y(x paramx)
  {
    AppMethodBeat.i(68490);
    this.Val = new b();
    this.Vam = new a();
    this.Van = new e();
    this.Vao = new c();
    this.Vap = new d();
    this.Vak = paramx;
    AppMethodBeat.o(68490);
  }
  
  public final class a
    implements e<adl, com.tencent.mm.vending.j.c<String, Integer>>
  {
    public a() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements e<ekd, Void>
  {
    public b() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<ekd> bVq()
    {
      AppMethodBeat.i(68484);
      com.tencent.mm.vending.g.c localc = g.jJU().c(this);
      AppMethodBeat.o(68484);
      return localc;
    }
  }
  
  public final class c
    implements e<dwc, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public c() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<dwc> mQ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68486);
      com.tencent.mm.vending.g.c localc = g.S(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).c(this);
      AppMethodBeat.o(68486);
      return localc;
    }
  }
  
  public final class d
    implements e<dwc, String>
  {
    public d() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class e
    implements e<dwg, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public e() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<dwg> arJ(int paramInt)
    {
      AppMethodBeat.i(316219);
      com.tencent.mm.vending.g.c localc = g.S(Integer.valueOf(paramInt), Integer.valueOf(1)).c(this);
      AppMethodBeat.o(316219);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.y
 * JD-Core Version:    0.7.0.1
 */