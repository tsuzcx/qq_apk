package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public enum b
{
  static
  {
    AppMethodBeat.i(89764);
    Azv = new b("INSTANCE");
    Azw = new b[] { Azv };
    AppMethodBeat.o(89764);
  }
  
  private b() {}
  
  public static void Ts(int paramInt)
  {
    AppMethodBeat.i(89759);
    String str = Util.nullAsNil((String)g.aAh().azQ().get(143873, ""));
    if (!str.equals(""))
    {
      if (Util.secondsToNow(Util.nullAsNil((Long)g.aAh().azQ().get(143874, Long.valueOf(0L)))) < 7200L)
      {
        eV(str, paramInt);
        AppMethodBeat.o(89759);
        return;
      }
      aIt(str);
    }
    AppMethodBeat.o(89759);
  }
  
  public static void aIt(String paramString)
  {
    AppMethodBeat.i(89763);
    bv localbv = ((l)g.af(l.class)).aSN();
    if (localbv.bjN(paramString)) {
      localbv.aNa(paramString);
    }
    bp.a(paramString, new bp.a()
    {
      public final boolean amG()
      {
        return false;
      }
      
      public final void amH() {}
    });
    g.aAh().azQ().set(143873, "");
    g.aAh().azQ().set(143874, Long.valueOf(0L));
    ewQ();
    AppMethodBeat.o(89763);
  }
  
  public static void eV(String paramString, int paramInt)
  {
    AppMethodBeat.i(89758);
    paramString = new d(paramString, (int)Util.secondsToNow(Util.nullAsNil((Long)g.aAh().azQ().get(143874, Long.valueOf(0L)))), paramInt);
    g.azz().a(paramString, 0);
    AppMethodBeat.o(89758);
  }
  
  public static boolean ewO()
  {
    AppMethodBeat.i(89760);
    if (Util.nullAsNil((Integer)g.aAh().azQ().get(143875, Integer.valueOf(0))) == 1)
    {
      AppMethodBeat.o(89760);
      return true;
    }
    AppMethodBeat.o(89760);
    return false;
  }
  
  public static void ewP()
  {
    AppMethodBeat.i(89761);
    g.aAh().azQ().set(143875, Integer.valueOf(1));
    AppMethodBeat.o(89761);
  }
  
  public static void ewQ()
  {
    AppMethodBeat.i(89762);
    g.aAh().azQ().set(143875, Integer.valueOf(0));
    AppMethodBeat.o(89762);
  }
  
  public static boolean jc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89757);
    as localas = new as();
    localas.setNickname(paramString2);
    localas.setUsername(paramString1);
    paramString2 = ((l)g.af(l.class)).aSN();
    Log.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + localas.field_username);
    if (!paramString2.bjN(localas.field_username)) {
      paramString2.ap(localas);
    }
    g.aAh().azQ().set(143873, paramString1);
    g.aAh().azQ().set(143874, Long.valueOf(Util.nowSecond()));
    AppMethodBeat.o(89757);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.b
 * JD-Core Version:    0.7.0.1
 */