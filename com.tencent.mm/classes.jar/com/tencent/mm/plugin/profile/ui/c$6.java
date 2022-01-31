package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.b;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.nn;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    ad localad;
    if (paramBoolean1)
    {
      h.bC(this.mWY.bER, this.mWY.bER.getString(R.l.contact_info_biz_add_ok));
      this.mWY.dnn.bJ("contact_info_time_expired", true);
      localad = this.mWY.dnp;
      if ((localad == null) || (bk.bl(paramString1)))
      {
        y.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + paramString1 + ", contact = " + localad);
        this.mWY.mWQ = true;
        if (this.mWY.mWW != null)
        {
          paramString1 = new nn();
          this.mWY.mWW.eAB = 4;
          paramString1.bXh.bXi = this.mWY.mWW;
          com.tencent.mm.sdk.b.a.udP.m(paramString1);
        }
        paramString1 = z.My().kQ(this.mWY.dnp.field_username);
        paramString1.field_status = 1;
        if ((!bk.bl(paramString1.field_extInfo)) || (bk.bl(paramString1.field_username)) || (this.mWY.mVy == null) || (!paramString1.field_username.equals(bk.pm(this.mWY.mVy.field_username)))) {
          break label663;
        }
        z.My().e(this.mWY.mVy);
        label243:
        paramBoolean1 = this.mWY.bER.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
        paramBoolean2 = this.mWY.bER.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
        if (!paramString1.Ly()) {
          break label674;
        }
        paramString1 = new Intent();
        paramString1.putExtra("enterprise_biz_name", this.mWY.dnp.field_username);
        paramString1.putExtra("enterprise_biz_display_name", r.gV(this.mWY.dnp.field_username));
        paramString1.putExtra("enterprise_from_scene", 7);
        paramString1.addFlags(67108864);
        com.tencent.mm.br.d.e(this.mWY.bER, ".ui.conversation.EnterpriseConversationUI", paramString1);
        label358:
        this.mWY.bER.finish();
        label368:
        this.mWY.az(3, null);
      }
    }
    else
    {
      return;
    }
    if (s.hj(localad.field_username))
    {
      String str = bk.pm(localad.field_username);
      paramString2 = com.tencent.mm.ai.f.kX(str);
      if (paramString2 != null) {
        paramString2.field_username = paramString1;
      }
      z.My().delete(str);
      localad.dq(str);
    }
    for (;;)
    {
      localad.setUsername(paramString1);
      if ((int)localad.dBe == 0)
      {
        au.Hx();
        com.tencent.mm.model.c.Fw().W(localad);
      }
      if ((int)localad.dBe <= 0)
      {
        y.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
        break;
      }
      s.q(localad);
      au.Hx();
      paramString1 = com.tencent.mm.model.c.Fw().abl(localad.field_username);
      if (paramString2 != null)
      {
        z.My().d(paramString2);
        break;
      }
      paramString2 = com.tencent.mm.ai.f.kX(paramString1.field_username);
      if ((paramString1.cua()) && (com.tencent.mm.ai.a.Lp())) {}
      for (int i = 1;; i = 0)
      {
        if ((paramString2 != null) && ((!paramString2.Ls()) || (i != 0))) {
          break label604;
        }
        y.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
        am.a.dVy.V(paramString1.field_username, "");
        b.ka(paramString1.field_username);
        break;
      }
      label604:
      if ((!paramString1.cud()) || (i != 0)) {
        break;
      }
      y.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramString1.cCH) });
      am.a.dVy.V(paramString1.field_username, "");
      b.ka(paramString1.field_username);
      break;
      label663:
      z.My().e(paramString1);
      break label243;
      label674:
      paramString1 = new Intent();
      paramString1.putExtra("Chat_User", this.mWY.dnp.field_username);
      paramString1.putExtra("key_has_add_contact", true);
      paramString1.putExtra("finish_direct", true);
      if (paramBoolean2) {
        paramString1.addFlags(268435456);
      }
      com.tencent.mm.plugin.profile.a.eUR.e(paramString1, this.mWY.bER);
      if (paramBoolean1) {
        break label358;
      }
      if (!paramBoolean2) {
        break label368;
      }
      break label358;
      paramString2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.6
 * JD-Core Version:    0.7.0.1
 */