package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
    Gsy = new b("INSTANCE");
    Gsz = new b[] { Gsy };
    AppMethodBeat.o(89764);
  }
  
  private b() {}
  
  public static void aSN(String paramString)
  {
    AppMethodBeat.i(89763);
    bv localbv = ((n)h.ae(n.class)).bbL();
    if (localbv.bwl(paramString)) {
      localbv.bwp(paramString);
    }
    bq.a(paramString, new bq.a()
    {
      public final boolean asH()
      {
        return false;
      }
      
      public final void asI() {}
    });
    h.aHG().aHp().i(143873, "");
    h.aHG().aHp().i(143874, Long.valueOf(0L));
    fit();
    AppMethodBeat.o(89763);
  }
  
  public static void aae(int paramInt)
  {
    AppMethodBeat.i(89759);
    String str = Util.nullAsNil((String)h.aHG().aHp().b(143873, ""));
    if (!str.equals(""))
    {
      if (Util.secondsToNow(Util.nullAsNil((Long)h.aHG().aHp().b(143874, Long.valueOf(0L)))) < 7200L)
      {
        fw(str, paramInt);
        AppMethodBeat.o(89759);
        return;
      }
      aSN(str);
    }
    AppMethodBeat.o(89759);
  }
  
  public static boolean fir()
  {
    AppMethodBeat.i(89760);
    if (Util.nullAsNil((Integer)h.aHG().aHp().b(143875, Integer.valueOf(0))) == 1)
    {
      AppMethodBeat.o(89760);
      return true;
    }
    AppMethodBeat.o(89760);
    return false;
  }
  
  public static void fis()
  {
    AppMethodBeat.i(89761);
    h.aHG().aHp().i(143875, Integer.valueOf(1));
    AppMethodBeat.o(89761);
  }
  
  public static void fit()
  {
    AppMethodBeat.i(89762);
    h.aHG().aHp().i(143875, Integer.valueOf(0));
    AppMethodBeat.o(89762);
  }
  
  public static void fw(String paramString, int paramInt)
  {
    AppMethodBeat.i(89758);
    paramString = new d(paramString, (int)Util.secondsToNow(Util.nullAsNil((Long)h.aHG().aHp().b(143874, Long.valueOf(0L)))), paramInt);
    h.aGY().a(paramString, 0);
    AppMethodBeat.o(89758);
  }
  
  public static boolean jo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89757);
    as localas = new as();
    localas.setNickname(paramString2);
    localas.setUsername(paramString1);
    paramString2 = ((n)h.ae(n.class)).bbL();
    Log.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + localas.field_username);
    if (!paramString2.bwl(localas.field_username)) {
      paramString2.av(localas);
    }
    h.aHG().aHp().i(143873, paramString1);
    h.aHG().aHp().i(143874, Long.valueOf(Util.nowSecond()));
    AppMethodBeat.o(89757);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.b
 * JD-Core Version:    0.7.0.1
 */