package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;

final class ContactWidgetNewBizInfo$10
  implements a.a
{
  ContactWidgetNewBizInfo$10(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(231947);
    as localas;
    if (paramBoolean1)
    {
      h.cD(ContactWidgetNewBizInfo.b(this.Bjh), ContactWidgetNewBizInfo.b(this.Bjh).getString(2131757835));
      ContactWidgetNewBizInfo.c(this.Bjh).jdMethod_do("contact_info_time_expired", true);
      localas = ContactWidgetNewBizInfo.e(this.Bjh);
      if ((localas != null) && (!Util.isNullOrNil(paramString1))) {
        break label379;
      }
      Log.e("MicroMsg.ContactWidgetNewBizInfo", "respUsername == " + paramString1 + ", contact = " + localas);
      if (ContactWidgetNewBizInfo.r(this.Bjh) != null)
      {
        paramString1 = new rr();
        ContactWidgetNewBizInfo.r(this.Bjh).jkU = 4;
        paramString1.dYk.dYl = ContactWidgetNewBizInfo.r(this.Bjh);
        EventCenter.instance.publish(paramString1);
      }
      paramString1 = ag.bah().MT(ContactWidgetNewBizInfo.e(this.Bjh).field_username);
      paramString1.field_status = 1;
      if ((!Util.isNullOrNil(paramString1.field_extInfo)) || (Util.isNullOrNil(paramString1.field_username)) || (ContactWidgetNewBizInfo.s(this.Bjh) == null) || (!paramString1.field_username.equals(Util.nullAsNil(ContactWidgetNewBizInfo.s(this.Bjh).field_username)))) {
        break label667;
      }
      ag.bah().h(ContactWidgetNewBizInfo.s(this.Bjh));
      label240:
      paramBoolean1 = ContactWidgetNewBizInfo.b(this.Bjh).getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
      paramBoolean2 = ContactWidgetNewBizInfo.b(this.Bjh).getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
      if (!paramString1.UF()) {
        break label678;
      }
      paramString1 = new Intent();
      paramString1.putExtra("enterprise_biz_name", ContactWidgetNewBizInfo.e(this.Bjh).field_username);
      paramString1.putExtra("enterprise_biz_display_name", aa.getDisplayName(ContactWidgetNewBizInfo.e(this.Bjh).field_username));
      paramString1.putExtra("enterprise_from_scene", 7);
      paramString1.addFlags(67108864);
      com.tencent.mm.br.c.f(ContactWidgetNewBizInfo.b(this.Bjh), ".ui.conversation.EnterpriseConversationUI", paramString1);
    }
    label608:
    for (;;)
    {
      label355:
      ContactWidgetNewBizInfo.b(this.Bjh).finish();
      label379:
      do
      {
        ContactWidgetNewBizInfo.a(this.Bjh, 3);
        AppMethodBeat.o(231947);
        return;
        paramString2 = null;
        if (com.tencent.mm.model.ab.IR(localas.field_username))
        {
          String str = Util.nullAsNil(localas.field_username);
          paramString2 = g.fJ(str);
          if (paramString2 != null) {
            paramString2.field_username = paramString1;
          }
          ag.bah().delete(str);
          localas.BK(str);
        }
        localas.setUsername(paramString1);
        if ((int)localas.gMZ == 0)
        {
          bg.aVF();
          com.tencent.mm.model.c.aSN().aq(localas);
        }
        if ((int)localas.gMZ <= 0)
        {
          Log.e("MicroMsg.ContactWidgetNewBizInfo", "addContact : insert contact failed");
          break;
        }
        com.tencent.mm.model.ab.B(localas);
        bg.aVF();
        paramString1 = com.tencent.mm.model.c.aSN().Kn(localas.field_username);
        if (paramString2 != null)
        {
          ag.bah().g(paramString2);
          break;
        }
        paramString2 = g.fJ(paramString1.field_username);
        if ((paramString1.gBM()) && (a.aZz())) {}
        for (int i = 1;; i = 0)
        {
          if ((paramString2 != null) && ((!paramString2.Uz()) || (i != 0))) {
            break label608;
          }
          Log.d("MicroMsg.ContactWidgetNewBizInfo", "shouldUpdate");
          ay.a.iDq.aL(paramString1.field_username, "");
          com.tencent.mm.aj.c.Mf(paramString1.field_username);
          break;
        }
        if ((!paramString1.gBQ()) || (i != 0)) {
          break;
        }
        Log.d("MicroMsg.ContactWidgetNewBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramString1.fuP) });
        ay.a.iDq.aL(paramString1.field_username, "");
        com.tencent.mm.aj.c.Mf(paramString1.field_username);
        break;
        ag.bah().h(paramString1);
        break label240;
        paramString1 = new Intent();
        paramString1.putExtra("Chat_User", ContactWidgetNewBizInfo.e(this.Bjh).field_username);
        paramString1.putExtra("key_has_add_contact", true);
        paramString1.putExtra("finish_direct", true);
        if (paramBoolean2) {
          paramString1.addFlags(268435456);
        }
        com.tencent.mm.storage.ab.bja(ContactWidgetNewBizInfo.e(this.Bjh).field_username);
        b.jRt.d(paramString1, ContactWidgetNewBizInfo.b(this.Bjh));
        if (paramBoolean1) {
          break label355;
        }
      } while (!paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.10
 * JD-Core Version:    0.7.0.1
 */