package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class c$6
  implements a.a
{
  c$6(c paramc) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(23462);
    ad localad;
    if (paramBoolean1)
    {
      h.bO(this.pzT.cmc, this.pzT.cmc.getString(2131298531));
      this.pzT.screen.cl("contact_info_time_expired", true);
      localad = this.pzT.contact;
      if ((localad == null) || (bo.isNullOrNil(paramString1)))
      {
        ab.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + paramString1 + ", contact = " + localad);
        this.pzT.pzL = true;
        if (this.pzT.pzR != null)
        {
          paramString1 = new om();
          this.pzT.pzR.fQt = 4;
          paramString1.cFa.cFb = this.pzT.pzR;
          com.tencent.mm.sdk.b.a.ymk.l(paramString1);
        }
        paramString1 = z.afi().rK(this.pzT.contact.field_username);
        paramString1.field_status = 1;
        if ((!bo.isNullOrNil(paramString1.field_extInfo)) || (bo.isNullOrNil(paramString1.field_username)) || (this.pzT.pyd == null) || (!paramString1.field_username.equals(bo.nullAsNil(this.pzT.pyd.field_username)))) {
          break label674;
        }
        z.afi().e(this.pzT.pyd);
        label248:
        paramBoolean1 = this.pzT.cmc.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
        paramBoolean2 = this.pzT.cmc.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
        if (!paramString1.aeg()) {
          break label685;
        }
        paramString1 = new Intent();
        paramString1.putExtra("enterprise_biz_name", this.pzT.contact.field_username);
        paramString1.putExtra("enterprise_biz_display_name", s.nE(this.pzT.contact.field_username));
        paramString1.putExtra("enterprise_from_scene", 7);
        paramString1.addFlags(67108864);
        com.tencent.mm.bq.d.f(this.pzT.cmc, ".ui.conversation.EnterpriseConversationUI", paramString1);
        label363:
        this.pzT.cmc.finish();
        label373:
        this.pzT.aV(3, null);
      }
    }
    else
    {
      AppMethodBeat.o(23462);
      return;
    }
    if (t.nS(localad.field_username))
    {
      String str = bo.nullAsNil(localad.field_username);
      paramString2 = com.tencent.mm.aj.f.rS(str);
      if (paramString2 != null) {
        paramString2.field_username = paramString1;
      }
      z.afi().delete(str);
      localad.jv(str);
    }
    for (;;)
    {
      localad.setUsername(paramString1);
      if ((int)localad.euF == 0)
      {
        aw.aaz();
        com.tencent.mm.model.c.YA().Z(localad);
      }
      if ((int)localad.euF <= 0)
      {
        ab.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
        break;
      }
      t.q(localad);
      aw.aaz();
      paramString1 = com.tencent.mm.model.c.YA().arw(localad.field_username);
      if (paramString2 != null)
      {
        z.afi().d(paramString2);
        break;
      }
      paramString2 = com.tencent.mm.aj.f.rS(paramString1.field_username);
      if ((paramString1.dwz()) && (com.tencent.mm.aj.a.adX())) {}
      for (int i = 1;; i = 0)
      {
        if ((paramString2 != null) && ((!paramString2.aea()) || (i != 0))) {
          break label615;
        }
        ab.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
        ao.a.flI.am(paramString1.field_username, "");
        com.tencent.mm.ah.b.qT(paramString1.field_username);
        break;
      }
      label615:
      if ((!paramString1.dwC()) || (i != 0)) {
        break;
      }
      ab.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramString1.dqR) });
      ao.a.flI.am(paramString1.field_username, "");
      com.tencent.mm.ah.b.qT(paramString1.field_username);
      break;
      label674:
      z.afi().e(paramString1);
      break label248;
      label685:
      paramString1 = new Intent();
      paramString1.putExtra("Chat_User", this.pzT.contact.field_username);
      paramString1.putExtra("key_has_add_contact", true);
      paramString1.putExtra("finish_direct", true);
      if (paramBoolean2) {
        paramString1.addFlags(268435456);
      }
      com.tencent.mm.plugin.profile.b.gmO.d(paramString1, this.pzT.cmc);
      if (paramBoolean1) {
        break label363;
      }
      if (!paramBoolean2) {
        break label373;
      }
      break label363;
      paramString2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.6
 * JD-Core Version:    0.7.0.1
 */