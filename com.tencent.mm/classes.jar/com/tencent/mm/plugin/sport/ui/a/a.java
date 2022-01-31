package com.tencent.mm.plugin.sport.ui.a;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.ai.f, com.tencent.mm.pluginsdk.b.a
{
  ad contact;
  Context context;
  private com.tencent.mm.ui.base.p iMZ;
  private CheckBoxPreference ldk;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference sqA;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(25148);
    if ("contact_info_record_data".equals(paramString))
    {
      paramString = new Intent(this.context, ExdeviceRankDataSourceUI.class);
      this.context.startActivity(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(25148);
      return false;
      if ("contact_info_top_sport".equals(paramString))
      {
        if (this.sqA.isChecked())
        {
          com.tencent.mm.plugin.sport.a.d.kS(20);
          t.x(this.contact.field_username, true);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.d.kS(21);
          t.y(this.contact.field_username, true);
        }
      }
      else if ("contact_info_not_disturb".equals(paramString))
      {
        if (this.ldk.isChecked())
        {
          com.tencent.mm.plugin.sport.a.d.kS(22);
          t.o(this.contact);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.d.kS(23);
          t.p(this.contact);
        }
      }
      else if ("contact_info_go_to_sport".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("finish_direct", true);
        com.tencent.mm.bq.d.f(this.context, ".ui.chatting.ChattingUI", paramString);
        com.tencent.mm.plugin.sport.a.d.kS(19);
      }
      else
      {
        Object localObject;
        if ("contact_info_go_to_my_profile".equals(paramString))
        {
          paramString = r.Zn();
          if (bo.isNullOrNil(paramString))
          {
            ab.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
            AppMethodBeat.o(25148);
            return false;
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("username", paramString);
          com.tencent.mm.bq.d.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", (Intent)localObject);
          com.tencent.mm.plugin.sport.a.d.kS(3);
        }
        else if ("contact_info_invite_friend".equals(paramString))
        {
          paramString = new Intent();
          paramString.putExtra("Select_Talker_Name", this.contact.field_username);
          paramString.putExtra("Select_block_List", this.contact.field_username);
          paramString.putExtra("Select_Conv_Type", 3);
          paramString.putExtra("Select_Send_Card", true);
          paramString.putExtra("mutil_select_is_ret", true);
          com.tencent.mm.bq.d.b(this.context, ".ui.transmit.SelectConversationUI", paramString, 1);
          com.tencent.mm.plugin.sport.a.d.kS(4);
        }
        else if ("contact_info_common_problem".equals(paramString))
        {
          paramString = new Intent();
          paramString.putExtra("KPublisherId", "custom_menu");
          paramString.putExtra("pre_username", this.contact.field_username);
          paramString.putExtra("prePublishId", "custom_menu");
          paramString.putExtra("preUsername", this.contact.field_username);
          paramString.putExtra("preChatName", this.contact.field_username);
          paramString.putExtra("preChatTYPE", u.ah(this.contact.field_username, this.contact.field_username));
          paramString.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
          paramString.putExtra("geta8key_username", this.contact.field_username);
          paramString.putExtra("from_scence", 1);
          com.tencent.mm.bq.d.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
          com.tencent.mm.plugin.sport.a.d.kS(5);
        }
        else if ("contact_info_privacy_and_notification".equals(paramString))
        {
          com.tencent.mm.bq.d.H(this.context, "exdevice", ".ui.ExdeviceSettingUI");
        }
        else if ("contact_info_sport_install".equals(paramString))
        {
          com.tencent.mm.plugin.sport.a.d.kS(13);
          paramString = this.context;
          this.context.getString(2131297087);
          this.iMZ = com.tencent.mm.ui.base.h.b(paramString, this.context.getString(2131303380), true, null);
          this.iMZ.show();
          aw.Rc().a(30, this);
          paramString = new LinkedList();
          paramString.add("gh_43f2581f6fd6");
          localObject = new LinkedList();
          ((LinkedList)localObject).add(Integer.valueOf(1));
          paramString = new com.tencent.mm.pluginsdk.model.m(paramString, (List)localObject, "", "");
          aw.Rc().a(paramString, 0);
          com.tencent.mm.plugin.sport.model.h.lL(true);
        }
        else if ("contact_info_sport_uninstall".equals(paramString))
        {
          com.tencent.mm.plugin.sport.a.d.kS(14);
          com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new a.2(this), null);
        }
        else if ("contact_info_clear_data".equals(paramString))
        {
          com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131298571), "", this.context.getString(2131296891), this.context.getString(2131296888), new a.1(this), null);
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25147);
    this.screen = paramf;
    this.contact = paramad;
    paramf.addPreferencesFromResource(2131165223);
    this.sqA = ((CheckBoxPreference)paramf.atx("contact_info_top_sport"));
    this.ldk = ((CheckBoxPreference)paramf.atx("contact_info_not_disturb"));
    bkc();
    AppMethodBeat.o(25147);
    return true;
  }
  
  public final boolean bkb()
  {
    return true;
  }
  
  final void bkc()
  {
    AppMethodBeat.i(25150);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.atx("contact_info_header_helper");
    localHelperHeaderPreference.aB(this.contact.field_username, this.contact.Of(), this.context.getString(2131298812));
    if (com.tencent.mm.n.a.je(this.contact.field_type))
    {
      localHelperHeaderPreference.sb(1);
      this.screen.cl("contact_info_sport_install", true);
      this.screen.cl("contact_info_sport_uninstall", false);
      this.screen.cl("contact_info_go_to_sport", false);
      this.screen.cl("contact_info_go_to_my_profile", false);
      this.screen.cl("contact_info_invite_friend", false);
      this.screen.cl("contact_info_common_problem", false);
      this.screen.cl("contact_info_record_data", false);
      this.screen.cl("contact_info_privacy_and_notification", false);
      this.screen.cl("contact_info_top_sport", false);
      this.screen.cl("contact_info_not_disturb", false);
      aw.aaz();
      if (c.YF().arP(this.contact.field_username)) {}
      for (this.sqA.vxW = true; this.contact.DP(); this.sqA.vxW = false)
      {
        this.ldk.vxW = true;
        AppMethodBeat.o(25150);
        return;
      }
      this.ldk.vxW = false;
      AppMethodBeat.o(25150);
      return;
    }
    localHelperHeaderPreference.sb(0);
    this.screen.cl("contact_info_sport_install", false);
    this.screen.cl("contact_info_sport_uninstall", true);
    this.screen.cl("contact_info_go_to_sport", true);
    this.screen.cl("contact_info_go_to_my_profile", true);
    this.screen.cl("contact_info_invite_friend", true);
    this.screen.cl("contact_info_common_problem", true);
    this.screen.cl("contact_info_record_data", true);
    this.screen.cl("contact_info_privacy_and_notification", true);
    this.screen.cl("contact_info_top_sport", true);
    this.screen.cl("contact_info_not_disturb", true);
    AppMethodBeat.o(25150);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(25149);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(25149);
      return;
      if (paramIntent != null)
      {
        Object localObject = bo.P(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          g.bPJ().q("gh_43f2581f6fd6", str, t.lA(str));
          if (!bo.isNullOrNil(paramIntent))
          {
            qj localqj = new qj();
            localqj.cGX.cGY = str;
            localqj.cGX.content = paramIntent;
            localqj.cGX.type = t.oF(str);
            localqj.cGX.flags = 0;
            com.tencent.mm.sdk.b.a.ymk.l(localqj);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(25151);
    if ((paramm instanceof com.tencent.mm.pluginsdk.model.m))
    {
      aw.Rc().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bo.isNullOrNil(paramString))) {
          Toast.makeText(ah.getContext(), paramString, 1).show();
        }
        if (this.iMZ != null) {
          this.iMZ.dismiss();
        }
        bkc();
      }
    }
    else
    {
      AppMethodBeat.o(25151);
      return;
    }
    Object localObject = ((com.tencent.mm.pluginsdk.model.m)paramm).dlk();
    ab.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", new Object[] { localObject });
    aw.aaz();
    paramm = c.YA().arw("gh_43f2581f6fd6");
    if ((paramm == null) || (bo.isNullOrNil((String)localObject))) {
      ab.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + (String)localObject + ", contact = " + paramm);
    }
    for (;;)
    {
      paramString = com.tencent.mm.aj.z.afi().rK(paramm.field_username);
      com.tencent.mm.aj.z.afi().e(paramString);
      aw.aaz();
      c.Ru().set(327825, Boolean.TRUE);
      com.tencent.mm.plugin.r.a.bWS();
      paramInt1 = com.tencent.mm.ax.b.fKU;
      com.tencent.mm.ax.d.b(paramInt1, com.tencent.mm.ax.b.fKQ, "", null);
      ab.i("MicroMsg.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), "" });
      break;
      paramString = null;
      if (t.nS(paramm.field_username))
      {
        String str = bo.nullAsNil(paramm.field_username);
        paramString = com.tencent.mm.aj.f.rS(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        com.tencent.mm.aj.z.afi().delete(str);
        paramm.jv(str);
      }
      paramm.setUsername((String)localObject);
      if ((int)paramm.euF == 0)
      {
        aw.aaz();
        c.YA().Z(paramm);
      }
      if ((int)paramm.euF <= 0)
      {
        ab.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
      }
      else
      {
        t.q(paramm);
        aw.aaz();
        localObject = c.YA().arw(paramm.field_username);
        if (paramString != null)
        {
          com.tencent.mm.aj.z.afi().d(paramString);
        }
        else
        {
          paramString = com.tencent.mm.aj.f.rS(((aq)localObject).field_username);
          if ((paramString == null) || (paramString.aea()))
          {
            ab.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
            ao.a.flI.am(((aq)localObject).field_username, "");
            com.tencent.mm.ah.b.qT(((aq)localObject).field_username);
          }
          else if (((ad)localObject).dwC())
          {
            ab.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", new Object[] { Integer.valueOf(((aq)localObject).dqR) });
            ao.a.flI.am(((aq)localObject).field_username, "");
            com.tencent.mm.ah.b.qT(((aq)localObject).field_username);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.a.a
 * JD-Core Version:    0.7.0.1
 */