package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class ContactRemarkInfoModUI$13
  implements View.OnClickListener
{
  ContactRemarkInfoModUI$13(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33642);
    ContactRemarkInfoModUI.f(this.Acv);
    ContactRemarkInfoModUI.a(this.Acv, false, paramView.getId());
    ContactRemarkInfoModUI.h(this.Acv).performClick();
    ContactRemarkInfoModUI.h(this.Acv).requestFocus();
    this.Acv.showVKB();
    AppMethodBeat.o(33642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.13
 * JD-Core Version:    0.7.0.1
 */