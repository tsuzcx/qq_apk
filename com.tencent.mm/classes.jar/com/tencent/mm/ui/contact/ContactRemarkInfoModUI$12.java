package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMClearEditText;

final class ContactRemarkInfoModUI$12
  implements View.OnClickListener
{
  ContactRemarkInfoModUI$12(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33641);
    ContactRemarkInfoModUI.f(this.Acv);
    ContactRemarkInfoModUI.a(this.Acv, false, paramView.getId());
    ContactRemarkInfoModUI.g(this.Acv).performClick();
    ContactRemarkInfoModUI.g(this.Acv).requestFocus();
    this.Acv.showVKB();
    AppMethodBeat.o(33641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.12
 * JD-Core Version:    0.7.0.1
 */