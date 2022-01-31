package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.nn;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;

final class b$7
  implements a.a
{
  b$7(b paramb) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    ad localad;
    if (paramBoolean1)
    {
      h.bC(this.mZA.mZy, this.mZA.mZy.getString(R.l.contact_info_biz_new_add_ok));
      this.mZA.dnn.bJ("contact_info_time_expired", true);
      localad = this.mZA.dnp;
      if ((localad != null) && (!bk.bl(paramString1))) {
        break label369;
      }
      y.e("MicroMsg.ContactWidgetNewBizInfo", "respUsername == " + paramString1 + ", contact = " + localad);
      if (this.mZA.mWW != null)
      {
        paramString1 = new nn();
        this.mZA.mWW.eAB = 4;
        paramString1.bXh.bXi = this.mZA.mWW;
        com.tencent.mm.sdk.b.a.udP.m(paramString1);
      }
      paramString1 = z.My().kQ(this.mZA.dnp.field_username);
      paramString1.field_status = 1;
      if ((!bk.bl(paramString1.field_extInfo)) || (bk.bl(paramString1.field_username)) || (this.mZA.mVy == null) || (!paramString1.field_username.equals(bk.pm(this.mZA.mVy.field_username)))) {
        break label657;
      }
      z.My().e(this.mZA.mVy);
      label235:
      paramBoolean1 = this.mZA.mZy.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
      paramBoolean2 = this.mZA.mZy.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
      if (!paramString1.Ly()) {
        break label668;
      }
      paramString1 = new Intent();
      paramString1.putExtra("enterprise_biz_name", this.mZA.dnp.field_username);
      paramString1.putExtra("enterprise_biz_display_name", r.gV(this.mZA.dnp.field_username));
      paramString1.putExtra("enterprise_from_scene", 7);
      paramString1.addFlags(67108864);
      com.tencent.mm.br.d.e(this.mZA.mZy, ".ui.conversation.EnterpriseConversationUI", paramString1);
    }
    label598:
    for (;;)
    {
      label350:
      this.mZA.mZy.finish();
      label369:
      do
      {
        this.mZA.wf(3);
        return;
        paramString2 = null;
        if (com.tencent.mm.model.s.hj(localad.field_username))
        {
          String str = bk.pm(localad.field_username);
          paramString2 = com.tencent.mm.ai.f.kX(str);
          if (paramString2 != null) {
            paramString2.field_username = paramString1;
          }
          z.My().delete(str);
          localad.dq(str);
        }
        localad.setUsername(paramString1);
        if ((int)localad.dBe == 0)
        {
          au.Hx();
          c.Fw().W(localad);
        }
        if ((int)localad.dBe <= 0)
        {
          y.e("MicroMsg.ContactWidgetNewBizInfo", "addContact : insert contact failed");
          break;
        }
        com.tencent.mm.model.s.q(localad);
        au.Hx();
        paramString1 = c.Fw().abl(localad.field_username);
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
            break label598;
          }
          y.d("MicroMsg.ContactWidgetNewBizInfo", "shouldUpdate");
          am.a.dVy.V(paramString1.field_username, "");
          com.tencent.mm.ag.b.ka(paramString1.field_username);
          break;
        }
        if ((!paramString1.cud()) || (i != 0)) {
          break;
        }
        y.d("MicroMsg.ContactWidgetNewBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramString1.cCH) });
        am.a.dVy.V(paramString1.field_username, "");
        com.tencent.mm.ag.b.ka(paramString1.field_username);
        break;
        z.My().e(paramString1);
        break label235;
        paramString1 = new Intent();
        paramString1.putExtra("Chat_User", this.mZA.dnp.field_username);
        paramString1.putExtra("key_has_add_contact", true);
        paramString1.putExtra("finish_direct", true);
        if (paramBoolean2) {
          paramString1.addFlags(268435456);
        }
        com.tencent.mm.storage.s.aaK(this.mZA.dnp.field_username);
        com.tencent.mm.plugin.profile.a.eUR.e(paramString1, this.mZA.mZy);
        if (paramBoolean1) {
          break label350;
        }
      } while (!paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.7
 * JD-Core Version:    0.7.0.1
 */