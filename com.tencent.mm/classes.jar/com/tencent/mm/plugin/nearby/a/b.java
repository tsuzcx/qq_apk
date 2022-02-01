package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;

public enum b
{
  static
  {
    AppMethodBeat.i(89764);
    viM = new b("INSTANCE");
    viN = new b[] { viM };
    AppMethodBeat.o(89764);
  }
  
  private b() {}
  
  public static void Kc(int paramInt)
  {
    AppMethodBeat.i(89759);
    String str = bs.nullAsNil((String)g.agR().agA().get(143873, ""));
    if (!str.equals(""))
    {
      if (bs.pN(bs.g((Long)g.agR().agA().get(143874, Long.valueOf(0L)))) < 7200L)
      {
        eg(str, paramInt);
        AppMethodBeat.o(89759);
        return;
      }
      anY(str);
    }
    AppMethodBeat.o(89759);
  }
  
  public static void anY(String paramString)
  {
    AppMethodBeat.i(89763);
    bj localbj = ((k)g.ab(k.class)).awB();
    if (localbj.aNw(paramString)) {
      localbj.aNA(paramString);
    }
    bi.a(paramString, new bi.a()
    {
      public final boolean Wr()
      {
        return false;
      }
      
      public final void Ws() {}
    });
    g.agR().agA().set(143873, "");
    g.agR().agA().set(143874, Long.valueOf(0L));
    djG();
    AppMethodBeat.o(89763);
  }
  
  public static boolean djE()
  {
    AppMethodBeat.i(89760);
    if (bs.m((Integer)g.agR().agA().get(143875, Integer.valueOf(0))) == 1)
    {
      AppMethodBeat.o(89760);
      return true;
    }
    AppMethodBeat.o(89760);
    return false;
  }
  
  public static void djF()
  {
    AppMethodBeat.i(89761);
    g.agR().agA().set(143875, Integer.valueOf(1));
    AppMethodBeat.o(89761);
  }
  
  public static void djG()
  {
    AppMethodBeat.i(89762);
    g.agR().agA().set(143875, Integer.valueOf(0));
    AppMethodBeat.o(89762);
  }
  
  public static void eg(String paramString, int paramInt)
  {
    AppMethodBeat.i(89758);
    paramString = new d(paramString, (int)bs.pN(bs.g((Long)g.agR().agA().get(143874, Long.valueOf(0L)))), paramInt);
    g.agi().a(paramString, 0);
    AppMethodBeat.o(89758);
  }
  
  public static boolean ia(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89757);
    ai localai = new ai();
    localai.qj(paramString2);
    localai.setUsername(paramString1);
    paramString2 = ((k)g.ab(k.class)).awB();
    ac.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + localai.field_username);
    if (!paramString2.aNw(localai.field_username)) {
      paramString2.ag(localai);
    }
    g.agR().agA().set(143873, paramString1);
    g.agR().agA().set(143874, Long.valueOf(bs.aNx()));
    AppMethodBeat.o(89757);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.b
 * JD-Core Version:    0.7.0.1
 */