package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class ShakeReportUI$18
  implements View.OnClickListener
{
  public long qPI = 0L;
  
  ShakeReportUI$18(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24796);
    if (bo.isNullOrNil((String)ShakeReportUI.r(this.qRs).getTag()))
    {
      AppMethodBeat.o(24796);
      return;
    }
    if (ShakeReportUI.N(this.qRs) == null)
    {
      AppMethodBeat.o(24796);
      return;
    }
    paramView = ShakeReportUI.N(this.qRs);
    Object localObject1 = paramView.field_username;
    if (11 == paramView.field_type)
    {
      if (System.currentTimeMillis() - this.qPI > 3000L)
      {
        this.qPI = System.currentTimeMillis();
        if ((paramView.field_reserved3 == null) || (paramView.field_reserved3.split(",").length != 3) || (paramView.field_reserved3.split(",")[0] == null) || (paramView.field_reserved3.split(",")[0].equals(""))) {
          break label259;
        }
        localObject1 = paramView.field_reserved3.split(",");
        localObject2 = new so();
        ((so)localObject2).cIQ.userName = localObject1[0];
        ((so)localObject2).cIQ.cIS = bo.bf(localObject1[1], "");
        ((so)localObject2).cIQ.cIT = bo.getInt(localObject1[2], 0);
        ((so)localObject2).cIQ.scene = 1077;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
      }
      for (;;)
      {
        localObject1 = ShakeReportUI.E(this.qRs).qNd;
        if ((localObject1 != null) && ((localObject1 instanceof com.tencent.mm.plugin.shake.d.a.h)))
        {
          com.tencent.mm.plugin.shake.d.a.h.a(paramView);
          com.tencent.mm.plugin.shake.d.a.h.b(paramView);
        }
        AppMethodBeat.o(24796);
        return;
        label259:
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView.getCity());
        ((Intent)localObject1).putExtra("scene", 27);
        ((Intent)localObject1).putExtra("stastic_scene", 5);
        com.tencent.mm.bq.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
    }
    aw.aaz();
    Object localObject2 = c.YA().arw((String)localObject1);
    if (com.tencent.mm.n.a.je(((aq)localObject2).field_type))
    {
      paramView = new Intent();
      paramView.putExtra("Contact_User", (String)localObject1);
      paramView.putExtra("Sns_from_Scene", 22);
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        if (((ad)localObject2).dwz())
        {
          com.tencent.mm.plugin.report.service.h.qsU.kvStat(10298, (String)localObject1 + "," + ShakeReportUI.O(this.qRs));
          paramView.putExtra("Contact_Scene", ShakeReportUI.O(this.qRs));
        }
        com.tencent.mm.plugin.shake.a.gmO.c(paramView, this.qRs);
      }
      AppMethodBeat.o(24796);
      return;
    }
    if ((paramView.field_reserved1 & 0x8) > 0) {
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10298, paramView.field_username + "," + ShakeReportUI.O(this.qRs));
    }
    localObject1 = new Intent();
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
    ((Intent)localObject1).putExtra("Contact_Scene", ShakeReportUI.O(this.qRs));
    ((Intent)localObject1).putExtra("Sns_from_Scene", 22);
    com.tencent.mm.plugin.shake.a.gmO.c((Intent)localObject1, this.qRs);
    AppMethodBeat.o(24796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.18
 * JD-Core Version:    0.7.0.1
 */