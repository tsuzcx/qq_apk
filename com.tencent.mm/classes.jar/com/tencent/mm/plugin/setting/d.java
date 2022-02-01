package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
  implements az
{
  private static List<wu> ySF = null;
  private n.b ySG;
  private cf.a ySH;
  private q ySI;
  private cf.a ySJ;
  private q ySK;
  
  public d()
  {
    AppMethodBeat.i(73751);
    this.ySG = new n.b()
    {
      public final void a(int paramAnonymousInt, final n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(73746);
        if (paramAnonymousInt == 2)
        {
          paramAnonymousn = (String)paramAnonymousObject;
          paramAnonymousObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUG(paramAnonymousn);
          if ((paramAnonymousObject != null) && (!com.tencent.mm.contact.c.lO(paramAnonymousObject.field_type)) && (paramAnonymousObject.adt()) && (!paramAnonymousObject.adu())) {
            com.tencent.mm.kernel.g.ajU().n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(73745);
                Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramAnonymousn);
                if ((localObject != null) && (!com.tencent.mm.contact.c.lO(((aw)localObject).field_type)) && (((an)localObject).adt()) && (!((an)localObject).adu()))
                {
                  localObject = new bv();
                  ((bv)localObject).kt(0);
                  ((bv)localObject).ui(paramAnonymousn);
                  ((bv)localObject).setStatus(6);
                  ((bv)localObject).setContent(ak.getContext().getString(2131763250));
                  ((bv)localObject).qN(bl.B(paramAnonymousn, System.currentTimeMillis() / 1000L));
                  ((bv)localObject).setType(10000);
                  ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ar((bv)localObject);
                  ae.i("MicroMsg.SubCoreSetting", "insert chatcontact verify sysmsg. %s", new Object[] { paramAnonymousn });
                }
                AppMethodBeat.o(73745);
              }
            }, 5000L);
          }
        }
        AppMethodBeat.o(73746);
      }
    };
    this.ySH = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(73747);
        paramAnonymousa = z.a(paramAnonymousa.gte.FNI);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ae.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
          AppMethodBeat.o(73747);
          return;
        }
        paramAnonymousa = bx.M(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(73747);
          return;
        }
        String str = bu.bI((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.path"), "");
        int i = bu.aSB(bu.bI((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
        bu.aSB(bu.bI((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
        if (bu.isNullOrNil(str))
        {
          AppMethodBeat.o(73747);
          return;
        }
        if (str.equals("my_setting_privaty_recentOption"))
        {
          if (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISI, Integer.valueOf(0))).intValue() >= i)
          {
            AppMethodBeat.o(73747);
            return;
          }
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISI, Integer.valueOf(i));
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISJ, Integer.valueOf(i));
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISL, Integer.valueOf(i));
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISN, Integer.valueOf(i));
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISP, Integer.valueOf(i));
          com.tencent.mm.y.c.ahI().x(266260, true);
          AppMethodBeat.o(73747);
          return;
        }
        if (str.equals("my_setting_plugin_switch"))
        {
          paramAnonymousa = bu.bI((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.ext"), "");
          if (bu.isNullOrNil(paramAnonymousa))
          {
            AppMethodBeat.o(73747);
            return;
          }
          if (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITM, Integer.valueOf(0))).intValue() >= i)
          {
            AppMethodBeat.o(73747);
            return;
          }
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITM, Integer.valueOf(i));
          str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITN, "");
          if (bu.isNullOrNil(str)) {
            break label414;
          }
          paramAnonymousa = paramAnonymousa.concat(",").concat(str);
        }
        label414:
        for (;;)
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITN, paramAnonymousa);
          com.tencent.mm.y.c.ahI().x(262158, true);
          AppMethodBeat.o(73747);
          return;
        }
      }
      
      public final void a(com.tencent.mm.ak.e.c paramAnonymousc) {}
    };
    this.ySI = new d.3(this);
    this.ySJ = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(73749);
        paramAnonymousa = z.a(paramAnonymousa.gte.FNI);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ae.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
          AppMethodBeat.o(73749);
          return;
        }
        paramAnonymousa = bx.M(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(73749);
          return;
        }
        int i = bu.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.$clientversion"), 0);
        if (i <= com.tencent.mm.protocal.d.FFH)
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
          d.dQE();
          AppMethodBeat.o(73749);
          return;
        }
        str1 = (String)paramAnonymousa.get(".sysmsg.crowdtest.apply.link");
        str2 = (String)paramAnonymousa.get(".sysmsg.crowdtest.feedback.link");
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITH, Integer.valueOf(i));
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITI, Long.valueOf(l1));
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITJ, str1);
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITK, str2);
        i = bu.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
        paramAnonymousa = com.tencent.mm.y.c.ahI();
        if (i > 0) {}
        for (bool = true;; bool = false)
        {
          paramAnonymousa.x(262157, bool);
          if (i < 3) {
            com.tencent.mm.y.c.ahI().cK(262157, 266261);
          }
          if (i < 2) {
            com.tencent.mm.y.c.ahI().cK(262157, 266262);
          }
          AppMethodBeat.o(73749);
          return;
        }
      }
      
      public final void a(com.tencent.mm.ak.e.c paramAnonymousc) {}
    };
    this.ySK = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
      {
        AppMethodBeat.i(73750);
        if (paramAnonymousMap != null)
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.security");
          if (!bu.isNullOrNil(paramAnonymousString)) {
            try
            {
              int i = bu.getInt(paramAnonymousString, 0);
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXL, Integer.valueOf(i));
              if (i != 0)
              {
                com.tencent.mm.y.c.ahI().b(am.a.IXJ, true);
                AppMethodBeat.o(73750);
                return;
              }
              com.tencent.mm.y.c.ahI().b(am.a.IXJ, false);
              AppMethodBeat.o(73750);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              ae.printErrStackTrace("MicroMsg.SubCoreSetting", paramAnonymousString, "device protect security value is not number!", new Object[0]);
            }
          }
        }
        AppMethodBeat.o(73750);
      }
    };
    ae.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
    AppMethodBeat.o(73751);
  }
  
  private static void dQC()
  {
    AppMethodBeat.i(73756);
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITI, Long.valueOf(0L));
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITJ, "");
    com.tencent.mm.y.c.ahI().x(262157, false);
    AppMethodBeat.o(73756);
  }
  
  public static List<wu> dQD()
  {
    return ySF;
  }
  
  public static void fG(List<wu> paramList)
  {
    ySF = paramList;
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(73752);
    ae.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
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
    ae.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("redpointinfo", this.ySH, true);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("crowdtest", this.ySJ, true);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.ySI);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.ySK);
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITH, Integer.valueOf(com.tencent.mm.protocal.d.FFH))).intValue();
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITI, Long.valueOf(0L))).longValue();
    if ((i <= com.tencent.mm.protocal.d.FFH) || (l < System.currentTimeMillis())) {
      dQC();
    }
    i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITL, Integer.valueOf(0))).intValue();
    ae.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset flavorBlueCV: " + i + ",CLIENT_VERSION:" + com.tencent.mm.protocal.d.FFH);
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_BLUE) && (i < com.tencent.mm.protocal.d.FFH))
    {
      com.tencent.mm.y.c.ahI().x(262164, true);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITL, Integer.valueOf(com.tencent.mm.protocal.d.FFH));
    }
    if (paramBoolean)
    {
      i = com.tencent.mm.model.v.aAO();
      com.tencent.mm.kernel.g.ajR().ajA().set(34, Integer.valueOf(i & 0xFFEFFFFF & 0xFFBFFFFF));
      Object localObject1 = new clm();
      ((clm)localObject1).FKG = 1048576;
      ((clm)localObject1).HxH = 0;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(new k.a(39, (com.tencent.mm.bw.a)localObject1));
      localObject1 = new clm();
      ((clm)localObject1).FKG = 4194304;
      ((clm)localObject1).HxH = 0;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(new k.a(39, (com.tencent.mm.bw.a)localObject1));
      ae.i("MicroMsg.SubCoreSetting", "set void default open");
      if (!android.support.v4.app.v.O(ak.getContext()).areNotificationsEnabled())
      {
        ae.w("MicroMsg.SubCoreSetting", "sys notification disable！");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 18L, 1L, false);
      }
      ae.i("MicroMsg.SubCoreSetting", "is update from %s", new Object[] { Integer.valueOf(com.tencent.mm.kernel.g.ajP().gDa.gEp) });
      Object localObject2 = cd.hLa.aCQ();
      if (((Set)localObject2).size() == 2)
      {
        localObject1 = new String[2];
        localObject2 = ((Set)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localObject1[i] = cd.hLa.getString(str, "login_user_name");
          i += 1;
        }
        if ((!bu.V(new String[] { localObject1[0], localObject1[1] })) && (localObject1[0].equals(localObject1[1])))
        {
          ae.w("MicroMsg.SubCoreSetting", "old dirty data!!!");
          cd.hLa.Cb(localObject1[0]);
          cd.hLa.Cb(localObject1[1]);
        }
      }
    }
    if ((com.tencent.mm.n.g.acL().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1) && ((com.tencent.mm.model.v.aAG() & 0x20) == 0)) {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().a(this.ySG);
    }
    AppMethodBeat.o(73753);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(73755);
    ae.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("redpointinfo", this.ySH, true);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("crowdtest", this.ySJ, true);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.ySI);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.ySK);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().b(this.ySG);
    AppMethodBeat.o(73755);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(73754);
    ae.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    AppMethodBeat.o(73754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.d
 * JD-Core Version:    0.7.0.1
 */