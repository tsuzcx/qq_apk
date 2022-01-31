package com.tencent.mm.plugin.sport.ui.a;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ai.e;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.ah.f, com.tencent.mm.pluginsdk.b.a
{
  Context context;
  private com.tencent.mm.ui.base.preference.f dnn;
  ad dnp;
  private com.tencent.mm.ui.base.p hdi;
  private CheckBoxPreference iUh;
  private CheckBoxPreference puk;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    this.dnn = paramf;
    this.dnp = paramad;
    paramf.addPreferencesFromResource(R.o.contact_info_pref_sport);
    this.puk = ((CheckBoxPreference)paramf.add("contact_info_top_sport"));
    this.iUh = ((CheckBoxPreference)paramf.add("contact_info_not_disturb"));
    awY();
    return true;
  }
  
  final void awY()
  {
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.dnn.add("contact_info_header_helper");
    localHelperHeaderPreference.al(this.dnp.field_username, this.dnp.Bq(), this.context.getString(R.l.contact_info_sport_switch_tip));
    if (com.tencent.mm.n.a.gR(this.dnp.field_type))
    {
      localHelperHeaderPreference.ov(1);
      this.dnn.bJ("contact_info_sport_install", true);
      this.dnn.bJ("contact_info_sport_uninstall", false);
      this.dnn.bJ("contact_info_go_to_sport", false);
      this.dnn.bJ("contact_info_go_to_my_profile", false);
      this.dnn.bJ("contact_info_invite_friend", false);
      this.dnn.bJ("contact_info_common_problem", false);
      this.dnn.bJ("contact_info_record_data", false);
      this.dnn.bJ("contact_info_privacy_and_notification", false);
      this.dnn.bJ("contact_info_top_sport", false);
      this.dnn.bJ("contact_info_not_disturb", false);
      au.Hx();
      if (c.FB().abD(this.dnp.field_username)) {}
      for (this.puk.rHo = true; this.dnp.Bj(); this.puk.rHo = false)
      {
        this.iUh.rHo = true;
        return;
      }
      this.iUh.rHo = false;
      return;
    }
    localHelperHeaderPreference.ov(0);
    this.dnn.bJ("contact_info_sport_install", false);
    this.dnn.bJ("contact_info_sport_uninstall", true);
    this.dnn.bJ("contact_info_go_to_sport", true);
    this.dnn.bJ("contact_info_go_to_my_profile", true);
    this.dnn.bJ("contact_info_invite_friend", true);
    this.dnn.bJ("contact_info_common_problem", true);
    this.dnn.bJ("contact_info_record_data", true);
    this.dnn.bJ("contact_info_privacy_and_notification", true);
    this.dnn.bJ("contact_info_top_sport", true);
    this.dnn.bJ("contact_info_not_disturb", true);
  }
  
  public final boolean awZ()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      return;
      if (paramIntent != null)
      {
        Object localObject = bk.G(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          g.bhI().o("gh_43f2581f6fd6", str, s.fn(str));
          if (!bk.bl(paramIntent))
          {
            pe localpe = new pe();
            localpe.bYQ.bYR = str;
            localpe.bYQ.content = paramIntent;
            localpe.bYQ.type = s.hW(str);
            localpe.bYQ.flags = 0;
            com.tencent.mm.sdk.b.a.udP.m(localpe);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof com.tencent.mm.pluginsdk.model.m))
    {
      au.Dk().b(30, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label104;
      }
      y.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bk.bl(paramString))) {
        Toast.makeText(ae.getContext(), paramString, 1).show();
      }
    }
    label104:
    Object localObject;
    for (;;)
    {
      if (this.hdi != null) {
        this.hdi.dismiss();
      }
      awY();
      return;
      localObject = ((com.tencent.mm.pluginsdk.model.m)paramm).ckC();
      y.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", new Object[] { localObject });
      au.Hx();
      paramm = c.Fw().abl("gh_43f2581f6fd6");
      if ((paramm != null) && (!bk.bl((String)localObject))) {
        break;
      }
      y.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + (String)localObject + ", contact = " + paramm);
      paramString = com.tencent.mm.ai.z.My().kQ(paramm.field_username);
      com.tencent.mm.ai.z.My().e(paramString);
      au.Hx();
      c.Dz().o(327825, Boolean.valueOf(true));
      com.tencent.mm.plugin.y.a.bot();
      paramInt1 = com.tencent.mm.aw.b.evh;
      com.tencent.mm.aw.d.b(paramInt1, com.tencent.mm.aw.b.evd, "", null);
      y.i("MicroMsg.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), "" });
    }
    if (s.hj(paramm.field_username))
    {
      String str = bk.pm(paramm.field_username);
      paramString = com.tencent.mm.ai.f.kX(str);
      if (paramString != null) {
        paramString.field_username = ((String)localObject);
      }
      com.tencent.mm.ai.z.My().delete(str);
      paramm.dq(str);
    }
    for (;;)
    {
      paramm.setUsername((String)localObject);
      if ((int)paramm.dBe == 0)
      {
        au.Hx();
        c.Fw().W(paramm);
      }
      if ((int)paramm.dBe <= 0)
      {
        y.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
        break;
      }
      s.q(paramm);
      au.Hx();
      localObject = c.Fw().abl(paramm.field_username);
      if (paramString != null)
      {
        com.tencent.mm.ai.z.My().d(paramString);
        break;
      }
      paramString = com.tencent.mm.ai.f.kX(((ao)localObject).field_username);
      if ((paramString == null) || (paramString.Ls()))
      {
        y.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
        am.a.dVy.V(((ao)localObject).field_username, "");
        com.tencent.mm.ag.b.ka(((ao)localObject).field_username);
        break;
      }
      if (!((ad)localObject).cud()) {
        break;
      }
      y.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", new Object[] { Integer.valueOf(((ao)localObject).cCH) });
      am.a.dVy.V(((ao)localObject).field_username, "");
      com.tencent.mm.ag.b.ka(((ao)localObject).field_username);
      break;
      paramString = null;
    }
  }
  
  public final boolean xQ(String paramString)
  {
    if ("contact_info_record_data".equals(paramString))
    {
      paramString = new Intent(this.context, ExdeviceRankDataSourceUI.class);
      this.context.startActivity(paramString);
    }
    do
    {
      return false;
      if ("contact_info_top_sport".equals(paramString))
      {
        if (this.puk.isChecked())
        {
          com.tencent.mm.plugin.sport.b.d.jdMethod_if(20);
          s.t(this.dnp.field_username, true);
          return false;
        }
        com.tencent.mm.plugin.sport.b.d.jdMethod_if(21);
        s.u(this.dnp.field_username, true);
        return false;
      }
      if ("contact_info_not_disturb".equals(paramString))
      {
        if (this.iUh.isChecked())
        {
          com.tencent.mm.plugin.sport.b.d.jdMethod_if(22);
          s.o(this.dnp);
          return false;
        }
        com.tencent.mm.plugin.sport.b.d.jdMethod_if(23);
        s.p(this.dnp);
        return false;
      }
      if ("contact_info_go_to_sport".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Chat_User", this.dnp.field_username);
        paramString.putExtra("finish_direct", true);
        com.tencent.mm.br.d.e(this.context, ".ui.chatting.ChattingUI", paramString);
        com.tencent.mm.plugin.sport.b.d.jdMethod_if(19);
        return false;
      }
      Object localObject;
      if ("contact_info_go_to_my_profile".equals(paramString))
      {
        paramString = q.Gj();
        if (bk.bl(paramString))
        {
          y.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
          return false;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("username", paramString);
        com.tencent.mm.br.d.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", (Intent)localObject);
        com.tencent.mm.plugin.sport.b.d.jdMethod_if(3);
        return false;
      }
      if ("contact_info_invite_friend".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Select_Talker_Name", this.dnp.field_username);
        paramString.putExtra("Select_block_List", this.dnp.field_username);
        paramString.putExtra("Select_Conv_Type", 3);
        paramString.putExtra("Select_Send_Card", true);
        paramString.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.br.d.c(this.context, ".ui.transmit.SelectConversationUI", paramString, 1);
        com.tencent.mm.plugin.sport.b.d.jdMethod_if(4);
        return false;
      }
      if ("contact_info_common_problem".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("KPublisherId", "custom_menu");
        paramString.putExtra("pre_username", this.dnp.field_username);
        paramString.putExtra("prePublishId", "custom_menu");
        paramString.putExtra("preUsername", this.dnp.field_username);
        paramString.putExtra("preChatName", this.dnp.field_username);
        paramString.putExtra("preChatTYPE", t.R(this.dnp.field_username, this.dnp.field_username));
        paramString.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
        paramString.putExtra("geta8key_username", this.dnp.field_username);
        paramString.putExtra("from_scence", 1);
        com.tencent.mm.br.d.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
        com.tencent.mm.plugin.sport.b.d.jdMethod_if(5);
        return false;
      }
      if ("contact_info_privacy_and_notification".equals(paramString))
      {
        com.tencent.mm.br.d.x(this.context, "exdevice", ".ui.ExdeviceSettingUI");
        return false;
      }
      if ("contact_info_sport_install".equals(paramString))
      {
        com.tencent.mm.plugin.sport.b.d.jdMethod_if(13);
        paramString = this.context;
        this.context.getString(R.l.app_tip);
        this.hdi = h.b(paramString, this.context.getString(R.l.settings_plugins_installing), true, null);
        this.hdi.show();
        au.Dk().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_43f2581f6fd6");
        localObject = new LinkedList();
        ((LinkedList)localObject).add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.m(1, paramString, (List)localObject, "", "");
        au.Dk().a(paramString, 0);
        return false;
      }
      if ("contact_info_sport_uninstall".equals(paramString))
      {
        com.tencent.mm.plugin.sport.b.d.jdMethod_if(14);
        h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new a.2(this), null);
        return false;
      }
    } while (!"contact_info_clear_data".equals(paramString));
    h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new a.1(this), null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.a.a
 * JD-Core Version:    0.7.0.1
 */