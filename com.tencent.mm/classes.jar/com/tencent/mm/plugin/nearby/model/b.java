package com.tencent.mm.plugin.nearby.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public enum b
{
  static
  {
    AppMethodBeat.i(89764);
    Moy = new b("INSTANCE");
    Moz = new b[] { Moy };
    AppMethodBeat.o(89764);
  }
  
  private b() {}
  
  public static void aPM(String paramString)
  {
    AppMethodBeat.i(89763);
    bx localbx = ((n)h.ax(n.class)).bzA();
    if (localbx.bxy(paramString)) {
      localbx.bxC(paramString);
    }
    br.a(paramString, new br.a()
    {
      public final boolean aMJ()
      {
        return false;
      }
      
      public final void aMK() {}
    });
    ac.aY(paramString, 15);
    h.baE().ban().B(143873, "");
    h.baE().ban().B(143874, Long.valueOf(0L));
    gsK();
    AppMethodBeat.o(89763);
  }
  
  public static void aex(int paramInt)
  {
    AppMethodBeat.i(89759);
    String str = Util.nullAsNil((String)h.baE().ban().d(143873, ""));
    if (!str.equals(""))
    {
      if (Util.secondsToNow(Util.nullAsNil((Long)h.baE().ban().d(143874, Long.valueOf(0L)))) < 7200L)
      {
        gp(str, paramInt);
        AppMethodBeat.o(89759);
        return;
      }
      aPM(str);
    }
    AppMethodBeat.o(89759);
  }
  
  public static void gp(String paramString, int paramInt)
  {
    AppMethodBeat.i(89758);
    paramString = new d(paramString, (int)Util.secondsToNow(Util.nullAsNil((Long)h.baE().ban().d(143874, Long.valueOf(0L)))), paramInt);
    h.aZW().a(paramString, 0);
    AppMethodBeat.o(89758);
  }
  
  public static boolean gsI()
  {
    AppMethodBeat.i(89760);
    if (Util.nullAsNil((Integer)h.baE().ban().d(143875, Integer.valueOf(0))) == 1)
    {
      AppMethodBeat.o(89760);
      return true;
    }
    AppMethodBeat.o(89760);
    return false;
  }
  
  public static void gsJ()
  {
    AppMethodBeat.i(89761);
    h.baE().ban().B(143875, Integer.valueOf(1));
    AppMethodBeat.o(89761);
  }
  
  public static void gsK()
  {
    AppMethodBeat.i(89762);
    h.baE().ban().B(143875, Integer.valueOf(0));
    AppMethodBeat.o(89762);
  }
  
  public static boolean kF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89757);
    au localau = new au();
    localau.setNickname(paramString2);
    localau.setUsername(paramString1);
    paramString2 = ((n)h.ax(n.class)).bzA();
    Log.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + localau.field_username);
    if (!paramString2.bxy(localau.field_username)) {
      paramString2.aB(localau);
    }
    h.baE().ban().B(143873, paramString1);
    h.baE().ban().B(143874, Long.valueOf(Util.nowSecond()));
    AppMethodBeat.o(89757);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.model.b
 * JD-Core Version:    0.7.0.1
 */