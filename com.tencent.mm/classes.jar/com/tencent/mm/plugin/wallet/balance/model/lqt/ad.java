package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dec;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;
import com.tencent.mm.vending.j.h;
import com.tencent.mm.vending.j.i;

public class ad
  implements b<ac>
{
  protected ac Huo;
  public final d Hup;
  public final b Huq;
  public final c Hur;
  public final a Hus;
  
  public ad()
  {
    this(new ac());
    AppMethodBeat.i(68521);
    AppMethodBeat.o(68521);
  }
  
  private ad(ac paramac)
  {
    AppMethodBeat.i(68522);
    this.Hup = new d();
    this.Huq = new b();
    this.Hur = new c();
    this.Hus = new a();
    this.Huo = paramac;
    AppMethodBeat.o(68522);
  }
  
  public final class a
    implements e<dec, f<Integer, ja, Integer, Integer, String>>
  {
    public a() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<dhj, h<String, String, Integer, Integer, String, Integer, Integer>>
  {
    public b() {}
    
    public final c<dhj> a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(213855);
      paramString1 = g.a(paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4)).c(this);
      AppMethodBeat.o(213855);
      return paramString1;
    }
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<dlv, f<Integer, String, String, Integer, String>>
  {
    public c() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
  
  public final class d
    implements e<dgc, i<String, String, Integer, Integer, String, Integer, String, String>>
  {
    public d() {}
    
    public final String akn()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ad
 * JD-Core Version:    0.7.0.1
 */