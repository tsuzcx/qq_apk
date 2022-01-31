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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.no;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.a.ru.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.tools.o;

public final class af
  extends o
{
  private static final int[] uQq = { 2, 1, 4, 10, 3, 2147483647 };
  private LayoutInflater Lu;
  private Context mContext;
  private SparseArray<c> uQm;
  private af.a uQo;
  ae uQp = null;
  
  public af(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    this.mContext = paramAppCompatActivity;
    this.Lu = LayoutInflater.from(paramAppCompatActivity);
    nL(false);
    this.uQp = ae.cAc();
  }
  
  public static d Gd(int paramInt)
  {
    Context localContext = com.tencent.mm.sdk.platformtools.ae.getContext();
    switch (paramInt)
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
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 2147483647: 
    case 2147483645: 
    case 22: 
      do
      {
        do
        {
          return null;
          if (HomeUI.uKb.booleanValue()) {
            return new d(1, localContext.getString(R.l.menu_item_add_friend), "", R.k.ofm_add_green_icon, R.e.wechat_green);
          }
          return new d(1, localContext.getString(R.l.menu_item_add_friend), "", R.k.ofm_add_icon, 0);
          if (HomeUI.uKc.booleanValue()) {
            return new d(2, localContext.getString(R.l.menu_item_new_group_chat), "", R.k.ofm_group_chat_green_icon, R.e.wechat_green);
          }
          return new d(2, localContext.getString(R.l.menu_item_new_group_chat), "", R.k.ofm_group_chat_icon, 0);
          return new d(3, localContext.getString(R.l.menu_item_send_image), "", R.k.camera, 0);
          if (1 == bk.getInt(com.tencent.mm.m.g.AA().getValue("VOIPCallType"), 0)) {
            return new d(4, localContext.getString(R.l.menu_item_video_call), "", R.k.ofm_video_icon, 0);
          }
          return new d(4, localContext.getString(R.l.menu_item_audio_call), "", R.k.ofm_audio_icon, 0);
          return new d(5, localContext.getString(R.l.settings_my_album), "", R.k.ofm_pic_icon, 0);
          return new d(6, localContext.getString(R.l.settings_mm_favorite), "", R.k.ofm_favourite_icon, 0);
          return new d(7, localContext.getString(R.l.settings_mm_wallet), "", R.k.ofm_card_icon, 0);
          return new d(8, localContext.getString(R.l.emoji_store), "", R.k.ofm_emostore_icon, 0);
          return new d(9, localContext.getString(R.l.settings_my_qrcode), "", R.k.ofm_myqrcode_icon, 0);
          return new d(10, localContext.getString(R.l.find_friends_by_qrcode), "", R.k.ofm_qrcode_icon, 0);
          return new d(11, localContext.getString(R.l.sns_dyna_photo_ui_title), "", R.k.ofm_moment_icon, 0);
          return new d(12, localContext.getString(R.l.game_recommand), "", R.k.ofm_gamecenter_icon, 0);
          return new d(13, localContext.getString(R.l.shake_report_title), "", R.k.ofm_shake_icon, 0);
          return new d(14, localContext.getString(R.l.nearby_friend_title), "", R.k.ofm_nearby_icon, 0);
          return new d(15, localContext.getString(R.l.bottle_beach_title), "", R.k.ofm_bottle_icon, 0);
          return new d(16, localContext.getString(R.l.settings_WebWX), "", R.k.ofm_webwechat_icon, 0);
          return new d(17, localContext.getString(R.l.mass_send_helper), "", R.k.ofm_groupmessage_icon, 0);
          return new d(18, localContext.getString(R.l.find_friends_by_radar), "", R.k.ofm_radar_icon, 0);
          return new d(19, localContext.getString(R.l.find_friends_create_pwdgroup), "", R.k.actionbar_facefriend_icon, 0);
          au.Hx();
        } while (((Integer)com.tencent.mm.model.c.Dz().get(ac.a.usE, Integer.valueOf(0))).intValue() > 1);
        return new d(20, localContext.getString(R.l.address_title_face_to_face), "", R.k.receipt_payment_icon, 0);
        return new d(2147483647, localContext.getString(R.l.settings_feedback), "", R.k.ofm_feedback_icon, 0);
        return new d(2147483645, localContext.getString(R.l.settings_crowdtest_feedback), "", R.k.ofm_feedback_icon, 0);
        au.Hx();
      } while (((Integer)com.tencent.mm.model.c.Dz().get(ac.a.usE, Integer.valueOf(0))).intValue() != 8);
      return new d(22, localContext.getString(R.l.plus_wallet_pay_or_collect_tip_for_collect), "", R.k.offline_entrance_f2f_collect, 0);
    }
    return new d(2147483646, "TIT", "", R.k.ofm_card_icon, 0);
  }
  
  public final boolean fy()
  {
    int j = 0;
    this.uQp.mW(false);
    if (this.uQp.uQm.size() != 0) {
      this.uQm = this.uQp.uQm;
    }
    try
    {
      au.Hx();
      if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uqH, Boolean.valueOf(false))).booleanValue())
      {
        int i = j;
        while (i < this.uQm.size())
        {
          j = ((c)this.uQm.get(i)).uQv.uQy;
          if (j != 2147483646)
          {
            i += 1;
            continue;
            y.d("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.uQm != null) {
              this.uQm.clear();
            }
            for (;;)
            {
              i = 0;
              while (i < uQq.length)
              {
                c localc = new c(Gd(uQq[i]));
                this.uQm.put(i, localc);
                i += 1;
              }
              this.uQm = new SparseArray();
            }
          }
        }
        if (i == this.uQm.size()) {
          this.uQm.put(this.uQm.size(), new c(Gd(2147483646)));
        }
      }
    }
    catch (Exception localException)
    {
      label222:
      break label222;
    }
    if (this.uQo != null) {
      this.uQo.notifyDataSetChanged();
    }
    return super.fy();
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    boolean bool2 = false;
    if ((this.mContext instanceof AppCompatActivity)) {
      ((AppCompatActivity)this.mContext).supportInvalidateOptionsMenu();
    }
    int j = ((c)this.uQm.get(paramInt)).uQv.uQy;
    com.tencent.mm.plugin.report.service.h.nFQ.f(11104, new Object[] { Integer.valueOf(j) });
    if (com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.widget.recentview.d.class) != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).ci(300, 8);
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
        this.uQp.Gc(j);
        dismiss();
        return;
        new Intent().putExtra("invite_friend_scene", 2);
        com.tencent.mm.br.d.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
        continue;
        paramAdapterView = new Intent(this.mContext, SelectContactUI.class);
        paramAdapterView.putExtra("titile", this.mContext.getString(R.l.address_title_launch_chatting));
        paramAdapterView.putExtra("list_type", 0);
        paramAdapterView.putExtra("list_attr", com.tencent.mm.ui.contact.s.v(new int[] { com.tencent.mm.ui.contact.s.vMt, 256, 512 }));
        paramAdapterView.putExtra("scene", 7);
        this.mContext.startActivity(paramAdapterView);
        continue;
        paramAdapterView = new Intent();
        paramAdapterView.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
        this.mContext.startActivity(paramAdapterView);
        continue;
        paramAdapterView = new ru();
        paramAdapterView.cbq.cbs = true;
        com.tencent.mm.sdk.b.a.udP.m(paramAdapterView);
        paramAdapterView = paramAdapterView.cbr.cbu;
        if (!bk.bl(paramAdapterView))
        {
          y.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: " + paramAdapterView);
          com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.talk_room_enter_voip_tip), "", this.mContext.getString(R.l.app_ok), this.mContext.getString(R.l.app_cancel), new af.1(this), new af.2(this));
        }
        else
        {
          VoipAddressUI.gV(this.mContext);
          continue;
          au.Hx();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.s.gM(this.mContext);
          }
          else
          {
            au.Hx();
            paramAdapterView = (String)com.tencent.mm.model.c.Dz().get(2, null);
            paramView = new Intent();
            paramView.putExtra("sns_userName", paramAdapterView);
            paramView.setFlags(536870912);
            paramView.addFlags(67108864);
            au.Hx();
            paramInt = bk.a((Integer)com.tencent.mm.model.c.Dz().get(68389, null), 0);
            au.Hx();
            com.tencent.mm.model.c.Dz().o(68389, Integer.valueOf(paramInt + 1));
            com.tencent.mm.br.d.b(this.mContext, "sns", ".ui.SnsUserUI", paramView);
            continue;
            b.a(this.mContext, ".ui.FavoriteIndexUI", new Intent());
            continue;
            com.tencent.mm.br.d.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
            continue;
            paramAdapterView = new Intent();
            paramAdapterView.putExtra("preceding_scence", 2);
            com.tencent.mm.br.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", paramAdapterView);
            continue;
            com.tencent.mm.br.d.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
            continue;
            com.tencent.mm.plugin.report.service.h.nFQ.f(11265, new Object[] { Integer.valueOf(3) });
            if ((!com.tencent.mm.r.a.bj(this.mContext)) && (!com.tencent.mm.bf.e.RS()))
            {
              com.tencent.mm.br.d.x(this.mContext, "scanner", ".ui.BaseScanUI");
              continue;
              au.Hx();
              if (com.tencent.mm.model.c.isSDCardAvailable()) {
                break;
              }
              com.tencent.mm.ui.base.s.gM(this.mContext);
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.wI(10);
      au.Hx();
      paramAdapterView = (String)com.tencent.mm.model.c.Dz().get(68377, null);
      au.Hx();
      com.tencent.mm.model.c.Dz().o(68377, "");
      paramView = new Intent();
      paramView.putExtra("sns_timeline_NeedFirstLoadint", true);
      if (bk.bl(paramAdapterView)) {
        break;
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if (n.omE != null) {
        if (n.omE.aAo() > 0) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        paramView.putExtra("sns_resume_state", bool1);
        com.tencent.mm.br.d.b(this.mContext, "sns", ".ui.SnsTimeLineUI", paramView);
        break;
        continue;
        au.Hx();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.s.gM(this.mContext);
          break;
        }
        com.tencent.mm.br.d.x(this.mContext, "game", ".ui.GameCenterUI");
        new ah().postDelayed(new af.3(this), 100L);
        break;
        com.tencent.mm.sdk.b.a.udP.m(new no());
        com.tencent.mm.br.d.x(this.mContext, "shake", ".ui.ShakeReportUI");
        break;
        au.Hx();
        if (!bk.d((Boolean)com.tencent.mm.model.c.Dz().get(4103, null)))
        {
          com.tencent.mm.br.d.x(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
          break;
        }
        paramAdapterView = bn.Ie();
        if (paramAdapterView == null)
        {
          com.tencent.mm.br.d.x(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
          break;
        }
        paramView = bk.pm(paramAdapterView.getProvince());
        paramInt = bk.a(Integer.valueOf(paramAdapterView.sex), 0);
        if ((bk.bl(paramView)) || (paramInt == 0))
        {
          com.tencent.mm.br.d.x(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
          break;
        }
        au.Hx();
        paramAdapterView = (Boolean)com.tencent.mm.model.c.Dz().get(4104, null);
        if ((paramAdapterView == null) || (!paramAdapterView.booleanValue()))
        {
          paramAdapterView = LauncherUI.cyX();
          if (paramAdapterView != null) {
            paramAdapterView.uKP.uKi.acW("tab_find_friend");
          }
          com.tencent.mm.bp.a.eF(this.mContext);
          break;
        }
        paramAdapterView = View.inflate(this.mContext, R.i.lbs_open_dialog_view, null);
        paramView = (CheckBox)paramAdapterView.findViewById(R.h.lbs_open_dialog_cb);
        paramView.setChecked(false);
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.app_tip), paramAdapterView, new af.4(this, paramView), null);
        break;
        paramAdapterView = bn.Id();
        if ((bk.a(Integer.valueOf(paramAdapterView.sex), 0) <= 0) || (bk.bl(paramAdapterView.getProvince())))
        {
          com.tencent.mm.br.d.x(this.mContext, "bottle", ".ui.BottleWizardStep1");
          break;
        }
        com.tencent.mm.br.d.x(this.mContext, "bottle", ".ui.BottleBeachUI");
        break;
        au.Hx();
        if (com.tencent.mm.model.c.Fs())
        {
          com.tencent.mm.br.d.x(this.mContext, "webwx", ".ui.WebWXLogoutUI");
          break;
        }
        com.tencent.mm.br.d.x(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
        break;
        if ((q.Gu() & 0x10000) == 0) {}
        for (paramInt = i;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label1482;
          }
          com.tencent.mm.br.d.x(this.mContext, "masssend", ".ui.MassSendHistoryUI");
          break;
        }
        label1482:
        com.tencent.mm.br.d.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
        break;
        com.tencent.mm.br.d.x(this.mContext, "radar", ".ui.RadarSearchUI");
        break;
        com.tencent.mm.br.d.x(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
        break;
        com.tencent.mm.plugin.report.service.h.nFQ.aC(10919, "1-6");
        com.tencent.mm.pluginsdk.d.eJ(this.mContext);
        break;
        paramAdapterView = new Intent();
        au.Hx();
        paramView = (String)com.tencent.mm.model.c.Dz().get(ac.a.uwo, "");
        if (!bk.bl(paramView))
        {
          paramAdapterView.putExtra("rawUrl", paramView);
          paramAdapterView.putExtra("showShare", true);
          paramAdapterView.putExtra("show_bottom", false);
          com.tencent.mm.br.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramAdapterView);
          break;
        }
        com.tencent.mm.pluginsdk.d.eJ(this.mContext);
        break;
        paramAdapterView = this.mContext;
        paramView = new Intent();
        paramView.putExtra("key_from_scene", 2);
        com.tencent.mm.br.d.b(paramAdapterView, "offline", ".ui.WalletOfflineEntranceUI", paramView);
        if (!com.tencent.mm.y.c.BS().bc(262159, 266248)) {
          break;
        }
        com.tencent.mm.y.c.BS().bd(262159, 266248);
        com.tencent.mm.plugin.report.service.h.nFQ.f(14396, new Object[] { Integer.valueOf(2) });
        break;
        com.tencent.mm.pluginsdk.wallet.h.X(this.mContext, 1);
        break;
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("key_from_scene", 2);
        com.tencent.mm.br.d.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", paramAdapterView);
        break;
      }
    }
  }
  
  protected final BaseAdapter xX()
  {
    if (this.uQo == null) {
      this.uQo = new af.a(this, (byte)0);
    }
    return this.uQo;
  }
  
  public static final class c
  {
    int bFo = 0;
    boolean uQt = false;
    boolean uQu = false;
    af.d uQv;
    
    public c(af.d paramd)
    {
      this.uQv = paramd;
    }
  }
  
  public static final class d
  {
    int icon;
    int textColor;
    String uQw;
    String uQx;
    int uQy;
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      this.uQw = paramString1;
      this.uQx = paramString2;
      this.icon = paramInt2;
      this.uQy = paramInt1;
      this.textColor = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.af
 * JD-Core Version:    0.7.0.1
 */