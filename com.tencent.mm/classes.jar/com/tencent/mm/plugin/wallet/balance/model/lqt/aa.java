package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.h;

public class aa
  implements b<z>
{
  protected z OlO;
  public final d OlP;
  public final a OlQ;
  public final b OlR;
  public final c OlS;
  
  public aa()
  {
    this(new z());
    AppMethodBeat.i(68502);
    AppMethodBeat.o(68502);
  }
  
  private aa(z paramz)
  {
    AppMethodBeat.i(68503);
    this.OlP = new d();
    this.OlQ = new a();
    this.OlR = new b();
    this.OlS = new c();
    this.OlO = paramz;
    AppMethodBeat.o(68503);
  }
  
  public final class a
    implements e<dl, h<String, String, String, String, Integer, Integer, Integer>>
  {
    public a() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<czp, h<Integer, String, String, String, Integer, Integer, String>>
  {
    public b() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<dqs, d<Integer, Integer, Integer>>
  {
    public c() {}
    
    public final com.tencent.mm.vending.g.c<dqs> aL(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(276549);
      com.tencent.mm.vending.g.c localc = g.g(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(6)).c(this);
      AppMethodBeat.o(276549);
      return localc;
    }
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
  
  public final class d
    implements e<dnj, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public d() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.aa
 * JD-Core Version:    0.7.0.1
 */