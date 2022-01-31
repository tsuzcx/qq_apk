package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;

public enum b
{
  static
  {
    AppMethodBeat.i(55362);
    pco = new b("INSTANCE");
    pcp = new b[] { pco };
    AppMethodBeat.o(55362);
  }
  
  private b() {}
  
  public static void AA(int paramInt)
  {
    AppMethodBeat.i(55357);
    String str = bo.nullAsNil((String)g.RL().Ru().get(143873, ""));
    if (!str.equals(""))
    {
      if (bo.gz(bo.c((Long)g.RL().Ru().get(143874, Long.valueOf(0L)))) < 7200L)
      {
        cU(str, paramInt);
        AppMethodBeat.o(55357);
        return;
      }
      VN(str);
    }
    AppMethodBeat.o(55357);
  }
  
  public static void VN(String paramString)
  {
    AppMethodBeat.i(55361);
    bd localbd = ((j)g.E(j.class)).YA();
    if (localbd.ary(paramString)) {
      localbd.arC(paramString);
    }
    bf.a(paramString, new b.1());
    g.RL().Ru().set(143873, "");
    g.RL().Ru().set(143874, Long.valueOf(0L));
    bWx();
    AppMethodBeat.o(55361);
  }
  
  public static boolean bWv()
  {
    AppMethodBeat.i(55358);
    if (bo.g((Integer)g.RL().Ru().get(143875, Integer.valueOf(0))) == 1)
    {
      AppMethodBeat.o(55358);
      return true;
    }
    AppMethodBeat.o(55358);
    return false;
  }
  
  public static void bWw()
  {
    AppMethodBeat.i(55359);
    g.RL().Ru().set(143875, Integer.valueOf(1));
    AppMethodBeat.o(55359);
  }
  
  public static void bWx()
  {
    AppMethodBeat.i(55360);
    g.RL().Ru().set(143875, Integer.valueOf(0));
    AppMethodBeat.o(55360);
  }
  
  public static void cU(String paramString, int paramInt)
  {
    AppMethodBeat.i(55356);
    paramString = new d(paramString, (int)bo.gz(bo.c((Long)g.RL().Ru().get(143874, Long.valueOf(0L)))), paramInt);
    g.Rc().a(paramString, 0);
    AppMethodBeat.o(55356);
  }
  
  public static boolean fA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55355);
    ad localad = new ad();
    localad.jp(paramString2);
    localad.setUsername(paramString1);
    paramString2 = ((j)g.E(j.class)).YA();
    ab.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + localad.field_username);
    if (!paramString2.ary(localad.field_username)) {
      paramString2.Y(localad);
    }
    g.RL().Ru().set(143873, paramString1);
    g.RL().Ru().set(143874, Long.valueOf(bo.aox()));
    AppMethodBeat.o(55355);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.b
 * JD-Core Version:    0.7.0.1
 */