package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.mz;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

final class ShakeReportUI$16
  implements View.OnClickListener
{
  public long PBZ = 0L;
  
  ShakeReportUI$16(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(273563);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeReportUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    if (Util.isNullOrNil((String)ShakeReportUI.h(this.PEm).getTag()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273563);
      return;
    }
    if (ShakeReportUI.H(this.PEm) == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273563);
      return;
    }
    paramView = ShakeReportUI.H(this.PEm);
    localObject1 = paramView.field_username;
    bh.bCz();
    Object localObject2 = c.bzA().JE((String)localObject1);
    if (com.tencent.mm.contact.d.rs(((az)localObject2).field_type))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", (String)localObject1);
      localIntent.putExtra("Sns_from_Scene", 22);
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        if (((au)localObject2).iZC())
        {
          h.OAn.kvStat(10298, (String)localObject1 + "," + ShakeReportUI.I(this.PEm));
          localIntent.putExtra("Contact_Scene", ShakeReportUI.I(this.PEm));
        }
        localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 31);
        localIntent.putExtra("CONTACT_INFO_UI_SUB_SOURCE", 3102);
        com.tencent.mm.plugin.shake.b.pFn.c(localIntent, this.PEm);
      }
      localObject1 = new mz();
      localObject2 = ((mz)localObject1).vv(paramView.field_username);
      ((mz)localObject2).jcH = ShakeReportUI.H(this.PEm).field_sex;
      if (!Util.isNullOrNil(paramView.field_signature)) {
        break label648;
      }
    }
    label648:
    for (long l = 1L;; l = 2L)
    {
      ((mz)localObject2).jcJ = l;
      ((mz)localObject2).vw(paramView.field_distance);
      ((mz)localObject1).jcG = 1L;
      paramView = com.tencent.mm.plugin.shake.a.PyM;
      com.tencent.mm.plugin.shake.a.a(4, (mz)localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273563);
      return;
      if ((paramView.field_reserved1 & 0x8) > 0) {
        h.OAn.kvStat(10298, paramView.field_username + "," + ShakeReportUI.I(this.PEm));
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
      ((Intent)localObject1).putExtra("Contact_Scene", ShakeReportUI.I(this.PEm));
      ((Intent)localObject1).putExtra("Sns_from_Scene", 22);
      ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", 31);
      ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SUB_SOURCE", 3102);
      com.tencent.mm.plugin.shake.b.pFn.c((Intent)localObject1, this.PEm);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.16
 * JD-Core Version:    0.7.0.1
 */