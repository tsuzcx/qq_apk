package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

public enum b
{
  static
  {
    AppMethodBeat.i(89764);
    wDO = new b("INSTANCE");
    wDP = new b[] { wDO };
    AppMethodBeat.o(89764);
  }
  
  private b() {}
  
  public static void Mj(int paramInt)
  {
    AppMethodBeat.i(89759);
    String str = bu.nullAsNil((String)g.ajR().ajA().get(143873, ""));
    if (!str.equals(""))
    {
      if (bu.rZ(bu.i((Long)g.ajR().ajA().get(143874, Long.valueOf(0L)))) < 7200L)
      {
        eG(str, paramInt);
        AppMethodBeat.o(89759);
        return;
      }
      auk(str);
    }
    AppMethodBeat.o(89759);
  }
  
  public static void auk(String paramString)
  {
    AppMethodBeat.i(89763);
    bq localbq = ((l)g.ab(l.class)).azF();
    if (localbq.aUO(paramString)) {
      localbq.aUS(paramString);
    }
    bl.a(paramString, new bl.a()
    {
      public final boolean YT()
      {
        return false;
      }
      
      public final void YU() {}
    });
    g.ajR().ajA().set(143873, "");
    g.ajR().ajA().set(143874, Long.valueOf(0L));
    dxh();
    AppMethodBeat.o(89763);
  }
  
  public static boolean dxf()
  {
    AppMethodBeat.i(89760);
    if (bu.o((Integer)g.ajR().ajA().get(143875, Integer.valueOf(0))) == 1)
    {
      AppMethodBeat.o(89760);
      return true;
    }
    AppMethodBeat.o(89760);
    return false;
  }
  
  public static void dxg()
  {
    AppMethodBeat.i(89761);
    g.ajR().ajA().set(143875, Integer.valueOf(1));
    AppMethodBeat.o(89761);
  }
  
  public static void dxh()
  {
    AppMethodBeat.i(89762);
    g.ajR().ajA().set(143875, Integer.valueOf(0));
    AppMethodBeat.o(89762);
  }
  
  public static void eG(String paramString, int paramInt)
  {
    AppMethodBeat.i(89758);
    paramString = new d(paramString, (int)bu.rZ(bu.i((Long)g.ajR().ajA().get(143874, Long.valueOf(0L)))), paramInt);
    g.ajj().a(paramString, 0);
    AppMethodBeat.o(89758);
  }
  
  public static boolean ir(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89757);
    an localan = new an();
    localan.to(paramString2);
    localan.setUsername(paramString1);
    paramString2 = ((l)g.ab(l.class)).azF();
    ae.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + localan.field_username);
    if (!paramString2.aUO(localan.field_username)) {
      paramString2.an(localan);
    }
    g.ajR().ajA().set(143873, paramString1);
    g.ajR().ajA().set(143874, Long.valueOf(bu.aRi()));
    AppMethodBeat.o(89757);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.b
 * JD-Core Version:    0.7.0.1
 */