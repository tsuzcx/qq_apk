package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bb.c;
import com.tencent.mm.platformtools.ah;

final class ContactRemarkInfoModUI$16
  implements View.OnClickListener
{
  ContactRemarkInfoModUI$16(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void onClick(View paramView)
  {
    if (!ContactRemarkInfoModUI.j(this.vKT)) {
      return;
    }
    ContactRemarkInfoModUI.k(this.vKT);
    Intent localIntent = new Intent(this.vKT, ContactRemarkImagePreviewUI.class);
    localIntent.putExtra("Contact_User", ContactRemarkInfoModUI.l(this.vKT));
    if ((!ah.bl(ContactRemarkInfoModUI.m(this.vKT))) && (!ContactRemarkInfoModUI.n(this.vKT))) {
      c.PO();
    }
    for (paramView = c.mK(ContactRemarkInfoModUI.l(this.vKT));; paramView = ContactRemarkInfoModUI.o(this.vKT))
    {
      localIntent.putExtra("remark_image_path", paramView);
      localIntent.putExtra("view_temp_remark_image", ContactRemarkInfoModUI.n(this.vKT));
      this.vKT.startActivityForResult(localIntent, 400);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.16
 * JD-Core Version:    0.7.0.1
 */