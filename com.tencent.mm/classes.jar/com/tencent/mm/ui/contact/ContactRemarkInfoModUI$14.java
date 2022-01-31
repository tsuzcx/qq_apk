package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.c;
import com.tencent.mm.platformtools.ah;

final class ContactRemarkInfoModUI$14
  implements View.OnClickListener
{
  ContactRemarkInfoModUI$14(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153957);
    if (!ContactRemarkInfoModUI.i(this.Acv))
    {
      AppMethodBeat.o(153957);
      return;
    }
    ContactRemarkInfoModUI.j(this.Acv);
    Intent localIntent = new Intent(this.Acv, ContactRemarkImagePreviewUI.class);
    localIntent.putExtra("Contact_User", ContactRemarkInfoModUI.k(this.Acv));
    if ((!ah.isNullOrNil(ContactRemarkInfoModUI.l(this.Acv))) && (!ContactRemarkInfoModUI.m(this.Acv))) {
      c.aiT();
    }
    for (paramView = c.tU(ContactRemarkInfoModUI.k(this.Acv));; paramView = ContactRemarkInfoModUI.n(this.Acv))
    {
      localIntent.putExtra("remark_image_path", paramView);
      localIntent.putExtra("view_temp_remark_image", ContactRemarkInfoModUI.m(this.Acv));
      this.Acv.startActivityForResult(localIntent, 400);
      AppMethodBeat.o(153957);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.14
 * JD-Core Version:    0.7.0.1
 */