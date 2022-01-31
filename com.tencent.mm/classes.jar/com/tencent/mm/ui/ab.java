package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;

public final class ab
  extends com.tencent.mm.ui.tools.r
{
  private static final int[] zeB = { 2, 1, 10, 20, 2147483647 };
  private static final int[] zeC = { 2, 1, 10, 2147483647 };
  private Context mContext;
  private LayoutInflater mInflater;
  aa zeA;
  private SparseArray<ab.c> zex;
  private ab.a zez;
  
  public ab(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(29845);
    this.zeA = null;
    this.mContext = paramAppCompatActivity;
    this.mInflater = LayoutInflater.from(paramAppCompatActivity);
    rv(false);
    this.zeA = aa.dDd();
    AppMethodBeat.o(29845);
  }
  
  public static ab.d Ou(int paramInt)
  {
    AppMethodBeat.i(29848);
    Object localObject = ah.getContext();
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(29848);
      return localObject;
      if (HomeUI.yXL.booleanValue())
      {
        localObject = new ab.d(1, ((Context)localObject).getString(2131301547), "", 2131231801, 2131690701);
      }
      else
      {
        localObject = new ab.d(1, ((Context)localObject).getString(2131301547), "", 2131231802, 0);
        continue;
        if (HomeUI.yXM.booleanValue())
        {
          localObject = new ab.d(2, ((Context)localObject).getString(2131301550), "", 2131231814, 2131690701);
        }
        else
        {
          localObject = new ab.d(2, ((Context)localObject).getString(2131301550), "", 2131231815, 0);
          continue;
          localObject = new ab.d(3, ((Context)localObject).getString(2131301551), "", 2131231063, 0);
          continue;
          if (1 == bo.getInt(com.tencent.mm.m.g.Nq().getValue("VOIPCallType"), 0))
          {
            localObject = new ab.d(4, ((Context)localObject).getString(2131301552), "", 2131231826, 0);
          }
          else
          {
            localObject = new ab.d(4, ((Context)localObject).getString(2131301548), "", 2131231803, 0);
            continue;
            localObject = new ab.d(5, ((Context)localObject).getString(2131303327), "", 2131231820, 0);
            continue;
            localObject = new ab.d(6, ((Context)localObject).getString(2131303306), "", 2131231811, 0);
            continue;
            localObject = new ab.d(7, ((Context)localObject).getString(2131303308), "", 2131231806, 0);
            continue;
            localObject = new ab.d(8, ((Context)localObject).getString(2131299181), "", 2131231809, 0);
            continue;
            localObject = new ab.d(9, ((Context)localObject).getString(2131303331), "", 2131231818, 0);
            continue;
            localObject = new ab.d(10, ((Context)localObject).getString(2131299908), "", 2131231821, 0);
            continue;
            localObject = new ab.d(11, ((Context)localObject).getString(2131303801), "", 2131231817, 0);
            continue;
            localObject = new ab.d(12, ((Context)localObject).getString(2131300443), "", 2131231813, 0);
            continue;
            localObject = new ab.d(13, ((Context)localObject).getString(2131303623), "", 2131231825, 0);
            continue;
            localObject = new ab.d(14, ((Context)localObject).getString(2131301773), "", 2131231819, 0);
            continue;
            localObject = new ab.d(16, ((Context)localObject).getString(2131303187), "", 2131231828, 0);
            continue;
            localObject = new ab.d(17, ((Context)localObject).getString(2131301529), "", 2131231816, 0);
            continue;
            localObject = new ab.d(18, ((Context)localObject).getString(2131299910), "", 2131231822, 0);
            continue;
            localObject = new ab.d(19, ((Context)localObject).getString(2131299913), "", 2131230731, 0);
            continue;
            aw.aaz();
            if (((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue() > 1) {
              break;
            }
            localObject = new ab.d(20, ((Context)localObject).getString(2131296499), "", 2131231911, 0);
            continue;
            localObject = new ab.d(2147483647, ((Context)localObject).getString(2131303258), "", 2131231812, 0);
            continue;
            localObject = new ab.d(2147483645, ((Context)localObject).getString(2131303236), "", 2131231812, 0);
            continue;
            aw.aaz();
            if (((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue() != 8) {
              break;
            }
            localObject = new ab.d(22, ((Context)localObject).getString(2131302159), "", 2131231793, 0);
            continue;
            localObject = new ab.d(2147483646, "TIT", "", 2131231806, 0);
          }
        }
      }
    }
  }
  
  public final BaseAdapter Kp()
  {
    AppMethodBeat.i(29849);
    if (this.zez == null) {
      this.zez = new ab.a(this, (byte)0);
    }
    ab.a locala = this.zez;
    AppMethodBeat.o(29849);
    return locala;
  }
  
  public final boolean gr()
  {
    int k = 0;
    AppMethodBeat.i(29846);
    this.zeA.qz(false);
    if (this.zeA.zex.size() != 0) {
      this.zex = this.zeA.zex;
    }
    try
    {
      aw.aaz();
      if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yAH, Boolean.FALSE)).booleanValue())
      {
        int i = k;
        while (i < this.zex.size())
        {
          int j = ((ab.c)this.zex.get(i)).zeH.zeK;
          if (j != 2147483646)
          {
            i += 1;
            continue;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.zex != null)
            {
              this.zex.clear();
              label132:
              if (!bo.hl(this.mContext)) {
                break label221;
              }
            }
            label221:
            for (int[] arrayOfInt = zeC;; arrayOfInt = zeB)
            {
              int m = arrayOfInt.length;
              i = 0;
              j = 0;
              while (i < m)
              {
                ab.c localc = new ab.c(Ou(arrayOfInt[i]));
                if (localc.zeH != null) {
                  this.zex.put(j, localc);
                }
                j += 1;
                i += 1;
              }
              this.zex = new SparseArray();
              break label132;
            }
          }
        }
        if (i == this.zex.size()) {
          this.zex.put(this.zex.size(), new ab.c(Ou(2147483646)));
        }
      }
    }
    catch (Exception localException)
    {
      label266:
      boolean bool;
      break label266;
    }
    if (this.zez != null) {
      this.zez.notifyDataSetChanged();
    }
    bool = super.gr();
    AppMethodBeat.o(29846);
    return bool;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    boolean bool2 = false;
    AppMethodBeat.i(29847);
    if ((this.mContext instanceof AppCompatActivity)) {
      ((AppCompatActivity)this.mContext).supportInvalidateOptionsMenu();
    }
    int j = ((ab.c)this.zex.get(paramInt)).zeH.zeK;
    com.tencent.mm.plugin.report.service.h.qsU.e(11104, new Object[] { Integer.valueOf(j) });
    if (com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.widget.recentview.d.class) != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).aOy();
    }
    switch (j)
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
        this.zeA.Ot(j);
        dismiss();
        AppMethodBeat.o(29847);
        return;
        new Intent().putExtra("invite_friend_scene", 2);
        com.tencent.mm.bq.d.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
        continue;
        paramAdapterView = new Intent(this.mContext, SelectContactUI.class);
        paramAdapterView.putExtra("titile", this.mContext.getString(2131296500));
        paramAdapterView.putExtra("list_type", 0);
        paramAdapterView.putExtra("list_attr", com.tencent.mm.ui.contact.t.F(new int[] { com.tencent.mm.ui.contact.t.AdV, 256, 512 }));
        paramAdapterView.putExtra("scene", 7);
        this.mContext.startActivity(paramAdapterView);
        continue;
        paramAdapterView = new Intent();
        paramAdapterView.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
        this.mContext.startActivity(paramAdapterView);
        continue;
        paramAdapterView = new tl();
        paramAdapterView.cJT.cJV = true;
        com.tencent.mm.sdk.b.a.ymk.l(paramAdapterView);
        paramAdapterView = paramAdapterView.cJU.cJX;
        if (!bo.isNullOrNil(paramAdapterView))
        {
          com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: ".concat(String.valueOf(paramAdapterView)));
          com.tencent.mm.ui.base.h.d(this.mContext, this.mContext.getString(2131304232), "", this.mContext.getString(2131297018), this.mContext.getString(2131296888), new ab.1(this), new ab.2(this));
        }
        else
        {
          VoipAddressUI.iq(this.mContext);
          continue;
          aw.aaz();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.t.ii(this.mContext);
          }
          else
          {
            aw.aaz();
            paramAdapterView = (String)com.tencent.mm.model.c.Ru().get(2, null);
            paramView = new Intent();
            paramView.putExtra("sns_userName", paramAdapterView);
            paramView.setFlags(536870912);
            paramView.addFlags(67108864);
            aw.aaz();
            paramInt = bo.a((Integer)com.tencent.mm.model.c.Ru().get(68389, null), 0);
            aw.aaz();
            com.tencent.mm.model.c.Ru().set(68389, Integer.valueOf(paramInt + 1));
            paramView.putExtra("sns_adapter_type", 1);
            com.tencent.mm.bq.d.b(this.mContext, "sns", ".ui.SnsTimeLineUserPagerUI", paramView);
            continue;
            b.b(this.mContext, ".ui.FavoriteIndexUI", new Intent());
            continue;
            com.tencent.mm.bq.d.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
            continue;
            paramAdapterView = new Intent();
            paramAdapterView.putExtra("preceding_scence", 2);
            com.tencent.mm.bq.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", paramAdapterView);
            continue;
            com.tencent.mm.bq.d.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
            continue;
            com.tencent.mm.plugin.report.service.h.qsU.e(11265, new Object[] { Integer.valueOf(3) });
            if ((!com.tencent.mm.r.a.bN(this.mContext)) && (!com.tencent.mm.bg.e.alb()))
            {
              paramAdapterView = new Intent();
              paramAdapterView.putExtra("key_scan_entry_scene", 1);
              com.tencent.mm.bq.d.b(this.mContext, "scanner", ".ui.BaseScanUI", paramAdapterView);
              continue;
              aw.aaz();
              if (com.tencent.mm.model.c.isSDCardAvailable()) {
                break;
              }
              com.tencent.mm.ui.base.t.ii(this.mContext);
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.Cx(10);
      aw.aaz();
      paramAdapterView = (String)com.tencent.mm.model.c.Ru().get(68377, null);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(68377, "");
      paramView = new Intent();
      paramView.putExtra("sns_timeline_NeedFirstLoadint", true);
      if (bo.isNullOrNil(paramAdapterView)) {
        break;
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if (n.raS != null) {
        if (n.raS.bbZ() > 0) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        paramView.putExtra("sns_resume_state", bool1);
        com.tencent.mm.bq.d.b(this.mContext, "sns", ".ui.SnsTimeLineUI", paramView);
        break;
        continue;
        aw.aaz();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.t.ii(this.mContext);
          break;
        }
        com.tencent.mm.bq.d.H(this.mContext, "game", ".ui.GameCenterUI");
        new ak().postDelayed(new ab.3(this), 100L);
        break;
        com.tencent.mm.sdk.b.a.ymk.l(new oo());
        com.tencent.mm.bq.d.H(this.mContext, "shake", ".ui.ShakeReportUI");
        break;
        aw.aaz();
        if (!bo.e((Boolean)com.tencent.mm.model.c.Ru().get(4103, null)))
        {
          com.tencent.mm.bq.d.H(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
          break;
        }
        paramAdapterView = bp.abb();
        if (paramAdapterView == null)
        {
          com.tencent.mm.bq.d.H(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
          break;
        }
        paramView = bo.nullAsNil(paramAdapterView.getProvince());
        paramInt = bo.a(Integer.valueOf(paramAdapterView.dqC), 0);
        if ((bo.isNullOrNil(paramView)) || (paramInt == 0))
        {
          com.tencent.mm.bq.d.H(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
          break;
        }
        aw.aaz();
        paramAdapterView = (Boolean)com.tencent.mm.model.c.Ru().get(4104, null);
        if ((paramAdapterView == null) || (!paramAdapterView.booleanValue()))
        {
          paramAdapterView = LauncherUI.getInstance();
          if (paramAdapterView != null) {
            paramAdapterView.yYT.getMainTabUI().atp("tab_find_friend");
          }
          com.tencent.mm.bo.a.fF(this.mContext);
          break;
        }
        paramAdapterView = View.inflate(this.mContext, 2130969978, null);
        paramView = (CheckBox)paramAdapterView.findViewById(2131825412);
        paramView.setChecked(false);
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131297087), paramAdapterView, new ab.4(this, paramView), null);
        break;
        aw.aaz();
        if (com.tencent.mm.model.c.Yw())
        {
          com.tencent.mm.bq.d.H(this.mContext, "webwx", ".ui.WebWXLogoutUI");
          break;
        }
        com.tencent.mm.bq.d.H(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
        break;
        if ((com.tencent.mm.model.r.Zy() & 0x10000) == 0) {}
        for (paramInt = i;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label1440;
          }
          com.tencent.mm.bq.d.H(this.mContext, "masssend", ".ui.MassSendHistoryUI");
          break;
        }
        label1440:
        com.tencent.mm.bq.d.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
        break;
        com.tencent.mm.bq.d.H(this.mContext, "radar", ".ui.RadarSearchUI");
        break;
        com.tencent.mm.bq.d.H(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
        break;
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10919, "1-6");
        com.tencent.mm.pluginsdk.e.fJ(this.mContext);
        break;
        paramAdapterView = new Intent();
        aw.aaz();
        paramView = (String)com.tencent.mm.model.c.Ru().get(ac.a.yGw, "");
        if (!bo.isNullOrNil(paramView))
        {
          paramAdapterView.putExtra("rawUrl", paramView);
          paramAdapterView.putExtra("showShare", true);
          paramAdapterView.putExtra("show_bottom", false);
          com.tencent.mm.bq.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramAdapterView);
          break;
        }
        com.tencent.mm.pluginsdk.e.fJ(this.mContext);
        break;
        paramAdapterView = this.mContext;
        paramView = new Intent();
        paramView.putExtra("key_from_scene", 2);
        com.tencent.mm.bq.d.b(paramAdapterView, "offline", ".ui.WalletOfflineEntranceUI", paramView);
        if (!com.tencent.mm.x.c.PJ().cd(262159, 266248)) {
          break;
        }
        com.tencent.mm.x.c.PJ().ce(262159, 266248);
        com.tencent.mm.plugin.report.service.h.qsU.e(14396, new Object[] { Integer.valueOf(2) });
        break;
        com.tencent.mm.pluginsdk.wallet.h.al(this.mContext, 1);
        break;
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("key_from_scene", 2);
        com.tencent.mm.bq.d.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", paramAdapterView);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ab
 * JD-Core Version:    0.7.0.1
 */