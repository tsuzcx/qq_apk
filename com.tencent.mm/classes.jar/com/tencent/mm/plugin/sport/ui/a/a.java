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
import com.tencent.mm.al.af;
import com.tencent.mm.api.l;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.c.av;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.ak.g, com.tencent.mm.pluginsdk.b.a
{
  com.tencent.mm.storage.ai contact;
  Context context;
  private p mcf;
  private CheckBoxPreference oNN;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference zpN;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(28823);
    Object localObject;
    if ("contact_info_record_data".equals(paramString))
    {
      localObject = new Intent(this.context, ExdeviceRankDataSourceUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(28823);
      return false;
      if ("contact_info_top_sport".equals(paramString))
      {
        if (this.zpN.isChecked())
        {
          com.tencent.mm.plugin.sport.a.c.lA(20);
          w.D(this.contact.field_username, true);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.c.lA(21);
          w.E(this.contact.field_username, true);
        }
      }
      else if ("contact_info_not_disturb".equals(paramString))
      {
        if (this.oNN.isChecked())
        {
          com.tencent.mm.plugin.sport.a.c.lA(22);
          w.s(this.contact);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.c.lA(23);
          w.t(this.contact);
        }
      }
      else if ("contact_info_go_to_sport".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("finish_direct", true);
        com.tencent.mm.br.d.e(this.context, ".ui.chatting.ChattingUI", paramString);
        com.tencent.mm.plugin.sport.a.c.lA(19);
      }
      else if ("contact_info_go_to_my_profile".equals(paramString))
      {
        paramString = u.axw();
        if (bs.isNullOrNil(paramString))
        {
          ac.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
          AppMethodBeat.o(28823);
          return false;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("username", paramString);
        com.tencent.mm.br.d.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", (Intent)localObject);
        com.tencent.mm.plugin.sport.a.c.lA(3);
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
        com.tencent.mm.plugin.sport.a.c.lA(4);
      }
      else if ("contact_info_common_problem".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("KPublisherId", "custom_menu");
        paramString.putExtra("pre_username", this.contact.field_username);
        paramString.putExtra("prePublishId", "custom_menu");
        paramString.putExtra("preUsername", this.contact.field_username);
        paramString.putExtra("preChatName", this.contact.field_username);
        paramString.putExtra("preChatTYPE", x.aE(this.contact.field_username, this.contact.field_username));
        paramString.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
        paramString.putExtra("geta8key_username", this.contact.field_username);
        paramString.putExtra("from_scence", 1);
        com.tencent.mm.br.d.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
        com.tencent.mm.plugin.sport.a.c.lA(5);
      }
      else if ("contact_info_privacy_and_notification".equals(paramString))
      {
        com.tencent.mm.br.d.N(this.context, "exdevice", ".ui.ExdeviceSettingUI");
      }
      else if ("contact_info_sport_install".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.c.lA(13);
        paramString = this.context;
        this.context.getString(2131755906);
        this.mcf = com.tencent.mm.ui.base.h.b(paramString, this.context.getString(2131763362), true, null);
        this.mcf.show();
        az.agi().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_43f2581f6fd6");
        localObject = new LinkedList();
        ((LinkedList)localObject).add(Integer.valueOf(1));
        paramString = new o(paramString, (List)localObject, "", "");
        az.agi().a(paramString, 0);
        com.tencent.mm.plugin.sport.model.h.ry(true);
      }
      else if ("contact_info_sport_uninstall".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.c.lA(14);
        com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28821);
            paramAnonymousDialogInterface = com.tencent.mm.al.f.dX(a.this.contact.field_username);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).a(paramAnonymousDialogInterface, (Activity)a.this.context, a.this.contact);
            a.this.bYK();
            com.tencent.mm.plugin.sport.model.h.ry(false);
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
            com.tencent.mm.plugin.sport.a.c.lA(25);
            az.ayM();
            com.tencent.mm.model.c.awD().alq("gh_43f2581f6fd6");
            AppMethodBeat.o(28820);
          }
        }, null);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, com.tencent.mm.storage.ai paramai, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(28822);
    this.screen = paramf;
    this.contact = paramai;
    paramf.addPreferencesFromResource(2131951657);
    this.zpN = ((CheckBoxPreference)paramf.aPN("contact_info_top_sport"));
    this.oNN = ((CheckBoxPreference)paramf.aPN("contact_info_not_disturb"));
    bYK();
    AppMethodBeat.o(28822);
    return true;
  }
  
  public final boolean bYJ()
  {
    return true;
  }
  
  final void bYK()
  {
    AppMethodBeat.i(28825);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aPN("contact_info_header_helper");
    localHelperHeaderPreference.aR(this.contact.field_username, this.contact.aaS(), this.context.getString(2131757875));
    if (b.ln(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cK("contact_info_sport_install", true);
      this.screen.cK("contact_info_sport_uninstall", false);
      this.screen.cK("contact_info_go_to_sport", false);
      this.screen.cK("contact_info_go_to_my_profile", false);
      this.screen.cK("contact_info_invite_friend", false);
      this.screen.cK("contact_info_common_problem", false);
      this.screen.cK("contact_info_record_data", false);
      this.screen.cK("contact_info_privacy_and_notification", false);
      this.screen.cK("contact_info_top_sport", false);
      this.screen.cK("contact_info_not_disturb", false);
      az.ayM();
      if (com.tencent.mm.model.c.awG().aNQ(this.contact.field_username)) {}
      for (this.zpN.mF = true; this.contact.Nw(); this.zpN.mF = false)
      {
        this.oNN.mF = true;
        AppMethodBeat.o(28825);
        return;
      }
      this.oNN.mF = false;
      AppMethodBeat.o(28825);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.cK("contact_info_sport_install", false);
    this.screen.cK("contact_info_sport_uninstall", true);
    this.screen.cK("contact_info_go_to_sport", true);
    this.screen.cK("contact_info_go_to_my_profile", true);
    this.screen.cK("contact_info_invite_friend", true);
    this.screen.cK("contact_info_common_problem", true);
    this.screen.cK("contact_info_record_data", true);
    this.screen.cK("contact_info_privacy_and_notification", true);
    this.screen.cK("contact_info_top_sport", true);
    this.screen.cK("contact_info_not_disturb", true);
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
        Object localObject = bs.S(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          j.dck().q("gh_43f2581f6fd6", str, w.sQ(str));
          if (!bs.isNullOrNil(paramIntent))
          {
            sk localsk = new sk();
            localsk.dvv.dvw = str;
            localsk.dvv.content = paramIntent;
            localsk.dvv.type = w.xt(str);
            localsk.dvv.flags = 0;
            com.tencent.mm.sdk.b.a.GpY.l(localsk);
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
      az.agi().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && ((paramInt2 == -2) || (paramInt2 == -101) || (paramInt2 == -24)) && (!bs.isNullOrNil(paramString))) {
          Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), paramString, 1).show();
        }
        if (this.mcf != null) {
          this.mcf.dismiss();
        }
        bYK();
      }
    }
    else
    {
      AppMethodBeat.o(28826);
      return;
    }
    Object localObject = ((o)paramn).eKL();
    ac.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", new Object[] { localObject });
    az.ayM();
    paramn = com.tencent.mm.model.c.awB().aNt("gh_43f2581f6fd6");
    if ((paramn == null) || (bs.isNullOrNil((String)localObject))) {
      ac.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + (String)localObject + ", contact = " + paramn);
    }
    for (;;)
    {
      paramString = af.aCW().AE(paramn.field_username);
      af.aCW().g(paramString);
      az.ayM();
      com.tencent.mm.model.c.agA().set(327825, Boolean.TRUE);
      com.tencent.mm.plugin.newtips.a.dkb();
      paramInt1 = com.tencent.mm.plugin.newtips.a.d.vmS;
      i.g(paramInt1, com.tencent.mm.plugin.newtips.a.d.vmO, "", null);
      ac.i("MicroMsg.NewTips.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), "" });
      break;
      paramString = null;
      if (w.wF(paramn.field_username))
      {
        String str = bs.nullAsNil(paramn.field_username);
        paramString = com.tencent.mm.al.f.dX(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        af.aCW().delete(str);
        paramn.qp(str);
      }
      paramn.setUsername((String)localObject);
      if ((int)paramn.fLJ == 0)
      {
        az.ayM();
        com.tencent.mm.model.c.awB().ah(paramn);
      }
      if ((int)paramn.fLJ <= 0)
      {
        ac.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
      }
      else
      {
        w.u(paramn);
        az.ayM();
        localObject = com.tencent.mm.model.c.awB().aNt(paramn.field_username);
        if (paramString != null)
        {
          af.aCW().f(paramString);
        }
        else
        {
          paramString = com.tencent.mm.al.f.dX(((av)localObject).field_username);
          if ((paramString == null) || (paramString.IH()))
          {
            ac.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
            ar.a.hnw.aJ(((av)localObject).field_username, "");
            com.tencent.mm.aj.c.zU(((av)localObject).field_username);
          }
          else if (((com.tencent.mm.storage.ai)localObject).fah())
          {
            ac.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", new Object[] { Integer.valueOf(((av)localObject).eyc) });
            ar.a.hnw.aJ(((av)localObject).field_username, "");
            com.tencent.mm.aj.c.zU(((av)localObject).field_username);
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