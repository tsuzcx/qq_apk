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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.aaq.b;
import com.tencent.mm.autogen.a.gg;
import com.tencent.mm.autogen.a.uk;
import com.tencent.mm.bd.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.protocal.protobuf.ech;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.contact.select.MvvmSelectContactUI;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.util.b.a;
import com.tencent.mm.wallet_core.model.ab;
import java.io.IOException;

public final class al
  extends t
  implements com.tencent.mm.am.h
{
  private static final int[] adJi = { 2, 1, 10, 20 };
  private static final int[] adJj = { 2, 1, 10 };
  private static final int[] adJk = { 2, 1, 10 };
  private boolean Wai;
  private SparseArray<c> adJe;
  private a adJg;
  ak adJh;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public al(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(249290);
    this.adJh = null;
    this.mContext = paramAppCompatActivity;
    this.mInflater = LayoutInflater.from(paramAppCompatActivity);
    Na(false);
    this.adJh = ak.jkF();
    AppMethodBeat.o(249290);
  }
  
  private void HZ(boolean paramBoolean)
  {
    AppMethodBeat.i(249299);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.plugin.wallet_index.model.a.b localb = new com.tencent.mm.plugin.wallet_index.model.a.b(((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue());
    bh.aZW().a(localb, 0);
    this.Wai = paramBoolean;
    AppMethodBeat.o(249299);
  }
  
  public static d aAC(int paramInt)
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
      if (HomeUI.adAr.booleanValue())
      {
        localObject = new d(1, ((Context)localObject).getString(R.l.gNN), "", R.k.ofm_add_green_icon, R.e.wechat_green);
      }
      else
      {
        localObject = new d(1, ((Context)localObject).getString(R.l.gNN), "", R.k.ofm_add_icon, 0);
        continue;
        if (HomeUI.adAs.booleanValue())
        {
          localObject = new d(2, ((Context)localObject).getString(R.l.gNQ), "", R.k.ofm_group_chat_green_icon, R.e.wechat_green);
        }
        else
        {
          localObject = new d(2, ((Context)localObject).getString(R.l.gNQ), "", R.k.ofm_group_chat_icon, 0);
          continue;
          localObject = new d(3, ((Context)localObject).getString(R.l.gNR), "", R.k.camera, 0);
          continue;
          if (1 == Util.getInt(com.tencent.mm.k.i.aRC().getValue("VOIPCallType"), 0))
          {
            localObject = new d(4, ((Context)localObject).getString(R.l.gNS), "", R.k.ofm_video_icon, 0);
          }
          else
          {
            localObject = new d(4, ((Context)localObject).getString(R.l.gNO), "", R.k.ofm_audio_icon, 0);
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
            localObject = new d(12, ((Context)localObject).getString(R.l.gJb), "", R.k.ofm_gamecenter_icon, 0);
            continue;
            localObject = new d(13, ((Context)localObject).getString(R.l.shake_report_title), "", R.k.ofm_shake_icon, 0);
            continue;
            localObject = new d(14, ((Context)localObject).getString(R.l.nearby_friend_title), "", R.k.ofm_nearby_icon, 0);
            continue;
            localObject = new d(16, ((Context)localObject).getString(R.l.settings_WebWX), "", R.k.ofm_webwechat_icon, 0);
            continue;
            localObject = new d(17, ((Context)localObject).getString(R.l.gNv), "", R.k.ofm_groupmessage_icon, 0);
            continue;
            localObject = new d(18, ((Context)localObject).getString(R.l.find_friends_by_radar), "", R.k.ofm_radar_icon, 0);
            continue;
            localObject = new d(19, ((Context)localObject).getString(R.l.gHV), "", R.k.actionbar_facefriend_icon, 0);
            continue;
            bh.bCz();
            if (((Integer)com.tencent.mm.model.c.ban().get(at.a.acNa, Integer.valueOf(0))).intValue() > 1) {
              break;
            }
            localObject = new d(20, ((Context)localObject).getString(R.l.gqU), "", R.k.receipt_payment_icon, 0, "plus_receiveorpay");
            continue;
            bh.bCz();
            paramInt = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
            int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWV, 0);
            if ((paramInt != 8) || (i != 0)) {
              break;
            }
            localObject = new d(22, ((Context)localObject).getString(R.l.gRw), "", R.k.offline_entrance_f2f_collect_hk, 0);
            continue;
            bh.bCz();
            paramInt = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
            i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWV, 0);
            if ((paramInt != 8) || (i != 1)) {
              break;
            }
            localObject = new d(24, ((Context)localObject).getString(R.l.gRx), "", R.k.receipt_payment_icon, 0);
            continue;
            localObject = new d(2147483646, "TIT", "", R.k.ofm_card_icon, 0);
          }
        }
      }
    }
  }
  
  private static ech imi()
  {
    AppMethodBeat.i(249306);
    Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig");
    ech localech = new ech();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.adfV, null);
    if (Util.isNullOrNil(str)) {
      Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 get PayIBGQuickGetOverseaWalletConfig failed");
    }
    for (;;)
    {
      AppMethodBeat.o(249306);
      return localech;
      try
      {
        localech.parseFrom(str.getBytes("ISO-8859-1"));
        Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig success");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.PlusSubMenuHelper", "OfflineH5 parse PayIBGQuickGetOverseaWalletConfig fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  private boolean imj()
  {
    AppMethodBeat.i(249310);
    String str = Util.getTopActivityName2(this.mContext);
    if ((!Util.isNullOrNil(str)) && (str.equals("LauncherUI")))
    {
      Log.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is on ActivityTask Top ");
      AppMethodBeat.o(249310);
      return true;
    }
    Log.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is not on ActivityTask Top：%s", new Object[] { str });
    AppMethodBeat.o(249310);
    return false;
  }
  
  public final BaseAdapter aNu()
  {
    AppMethodBeat.i(33701);
    if (this.adJg == null) {
      this.adJg = new a((byte)0);
    }
    a locala = this.adJg;
    AppMethodBeat.o(33701);
    return locala;
  }
  
  public final boolean du()
  {
    int k = 0;
    AppMethodBeat.i(33698);
    this.adJh.Ls(false);
    if (this.adJh.adJe.size() != 0) {
      this.adJe = this.adJh.adJe;
    }
    try
    {
      bh.bCz();
      if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acLd, Boolean.FALSE)).booleanValue())
      {
        int i = k;
        while (i < this.adJe.size())
        {
          int j = ((c)this.adJe.get(i)).adJo.adJr;
          if (j != 2147483646)
          {
            i += 1;
            continue;
            Log.i("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            label133:
            int[] arrayOfInt;
            if (this.adJe != null)
            {
              this.adJe.clear();
              if (!WeChatBrands.Business.Entries.HomeMoreFeedback.banned()) {
                break label221;
              }
              arrayOfInt = adJk;
            }
            for (;;)
            {
              int m = arrayOfInt.length;
              i = 0;
              j = 0;
              while (i < m)
              {
                c localc = new c(aAC(arrayOfInt[i]));
                if (localc.adJo != null) {
                  this.adJe.put(j, localc);
                }
                j += 1;
                i += 1;
              }
              this.adJe = new SparseArray();
              break label133;
              label221:
              if (Util.isOverseasUser(this.mContext)) {
                arrayOfInt = adJj;
              } else {
                arrayOfInt = adJi;
              }
            }
          }
        }
        if (i == this.adJe.size()) {
          this.adJe.put(this.adJe.size(), new c(aAC(2147483646)));
        }
      }
    }
    catch (Exception localException)
    {
      label285:
      boolean bool;
      break label285;
    }
    if (this.adJg != null) {
      this.adJg.notifyDataSetChanged();
    }
    bool = super.du();
    AppMethodBeat.o(33698);
    return bool;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, final View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33699);
    if ((this.mContext instanceof AppCompatActivity)) {
      ((AppCompatActivity)this.mContext).supportInvalidateOptionsMenu();
    }
    int i = ((c)this.adJe.get(paramInt)).adJo.adJr;
    paramAdapterView = new com.tencent.mm.hellhoundlib.b.b();
    paramAdapterView.sc(i);
    paramAdapterView.sc(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/PlusSubMenuHelper", "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", this, paramAdapterView.aYj());
    com.tencent.mm.plugin.report.service.h.OAn.b(11104, new Object[] { Integer.valueOf(i) });
    if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.widget.recent.k.class) != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recent.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.widget.recent.k.class)).cSO();
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
        this.adJh.aAB(i);
        dismiss();
        AppMethodBeat.o(33699);
        return;
        new Intent().putExtra("invite_friend_scene", 2);
        com.tencent.mm.br.c.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
        continue;
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpV, b.a.agrW, 0) == 1) {}
        for (paramAdapterView = new Intent(this.mContext, MvvmSelectContactUI.class);; paramAdapterView = new Intent(this.mContext, SelectContactUI.class))
        {
          paramAdapterView.putExtra("titile", this.mContext.getString(R.l.address_title_launch_chatting));
          paramAdapterView.putExtra("list_type", 0);
          paramAdapterView.putExtra("list_attr", w.R(new int[] { w.affr, 256, 512 }));
          paramAdapterView.putExtra("scene", 7);
          paramAdapterView.putExtra("menu_mode", 2);
          paramAdapterView.putExtra("create_group_recommend", true);
          paramView = this.mContext;
          paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAdapterView);
          com.tencent.mm.hellhoundlib.a.a.b(paramView, paramAdapterView.aYi(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)paramAdapterView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
        }
        paramView = new Intent();
        paramView.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, paramView.aYi(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramAdapterView = new aaq();
        paramAdapterView.ieg.iei = true;
        paramAdapterView.publish();
        paramAdapterView = paramAdapterView.ieh.iek;
        if (!Util.isNullOrNil(paramAdapterView))
        {
          Log.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: ".concat(String.valueOf(paramAdapterView)));
          com.tencent.mm.ui.base.k.b(this.mContext, this.mContext.getString(R.l.gWJ), "", this.mContext.getString(R.l.app_ok), this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(33686);
              Object localObject = new aaq();
              ((aaq)localObject).ieg.iej = true;
              ((aaq)localObject).publish();
              localObject = new gg();
              ((gg)localObject).hGt.username = d.oXO.bNG();
              ((gg)localObject).publish();
              VoipAddressUI.nr(al.b(al.this));
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
          VoipAddressUI.nr(this.mContext);
          continue;
          bh.bCz();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            aa.j(this.mContext, null);
          }
          else
          {
            bh.bCz();
            paramAdapterView = (String)com.tencent.mm.model.c.ban().d(2, null);
            paramView = new Intent();
            paramView.putExtra("sns_userName", paramAdapterView);
            paramView.setFlags(536870912);
            paramView.addFlags(67108864);
            bh.bCz();
            paramInt = Util.nullAs((Integer)com.tencent.mm.model.c.ban().d(68389, null), 0);
            bh.bCz();
            com.tencent.mm.model.c.ban().B(68389, Integer.valueOf(paramInt + 1));
            paramView.putExtra("sns_adapter_type", 1);
            com.tencent.mm.br.c.b(this.mContext, "sns", ".ui.SnsTimeLineUserPagerUI", paramView);
            continue;
            com.tencent.mm.plugin.fav.a.b.b(this.mContext, ".ui.FavoriteIndexUI", new Intent());
            continue;
            bool1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXg, true);
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
              com.tencent.mm.plugin.report.service.h.OAn.b(11265, new Object[] { Integer.valueOf(3) });
              if ((!com.tencent.mm.n.a.p(this.mContext, true)) && (!com.tencent.mm.n.a.dl(this.mContext)) && (!com.tencent.mm.n.a.u(this.mContext, true)))
              {
                paramAdapterView = new Intent();
                paramAdapterView.putExtra("key_scan_entry_scene", 1);
                paramAdapterView.putExtra("key_scan_report_enter_scene", 6);
                paramAdapterView.putExtra("key_config_black_interval", true);
                paramAdapterView.putExtra("key_enable_multi_code", true);
                paramAdapterView.putExtra("key_enable_scan_code_product_merge", true);
                paramAdapterView.putExtra("key_scan_goods_enable_dynamic_wording", true);
                com.tencent.mm.br.c.b(this.mContext, "scanner", ".ui.BaseScanUI", paramAdapterView);
                continue;
                bh.bCz();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                  break;
                }
                aa.j(this.mContext, null);
              }
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.ahw(10);
      bh.bCz();
      paramAdapterView = (String)com.tencent.mm.model.c.ban().d(68377, null);
      bh.bCz();
      com.tencent.mm.model.c.ban().B(68377, "");
      paramView = new Intent();
      paramView.putExtra("sns_timeline_NeedFirstLoadint", true);
      if (Util.isNullOrNil(paramAdapterView)) {
        break;
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (q.Qkk != null)
      {
        bool2 = bool1;
        if (q.Qkk.dkF() > 0) {
          bool2 = false;
        }
      }
      paramView.putExtra("sns_resume_state", bool2);
      com.tencent.mm.br.c.b(this.mContext, "sns", ".ui.SnsTimeLineUI", paramView);
      break;
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        aa.j(this.mContext, null);
        break;
      }
      com.tencent.mm.br.c.ai(this.mContext, "game", ".ui.GameCenterUI");
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33688);
          com.tencent.mm.xwebutil.c.jQE();
          AppMethodBeat.o(33688);
        }
      }, 100L);
      break;
      new uk().publish();
      com.tencent.mm.br.c.ai(this.mContext, "shake", ".ui.ShakeReportUI");
      break;
      bh.bCz();
      if (!Util.nullAsFalse((Boolean)com.tencent.mm.model.c.ban().d(4103, null)))
      {
        com.tencent.mm.br.c.ai(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
        break;
      }
      paramAdapterView = cb.bDf();
      if (paramAdapterView == null)
      {
        com.tencent.mm.br.c.ai(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      paramView = Util.nullAsNil(paramAdapterView.getProvince());
      paramInt = Util.nullAs(Integer.valueOf(paramAdapterView.sex), 0);
      if ((Util.isNullOrNil(paramView)) || (paramInt == 0))
      {
        com.tencent.mm.br.c.ai(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      bh.bCz();
      paramAdapterView = (Boolean)com.tencent.mm.model.c.ban().d(4104, null);
      if ((paramAdapterView == null) || (!paramAdapterView.booleanValue()))
      {
        paramAdapterView = LauncherUI.getInstance();
        if (paramAdapterView != null) {
          paramAdapterView.adBG.getMainTabUI().bzP("tab_find_friend");
        }
        com.tencent.mm.bp.a.li(this.mContext);
        break;
      }
      paramAdapterView = View.inflate(this.mContext, R.i.gli, null);
      paramView = (CheckBox)paramAdapterView.findViewById(R.h.fMB);
      paramView.setChecked(false);
      com.tencent.mm.ui.base.k.a(this.mContext, this.mContext.getString(R.l.app_tip), paramAdapterView, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33689);
          if (paramView != null)
          {
            bh.bCz();
            paramAnonymousDialogInterface = com.tencent.mm.model.c.ban();
            if (paramView.isChecked()) {
              break label79;
            }
          }
          label79:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousDialogInterface.B(4104, Boolean.valueOf(bool));
            paramAnonymousDialogInterface = LauncherUI.getInstance();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.adBG.getMainTabUI().bzP("tab_find_friend");
            }
            com.tencent.mm.bp.a.li(al.b(al.this));
            AppMethodBeat.o(33689);
            return;
          }
        }
      }, null);
      break;
      bh.bCz();
      if (com.tencent.mm.model.c.bzw())
      {
        com.tencent.mm.br.c.ai(this.mContext, "webwx", ".ui.WebWXLogoutUI");
        break;
      }
      com.tencent.mm.br.c.ai(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
      break;
      if ((z.bBf() & 0x10000) == 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label1818;
        }
        com.tencent.mm.br.c.ai(this.mContext, "masssend", ".ui.MassSendHistoryUI");
        break;
      }
      label1818:
      com.tencent.mm.br.c.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
      break;
      com.tencent.mm.br.c.ai(this.mContext, "radar", ".ui.RadarSearchUI");
      break;
      com.tencent.mm.br.c.ai(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      break;
      paramAdapterView = new Intent();
      bh.bCz();
      paramView = (String)com.tencent.mm.model.c.ban().get(at.a.acRD, "");
      if (!Util.isNullOrNil(paramView))
      {
        paramAdapterView.putExtra("rawUrl", paramView);
        paramAdapterView.putExtra("showShare", true);
        paramAdapterView.putExtra("show_bottom", false);
        com.tencent.mm.br.c.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramAdapterView);
        break;
      }
      com.tencent.mm.pluginsdk.g.ll(this.mContext);
      break;
      if (!WeChatBrands.Business.Entries.HomeMorePayment.checkAvailable(this.mContext)) {
        break;
      }
      com.tencent.mm.plugin.newtips.a.gtf().aeI(4);
      paramAdapterView = this.mContext;
      paramView = new Intent();
      paramView.putExtra("key_from_scene", 2);
      com.tencent.mm.br.c.b(paramAdapterView, "offline", ".ui.WalletOfflineEntranceUI", paramView);
      if (!com.tencent.mm.aa.c.aYo().dW(262159, 266248)) {
        break;
      }
      com.tencent.mm.aa.c.aYo().dX(262159, 266248);
      com.tencent.mm.plugin.report.service.h.OAn.b(14396, new Object[] { Integer.valueOf(2) });
      break;
      com.tencent.mm.pluginsdk.wallet.f.bo(this.mContext, 1);
      break;
      com.tencent.mm.kernel.h.aZW().a(2540, this);
      paramAdapterView = imi();
      if (Util.isNullOrNil(paramAdapterView.abhO))
      {
        Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 has no cache");
        HZ(false);
        break;
      }
      paramLong = System.currentTimeMillis();
      long l = paramLong - paramAdapterView.abhQ;
      Log.i("MicroMsg.PlusSubMenuHelper", "currentTime ：%s ,lastTime：%s,internalTime ：%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramAdapterView.abhQ), Long.valueOf(l) });
      if (l < paramAdapterView.abhP)
      {
        Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 dont expired，url：%s", new Object[] { paramAdapterView.abhO });
        com.tencent.mm.wallet_core.ui.i.o(this.mContext, paramAdapterView.abhO, false);
        HZ(true);
        break;
      }
      Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 is expired");
      HZ(false);
      break;
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("key_from_scene", 2);
      com.tencent.mm.br.c.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", paramAdapterView);
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(249358);
    Log.i("MicroMsg.PlusSubMenuHelper", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof com.tencent.mm.plugin.wallet_index.model.a.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label365;
      }
      paramp = ((com.tencent.mm.plugin.wallet_index.model.a.b)paramp).iml();
      if (paramp.hNv != 0) {
        break label305;
      }
      Log.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd ok，pay_wallet_wxapp_h5_url：%s, cache_time：%s", new Object[] { paramp.abhO, Integer.valueOf(paramp.abhP) });
      if ((!this.Wai) && (imj()))
      {
        Log.i("MicroMsg.PlusSubMenuHelper", "on Scene End jump h5 ");
        com.tencent.mm.wallet_core.ui.i.o(this.mContext, paramp.abhO, false);
      }
      paramp.abhQ = System.currentTimeMillis();
      Log.i("MicroMsg.PlusSubMenuHelper", "on Scene End currentTime ：%s ", new Object[] { Long.valueOf(paramp.abhQ) });
      Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 setConfig");
      paramString = " ";
      if (paramp == null) {}
    }
    for (;;)
    {
      try
      {
        paramString = new String(paramp.toByteArray(), "ISO-8859-1");
        Log.e("MicroMsg.PlusSubMenuHelper", "save config exp, " + paramp.getLocalizedMessage());
      }
      catch (IOException paramp)
      {
        try
        {
          Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 setConfig success");
          ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(at.a.adfV, paramString);
          ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().iZy();
          com.tencent.mm.kernel.h.aZW().b(2540, this);
          AppMethodBeat.o(249358);
          return;
        }
        catch (IOException paramp)
        {
          break label275;
        }
        paramp = paramp;
        paramString = " ";
      }
      label275:
      continue;
      label305:
      Log.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd failed show dialog ");
      if ((!this.Wai) && (imj()))
      {
        com.tencent.mm.ui.base.k.a(this.mContext, paramp.hNw, "", this.mContext.getString(R.l.welcome_i_know), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(249867);
            Log.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
            AppMethodBeat.o(249867);
          }
        });
        continue;
        label365:
        Log.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd faile show error dialog ");
        if ((!this.Wai) && (imj())) {
          com.tencent.mm.ui.base.k.a(this.mContext, paramString, "", this.mContext.getString(R.l.welcome_i_know), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(249869);
              Log.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
              AppMethodBeat.o(249869);
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
      int i = al.a(al.this).size();
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
      paramView = (al.c)al.a(al.this).get(paramInt);
      paramView = new al.e(al.b(al.this), paramView);
      LayoutInflater localLayoutInflater = al.c(al.this);
      label260:
      label321:
      boolean bool;
      if (paramInt == getCount() - 1)
      {
        paramInt = 1;
        paramView.lBX = localLayoutInflater.inflate(R.i.mm_submenu_item, paramViewGroup, false);
        paramView.mll = ((TextView)paramView.lBX.findViewById(R.h.title));
        paramView.dpM = ((ImageView)paramView.lBX.findViewById(R.h.icon));
        paramView.adJt = ((TextView)paramView.lBX.findViewById(R.h.new_tips));
        paramView.adJu = ((TextView)paramView.lBX.findViewById(R.h.unread_count));
        paramView.adJv = paramView.lBX.findViewById(R.h.new_dot);
        if (!Util.isNullOrNil(paramView.adJs.adJo.adJp)) {
          paramView.mll.setText(paramView.adJs.adJo.adJp);
        }
        if (paramView.adJs.adJo.textColor > 0) {
          paramView.mll.setTextColor(com.tencent.mm.cd.a.w(MMApplicationContext.getContext(), paramView.adJs.adJo.textColor));
        }
        if (paramView.adJs.adJo.icon <= 0) {
          break label433;
        }
        paramView.dpM.setVisibility(0);
        paramView.dpM.setImageResource(paramView.adJs.adJo.icon);
        if (!Util.isNullOrNil(paramView.adJs.adJo.adJq)) {
          paramView.dpM.setContentDescription(paramView.adJs.adJo.adJq);
        }
        paramView.adJu.setBackgroundResource(v.nH(paramView.context));
        if (paramInt == 0) {
          break label445;
        }
        paramView.lBX.setBackgroundResource(R.g.submenu_item_selector_no_divider);
        paramView.adJt.setTextSize(0, com.tencent.mm.cd.a.bs(paramView.context, R.f.unReadNewTextSize));
        if ((!paramView.adJs.mjf) && (paramView.adJs.hzj <= 0) && (!paramView.adJs.adJn)) {
          break label458;
        }
        bool = true;
        label373:
        if (!com.tencent.mm.plugin.newtips.a.g.a(bool, paramView))
        {
          if (!paramView.adJs.mjf) {
            break label464;
          }
          paramView.adJt.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, com.tencent.mm.plugin.newtips.a.k.MsL, true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.newtips.a.gtf().h(paramView);
        paramView = paramView.lBX;
        AppMethodBeat.o(33691);
        return paramView;
        paramInt = 0;
        break;
        label433:
        paramView.dpM.setVisibility(8);
        break label260;
        label445:
        paramView.lBX.setBackgroundResource(R.g.submenu_item_selector);
        break label321;
        label458:
        bool = false;
        break label373;
        label464:
        if (paramView.adJs.hzj > 0)
        {
          paramView.adJu.setVisibility(0);
          if (paramView.adJs.hzj > 99)
          {
            paramView.adJu.setText("");
            paramView.adJu.setBackgroundResource(R.k.badge_count_more);
          }
          for (;;)
          {
            com.tencent.mm.plugin.newtips.a.g.a(paramView, com.tencent.mm.plugin.newtips.a.k.MsP, true);
            break;
            paramView.adJu.setText(paramView.adJs.hzj);
            paramView.adJu.setBackgroundResource(v.bC(paramView.context, paramView.adJs.hzj));
          }
        }
        if (paramView.adJs.adJn)
        {
          paramView.adJv.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, com.tencent.mm.plugin.newtips.a.k.MsK, true);
        }
        else
        {
          paramView.adJt.setVisibility(8);
          paramView.adJu.setVisibility(8);
          paramView.adJv.setVisibility(8);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, com.tencent.mm.plugin.newtips.a.k.MsL, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, com.tencent.mm.plugin.newtips.a.k.MsP, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, com.tencent.mm.plugin.newtips.a.k.MsK, false);
        }
      }
    }
  }
  
  public static final class b
  {
    int adJm;
    int id;
    int oUj;
    int order;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2, paramInt3, 0);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.id = paramInt1;
      this.adJm = paramInt2;
      this.oUj = paramInt3;
      this.order = paramInt4;
    }
  }
  
  public static final class c
  {
    boolean adJn = false;
    al.d adJo;
    int hzj = 0;
    boolean mjf = false;
    
    public c(al.d paramd)
    {
      this.adJo = paramd;
    }
  }
  
  public static final class d
  {
    String adJp;
    String adJq;
    int adJr;
    int icon;
    String path;
    int textColor;
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramString1, paramString2, paramInt2, paramInt3, "");
    }
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
    {
      this.adJp = paramString1;
      this.adJq = paramString2;
      this.icon = paramInt2;
      this.adJr = paramInt1;
      this.textColor = paramInt3;
      this.path = paramString3;
    }
  }
  
  public static final class e
    implements com.tencent.mm.plugin.newtips.a.a
  {
    al.c adJs;
    TextView adJt;
    TextView adJu;
    View adJv;
    Context context;
    ImageView dpM;
    View lBX;
    TextView mll;
    
    public e(Context paramContext, al.c paramc)
    {
      this.context = paramContext;
      this.adJs = paramc;
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(369624);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(369624);
    }
    
    public final boolean a(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, fng paramfng)
    {
      AppMethodBeat.i(33696);
      if (paramBoolean)
      {
        this.adJu.setVisibility(0);
        if (paramfng.num > 99)
        {
          this.adJu.setText("");
          this.adJu.setBackgroundResource(R.k.badge_count_more);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33696);
        return true;
        this.adJu.setText(paramfng.num);
        this.adJu.setBackgroundResource(v.bC(this.context, paramfng.num));
        continue;
        this.adJu.setVisibility(8);
      }
    }
    
    public final boolean fZD()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.adJs.adJo.path;
    }
    
    public final View getRoot()
    {
      return this.lBX;
    }
    
    public final boolean ym(boolean paramBoolean)
    {
      AppMethodBeat.i(369625);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(369625);
      return paramBoolean;
    }
    
    public final boolean yn(boolean paramBoolean)
    {
      AppMethodBeat.i(33694);
      if (paramBoolean) {
        this.adJv.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33694);
        return true;
        this.adJv.setVisibility(8);
      }
    }
    
    public final boolean yo(boolean paramBoolean)
    {
      AppMethodBeat.i(33695);
      if (paramBoolean) {
        this.adJt.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33695);
        return true;
        this.adJt.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.al
 * JD-Core Version:    0.7.0.1
 */