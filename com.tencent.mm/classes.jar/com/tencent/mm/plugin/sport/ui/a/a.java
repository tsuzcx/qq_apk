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
import com.tencent.mm.am.ag;
import com.tencent.mm.api.l;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.al.f, com.tencent.mm.pluginsdk.b.a
{
  private CheckBoxPreference AHH;
  am contact;
  Context context;
  private p mCn;
  private CheckBoxPreference prv;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(28822);
    this.screen = paramf;
    this.contact = paramam;
    paramf.addPreferencesFromResource(2131951657);
    this.AHH = ((CheckBoxPreference)paramf.aVD("contact_info_top_sport"));
    this.prv = ((CheckBoxPreference)paramf.aVD("contact_info_not_disturb"));
    cdo();
    AppMethodBeat.o(28822);
    return true;
  }
  
  public final boolean aaG(String paramString)
  {
    AppMethodBeat.i(28823);
    Object localObject;
    if ("contact_info_record_data".equals(paramString))
    {
      localObject = new Intent(this.context, ExdeviceRankDataSourceUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(28823);
      return false;
      if ("contact_info_top_sport".equals(paramString))
      {
        if (this.AHH.isChecked())
        {
          com.tencent.mm.plugin.sport.a.c.ma(20);
          w.D(this.contact.field_username, true);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.c.ma(21);
          w.E(this.contact.field_username, true);
        }
      }
      else if ("contact_info_not_disturb".equals(paramString))
      {
        if (this.prv.isChecked())
        {
          com.tencent.mm.plugin.sport.a.c.ma(22);
          w.s(this.contact);
        }
        else
        {
          com.tencent.mm.plugin.sport.a.c.ma(23);
          w.t(this.contact);
        }
      }
      else if ("contact_info_go_to_sport".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("finish_direct", true);
        com.tencent.mm.bs.d.f(this.context, ".ui.chatting.ChattingUI", paramString);
        com.tencent.mm.plugin.sport.a.c.ma(19);
      }
      else if ("contact_info_go_to_my_profile".equals(paramString))
      {
        paramString = u.aAm();
        if (bt.isNullOrNil(paramString))
        {
          ad.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
          AppMethodBeat.o(28823);
          return false;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("username", paramString);
        com.tencent.mm.bs.d.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", (Intent)localObject);
        com.tencent.mm.plugin.sport.a.c.ma(3);
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
        com.tencent.mm.plugin.sport.a.c.ma(4);
      }
      else if ("contact_info_common_problem".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("KPublisherId", "custom_menu");
        paramString.putExtra("pre_username", this.contact.field_username);
        paramString.putExtra("prePublishId", "custom_menu");
        paramString.putExtra("preUsername", this.contact.field_username);
        paramString.putExtra("preChatName", this.contact.field_username);
        paramString.putExtra("preChatTYPE", x.aG(this.contact.field_username, this.contact.field_username));
        paramString.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
        paramString.putExtra("geta8key_username", this.contact.field_username);
        paramString.putExtra("from_scence", 1);
        com.tencent.mm.bs.d.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
        com.tencent.mm.plugin.sport.a.c.ma(5);
      }
      else if ("contact_info_privacy_and_notification".equals(paramString))
      {
        com.tencent.mm.bs.d.Q(this.context, "exdevice", ".ui.ExdeviceSettingUI");
      }
      else if ("contact_info_sport_install".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.c.ma(13);
        paramString = this.context;
        this.context.getString(2131755906);
        this.mCn = com.tencent.mm.ui.base.h.b(paramString, this.context.getString(2131763362), true, null);
        this.mCn.show();
        ba.aiU().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_43f2581f6fd6");
        localObject = new LinkedList();
        ((LinkedList)localObject).add(Integer.valueOf(1));
        paramString = new o(paramString, (List)localObject, "", "");
        ba.aiU().a(paramString, 0);
        com.tencent.mm.plugin.sport.model.h.se(true);
      }
      else if ("contact_info_sport_uninstall".equals(paramString))
      {
        com.tencent.mm.plugin.sport.a.c.ma(14);
        com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28821);
            paramAnonymousDialogInterface = com.tencent.mm.am.g.eS(a.this.contact.field_username);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).a(paramAnonymousDialogInterface, (Activity)a.this.context, a.this.contact);
            a.this.cdo();
            com.tencent.mm.plugin.sport.model.h.se(false);
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
            com.tencent.mm.plugin.sport.a.c.ma(25);
            ba.aBQ();
            com.tencent.mm.model.c.azs().aqe("gh_43f2581f6fd6");
            AppMethodBeat.o(28820);
          }
        }, null);
      }
    }
  }
  
  public final boolean cdn()
  {
    return true;
  }
  
  final void cdo()
  {
    AppMethodBeat.i(28825);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aVD("contact_info_header_helper");
    localHelperHeaderPreference.aZ(this.contact.field_username, this.contact.adv(), this.context.getString(2131757875));
    if (b.lM(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cP("contact_info_sport_install", true);
      this.screen.cP("contact_info_sport_uninstall", false);
      this.screen.cP("contact_info_go_to_sport", false);
      this.screen.cP("contact_info_go_to_my_profile", false);
      this.screen.cP("contact_info_invite_friend", false);
      this.screen.cP("contact_info_common_problem", false);
      this.screen.cP("contact_info_record_data", false);
      this.screen.cP("contact_info_privacy_and_notification", false);
      this.screen.cP("contact_info_top_sport", false);
      this.screen.cP("contact_info_not_disturb", false);
      ba.aBQ();
      if (com.tencent.mm.model.c.azv().aTH(this.contact.field_username)) {}
      for (this.AHH.oB = true; this.contact.Pf(); this.AHH.oB = false)
      {
        this.prv.oB = true;
        AppMethodBeat.o(28825);
        return;
      }
      this.prv.oB = false;
      AppMethodBeat.o(28825);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.cP("contact_info_sport_install", false);
    this.screen.cP("contact_info_sport_uninstall", true);
    this.screen.cP("contact_info_go_to_sport", true);
    this.screen.cP("contact_info_go_to_my_profile", true);
    this.screen.cP("contact_info_invite_friend", true);
    this.screen.cP("contact_info_common_problem", true);
    this.screen.cP("contact_info_record_data", true);
    this.screen.cP("contact_info_privacy_and_notification", true);
    this.screen.cP("contact_info_top_sport", true);
    this.screen.cP("contact_info_not_disturb", true);
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
        Object localObject = bt.U(paramIntent.getStringExtra("received_card_name").split(","));
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          com.tencent.mm.plugin.messenger.a.g.dlD().q("gh_43f2581f6fd6", str, w.vF(str));
          if (!bt.isNullOrNil(paramIntent))
          {
            sx localsx = new sx();
            localsx.dHy.dHz = str;
            localsx.dHy.content = paramIntent;
            localsx.dHy.type = w.Ar(str);
            localsx.dHy.flags = 0;
            com.tencent.mm.sdk.b.a.IbL.l(localsx);
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
      ba.aiU().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && ((paramInt2 == -2) || (paramInt2 == -101) || (paramInt2 == -24)) && (!bt.isNullOrNil(paramString))) {
          Toast.makeText(aj.getContext(), paramString, 1).show();
        }
        if (this.mCn != null) {
          this.mCn.dismiss();
        }
        cdo();
      }
    }
    else
    {
      AppMethodBeat.o(28826);
      return;
    }
    Object localObject = ((o)paramn).eZF();
    ad.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", new Object[] { localObject });
    ba.aBQ();
    paramn = com.tencent.mm.model.c.azp().Bf("gh_43f2581f6fd6");
    if ((paramn == null) || (bt.isNullOrNil((String)localObject))) {
      ad.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + (String)localObject + ", contact = " + paramn);
    }
    for (;;)
    {
      paramString = ag.aFZ().DD(paramn.field_username);
      ag.aFZ().g(paramString);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(327825, Boolean.TRUE);
      com.tencent.mm.plugin.newtips.a.dun();
      paramInt1 = com.tencent.mm.plugin.newtips.a.d.wsk;
      com.tencent.mm.plugin.newtips.a.i.g(paramInt1, com.tencent.mm.plugin.newtips.a.d.wsg, "", null);
      ad.i("MicroMsg.NewTips.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), "" });
      break;
      paramString = null;
      if (w.zC(paramn.field_username))
      {
        String str = bt.nullAsNil(paramn.field_username);
        paramString = com.tencent.mm.am.g.eS(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        ag.aFZ().delete(str);
        paramn.sZ(str);
      }
      paramn.setUsername((String)localObject);
      if ((int)paramn.gfj == 0)
      {
        ba.aBQ();
        com.tencent.mm.model.c.azp().ah(paramn);
      }
      if ((int)paramn.gfj <= 0)
      {
        ad.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
      }
      else
      {
        w.u(paramn);
        ba.aBQ();
        localObject = com.tencent.mm.model.c.azp().Bf(paramn.field_username);
        if (paramString != null)
        {
          ag.aFZ().f(paramString);
        }
        else
        {
          paramString = com.tencent.mm.am.g.eS(((aw)localObject).field_username);
          if ((paramString == null) || (paramString.Kh()))
          {
            ad.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
            as.a.hFO.aI(((aw)localObject).field_username, "");
            com.tencent.mm.ak.c.CT(((aw)localObject).field_username);
          }
          else if (((am)localObject).fqk())
          {
            ad.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", new Object[] { Integer.valueOf(((aw)localObject).ePB) });
            as.a.hFO.aI(((aw)localObject).field_username, "");
            com.tencent.mm.ak.c.CT(((aw)localObject).field_username);
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