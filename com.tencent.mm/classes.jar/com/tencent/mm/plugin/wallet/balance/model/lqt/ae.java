package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.protocal.protobuf.dre;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.protocal.protobuf.ip;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;
import com.tencent.mm.vending.j.h;
import com.tencent.mm.vending.j.i;

public class ae
  implements b<ad>
{
  protected ad Oma;
  public final d Omb;
  public final b Omc;
  public final c Omd;
  public final a Ome;
  
  public ae()
  {
    this(new ad());
    AppMethodBeat.i(68521);
    AppMethodBeat.o(68521);
  }
  
  private ae(ad paramad)
  {
    AppMethodBeat.i(68522);
    this.Omb = new d();
    this.Omc = new b();
    this.Omd = new c();
    this.Ome = new a();
    this.Oma = paramad;
    AppMethodBeat.o(68522);
  }
  
  public final class a
    implements e<dns, f<Integer, ip, Integer, Integer, String>>
  {
    public a() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<dre, h<String, String, Integer, Integer, String, Integer, Integer>>
  {
    public b() {}
    
    public final c<dre> a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(195303);
      paramString1 = g.b(paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4)).c(this);
      AppMethodBeat.o(195303);
      return paramString1;
    }
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<dvn, f<Integer, String, String, Integer, String>>
  {
    public c() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
  
  public final class d
    implements e<dpw, i<String, String, Integer, Integer, String, Integer, String, String>>
  {
    public d() {}
    
    public final String aqj()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ae
 * JD-Core Version:    0.7.0.1
 */