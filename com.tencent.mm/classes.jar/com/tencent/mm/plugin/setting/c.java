package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class c
  implements at
{
  private n.b qEt;
  private bz.a qEu;
  private o qEv;
  private bz.a qEw;
  private o qEx;
  
  public c()
  {
    AppMethodBeat.i(126830);
    this.qEt = new n.b()
    {
      public final void a(int paramAnonymousInt, final n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(126825);
        if (paramAnonymousInt == 2)
        {
          paramAnonymousn = (String)paramAnonymousObject;
          paramAnonymousObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arq(paramAnonymousn);
          if ((paramAnonymousObject != null) && (!com.tencent.mm.n.a.je(paramAnonymousObject.field_type)) && (paramAnonymousObject.NU()) && (!paramAnonymousObject.NV())) {
            com.tencent.mm.kernel.g.RO().o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(126824);
                Object localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(paramAnonymousn);
                if ((localObject != null) && (!com.tencent.mm.n.a.je(((aq)localObject).field_type)) && (((ad)localObject).NU()) && (!((ad)localObject).NV()))
                {
                  localObject = new bi();
                  ((bi)localObject).hL(0);
                  ((bi)localObject).kj(paramAnonymousn);
                  ((bi)localObject).setStatus(6);
                  ((bi)localObject).setContent(ah.getContext().getString(2131303281));
                  ((bi)localObject).fQ(bf.x(paramAnonymousn, System.currentTimeMillis() / 1000L));
                  ((bi)localObject).setType(10000);
                  ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Z((bi)localObject);
                  ab.i("MicroMsg.SubCoreSetting", "insert chatcontact verify sysmsg. %s", new Object[] { paramAnonymousn });
                }
                AppMethodBeat.o(126824);
              }
            }, 5000L);
          }
        }
        AppMethodBeat.o(126825);
      }
    };
    this.qEu = new c.2(this);
    this.qEv = new c.3(this);
    this.qEw = new c.4(this);
    this.qEx = new c.5(this);
    ab.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
    AppMethodBeat.o(126830);
  }
  
  static void cjP()
  {
    AppMethodBeat.i(126835);
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yGu, Long.valueOf(0L));
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yGv, "");
    com.tencent.mm.x.c.PJ().y(262157, false);
    AppMethodBeat.o(126835);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(126831);
    ab.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
    AppMethodBeat.o(126831);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(126832);
    ab.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().a("redpointinfo", this.qEu, true);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().a("crowdtest", this.qEw, true);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.qEv);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.qEx);
    int i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yGt, Integer.valueOf(d.whH))).intValue();
    long l = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yGu, Long.valueOf(0L))).longValue();
    if ((i <= d.whH) || (l < System.currentTimeMillis())) {
      cjP();
    }
    if (paramBoolean)
    {
      i = r.Zy();
      com.tencent.mm.kernel.g.RL().Ru().set(34, Integer.valueOf(i & 0xFFEFFFFF & 0xFFBFFFFF));
      Object localObject1 = new bmq();
      ((bmq)localObject1).wmt = 1048576;
      ((bmq)localObject1).xBb = 0;
      ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new j.a(39, (com.tencent.mm.bv.a)localObject1));
      localObject1 = new bmq();
      ((bmq)localObject1).wmt = 4194304;
      ((bmq)localObject1).xBb = 0;
      ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new j.a(39, (com.tencent.mm.bv.a)localObject1));
      ab.i("MicroMsg.SubCoreSetting", "set void default open");
      if (!v.K(ah.getContext()).areNotificationsEnabled())
      {
        ab.w("MicroMsg.SubCoreSetting", "sys notification disable！");
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(500L, 18L, 1L, false);
      }
      ab.i("MicroMsg.SubCoreSetting", "is update from %s", new Object[] { Integer.valueOf(com.tencent.mm.kernel.g.RJ().eGW.eIk) });
      Object localObject2 = bx.fnO.abf();
      if (((Set)localObject2).size() == 2)
      {
        localObject1 = new String[2];
        localObject2 = ((Set)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localObject1[i] = bx.fnO.getString(str, "login_user_name");
          i += 1;
        }
        if ((!bo.Q(new String[] { localObject1[0], localObject1[1] })) && (localObject1[0].equals(localObject1[1])))
        {
          ab.w("MicroMsg.SubCoreSetting", "old dirty data!!!");
          bx.fnO.pG(localObject1[0]);
          bx.fnO.pG(localObject1[1]);
        }
      }
    }
    if ((com.tencent.mm.m.g.Nq().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1) && ((r.Zr() & 0x20) == 0)) {
      ((j)com.tencent.mm.kernel.g.E(j.class)).YA().a(this.qEt);
    }
    AppMethodBeat.o(126832);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(126834);
    ab.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().b("redpointinfo", this.qEu, true);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().b("crowdtest", this.qEw, true);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.qEv);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.qEx);
    ((j)com.tencent.mm.kernel.g.E(j.class)).YA().b(this.qEt);
    AppMethodBeat.o(126834);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(126833);
    ab.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    AppMethodBeat.o(126833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c
 * JD-Core Version:    0.7.0.1
 */