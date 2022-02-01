package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;

public enum b
{
  static
  {
    AppMethodBeat.i(89764);
    wof = new b("INSTANCE");
    wog = new b[] { wof };
    AppMethodBeat.o(89764);
  }
  
  private b() {}
  
  public static void LE(int paramInt)
  {
    AppMethodBeat.i(89759);
    String str = bt.nullAsNil((String)g.ajC().ajl().get(143873, ""));
    if (!str.equals(""))
    {
      if (bt.rM(bt.g((Long)g.ajC().ajl().get(143874, Long.valueOf(0L)))) < 7200L)
      {
        ey(str, paramInt);
        AppMethodBeat.o(89759);
        return;
      }
      asX(str);
    }
    AppMethodBeat.o(89759);
  }
  
  public static void asX(String paramString)
  {
    AppMethodBeat.i(89763);
    bp localbp = ((l)g.ab(l.class)).azp();
    if (localbp.aTn(paramString)) {
      localbp.aTr(paramString);
    }
    bj.a(paramString, new bj.a()
    {
      public final boolean YK()
      {
        return false;
      }
      
      public final void YL() {}
    });
    g.ajC().ajl().set(143873, "");
    g.ajC().ajl().set(143874, Long.valueOf(0L));
    dtS();
    AppMethodBeat.o(89763);
  }
  
  public static boolean dtQ()
  {
    AppMethodBeat.i(89760);
    if (bt.n((Integer)g.ajC().ajl().get(143875, Integer.valueOf(0))) == 1)
    {
      AppMethodBeat.o(89760);
      return true;
    }
    AppMethodBeat.o(89760);
    return false;
  }
  
  public static void dtR()
  {
    AppMethodBeat.i(89761);
    g.ajC().ajl().set(143875, Integer.valueOf(1));
    AppMethodBeat.o(89761);
  }
  
  public static void dtS()
  {
    AppMethodBeat.i(89762);
    g.ajC().ajl().set(143875, Integer.valueOf(0));
    AppMethodBeat.o(89762);
  }
  
  public static void ey(String paramString, int paramInt)
  {
    AppMethodBeat.i(89758);
    paramString = new d(paramString, (int)bt.rM(bt.g((Long)g.ajC().ajl().get(143874, Long.valueOf(0L)))), paramInt);
    g.aiU().a(paramString, 0);
    AppMethodBeat.o(89758);
  }
  
  public static boolean il(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89757);
    am localam = new am();
    localam.sT(paramString2);
    localam.setUsername(paramString1);
    paramString2 = ((l)g.ab(l.class)).azp();
    ad.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + localam.field_username);
    if (!paramString2.aTn(localam.field_username)) {
      paramString2.ag(localam);
    }
    g.ajC().ajl().set(143873, paramString1);
    g.ajC().ajl().set(143874, Long.valueOf(bt.aQJ()));
    AppMethodBeat.o(89757);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.b
 * JD-Core Version:    0.7.0.1
 */