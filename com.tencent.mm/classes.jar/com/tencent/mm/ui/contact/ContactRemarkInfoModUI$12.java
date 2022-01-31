package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.MMClearEditText;

final class ContactRemarkInfoModUI$12
  implements View.OnClickListener
{
  ContactRemarkInfoModUI$12(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void onClick(View paramView)
  {
    ContactRemarkInfoModUI.f(this.vKT);
    ContactRemarkInfoModUI.a(this.vKT, false, paramView.getId());
    ContactRemarkInfoModUI.g(this.vKT).performClick();
    ContactRemarkInfoModUI.g(this.vKT).requestFocus();
    this.vKT.showVKB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.12
 * JD-Core Version:    0.7.0.1
 */