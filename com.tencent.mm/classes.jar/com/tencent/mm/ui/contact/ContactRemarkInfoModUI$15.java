package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.R.g;

final class ContactRemarkInfoModUI$15
  implements View.OnFocusChangeListener
{
  ContactRemarkInfoModUI$15(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ContactRemarkInfoModUI.i(this.vKT).setBackgroundResource(R.g.input_bar_bg_normal);
      return;
    }
    ContactRemarkInfoModUI.i(this.vKT).setBackgroundResource(R.g.input_bar_bg_active);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.15
 * JD-Core Version:    0.7.0.1
 */