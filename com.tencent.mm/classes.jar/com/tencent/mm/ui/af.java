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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.widget.recent.l;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.wallet_core.c.aa;
import java.io.IOException;

public final class af
  extends com.tencent.mm.ui.tools.t
  implements com.tencent.mm.ak.i
{
  private static final int[] OKj = { 2, 1, 10, 20, 2147483647 };
  private static final int[] OKk = { 2, 1, 10, 2147483647 };
  private static final int[] OKl = { 2, 1, 10 };
  private boolean IqH;
  private SparseArray<c> OKf;
  private a OKh;
  ae OKi;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public af(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(33697);
    this.OKi = null;
    this.mContext = paramAppCompatActivity;
    this.mInflater = LayoutInflater.from(paramAppCompatActivity);
    CL(false);
    this.OKi = ae.gJy();
    AppMethodBeat.o(33697);
  }
  
  public static d all(int paramInt)
  {
    AppMethodBeat.i(33700);
    Object localObject = MMApplicationContext.getContext();
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(33700);
      return localObject;
      if (HomeUI.OCE.booleanValue())
      {
        localObject = new d(1, ((Context)localObject).getString(2131763026), "", 2131691269, 2131101414);
      }
      else
      {
        localObject = new d(1, ((Context)localObject).getString(2131763026), "", 2131691270, 0);
        continue;
        if (HomeUI.OCF.booleanValue())
        {
          localObject = new d(2, ((Context)localObject).getString(2131763029), "", 2131691282, 2131101414);
        }
        else
        {
          localObject = new d(2, ((Context)localObject).getString(2131763029), "", 2131691283, 0);
          continue;
          localObject = new d(3, ((Context)localObject).getString(2131763030), "", 2131689869, 0);
          continue;
          if (1 == Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VOIPCallType"), 0))
          {
            localObject = new d(4, ((Context)localObject).getString(2131763031), "", 2131691293, 0);
          }
          else
          {
            localObject = new d(4, ((Context)localObject).getString(2131763027), "", 2131691271, 0);
            continue;
            localObject = new d(5, ((Context)localObject).getString(2131765484), "", 2131691288, 0);
            continue;
            localObject = new d(6, ((Context)localObject).getString(2131765450), "", 2131691279, 0);
            continue;
            localObject = new d(7, ((Context)localObject).getString(2131765452), "", 2131691274, 0);
            continue;
            localObject = new d(8, ((Context)localObject).getString(2131758601), "", 2131691277, 0);
            continue;
            localObject = new d(9, ((Context)localObject).getString(2131765490), "", 2131691286, 0);
            continue;
            localObject = new d(10, ((Context)localObject).getString(2131759428), "", 2131691289, 0);
            continue;
            localObject = new d(11, ((Context)localObject).getString(2131766032), "", 2131691285, 0);
            continue;
            localObject = new d(12, ((Context)localObject).getString(2131761327), "", 2131691281, 0);
            continue;
            localObject = new d(13, ((Context)localObject).getString(2131765793), "", 2131691292, 0);
            continue;
            localObject = new d(14, ((Context)localObject).getString(2131763462), "", 2131691287, 0);
            continue;
            localObject = new d(16, ((Context)localObject).getString(2131765322), "", 2131691295, 0);
            continue;
            localObject = new d(17, ((Context)localObject).getString(2131762964), "", 2131691284, 0);
            continue;
            localObject = new d(18, ((Context)localObject).getString(2131759430), "", 2131691290, 0);
            continue;
            localObject = new d(19, ((Context)localObject).getString(2131759433), "", 2131689486, 0);
            continue;
            bg.aVF();
            if (((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue() > 1) {
              break;
            }
            localObject = new d(20, ((Context)localObject).getString(2131755265), "", 2131691385, 0, "plus_receiveorpay");
            continue;
            localObject = new d(2147483647, ((Context)localObject).getString(2131765396), "", 2131691280, 0);
            continue;
            localObject = new d(2147483645, ((Context)localObject).getString(2131765372), "", 2131691280, 0);
            continue;
            bg.aVF();
            paramInt = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
            int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZZ, 0);
            if ((paramInt != 8) || (i != 0)) {
              break;
            }
            localObject = new d(22, ((Context)localObject).getString(2131764009), "", 2131691261, 0);
            continue;
            bg.aVF();
            paramInt = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
            i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZZ, 0);
            if ((paramInt != 8) || (i != 1)) {
              break;
            }
            localObject = new d(24, ((Context)localObject).getString(2131764010), "", 2131691385, 0);
            continue;
            localObject = new d(2147483646, "TIT", "", 2131691274, 0);
          }
        }
      }
    }
  }
  
  private static daj fUn()
  {
    AppMethodBeat.i(232708);
    Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig");
    daj localdaj = new daj();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.OnN, null);
    if (Util.isNullOrNil(str)) {
      Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 get PayIBGQuickGetOverseaWalletConfig failed");
    }
    for (;;)
    {
      AppMethodBeat.o(232708);
      return localdaj;
      try
      {
        localdaj.parseFrom(str.getBytes("ISO-8859-1"));
        Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig success");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.PlusSubMenuHelper", "OfflineH5 parse PayIBGQuickGetOverseaWalletConfig fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  private boolean fUo()
  {
    AppMethodBeat.i(232710);
    String str = Util.getTopActivityName2(this.mContext);
    if ((!Util.isNullOrNil(str)) && (str.equals("LauncherUI")))
    {
      Log.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is on ActivityTask Top ");
      AppMethodBeat.o(232710);
      return true;
    }
    Log.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is not on ActivityTask Top：%s", new Object[] { str });
    AppMethodBeat.o(232710);
    return false;
  }
  
  private void yz(boolean paramBoolean)
  {
    AppMethodBeat.i(232707);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.plugin.wallet_index.c.a.b localb = new com.tencent.mm.plugin.wallet_index.c.a.b(((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue());
    bg.azz().a(localb, 0);
    this.IqH = paramBoolean;
    AppMethodBeat.o(232707);
  }
  
  public final BaseAdapter anl()
  {
    AppMethodBeat.i(33701);
    if (this.OKh == null) {
      this.OKh = new a((byte)0);
    }
    a locala = this.OKh;
    AppMethodBeat.o(33701);
    return locala;
  }
  
  public final boolean iv()
  {
    int k = 0;
    AppMethodBeat.i(33698);
    this.OKi.Bs(false);
    if (this.OKi.OKf.size() != 0) {
      this.OKf = this.OKi.OKf;
    }
    try
    {
      bg.aVF();
      if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NVJ, Boolean.FALSE)).booleanValue())
      {
        int i = k;
        while (i < this.OKf.size())
        {
          int j = ((c)this.OKf.get(i)).OKp.OKs;
          if (j != 2147483646)
          {
            i += 1;
            continue;
            Log.i("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            label132:
            int[] arrayOfInt;
            if (this.OKf != null)
            {
              this.OKf.clear();
              if (!WeChatBrands.Business.Entries.HomeMoreFeedback.banned()) {
                break label220;
              }
              arrayOfInt = OKl;
            }
            for (;;)
            {
              int m = arrayOfInt.length;
              i = 0;
              j = 0;
              while (i < m)
              {
                c localc = new c(all(arrayOfInt[i]));
                if (localc.OKp != null) {
                  this.OKf.put(j, localc);
                }
                j += 1;
                i += 1;
              }
              this.OKf = new SparseArray();
              break label132;
              label220:
              if (Util.isOverseasUser(this.mContext)) {
                arrayOfInt = OKk;
              } else {
                arrayOfInt = OKj;
              }
            }
          }
        }
        if (i == this.OKf.size()) {
          this.OKf.put(this.OKf.size(), new c(all(2147483646)));
        }
      }
    }
    catch (Exception localException)
    {
      label283:
      boolean bool;
      break label283;
    }
    if (this.OKh != null) {
      this.OKh.notifyDataSetChanged();
    }
    bool = super.iv();
    AppMethodBeat.o(33698);
    return bool;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33699);
    if ((this.mContext instanceof AppCompatActivity)) {
      ((AppCompatActivity)this.mContext).supportInvalidateOptionsMenu();
    }
    int i = ((c)this.OKf.get(paramInt)).OKp.OKs;
    paramAdapterView = new com.tencent.mm.hellhoundlib.b.b();
    paramAdapterView.pH(i);
    paramAdapterView.pH(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/PlusSubMenuHelper", "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", this, paramAdapterView.axR());
    com.tencent.mm.plugin.report.service.h.CyF.a(11104, new Object[] { Integer.valueOf(i) });
    if (com.tencent.mm.kernel.g.af(l.class) != null) {
      ((l)com.tencent.mm.kernel.g.af(l.class)).ccV();
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
        this.OKi.alk(i);
        dismiss();
        AppMethodBeat.o(33699);
        return;
        new Intent().putExtra("invite_friend_scene", 2);
        com.tencent.mm.br.c.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
        continue;
        paramView = new Intent(this.mContext, SelectContactUI.class);
        paramView.putExtra("titile", this.mContext.getString(2131755266));
        paramView.putExtra("list_type", 0);
        paramView.putExtra("list_attr", com.tencent.mm.ui.contact.u.Q(new int[] { com.tencent.mm.ui.contact.u.PWU, 256, 512 }));
        paramView.putExtra("scene", 7);
        paramView.putExtra("menu_mode", 2);
        paramView.putExtra("create_group_recommend", true);
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.axQ(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramView = new Intent();
        paramView.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.axQ(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramAdapterView = new xq();
        paramAdapterView.edR.edT = true;
        EventCenter.instance.publish(paramAdapterView);
        paramAdapterView = paramAdapterView.edS.edV;
        if (!Util.isNullOrNil(paramAdapterView))
        {
          Log.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: ".concat(String.valueOf(paramAdapterView)));
          com.tencent.mm.ui.base.h.c(this.mContext, this.mContext.getString(2131766611), "", this.mContext.getString(2131755921), this.mContext.getString(2131755761), new af.1(this), new af.2(this));
        }
        else
        {
          VoipAddressUI.kp(this.mContext);
          continue;
          bg.aVF();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.u.g(this.mContext, null);
          }
          else
          {
            bg.aVF();
            paramAdapterView = (String)com.tencent.mm.model.c.azQ().get(2, null);
            paramView = new Intent();
            paramView.putExtra("sns_userName", paramAdapterView);
            paramView.setFlags(536870912);
            paramView.addFlags(67108864);
            bg.aVF();
            paramInt = Util.nullAs((Integer)com.tencent.mm.model.c.azQ().get(68389, null), 0);
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(68389, Integer.valueOf(paramInt + 1));
            paramView.putExtra("sns_adapter_type", 1);
            com.tencent.mm.br.c.b(this.mContext, "sns", ".ui.SnsTimeLineUserPagerUI", paramView);
            continue;
            com.tencent.mm.plugin.fav.a.b.b(this.mContext, ".ui.FavoriteIndexUI", new Intent());
            continue;
            bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sad, true);
            Log.i("MicroMsg.PlusSubMenuHelper", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool1) });
            if (bool1)
            {
              com.tencent.mm.br.c.b(this.mContext, "mall", ".ui.MallIndexUIv2", new Intent());
            }
            else
            {
              com.tencent.mm.br.c.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
              continue;
              paramAdapterView = new Intent();
              paramAdapterView.putExtra("preceding_scence", 2);
              com.tencent.mm.br.c.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", paramAdapterView);
              continue;
              com.tencent.mm.br.c.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
              continue;
              com.tencent.mm.plugin.report.service.h.CyF.a(11265, new Object[] { Integer.valueOf(3) });
              if ((!com.tencent.mm.q.a.o(this.mContext, true)) && (!com.tencent.mm.bh.e.bgF()) && (!com.tencent.mm.q.a.r(this.mContext, true)))
              {
                paramAdapterView = new Intent();
                paramAdapterView.putExtra("key_scan_entry_scene", 1);
                paramAdapterView.putExtra("key_config_black_interval", true);
                paramAdapterView.putExtra("key_enable_multi_code", true);
                paramAdapterView.putExtra("key_scan_goods_enable_dynamic_wording", true);
                com.tencent.mm.br.c.b(this.mContext, "scanner", ".ui.BaseScanUI", paramAdapterView);
                continue;
                bg.aVF();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                  break;
                }
                com.tencent.mm.ui.base.u.g(this.mContext, null);
              }
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.Wl(10);
      bg.aVF();
      paramAdapterView = (String)com.tencent.mm.model.c.azQ().get(68377, null);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(68377, "");
      paramView = new Intent();
      paramView.putExtra("sns_timeline_NeedFirstLoadint", true);
      if (Util.isNullOrNil(paramAdapterView)) {
        break;
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (o.DCO != null)
      {
        bool2 = bool1;
        if (o.DCO.ctM() > 0) {
          bool2 = false;
        }
      }
      paramView.putExtra("sns_resume_state", bool2);
      com.tencent.mm.br.c.b(this.mContext, "sns", ".ui.SnsTimeLineUI", paramView);
      break;
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.u.g(this.mContext, null);
        break;
      }
      com.tencent.mm.br.c.V(this.mContext, "game", ".ui.GameCenterUI");
      new MMHandler().postDelayed(new af.3(this), 100L);
      break;
      EventCenter.instance.publish(new rv());
      com.tencent.mm.br.c.V(this.mContext, "shake", ".ui.ShakeReportUI");
      break;
      bg.aVF();
      if (!Util.nullAsFalse((Boolean)com.tencent.mm.model.c.azQ().get(4103, null)))
      {
        com.tencent.mm.br.c.V(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
        break;
      }
      paramAdapterView = bz.aWk();
      if (paramAdapterView == null)
      {
        com.tencent.mm.br.c.V(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      paramView = Util.nullAsNil(paramAdapterView.getProvince());
      paramInt = Util.nullAs(Integer.valueOf(paramAdapterView.fuA), 0);
      if ((Util.isNullOrNil(paramView)) || (paramInt == 0))
      {
        com.tencent.mm.br.c.V(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      bg.aVF();
      paramAdapterView = (Boolean)com.tencent.mm.model.c.azQ().get(4104, null);
      if ((paramAdapterView == null) || (!paramAdapterView.booleanValue()))
      {
        paramAdapterView = LauncherUI.getInstance();
        if (paramAdapterView != null) {
          paramAdapterView.ODR.getMainTabUI().blU("tab_find_friend");
        }
        com.tencent.mm.bp.a.ih(this.mContext);
        break;
      }
      paramAdapterView = View.inflate(this.mContext, 2131495206, null);
      paramView = (CheckBox)paramAdapterView.findViewById(2131303120);
      paramView.setChecked(false);
      com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131755998), paramAdapterView, new af.4(this, paramView), null);
      break;
      bg.aVF();
      if (com.tencent.mm.model.c.azn())
      {
        com.tencent.mm.br.c.V(this.mContext, "webwx", ".ui.WebWXLogoutUI");
        break;
      }
      com.tencent.mm.br.c.V(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
      break;
      if ((z.aUl() & 0x10000) == 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label1765;
        }
        com.tencent.mm.br.c.V(this.mContext, "masssend", ".ui.MassSendHistoryUI");
        break;
      }
      label1765:
      com.tencent.mm.br.c.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
      break;
      com.tencent.mm.br.c.V(this.mContext, "radar", ".ui.RadarSearchUI");
      break;
      com.tencent.mm.br.c.V(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      break;
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(10919, "1-6");
      com.tencent.mm.pluginsdk.g.il(this.mContext);
      break;
      paramAdapterView = new Intent();
      bg.aVF();
      paramView = (String)com.tencent.mm.model.c.azQ().get(ar.a.ObY, "");
      if (!Util.isNullOrNil(paramView))
      {
        paramAdapterView.putExtra("rawUrl", paramView);
        paramAdapterView.putExtra("showShare", true);
        paramAdapterView.putExtra("show_bottom", false);
        com.tencent.mm.br.c.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramAdapterView);
        break;
      }
      com.tencent.mm.pluginsdk.g.il(this.mContext);
      break;
      if (!WeChatBrands.Business.Entries.HomeMorePayment.checkAvailable(this.mContext)) {
        break;
      }
      com.tencent.mm.plugin.newtips.a.exl().TC(4);
      paramAdapterView = this.mContext;
      paramView = new Intent();
      paramView.putExtra("key_from_scene", 2);
      com.tencent.mm.br.c.b(paramAdapterView, "offline", ".ui.WalletOfflineEntranceUI", paramView);
      if (!com.tencent.mm.y.c.axV().cP(262159, 266248)) {
        break;
      }
      com.tencent.mm.y.c.axV().cQ(262159, 266248);
      com.tencent.mm.plugin.report.service.h.CyF.a(14396, new Object[] { Integer.valueOf(2) });
      break;
      com.tencent.mm.pluginsdk.wallet.f.aD(this.mContext, 1);
      break;
      com.tencent.mm.kernel.g.azz().a(2540, this);
      paramAdapterView = fUn();
      if (Util.isNullOrNil(paramAdapterView.MFD))
      {
        Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 has no cache");
        yz(false);
        break;
      }
      paramLong = System.currentTimeMillis();
      long l = paramLong - paramAdapterView.MFF;
      Log.i("MicroMsg.PlusSubMenuHelper", "currentTime ：%s ,lastTime：%s,internalTime ：%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramAdapterView.MFF), Long.valueOf(l) });
      if (l < paramAdapterView.MFE)
      {
        Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 dont expired，url：%s", new Object[] { paramAdapterView.MFD });
        com.tencent.mm.wallet_core.ui.f.o(this.mContext, paramAdapterView.MFD, false);
        yz(true);
        break;
      }
      Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 is expired");
      yz(false);
      break;
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("key_from_scene", 2);
      com.tencent.mm.br.c.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", paramAdapterView);
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(232709);
    Log.i("MicroMsg.PlusSubMenuHelper", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof com.tencent.mm.plugin.wallet_index.c.a.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label365;
      }
      paramq = ((com.tencent.mm.plugin.wallet_index.c.a.b)paramq).fUq();
      if (paramq.dOK != 0) {
        break label305;
      }
      Log.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd ok，pay_wallet_wxapp_h5_url：%s, cache_time：%s", new Object[] { paramq.MFD, Integer.valueOf(paramq.MFE) });
      if ((!this.IqH) && (fUo()))
      {
        Log.i("MicroMsg.PlusSubMenuHelper", "on Scene End jump h5 ");
        com.tencent.mm.wallet_core.ui.f.o(this.mContext, paramq.MFD, false);
      }
      paramq.MFF = System.currentTimeMillis();
      Log.i("MicroMsg.PlusSubMenuHelper", "on Scene End currentTime ：%s ", new Object[] { Long.valueOf(paramq.MFF) });
      Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 setConfig");
      paramString = " ";
      if (paramq == null) {}
    }
    for (;;)
    {
      try
      {
        paramString = new String(paramq.toByteArray(), "ISO-8859-1");
        Log.e("MicroMsg.PlusSubMenuHelper", "save config exp, " + paramq.getLocalizedMessage());
      }
      catch (IOException paramq)
      {
        try
        {
          Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 setConfig success");
          ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.OnN, paramString);
          ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().gBI();
          com.tencent.mm.kernel.g.azz().b(2540, this);
          AppMethodBeat.o(232709);
          return;
        }
        catch (IOException paramq)
        {
          break label275;
        }
        paramq = paramq;
        paramString = " ";
      }
      label275:
      continue;
      label305:
      Log.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd failed show dialog ");
      if ((!this.IqH) && (fUo()))
      {
        com.tencent.mm.ui.base.h.a(this.mContext, paramq.dOL, "", this.mContext.getString(2131768713), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(232703);
            Log.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
            AppMethodBeat.o(232703);
          }
        });
        continue;
        label365:
        Log.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd faile show error dialog ");
        if ((!this.IqH) && (fUo())) {
          com.tencent.mm.ui.base.h.a(this.mContext, paramString, "", this.mContext.getString(2131768713), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(232704);
              Log.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
              AppMethodBeat.o(232704);
            }
          });
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
      int i = af.a(af.this).size();
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
      paramView = (af.c)af.a(af.this).get(paramInt);
      paramView = new af.e(af.b(af.this), paramView);
      LayoutInflater localLayoutInflater = af.c(af.this);
      label254:
      boolean bool;
      if (paramInt == getCount() - 1)
      {
        paramInt = 1;
        paramView.gvQ = localLayoutInflater.inflate(2131495643, paramViewGroup, false);
        paramView.hbb = ((TextView)paramView.gvQ.findViewById(2131309195));
        paramView.kc = ((ImageView)paramView.gvQ.findViewById(2131302468));
        paramView.OKu = ((TextView)paramView.gvQ.findViewById(2131305369));
        paramView.OKv = ((TextView)paramView.gvQ.findViewById(2131309592));
        paramView.OKw = paramView.gvQ.findViewById(2131305309);
        if (!Util.isNullOrNil(paramView.OKt.OKp.OKq)) {
          paramView.hbb.setText(paramView.OKt.OKp.OKq);
        }
        if (paramView.OKt.OKp.textColor > 0) {
          paramView.hbb.setTextColor(com.tencent.mm.cb.a.n(MMApplicationContext.getContext(), paramView.OKt.OKp.textColor));
        }
        if (paramView.OKt.OKp.icon <= 0) {
          break label425;
        }
        paramView.kc.setVisibility(0);
        paramView.kc.setImageResource(paramView.OKt.OKp.icon);
        if (!Util.isNullOrNil(paramView.OKt.OKp.OKr)) {
          paramView.kc.setContentDescription(paramView.OKt.OKp.OKr);
        }
        paramView.OKv.setBackgroundResource(v.kH(paramView.context));
        if (paramInt == 0) {
          break label437;
        }
        paramView.gvQ.setBackgroundResource(2131235154);
        label314:
        paramView.OKu.setTextSize(0, com.tencent.mm.cb.a.aH(paramView.context, 2131167085));
        if ((!paramView.OKt.gYN) && (paramView.OKt.dCm <= 0) && (!paramView.OKt.OKo)) {
          break label449;
        }
        bool = true;
        label365:
        if (!com.tencent.mm.plugin.newtips.a.g.a(bool, paramView))
        {
          if (!paramView.OKt.gYN) {
            break label455;
          }
          paramView.OKu.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.ADH, true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.newtips.a.exl().h(paramView);
        paramView = paramView.gvQ;
        AppMethodBeat.o(33691);
        return paramView;
        paramInt = 0;
        break;
        label425:
        paramView.kc.setVisibility(8);
        break label254;
        label437:
        paramView.gvQ.setBackgroundResource(2131235153);
        break label314;
        label449:
        bool = false;
        break label365;
        label455:
        if (paramView.OKt.dCm > 0)
        {
          paramView.OKv.setVisibility(0);
          if (paramView.OKt.dCm > 99)
          {
            paramView.OKv.setText("");
            paramView.OKv.setBackgroundResource(2131689753);
          }
          for (;;)
          {
            com.tencent.mm.plugin.newtips.a.g.a(paramView, k.ADL, true);
            break;
            paramView.OKv.setText(paramView.OKt.dCm);
            paramView.OKv.setBackgroundResource(v.aQ(paramView.context, paramView.OKt.dCm));
          }
        }
        if (paramView.OKt.OKo)
        {
          paramView.OKw.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.ADG, true);
        }
        else
        {
          paramView.OKu.setVisibility(8);
          paramView.OKv.setVisibility(8);
          paramView.OKw.setVisibility(8);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.ADH, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.ADL, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.ADG, false);
        }
      }
    }
  }
  
  public static final class b
  {
    int OKn;
    int id;
    int jlm;
    int order;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2, paramInt3, 0);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.id = paramInt1;
      this.OKn = paramInt2;
      this.jlm = paramInt3;
      this.order = paramInt4;
    }
  }
  
  public static final class c
  {
    boolean OKo = false;
    af.d OKp;
    int dCm = 0;
    boolean gYN = false;
    
    public c(af.d paramd)
    {
      this.OKp = paramd;
    }
  }
  
  public static final class d
  {
    String OKq;
    String OKr;
    int OKs;
    int icon;
    String path;
    int textColor;
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramString1, paramString2, paramInt2, paramInt3, "");
    }
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
    {
      this.OKq = paramString1;
      this.OKr = paramString2;
      this.icon = paramInt2;
      this.OKs = paramInt1;
      this.textColor = paramInt3;
      this.path = paramString3;
    }
  }
  
  public static final class e
    implements com.tencent.mm.plugin.newtips.a.a
  {
    af.c OKt;
    TextView OKu;
    TextView OKv;
    View OKw;
    Context context;
    View gvQ;
    TextView hbb;
    ImageView kc;
    
    public e(Context paramContext, af.c paramc)
    {
      this.context = paramContext;
      this.OKt = paramc;
    }
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(258279);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(258279);
    }
    
    public final boolean a(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, ehv paramehv)
    {
      AppMethodBeat.i(33696);
      if (paramBoolean)
      {
        this.OKv.setVisibility(0);
        if (paramehv.ibS > 99)
        {
          this.OKv.setText("");
          this.OKv.setBackgroundResource(2131689753);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33696);
        return true;
        this.OKv.setText(paramehv.ibS);
        this.OKv.setBackgroundResource(v.aQ(this.context, paramehv.ibS));
        continue;
        this.OKv.setVisibility(8);
      }
    }
    
    public final boolean ehp()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.OKt.OKp.path;
    }
    
    public final View getRoot()
    {
      return this.gvQ;
    }
    
    public final boolean qV(boolean paramBoolean)
    {
      AppMethodBeat.i(258280);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(258280);
      return paramBoolean;
    }
    
    public final boolean qW(boolean paramBoolean)
    {
      AppMethodBeat.i(33694);
      if (paramBoolean) {
        this.OKw.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33694);
        return true;
        this.OKw.setVisibility(8);
      }
    }
    
    public final boolean qX(boolean paramBoolean)
    {
      AppMethodBeat.i(33695);
      if (paramBoolean) {
        this.OKu.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33695);
        return true;
        this.OKu.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.af
 * JD-Core Version:    0.7.0.1
 */