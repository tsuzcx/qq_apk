package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.c.av;
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
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
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
  private static List<us> xnV = null;
  private ExitAccountReceiver xnW;
  private ClearUATTestIDReceiver xnX;
  private n.b xnY;
  private cc.a xnZ;
  private p xoa;
  private cc.a xob;
  private p xoc;
  
  public c()
  {
    AppMethodBeat.i(73751);
    this.xnY = new n.b()
    {
      public final void a(int paramAnonymousInt, final n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(73746);
        if (paramAnonymousInt == 2)
        {
          paramAnonymousn = (String)paramAnonymousObject;
          paramAnonymousObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNn(paramAnonymousn);
          if ((paramAnonymousObject != null) && (!b.ln(paramAnonymousObject.field_type)) && (paramAnonymousObject.aaF()) && (!paramAnonymousObject.aaG())) {
            com.tencent.mm.kernel.g.agU().m(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(73745);
                Object localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramAnonymousn);
                if ((localObject != null) && (!b.ln(((av)localObject).field_type)) && (((com.tencent.mm.storage.ai)localObject).aaF()) && (!((com.tencent.mm.storage.ai)localObject).aaG()))
                {
                  localObject = new bo();
                  ((bo)localObject).jT(0);
                  ((bo)localObject).re(paramAnonymousn);
                  ((bo)localObject).setStatus(6);
                  ((bo)localObject).setContent(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131763250));
                  ((bo)localObject).oA(bi.z(paramAnonymousn, System.currentTimeMillis() / 1000L));
                  ((bo)localObject).setType(10000);
                  ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().ap((bo)localObject);
                  ac.i("MicroMsg.SubCoreSetting", "insert chatcontact verify sysmsg. %s", new Object[] { paramAnonymousn });
                }
                AppMethodBeat.o(73745);
              }
            }, 5000L);
          }
        }
        AppMethodBeat.o(73746);
      }
    };
    this.xnZ = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(73747);
        paramAnonymousa = z.a(paramAnonymousa.fXi.DPV);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ac.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
          AppMethodBeat.o(73747);
          return;
        }
        paramAnonymousa = bv.L(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(73747);
          return;
        }
        String str = bs.bG((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.path"), "");
        int i = bs.aLy(bs.bG((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
        bs.aLy(bs.bG((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
        if (bs.isNullOrNil(str))
        {
          AppMethodBeat.o(73747);
          return;
        }
        if (str.equals("my_setting_privaty_recentOption"))
        {
          if (((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLS, Integer.valueOf(0))).intValue() >= i)
          {
            AppMethodBeat.o(73747);
            return;
          }
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLS, Integer.valueOf(i));
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLT, Integer.valueOf(i));
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLV, Integer.valueOf(i));
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLX, Integer.valueOf(i));
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLZ, Integer.valueOf(i));
          com.tencent.mm.y.c.aeH().x(266260, true);
          AppMethodBeat.o(73747);
          return;
        }
        if (str.equals("my_setting_plugin_switch"))
        {
          paramAnonymousa = bs.bG((String)paramAnonymousa.get(".sysmsg.RedPoints.redPoint.ext"), "");
          if (bs.isNullOrNil(paramAnonymousa))
          {
            AppMethodBeat.o(73747);
            return;
          }
          if (((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GMW, Integer.valueOf(0))).intValue() >= i)
          {
            AppMethodBeat.o(73747);
            return;
          }
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GMW, Integer.valueOf(i));
          str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GMX, "");
          if (bs.isNullOrNil(str)) {
            break label414;
          }
          paramAnonymousa = paramAnonymousa.concat(",").concat(str);
        }
        label414:
        for (;;)
        {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GMX, paramAnonymousa);
          com.tencent.mm.y.c.aeH().x(262158, true);
          AppMethodBeat.o(73747);
          return;
        }
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.xoa = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(73748);
        if (paramAnonymousMap != null)
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.showtrustedfriends.wording");
          if (!bs.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousMap = new Intent();
            paramAnonymousMap.putExtra(e.k.Hhp, paramAnonymousString);
            com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", paramAnonymousMap);
          }
        }
        AppMethodBeat.o(73748);
      }
    };
    this.xob = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(73749);
        paramAnonymousa = z.a(paramAnonymousa.fXi.DPV);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ac.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
          AppMethodBeat.o(73749);
          return;
        }
        paramAnonymousa = bv.L(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(73749);
          return;
        }
        int i = bs.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.$clientversion"), 0);
        if (i <= com.tencent.mm.protocal.d.DIc)
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
          c.dBF();
          AppMethodBeat.o(73749);
          return;
        }
        str1 = (String)paramAnonymousa.get(".sysmsg.crowdtest.apply.link");
        str2 = (String)paramAnonymousa.get(".sysmsg.crowdtest.feedback.link");
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GMR, Integer.valueOf(i));
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GMS, Long.valueOf(l1));
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GMU, str1);
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GMV, str2);
        i = bs.getInt((String)paramAnonymousa.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
        paramAnonymousa = com.tencent.mm.y.c.aeH();
        if (i > 0) {}
        for (bool = true;; bool = false)
        {
          paramAnonymousa.x(262157, bool);
          if (i < 3) {
            com.tencent.mm.y.c.aeH().cI(262157, 266261);
          }
          if (i < 2) {
            com.tencent.mm.y.c.aeH().cI(262157, 266262);
          }
          AppMethodBeat.o(73749);
          return;
        }
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.xoc = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(73750);
        if (paramAnonymousMap != null)
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.security");
          if (!bs.isNullOrNil(paramAnonymousString)) {
            try
            {
              int i = bs.getInt(paramAnonymousString, 0);
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQO, Integer.valueOf(i));
              if (i != 0)
              {
                com.tencent.mm.y.c.aeH().b(ah.a.GQM, true);
                AppMethodBeat.o(73750);
                return;
              }
              com.tencent.mm.y.c.aeH().b(ah.a.GQM, false);
              AppMethodBeat.o(73750);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              ac.printErrStackTrace("MicroMsg.SubCoreSetting", paramAnonymousString, "device protect security value is not number!", new Object[0]);
            }
          }
        }
        AppMethodBeat.o(73750);
      }
    };
    ac.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
    AppMethodBeat.o(73751);
  }
  
  private static void dBD()
  {
    AppMethodBeat.i(73756);
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GMS, Long.valueOf(0L));
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GMU, "");
    com.tencent.mm.y.c.aeH().x(262157, false);
    AppMethodBeat.o(73756);
  }
  
  public static List<us> dBE()
  {
    return xnV;
  }
  
  public static void fl(List<us> paramList)
  {
    xnV = paramList;
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(73752);
    ac.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
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
    ac.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("redpointinfo", this.xnZ, true);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("crowdtest", this.xob, true);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.xoa);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.xoc);
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GMR, Integer.valueOf(com.tencent.mm.protocal.d.DIc))).intValue();
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GMS, Long.valueOf(0L))).longValue();
    if ((i <= com.tencent.mm.protocal.d.DIc) || (l < System.currentTimeMillis())) {
      dBD();
    }
    Object localObject1;
    if (paramBoolean)
    {
      i = u.axI();
      com.tencent.mm.kernel.g.agR().agA().set(34, Integer.valueOf(i & 0xFFEFFFFF & 0xFFBFFFFF));
      localObject1 = new cft();
      ((cft)localObject1).DNd = 1048576;
      ((cft)localObject1).Fuc = 0;
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(new j.a(39, (com.tencent.mm.bw.a)localObject1));
      localObject1 = new cft();
      ((cft)localObject1).DNd = 4194304;
      ((cft)localObject1).Fuc = 0;
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(new j.a(39, (com.tencent.mm.bw.a)localObject1));
      ac.i("MicroMsg.SubCoreSetting", "set void default open");
      if (!v.N(com.tencent.mm.sdk.platformtools.ai.getContext()).areNotificationsEnabled())
      {
        ac.w("MicroMsg.SubCoreSetting", "sys notification disable！");
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 18L, 1L, false);
      }
      ac.i("MicroMsg.SubCoreSetting", "is update from %s", new Object[] { Integer.valueOf(com.tencent.mm.kernel.g.agP().ggJ.ghY) });
      Object localObject2 = ca.hpQ.azx();
      if (((Set)localObject2).size() == 2)
      {
        localObject1 = new String[2];
        localObject2 = ((Set)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localObject1[i] = ca.hpQ.getString(str, "login_user_name");
          i += 1;
        }
        if ((!bs.T(new String[] { localObject1[0], localObject1[1] })) && (localObject1[0].equals(localObject1[1])))
        {
          ac.w("MicroMsg.SubCoreSetting", "old dirty data!!!");
          ca.hpQ.yA(localObject1[0]);
          ca.hpQ.yA(localObject1[1]);
        }
      }
    }
    if ((com.tencent.mm.m.g.ZY().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1) && ((u.axA() & 0x20) == 0)) {
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().a(this.xnY);
    }
    ac.i("MicroMsg.SubCoreSetting", "before register an wechat pay UAT, is_uat: %b, context: %s", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.h.IS_UAT), com.tencent.mm.sdk.platformtools.ai.getContext() });
    if ((com.tencent.mm.sdk.platformtools.h.IS_UAT) && (com.tencent.mm.sdk.platformtools.ai.getContext() != null))
    {
      this.xnW = new ExitAccountReceiver();
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("action_exit_account_broadcast");
      com.tencent.mm.sdk.platformtools.ai.getContext().registerReceiver(this.xnW, (IntentFilter)localObject1);
      this.xnX = new ClearUATTestIDReceiver();
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("action_uat_clear_test_id_broadcast");
      com.tencent.mm.sdk.platformtools.ai.getContext().registerReceiver(this.xnX, (IntentFilter)localObject1);
    }
    AppMethodBeat.o(73753);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(73755);
    ac.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("redpointinfo", this.xnZ, true);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("crowdtest", this.xob, true);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.xoa);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.xoc);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().b(this.xnY);
    if (com.tencent.mm.sdk.platformtools.ai.getContext() == null) {
      ac.w("MicroMsg.SubCoreSetting", "MMApplicationContext.getContext return null! unregisterUATReceiver return!");
    }
    ac.i("MicroMsg.SubCoreSetting", "before unregister ExitAccountReceiver, mExitAccountReceiver: %b", new Object[] { this.xnW });
    if (this.xnW != null) {
      com.tencent.mm.sdk.platformtools.ai.getContext().unregisterReceiver(this.xnW);
    }
    ac.i("MicroMsg.SubCoreSetting", "before unregister ClearUATTestIDReceiver, mClearUATTestIDReceiver: %b", new Object[] { this.xnW });
    if (this.xnX != null) {
      com.tencent.mm.sdk.platformtools.ai.getContext().unregisterReceiver(this.xnX);
    }
    AppMethodBeat.o(73755);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(73754);
    ac.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    AppMethodBeat.o(73754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c
 * JD-Core Version:    0.7.0.1
 */