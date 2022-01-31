package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class ShakeReportUI$18
  implements View.OnClickListener
{
  public long obB = 0L;
  
  ShakeReportUI$18(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(View paramView)
  {
    if (bk.bl((String)ShakeReportUI.p(this.odm).getTag())) {}
    label19:
    Object localObject2;
    do
    {
      do
      {
        break label19;
        do
        {
          return;
        } while (ShakeReportUI.L(this.odm) == null);
        paramView = ShakeReportUI.L(this.odm);
        localObject1 = paramView.field_username;
        if (11 != paramView.field_type) {
          break;
        }
      } while (System.currentTimeMillis() - this.obB <= 3000L);
      this.obB = System.currentTimeMillis();
      if ((paramView.field_reserved3 != null) && (paramView.field_reserved3.split(",").length == 3) && (paramView.field_reserved3.split(",")[0] != null) && (!paramView.field_reserved3.split(",")[0].equals("")))
      {
        localObject1 = paramView.field_reserved3.split(",");
        localObject2 = new rc();
        ((rc)localObject2).caq.userName = localObject1[0];
        ((rc)localObject2).caq.cas = bk.aM(localObject1[1], "");
        ((rc)localObject2).caq.cat = bk.getInt(localObject1[2], 0);
        ((rc)localObject2).caq.scene = 1077;
        com.tencent.mm.sdk.b.a.udP.m((b)localObject2);
      }
      for (;;)
      {
        localObject1 = ShakeReportUI.C(this.odm).nYT;
        if ((localObject1 == null) || (!(localObject1 instanceof com.tencent.mm.plugin.shake.d.a.h))) {
          break;
        }
        com.tencent.mm.plugin.shake.d.a.h.a(paramView);
        com.tencent.mm.plugin.shake.d.a.h.b(paramView);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView.getCity());
        ((Intent)localObject1).putExtra("scene", 27);
        ((Intent)localObject1).putExtra("stastic_scene", 5);
        com.tencent.mm.br.d.b(ae.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      au.Hx();
      localObject2 = c.Fw().abl((String)localObject1);
      if (!com.tencent.mm.n.a.gR(((ao)localObject2).field_type)) {
        break;
      }
      paramView = new Intent();
      paramView.putExtra("Contact_User", (String)localObject1);
      paramView.putExtra("Sns_from_Scene", 22);
    } while ((localObject1 == null) || (((String)localObject1).length() <= 0));
    if (((ad)localObject2).cua())
    {
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10298, (String)localObject1 + "," + ShakeReportUI.M(this.odm));
      paramView.putExtra("Contact_Scene", ShakeReportUI.M(this.odm));
    }
    com.tencent.mm.plugin.shake.a.eUR.d(paramView, this.odm);
    return;
    if ((paramView.field_reserved1 & 0x8) > 0) {
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10298, paramView.field_username + "," + ShakeReportUI.M(this.odm));
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("Contact_User", paramView.field_username);
    ((Intent)localObject1).putExtra("Contact_Nick", paramView.field_nickname);
    ((Intent)localObject1).putExtra("Contact_Distance", paramView.field_distance);
    ((Intent)localObject1).putExtra("Contact_Signature", paramView.field_signature);
    ((Intent)localObject1).putExtra("Contact_Province", paramView.getProvince());
    ((Intent)localObject1).putExtra("Contact_City", paramView.getCity());
    ((Intent)localObject1).putExtra("Contact_Sex", paramView.field_sex);
    ((Intent)localObject1).putExtra("Contact_IsLBSFriend", true);
    ((Intent)localObject1).putExtra("Contact_VUser_Info", paramView.field_reserved3);
    ((Intent)localObject1).putExtra("Contact_VUser_Info_Flag", paramView.field_reserved1);
    ((Intent)localObject1).putExtra("Contact_KSnsIFlag", paramView.field_snsFlag);
    ((Intent)localObject1).putExtra("Contact_KSnsBgUrl", paramView.field_sns_bgurl);
    ((Intent)localObject1).putExtra("Contact_Scene", ShakeReportUI.M(this.odm));
    ((Intent)localObject1).putExtra("Sns_from_Scene", 22);
    com.tencent.mm.plugin.shake.a.eUR.d((Intent)localObject1, this.odm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.18
 * JD-Core Version:    0.7.0.1
 */