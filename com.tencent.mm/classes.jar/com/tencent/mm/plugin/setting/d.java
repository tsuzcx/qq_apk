package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.y.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
  implements bd
{
  private static List<ye> CXv = null;
  private q CXA;
  private MStorageEx.IOnStorageChange CXw;
  private cj.a CXx;
  private q CXy;
  private cj.a CXz;
  
  public d()
  {
    AppMethodBeat.i(73751);
    this.CXw = new d.1(this);
    this.CXx = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(73747);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.heO.KHn);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          Log.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
          AppMethodBeat.o(73747);
          return;
        }
        paramAnonymousa = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(73747);
          return;
        }
        String str = Util.nullAs((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.path"), "");
        int i = Util.safeParseInt(Util.nullAs((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
        Util.safeParseInt(Util.nullAs((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
        if (Util.isNullOrNil(str))
        {
          AppMethodBeat.o(73747);
          return;
        }
        if (str.equals("my_setting_privaty_recentOption"))
        {
          if (((Integer)g.aAh().azQ().get(ar.a.OaK, Integer.valueOf(0))).intValue() >= i)
          {
            AppMethodBeat.o(73747);
            return;
          }
          g.aAh().azQ().set(ar.a.OaK, Integer.valueOf(i));
          g.aAh().azQ().set(ar.a.OaL, Integer.valueOf(i));
          g.aAh().azQ().set(ar.a.OaN, Integer.valueOf(i));
          g.aAh().azQ().set(ar.a.OaP, Integer.valueOf(i));
          g.aAh().azQ().set(ar.a.OaR, Integer.valueOf(i));
          c.axV().B(266260, true);
          AppMethodBeat.o(73747);
          return;
        }
        if (str.equals("my_setting_plugin_switch"))
        {
          paramAnonymousa = Util.nullAs((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.ext"), "");
          if (Util.isNullOrNil(paramAnonymousa))
          {
            AppMethodBeat.o(73747);
            return;
          }
          if (((Integer)g.aAh().azQ().get(ar.a.Oca, Integer.valueOf(0))).intValue() >= i)
          {
            AppMethodBeat.o(73747);
            return;
          }
          g.aAh().azQ().set(ar.a.Oca, Integer.valueOf(i));
          str = (String)g.aAh().azQ().get(ar.a.Ocb, "");
          if (Util.isNullOrNil(str)) {
            break label415;
          }
          paramAnonymousa = paramAnonymousa.concat(",").concat(str);
        }
        label415:
        for (;;)
        {
          g.aAh().azQ().set(ar.a.Ocb, paramAnonymousa);
          c.axV().B(262158, true);
          AppMethodBeat.o(73747);
          return;
        }
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.CXy = new d.3(this);
    this.CXz = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(73749);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.heO.KHn);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          Log.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
          AppMethodBeat.o(73749);
          return;
        }
        paramAnonymousa = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(73749);
          return;
        }
        int i = Util.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.$clientversion"), 0);
        if (i <= com.tencent.mm.protocal.d.KyO)
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
          label124:
          String str2;
          boolean bool;
          break label124;
        }
        if (l1 < System.currentTimeMillis())
        {
          d.eSF();
          AppMethodBeat.o(73749);
          return;
        }
        str1 = (String)paramAnonymousa.get(".sysmsg.crowdtest.apply.link");
        str2 = (String)paramAnonymousa.get(".sysmsg.crowdtest.feedback.link");
        g.aAh().azQ().set(ar.a.ObV, Integer.valueOf(i));
        g.aAh().azQ().set(ar.a.ObW, Long.valueOf(l1));
        g.aAh().azQ().set(ar.a.ObX, str1);
        g.aAh().azQ().set(ar.a.ObY, str2);
        i = Util.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
        paramAnonymousa = c.axV();
        if (i > 0) {}
        for (bool = true;; bool = false)
        {
          paramAnonymousa.B(262157, bool);
          if (i < 3) {
            c.axV().cQ(262157, 266261);
          }
          if (i < 2) {
            c.axV().cQ(262157, 266262);
          }
          AppMethodBeat.o(73749);
          return;
        }
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.CXA = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(73750);
        if (paramAnonymousMap != null)
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.security");
          if (!Util.isNullOrNil(paramAnonymousString)) {
            try
            {
              int i = Util.getInt(paramAnonymousString, 0);
              g.aAh().azQ().set(ar.a.Ogi, Integer.valueOf(i));
              if (i != 0)
              {
                c.axV().b(ar.a.Ogg, true);
                AppMethodBeat.o(73750);
                return;
              }
              c.axV().b(ar.a.Ogg, false);
              AppMethodBeat.o(73750);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              Log.printErrStackTrace("MicroMsg.SubCoreSetting", paramAnonymousString, "device protect security value is not number!", new Object[0]);
            }
          }
        }
        AppMethodBeat.o(73750);
      }
    };
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
    AppMethodBeat.o(73751);
  }
  
  private static void eSD()
  {
    AppMethodBeat.i(73756);
    g.aAh().azQ().set(ar.a.ObW, Long.valueOf(0L));
    g.aAh().azQ().set(ar.a.ObX, "");
    c.axV().B(262157, false);
    AppMethodBeat.o(73756);
  }
  
  public static List<ye> eSE()
  {
    return CXv;
  }
  
  public static void gF(List<ye> paramList)
  {
    CXv = paramList;
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(73752);
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
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
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("redpointinfo", this.CXx, true);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("crowdtest", this.CXz, true);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.CXy);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.CXA);
    int i = ((Integer)g.aAh().azQ().get(ar.a.ObV, Integer.valueOf(com.tencent.mm.protocal.d.KyO))).intValue();
    long l = ((Long)g.aAh().azQ().get(ar.a.ObW, Long.valueOf(0L))).longValue();
    if ((i <= com.tencent.mm.protocal.d.KyO) || (l < System.currentTimeMillis())) {
      eSD();
    }
    i = ((Integer)g.aAh().azQ().get(ar.a.ObZ, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset flavorBlueCV: " + i + ",CLIENT_VERSION:" + com.tencent.mm.protocal.d.KyO);
    if ((BuildInfo.IS_FLAVOR_BLUE) && (i < com.tencent.mm.protocal.d.KyO))
    {
      c.axV().B(262164, true);
      g.aAh().azQ().set(ar.a.ObZ, Integer.valueOf(com.tencent.mm.protocal.d.KyO));
    }
    if (paramBoolean)
    {
      i = com.tencent.mm.model.z.aUl();
      g.aAh().azQ().set(34, Integer.valueOf(i & 0xFFEFFFFF & 0xFFBFFFFF));
      Object localObject1 = new dbw();
      ((dbw)localObject1).KEc = 1048576;
      ((dbw)localObject1).MGK = 0;
      ((l)g.af(l.class)).aSM().d(new k.a(39, (com.tencent.mm.bw.a)localObject1));
      localObject1 = new dbw();
      ((dbw)localObject1).KEc = 4194304;
      ((dbw)localObject1).MGK = 0;
      ((l)g.af(l.class)).aSM().d(new k.a(39, (com.tencent.mm.bw.a)localObject1));
      Log.i("MicroMsg.SubCoreSetting", "set void default open");
      if (!v.P(MMApplicationContext.getContext()).areNotificationsEnabled())
      {
        Log.w("MicroMsg.SubCoreSetting", "sys notification disable！");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 18L, 1L, false);
      }
      Log.i("MicroMsg.SubCoreSetting", "is update from %s", new Object[] { Integer.valueOf(g.aAf().hpO.hrd) });
      Object localObject2 = ch.iFO.aWo();
      if (((Set)localObject2).size() == 2)
      {
        localObject1 = new String[2];
        localObject2 = ((Set)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localObject1[i] = ch.iFO.getString(str, "login_user_name");
          i += 1;
        }
        if ((!Util.isNullOrNil(new String[] { localObject1[0], localObject1[1] })) && (localObject1[0].equals(localObject1[1])))
        {
          Log.w("MicroMsg.SubCoreSetting", "old dirty data!!!");
          ch.iFO.KH(localObject1[0]);
          ch.iFO.KH(localObject1[1]);
        }
      }
    }
    if ((com.tencent.mm.n.h.aqJ().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1) && ((com.tencent.mm.model.z.aUc() & 0x20) == 0)) {
      ((l)g.af(l.class)).aSN().add(this.CXw);
    }
    AppMethodBeat.o(73753);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(73755);
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("redpointinfo", this.CXx, true);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("crowdtest", this.CXz, true);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.CXy);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.CXA);
    ((l)g.af(l.class)).aSN().remove(this.CXw);
    AppMethodBeat.o(73755);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(73754);
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    AppMethodBeat.o(73754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.d
 * JD-Core Version:    0.7.0.1
 */