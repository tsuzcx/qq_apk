package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.u;
import com.tencent.mm.o.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c
  implements ax
{
  private static List<wr> yCC = null;
  private n.b yCD;
  private cd.a yCE;
  private q yCF;
  private cd.a yCG;
  private q yCH;
  
  public c()
  {
    AppMethodBeat.i(73751);
    this.yCD = new n.b()
    {
      public final void a(int paramAnonymousInt, final n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(73746);
        if (paramAnonymousInt == 2)
        {
          paramAnonymousn = (String)paramAnonymousObject;
          paramAnonymousObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTf(paramAnonymousn);
          if ((paramAnonymousObject != null) && (!b.lM(paramAnonymousObject.field_type)) && (paramAnonymousObject.adi()) && (!paramAnonymousObject.adj())) {
            com.tencent.mm.kernel.g.ajF().n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(73745);
                Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramAnonymousn);
                if ((localObject != null) && (!b.lM(((aw)localObject).field_type)) && (((am)localObject).adi()) && (!((am)localObject).adj()))
                {
                  localObject = new bu();
                  ((bu)localObject).kr(0);
                  ((bu)localObject).tN(paramAnonymousn);
                  ((bu)localObject).setStatus(6);
                  ((bu)localObject).setContent(aj.getContext().getString(2131763250));
                  ((bu)localObject).qA(bj.B(paramAnonymousn, System.currentTimeMillis() / 1000L));
                  ((bu)localObject).setType(10000);
                  ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().as((bu)localObject);
                  ad.i("MicroMsg.SubCoreSetting", "insert chatcontact verify sysmsg. %s", new Object[] { paramAnonymousn });
                }
                AppMethodBeat.o(73745);
              }
            }, 5000L);
          }
        }
        AppMethodBeat.o(73746);
      }
    };
    this.yCE = new c.2(this);
    this.yCF = new c.3(this);
    this.yCG = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(73749);
        paramAnonymousa = z.a(paramAnonymousa.gqE.Fvk);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ad.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
          AppMethodBeat.o(73749);
          return;
        }
        paramAnonymousa = bw.M(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(73749);
          return;
        }
        int i = bt.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.$clientversion"), 0);
        if (i <= d.Fnj)
        {
          AppMethodBeat.o(73749);
          return;
        }
        long l1 = 0L;
        try
        {
          str1 = (String)paramAnonymousa.get(".sysmsg.crowdtest.apply.$expire");
          long l2 = new SimpleDateFormat("yyyy-MM-dd").parse(str1).getTime();
          l1 = l2;
        }
        catch (Exception localException)
        {
          String str1;
          label123:
          String str2;
          boolean bool;
          break label123;
        }
        if (l1 < System.currentTimeMillis())
        {
          c.dNi();
          AppMethodBeat.o(73749);
          return;
        }
        str1 = (String)paramAnonymousa.get(".sysmsg.crowdtest.apply.link");
        str2 = (String)paramAnonymousa.get(".sysmsg.crowdtest.feedback.link");
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Izj, Integer.valueOf(i));
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Izk, Long.valueOf(l1));
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Izl, str1);
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Izm, str2);
        i = bt.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
        paramAnonymousa = com.tencent.mm.z.c.aht();
        if (i > 0) {}
        for (bool = true;; bool = false)
        {
          paramAnonymousa.x(262157, bool);
          if (i < 3) {
            com.tencent.mm.z.c.aht().cK(262157, 266261);
          }
          if (i < 2) {
            com.tencent.mm.z.c.aht().cK(262157, 266262);
          }
          AppMethodBeat.o(73749);
          return;
        }
      }
      
      public final void a(com.tencent.mm.al.e.c paramAnonymousc) {}
    };
    this.yCH = new c.5(this);
    ad.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
    AppMethodBeat.o(73751);
  }
  
  private static void dNg()
  {
    AppMethodBeat.i(73756);
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Izk, Long.valueOf(0L));
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Izl, "");
    com.tencent.mm.z.c.aht().x(262157, false);
    AppMethodBeat.o(73756);
  }
  
  public static List<wr> dNh()
  {
    return yCC;
  }
  
  public static void fy(List<wr> paramList)
  {
    yCC = paramList;
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(73752);
    ad.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
    AppMethodBeat.o(73752);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(73753);
    ad.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("redpointinfo", this.yCE, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("crowdtest", this.yCG, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.yCF);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.yCH);
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Izj, Integer.valueOf(d.Fnj))).intValue();
    long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Izk, Long.valueOf(0L))).longValue();
    if ((i <= d.Fnj) || (l < System.currentTimeMillis())) {
      dNg();
    }
    if (paramBoolean)
    {
      i = u.aAy();
      com.tencent.mm.kernel.g.ajC().ajl().set(34, Integer.valueOf(i & 0xFFEFFFFF & 0xFFBFFFFF));
      Object localObject1 = new cks();
      ((cks)localObject1).Fsi = 1048576;
      ((cks)localObject1).Heh = 0;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azo().c(new k.a(39, (com.tencent.mm.bx.a)localObject1));
      localObject1 = new cks();
      ((cks)localObject1).Fsi = 4194304;
      ((cks)localObject1).Heh = 0;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azo().c(new k.a(39, (com.tencent.mm.bx.a)localObject1));
      ad.i("MicroMsg.SubCoreSetting", "set void default open");
      if (!v.N(aj.getContext()).areNotificationsEnabled())
      {
        ad.w("MicroMsg.SubCoreSetting", "sys notification disable！");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 18L, 1L, false);
      }
      ad.i("MicroMsg.SubCoreSetting", "is update from %s", new Object[] { Integer.valueOf(com.tencent.mm.kernel.g.ajA().gAt.gBI) });
      Object localObject2 = cb.hIi.aCA();
      if (((Set)localObject2).size() == 2)
      {
        localObject1 = new String[2];
        localObject2 = ((Set)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localObject1[i] = cb.hIi.getString(str, "login_user_name");
          i += 1;
        }
        if ((!bt.V(new String[] { localObject1[0], localObject1[1] })) && (localObject1[0].equals(localObject1[1])))
        {
          ad.w("MicroMsg.SubCoreSetting", "old dirty data!!!");
          cb.hIi.Bz(localObject1[0]);
          cb.hIi.Bz(localObject1[1]);
        }
      }
    }
    if ((com.tencent.mm.n.g.acA().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1) && ((u.aAq() & 0x20) == 0)) {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().a(this.yCD);
    }
    AppMethodBeat.o(73753);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(73755);
    ad.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("redpointinfo", this.yCE, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("crowdtest", this.yCG, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.yCF);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.yCH);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().b(this.yCD);
    AppMethodBeat.o(73755);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(73754);
    ad.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    AppMethodBeat.o(73754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c
 * JD-Core Version:    0.7.0.1
 */