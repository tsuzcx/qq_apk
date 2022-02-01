package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.wallet_core.c.aa;
import java.io.IOException;

public final class ae
  extends s
  implements com.tencent.mm.ak.g
{
  private static final int[] Hry = { 2, 1, 10, 20, 2147483647 };
  private static final int[] Hrz = { 2, 1, 10, 2147483647 };
  private SparseArray<c> Hrt;
  private a Hrv;
  ad Hrw;
  private boolean Hrx;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public ae(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(33697);
    this.Hrw = null;
    this.mContext = paramAppCompatActivity;
    this.mInflater = LayoutInflater.from(paramAppCompatActivity);
    xP(false);
    this.Hrw = ad.fhq();
    AppMethodBeat.o(33697);
  }
  
  public static d ZL(int paramInt)
  {
    AppMethodBeat.i(33700);
    Object localObject = ai.getContext();
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(33700);
      return localObject;
      if (HomeUI.HjZ.booleanValue())
      {
        localObject = new d(1, ((Context)localObject).getString(2131761217), "", 2131690971, 2131101171);
      }
      else
      {
        localObject = new d(1, ((Context)localObject).getString(2131761217), "", 2131690972, 0);
        continue;
        if (HomeUI.Hka.booleanValue())
        {
          localObject = new d(2, ((Context)localObject).getString(2131761220), "", 2131690984, 2131101171);
        }
        else
        {
          localObject = new d(2, ((Context)localObject).getString(2131761220), "", 2131690985, 0);
          continue;
          localObject = new d(3, ((Context)localObject).getString(2131761221), "", 2131689854, 0);
          continue;
          if (1 == com.tencent.mm.sdk.platformtools.bs.getInt(com.tencent.mm.m.g.ZY().getValue("VOIPCallType"), 0))
          {
            localObject = new d(4, ((Context)localObject).getString(2131761222), "", 2131690995, 0);
          }
          else
          {
            localObject = new d(4, ((Context)localObject).getString(2131761218), "", 2131690973, 0);
            continue;
            localObject = new d(5, ((Context)localObject).getString(2131763307), "", 2131690990, 0);
            continue;
            localObject = new d(6, ((Context)localObject).getString(2131763276), "", 2131690981, 0);
            continue;
            localObject = new d(7, ((Context)localObject).getString(2131763278), "", 2131690976, 0);
            continue;
            localObject = new d(8, ((Context)localObject).getString(2131758307), "", 2131690979, 0);
            continue;
            localObject = new d(9, ((Context)localObject).getString(2131763311), "", 2131690988, 0);
            continue;
            localObject = new d(10, ((Context)localObject).getString(2131759095), "", 2131690991, 0);
            continue;
            localObject = new d(11, ((Context)localObject).getString(2131763808), "", 2131690987, 0);
            continue;
            localObject = new d(12, ((Context)localObject).getString(2131759965), "", 2131690983, 0);
            continue;
            localObject = new d(13, ((Context)localObject).getString(2131763605), "", 2131690994, 0);
            continue;
            localObject = new d(14, ((Context)localObject).getString(2131761520), "", 2131690989, 0);
            continue;
            localObject = new d(16, ((Context)localObject).getString(2131763154), "", 2131690997, 0);
            continue;
            localObject = new d(17, ((Context)localObject).getString(2131761177), "", 2131690986, 0);
            continue;
            localObject = new d(18, ((Context)localObject).getString(2131759097), "", 2131690992, 0);
            continue;
            localObject = new d(19, ((Context)localObject).getString(2131759100), "", 2131689484, 0);
            continue;
            az.ayM();
            if (((Integer)com.tencent.mm.model.c.agA().get(ah.a.GIP, Integer.valueOf(0))).intValue() > 1) {
              break;
            }
            localObject = new d(20, ((Context)localObject).getString(2131755231), "", 2131691083, 0, "plus_receiveorpay");
            continue;
            localObject = new d(2147483647, ((Context)localObject).getString(2131763227), "", 2131690982, 0);
            continue;
            localObject = new d(2147483645, ((Context)localObject).getString(2131763204), "", 2131690982, 0);
            continue;
            az.ayM();
            if (((Integer)com.tencent.mm.model.c.agA().get(ah.a.GIP, Integer.valueOf(0))).intValue() != 8) {
              break;
            }
            localObject = new d(22, ((Context)localObject).getString(2131762000), "", 2131690963, 0);
            continue;
            az.ayM();
            if (((Integer)com.tencent.mm.model.c.agA().get(ah.a.GIP, Integer.valueOf(0))).intValue() != 8) {
              break;
            }
            localObject = new d(24, ((Context)localObject).getString(2131766756), "", 2131691083, 0);
            continue;
            localObject = new d(2147483646, "TIT", "", 2131690976, 0);
          }
        }
      }
    }
  }
  
  private static cei fhs()
  {
    AppMethodBeat.i(196337);
    ac.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig");
    cei localcei = new cei();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ah.a.GWB, null);
    if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(str)) {
      ac.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 get PayIBGQuickGetOverseaWalletConfig failed");
    }
    for (;;)
    {
      AppMethodBeat.o(196337);
      return localcei;
      try
      {
        localcei.parseFrom(str.getBytes("ISO-8859-1"));
        ac.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig success");
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.PlusSubMenuHelper", "OfflineH5 parse PayIBGQuickGetOverseaWalletConfig fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  private boolean ghg()
  {
    AppMethodBeat.i(210127);
    String str = com.tencent.mm.sdk.platformtools.bs.jd(this.mContext);
    if ((!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(str)) && (str.equals("LauncherUI")))
    {
      ac.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is on ActivityTask Top ");
      AppMethodBeat.o(210127);
      return true;
    }
    ac.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is not on ActivityTask Top：%s", new Object[] { str });
    AppMethodBeat.o(210127);
    return false;
  }
  
  private void wK(boolean paramBoolean)
  {
    AppMethodBeat.i(196336);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.plugin.wallet_index.c.a.b localb = new com.tencent.mm.plugin.wallet_index.c.a.b(((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIP, Integer.valueOf(0))).intValue());
    az.agi().a(localb, 0);
    this.Hrx = paramBoolean;
    AppMethodBeat.o(196336);
  }
  
  public final BaseAdapter WW()
  {
    AppMethodBeat.i(33701);
    if (this.Hrv == null) {
      this.Hrv = new a((byte)0);
    }
    a locala = this.Hrv;
    AppMethodBeat.o(33701);
    return locala;
  }
  
  public final boolean hU()
  {
    int k = 0;
    AppMethodBeat.i(33698);
    this.Hrw.wJ(false);
    if (this.Hrw.Hrt.size() != 0) {
      this.Hrt = this.Hrw.Hrt;
    }
    try
    {
      az.ayM();
      if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GGS, Boolean.FALSE)).booleanValue())
      {
        int i = k;
        while (i < this.Hrt.size())
        {
          int j = ((c)this.Hrt.get(i)).HrD.HrG;
          if (j != 2147483646)
          {
            i += 1;
            continue;
            ac.i("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.Hrt != null)
            {
              this.Hrt.clear();
              label131:
              if (!com.tencent.mm.sdk.platformtools.bs.ja(this.mContext)) {
                break label220;
              }
            }
            label220:
            for (int[] arrayOfInt = Hrz;; arrayOfInt = Hry)
            {
              int m = arrayOfInt.length;
              i = 0;
              j = 0;
              while (i < m)
              {
                c localc = new c(ZL(arrayOfInt[i]));
                if (localc.HrD != null) {
                  this.Hrt.put(j, localc);
                }
                j += 1;
                i += 1;
              }
              this.Hrt = new SparseArray();
              break label131;
            }
          }
        }
        if (i == this.Hrt.size()) {
          this.Hrt.put(this.Hrt.size(), new c(ZL(2147483646)));
        }
      }
    }
    catch (Exception localException)
    {
      label265:
      boolean bool;
      break label265;
    }
    if (this.Hrv != null) {
      this.Hrv.notifyDataSetChanged();
    }
    bool = super.hU();
    AppMethodBeat.o(33698);
    return bool;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, final View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33699);
    if ((this.mContext instanceof AppCompatActivity)) {
      ((AppCompatActivity)this.mContext).supportInvalidateOptionsMenu();
    }
    int i = ((c)this.Hrt.get(paramInt)).HrD.HrG;
    paramAdapterView = new com.tencent.mm.hellhoundlib.b.b();
    paramAdapterView.lS(i);
    paramAdapterView.lS(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/PlusSubMenuHelper", "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", this, paramAdapterView.aeE());
    com.tencent.mm.plugin.report.service.h.wUl.f(11104, new Object[] { Integer.valueOf(i) });
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class) != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).bxV();
    }
    switch (i)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/PlusSubMenuHelper", "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V");
        this.Hrw.ZK(i);
        dismiss();
        AppMethodBeat.o(33699);
        return;
        new Intent().putExtra("invite_friend_scene", 2);
        com.tencent.mm.br.d.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
        continue;
        paramView = new Intent(this.mContext, SelectContactUI.class);
        paramView.putExtra("titile", this.mContext.getString(2131755232));
        paramView.putExtra("list_type", 0);
        paramView.putExtra("list_attr", com.tencent.mm.ui.contact.u.I(new int[] { com.tencent.mm.ui.contact.u.IwR, 256, 512 }));
        paramView.putExtra("scene", 7);
        paramView.putExtra("create_group_recommend", true);
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.aeD(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramView = new Intent();
        paramView.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.aeD(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramAdapterView = new vt();
        paramAdapterView.dyB.dyD = true;
        com.tencent.mm.sdk.b.a.GpY.l(paramAdapterView);
        paramAdapterView = paramAdapterView.dyC.dyF;
        if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramAdapterView))
        {
          ac.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: ".concat(String.valueOf(paramAdapterView)));
          com.tencent.mm.ui.base.h.d(this.mContext, this.mContext.getString(2131764350), "", this.mContext.getString(2131755835), this.mContext.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(33686);
              Object localObject = new vt();
              ((vt)localObject).dyB.dyE = true;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
              localObject = new fh();
              ((fh)localObject).dfa.username = com.tencent.mm.bi.d.hXZ.aJc();
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
              VoipAddressUI.kd(ae.b(ae.this));
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(33686);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(33687);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(33687);
            }
          });
        }
        else
        {
          VoipAddressUI.kd(this.mContext);
          continue;
          az.ayM();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            t.g(this.mContext, null);
          }
          else
          {
            az.ayM();
            paramAdapterView = (String)com.tencent.mm.model.c.agA().get(2, null);
            paramView = new Intent();
            paramView.putExtra("sns_userName", paramAdapterView);
            paramView.setFlags(536870912);
            paramView.addFlags(67108864);
            az.ayM();
            paramInt = com.tencent.mm.sdk.platformtools.bs.a((Integer)com.tencent.mm.model.c.agA().get(68389, null), 0);
            az.ayM();
            com.tencent.mm.model.c.agA().set(68389, Integer.valueOf(paramInt + 1));
            paramView.putExtra("sns_adapter_type", 1);
            com.tencent.mm.br.d.b(this.mContext, "sns", ".ui.SnsTimeLineUserPagerUI", paramView);
            continue;
            com.tencent.mm.plugin.fav.a.b.b(this.mContext, ".ui.FavoriteIndexUI", new Intent());
            continue;
            com.tencent.mm.br.d.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
            continue;
            paramAdapterView = new Intent();
            paramAdapterView.putExtra("preceding_scence", 2);
            com.tencent.mm.br.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", paramAdapterView);
            continue;
            com.tencent.mm.br.d.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
            continue;
            com.tencent.mm.plugin.report.service.h.wUl.f(11265, new Object[] { Integer.valueOf(3) });
            if ((!com.tencent.mm.r.a.cg(this.mContext)) && (!com.tencent.mm.bh.e.aIX()) && (!com.tencent.mm.r.a.cj(this.mContext)))
            {
              paramAdapterView = new Intent();
              paramAdapterView.putExtra("key_scan_entry_scene", 1);
              paramAdapterView.putExtra("key_config_black_interval", true);
              com.tencent.mm.br.d.b(this.mContext, "scanner", ".ui.BaseScanUI", paramAdapterView);
              continue;
              az.ayM();
              if (com.tencent.mm.model.c.isSDCardAvailable()) {
                break;
              }
              t.g(this.mContext, null);
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.MH(10);
      az.ayM();
      paramAdapterView = (String)com.tencent.mm.model.c.agA().get(68377, null);
      az.ayM();
      com.tencent.mm.model.c.agA().set(68377, "");
      paramView = new Intent();
      paramView.putExtra("sns_timeline_NeedFirstLoadint", true);
      if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramAdapterView)) {
        break;
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (o.xMc != null)
      {
        bool2 = bool1;
        if (o.xMc.bQe() > 0) {
          bool2 = false;
        }
      }
      paramView.putExtra("sns_resume_state", bool2);
      com.tencent.mm.br.d.b(this.mContext, "sns", ".ui.SnsTimeLineUI", paramView);
      break;
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(this.mContext, null);
        break;
      }
      com.tencent.mm.br.d.N(this.mContext, "game", ".ui.GameCenterUI");
      new ao().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33688);
          com.tencent.mm.cq.d.fBf();
          AppMethodBeat.o(33688);
        }
      }, 100L);
      break;
      com.tencent.mm.sdk.b.a.GpY.l(new qp());
      com.tencent.mm.br.d.N(this.mContext, "shake", ".ui.ShakeReportUI");
      break;
      az.ayM();
      if (!com.tencent.mm.sdk.platformtools.bs.l((Boolean)com.tencent.mm.model.c.agA().get(4103, null)))
      {
        com.tencent.mm.br.d.N(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
        break;
      }
      paramAdapterView = com.tencent.mm.model.bs.azt();
      if (paramAdapterView == null)
      {
        com.tencent.mm.br.d.N(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      paramView = com.tencent.mm.sdk.platformtools.bs.nullAsNil(paramAdapterView.getProvince());
      paramInt = com.tencent.mm.sdk.platformtools.bs.a(Integer.valueOf(paramAdapterView.exL), 0);
      if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramView)) || (paramInt == 0))
      {
        com.tencent.mm.br.d.N(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      az.ayM();
      paramAdapterView = (Boolean)com.tencent.mm.model.c.agA().get(4104, null);
      if ((paramAdapterView == null) || (!paramAdapterView.booleanValue()))
      {
        paramAdapterView = LauncherUI.getInstance();
        if (paramAdapterView != null) {
          paramAdapterView.Hlj.getMainTabUI().aPD("tab_find_friend");
        }
        com.tencent.mm.bp.a.hc(this.mContext);
        break;
      }
      paramAdapterView = View.inflate(this.mContext, 2131494579, null);
      paramView = (CheckBox)paramAdapterView.findViewById(2131301369);
      paramView.setChecked(false);
      com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131755906), paramAdapterView, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33689);
          if (paramView != null)
          {
            az.ayM();
            paramAnonymousDialogInterface = com.tencent.mm.model.c.agA();
            if (paramView.isChecked()) {
              break label79;
            }
          }
          label79:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousDialogInterface.set(4104, Boolean.valueOf(bool));
            paramAnonymousDialogInterface = LauncherUI.getInstance();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.Hlj.getMainTabUI().aPD("tab_find_friend");
            }
            com.tencent.mm.bp.a.hc(ae.b(ae.this));
            AppMethodBeat.o(33689);
            return;
          }
        }
      }, null);
      break;
      az.ayM();
      if (com.tencent.mm.model.c.afW())
      {
        com.tencent.mm.br.d.N(this.mContext, "webwx", ".ui.WebWXLogoutUI");
        break;
      }
      com.tencent.mm.br.d.N(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
      break;
      if ((com.tencent.mm.model.u.axI() & 0x10000) == 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label1667;
        }
        com.tencent.mm.br.d.N(this.mContext, "masssend", ".ui.MassSendHistoryUI");
        break;
      }
      label1667:
      com.tencent.mm.br.d.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
      break;
      com.tencent.mm.br.d.N(this.mContext, "radar", ".ui.RadarSearchUI");
      break;
      com.tencent.mm.br.d.N(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      break;
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10919, "1-6");
      com.tencent.mm.pluginsdk.f.hg(this.mContext);
      break;
      paramAdapterView = new Intent();
      az.ayM();
      paramView = (String)com.tencent.mm.model.c.agA().get(ah.a.GMV, "");
      if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramView))
      {
        paramAdapterView.putExtra("rawUrl", paramView);
        paramAdapterView.putExtra("showShare", true);
        paramAdapterView.putExtra("show_bottom", false);
        com.tencent.mm.br.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramAdapterView);
        break;
      }
      com.tencent.mm.pluginsdk.f.hg(this.mContext);
      break;
      com.tencent.mm.plugin.newtips.a.dkb().Ko(4);
      paramAdapterView = this.mContext;
      paramView = new Intent();
      paramView.putExtra("key_from_scene", 2);
      com.tencent.mm.br.d.b(paramAdapterView, "offline", ".ui.WalletOfflineEntranceUI", paramView);
      if (!com.tencent.mm.y.c.aeH().cH(262159, 266248)) {
        break;
      }
      com.tencent.mm.y.c.aeH().cI(262159, 266248);
      com.tencent.mm.plugin.report.service.h.wUl.f(14396, new Object[] { Integer.valueOf(2) });
      break;
      com.tencent.mm.pluginsdk.wallet.f.ar(this.mContext, 1);
      break;
      com.tencent.mm.kernel.g.agi().a(2540, this);
      paramAdapterView = fhs();
      if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramAdapterView.FsW))
      {
        ac.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 has no cache");
        wK(false);
        break;
      }
      paramLong = System.currentTimeMillis();
      long l = paramLong - paramAdapterView.FsY;
      ac.i("MicroMsg.PlusSubMenuHelper", "currentTime ：%s ,lastTime：%s,internalTime ：%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramAdapterView.FsY), Long.valueOf(l) });
      if (l < paramAdapterView.FsX)
      {
        ac.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 dont expired，url：%s", new Object[] { paramAdapterView.FsW });
        com.tencent.mm.wallet_core.ui.e.n(this.mContext, paramAdapterView.FsW, false);
        wK(true);
        break;
      }
      ac.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 is expired");
      wK(false);
      break;
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("key_from_scene", 2);
      com.tencent.mm.br.d.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", paramAdapterView);
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(196338);
    ac.i("MicroMsg.PlusSubMenuHelper", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.wallet_index.c.a.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label363;
      }
      paramString = (com.tencent.mm.plugin.wallet_index.c.a.b)paramn;
      if (paramString.BPO != null) {
        break label262;
      }
      paramString = new cei();
      if (paramString.dkl != 0) {
        break label305;
      }
      ac.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd ok，pay_wallet_wxapp_h5_url：%s, cache_time：%s", new Object[] { paramString.FsW, Integer.valueOf(paramString.FsX) });
      if ((!this.Hrx) && (ghg()))
      {
        ac.i("MicroMsg.PlusSubMenuHelper", "on Scene End jump h5 ");
        com.tencent.mm.wallet_core.ui.e.n(this.mContext, paramString.FsW, false);
      }
      paramString.FsY = System.currentTimeMillis();
      ac.i("MicroMsg.PlusSubMenuHelper", "on Scene End currentTime ：%s ", new Object[] { Long.valueOf(paramString.FsY) });
      ac.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 setConfig");
      if (paramString == null) {
        break label423;
      }
    }
    for (;;)
    {
      try
      {
        paramString = new String(paramString.toByteArray(), "ISO-8859-1");
      }
      catch (IOException paramn)
      {
        label262:
        paramString = " ";
      }
      try
      {
        ac.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 setConfig success");
        ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ah.a.GWB, paramString);
        ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().faa();
        com.tencent.mm.kernel.g.agi().b(2540, this);
        AppMethodBeat.o(196338);
        return;
      }
      catch (IOException paramn)
      {
        break label276;
      }
      paramString = paramString.BPO;
      break;
      label276:
      ac.e("MicroMsg.PlusSubMenuHelper", "save config exp, " + paramn.getLocalizedMessage());
      continue;
      label305:
      ac.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd failed show dialog ");
      if ((!this.Hrx) && (ghg()))
      {
        com.tencent.mm.ui.base.h.a(this.mContext, paramString.dkm, "", this.mContext.getString(2131766205), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(196332);
            ac.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
            AppMethodBeat.o(196332);
          }
        });
        continue;
        label363:
        ac.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd faile show error dialog ");
        if ((!this.Hrx) && (ghg()))
        {
          com.tencent.mm.ui.base.h.a(this.mContext, paramString, "", this.mContext.getString(2131766205), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(196333);
              ac.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
              AppMethodBeat.o(196333);
            }
          });
          continue;
          label423:
          paramString = " ";
        }
      }
    }
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(33690);
      int i = ae.a(ae.this).size();
      AppMethodBeat.o(33690);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(33691);
      paramView = (ae.c)ae.a(ae.this).get(paramInt);
      paramView = new ae.e(ae.b(ae.this), paramView);
      LayoutInflater localLayoutInflater = ae.c(ae.this);
      label254:
      boolean bool;
      if (paramInt == getCount() - 1)
      {
        paramInt = 1;
        paramView.fvu = localLayoutInflater.inflate(2131494904, paramViewGroup, false);
        paramView.fUk = ((TextView)paramView.fvu.findViewById(2131305902));
        paramView.ig = ((ImageView)paramView.fvu.findViewById(2131300874));
        paramView.HrI = ((TextView)paramView.fvu.findViewById(2131302799));
        paramView.HrJ = ((TextView)paramView.fvu.findViewById(2131306194));
        paramView.HrK = paramView.fvu.findViewById(2131302741);
        if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramView.HrH.HrD.HrE)) {
          paramView.fUk.setText(paramView.HrH.HrD.HrE);
        }
        if (paramView.HrH.HrD.textColor > 0) {
          paramView.fUk.setTextColor(com.tencent.mm.cc.a.n(ai.getContext(), paramView.HrH.HrD.textColor));
        }
        if (paramView.HrH.HrD.icon <= 0) {
          break label425;
        }
        paramView.ig.setVisibility(0);
        paramView.ig.setImageResource(paramView.HrH.HrD.icon);
        if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramView.HrH.HrD.HrF)) {
          paramView.ig.setContentDescription(paramView.HrH.HrD.HrF);
        }
        paramView.HrJ.setBackgroundResource(com.tencent.mm.ui.tools.u.ks(paramView.context));
        if (paramInt == 0) {
          break label437;
        }
        paramView.fvu.setBackgroundResource(2131234277);
        label314:
        paramView.HrI.setTextSize(0, com.tencent.mm.cc.a.av(paramView.context, 2131166950));
        if ((!paramView.HrH.fRT) && (paramView.HrH.cYG <= 0) && (!paramView.HrH.HrC)) {
          break label449;
        }
        bool = true;
        label365:
        if (!com.tencent.mm.plugin.newtips.a.g.a(bool, paramView))
        {
          if (!paramView.HrH.fRT) {
            break label455;
          }
          paramView.HrI.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.vnu, true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.newtips.a.dkb().h(paramView);
        paramView = paramView.fvu;
        AppMethodBeat.o(33691);
        return paramView;
        paramInt = 0;
        break;
        label425:
        paramView.ig.setVisibility(8);
        break label254;
        label437:
        paramView.fvu.setBackgroundResource(2131234276);
        break label314;
        label449:
        bool = false;
        break label365;
        label455:
        if (paramView.HrH.cYG > 0)
        {
          paramView.HrJ.setVisibility(0);
          if (paramView.HrH.cYG > 99)
          {
            paramView.HrJ.setText("");
            paramView.HrJ.setBackgroundResource(2131689744);
          }
          for (;;)
          {
            com.tencent.mm.plugin.newtips.a.g.a(paramView, k.vny, true);
            break;
            paramView.HrJ.setText(paramView.HrH.cYG);
            paramView.HrJ.setBackgroundResource(com.tencent.mm.ui.tools.u.aM(paramView.context, paramView.HrH.cYG));
          }
        }
        if (paramView.HrH.HrC)
        {
          paramView.HrK.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.vnt, true);
        }
        else
        {
          paramView.HrI.setVisibility(8);
          paramView.HrJ.setVisibility(8);
          paramView.HrK.setVisibility(8);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.vnu, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.vny, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.vnt, false);
        }
      }
    }
  }
  
  public static final class b
  {
    int HrB;
    int hTM;
    int id;
    int order;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2, paramInt3, 0);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.id = paramInt1;
      this.HrB = paramInt2;
      this.hTM = paramInt3;
      this.order = paramInt4;
    }
  }
  
  public static final class c
  {
    boolean HrC = false;
    ae.d HrD;
    int cYG = 0;
    boolean fRT = false;
    
    public c(ae.d paramd)
    {
      this.HrD = paramd;
    }
  }
  
  public static final class d
  {
    String HrE;
    String HrF;
    int HrG;
    int icon;
    String path;
    int textColor;
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramString1, paramString2, paramInt2, paramInt3, "");
    }
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
    {
      this.HrE = paramString1;
      this.HrF = paramString2;
      this.icon = paramInt2;
      this.HrG = paramInt1;
      this.textColor = paramInt3;
      this.path = paramString3;
    }
  }
  
  public static final class e
    implements com.tencent.mm.plugin.newtips.a.a
  {
    ae.c HrH;
    TextView HrI;
    TextView HrJ;
    View HrK;
    Context context;
    TextView fUk;
    View fvu;
    ImageView ig;
    
    public e(Context paramContext, ae.c paramc)
    {
      this.context = paramContext;
      this.HrH = paramc;
    }
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(210125);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(210125);
    }
    
    public final boolean a(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dhn paramdhn)
    {
      AppMethodBeat.i(33696);
      if (paramBoolean)
      {
        this.HrJ.setVisibility(0);
        if (paramdhn.gMk > 99)
        {
          this.HrJ.setText("");
          this.HrJ.setBackgroundResource(2131689744);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33696);
        return true;
        this.HrJ.setText(paramdhn.gMk);
        this.HrJ.setBackgroundResource(com.tencent.mm.ui.tools.u.aM(this.context, paramdhn.gMk));
        continue;
        this.HrJ.setVisibility(8);
      }
    }
    
    public final boolean dbk()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.HrH.HrD.path;
    }
    
    public final View getRoot()
    {
      return this.fvu;
    }
    
    public final boolean nR(boolean paramBoolean)
    {
      AppMethodBeat.i(210126);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(210126);
      return paramBoolean;
    }
    
    public final boolean nS(boolean paramBoolean)
    {
      AppMethodBeat.i(33694);
      if (paramBoolean) {
        this.HrK.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33694);
        return true;
        this.HrK.setVisibility(8);
      }
    }
    
    public final boolean nT(boolean paramBoolean)
    {
      AppMethodBeat.i(33695);
      if (paramBoolean) {
        this.HrI.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33695);
        return true;
        this.HrI.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ae
 * JD-Core Version:    0.7.0.1
 */