package com.tencent.mm.plugin.sport.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.api.l;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.al.g, com.tencent.mm.pluginsdk.b.a
{
  com.tencent.mm.storage.af contact;
  Context context;
  private p lAj;
  private CheckBoxPreference okn;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference ycN;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(28823);
    Object localObject;
    if ("contact_info_record_data".equals(paramString))
    {
      localObject = new Intent(this.context, ExdeviceRankDataSourceUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(28823);
      return false;
      if ("contact_info_top_sport".equals(paramString))
      {
        if (this.ycN.isChecked())
        {
          com.tencent.mm.plugin.sport.a.c.lI(20);
          w.C(this.contact.field_username, true);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.c.lI(21);
          w.D(this.contact.field_username, true);
        }
      }
      else if ("contact_info_not_disturb".equals(paramString))
      {
        if (this.okn.isChecked())
        {
          com.tencent.mm.plugin.sport.a.c.lI(22);
          w.s(this.contact);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.c.lI(23);
          w.t(this.contact);
        }
      }
      else if ("contact_info_go_to_sport".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("finish_direct", true);
        com.tencent.mm.bs.d.e(this.context, ".ui.chatting.ChattingUI", paramString);
        com.tencent.mm.plugin.sport.a.c.lI(19);
      }
      else if ("contact_info_go_to_my_profile".equals(paramString))
      {
        paramString = u.aqG();
        if (bt.isNullOrNil(paramString))
        {
          ad.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
          AppMethodBeat.o(28823);
          return false;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("username", paramString);
        com.tencent.mm.bs.d.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", (Intent)localObject);
        com.tencent.mm.plugin.sport.a.c.lI(3);
      }
      else if ("contact_info_invite_friend".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Select_Talker_Name", this.contact.field_username);
        paramString.putExtra("Select_block_List", this.contact.field_username);
        paramString.putExtra("Select_Conv_Type", 3);
        paramString.putExtra("Select_Send_Card", true);
        paramString.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.bs.d.c(this.context, ".ui.transmit.SelectConversationUI", paramString, 1);
        com.tencent.mm.plugin.sport.a.c.lI(4);
      }
      else if ("contact_info_common_problem".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("KPublisherId", "custom_menu");
        paramString.putExtra("pre_username", this.contact.field_username);
        paramString.putExtra("prePublishId", "custom_menu");
        paramString.putExtra("preUsername", this.contact.field_username);
        paramString.putExtra("preChatName", this.contact.field_username);
        paramString.putExtra("preChatTYPE", x.aw(this.contact.field_username, this.contact.field_username));
        paramString.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
        paramString.putExtra("geta8key_username", this.contact.field_username);
        paramString.putExtra("from_scence", 1);
        com.tencent.mm.bs.d.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
        com.tencent.mm.plugin.sport.a.c.lI(5);
      }
      else if ("contact_info_privacy_and_notification".equals(paramString))
      {
        com.tencent.mm.bs.d.O(this.context, "exdevice", ".ui.ExdeviceSettingUI");
      }
      else if ("contact_info_sport_install".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.c.lI(13);
        paramString = this.context;
        this.context.getString(2131755906);
        this.lAj = com.tencent.mm.ui.base.h.b(paramString, this.context.getString(2131763362), true, null);
        this.lAj.show();
        az.aeS().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_43f2581f6fd6");
        localObject = new LinkedList();
        ((LinkedList)localObject).add(Integer.valueOf(1));
        paramString = new o(paramString, (List)localObject, "", "");
        az.aeS().a(paramString, 0);
        com.tencent.mm.plugin.sport.model.h.qA(true);
      }
      else if ("contact_info_sport_uninstall".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.c.lI(14);
        com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28821);
            paramAnonymousDialogInterface = com.tencent.mm.am.f.ei(a.this.contact.field_username);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).a(paramAnonymousDialogInterface, (Activity)a.this.context, a.this.contact);
            a.this.bRv();
            com.tencent.mm.plugin.sport.model.h.qA(false);
            AppMethodBeat.o(28821);
          }
        }, null);
      }
      else if ("contact_info_clear_data".equals(paramString))
      {
        com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28820);
            com.tencent.mm.plugin.sport.a.c.lI(25);
            az.arV();
            com.tencent.mm.model.c.apO().agw("gh_43f2581f6fd6");
            AppMethodBeat.o(28820);
          }
        }, null);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, com.tencent.mm.storage.af paramaf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(28822);
    this.screen = paramf;
    this.contact = paramaf;
    paramf.addPreferencesFromResource(2131951657);
    this.ycN = ((CheckBoxPreference)paramf.aKk("contact_info_top_sport"));
    this.okn = ((CheckBoxPreference)paramf.aKk("contact_info_not_disturb"));
    bRv();
    AppMethodBeat.o(28822);
    return true;
  }
  
  public final boolean bRu()
  {
    return true;
  }
  
  final void bRv()
  {
    AppMethodBeat.i(28825);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aKk("contact_info_header_helper");
    localHelperHeaderPreference.aO(this.contact.field_username, this.contact.ZX(), this.context.getString(2131757875));
    if (b.ls(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cE("contact_info_sport_install", true);
      this.screen.cE("contact_info_sport_uninstall", false);
      this.screen.cE("contact_info_go_to_sport", false);
      this.screen.cE("contact_info_go_to_my_profile", false);
      this.screen.cE("contact_info_invite_friend", false);
      this.screen.cE("contact_info_common_problem", false);
      this.screen.cE("contact_info_record_data", false);
      this.screen.cE("contact_info_privacy_and_notification", false);
      this.screen.cE("contact_info_top_sport", false);
      this.screen.cE("contact_info_not_disturb", false);
      az.arV();
      if (com.tencent.mm.model.c.apR().aIv(this.contact.field_username)) {}
      for (this.ycN.lG = true; this.contact.Ny(); this.ycN.lG = false)
      {
        this.okn.lG = true;
        AppMethodBeat.o(28825);
        return;
      }
      this.okn.lG = false;
      AppMethodBeat.o(28825);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.cE("contact_info_sport_install", false);
    this.screen.cE("contact_info_sport_uninstall", true);
    this.screen.cE("contact_info_go_to_sport", true);
    this.screen.cE("contact_info_go_to_my_profile", true);
    this.screen.cE("contact_info_invite_friend", true);
    this.screen.cE("contact_info_common_problem", true);
    this.screen.cE("contact_info_record_data", true);
    this.screen.cE("contact_info_privacy_and_notification", true);
    this.screen.cE("contact_info_top_sport", true);
    this.screen.cE("contact_info_not_disturb", true);
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
        Object localObject = bt.S(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          j.cOB().q("gh_43f2581f6fd6", str, w.pF(str));
          if (!bt.isNullOrNil(paramIntent))
          {
            sb localsb = new sb();
            localsb.dxJ.dxK = str;
            localsb.dxJ.content = paramIntent;
            localsb.dxJ.type = w.tq(str);
            localsb.dxJ.flags = 0;
            com.tencent.mm.sdk.b.a.ESL.l(localsb);
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
      az.aeS().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && ((paramInt2 == -2) || (paramInt2 == -101) || (paramInt2 == -24)) && (!bt.isNullOrNil(paramString))) {
          Toast.makeText(aj.getContext(), paramString, 1).show();
        }
        if (this.lAj != null) {
          this.lAj.dismiss();
        }
        bRv();
      }
    }
    else
    {
      AppMethodBeat.o(28826);
      return;
    }
    Object localObject = ((o)paramn).evr();
    ad.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", new Object[] { localObject });
    az.arV();
    paramn = com.tencent.mm.model.c.apM().aHY("gh_43f2581f6fd6");
    if ((paramn == null) || (bt.isNullOrNil((String)localObject))) {
      ad.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + (String)localObject + ", contact = " + paramn);
    }
    for (;;)
    {
      paramString = com.tencent.mm.am.af.awe().wy(paramn.field_username);
      com.tencent.mm.am.af.awe().g(paramString);
      az.arV();
      com.tencent.mm.model.c.afk().set(327825, Boolean.TRUE);
      com.tencent.mm.plugin.newtips.a.cWs();
      paramInt1 = com.tencent.mm.plugin.newtips.a.d.udT;
      i.e(paramInt1, com.tencent.mm.plugin.newtips.a.d.udP, "", null);
      ad.i("MicroMsg.NewTips.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), "" });
      break;
      paramString = null;
      if (w.sC(paramn.field_username))
      {
        String str = bt.nullAsNil(paramn.field_username);
        paramString = com.tencent.mm.am.f.ei(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        com.tencent.mm.am.af.awe().delete(str);
        paramn.nj(str);
      }
      paramn.setUsername((String)localObject);
      if ((int)paramn.fId == 0)
      {
        az.arV();
        com.tencent.mm.model.c.apM().ag(paramn);
      }
      if ((int)paramn.fId <= 0)
      {
        ad.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
      }
      else
      {
        w.u(paramn);
        az.arV();
        localObject = com.tencent.mm.model.c.apM().aHY(paramn.field_username);
        if (paramString != null)
        {
          com.tencent.mm.am.af.awe().f(paramString);
        }
        else
        {
          paramString = com.tencent.mm.am.f.ei(((au)localObject).field_username);
          if ((paramString == null) || (paramString.IY()))
          {
            ad.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
            ar.a.gMW.aB(((au)localObject).field_username, "");
            com.tencent.mm.ak.c.vO(((au)localObject).field_username);
          }
          else if (((com.tencent.mm.storage.af)localObject).eKF())
          {
            ad.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", new Object[] { Integer.valueOf(((au)localObject).evG) });
            ar.a.gMW.aB(((au)localObject).field_username, "");
            com.tencent.mm.ak.c.vO(((au)localObject).field_username);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.a.a
 * JD-Core Version:    0.7.0.1
 */