package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;

public enum b
{
  static
  {
    AppMethodBeat.i(89764);
    tZM = new b("INSTANCE");
    tZN = new b[] { tZM };
    AppMethodBeat.o(89764);
  }
  
  private b() {}
  
  public static void Id(int paramInt)
  {
    AppMethodBeat.i(89759);
    String str = bt.nullAsNil((String)g.afB().afk().get(143873, ""));
    if (!str.equals(""))
    {
      if (bt.lZ(bt.f((Long)g.afB().afk().get(143874, Long.valueOf(0L)))) < 7200L)
      {
        dZ(str, paramInt);
        AppMethodBeat.o(89759);
        return;
      }
      aja(str);
    }
    AppMethodBeat.o(89759);
  }
  
  public static void aja(String paramString)
  {
    AppMethodBeat.i(89763);
    bg localbg = ((k)g.ab(k.class)).apM();
    if (localbg.aIb(paramString)) {
      localbg.aIf(paramString);
    }
    bi.a(paramString, new bi.a()
    {
      public final boolean Vt()
      {
        return false;
      }
      
      public final void Vu() {}
    });
    g.afB().afk().set(143873, "");
    g.afB().afk().set(143874, Long.valueOf(0L));
    cVY();
    AppMethodBeat.o(89763);
  }
  
  public static boolean cVW()
  {
    AppMethodBeat.i(89760);
    if (bt.l((Integer)g.afB().afk().get(143875, Integer.valueOf(0))) == 1)
    {
      AppMethodBeat.o(89760);
      return true;
    }
    AppMethodBeat.o(89760);
    return false;
  }
  
  public static void cVX()
  {
    AppMethodBeat.i(89761);
    g.afB().afk().set(143875, Integer.valueOf(1));
    AppMethodBeat.o(89761);
  }
  
  public static void cVY()
  {
    AppMethodBeat.i(89762);
    g.afB().afk().set(143875, Integer.valueOf(0));
    AppMethodBeat.o(89762);
  }
  
  public static void dZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(89758);
    paramString = new d(paramString, (int)bt.lZ(bt.f((Long)g.afB().afk().get(143874, Long.valueOf(0L)))), paramInt);
    g.aeS().a(paramString, 0);
    AppMethodBeat.o(89758);
  }
  
  public static boolean hH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89757);
    af localaf = new af();
    localaf.nd(paramString2);
    localaf.setUsername(paramString1);
    paramString2 = ((k)g.ab(k.class)).apM();
    ad.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + localaf.field_username);
    if (!paramString2.aIb(localaf.field_username)) {
      paramString2.af(localaf);
    }
    g.afB().afk().set(143873, paramString1);
    g.afB().afk().set(143874, Long.valueOf(bt.aGK()));
    AppMethodBeat.o(89757);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.b
 * JD-Core Version:    0.7.0.1
 */