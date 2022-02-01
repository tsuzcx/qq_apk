package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.u;
import com.tencent.mm.n.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.e.k;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c
  implements aw
{
  private static List<ui> wcJ = null;
  private n.b wcK;
  private cc.a wcL;
  private p wcM;
  private cc.a wcN;
  private p wcO;
  
  public c()
  {
    AppMethodBeat.i(73751);
    this.wcK = new n.b()
    {
      public final void a(int paramAnonymousInt, final n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(73746);
        if (paramAnonymousInt == 2)
        {
          paramAnonymousn = (String)paramAnonymousObject;
          paramAnonymousObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHS(paramAnonymousn);
          if ((paramAnonymousObject != null) && (!b.ls(paramAnonymousObject.field_type)) && (paramAnonymousObject.ZK()) && (!paramAnonymousObject.ZL())) {
            com.tencent.mm.kernel.g.afE().m(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(73745);
                Object localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramAnonymousn);
                if ((localObject != null) && (!b.ls(((au)localObject).field_type)) && (((af)localObject).ZK()) && (!((af)localObject).ZL()))
                {
                  localObject = new bl();
                  ((bl)localObject).jV(0);
                  ((bl)localObject).nY(paramAnonymousn);
                  ((bl)localObject).setStatus(6);
                  ((bl)localObject).setContent(aj.getContext().getString(2131763250));
                  ((bl)localObject).kY(bi.y(paramAnonymousn, System.currentTimeMillis() / 1000L));
                  ((bl)localObject).setType(10000);
                  ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().an((bl)localObject);
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
    this.wcL = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(73747);
        paramAnonymousa = z.a(paramAnonymousa.fTo.Cxz);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ad.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
          AppMethodBeat.o(73747);
          return;
        }
        paramAnonymousa = bw.K(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(73747);
          return;
        }
        String str = bt.by((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.path"), "");
        int i = bt.aGh(bt.by((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
        bt.aGh(bt.by((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
        if (bt.isNullOrNil(str))
        {
          AppMethodBeat.o(73747);
          return;
        }
        if (str.equals("my_setting_privaty_recentOption"))
        {
          if (((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fod, Integer.valueOf(0))).intValue() >= i)
          {
            AppMethodBeat.o(73747);
            return;
          }
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fod, Integer.valueOf(i));
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Foe, Integer.valueOf(i));
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fog, Integer.valueOf(i));
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Foi, Integer.valueOf(i));
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fok, Integer.valueOf(i));
          com.tencent.mm.z.c.adr().x(266260, true);
          AppMethodBeat.o(73747);
          return;
        }
        if (str.equals("my_setting_plugin_switch"))
        {
          paramAnonymousa = bt.by((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.ext"), "");
          if (bt.isNullOrNil(paramAnonymousa))
          {
            AppMethodBeat.o(73747);
            return;
          }
          if (((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fpg, Integer.valueOf(0))).intValue() >= i)
          {
            AppMethodBeat.o(73747);
            return;
          }
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpg, Integer.valueOf(i));
          str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fph, "");
          if (bt.isNullOrNil(str)) {
            break label414;
          }
          paramAnonymousa = paramAnonymousa.concat(",").concat(str);
        }
        label414:
        for (;;)
        {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fph, paramAnonymousa);
          com.tencent.mm.z.c.adr().x(262158, true);
          AppMethodBeat.o(73747);
          return;
        }
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.wcM = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(73748);
        if (paramAnonymousMap != null)
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.showtrustedfriends.wording");
          if (!bt.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousMap = new Intent();
            paramAnonymousMap.putExtra(e.k.FIh, paramAnonymousString);
            com.tencent.mm.bs.d.b(aj.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", paramAnonymousMap);
          }
        }
        AppMethodBeat.o(73748);
      }
    };
    this.wcN = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(73749);
        paramAnonymousa = z.a(paramAnonymousa.fTo.Cxz);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ad.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
          AppMethodBeat.o(73749);
          return;
        }
        paramAnonymousa = bw.K(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(73749);
          return;
        }
        int i = bt.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.$clientversion"), 0);
        if (i <= com.tencent.mm.protocal.d.CpK)
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
          c.dnx();
          AppMethodBeat.o(73749);
          return;
        }
        str1 = (String)paramAnonymousa.get(".sysmsg.crowdtest.apply.link");
        str2 = (String)paramAnonymousa.get(".sysmsg.crowdtest.feedback.link");
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpc, Integer.valueOf(i));
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpd, Long.valueOf(l1));
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpe, str1);
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpf, str2);
        i = bt.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
        paramAnonymousa = com.tencent.mm.z.c.adr();
        if (i > 0) {}
        for (bool = true;; bool = false)
        {
          paramAnonymousa.x(262157, bool);
          if (i < 3) {
            com.tencent.mm.z.c.adr().cK(262157, 266261);
          }
          if (i < 2) {
            com.tencent.mm.z.c.adr().cK(262157, 266262);
          }
          AppMethodBeat.o(73749);
          return;
        }
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.wcO = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(73750);
        if (paramAnonymousMap != null)
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.security");
          if (!bt.isNullOrNil(paramAnonymousString)) {
            try
            {
              int i = bt.getInt(paramAnonymousString, 0);
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsV, Integer.valueOf(i));
              if (i != 0)
              {
                com.tencent.mm.z.c.adr().b(ae.a.FsT, true);
                AppMethodBeat.o(73750);
                return;
              }
              com.tencent.mm.z.c.adr().b(ae.a.FsT, false);
              AppMethodBeat.o(73750);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              ad.printErrStackTrace("MicroMsg.SubCoreSetting", paramAnonymousString, "device protect security value is not number!", new Object[0]);
            }
          }
        }
        AppMethodBeat.o(73750);
      }
    };
    ad.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
    AppMethodBeat.o(73751);
  }
  
  private static void dnv()
  {
    AppMethodBeat.i(73756);
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpd, Long.valueOf(0L));
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpe, "");
    com.tencent.mm.z.c.adr().x(262157, false);
    AppMethodBeat.o(73756);
  }
  
  public static List<ui> dnw()
  {
    return wcJ;
  }
  
  public static void fd(List<ui> paramList)
  {
    wcJ = paramList;
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
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("redpointinfo", this.wcL, true);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("crowdtest", this.wcN, true);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.wcM);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.wcO);
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fpc, Integer.valueOf(com.tencent.mm.protocal.d.CpK))).intValue();
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fpd, Long.valueOf(0L))).longValue();
    if ((i <= com.tencent.mm.protocal.d.CpK) || (l < System.currentTimeMillis())) {
      dnv();
    }
    if (paramBoolean)
    {
      i = u.aqS();
      com.tencent.mm.kernel.g.afB().afk().set(34, Integer.valueOf(i & 0xFFEFFFFF & 0xFFBFFFFF));
      Object localObject1 = new cau();
      ((cau)localObject1).CuI = 1048576;
      ((cau)localObject1).DXj = 0;
      ((k)com.tencent.mm.kernel.g.ab(k.class)).apL().c(new j.a(39, (com.tencent.mm.bx.a)localObject1));
      localObject1 = new cau();
      ((cau)localObject1).CuI = 4194304;
      ((cau)localObject1).DXj = 0;
      ((k)com.tencent.mm.kernel.g.ab(k.class)).apL().c(new j.a(39, (com.tencent.mm.bx.a)localObject1));
      ad.i("MicroMsg.SubCoreSetting", "set void default open");
      if (!v.M(aj.getContext()).areNotificationsEnabled())
      {
        ad.w("MicroMsg.SubCoreSetting", "sys notification disable！");
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(500L, 18L, 1L, false);
      }
      ad.i("MicroMsg.SubCoreSetting", "is update from %s", new Object[] { Integer.valueOf(com.tencent.mm.kernel.g.afz().gcd.gds) });
      Object localObject2 = ca.gPq.asG();
      if (((Set)localObject2).size() == 2)
      {
        localObject1 = new String[2];
        localObject2 = ((Set)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localObject1[i] = ca.gPq.getString(str, "login_user_name");
          i += 1;
        }
        if ((!bt.T(new String[] { localObject1[0], localObject1[1] })) && (localObject1[0].equals(localObject1[1])))
        {
          ad.w("MicroMsg.SubCoreSetting", "old dirty data!!!");
          ca.gPq.uu(localObject1[0]);
          ca.gPq.uu(localObject1[1]);
        }
      }
    }
    if ((com.tencent.mm.m.g.Zd().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1) && ((u.aqK() & 0x20) == 0)) {
      ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().a(this.wcK);
    }
    AppMethodBeat.o(73753);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(73755);
    ad.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("redpointinfo", this.wcL, true);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("crowdtest", this.wcN, true);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.wcM);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.wcO);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().b(this.wcK);
    AppMethodBeat.o(73755);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(73754);
    ad.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    AppMethodBeat.o(73754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c
 * JD-Core Version:    0.7.0.1
 */