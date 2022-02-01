package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.h;

public class x
  implements b<w>
{
  protected w zFk;
  public final d zFl;
  public final a zFm;
  public final b zFn;
  public final c zFo;
  
  public x()
  {
    this(new w());
    AppMethodBeat.i(68502);
    AppMethodBeat.o(68502);
  }
  
  private x(w paramw)
  {
    AppMethodBeat.i(68503);
    this.zFl = new d();
    this.zFm = new a();
    this.zFn = new b();
    this.zFo = new c();
    this.zFk = paramw;
    AppMethodBeat.o(68503);
  }
  
  public final class a
    implements e<db, h<String, String, String, String, Integer, Integer, Integer>>
  {
    public a() {}
    
    public final String Tg()
    {
      return "Vending.UI";
    }
  }
  
  public final class b
    implements e<brv, h<Integer, String, String, String, Integer, Integer, String>>
  {
    public b() {}
    
    public final String Tg()
    {
      return "Vending.UI";
    }
  }
  
  public final class c
    implements e<ceb, d<Integer, Integer, Integer>>
  {
    public c() {}
    
    public final String Tg()
    {
      return "Vending.UI";
    }
    
    public final com.tencent.mm.vending.g.c<ceb> ie(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(68499);
      com.tencent.mm.vending.g.c localc = g.h(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(6)).c(this);
      AppMethodBeat.o(68499);
      return localc;
    }
  }
  
  public final class d
    implements e<cbl, com.tencent.mm.vending.j.c<Integer, Integer>>
  {
    public d() {}
    
    public final String Tg()
    {
      return "Vending.UI";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.x
 * JD-Core Version:    0.7.0.1
 */