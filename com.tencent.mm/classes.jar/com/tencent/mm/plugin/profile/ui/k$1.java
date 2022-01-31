package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

final class k$1
  implements View.OnClickListener
{
  k$1(k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23566);
    k localk = this.pAx;
    if (paramView.getId() == 2131823128) {
      h.qsU.e(16055, new Object[] { Integer.valueOf(c.al(localk.cmc.getIntent())), Integer.valueOf(2), Integer.valueOf(1), localk.contact.field_username });
    }
    if (localk.contact == null)
    {
      ab.e("MicroMsg.ContactWidgetNormal", "contact is null");
      AppMethodBeat.o(23566);
      return;
    }
    if (!a.je(localk.contact.field_type))
    {
      if (!bo.isNullOrNil(localk.contact.field_encryptUsername))
      {
        localk.Xf(localk.contact.field_encryptUsername);
        AppMethodBeat.o(23566);
        return;
      }
      localk.Xf(localk.contact.field_username);
      AppMethodBeat.o(23566);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Contact_Scene", localk.gyR);
    paramView.putExtra("Contact_User", localk.contact.field_username);
    paramView.putExtra("Contact_RoomNickname", localk.cmc.getIntent().getStringExtra("Contact_RoomNickname"));
    paramView.putExtra("view_mode", true);
    paramView.putExtra("contact_phone_number_by_md5", localk.pAv);
    paramView.putExtra("contact_phone_number_list", localk.contact.dqZ);
    b.gmO.m(paramView, localk.cmc);
    AppMethodBeat.o(23566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.1
 * JD-Core Version:    0.7.0.1
 */