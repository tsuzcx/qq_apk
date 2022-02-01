package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dlm;
import com.tencent.mm.protocal.protobuf.yk;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
  implements be
{
  private static List<yk> Jdb = null;
  private MStorageEx.IOnStorageChange Jdc;
  private ck.a Jdd;
  private t Jde;
  private ck.a Jdf;
  private t Jdg;
  
  public d()
  {
    AppMethodBeat.i(73751);
    this.Jdc = new d.1(this);
    this.Jdd = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(73747);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.jQG.RIF);
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
          if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VoM, Integer.valueOf(0))).intValue() >= i)
          {
            AppMethodBeat.o(73747);
            return;
          }
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoM, Integer.valueOf(i));
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoN, Integer.valueOf(i));
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoP, Integer.valueOf(i));
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoR, Integer.valueOf(i));
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoT, Integer.valueOf(i));
          c.aFn().D(266260, true);
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
          if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqd, Integer.valueOf(0))).intValue() >= i)
          {
            AppMethodBeat.o(73747);
            return;
          }
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqd, Integer.valueOf(i));
          str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqe, "");
          if (Util.isNullOrNil(str)) {
            break label415;
          }
          paramAnonymousa = paramAnonymousa.concat(",").concat(str);
        }
        label415:
        for (;;)
        {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqe, paramAnonymousa);
          c.aFn().D(262158, true);
          AppMethodBeat.o(73747);
          return;
        }
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.Jde = new d.3(this);
    this.Jdf = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(73749);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.jQG.RIF);
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
        if (i <= com.tencent.mm.protocal.d.RAD)
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
          d.fFI();
          AppMethodBeat.o(73749);
          return;
        }
        str1 = (String)paramAnonymousa.get(".sysmsg.crowdtest.apply.link");
        str2 = (String)paramAnonymousa.get(".sysmsg.crowdtest.feedback.link");
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VpY, Integer.valueOf(i));
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VpZ, Long.valueOf(l1));
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqa, str1);
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqb, str2);
        i = Util.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
        paramAnonymousa = c.aFn();
        if (i > 0) {}
        for (bool = true;; bool = false)
        {
          paramAnonymousa.D(262157, bool);
          if (i < 3) {
            c.aFn().dl(262157, 266261);
          }
          if (i < 2) {
            c.aFn().dl(262157, 266262);
          }
          AppMethodBeat.o(73749);
          return;
        }
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.Jdg = new t()
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
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vuy, Integer.valueOf(i));
              if (i != 0)
              {
                c.aFn().b(ar.a.Vuw, true);
                AppMethodBeat.o(73750);
                return;
              }
              c.aFn().b(ar.a.Vuw, false);
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
  
  private static void fFG()
  {
    AppMethodBeat.i(73756);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VpZ, Long.valueOf(0L));
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqa, "");
    c.aFn().D(262157, false);
    AppMethodBeat.o(73756);
  }
  
  public static List<yk> fFH()
  {
    return Jdb;
  }
  
  public static void hl(List<yk> paramList)
  {
    Jdb = paramList;
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
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("redpointinfo", this.Jdd, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("crowdtest", this.Jdf, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.Jde);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.Jdg);
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VpY, Integer.valueOf(com.tencent.mm.protocal.d.RAD))).intValue();
    long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VpZ, Long.valueOf(0L))).longValue();
    if ((i <= com.tencent.mm.protocal.d.RAD) || (l < System.currentTimeMillis())) {
      fFG();
    }
    i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqc, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset flavorBlueCV: " + i + ",CLIENT_VERSION:" + com.tencent.mm.protocal.d.RAD);
    if ((BuildInfo.IS_FLAVOR_BLUE) && (i < com.tencent.mm.protocal.d.RAD))
    {
      c.aFn().D(262164, true);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqc, Integer.valueOf(com.tencent.mm.protocal.d.RAD));
    }
    if (paramBoolean)
    {
      i = com.tencent.mm.model.z.bdn();
      com.tencent.mm.kernel.h.aHG().aHp().i(34, Integer.valueOf(i & 0xFFEFFFFF & 0xFFBFFFFF));
      Object localObject1 = new dlm();
      ((dlm)localObject1).RFu = 1048576;
      ((dlm)localObject1).TSy = 0;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(39, (com.tencent.mm.cd.a)localObject1));
      localObject1 = new dlm();
      ((dlm)localObject1).RFu = 4194304;
      ((dlm)localObject1).TSy = 0;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(39, (com.tencent.mm.cd.a)localObject1));
      Log.i("MicroMsg.SubCoreSetting", "set void default open");
      if (!androidx.core.app.h.M(MMApplicationContext.getContext()).gs())
      {
        Log.w("MicroMsg.SubCoreSetting", "sys notification disable！");
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 18L, 1L, false);
      }
      Log.i("MicroMsg.SubCoreSetting", "is update from %s", new Object[] { Integer.valueOf(com.tencent.mm.kernel.h.aHE().kbI.kcY) });
      Object localObject2 = ci.lvQ.bfs();
      if (((Set)localObject2).size() == 2)
      {
        localObject1 = new String[2];
        localObject2 = ((Set)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localObject1[i] = ci.lvQ.getString(str, "login_user_name");
          i += 1;
        }
        if ((!Util.isNullOrNil(new String[] { localObject1[0], localObject1[1] })) && (localObject1[0].equals(localObject1[1])))
        {
          Log.w("MicroMsg.SubCoreSetting", "old dirty data!!!");
          ci.lvQ.Sa(localObject1[0]);
          ci.lvQ.Sa(localObject1[1]);
        }
      }
    }
    if ((com.tencent.mm.n.h.axc().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1) && ((com.tencent.mm.model.z.bdd() & 0x20) == 0)) {
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().add(this.Jdc);
    }
    AppMethodBeat.o(73753);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(73755);
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("redpointinfo", this.Jdd, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("crowdtest", this.Jdf, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.Jde);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.Jdg);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().remove(this.Jdc);
    AppMethodBeat.o(73755);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(73754);
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    AppMethodBeat.o(73754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.d
 * JD-Core Version:    0.7.0.1
 */