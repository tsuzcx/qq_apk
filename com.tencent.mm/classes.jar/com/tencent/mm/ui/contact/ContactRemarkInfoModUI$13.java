package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.MMEditText;

final class ContactRemarkInfoModUI$13
  implements View.OnClickListener
{
  ContactRemarkInfoModUI$13(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void onClick(View paramView)
  {
    ContactRemarkInfoModUI.f(this.vKT);
    ContactRemarkInfoModUI.a(this.vKT, false, paramView.getId());
    ContactRemarkInfoModUI.h(this.vKT).performClick();
    ContactRemarkInfoModUI.h(this.vKT).requestFocus();
    this.vKT.showVKB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.13
 * JD-Core Version:    0.7.0.1
 */