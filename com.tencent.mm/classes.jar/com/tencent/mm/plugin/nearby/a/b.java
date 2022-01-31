package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;

public enum b
{
  private b() {}
  
  public static void JO(String paramString)
  {
    com.tencent.mm.storage.bd localbd = ((j)g.r(j.class)).Fw();
    if (localbd.abn(paramString)) {
      localbd.abr(paramString);
    }
    com.tencent.mm.model.bd.a(paramString, new b.1());
    g.DP().Dz().o(143873, "");
    g.DP().Dz().o(143874, Long.valueOf(0L));
    bob();
  }
  
  public static boolean bnZ()
  {
    return bk.g((Integer)g.DP().Dz().get(143875, Integer.valueOf(0))) == 1;
  }
  
  public static void boa()
  {
    g.DP().Dz().o(143875, Integer.valueOf(1));
  }
  
  public static void bob()
  {
    g.DP().Dz().o(143875, Integer.valueOf(0));
  }
  
  public static void cc(String paramString, int paramInt)
  {
    paramString = new d(paramString, (int)bk.cn(bk.c((Long)g.DP().Dz().get(143874, Long.valueOf(0L)))), paramInt);
    g.Dk().a(paramString, 0);
  }
  
  public static boolean eg(String paramString1, String paramString2)
  {
    ad localad = new ad();
    localad.dk(paramString2);
    localad.setUsername(paramString1);
    paramString2 = ((j)g.r(j.class)).Fw();
    y.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + localad.field_username);
    if (!paramString2.abn(localad.field_username)) {
      paramString2.V(localad);
    }
    g.DP().Dz().o(143873, paramString1);
    g.DP().Dz().o(143874, Long.valueOf(bk.UX()));
    return true;
  }
  
  public static void vc(int paramInt)
  {
    String str = bk.pm((String)g.DP().Dz().get(143873, ""));
    if (!str.equals(""))
    {
      if (bk.cn(bk.c((Long)g.DP().Dz().get(143874, Long.valueOf(0L)))) < 7200L) {
        cc(str, paramInt);
      }
    }
    else {
      return;
    }
    JO(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.b
 * JD-Core Version:    0.7.0.1
 */