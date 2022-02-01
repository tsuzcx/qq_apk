package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class c$6
  implements a.a
{
  c$6(c paramc) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(27077);
    as localas;
    if (paramBoolean1)
    {
      h.cD(c.f(this.Bfj), c.f(this.Bfj).getString(2131757817));
      c.l(this.Bfj).jdMethod_do("contact_info_time_expired", true);
      localas = c.d(this.Bfj);
      if ((localas != null) && (!Util.isNullOrNil(paramString1))) {
        break label389;
      }
      Log.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + paramString1 + ", contact = " + localas);
      c.m(this.Bfj);
      if (c.n(this.Bfj) != null)
      {
        paramString1 = new rr();
        c.n(this.Bfj).jkU = 4;
        paramString1.dYk.dYl = c.n(this.Bfj);
        EventCenter.instance.publish(paramString1);
      }
      paramString1 = ag.bah().MT(c.d(this.Bfj).field_username);
      paramString1.field_status = 1;
      if ((!Util.isNullOrNil(paramString1.field_extInfo)) || (Util.isNullOrNil(paramString1.field_username)) || (c.c(this.Bfj) == null) || (!paramString1.field_username.equals(Util.nullAsNil(c.c(this.Bfj).field_username)))) {
        break label677;
      }
      ag.bah().h(c.c(this.Bfj));
      label249:
      paramBoolean1 = c.f(this.Bfj).getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
      paramBoolean2 = c.f(this.Bfj).getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
      if (!paramString1.UF()) {
        break label688;
      }
      paramString1 = new Intent();
      paramString1.putExtra("enterprise_biz_name", c.d(this.Bfj).field_username);
      paramString1.putExtra("enterprise_biz_display_name", aa.getDisplayName(c.d(this.Bfj).field_username));
      paramString1.putExtra("enterprise_from_scene", 7);
      paramString1.addFlags(67108864);
      com.tencent.mm.br.c.f(c.f(this.Bfj), ".ui.conversation.EnterpriseConversationUI", paramString1);
    }
    label389:
    label677:
    label688:
    for (;;)
    {
      label364:
      c.f(this.Bfj).finish();
      label618:
      do
      {
        c.a(this.Bfj, 3);
        AppMethodBeat.o(27077);
        return;
        paramString2 = null;
        if (ab.IR(localas.field_username))
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
          Log.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
          break;
        }
        ab.B(localas);
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
            break label618;
          }
          Log.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
          ay.a.iDq.aL(paramString1.field_username, "");
          com.tencent.mm.aj.c.Mf(paramString1.field_username);
          break;
        }
        if ((!paramString1.gBQ()) || (i != 0)) {
          break;
        }
        Log.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramString1.fuP) });
        ay.a.iDq.aL(paramString1.field_username, "");
        com.tencent.mm.aj.c.Mf(paramString1.field_username);
        break;
        ag.bah().h(paramString1);
        break label249;
        paramString1 = new Intent();
        paramString1.putExtra("Chat_User", c.d(this.Bfj).field_username);
        paramString1.putExtra("key_has_add_contact", true);
        paramString1.putExtra("finish_direct", true);
        if (paramBoolean2) {
          paramString1.addFlags(268435456);
        }
        b.jRt.d(paramString1, c.f(this.Bfj));
        if (paramBoolean1) {
          break label364;
        }
      } while (!paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.6
 * JD-Core Version:    0.7.0.1
 */