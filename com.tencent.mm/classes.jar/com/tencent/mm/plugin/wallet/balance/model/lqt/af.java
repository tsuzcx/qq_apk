package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.protocal.protobuf.ejz;
import com.tencent.mm.protocal.protobuf.eoj;
import com.tencent.mm.protocal.protobuf.jl;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;
import com.tencent.mm.vending.j.h;
import com.tencent.mm.vending.j.i;

public class af
  implements b<ae>
{
  protected ae VaG;
  public final d VaH;
  public final b VaI;
  public final c VaJ;
  public final a VaK;
  
  public af()
  {
    this(new ae());
    AppMethodBeat.i(68521);
    AppMethodBeat.o(68521);
  }
  
  private af(ae paramae)
  {
    AppMethodBeat.i(68522);
    this.VaH = new d();
    this.VaI = new b();
    this.VaJ = new c();
    this.VaK = new a();
    this.VaG = paramae;
    AppMethodBeat.o(68522);
  }
  
  public final class a
    implements e<egh, f<Integer, jl, Integer, Integer, String>>
  {
    public a() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<ejz, h<String, String, Integer, Integer, String, Integer, Integer>>
  {
    public b() {}
    
    public final c<ejz> a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(316129);
      paramString1 = g.a(paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4)).c(this);
      AppMethodBeat.o(316129);
      return paramString1;
    }
    
    public final String aKh()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<eoj, f<Integer, String, String, Integer, String>>
  {
    public c() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
  }
  
  public final class d
    implements e<eiq, i<String, String, Integer, Integer, String, Integer, String, String>>
  {
    public d() {}
    
    public final String aKh()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.af
 * JD-Core Version:    0.7.0.1
 */