package com.tencent.mm.plugin.sport.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.l;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.ak.f, com.tencent.mm.pluginsdk.b.a
{
  private CheckBoxPreference AZk;
  an contact;
  Context context;
  private p mHs;
  private CheckBoxPreference pyb;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(28822);
    this.screen = paramf;
    this.contact = paraman;
    paramf.addPreferencesFromResource(2131951657);
    this.AZk = ((CheckBoxPreference)paramf.aXe("contact_info_top_sport"));
    this.pyb = ((CheckBoxPreference)paramf.aXe("contact_info_not_disturb"));
    ceD();
    AppMethodBeat.o(28822);
    return true;
  }
  
  public final boolean abx(String paramString)
  {
    AppMethodBeat.i(28823);
    Object localObject;
    if ("contact_info_record_data".equals(paramString))
    {
      localObject = new Intent(this.context, ExdeviceRankDataSourceUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(28823);
      return false;
      if ("contact_info_top_sport".equals(paramString))
      {
        if (this.AZk.isChecked())
        {
          com.tencent.mm.plugin.sport.a.c.md(20);
          x.D(this.contact.field_username, true);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.c.md(21);
          x.E(this.contact.field_username, true);
        }
      }
      else if ("contact_info_not_disturb".equals(paramString))
      {
        if (this.pyb.isChecked())
        {
          com.tencent.mm.plugin.sport.a.c.md(22);
          x.z(this.contact);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.c.md(23);
          x.A(this.contact);
        }
      }
      else if ("contact_info_go_to_sport".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("finish_direct", true);
        com.tencent.mm.br.d.f(this.context, ".ui.chatting.ChattingUI", paramString);
        com.tencent.mm.plugin.sport.a.c.md(19);
      }
      else if ("contact_info_go_to_my_profile".equals(paramString))
      {
        paramString = v.aAC();
        if (bu.isNullOrNil(paramString))
        {
          ae.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
          AppMethodBeat.o(28823);
          return false;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("username", paramString);
        com.tencent.mm.br.d.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", (Intent)localObject);
        com.tencent.mm.plugin.sport.a.c.md(3);
      }
      else if ("contact_info_invite_friend".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Select_Talker_Name", this.contact.field_username);
        paramString.putExtra("Select_block_List", this.contact.field_username);
        paramString.putExtra("Select_Conv_Type", 3);
        paramString.putExtra("Select_Send_Card", true);
        paramString.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.br.d.c(this.context, ".ui.transmit.SelectConversationUI", paramString, 1);
        com.tencent.mm.plugin.sport.a.c.md(4);
      }
      else if ("contact_info_common_problem".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("KPublisherId", "custom_menu");
        paramString.putExtra("pre_username", this.contact.field_username);
        paramString.putExtra("prePublishId", "custom_menu");
        paramString.putExtra("preUsername", this.contact.field_username);
        paramString.putExtra("preChatName", this.contact.field_username);
        paramString.putExtra("preChatTYPE", y.aH(this.contact.field_username, this.contact.field_username));
        paramString.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
        paramString.putExtra("geta8key_username", this.contact.field_username);
        paramString.putExtra("from_scence", 1);
        com.tencent.mm.br.d.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
        com.tencent.mm.plugin.sport.a.c.md(5);
      }
      else if ("contact_info_privacy_and_notification".equals(paramString))
      {
        com.tencent.mm.br.d.Q(this.context, "exdevice", ".ui.ExdeviceSettingUI");
      }
      else if ("contact_info_sport_install".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.c.md(13);
        paramString = this.context;
        this.context.getString(2131755906);
        this.mHs = com.tencent.mm.ui.base.h.b(paramString, this.context.getString(2131763362), true, null);
        this.mHs.show();
        bc.ajj().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_43f2581f6fd6");
        localObject = new LinkedList();
        ((LinkedList)localObject).add(Integer.valueOf(1));
        paramString = new o(paramString, (List)localObject, "", "");
        bc.ajj().a(paramString, 0);
        com.tencent.mm.plugin.sport.model.h.sl(true);
      }
      else if ("contact_info_sport_uninstall".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.c.md(14);
        com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28821);
            paramAnonymousDialogInterface = com.tencent.mm.al.g.eX(a.this.contact.field_username);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).a(paramAnonymousDialogInterface, (Activity)a.this.context, a.this.contact);
            a.this.ceD();
            com.tencent.mm.plugin.sport.model.h.sl(false);
            AppMethodBeat.o(28821);
          }
        }, null);
      }
      else if ("contact_info_clear_data".equals(paramString))
      {
        com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28820);
            com.tencent.mm.plugin.sport.a.c.md(25);
            bc.aCg();
            com.tencent.mm.model.c.azI().arj("gh_43f2581f6fd6");
            AppMethodBeat.o(28820);
          }
        }, null);
      }
    }
  }
  
  public final boolean ceC()
  {
    return true;
  }
  
  final void ceD()
  {
    AppMethodBeat.i(28825);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aXe("contact_info_header_helper");
    localHelperHeaderPreference.ba(this.contact.field_username, this.contact.adG(), this.context.getString(2131757875));
    if (com.tencent.mm.contact.c.lO(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cT("contact_info_sport_install", true);
      this.screen.cT("contact_info_sport_uninstall", false);
      this.screen.cT("contact_info_go_to_sport", false);
      this.screen.cT("contact_info_go_to_my_profile", false);
      this.screen.cT("contact_info_invite_friend", false);
      this.screen.cT("contact_info_common_problem", false);
      this.screen.cT("contact_info_record_data", false);
      this.screen.cT("contact_info_privacy_and_notification", false);
      this.screen.cT("contact_info_top_sport", false);
      this.screen.cT("contact_info_not_disturb", false);
      bc.aCg();
      if (com.tencent.mm.model.c.azL().aVi(this.contact.field_username)) {
        this.AZk.setChecked(true);
      }
      while (this.contact.Pd())
      {
        this.pyb.setChecked(true);
        AppMethodBeat.o(28825);
        return;
        this.AZk.setChecked(false);
      }
      this.pyb.setChecked(false);
      AppMethodBeat.o(28825);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.cT("contact_info_sport_install", false);
    this.screen.cT("contact_info_sport_uninstall", true);
    this.screen.cT("contact_info_go_to_sport", true);
    this.screen.cT("contact_info_go_to_my_profile", true);
    this.screen.cT("contact_info_invite_friend", true);
    this.screen.cT("contact_info_common_problem", true);
    this.screen.cT("contact_info_record_data", true);
    this.screen.cT("contact_info_privacy_and_notification", true);
    this.screen.cT("contact_info_top_sport", true);
    this.screen.cT("contact_info_not_disturb", true);
    AppMethodBeat.o(28825);
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
        Object localObject = bu.U(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          com.tencent.mm.plugin.messenger.a.g.doC().q("gh_43f2581f6fd6", str, x.wb(str));
          if (!bu.isNullOrNil(paramIntent))
          {
            sy localsy = new sy();
            localsy.dID.cUB = str;
            localsy.dID.content = paramIntent;
            localsy.dID.type = x.Bb(str);
            localsy.dID.flags = 0;
            com.tencent.mm.sdk.b.a.IvT.l(localsy);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28826);
    if ((paramn instanceof o))
    {
      bc.ajj().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && ((paramInt2 == -2) || (paramInt2 == -101) || (paramInt2 == -24)) && (!bu.isNullOrNil(paramString))) {
          Toast.makeText(ak.getContext(), paramString, 1).show();
        }
        if (this.mHs != null) {
          this.mHs.dismiss();
        }
        ceD();
      }
    }
    else
    {
      AppMethodBeat.o(28826);
      return;
    }
    Object localObject = ((o)paramn).fdt();
    ae.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", new Object[] { localObject });
    bc.aCg();
    paramn = com.tencent.mm.model.c.azF().BH("gh_43f2581f6fd6");
    if ((paramn == null) || (bu.isNullOrNil((String)localObject))) {
      ae.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + (String)localObject + ", contact = " + paramn);
    }
    for (;;)
    {
      paramString = ag.aGp().Ef(paramn.field_username);
      ag.aGp().g(paramString);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(327825, Boolean.TRUE);
      com.tencent.mm.plugin.newtips.a.dxD();
      paramInt1 = com.tencent.mm.plugin.newtips.a.d.wHT;
      com.tencent.mm.plugin.newtips.a.i.g(paramInt1, com.tencent.mm.plugin.newtips.a.d.wHP, "", null);
      ae.i("MicroMsg.NewTips.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), "" });
      break;
      paramString = null;
      if (x.Am(paramn.field_username))
      {
        String str = bu.nullAsNil(paramn.field_username);
        paramString = com.tencent.mm.al.g.eX(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        ag.aGp().delete(str);
        paramn.tu(str);
      }
      paramn.setUsername((String)localObject);
      if ((int)paramn.ght == 0)
      {
        bc.aCg();
        com.tencent.mm.model.c.azF().ao(paramn);
      }
      if ((int)paramn.ght <= 0)
      {
        ae.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
      }
      else
      {
        x.B(paramn);
        bc.aCg();
        localObject = com.tencent.mm.model.c.azF().BH(paramn.field_username);
        if (paramString != null)
        {
          ag.aGp().f(paramString);
        }
        else
        {
          paramString = com.tencent.mm.al.g.eX(((aw)localObject).field_username);
          if ((paramString == null) || (paramString.Kp()))
          {
            ae.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
            au.a.hIG.aJ(((aw)localObject).field_username, "");
            com.tencent.mm.aj.c.Dv(((aw)localObject).field_username);
          }
          else if (((an)localObject).fuk())
          {
            ae.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", new Object[] { Integer.valueOf(((aw)localObject).eRm) });
            au.a.hIG.aJ(((aw)localObject).field_username, "");
            com.tencent.mm.aj.c.Dv(((aw)localObject).field_username);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.a.a
 * JD-Core Version:    0.7.0.1
 */