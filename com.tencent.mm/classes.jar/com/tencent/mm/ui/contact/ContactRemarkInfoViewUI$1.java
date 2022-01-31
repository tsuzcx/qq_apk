package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bb.c;

final class ContactRemarkInfoViewUI$1
  implements View.OnClickListener
{
  ContactRemarkInfoViewUI$1(ContactRemarkInfoViewUI paramContactRemarkInfoViewUI) {}
  
  public final void onClick(View paramView)
  {
    if (!ContactRemarkInfoViewUI.a(this.vKY)) {
      return;
    }
    paramView = new Intent(this.vKY, ContactRemarkImagePreviewUI.class);
    paramView.putExtra("Contact_User", ContactRemarkInfoViewUI.b(this.vKY));
    c.PO();
    paramView.putExtra("remark_image_path", c.mK(ContactRemarkInfoViewUI.b(this.vKY)));
    paramView.putExtra("view_only", true);
    this.vKY.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoViewUI.1
 * JD-Core Version:    0.7.0.1
 */