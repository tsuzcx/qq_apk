package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;

final class b$2
  implements a.a
{
  b$2(b paramb) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(153577);
    ad localad;
    if (paramBoolean1)
    {
      h.bO(this.pDl.pDe, this.pDl.pDe.getString(2131298548));
      this.pDl.screen.cl("contact_info_time_expired", true);
      localad = this.pDl.contact;
      if ((localad != null) && (!bo.isNullOrNil(paramString1))) {
        break label378;
      }
      ab.e("MicroMsg.ContactWidgetNewBizInfo", "respUsername == " + paramString1 + ", contact = " + localad);
      if (this.pDl.pzR != null)
      {
        paramString1 = new om();
        this.pDl.pzR.fQt = 4;
        paramString1.cFa.cFb = this.pDl.pzR;
        com.tencent.mm.sdk.b.a.ymk.l(paramString1);
      }
      paramString1 = z.afi().rK(this.pDl.contact.field_username);
      paramString1.field_status = 1;
      if ((!bo.isNullOrNil(paramString1.field_extInfo)) || (bo.isNullOrNil(paramString1.field_username)) || (this.pDl.pyd == null) || (!paramString1.field_username.equals(bo.nullAsNil(this.pDl.pyd.field_username)))) {
        break label666;
      }
      z.afi().e(this.pDl.pyd);
      label239:
      paramBoolean1 = this.pDl.pDe.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
      paramBoolean2 = this.pDl.pDe.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
      if (!paramString1.aeg()) {
        break label677;
      }
      paramString1 = new Intent();
      paramString1.putExtra("enterprise_biz_name", this.pDl.contact.field_username);
      paramString1.putExtra("enterprise_biz_display_name", com.tencent.mm.model.s.nE(this.pDl.contact.field_username));
      paramString1.putExtra("enterprise_from_scene", 7);
      paramString1.addFlags(67108864);
      com.tencent.mm.bq.d.f(this.pDl.pDe, ".ui.conversation.EnterpriseConversationUI", paramString1);
    }
    label607:
    for (;;)
    {
      label354:
      this.pDl.pDe.finish();
      label378:
      do
      {
        this.pDl.BK(3);
        AppMethodBeat.o(153577);
        return;
        paramString2 = null;
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
        localad.setUsername(paramString1);
        if ((int)localad.euF == 0)
        {
          aw.aaz();
          c.YA().Z(localad);
        }
        if ((int)localad.euF <= 0)
        {
          ab.e("MicroMsg.ContactWidgetNewBizInfo", "addContact : insert contact failed");
          break;
        }
        t.q(localad);
        aw.aaz();
        paramString1 = c.YA().arw(localad.field_username);
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
            break label607;
          }
          ab.d("MicroMsg.ContactWidgetNewBizInfo", "shouldUpdate");
          ao.a.flI.am(paramString1.field_username, "");
          com.tencent.mm.ah.b.qT(paramString1.field_username);
          break;
        }
        if ((!paramString1.dwC()) || (i != 0)) {
          break;
        }
        ab.d("MicroMsg.ContactWidgetNewBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramString1.dqR) });
        ao.a.flI.am(paramString1.field_username, "");
        com.tencent.mm.ah.b.qT(paramString1.field_username);
        break;
        z.afi().e(paramString1);
        break label239;
        paramString1 = new Intent();
        paramString1.putExtra("Chat_User", this.pDl.contact.field_username);
        paramString1.putExtra("key_has_add_contact", true);
        paramString1.putExtra("finish_direct", true);
        if (paramBoolean2) {
          paramString1.addFlags(268435456);
        }
        com.tencent.mm.storage.s.aqU(this.pDl.contact.field_username);
        com.tencent.mm.plugin.profile.b.gmO.d(paramString1, this.pDl.pDe);
        if (paramBoolean1) {
          break label354;
        }
      } while (!paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.2
 * JD-Core Version:    0.7.0.1
 */