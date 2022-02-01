package com.tencent.mm.plugin.sport.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.m;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.ak.i, com.tencent.mm.pluginsdk.b.a
{
  private static final String Fkh;
  private CheckBoxPreference Fki;
  private as contact;
  private Context context;
  private com.tencent.mm.ui.base.q nUq;
  private CheckBoxPreference qNs;
  private com.tencent.mm.ui.base.preference.f screen;
  
  static
  {
    AppMethodBeat.i(232064);
    Fkh = "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index";
    AppMethodBeat.o(232064);
  }
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void cCt()
  {
    AppMethodBeat.i(28825);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    localHelperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131758115));
    if (com.tencent.mm.contact.c.oR(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.jdMethod_do("contact_info_sport_install", true);
      this.screen.jdMethod_do("contact_info_sport_uninstall", false);
      this.screen.jdMethod_do("contact_info_go_to_sport", false);
      this.screen.jdMethod_do("contact_info_go_to_my_profile", false);
      this.screen.jdMethod_do("contact_info_invite_friend", false);
      this.screen.jdMethod_do("contact_info_common_problem", false);
      this.screen.jdMethod_do("contact_info_record_data", false);
      this.screen.jdMethod_do("contact_info_privacy_and_notification", false);
      this.screen.jdMethod_do("contact_info_top_sport", false);
      this.screen.jdMethod_do("contact_info_not_disturb", false);
      bg.aVF();
      if (com.tencent.mm.model.c.aST().bkg(this.contact.field_username)) {
        this.Fki.setChecked(true);
      }
      while (this.contact.Zx())
      {
        this.qNs.setChecked(true);
        AppMethodBeat.o(28825);
        return;
        this.Fki.setChecked(false);
      }
      this.qNs.setChecked(false);
      AppMethodBeat.o(28825);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.jdMethod_do("contact_info_sport_install", false);
    this.screen.jdMethod_do("contact_info_sport_uninstall", true);
    this.screen.jdMethod_do("contact_info_go_to_sport", true);
    this.screen.jdMethod_do("contact_info_go_to_my_profile", true);
    this.screen.jdMethod_do("contact_info_invite_friend", true);
    this.screen.jdMethod_do("contact_info_common_problem", true);
    this.screen.jdMethod_do("contact_info_record_data", true);
    this.screen.jdMethod_do("contact_info_privacy_and_notification", true);
    this.screen.jdMethod_do("contact_info_top_sport", true);
    this.screen.jdMethod_do("contact_info_not_disturb", true);
    AppMethodBeat.o(28825);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(28822);
    this.screen = paramf;
    this.contact = paramas;
    paramf.addPreferencesFromResource(2132017195);
    this.Fki = ((CheckBoxPreference)paramf.bmg("contact_info_top_sport"));
    this.qNs = ((CheckBoxPreference)paramf.bmg("contact_info_not_disturb"));
    cCt();
    AppMethodBeat.o(28822);
    return true;
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(28823);
    Object localObject;
    if ("contact_info_record_data".equals(paramString))
    {
      localObject = new Intent(this.context, ExdeviceRankDataSourceUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(28823);
      return false;
      if ("contact_info_top_sport".equals(paramString))
      {
        if (this.Fki.isChecked())
        {
          com.tencent.mm.plugin.sport.a.c.pl(20);
          ab.E(this.contact.field_username, true);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.c.pl(21);
          ab.F(this.contact.field_username, true);
        }
      }
      else if ("contact_info_not_disturb".equals(paramString))
      {
        if (this.qNs.isChecked())
        {
          com.tencent.mm.plugin.sport.a.c.pl(22);
          ab.z(this.contact);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.c.pl(23);
          ab.A(this.contact);
        }
      }
      else if ("contact_info_go_to_sport".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("finish_direct", true);
        com.tencent.mm.br.c.f(this.context, ".ui.chatting.ChattingUI", paramString);
        com.tencent.mm.plugin.sport.a.c.pl(19);
      }
      else if ("contact_info_go_to_my_profile".equals(paramString))
      {
        paramString = z.aTY();
        if (Util.isNullOrNil(paramString))
        {
          Log.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
          AppMethodBeat.o(28823);
          return false;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("username", paramString);
        com.tencent.mm.br.c.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", (Intent)localObject);
        com.tencent.mm.plugin.sport.a.c.pl(3);
      }
      else if ("contact_info_invite_friend".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Select_Talker_Name", this.contact.field_username);
        paramString.putExtra("Select_block_List", this.contact.field_username);
        paramString.putExtra("Select_Conv_Type", 3);
        paramString.putExtra("Select_Send_Card", true);
        paramString.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.br.c.c(this.context, ".ui.transmit.SelectConversationUI", paramString, 1);
        com.tencent.mm.plugin.sport.a.c.pl(4);
      }
      else if ("contact_info_common_problem".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("KPublisherId", "custom_menu");
        paramString.putExtra("pre_username", this.contact.field_username);
        paramString.putExtra("prePublishId", "custom_menu");
        paramString.putExtra("preUsername", this.contact.field_username);
        paramString.putExtra("preChatName", this.contact.field_username);
        paramString.putExtra("preChatTYPE", ac.aJ(this.contact.field_username, this.contact.field_username));
        paramString.putExtra("rawUrl", Fkh);
        paramString.putExtra("geta8key_username", this.contact.field_username);
        paramString.putExtra("from_scence", 1);
        com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
        com.tencent.mm.plugin.sport.a.c.pl(5);
      }
      else if ("contact_info_privacy_and_notification".equals(paramString))
      {
        com.tencent.mm.br.c.V(this.context, "exdevice", ".ui.ExdeviceSettingUI");
      }
      else if ("contact_info_sport_install".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.c.pl(13);
        paramString = this.context;
        this.context.getString(2131755998);
        this.nUq = h.a(paramString, this.context.getString(2131765544), true, null);
        this.nUq.show();
        bg.azz().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_43f2581f6fd6");
        localObject = new LinkedList();
        ((LinkedList)localObject).add(Integer.valueOf(1));
        paramString = new p(paramString, (List)localObject, "", "");
        bg.azz().a(paramString, 0);
        com.tencent.mm.plugin.sport.model.g.vH(true);
      }
      else if ("contact_info_sport_uninstall".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.c.pl(14);
        h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28821);
            paramAnonymousDialogInterface = com.tencent.mm.al.g.fJ(a.a(a.this).field_username);
            ((m)com.tencent.mm.kernel.g.af(m.class)).a(paramAnonymousDialogInterface, (Activity)a.b(a.this), a.a(a.this));
            a.c(a.this);
            com.tencent.mm.plugin.sport.model.g.vH(false);
            AppMethodBeat.o(28821);
          }
        }, null);
      }
      else if ("contact_info_clear_data".equals(paramString))
      {
        h.c(this.context, this.context.getString(2131757858), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28820);
            com.tencent.mm.plugin.sport.a.c.pl(25);
            bg.aVF();
            com.tencent.mm.model.c.aSQ().aEE("gh_43f2581f6fd6");
            AppMethodBeat.o(28820);
          }
        }, null);
      }
    }
  }
  
  public final boolean cCs()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(28824);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(28824);
      return;
      if (paramIntent != null)
      {
        Object localObject = Util.stringsToList(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          com.tencent.mm.plugin.messenger.a.g.eir().s("gh_43f2581f6fd6", str, ab.Eq(str));
          if (!Util.isNullOrNil(paramIntent))
          {
            tw localtw = new tw();
            localtw.eaq.dkV = str;
            localtw.eaq.content = paramIntent;
            localtw.eaq.type = ab.JG(str);
            localtw.eaq.flags = 0;
            EventCenter.instance.publish(localtw);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(28826);
    if ((paramq instanceof p))
    {
      bg.azz().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && ((paramInt2 == -2) || (paramInt2 == -101) || (paramInt2 == -24)) && (!Util.isNullOrNil(paramString))) {
          Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
        }
        if (this.nUq != null) {
          this.nUq.dismiss();
        }
        cCt();
      }
    }
    else
    {
      AppMethodBeat.o(28826);
      return;
    }
    Object localObject = ((p)paramq).gmD();
    Log.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", new Object[] { localObject });
    bg.aVF();
    paramq = com.tencent.mm.model.c.aSN().Kn("gh_43f2581f6fd6");
    if ((paramq == null) || (Util.isNullOrNil((String)localObject))) {
      Log.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + (String)localObject + ", contact = " + paramq);
    }
    for (;;)
    {
      paramString = ag.bah().MT(paramq.field_username);
      ag.bah().h(paramString);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(327825, Boolean.TRUE);
      com.tencent.mm.plugin.newtips.a.exl();
      paramInt1 = com.tencent.mm.plugin.newtips.a.d.ADd;
      com.tencent.mm.plugin.newtips.a.i.f(paramInt1, com.tencent.mm.plugin.newtips.a.d.ACZ, "", null);
      Log.i("MicroMsg.NewTips.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), "" });
      break;
      paramString = null;
      if (ab.IR(paramq.field_username))
      {
        String str = Util.nullAsNil(paramq.field_username);
        paramString = com.tencent.mm.al.g.fJ(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        ag.bah().delete(str);
        paramq.BK(str);
      }
      paramq.setUsername((String)localObject);
      if ((int)paramq.gMZ == 0)
      {
        bg.aVF();
        com.tencent.mm.model.c.aSN().aq(paramq);
      }
      if ((int)paramq.gMZ <= 0)
      {
        Log.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
      }
      else
      {
        ab.B(paramq);
        bg.aVF();
        localObject = com.tencent.mm.model.c.aSN().Kn(paramq.field_username);
        if (paramString != null)
        {
          ag.bah().g(paramString);
        }
        else
        {
          paramString = com.tencent.mm.al.g.fJ(((ax)localObject).field_username);
          if ((paramString == null) || (paramString.Uz()))
          {
            Log.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
            ay.a.iDq.aL(((ax)localObject).field_username, "");
            com.tencent.mm.aj.c.Mf(((ax)localObject).field_username);
          }
          else if (((as)localObject).gBQ())
          {
            Log.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", new Object[] { Integer.valueOf(((ax)localObject).fuP) });
            ay.a.iDq.aL(((ax)localObject).field_username, "");
            com.tencent.mm.aj.c.Mf(((ax)localObject).field_username);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.a.a
 * JD-Core Version:    0.7.0.1
 */