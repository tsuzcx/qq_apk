package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.bj.e;
import com.tencent.mm.bk.d;
import com.tencent.mm.f.a.fv;
import com.tencent.mm.f.a.sv;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.a.yx.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.wallet_core.c.aa;
import java.io.IOException;

public final class ah
  extends u
  implements com.tencent.mm.an.i
{
  private static final int[] WdE = { 2, 1, 10, 20, 2147483647 };
  private static final int[] WdF = { 2, 1, 10, 2147483647 };
  private static final int[] WdG = { 2, 1, 10 };
  private boolean Pjq;
  private SparseArray<c> WdA;
  private a WdC;
  ag WdD;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public ah(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(282612);
    this.WdD = null;
    this.mContext = paramAppCompatActivity;
    this.mInflater = LayoutInflater.from(paramAppCompatActivity);
    Hf(false);
    this.WdD = ag.hIv();
    AppMethodBeat.o(282612);
  }
  
  private void Cu(boolean paramBoolean)
  {
    AppMethodBeat.i(282618);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.plugin.wallet_index.c.a.b localb = new com.tencent.mm.plugin.wallet_index.c.a.b(((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue());
    bh.aGY().a(localb, 0);
    this.Pjq = paramBoolean;
    AppMethodBeat.o(282618);
  }
  
  public static d aui(int paramInt)
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
      if (HomeUI.VVV.booleanValue())
      {
        localObject = new d(1, ((Context)localObject).getString(R.l.eLP), "", R.k.ofm_add_green_icon, R.e.wechat_green);
      }
      else
      {
        localObject = new d(1, ((Context)localObject).getString(R.l.eLP), "", R.k.ofm_add_icon, 0);
        continue;
        if (HomeUI.VVW.booleanValue())
        {
          localObject = new d(2, ((Context)localObject).getString(R.l.eLS), "", R.k.ofm_group_chat_green_icon, R.e.wechat_green);
        }
        else
        {
          localObject = new d(2, ((Context)localObject).getString(R.l.eLS), "", R.k.ofm_group_chat_icon, 0);
          continue;
          localObject = new d(3, ((Context)localObject).getString(R.l.eLT), "", R.k.camera, 0);
          continue;
          if (1 == Util.getInt(com.tencent.mm.n.h.axc().getValue("VOIPCallType"), 0))
          {
            localObject = new d(4, ((Context)localObject).getString(R.l.eLU), "", R.k.ofm_video_icon, 0);
          }
          else
          {
            localObject = new d(4, ((Context)localObject).getString(R.l.eLQ), "", R.k.ofm_audio_icon, 0);
            continue;
            localObject = new d(5, ((Context)localObject).getString(R.l.settings_my_album), "", R.k.ofm_pic_icon, 0);
            continue;
            localObject = new d(6, ((Context)localObject).getString(R.l.settings_mm_favorite), "", R.k.ofm_favourite_icon, 0);
            continue;
            localObject = new d(7, ((Context)localObject).getString(R.l.settings_mm_wallet), "", R.k.ofm_card_icon, 0);
            continue;
            localObject = new d(8, ((Context)localObject).getString(R.l.emoji_store), "", R.k.ofm_emostore_icon, 0);
            continue;
            localObject = new d(9, ((Context)localObject).getString(R.l.settings_my_qrcode), "", R.k.ofm_myqrcode_icon, 0);
            continue;
            localObject = new d(10, ((Context)localObject).getString(R.l.find_friends_by_qrcode), "", R.k.ofm_qrcode_icon, 0);
            continue;
            localObject = new d(11, ((Context)localObject).getString(R.l.sns_dyna_photo_ui_title), "", R.k.ofm_moment_icon, 0);
            continue;
            localObject = new d(12, ((Context)localObject).getString(R.l.eGg), "", R.k.ofm_gamecenter_icon, 0);
            continue;
            localObject = new d(13, ((Context)localObject).getString(R.l.shake_report_title), "", R.k.ofm_shake_icon, 0);
            continue;
            localObject = new d(14, ((Context)localObject).getString(R.l.nearby_friend_title), "", R.k.ofm_nearby_icon, 0);
            continue;
            localObject = new d(16, ((Context)localObject).getString(R.l.settings_WebWX), "", R.k.ofm_webwechat_icon, 0);
            continue;
            localObject = new d(17, ((Context)localObject).getString(R.l.eLB), "", R.k.ofm_groupmessage_icon, 0);
            continue;
            localObject = new d(18, ((Context)localObject).getString(R.l.find_friends_by_radar), "", R.k.ofm_radar_icon, 0);
            continue;
            localObject = new d(19, ((Context)localObject).getString(R.l.eFc), "", R.k.actionbar_facefriend_icon, 0);
            continue;
            bh.beI();
            if (((Integer)com.tencent.mm.model.c.aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue() > 1) {
              break;
            }
            localObject = new d(20, ((Context)localObject).getString(R.l.enU), "", R.k.receipt_payment_icon, 0, "plus_receiveorpay");
            continue;
            localObject = new d(2147483647, ((Context)localObject).getString(R.l.settings_feedback), "", R.k.ofm_feedback_icon, 0);
            continue;
            localObject = new d(2147483645, ((Context)localObject).getString(R.l.settings_crowdtest_feedback), "", R.k.ofm_feedback_icon, 0);
            continue;
            bh.beI();
            paramInt = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
            int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHb, 0);
            if ((paramInt != 8) || (i != 0)) {
              break;
            }
            localObject = new d(22, ((Context)localObject).getString(R.l.eOV), "", R.k.offline_entrance_f2f_collect_hk, 0);
            continue;
            bh.beI();
            paramInt = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
            i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHb, 0);
            if ((paramInt != 8) || (i != 1)) {
              break;
            }
            localObject = new d(24, ((Context)localObject).getString(R.l.eOW), "", R.k.receipt_payment_icon, 0);
            continue;
            localObject = new d(2147483646, "TIT", "", R.k.ofm_card_icon, 0);
          }
        }
      }
    }
  }
  
  private static djx gMT()
  {
    AppMethodBeat.i(282619);
    Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig");
    djx localdjx = new djx();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.VDb, null);
    if (Util.isNullOrNil(str)) {
      Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 get PayIBGQuickGetOverseaWalletConfig failed");
    }
    for (;;)
    {
      AppMethodBeat.o(282619);
      return localdjx;
      try
      {
        localdjx.parseFrom(str.getBytes("ISO-8859-1"));
        Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig success");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.PlusSubMenuHelper", "OfflineH5 parse PayIBGQuickGetOverseaWalletConfig fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  private boolean gMU()
  {
    AppMethodBeat.i(282623);
    String str = Util.getTopActivityName2(this.mContext);
    if ((!Util.isNullOrNil(str)) && (str.equals("LauncherUI")))
    {
      Log.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is on ActivityTask Top ");
      AppMethodBeat.o(282623);
      return true;
    }
    Log.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is not on ActivityTask Top：%s", new Object[] { str });
    AppMethodBeat.o(282623);
    return false;
  }
  
  public final BaseAdapter atn()
  {
    AppMethodBeat.i(33701);
    if (this.WdC == null) {
      this.WdC = new a((byte)0);
    }
    a locala = this.WdC;
    AppMethodBeat.o(33701);
    return locala;
  }
  
  public final boolean cB()
  {
    int k = 0;
    AppMethodBeat.i(33698);
    this.WdD.FJ(false);
    if (this.WdD.WdA.size() != 0) {
      this.WdA = this.WdD.WdA;
    }
    try
    {
      bh.beI();
      if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.VjJ, Boolean.FALSE)).booleanValue())
      {
        int i = k;
        while (i < this.WdA.size())
        {
          int j = ((c)this.WdA.get(i)).WdK.WdN;
          if (j != 2147483646)
          {
            i += 1;
            continue;
            Log.i("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            label133:
            int[] arrayOfInt;
            if (this.WdA != null)
            {
              this.WdA.clear();
              if (!WeChatBrands.Business.Entries.HomeMoreFeedback.banned()) {
                break label221;
              }
              arrayOfInt = WdG;
            }
            for (;;)
            {
              int m = arrayOfInt.length;
              i = 0;
              j = 0;
              while (i < m)
              {
                c localc = new c(aui(arrayOfInt[i]));
                if (localc.WdK != null) {
                  this.WdA.put(j, localc);
                }
                j += 1;
                i += 1;
              }
              this.WdA = new SparseArray();
              break label133;
              label221:
              if (Util.isOverseasUser(this.mContext)) {
                arrayOfInt = WdF;
              } else {
                arrayOfInt = WdE;
              }
            }
          }
        }
        if (i == this.WdA.size()) {
          this.WdA.put(this.WdA.size(), new c(aui(2147483646)));
        }
      }
    }
    catch (Exception localException)
    {
      label285:
      boolean bool;
      break label285;
    }
    if (this.WdC != null) {
      this.WdC.notifyDataSetChanged();
    }
    bool = super.cB();
    AppMethodBeat.o(33698);
    return bool;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, final View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33699);
    if ((this.mContext instanceof AppCompatActivity)) {
      ((AppCompatActivity)this.mContext).supportInvalidateOptionsMenu();
    }
    int i = ((c)this.WdA.get(paramInt)).WdK.WdN;
    paramAdapterView = new com.tencent.mm.hellhoundlib.b.b();
    paramAdapterView.sg(i);
    paramAdapterView.sg(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/PlusSubMenuHelper", "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", this, paramAdapterView.aFi());
    com.tencent.mm.plugin.report.service.h.IzE.a(11104, new Object[] { Integer.valueOf(i) });
    if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.widget.recent.k.class) != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recent.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.widget.recent.k.class)).cqi();
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
        this.WdD.auh(i);
        dismiss();
        AppMethodBeat.o(33699);
        return;
        new Intent().putExtra("invite_friend_scene", 2);
        com.tencent.mm.by.c.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
        continue;
        paramView = new Intent(this.mContext, SelectContactUI.class);
        paramView.putExtra("titile", this.mContext.getString(R.l.address_title_launch_chatting));
        paramView.putExtra("list_type", 0);
        paramView.putExtra("list_attr", com.tencent.mm.ui.contact.w.P(new int[] { com.tencent.mm.ui.contact.w.XtM, 256, 512 }));
        paramView.putExtra("scene", 7);
        paramView.putExtra("menu_mode", 2);
        paramView.putExtra("create_group_recommend", true);
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, paramView.aFh(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramView = new Intent();
        paramView.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, paramView.aFh(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramAdapterView = new yx();
        paramAdapterView.fYg.fYi = true;
        EventCenter.instance.publish(paramAdapterView);
        paramAdapterView = paramAdapterView.fYh.fYk;
        if (!Util.isNullOrNil(paramAdapterView))
        {
          Log.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: ".concat(String.valueOf(paramAdapterView)));
          com.tencent.mm.ui.base.h.c(this.mContext, this.mContext.getString(R.l.eTP), "", this.mContext.getString(R.l.app_ok), this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(33686);
              Object localObject = new yx();
              ((yx)localObject).fYg.fYj = true;
              EventCenter.instance.publish((IEvent)localObject);
              localObject = new fv();
              ((fv)localObject).fBE.username = d.meW.bqa();
              EventCenter.instance.publish((IEvent)localObject);
              VoipAddressUI.ln(ah.b(ah.this));
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
          VoipAddressUI.ln(this.mContext);
          continue;
          bh.beI();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.w.g(this.mContext, null);
          }
          else
          {
            bh.beI();
            paramAdapterView = (String)com.tencent.mm.model.c.aHp().b(2, null);
            paramView = new Intent();
            paramView.putExtra("sns_userName", paramAdapterView);
            paramView.setFlags(536870912);
            paramView.addFlags(67108864);
            bh.beI();
            paramInt = Util.nullAs((Integer)com.tencent.mm.model.c.aHp().b(68389, null), 0);
            bh.beI();
            com.tencent.mm.model.c.aHp().i(68389, Integer.valueOf(paramInt + 1));
            paramView.putExtra("sns_adapter_type", 1);
            com.tencent.mm.by.c.b(this.mContext, "sns", ".ui.SnsTimeLineUserPagerUI", paramView);
            continue;
            com.tencent.mm.plugin.fav.a.b.b(this.mContext, ".ui.FavoriteIndexUI", new Intent());
            continue;
            bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHh, true);
            Log.i("MicroMsg.PlusSubMenuHelper", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool1) });
            if (bool1)
            {
              com.tencent.mm.by.c.b(this.mContext, "mall", ".ui.MallIndexUIv2", new Intent());
            }
            else
            {
              com.tencent.mm.by.c.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
              continue;
              paramAdapterView = new Intent();
              paramAdapterView.putExtra("preceding_scence", 2);
              com.tencent.mm.by.c.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", paramAdapterView);
              continue;
              com.tencent.mm.by.c.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
              continue;
              com.tencent.mm.plugin.report.service.h.IzE.a(11265, new Object[] { Integer.valueOf(3) });
              if ((!com.tencent.mm.q.a.p(this.mContext, true)) && (!e.bpU()) && (!com.tencent.mm.q.a.t(this.mContext, true)))
              {
                paramAdapterView = new Intent();
                paramAdapterView.putExtra("key_scan_entry_scene", 1);
                paramAdapterView.putExtra("key_config_black_interval", true);
                paramAdapterView.putExtra("key_enable_multi_code", true);
                paramAdapterView.putExtra("key_scan_goods_enable_dynamic_wording", true);
                com.tencent.mm.by.c.b(this.mContext, "scanner", ".ui.BaseScanUI", paramAdapterView);
                continue;
                bh.beI();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                  break;
                }
                com.tencent.mm.ui.base.w.g(this.mContext, null);
              }
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.ada(10);
      bh.beI();
      paramAdapterView = (String)com.tencent.mm.model.c.aHp().b(68377, null);
      bh.beI();
      com.tencent.mm.model.c.aHp().i(68377, "");
      paramView = new Intent();
      paramView.putExtra("sns_timeline_NeedFirstLoadint", true);
      if (Util.isNullOrNil(paramAdapterView)) {
        break;
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (p.JPe != null)
      {
        bool2 = bool1;
        if (p.JPe.cHo() > 0) {
          bool2 = false;
        }
      }
      paramView.putExtra("sns_resume_state", bool2);
      com.tencent.mm.by.c.b(this.mContext, "sns", ".ui.SnsTimeLineUI", paramView);
      break;
      bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.w.g(this.mContext, null);
        break;
      }
      com.tencent.mm.by.c.ad(this.mContext, "game", ".ui.GameCenterUI");
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33688);
          com.tencent.mm.xwebutil.c.ikh();
          AppMethodBeat.o(33688);
        }
      }, 100L);
      break;
      EventCenter.instance.publish(new sv());
      com.tencent.mm.by.c.ad(this.mContext, "shake", ".ui.ShakeReportUI");
      break;
      bh.beI();
      if (!Util.nullAsFalse((Boolean)com.tencent.mm.model.c.aHp().b(4103, null)))
      {
        com.tencent.mm.by.c.ad(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
        break;
      }
      paramAdapterView = ca.bfo();
      if (paramAdapterView == null)
      {
        com.tencent.mm.by.c.ad(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      paramView = Util.nullAsNil(paramAdapterView.getProvince());
      paramInt = Util.nullAs(Integer.valueOf(paramAdapterView.sex), 0);
      if ((Util.isNullOrNil(paramView)) || (paramInt == 0))
      {
        com.tencent.mm.by.c.ad(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      bh.beI();
      paramAdapterView = (Boolean)com.tencent.mm.model.c.aHp().b(4104, null);
      if ((paramAdapterView == null) || (!paramAdapterView.booleanValue()))
      {
        paramAdapterView = LauncherUI.getInstance();
        if (paramAdapterView != null) {
          paramAdapterView.VXk.getMainTabUI().byt("tab_find_friend");
        }
        com.tencent.mm.bw.a.jk(this.mContext);
        break;
      }
      paramAdapterView = View.inflate(this.mContext, R.i.lbs_open_dialog_view, null);
      paramView = (CheckBox)paramAdapterView.findViewById(R.h.lbs_open_dialog_cb);
      paramView.setChecked(false);
      com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.app_tip), paramAdapterView, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33689);
          if (paramView != null)
          {
            bh.beI();
            paramAnonymousDialogInterface = com.tencent.mm.model.c.aHp();
            if (paramView.isChecked()) {
              break label79;
            }
          }
          label79:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousDialogInterface.i(4104, Boolean.valueOf(bool));
            paramAnonymousDialogInterface = LauncherUI.getInstance();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.VXk.getMainTabUI().byt("tab_find_friend");
            }
            com.tencent.mm.bw.a.jk(ah.b(ah.this));
            AppMethodBeat.o(33689);
            return;
          }
        }
      }, null);
      break;
      bh.beI();
      if (com.tencent.mm.model.c.aGK())
      {
        com.tencent.mm.by.c.ad(this.mContext, "webwx", ".ui.WebWXLogoutUI");
        break;
      }
      com.tencent.mm.by.c.ad(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
      break;
      if ((z.bdn() & 0x10000) == 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label1766;
        }
        com.tencent.mm.by.c.ad(this.mContext, "masssend", ".ui.MassSendHistoryUI");
        break;
      }
      label1766:
      com.tencent.mm.by.c.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
      break;
      com.tencent.mm.by.c.ad(this.mContext, "radar", ".ui.RadarSearchUI");
      break;
      com.tencent.mm.by.c.ad(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      break;
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10919, "1-6");
      com.tencent.mm.pluginsdk.g.jo(this.mContext);
      break;
      paramAdapterView = new Intent();
      bh.beI();
      paramView = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vqb, "");
      if (!Util.isNullOrNil(paramView))
      {
        paramAdapterView.putExtra("rawUrl", paramView);
        paramAdapterView.putExtra("showShare", true);
        paramAdapterView.putExtra("show_bottom", false);
        com.tencent.mm.by.c.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramAdapterView);
        break;
      }
      com.tencent.mm.pluginsdk.g.jo(this.mContext);
      break;
      if (!WeChatBrands.Business.Entries.HomeMorePayment.checkAvailable(this.mContext)) {
        break;
      }
      com.tencent.mm.plugin.newtips.a.fiO().aap(4);
      paramAdapterView = this.mContext;
      paramView = new Intent();
      paramView.putExtra("key_from_scene", 2);
      com.tencent.mm.by.c.b(paramAdapterView, "offline", ".ui.WalletOfflineEntranceUI", paramView);
      if (!com.tencent.mm.aa.c.aFn().dk(262159, 266248)) {
        break;
      }
      com.tencent.mm.aa.c.aFn().dl(262159, 266248);
      com.tencent.mm.plugin.report.service.h.IzE.a(14396, new Object[] { Integer.valueOf(2) });
      break;
      com.tencent.mm.pluginsdk.wallet.f.aV(this.mContext, 1);
      break;
      com.tencent.mm.kernel.h.aGY().a(2540, this);
      paramAdapterView = gMT();
      if (Util.isNullOrNil(paramAdapterView.TRp))
      {
        Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 has no cache");
        Cu(false);
        break;
      }
      paramLong = System.currentTimeMillis();
      long l = paramLong - paramAdapterView.TRr;
      Log.i("MicroMsg.PlusSubMenuHelper", "currentTime ：%s ,lastTime：%s,internalTime ：%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramAdapterView.TRr), Long.valueOf(l) });
      if (l < paramAdapterView.TRq)
      {
        Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 dont expired，url：%s", new Object[] { paramAdapterView.TRp });
        com.tencent.mm.wallet_core.ui.g.o(this.mContext, paramAdapterView.TRp, false);
        Cu(true);
        break;
      }
      Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 is expired");
      Cu(false);
      break;
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("key_from_scene", 2);
      com.tencent.mm.by.c.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", paramAdapterView);
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(282622);
    Log.i("MicroMsg.PlusSubMenuHelper", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof com.tencent.mm.plugin.wallet_index.c.a.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label365;
      }
      paramq = ((com.tencent.mm.plugin.wallet_index.c.a.b)paramq).gMW();
      if (paramq.fHV != 0) {
        break label305;
      }
      Log.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd ok，pay_wallet_wxapp_h5_url：%s, cache_time：%s", new Object[] { paramq.TRp, Integer.valueOf(paramq.TRq) });
      if ((!this.Pjq) && (gMU()))
      {
        Log.i("MicroMsg.PlusSubMenuHelper", "on Scene End jump h5 ");
        com.tencent.mm.wallet_core.ui.g.o(this.mContext, paramq.TRp, false);
      }
      paramq.TRr = System.currentTimeMillis();
      Log.i("MicroMsg.PlusSubMenuHelper", "on Scene End currentTime ：%s ", new Object[] { Long.valueOf(paramq.TRr) });
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
          ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.VDb, paramString);
          ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().hxT();
          com.tencent.mm.kernel.h.aGY().b(2540, this);
          AppMethodBeat.o(282622);
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
      if ((!this.Pjq) && (gMU()))
      {
        com.tencent.mm.ui.base.h.a(this.mContext, paramq.fHW, "", this.mContext.getString(R.l.welcome_i_know), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(290109);
            Log.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
            AppMethodBeat.o(290109);
          }
        });
        continue;
        label365:
        Log.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd faile show error dialog ");
        if ((!this.Pjq) && (gMU())) {
          com.tencent.mm.ui.base.h.a(this.mContext, paramString, "", this.mContext.getString(R.l.welcome_i_know), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(286139);
              Log.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
              AppMethodBeat.o(286139);
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
      int i = ah.a(ah.this).size();
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
      paramView = (ah.c)ah.a(ah.this).get(paramInt);
      paramView = new ah.e(ah.b(ah.this), paramView);
      LayoutInflater localLayoutInflater = ah.c(ah.this);
      label260:
      label321:
      boolean bool;
      if (paramInt == getCount() - 1)
      {
        paramInt = 1;
        paramView.jac = localLayoutInflater.inflate(R.i.mm_submenu_item, paramViewGroup, false);
        paramView.jMg = ((TextView)paramView.jac.findViewById(R.h.title));
        paramView.bwJ = ((ImageView)paramView.jac.findViewById(R.h.icon));
        paramView.WdP = ((TextView)paramView.jac.findViewById(R.h.new_tips));
        paramView.WdQ = ((TextView)paramView.jac.findViewById(R.h.unread_count));
        paramView.WdR = paramView.jac.findViewById(R.h.new_dot);
        if (!Util.isNullOrNil(paramView.WdO.WdK.WdL)) {
          paramView.jMg.setText(paramView.WdO.WdK.WdL);
        }
        if (paramView.WdO.WdK.textColor > 0) {
          paramView.jMg.setTextColor(com.tencent.mm.ci.a.w(MMApplicationContext.getContext(), paramView.WdO.WdK.textColor));
        }
        if (paramView.WdO.WdK.icon <= 0) {
          break label433;
        }
        paramView.bwJ.setVisibility(0);
        paramView.bwJ.setImageResource(paramView.WdO.WdK.icon);
        if (!Util.isNullOrNil(paramView.WdO.WdK.WdM)) {
          paramView.bwJ.setContentDescription(paramView.WdO.WdK.WdM);
        }
        paramView.WdQ.setBackgroundResource(com.tencent.mm.ui.tools.w.lE(paramView.context));
        if (paramInt == 0) {
          break label445;
        }
        paramView.jac.setBackgroundResource(R.g.submenu_item_selector_no_divider);
        paramView.WdP.setTextSize(0, com.tencent.mm.ci.a.aZ(paramView.context, R.f.unReadNewTextSize));
        if ((!paramView.WdO.jJN) && (paramView.WdO.fuP <= 0) && (!paramView.WdO.WdJ)) {
          break label458;
        }
        bool = true;
        label373:
        if (!com.tencent.mm.plugin.newtips.a.g.a(bool, paramView))
        {
          if (!paramView.WdO.jJN) {
            break label464;
          }
          paramView.WdP.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, com.tencent.mm.plugin.newtips.a.k.GwL, true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.newtips.a.fiO().h(paramView);
        paramView = paramView.jac;
        AppMethodBeat.o(33691);
        return paramView;
        paramInt = 0;
        break;
        label433:
        paramView.bwJ.setVisibility(8);
        break label260;
        label445:
        paramView.jac.setBackgroundResource(R.g.submenu_item_selector);
        break label321;
        label458:
        bool = false;
        break label373;
        label464:
        if (paramView.WdO.fuP > 0)
        {
          paramView.WdQ.setVisibility(0);
          if (paramView.WdO.fuP > 99)
          {
            paramView.WdQ.setText("");
            paramView.WdQ.setBackgroundResource(R.k.badge_count_more);
          }
          for (;;)
          {
            com.tencent.mm.plugin.newtips.a.g.a(paramView, com.tencent.mm.plugin.newtips.a.k.GwP, true);
            break;
            paramView.WdQ.setText(paramView.WdO.fuP);
            paramView.WdQ.setBackgroundResource(com.tencent.mm.ui.tools.w.bj(paramView.context, paramView.WdO.fuP));
          }
        }
        if (paramView.WdO.WdJ)
        {
          paramView.WdR.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, com.tencent.mm.plugin.newtips.a.k.GwK, true);
        }
        else
        {
          paramView.WdP.setVisibility(8);
          paramView.WdQ.setVisibility(8);
          paramView.WdR.setVisibility(8);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, com.tencent.mm.plugin.newtips.a.k.GwL, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, com.tencent.mm.plugin.newtips.a.k.GwP, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, com.tencent.mm.plugin.newtips.a.k.GwK, false);
        }
      }
    }
  }
  
  public static final class b
  {
    int WdI;
    int id;
    int mbp;
    int order;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2, paramInt3, 0);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.id = paramInt1;
      this.WdI = paramInt2;
      this.mbp = paramInt3;
      this.order = paramInt4;
    }
  }
  
  public static final class c
  {
    boolean WdJ = false;
    ah.d WdK;
    int fuP = 0;
    boolean jJN = false;
    
    public c(ah.d paramd)
    {
      this.WdK = paramd;
    }
  }
  
  public static final class d
  {
    String WdL;
    String WdM;
    int WdN;
    int icon;
    String path;
    int textColor;
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramString1, paramString2, paramInt2, paramInt3, "");
    }
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
    {
      this.WdL = paramString1;
      this.WdM = paramString2;
      this.icon = paramInt2;
      this.WdN = paramInt1;
      this.textColor = paramInt3;
      this.path = paramString3;
    }
  }
  
  public static final class e
    implements com.tencent.mm.plugin.newtips.a.a
  {
    ah.c WdO;
    TextView WdP;
    TextView WdQ;
    View WdR;
    ImageView bwJ;
    Context context;
    TextView jMg;
    View jac;
    
    public e(Context paramContext, ah.c paramc)
    {
      this.context = paramContext;
      this.WdO = paramc;
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(293350);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(293350);
    }
    
    public final boolean a(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, erx paramerx)
    {
      AppMethodBeat.i(33696);
      if (paramBoolean)
      {
        this.WdQ.setVisibility(0);
        if (paramerx.num > 99)
        {
          this.WdQ.setText("");
          this.WdQ.setBackgroundResource(R.k.badge_count_more);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33696);
        return true;
        this.WdQ.setText(paramerx.num);
        this.WdQ.setBackgroundResource(com.tencent.mm.ui.tools.w.bj(this.context, paramerx.num));
        continue;
        this.WdQ.setVisibility(8);
      }
    }
    
    public final boolean eQW()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.WdO.WdK.path;
    }
    
    public final View getRoot()
    {
      return this.jac;
    }
    
    public final boolean tX(boolean paramBoolean)
    {
      AppMethodBeat.i(293351);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(293351);
      return paramBoolean;
    }
    
    public final boolean tY(boolean paramBoolean)
    {
      AppMethodBeat.i(33694);
      if (paramBoolean) {
        this.WdR.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33694);
        return true;
        this.WdR.setVisibility(8);
      }
    }
    
    public final boolean tZ(boolean paramBoolean)
    {
      AppMethodBeat.i(33695);
      if (paramBoolean) {
        this.WdP.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33695);
        return true;
        this.WdP.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ah
 * JD-Core Version:    0.7.0.1
 */