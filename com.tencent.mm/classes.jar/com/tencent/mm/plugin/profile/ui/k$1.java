package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.h;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class k$1
  implements View.OnClickListener
{
  k$1(k paramk) {}
  
  public final void onClick(View paramView)
  {
    k localk = this.mXC;
    if (paramView.getId() == R.h.set_desc_and_label_tv) {
      h.nFQ.f(16055, new Object[] { Integer.valueOf(2), Integer.valueOf(b.S(localk.bMV.getIntent())) });
    }
    if (localk.dnp == null)
    {
      y.e("MicroMsg.ContactWidgetNormal", "contact is null");
      return;
    }
    if (!com.tencent.mm.n.a.gR(localk.dnp.field_type))
    {
      if (!bk.bl(localk.dnp.field_encryptUsername))
      {
        localk.KV(localk.dnp.field_encryptUsername);
        return;
      }
      localk.KV(localk.dnp.field_username);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Contact_Scene", localk.fhj);
    paramView.putExtra("Contact_User", localk.dnp.field_username);
    paramView.putExtra("Contact_RoomNickname", localk.bMV.getIntent().getStringExtra("Contact_RoomNickname"));
    paramView.putExtra("view_mode", true);
    paramView.putExtra("contact_phone_number_by_md5", localk.mXA);
    paramView.putExtra("contact_phone_number_list", localk.dnp.cCP);
    com.tencent.mm.plugin.profile.a.eUR.n(paramView, localk.bMV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.1
 * JD-Core Version:    0.7.0.1
 */