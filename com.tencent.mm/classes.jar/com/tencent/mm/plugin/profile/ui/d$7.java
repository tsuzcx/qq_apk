package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.a;
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.a.ug;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

final class d$7
  implements a.a
{
  d$7(d paramd) {}
  
  public final void canAddContact(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(305634);
    au localau;
    if (paramBoolean1)
    {
      k.cZ(d.g(this.MXk), d.g(this.MXk).getString(R.l.gAH));
      d.l(this.MXk).eh("contact_info_time_expired", true);
      localau = d.e(this.MXk);
      if ((localau != null) && (!Util.isNullOrNil(paramString1))) {
        break label389;
      }
      Log.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + paramString1 + ", contact = " + localau);
      d.m(this.MXk);
      if (d.n(this.MXk) != null)
      {
        paramString1 = new ug();
        d.n(this.MXk).oTP = 4;
        paramString1.hXY.hXZ = d.n(this.MXk);
        paramString1.publish();
      }
      paramString1 = af.bHf().Mn(d.e(this.MXk).field_username);
      if (paramString1 != null)
      {
        paramString1.field_status = 1;
        if ((!Util.isNullOrNil(paramString1.field_extInfo)) || (Util.isNullOrNil(paramString1.field_username)) || (d.d(this.MXk) == null) || (!paramString1.field_username.equals(Util.nullAsNil(d.d(this.MXk).field_username)))) {
          break label677;
        }
        af.bHf().h(d.d(this.MXk));
        label250:
        paramBoolean1 = d.g(this.MXk).getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
        paramBoolean2 = d.g(this.MXk).getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
        if (!paramString1.aAP()) {
          break label688;
        }
        paramString1 = new Intent();
        paramString1.putExtra("enterprise_biz_name", d.e(this.MXk).field_username);
        paramString1.putExtra("enterprise_biz_display_name", aa.getDisplayName(d.e(this.MXk).field_username));
        paramString1.putExtra("enterprise_from_scene", 7);
        paramString1.addFlags(67108864);
        com.tencent.mm.br.c.g(d.g(this.MXk), ".ui.conversation.EnterpriseConversationUI", paramString1);
      }
    }
    label389:
    label677:
    label688:
    for (;;)
    {
      label365:
      d.g(this.MXk).finish();
      label618:
      do
      {
        d.a(this.MXk, 3);
        AppMethodBeat.o(305634);
        return;
        paramString2 = null;
        if (au.bxa(localau.field_username))
        {
          String str = Util.nullAsNil(localau.field_username);
          paramString2 = g.hU(str);
          if (paramString2 != null) {
            paramString2.field_username = paramString1;
          }
          af.bHf().Mo(str);
          localau.Bd(str);
        }
        localau.setUsername(paramString1);
        if ((int)localau.maN == 0)
        {
          bh.bCz();
          com.tencent.mm.model.c.bzA().aC(localau);
        }
        if ((int)localau.maN <= 0)
        {
          Log.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
          break;
        }
        ab.I(localau);
        bh.bCz();
        paramString1 = com.tencent.mm.model.c.bzA().JE(localau.field_username);
        if (paramString2 != null)
        {
          af.bHf().g(paramString2);
          break;
        }
        paramString2 = g.hU(paramString1.field_username);
        if ((paramString1.iZC()) && (a.bGz())) {}
        for (int i = 1;; i = 0)
        {
          if ((paramString2 != null) && ((!paramString2.aAJ()) || (i != 0))) {
            break label618;
          }
          Log.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
          az.a.okP.aZ(paramString1.field_username, "");
          com.tencent.mm.modelavatar.d.LA(paramString1.field_username);
          break;
        }
        if ((!paramString1.iZI()) || (i != 0)) {
          break;
        }
        Log.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramString1.kak) });
        az.a.okP.aZ(paramString1.field_username, "");
        com.tencent.mm.modelavatar.d.LA(paramString1.field_username);
        break;
        af.bHf().h(paramString1);
        break label250;
        paramString1 = new Intent();
        paramString1.putExtra("Chat_User", d.e(this.MXk).field_username);
        paramString1.putExtra("key_has_add_contact", true);
        paramString1.putExtra("finish_direct", true);
        if (paramBoolean2) {
          paramString1.addFlags(268435456);
        }
        b.pFn.d(paramString1, d.g(this.MXk));
        if (paramBoolean1) {
          break label365;
        }
      } while (!paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.d.7
 * JD-Core Version:    0.7.0.1
 */