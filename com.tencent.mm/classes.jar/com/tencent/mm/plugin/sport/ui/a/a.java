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
import com.tencent.mm.an.q;
import com.tencent.mm.ao.af;
import com.tencent.mm.api.m;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.plugin.sport.model.k;
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
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.an.i, com.tencent.mm.pluginsdk.c.a
{
  private static final String LyS;
  private CheckBoxPreference LyT;
  private as contact;
  private Context context;
  private s oTk;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference uoF;
  
  static
  {
    AppMethodBeat.i(276529);
    LyS = "https://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index";
    AppMethodBeat.o(276529);
  }
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void cQY()
  {
    AppMethodBeat.i(28825);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.byG("contact_info_header_helper");
    localHelperHeaderPreference.bf(this.contact.field_username, this.contact.ays(), this.context.getString(R.l.eAg));
    if (com.tencent.mm.contact.d.rk(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.dz("contact_info_sport_install", true);
      this.screen.dz("contact_info_sport_uninstall", false);
      this.screen.dz("contact_info_go_to_sport", false);
      this.screen.dz("contact_info_go_to_my_profile", false);
      this.screen.dz("contact_info_invite_friend", false);
      this.screen.dz("contact_info_common_problem", false);
      this.screen.dz("contact_info_record_data", false);
      this.screen.dz("contact_info_privacy_and_notification", false);
      this.screen.dz("contact_info_top_sport", false);
      this.screen.dz("contact_info_not_disturb", false);
      bh.beI();
      if (com.tencent.mm.model.c.bbR().bwF(this.contact.field_username)) {
        this.LyT.setChecked(true);
      }
      while (this.contact.aeg())
      {
        this.uoF.setChecked(true);
        AppMethodBeat.o(28825);
        return;
        this.LyT.setChecked(false);
      }
      this.uoF.setChecked(false);
      AppMethodBeat.o(28825);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.dz("contact_info_sport_install", false);
    this.screen.dz("contact_info_sport_uninstall", true);
    this.screen.dz("contact_info_go_to_sport", true);
    this.screen.dz("contact_info_go_to_my_profile", true);
    this.screen.dz("contact_info_invite_friend", true);
    this.screen.dz("contact_info_common_problem", true);
    this.screen.dz("contact_info_record_data", true);
    this.screen.dz("contact_info_privacy_and_notification", true);
    this.screen.dz("contact_info_top_sport", true);
    this.screen.dz("contact_info_not_disturb", true);
    AppMethodBeat.o(28825);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(28822);
    this.screen = paramf;
    this.contact = paramas;
    paramf.auC(R.o.eXw);
    this.LyT = ((CheckBoxPreference)paramf.byG("contact_info_top_sport"));
    this.uoF = ((CheckBoxPreference)paramf.byG("contact_info_not_disturb"));
    cQY();
    AppMethodBeat.o(28822);
    return true;
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(28823);
    Object localObject;
    if ("contact_info_record_data".equals(paramString))
    {
      localObject = new Intent(this.context, ExdeviceRankDataSourceUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(28823);
      return false;
      if ("contact_info_top_sport".equals(paramString))
      {
        if (this.LyT.isChecked())
        {
          com.tencent.mm.plugin.sport.a.d.rE(20);
          ab.G(this.contact.field_username, true);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.d.rE(21);
          ab.H(this.contact.field_username, true);
        }
      }
      else if ("contact_info_not_disturb".equals(paramString))
      {
        if (this.uoF.isChecked())
        {
          com.tencent.mm.plugin.sport.a.d.rE(22);
          ab.F(this.contact);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.d.rE(23);
          ab.G(this.contact);
        }
      }
      else if ("contact_info_go_to_sport".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("finish_direct", true);
        com.tencent.mm.by.c.f(this.context, ".ui.chatting.ChattingUI", paramString);
        com.tencent.mm.plugin.sport.a.d.rE(19);
      }
      else if ("contact_info_go_to_my_profile".equals(paramString))
      {
        paramString = z.bcZ();
        if (Util.isNullOrNil(paramString))
        {
          Log.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
          AppMethodBeat.o(28823);
          return false;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("username", paramString);
        com.tencent.mm.by.c.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", (Intent)localObject);
        com.tencent.mm.plugin.sport.a.d.rE(3);
      }
      else if ("contact_info_invite_friend".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Select_Talker_Name", this.contact.field_username);
        paramString.putExtra("Select_block_List", this.contact.field_username);
        paramString.putExtra("Select_Conv_Type", 3);
        paramString.putExtra("Select_Send_Card", true);
        paramString.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.by.c.d(this.context, ".ui.transmit.SelectConversationUI", paramString, 1);
        com.tencent.mm.plugin.sport.a.d.rE(4);
      }
      else if ("contact_info_common_problem".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("KPublisherId", "custom_menu");
        paramString.putExtra("pre_username", this.contact.field_username);
        paramString.putExtra("prePublishId", "custom_menu");
        paramString.putExtra("preUsername", this.contact.field_username);
        paramString.putExtra("preChatName", this.contact.field_username);
        paramString.putExtra("preChatTYPE", ac.aN(this.contact.field_username, this.contact.field_username));
        paramString.putExtra("rawUrl", LyS);
        paramString.putExtra("geta8key_username", this.contact.field_username);
        paramString.putExtra("from_scence", 1);
        com.tencent.mm.by.c.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
        com.tencent.mm.plugin.sport.a.d.rE(5);
      }
      else if ("contact_info_privacy_and_notification".equals(paramString))
      {
        com.tencent.mm.by.c.ad(this.context, "exdevice", ".ui.ExdeviceSettingUI");
      }
      else if ("contact_info_sport_install".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.d.rE(13);
        paramString = this.context;
        this.context.getString(R.l.app_tip);
        this.oTk = com.tencent.mm.ui.base.h.a(paramString, this.context.getString(R.l.settings_plugins_installing), true, null);
        this.oTk.show();
        bh.aGY().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_43f2581f6fd6");
        localObject = new LinkedList();
        ((LinkedList)localObject).add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.t(paramString, (List)localObject, "", "");
        bh.aGY().a(paramString, 0);
        k.zl(true);
      }
      else if ("contact_info_sport_uninstall".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.d.rE(14);
        com.tencent.mm.ui.base.h.c(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28821);
            paramAnonymousDialogInterface = com.tencent.mm.ao.g.gu(a.a(a.this).field_username);
            ((m)com.tencent.mm.kernel.h.ae(m.class)).a(paramAnonymousDialogInterface, (Activity)a.b(a.this), a.a(a.this));
            a.c(a.this);
            k.zl(false);
            AppMethodBeat.o(28821);
          }
        }, null);
      }
      else if ("contact_info_clear_data".equals(paramString))
      {
        com.tencent.mm.ui.base.h.c(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28820);
            com.tencent.mm.plugin.sport.a.d.rE(25);
            bh.beI();
            com.tencent.mm.model.c.bbO().aOO("gh_43f2581f6fd6");
            AppMethodBeat.o(28820);
          }
        }, null);
      }
    }
  }
  
  public final boolean cQX()
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
          com.tencent.mm.plugin.messenger.a.g.eRW().u("gh_43f2581f6fd6", str, ab.Lj(str));
          if (!Util.isNullOrNil(paramIntent))
          {
            uz localuz = new uz();
            localuz.fUn.fcD = str;
            localuz.fUn.content = paramIntent;
            localuz.fUn.type = ab.QZ(str);
            localuz.fUn.flags = 0;
            EventCenter.instance.publish(localuz);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(28826);
    if ((paramq instanceof com.tencent.mm.pluginsdk.model.t))
    {
      bh.aGY().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && ((paramInt2 == -2) || (paramInt2 == -101) || (paramInt2 == -24)) && (!Util.isNullOrNil(paramString))) {
          Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
        }
        if (this.oTk != null) {
          this.oTk.dismiss();
        }
        cQY();
      }
    }
    else
    {
      AppMethodBeat.o(28826);
      return;
    }
    Object localObject = ((com.tencent.mm.pluginsdk.model.t)paramq).hhc();
    Log.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", new Object[] { localObject });
    bh.beI();
    paramq = com.tencent.mm.model.c.bbL().RG("gh_43f2581f6fd6");
    if ((paramq == null) || (Util.isNullOrNil((String)localObject))) {
      Log.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + (String)localObject + ", contact = " + paramq);
    }
    for (;;)
    {
      paramString = af.bjv().Uo(paramq.field_username);
      af.bjv().h(paramString);
      bh.beI();
      com.tencent.mm.model.c.aHp().i(327825, Boolean.TRUE);
      com.tencent.mm.plugin.newtips.a.fiO();
      paramInt1 = com.tencent.mm.plugin.newtips.a.d.Gwh;
      com.tencent.mm.plugin.newtips.a.i.g(paramInt1, com.tencent.mm.plugin.newtips.a.d.Gwd, "", null);
      Log.i("MicroMsg.NewTips.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), "" });
      break;
      paramString = null;
      if (ab.Qk(paramq.field_username))
      {
        String str = Util.nullAsNil(paramq.field_username);
        paramString = com.tencent.mm.ao.g.gu(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        af.bjv().Up(str);
        paramq.Iy(str);
      }
      paramq.setUsername((String)localObject);
      if ((int)paramq.jxt == 0)
      {
        bh.beI();
        com.tencent.mm.model.c.bbL().aw(paramq);
      }
      if ((int)paramq.jxt <= 0)
      {
        Log.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
      }
      else
      {
        ab.H(paramq);
        bh.beI();
        localObject = com.tencent.mm.model.c.bbL().RG(paramq.field_username);
        if (paramString != null)
        {
          af.bjv().g(paramString);
        }
        else
        {
          paramString = com.tencent.mm.ao.g.gu(((ax)localObject).field_username);
          if ((paramString == null) || (paramString.YR()))
          {
            Log.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
            az.a.ltq.aP(((ax)localObject).field_username, "");
            com.tencent.mm.am.d.TA(((ax)localObject).field_username);
          }
          else if (((as)localObject).hyb())
          {
            Log.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", new Object[] { Integer.valueOf(((ax)localObject).hDo) });
            az.a.ltq.aP(((ax)localObject).field_username, "");
            com.tencent.mm.am.d.TA(((ax)localObject).field_username);
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