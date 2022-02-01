package com.tencent.mm.plugin.sport.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.af;
import com.tencent.mm.api.n;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.am.h, com.tencent.mm.pluginsdk.c.a
{
  private static final String ScG;
  private CheckBoxPreference ScH;
  private au contact;
  private Context context;
  private w rYw;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference xvc;
  
  static
  {
    AppMethodBeat.i(263964);
    ScG = "https://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index";
    AppMethodBeat.o(263964);
  }
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void dvr()
  {
    AppMethodBeat.i(28825);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    localHelperHeaderPreference.bz(this.contact.field_username, this.contact.aSV(), this.context.getString(R.l.gCX));
    if (com.tencent.mm.contact.d.rs(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.eh("contact_info_sport_install", true);
      this.screen.eh("contact_info_sport_uninstall", false);
      this.screen.eh("contact_info_go_to_sport", false);
      this.screen.eh("contact_info_go_to_my_profile", false);
      this.screen.eh("contact_info_invite_friend", false);
      this.screen.eh("contact_info_common_problem", false);
      this.screen.eh("contact_info_record_data", false);
      this.screen.eh("contact_info_privacy_and_notification", false);
      this.screen.eh("contact_info_top_sport", false);
      this.screen.eh("contact_info_not_disturb", false);
      bh.bCz();
      if (com.tencent.mm.model.c.bzG().bxV(this.contact.field_username)) {
        this.ScH.setChecked(true);
      }
      while (this.contact.aGe())
      {
        this.xvc.setChecked(true);
        AppMethodBeat.o(28825);
        return;
        this.ScH.setChecked(false);
      }
      this.xvc.setChecked(false);
      AppMethodBeat.o(28825);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.eh("contact_info_sport_install", false);
    this.screen.eh("contact_info_sport_uninstall", true);
    this.screen.eh("contact_info_go_to_sport", true);
    this.screen.eh("contact_info_go_to_my_profile", true);
    this.screen.eh("contact_info_invite_friend", true);
    this.screen.eh("contact_info_common_problem", true);
    this.screen.eh("contact_info_record_data", true);
    this.screen.eh("contact_info_privacy_and_notification", true);
    this.screen.eh("contact_info_top_sport", true);
    this.screen.eh("contact_info_not_disturb", true);
    AppMethodBeat.o(28825);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(28822);
    this.screen = paramf;
    this.contact = paramau;
    paramf.aBe(R.o.haX);
    this.ScH = ((CheckBoxPreference)paramf.bAi("contact_info_top_sport"));
    this.xvc = ((CheckBoxPreference)paramf.bAi("contact_info_not_disturb"));
    dvr();
    AppMethodBeat.o(28822);
    return true;
  }
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(28823);
    Object localObject;
    if ("contact_info_record_data".equals(paramString))
    {
      localObject = new Intent(this.context, ExdeviceRankDataSourceUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(28823);
      return false;
      if ("contact_info_top_sport".equals(paramString))
      {
        if (this.ScH.isChecked())
        {
          com.tencent.mm.plugin.sport.a.d.rG(20);
          ab.K(this.contact.field_username, true);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.d.rG(21);
          ab.L(this.contact.field_username, true);
        }
      }
      else if ("contact_info_not_disturb".equals(paramString))
      {
        if (this.xvc.isChecked())
        {
          com.tencent.mm.plugin.sport.a.d.rG(22);
          ab.G(this.contact);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.d.rG(23);
          ab.H(this.contact);
        }
      }
      else if ("contact_info_go_to_sport".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("finish_direct", true);
        com.tencent.mm.br.c.g(this.context, ".ui.chatting.ChattingUI", paramString);
        com.tencent.mm.plugin.sport.a.d.rG(19);
      }
      else if ("contact_info_go_to_my_profile".equals(paramString))
      {
        paramString = z.bAM();
        if (Util.isNullOrNil(paramString))
        {
          Log.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
          AppMethodBeat.o(28823);
          return false;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("username", paramString);
        com.tencent.mm.br.c.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", (Intent)localObject);
        com.tencent.mm.plugin.sport.a.d.rG(3);
      }
      else if ("contact_info_invite_friend".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Select_Talker_Name", this.contact.field_username);
        paramString.putExtra("Select_block_List", this.contact.field_username);
        paramString.putExtra("Select_Conv_Type", 3);
        paramString.putExtra("Select_Send_Card", true);
        paramString.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.br.c.d(this.context, ".ui.transmit.SelectConversationUI", paramString, 1);
        com.tencent.mm.plugin.sport.a.d.rG(4);
      }
      else if ("contact_info_common_problem".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("KPublisherId", "custom_menu");
        paramString.putExtra("pre_username", this.contact.field_username);
        paramString.putExtra("prePublishId", "custom_menu");
        paramString.putExtra("preUsername", this.contact.field_username);
        paramString.putExtra("preChatName", this.contact.field_username);
        paramString.putExtra("preChatTYPE", ac.aX(this.contact.field_username, this.contact.field_username));
        paramString.putExtra("rawUrl", ScG);
        paramString.putExtra("geta8key_username", this.contact.field_username);
        paramString.putExtra("from_scence", 1);
        com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
        com.tencent.mm.plugin.sport.a.d.rG(5);
      }
      else if ("contact_info_privacy_and_notification".equals(paramString))
      {
        com.tencent.mm.br.c.ai(this.context, "exdevice", ".ui.ExdeviceSettingUI");
      }
      else if ("contact_info_sport_install".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.d.rG(13);
        paramString = this.context;
        this.context.getString(R.l.app_tip);
        this.rYw = com.tencent.mm.ui.base.k.a(paramString, this.context.getString(R.l.settings_plugins_installing), true, null);
        this.rYw.show();
        bh.aZW().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_43f2581f6fd6");
        localObject = new LinkedList();
        ((LinkedList)localObject).add(Integer.valueOf(1));
        paramString = new v(paramString, (List)localObject, "", "");
        bh.aZW().a(paramString, 0);
        com.tencent.mm.plugin.sport.model.k.EC(true);
      }
      else if ("contact_info_sport_uninstall".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.d.rG(14);
        com.tencent.mm.ui.base.k.b(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28821);
            paramAnonymousDialogInterface = com.tencent.mm.an.g.hU(a.a(a.this).field_username);
            ((n)com.tencent.mm.kernel.h.ax(n.class)).a(paramAnonymousDialogInterface, (Activity)a.b(a.this), a.a(a.this));
            a.c(a.this);
            com.tencent.mm.plugin.sport.model.k.EC(false);
            AppMethodBeat.o(28821);
          }
        }, null);
      }
      else if ("contact_info_clear_data".equals(paramString))
      {
        com.tencent.mm.ui.base.k.b(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28820);
            com.tencent.mm.plugin.sport.a.d.rG(25);
            bh.bCz();
            com.tencent.mm.model.c.bzD().aLO("gh_43f2581f6fd6");
            AppMethodBeat.o(28820);
          }
        }, null);
      }
    }
  }
  
  public final boolean dvq()
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
          com.tencent.mm.plugin.messenger.a.g.gaI().B("gh_43f2581f6fd6", str, au.bwE(str));
          if (!Util.isNullOrNil(paramIntent))
          {
            wp localwp = new wp();
            localwp.iak.hgl = str;
            localwp.iak.content = paramIntent;
            localwp.iak.type = ab.IX(str);
            localwp.iak.flags = 0;
            localwp.publish();
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(28826);
    if ((paramp instanceof v))
    {
      bh.aZW().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && ((paramInt2 == -2) || (paramInt2 == -101) || (paramInt2 == -24)) && (!Util.isNullOrNil(paramString))) {
          Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
        }
        if (this.rYw != null) {
          this.rYw.dismiss();
        }
        dvr();
      }
    }
    else
    {
      AppMethodBeat.o(28826);
      return;
    }
    Object localObject = ((v)paramp).iIc();
    Log.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", new Object[] { localObject });
    bh.bCz();
    paramp = com.tencent.mm.model.c.bzA().JE("gh_43f2581f6fd6");
    if ((paramp == null) || (Util.isNullOrNil((String)localObject))) {
      Log.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + (String)localObject + ", contact = " + paramp);
    }
    for (;;)
    {
      paramString = af.bHf().Mn(paramp.field_username);
      if (paramString != null) {
        af.bHf().h(paramString);
      }
      bh.bCz();
      com.tencent.mm.model.c.ban().B(327825, Boolean.TRUE);
      com.tencent.mm.plugin.newtips.a.gtf();
      paramInt1 = com.tencent.mm.plugin.newtips.a.d.Msg;
      com.tencent.mm.plugin.newtips.a.i.h(paramInt1, com.tencent.mm.plugin.newtips.a.d.Msc, "", null);
      Log.i("MicroMsg.NewTips.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), "" });
      break;
      paramString = null;
      if (au.bxa(paramp.field_username))
      {
        String str = Util.nullAsNil(paramp.field_username);
        paramString = com.tencent.mm.an.g.hU(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        af.bHf().Mo(str);
        paramp.Bd(str);
      }
      paramp.setUsername((String)localObject);
      if ((int)paramp.maN == 0)
      {
        bh.bCz();
        com.tencent.mm.model.c.bzA().aC(paramp);
      }
      if ((int)paramp.maN <= 0)
      {
        Log.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
      }
      else
      {
        ab.I(paramp);
        bh.bCz();
        localObject = com.tencent.mm.model.c.bzA().JE(paramp.field_username);
        if (paramString != null)
        {
          af.bHf().g(paramString);
        }
        else
        {
          paramString = com.tencent.mm.an.g.hU(((az)localObject).field_username);
          if ((paramString == null) || (paramString.aAJ()))
          {
            Log.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
            az.a.okP.aZ(((az)localObject).field_username, "");
            com.tencent.mm.modelavatar.d.LA(((az)localObject).field_username);
          }
          else if (((au)localObject).iZI())
          {
            Log.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", new Object[] { Integer.valueOf(((az)localObject).kak) });
            az.a.okP.aZ(((az)localObject).field_username, "");
            com.tencent.mm.modelavatar.d.LA(((az)localObject).field_username);
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