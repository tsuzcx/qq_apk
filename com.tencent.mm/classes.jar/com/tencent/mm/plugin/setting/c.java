package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import android.support.v4.app.aa;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class c
  implements ar
{
  private o nQA = new c.5(this);
  private m.b nQw = new m.b()
  {
    public final void a(int paramAnonymousInt, m paramAnonymousm, Object paramAnonymousObject)
    {
      if (paramAnonymousInt == 2)
      {
        paramAnonymousm = (String)paramAnonymousObject;
        paramAnonymousObject = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abf(paramAnonymousm);
        if ((paramAnonymousObject != null) && (!com.tencent.mm.n.a.gR(paramAnonymousObject.field_type)) && (paramAnonymousObject.Be()) && (!paramAnonymousObject.Bf())) {
          com.tencent.mm.kernel.g.DS().k(new c.1.1(this, paramAnonymousm), 5000L);
        }
      }
    }
  };
  private bx.a nQx = new c.2(this);
  private o nQy = new c.3(this);
  private bx.a nQz = new c.4(this);
  
  public c()
  {
    y.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
  }
  
  static void byF()
  {
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uwm, Long.valueOf(0L));
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uwn, "");
    com.tencent.mm.y.c.BS().w(262157, false);
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().a("redpointinfo", this.nQx, true);
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().a("crowdtest", this.nQz, true);
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.nQy);
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.nQA);
    int i = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uwl, Integer.valueOf(d.spa))).intValue();
    long l = ((Long)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uwm, Long.valueOf(0L))).longValue();
    if ((i <= d.spa) || (l < System.currentTimeMillis())) {
      byF();
    }
    if (paramBoolean)
    {
      i = q.Gu();
      com.tencent.mm.kernel.g.DP().Dz().o(34, Integer.valueOf(i & 0xFFEFFFFF & 0xFFBFFFFF));
      Object localObject1 = new bev();
      ((bev)localObject1).stP = 1048576;
      ((bev)localObject1).tzI = 0;
      ((j)com.tencent.mm.kernel.g.r(j.class)).Fv().b(new i.a(39, (com.tencent.mm.bv.a)localObject1));
      localObject1 = new bev();
      ((bev)localObject1).stP = 4194304;
      ((bev)localObject1).tzI = 0;
      ((j)com.tencent.mm.kernel.g.r(j.class)).Fv().b(new i.a(39, (com.tencent.mm.bv.a)localObject1));
      y.i("MicroMsg.SubCoreSetting", "set void default open");
      if (!aa.L(ae.getContext()).areNotificationsEnabled())
      {
        y.w("MicroMsg.SubCoreSetting", "sys notification disable！");
        com.tencent.mm.plugin.report.service.h.nFQ.a(500L, 18L, 1L, false);
      }
      y.i("MicroMsg.SubCoreSetting", "is update from %s", new Object[] { Integer.valueOf(com.tencent.mm.kernel.g.DN().dJx.dKM) });
      Object localObject2 = bv.dXJ.Ii();
      if (((Set)localObject2).size() == 2)
      {
        localObject1 = new String[2];
        localObject2 = ((Set)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localObject1[i] = bv.dXJ.getString(str, "login_user_name");
          i += 1;
        }
        if ((!bk.H(new String[] { localObject1[0], localObject1[1] })) && (localObject1[0].equals(localObject1[1])))
        {
          y.w("MicroMsg.SubCoreSetting", "old dirty data!!!");
          bv.dXJ.iS(localObject1[0]);
          bv.dXJ.iS(localObject1[1]);
        }
      }
    }
    if ((com.tencent.mm.m.g.AA().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1) && ((q.Gn() & 0x20) == 0)) {
      ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().a(this.nQw);
    }
  }
  
  public final void bi(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
  }
  
  public final void gf(int paramInt)
  {
    y.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
  }
  
  public final void onAccountRelease()
  {
    y.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().b("redpointinfo", this.nQx, true);
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().b("crowdtest", this.nQz, true);
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.nQy);
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.nQA);
    ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().b(this.nQw);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c
 * JD-Core Version:    0.7.0.1
 */