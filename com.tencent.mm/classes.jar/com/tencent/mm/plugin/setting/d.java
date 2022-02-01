package com.tencent.mm.plugin.setting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.be;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.edx;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.vas.VASActivity;
import com.tencent.mm.ui.vas.VASActivity.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.s;

public final class d
  implements be
{
  private static List<aah> PmY = null;
  private MStorageEx.IOnStorageChange PmZ;
  private cl.a Pna;
  private t Pnb;
  private t Pnc;
  private cl.a Pnd;
  private t Pne;
  
  public d()
  {
    AppMethodBeat.i(73751);
    this.PmZ = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, final MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(73746);
        if (paramAnonymousInt == 2)
        {
          paramAnonymousMStorageEx = (String)paramAnonymousObject;
          paramAnonymousObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxq(paramAnonymousMStorageEx);
          if ((paramAnonymousObject != null) && (!com.tencent.mm.contact.d.rs(paramAnonymousObject.field_type)) && (paramAnonymousObject.aSD()) && (!paramAnonymousObject.aSE())) {
            com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(73745);
                Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramAnonymousMStorageEx);
                if ((localObject != null) && (!com.tencent.mm.contact.d.rs(((az)localObject).field_type)) && (((au)localObject).aSD()) && (!((au)localObject).aSE()))
                {
                  localObject = new cc();
                  ((cc)localObject).pI(0);
                  ((cc)localObject).BS(paramAnonymousMStorageEx);
                  ((cc)localObject).setStatus(6);
                  ((cc)localObject).setContent(MMApplicationContext.getContext().getString(b.i.settings_jump_to_verifypage_tips));
                  ((cc)localObject).setCreateTime(br.D(paramAnonymousMStorageEx, System.currentTimeMillis() / 1000L));
                  ((cc)localObject).setType(10000);
                  ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba((cc)localObject);
                  Log.i("MicroMsg.SubCoreSetting", "insert chatcontact verify sysmsg. %s", new Object[] { paramAnonymousMStorageEx });
                }
                AppMethodBeat.o(73745);
              }
            }, 5000L);
          }
        }
        AppMethodBeat.o(73746);
      }
    };
    this.Pna = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(73747);
        paramAnonymousa = w.a(paramAnonymousa.mpN.YFG);
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
          if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQi, Integer.valueOf(0))).intValue() >= i)
          {
            AppMethodBeat.o(73747);
            return;
          }
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acQi, Integer.valueOf(i));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acQj, Integer.valueOf(i));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acQl, Integer.valueOf(i));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acQn, Integer.valueOf(i));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acQp, Integer.valueOf(i));
          c.aYo().R(266260, true);
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
          if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acRF, Integer.valueOf(0))).intValue() >= i)
          {
            AppMethodBeat.o(73747);
            return;
          }
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acRF, Integer.valueOf(i));
          str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acRG, "");
          if (Util.isNullOrNil(str)) {
            break label415;
          }
          paramAnonymousa = paramAnonymousa.concat(",").concat(str);
        }
        label415:
        for (;;)
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acRG, paramAnonymousa);
          c.aYo().R(262158, true);
          AppMethodBeat.o(73747);
          return;
        }
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.Pnb = new d.3(this);
    this.Pnc = new d.4(this);
    this.Pnd = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(298487);
        paramAnonymousa = w.a(paramAnonymousa.mpN.YFG);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          Log.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
          AppMethodBeat.o(298487);
          return;
        }
        paramAnonymousa = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(298487);
          return;
        }
        int i = Util.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.$clientversion"), 0);
        if (i <= com.tencent.mm.protocal.d.Yxh)
        {
          AppMethodBeat.o(298487);
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
          d.gUQ();
          AppMethodBeat.o(298487);
          return;
        }
        str1 = (String)paramAnonymousa.get(".sysmsg.crowdtest.apply.link");
        str2 = (String)paramAnonymousa.get(".sysmsg.crowdtest.feedback.link");
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acRA, Integer.valueOf(i));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acRB, Long.valueOf(l1));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acRC, str1);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acRD, str2);
        i = Util.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
        paramAnonymousa = c.aYo();
        if (i > 0) {}
        for (bool = true;; bool = false)
        {
          paramAnonymousa.R(262157, bool);
          if (i < 3) {
            c.aYo().dX(262157, 266261);
          }
          if (i < 2) {
            c.aYo().dX(262157, 266262);
          }
          AppMethodBeat.o(298487);
          return;
        }
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.Pne = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(298490);
        if (paramAnonymousMap != null)
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.security");
          if (!Util.isNullOrNil(paramAnonymousString)) {
            try
            {
              int i = Util.getInt(paramAnonymousString, 0);
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acWh, Integer.valueOf(i));
              if (i != 0)
              {
                c.aYo().b(at.a.acWf, true);
                AppMethodBeat.o(298490);
                return;
              }
              c.aYo().b(at.a.acWf, false);
              AppMethodBeat.o(298490);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              Log.printErrStackTrace("MicroMsg.SubCoreSetting", paramAnonymousString, "device protect security value is not number!", new Object[0]);
            }
          }
        }
        AppMethodBeat.o(298490);
      }
    };
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
    AppMethodBeat.o(73751);
  }
  
  private static void gUO()
  {
    AppMethodBeat.i(73756);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acRB, Long.valueOf(0L));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acRC, "");
    c.aYo().R(262157, false);
    AppMethodBeat.o(73756);
  }
  
  public static List<aah> gUP()
  {
    return PmY;
  }
  
  public static void kn(List<aah> paramList)
  {
    PmY = paramList;
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(73752);
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
    AppMethodBeat.o(73752);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(73753);
    Object localObject1 = e.Pnh;
    Log.i("MicroMsg.VAS.WxVAS", s.X("init isVASOpen:", Boolean.valueOf(((e)localObject1).gUR())));
    com.tencent.mm.ui.MMFragmentActivity.aReporter = e.Pnj;
    Object localObject2 = VASActivity.Companion;
    VASActivity.a.a((com.tencent.mm.ui.vas.b.a)localObject1);
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("redpointinfo", this.Pna, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("crowdtest", this.Pnd, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.Pnc);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.Pne);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("showWCOpenService", this.Pnb);
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acRA, Integer.valueOf(com.tencent.mm.protocal.d.Yxh))).intValue();
    long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acRB, Long.valueOf(0L))).longValue();
    if ((i <= com.tencent.mm.protocal.d.Yxh) || (l < System.currentTimeMillis())) {
      gUO();
    }
    i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acRE, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset flavorBlueCV: " + i + ",CLIENT_VERSION:" + com.tencent.mm.protocal.d.Yxh);
    if ((BuildInfo.IS_FLAVOR_BLUE) && (i < com.tencent.mm.protocal.d.Yxh))
    {
      c.aYo().R(262164, true);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acRE, Integer.valueOf(com.tencent.mm.protocal.d.Yxh));
    }
    if (paramBoolean)
    {
      i = z.bBf();
      com.tencent.mm.kernel.h.baE().ban().B(34, Integer.valueOf(i & 0xFFEFFFFF & 0xFFBFFFFF));
      localObject1 = new edx();
      ((edx)localObject1).YBX = 1048576;
      ((edx)localObject1).abiW = 0;
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(39, (com.tencent.mm.bx.a)localObject1));
      localObject1 = new edx();
      ((edx)localObject1).YBX = 4194304;
      ((edx)localObject1).abiW = 0;
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(39, (com.tencent.mm.bx.a)localObject1));
      Log.i("MicroMsg.SubCoreSetting", "set void default open");
      if (!androidx.core.app.i.X(MMApplicationContext.getContext()).DB())
      {
        Log.w("MicroMsg.SubCoreSetting", "sys notification disable！");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 18L, 1L, false);
      }
      Log.i("MicroMsg.SubCoreSetting", "is update from %s", new Object[] { Integer.valueOf(com.tencent.mm.kernel.h.baC().mBO.mDh) });
      localObject2 = cj.ono.bDj();
      if (((Set)localObject2).size() == 2)
      {
        localObject1 = new String[2];
        localObject2 = ((Set)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localObject1[i] = cj.ono.getString(str, "login_user_name");
          i += 1;
        }
        if ((!Util.isNullOrNil(new String[] { localObject1[0], localObject1[1] })) && (localObject1[0].equals(localObject1[1])))
        {
          Log.w("MicroMsg.SubCoreSetting", "old dirty data!!!");
          cj.ono.Kb(localObject1[0]);
          cj.ono.Kb(localObject1[1]);
        }
      }
      i = a.jD(MMApplicationContext.getContext());
      if ((com.tencent.mm.ce.b.iRp()) && (i == 5)) {
        com.tencent.mm.ce.b.axU(5);
      }
    }
    if ((com.tencent.mm.k.i.aRC().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1) && ((z.bAQ() & 0x20) == 0)) {
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().add(this.PmZ);
    }
    AppMethodBeat.o(73753);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(73755);
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("redpointinfo", this.Pna, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("crowdtest", this.Pnd, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.Pnc);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.Pne);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().remove(this.PmZ);
    AppMethodBeat.o(73755);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(73754);
    Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    AppMethodBeat.o(73754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.d
 * JD-Core Version:    0.7.0.1
 */