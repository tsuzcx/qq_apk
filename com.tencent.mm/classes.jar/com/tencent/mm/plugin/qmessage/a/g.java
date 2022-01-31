package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ah.e.d;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import java.util.HashMap;

public final class g
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private e ncB;
  private f ncC = new f();
  private a ncD = new a();
  private b ncE = new b();
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("QCONTACT_TABLE".hashCode()), new g.1());
  }
  
  private static g btj()
  {
    au.Hq();
    g localg2 = (g)bu.iR("plugin.qmessage");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      au.Hq().a("plugin.qmessage", localg1);
    }
    return localg1;
  }
  
  public static e btk()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (btj().ncB == null)
    {
      g localg = btj();
      au.Hx();
      localg.ncB = new e(c.Dv());
    }
    return btj().ncB;
  }
  
  public static void btl()
  {
    au.Hx();
    if (c.FB().abv("qmessage") == null)
    {
      localObject = new ak();
      ((ak)localObject).setUsername("qmessage");
      ((ak)localObject).setContent("");
      ((ak)localObject).ba(bk.UY());
      ((ak)localObject).fA(0);
      ((ak)localObject).fy(0);
      au.Hx();
      c.FB().d((ak)localObject);
      return;
    }
    au.Hx();
    Object localObject = c.Fy().HA("qmessage");
    ak localak = new ak();
    localak.setUsername("qmessage");
    if (localObject == null) {}
    for (localObject = "";; localObject = ((cs)localObject).field_content)
    {
      localak.setContent((String)localObject);
      localak.ba(bk.UY());
      localak.fA(0);
      localak.fy(0);
      au.Hx();
      c.FB().a(localak, "qmessage");
      return;
    }
  }
  
  public static void btm()
  {
    bd.HO();
    au.Hx();
    c.FB().HH("@qqim");
    au.Hx();
    c.FB().abu("qmessage");
  }
  
  public final void bh(boolean paramBoolean)
  {
    e.d.a(Integer.valueOf(36), this.ncC);
    e.d.a(Integer.valueOf(39), this.ncC);
    com.tencent.mm.sdk.b.a.udP.c(this.ncD);
    com.tencent.mm.sdk.b.a.udP.c(this.ncE);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt)
  {
    y.d("MicroMsg.SubCoreQMsg", "clear plugin");
    if ((paramInt & 0x20) != 0) {
      btm();
    }
  }
  
  public final void onAccountRelease()
  {
    e.d.b(Integer.valueOf(36), this.ncC);
    e.d.b(Integer.valueOf(39), this.ncC);
    com.tencent.mm.sdk.b.a.udP.d(this.ncD);
    com.tencent.mm.sdk.b.a.udP.d(this.ncE);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.g
 * JD-Core Version:    0.7.0.1
 */